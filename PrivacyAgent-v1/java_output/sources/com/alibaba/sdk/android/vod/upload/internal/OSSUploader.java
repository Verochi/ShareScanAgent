package com.alibaba.sdk.android.vod.upload.internal;

/* loaded from: classes.dex */
public interface OSSUploader {
    void cancel();

    void init(com.alibaba.sdk.android.vod.upload.model.OSSConfig oSSConfig, com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener oSSUploadListener);

    void pause();

    void resume();

    void setOSSClientConfiguration(com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration);

    void setRecordUploadProgressEnabled(boolean z);

    void start(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) throws java.io.FileNotFoundException;
}
