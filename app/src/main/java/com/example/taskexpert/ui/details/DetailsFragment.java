package com.example.taskexpert.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.taskexpert.R;
import com.example.taskexpert.data.Car;
import com.example.taskexpert.databinding.DetailsFragmentBinding;

public class DetailsFragment extends Fragment {

    private DetailsFragmentArgs args ;
    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }
    DetailsFragmentBinding viewBiniding ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewBiniding = DetailsFragmentBinding.inflate(inflater ,container ,false);
        return  viewBiniding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            Car car = DetailsFragmentArgs.fromBundle(getArguments()).getCar() ;
            viewBiniding.setCar(car);
        }
    }

}