package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class bv {
    public static com.amap.api.col.s.bv c;
    public final android.content.Context a;
    public final java.lang.String b = com.amap.api.col.s.cc.a(com.amap.api.col.s.bu.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    public bv(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    public static com.amap.api.col.s.bv a(android.content.Context context) {
        if (c == null) {
            synchronized (com.amap.api.col.s.bv.class) {
                if (c == null) {
                    c = new com.amap.api.col.s.bv(context);
                }
            }
        }
        return c;
    }

    public final synchronized void a() {
        try {
            if (com.amap.api.col.s.bm.c() == null) {
                com.amap.api.col.s.bm.a(com.amap.api.col.s.bz.a());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.lang.String str) {
        com.amap.api.col.s.bw.a(this.a).a(this.b);
        com.amap.api.col.s.bw.a(this.a).b(str);
    }
}
