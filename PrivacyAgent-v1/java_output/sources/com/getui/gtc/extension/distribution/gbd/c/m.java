package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class m {
    private static final java.lang.String a = "117CBean";
    private java.lang.String b;
    private long c;
    private boolean d;
    private boolean e;

    private m(java.lang.String str, long j, boolean z, boolean z2) {
        this.b = str;
        this.c = j;
        this.d = z;
        this.e = z2;
    }

    private java.lang.String a() {
        return this.b;
    }

    private long b() {
        return this.c;
    }

    private boolean c() {
        return this.d;
    }

    private boolean d() {
        return this.e;
    }

    public final java.lang.String toString() {
        return "MdnsConfigBean{protocolType='" + this.b + "', timeInterval=" + this.c + ", reportTxtRecord=" + this.e + '}';
    }
}
