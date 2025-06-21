package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AudioFade extends com.aliyun.svideosdk.common.struct.project.Effect {

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DURATION)
    public float duration;

    @com.google.gson.annotations.SerializedName("FadeIn")
    public boolean isFadeIn;

    @com.google.gson.annotations.SerializedName("ShapeType")
    public int shapeType;

    public AudioFade(int i, float f, boolean z) {
        super(com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade);
        this.duration = f;
        this.shapeType = i;
        this.isFadeIn = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.isFadeIn == ((com.aliyun.svideosdk.common.struct.project.AudioFade) obj).isFadeIn;
    }
}
