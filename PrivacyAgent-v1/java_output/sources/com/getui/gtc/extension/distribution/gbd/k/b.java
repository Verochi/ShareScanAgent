package com.getui.gtc.extension.distribution.gbd.k;

/* loaded from: classes22.dex */
public abstract class b {
    protected long a = 0;
    protected long b = 0;

    public abstract void a();

    public void a(long j) {
        this.a = j;
    }

    public boolean b() {
        return java.lang.System.currentTimeMillis() - this.a > this.b;
    }

    public abstract boolean c();

    public abstract int d();
}
