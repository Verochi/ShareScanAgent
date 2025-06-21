package com.aliyun.aio_stat;

@com.aliyun.aio.keep.CalledByNative
/* loaded from: classes.dex */
public class AioStat {
    public static boolean init(android.content.Context context) {
        if (context != null) {
            nSetApplicationContext(context);
        }
        return nInit();
    }

    private static native boolean nInit();

    private static native boolean nRelease();

    public static native void nSetApplicationContext(android.content.Context context);

    public static boolean release() {
        return nRelease();
    }
}
