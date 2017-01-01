package core.config.auto;

import core.config.Cd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by williaz on 12/22/16.
 */
@Component("Ipod")
public class CdPlayer {
    @Autowired
    @Qualifier("ThisLove")
    private Cd cd;

    public void play() {
        System.out.println(cd);
    }
}
