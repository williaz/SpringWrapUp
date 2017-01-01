package core.config.java;

import core.config.Cd;

/**
 * Created by williaz on 12/31/16.
 */
public class CdPlayer1 {
    private Cd song;

    public Cd getSong() {
        return song;
    }

    public void setSong(Cd song) {
        this.song = song;
    }

    public void start() {
        song.play();
    }
}
