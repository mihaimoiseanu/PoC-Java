package ro.mihai.pocjava.domain.repository;

import io.reactivex.Observable;
import ro.mihai.pocjava.domain.models.PlaceResponse;
import ro.mihai.pocjava.domain.models.PlacesResponse;

/**
 * Created by mihai on 16.10.2017.
 */

public interface PlaceRepository {

    Observable<PlacesResponse> places();

    Observable<PlaceResponse> place();

}
