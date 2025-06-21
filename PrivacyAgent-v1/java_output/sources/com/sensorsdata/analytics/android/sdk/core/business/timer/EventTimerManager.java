package com.sensorsdata.analytics.android.sdk.core.business.timer;

/* loaded from: classes19.dex */
public class EventTimerManager {
    private final java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer> mTrackTimer;

    public static class SingletonHolder {
        private static final com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager mInstance = new com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager(null);

        private SingletonHolder() {
        }
    }

    private EventTimerManager() {
        this.mTrackTimer = new java.util.HashMap();
    }

    public /* synthetic */ EventTimerManager(com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static synchronized com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager getInstance() {
        com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager eventTimerManager;
        synchronized (com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.class) {
            eventTimerManager = com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.SingletonHolder.mInstance;
        }
        return eventTimerManager;
    }

    public void addEventTimer(java.lang.String str, com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer eventTimer) {
        synchronized (this.mTrackTimer) {
            this.mTrackTimer.put(str, eventTimer);
        }
    }

    public void appBecomeActive() {
        com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer value;
        synchronized (this.mTrackTimer) {
            try {
                for (java.util.Map.Entry<java.lang.String, com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer> entry : this.mTrackTimer.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.setStartTime(android.os.SystemClock.elapsedRealtime());
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public void appEnterBackground() {
        com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer value;
        synchronized (this.mTrackTimer) {
            try {
                for (java.util.Map.Entry<java.lang.String, com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer> entry : this.mTrackTimer.entrySet()) {
                    if (entry != null && !"$AppEnd".equals(entry.getKey()) && (value = entry.getValue()) != null && !value.isPaused()) {
                        value.setEventAccumulatedDuration((value.getEventAccumulatedDuration() + android.os.SystemClock.elapsedRealtime()) - value.getStartTime());
                        value.setStartTime(android.os.SystemClock.elapsedRealtime());
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public void clearTimers() {
        try {
            synchronized (this.mTrackTimer) {
                this.mTrackTimer.clear();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer getEventTimer(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer eventTimer;
        synchronized (this.mTrackTimer) {
            eventTimer = this.mTrackTimer.get(str);
            this.mTrackTimer.remove(str);
        }
        return eventTimer;
    }

    public void removeTimer(java.lang.String str) {
        synchronized (this.mTrackTimer) {
            this.mTrackTimer.remove(str);
        }
    }

    public void updateEndTime(java.lang.String str, long j) {
        synchronized (this.mTrackTimer) {
            com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer eventTimer = this.mTrackTimer.get(str);
            if (eventTimer != null) {
                eventTimer.setEndTime(j);
            }
        }
    }

    public void updateTimerState(java.lang.String str, long j, boolean z) {
        try {
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertEventName(str);
            synchronized (this.mTrackTimer) {
                com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer eventTimer = this.mTrackTimer.get(str);
                if (eventTimer != null && eventTimer.isPaused() != z) {
                    eventTimer.setTimerState(z, j);
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
