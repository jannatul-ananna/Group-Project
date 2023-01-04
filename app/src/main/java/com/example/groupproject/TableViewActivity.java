package com.example.groupproject;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class TableViewActivity extends AppCompatActivity {

    Button btnTabNext, btnTabBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_table);

        //Action to Animation
        btnTabNext = findViewById(R.id.button_table_next);
        btnTabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnimation();

            }
        });

        //Action to Image
        btnTabBack = findViewById(R.id.button_table_back);
        btnTabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageView();
                //createNotif();
            }
        });

    }

    public void openAnimation(){
        Intent openAnim = new Intent(getApplicationContext(),AnimActivity.class);
        startActivity(openAnim);
    }

    public void openImageView(){
        Intent openImage =  new Intent(getApplicationContext(),Image_view.class);
        startActivity(openImage);
    }

   /* private void createNotif()
    {
        String id= "my_channel_id_01";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = manager.getNotificationChannel(id);
            if (channel == null)
            {
                channel = new NotificationChannel(id,"Channel Title" , NotificationManager.IMPORTANCE_HIGH);
                //notification channel
                channel.setDescription("[Channel description]");
                channel.enableVibration(true);
                channel.setVibrationPattern(new long [] {100,1000,200,340});
                channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                manager.createNotificationChannel(channel);
            }
        }

        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.bg))
                        .bigLargeIcon(null))
                .setContentTitle("Title")
                .setContentText("You are in Grid Layout")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{100,1000,200,340})
                .setAutoCancel(false)
                .setTicker("Notification");
        builder.setContentIntent(contentIntent);
        NotificationManagerCompat m = NotificationManagerCompat.from(getApplicationContext());
        m.notify(1,builder.build());




    }*/
}
