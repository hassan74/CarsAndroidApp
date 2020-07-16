package com.example.taskexpert;

import android.app.Application;

import com.example.taskexpert.base.di.ApplicationComponent;
import com.example.taskexpert.base.di.DaggerApplicationComponent;


// Definition of the Application graph

public class MyApplication extends Application {
    public ApplicationComponent appComponent = DaggerApplicationComponent.create();
}
