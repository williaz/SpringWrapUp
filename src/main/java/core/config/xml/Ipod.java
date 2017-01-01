package core.config.xml;
import core.config.Cd;

/**
 * Created by williaz on 12/31/16.
 */
public class Ipod {
    private Cd cd;
    public void start() {
        cd.play();
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }
}
