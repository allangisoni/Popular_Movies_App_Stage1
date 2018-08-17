package com.example.android.pendomoviz.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.pendomoviz.R;

public class MovizViewHolder extends RecyclerView.ViewHolder {

    public final ImageView thumbnailImage;

    public MovizViewHolder(View itemView) {
        super(itemView);
        thumbnailImage = itemView.findViewById(R.id.thumbnail_image);

    }
}
