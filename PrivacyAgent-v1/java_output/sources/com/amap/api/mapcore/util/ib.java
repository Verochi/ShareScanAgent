package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ib extends com.amap.api.mapcore.util.Cif {
    private int a;
    private java.lang.String b;

    public ib(java.lang.String str, com.amap.api.mapcore.util.Cif cif) {
        super(cif);
        this.a = 30;
        this.b = str;
    }

    private static int a(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.mapcore.util.Cif
    public final boolean c() {
        return a(this.b) >= this.a;
    }
}
