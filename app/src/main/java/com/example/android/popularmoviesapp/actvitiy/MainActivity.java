package com.example.android.popularmoviesapp.actvitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.android.popularmoviesapp.MovisListener;
import com.example.android.popularmoviesapp.R;
import com.example.android.popularmoviesapp.StaticVar;
import com.example.android.popularmoviesapp.fragments.DetailsFragment;
import com.example.android.popularmoviesapp.fragments.MainFragment;
import com.example.android.popularmoviesapp.schema.MovieSchema;

/**
 * Created by Ahmed Mohamed on 24/8/2016.
 */
public class MainActivity extends AppCompatActivity implements MovisListener {

    Boolean mTowPan;
    StaticVar staticVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staticVar = new StaticVar();
        FrameLayout flpanel2 = (FrameLayout) findViewById(R.id.f_panel_2);
        mTowPan = null != flpanel2;

        if (null == savedInstanceState) {
            MainFragment mainFragment = new MainFragment();
            mainFragment.SetMovieListener(this);


            getSupportFragmentManager().beginTransaction().replace(R.id.f_panel_1, mainFragment).commit();
        }
    }

    @Override
    public void Set_SelectedMovie(MovieSchema movieDtails) {

        if (mTowPan) {
            DetailsFragment dFragment = new DetailsFragment();
            Bundle extra = new Bundle();
            extra.putSerializable(StaticVar.Extra, movieDtails);
            dFragment.setArguments(extra);
            getSupportFragmentManager().beginTransaction().replace(R.id.f_panel_2, dFragment).commit();
        } else {
            Intent i = new Intent(this, DetailsActivity.class);
            i.putExtra(StaticVar.Extra, movieDtails);
            startActivity(i);
        }
    }
}
