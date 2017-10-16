package ro.mihai.pocjava.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import ro.mihai.pocjava.domain.executor.PostExecutionThread;
import ro.mihai.pocjava.domain.executor.ThreadExecutor;
import ro.mihai.pocjava.domain.models.PlacesResponse;
import ro.mihai.pocjava.domain.repository.PlaceRepository;

/**
 * Created by mihai on 16.10.2017.
 */

public class GetPlaces extends UseCase<PlacesResponse, Void> {

    private final PlaceRepository placeRepository;

    @Inject
    public GetPlaces(PlaceRepository placeRepository,
                     ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.placeRepository = placeRepository;
    }

    @Override
    Observable<PlacesResponse> buildUseCaseObservable(Void aVoid) {
        return placeRepository.places();
    }
}
