package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface SVSD {
    android.os.IBinder onBind(android.content.Intent intent);

    void onConfigurationChanged(android.content.res.Configuration configuration);

    void onCreate();

    void onDestroy();

    void onLowMemory();

    void onRebind(android.content.Intent intent);

    int onStartCommand(android.content.Intent intent, int i, int i2);

    void onTaskRemoved(android.content.Intent intent);

    void onTrimMemory(int i);

    boolean onUnbind(android.content.Intent intent);
}
