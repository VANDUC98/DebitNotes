package com.hdpsolution.debitnotes.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.hdpsolution.debitnotes.R;
import com.hdpsolution.debitnotes.interFace.onItemClickListener;
import com.hdpsolution.debitnotes.model.Data;

public class HolderMoneyTake extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView imgContent;
    public TextView tvTime;
    public TextView tvName;
    public TextView tvNumber;
    public SwipeRevealLayout swipeLayout;
    public View frontLayout;
    public View deleteLayout;
    public View showLayout;
    public onItemClickListener itemClickListener;

    public void setItemClickListener(onItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public HolderMoneyTake(View itemView) {
        super(itemView);
        imgContent = (ImageView) itemView.findViewById(R.id.img_content);
        tvTime = (TextView) itemView.findViewById(R.id.tv_time);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvNumber = (TextView) itemView.findViewById(R.id.tvNumber);
        swipeLayout = (SwipeRevealLayout) itemView.findViewById(R.id.swipe_layout);
        frontLayout = itemView.findViewById(R.id.front_layout);
        deleteLayout = itemView.findViewById(R.id.delete_layout);
        showLayout=itemView.findViewById(R.id.show_layout);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onItemClick(v,getAdapterPosition());
    }
}
