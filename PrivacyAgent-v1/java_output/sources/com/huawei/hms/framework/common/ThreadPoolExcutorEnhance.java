package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class ThreadPoolExcutorEnhance extends java.util.concurrent.ThreadPoolExecutor {
    public ThreadPoolExcutorEnhance(int i, int i2, long j, java.util.concurrent.TimeUnit timeUnit, java.util.concurrent.BlockingQueue<java.lang.Runnable> blockingQueue, java.util.concurrent.ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(java.lang.Thread thread, java.lang.Runnable runnable) {
        if (runnable instanceof com.huawei.hms.framework.common.RunnableEnhance) {
            java.lang.String parentName = ((com.huawei.hms.framework.common.RunnableEnhance) runnable).getParentName();
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

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        super.execute(new com.huawei.hms.framework.common.RunnableEnhance(runnable));
    }
}
