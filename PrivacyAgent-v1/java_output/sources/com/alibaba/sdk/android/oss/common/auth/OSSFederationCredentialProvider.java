package com.alibaba.sdk.android.oss.common.auth;

/* loaded from: classes.dex */
public abstract class OSSFederationCredentialProvider implements com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider {
    private volatile com.alibaba.sdk.android.oss.common.auth.OSSFederationToken cachedToken;

    public com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getCachedToken() {
        return this.cachedToken;
    }

    @Override // com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public abstract com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getFederationToken() throws com.alibaba.sdk.android.oss.ClientException;

    public synchronized com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getValidFederationToken() throws com.alibaba.sdk.android.oss.ClientException {
        if (this.cachedToken == null || com.alibaba.sdk.android.oss.common.utils.DateUtil.getFixedSkewedTimeMillis() / 1000 > this.cachedToken.getExpiration() - 300) {
            if (this.cachedToken != null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("token expired! current time: " + (com.alibaba.sdk.android.oss.common.utils.DateUtil.getFixedSkewedTimeMillis() / 1000) + " token expired: " + this.cachedToken.getExpiration());
            }
            this.cachedToken = getFederationToken();
        }
        return this.cachedToken;
    }
}
