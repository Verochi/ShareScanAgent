package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutObjectResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.lang.String eTag;
    private java.lang.String serverCallbackReturnBody;

    public java.lang.String getETag() {
        return this.eTag;
    }

    public java.lang.String getServerCallbackReturnBody() {
        return this.serverCallbackReturnBody;
    }

    public void setETag(java.lang.String str) {
        this.eTag = str;
    }

    public void setServerCallbackReturnBody(java.lang.String str) {
        this.serverCallbackReturnBody = str;
    }
}
