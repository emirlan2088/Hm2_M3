package com.example.hm2_m3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment {

    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView result = requireActivity().findViewById(R.id.tv_counter);
        Button navigate = requireActivity().findViewById(R.id.btn_navigate);
        Button plus = requireActivity().findViewById(R.id.btn_plus);

        plus.setOnClickListener(v -> {
            counter++;
            result.setText(counter);
        });

        navigate.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("password", counter);

            NavHostFragment.findNavController(CounterFragment.this)
                    .navigate(R.id.action_counterFragment_to_resultFragment);
        });

    }
}