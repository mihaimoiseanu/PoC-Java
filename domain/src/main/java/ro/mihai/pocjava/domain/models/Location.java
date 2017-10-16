package ro.mihai.pocjava.domain.models;

/**
 * Created by mihai on 16.10.2017.
 */

public class Location {

    private Double lat;
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public Location setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLng() {
        return lng;
    }

    public Location setLng(Double lng) {
        this.lng = lng;
        return this;
    }
}
