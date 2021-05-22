package com.geek.bottomnavigation.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.geek.bottomnavigation.databinding.FragmentHomeItemsBinding;

import java.util.ArrayList;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder>  {
    private ArrayList<Model> list = new ArrayList<>();
    private OnRecyclerItemClick listener;

    public HomeFragmentAdapter() {

    }

    public void addItems(Model models){
        this.list.add(0,models);
        notifyDataSetChanged();
    }

    public void changeItems(Model model, int pos){
        list.remove(pos);
        list.add(pos,model);
        notifyItemChanged(pos);
    }

    public void setListener(OnRecyclerItemClick listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentHomeItemsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(HomeFragmentAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(v -> listener.onItemClick(list.get(position), position));
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
