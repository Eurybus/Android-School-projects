package com.eurybus.notificationexample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int notification_ID = 1;
    //Resources res = getResources();
    //Drawable drawable = res.getDrawable(R.drawable.)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LaunchNotification(View view){
        //creating a pending intent to open a web browser
        Intent actionIntent = new Intent(Intent.ACTION_VIEW);
        actionIntent.setData(Uri.parse("http://www.jamk.fi"));
        PendingIntent actionPendingIntent = PendingIntent.getActivity(this, 0 , actionIntent,0);

        //create a new notification
        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Text notification")
                .setContentText("Click here to see our web page")
                .setSmallIcon(R.drawable.ic_accessible_black_24dp)
                .setAutoCancel(true)
                .setContentIntent(actionPendingIntent)
                .setVisibility(Notification.VISIBILITY_PUBLIC).build();
        //connect phone notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //Make a new notification with this  id
        notificationManager.notify(notification_ID,notification);
    }
}
