package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidApplicationConfiguration {
    public java.lang.String sdcard;
    public int r = 5;
    public int g = 6;
    public int b = 5;
    public int a = 0;
    public int depth = 16;
    public int stencil = 0;
    public int numSamples = 0;
    public boolean useAccelerometer = true;
    public boolean useGyroscope = false;
    public boolean useCompass = true;
    public int touchSleepTime = 0;
    public boolean useWakelock = false;
    public boolean hideStatusBar = false;
    public boolean disableAudio = false;
    public int maxSimultaneousSounds = 16;
    public com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy resolutionStrategy = new com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy();
    public boolean getTouchEventsForLiveWallpaper = false;
    public boolean useImmersiveMode = false;

    @java.lang.Deprecated
    public boolean useGL30 = false;
    public boolean useGLSurfaceView20API18 = false;
}
