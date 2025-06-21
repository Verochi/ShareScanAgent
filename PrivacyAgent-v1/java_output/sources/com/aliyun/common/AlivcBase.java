package com.aliyun.common;

@com.aliyun.aio.keep.CalledByNative
/* loaded from: classes.dex */
public class AlivcBase {
    static boolean hasLoad;

    public static com.aliyun.aio.aio_env.AlivcEnv getEnvironmentManager() {
        loadSo();
        com.aliyun.aio.aio_env.AlivcEnv alivcEnv = com.aliyun.aio.aio_env.AlivcEnv.getInstance();
        if (!hasLoad) {
            alivcEnv.setOption("prepare", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        return alivcEnv;
    }

    private static void loadSo() {
        if (hasLoad) {
            return;
        }
        boolean loadLibrary = com.aliyun.common.AlivcNativeLoader.loadLibrary("all_in_one");
        hasLoad = loadLibrary;
        if (!loadLibrary) {
            hasLoad = com.aliyun.common.AlivcNativeLoader.loadLibrary(com.aliyun.player.BuildConfig.PLAYER_LIB_NAME);
        }
        if (hasLoad) {
            return;
        }
        hasLoad = com.aliyun.common.AlivcNativeLoader.loadLibrary("ugsv");
    }

    private static native void nativeSetIntegrationWay(java.lang.String str);

    public static void setIntegrationWay(java.lang.String str) {
        loadSo();
        if (hasLoad) {
            nativeSetIntegrationWay(str);
        }
    }
}
