package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class TriggerCallbackRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String mBucketName;
    private java.util.Map<java.lang.String, java.lang.String> mCallbackParam;
    private java.util.Map<java.lang.String, java.lang.String> mCallbackVars;
    private java.lang.String mObjectKey;

    public TriggerCallbackRequest(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
        setBucketName(str);
        setObjectKey(str2);
        setCallbackParam(map);
        setCallbackVars(map2);
    }

    public java.lang.String getBucketName() {
        return this.mBucketName;
    }

    public java.util.Map<java.lang.String, java.lang.String> getCallbackParam() {
        return this.mCallbackParam;
    }

    public java.util.Map<java.lang.String, java.lang.String> getCallbackVars() {
        return this.mCallbackVars;
    }

    public java.lang.String getObjectKey() {
        return this.mObjectKey;
    }

    public void setBucketName(java.lang.String str) {
        this.mBucketName = str;
    }

    public void setCallbackParam(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mCallbackParam = map;
    }

    public void setCallbackVars(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mCallbackVars = map;
    }

    public void setObjectKey(java.lang.String str) {
        this.mObjectKey = str;
    }
}
