package core.config.xml;
import core.config.Cd;
/**
 * Created by williaz on 12/31/16.
 */
public class Sugar implements Cd {
    private String artist;
    private double length;

    public Sugar(String artist) {
        this.artist = artist;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println(artist + " is playing  for " + length + "s");
    }
}
