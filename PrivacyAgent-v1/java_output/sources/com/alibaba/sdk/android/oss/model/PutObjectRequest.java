package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutObjectRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.util.Map<java.lang.String, java.lang.String> callbackParam;
    private java.util.Map<java.lang.String, java.lang.String> callbackVars;
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata;
    private java.lang.String objectKey;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest> progressCallback;
    private com.alibaba.sdk.android.oss.callback.OSSRetryCallback retryCallback;
    private byte[] uploadData;
    private java.lang.String uploadFilePath;
    private android.net.Uri uploadUri;

    public PutObjectRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        this(str, str2, uri, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public PutObjectRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadUri(uri);
        setMetadata(objectMetadata);
    }

    public PutObjectRequest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str, str2, str3, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public PutObjectRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadFilePath(str3);
        setMetadata(objectMetadata);
    }

    public PutObjectRequest(java.lang.String str, java.lang.String str2, byte[] bArr) {
        this(str, str2, bArr, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public PutObjectRequest(java.lang.String str, java.lang.String str2, byte[] bArr, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadData(bArr);
        setMetadata(objectMetadata);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.util.Map<java.lang.String, java.lang.String> getCallbackParam() {
        return this.callbackParam;
    }

    public java.util.Map<java.lang.String, java.lang.String> getCallbackVars() {
        return this.callbackVars;
    }

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest> getProgressCallback() {
        return this.progressCallback;
    }

    public com.alibaba.sdk.android.oss.callback.OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public java.lang.String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public android.net.Uri getUploadUri() {
        return this.uploadUri;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setCallbackParam(java.util.Map<java.lang.String, java.lang.String> map) {
        this.callbackParam = map;
    }

    public void setCallbackVars(java.util.Map<java.lang.String, java.lang.String> map) {
        this.callbackVars = map;
    }

    public void setMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setProgressCallback(com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest> oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setRetryCallback(com.alibaba.sdk.android.oss.callback.OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }

    public void setUploadData(byte[] bArr) {
        this.uploadData = bArr;
    }

    public void setUploadFilePath(java.lang.String str) {
        this.uploadFilePath = str;
    }

    public void setUploadUri(android.net.Uri uri) {
        this.uploadUri = uri;
    }
}
