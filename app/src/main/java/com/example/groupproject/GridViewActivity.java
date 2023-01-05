package com.example.groupproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Button;
import android.view.View;

import java.util.Timer;

import kotlinx.coroutines.Delay;


public class GridViewActivity extends AppCompatActivity {
    Button btnGridNext;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_grid_view);

        GridView gridview = (GridView) findViewById(R.id.grid_image_view);
        gridview.setAdapter(new ImageAdapter(this));

        //Action to SingleView
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
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
                callGridNoti();
            }
        });
    }

    public void openTabView() {
        Intent opentab = new Intent(getApplicationContext(), TableViewActivity.class);
        startActivity(opentab);
    }

    public void callGridNoti() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("com.example.groupproject",
                    "Group Project", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(GridViewActivity.this,
                    "com.example.groupproject");
            Notification notification = builder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("This is Table view")
                    .setPriority(NotificationManager.IMPORTANCE_HIGH)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .build();
            notificationManager.notify(0, notification);
            new CountDownTimer(10000, 100) {
                @Override
                public void onTick(long l) {
                }
                public void onFinish() {
                    notificationManager.cancel(0);
                }
            }.start();
        }
    }
}