package com.example.android.pendomoviz.activity;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.android.pendomoviz.DetailsMain;
import com.example.android.pendomoviz.Favorites;
import com.example.android.pendomoviz.FavoritesDb;
import com.example.android.pendomoviz.R;
import com.example.android.pendomoviz.ReviewsFragment;
import com.example.android.pendomoviz.model.Moviz;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvTitle, tvReleaseDate, tvDescription, tvRating, tvReviewsTrailers;

    private ImageView ivThumbnail, ivThumbnailBackdrop, ivFavorites;
    private Toolbar toolbar;

    private String backdropPath, posterPath;


    private FavoritesDb favoritesDb;
    Intent intent;

    private  boolean isFavorite;
  //  private ListView listView;

    private String[] values;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        initUIComponents();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setMovieDetails();
        isFavorite = false;


       ivFavorites.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               setFavorite(isFavorite);



               new Thread(new Runnable() {
                   @Override
                   public void run() {


                      /** Favorites favorites = new Favorites();

                       favorites.setName(moviz.getTitle());
                       favorites.setImageUrl(moviz.getPosterPath());
                       FavoritesDb.getAppDatabase(getApplicationContext()).favoritesDao().insertOnlySingleMovie(favorites);
                       **/
                   }
               }).start();
           }
       });


       tvReviewsTrailers.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Moviz moviz = intent.getParcelableExtra("movieDetails");
               Intent intent = new Intent(getApplicationContext(), ReviewsFragment.class);
               intent.putExtra("movieDetails", moviz );

               startActivity(intent);
           }
       });



        values= new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };


    }

    public void setFavorite(Boolean isMovieFavorite){
        if(isMovieFavorite == false){
            ivFavorites.setColorFilter(getResources().getColor(R.color.colorAccent));
            isFavorite = true;
        }
         else{
            ivFavorites.setColorFilter(getResources().getColor(R.color.blue));
            isFavorite = false;

        }
    }


    /**
     * This method will allow us to initialize our views from the xml and assign them to the
     * variables we have created
     */
    private void initUIComponents() {
        intent = getIntent();
        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvDescription = findViewById(R.id.tvDescription);
        ivThumbnail = findViewById(R.id.ivThumbnail);
        tvRating = findViewById(R.id.tvRating);
        ivThumbnailBackdrop = findViewById(R.id.ivThumbnailBackdrop);
        ivFavorites = findViewById(R.id.imageViewFavorite);
        tvReviewsTrailers =  findViewById(R.id.tvReviewsTrailers);




    }

    /**
     * This method will set our views with the content that has been passed
     * from the main activity
     */

    private  void setMovieDetails(){

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
