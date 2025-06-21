package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class OSSRequest {
    private boolean isAuthorizationRequired = true;
    private java.lang.Enum CRC64 = com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.NULL;
    private java.util.Set<java.lang.String> additionalHeaderNames = new java.util.HashSet();

    public enum CRC64Config {
        NULL,
        YES,
        NO
    }

    public java.util.Set<java.lang.String> getAdditionalHeaderNames() {
        return this.additionalHeaderNames;
    }

    public java.lang.Enum getCRC64() {
        return this.CRC64;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public void setAdditionalHeaderNames(java.util.Set<java.lang.String> set) {
        this.additionalHeaderNames = set;
    }

    public void setCRC64(java.lang.Enum r1) {
        this.CRC64 = r1;
    }

    public void setIsAuthorizationRequired(boolean z) {
        this.isAuthorizationRequired = z;
    }
}
