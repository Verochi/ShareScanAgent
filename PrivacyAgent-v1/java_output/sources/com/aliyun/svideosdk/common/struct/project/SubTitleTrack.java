package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class SubTitleTrack extends com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack {

    @com.google.gson.annotations.SerializedName("BackgroundImgPath")
    private com.aliyun.svideosdk.common.struct.project.Source mBackgroundImgPath;

    @com.google.gson.annotations.SerializedName("Font")
    private com.aliyun.svideosdk.common.struct.project.Source mFont;
    private transient float mPreBegin;
    private transient float mPreEnd;

    @com.google.gson.annotations.SerializedName("Text")
    private java.lang.String mText;

    @com.google.gson.annotations.SerializedName("TextAlignment")
    private int mTextAlignment;

    @com.google.gson.annotations.SerializedName("TextBgColor")
    private int mTextBackgroundColor = 0;

    @com.google.gson.annotations.SerializedName("TextBmpPath")
    private java.lang.String mTextBmpPath;

    @com.google.gson.annotations.SerializedName("TextColor")
    private int mTextColor;

    @com.google.gson.annotations.SerializedName("TextHeight")
    private float mTextHeight;

    @com.google.gson.annotations.SerializedName("TextMaxLines")
    private int mTextMaxLines;

    @com.google.gson.annotations.SerializedName("TextPaddingX")
    private float mTextPaddingX;

    @com.google.gson.annotations.SerializedName("TextPaddingY")
    private float mTextPaddingY;
    private transient float mTextRotation;

    @com.google.gson.annotations.SerializedName("TextSize")
    private float mTextSize;

    @com.google.gson.annotations.SerializedName("OutlineColor")
    private int mTextStrokeColor;

    @com.google.gson.annotations.SerializedName("TextWidth")
    private float mTextWidth;

    public SubTitleTrack() {
        setType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.subtitle);
    }

    public com.aliyun.svideosdk.common.struct.project.Source getBackgroundImgPath() {
        return this.mBackgroundImgPath;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getFont() {
        return this.mFont;
    }

    public float getPreBegin() {
        return this.mPreBegin;
    }

    public float getPreEnd() {
        return this.mPreEnd;
    }

    public java.lang.String getText() {
        return this.mText;
    }

    public int getTextAlignment() {
        return this.mTextAlignment;
    }

    public int getTextBackgroundColor() {
        return this.mTextBackgroundColor;
    }

    public java.lang.String getTextBmpPath() {
        return this.mTextBmpPath;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextHeight() {
        return this.mTextHeight;
    }

    public int getTextMaxLines() {
        return this.mTextMaxLines;
    }

    public float getTextPaddingX() {
        return this.mTextPaddingX;
    }

    public float getTextPaddingY() {
        return this.mTextPaddingY;
    }

    public float getTextRotation() {
        return this.mTextRotation;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public int getTextStrokeColor() {
        return this.mTextStrokeColor;
    }

    public float getTextWidth() {
        return this.mTextWidth;
    }

    public void setBackgroundImgPath(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mBackgroundImgPath = source;
    }

    public void setFont(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mFont = source;
    }

    public void setPreBegin(float f) {
        this.mPreBegin = f;
    }

    public void setPreEnd(float f) {
        this.mPreEnd = f;
    }

    public void setText(java.lang.String str) {
        this.mText = str;
    }

    public void setTextAlignment(int i) {
        this.mTextAlignment = i;
    }

    public void setTextBackgroundColor(int i) {
        this.mTextBackgroundColor = i;
    }

    public void setTextBmpPath(java.lang.String str) {
        this.mTextBmpPath = str;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTextHeight(float f) {
        this.mTextHeight = f;
    }

    public void setTextMaxLines(int i) {
        this.mTextMaxLines = i;
    }

    public void setTextPaddingX(float f) {
        this.mTextPaddingX = f;
    }

    public void setTextPaddingY(float f) {
        this.mTextPaddingY = f;
    }

    public void setTextRotation(float f) {
        this.mTextRotation = f;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
    }

    public void setTextStrokeColor(int i) {
        this.mTextStrokeColor = i;
    }

    public void setTextWidth(float f) {
        this.mTextWidth = f;
    }
}
