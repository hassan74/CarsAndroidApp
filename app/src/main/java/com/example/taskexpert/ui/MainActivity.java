package com.example.taskexpert.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.taskexpert.MyApplication;
import com.example.taskexpert.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplicationContext()).appComponent.mainComponent().create().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        NavController navController= Navigation.findNavController(this ,R.id.nav_host_fragment) ;

    }
}