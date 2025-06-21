package com.alimm.tanx.core;

/* loaded from: classes.dex */
public class TanxCoreSdk implements com.alimm.tanx.core.utils.NotConfused {
    private static android.app.Application application;
    private static boolean mDebugMode;
    private static com.alimm.tanx.core.tanxc_do mInitializer;
    private static boolean mIsInit;
    private static com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer proxyCacheServer;

    public static boolean checkSdkInit() {
        if (mInitializer != null) {
            return true;
        }
        if (mDebugMode) {
            throw new java.lang.RuntimeException("TanxSdk Not initialized");
        }
        com.alimm.tanx.core.utils.LogUtils.e("checkSdkInit", "TanxSdk Not initialized SdkDebug : false");
        return false;
    }

    public static android.app.Application getApplication() {
        return application;
    }

    public static com.alimm.tanx.core.config.TanxConfig getConfig() {
        if (checkSdkInit()) {
            return mInitializer.tanxc_do();
        }
        return null;
    }

    public static com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer getProxy(android.content.Context context) {
        if (proxyCacheServer == null) {
            proxyCacheServer = com.alimm.tanx.core.view.player.cache.ProxyCacheManager.getProxy(context);
        }
        return proxyCacheServer;
    }

    public static com.alimm.tanx.core.ad.ITanxCoreManager getSDKManager() {
        if (checkSdkInit()) {
            return mInitializer.tanxc_if();
        }
        return null;
    }

    public static void init(android.app.Application application2, com.alimm.tanx.core.config.TanxConfig tanxConfig, com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        if (mIsInit) {
            return;
        }
        if (tanxConfig != null) {
            mDebugMode = tanxConfig.isDebugMode();
        }
        application = application2;
        if (mInitializer == null) {
            mInitializer = new com.alimm.tanx.core.tanxc_do();
        }
        mInitializer.tanxc_do(application2, tanxConfig, tanxCoreInstanceConfig, tanxInitListener);
        mIsInit = true;
    }

    public static void init(android.app.Application application2, com.alimm.tanx.core.config.TanxConfig tanxConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        init(application2, tanxConfig, new com.alimm.tanx.core.TanxCoreInstanceConfig(), tanxInitListener);
    }

    public static boolean ismDebugMode() {
        return mDebugMode;
    }
}
