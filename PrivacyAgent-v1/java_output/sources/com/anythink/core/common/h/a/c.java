package com.anythink.core.common.h.a;

import com.anythink.core.common.h.a.d.AnonymousClass1;

/* loaded from: classes12.dex */
public abstract class c {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    private final int a = 0;
    protected int i;
    protected java.lang.String j;

    public interface a {
        void a(java.lang.Object obj);

        void a(java.lang.Throwable th);
    }

    public static byte[] a(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final void a(int i, java.lang.String str) {
        this.i = i;
        this.j = str;
    }

    public final void a(com.anythink.core.common.h.a.c.a aVar) {
        com.anythink.core.common.o.b.b.a().a((com.anythink.core.common.o.b.d) com.anythink.core.common.h.a.d.a().new AnonymousClass1(this, aVar), 3);
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
    }

    public abstract int c();

    public abstract int d();

    public abstract byte[] e();

    public abstract boolean f();

    public int g() {
        return 0;
    }

    public final org.json.JSONObject h() {
        return com.anythink.core.common.h.c.a(g());
    }

    public final org.json.JSONObject i() {
        return com.anythink.core.common.h.c.b(g());
    }
}
