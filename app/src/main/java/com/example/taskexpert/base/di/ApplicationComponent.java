package com.example.taskexpert.base.di;

import com.example.taskexpert.ui.MainActivity;
import com.example.taskexpert.ui.main.di.MainComponent;
import com.example.taskexpert.ui.main.di.MainModule;
import com.example.taskexpert.ui.main.presentation.MainFragment;

import dagger.Component;

@Component(modules = {NetworkModule.class ,MainModule.class})
public  interface ApplicationComponent {
    MainComponent.Factory mainComponent();
}
