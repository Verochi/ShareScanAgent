package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public class TrackTaskManager {
    private static com.sensorsdata.analytics.android.sdk.TrackTaskManager trackTaskManager;
    private final java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> mTrackEventTasks = new java.util.concurrent.LinkedBlockingQueue<>();

    private TrackTaskManager() {
    }

    public static synchronized com.sensorsdata.analytics.android.sdk.TrackTaskManager getInstance() {
        com.sensorsdata.analytics.android.sdk.TrackTaskManager trackTaskManager2;
        synchronized (com.sensorsdata.analytics.android.sdk.TrackTaskManager.class) {
            try {
                if (trackTaskManager == null) {
                    trackTaskManager = new com.sensorsdata.analytics.android.sdk.TrackTaskManager();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            trackTaskManager2 = trackTaskManager;
        }
        return trackTaskManager2;
    }

    public void addTrackEventTask(java.lang.Runnable runnable) {
        try {
            this.mTrackEventTasks.put(runnable);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public boolean isEmpty() {
        return this.mTrackEventTasks.isEmpty();
    }

    public java.lang.Runnable pollTrackEventTask() {
        try {
            return this.mTrackEventTasks.poll();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public java.lang.Runnable takeTrackEventTask() {
        try {
            return this.mTrackEventTasks.take();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }
}
