package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This Listener Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnImage = findViewById(R.id.button_image);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Go To New page for viewing image", Toast.LENGTH_SHORT).show();

                //Calling Image_view.java
                Intent imageView = new Intent(getApplicationContext(), ImageView.class);
                startActivity(imageView);
            }
        });

        /*GridView gridView = (GridView) findViewById(R.id.grid_image_view);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                Intent i = new Intent(getApplicationContext(),SingleViewActivity.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });*/
    }
}