package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ATAdStatusInfo {
    private com.anythink.core.api.ATAdInfo mATAdInfo;
    private boolean mIsLoading;
    private boolean mIsReady;

    public ATAdStatusInfo(boolean z, boolean z2, com.anythink.core.api.ATAdInfo aTAdInfo) {
        this.mIsLoading = z;
        this.mIsReady = z2;
        this.mATAdInfo = aTAdInfo;
    }

    public com.anythink.core.api.ATAdInfo getATAdInfo() {
        return this.mATAdInfo;
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ATAdStatusInfo{isLoading=");
        sb.append(this.mIsLoading);
        sb.append(", isReady=");
        sb.append(this.mIsReady);
        sb.append(", topAdInfo=");
        java.lang.Object obj = this.mATAdInfo;
        if (obj == null) {
            obj = com.igexin.push.core.b.m;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
