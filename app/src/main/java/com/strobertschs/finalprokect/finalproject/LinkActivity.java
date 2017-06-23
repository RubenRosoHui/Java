package com.strobertschs.finalprokect.finalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
    }
    public void sixWays (View view) {
        goToUrl ( "https://www.nrdc.org/stories/6-ways-you-can-help-keep-our-water-clean/");
        Log.i("info", "The user opened the first link");
    }

    public void wasteOil (View view) {
        goToUrl ( "https://www.scientificamerican.com/article/how-to-keep-waste-oil-out/");
        Log.i("info", "The user opened the second link");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}




