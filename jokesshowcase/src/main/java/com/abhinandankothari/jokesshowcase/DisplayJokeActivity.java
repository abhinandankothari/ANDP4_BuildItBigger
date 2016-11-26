package com.abhinandankothari.jokesshowcase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        TextView textView = (TextView) findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.getString("joke"));
    }
}
