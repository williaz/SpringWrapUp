package core.config;

import java.util.List;

/**
 * Created by williaz on 12/31/16.
 */
public class PlayList {
    private List<Cd> songs;
    public void start() {
        for (Cd song: songs) {
            song.play();
        }
    }
    public void addSong(Cd cd) {
        songs.add(cd);
    }
}
