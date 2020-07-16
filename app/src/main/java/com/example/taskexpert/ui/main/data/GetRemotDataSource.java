package com.example.taskexpert.ui.main.data;

import com.example.taskexpert.base.entities.ApiResponseBody;
import com.example.taskexpert.data.Car;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
public class GetRemotDataSource implements IGetRemoteDataSource {
    DataAPI dataAPI;
    @Inject
    public GetRemotDataSource(DataAPI dataAPI){
        this.dataAPI=dataAPI;
    }


    @Override
    public Single<ApiResponseBody<List<Car>>> getCars(String page) {
        return  dataAPI.getCars(page);
    }
}
