package com.example.android.popularmoviesapp.cloud;

import android.os.AsyncTask;

import com.example.android.popularmoviesapp.StaticVar;
import com.example.android.popularmoviesapp.jsonParsing.JsonParser;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ahmed Mohamed on 24/8/2016.
 */
public class FetchingMoviesList extends AsyncTask<String, Void, String> {
    StaticVar staticVar = new StaticVar();
    JsonParser parser = new JsonParser();
    private FetchingMoviesListListener fetchMoviesListListener;

    public void setTaskListener(FetchingMoviesListListener fetchMoviesListListener) {
        this.fetchMoviesListListener = fetchMoviesListListener;
    }

    protected String doInBackground(String... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String forecastJsonStr = null;

        try {

            URL url = new URL(StaticVar.BASE_URI + params[0] + StaticVar.Fetch_S + StaticVar.API_KEY);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {

                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            forecastJsonStr = buffer.toString();

            return forecastJsonStr;
        } catch (IOException e) {

            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                }
            }
        }
    }

    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);
        try {
            parser.JsonData(s);
            fetchMoviesListListener.OnTaskFinish(parser.JsonData(s));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
