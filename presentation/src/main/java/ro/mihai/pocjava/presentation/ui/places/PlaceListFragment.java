package ro.mihai.pocjava.presentation.ui.places;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;

import javax.inject.Inject;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.presentation.model.PlaceModel;
import ro.mihai.pocjava.presentation.ui.base.BaseFragment;

/**
 * Created by mihai on 16.10.2017.
 */

public class PlaceListFragment extends BaseFragment implements PlaceListView {

    public interface PlaceListListener {
        void onPlaceClick(final PlaceModel placeModel);
    }

    @Inject
    PlaceListPresenter placeListPresenter;

    private PlaceListListener placeListListener;

    public PlaceListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PlaceListListener) {
            this.placeListListener = (PlaceListListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_user_list, container, false);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.placeListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadPlaceList();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.placeListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.placeListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.placeListPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.placeListListener = null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {
        this.showToastMessage(error);
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    @Override
    public void renderPlaceList(Collection<PlaceModel> placeModels) {

    }

    @Override
    public void viewPlace(PlaceModel placeModel) {

    }

    private void loadPlaceList() {
        this.placeListPresenter.init();
    }
}
