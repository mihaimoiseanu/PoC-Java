package ro.mihai.pocjava.presentation.navigation;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import ro.mihai.pocjava.presentation.ui.places.PlacesActivity;

/**
 * Created by mihai on 16.10.2017.
 */

@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }


    public void navigateToPlaceList(Context context) {
        if (context != null) {
            context.startActivity(PlacesActivity.getCallingIntent(context));
        }
    }


}
