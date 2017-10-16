package ro.mihai.pocjava.domain.models;

/**
 * Created by mihai on 16.10.2017.
 */

public class Geometry {
    private Location location;

    public Location getLocation() {
        return location;
    }

    public Geometry setLocation(Location location) {
        this.location = location;
        return this;
    }
}
