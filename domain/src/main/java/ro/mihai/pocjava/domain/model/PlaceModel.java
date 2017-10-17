package ro.mihai.pocjava.domain.model;

import java.util.List;

/**
 * Created by mihai on 16.10.2017.
 */

public class PlaceModel {
    private String placeId;
    private String name;
    private Double rating;
    private List<PhotoModel> photoModels;

    public String getPlaceId() {
        return placeId;
    }

    public PlaceModel setPlaceId(String placeId) {
        this.placeId = placeId;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlaceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public PlaceModel setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public List<PhotoModel> getPhotoModels() {
        return photoModels;
    }

    public PlaceModel setPhotoModels(List<PhotoModel> photoModels) {
        this.photoModels = photoModels;
        return this;
    }
}
