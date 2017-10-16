package ro.mihai.pocjava.presentation.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import ro.mihai.pocjava.presentation.di.PerActivity;

/**
 * Created by mihai on 16.10.2017.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }
}

