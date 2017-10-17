package ro.mihai.pocjava.data.service;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mihai on 16.10.2017.
 * <p>
 * A wrapper around {@link Retrofit} used to generate the desired services
 */
@Singleton
public class RetrofitWrapper {

    private Retrofit retrofit;

    @Inject
    public RetrofitWrapper() {
        retrofit = createRetrofit();
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .baseUrl("https://maps.googleapis.com/maps/api/place/")
                .build();
    }

    private OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    /**
     * Generic method used to generate {@link Retrofit} services
     *
     * @param clazz interface used generate the service
     * @param <T>
     * @return created service
     */
    public <T> T createService(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
