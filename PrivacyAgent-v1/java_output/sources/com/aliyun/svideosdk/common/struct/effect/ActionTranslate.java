package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionTranslate extends com.aliyun.svideosdk.common.struct.effect.ActionFrameBase<com.aliyun.svideosdk.common.struct.effect.Frame.FramePoint> {

    @com.google.gson.annotations.SerializedName("FromX")
    protected float mFromPointX;

    @com.google.gson.annotations.SerializedName("FromY")
    protected float mFromPointY;

    @com.google.gson.annotations.SerializedName("ToX")
    protected float mToPointX;

    @com.google.gson.annotations.SerializedName("ToY")
    protected float mToPointY;

    @com.google.gson.annotations.SerializedName("TranslateType")
    protected int mTranslateType = com.aliyun.svideosdk.common.struct.effect.ActionTranslate.TranslateType.TranslateTo.ordinal();

    public enum TranslateType {
        TranslateTo,
        TranslateBy
    }

    public ActionTranslate() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.translate;
    }

    public float getFromPointX() {
        return this.mFromPointX;
    }

    public float getFromPointY() {
        return this.mFromPointY;
    }

    public float getToPointX() {
        return this.mToPointX;
    }

    public float getToPointY() {
        return this.mToPointY;
    }

    public void setFromPointX(float f) {
        this.mFromPointX = f;
    }

    public void setFromPointY(float f) {
        this.mFromPointY = f;
    }

    public void setToPointX(float f) {
        this.mToPointX = f;
    }

    public void setToPointY(float f) {
        this.mToPointY = f;
    }

    public void setTranslateType(com.aliyun.svideosdk.common.struct.effect.ActionTranslate.TranslateType translateType) {
        this.mTranslateType = translateType.ordinal();
    }
}
