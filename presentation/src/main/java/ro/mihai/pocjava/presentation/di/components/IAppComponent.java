package ro.mihai.pocjava.presentation.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ro.mihai.pocjava.domain.executor.PostExecutionThread;
import ro.mihai.pocjava.domain.executor.ThreadExecutor;
import ro.mihai.pocjava.domain.repository.PlaceRepository;
import ro.mihai.pocjava.presentation.di.modules.ApplicationModule;
import ro.mihai.pocjava.presentation.ui.base.BaseActivity;

/**
 * Created by mihai on 16.10.2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface IAppComponent {

    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    PlaceRepository placeRepository();

}
