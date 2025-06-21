package com.hihonor.push.sdk.tasks;

/* loaded from: classes22.dex */
public final class TaskExecutors {
    private static final com.hihonor.push.sdk.tasks.TaskExecutors INSTANCE = new com.hihonor.push.sdk.tasks.TaskExecutors();
    private final java.util.concurrent.Executor mUiThread = com.hihonor.push.sdk.w.c();
    private final java.util.concurrent.Executor mImmediate = com.hihonor.push.sdk.w.b();
    private final java.util.concurrent.ExecutorService mBackground = com.hihonor.push.sdk.w.a();

    private TaskExecutors() {
    }

    public static java.util.concurrent.ExecutorService background() {
        return INSTANCE.mBackground;
    }

    public static java.util.concurrent.Executor immediate() {
        return INSTANCE.mImmediate;
    }

    public static java.util.concurrent.Executor uiThread() {
        return INSTANCE.mUiThread;
    }
}
