package com.igexin.base.scheduler.task;

/* loaded from: classes22.dex */
public abstract class SimpleTask extends com.igexin.base.scheduler.BaseTask {
    public SimpleTask() {
        super(0L, java.util.concurrent.TimeUnit.MILLISECONDS);
        setTaskLevel(com.igexin.base.api.GTSchedulerManager.TASKLEVEL.LEVEL_DEFAULT);
    }
}
