package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class MultipartUploadRequest<T extends com.alibaba.sdk.android.oss.model.MultipartUploadRequest> extends com.alibaba.sdk.android.oss.model.OSSRequest {
    protected java.lang.String bucketName;
    protected java.util.Map<java.lang.String, java.lang.String> callbackParam;
    protected java.util.Map<java.lang.String, java.lang.String> callbackVars;
    protected com.alibaba.sdk.android.oss.model.ObjectMetadata metadata;
    protected java.lang.String objectKey;
    protected long partSize;
    protected com.alibaba.sdk.android.oss.callback.OSSProgressCallback<T> progressCallback;
    protected java.lang.Integer threadNum;
    protected java.lang.String uploadFilePath;
    protected java.lang.String uploadId;
    protected android.net.Uri uploadUri;

    public MultipartUploadRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        this(str, str2, uri, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public MultipartUploadRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.partSize = android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        setBucketName(str);
        setObjectKey(str2);
        setUploadUri(uri);
        setMetadata(objectMetadata);
    }

    public MultipartUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str, str2, str3, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public MultipartUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.partSize = android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        setBucketName(str);
        setObjectKey(str2);
        setUploadFilePath(str3);
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

    public long getPartSize() {
        return this.partSize;
    }

    public com.alibaba.sdk.android.oss.callback.OSSProgressCallback<T> getProgressCallback() {
        return this.progressCallback;
    }

    public java.lang.Integer getThreadNum() {
        return this.threadNum;
    }

    public java.lang.String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public java.lang.String getUploadId() {
        return this.uploadId;
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

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setProgressCallback(com.alibaba.sdk.android.oss.callback.OSSProgressCallback<T> oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setThreadNum(java.lang.Integer num) {
        this.threadNum = num;
    }

    public void setUploadFilePath(java.lang.String str) {
        this.uploadFilePath = str;
    }

    public void setUploadId(java.lang.String str) {
        this.uploadId = str;
    }

    public void setUploadUri(android.net.Uri uri) {
        this.uploadUri = uri;
    }
}
