package com.geek.bottomnavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geek.bottomnavigation.MainActivity;
import com.geek.bottomnavigation.R;
import com.geek.bottomnavigation.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements OnRecyclerItemClick {
    private FragmentHomeBinding binding;
    private HomeFragmentAdapter adapter;
    private Model model;
    private MainActivity mainActivity;
    private FormFragment formFragment;
    private boolean isEdited = false;
    private int pos;
    private ArrayList<Model> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HomeFragmentAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainActivity = (MainActivity) requireActivity();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireActivity().getSupportFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                model = new Model(result.getString("name"), result.getString("number"));
                if (isEdited){
                    adapter.changeItems(model,pos);
                }else{
                    adapter.addItems(model);
                }
            }
        });
        adapter.setListener(this);
        binding.recycler.setAdapter(adapter);
        binding.fab.setOnClickListener(v -> {
            isEdited = false;
            mainActivity.hideBottomNav();
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack(null).replace(R.id.cont, new FormFragment()).commit();
        });
    }

    @Override
    public void onItemClick(Model model, int pos) {
        this.pos = pos;
        isEdited = true;
        Bundle bundle = new Bundle();
        formFragment = new FormFragment();
        formFragment.setArguments(bundle);
        bundle.putSerializable("model",model);
        mainActivity.hideBottomNav();
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(R.id.cont,formFragment).commit();
    }
}