package com.alibaba.sdk.android.vod.upload.model;

/* loaded from: classes.dex */
public class UploadFileInfo {
    public static final int UPLOAD_FILE_TYPE_IMAGE = 0;
    public static final int UPLOAD_FILE_TYPE_VIDEO = 1;
    private java.lang.String bucket;
    private java.lang.String endpoint;
    private java.lang.String filePath;
    private java.lang.String object;
    private com.alibaba.sdk.android.vod.upload.common.UploadStateType status;
    private com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo;
    private int fileType = 1;
    private boolean isMultipart = false;
    private long fileLength = -1;
    private java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> partInfoList = new java.util.ArrayList();

    public boolean equals(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        return (uploadFileInfo == null || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(uploadFileInfo.filePath) || !uploadFileInfo.filePath.equals(this.filePath) || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(uploadFileInfo.endpoint) || !uploadFileInfo.endpoint.equals(this.endpoint) || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(uploadFileInfo.bucket) || !uploadFileInfo.bucket.equals(this.bucket) || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(uploadFileInfo.object) || !uploadFileInfo.object.equals(this.object) || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(uploadFileInfo.object) || !uploadFileInfo.object.equals(this.object)) ? false : true;
    }

    public java.lang.String getBucket() {
        return this.bucket;
    }

    public java.lang.String getEndpoint() {
        return this.endpoint;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public int getFileType() {
        return this.fileType;
    }

    public java.lang.String getObject() {
        return this.object;
    }

    public java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> getPartInfoList() {
        return this.partInfoList;
    }

    public com.alibaba.sdk.android.vod.upload.common.UploadStateType getStatus() {
        return this.status;
    }

    public com.alibaba.sdk.android.vod.upload.model.VodInfo getVodInfo() {
        return this.vodInfo;
    }

    public boolean isMultipart() {
        return this.isMultipart;
    }

    public void setBucket(java.lang.String str) {
        this.bucket = str;
    }

    public void setEndpoint(java.lang.String str) {
        this.endpoint = str;
    }

    public void setFileLength(long j) {
        this.fileLength = j;
    }

    public void setFilePath(java.lang.String str) {
        this.filePath = str;
    }

    public void setFileType(int i) {
        this.fileType = i;
    }

    public void setMultipart(boolean z) {
        this.isMultipart = z;
    }

    public void setObject(java.lang.String str) {
        this.object = str;
    }

    public void setPartInfoList(java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> list) {
        this.partInfoList = list;
    }

    public void setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType uploadStateType) {
        this.status = uploadStateType;
    }

    public void setVodInfo(com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo) {
        this.vodInfo = vodInfo;
    }
}
