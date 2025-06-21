package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public final class d {
    public static <T extends java.lang.Throwable> void a(java.lang.Throwable th, java.lang.Class<T> cls) {
        if (cls.isInstance(th)) {
            throw th;
        }
    }
}
