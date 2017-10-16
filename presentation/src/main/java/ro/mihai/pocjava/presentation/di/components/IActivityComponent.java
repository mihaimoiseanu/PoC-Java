package ro.mihai.pocjava.presentation.di.components;

import android.app.Activity;

import dagger.Component;
import ro.mihai.pocjava.presentation.di.PerActivity;
import ro.mihai.pocjava.presentation.di.modules.ActivityModule;

/**
 * Created by mihai on 16.10.2017.
 */

@PerActivity
@Component(dependencies = IAppComponent.class, modules = ActivityModule.class)
public interface IActivityComponent {
    Activity activity();
}
