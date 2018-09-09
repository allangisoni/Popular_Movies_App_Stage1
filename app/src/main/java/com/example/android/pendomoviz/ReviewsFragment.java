package com.example.android.pendomoviz;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.pendomoviz.model.Moviz;
import com.example.android.pendomoviz.model.Reviews;

public class ReviewsFragment extends Fragment {

    private ListView listView;

public ReviewsFragment(){

}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View rootView = inflater.inflate(R.layout.activity_reviews_fragment, container, false);

        initViews(rootView);

        Intent intent  = getActivity().getIntent();

        Moviz moviz = intent.getParcelableExtra("movieDetails");

        Reviews myReviews = moviz.getReviews();

        String[] values= new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };
        ArrayAdapter<String> reviewsAdapter = new ArrayAdapter<String>(getContext(),R.layout.reviewslistview, R.id.tvReviewslist, myReviews.getContent());
        //reviewsAdapter.notifyDataSetChanged();
        listView.setAdapter(reviewsAdapter);


        return rootView;

    }
   public void initViews(View rootView) {


       listView = rootView.findViewById(R.id.detail_reviews);

   }
}
