package com.alibaba.sdk.android.vod.upload;

/* loaded from: classes.dex */
public interface VODSVideoUploadClient {
    void cancel();

    void init();

    void pause();

    void refreshSTSToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    void release();

    void resume();

    void setAppVersion(java.lang.String str);

    void setRecordUploadProgressEnabled(boolean z);

    void setRegion(java.lang.String str);

    void uploadWithVideoAndImg(com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo vodSessionCreateInfo, com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback vODSVideoUploadCallback);
}
