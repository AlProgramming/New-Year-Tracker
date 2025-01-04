package com.example.newyearsaroundtheworld;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    File folder1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //API minimum used to be 16 and 19
        //Went from 19 to 23 due to Alarm Manager Requirements
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSetUp();
        setTextView();
        setBellFunction();
        setNotificationsFunction();
        //newYear();
        runNewYear();
        /*File directory = getFilesDir();
        Log.i("Developer", "Files: " + directory.listFiles());
        File fileToDelete = new File(directory, "debugFile1.txt");
        boolean deleteFile = deleteFile("debugFile1.txt");
        Log.i("Developer", "File Deleted: " + deleteFile);
        Log.i("Developer", "Files: " + directory.listFiles());*/
        /*File settingsFile = new File("settingsData.txt");
        try{
            Scanner scanner1 = new Scanner(settingsFile);
            while(scanner1.hasNextLine()){
                String lines = scanner1.nextLine();
                Log.i("Developer", lines);
            }
        }catch(IOException error){
            Log.e("Developer", "An Error Occurred During This Process");
            error.printStackTrace();
        }
        */
        Context context = getApplicationContext();
        createPersistentFile(folder1, "settingsData.txt");
        writeToPersistentFile(folder1, "settingsData.txt", "Off\nOn\nOn");
        //readFromPersistentFile(context, "settingsData.txt");
        /*String[] files = context.fileList();
        Log.i("Developer", String.valueOf(files.length));
        for (int i = 0; i < files.length; i++) {
            Log.i("Developer", "Value of i: " + String.valueOf(i));
            Log.i("Developer", "File: " + files[i]);
            Log.i("Developer", "");
        }*/
        newYear();
        reloadTextView();
    }

    public void logDebugFile(String file, String content, int month, int day, int hour, int minute, int second, int millisecond){
        String minuteString = (minute < 10) ? "0" + minute : "" + minute;
        String secondString = (second < 10) ? "0" + second : "" + second;
        String millisecondString = (millisecond < 10) ? "00" + millisecond : (millisecond < 100) ? "0" + millisecond : "" + millisecond;
        addToPersistentFile(folder1, file, content + (month + 1) + "/" + day + " " + hour + ":" + minuteString + ":" + secondString + "." + millisecondString);
    }

    public void runNewYear(){
        final TextView NextNewYear0 = findViewById(R.id.nextNewYear0);
        final TextView NextNewYear1 = findViewById(R.id.nextNewYear1);
        final TextView NextNewYear2 = findViewById(R.id.nextNewYear2);
        final TextView NextNewYear3 = findViewById(R.id.nextNewYear3);
        final TextView Note1 = findViewById(R.id.note1);
        final TextView Note2 = findViewById(R.id.note2);
        final TextView Note3 = findViewById(R.id.note3);
        final TextView Note4 = findViewById(R.id.note4);

        Context context1 = getApplicationContext();
        PowerManager powerManager1 = (PowerManager) context1.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock1 = powerManager1.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"NewYear:WakeTag1");

        /*createPersistentFile(folder1, "debugFile1.txt");
        addToPersistentFile(folder1, "debugFile1.txt", "\nNew Run:\n");

        createPersistentFile(folder1, "debugFile2.txt");
        addToPersistentFile(folder1, "debugFile2.txt", "\nNew Run:\n");*/

        final Handler handler4 = new Handler();
        handler4.post(new Runnable() {
            @Override
            public void run() {
                Calendar newYearCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                int month = newYearCalendar.get(Calendar.MONTH);
                int day = newYearCalendar.get(Calendar.DATE);
                int hour = newYearCalendar.get(Calendar.HOUR_OF_DAY);
                int minute = newYearCalendar.get(Calendar.MINUTE);
                int second = newYearCalendar.get(Calendar.SECOND);
                int millisecond = newYearCalendar.get(Calendar.MILLISECOND);

                if(millisecond >= 0 && millisecond < 200) {
                    Log.i("Information", "Date and Time: " + (month + 1) + " " + day + " " + hour);
                    /*Log.i("Information", "New Year Supposed to Run: " + ((month == 11 && day == 31 && hour >= 9) || (month == 0 && day == 1 && hour <= 12)));
                    //Log.i("Information", "Is Service Running: " + isServiceRunning(NewYearService.class));
                    Log.i("Information", "Context: " + getApplicationContext());
                    Log.i("Information", "New Year 0 Value: " + NextNewYear0.getText());
                    Log.i("Information", "New Year 1 Value: " + NextNewYear1.getText());*/
                }

                //Note1.setText("Is Service Running: " + isServiceRunning(NewYearService.class));
                //Note1.setText("Last Call For Notification: " + month + "/" + day + " " + hour + ":" + minute + ":" + second);
                /*if((hour == 9 && minute == 54 && second == 54 && !Global.getInstance().getSleepMode() && !Global.getInstance().getNotificationSent() && Global.getInstance().getNotificationsOn())){
                    Note1.setText("Is Service Running: " + isServiceRunning(NewYearService.class));
                    //Note2.setText("Last 5 minute notification: " "Time for 5 minute notification to run: " + month + "/" + day + " " + hour + ":" + minute + ":" + second);
                }

                if((hour == 9 && minute == 58 && second == 54 && !Global.getInstance().getSleepMode() && !Global.getInstance().getNotificationSent() && Global.getInstance().getNotificationsOn())){
                    Note2.setText("Is Service Running: " + isServiceRunning(NewYearService.class));
                    //Note3.setText("Last 1 minute notification: " "Time for 1 minute notification to run: " + month + "/" + day + " " + hour + ":" + minute + ":" + second);
                }

                if((hour == 9 && minute == 59 && second == 54 && !Global.getInstance().getSleepMode() && !Global.getInstance().getNotificationSent() && Global.getInstance().getNotificationsOn())){
                    Note3.setText("Is Service Running: " + isServiceRunning(NewYearService.class));
                    //Note4.setText("On New Year notification: " "Time for on New Year notification to run: " + month + "/" + day + " " + hour + ":" + minute + ":" + second);
                }*/

                if((month == 11 && day == 31 && hour >= 9) || (month == 0 && day == 1 && hour <= 12 )){
                    if(second == 4 & minute % 2 == 0){
                        Log.i("Developer", "\nDate and Time: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second + "." + millisecond + "\n");
                        //logDebugFile("debugFile1.txt" , "\nDate and Time: ", month, day, hour, minute, second, millisecond);
                    }else if(second == 4){
                        Log.i("Developer", "\nDate and Time: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second + "." + millisecond + "\n");
                        //logDebugFile("debugFile2.txt" , "\nDate and Time: ", month, day, hour, minute, second, millisecond);
                    }

                    if(minute == 58 && second == 54 && !Global.getInstance().getSleepMode() && !Global.getInstance().getNotificationSent() && Global.getInstance().getNotificationsOn()){
                        Log.i("Developer", "Notification should run!!!!!!!!!!!!!!!!!!!");
                    }

                    /*if(Global.getInstance().getNotificationSent()){
                        Note1.setText("Notification Sent at: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second);
                        if(second % 10 == 4) {
                            logDebugFile("debugFile1.txt","\nDate and Time: ", month,  day, hour, minute, second, millisecond);
                            //addToPersistentFile(folder1, "debugFile1.txt", "Date and Time: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second + "." + millisecond);
                            logDebugFile("debugFile1.txt","Notification Sent at: ", month,  day, hour, minute, second, millisecond);
                            logDebugFile("debugFile2.txt","\nDate and Time: ", month,  day, hour, minute, second, millisecond);
                            //addToPersistentFile(folder1, "debugFile2.txt", "Date and Time: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second + "." + millisecond);
                            logDebugFile("debugFile2.txt","Notification Sent at: ", month,  day, hour, minute, second, millisecond);
                        }
                    }*/

                    if(millisecond < 300){
                        if(wakeLock1.isHeld()){
                            //Note2.setText("Wake Lock is held: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second);
                            if(second % 10 == 4) {
                                //addToPersistentFile(getApplicationContext(), "debugFile1.txt", "Wake Lock held " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second);
                            }
                            Log.i("Developer", "\n" + "Wake Lock is held: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second + "\n");
                        }else if(!wakeLock1.isHeld()){
                            //Note3.setText("Wake Lock is not held: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second);
                            if(second % 10 == 4) {
                                //addToPersistentFile(getApplicationContext(), "debugFile1.txt", "Wa.L. not held" + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second);
                            }
                            Log.i("Developer", "\n" + "Wake Lock is not held: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second + "\n");
                        }
                    }

                    if(!wakeLock1.isHeld()) {
                        wakeLock1.acquire(27*60*60*1000L /*27 hours*/);
                        //Note4.setText("Wake Lock acquired: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second);
                        //Log.i("Developer", "\n" + "Wake Lock acquired: " + (month + 1) + "/" + day + " " + hour + ":" + minute + ":" + second + "\n");
                    }
                    /*if(!isServiceRunning(NewYearService.class)){
                        //try {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                startForegroundService(new Intent(getApplicationContext(), NewYearService.class));
                            }else{
                                startService(new Intent(getApplicationContext(), NewYearService.class));
                            }
                        //}catch(Error error){
                        //    Log.e("Developer", "An error has occurred!");
                        //    error.printStackTrace();
                        //}
                    }*/
                }else{
                    if(wakeLock1.isHeld()) {
                        wakeLock1.release();
                        Log.i("Developer", "\nWake Lock released!\n");
                    }
                    /*if(isServiceRunning(NewYearService.class)){
                        stopService(new Intent(getApplicationContext(), NewYearService.class));
                    }*/
                    NextNewYear0.setText(R.string.noNewYear0);
                    NextNewYear1.setText(R.string.noNewYear1);
                    NextNewYear2.setText(R.string.blank);
                    NextNewYear3.setText(R.string.blank);
                    Note1.setText(R.string.blank);
                    Note2.setText(R.string.blank);
                    Note3.setText(R.string.blank);
                    Note4.setText(R.string.blank);
                }
                handler4.postDelayed(this, 200);
            }
        });


    }

    private boolean isServiceRunning(Class<?> classOfService){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service1 : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (classOfService.getName().equals(service1.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void createPersistentFile(File folder, String fileName){

        //File file1 = new File(context1.getFilesDir(), fileName);
        File file1 = new File(folder, fileName);

        if(!file1.exists()){
            try{
                file1.createNewFile();
                Log.i("Developer", "File has been created");
            }catch(IOException error){
                Log.e("Developer", "File could not be created");
            }
        }else{
            Log.i("Developer", "File already exists");
        }
    }

    private void writeToPersistentFile(File folder, String fileName, String content){
        try{
            //FileOutputStream fileOutput1 = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            File file = new File(folder, fileName);
            FileOutputStream fileOutput1 = new FileOutputStream(file);
            fileOutput1.write(content.getBytes(Charset.forName("UTF-8")));
            Log.i("Developer", "Wrote to file");
            fileOutput1.close();
        }catch(Exception error){
            error.printStackTrace();
            Log.e("Developer", "Failed to write to file");
        }
    }

    private ArrayList<String> readFromPersistentFile(File folder, String fileName){
        try {
            //FileInputStream fileInput1 = context.openFileInput(fileName);
            File file = new File(folder, fileName);
            FileInputStream fileInput1 = new FileInputStream(file);
            InputStreamReader inputReader = new InputStreamReader(fileInput1, Charset.forName("UTF-8"));
            ArrayList<String> linesArray = new ArrayList<>();
            BufferedReader reader1 = new BufferedReader(inputReader);
            String line = reader1.readLine();
            while (line != null){
                linesArray.add(line);
                line = reader1.readLine();
            }
            Log.i("Developer", linesArray.toString());
            Log.i("Developer", "Read file");
            fileInput1.close();
            return linesArray;
        }catch(Exception error){
            error.printStackTrace();
            Log.e("Developer", "Failed to read file");
        }
        return null;
    }

    private void addToPersistentFile(File folder, String fileName, String content){
        try {
            ArrayList<String> fileContent;
            String fileString = "";
            fileContent = readFromPersistentFile(folder, fileName);
            if(fileContent.size() != 0) {
                fileString = fileContent.get(0);
                //Log.i("Developer", "\n" + fileContent.get(0) + "\n");
            }
            for (int i = 1; i < fileContent.size(); i++){
                fileString = fileString + "\n" + fileContent.get(i);
                //Log.i("Developer", "\n" + fileContent.get(i) + "\n");
            }
            fileString = fileString + "\n" + content;
            writeToPersistentFile(folder, fileName, fileString);
        }catch(Exception error){
            error.printStackTrace();
            Log.e("Developer", "Failed to add to file");
        }
    }

    public void buttonSetUp(){
        final FloatingActionButton floatingActionButton1 = findViewById(R.id.floatingActionButton1);
        floatingActionButton1.setOnClickListener(this::onClick);
    }
    private void onClick(View view){
        int buttonID = view.getId();
        if (buttonID == R.id.floatingActionButton1 || buttonID == R.id.floatingActionButton2 || buttonID == R.id.floatingActionButton3 || buttonID == R.id.floatingActionButton4){
            Global.getInstance().setCurrentView("Menu");
            if(buttonID == R.id.floatingActionButton2){
                Global.getInstance().setSettingsOn(false);
                //Log.i("Developer", "Settings On: " + Global.getInstance().getSettingsOn() + ".");
                //storeSettings();
                /*Log.i("Developer", "Settings stored!");
                Log.i("Developer", "Sleep mode: " + switch_values.getInstance().getSleepMode() + ".");
                Log.i("Developer", "Notifications: " + switch_values.getInstance().getNotifications() + ".");
                Log.i("Developer", "Bell: " + switch_values.getInstance().getBell() + ".");*/
            }
            setContentView(R.layout.menu);
            final Button button1 = findViewById(R.id.button1);
            button1.setOnClickListener(this::onClick);
            final Button button2 = findViewById(R.id.button2);
            button2.setOnClickListener(this::onClick);
            final Button button3 = findViewById(R.id.button3);
            button3.setOnClickListener(this::onClick);
            final Button button4 = findViewById(R.id.button4);
            button4.setOnClickListener(this::onClick);
            otherViewNewYear();
        }else if (buttonID == R.id.button1){
            Global.getInstance().setCurrentView("Main");
            Global.getInstance().setSettingsOn(false);
            setContentView(R.layout.activity_main);
            reloadTextView();
            final FloatingActionButton floatingActionButton1 = findViewById(R.id.floatingActionButton1);
            floatingActionButton1.setOnClickListener(this::onClick);
            newYear();
        }else if (buttonID == R.id.button2){
            Global.getInstance().setCurrentView("Settings");
            Global.getInstance().setSettingsOn(true);
            //Log.i("Developer", "Settings On: " + Global.getInstance().getSettingsOn() + ".");
            setContentView(R.layout.settings);
            final FloatingActionButton floatingActionButton2 = findViewById(R.id.floatingActionButton2);
            floatingActionButton2.setOnClickListener(this::onClick);
            otherViewNewYear();
            settings();
        }else if (buttonID == R.id.button3){
            Global.getInstance().setCurrentView("Credits");
            Global.getInstance().setSettingsOn(false);
            setContentView(R.layout.credits);
            final FloatingActionButton floatingActionButton3 = findViewById(R.id.floatingActionButton3);
            floatingActionButton3.setOnClickListener(this::onClick);
            otherViewNewYear();
        }else if (buttonID == R.id.button4){
            Global.getInstance().setCurrentView("Help");
            Global.getInstance().setSettingsOn(false);
            setContentView(R.layout.help);
            final FloatingActionButton floatingActionButton4 = findViewById(R.id.floatingActionButton4);
            floatingActionButton4.setOnClickListener(this::onClick);
            otherViewNewYear();
        }
    }
    /*public void storeSettings() {
            boolean sleepMode = Global.getInstance().getSleepMode();
            boolean notificationsOn = Global.getInstance().getNotificationsOn();
            boolean bellOn = Global.getInstance().getBellOn();
            switch_values.getInstance().setSleepMode(sleepMode);
            switch_values.getInstance().setNotifications(notificationsOn);
            switch_values.getInstance().setBell(bellOn);
    }*/
    public void settings(){
        final Switch sleepModeSwitch = findViewById(R.id.switch1);
        final Switch notificationSwitch = findViewById(R.id.switch2);
        final Switch bellSwitch = findViewById(R.id.switch3);

        /*File documentsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        ArrayList<String> settings1 = readFromPersistentFile(documentsFolder, "settingsData.txt");*/
        /*ArrayList<String> settings1 = new ArrayList<>(3);
        settings1.add("false");
        settings1.add("true");
        settings1.add("true");*/
        /*Log.i("Developer", "Sleep Mode: " + settings1.get(0));
        Log.i("Developer", "Notifications: " + settings1.get(1));
        Log.i("Developer", "Bell: " + settings1.get(2));
        ArrayList<Boolean> booleanSettings = onOffStringToBoolean(settings1);
        Log.i("Developer", "Boolean Array: " + booleanSettings.toString());*/
        boolean sleepMode = switch_values.getInstance().getSleepMode();
        boolean notifications = switch_values.getInstance().getNotifications();
        boolean bell = switch_values.getInstance().getBell();
        /*Log.i("Developer", "Sleep Mode Boolean: " + booleanSettings.get(0));
        Log.i("Developer", "Notifications Boolean: " + booleanSettings.get(1));
        Log.i("Developer", "Bell Boolean: " + booleanSettings.get(2));*/

        if (sleepMode) {
            sleepModeSwitch.setChecked(true);
            //Log.i("Developer", "Sleep Mode: true.");
        } else {
            sleepModeSwitch.setChecked(false);
            //Log.i("Developer", "Sleep Mode: false.");
        }
        if (notifications) {
            notificationSwitch.setChecked(true);
            //Log.i("Developer", "Notifications On: true.");
        } else {
            notificationSwitch.setChecked(false);
            //Log.i("Developer", "Notifications On: false.");
        }
        if (bell) {
            bellSwitch.setChecked(true);
            //Log.i("Developer", "Bell On: true.");
        } else {
            bellSwitch.setChecked(false);
            //Log.i("Developer", "Bell On: false.");
        }
        int[] x = {0};
        sleepModeSwitch.setOnClickListener(this::onClick1);
        final Handler handler3 = new Handler();
        handler3.post(new Runnable() {
            @Override
            public void run() {
                boolean settingsOn = Global.getInstance().getSettingsOn();
                if(settingsOn) {
                    x[0]++;
                    boolean sleepModeSwitchChecked = sleepModeSwitch.isChecked();
                    boolean notificationSwitchChecked = notificationSwitch.isChecked();
                    boolean bellSwitchChecked = bellSwitch.isChecked();
                    boolean sleepModeChanged = switch_values.getInstance().getSleepModeChanged();
                    if (sleepModeSwitchChecked && sleepModeChanged) {
                        notificationSwitch.setChecked(false);
                        bellSwitch.setChecked(false);
                        switch_values.getInstance().setNotifications(false);
                        switch_values.getInstance().setNotifications(false);
                    } else if (!notificationSwitchChecked && !bellSwitchChecked && sleepModeChanged) {
                        notificationSwitch.setChecked(true);
                        bellSwitch.setChecked(true);
                        switch_values.getInstance().setNotifications(true);
                        switch_values.getInstance().setBell(true);
                    } else if (!notificationSwitchChecked && !bellSwitchChecked) {
                        sleepModeSwitch.setChecked(true);
                        switch_values.getInstance().setSleepMode(true);
                    } else if (!sleepModeChanged) {
                        sleepModeSwitch.setChecked(false);
                        switch_values.getInstance().setSleepMode(false);
                    }
                    Global.getInstance().setSleepMode(sleepModeSwitchChecked);
                    Global.getInstance().setNotificationsOn(notificationSwitchChecked);
                    Global.getInstance().setBellOn(bellSwitchChecked);
                    switch_values.getInstance().setSleepModeChanged(false);

                    /*booleanSettings.set(0, sleepModeSwitchChecked);
                    booleanSettings.set(1, notificationSwitchChecked);
                    booleanSettings.set(2, bellSwitchChecked);

                    ArrayList<String> settings2 = booleanToOnOffString(booleanSettings);
                    for(int i = 0; i < settings1.size(); i++){
                        settings1.set(i, settings2.get(i));
                    }
                    File documents = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                    writeToPersistentFile(documents, "settingsData.txt", settings1.get(0) + "\n" + settings1.get(1) + "\n" + settings1.get(2));                    writeToPersistentFile(documents, "settingsData.txt", settings1.get(0) + "\n" + settings1.get(1) + "\n" + settings1.get(2));

                    */
                    //Log.i("Developer", "Sleep Mode Changed False!");
                    if (x[0] == 10) {
                        Log.i("Developer", "Sleep Mode Checked: " + sleepModeSwitchChecked + ".");
                        Log.i("Developer", "Notifications Checked: " + notificationSwitchChecked + ".");
                        Log.i("Developer,", "Bell Checked: " + bellSwitchChecked + ".");
                        Log.i("Developer", "Sleep Mode Set: " + Global.getInstance().getSleepMode() + ".");
                        Log.i("Developer", "Notifications Set: " + Global.getInstance().getNotificationsOn() + ".");
                        Log.i("Developer", "Bell Set: " + Global.getInstance().getBellOn() + ".");
                        Log.i("Developer", "Settings On: " + Global.getInstance().getSettingsOn() + ".");
                        x[0] = 0;
                    }
                    handler3.postDelayed(this, 200);
                }
            }
        });
    }

    public ArrayList<Boolean> onOffStringToBoolean(ArrayList<String> stringArray){
        ArrayList<Boolean> booleanArray = new ArrayList<>();
        for(int i = 0; i < stringArray.size(); i++){
            if(Objects.equals(stringArray.get(i), "On")){
                booleanArray.add(true);
                Log.i("Developer", "Item " + i + " is on");
            }else if(Objects.equals(stringArray.get(i), "Off")){
                booleanArray.add(false);
                Log.i("Developer", "Item " + i + " is on");
            }else{
                Log.e("Developer", "Neither on or off");
            }
        }
        return booleanArray;
    }

    public ArrayList<String> booleanToOnOffString(ArrayList<Boolean> booleanArray){
        ArrayList<String> stringArray = new ArrayList<>();
        for(int i = 0; i < booleanArray.size(); i++){
            if(booleanArray.get(i)){
                stringArray.add("On");
            }else{
                stringArray.add("Off");
            }
        }
        return stringArray;
    }

    private void onClick1(View view) {
        switch_values.getInstance().setSleepModeChanged(true);
        //Log.i("Developer", "Sleep Mode Changed True!");
    }

    public MediaPlayer getBellMedia(){
        return MediaPlayer.create(this, R.raw.new_year_bell_sound);
    }
    public void bellSound(){
        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        int month = calendar1.get(Calendar.MONTH);
        int day = calendar1.get(Calendar.DATE);
        int hour = calendar1.get(Calendar.HOUR_OF_DAY);
        int minute = calendar1.get(Calendar.MINUTE);
        int second = calendar1.get(Calendar.SECOND);
        int millisecond = calendar1.get(Calendar.MILLISECOND);
        boolean noNewYear = false;
        boolean sleepMode = Global.getInstance().getSleepMode();
        boolean bellPlayed = Global.getInstance().getBellPlayed();
        boolean bellOn = Global.getInstance().getBellOn();
        if (!((month == 11 && day == 31) || (month == 0 && day == 1))) {
            noNewYear = true;
        } else if (month == 11 & day == 31) {
            if (hour < 9) {
                noNewYear = true;
            }
        } else {
            if (hour > 12) {
                noNewYear = true;
            }
        }
        if(!noNewYear) {
            if(month == 11) {
                if (hour == 10 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                     Global.getInstance().setBellPlayed(true);
                } else if (hour == 10 && minute == 15 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 11 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 12 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 13 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 13 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 14 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 14 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 15 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 15 && minute == 15 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 16 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 17 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 17 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 18 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 18 && minute == 15 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 18 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 19 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 19 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 20 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 20 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 21 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 22 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 23 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                }
            } else {
                if (hour == 0 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 1 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 2 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 3 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 3 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 4 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 5 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 6 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 7 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 8 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 9 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 9 && minute == 30 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 10 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 11 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                } else if (hour == 12 && minute == 0 && second < 10 && !sleepMode && !bellPlayed && bellOn) {
                    getBellMedia().start();
                    Global.getInstance().setBellPlayed(true);
                }
            }
        }
        if(second == 12){
            Global.getInstance().setBellPlayed(false);

        }
    }

    public void callBellFunction(){
        Global.getInstance().setCallBell(true);
    }

    public void setBellFunction(){
        final Handler handler6 = new Handler();
        handler6.post(new Runnable() {
            @Override
            public void run() {
                boolean setBellBoolean = Global.getInstance().getCallBell();
                if(setBellBoolean){
                    bellSound();
                    Global.getInstance().setCallBell(false);
                }
                handler6.postDelayed(this, 200);
            }
        });
    }

    //FIXME: Notification Run Only Once
    public void notifications(){
        //System.out.println("Notifications Function Running!");
        Calendar epochCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        if(epochCalendar.get(Calendar.MONTH) == Calendar.JANUARY){
            epochCalendar.set(Calendar.YEAR, epochCalendar.get(Calendar.YEAR) - 1);
        }

        epochCalendar.set(Calendar.MONTH, 11);
        epochCalendar.set(Calendar.DATE, 31);
        epochCalendar.set(Calendar.HOUR_OF_DAY, 9);
        epochCalendar.set(Calendar.MINUTE, 0);
        epochCalendar.set(Calendar.SECOND, 0);
        epochCalendar.set(Calendar.MILLISECOND, 0);

        //Log.i("Developer", "Notification Scheduled: " + Global.getInstance().getScheduleNotification());
        if(!Global.getInstance().getScheduleNotification()) {
            for (int i = 0; i < 114; i++) {
                Log.i("Developer", "Alarm " + i + " Scheduled");
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intent = new Intent(MainActivity.this, NotificationSchedulerReceiver.class);
                intent.setData(Uri.parse("alarms://" + (2000 + i)));
                PendingIntent pendingIntent;
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 2000 + i, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                long epoch = epochCalendar.getTimeInMillis();
                long alarmTime = epoch + findAlarmMilliseconds(i);
                if(alarmTime > currentTime.getTimeInMillis()) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent);
                }
                Log.i("Developer", "Time: " + alarmTime);
            }

            Global.getInstance().setScheduleNotification(true);
        }

    }

    public void callNotificationsFunction(){
        Global.getInstance().setCallNotifications(true);
    }

    public void setNotificationsFunction(){
        final Handler handler7 = new Handler();
        handler7.post(new Runnable() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                boolean setNotificationsBoolean = Global.getInstance().getCallNotifications();
                if(setNotificationsBoolean){
                    notifications();
                    Global.getInstance().setCallNotifications(false);
                }

                if(calendar.get(Calendar.SECOND) == 2 /*&& millisecond > 0 && millisecond <= 200*/ && Global.getInstance().getNotificationSent()){
                    Global.getInstance().setNotificationSent(false);
                }
                handler7.postDelayed(this, 200);
            }
        });
    }

    public int findAlarmMilliseconds(int alarmNumber){
        switch(alarmNumber){
            case 0:
                return 3294000;
            case 1:
                return 3534000;
            case 2:
                return 3594000;
            case 3:
                return 4194000;
            case 4:
                return 4434000;
            case 5:
                return 4494000;
            case 6:
                return 6894000;
            case 7:
                return 7134000;
            case 8:
                return 7194000;
            case 9:
                return 10494000;
            case 10:
                return 10734000;
            case 11:
                return 10794000;
            case 12:
                return 14094000;
            case 13:
                return 14334000;
            case 14:
                return 14394000;
            case 15:
                return 15894000;
            case 16:
                return 16134000;
            case 17:
                return 16194000;
            case 18:
                return 17694000;
            case 19:
                return 17934000;
            case 20:
                return 17994000;
            case 21:
                return 19494000;
            case 22:
                return 19734000;
            case 23:
                return 19794000;
            case 24:
                return 21294000;
            case 25:
                return 21534000;
            case 26:
                return 21594000;
            case 27:
                return 22194000;
            case 28:
                return 22434000;
            case 29:
                return 22494000;
            case 30:
                return 24894000;
            case 31:
                return 25134000;
            case 32:
                return 25194000;
            case 33:
                return 28494000;
            case 34:
                return 28734000;
            case 35:
                return 28794000;
            case 36:
                return 30294000;
            case 37:
                return 30534000;
            case 38:
                return 30594000;
            case 39:
                return 32094000;
            case 40:
                return 32334000;
            case 41:
                return 32394000;
            case 42:
                return 32994000;
            case 43:
                return 33234000;
            case 44:
                return 33294000;
            case 45:
                return 33894000;
            case 46:
                return 34134000;
            case 47:
                return 34194000;
            case 48:
                return 35694000;
            case 49:
                return 35934000;
            case 50:
                return 35994000;
            case 51:
                return 37494000;
            case 52:
                return 37734000;
            case 53:
                return 37794000;
            case 54:
                return 39294000;
            case 55:
                return 39534000;
            case 56:
                return 39594000;
            case 57:
                return 41094000;
            case 58:
                return 41334000;
            case 59:
                return 41394000;
            case 60:
                return 42894000;
            case 61:
                return 43134000;
            case 62:
                return 43194000;
            case 63:
                return 46494000;
            case 64:
                return 46734000;
            case 65:
                return 46794000;
            case 66:
                return 50094000;
            case 67:
                return 50334000;
            case 68:
                return 50394000;
            case 69:
                return 53694000;
            case 70:
                return 53934000;
            case 71:
                return 53994000;
            case 72:
                return 57294000;
            case 73:
                return 57534000;
            case 74:
                return 57594000;
            case 75:
                return 60894000;
            case 76:
                return 61134000;
            case 77:
                return 61194000;
            case 78:
                return 64494000;
            case 79:
                return 64734000;
            case 80:
                return 64794000;
            case 81:
                return 66294000;
            case 82:
                return 66534000;
            case 83:
                return 66594000;
            case 84:
                return 68094000;
            case 85:
                return 68334000;
            case 86:
                return 68394000;
            case 87:
                return 71694000;
            case 88:
                return 71934000;
            case 89:
                return 71994000;
            case 90:
                return 75294000;
            case 91:
                return 75534000;
            case 92:
                return 75594000;
            case 93:
                return 78894000;
            case 94:
                return 79134000;
            case 95:
                return 79194000;
            case 96:
                return 82494000;
            case 97:
                return 82734000;
            case 98:
                return 82794000;
            case 99:
                return 86094000;
            case 100:
                return 86334000;
            case 101:
                return 86394000;
            case 102:
                return 87894000;
            case 103:
                return 88134000;
            case 104:
                return 88194000;
            case 105:
                return 89694000;
            case 106:
                return 89934000;
            case 107:
                return 89994000;
            case 108:
                return 93294000;
            case 109:
                return 93534000;
            case 110:
                return 93594000;
            case 111:
                return 96894000;
            case 112:
                return 97134000;
            case 113:
                return 97194000;
            default:
                return 0;
        }
    }

    public void setContent(String textView, String content){
        //Log.i("Developer", "Change TextView!");
        if(Objects.equals(textView, "nextNewYear0")){
            Global.getInstance().setContentNextNewYear0(content);
        }else if(Objects.equals(textView, "nextNewYear1")){
            Global.getInstance().setContentNextNewYear1(content);
        }else if(Objects.equals(textView, "nextNewYear2")){
            Global.getInstance().setContentNextNewYear2(content);
        }else if(Objects.equals(textView, "nextNewYear3")){
            Global.getInstance().setContentNextNewYear3(content);
        }else if(Objects.equals(textView, "note1")){
            Global.getInstance().setContentNote1(content);
        }else if(Objects.equals(textView, "note2")){
            Global.getInstance().setContentNote2(content);
        }else if(Objects.equals(textView, "note3")){
            Global.getInstance().setContentNote3(content);
        }else if(Objects.equals(textView, "note4")){
            Global.getInstance().setContentNote4(content);
        }else{
            throw new IllegalArgumentException("TextView entered is not a valid TextView");
        }
    }

    public void changeTextView(){
        Global.getInstance().setNextNewYear(true);
    }

    public void setTextView(){
        final Handler handler5 = new Handler();
        handler5.post(new Runnable() {
            @Override
            public void run() {
                //FIXME: Uncomment to investigate TextView
                /*Log.i("Developer", "Set TextView!");
                Log.i("Information", "Set TextView New Year 0 Value: " + NextNewYear0.getText());
                Log.i("Information", "Set TextView New Year 1 Value: " + NextNewYear1.getText());*/
                boolean booleanNewYear = Global.getInstance().getNextNewYear();
                String currentView = Global.getInstance().getCurrentView();

                if(booleanNewYear){
                    reloadTextView();
                    Global.getInstance().setNextNewYear(false);
                }

                handler5.postDelayed(this, 200);
            }
        });
    }

    public void reloadTextView(){
        final TextView NextNewYear0 = findViewById(R.id.nextNewYear0);
        final TextView NextNewYear1 = findViewById(R.id.nextNewYear1);
        final TextView NextNewYear2 = findViewById(R.id.nextNewYear2);
        final TextView NextNewYear3 = findViewById(R.id.nextNewYear3);
        final TextView Note1 = findViewById(R.id.note1);
        final TextView Note2 = findViewById(R.id.note2);
        final TextView Note3 = findViewById(R.id.note3);
        final TextView Note4 = findViewById(R.id.note4);

        String newNewYear0 = Global.getInstance().getContentNextNewYear0();
        String newNewYear1 = Global.getInstance().getContentNextNewYear1();
        String newNewYear2 = Global.getInstance().getContentNextNewYear2();
        String newNewYear3 = Global.getInstance().getContentNextNewYear3();
        String note1 = Global.getInstance().getContentNote1();
        String note2 = Global.getInstance().getContentNote2();
        String note3 = Global.getInstance().getContentNote3();
        String note4 = Global.getInstance().getContentNote4();

        if(Global.getInstance().getCurrentView() == "Main") {
            NextNewYear0.setText(newNewYear0);
            NextNewYear1.setText(newNewYear1);
            NextNewYear2.setText(newNewYear2);
            NextNewYear3.setText(newNewYear3);
            Note1.setText(note1);
            Note2.setText(note2);
            Note3.setText(note3);
            Note4.setText(note4);
        }
    }

    public void newYear(){
        int x[] = {0};

        final Handler handler1 = new Handler();
        handler1.post(new Runnable(){
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                x[0]++;
                if (x[0] == 50) {
                    //Log.i("Developer", "App running (Main Activity)!");
                    x[0] = 0;
                }
                Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                int month = calendar1.get(Calendar.MONTH);
                int day = calendar1.get(Calendar.DATE);
                int hour = calendar1.get(Calendar.HOUR_OF_DAY);
                int minute = calendar1.get(Calendar.MINUTE);
                /*int second = calendar1.get(Calendar.SECOND);
                int millisecond = calendar1.get(Calendar.MILLISECOND);*/
                boolean noNewYear = false;
                if (!((month == 11 && day == 31) || (month == 0 && day == 1))) {
                    noNewYear = true;
                } else if (month == 11 & day == 31) {
                    if (hour < 9) {
                        noNewYear = true;
                    }
                } else {
                    if (hour > 12) {
                        noNewYear = true;
                    }
                }

                /*if (millisecond > 0 && millisecond <= 200){
                    Log.i("Developer",String.valueOf(noNewYear));
                }*/
                /*
                NextNewYear0.setText("");
                NextNewYear1.setText("");
                 */
                if (!noNewYear) {
                    if(month == 11) {
                        if (hour == 9) {
                            setContent("nextNewYear0", "Next New Year: UTC+14");
                            setContent("nextNewYear1", "City: Kiritimati, Kiribati");
                            setContent("nextNewYear2", "");
                            setContent("nextNewYear3", "");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();
                        } else if (hour == 10 && minute < 15) {
                            setContent("nextNewYear0", "Previous New Year: UTC+14");
                            setContent("nextNewYear1", "City: Kiritimati, Kiribati");
                            setContent("nextNewYear2", "Next New Year: UTC+13:45");
                            setContent("nextNewYear3", "City: Chatham Islands, New Zealand");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 10) {
                            setContent("nextNewYear0", "Previous New Year: UTC+13:45");
                            setContent("nextNewYear1", "City: Chatham Islands, New Zealand");
                            setContent("nextNewYear2", "Next New Year: UTC+13");
                            setContent("nextNewYear3", "City: Wellington, New Zealand");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 11) {
                            setContent("nextNewYear0", "Previous New Year: UTC+13");
                            setContent("nextNewYear1", "City: Wellington, New Zealand");
                            setContent("nextNewYear2", "Next New Year: UTC+12");
                            setContent("nextNewYear3", "City: Tarawa, Kiribati");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 12) {
                            setContent("nextNewYear0", "Previous New Year: UTC+12");
                            setContent("nextNewYear1", "City: Tarawa, Kiribati");
                            setContent("nextNewYear2", "Next New Year: UTC+11");
                            setContent("nextNewYear3", "City: Sydney, Australia");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 13 && minute < 30) {
                            setContent("nextNewYear0", "Previous New Year: UTC+11");
                            setContent("nextNewYear1", "City: Sydney, Australia");
                            setContent("nextNewYear2", "Next New Year: UTC+10:30");
                            setContent("nextNewYear3", "City: Adelaide, Australia");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 13) {
                            setContent("nextNewYear0", "Previous New Year: UTC+10:30");
                            setContent("nextNewYear1", "City: Adelaide, Australia");
                            setContent("nextNewYear2", "Next New Year: UTC+10");
                            setContent("nextNewYear3", "City: Brisbane, Australia");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 14 && minute < 30) {
                            setContent("nextNewYear0", "Previous New Year: UTC+10");
                            setContent("nextNewYear1", "City: Brisbane, Australia");
                            setContent("nextNewYear2", "Next New Year: UTC+9:30");
                            setContent("nextNewYear3", "City: Alice Springs, Australia");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 14) {
                            setContent("nextNewYear0", "Previous New Year: UTC+9:30");
                            setContent("nextNewYear1", "City: Alice Springs, Australia");
                            setContent("nextNewYear2", "Next New Year: UTC+9");
                            setContent("nextNewYear3", "City: Tokyo, Japan");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 15 && minute < 15) {
                            setContent("nextNewYear0", "Previous New Year: UTC+9");
                            setContent("nextNewYear1", "City: Tokyo, Japan");
                            setContent("nextNewYear2", "Next New Year: UTC+8:45");
                            setContent("nextNewYear3", "City: Eucla, Australia");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 15) {
                            setContent("nextNewYear0", "Previous New Year: UTC+8:45");
                            setContent("nextNewYear1", "City: Eucla, Australia");
                            setContent("nextNewYear2", "Next New Year: UTC+8");
                            setContent("nextNewYear3", "City: Beijing, China");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 16) {
                            setContent("nextNewYear0", "Previous New Year: UTC+8");
                            setContent("nextNewYear1", "City: Beijing, China");
                            setContent("nextNewYear2", "Next New Year: UTC+7");
                            setContent("nextNewYear3", "City: Jakarta, Indonesia");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 17 && minute < 30) {
                            setContent("nextNewYear0", "Previous New Year: UTC+7");
                            setContent("nextNewYear1", "City: Jakarta, Indonesia");
                            setContent("nextNewYear2", "Next New Year: UTC+6:30");
                            setContent("nextNewYear3", "City: Yangon, Myanmar");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 17) {
                            setContent("nextNewYear0", "Previous New Year: UTC+6:30");
                            setContent("nextNewYear1", "City: Yangon, Myanmar");
                            setContent("nextNewYear2", "Next New Year: UTC+6");
                            setContent("nextNewYear3", "City: Dhaka, Bangladesh");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 18 && minute < 15) {
                            setContent("nextNewYear0", "Previous New Year: UTC+6");
                            setContent("nextNewYear1", "City: Dhaka, Bangladesh");
                            setContent("nextNewYear2", "Next New Year: UTC+5:45");
                            setContent("nextNewYear3", "City: Kathmandu, Nepal");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 18 && minute < 30) {
                            setContent("nextNewYear0", "Previous New Year: UTC+5:45");
                            setContent("nextNewYear1", "City: Kathmandu, Nepal");
                            setContent("nextNewYear2", "Next New Year: UTC+5:30");
                            setContent("nextNewYear3", "City: Mumbai, India");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 18) {
                            setContent("nextNewYear0", "Previous New Year: UTC+5:30");
                            setContent("nextNewYear1", "City: Mumbai, India");
                            setContent("nextNewYear2", "Next New Year: UTC+5");
                            setContent("nextNewYear3", "City: Karachi, Pakistan");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 19 && minute < 30) {
                            setContent("nextNewYear0", "Previous New Year: UTC+5");
                            setContent("nextNewYear1", "City: Karachi, Pakistan");
                            setContent("nextNewYear2", "Next New Year: UTC+4:30");
                            setContent("nextNewYear3", "City: Kabul, Afghanistan");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 19) {
                            setContent("nextNewYear0", "Previous New Year: UTC+4:30");
                            setContent("nextNewYear1", "City: Kabul, Afghanistan");
                            setContent("nextNewYear2", "Next New Year: UTC+4");
                            setContent("nextNewYear3", "City: Dubai, UAE");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 20 && minute < 30) {
                            setContent("nextNewYear0", "Previous New Year: UTC+4");
                            setContent("nextNewYear1", "City: Dubai, UAE");
                            setContent("nextNewYear2", "Next New Year: UTC+3:30");
                            setContent("nextNewYear3", "City: Tehran, Iran");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 20) {
                            setContent("nextNewYear0", "Previous New Year: UTC+3:30");
                            setContent("nextNewYear1", "City: Tehran, Iran");
                            setContent("nextNewYear2", "Next New Year: UTC+3");
                            setContent("nextNewYear3", "City: Istanbul, Turkey");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else if (hour == 21) {
                            setContent("nextNewYear0", "Previous New Year: UTC+3");
                            setContent("nextNewYear1", "City: Istanbul, Turkey");
                            setContent("nextNewYear2", "Next New Year: UTC+2");
                            setContent("nextNewYear3", "City: Cape Town, South Africa");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;

                        } else if (hour == 22) {
                            setContent("nextNewYear0", "Previous New Year: UTC+2");
                            setContent("nextNewYear1", "City: Cape Town, South Africa");
                            setContent("nextNewYear2", "Next New Year: UTC+1");
                            setContent("nextNewYear3", "City: Berlin, Germany");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        } else {
                            setContent("nextNewYear0", "Previous New Year: UTC+1");
                            setContent("nextNewYear1", "City: Berlin, Germany");
                            setContent("nextNewYear2", "Next New Year: UTC");
                            setContent("nextNewYear3", "City: London, UK");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }
                    }else {
                        if(hour == 0){
                            setContent("nextNewYear0", "Previous New Year: UTC");
                            setContent("nextNewYear1", "City: London, UK");
                            setContent("nextNewYear2", "Next New Year: UTC-1");
                            setContent("nextNewYear3", "City: Praia, Cabo Verde");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 1){
                            setContent("nextNewYear0", "Previous New Year: UTC-1");
                            setContent("nextNewYear1", "City: Praia, Cabo Verde");
                            setContent("nextNewYear2", "Next New Year: UTC-2");
                            setContent("nextNewYear3", "City: Fernando de Noronha, Brazil");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 2){
                            setContent("nextNewYear0", "Previous New Year: UTC-2");
                            setContent("nextNewYear1", "City: Fernando de Noronha, Brazil");
                            setContent("nextNewYear2", "Next New Year: UTC-3");
                            setContent("nextNewYear3", "City: Rio de Janeiro, Brazil");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 3 && minute < 30){
                            setContent("nextNewYear0", "Previous New Year: UTC-3");
                            setContent("nextNewYear1", "City: Rio de Janeiro, Brazil");
                            setContent("nextNewYear2", "Next New Year: UTC-3:30");
                            setContent("nextNewYear3", "City: St. John's, Canada");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 3){
                            setContent("nextNewYear0", "Previous New Year: UTC-3:30");
                            setContent("nextNewYear1", "City: St. John's, Canada");
                            setContent("nextNewYear2", "Next New Year: UTC-4");
                            setContent("nextNewYear3", "City: Bridgetown, Barbados");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 4){
                            setContent("nextNewYear0", "Previous New Year: UTC-4");
                            setContent("nextNewYear1", "City: Bridgetown, Barbados");
                            setContent("nextNewYear2", "Next New Year: UTC-5");
                            setContent("nextNewYear3", "City: Miami, USA");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 5){
                            setContent("nextNewYear0", "Previous New Year: UTC-5");
                            setContent("nextNewYear1", "City: Miami, USA");
                            setContent("nextNewYear2", "Next New Year: UTC-6");
                            setContent("nextNewYear3", "City: Mexico City, Mexico");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 6){
                            setContent("nextNewYear0", "Previous New Year: UTC-6");
                            setContent("nextNewYear1", "City: Mexico City, Mexico");
                            setContent("nextNewYear2", "Next New Year: UTC-7");
                            setContent("nextNewYear3", "City: Denver, USA");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 7){
                            setContent("nextNewYear0", "Previous New Year: UTC-7");
                            setContent("nextNewYear1", "City: Denver, USA");
                            setContent("nextNewYear2", "Next New Year: UTC-8");
                            setContent("nextNewYear3", "City: Los Angeles, USA");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 8){
                            setContent("nextNewYear0", "Previous New Year: UTC-8");
                            setContent("nextNewYear1", "City: Los Angeles, USA");
                            setContent("nextNewYear2", "Next New Year: UTC-9");
                            setContent("nextNewYear3", "City: Anchorage, USA");
                            setContent("note1", "");
                            setContent("note2", "");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 9 && minute < 30){
                            setContent("nextNewYear0", "Previous New Year: UTC-9");
                            setContent("nextNewYear1", "City: Anchorage, USA");
                            setContent("nextNewYear2", "Next New Year: UTC-9:30");
                            setContent("nextNewYear3", "City: Taiohae, France");
                            setContent("note1", "Taiohae is in French Polynesia,");
                            setContent("note2", "an Overseas Collectivity of France.");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 9){
                            setContent("nextNewYear0", "Previous New Year: UTC-9:30");
                            setContent("nextNewYear1", "City: Taiohae, France");
                            setContent("nextNewYear2", "Next New Year: UTC-10");
                            setContent("nextNewYear3", "City: Honolulu, USA");
                            setContent("note1", "Taiohae is in French Polynesia,");
                            setContent("note2", "an Overseas Collectivity of France.");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 10){
                            setContent("nextNewYear0", "Previous New Year: UTC-10");
                            setContent("nextNewYear1", "City: Honolulu, USA");
                            setContent("nextNewYear2", "Next New Year: UTC-11");
                            setContent("nextNewYear3", "City: Pago Pago, USA");
                            setContent("note1", "Pago Pago is in American Samoa,");
                            setContent("note2", "a territory of the US.");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }else if(hour == 11){
                            setContent("nextNewYear0", "Previous New Year: UTC-11");
                            setContent("nextNewYear1", "City: Pago Pago, USA");
                            setContent("nextNewYear2", "Next New Year: UTC-12");
                            setContent("nextNewYear3", "City: Baker Island, USA");
                            setContent("note1", "Pago Pago is in American Samoa,");
                            setContent("note2", "a territory of the US.");
                            setContent("note3", "Baker Island is in US Minor");
                            setContent("note4", "Outlying islands, a US territory.");
                            changeTextView();;
                        }else{
                            setContent("nextNewYear0", "Previous New Year: UTC-12");
                            setContent("nextNewYear1", "City: Baker Island, USA");
                            setContent("nextNewYear2", "There are no areas of the world");
                            setContent("nextNewYear3", "about to enter a New Year.");
                            setContent("note1", "Baker Island is in US Minor");
                            setContent("note2", "Outlying islands, a US territory.");
                            setContent("note3", "");
                            setContent("note4", "");
                            changeTextView();;
                        }
                    }
                }
                /*if (month == 11 && day == 31) {
                    if (hour < 9) {
                        NextNewYear0.setText(R.string.noNewYear0);
                        NextNewYear1.setText(R.string.noNewYear1);
                        NextNewYear2.setText(R.string.blank);
                        NextNewYear3.setText(R.string.blank);
                        Note1.setText(R.string.blank);
                        Note2.setText(R.string.blank);
                        Note3.setText(R.string.blank);
                        Note4.setText(R.string.blank);
                    }
                } else if (month == 0 && day == 1) {
                    if (hour > 12) {
                        NextNewYear0.setText(R.string.noNewYear0);
                        NextNewYear1.setText(R.string.noNewYear1);
                        NextNewYear2.setText(R.string.blank);
                        NextNewYear3.setText(R.string.blank);
                        Note1.setText(R.string.blank);
                        Note2.setText(R.string.blank);
                        Note3.setText(R.string.blank);
                        Note4.setText(R.string.blank);
                    }
                } else {
                    NextNewYear0.setText(R.string.noNewYear0);
                    NextNewYear1.setText(R.string.noNewYear1);
                    NextNewYear2.setText(R.string.blank);
                    NextNewYear3.setText(R.string.blank);
                    Note1.setText(R.string.blank);
                    Note2.setText(R.string.blank);
                    Note3.setText(R.string.blank);
                    Note4.setText(R.string.blank);
                }*/
                callBellFunction();
                callNotificationsFunction();
                handler1.postDelayed(this, 200);
            }
        });
    }
    public void otherViewNewYear(){
        int x[] = {0};

        final Handler handler2 = new Handler();
        handler2.post(new Runnable() {
            @Override
            public void run() {
                x[0]++;
                if (x[0] == 10) {
                    //Log.i("Developer", "App running (Other Activity)!");
                    /*NotificationChannel.createNotificationChannel(MainActivity.this, "channelIDA", NotificationManager.IMPORTANCE_HIGH, "notificationChannelA", "newYearA", 10);
                    NotificationChannel.setNotification(MainActivity.this, "Test Notification!", "This is a Test Notification!", NotificationCompat.PRIORITY_HIGH, 5000, "channelIDA");*/
                    x[0] = 0;
                }
                bellSound();
                notifications();
                handler2.postDelayed(this, 200);
            }
        });
    }
}