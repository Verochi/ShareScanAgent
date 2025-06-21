package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TrackEffectFilter extends com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectFilter> {

    public static class Builder {
        private long mDuration;
        private com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;
        private int mResId = 0;
        private com.aliyun.svideosdk.common.struct.project.Source mSource;
        private long mStartTime;

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter build() {
            com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter = new com.aliyun.svideosdk.common.struct.effect.EffectFilter(this.mSource);
            effectFilter.setEffectConfig(this.mEffectConfig);
            int i = this.mResId;
            if (i != 0) {
                effectFilter.setResId(i);
            }
            return new com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter(this.mStartTime, this.mDuration, effectFilter, null);
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder duration(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mDuration = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder effectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
            this.mEffectConfig = effectConfig;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder resId(int i) {
            this.mResId = i;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder source(com.aliyun.svideosdk.common.struct.project.Source source) {
            this.mSource = source;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder startTime(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mStartTime = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    private TrackEffectFilter(long j, long j2, com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        super(j, j2, effectFilter);
        effectFilter.setStartTime(j);
        effectFilter.setDuration(j2);
    }

    public /* synthetic */ TrackEffectFilter(long j, long j2, com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter, com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.AnonymousClass1 anonymousClass1) {
        this(j, j2, effectFilter);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.TrackEffect
    public void setDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        super.setDuration(j, timeUnit);
        ((com.aliyun.svideosdk.common.struct.effect.EffectFilter) this.bean).setDuration(this.duration);
    }

    public void setEffectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectFilter) this.bean).setEffectConfig(effectConfig);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.TrackEffect
    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        super.setStartTime(j, timeUnit);
        ((com.aliyun.svideosdk.common.struct.effect.EffectFilter) this.bean).setStartTime(this.startTime);
    }
}
