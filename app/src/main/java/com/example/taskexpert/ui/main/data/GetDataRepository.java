package com.example.taskexpert.ui.main.data;

import com.example.taskexpert.base.entities.ApiResponseBody;
import com.example.taskexpert.data.Car;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
public class GetDataRepository implements IGetDataRepository {
    private final IGetRemoteDataSource getRemoteDataSource ;
    @Inject
    public GetDataRepository(IGetRemoteDataSource getRemoteDataSource){
        this.getRemoteDataSource =getRemoteDataSource ;
    }

    @Override
    public Single<ApiResponseBody<List<Car>>> getCars(String page) {
        return getRemoteDataSource.getCars(page);
    }
}
