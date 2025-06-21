package com.aliyun.svideo.editor.msg.body;

/* loaded from: classes12.dex */
public class BrightnessProgressMsg {
    private float progress;

    public float getProgress() {
        return this.progress;
    }

    public com.aliyun.svideo.editor.msg.body.BrightnessProgressMsg progress(float f) {
        this.progress = f;
        return this;
    }

    public void setProgress(float f) {
        this.progress = f;
    }
}
