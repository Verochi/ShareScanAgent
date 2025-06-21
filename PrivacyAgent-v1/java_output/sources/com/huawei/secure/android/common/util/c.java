package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class c {
    public static android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());

    public static void a(java.lang.Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a.post(runnable);
    }
}
