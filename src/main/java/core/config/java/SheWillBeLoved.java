package core.config.java;

import core.config.Cd;

/**
 * Created by williaz on 12/31/16.
 */
public class SheWillBeLoved implements Cd {
    private String name;
    private double length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Now playing " + name + " for  " + length + "s");
    }
}
