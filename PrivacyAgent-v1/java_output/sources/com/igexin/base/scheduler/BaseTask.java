package com.igexin.base.scheduler;

/* loaded from: classes22.dex */
public abstract class BaseTask implements java.lang.Runnable {
    private static final java.lang.String TAG = "BaseTask";
    private java.lang.String groupName;
    private long initDelay;
    private volatile int isRunVal;
    private com.igexin.base.scheduler.b.a mParent;
    private long period;
    private java.util.concurrent.atomic.AtomicBoolean isCanceled = new java.util.concurrent.atomic.AtomicBoolean();
    private com.igexin.base.api.GTSchedulerManager.TASKLEVEL taskLevel = com.igexin.base.api.GTSchedulerManager.TASKLEVEL.LEVEL_DEFAULT;

    public BaseTask(long j, long j2, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        setDelayImpl(j, j2, timeUnit, z);
    }

    public BaseTask(long j, java.util.concurrent.TimeUnit timeUnit) {
        setDelayImpl(j, 0L, timeUnit, true);
    }

    private void setDelayImpl(long j, long j2, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        java.util.concurrent.TimeUnit timeUnit2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        this.initDelay = timeUnit2.convert(j, timeUnit);
        this.period = (z ? 1 : -1) * timeUnit2.convert(j2, timeUnit);
    }

    public void bind(com.igexin.base.scheduler.b.a aVar) {
        if (aVar == null) {
            return;
        }
        this.mParent = aVar;
    }

    public boolean cancel() {
        com.igexin.base.scheduler.b.a aVar = this.mParent;
        if (aVar != null) {
            return aVar.cancel(false);
        }
        this.isCanceled.set(true);
        return true;
    }

    public void done() {
    }

    public java.lang.String getGroupName() {
        return this.groupName;
    }

    public long getInitDelay() {
        return this.initDelay;
    }

    public long getPeriod() {
        return this.period;
    }

    public int getTaskLevel() {
        return this.taskLevel.val;
    }

    public boolean interrupt() {
        com.igexin.base.scheduler.b.a aVar = this.mParent;
        if (aVar != null) {
            return aVar.cancel(true);
        }
        this.isCanceled.set(true);
        return true;
    }

    public boolean isPeriodic() {
        return this.period != 0;
    }

    public boolean isRunning() {
        return this.isRunVal != 0;
    }

    public void onCancel() {
    }

    public void onException(java.lang.Throwable th) {
    }

    public abstract void onRunTask();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.isCanceled.get()) {
            return;
        }
        setIsRunning(true);
        onRunTask();
    }

    public void setDelay(long j, long j2, java.util.concurrent.TimeUnit timeUnit, boolean z) {
        setDelayImpl(j, j2, timeUnit, z);
    }

    public void setDelay(long j, java.util.concurrent.TimeUnit timeUnit) {
        setDelayImpl(j, 0L, timeUnit, true);
    }

    public void setGroupName(java.lang.String str) {
        this.groupName = str;
    }

    public void setIsRunning(boolean z) {
        this.isRunVal = z ? 1 : 0;
    }

    public void setTaskLevel(com.igexin.base.api.GTSchedulerManager.TASKLEVEL tasklevel) {
        this.taskLevel = tasklevel;
    }
}
