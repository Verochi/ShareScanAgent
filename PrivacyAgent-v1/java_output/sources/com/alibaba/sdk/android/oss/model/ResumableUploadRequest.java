package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ResumableUploadRequest extends com.alibaba.sdk.android.oss.model.MultipartUploadRequest {
    private java.lang.Boolean deleteUploadOnCancelling;
    private com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode exceptionTerminationMode;
    private java.lang.String recordDirectory;

    public enum ExceptionTerminationMode {
        EXCEPTION,
        ALL
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        this(str, str2, uri, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null, (java.lang.String) null);
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this(str, str2, uri, objectMetadata, (java.lang.String) null);
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata, java.lang.String str3) {
        super(str, str2, uri, objectMetadata);
        this.deleteUploadOnCancelling = java.lang.Boolean.TRUE;
        this.exceptionTerminationMode = com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode.ALL;
        setRecordDirectory(str3);
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, android.net.Uri uri, java.lang.String str3) {
        this(str, str2, uri, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null, str3);
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(str, str2, str3, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null, (java.lang.String) null);
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this(str, str2, str3, objectMetadata, (java.lang.String) null);
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata, java.lang.String str4) {
        super(str, str2, str3, objectMetadata);
        this.deleteUploadOnCancelling = java.lang.Boolean.TRUE;
        this.exceptionTerminationMode = com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode.ALL;
        setRecordDirectory(str4);
    }

    public ResumableUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this(str, str2, str3, (com.alibaba.sdk.android.oss.model.ObjectMetadata) null, str4);
    }

    public java.lang.Boolean deleteUploadOnCancelling() {
        return this.deleteUploadOnCancelling;
    }

    public com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode getExceptionTerminationMode() {
        return this.exceptionTerminationMode;
    }

    public java.lang.String getRecordDirectory() {
        return this.recordDirectory;
    }

    public void setDeleteUploadOnCancelling(java.lang.Boolean bool) {
        this.deleteUploadOnCancelling = bool;
    }

    public void setExceptionTerminationMode(com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode exceptionTerminationMode) {
        this.exceptionTerminationMode = exceptionTerminationMode;
    }

    public void setRecordDirectory(java.lang.String str) {
        if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(str)) {
            java.io.File file = new java.io.File(str);
            if (!file.exists() || !file.isDirectory()) {
                throw new java.lang.IllegalArgumentException("Record directory must exist, and it should be a directory!");
            }
        }
        this.recordDirectory = str;
    }
}
