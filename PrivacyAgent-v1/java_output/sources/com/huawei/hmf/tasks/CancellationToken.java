package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract com.huawei.hmf.tasks.CancellationToken register(java.lang.Runnable runnable);
}
