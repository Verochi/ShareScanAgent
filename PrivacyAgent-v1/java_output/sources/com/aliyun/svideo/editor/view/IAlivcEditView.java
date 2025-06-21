package com.aliyun.svideo.editor.view;

/* loaded from: classes12.dex */
public interface IAlivcEditView {
    void addVideoUpdateListener(com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener onVideoUpdateDurationListener);

    com.aliyun.svideo.editor.view.AlivcEditView getAlivcEditView();

    com.aliyun.svideosdk.editor.AliyunIEditor getAliyunIEditor();

    android.view.View getSufaceView();

    void removeVideoUpdateListener(com.aliyun.svideo.editor.effects.caption.listener.OnVideoUpdateDurationListener onVideoUpdateDurationListener);
}
