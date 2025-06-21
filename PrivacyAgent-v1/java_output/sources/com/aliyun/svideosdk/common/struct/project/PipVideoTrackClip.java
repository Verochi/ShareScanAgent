package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class PipVideoTrackClip extends com.aliyun.svideosdk.common.struct.project.VideoTrackClip {

    @com.google.gson.annotations.SerializedName("ClassType")
    java.lang.String ClassType = "pip";

    @com.google.gson.annotations.SerializedName("Alpha")
    private float alpha;

    @com.google.gson.annotations.SerializedName("Border")
    private com.aliyun.svideosdk.common.struct.project.BorderInfo border;

    @com.google.gson.annotations.SerializedName("X")
    private float centerX;

    @com.google.gson.annotations.SerializedName("Y")
    private float centerY;

    @com.google.gson.annotations.SerializedName("OutputRotation")
    private float rotationRadian;

    @com.google.gson.annotations.SerializedName("Scale")
    private float scale;

    public float getAlpha() {
        return this.alpha;
    }

    public com.aliyun.svideosdk.common.struct.project.BorderInfo getBorder() {
        if (this.border == null) {
            this.border = new com.aliyun.svideosdk.common.struct.project.BorderInfo();
        }
        return this.border;
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public float getRotationRadian() {
        return this.rotationRadian;
    }

    public float getScale() {
        return this.scale;
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    public void setBorder(com.aliyun.svideosdk.common.struct.project.BorderInfo borderInfo) {
        this.border = borderInfo;
    }

    public void setCenterX(float f) {
        this.centerX = f;
    }

    public void setCenterY(float f) {
        this.centerY = f;
    }

    public void setRotationRadian(float f) {
        this.rotationRadian = f;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public java.lang.String toString() {
        return "PipVideoTrackClip{centerX=" + this.centerX + ", centerY=" + this.centerY + ", scale=" + this.scale + ", rotationRadian=" + this.rotationRadian + ", border=" + this.border + '}';
    }
}
