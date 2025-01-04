package com.example.newyearsaroundtheworld;

import static androidx.core.app.NotificationCompat.*;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import androidx.core.app.NotificationCompat;


public class NotificationChannel {
    public static void setNotification(Context context1, String title0, String content0, int importance2, long delay1, String primaryChannelID0){
        Global.getInstance().setContent(content0);
        Global.getInstance().setTitle(title0);
        Global.getInstance().setImportance(importance2);
        Global.getInstance().setPrimaryChannelID(primaryChannelID0);

        Handler handler1 = new Handler();
        Log.i("Developer", "Notification Started Running!");
        handler1.postDelayed(new Runnable(){
            @Override
            public void run(){
                PendingIntent pendingIntent1;
                Intent intent0 = new Intent(context1, Broadcast.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    pendingIntent1 = PendingIntent.getBroadcast(context1, 0, intent0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                    Log.i("Developer", "Pending Intent Created (M).");
                }else{
                    pendingIntent1 = PendingIntent.getBroadcast(context1, 0, intent0, PendingIntent.FLAG_UPDATE_CURRENT);
                    Log.i("Developer", "Pending Intent Created (L).");
                }
                AlarmManager alarmManager1 = (AlarmManager) context1.getSystemService(Context.ALARM_SERVICE);
                alarmManager1.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()  + delay1, pendingIntent1);
                Log.i("Developer", "Notification Running!");
            }
        }, 1000);
    }
    public static void createNotificationChannel(Context context, String channel_id, int importance, CharSequence name, String description1, int channel){
        Log.i("Information", "createNotificationChannel: Notification Channel Started Being Created!");
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(channel == 1) {
                android.app.NotificationChannel channel1 = new android.app.NotificationChannel(channel_id, name, importance);
                /*
                Uri sound1 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                AudioAttributes audioAttribute1 = new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build();
                Log.i("Developer", String.valueOf(importance >= PRIORITY_DEFAULT));
                if(importance >= PRIORITY_DEFAULT) {
                    channel1.setSound(sound1, audioAttribute1);
                }
                 */
                channel1.setDescription(description1);
                channel1.enableVibration(false);
                channel1.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                NotificationManager notificationManager1 = context.getSystemService(NotificationManager.class);
                notificationManager1.createNotificationChannel(channel1);
                Log.i("Developer", "createNotificationChannel: Notification Channel Created!");
                Log.i("Developer", String.valueOf(channel));
                Log.i("Developer", channel1.getId());
                Log.i("Developer", String.valueOf(channel1.getName()));
                Log.i("Developer", String.valueOf(channel1.getDescription()));
                Log.i("Developer", String.valueOf(channel1.getImportance()));
            }else if(channel == 2) {
                android.app.NotificationChannel channel2 = new android.app.NotificationChannel(channel_id, name, importance);
                /*Uri sound2 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                AudioAttributes audioAttribute2 = new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build();
                Log.i("Developer", String.valueOf(importance >= PRIORITY_DEFAULT));
                if(importance >= PRIORITY_DEFAULT) {
                    channel2.setSound(sound2, audioAttribute2);
                }
                 */
                channel2.setDescription(description1);
                channel2.enableVibration(true);
                channel2.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                NotificationManager notificationManager2 = context.getSystemService(NotificationManager.class);
                notificationManager2.createNotificationChannel(channel2);
                Log.i("Developer", "createNotificationChannel: Notification Channel Created!");
                Log.i("Developer", String.valueOf(channel));
                Log.i("Developer", channel2.getId());
                Log.i("Developer", String.valueOf(channel2.getName()));
                Log.i("Developer", String.valueOf(channel2.getDescription()));
                Log.i("Developer", String.valueOf(channel2.getImportance()));
            }else if(channel == 3) {
                android.app.NotificationChannel channel3 = new android.app.NotificationChannel(channel_id, name, importance);
                /*Uri sound3 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                AudioAttributes audioAttribute3 = new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build();
                Log.i("Developer", String.valueOf(importance >= PRIORITY_DEFAULT));
                if(importance >= PRIORITY_DEFAULT) {
                    channel3.setSound(sound3, audioAttribute3);
                }

                 */
                channel3.setDescription(description1);
                channel3.enableVibration(true);
                channel3.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                NotificationManager notificationManager3 = context.getSystemService(NotificationManager.class);
                notificationManager3.createNotificationChannel(channel3);
                Log.i("Developer", "createNotificationChannel: Notification Channel Created!");
                Log.i("Developer", String.valueOf(channel));
                Log.i("Developer", channel3.getId());
                Log.i("Developer", String.valueOf(channel3.getName()));
                Log.i("Developer", String.valueOf(channel3.getDescription()));
                Log.i("Developer", String.valueOf(channel3.getImportance()));
            }
        }
    }
}
