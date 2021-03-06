package com.rahul0596.quakealert;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String themes = sharedPrefs.getString(
                getString(R.string.settings_themes_key),
                getString(R.string.settings_themes_default));
        switch (themes) {
            case "dark":
                setTheme(R.style.AppTheme);
                break;
            case "light":
                setTheme(R.style.AppTheme_Light);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void rahul(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rahulprabhakar.ml/"));
        startActivity(intent);
    }

    public void mervin(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.behance.net/mervinin97e9f7"));
        startActivity(intent);
    }

    public void rateUs(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rahul0596.quakealert"));
        startActivity(intent);
    }

    public void feedback(View view) {
        String email = "rahulprabhakar0596@gmail.com";
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback on Quake Alert");

        startActivity(Intent.createChooser(emailIntent, "Feedback"));
    }
}
