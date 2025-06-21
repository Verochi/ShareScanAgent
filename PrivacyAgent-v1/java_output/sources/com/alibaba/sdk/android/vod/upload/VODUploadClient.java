package com.alibaba.sdk.android.vod.upload;

/* loaded from: classes.dex */
public interface VODUploadClient {
    void addFile(java.lang.String str, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo);

    void addFile(java.lang.String str, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> list);

    void addFile(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    void addFile(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo);

    void cancelFile(int i);

    void clearFiles();

    void deleteFile(int i);

    com.alibaba.sdk.android.vod.upload.common.VodUploadStateType getStatus();

    void init(com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback);

    void init(java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback);

    void init(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback);

    java.util.List<com.alibaba.sdk.android.vod.upload.model.UploadFileInfo> listFiles();

    void pause();

    void resume();

    void resumeFile(int i);

    void resumeWithAuth(java.lang.String str);

    void resumeWithToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    void setAppId(java.lang.String str);

    void setPartSize(long j);

    void setRecordUploadProgressEnabled(boolean z);

    void setRegion(java.lang.String str);

    void setStorageLocation(java.lang.String str);

    void setTemplateGroupId(java.lang.String str);

    void setTranscodeMode(boolean z);

    void setUploadAuthAndAddress(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, java.lang.String str, java.lang.String str2);

    void setVodHttpClientConfig(com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig vodHttpClientConfig);

    void setWorkflowId(java.lang.String str);

    void start();

    void stop();
}
