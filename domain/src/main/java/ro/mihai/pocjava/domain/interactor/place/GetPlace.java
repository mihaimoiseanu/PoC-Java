package ro.mihai.pocjava.domain.interactor.place;

import javax.inject.Inject;

import io.reactivex.Observable;
import ro.mihai.pocjava.domain.executor.PostExecutionThread;
import ro.mihai.pocjava.domain.executor.ThreadExecutor;
import ro.mihai.pocjava.domain.interactor.UseCase;
import ro.mihai.pocjava.domain.model.PlaceModel;
import ro.mihai.pocjava.domain.repository.PlaceRepository;

/**
 * Created by mihai on 16.10.2017.
 */

public class GetPlace extends UseCase<PlaceModel, PlaceParams> {
    private final PlaceRepository placeRepository;

    @Inject
    public GetPlace(PlaceRepository placeRepository,
                    ThreadExecutor threadExecutor,
                    PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.placeRepository = placeRepository;
    }

    @Override
    public Observable<PlaceModel> buildUseCaseObservable(PlaceParams params) {
        return placeRepository.place(params);
    }
}
