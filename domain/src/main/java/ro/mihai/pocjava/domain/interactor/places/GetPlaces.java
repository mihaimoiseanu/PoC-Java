package ro.mihai.pocjava.domain.interactor.places;

import javax.inject.Inject;

import io.reactivex.Observable;
import ro.mihai.pocjava.domain.executor.PostExecutionThread;
import ro.mihai.pocjava.domain.executor.ThreadExecutor;
import ro.mihai.pocjava.domain.interactor.UseCase;
import ro.mihai.pocjava.domain.models.PlacesResponse;
import ro.mihai.pocjava.domain.repository.PlaceRepository;

/**
 * Created by mihai on 16.10.2017.
 */

public class GetPlaces extends UseCase<PlacesResponse, PlacesParams> {

    private final PlaceRepository placeRepository;

    @Inject
    public GetPlaces(PlaceRepository placeRepository,
                     ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.placeRepository = placeRepository;
    }

    @Override
    public Observable<PlacesResponse> buildUseCaseObservable(PlacesParams placesParams) {
        return placeRepository.places(placesParams);
    }


}
