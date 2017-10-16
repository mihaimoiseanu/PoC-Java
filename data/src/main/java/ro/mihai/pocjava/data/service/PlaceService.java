package ro.mihai.pocjava.data.service;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ro.mihai.pocjava.domain.models.PlaceResponse;
import ro.mihai.pocjava.domain.models.PlacesResponse;

/**
 * Created by mihai on 16.10.2017.
 */

public interface PlaceService {

    @GET("nearbysearch/json")
    Observable<PlacesResponse> getNearbyPlaces(@QueryMap Map<String, String> queries);

    @GET("details/json")
    Observable<PlaceResponse> getPlaceDetails(@QueryMap Map<String, String> queries);
}
