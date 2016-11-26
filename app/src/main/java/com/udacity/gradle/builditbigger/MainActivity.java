package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.abhinandankothari.jokesshowcase.DisplayJokeActivity;


public class MainActivity extends ActionBarActivity{
    private static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        FetchJokes fetchJokes = new FetchJokes(new JokesCallback() {
            @Override
            public void onSuccess(String joke) {
                Intent intent = new Intent(MainActivity.this, DisplayJokeActivity.class);
                intent.putExtra(JOKE, joke);
                startActivity(intent);
            }
        });
        fetchJokes.execute();
        //Toast.makeText(MainActivity.this, "Cannot Connect to Server to fetch Joke, Try again or Check your Internet", Toast.LENGTH_LONG).show();
    }
}