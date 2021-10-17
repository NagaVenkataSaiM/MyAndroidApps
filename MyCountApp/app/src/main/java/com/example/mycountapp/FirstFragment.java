package com.example.mycountapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mycountapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mytoast=Toast.makeText(getActivity(),"Made By Nvsai!",Toast.LENGTH_SHORT);
                mytoast.show();
            }
        });
        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvf=view.findViewById(R.id.textview_first);
                String counttext=tvf.getText().toString();
                Integer count = Integer.parseInt(counttext);
                count++;
                tvf.setText(count.toString());
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvf=view.findViewById(R.id.textview_first);
                int cc=Integer.parseInt(tvf.getText().toString());
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action=FirstFragmentDirections.actionFirstFragmentToSecondFragment(cc);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}