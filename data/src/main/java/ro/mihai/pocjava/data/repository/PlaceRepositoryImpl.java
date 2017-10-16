package ro.mihai.pocjava.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import ro.mihai.pocjava.data.service.PlaceService;
import ro.mihai.pocjava.data.service.RetrofitWrapper;
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
    public Observable<PlacesResponse> places() {
        return null;
    }

    @Override
    public Observable<PlaceResponse> place() {
        return null;
    }
}
