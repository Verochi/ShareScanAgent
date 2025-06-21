package com.sensorsdata.analytics.android.sdk.core.tasks;

/* loaded from: classes19.dex */
public class TrackTaskManagerThread implements java.lang.Runnable {
    private static final int POOL_SIZE = 1;
    private boolean isStop = false;
    private java.util.concurrent.ExecutorService mPool;
    private com.sensorsdata.analytics.android.sdk.TrackTaskManager mTrackTaskManager;

    /* renamed from: com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants.THREAD_TASK_EXECUTE);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public TrackTaskManagerThread() {
        try {
            this.mTrackTaskManager = com.sensorsdata.analytics.android.sdk.TrackTaskManager.getInstance();
            this.mPool = new java.util.concurrent.ThreadPoolExecutor(1, 1, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread.AnonymousClass1());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public boolean isStopped() {
        return this.isStop;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.isStop) {
            try {
                this.mPool.execute(this.mTrackTaskManager.takeTrackEventTask());
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
        }
        while (true) {
            java.lang.Runnable pollTrackEventTask = this.mTrackTaskManager.pollTrackEventTask();
            if (pollTrackEventTask == null) {
                this.mPool.shutdown();
                return;
            }
            this.mPool.execute(pollTrackEventTask);
        }
    }

    public void stop() {
        this.isStop = true;
        if (this.mTrackTaskManager.isEmpty()) {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread.AnonymousClass2());
        }
    }
}
