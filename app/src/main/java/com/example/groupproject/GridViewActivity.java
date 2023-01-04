package com.example.groupproject;

import android.app.Activity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Button;
import android.view.View;


public class GridViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_grid_view);

        GridView gridview = (GridView) findViewById(R.id.grid_image_view);
        gridview.setAdapter(new ImageAdapter(this));
    }
}