package com.huawei.hmf.tasks.a;

/* loaded from: classes22.dex */
public final class c extends com.huawei.hmf.tasks.CancellationToken {
    public final java.util.List<java.lang.Runnable> a = new java.util.ArrayList();
    public final java.lang.Object b = new java.lang.Object();
    public boolean c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final com.huawei.hmf.tasks.CancellationToken register(java.lang.Runnable runnable) {
        synchronized (this.b) {
            if (this.c) {
                runnable.run();
            } else {
                this.a.add(runnable);
            }
        }
        return this;
    }
}
