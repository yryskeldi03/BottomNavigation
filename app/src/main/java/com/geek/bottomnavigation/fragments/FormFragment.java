package com.geek.bottomnavigation.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.geek.bottomnavigation.R;
import com.geek.bottomnavigation.databinding.FragmentDashBinding;
import com.geek.bottomnavigation.databinding.FragmentFormBinding;

import java.util.ArrayList;

public class FormFragment extends Fragment {
    private FragmentFormBinding binding;
    private HomeFragmentAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFormBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(v -> {
            String name = binding.etName.getText().toString().trim();
            String phoneNumber = binding.etPhoneNumber.getText().toString().trim();

            if (name.equals("")) {
                binding.etName.setError("Заполните имя");
            } else if (phoneNumber.equals("")) {
                binding.etPhoneNumber.setError("Заполните номер");
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("number", phoneNumber);
                getActivity().getSupportFragmentManager().setFragmentResult("key", bundle);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}