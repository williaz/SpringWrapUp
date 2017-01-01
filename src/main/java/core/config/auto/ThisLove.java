package core.config.auto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import core.config.Cd;

/**
 * Created by williaz on 12/22/16.
 */
@Component("ThisLove")
public class ThisLove implements Cd {
    @Value("This Love")
    private String name;
    @Value("Maroon 5")
    private String artiest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtiest() {
        return artiest;
    }

    public void setArtiest(String artiest) {
        this.artiest = artiest;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "name='" + name + '\'' +
                ", artiest='" + artiest + '\'' +
                '}';
    }

    @Override
    public void play() {
        System.out.println(this);
    }
}
