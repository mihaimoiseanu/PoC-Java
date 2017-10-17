package ro.mihai.pocjava.presentation.ui.places;

import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import javax.inject.Inject;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.databinding.FragmentPlaceListBinding;
import ro.mihai.pocjava.domain.model.PlaceModel;
import ro.mihai.pocjava.presentation.di.components.IPlaceComponent;
import ro.mihai.pocjava.presentation.registry.ViewModelRegistry;
import ro.mihai.pocjava.presentation.ui.base.BaseFragment;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

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

    private final LatLng DEFAULT_LOCATION = new LatLng(45.6681758, 25.5925796);
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private LatLng currentLatLng = DEFAULT_LOCATION;


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
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.context());
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
    public void renderPlaceList(List<PlaceModel> placeModels) {
        placeViewModel.setItems(placeModels);
    }

    @Override
    public void viewPlace(PlaceModel placeModel) {

    }

    private void loadPlaceList() {
//        if (!checkLocationService()) {
        this.placeListPresenter.getPlacesList(currentLatLng.latitude, currentLatLng.longitude, getString(R.string.google_api_key));
//            return;
//        }
//        getLastLocation();
    }
//
//    private void getLastLocation() {
//        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
//                this.placeListPresenter.getPlacesList(currentLatLng.latitude, currentLatLng.longitude, getString(R.string.google_api_key));
//            }
//        });
//    }

    private void setupRefreshListener() {
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadPlaceList();
            }
        });
    }


    private boolean checkLocationService() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean gpsLocation = false;
        boolean networkLocation = false;
        try {
            gpsLocation = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            networkLocation = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (IllegalArgumentException e) {
            Log.d("Location service", e.getMessage());
        }
        if (!gpsLocation && !networkLocation)
            return false;
        if (!checkPermission()) {
            requestPermission();
            return false;
        }
        return true;
    }

    private boolean checkPermission() {
        int coarseLocation = ContextCompat.checkSelfPermission(getActivity(), ACCESS_COARSE_LOCATION);
        int fineLocation = ContextCompat.checkSelfPermission(getActivity(), ACCESS_FINE_LOCATION);
        return coarseLocation == PackageManager.PERMISSION_GRANTED && fineLocation == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this.getActivity(), new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, 200);
    }

}
