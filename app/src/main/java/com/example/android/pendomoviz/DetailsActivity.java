package com.example.android.pendomoviz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pendomoviz.model.Moviz;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvTitle, tvReleaseDate, tvDescription, tvRating;

    private ImageView ivThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initUIComponents();
        setMovieDetails();
    }

    private void initUIComponents() {

        tvTitle = findViewById(R.id.tvTitle);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvDescription = findViewById(R.id.tvDescription);
        ivThumbnail = findViewById(R.id.ivThumbnail);
        tvRating = findViewById(R.id.tvRating);

    }

    private  void setMovieDetails(){
        Intent intent = getIntent();

        Moviz moviz = intent.getParcelableExtra("movieDetails");

        tvTitle.setText(moviz.getTitle().toString());
        tvReleaseDate.setText(moviz.getReleaseDate().toString());
        tvDescription.setText(moviz.getOverview().toString());
        tvRating.setText(moviz.getVoteAverage().toString() +" "+ "/ 10");
        Picasso.with(this).load(moviz.getPosterPath()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(ivThumbnail);

    }
}
