package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public final class TaskExecutors {
    public static final com.huawei.hmf.tasks.TaskExecutors d = new com.huawei.hmf.tasks.TaskExecutors();
    public final java.util.concurrent.ExecutorService b = com.huawei.hmf.tasks.a.a.a();
    public final java.util.concurrent.Executor a = new com.huawei.hmf.tasks.TaskExecutors.ImmediateExecutor();
    public final java.util.concurrent.Executor c = com.huawei.hmf.tasks.a.a.b();

    public static final class ImmediateExecutor implements java.util.concurrent.Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(java.lang.Runnable runnable) {
            runnable.run();
        }
    }

    public static java.util.concurrent.ExecutorService a() {
        return d.b;
    }

    public static java.util.concurrent.Executor immediate() {
        return d.a;
    }

    public static java.util.concurrent.Executor uiThread() {
        return d.c;
    }
}
