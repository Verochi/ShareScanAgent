package com.alibaba.sdk.android.vod.upload.model;

/* loaded from: classes.dex */
public class OSSConfig {
    private java.lang.String accessKeyId;
    private java.lang.String accessKeyIdToVOD;
    private java.lang.String accessKeySecret;
    private java.lang.String accessKeySecretToVOD;
    private java.lang.String expireTime;
    private java.lang.String expireTimeToVOD;
    private long partSize;
    private java.lang.String secrityToken;
    private java.lang.String secrityTokenToVOD;
    private java.lang.String uploadAddress;
    private java.lang.String videoId;

    /* renamed from: com.alibaba.sdk.android.vod.upload.model.OSSConfig$1, reason: invalid class name */
    public class AnonymousClass1 extends com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider {
        public AnonymousClass1() {
        }

        @Override // com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
        public com.alibaba.sdk.android.oss.common.auth.OSSFederationToken getFederationToken() {
            return new com.alibaba.sdk.android.oss.common.auth.OSSFederationToken(com.alibaba.sdk.android.vod.upload.model.OSSConfig.this.accessKeyId, com.alibaba.sdk.android.vod.upload.model.OSSConfig.this.accessKeySecret, com.alibaba.sdk.android.vod.upload.model.OSSConfig.this.secrityToken, com.alibaba.sdk.android.vod.upload.model.OSSConfig.this.expireTime);
        }
    }

    public java.lang.String getAccessKeyId() {
        return this.accessKeyId;
    }

    public java.lang.String getAccessKeyIdToVOD() {
        return this.accessKeyIdToVOD;
    }

    public java.lang.String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public java.lang.String getAccessKeySecretToVOD() {
        return this.accessKeySecretToVOD;
    }

    public java.lang.String getExpireTime() {
        return this.expireTime;
    }

    public java.lang.String getExpireTimeToVOD() {
        return this.expireTimeToVOD;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider getProvider() {
        return (this.secrityToken == null || this.expireTime == null) ? new com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider(this.accessKeyId, this.accessKeySecret) : new com.alibaba.sdk.android.vod.upload.model.OSSConfig.AnonymousClass1();
    }

    public java.lang.String getSecrityToken() {
        return this.secrityToken;
    }

    public java.lang.String getSecrityTokenToVOD() {
        return this.secrityTokenToVOD;
    }

    public java.lang.String getUploadAddress() {
        return this.uploadAddress;
    }

    public java.lang.String getVideoId() {
        return this.videoId;
    }

    public void setAccessKeyId(java.lang.String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeyIdToVOD(java.lang.String str) {
        this.accessKeyIdToVOD = str;
    }

    public void setAccessKeySecret(java.lang.String str) {
        this.accessKeySecret = str;
    }

    public void setAccessKeySecretToVOD(java.lang.String str) {
        this.accessKeySecretToVOD = str;
    }

    public void setExpireTime(java.lang.String str) {
        this.expireTime = str;
    }

    public void setExpireTimeToVOD(java.lang.String str) {
        this.expireTimeToVOD = str;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setSecrityToken(java.lang.String str) {
        this.secrityToken = str;
    }

    public void setSecrityTokenToVOD(java.lang.String str) {
        this.secrityTokenToVOD = str;
    }

    public void setUploadAddress(java.lang.String str) {
        this.uploadAddress = str;
    }

    public void setVideoId(java.lang.String str) {
        this.videoId = str;
    }
}
