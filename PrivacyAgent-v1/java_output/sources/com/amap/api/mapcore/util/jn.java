package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public abstract class jn {
    public java.lang.String a = "";
    public java.lang.String b = "";
    public int c = 99;
    public int d = Integer.MAX_VALUE;
    public long e = 0;
    public long f = 0;
    public int g = 0;
    public boolean h;
    public boolean i;

    public jn(boolean z, boolean z2) {
        this.h = z;
        this.i = z2;
    }

    @Override // 
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract com.amap.api.mapcore.util.jn clone();

    public final void a(com.amap.api.mapcore.util.jn jnVar) {
        this.a = jnVar.a;
        this.b = jnVar.b;
        this.c = jnVar.c;
        this.d = jnVar.d;
        this.e = jnVar.e;
        this.f = jnVar.f;
        this.g = jnVar.g;
        this.h = jnVar.h;
        this.i = jnVar.i;
    }

    public java.lang.String toString() {
        return "AmapCell{mcc=" + this.a + ", mnc=" + this.b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
