package com.huawei.hms.framework.network.grs.g.k;

/* loaded from: classes22.dex */
public class b {
    private final java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d> a;
    private final long b = android.os.SystemClock.elapsedRealtime();

    public b(java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.a = future;
    }

    public java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.a;
    }

    public boolean b() {
        return android.os.SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}
