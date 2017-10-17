package ro.mihai.pocjava.data.repository;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import ro.mihai.pocjava.data.service.PlaceService;
import ro.mihai.pocjava.data.service.RetrofitWrapper;
import ro.mihai.pocjava.domain.interactor.place.PlaceParams;
import ro.mihai.pocjava.domain.interactor.places.PlacesParams;
import ro.mihai.pocjava.domain.models.PlaceResponse;
import ro.mihai.pocjava.domain.models.PlacesResponse;
import ro.mihai.pocjava.domain.repository.PlaceRepository;

/**
 * Created by mihai on 16.10.2017.
 */
@Singleton
public class PlaceRepositoryImpl implements PlaceRepository {
    private PlaceService placeService;

    @Inject
    public PlaceRepositoryImpl(RetrofitWrapper retrofitWrapper) {
        placeService = retrofitWrapper.createService(PlaceService.class);
    }

    @Override
    public Observable<PlacesResponse> places(@NonNull PlacesParams placesParams) {
        return placeService.getNearbyPlaces(null);
    }

    @Override
    public Observable<PlaceResponse> place(PlaceParams placeParams) {
        return placeService.getPlaceDetails(placeParams.getParams());
    }

}
