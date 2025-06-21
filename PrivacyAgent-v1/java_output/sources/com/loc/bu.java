package com.loc;

/* loaded from: classes23.dex */
public abstract class bu {
    private java.lang.String d;
    private boolean e;
    private boolean f;
    com.loc.bp.a o;
    int l = 20000;
    int m = 20000;
    java.net.Proxy n = null;
    private boolean a = false;
    private int b = 20000;
    private boolean c = true;
    private com.loc.bu.a g = com.loc.bu.a.NORMAL;
    private com.loc.bu.b h = com.loc.bu.b.FIRST_NONDEGRADE;

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

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return c(map.get("platinfo"));
            }
            return null;
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "ht", "pnfh");
            return null;
        }
    }

    private java.lang.String b(java.lang.String str) {
        byte[] d = d();
        if (d == null || d.length == 0) {
            return str;
        }
        java.util.Map<java.lang.String, java.lang.String> e = e();
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.loc.bp.e;
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
        java.lang.String a2 = com.loc.bs.a(e);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(a2);
        return stringBuffer.toString();
    }

    private static java.lang.String c(java.lang.String str) {
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
                            if (!android.text.TextUtils.isEmpty(str4) && android.text.TextUtils.isEmpty(com.loc.ah.a(str3))) {
                                java.lang.String[] split3 = str4.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                                if (split3.length > 1) {
                                    com.loc.ah.a(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "ht", "pnfp");
        }
        return str3;
    }

    public abstract java.util.Map<java.lang.String, java.lang.String> a();

    public final void a(int i) {
        this.l = i;
    }

    public final void a(com.loc.bu.a aVar) {
        this.g = aVar;
    }

    public final void a(com.loc.bu.b bVar) {
        this.h = bVar;
    }

    public final void a(com.loc.bu.c cVar) {
        this.f = cVar == com.loc.bu.c.HTTPS;
    }

    public final void a(java.lang.String str) {
        this.d = str;
    }

    public final void a(java.net.Proxy proxy) {
        this.n = proxy;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public abstract java.lang.String b();

    public final void b(int i) {
        this.m = i;
    }

    public java.lang.String c() {
        return b();
    }

    public final void c(int i) {
        this.b = i;
    }

    public java.lang.String c_() {
        return "";
    }

    public byte[] d() {
        return null;
    }

    public abstract java.util.Map<java.lang.String, java.lang.String> e();

    public java.lang.String g() {
        return "";
    }

    public boolean h() {
        return this.c;
    }

    public final java.lang.String l() {
        return b(b());
    }

    public final java.lang.String m() {
        return b(c());
    }

    public final int n() {
        return this.l;
    }

    public final java.net.Proxy o() {
        return this.n;
    }

    public final com.loc.bu.a p() {
        return this.g;
    }

    public final boolean q() {
        return this.a;
    }

    public final void r() {
        this.a = true;
    }

    public final boolean s() {
        return this.f;
    }

    public final com.loc.bp.a t() {
        return this.o;
    }

    public final com.loc.bu.b u() {
        return this.h;
    }

    public final int v() {
        return this.b;
    }

    public final void w() {
        this.c = false;
    }

    public final java.lang.String x() {
        return this.d;
    }

    public final boolean y() {
        return this.e;
    }

    public final java.lang.String z() {
        java.lang.String str;
        try {
            str = c_();
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    str = this.a ? c(((com.loc.bq) this).j()) : a(a());
                }
            } catch (java.lang.Throwable th) {
                th = th;
                com.loc.at.a(th, "ht", "pnfr");
                return str;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str = "";
        }
        return str;
    }
}
