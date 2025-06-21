package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class BorderInfo {

    @com.google.gson.annotations.SerializedName("Color")
    private int color;

    @com.google.gson.annotations.SerializedName("CornerRadius")
    private float cornerRadius;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_WIDTH)
    private float width;

    public int getColor() {
        return this.color;
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getWidth() {
        return this.width;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public java.lang.String toString() {
        return "BorderInfo{color=" + this.color + ", width=" + this.width + ", cornerRadius=" + this.cornerRadius + '}';
    }
}
