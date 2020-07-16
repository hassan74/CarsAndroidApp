package com.example.taskexpert.base.di;

import com.example.taskexpert.ui.main.data.DataAPI;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    public Retrofit provideRetrofitService() {
        OkHttpClient.Builder builder =new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel( HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        return new Retrofit.Builder()
                .baseUrl("http://demo1286023.mockable.io/api/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }
    @Provides
    DataAPI provideMainApi(Retrofit retrofit){
        return retrofit.create(DataAPI.class);
    }

}
