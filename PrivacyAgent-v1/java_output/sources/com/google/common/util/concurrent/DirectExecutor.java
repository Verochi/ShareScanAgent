package com.google.common.util.concurrent;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
enum DirectExecutor implements java.util.concurrent.Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
