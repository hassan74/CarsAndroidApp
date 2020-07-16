package com.example.taskexpert.ui.main.data;

import com.example.taskexpert.base.entities.ApiResponseBody;
import com.example.taskexpert.data.Car;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataAPI {
    @GET("cars")
      public Single<ApiResponseBody<List<Car>>> getCars(@Query("page") String page );
}

