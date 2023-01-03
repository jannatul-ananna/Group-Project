package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_grid_view);

        GridView gridView = (GridView) findViewById(R.id.grid_image_view);
        gridView.setAdapter(new ImageAdapter(this));
    }
}