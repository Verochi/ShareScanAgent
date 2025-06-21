package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class BlurBackground extends com.aliyun.svideosdk.common.struct.project.VideoEffect {

    @com.google.gson.annotations.SerializedName("BlurRadius")
    private float mBlurRadius;

    public BlurBackground(int i, int i2, long j, long j2, float f) {
        super(com.aliyun.svideosdk.common.struct.project.Effect.Type.blur_background, i, i2, j, j2);
        this.mBlurRadius = f;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.aliyun.svideosdk.common.struct.effect.BlurBackground) && ((com.aliyun.svideosdk.common.struct.effect.BlurBackground) obj).getId() == getId();
    }

    public float getBlurRadius() {
        return this.mBlurRadius;
    }

    public void setBlurRadius(float f) {
        this.mBlurRadius = f;
    }
}
