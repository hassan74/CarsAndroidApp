package com.example.taskexpert.ui.main.presentation;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.taskexpert.data.Car;

import java.util.List;

public class CarsListBinding {
    @BindingAdapter("app:items")
    public static void setItems(RecyclerView listView , List<Car> items){
        if(items!=null )
            ((CarsAdapter)listView.getAdapter() ).submitList(items);
    }

    @BindingAdapter("app:imageFromUrl")
    public static void bindImageFromUrl(ImageView view, String imageUrl) {
        if (imageUrl!=null && !imageUrl.isEmpty()) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(view);
        }
    }



    @BindingAdapter("app:visibility")
    public static void setVisibility(ProgressBar progressBar, Boolean status){
        if(status!=null){
            if(!status )
                progressBar.setVisibility(View.GONE);
            else
                progressBar.setVisibility(View.VISIBLE);
        }

    }
}
