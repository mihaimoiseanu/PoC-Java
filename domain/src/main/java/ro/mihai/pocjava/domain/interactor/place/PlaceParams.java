package ro.mihai.pocjava.domain.interactor.place;

import java.util.Map;

import ro.mihai.pocjava.domain.interactor.places.PlacesParams;

/**
 * Created by mihai on 17.10.2017.
 */

public class PlaceParams {

    private Map<String, Object> params;

    private PlaceParams(String key, String placeId) {
        params.put("key", key);
        params.put("placeId", placeId);
    }

    public class Builder {
        private String key;
        private String placeId;
        private int radius;

        public Builder(String key, String placeId) {
            this.key = key;
            this.placeId = placeId;
        }

        public PlaceParams build() {
            return new PlaceParams(key, placeId);
        }
    }

    public Map<String,Object> getParams(){
        return params;
    }
}
