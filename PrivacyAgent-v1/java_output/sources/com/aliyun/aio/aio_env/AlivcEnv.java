package com.aliyun.aio.aio_env;

@com.aliyun.aio.keep.API
/* loaded from: classes.dex */
public class AlivcEnv {
    private static final java.lang.String KEY_PREPARED = "prepare";
    private static com.aliyun.aio.aio_env.AlivcEnv sInstance = new com.aliyun.aio.aio_env.AlivcEnv();
    private boolean hasPrepared = true;

    @com.aliyun.aio.keep.API
    public enum GlobalEnv {
        ENV_GLOBAL_DEFAULT,
        ENV_CN,
        ENV_SEA
    }

    public static com.aliyun.aio.aio_env.AlivcEnv getInstance() {
        return sInstance;
    }

    private static native int nativeGetEnv();

    private static native int nativeSetEnv(int i);

    private static native boolean nativeSetOption(java.lang.String str, java.lang.String str2);

    public com.aliyun.aio.aio_env.AlivcEnv.GlobalEnv getGlobalEnvironment() {
        if (!this.hasPrepared) {
            return com.aliyun.aio.aio_env.AlivcEnv.GlobalEnv.ENV_GLOBAL_DEFAULT;
        }
        int nativeGetEnv = nativeGetEnv();
        if (nativeGetEnv < 0 || nativeGetEnv >= com.aliyun.aio.aio_env.AlivcEnv.GlobalEnv.values().length) {
            throw new java.lang.IllegalArgumentException("Invalid ordinal for GlobalEnv enum");
        }
        return com.aliyun.aio.aio_env.AlivcEnv.GlobalEnv.values()[nativeGetEnv];
    }

    public int setGlobalEnvironment(com.aliyun.aio.aio_env.AlivcEnv.GlobalEnv globalEnv) {
        if (this.hasPrepared) {
            return nativeSetEnv(globalEnv.ordinal());
        }
        return -1;
    }

    public boolean setOption(java.lang.String str, java.lang.String str2) {
        if (KEY_PREPARED.equalsIgnoreCase(str)) {
            if (str2 == null) {
                str2 = "";
            }
            if (str2.equalsIgnoreCase(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                this.hasPrepared = false;
            }
            return false;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return nativeSetOption(str, str2);
    }
}
