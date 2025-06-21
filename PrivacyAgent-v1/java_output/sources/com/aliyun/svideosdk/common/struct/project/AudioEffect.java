package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AudioEffect extends com.aliyun.svideosdk.common.struct.project.Effect {

    @com.google.gson.annotations.SerializedName("EffectParam")
    public int mEffectParam;

    @com.google.gson.annotations.SerializedName("EffectType")
    public com.aliyun.svideosdk.editor.AudioEffectType mEffectType;

    public AudioEffect() {
        super(com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_effect);
    }

    public AudioEffect(int i, int i2) {
        this(com.aliyun.svideosdk.editor.AudioEffectType.values()[i], i2);
    }

    public AudioEffect(com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, int i) {
        this();
        this.mEffectType = audioEffectType;
        this.mEffectParam = i;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.aliyun.svideosdk.common.struct.project.AudioEffect) && ((com.aliyun.svideosdk.common.struct.project.AudioEffect) obj).mEffectType == this.mEffectType;
    }
}
