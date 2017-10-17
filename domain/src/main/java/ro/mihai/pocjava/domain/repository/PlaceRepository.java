package ro.mihai.pocjava.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ro.mihai.pocjava.domain.interactor.place.PlaceParams;
import ro.mihai.pocjava.domain.interactor.places.PlacesParams;
import ro.mihai.pocjava.domain.model.PlaceModel;

/**
 * Created by mihai on 16.10.2017.
 */

public interface PlaceRepository {

    Observable<List<PlaceModel>> places(PlacesParams params);

    Observable<PlaceModel> place(PlaceParams params);

}
