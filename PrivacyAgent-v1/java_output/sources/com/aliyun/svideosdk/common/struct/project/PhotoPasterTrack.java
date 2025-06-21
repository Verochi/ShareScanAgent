package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class PhotoPasterTrack extends com.aliyun.svideosdk.common.struct.project.PasterTrack implements com.aliyun.svideosdk.common.struct.project.TemplateNode {

    @com.google.gson.annotations.SerializedName("Actions")
    private java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> mActions = new java.util.ArrayList();
    private transient java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> mFrameArray;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_HEIGHT)
    private float mHeight;

    @com.google.gson.annotations.SerializedName("Mirror")
    private boolean mMirror;
    private transient java.lang.String mName;

    @com.google.gson.annotations.SerializedName("NodeKey")
    protected java.lang.String mNodeKey;

    @com.google.gson.annotations.SerializedName("Rotation")
    private float mRotation;

    @com.google.gson.annotations.SerializedName("Source")
    private com.aliyun.svideosdk.common.struct.project.Source mSource;
    private transient java.util.List<com.aliyun.svideosdk.common.struct.project.FrameTime> mTimeArray;

    @com.google.gson.annotations.SerializedName("TimelineIn")
    private float mTimelineIn;

    @com.google.gson.annotations.SerializedName("TimelineOut")
    private float mTimelineOut;

    @com.google.gson.annotations.SerializedName(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_WIDTH)
    private float mWidth;

    @com.google.gson.annotations.SerializedName("X")
    private float mX;

    @com.google.gson.annotations.SerializedName("Y")
    private float mY;

    public PhotoPasterTrack() {
        setType(com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo);
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> getActions() {
        return this.mActions;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> getFrameArray() {
        return this.mFrameArray;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public java.lang.String getNodeKey() {
        return this.mNodeKey;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.FrameTime> getTimeArray() {
        return this.mTimeArray;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
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

    public boolean isMirror() {
        return this.mMirror;
    }

    public void setFrameArray(java.util.List<com.aliyun.svideosdk.common.struct.project.Frame> list) {
        this.mFrameArray = list;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setMirror(boolean z) {
        this.mMirror = z;
    }

    public void setName(java.lang.String str) {
        this.mName = str;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.TemplateNode
    public void setNodeKey(java.lang.String str) {
        this.mNodeKey = str;
    }

    public void setRotation(float f) {
        this.mRotation = f;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }

    public void setTimeArray(java.util.List<com.aliyun.svideosdk.common.struct.project.FrameTime> list) {
        this.mTimeArray = list;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
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

    public java.lang.String toString() {
        return super.toString() + "PhotoPasterTrack{mSource=" + this.mSource + ", mX=" + this.mX + ", mY=" + this.mY + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mRotation=" + this.mRotation + ", mMirror=" + this.mMirror + ", mTimelineIn=" + this.mTimelineIn + ", mTimelineOut=" + this.mTimelineOut + ", mActions=" + this.mActions + ", mFrameArray=" + this.mFrameArray + ", mTimeArray=" + this.mTimeArray + ", mName='" + this.mName + "'}";
    }
}
