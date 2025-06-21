package com.aliyun.svideosdk.common.struct.project;

/* loaded from: classes12.dex */
public class CaptionTrack extends com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack {

    @com.google.gson.annotations.SerializedName("TextBgColor")
    private int mBackgroundColor;

    @com.google.gson.annotations.SerializedName("BackgroundCornerRadius")
    private float mBackgroundCornerRadius;
    private transient com.aliyun.svideosdk.common.AliyunCaption mCaption;

    @com.google.gson.annotations.SerializedName("Font")
    private com.aliyun.svideosdk.common.struct.project.Source mFont;

    @com.google.gson.annotations.SerializedName("FontEffectSource")
    private com.aliyun.svideosdk.common.struct.project.Source mFontEffectSource;

    @com.google.gson.annotations.SerializedName("FontSize")
    private float mFontSize;

    @com.google.gson.annotations.SerializedName("OutlineColor")
    private int mOutlineColor;

    @com.google.gson.annotations.SerializedName("OutlineWidth")
    private float mOutlineWidth;

    @com.google.gson.annotations.SerializedName("Scale")
    public float mScale;

    @com.google.gson.annotations.SerializedName("ShadowColor")
    private int mShadowColor;

    @com.google.gson.annotations.SerializedName("ShadowOffsetH")
    private float mShadowOffsetX;

    @com.google.gson.annotations.SerializedName("ShadowOffsetV")
    private float mShadowOffsetY;

    @com.google.gson.annotations.SerializedName("Text")
    private java.lang.String mText;

    @com.google.gson.annotations.SerializedName("TextAlignment")
    private int mTextAlignment;

    @com.google.gson.annotations.SerializedName("TextColor")
    private int mTextColor;

    @com.google.gson.annotations.SerializedName("FaceType")
    private int mTypeface;

    public CaptionTrack() {
        setType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.caption);
    }

    public static com.aliyun.svideosdk.common.struct.project.CaptionTrack fromCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption) {
        com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = new com.aliyun.svideosdk.common.struct.project.CaptionTrack();
        captionTrack.setCaption(aliyunCaption);
        captionTrack.setId(aliyunCaption.getId());
        captionTrack.updateInfo();
        return captionTrack;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public float getBackgroundCornerRadius() {
        return this.mBackgroundCornerRadius;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getFont() {
        return this.mFont;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getFontEffectSource() {
        return this.mFontEffectSource;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public int getOutlineColor() {
        return this.mOutlineColor;
    }

    public float getOutlineWidth() {
        return this.mOutlineWidth;
    }

    public float getScale() {
        return this.mScale;
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public float getShadowOffsetX() {
        return this.mShadowOffsetX;
    }

    public float getShadowOffsetY() {
        return this.mShadowOffsetY;
    }

    public java.lang.String getText() {
        return this.mText;
    }

    public int getTextAlignment() {
        return this.mTextAlignment;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTypeface() {
        return this.mTypeface;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setBackgroundCornerRadius(float f) {
        this.mBackgroundCornerRadius = f;
    }

    public void setCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption) {
        this.mCaption = aliyunCaption;
    }

    public void setFont(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mFont = source;
    }

    public void setFontEffectSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mFontEffectSource = source;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public void setOutlineColor(int i) {
        this.mOutlineColor = i;
    }

    public void setOutlineWidth(float f) {
        this.mOutlineWidth = f;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public void setShadowColor(int i) {
        this.mShadowColor = i;
    }

    public void setShadowOffsetX(float f) {
        this.mShadowOffsetX = f;
    }

    public void setShadowOffsetY(float f) {
        this.mShadowOffsetY = f;
    }

    public void setText(java.lang.String str) {
        this.mText = str;
    }

    public void setTextAlignment(int i) {
        this.mTextAlignment = i;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTypeface(int i) {
        this.mTypeface = i;
    }

    public com.aliyun.svideosdk.common.AliyunCaption toCaption() {
        com.aliyun.svideosdk.common.AliyunCaption aliyunCaption = this.mCaption;
        if (aliyunCaption == null) {
            aliyunCaption = new com.aliyun.svideosdk.common.AliyunCaption();
            setCaption(aliyunCaption);
        }
        if (getFontEffectSource() != null) {
            aliyunCaption.setFontEffectSource(getFontEffectSource());
        }
        if (getSource() != null) {
            aliyunCaption.setBubbleSource(getSource());
        }
        aliyunCaption.setStartTime((long) (getTimelineIn() * 1000000.0f));
        aliyunCaption.setDuration((long) ((getTimelineOut() - getTimelineIn()) * 1000000.0f));
        aliyunCaption.setRotate(getRotation());
        aliyunCaption.setScale(getScale());
        aliyunCaption.setText(getText());
        aliyunCaption.setSize(new android.graphics.RectF(0.0f, 0.0f, getWidth(), getHeight()));
        aliyunCaption.setPosition(new android.graphics.PointF(getX(), getY()));
        aliyunCaption.setFontStyle(getFont() == null ? new com.aliyun.svideosdk.common.AliyunFontStyle("", getFontSize(), com.aliyun.svideosdk.common.AliyunTypeface.get(getTypeface())) : new com.aliyun.svideosdk.common.AliyunFontStyle(getFont(), getFontSize(), com.aliyun.svideosdk.common.AliyunTypeface.get(getTypeface())));
        aliyunCaption.setColor(new com.aliyun.svideosdk.common.AliyunColor(getTextColor()));
        aliyunCaption.setOutlineColor(new com.aliyun.svideosdk.common.AliyunColor(getOutlineColor()));
        aliyunCaption.setOutlineWidth(getOutlineWidth());
        aliyunCaption.setShadowColor(new com.aliyun.svideosdk.common.AliyunColor(getShadowColor()));
        aliyunCaption.setTextAlignment(getTextAlignment());
        aliyunCaption.setBackgroundColor(new com.aliyun.svideosdk.common.AliyunColor(getBackgroundColor()));
        aliyunCaption.setBackgroundCornerRadius(getBackgroundCornerRadius());
        aliyunCaption.setShadowOffset(new android.graphics.PointF(getShadowOffsetX(), getShadowOffsetY()));
        aliyunCaption.getActionList().clear();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.ActionBase> it = getActions().iterator();
        while (it.hasNext()) {
            aliyunCaption.addAction(it.next());
        }
        return aliyunCaption;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack
    public java.lang.String toString() {
        return super.toString() + "CompoundCaption{mText='" + this.mText + "', mScale=" + this.mScale + ", mFontSize=" + this.mFontSize + ", mTypeface=" + this.mTypeface + ", mFontColor=" + this.mTextColor + ", mOutlineColor=" + this.mOutlineColor + ", mOutlineWidth=" + this.mOutlineWidth + ", mShadowColor=" + this.mShadowColor + ", mShadowOffsetX=" + this.mShadowOffsetX + ", mShadowOffsetY=" + this.mShadowOffsetY + ", mFont=" + this.mFont + ", mFontEffect=" + this.mFontEffectSource + '}';
    }

    public void updateInfo() {
        if (this.mCaption == null) {
            return;
        }
        setTimelineIn(r0.getStartTime() / 1000000.0f);
        setTimelineOut(getTimelineIn() + (this.mCaption.getDuration() / 1000000.0f));
        setRotation(this.mCaption.getRotate());
        setScale(this.mCaption.getScale());
        setText(this.mCaption.getText());
        android.graphics.PointF position = this.mCaption.getPosition();
        setX(position.x);
        setY(position.y);
        android.graphics.RectF size = this.mCaption.getSize();
        setWidth(size.width());
        setHeight(size.height());
        com.aliyun.svideosdk.common.AliyunFontStyle fontStyle = this.mCaption.getFontStyle();
        setFontSize(fontStyle.getFontSize());
        if (fontStyle.getFontSource() != null) {
            setFont(new com.aliyun.svideosdk.common.struct.project.Source(fontStyle.getFontSource().getId(), fontStyle.getFontSource().getPath(), fontStyle.getFontSource().getURL()));
        }
        setTypeface(fontStyle.getTypeface().ordinal());
        setTextColor(this.mCaption.getColor().toArgb());
        setOutlineColor(this.mCaption.getOutlineColor().toArgb());
        setOutlineWidth(this.mCaption.getOutlineWidth());
        setShadowColor(this.mCaption.getShadowColor().toArgb());
        android.graphics.PointF shadowOffset = this.mCaption.getShadowOffset();
        setShadowOffsetX(shadowOffset.x);
        setShadowOffsetY(shadowOffset.y);
        setBackgroundColor(this.mCaption.getBackgroundColor().toArgb());
        setBackgroundCornerRadius(this.mCaption.getBackgroundCornerRadius());
        setTextAlignment(this.mCaption.getTextAlignment());
        if (this.mCaption.getFontEffectSource() != null) {
            setFontEffectSource(new com.aliyun.svideosdk.common.struct.project.Source(this.mCaption.getFontEffectSource().getId(), this.mCaption.getFontEffectSource().getPath(), this.mCaption.getFontEffectSource().getURL()));
        }
        if (this.mCaption.getBubbleSource() != null) {
            setSource(new com.aliyun.svideosdk.common.struct.project.Source(this.mCaption.getBubbleSource().getId(), this.mCaption.getBubbleSource().getPath(), this.mCaption.getBubbleSource().getURL()));
        }
        java.util.List<java.lang.Object> actionList = this.mCaption.getActionList();
        getActions().clear();
        for (java.lang.Object obj : actionList) {
            if (obj instanceof com.aliyun.svideosdk.common.struct.effect.ActionBase) {
                getActions().add((com.aliyun.svideosdk.common.struct.effect.ActionBase) obj);
            }
        }
    }
}
