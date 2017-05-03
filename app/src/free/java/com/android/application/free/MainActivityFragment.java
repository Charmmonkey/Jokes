package com.android.application.free;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.androidlibrary.JokesActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.AsyncResponse;
import com.udacity.gradle.builditbigger.JokesAsyncTask;
import com.udacity.gradle.builditbigger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements AsyncResponse, View.OnClickListener {
    private ProgressBar progressBar;
    private InterstitialAd mInterstitialAd;
    private static String retrievedJoke;
    private AdView mAdView;

    public MainActivityFragment() {
    }

    @Override
    public void processFinish(String result) {
        retrievedJoke = result;

    }

    @Override
    public void onClick(View v) {
        progressBar.setVisibility(View.VISIBLE);

        JokesAsyncTask jokesAsyncTask = new JokesAsyncTask(this);
        jokesAsyncTask.execute();

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            Log.d("MainActivityFragment", "ad loaded");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."


        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                super.onAdClosed();

                startJokesActivity();
                progressBar.setVisibility(View.GONE);

            }
        });
        requestNewInterstitial();

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

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);
        Log.d("MainActivityFragment", "ad requested");

    }

    private void startJokesActivity() {
        Intent jokesIntent = new Intent(getContext(), JokesActivity.class).putExtra("joke", retrievedJoke);
        startActivity(jokesIntent);
    }
}