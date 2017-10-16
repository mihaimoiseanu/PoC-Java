package ro.mihai.pocjava.presentation.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import ro.mihai.pocjava.presentation.AndroidApplication;
import ro.mihai.pocjava.presentation.di.components.IAppComponent;
import ro.mihai.pocjava.presentation.di.modules.ActivityModule;
import ro.mihai.pocjava.presentation.navigation.Navigator;

/**
 * Created by mihai on 16.10.2017.
 */

public abstract class BaseActivity extends Activity {
    @Inject
    public Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getAppComponent().inject(this);
    }


    protected IAppComponent getAppComponent() {
        return AndroidApplication.getInstance().getAppComponent();
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
