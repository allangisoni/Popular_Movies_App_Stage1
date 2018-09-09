package com.example.android.pendomoviz.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.pendomoviz.Favorites;
import com.example.android.pendomoviz.R;
import com.example.android.pendomoviz.activity.DetailsActivity;
import com.squareup.picasso.Picasso;

public class FavoritesViewHolder extends RecyclerView.ViewHolder {


    public final ImageView thumbnailImage;

    public FavoritesViewHolder(View itemView) {
        super(itemView);
        thumbnailImage = itemView.findViewById(R.id.thumbnail_image);

    }

    public void bind(final Favorites favoritemovies, final FavoritesAdapter.OnItemClickListener listener) {

        Picasso.with(itemView.getContext()).load(favoritemovies.getImageUrl()).into(thumbnailImage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(favoritemovies);
                Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                intent.putExtra("movieDetails", favoritemovies);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
