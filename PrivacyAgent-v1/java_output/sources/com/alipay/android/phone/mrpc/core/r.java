package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class r {
    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }
}
