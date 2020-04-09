package com.example.newsignin;


import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static com.example.newsignin.app.FCM_CHANNEL_ID;
import static com.example.newsignin.app.FCM_CHANNEL_ID;


public class FCMMessageRecieverService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("MyTag", "onMessageReceived: called");

        Log.d("MyTag", "onMessageReceived: Message recieved from: "+remoteMessage.getFrom());

        if(remoteMessage.getNotification()!=null){
            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();

            Notification notification=new NotificationCompat.Builder(this,FCM_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_sms_black)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setColor(Color.BLUE)
                    .build();

            NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1002,notification);

        }

        if(remoteMessage.getData().size()>0){

            Log.d("My Tag","onMessageReceived: Data: "+remoteMessage.getData().toString());
        }


    }


    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();

        Log.d("MyTag", "onDeletedMessages: called");
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("MyTag","onNewToken: called");
    }
}


