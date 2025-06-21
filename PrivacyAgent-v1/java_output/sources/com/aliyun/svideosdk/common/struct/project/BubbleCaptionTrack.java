package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class BubbleCaptionTrack extends com.aliyun.svideosdk.common.struct.project.SubTitleTrack {

    @com.google.gson.annotations.SerializedName("TextCenterX")
    private float mTextCenterX;

    @com.google.gson.annotations.SerializedName("TextCenterY")
    private float mTextCenterY;

    public BubbleCaptionTrack() {
        setType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption);
    }

    public float getTextCenterX() {
        return this.mTextCenterX;
    }

    public float getTextCenterY() {
        return this.mTextCenterY;
    }

    public void setTextCenterX(float f) {
        this.mTextCenterX = f;
    }

    public void setTextCenterY(float f) {
        this.mTextCenterY = f;
    }
}
