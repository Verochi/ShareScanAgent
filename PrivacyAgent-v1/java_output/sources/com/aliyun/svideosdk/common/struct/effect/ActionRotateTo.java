package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionRotateTo extends com.aliyun.svideosdk.common.struct.effect.ActionRotateBase {

    @com.google.gson.annotations.SerializedName("From")
    protected float mFromDegree;

    @com.google.gson.annotations.SerializedName("To")
    protected float mRotateToDegree;

    public ActionRotateTo() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.rotate_to;
    }

    public float getFromDegree() {
        return this.mFromDegree;
    }

    public float getRotateToDegree() {
        return this.mRotateToDegree;
    }

    public void setFromDegree(float f) {
        this.mFromDegree = f;
    }

    public void setRotateToDegree(float f) {
        this.mRotateToDegree = f;
    }
}
