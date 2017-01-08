package core.config.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Collections;

import core.config.Cd;

/**
 * Created by williaz on 12/31/16.
 */
@Configuration
public class PlayerConfig {
    @Bean
    @Qualifier("she")
    public SheWillBeLoved sheWillBeLoved() {
        SheWillBeLoved cd = new SheWillBeLoved();
        cd.setName("She will be loved");
        cd.setLength(3.41);
        return cd;
    }

    @Bean("ipod")
    public CdPlayer1 getIpod(@Qualifier("she") Cd she) {
        CdPlayer1 ipod = new CdPlayer1();
        ipod.setSong(she);
        return ipod;
    }
}
