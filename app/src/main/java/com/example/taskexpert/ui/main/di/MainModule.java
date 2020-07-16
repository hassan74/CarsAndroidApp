package com.example.taskexpert.ui.main.di;


import com.example.taskexpert.ui.main.data.DataAPI;
import com.example.taskexpert.ui.main.data.GetDataRepository;
import com.example.taskexpert.ui.main.data.GetRemotDataSource;
import com.example.taskexpert.ui.main.data.IGetDataRepository;
import com.example.taskexpert.ui.main.data.IGetRemoteDataSource;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(subcomponents = MainComponent.class)
public abstract class MainModule {

    @Binds
    public abstract IGetDataRepository bindGetDataRepository(
            GetDataRepository getDataRepository
    );
    @Binds
    public abstract IGetRemoteDataSource bindGetDataRemoteDataSource(
            GetRemotDataSource getRemotDataSource
    );
}
