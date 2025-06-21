package com.aliyun.svideosdk.common.struct.effect;

/* loaded from: classes12.dex */
public class ActionRotateBase extends com.aliyun.svideosdk.common.struct.effect.ActionFrameBase<java.lang.Float> {

    @com.google.gson.annotations.SerializedName("CenterCoordinateSys")
    protected int mCenterCoordinateSys;

    @com.google.gson.annotations.SerializedName("CenterX")
    protected float mCenterX;

    @com.google.gson.annotations.SerializedName("CenterY")
    protected float mCenterY;

    public void setCenterCoordinateSys(int i) {
        this.mCenterCoordinateSys = i;
    }

    public void setCenterX(float f) {
        this.mCenterX = f;
    }

    public void setCenterY(float f) {
        this.mCenterY = f;
    }
}
