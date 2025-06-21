package com.amap.api.mapcore.util;

@com.amap.api.mapcore.util.gi(a = "a")
/* loaded from: classes12.dex */
public final class fh {

    @com.amap.api.mapcore.util.gj(a = "a1", b = 6)
    private java.lang.String a;

    @com.amap.api.mapcore.util.gj(a = "a2", b = 6)
    private java.lang.String b;

    @com.amap.api.mapcore.util.gj(a = "a6", b = 2)
    private int c;

    @com.amap.api.mapcore.util.gj(a = "a3", b = 6)
    private java.lang.String d;

    @com.amap.api.mapcore.util.gj(a = "a4", b = 6)
    private java.lang.String e;

    @com.amap.api.mapcore.util.gj(a = "a5", b = 6)
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String[] l;

    public static class a {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String d;
        private boolean e = true;
        private java.lang.String f = "standard";
        private java.lang.String[] g = null;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final com.amap.api.mapcore.util.fh.a a(java.lang.String str) {
            this.b = str;
            return this;
        }

        public final com.amap.api.mapcore.util.fh.a a(java.lang.String[] strArr) {
            if (strArr != null) {
                this.g = (java.lang.String[]) strArr.clone();
            }
            return this;
        }

        public final com.amap.api.mapcore.util.fh a() throws com.amap.api.mapcore.util.eu {
            if (this.g != null) {
                return new com.amap.api.mapcore.util.fh(this, (byte) 0);
            }
            throw new com.amap.api.mapcore.util.eu("sdk packages is null");
        }
    }

    private fh() {
        this.c = 1;
        this.l = null;
    }

    private fh(com.amap.api.mapcore.util.fh.a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = com.amap.api.mapcore.util.fi.b(this.h);
        this.a = com.amap.api.mapcore.util.fi.b(this.j);
        this.d = com.amap.api.mapcore.util.fi.b(this.i);
        this.e = com.amap.api.mapcore.util.fi.b(a(this.l));
        this.f = com.amap.api.mapcore.util.fi.b(this.k);
    }

    public /* synthetic */ fh(com.amap.api.mapcore.util.fh.a aVar, byte b) {
        this(aVar);
    }

    private static java.lang.String a(java.lang.String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : strArr) {
                sb.append(str);
                sb.append(com.alipay.sdk.m.u.i.b);
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static java.lang.String[] a(java.lang.String str) {
        try {
            return str.split(com.alipay.sdk.m.u.i.b);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final java.lang.String a() {
        if (android.text.TextUtils.isEmpty(this.j) && !android.text.TextUtils.isEmpty(this.a)) {
            this.j = com.amap.api.mapcore.util.fi.c(this.a);
        }
        return this.j;
    }

    public final void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public final java.lang.String b() {
        return this.g;
    }

    public final java.lang.String c() {
        if (android.text.TextUtils.isEmpty(this.h) && !android.text.TextUtils.isEmpty(this.b)) {
            this.h = com.amap.api.mapcore.util.fi.c(this.b);
        }
        return this.h;
    }

    public final java.lang.String d() {
        if (android.text.TextUtils.isEmpty(this.i) && !android.text.TextUtils.isEmpty(this.d)) {
            this.i = com.amap.api.mapcore.util.fi.c(this.d);
        }
        return this.i;
    }

    public final java.lang.String e() {
        if (android.text.TextUtils.isEmpty(this.k) && !android.text.TextUtils.isEmpty(this.f)) {
            this.k = com.amap.api.mapcore.util.fi.c(this.f);
        }
        if (android.text.TextUtils.isEmpty(this.k)) {
            this.k = "standard";
        }
        return this.k;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (com.amap.api.mapcore.util.fh.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.j.equals(((com.amap.api.mapcore.util.fh) obj).j) && this.g.equals(((com.amap.api.mapcore.util.fh) obj).g)) {
                if (this.h.equals(((com.amap.api.mapcore.util.fh) obj).h)) {
                    return true;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    public final boolean f() {
        return this.c == 1;
    }

    public final java.lang.String[] g() {
        java.lang.String[] strArr = this.l;
        if ((strArr == null || strArr.length == 0) && !android.text.TextUtils.isEmpty(this.e)) {
            this.l = a(com.amap.api.mapcore.util.fi.c(this.e));
        }
        return (java.lang.String[]) this.l.clone();
    }
}
