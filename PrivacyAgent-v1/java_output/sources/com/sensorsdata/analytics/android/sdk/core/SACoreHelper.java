package com.sensorsdata.analytics.android.sdk.core;

/* loaded from: classes19.dex */
public class SACoreHelper {
    private static final java.lang.String TAG = "SA.EventManager";
    private static volatile com.sensorsdata.analytics.android.sdk.core.SACoreHelper mSingleton;

    private SACoreHelper() {
    }

    public static com.sensorsdata.analytics.android.sdk.core.SACoreHelper getInstance() {
        if (mSingleton == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.core.SACoreHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new com.sensorsdata.analytics.android.sdk.core.SACoreHelper();
                }
            }
        }
        return mSingleton;
    }

    public void trackEvent(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        try {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().trackEvent(inputData);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void trackQueueEvent(java.lang.Runnable runnable) {
        try {
            com.sensorsdata.analytics.android.sdk.TrackTaskManager.getInstance().addTrackEventTask(runnable);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
