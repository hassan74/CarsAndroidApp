package com.example.taskexpert.ui.main.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskexpert.data.Car;
import com.example.taskexpert.databinding.CarItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CarsAdapter extends ListAdapter<Car, CarsAdapter.ViewHolder> {
    public static final DiffUtil.ItemCallback<Car> DIFF_CALLBACK = new DiffUtil.ItemCallback<Car>() {

        @Override
        public boolean areItemsTheSame(@NonNull Car oldItem, @NonNull Car newItem) {
            return oldItem.getId() == newItem.getId();

        }

        @Override
        public boolean areContentsTheSame(@NonNull Car oldItem, @NonNull Car newItem) {
            return oldItem.getId() == newItem.getId();
        }
    };
    //  RecyclerView.Adapter<TasksAdapter.ViewHolder> {
    ArrayList<Car> cars;

    public CarsAdapter(ArrayList<Car> cars) {
        super(DIFF_CALLBACK);
        this.cars = cars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item ,parent ,false));
        return new ViewHolder(CarItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void submitList(@Nullable List<Car> list) {
        //  super.submitList(list);
        if (list != null) {
            cars.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car item = cars.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CarItemBinding binding ;
        public ViewHolder(@NonNull CarItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            binding.carItemImage.setOnClickListener(view -> {
                navigateToCarDetails(binding.getCar() ,binding.getRoot());
            }
            );
        }
        void bind(Car item){
            binding.setCar(item);
        }

        private void navigateToCarDetails(
                Car car,
                View view
        ) {
           MainFragmentDirections.ActionMainFragmentToDetailsFragment direction = MainFragmentDirections.actionMainFragmentToDetailsFragment(car);
            Navigation.findNavController(view).navigate(direction);
        }
    }
}
