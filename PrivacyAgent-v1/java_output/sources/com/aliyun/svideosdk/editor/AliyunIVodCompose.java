package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIVodCompose extends com.aliyun.svideosdk.editor.AliyunIBaseCompose {

    @com.aliyun.Visible
    public enum AliyunComposeState {
        STATE_IDLE,
        STATE_IMAGE_UPLOADING,
        STATE_VIDEO_UPLOADING
    }

    @com.aliyun.Visible
    public enum AliyunComposeUploadState {
        STATE_IDLE,
        STATE_GET_UPLOAD_AUTH,
        STATE_GET_UPLOAD_AUTH_SUCCEED,
        STATE_VIDEO_UPLOADING
    }

    @com.aliyun.Visible
    public interface AliyunIVodUploadCallBack extends com.aliyun.svideosdk.editor.AliyunIVodUpload.AliyunIVodUploadCallBack {
    }

    int cancelUpload();

    int composeAndUpload(java.lang.String str, java.lang.String str2, com.aliyun.svideosdk.editor.ComposeAndUploadCallBack composeAndUploadCallBack);

    com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState getState();

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    @com.aliyun.Visible
    int init(android.content.Context context);

    @com.aliyun.Visible
    int init(android.content.Context context, boolean z);

    int pauseUpload();

    int refreshWithUploadAuth(java.lang.String str);

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    void release();

    int resumeUpload();

    int uploadImageWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunIVodUploadCallBack aliyunIVodUploadCallBack);

    int uploadVideoWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunIVodUploadCallBack aliyunIVodUploadCallBack);
}
