package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class o extends com.alipay.android.phone.mrpc.core.t {
    public java.lang.String b;
    public byte[] c;
    public boolean g;
    public java.util.ArrayList<org.apache.http.Header> e = new java.util.ArrayList<>();
    public java.util.Map<java.lang.String, java.lang.String> f = new java.util.HashMap();
    public java.lang.String d = com.anythink.expressad.foundation.g.f.g.b.e;

    public o(java.lang.String str) {
        this.b = str;
    }

    public final java.lang.String a() {
        return this.b;
    }

    public final void a(java.lang.String str) {
        this.d = str;
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (this.f == null) {
            this.f = new java.util.HashMap();
        }
        this.f.put(str, str2);
    }

    public final void a(org.apache.http.Header header) {
        this.e.add(header);
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void a(byte[] bArr) {
        this.c = bArr;
    }

    public final java.lang.String b(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.c;
    }

    public final java.lang.String c() {
        return this.d;
    }

    public final java.util.ArrayList<org.apache.http.Header> d() {
        return this.e;
    }

    public final boolean e() {
        return this.g;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.alipay.android.phone.mrpc.core.o.class != obj.getClass()) {
            return false;
        }
        com.alipay.android.phone.mrpc.core.o oVar = (com.alipay.android.phone.mrpc.core.o) obj;
        byte[] bArr = this.c;
        if (bArr == null) {
            if (oVar.c != null) {
                return false;
            }
        } else if (!bArr.equals(oVar.c)) {
            return false;
        }
        java.lang.String str = this.b;
        java.lang.String str2 = oVar.b;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        java.util.Map<java.lang.String, java.lang.String> map = this.f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f.get("id").hashCode() + 31) * 31;
        java.lang.String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final java.lang.String toString() {
        return java.lang.String.format("Url : %s,HttpHeader: %s", this.b, this.e);
    }
}
