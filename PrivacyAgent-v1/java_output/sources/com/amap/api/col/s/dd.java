package com.amap.api.col.s;

/* loaded from: classes12.dex */
public abstract class dd {
    public com.amap.api.col.s.cx.a j;
    public java.lang.String n;
    public boolean o;
    public boolean p;
    public int g = 20000;
    public int h = 20000;
    public java.net.Proxy i = null;
    public boolean k = false;
    public int l = 20000;
    public boolean m = true;
    public com.amap.api.col.s.dd.a q = com.amap.api.col.s.dd.a.NORMAL;
    public com.amap.api.col.s.dd.b r = com.amap.api.col.s.dd.b.FIRST_NONDEGRADE;

    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);

        private int f;

        a(int i) {
            this.f = i;
        }
    }

    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);

        private int h;

        b(int i2) {
            this.h = i2;
        }

        public final int a() {
            return this.h;
        }

        public final boolean b() {
            int i2 = this.h;
            return i2 == FIRST_NONDEGRADE.h || i2 == NEVER_GRADE.h || i2 == FIX_NONDEGRADE.h;
        }

        public final boolean c() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == DEGRADE_ONLY.h || i2 == FIX_DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_ONLY.h;
        }

        public final boolean d() {
            int i2 = this.h;
            return i2 == DEGRADE_BYERROR.h || i2 == FIX_DEGRADE_BYERROR.h;
        }

        public final boolean e() {
            return this.h == NEVER_GRADE.h;
        }
    }

    public enum c {
        HTTP(0),
        HTTPS(1);

        private int c;

        c(int i) {
            this.c = i;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3 = "";
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i = 0;
                    java.lang.String str4 = "";
                    while (true) {
                        if (i >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i++;
                    }
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        java.lang.String[] split2 = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!android.text.TextUtils.isEmpty(str4) && android.text.TextUtils.isEmpty(com.amap.api.col.s.cd.a(str3))) {
                                java.lang.String[] split3 = str4.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                                if (split3.length > 1) {
                                    com.amap.api.col.s.cd.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "ht", "pnfp");
        }
        return str3;
    }

    public static java.lang.String f(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return b(map.get("platinfo"));
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "ht", "pnfh");
            return null;
        }
    }

    public java.lang.String a() {
        return h();
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void a(com.amap.api.col.s.dd.a aVar) {
        this.q = aVar;
    }

    public final void a(com.amap.api.col.s.dd.b bVar) {
        this.r = bVar;
    }

    public final void a(com.amap.api.col.s.dd.c cVar) {
        this.p = cVar == com.amap.api.col.s.dd.c.HTTPS;
    }

    public final void b(int i) {
        this.h = i;
    }

    public boolean b_() {
        return this.m;
    }

    public java.lang.String c() {
        return "";
    }

    public final void c(int i) {
        this.l = i;
    }

    public final void d(java.lang.String str) {
        this.n = str;
    }

    public final java.lang.String e(java.lang.String str) {
        byte[] g = g();
        if (g == null || g.length == 0) {
            return str;
        }
        java.util.Map<java.lang.String, java.lang.String> e = e();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.col.s.cx.e;
        if (hashMap != null) {
            if (e != null) {
                e.putAll(hashMap);
            } else {
                e = hashMap;
            }
        }
        if (e == null) {
            return str;
        }
        java.lang.String g2 = com.amap.api.col.s.da.g(e);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(g2);
        return stringBuffer.toString();
    }

    public abstract java.util.Map<java.lang.String, java.lang.String> e();

    public abstract java.util.Map<java.lang.String, java.lang.String> f();

    public byte[] g() {
        return null;
    }

    public abstract java.lang.String h();

    public java.lang.String i() {
        return "";
    }

    public final java.lang.String k() {
        return e(h());
    }

    public final java.lang.String l() {
        return e(a());
    }

    public final int m() {
        return this.g;
    }

    public final java.net.Proxy n() {
        return this.i;
    }

    public final com.amap.api.col.s.dd.a o() {
        return this.q;
    }

    public final boolean p() {
        return this.k;
    }

    public final void q() {
        this.k = true;
    }

    public final boolean r() {
        return this.p;
    }

    public final com.amap.api.col.s.cx.a s() {
        return this.j;
    }

    public final com.amap.api.col.s.dd.b t() {
        return this.r;
    }

    public final int u() {
        return this.l;
    }

    public final void v() {
        this.m = false;
    }

    public final java.lang.String w() {
        return this.n;
    }

    public final boolean x() {
        return this.o;
    }

    public final java.lang.String y() {
        java.lang.String str;
        try {
            str = c();
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    str = this.k ? b(((com.amap.api.col.s.cy) this).j()) : f(f());
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.amap.api.col.s.cg.a(th, "ht", "pnfr");
                return str;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "";
        }
        return str;
    }
}
