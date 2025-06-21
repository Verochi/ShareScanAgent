package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class VideoTrackClip extends com.aliyun.svideosdk.common.struct.project.TrackClip implements com.aliyun.svideosdk.common.struct.project.TemplateNode {
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 0;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_DURATION)
    private float mDuration;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_HEIGHT)
    private int mHeight;

    @com.google.gson.annotations.SerializedName("In")
    private float mIn;

    @com.google.gson.annotations.SerializedName("NodeKey")
    protected java.lang.String mNodeKey;

    @com.google.gson.annotations.SerializedName("Out")
    private float mOut;

    @com.google.gson.annotations.SerializedName("Source")
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_WIDTH)
    private int mWidth;

    @com.google.gson.annotations.SerializedName("Type")
    private int mType = 0;

    @com.google.gson.annotations.SerializedName("Rotation")
    private int mRotation = -1;

    @com.google.gson.annotations.SerializedName(androidx.exifinterface.media.ExifInterface.TAG_BRIGHTNESS_VALUE)
    private float mBrightness = 0.5f;

    @com.google.gson.annotations.SerializedName("ContrastValue")
    private float mContrast = 0.25f;

    @com.google.gson.annotations.SerializedName("VignetteValue")
    private float mVignette = 0.0f;

    @com.google.gson.annotations.SerializedName("SaturationValue")
    private float mSaturation = 0.5f;

    @com.google.gson.annotations.SerializedName("SharpnessValue")
    private float mSharpness = 0.0f;

    @com.google.gson.annotations.SerializedName("HorizontalFlip")
    private boolean mHorizontalFlip = false;

    @com.google.gson.annotations.SerializedName("Effects")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> mEffects = new java.util.ArrayList();

    @com.google.gson.annotations.SerializedName("Actions")
    private java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> mActions = new java.util.ArrayList();

    public java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> getActions() {
        return this.mActions;
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public float getContrast() {
        return this.mContrast;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> getEffects() {
        return this.mEffects;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean getHorizontalFlip() {
        return this.mHorizontalFlip;
    }

    public float getIn() {
        return this.mIn;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public java.lang.String getNodeKey() {
        return this.mNodeKey;
    }

    public float getOut() {
        return this.mOut;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public float getSaturation() {
        return this.mSaturation;
    }

    public float getSharpness() {
        return this.mSharpness;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public com.aliyun.svideosdk.common.struct.effect.TransitionBase getTransition() {
        for (com.aliyun.svideosdk.common.struct.project.Effect effect : this.mEffects) {
            if (effect instanceof com.aliyun.svideosdk.common.struct.effect.TransitionBase) {
                return (com.aliyun.svideosdk.common.struct.effect.TransitionBase) effect;
            }
        }
        return null;
    }

    public int getType() {
        return this.mType;
    }

    public float getVignette() {
        return this.mVignette;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isFileExists() {
        if (getSource() == null || com.aliyun.common.utils.StringUtils.isEmpty(getSource().getPath())) {
            return false;
        }
        return new java.io.File(getSource().getPath()).exists();
    }

    public boolean isHorizontalFlip() {
        return this.mHorizontalFlip;
    }

    public void setBrightness(float f) {
        this.mBrightness = f;
    }

    public void setContrast(float f) {
        this.mContrast = f;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setHorizontalFlip(boolean z) {
        this.mHorizontalFlip = z;
    }

    public void setIn(float f) {
        this.mIn = f;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public void setNodeKey(java.lang.String str) {
        this.mNodeKey = str;
    }

    public void setOut(float f) {
        this.mOut = f;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setSaturation(float f) {
        this.mSaturation = f;
    }

    public void setSharpness(float f) {
        this.mSharpness = f;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }

    public void setTransition(com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.Effect> it = this.mEffects.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.aliyun.svideosdk.common.struct.project.Effect next = it.next();
            if (next instanceof com.aliyun.svideosdk.common.struct.effect.TransitionBase) {
                this.mEffects.remove(next);
                break;
            }
        }
        if (transitionBase != null) {
            this.mEffects.add(transitionBase);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setVignette(float f) {
        this.mVignette = f;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }
}
