package com.bytedance.sdk.openadsdk.live.core;

/* loaded from: classes22.dex */
public class wg implements com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth {
    private com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth vw;

    /* renamed from: com.bytedance.sdk.openadsdk.live.core.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback {
        final /* synthetic */ com.bytedance.android.livehostapi.platform.TokenRefreshCallback vw;

        public AnonymousClass1(com.bytedance.android.livehostapi.platform.TokenRefreshCallback tokenRefreshCallback) {
            this.vw = tokenRefreshCallback;
        }

        @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
        public void onAuth(com.bytedance.sdk.openadsdk.live.TTLiveToken tTLiveToken) {
            this.vw.onSuccess(new com.bytedance.android.livehostapi.platform.TokenInfo(tTLiveToken.name, tTLiveToken.openId, tTLiveToken.accessToken, tTLiveToken.expireAt));
        }

        @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
        public void onFailed(java.lang.Throwable th) {
            this.vw.onFailed(th);
        }
    }

    public wg(com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.vw = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public com.bytedance.android.livehostapi.platform.TokenInfo getTokenInfo() {
        com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.vw;
        if (iTTLiveTokenInjectionAuth == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.live.TTLiveToken tokenInfo = iTTLiveTokenInjectionAuth.getTokenInfo();
        return tokenInfo == null ? new com.bytedance.android.livehostapi.platform.TokenInfo("", "", "", 0L) : new com.bytedance.android.livehostapi.platform.TokenInfo(tokenInfo.name, tokenInfo.openId, tokenInfo.accessToken, tokenInfo.expireAt);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public boolean isLogin() {
        com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.vw;
        return iTTLiveTokenInjectionAuth != null && iTTLiveTokenInjectionAuth.isLogin();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public void onTokenInvalid(com.bytedance.android.livehostapi.platform.TokenInfo tokenInfo, com.bytedance.android.livehostapi.platform.TokenRefreshCallback tokenRefreshCallback, android.app.Activity activity, java.util.Map<java.lang.String, java.lang.String> map) {
        if (this.vw == null) {
            return;
        }
        this.vw.onTokenInvalid(tokenInfo == null ? null : new com.bytedance.sdk.openadsdk.live.TTLiveToken(com.bytedance.sdk.openadsdk.live.TTLiveConstants.DOUYIN_AUTH_NAME, tokenInfo.getAccessToken(), tokenInfo.getOpenId(), tokenInfo.getExpireAt(), tokenInfo.getName()), new com.bytedance.sdk.openadsdk.live.core.wg.AnonymousClass1(tokenRefreshCallback), activity, map);
    }
}
