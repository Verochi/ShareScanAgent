package com.alimm.tanx.core.config;

/* loaded from: classes.dex */
public class TanxConfig extends com.alimm.tanx.core.config.TanxCoreConfig implements com.alimm.tanx.core.utils.NotConfused {
    private com.alimm.tanx.core.config.SettingConfig mSettingConfig;
    private com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer proxyCacheServer;

    public static class Builder implements com.alimm.tanx.core.utils.NotConfused {
        protected java.lang.Boolean idAllSwitch;
        protected java.lang.String imei;
        protected boolean imeiSwitch;
        protected java.lang.String mAppId;
        private java.lang.String mAppKey;
        protected java.lang.String mAppName;
        private java.lang.String mAppSecret;
        protected java.lang.String mChannel;
        protected boolean mDebugMode;
        private com.alimm.tanx.core.image.ILoader mImageLoader;
        private com.alimm.tanx.core.net.INetWork mNetWork;
        protected com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker mTanxUserTracker;
        protected com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do mUserTracker;
        private boolean netDebug;
        protected java.lang.String oaid;
        protected boolean oaidSwitch;
        private java.util.Map<java.lang.String, java.util.List<java.lang.String>> userTag;
        protected com.alimm.tanx.core.utils.LogStatus logStatus = null;
        private com.alimm.tanx.core.config.SettingConfig mSettingConfig = new com.alimm.tanx.core.config.SettingConfig();

        public Builder() {
            this.mDebugMode = false;
            this.netDebug = false;
            this.mDebugMode = false;
            this.netDebug = false;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder appId(java.lang.String str) {
            this.mAppId = str;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder appKey(java.lang.String str) {
            this.mAppKey = str;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder appName(java.lang.String str) {
            this.mAppName = str;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder appSecret(java.lang.String str) {
            this.mAppSecret = str;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig build() {
            return new com.alimm.tanx.core.config.TanxConfig(this);
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder channel(java.lang.String str) {
            this.mChannel = str;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder dark(com.alimm.tanx.core.config.SettingConfig settingConfig) {
            this.mSettingConfig = settingConfig;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder debug(boolean z) {
            this.mDebugMode = z;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder idAllSwitch(boolean z) {
            this.idAllSwitch = java.lang.Boolean.valueOf(z);
            return this;
        }

        @java.lang.Deprecated
        public com.alimm.tanx.core.config.TanxConfig.Builder imageLoader(com.alimm.tanx.core.image.ILoader iLoader) {
            this.mImageLoader = iLoader;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder imei(java.lang.String str) {
            this.imei = str;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder imeiSwitch(boolean z) {
            this.imeiSwitch = z;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder logStatus(com.alimm.tanx.core.utils.LogStatus logStatus) {
            this.logStatus = logStatus;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder netDebug(boolean z) {
            this.netDebug = z;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder network(com.alimm.tanx.core.net.INetWork iNetWork) {
            this.mNetWork = iNetWork;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder oaid(java.lang.String str) {
            this.oaid = str;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder oaidSwitch(boolean z) {
            this.oaidSwitch = z;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder setUserTag(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
            this.userTag = map;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder tanxUserTracker(com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker iTanxUserTracker) {
            this.mTanxUserTracker = iTanxUserTracker;
            return this;
        }

        public com.alimm.tanx.core.config.TanxConfig.Builder userTracker(com.tanx.exposer.tanxc_do.tanxc_try.tanxc_do tanxc_doVar) {
            this.mUserTracker = tanxc_doVar;
            return this;
        }
    }

    public TanxConfig() {
    }

    public TanxConfig(com.alimm.tanx.core.config.TanxConfig.Builder builder) {
        setDebugMode(builder.mDebugMode);
        setLogStatus(builder.logStatus);
        setAppName(builder.mAppName);
        setChannel(builder.mChannel);
        setAppId(builder.mAppId);
        setAppName(builder.mAppName);
        setAppKey(builder.mAppKey);
        setNetDebug(builder.netDebug);
        setAppSecret(builder.mAppSecret);
        setmOaid(builder.oaid);
        setImei(builder.imei);
        setOaidSwitch(builder.oaidSwitch);
        setImeiSwitch(builder.imeiSwitch);
        setIdAllSwitch(builder.idAllSwitch);
        setImageLoader(builder.mImageLoader);
        this.mSettingConfig = builder.mSettingConfig;
        setUserTag(builder.userTag);
    }

    public com.alimm.tanx.core.image.ILoader getImageLoader() {
        return com.alimm.tanx.core.image.ImageManager.getLoader();
    }

    public com.alimm.tanx.core.config.SettingConfig getSettingConfig() {
        return this.mSettingConfig;
    }

    public void setImageLoader(com.alimm.tanx.core.image.ILoader iLoader) {
        if (iLoader != null) {
            com.alimm.tanx.core.image.ImageManager.setLoader(iLoader);
        }
    }

    public void setSettingConfig(com.alimm.tanx.core.config.SettingConfig settingConfig) {
        this.mSettingConfig = settingConfig;
    }
}
