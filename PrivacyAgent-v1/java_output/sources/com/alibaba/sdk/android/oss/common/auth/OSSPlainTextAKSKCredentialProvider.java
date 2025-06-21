package com.alibaba.sdk.android.oss.common.auth;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class OSSPlainTextAKSKCredentialProvider implements com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider {
    private java.lang.String accessKeyId;
    private java.lang.String accessKeySecret;

    public OSSPlainTextAKSKCredentialProvider(java.lang.String str, java.lang.String str2) {
        setAccessKeyId(str.trim());
        setAccessKeySecret(str2.trim());
    }

    public java.lang.String getAccessKeyId() {
        return this.accessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    @Override // com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getFederationToken() {
        return null;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.accessKeySecret = str;
    }
}
