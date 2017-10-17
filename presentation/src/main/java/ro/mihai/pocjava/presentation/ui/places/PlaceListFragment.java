package ro.mihai.pocjava.presentation.ui.places;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.databinding.FragmentPlaceListBinding;
import ro.mihai.pocjava.presentation.di.components.IPlaceComponent;
import ro.mihai.pocjava.presentation.model.PlaceModel;
import ro.mihai.pocjava.presentation.registry.ViewModelRegistry;
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
    @Inject
    ViewModelRegistry viewModelRegistry;

    private FragmentPlaceListBinding binding;
    private PlaceListListener placeListListener;
    private PlaceViewModel placeViewModel;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(IPlaceComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_place_list, container, false);
        binding.placeList.setHandler(placeListPresenter);
        placeViewModel = viewModelRegistry.get(PlaceViewModel.class);
        binding.setVm(placeViewModel);
        setupRefreshListener();
        return binding.getRoot();
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
        binding.swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        binding.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(String error) {
        this.showToastMessage(error);
        hideLoading();
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    @Override
    public void renderPlaceList(Collection<PlaceModel> placeModels) {
        placeViewModel.setItems((List<PlaceModel>) placeModels);
    }

    @Override
    public void viewPlace(PlaceModel placeModel) {

    }

    private void loadPlaceList() {
        this.placeListPresenter.init();
    }

    private void setupRefreshListener() {
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadPlaceList();
            }
        });
    }
}
