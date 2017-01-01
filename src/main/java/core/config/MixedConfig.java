package core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

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
//TODO revise
public class MixedConfig {

    @Autowired
    @Qualifier("ThisLove")
    private ThisLove thisLove;

    @Autowired
    @Qualifier("she")
    private SheWillBeLoved she;

//    @Autowired
//    @Qualifier("sugar")
//    private Sugar sugar;

    @Bean("favorites")
    public PlayList getMyFavorites() {
        PlayList list = new PlayList();
        list.addSong(thisLove);
        list.addSong(she);
       // list.addSong(sugar);
        return list;
    }
}
