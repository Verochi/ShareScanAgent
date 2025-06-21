package com.amap.api.mapcore.util;

/* renamed from: com.amap.api.mapcore.util.if, reason: invalid class name */
/* loaded from: classes12.dex */
public abstract class Cif {
    com.amap.api.mapcore.util.Cif c;

    public Cif() {
    }

    public Cif(com.amap.api.mapcore.util.Cif cif) {
        this.c = cif;
    }

    public int a() {
        com.amap.api.mapcore.util.Cif cif = this.c;
        return java.lang.Math.min(Integer.MAX_VALUE, cif != null ? cif.a() : Integer.MAX_VALUE);
    }

    public void a_(int i) {
        com.amap.api.mapcore.util.Cif cif = this.c;
        if (cif != null) {
            cif.a_(i);
        }
    }

    public void a_(boolean z) {
        com.amap.api.mapcore.util.Cif cif = this.c;
        if (cif != null) {
            cif.a_(z);
        }
    }

    public abstract boolean c();

    public final boolean d() {
        com.amap.api.mapcore.util.Cif cif = this.c;
        if (cif != null ? cif.d() : true) {
            return c();
        }
        return false;
    }
}
