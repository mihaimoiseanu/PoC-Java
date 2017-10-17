package ro.mihai.pocjava.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ro.mihai.pocjava.domain.interactor.place.PlaceParams;
import ro.mihai.pocjava.domain.interactor.places.PlacesParams;
import ro.mihai.pocjava.domain.model.PlaceModel;

/**
 * Created by mihai on 16.10.2017.
 * Interface  that represents a Repository for getting {@link PlaceModel} related data.
 */

public interface PlaceRepository {

    /**
     * Get an {@link Observable} which will emit a list of {@link PlaceModel}
     *
     * @param params used for retrieving places
     */
    Observable<List<PlaceModel>> places(PlacesParams params);

    /**
     * Get an {@link Observable} which will emit a {@link PlaceModel}
     *
     * @param params used for retrieving place
     */
    Observable<PlaceModel> place(PlaceParams params);

}
