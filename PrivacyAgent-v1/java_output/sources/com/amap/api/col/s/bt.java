package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bt {
    public java.lang.String a;
    public java.lang.String b;
    public int c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String[] l;

    public static class a {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public boolean e = true;
        public java.lang.String f = "standard";
        public java.lang.String[] g = null;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final com.amap.api.col.s.bt.a a(java.lang.String str) {
            this.b = str;
            return this;
        }

        public final com.amap.api.col.s.bt.a a(boolean z) {
            this.e = z;
            return this;
        }

        public final com.amap.api.col.s.bt.a a(java.lang.String[] strArr) {
            if (strArr != null) {
                this.g = (java.lang.String[]) strArr.clone();
            }
            return this;
        }

        public final com.amap.api.col.s.bt a() throws com.amap.api.col.s.bh {
            if (this.g != null) {
                return new com.amap.api.col.s.bt(this, (byte) 0);
            }
            throw new com.amap.api.col.s.bh("sdk packages is null");
        }
    }

    public bt() {
        this.c = 1;
        this.l = null;
    }

    public bt(com.amap.api.col.s.bt.a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = com.amap.api.col.s.bu.b(this.h);
        this.a = com.amap.api.col.s.bu.b(this.j);
        this.d = com.amap.api.col.s.bu.b(this.i);
        this.e = com.amap.api.col.s.bu.b(a(this.l));
        this.f = com.amap.api.col.s.bu.b(this.k);
    }

    public /* synthetic */ bt(com.amap.api.col.s.bt.a aVar, byte b) {
        this(aVar);
    }

    public static java.lang.String a(java.lang.String[] strArr) {
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

    public static java.lang.String[] b(java.lang.String str) {
        try {
            return str.split(com.alipay.sdk.m.u.i.b);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void a() {
        this.c = 1;
    }

    public final java.lang.String b() {
        if (android.text.TextUtils.isEmpty(this.j) && !android.text.TextUtils.isEmpty(this.a)) {
            this.j = com.amap.api.col.s.bu.c(this.a);
        }
        return this.j;
    }

    public final java.lang.String c() {
        return this.g;
    }

    public final java.lang.String d() {
        if (android.text.TextUtils.isEmpty(this.h) && !android.text.TextUtils.isEmpty(this.b)) {
            this.h = com.amap.api.col.s.bu.c(this.b);
        }
        return this.h;
    }

    public final java.lang.String e() {
        if (android.text.TextUtils.isEmpty(this.k) && !android.text.TextUtils.isEmpty(this.f)) {
            this.k = com.amap.api.col.s.bu.c(this.f);
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
        if (com.amap.api.col.s.bt.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.j.equals(((com.amap.api.col.s.bt) obj).j) && this.g.equals(((com.amap.api.col.s.bt) obj).g)) {
                if (this.h.equals(((com.amap.api.col.s.bt) obj).h)) {
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
            this.l = b(com.amap.api.col.s.bu.c(this.e));
        }
        return (java.lang.String[]) this.l.clone();
    }
}
