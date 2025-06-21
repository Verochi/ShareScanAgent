package com.sensorsdata.sf.core.thread;

/* loaded from: classes19.dex */
public class SFPlanTaskManager {
    private static com.sensorsdata.sf.core.thread.SFPlanTaskManager mSFPlanTriggerManager;
    private final java.util.concurrent.LinkedBlockingQueue<java.lang.Runnable> mTriggerQueue = new java.util.concurrent.LinkedBlockingQueue<>();

    private SFPlanTaskManager() {
    }

    public static synchronized com.sensorsdata.sf.core.thread.SFPlanTaskManager getInstance() {
        com.sensorsdata.sf.core.thread.SFPlanTaskManager sFPlanTaskManager;
        synchronized (com.sensorsdata.sf.core.thread.SFPlanTaskManager.class) {
            try {
                if (mSFPlanTriggerManager == null) {
                    mSFPlanTriggerManager = new com.sensorsdata.sf.core.thread.SFPlanTaskManager();
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
            sFPlanTaskManager = mSFPlanTriggerManager;
        }
        return sFPlanTaskManager;
    }

    public void addTriggerTask(java.lang.Runnable runnable) {
        try {
            synchronized (this.mTriggerQueue) {
                this.mTriggerQueue.put(runnable);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public java.lang.Runnable getTriggerTask() {
        try {
            return this.mTriggerQueue.take();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public boolean isEmpty() {
        return this.mTriggerQueue.isEmpty();
    }
}
