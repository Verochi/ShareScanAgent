package com.alipay.sdk.app;

/* loaded from: classes.dex */
public class EnvUtils {
    public static com.alipay.sdk.app.EnvUtils.EnvEnum mEnv = com.alipay.sdk.app.EnvUtils.EnvEnum.ONLINE;

    public enum EnvEnum {
        ONLINE,
        SANDBOX
    }

    public static com.alipay.sdk.app.EnvUtils.EnvEnum geEnv() {
        return mEnv;
    }

    public static boolean isSandBox() {
        return mEnv == com.alipay.sdk.app.EnvUtils.EnvEnum.SANDBOX;
    }

    public static void setEnv(com.alipay.sdk.app.EnvUtils.EnvEnum envEnum) {
        mEnv = envEnum;
    }
}
