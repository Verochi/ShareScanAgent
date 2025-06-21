package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class MVFilter extends com.aliyun.svideosdk.common.struct.project.EffectTrack {

    @com.google.gson.annotations.SerializedName("MixWeight")
    private int mMixWeight = 50;

    @com.google.gson.annotations.SerializedName("Mute")
    private boolean mMute = false;

    @com.google.gson.annotations.SerializedName("Source")
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    public MVFilter() {
        setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.mv);
    }

    public int getMixWeight() {
        return this.mMixWeight;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public boolean isMute() {
        return this.mMute;
    }

    public void setMixWeight(int i) {
        this.mMixWeight = i;
    }

    public void setMute(boolean z) {
        this.mMute = z;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }
}
