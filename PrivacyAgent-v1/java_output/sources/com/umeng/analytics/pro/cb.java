package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class cb extends com.umeng.analytics.pro.ci {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final com.umeng.analytics.pro.dg j = new com.umeng.analytics.pro.dg("TApplicationException");
    private static final com.umeng.analytics.pro.cw k = new com.umeng.analytics.pro.cw("message", (byte) 11, 1);
    private static final com.umeng.analytics.pro.cw l = new com.umeng.analytics.pro.cw("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public cb() {
        this.i = 0;
    }

    public cb(int i) {
        this.i = i;
    }

    public cb(int i, java.lang.String str) {
        super(str);
        this.i = i;
    }

    public cb(java.lang.String str) {
        super(str);
        this.i = 0;
    }

    public static com.umeng.analytics.pro.cb a(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        dbVar.j();
        java.lang.String str = null;
        int i = 0;
        while (true) {
            com.umeng.analytics.pro.cw l2 = dbVar.l();
            byte b2 = l2.b;
            if (b2 == 0) {
                dbVar.k();
                return new com.umeng.analytics.pro.cb(i, str);
            }
            short s2 = l2.c;
            if (s2 != 1) {
                if (s2 != 2) {
                    com.umeng.analytics.pro.de.a(dbVar, b2);
                } else if (b2 == 8) {
                    i = dbVar.w();
                } else {
                    com.umeng.analytics.pro.de.a(dbVar, b2);
                }
            } else if (b2 == 11) {
                str = dbVar.z();
            } else {
                com.umeng.analytics.pro.de.a(dbVar, b2);
            }
            dbVar.m();
        }
    }

    public int a() {
        return this.i;
    }

    public void b(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        dbVar.a(j);
        if (getMessage() != null) {
            dbVar.a(k);
            dbVar.a(getMessage());
            dbVar.c();
        }
        dbVar.a(l);
        dbVar.a(this.i);
        dbVar.c();
        dbVar.d();
        dbVar.b();
    }
}
