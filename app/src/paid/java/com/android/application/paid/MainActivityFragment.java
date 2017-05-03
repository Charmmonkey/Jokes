package com.android.application.paid;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.androidlibrary.JokesActivity;
import com.udacity.gradle.builditbigger.AsyncResponse;
import com.udacity.gradle.builditbigger.JokesAsyncTask;
import com.udacity.gradle.builditbigger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements AsyncResponse, View.OnClickListener {
    private ProgressBar progressBar;
    private static String retrievedJoke;

    public MainActivityFragment() {
    }

    @Override
    public void processFinish(String result) {
        retrievedJoke = result;
        startJokesActivity();
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {
        progressBar.setVisibility(View.VISIBLE);

        JokesAsyncTask jokesAsyncTask = new JokesAsyncTask(this);
        jokesAsyncTask.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        progressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);


        Button button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(this);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void startJokesActivity() {
        Intent jokesIntent = new Intent(getContext(), JokesActivity.class).putExtra("joke", retrievedJoke);
        startActivity(jokesIntent);
    }
}