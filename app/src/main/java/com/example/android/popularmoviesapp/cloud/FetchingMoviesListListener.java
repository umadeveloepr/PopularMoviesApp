package com.example.android.popularmoviesapp.cloud;

import com.example.android.popularmoviesapp.schema.MovieSchema;

import java.util.ArrayList;

/**
 * Created by Ahmed Mohamed on 24/8/2016.
 */
public interface FetchingMoviesListListener {

    void OnTaskFinish(ArrayList<MovieSchema> arrayList);


}
