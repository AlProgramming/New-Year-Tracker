package com.example.newyearsaroundtheworld;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.TimeZone;

public class NotificationSchedulerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Global.getInstance().setDebug0(true);
        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        int month = calendar1.get(Calendar.MONTH);
        int day = calendar1.get(Calendar.DATE);
        int hour = calendar1.get(Calendar.HOUR_OF_DAY);
        int minute = calendar1.get(Calendar.MINUTE);
        int second = calendar1.get(Calendar.SECOND);
        //int millisecond = calendar1.get(Calendar.MILLISECOND);
        //boolean noNewYear = false;

        System.out.println("Hour: " + hour + " Minute: " + minute + " Second: " + second);
        Log.i("Information", "Time since epoch: " + calendar1.getTimeInMillis());
        Log.i("Developer", "Notification Running!!!");


        if(!Global.getInstance().getNotificationSent()) {
            if (month == 11 && day == 31) {
                if (second % 10 == 4) {
                    Log.i("Developer", "Notification Running!!!");
                }
                //On New Year notification.
                if (hour == 9 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+14!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 14) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+13:45!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+13!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 11 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+12!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 12 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+11!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 13 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+10:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 13 && minute == 59) {
                /*Log.i("Developer", String.valueOf(notificationSent));
                Log.i("Developer", String.valueOf(hour == 14 && minute == 0 && second == 0));
                Log.i("Developer", String.valueOf(hour == 14 && minute == 30 && second == 0)); */
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+10!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                    //Log.i("Developer", String.valueOf(notificationSent));
                } else if (hour == 14 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+9:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 14 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+9!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 15 && minute == 14) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+8:45!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 15 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+8!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 16 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+7!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 17 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+6:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 17 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+6!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 14) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+5:45!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+5:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+5!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 19 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+4:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 19 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+4!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 20 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+3:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 20 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+3!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 21 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+2!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 22 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC+1!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 23 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                    //1 minute before notification.
                } else if (hour == 9 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+14!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 13) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+13:45!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+13!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 11 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+12!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 12 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+11!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 13 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+10:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 13 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+10!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 14 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+9:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 14 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+9!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 15 && minute == 13) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+8:45!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 15 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+8!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 16 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+7!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 17 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+6:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 17 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+6!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 13) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+5:45!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+5:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+5!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 19 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+4:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 19 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+4!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 20 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+3:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 20 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+3!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 21 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+2!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 22 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC+1!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 23 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                    //5 minutes before notification.
                } else if (hour == 9 && minute == 54) {
                    //Log.i("Developer", "If statement true.");
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+14!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 9) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+13:45!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+13!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 11 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+12!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 12 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+11!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 13 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+10:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 13 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+10!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 14 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+9:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 14 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+9!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 15 && minute == 9) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+8:45!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 15 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+8!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 16 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+7!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 17 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+6:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 17 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+6!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 9) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+5:45!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+5:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 18 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+5!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 19 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+4:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 19 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+4!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 20 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+3:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 20 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+3!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 21 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+2!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 22 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC+1!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 23 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                }
            } else if (month == 0 && day == 1) {
                //On New Year notification.
                if (hour == 0 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-1!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 1 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-2!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 2 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-3!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 3 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-3:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 3 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-4!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 4 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-5!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 5 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-6!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 6 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-7!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 7 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-8!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 8 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-9!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 9 && minute == 29) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-9:30!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 9 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-10!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-11!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 11 && minute == 59) {
                    NotificationChannel.createNotificationChannel(context, "channelID1", NotificationManager.IMPORTANCE_LOW, "notificationChannel1", "newYear1", 1);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "A new year just occurred in UTC-12!", NotificationCompat.PRIORITY_LOW, 0, "channelID1");
                    Global.getInstance().setNotificationSent(true);
                    //1 minute before notification.
                } else if (hour == 0 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-1!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 1 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-2!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 2 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-3!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 3 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-3:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 3 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-4!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 4 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-5!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 5 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-6!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 6 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-7!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 7 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-8!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 8 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-9!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 9 && minute == 28) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-9:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 9 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-10!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-11!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 11 && minute == 58) {
                    NotificationChannel.createNotificationChannel(context, "channelID2", NotificationManager.IMPORTANCE_HIGH, "notificationChannel2", "newYear2", 2);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 1 minute, a new year will occur in UTC-12!", NotificationCompat.PRIORITY_HIGH, 0, "channelID2");
                    Global.getInstance().setNotificationSent(true);
                    //5 minutes before notification.
                } else if (hour == 0 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-1!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 1 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-2!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 2 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-3!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 3 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-3:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 3 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-4!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 4 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-5!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 5 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-6!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 6 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-7!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 7 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-8!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 8 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-9!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 9 && minute == 24) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-9:30!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 9 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-10!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 10 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-11!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                } else if (hour == 11 && minute == 54) {
                    NotificationChannel.createNotificationChannel(context, "channelID3", NotificationManager.IMPORTANCE_HIGH, "notificationChannel3", "newYear3", 3);
                    NotificationChannel.setNotification(context, "New Year Around the World!", "In 5 minutes, a new year will occur in UTC-12!", NotificationCompat.PRIORITY_HIGH, 0, "channelID3");
                    Global.getInstance().setNotificationSent(true);
                }
            }
        }
    }
}
