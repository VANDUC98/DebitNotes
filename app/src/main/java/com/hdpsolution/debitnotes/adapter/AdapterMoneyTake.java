package com.hdpsolution.debitnotes.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hdpsolution.debitnotes.Database.DatabaseHelper;
import com.hdpsolution.debitnotes.Detail;
import com.hdpsolution.debitnotes.R;
import com.hdpsolution.debitnotes.model.Data;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterMoneyTake extends RecyclerView.Adapter<HolderMoneyTake>{
    private Context mContext;
    private ArrayList<Data> mDatas;
    private LayoutInflater mInflater;
    private DatabaseHelper databaseHelper;
    public AdapterMoneyTake(Context Context,ArrayList<Data> data) {
        this.mDatas = data;
        this.mContext = Context;
        mInflater=LayoutInflater.from(Context);
    }

    @NonNull
    @Override
    public HolderMoneyTake onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_item_lst,parent,false);
        return new HolderMoneyTake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderMoneyTake holder, final int position) {
        databaseHelper=new DatabaseHelper(mContext);
        holder.tvTime.setText(mDatas.get(position).getDate());
        holder.tvName.setText(mDatas.get(position).getName());
        holder.tvNumber.setText(String.valueOf(mDatas.get(position).getNumber()));
        holder.deleteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data=mDatas.get(holder.getAdapterPosition());
                mDatas.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                databaseHelper.deleteMoney(data);
            }
        });
        holder.showLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data data=mDatas.get(holder.getAdapterPosition());
                Intent intent=new Intent(mContext, Detail.class);
                intent.putExtra("object",data);
                //intent.putExtra("postion",String.valueOf(holder.getAdapterPosition()));
                mContext.startActivity(intent);
            }
        });
        holder.frontLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mDatas.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
