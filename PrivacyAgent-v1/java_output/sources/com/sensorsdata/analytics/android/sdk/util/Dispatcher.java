package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class Dispatcher {
    private static final java.lang.String TAG = "Dispatcher";
    private final android.os.Handler mHandler;
    private android.os.Handler mUiThreadHandler;

    public static class DispatchHolder {
        private static final com.sensorsdata.analytics.android.sdk.util.Dispatcher INSTANCE = new com.sensorsdata.analytics.android.sdk.util.Dispatcher(null);

        private DispatchHolder() {
        }
    }

    private Dispatcher() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new android.os.Handler(handlerThread.getLooper());
    }

    public /* synthetic */ Dispatcher(com.sensorsdata.analytics.android.sdk.util.Dispatcher.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.sensorsdata.analytics.android.sdk.util.Dispatcher getInstance() {
        return com.sensorsdata.analytics.android.sdk.util.Dispatcher.DispatchHolder.INSTANCE;
    }

    public synchronized android.os.Handler getUiThreadHandler() {
        try {
            if (this.mUiThreadHandler == null) {
                this.mUiThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
        return this.mUiThreadHandler;
    }

    public void post(java.lang.Runnable runnable) {
        postDelayed(runnable, 0L);
    }

    public void postDelayed(java.lang.Runnable runnable, long j) {
        this.mHandler.removeCallbacks(runnable);
        this.mHandler.postDelayed(runnable, j);
    }

    public void removeCallbacksAndMessages() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
