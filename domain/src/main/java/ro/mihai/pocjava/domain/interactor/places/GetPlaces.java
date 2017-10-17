package ro.mihai.pocjava.domain.interactor.places;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ro.mihai.pocjava.domain.executor.PostExecutionThread;
import ro.mihai.pocjava.domain.executor.ThreadExecutor;
import ro.mihai.pocjava.domain.interactor.UseCase;
import ro.mihai.pocjava.domain.model.PlaceModel;
import ro.mihai.pocjava.domain.repository.PlaceRepository;

/**
 * Created by mihai on 16.10.2017.
 * This class is an implementation of {@link UseCase} that represents a use case
 * for retrieving a collection of all {@link PlaceModel}
 */

public class GetPlaces extends UseCase<List<PlaceModel>, PlacesParams> {

    private final PlaceRepository placeRepository;

    @Inject
    public GetPlaces(PlaceRepository placeRepository,
                     ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.placeRepository = placeRepository;
    }

    @Override
    public Observable<List<PlaceModel>> buildUseCaseObservable(PlacesParams placesParams) {
        return placeRepository.places(placesParams);
    }


}
