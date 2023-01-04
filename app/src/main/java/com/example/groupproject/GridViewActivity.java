package com.example.groupproject;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Button;
import android.view.View;



public class GridViewActivity extends AppCompatActivity {
    Button btnGridNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_grid_view);

        GridView gridview = (GridView) findViewById(R.id.grid_image_view);
        gridview.setAdapter(new ImageAdapter(this));

        //Action to SingleView
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id){
                // Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
                // Pass image index
                i.putExtra("id", position);
                startActivity(i);
            }
        });

        //Action to table
        btnGridNext = findViewById(R.id.next_from_grid);
        btnGridNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTabView();
            }
        });
    }

    public void openTabView(){
        Intent opentab = new Intent(getApplicationContext(),TableViewActivity.class);
        startActivity(opentab);
    }
}