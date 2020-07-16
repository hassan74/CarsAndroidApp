package com.example.taskexpert.ui.main.di;

import com.example.taskexpert.base.di.ActivityScope;
import com.example.taskexpert.ui.MainActivity;
import com.example.taskexpert.ui.main.presentation.MainFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface MainComponent {
    @Subcomponent.Factory
    interface Factory{
        MainComponent create ();
    }
    void inject (MainFragment mainFragment);
    void inject(MainActivity mainActivity);
}
