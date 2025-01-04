package com.example.newyearsaroundtheworld;

import static android.app.PendingIntent.FLAG_IMMUTABLE;
import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;
import static android.app.PendingIntent.getActivity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.TimeZone;

public class Broadcast extends BroadcastReceiver{
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        NotificationManager notificationManager1;
        final int notificationID = (int) System.currentTimeMillis();
        final String primaryChannelID = Global.getInstance().getPrimaryChannelID();
        PendingIntent contentPendingIntent1;
        notificationManager1 = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent contentIntent1 = new Intent(context, MainActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            contentPendingIntent1 = getActivity(context, notificationID, contentIntent1, FLAG_UPDATE_CURRENT | FLAG_IMMUTABLE);
            Log.i("Developer", "Content Pending Intent (M).");
        }else{
            contentPendingIntent1 = getActivity(context, notificationID, contentIntent1, FLAG_UPDATE_CURRENT);
            Log.i("Developer", "Content Pending Intent (L).");
        }
        Log.i("Developer", "Notification Received!");
        String notificationTitle = Global.getInstance().getTitle();
        String notificationContent = Global.getInstance().getContent();
        int importance0 = Global.getInstance().getImportance();

        while(calendar.get(Calendar.SECOND) > 53 || calendar.get(Calendar.SECOND) < 5) {
            //Log.i("Developer", "Second: " + calendar.get(Calendar.SECOND));
            if(calendar.get(Calendar.SECOND) < 5) {
                NotificationCompat.Builder builder1 = new NotificationCompat.Builder(context, primaryChannelID)
                        .setSmallIcon(R.drawable.ic_stat_name_notification)
                        .setContentTitle(notificationTitle)
                        .setContentText(notificationContent)
                        .setContentIntent(contentPendingIntent1)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationContent))
                        .setPriority(importance0)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setAutoCancel(true)
                        .setDefaults(NotificationCompat.DEFAULT_ALL);
                if(importance0 <= NotificationCompat.PRIORITY_LOW){
                    builder1.setSilent(true);
                }

                Log.i("Developer", String.valueOf(importance0));
                Log.i("Developer", "Second: " + calendar.get(Calendar.SECOND));
                Log.i("Developer", "Broadcast Built!");
                notificationManager1.notify(notificationID, builder1.build());
                Log.i("Developer", "Broadcast Received!");
                break;
            }

            calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        }
    }
}
