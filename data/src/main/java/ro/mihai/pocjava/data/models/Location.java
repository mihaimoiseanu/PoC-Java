package ro.mihai.pocjava.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mihai on 17.10.2017.
 */

public class Location {

    @SerializedName("lat")
    @Expose
    private Double latitude;
    @SerializedName("lng")
    @Expose
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public Location setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Location setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
}
