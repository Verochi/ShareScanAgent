package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class ComposeAndUploadCallBack implements com.aliyun.svideosdk.editor.AliyunIComposeCallBack, com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunIVodUploadCallBack {

    @com.aliyun.Visible
    public interface VideoUploadAuthCallBack {
        void onFailure(int i, java.lang.String str);

        void onSuccess(java.lang.String str, java.lang.String str2, java.lang.String str3);
    }

    public abstract void getVideoUploadAuth(com.aliyun.svideosdk.editor.ComposeAndUploadCallBack.VideoUploadAuthCallBack videoUploadAuthCallBack);
}
