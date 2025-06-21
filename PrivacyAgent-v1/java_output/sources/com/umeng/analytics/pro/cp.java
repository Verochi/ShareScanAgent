package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class cp implements java.io.Serializable {
    private final boolean a;
    public final byte b;
    private final java.lang.String c;
    private final boolean d;

    public cp(byte b) {
        this(b, false);
    }

    public cp(byte b, java.lang.String str) {
        this.b = b;
        this.a = true;
        this.c = str;
        this.d = false;
    }

    public cp(byte b, boolean z) {
        this.b = b;
        this.a = false;
        this.c = null;
        this.d = z;
    }

    public boolean a() {
        return this.a;
    }

    public java.lang.String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.d;
    }
}
