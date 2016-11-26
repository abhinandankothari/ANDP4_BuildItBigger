package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.abhinandankothair.jokesbackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class FetchJokes extends AsyncTask<Void, Void, String> {

    private JokesCallback jokesCallback = null;
    private MyApi myApiService = null;

    FetchJokes(JokesCallback jokesCallback) {
        this.jokesCallback = jokesCallback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://andp4-builditbigger.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        jokesCallback.onSuccess(result);
    }
}
