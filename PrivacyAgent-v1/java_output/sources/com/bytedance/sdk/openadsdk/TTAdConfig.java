package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public final class TTAdConfig extends com.bytedance.sdk.openadsdk.CSJConfig {
    private com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth vw;

    public static class Builder {
        private com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth vw;
        private com.bytedance.sdk.openadsdk.CSJConfig.vw wg = new com.bytedance.sdk.openadsdk.CSJConfig.vw();

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder addExtra(java.lang.String str, java.lang.Object obj) {
            this.wg.vw(str, obj);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder allowShowNotify(boolean z) {
            this.wg.wg(z);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder appId(java.lang.String str) {
            this.wg.vw(str);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder appName(java.lang.String str) {
            this.wg.wg(str);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig build() {
            com.bytedance.sdk.openadsdk.TTAdConfig tTAdConfig = new com.bytedance.sdk.openadsdk.TTAdConfig(this.wg, null);
            tTAdConfig.setInjectionAuth(this.vw);
            return tTAdConfig;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder customController(com.bytedance.sdk.openadsdk.TTCustomController tTCustomController) {
            this.wg.vw(tTCustomController);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder data(java.lang.String str) {
            this.wg.v(str);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder debug(boolean z) {
            this.wg.t(z);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder directDownloadNetworkType(int... iArr) {
            this.wg.vw(iArr);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder injectionAuth(com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.vw = iTTLiveTokenInjectionAuth;
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder keywords(java.lang.String str) {
            this.wg.t(str);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder paid(boolean z) {
            this.wg.vw(z);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder setAgeGroup(int i) {
            this.wg.v(i);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder setPluginUpdateConfig(int i) {
            this.wg.t(i);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder supportMultiProcess(boolean z) {
            this.wg.v(z);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder themeStatus(int i) {
            this.wg.wg(i);
            return this;
        }

        public com.bytedance.sdk.openadsdk.TTAdConfig.Builder titleBarTheme(int i) {
            this.wg.vw(i);
            return this;
        }
    }

    private TTAdConfig(com.bytedance.sdk.openadsdk.CSJConfig.vw vwVar) {
        super(vwVar);
    }

    public /* synthetic */ TTAdConfig(com.bytedance.sdk.openadsdk.CSJConfig.vw vwVar, com.bytedance.sdk.openadsdk.TTAdConfig.AnonymousClass1 anonymousClass1) {
        this(vwVar);
    }

    public com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.vw;
    }

    public void setInjectionAuth(com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.vw = iTTLiveTokenInjectionAuth;
    }
}
