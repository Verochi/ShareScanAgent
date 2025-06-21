package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AudioTrackClip extends com.aliyun.svideosdk.common.struct.project.TrackClip {

    @com.google.gson.annotations.SerializedName("Effects")
    private java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> mEffects = new java.util.ArrayList();

    @com.google.gson.annotations.SerializedName("In")
    private float mIn;

    @com.google.gson.annotations.SerializedName("Out")
    private float mOut;

    @com.google.gson.annotations.SerializedName("Source")
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    @com.google.gson.annotations.SerializedName("Type")
    private com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type mType;

    public enum Type {
        Music,
        Dubs
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> getEffects() {
        return this.mEffects;
    }

    public float getIn() {
        return this.mIn;
    }

    public float getOut() {
        return this.mOut;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type getType() {
        return this.mType;
    }

    public void setIn(float f) {
        this.mIn = f;
    }

    public void setOut(float f) {
        this.mOut = f;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }

    public void setType(com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type type) {
        this.mType = type;
    }
}
