package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionScale extends com.aliyun.svideosdk.common.struct.effect.ActionFrameBase<java.lang.Float> {

    @com.google.gson.annotations.SerializedName("From")
    protected float mFromScale;

    @com.google.gson.annotations.SerializedName("AnchorBaseScale")
    protected float mScaleAnchorBaseScale = 1.0f;

    @com.google.gson.annotations.SerializedName("ScaleAnchorEnable")
    protected boolean mScaleAnchorEnable;

    @com.google.gson.annotations.SerializedName("AnchorX")
    protected float mScaleAnchorX;

    @com.google.gson.annotations.SerializedName("AnchorY")
    protected float mScaleAnchorY;

    @com.google.gson.annotations.SerializedName("To")
    protected float mToScale;

    public ActionScale() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.scale;
    }

    public float getFromScale() {
        return this.mFromScale;
    }

    public float getToScale() {
        return this.mToScale;
    }

    public void setFromScale(float f) {
        this.mFromScale = f;
    }

    public void setScaleAnchorBaseScale(float f) {
        this.mScaleAnchorBaseScale = f;
    }

    public void setScaleAnchorEnable(boolean z) {
        this.mScaleAnchorEnable = z;
    }

    public void setScaleAnchorX(float f) {
        this.mScaleAnchorX = f;
    }

    public void setScaleAnchorY(float f) {
        this.mScaleAnchorY = f;
    }

    public void setToScale(float f) {
        this.mToScale = f;
    }
}
