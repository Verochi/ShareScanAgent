package com.bytedance.pangle.dex;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class DirectDex {
    static {
        java.lang.System.loadLibrary("zeus_direct_dex");
        native_init(android.os.Build.VERSION.SDK_INT);
    }

    private static native boolean native_init(int i);

    public static native java.lang.Object native_load_direct_dex(java.lang.String str);
}
