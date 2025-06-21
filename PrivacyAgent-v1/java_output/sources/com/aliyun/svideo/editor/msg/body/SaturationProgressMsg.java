package com.aliyun.svideo.editor.msg.body;

/* loaded from: classes12.dex */
public class SaturationProgressMsg {
    private float progress;

    public float getProgress() {
        return this.progress;
    }

    public com.aliyun.svideo.editor.msg.body.SaturationProgressMsg progress(float f) {
        this.progress = f;
        return this;
    }

    public void setProgress(float f) {
        this.progress = f;
    }
}
