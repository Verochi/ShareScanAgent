package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TransitionShutter extends com.aliyun.svideosdk.common.struct.effect.TransitionBase {

    @com.google.gson.annotations.SerializedName("LineWidth")
    protected float mLineWidth;

    @com.google.gson.annotations.SerializedName(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION)
    protected int mOrientation;

    public TransitionShutter() {
        ((com.aliyun.svideosdk.common.struct.effect.TransitionBase) this).mType = 0;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setLineWidth(float f) {
        this.mLineWidth = f;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }
}
