package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ScheduledThreadPoolExecutorEnhance extends java.util.concurrent.ScheduledThreadPoolExecutor {
    private static final java.lang.String TAG = "ScheduledThreadPoolExec";

    public ScheduledThreadPoolExecutorEnhance(int i, java.util.concurrent.ThreadFactory threadFactory) {
        super(i, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(java.lang.Thread thread, java.lang.Runnable runnable) {
        if (runnable instanceof com.huawei.hms.framework.common.RunnableScheduledFutureEnhance) {
            java.lang.String parentName = ((com.huawei.hms.framework.common.RunnableScheduledFutureEnhance) runnable).getParentName();
            int lastIndexOf = parentName.lastIndexOf(" -->");
            if (lastIndexOf != -1) {
                parentName = com.huawei.hms.framework.common.StringUtils.substring(parentName, lastIndexOf + 4);
            }
            java.lang.String name = thread.getName();
            int lastIndexOf2 = name.lastIndexOf(" -->");
            if (lastIndexOf2 != -1) {
                name = com.huawei.hms.framework.common.StringUtils.substring(name, lastIndexOf2 + 4);
            }
            thread.setName(parentName + " -->" + name);
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(java.lang.Runnable runnable, java.util.concurrent.RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new com.huawei.hms.framework.common.RunnableScheduledFutureEnhance(super.decorateTask(runnable, runnableScheduledFuture));
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    public <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(java.util.concurrent.Callable<V> callable, java.util.concurrent.RunnableScheduledFuture<V> runnableScheduledFuture) {
        return new com.huawei.hms.framework.common.RunnableScheduledFutureEnhance(super.decorateTask(callable, runnableScheduledFuture));
    }
}
