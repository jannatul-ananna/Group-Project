package com.example.groupproject;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class AnimActivity extends AppCompatActivity {

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
        btnBlink = findViewById(R.id.blink_button);
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

        //Animation Fade
        btnFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation fadeAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                imageView.startAnimation(fadeAnim);
            }
        });

        //Animation Move
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation moveAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                imageView.startAnimation(moveAnim);
            }
        });

        //Animation Zoom
        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation zoomAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
                imageView.startAnimation(zoomAnim);
            }
        });

        //Animation Blink
        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation blinkAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                imageView.startAnimation(blinkAnim);
            }
        });

        //Stop Animation
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.clearAnimation();
            }
        });

    }
}