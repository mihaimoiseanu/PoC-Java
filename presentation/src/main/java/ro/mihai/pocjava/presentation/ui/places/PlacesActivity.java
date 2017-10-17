package ro.mihai.pocjava.presentation.ui.places;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.presentation.di.HasComponent;
import ro.mihai.pocjava.presentation.di.components.DaggerIPlaceComponent;
import ro.mihai.pocjava.presentation.di.components.IPlaceComponent;
import ro.mihai.pocjava.presentation.model.PlaceModel;
import ro.mihai.pocjava.presentation.ui.base.BaseActivity;

/**
 * Created by mihai on 16.10.2017.
 */

public class PlacesActivity extends BaseActivity implements HasComponent<IPlaceComponent>,
        PlaceListFragment.PlaceListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, PlacesActivity.class);
    }

    private IPlaceComponent placeComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.main_container, new PlaceListFragment());
        }
    }

    private void initInjector() {
        this.placeComponent = DaggerIPlaceComponent.builder()
                .iAppComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public IPlaceComponent getComponent() {
        return placeComponent;
    }

    @Override
    public void onPlaceClick(PlaceModel placeModel) {
        navigator.navigateToPlaceList(this);
    }
}
