package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionFade extends com.aliyun.svideosdk.common.struct.effect.ActionFrameBase<java.lang.Float> {

    @com.google.gson.annotations.SerializedName("From")
    protected float mFromAlpha;

    @com.google.gson.annotations.SerializedName("To")
    protected float mToAlpha;

    public ActionFade() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.alpha;
    }

    public float getFromAlpha() {
        return this.mFromAlpha;
    }

    public float getToAlpha() {
        return this.mToAlpha;
    }

    public void setAnimationConfig(java.util.List<android.util.Pair<java.lang.Float, java.lang.Float>> list) {
    }

    public void setFromAlpha(float f) {
        this.mFromAlpha = f;
    }

    public void setToAlpha(float f) {
        this.mToAlpha = f;
    }
}
