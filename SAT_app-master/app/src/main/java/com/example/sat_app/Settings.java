package com.example.sat_app;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.preference.PreferenceFragmentCompat;

public class Settings extends AppCompatActivity {

    /*
    * The Bellow code does not compile
    * So I commented it out
    * -Liang July-14-2020
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.settings_activity);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.settings, new SettingsFragment())
//                .commit();
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }


//    public static class SettingsFragment extends PreferenceFragmentCompat {
////        @Override
////        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
////            setPreferencesFromResource(R.xml.root_preferences, rootKey);
////        }
//    }
}
