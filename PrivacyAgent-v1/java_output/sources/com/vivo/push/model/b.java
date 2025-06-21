package com.vivo.push.model;

/* loaded from: classes19.dex */
public final class b {
    private java.lang.String a;
    private java.lang.String d;
    private long b = -1;
    private int c = -1;
    private boolean e = false;
    private boolean f = false;

    public b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.a = str;
    }

    public final java.lang.String a() {
        return this.a;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final void a(java.lang.String str) {
        this.d = str;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final long b() {
        return this.b;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final boolean c() {
        return this.e;
    }

    public final boolean d() {
        return this.f;
    }

    public final java.lang.String toString() {
        return "PushPackageInfo{mPackageName=" + this.a + ", mPushVersion=" + this.b + ", mPackageVersion=" + this.c + ", mInBlackList=" + this.e + ", mPushEnable=" + this.f + com.alipay.sdk.m.u.i.d;
    }
}
