package com.hdpsolution.debitnotes.fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hdpsolution.debitnotes.Database.DatabaseHelper;
import com.hdpsolution.debitnotes.R;
import com.hdpsolution.debitnotes.adapter.AdapterMoneyTake;
import com.hdpsolution.debitnotes.model.Data;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_profit extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterMoneyTake adapterMoneyTake;
    public ArrayList<Data> dataArrayList;
    public FloatingActionButton fab;
    public DatabaseHelper databaseHelper;
    private EditText edtName;
    private EditText edtPhone;
    private EditText edtAddress;
    private EditText edtDate;
    private EditText edtNumber;
    private EditText edtPercent;
    private EditText edtNote;
    private Button btnAdd;
    private Button btnCancel;
    private ImageView imgDate;
    public Dialog dialog;
    public Fragment_profit() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.cycleLst);
        fab = view.findViewById(R.id.fab);
        databaseHelper = new DatabaseHelper(getContext());
        dialog = showDialog(getContext());
        dataArrayList = databaseHelper.getAllProfit();
        if (!dataArrayList.isEmpty()) {
            loadList();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFunction(1);
                dialog.show();
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addFunction(1);
                    }
                });
            }
        });
    }

    public void addFunction(final int i) {
        dialog.show();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type=i;
                String name=edtName.getText().toString().trim();
                String phone=edtPhone.getText().toString().trim();
                String address=edtAddress.getText().toString().trim();
                String date=edtDate.getText().toString().trim();
                String number=edtNumber.getText().toString().trim();
                String percent=edtPercent.getText().toString().trim();
                String note=edtNote.getText().toString().trim();
                if(name!=null && !name.equals("") &&phone!=null && !phone.equals("") &&address!=null && !address.equals("")
                        &&date!=null && !date.equals("") && number!=null && !number.equals("") &&percent!=null && !percent.equals("") &&note!=null && !note.equals("")){
                    Data data=new Data(name,phone,address,date,number,percent,note,type);
                    if(databaseHelper.addMoney(data)){
                        dataArrayList.add(data);
                        loadList();
                        dialog.dismiss();
                    }
                    else {
                        dialog.dismiss();
                    }

                }
                else {
                    Toast.makeText(getContext(), R.string.checknull, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void loadList() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterMoneyTake=new AdapterMoneyTake(getContext(),dataArrayList);
        recyclerView.setAdapter(adapterMoneyTake);
        adapterMoneyTake.notifyDataSetChanged();

    }
    public Dialog showDialog(Context context){
        final Dialog dialog = new Dialog(context, android.R.style.ThemeOverlay_Material_Dialog);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialogshow);
        edtName=dialog.findViewById(R.id.edtName);
        edtPhone=dialog.findViewById(R.id.edtPhoneNumber);
        edtAddress=dialog.findViewById(R.id.edtAddress);
        edtDate=dialog.findViewById(R.id.edtDate);
        edtNumber=dialog.findViewById(R.id.edtNumber);
        edtPercent=dialog.findViewById(R.id.edtPercent);
        edtNote=dialog.findViewById(R.id.edtNote);
        btnAdd=dialog.findViewById(R.id.btnAdd);
        btnCancel=dialog.findViewById(R.id.btnCancel);
        imgDate=dialog.findViewById(R.id.imgDate);
        return dialog;
    }

}
