package ro.mihai.pocjava.data.models;

import java.util.List;

/**
 * Created by mihai on 17.10.2017.
 */

public class PlacesResponse {
    private List<Place> results;
    private String status;

    public List<Place> getResults() {
        return results;
    }

    public PlacesResponse setResults(List<Place> results) {
        this.results = results;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PlacesResponse setStatus(String status) {
        this.status = status;
        return this;
    }
}
