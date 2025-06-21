package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fv {
    private static int b = 100;
    private static int d = 10000;
    private java.util.Vector<com.amap.api.mapcore.util.fs> a;
    private int c;
    private int e;

    public fv() {
        this.e = 0;
        this.c = 10;
        this.a = new java.util.Vector<>();
    }

    public fv(byte b2) {
        this.c = b;
        this.e = 0;
        this.a = new java.util.Vector<>();
    }

    public final java.util.Vector<com.amap.api.mapcore.util.fs> a() {
        return this.a;
    }

    public final synchronized void a(com.amap.api.mapcore.util.fs fsVar) {
        if (fsVar != null) {
            if (!android.text.TextUtils.isEmpty(fsVar.b())) {
                this.a.add(fsVar);
                this.e += fsVar.b().getBytes().length;
            }
        }
    }

    public final synchronized boolean a(java.lang.String str) {
        if (str == null) {
            return false;
        }
        if (this.a.size() >= this.c) {
            return true;
        }
        return this.e + str.getBytes().length > d;
    }

    public final synchronized void b() {
        this.a.clear();
        this.e = 0;
    }
}
