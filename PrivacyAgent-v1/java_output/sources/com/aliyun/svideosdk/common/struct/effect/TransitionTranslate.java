package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TransitionTranslate extends com.aliyun.svideosdk.common.struct.effect.TransitionBase {

    @com.google.gson.annotations.SerializedName("Direction")
    protected int mDirection;

    public TransitionTranslate() {
        ((com.aliyun.svideosdk.common.struct.effect.TransitionBase) this).mType = 1;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }
}
