package com.aliyun.svideosdk.editor.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunTemplatePlayer {
    java.util.List<com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam> getAllParams();

    long getCurrentPlayPosition();

    long getDuration();

    com.aliyun.svideosdk.common.struct.project.AliyunEditorProject getEditorProject();

    int init(android.view.SurfaceView surfaceView, int i, int i2);

    boolean isPaused();

    boolean isPlaying();

    void onDestroy();

    int pause();

    int play();

    int seek(long j);

    void setPlayerCallBack(com.aliyun.svideosdk.editor.EditorCallBack editorCallBack);
}
