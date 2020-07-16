package com.example.taskexpert.ui.main.domain;

import com.example.taskexpert.base.UseCase;
import com.example.taskexpert.base.entities.ApiResponseBody;
import com.example.taskexpert.data.Car;
import com.example.taskexpert.ui.main.data.IGetDataRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
public class GetCarsUseCase implements UseCase<String  , Single<ApiResponseBody<List<Car>>>> {
    private final IGetDataRepository getDataRepository;
    @Inject
    public GetCarsUseCase(IGetDataRepository getDataRepository){
        this.getDataRepository =getDataRepository ;
    }

    @Override
    public  Single<ApiResponseBody<List<Car>>> execute(String page) {
        return getDataRepository.getCars(page);
    }
}
