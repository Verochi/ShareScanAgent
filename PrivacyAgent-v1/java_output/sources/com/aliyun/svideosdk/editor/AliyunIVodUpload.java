package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIVodUpload {

    @com.aliyun.Visible
    public interface AliyunIVodUploadCallBack {
        void onUploadFailed(java.lang.String str, java.lang.String str2);

        void onUploadProgress(long j, long j2);

        void onUploadRetry(java.lang.String str, java.lang.String str2);

        void onUploadRetryResume();

        void onUploadSucceed();

        void onUploadTokenExpired();
    }

    int cancelUpload();

    int init(android.content.Context context, com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack);

    int init(android.content.Context context, com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack aliyunIVodUploadCallBack, boolean z);

    int pauseUpload();

    int refreshWithUploadAuth(java.lang.String str);

    void release();

    int resumeUpload();

    void updatePartInfoList(java.lang.String str, java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> list, boolean z);

    int uploadImageWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3);

    int uploadVideoWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3);

    int uploadVideoWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> list);
}
