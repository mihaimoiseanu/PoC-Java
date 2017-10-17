package ro.mihai.pocjava.domain.interactor.places;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mihai on 17.10.2017.
 * This class represents the params used for getting a place
 */

public class PlacesParams {

    private Map<String, Object> params;

    private PlacesParams(String key, String location, int radius) {
        params = new HashMap<>();
        params.put("key", key);
        params.put("location", location);
        params.put("radius", radius);
    }

    public static class Builder {
        private String key;
        private String location;
        private int radius;

        public Builder(String key, String location, int radius) {
            this.key = key;
            this.location = location;
            this.radius = radius;
        }

        public PlacesParams build() {
            return new PlacesParams(key, location, radius);
        }
    }

    public Map<String, Object> getParams() {
        return params;
    }
}