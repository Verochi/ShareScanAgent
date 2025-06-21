package com.alibaba.sdk.android.vod.upload.internal;

/* loaded from: classes.dex */
public class ResumeableSession {
    private static final java.lang.String OSSUPLOAD_INFO = "OSS_UPLOAD_INFO";
    public static final java.lang.String SHAREDPREFS_OSSUPLOAD = "OSS_UPLOAD_CONFIG";
    private java.lang.ref.WeakReference<android.content.Context> context;
    private boolean enabled = true;

    public ResumeableSession(android.content.Context context) {
        this.context = new java.lang.ref.WeakReference<>(context);
    }

    public synchronized boolean deleteResumeableFileInfo(java.lang.String str) {
        if (!this.enabled) {
            return true;
        }
        com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo uploadInfo = com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
        if (uploadInfo == null || !com.alibaba.sdk.android.vod.upload.common.utils.MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), str)) {
            return false;
        }
        return com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.clearUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
    }

    public synchronized boolean deleteResumeableFileInfo(java.lang.String str, boolean z) {
        if (!z) {
            if (!this.enabled) {
                return true;
            }
        }
        com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo uploadInfo = com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
        if (uploadInfo == null || !com.alibaba.sdk.android.vod.upload.common.utils.MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), str)) {
            return false;
        }
        return com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.clearUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
    }

    public synchronized com.alibaba.sdk.android.vod.upload.model.UploadFileInfo getResumeableFileInfo(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, java.lang.String str) {
        if (!this.enabled) {
            return uploadFileInfo;
        }
        com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo uploadInfo = com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, uploadFileInfo.getFilePath());
        if (android.text.TextUtils.isEmpty(str)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("videoId cannot be null");
        } else {
            uploadFileInfo.setBucket(uploadInfo.getBucket());
            uploadFileInfo.setObject(uploadInfo.getObject());
            uploadFileInfo.setEndpoint(uploadInfo.getEndpoint());
        }
        return uploadFileInfo;
    }

    public synchronized java.lang.String getResumeableFileVideoID(java.lang.String str) {
        if (!this.enabled) {
            return null;
        }
        com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo uploadInfo = com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.getUploadInfo(this.context.get(), SHAREDPREFS_OSSUPLOAD, str);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("getResumeableFileInfo1" + uploadInfo);
        if (uploadInfo == null || !com.alibaba.sdk.android.vod.upload.common.utils.MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), str)) {
            return null;
        }
        return uploadInfo.getVideoID();
    }

    public synchronized void saveResumeableFileInfo(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, java.lang.String str) {
        com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo oSSUploadInfo = new com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo();
        oSSUploadInfo.setBucket(uploadFileInfo.getBucket());
        oSSUploadInfo.setEndpoint(uploadFileInfo.getEndpoint());
        oSSUploadInfo.setObject(uploadFileInfo.getObject());
        oSSUploadInfo.setMd5(com.alibaba.sdk.android.vod.upload.common.utils.MD5.calculateMD5(this.context.get(), uploadFileInfo.getFilePath()));
        oSSUploadInfo.setVideoID(str);
        try {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("saveUploadInfo" + oSSUploadInfo, toString());
            com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.saveUploadInfp(this.context.get(), SHAREDPREFS_OSSUPLOAD, uploadFileInfo.getFilePath(), oSSUploadInfo);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("saveUploadInfo error");
        }
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }
}
