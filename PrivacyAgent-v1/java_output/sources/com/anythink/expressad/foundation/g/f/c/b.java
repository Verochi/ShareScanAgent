package com.anythink.expressad.foundation.g.f.c;

/* loaded from: classes12.dex */
public final class b implements java.io.Serializable {
    private byte[] a;
    private java.io.InputStream b;
    private java.io.File c;
    private long d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;

    private b(java.io.InputStream inputStream, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.e = str;
        this.f = str2;
        this.b = inputStream;
        this.d = i;
        this.g = str3;
    }

    public b(java.lang.String str, java.io.File file, java.lang.String str2, java.lang.String str3) {
        this.g = com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        this.e = str;
        this.f = str2;
        try {
            this.b = new java.io.FileInputStream(file);
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
        this.d = file.length();
        if (str3 != null) {
            this.g = str3;
        }
        this.c = file;
    }

    private b(java.lang.String str, byte[] bArr, long j, java.lang.String str2, java.lang.String str3) {
        this.g = com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        this.e = str;
        this.f = str2;
        this.a = bArr;
        this.d = j;
        if (str3 != null) {
            this.g = str3;
        }
    }

    private void a(java.lang.String str) {
        this.e = str;
    }

    private void b(java.lang.String str) {
        this.f = str;
    }

    private void c(java.lang.String str) {
        this.g = str;
    }

    public final long a() {
        return this.d;
    }

    public final java.io.File b() {
        return this.c;
    }

    public final java.io.InputStream c() {
        return this.b;
    }

    public final byte[] d() {
        return this.a;
    }

    public final java.lang.String e() {
        return this.e;
    }

    public final java.lang.String f() {
        return this.f;
    }

    public final java.lang.String g() {
        return this.g;
    }
}
