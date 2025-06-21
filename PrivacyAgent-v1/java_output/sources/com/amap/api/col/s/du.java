package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class du extends com.amap.api.col.s.dy {
    public int d;
    public java.lang.String e;

    public du(java.lang.String str, com.amap.api.col.s.dy dyVar) {
        super(dyVar);
        this.d = 30;
        this.e = str;
    }

    public static int d(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.s.dy
    public final boolean a() {
        return d(this.e) >= this.d;
    }
}
