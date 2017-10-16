package ro.mihai.pocjava.presentation.di.components;

import dagger.Component;
import ro.mihai.pocjava.presentation.di.PerActivity;
import ro.mihai.pocjava.presentation.di.modules.ActivityModule;
import ro.mihai.pocjava.presentation.di.modules.PlaceModule;

/**
 * Created by mihai on 16.10.2017.
 */
@PerActivity
@Component(dependencies = IAppComponent.class, modules = {ActivityModule.class, PlaceModule.class})
public interface IPlaceComponent extends IActivityComponent {
}
