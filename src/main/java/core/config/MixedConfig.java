package core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.annotation.Resource;

import core.config.auto.CdPlayerConfig;
import core.config.auto.ThisLove;
import core.config.java.PlayerConfig;
import core.config.java.SheWillBeLoved;
import core.config.xml.Sugar;

/**
 * Created by williaz on 12/31/16.
 */
@Configuration
@Import({CdPlayerConfig.class, PlayerConfig.class})
@ImportResource("file:src/main/java/core/config/xml/xmlConfig.xml")
@ComponentScan
//TODO revise
public class MixedConfig {

    @Autowired
    @Qualifier("ThisLove")
    private ThisLove thisLove;

    @Autowired
    @Qualifier("she")
    private SheWillBeLoved she;

    //@Autowired
    //@Qualifier(value = "sugar")
    //private Sugar sugar;

    @Bean("favorites")
    public PlayList getMyFavorites() {
        PlayList list = new PlayList();
        list.addSong(thisLove);
        list.addSong(she);
       // list.addSong(sugar);
        return list;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CdPlayerConfig.class);
        Cd cd1 = context.getBean("ThisLove", ThisLove.class);
        cd1.play();
        ApplicationContext context1 = new AnnotationConfigApplicationContext(PlayerConfig.class);
        Cd cd2 = context1.getBean("sheWillBeLoved", SheWillBeLoved.class);
        cd2.play();
        ApplicationContext context2 = new FileSystemXmlApplicationContext("file:src/main/java/core/config/xml/xmlConfig.xml");
        Cd cd3 = context2.getBean("sugar", Sugar.class);
        cd3.play();

    }
}
