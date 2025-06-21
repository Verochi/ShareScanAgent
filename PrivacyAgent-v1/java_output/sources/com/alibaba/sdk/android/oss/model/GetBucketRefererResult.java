package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketRefererResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.lang.String mAllowEmpty;
    private java.util.ArrayList<java.lang.String> mReferers;

    public void addReferer(java.lang.String str) {
        if (this.mReferers == null) {
            this.mReferers = new java.util.ArrayList<>();
        }
        this.mReferers.add(str);
    }

    public java.lang.String getAllowEmpty() {
        return this.mAllowEmpty;
    }

    public java.util.ArrayList<java.lang.String> getReferers() {
        return this.mReferers;
    }

    public void setAllowEmpty(java.lang.String str) {
        this.mAllowEmpty = str;
    }

    public void setReferers(java.util.ArrayList<java.lang.String> arrayList) {
        this.mReferers = arrayList;
    }
}
