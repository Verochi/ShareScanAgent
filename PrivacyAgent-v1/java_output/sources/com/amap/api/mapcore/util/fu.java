package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fu extends com.amap.api.mapcore.util.Cif {
    private static int g = 10000000;
    protected int a;
    protected long b;
    private boolean d;
    private boolean e;
    private int f;
    private long h;

    public fu(boolean z, com.amap.api.mapcore.util.Cif cif, long j, int i) {
        super(cif);
        this.e = false;
        this.d = z;
        this.a = 600000;
        this.h = j;
        this.f = i;
    }

    @Override // com.amap.api.mapcore.util.Cif
    public final int a() {
        return 320000;
    }

    public final void a(int i) {
        if (i <= 0) {
            return;
        }
        this.h += i;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final long b() {
        return this.h;
    }

    @Override // com.amap.api.mapcore.util.Cif
    public final boolean c() {
        if (this.e && this.h <= this.f) {
            return true;
        }
        if (!this.d || this.h >= this.f) {
            return false;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.b < this.a) {
            return false;
        }
        this.b = currentTimeMillis;
        return true;
    }
}
