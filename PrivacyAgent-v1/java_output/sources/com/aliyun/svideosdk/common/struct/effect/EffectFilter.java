package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectFilter extends com.aliyun.svideosdk.common.struct.effect.EffectBase {
    private long mDuration;
    private com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;
    private long mStartTime;
    private java.lang.String name;

    @com.aliyun.Visible
    public static final class Builder {
        private long mDuration;
        private com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;
        private long mStartTime;
        private com.aliyun.svideosdk.common.struct.project.Source source;

        public com.aliyun.svideosdk.common.struct.effect.EffectFilter build() {
            return new com.aliyun.svideosdk.common.struct.effect.EffectFilter(this, null);
        }

        @java.lang.Deprecated
        public com.aliyun.svideosdk.common.struct.effect.EffectFilter.Builder duration(long j) {
            this.mDuration = j;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.EffectFilter.Builder effectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
            this.mEffectConfig = effectConfig;
            return this;
        }

        @java.lang.Deprecated
        public com.aliyun.svideosdk.common.struct.effect.EffectFilter.Builder path(java.lang.String str) {
            this.source = new com.aliyun.svideosdk.common.struct.project.Source(str);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.EffectFilter.Builder source(com.aliyun.svideosdk.common.struct.project.Source source) {
            this.source = source;
            return this;
        }

        @java.lang.Deprecated
        public com.aliyun.svideosdk.common.struct.effect.EffectFilter.Builder startTime(long j) {
            this.mStartTime = j;
            return this;
        }
    }

    private EffectFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter.Builder builder) {
        setSource(builder.source);
        setStartTime(builder.mStartTime);
        setDuration(builder.mDuration);
        try {
            this.mEffectConfig = (com.aliyun.svideosdk.common.struct.effect.EffectConfig) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(new java.io.File(builder.source.getPath(), "config.json"), com.aliyun.svideosdk.common.struct.effect.EffectConfig.class);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (builder.mEffectConfig != null) {
            setEffectConfig(builder.mEffectConfig);
        }
    }

    public /* synthetic */ EffectFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter.Builder builder, com.aliyun.svideosdk.common.struct.effect.EffectFilter.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public EffectFilter(com.aliyun.svideosdk.common.struct.project.Source source) {
        if (source == null || com.aliyun.common.utils.StringUtils.isEmpty(source.getPath())) {
            return;
        }
        setSource(source);
        java.lang.String readString = readString(source.getPath() + "/config.json");
        try {
            this.name = new org.json.JSONObject(readString).optString("name");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        try {
            this.mEffectConfig = (com.aliyun.svideosdk.common.struct.effect.EffectConfig) new com.aliyun.common.jasonparse.JSONSupportImpl().readValue(readString, com.aliyun.svideosdk.common.struct.effect.EffectConfig.class);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    @java.lang.Deprecated
    public EffectFilter(java.lang.String str) {
        this(new com.aliyun.svideosdk.common.struct.project.Source(str));
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public void copy(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectFilter) {
            com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter = (com.aliyun.svideosdk.common.struct.effect.EffectFilter) effectBase;
            try {
                com.aliyun.common.jasonparse.JSONSupportImpl jSONSupportImpl = new com.aliyun.common.jasonparse.JSONSupportImpl();
                this.mEffectConfig.getParamsJsonString();
                effectFilter.setEffectConfig((com.aliyun.svideosdk.common.struct.effect.EffectConfig) jSONSupportImpl.readValue(jSONSupportImpl.writeValue(this.mEffectConfig), com.aliyun.svideosdk.common.struct.effect.EffectConfig.class));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter = (com.aliyun.svideosdk.common.struct.effect.EffectFilter) obj;
        if (this.mStartTime != effectFilter.mStartTime || this.mDuration != effectFilter.mDuration) {
            return false;
        }
        java.lang.String str = this.name;
        java.lang.String str2 = effectFilter.name;
        return str != null ? str.equals(str2) : str2 == null;
    }

    @java.lang.Deprecated
    public long getDuration() {
        return this.mDuration;
    }

    public com.aliyun.svideosdk.common.struct.effect.EffectConfig getEffectConfig() {
        return this.mEffectConfig;
    }

    @java.lang.Deprecated
    public java.lang.String getName() {
        return this.name;
    }

    public java.util.List<com.aliyun.svideosdk.common.struct.effect.EffectConfig.NodeBean> getNodeTree() {
        com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getNodeTree();
    }

    @java.lang.Deprecated
    public long getStartTime() {
        return this.mStartTime;
    }

    public int hashCode() {
        java.lang.String str = this.name;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.mStartTime;
        int i = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.mDuration;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    @java.lang.Deprecated
    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEffectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
        this.mEffectConfig = effectConfig;
    }

    @java.lang.Deprecated
    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public java.lang.String toJsonString() {
        com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig = this.mEffectConfig;
        if (effectConfig == null) {
            return null;
        }
        return effectConfig.getParamsJsonString();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public java.lang.String toString() {
        return "EffectFilter{name='" + this.name + "', mStartTime=" + this.mStartTime + ", mDuration=" + this.mDuration + '}';
    }

    public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter toTrackEffectFilter() {
        com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder source = new com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder().source(this.mSource);
        long startTime = getStartTime();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter build = source.startTime(startTime, timeUnit).duration(getDuration(), timeUnit).resId(getResId()).build();
        build.setViewId(getViewId());
        return build;
    }
}
