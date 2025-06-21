package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutBucketRefererRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private boolean mAllowEmpty;
    private java.lang.String mBucketName;
    private java.util.ArrayList<java.lang.String> mReferers;

    public java.lang.String getBucketName() {
        return this.mBucketName;
    }

    public java.util.ArrayList<java.lang.String> getReferers() {
        return this.mReferers;
    }

    public boolean isAllowEmpty() {
        return this.mAllowEmpty;
    }

    public void setAllowEmpty(boolean z) {
        this.mAllowEmpty = z;
    }

    public void setBucketName(java.lang.String str) {
        this.mBucketName = str;
    }

    public void setReferers(java.util.ArrayList<java.lang.String> arrayList) {
        this.mReferers = arrayList;
    }
}
