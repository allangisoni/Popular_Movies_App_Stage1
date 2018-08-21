package com.example.android.pendomoviz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.android.pendomoviz.R;
import com.example.android.pendomoviz.model.Moviz;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvTitle, tvReleaseDate, tvDescription, tvRating;

    private ImageView ivThumbnail, ivThumbnailBackdrop;
    private Toolbar toolbar;

    private String backdropPath, posterPath;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        initUIComponents();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setMovieDetails();


    }

    /**
     * This method will allow us to initialize our views from the xml and assign them to the
     * variables we have created
     */
    private void initUIComponents() {

        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvDescription = findViewById(R.id.tvDescription);
        ivThumbnail = findViewById(R.id.ivThumbnail);
        tvRating = findViewById(R.id.tvRating);
        ivThumbnailBackdrop = findViewById(R.id.ivThumbnailBackdrop);

    }

    /**
     * This method will set our views with the content that has been passed
     * from the main activity
     */

    private  void setMovieDetails(){

        Intent intent = getIntent();

        Moviz moviz = intent.getParcelableExtra("movieDetails");

        tvTitle.setText(moviz.getTitle());
        tvReleaseDate.setText(moviz.getReleaseDate());
        tvDescription.setText(moviz.getOverview());
        tvRating.setText(moviz.getVoteAverage().toString() +" "+ "/ 10");
        Picasso.with(this).load(moviz.getBackdropPath()).placeholder(R.drawable.mtvmovies).error(R.drawable.imagenotfound3).into(ivThumbnail);
        Picasso.with(this).load(moviz.getPosterPath()).placeholder(R.drawable.mtvmovies).error(R.drawable.imagenotfound).into(ivThumbnailBackdrop);
        backdropPath = moviz.getBackdropPath();
        posterPath = moviz.getPosterPath();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        setMovieDetails();
        outState.putString("title", tvTitle.getText().toString());
        outState.putString("tvReleaseDate", tvReleaseDate.getText().toString());
        outState.putString("description", tvDescription.getText().toString());
        outState.putString("rating", tvRating.getText().toString());
        outState.putString("thumbnail", backdropPath);
        outState.putString("thumbnailBackdrop", posterPath);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        tvTitle.setText(savedInstanceState.getString("title"));
        tvReleaseDate.setText(savedInstanceState.getString("tvReleaseDate"));
        tvDescription.setText(savedInstanceState.getString("description"));
        tvRating.setText(savedInstanceState.getString("rating"));
        Picasso.with(this).load(savedInstanceState.getString("thumbnail")).placeholder(R.drawable.mtvmovies).error(R.drawable.imagenotfound3).into(ivThumbnail);
        Picasso.with(this).load(savedInstanceState.getString("thumbnailBackdrop")).placeholder(R.drawable.mtvmovies).error(R.drawable.imagenotfound).into(ivThumbnailBackdrop);

    }
}
