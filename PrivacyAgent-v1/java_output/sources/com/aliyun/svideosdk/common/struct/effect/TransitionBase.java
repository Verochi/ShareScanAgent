package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TransitionBase extends com.aliyun.svideosdk.common.struct.project.Effect {
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 2;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int TRANSITION_TYPE_CIRCLE = 2;
    public static final int TRANSITION_TYPE_CUSTOM = 5;
    public static final int TRANSITION_TYPE_FADE = 4;
    public static final int TRANSITION_TYPE_FIVEPOINTSTAR = 3;
    public static final int TRANSITION_TYPE_SHUTTER = 0;
    public static final int TRANSITION_TYPE_TRANSLATE = 1;

    @com.google.gson.annotations.SerializedName("CustomSource")
    protected com.aliyun.svideosdk.common.struct.project.Source mCustomSource;
    private transient com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;

    @com.google.gson.annotations.SerializedName("OverlapDuration")
    private float mOverlapDurationSec;

    @com.google.gson.annotations.SerializedName("ParamString")
    protected java.lang.String mParamsString;

    @com.google.gson.annotations.SerializedName("TransitionType")
    public int mType;

    public TransitionBase() {
        super(com.aliyun.svideosdk.common.struct.project.Effect.Type.transition);
        this.mType = 5;
    }

    public TransitionBase(com.aliyun.svideosdk.common.struct.project.Source source) {
        super(com.aliyun.svideosdk.common.struct.project.Effect.Type.transition);
        this.mType = 5;
        if (source == null || com.aliyun.common.utils.StringUtils.isEmpty(source.getPath())) {
            return;
        }
        this.mType = 5;
        this.mCustomSource = source;
        initCustom();
    }

    @java.lang.Deprecated
    public TransitionBase(java.lang.String str) {
        this(new com.aliyun.svideosdk.common.struct.project.Source(str));
    }

    private void initCustom() {
        try {
            this.mEffectConfig = (com.aliyun.svideosdk.common.struct.effect.EffectConfig) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(new java.io.File(this.mCustomSource.getPath(), "config.json"), com.aliyun.svideosdk.common.struct.effect.EffectConfig.class);
            if (com.aliyun.common.utils.StringUtils.isEmpty(this.mParamsString)) {
                this.mParamsString = toJsonString();
            } else {
                this.mEffectConfig.readParamsJson(this.mParamsString);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public com.aliyun.svideosdk.common.struct.project.Source getCustomSource() {
        return this.mCustomSource;
    }

    public com.aliyun.svideosdk.common.struct.effect.EffectConfig getEffectConfig() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.mCustomSource;
        if (source != null && !com.aliyun.common.utils.StringUtils.isEmpty(source.getPath()) && this.mEffectConfig == null) {
            initCustom();
        }
        return this.mEffectConfig;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> getNodeTree() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.mCustomSource;
        if (source != null && !com.aliyun.common.utils.StringUtils.isEmpty(source.getPath()) && this.mEffectConfig == null) {
            initCustom();
        }
        com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getNodeTree();
    }

    public long getOverlapDuration() {
        return (long) (this.mOverlapDurationSec * 1000000.0f);
    }

    public long getOverlapDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getOverlapDuration(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setCustomSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        if (source == null || com.aliyun.common.utils.StringUtils.isEmpty(source.getPath())) {
            return;
        }
        this.mType = 5;
        this.mCustomSource = source;
        initCustom();
    }

    public void setEffectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
        if (effectConfig != null) {
            this.mParamsString = effectConfig.getParamsJsonString();
        }
        this.mEffectConfig = effectConfig;
    }

    public void setOverlapDuration(long j) {
        setOverlapDuration(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    public void setOverlapDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.mOverlapDurationSec = timeUnit.toMillis(j) / 1000.0f;
    }

    public void setParamsString(java.lang.String str) {
        this.mParamsString = str;
    }

    public java.lang.String toJsonString() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.mCustomSource;
        if (source != null && !com.aliyun.common.utils.StringUtils.isEmpty(source.getPath()) && this.mEffectConfig == null) {
            initCustom();
        }
        com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getParamsJsonString();
    }
}
