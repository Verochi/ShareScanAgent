package com.meizu.cloud.pushsdk.c.c;

/* loaded from: classes23.dex */
public abstract class l implements java.io.Closeable {
    public abstract com.meizu.cloud.pushsdk.c.g.d a();

    public final java.io.InputStream b() {
        return a().d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.meizu.cloud.pushsdk.c.c.m.a(a());
    }
}
