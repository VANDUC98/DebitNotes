package com.hdpsolution.debitnotes.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hdpsolution.debitnotes.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Give extends Fragment_profit {
    public Fragment_Give() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__give, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataArrayList.clear();
        dialog=showDialog(getContext());
        dataArrayList = databaseHelper.getAllGive();
        if (!dataArrayList.isEmpty()) {
            loadList();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFunction(2);
            }
        });

    }
}
