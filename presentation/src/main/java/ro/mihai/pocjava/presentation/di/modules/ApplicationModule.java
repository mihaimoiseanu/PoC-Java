package ro.mihai.pocjava.presentation.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ro.mihai.pocjava.data.executor.JobExecutor;
import ro.mihai.pocjava.data.repository.PlaceRepositoryImpl;
import ro.mihai.pocjava.domain.executor.PostExecutionThread;
import ro.mihai.pocjava.domain.executor.ThreadExecutor;
import ro.mihai.pocjava.domain.repository.PlaceRepository;
import ro.mihai.pocjava.presentation.AndroidApplication;
import ro.mihai.pocjava.presentation.UIThread;

/**
 * Created by mihai on 16.10.2017.
 */
@Module
public class ApplicationModule {

    private final AndroidApplication androidApplication;

    public ApplicationModule(AndroidApplication androidApplication) {
        this.androidApplication = androidApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.androidApplication;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides
    @Singleton
    PlaceRepository providePlaceRepository(PlaceRepositoryImpl placeRepository){
        return placeRepository;
    }
}
