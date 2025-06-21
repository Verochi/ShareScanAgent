package com.loc;

@com.loc.bb(a = "c")
/* loaded from: classes23.dex */
public class fm {

    @com.loc.bc(a = "a2", b = 6)
    private java.lang.String a;

    @com.loc.bc(a = "a3", b = 5)
    private long b;

    @com.loc.bc(a = "a4", b = 6)
    private java.lang.String c;
    private com.amap.api.location.AMapLocation d;

    public final com.amap.api.location.AMapLocation a() {
        return this.d;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final void a(com.amap.api.location.AMapLocation aMapLocation) {
        this.d = aMapLocation;
    }

    public final void a(java.lang.String str) {
        this.c = str;
    }

    public final java.lang.String b() {
        return this.c;
    }

    public final void b(java.lang.String str) {
        this.a = str;
    }

    public final java.lang.String c() {
        return this.a;
    }

    public final long d() {
        return this.b;
    }
}
