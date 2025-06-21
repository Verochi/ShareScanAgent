package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class Effect {

    @com.google.gson.annotations.SerializedName("Type")
    private com.aliyun.svideosdk.common.struct.project.Effect.Type mType;

    public enum Type {
        blur_background,
        running_display_mode,
        transition,
        audio_effect,
        audio_fade
    }

    public Effect(com.aliyun.svideosdk.common.struct.project.Effect.Type type) {
        this.mType = type;
    }

    public com.aliyun.svideosdk.common.struct.project.Effect.Type getType() {
        return this.mType;
    }
}
