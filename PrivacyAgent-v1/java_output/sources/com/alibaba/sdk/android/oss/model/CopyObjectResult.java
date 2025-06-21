package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class CopyObjectResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.lang.String etag;
    private java.util.Date lastModified;

    public java.lang.String getETag() {
        return this.etag;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public void setEtag(java.lang.String str) {
        this.etag = str;
    }

    public void setLastModified(java.util.Date date) {
        this.lastModified = date;
    }
}
