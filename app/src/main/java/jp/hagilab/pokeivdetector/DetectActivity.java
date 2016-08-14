package jp.hagilab.pokeivdetector;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.Preference;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yuki on 2016/08/04.
 */
public class DetectActivity extends Service implements Preference.OnPreferenceChangeListener {
    private Notification notification;
    private NotificationManager manager;

    public DetectActivity() {

        /*
        manager = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
        manager.notify(1000, notification);*/
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        Log.d("DetectA", "onCreate");
        notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("PokeIVDetector")
                .setContentText("Detect!")
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .build();
        manager = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
        manager.notify(10000,notification);
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        SwitchPreference sp = (SwitchPreference) preference;
        if(sp.isChecked()){
            Log.d("debug", "T to F (Disappear Notification)");
        } else {
            Log.d("debug", "F to T (Show Notification)");
            //manager.notify(1000, notification);
        }
        return true;
    }
}
