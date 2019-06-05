package com.vistalis.computerdictionary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vistalis.computerdictionary.DatabaseModules.DB;
import com.vistalis.computerdictionary.Helpers.SharedPref;
import com.vistalis.computerdictionary.Repositories.WordRepository;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if  ( !SharedPref.getSharedPreferenceBoolean(this,"is_splash_open",false) ) {
            new insertWords(SplashActivity.this).execute();
        } else {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    private class insertWords extends AsyncTask<Void , Integer , Void> {
        //asyc task insert all questions
        private WeakReference<SplashActivity> activityReference;

        // only retain a weak reference to the activity
        insertWords(SplashActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... voids) {
            WordRepository.insertAllWords(getApplicationContext());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) { // redirect if finish
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}
