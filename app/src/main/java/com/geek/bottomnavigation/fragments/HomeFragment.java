package com.geek.bottomnavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.bottomnavigation.R;
import com.geek.bottomnavigation.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeFragmentAdapter adapter;
    private ArrayList<Model> list = new ArrayList<>();
    private String name, phoneNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new HomeFragmentAdapter();
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        adapter.addItems(new Model("jopa","jopa"));
        binding.recycler.setAdapter(adapter);
        binding.fab.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.cont,new FormFragment()).commit();
        });
    }

}