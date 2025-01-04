package com.example.newyearsaroundtheworld;

public class switch_values{
    private static switch_values instance1;
    private boolean SleepMode = false;
    private boolean Notifications = true;
    private boolean Bell = true;
    private boolean SleepModeChanged = false;
    public static switch_values getInstance(){
        if(instance1 == null){
            instance1 = new switch_values();
        }
        return instance1;
    }
    private switch_values(){

    }
    public boolean getSleepMode(){
        return SleepMode;
    }
    public void setSleepMode(boolean SleepMode0){
        this.SleepMode = SleepMode0;
    }
    public boolean getNotifications(){
        return Notifications;
    }
    public void setNotifications(boolean Notifications0){
        this.Notifications = Notifications0;
    }
    public boolean getBell(){
        return Bell;
    }
    public void setBell(boolean Bell0){
        this.Bell = Bell0;
    }
    public boolean getSleepModeChanged(){
        return SleepModeChanged;
    }
    public void setSleepModeChanged(boolean SleepModeChanged0){
        this.SleepModeChanged = SleepModeChanged0;
    }
}