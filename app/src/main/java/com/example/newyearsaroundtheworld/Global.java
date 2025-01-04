package com.example.newyearsaroundtheworld;

import android.app.NotificationManager;

import androidx.core.app.NotificationCompat;

public class Global {
    private static Global instance1;
    private String notificationContent = "Not Set!";
    private String notificationTitle = "Not Set!";
    private int importance = NotificationCompat.PRIORITY_HIGH;
    private String primaryChannelID = "";
    private boolean bellPlayed0 = false;
    private boolean notificationSent0 = false;
    private boolean sleepMode0 = false;
    private boolean notificationsOn0 = true;
    private boolean bellOn0 = true;
    private boolean settingsOn0 = false;
    private boolean setNextNewYear = false;
    private String contentNextNewYear0 = "";
    private String contentNextNewYear1 = "";
    private String contentNextNewYear2 = "";
    private String contentNextNewYear3 = "";
    private String contentNote1 = "";
    private String contentNote2 = "";
    private String contentNote3 = "";
    private String contentNote4 = "";
    private boolean callNotifications = false;
    private boolean callBell = false;
    private boolean debug0 = false;
    private int sendNotification = -1;
    private boolean scheduleNotification = false;
    private String currentView = "Main";

    public static Global getInstance(){
        if(instance1 == null){
            instance1 = new Global();
        }
        return instance1;
    }
    private Global(){

    }
    public String getTitle(){
        return notificationTitle;
    }
    public void setTitle(String title1){
        this.notificationTitle = title1;
    }
    public String getContent(){
        return notificationContent;
    }
    public void setContent(String content1){
        this.notificationContent = content1;
    }
    public int getImportance(){
        return importance;
    }
    public void setImportance(int importance1){
        this.importance = importance1;
    }
    public String getPrimaryChannelID(){
        return primaryChannelID;
    }
    public void setPrimaryChannelID(String primaryChannelID2){
        this.primaryChannelID = primaryChannelID2;
    }
    public boolean getBellPlayed(){
        return bellPlayed0;
    }
    public void setBellPlayed(boolean bellPlayed1){
        this.bellPlayed0 = bellPlayed1;
    }
    public boolean getNotificationSent(){
        return notificationSent0;
    }
    public void setNotificationSent(boolean notificationSent1){
        this.notificationSent0 = notificationSent1;
    }
    public boolean getSleepMode(){
        return sleepMode0;
    }
    public void setSleepMode(boolean sleepMode1){
        this.sleepMode0 = sleepMode1;
    }
    public boolean getNotificationsOn(){
        return notificationsOn0;
    }
    public void setNotificationsOn(boolean notificationsOn1){
        this.notificationsOn0 = notificationsOn1;
    }
    public boolean getBellOn(){
        return bellOn0;
    }
    public void setBellOn(boolean bellOn1){
        this.bellOn0 = bellOn1;
    }
    public boolean getSettingsOn(){
        return settingsOn0;
    }
    public void setSettingsOn(boolean settingsOn1){
        this.settingsOn0 = settingsOn1;
    }
    public boolean getNextNewYear(){
        return setNextNewYear;
    }
    public void setNextNewYear(boolean NextNewYear0){
        this.setNextNewYear = NextNewYear0;
    }
    public String getContentNextNewYear0(){
        return contentNextNewYear0;
    }
    public void setContentNextNewYear0(String contentNewYear0){
        this.contentNextNewYear0 = contentNewYear0;
    }
    public String getContentNextNewYear1(){
        return contentNextNewYear1;
    }
    public void setContentNextNewYear1(String contentNewYear1){
        this.contentNextNewYear1 = contentNewYear1;
    }
    public String getContentNextNewYear2(){
        return contentNextNewYear2;
    }
    public void setContentNextNewYear2(String contentNewYear2){
        this.contentNextNewYear2 = contentNewYear2;
    }
    public String getContentNextNewYear3(){
        return contentNextNewYear3;
    }
    public void setContentNextNewYear3(String contentNewYear3){
        this.contentNextNewYear3 = contentNewYear3;
    }
    public String getContentNote1(){
        return contentNote1;
    }
    public void setContentNote1(String contentStringNote1){
        this.contentNote1 = contentStringNote1;
    }
    public String getContentNote2(){
        return contentNote2;
    }
    public void setContentNote2(String contentStringNote2){
        this.contentNote2 = contentStringNote2;
    }
    public String getContentNote3(){
        return contentNote3;
    }
    public void setContentNote3(String contentStringNote3){
        this.contentNote3 = contentStringNote3;
    }
    public String getContentNote4(){
        return contentNote4;
    }
    public void setContentNote4(String contentStringNote4){
        this.contentNote4 = contentStringNote4;
    }
    public boolean getCallNotifications(){
        return callNotifications;
    }
    public void setCallNotifications(boolean notificationsBoolean){
        this.callNotifications = notificationsBoolean;
    }
    public boolean getCallBell(){
        return callBell;
    }
    public void setCallBell(boolean bellBoolean){
        this.callBell = bellBoolean;
    }
    public boolean getDebug0(){
        return debug0;
    }
    public void setDebug0(boolean setDebug0){
        this.debug0 = setDebug0;
    }
    public int getSendNotification(){
        return sendNotification;
    }
    public void setSendNotification(int sendNotification1){
        this.sendNotification = sendNotification1;
    }

    public boolean getScheduleNotification(){
        return scheduleNotification;
    }
    public void setScheduleNotification(boolean scheduleNotification1){
        this.scheduleNotification = scheduleNotification1;
    }
    public String getCurrentView(){
        return currentView;
    }
    public void setCurrentView(String currentView){
        this.currentView = currentView;
    }
}
