package com.bytedance.pangle.service;

/* loaded from: classes.dex */
public interface a {
    void attach(com.bytedance.pangle.plugin.Plugin plugin);

    android.os.IBinder onBind(android.content.Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(android.content.Intent intent, int i, int i2);

    boolean onUnbind(android.content.Intent intent);
}
