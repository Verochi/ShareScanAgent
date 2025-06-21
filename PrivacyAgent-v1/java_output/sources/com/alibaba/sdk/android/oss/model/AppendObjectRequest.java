package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class AppendObjectRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.Long initCRC64;
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata;
    private java.lang.String objectKey;
    private long position;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.AppendObjectRequest> progressCallback;
    private byte[] uploadData;
    private java.lang.String uploadFilePath;
    private android.net.Uri uploadUri;

    public AppendObjectRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        this(str, str2, uri, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public AppendObjectRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadUri(uri);
        setMetadata(objectMetadata);
    }

    public AppendObjectRequest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str, str2, str3, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public AppendObjectRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadFilePath(str3);
        setMetadata(objectMetadata);
    }

    public AppendObjectRequest(java.lang.String str, java.lang.String str2, byte[] bArr) {
        this(str, str2, bArr, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null);
    }

    public AppendObjectRequest(java.lang.String str, java.lang.String str2, byte[] bArr, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadData(bArr);
        setMetadata(objectMetadata);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.Long getInitCRC64() {
        return this.initCRC64;
    }

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public long getPosition() {
        return this.position;
    }

    public com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.AppendObjectRequest> getProgressCallback() {
        return this.progressCallback;
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

    public void setInitCRC64(java.lang.Long l) {
        this.initCRC64 = l;
    }

    public void setMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setPosition(long j) {
        this.position = j;
    }

    public void setProgressCallback(com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.AppendObjectRequest> oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
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
