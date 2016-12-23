package core.config.auto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by williaz on 12/22/16.
 */
@Component
public class Cd {
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
}
