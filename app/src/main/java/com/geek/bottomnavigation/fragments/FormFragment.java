package com.geek.bottomnavigation.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.bottomnavigation.MainActivity;
import com.geek.bottomnavigation.databinding.FragmentFormBinding;

public class FormFragment extends Fragment {
    private FragmentFormBinding binding;
    private MainActivity mainActivity;
    private String name, phoneNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFormBinding.inflate(getLayoutInflater());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFormBinding.inflate(inflater, container, false);
        mainActivity = (MainActivity) requireActivity();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            Model model = (Model) getArguments().getSerializable("model");
            binding.etPhoneNumber.setText(model.getPhoneNumber());
            binding.etName.setText(model.getName());
        }
        binding.btnSave.setOnClickListener(v -> {
            name = binding.etName.getText().toString().trim();
            phoneNumber = binding.etPhoneNumber.getText().toString().trim();
            if (name.equals("")) {
                binding.etName.setError("Заполните имя");
            } else if (phoneNumber.equals("")) {
                binding.etPhoneNumber.setError("Заполните номер");
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("number", phoneNumber);
                mainActivity.visibleBottomNav();
                getActivity().getSupportFragmentManager().setFragmentResult("key", bundle);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}
