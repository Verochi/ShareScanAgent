package com.loc;

/* loaded from: classes23.dex */
public final class fr extends com.loc.bq {
    java.util.Map<java.lang.String, java.lang.String> d;
    java.lang.String e;
    java.lang.String f;
    byte[] g;
    byte[] h;
    boolean i;
    java.lang.String j;
    java.util.Map<java.lang.String, java.lang.String> k;
    boolean p;
    private java.lang.String q;

    public fr(android.content.Context context, com.loc.x xVar) {
        super(context, xVar);
        this.d = null;
        this.q = "";
        this.e = "";
        this.f = "";
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = null;
        this.k = null;
        this.p = false;
    }

    @Override // com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return this.d;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.k = map;
    }

    @Override // com.loc.bq
    public final byte[] a_() {
        return this.g;
    }

    @Override // com.loc.bu
    public final java.lang.String b() {
        return this.e;
    }

    public final void b(java.lang.String str) {
        this.j = str;
    }

    public final void b(java.util.Map<java.lang.String, java.lang.String> map) {
        this.d = map;
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public final void b(byte[] bArr) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(com.loc.bq.a(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return;
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (java.lang.Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.h = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    @Override // com.loc.bq
    public final byte[] b_() {
        return this.h;
    }

    @Override // com.loc.s, com.loc.bu
    public final java.lang.String c() {
        return this.f;
    }

    public final void c(java.lang.String str) {
        this.e = str;
    }

    public final void c(boolean z) {
        this.p = z;
    }

    public final void c(byte[] bArr) {
        this.g = bArr;
    }

    @Override // com.loc.bu
    public final java.lang.String c_() {
        return "loc";
    }

    public final void d(java.lang.String str) {
        this.f = str;
    }

    @Override // com.loc.bq, com.loc.bu
    public final java.util.Map<java.lang.String, java.lang.String> e() {
        return this.k;
    }

    public final void e(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.q = "";
        } else {
            this.q = str;
        }
    }

    @Override // com.loc.bu
    public final java.lang.String g() {
        return this.q;
    }

    @Override // com.loc.bq
    public final boolean i() {
        return this.i;
    }

    @Override // com.loc.bq
    public final java.lang.String j() {
        return this.j;
    }

    @Override // com.loc.bq
    public final boolean k() {
        return this.p;
    }
}
