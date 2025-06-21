package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public interface AndroidApplicationBase extends com.badlogic.gdx.Application {
    public static final int MINIMUM_SDK = 8;

    android.view.Window getApplicationWindow();

    android.content.Context getContext();

    com.badlogic.gdx.utils.Array<java.lang.Runnable> getExecutedRunnables();

    android.os.Handler getHandler();

    com.badlogic.gdx.utils.SnapshotArray<com.badlogic.gdx.LifecycleListener> getLifecycleListeners();

    com.badlogic.gdx.utils.Array<java.lang.Runnable> getRunnables();

    android.view.WindowManager getWindowManager();

    void runOnUiThread(java.lang.Runnable runnable);

    void startActivity(android.content.Intent intent);

    void useImmersiveMode(boolean z);
}
