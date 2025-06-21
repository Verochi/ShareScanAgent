package com.sensorsdata.analytics.android.sdk.core.business.timer;

/* loaded from: classes19.dex */
public class EventTimer {
    private long startTime;
    private final java.util.concurrent.TimeUnit timeUnit;
    private boolean isPaused = false;
    private long eventAccumulatedDuration = 0;
    private long endTime = -1;

    public EventTimer(java.util.concurrent.TimeUnit timeUnit, long j) {
        this.startTime = j;
        this.timeUnit = timeUnit;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #0 {Exception -> 0x005d, blocks: (B:9:0x002c, B:11:0x0034, B:17:0x0054, B:21:0x0036, B:23:0x003a, B:24:0x003d, B:26:0x0043, B:27:0x0045, B:28:0x0047, B:30:0x004b), top: B:8:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float duration() {
        float f;
        float f2;
        if (this.isPaused) {
            this.endTime = this.startTime;
        } else {
            long j = this.endTime;
            if (j < 0) {
                j = android.os.SystemClock.elapsedRealtime();
            }
            this.endTime = j;
        }
        long j2 = (this.endTime - this.startTime) + this.eventAccumulatedDuration;
        if (j2 >= 0 && j2 <= 86400000) {
            try {
                java.util.concurrent.TimeUnit timeUnit = this.timeUnit;
                if (timeUnit != java.util.concurrent.TimeUnit.MILLISECONDS) {
                    if (timeUnit == java.util.concurrent.TimeUnit.SECONDS) {
                        f2 = j2 / 1000.0f;
                    } else {
                        if (timeUnit == java.util.concurrent.TimeUnit.MINUTES) {
                            f = j2 / 1000.0f;
                        } else if (timeUnit == java.util.concurrent.TimeUnit.HOURS) {
                            f = (j2 / 1000.0f) / 60.0f;
                        }
                        f2 = f / 60.0f;
                    }
                    if (f2 >= 0.0f) {
                        return 0.0f;
                    }
                    return java.lang.Math.round(f2 * 1000.0f) / 1000.0f;
                }
                f2 = j2;
                if (f2 >= 0.0f) {
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
        return 0.0f;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getEventAccumulatedDuration() {
        return this.eventAccumulatedDuration;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setEventAccumulatedDuration(long j) {
        this.eventAccumulatedDuration = j;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setTimerState(boolean z, long j) {
        this.isPaused = z;
        if (z) {
            this.eventAccumulatedDuration = (this.eventAccumulatedDuration + j) - this.startTime;
        }
        this.startTime = j;
    }
}
