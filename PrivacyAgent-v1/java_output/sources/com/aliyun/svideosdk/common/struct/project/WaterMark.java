package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class WaterMark extends com.aliyun.svideosdk.common.struct.project.GlobalTrack {

    @com.google.gson.annotations.SerializedName("Actions")
    private java.util.ArrayList<com.aliyun.svideosdk.common.struct.effect.ActionBase> mActions = new java.util.ArrayList<>();

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_HEIGHT)
    private float mHeight;

    @com.google.gson.annotations.SerializedName("Source")
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_WIDTH)
    private float mWidth;

    @com.google.gson.annotations.SerializedName("X")
    private float mX;

    @com.google.gson.annotations.SerializedName("Y")
    private float mY;

    public WaterMark() {
        setType(com.aliyun.svideosdk.common.struct.project.GlobalTrack.Type.watermark);
    }

    public java.util.ArrayList<com.aliyun.svideosdk.common.struct.effect.ActionBase> getActions() {
        return this.mActions;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public void setX(float f) {
        this.mX = f;
    }

    public void setY(float f) {
        this.mY = f;
    }
}
