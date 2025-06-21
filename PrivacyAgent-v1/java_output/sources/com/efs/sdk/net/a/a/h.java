package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public final class h {
    public final com.efs.sdk.net.a.a.f a;
    public java.io.ByteArrayOutputStream b;
    public com.efs.sdk.net.a.a.a c;
    private final java.lang.String d;

    public h(com.efs.sdk.net.a.a.f fVar, java.lang.String str) {
        this.a = fVar;
        this.d = str;
    }

    public final boolean a() {
        return this.b != null;
    }

    public final void b() {
        if (!a()) {
            throw new java.lang.IllegalStateException("No body found; has createBodySink been called?");
        }
    }
}
