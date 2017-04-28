package com.example.androidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {
    public String joke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        joke = getExtraFromIntent();
    }

    @Override
    protected void onStart() {
        TextView textView = (TextView) findViewById(R.id.jokes_view);
        textView.setText(joke);
        super.onStart();

    }

    public String getExtraFromIntent(){
        Bundle bundle = getIntent().getExtras();
        return bundle.getString("joke");
    }

}
