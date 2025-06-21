package com.alimm.tanx.ui;

/* loaded from: classes.dex */
public class TanxSdk implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "TanxSdk";
    public static final int TANX_SDK_INIT_ERROR = -1;
    public static final int TANX_SDK_INIT_ING = 1;
    public static final int TANX_SDK_INIT_SUCC = 2;
    public static final int TANX_SDK_INIT_WAIT = 0;
    private static android.app.Application application;
    private static com.alimm.tanx.ui.tanxu_if mInitializer;
    public static volatile java.util.concurrent.atomic.AtomicInteger mIsInit = new java.util.concurrent.atomic.AtomicInteger(0);

    public static android.app.Application getApplication() {
        return application;
    }

    public static com.alimm.tanx.core.config.TanxConfig getConfig() {
        if (com.alimm.tanx.core.TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_do();
        }
        return null;
    }

    public static com.alimm.tanx.ui.ad.ITanxSdkManager getSDKManager() {
        if (com.alimm.tanx.core.TanxCoreSdk.checkSdkInit()) {
            return mInitializer.tanxu_if();
        }
        return null;
    }

    public static void init(android.app.Application application2, com.alimm.tanx.core.config.TanxConfig tanxConfig, com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("--->init()-->mIsInit->");
        tanxu_do2.append(mIsInit);
        tanxu_do2.append(" version:");
        tanxu_do2.append(com.alimm.tanx.core.SdkConstant.getSdkVersion());
        synchronized (com.alimm.tanx.ui.TanxSdk.class) {
            if (mIsInit.get() != 0 && mIsInit.get() != -1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("--->init()终止，已经在初始化，或者已经初始化完成。-->mIsInit->");
                sb.append(mIsInit);
                sb.append(" version:");
                sb.append(com.alimm.tanx.core.SdkConstant.getSdkVersion());
                return;
            }
            mIsInit.set(1);
            application = application2;
            if (tanxConfig == null) {
                throw new java.lang.RuntimeException("TanxConfig Not Null");
            }
            if (!com.alimm.tanx.core.utils.StringUtil.isNull(tanxConfig.getAppKey())) {
                if (mInitializer == null) {
                    mInitializer = new com.alimm.tanx.ui.tanxu_if();
                }
                com.alimm.tanx.core.TanxCoreSdk.init(application2, tanxConfig, tanxCoreInstanceConfig, new com.alimm.tanx.ui.tanxu_do(application2, tanxConfig, tanxInitListener));
                return;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("AppKey Is Null :");
            sb2.append(mIsInit);
            sb2.append(" version:");
            sb2.append(com.alimm.tanx.core.SdkConstant.getSdkVersion());
            com.alimm.tanx.core.ut.UtErrorCode utErrorCode = com.alimm.tanx.core.ut.UtErrorCode.APP_KEY_NULL;
            tanxInitListener.error(utErrorCode.getIntCode(), utErrorCode.getMsg());
        }
    }

    public static void init(android.app.Application application2, com.alimm.tanx.core.config.TanxConfig tanxConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("--->init()-->mIsInit->");
        tanxu_do2.append(mIsInit);
        tanxu_do2.append(" version:");
        tanxu_do2.append(com.alimm.tanx.core.SdkConstant.getSdkVersion());
        init(application2, tanxConfig, new com.alimm.tanx.ui.TanxThirdInstanceDefault().build(), tanxInitListener);
    }
}
