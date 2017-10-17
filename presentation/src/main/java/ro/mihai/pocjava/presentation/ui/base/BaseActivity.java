package ro.mihai.pocjava.presentation.ui.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import ro.mihai.pocjava.R;
import ro.mihai.pocjava.presentation.AndroidApplication;
import ro.mihai.pocjava.presentation.di.components.IAppComponent;
import ro.mihai.pocjava.presentation.di.modules.ActivityModule;
import ro.mihai.pocjava.presentation.navigation.Navigator;

import static android.view.View.NO_ID;

/**
 * Created by mihai on 16.10.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    public Navigator navigator;
    protected Toolbar mActionBarToolbar;
    protected ViewDataBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = setupBinding();
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

    protected abstract ViewDataBinding setupBinding();

    protected int getLayoutId() {
        return NO_ID;
    }

    protected void setupActionBarToolbar() {
        mActionBarToolbar = findViewById(R.id.toolbar);
        if (mActionBarToolbar != null) {
            setSupportActionBar(mActionBarToolbar);
        }
    }
}
