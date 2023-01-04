package com.example.groupproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class AnimActivity extends Activity {

    ImageView imageView;
    Button btnClockWise, btnFade, btnMove, btnZoom, btnBlink, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        //All Button
        btnClockWise = findViewById(R.id.clockwise_button);
        btnFade = findViewById(R.id.fade_button);
        btnMove = findViewById(R.id.move_button);
        btnZoom = findViewById(R.id.zoom_button);
        btnBlink = findViewById(R.id.zoom_button);
        btnStop = findViewById(R.id.stop_ani_button);
        //Image
        imageView = findViewById(R.id.anim_image);

        //Animation Clockwise
        btnClockWise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation clockWiseRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                imageView.startAnimation(clockWiseRotation);
            }
        });



    }
}