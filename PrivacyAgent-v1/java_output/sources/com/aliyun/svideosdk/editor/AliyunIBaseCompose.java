package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIBaseCompose {
    int cancelCompose();

    int compose(java.lang.String str, java.lang.String str2, com.aliyun.svideosdk.editor.AliyunIComposeCallBack aliyunIComposeCallBack);

    int init(android.content.Context context);

    int pauseCompose();

    void release();

    int resumeCompose();
}
