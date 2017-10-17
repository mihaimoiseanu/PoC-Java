package ro.mihai.pocjava.data.models;

/**
 * Created by mihai on 17.10.2017.
 */

public class PlaceResponse {
    private Place response;
    private String status;

    public Place getResponse() {
        return response;
    }

    public PlaceResponse setResponse(Place response) {
        this.response = response;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PlaceResponse setStatus(String status) {
        this.status = status;
        return this;
    }
}
