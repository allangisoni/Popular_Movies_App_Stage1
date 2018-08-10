package com.example.android.pendomoviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.android.pendomoviz.adapter.MovizAdapter;
import com.example.android.pendomoviz.model.Moviz;
import com.example.android.pendomoviz.model.MovizResponse;
import com.example.android.pendomoviz.rest.TMdbApiClient;
import com.example.android.pendomoviz.rest.TMdbApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "7f10a990314c43d89d94b1380199202d";
    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView recyclerView;
    MovizAdapter movizAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initUIComponents();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        int numberOfColumns = 2;
        RecyclerView.LayoutManager layoutmanager = new GridLayoutManager(MainActivity.this, numberOfColumns);
        recyclerView.setLayoutManager(layoutmanager);
        requestMovies();


    }

    private void initUIComponents() {

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rvMoviz);
    }

    private void requestMovies(){

        if(API_KEY == null){
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }


        TMdbApiInterface tMdbApiInterface = TMdbApiClient.getClient().create(TMdbApiInterface.class);

        Call<MovizResponse> call = tMdbApiInterface.getTopratedMovies(API_KEY);
        call.enqueue(new Callback<MovizResponse>() {
            @Override
            public void onResponse(Call<MovizResponse> call, Response<MovizResponse> response) {
                List<Moviz> movizs = response.body().getResults();
                movizAdapter = new MovizAdapter(movizs, getApplicationContext());
                recyclerView.setAdapter(movizAdapter);


                Log.d(TAG, "Number of Movies Received:" +movizs.size() );
            }

            @Override
            public void onFailure(Call<MovizResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
