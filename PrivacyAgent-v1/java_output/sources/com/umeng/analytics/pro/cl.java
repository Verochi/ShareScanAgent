package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class cl {
    private final java.io.ByteArrayOutputStream a;
    private final com.umeng.analytics.pro.dn b;
    private com.umeng.analytics.pro.db c;

    public cl() {
        this(new com.umeng.analytics.pro.cv.a());
    }

    public cl(com.umeng.analytics.pro.dd ddVar) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        com.umeng.analytics.pro.dn dnVar = new com.umeng.analytics.pro.dn(byteArrayOutputStream);
        this.b = dnVar;
        this.c = ddVar.a(dnVar);
    }

    public java.lang.String a(com.umeng.analytics.pro.cc ccVar, java.lang.String str) throws com.umeng.analytics.pro.ci {
        try {
            return new java.lang.String(a(ccVar), str);
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.umeng.analytics.pro.ci("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public byte[] a(com.umeng.analytics.pro.cc ccVar) throws com.umeng.analytics.pro.ci {
        this.a.reset();
        ccVar.write(this.c);
        return this.a.toByteArray();
    }

    public java.lang.String b(com.umeng.analytics.pro.cc ccVar) throws com.umeng.analytics.pro.ci {
        return new java.lang.String(a(ccVar));
    }
}
