package com.loc;

/* loaded from: classes23.dex */
public abstract class eb implements java.io.Serializable {
    public java.lang.String a;
    public java.lang.String b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public eb() {
        this.a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.i = true;
    }

    public eb(boolean z, boolean z2) {
        this.a = "";
        this.b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0L;
        this.f = 0L;
        this.g = 0;
        this.h = z;
        this.i = z2;
    }

    private static int a(java.lang.String str) {
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception e) {
            com.loc.el.a(e);
            return 0;
        }
    }

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract com.loc.eb clone();

    public final void a(com.loc.eb ebVar) {
        this.a = ebVar.a;
        this.b = ebVar.b;
        this.c = ebVar.c;
        this.d = ebVar.d;
        this.e = ebVar.e;
        this.f = ebVar.f;
        this.g = ebVar.g;
        this.h = ebVar.h;
        this.i = ebVar.i;
    }

    public final int b() {
        return a(this.a);
    }

    public final int c() {
        return a(this.b);
    }

    public java.lang.String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
