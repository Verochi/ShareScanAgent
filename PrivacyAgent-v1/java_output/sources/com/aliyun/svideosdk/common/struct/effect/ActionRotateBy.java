package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionRotateBy extends com.aliyun.svideosdk.common.struct.effect.ActionRotateBase {

    @com.google.gson.annotations.SerializedName("From")
    protected float mFromDegree;

    @com.google.gson.annotations.SerializedName("Rotate")
    protected float mRotateDegree;

    public ActionRotateBy() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.rotate_by;
    }

    public float getRotateDegree() {
        return this.mRotateDegree;
    }

    public void setFromDegree(float f) {
        this.mFromDegree = f;
    }

    public void setRotateDegree(float f) {
        this.mRotateDegree = f;
    }
}
