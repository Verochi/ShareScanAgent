package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ResumableDownloadRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String checkPointFilePath;
    private java.lang.String downloadToFilePath;
    private java.lang.Boolean enableCheckPoint;
    private java.lang.String objectKey;
    private long partSize;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback progressListener;
    private com.alibaba.sdk.android.oss.model.Range range;
    private java.util.Map<java.lang.String, java.lang.String> requestHeader;
    private java.lang.Integer threadNum;

    public ResumableDownloadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.enableCheckPoint = java.lang.Boolean.FALSE;
        this.partSize = android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.bucketName = str;
        this.objectKey = str2;
        this.downloadToFilePath = str3;
    }

    public ResumableDownloadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.partSize = android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.bucketName = str;
        this.objectKey = str2;
        this.downloadToFilePath = str3;
        this.enableCheckPoint = java.lang.Boolean.TRUE;
        this.checkPointFilePath = str4;
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getCheckPointFilePath() {
        return this.checkPointFilePath;
    }

    public java.lang.String getDownloadToFilePath() {
        return this.downloadToFilePath;
    }

    public java.lang.Boolean getEnableCheckPoint() {
        return this.enableCheckPoint;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public com.alibaba.sdk.android.oss.callback.OSSProgressCallback getProgressListener() {
        return this.progressListener;
    }

    public com.alibaba.sdk.android.oss.model.Range getRange() {
        return this.range;
    }

    public java.util.Map<java.lang.String, java.lang.String> getRequestHeader() {
        return this.requestHeader;
    }

    public java.lang.String getTempFilePath() {
        return this.downloadToFilePath + com.baidu.mobads.sdk.internal.al.k;
    }

    public java.lang.Integer getThreadNum() {
        return this.threadNum;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setCheckPointFilePath(java.lang.String str) {
        this.checkPointFilePath = str;
    }

    public void setDownloadToFilePath(java.lang.String str) {
        this.downloadToFilePath = str;
    }

    public void setEnableCheckPoint(java.lang.Boolean bool) {
        this.enableCheckPoint = bool;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setProgressListener(com.alibaba.sdk.android.oss.callback.OSSProgressCallback oSSProgressCallback) {
        this.progressListener = oSSProgressCallback;
    }

    public void setRange(com.alibaba.sdk.android.oss.model.Range range) {
        this.range = range;
    }

    public void setRequestHeader(java.util.Map<java.lang.String, java.lang.String> map) {
        this.requestHeader = map;
    }

    public void setThreadNum(java.lang.Integer num) {
        this.threadNum = num;
    }
}
