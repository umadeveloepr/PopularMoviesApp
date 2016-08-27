package com.example.android.popularmoviesapp.actvitiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.popularmoviesapp.R;
import com.example.android.popularmoviesapp.fragments.DetailsFragment;

/**
 * Created by Ahmed Mohamed on 24/8/2016.
 */
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction().add(R.id.Detalis_frame_layout, new DetailsFragment()).commit();
        }
    }
}
