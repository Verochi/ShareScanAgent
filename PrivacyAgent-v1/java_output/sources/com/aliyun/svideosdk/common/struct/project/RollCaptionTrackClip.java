package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class RollCaptionTrackClip {

    @com.google.gson.annotations.SerializedName("Font")
    private com.aliyun.svideosdk.common.struct.project.Source mFont;
    private transient int mId;

    @com.google.gson.annotations.SerializedName("Text")
    private java.lang.String mText;

    @com.google.gson.annotations.SerializedName("TimelineIn")
    private float mTimelineIn;

    @com.google.gson.annotations.SerializedName("TimelineOut")
    private float mTimelineOut;

    @com.google.gson.annotations.SerializedName("TextColor")
    private int mTextColor = -1;

    @com.google.gson.annotations.SerializedName("OutlineColor")
    private int mOutlineColor = 0;

    public com.aliyun.svideosdk.common.struct.project.Source getFont() {
        return this.mFont;
    }

    public int getId() {
        return this.mId;
    }

    public int getOutlineColor() {
        return this.mOutlineColor;
    }

    public java.lang.String getText() {
        return this.mText;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public void setFont(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mFont = source;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setOutlineColor(int i) {
        this.mOutlineColor = i;
    }

    public void setText(java.lang.String str) {
        this.mText = str;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }
}
