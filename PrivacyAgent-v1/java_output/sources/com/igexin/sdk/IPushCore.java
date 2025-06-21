package com.igexin.sdk;

/* loaded from: classes23.dex */
public interface IPushCore {
    void onActivityConfigurationChanged(android.app.Activity activity, android.content.res.Configuration configuration);

    boolean onActivityCreateOptionsMenu(android.app.Activity activity, android.view.Menu menu);

    void onActivityDestroy(android.app.Activity activity);

    boolean onActivityKeyDown(android.app.Activity activity, int i, android.view.KeyEvent keyEvent);

    void onActivityNewIntent(android.app.Activity activity, android.content.Intent intent);

    void onActivityPause(android.app.Activity activity);

    void onActivityRestart(android.app.Activity activity);

    void onActivityResume(android.app.Activity activity);

    void onActivityStart(android.app.Activity activity, android.content.Intent intent);

    void onActivityStop(android.app.Activity activity);

    android.os.IBinder onServiceBind(android.content.Intent intent);

    void onServiceDestroy();

    int onServiceStartCommand(android.content.Intent intent, int i, int i2);

    boolean start(android.content.Context context);
}
