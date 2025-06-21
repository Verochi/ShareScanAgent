package com.alibaba.sdk.android.oss.signer;

/* loaded from: classes.dex */
public class OSSSignerParams {
    private java.util.Set<java.lang.String> additionalHeaderNames = new java.util.HashSet();
    private java.lang.String cloudBoxId;
    private com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider;
    private long expiration;
    private java.lang.String product;
    private java.lang.String region;
    private java.lang.String resourcePath;

    public OSSSignerParams(java.lang.String str, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider) {
        this.resourcePath = str;
        this.credentialProvider = oSSCredentialProvider;
    }

    public java.util.Set<java.lang.String> getAdditionalHeaderNames() {
        return this.additionalHeaderNames;
    }

    public java.lang.String getCloudBoxId() {
        return this.cloudBoxId;
    }

    public com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider getCredentialProvider() {
        return this.credentialProvider;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public java.lang.String getProduct() {
        return this.product;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public java.lang.String getResourcePath() {
        return this.resourcePath;
    }

    public void setAdditionalHeaderNames(java.util.Set<java.lang.String> set) {
        this.additionalHeaderNames = set;
    }

    public void setCloudBoxId(java.lang.String str) {
        this.cloudBoxId = str;
    }

    public void setCredentialProvider(com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public void setExpiration(long j) {
        this.expiration = j;
    }

    public void setProduct(java.lang.String str) {
        this.product = str;
    }

    public void setRegion(java.lang.String str) {
        this.region = str;
    }

    public void setResourcePath(java.lang.String str) {
        this.resourcePath = str;
    }
}
