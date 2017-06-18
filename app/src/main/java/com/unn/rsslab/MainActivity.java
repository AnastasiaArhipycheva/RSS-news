package com.unn.rsslab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        String theme = "";
        if(v.getId() == R.id.sport)
            theme = "sport";
        else if(v.getId() == R.id.business)
            theme = "business";
        else if(v.getId() == R.id.music)
            theme = "music";
        else if(v.getId() == R.id.politics)
            theme = "politics";
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("theme", theme);
        startActivity(intent);
    }
}
