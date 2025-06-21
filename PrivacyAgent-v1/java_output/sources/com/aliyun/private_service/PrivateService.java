package com.aliyun.private_service;

/* loaded from: classes.dex */
public class PrivateService {
    static {
        com.aliyun.utils.f.f();
    }

    @java.lang.Deprecated
    public static void initService(android.content.Context context, java.lang.String str) {
        if (com.aliyun.utils.f.b() && context != null) {
            nInitService(context.getApplicationContext(), str);
        }
    }

    public static void initService(android.content.Context context, byte[] bArr) {
        if (com.aliyun.utils.f.b() && context != null) {
            nInitService(context.getApplicationContext(), bArr);
        }
    }

    public static void loadClass() {
    }

    private static native void nInitService(java.lang.Object obj, java.lang.String str);

    private static native void nInitService(java.lang.Object obj, byte[] bArr);

    private static native void nPreInitService(java.lang.Object obj);

    public static void preInitService(android.content.Context context) {
        if (com.aliyun.utils.f.b() && context != null) {
            nPreInitService(context.getApplicationContext());
        }
    }
}
