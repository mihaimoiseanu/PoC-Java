package ro.mihai.pocjava.presentation;

import android.app.Application;

import ro.mihai.pocjava.presentation.di.components.DaggerIAppComponent;
import ro.mihai.pocjava.presentation.di.components.IAppComponent;
import ro.mihai.pocjava.presentation.di.modules.ApplicationModule;

/**
 * Created by mihai on 16.10.2017.
 */

public class AndroidApplication extends Application {

    private IAppComponent iAppComponent;

    private static AndroidApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.setUpComponent();
        mInstance = this;
    }

    private void setUpComponent() {
        this.iAppComponent = DaggerIAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public IAppComponent getAppComponent() {
        return iAppComponent;
    }


    public static AndroidApplication getInstance() {
        return mInstance;
    }
}
