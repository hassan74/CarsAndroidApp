package com.example.taskexpert.ui.main.presentation;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskexpert.MyApplication;
import com.example.taskexpert.data.Car;
import com.example.taskexpert.databinding.MainFragmentBinding;

import java.util.ArrayList;

import javax.inject.Inject;


public class MainFragment extends Fragment {
    @Inject
    public MainViewModel mViewModel;
    MainFragmentBinding viewDataBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewDataBinding =MainFragmentBinding.inflate(inflater ,container ,false);
        return viewDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewDataBinding.setLifecycleOwner(getActivity());
        viewDataBinding.setViewModel(mViewModel);
        ArrayList<Car> cars=new ArrayList<>();
        CarsAdapter tasksAdapter = new CarsAdapter((ArrayList<Car>) cars);
        viewDataBinding.carsList.setAdapter(tasksAdapter);
        mViewModel.getData();


    }

    @Override
    public void onAttach(@NonNull Context context) {
        ((MyApplication) context.getApplicationContext()).appComponent.mainComponent().create().inject(this );

        super.onAttach(context);
    }
}