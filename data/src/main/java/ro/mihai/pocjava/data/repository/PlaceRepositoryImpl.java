package ro.mihai.pocjava.data.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import ro.mihai.pocjava.data.mapper.PlaceMapper;
import ro.mihai.pocjava.data.service.PlaceService;
import ro.mihai.pocjava.data.service.RetrofitWrapper;
import ro.mihai.pocjava.domain.interactor.place.PlaceParams;
import ro.mihai.pocjava.domain.interactor.places.PlacesParams;
import ro.mihai.pocjava.domain.model.PlaceModel;
import ro.mihai.pocjava.domain.repository.PlaceRepository;

/**
 * Created by mihai on 16.10.2017.
 * <p>
 * {@link PlaceRepository} for retrieving data.
 */
@Singleton
public class PlaceRepositoryImpl implements PlaceRepository {
    private final PlaceService placeService;
    private final PlaceMapper placeMapper;

    /**
     * Constructs a {@link PlaceRepository}
     *
     * @param retrofitWrapper {@link RetrofitWrapper}.
     * @param placeMapper     {@link PlaceMapper}.
     */
    @Inject
    public PlaceRepositoryImpl(RetrofitWrapper retrofitWrapper, PlaceMapper placeMapper) {
        placeService = retrofitWrapper.createService(PlaceService.class);
        this.placeMapper = placeMapper;
    }

    @Override
    public Observable<List<PlaceModel>> places(@NonNull PlacesParams placesParams) {
        return placeService.getNearbyPlaces(placesParams.getParams()).map(placeMapper::transform);
    }

    @Override
    public Observable<PlaceModel> place(PlaceParams placeParams) {
        return placeService.getPlaceDetails(placeParams.getParams()).map(placeMapper::transform);
    }

}
