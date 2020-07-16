package com.example.taskexpert.ui.main.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskexpert.base.ExecutionThread;
import com.example.taskexpert.data.Car;
import com.example.taskexpert.base.di.ActivityScope;
import com.example.taskexpert.ui.main.domain.GetCarsUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@ActivityScope
public class MainViewModel extends ViewModel {
    public GetCarsUseCase getDataUseCase;
    private  CompositeDisposable compositeDisposable;
    private  ExecutionThread executionThread;
    private MutableLiveData<List<Car>> _cars = new MutableLiveData<>();
    public LiveData<List<Car>> cars = _cars;
    //public LiveData<String> title = Transformations.map(_items ,items -> String.valueOf(items.size()));

    private MutableLiveData<Boolean> _progressBar = new MutableLiveData<>();
    public LiveData<Boolean> progressBar = _progressBar;

    @Inject
    public MainViewModel( GetCarsUseCase getDataUseCase) {
        this.getDataUseCase=getDataUseCase ;
    }

    public void getData() {
        compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(
                getDataUseCase.execute("1")
                       // .subscribeOn(executionThread.getIOThread())
                        .subscribeOn(Schedulers.io())
                       // .observeOn(executionThread.getMainThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> {
                            _progressBar.setValue(true);
                        })
                        .doFinally(()->{
                            _progressBar.setValue(false);
                        })
                        .subscribe((cars) -> {
                            _cars.setValue(cars.getData());
                        },(throwable) ->{
                            throwable.getMessage();
                        })
        );


    }
}