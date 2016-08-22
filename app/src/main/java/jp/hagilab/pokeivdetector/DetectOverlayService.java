package jp.hagilab.pokeivdetector;

import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.content.Intent;
import android.view.WindowManager;
import android.app.Service;
import android.view.LayoutInflater;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.content.Context;

/**
 * Created by yuki on 2016/08/22.
 *
 * Refer to: https://www.ipentec.com/document/document.aspx?page=android-create-system-overlay-application
 * Refer to: http://www.atmarkit.co.jp/ait/articles/1602/01/news156_2.html
 */
public class DetectOverlayService extends Service {
    View view;
    WindowManager wm;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);

        LayoutInflater layoutInflater = LayoutInflater.from(this);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);

        wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);

        view = layoutInflater.inflate(R.layout.detect_overlay, null);

        wm.addView(view, params);

        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wm.removeView(view);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
}
