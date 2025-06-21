package com.alimm.tanx.core;

/* loaded from: classes.dex */
public class TanxCoreManager implements com.alimm.tanx.core.ad.ITanxCoreManager, com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "AdSdkManager";
    private android.app.Application mAppContext;
    private boolean mHasInit = false;
    private com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig;

    /* renamed from: com.alimm.tanx.core.TanxCoreManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.orange.OrangeInitListener<com.alimm.tanx.core.orange.bean.OrangeBean> {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.orange.OrangeInitListener
        public /* bridge */ /* synthetic */ void initFinish(com.alimm.tanx.core.orange.bean.OrangeBean orangeBean) {
        }
    }

    public static class tanxc_do {
        static final com.alimm.tanx.core.TanxCoreManager tanxc_do = new com.alimm.tanx.core.TanxCoreManager();
    }

    public static com.alimm.tanx.core.TanxCoreManager getInstance() {
        return com.alimm.tanx.core.TanxCoreManager.tanxc_do.tanxc_do;
    }

    private void initAllId() {
        com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().init(this.mAppContext);
        com.alimm.tanx.core.utils.DeviceIdGetUtil.getInstance().getAllIdOnlyCache();
    }

    private void initExpose() {
        com.alimm.tanx.core.ad.event.track.expose.ExposeManager.tanxc_do().tanxc_do(this.mAppContext);
    }

    private void initLogSwitch(com.alimm.tanx.core.config.TanxCoreConfig tanxCoreConfig) {
        if (tanxCoreConfig == null) {
            com.alimm.tanx.core.utils.LogUtils.setLogStatus(com.alimm.tanx.core.utils.LogStatus.LOG_DEFAULT);
        } else if (tanxCoreConfig.getLogStatus() != null) {
            com.alimm.tanx.core.utils.LogUtils.setLogStatus(tanxCoreConfig.getLogStatus());
        } else if (tanxCoreConfig.isDebugMode()) {
            com.alimm.tanx.core.utils.LogUtils.setLogStatus(com.alimm.tanx.core.utils.LogStatus.LOG_DEBUG);
        }
    }

    private void initNet() {
        if (com.alimm.tanx.core.TanxCoreSdk.getConfig().isNetDebug()) {
            com.alimm.tanx.core.request.C.setDebug();
        }
    }

    private void initOrange() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "initOrange()");
        com.alimm.tanx.core.orange.OrangeManager.getInstance().init(new com.alimm.tanx.core.TanxCoreManager.AnonymousClass1());
    }

    private void initUT() {
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "initUTSDK()");
        com.alimm.tanx.core.TanxCoreSdk.getConfig();
        com.alimm.tanx.core.ut.core.UserReportManager.getInstance().init();
        com.alimm.tanx.core.ut.core.LifeCycleManager.getInstance().init();
    }

    private void initWebCache() {
        com.alimm.tanx.core.web.WebCacheManager.getInstance().init(this.mAppContext);
    }

    @Override // com.alimm.tanx.core.ad.ITanxCoreManager
    public com.alimm.tanx.core.ad.loader.ITanxRequestLoader createRequestLoader(android.content.Context context) {
        return new com.alimm.tanx.core.ad.loader.TanxRequestLoader();
    }

    public android.app.Application getAppContext() {
        android.app.Application application = this.mAppContext;
        if (application != null) {
            return application;
        }
        throw new java.lang.RuntimeException("App should call init() to initialize first. you AppContext == null");
    }

    @Override // com.alimm.tanx.core.ad.ITanxCoreManager
    public java.lang.String getSDKVersion() {
        return com.alimm.tanx.core.SdkConstant.getSdkVersion();
    }

    public com.alimm.tanx.core.TanxCoreInstanceConfig getTanxCoreInstanceConfig() {
        return this.tanxCoreInstanceConfig;
    }

    public com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker getTanxUserTracker() {
        com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig = this.tanxCoreInstanceConfig;
        if (tanxCoreInstanceConfig != null) {
            return tanxCoreInstanceConfig.getTanxUserTracker();
        }
        return null;
    }

    public com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do getUserTracker() {
        com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig = this.tanxCoreInstanceConfig;
        if (tanxCoreInstanceConfig != null) {
            return tanxCoreInstanceConfig.getUserTracker();
        }
        return null;
    }

    public void init(android.app.Application application, com.alimm.tanx.core.config.TanxCoreConfig tanxCoreConfig, com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        this.tanxCoreInstanceConfig = tanxCoreInstanceConfig;
        init(application, tanxCoreConfig, tanxInitListener);
    }

    public void init(android.app.Application application, com.alimm.tanx.core.config.TanxCoreConfig tanxCoreConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        if (this.mHasInit) {
            if (tanxInitListener != null) {
                tanxInitListener.succ();
                return;
            }
            return;
        }
        initLogSwitch(tanxCoreConfig);
        com.alimm.tanx.core.utils.LogUtils.i(TAG, "init: appContext = " + application + ", mHasInit = " + this.mHasInit + ", config = " + tanxCoreConfig);
        if (application == null) {
            throw new java.lang.RuntimeException("App should set a NonNull context when init().");
        }
        if (tanxCoreConfig == null) {
            throw new java.lang.RuntimeException("App should set a NonNull config when init().");
        }
        this.mAppContext = application;
        initAllId();
        initExpose();
        initNet();
        initOrange();
        initUT();
        initWebCache();
        this.mHasInit = true;
        if (tanxInitListener != null) {
            tanxInitListener.succ();
        }
    }

    public void setTanxCoreInstanceConfig(com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig) {
        this.tanxCoreInstanceConfig = tanxCoreInstanceConfig;
    }
}
