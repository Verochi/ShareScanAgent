package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class AliyunClip {
    protected int mClipHeight;
    protected int mClipWidth;
    private java.lang.String mSource;
    private com.aliyun.svideosdk.common.struct.effect.TransitionBase mTransition;
    private int mId = 0;
    private int mRotation = -1;
    private com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode mDisplayMode = com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode.DEFAULT;
    private com.aliyun.svideosdk.common.struct.common.MediaType mediaType = com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE;

    public int getClipHeight() {
        return this.mClipHeight;
    }

    public int getClipWidth() {
        return this.mClipWidth;
    }

    public com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public int getId() {
        return this.mId;
    }

    public com.aliyun.svideosdk.common.struct.common.MediaType getMediaType() {
        return this.mediaType;
    }

    public java.lang.String getSource() {
        return this.mSource;
    }

    public com.aliyun.svideosdk.common.struct.effect.TransitionBase getTransition() {
        return this.mTransition;
    }

    public void setDisplayMode(com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
        this.mDisplayMode = aliyunDisplayMode;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setMediaType(com.aliyun.svideosdk.common.struct.common.MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public void setSource(java.lang.String str) {
        this.mSource = str;
    }

    public void setTransition(com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        this.mTransition = transitionBase;
    }
}
