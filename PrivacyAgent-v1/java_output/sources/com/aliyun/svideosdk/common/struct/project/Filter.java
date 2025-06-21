package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class Filter extends com.aliyun.svideosdk.common.struct.project.EffectTrack {
    private transient com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;

    @com.google.gson.annotations.SerializedName("Intensity")
    private float mIntensity;

    @com.google.gson.annotations.SerializedName("Source")
    private com.aliyun.svideosdk.common.struct.project.Source mSource;

    public Filter(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
        initEffectConfig(source.getPath());
    }

    @java.lang.Deprecated
    public Filter(java.lang.String str) {
        this(new com.aliyun.svideosdk.common.struct.project.Source(str));
    }

    private void initEffectConfig(java.lang.String str) {
        try {
            this.mEffectConfig = (com.aliyun.svideosdk.common.struct.effect.EffectConfig) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(readString(str + "/config.json"), com.aliyun.svideosdk.common.struct.effect.EffectConfig.class);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private java.lang.String readString(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("");
        try {
            java.io.FileReader fileReader = new java.io.FileReader(new java.io.File(str));
            while (true) {
                int read = fileReader.read();
                if (read == -1) {
                    break;
                }
                stringBuffer.append((char) read);
            }
            fileReader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public long getDuration() {
        return (long) ((getTimelineOut() - getTimelineIn()) * 1000.0f);
    }

    public com.aliyun.svideosdk.common.struct.effect.EffectConfig getEffectConfig() {
        com.aliyun.svideosdk.common.struct.project.Source source;
        if (this.mEffectConfig == null && (source = this.mSource) != null) {
            initEffectConfig(source.getPath());
        }
        return this.mEffectConfig;
    }

    public float getIntensity() {
        return this.mIntensity;
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return this.mSource;
    }

    public long getStartTime() {
        return (long) (getTimelineIn() * 1000.0f);
    }

    public void setEffectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
        this.mEffectConfig = effectConfig;
    }

    public void setIntensity(float f) {
        this.mIntensity = f;
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        this.mSource = source;
    }
}
