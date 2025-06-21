package com.sensorsdata.sf.core.thread;

/* loaded from: classes19.dex */
public class SFPlanTriggerRunnable implements java.lang.Runnable {
    private static final int POOL_SIZE = 1;
    private static final java.util.concurrent.ExecutorService mPool = java.util.concurrent.Executors.newFixedThreadPool(1);
    private volatile boolean isStop = false;
    private com.sensorsdata.sf.core.thread.SFPlanTaskManager mSFPlanTaskManager;

    /* renamed from: com.sensorsdata.sf.core.thread.SFPlanTriggerRunnable$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public SFPlanTriggerRunnable() {
        try {
            this.mSFPlanTaskManager = com.sensorsdata.sf.core.thread.SFPlanTaskManager.getInstance();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public boolean isStopped() {
        return this.isStop;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.isStop) {
            try {
                mPool.submit(this.mSFPlanTaskManager.getTriggerTask()).get();
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                return;
            }
        }
    }

    public void stop() {
        this.isStop = true;
        if (this.mSFPlanTaskManager.isEmpty()) {
            this.mSFPlanTaskManager.addTriggerTask(new com.sensorsdata.sf.core.thread.SFPlanTriggerRunnable.AnonymousClass1());
        }
    }
}
