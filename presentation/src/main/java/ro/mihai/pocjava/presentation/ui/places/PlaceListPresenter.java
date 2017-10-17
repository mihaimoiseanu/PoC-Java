package ro.mihai.pocjava.presentation.ui.places;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import ro.mihai.pocjava.domain.exception.DefaultErrorBundle;
import ro.mihai.pocjava.domain.interactor.DefaultObserver;
import ro.mihai.pocjava.domain.interactor.places.GetPlaces;
import ro.mihai.pocjava.domain.interactor.places.PlacesParams;
import ro.mihai.pocjava.domain.model.PlaceModel;
import ro.mihai.pocjava.presentation.di.PerActivity;
import ro.mihai.pocjava.presentation.ui.base.Presenter;
import ro.mihai.pocjava.presentation.views.ActionHandler;

/**
 * Created by mihai on 16.10.2017.
 */

@PerActivity
public class PlaceListPresenter implements Presenter, ActionHandler<PlaceModel> {

    private PlaceListView placeListView;

    private final GetPlaces getPlacesCase;

    @Inject
    public PlaceListPresenter(GetPlaces getPlaces) {
        this.getPlacesCase = getPlaces;
    }

    public void setView(@NonNull PlaceListView placeListView) {
        this.placeListView = placeListView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getPlacesCase.dispose();
        this.placeListView = null;
    }


    public void getPlacesList(Double lat, Double lng, String key) {
        PlacesParams placesParams = new PlacesParams.Builder(key, lat + "," + lng, 20)
                .build();
        this.getPlacesCase.execute(new PlaceListObserver(), placesParams);
    }

    private void showUsersCollectionInView(List<PlaceModel> places) {
        placeListView.renderPlaceList(places);
    }

    private void showViewLoading() {
        this.placeListView.showLoading();
    }

    private void hideViewLoading() {
        this.placeListView.hideLoading();
    }

    private void showErrorMessage(DefaultErrorBundle defaultErrorBundle) {
        this.placeListView.showError(defaultErrorBundle.getErrorMessage());
    }

    @Override
    public void onItemClick(PlaceModel item) {

    }

    private final class PlaceListObserver extends DefaultObserver<List<PlaceModel>> {
        @Override
        public void onNext(List<PlaceModel> value) {
            PlaceListPresenter.this.showUsersCollectionInView(value);
        }

        @Override
        public void onError(Throwable e) {
            PlaceListPresenter.this.hideViewLoading();
            PlaceListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
        }

        @Override
        public void onComplete() {
            PlaceListPresenter.this.hideViewLoading();
        }
    }
}
