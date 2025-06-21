package com.alibaba.sdk.android.oss.common.auth;

/* loaded from: classes.dex */
public class OSSStsTokenCredentialProvider implements com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider {
    private java.lang.String accessKeyId;
    private java.lang.String secretKeyId;
    private java.lang.String securityToken;

    public OSSStsTokenCredentialProvider(com.alibaba.sdk.android.oss.common.auth.OSSFederationToken oSSFederationToken) {
        setAccessKeyId(oSSFederationToken.getTempAK().trim());
        setSecretKeyId(oSSFederationToken.getTempSK().trim());
        setSecurityToken(oSSFederationToken.getSecurityToken().trim());
    }

    public OSSStsTokenCredentialProvider(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setAccessKeyId(str.trim());
        setSecretKeyId(str2.trim());
        setSecurityToken(str3.trim());
    }

    public java.lang.String getAccessKeyId() {
        return this.accessKeyId;
    }

    @Override // com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getFederationToken() {
        return new com.alibaba.sdk.android.oss.common.auth.OSSFederationToken(this.accessKeyId, this.secretKeyId, this.securityToken, Long.MAX_VALUE);
    }

    public java.lang.String getSecretKeyId() {
        return this.secretKeyId;
    }

    public java.lang.String getSecurityToken() {
        return this.securityToken;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.accessKeyId = str;
    }

    public void setSecretKeyId(java.lang.String str) {
        this.secretKeyId = str;
    }

    public void setSecurityToken(java.lang.String str) {
        this.securityToken = str;
    }
}
