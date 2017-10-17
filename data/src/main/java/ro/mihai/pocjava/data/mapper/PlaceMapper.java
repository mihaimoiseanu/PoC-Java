package ro.mihai.pocjava.data.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ro.mihai.pocjava.data.models.Place;
import ro.mihai.pocjava.data.models.PlaceResponse;
import ro.mihai.pocjava.data.models.PlacesResponse;
import ro.mihai.pocjava.domain.model.PhotoModel;
import ro.mihai.pocjava.domain.model.PlaceModel;

/**
 * Created by mihai on 17.10.2017.
 * Mapper class used to transform {@link Place} (int the data layer) to {@link PlaceModel}
 * in the domain layer
 */
@Singleton
public class PlaceMapper {

    private final PhotoMapper photoMapper;

    @Inject
    public PlaceMapper(PhotoMapper photoMapper) {
        this.photoMapper = photoMapper;
    }

    /**
     * Transform a {@link Place} into a {@link PlaceModel}
     *
     * @param place Object to be transformed
     * @return {@link PhotoModel} if {@link Place} otherwise null
     */
    public PlaceModel transform(Place place) {
        if (place == null) {
            return null;
        }
        final PlaceModel placeModel = new PlaceModel();
        placeModel.setName(place.getName());
        placeModel.setPlaceId(place.getPlaceId());
        placeModel.setRating(place.getRating());
        placeModel.setPhotoModels((List<PhotoModel>) photoMapper.transform(place.getPhotos()));
        return placeModel;
    }


    /**
     * Transform a {@link PlacesResponse} into a List of {@link PlaceModel}
     *
     * @param placesResponse Object to be transformed
     * @return {@link PlaceModel} if valid {@link PlacesResponse} otherwise empty list
     */
    public List<PlaceModel> transform(PlacesResponse placesResponse) {
        List<Place> places = placesResponse.getResults();
        List<PlaceModel> placeModelCollection;
        if (places != null && !places.isEmpty()) {
            placeModelCollection = new ArrayList<>();
            for (Place place : places) {
                placeModelCollection.add(transform(place));
            }
        } else {
            placeModelCollection = Collections.emptyList();
        }
        return placeModelCollection;
    }

    /**
     * Transform a {@link PlaceResponse} into a {@link PlaceModel}
     *
     * @param placeResponse Object to be transformed
     * @return {@link PhotoModel} if {@link PlaceResponse} otherwise null
     */
    public PlaceModel transform(PlaceResponse placeResponse) {
        return transform(placeResponse.getResponse());
    }

}
