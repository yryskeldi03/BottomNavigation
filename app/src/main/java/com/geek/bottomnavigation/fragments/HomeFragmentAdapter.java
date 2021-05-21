package com.geek.bottomnavigation.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.geek.bottomnavigation.databinding.FragmentHomeItemsBinding;

import java.util.ArrayList;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder>  {
    private ArrayList<Model> list = new ArrayList<>();

    public void addItems(Model model){
        list.add(0,model);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentHomeItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(HomeFragmentAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private FragmentHomeItemsBinding binding;

        public ViewHolder(FragmentHomeItemsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Model model) {
            binding.tvName.setText(model.getName());
            binding.tvPhoneNumber.setText(model.getPhoneNumber());
        }
    }
}
