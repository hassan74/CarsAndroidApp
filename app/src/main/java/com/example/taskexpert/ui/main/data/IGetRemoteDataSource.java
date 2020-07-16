package com.example.taskexpert.ui.main.data;

import com.example.taskexpert.base.entities.ApiResponseBody;
import com.example.taskexpert.data.Car;

import java.util.List;

import io.reactivex.Single;

public interface IGetRemoteDataSource {
    public  Single<ApiResponseBody<List<Car>>> getCars(String page);
}
