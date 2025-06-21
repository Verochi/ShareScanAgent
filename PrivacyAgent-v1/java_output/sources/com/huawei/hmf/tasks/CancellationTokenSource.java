package com.huawei.hmf.tasks;

/* loaded from: classes22.dex */
public class CancellationTokenSource {
    public com.huawei.hmf.tasks.a.c a = new com.huawei.hmf.tasks.a.c();

    public void cancel() {
        com.huawei.hmf.tasks.a.c cVar = this.a;
        if (cVar.c) {
            return;
        }
        synchronized (cVar.b) {
            cVar.c = true;
            java.util.Iterator<java.lang.Runnable> it = cVar.a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public com.huawei.hmf.tasks.CancellationToken getToken() {
        return this.a;
    }
}
