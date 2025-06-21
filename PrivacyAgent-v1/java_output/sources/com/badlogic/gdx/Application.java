package com.badlogic.gdx;

/* loaded from: classes12.dex */
public interface Application {
    public static final int LOG_DEBUG = 3;
    public static final int LOG_ERROR = 1;
    public static final int LOG_INFO = 2;
    public static final int LOG_NONE = 0;

    public enum ApplicationType {
        Android,
        Desktop,
        HeadlessDesktop,
        Applet,
        WebGL,
        iOS
    }

    void addLifecycleListener(com.badlogic.gdx.LifecycleListener lifecycleListener);

    void debug(java.lang.String str, java.lang.String str2);

    void debug(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void error(java.lang.String str, java.lang.String str2);

    void error(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void exit();

    com.badlogic.gdx.ApplicationListener getApplicationListener();

    com.badlogic.gdx.ApplicationLogger getApplicationLogger();

    com.badlogic.gdx.Files getFiles();

    com.badlogic.gdx.Graphics getGraphics();

    long getJavaHeap();

    int getLogLevel();

    long getNativeHeap();

    com.badlogic.gdx.Preferences getPreferences(java.lang.String str);

    com.badlogic.gdx.Application.ApplicationType getType();

    int getVersion();

    void log(java.lang.String str, java.lang.String str2);

    void log(java.lang.String str, java.lang.String str2, java.lang.Throwable th);

    void postRunnable(java.lang.Runnable runnable);

    void removeLifecycleListener(com.badlogic.gdx.LifecycleListener lifecycleListener);

    void setApplicationLogger(com.badlogic.gdx.ApplicationLogger applicationLogger);

    void setLogLevel(int i);
}
