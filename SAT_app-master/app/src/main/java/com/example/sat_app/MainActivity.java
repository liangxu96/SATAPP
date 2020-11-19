package com.example.sat_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView test;
    private ImageView practice;
    private ImageView settings;
    private ImageView statistics;
//    private Button bookmark;
//    private Button history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = findViewById(R.id.MM_TestMode);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTestMode();
            }
        });

        practice = findViewById(R.id.MM_PracticeMode);
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPracticeMode();
            }
        });

        settings = findViewById(R.id.MM_Settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        statistics = findViewById(R.id.MM_Stats);
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStatistics();
            }
        });

//        bookmark = (Button) findViewById(R.id.bookmark);
//        bookmark.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openBookmark();
//            }
//        });
//
//        history = (Button) findViewById(R.id.history);
//        history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openHistory();
//            }
//        });
    }

    public void openTestMode() {
        Intent intent = new Intent(this, PracticeMode.class);
        startActivity(intent);
    }

    public void openPracticeMode() {
        Intent intent = new Intent(this, PracticeMode.class);
        startActivity(intent);
    }

    public void openSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openStatistics() {
        Intent intent = new Intent(this, Statistics.class);
        startActivity(intent);
    }

    public void openBookmark() {
        Intent intent = new Intent(this, Bookmark.class);
        startActivity(intent);
    }

    public void openHistory() {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

}