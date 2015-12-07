package com.ahmd.apps.esl;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.AndroidRuntimeException;


public class ESLApplication extends Application {
    private static ESLApplication INSTANCE;
    private boolean twoPane;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        INSTANCE = this;
        // Initializing instance from here.
        // This will get us access to resources if necessary.
    }

    public static ESLApplication getESLInstance(){
        if (INSTANCE == null) {
            throw new AndroidRuntimeException("ESL application was not initialized");
        }
        return INSTANCE;
    }

    public boolean getConnectionStatus() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }

    public SharedPreferences getSharedPreferences(){
        return this.getSharedPreferences("com.example.fragment0901", Context.MODE_PRIVATE);
    }

    public boolean getTwoPane(){
        return twoPane;
    }

    public void setTwoPane(boolean twoPane){
        this.twoPane = twoPane;
    }
}
