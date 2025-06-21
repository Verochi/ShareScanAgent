package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
@java.lang.Deprecated
/* loaded from: classes12.dex */
public interface AliyunICompose extends com.aliyun.svideosdk.editor.AliyunIBaseCompose {

    @com.aliyun.Visible
    @java.lang.Deprecated
    public interface AliyunIUploadCallBack {
        void onSTSTokenExpired();

        void onUploadFailed(java.lang.String str, java.lang.String str2);

        void onUploadProgress(long j, long j2);

        void onUploadRetry(java.lang.String str, java.lang.String str2);

        void onUploadRetryResume();

        void onUploadSucceed(java.lang.String str, java.lang.String str2);
    }

    int cancelUpload();

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    int init(android.content.Context context);

    void pauseUpload();

    int refreshSTSToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    void release();

    void resumeUpload();

    void setUploadRetryAndTimeout(int i, int i2, int i3);

    int uploadWithVideoAndImg(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.alibaba.sdk.android.vod.upload.model.SvideoInfo svideoInfo, boolean z, java.lang.String str6, java.lang.String str7, com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack);
}
