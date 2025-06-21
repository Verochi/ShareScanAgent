package com.alibaba.sdk.android.vod.upload;

/* loaded from: classes.dex */
public abstract class VODUploadCallback {
    public void onUploadFailed(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, java.lang.String str, java.lang.String str2) {
    }

    public void onUploadProgress(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, long j, long j2) {
    }

    public void onUploadRetry(java.lang.String str, java.lang.String str2) {
    }

    public void onUploadRetryResume() {
    }

    public void onUploadStarted(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
    }

    @java.lang.Deprecated
    public void onUploadSucceed(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
    }

    public void onUploadSucceed(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, com.alibaba.sdk.android.vod.upload.model.VodUploadResult vodUploadResult) {
    }

    public void onUploadTokenExpired() {
    }
}
