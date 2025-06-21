package com.sensorsdata.analytics.android.sdk.monitor;

/* loaded from: classes19.dex */
public class SensorsDataLifecycleMonitorManager {
    private static final com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager instance = new com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager();
    private final com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks mCallback = new com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks();

    private SensorsDataLifecycleMonitorManager() {
    }

    public static com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager getInstance() {
        return instance;
    }

    public void addActivityLifeCallback(com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        this.mCallback.addActivityLifecycleCallbacks(sAActivityLifecycleCallbacks);
    }

    public void addCrashListener(com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.addExceptionListener(sAExceptionListener);
    }

    public com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks getCallback() {
        return this.mCallback;
    }

    public void removeActivityLifeCallback(com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        this.mCallback.removeActivityLifecycleCallbacks(sAActivityLifecycleCallbacks);
    }

    public void removeCrashListener(com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler.removeExceptionListener(sAExceptionListener);
    }
}
