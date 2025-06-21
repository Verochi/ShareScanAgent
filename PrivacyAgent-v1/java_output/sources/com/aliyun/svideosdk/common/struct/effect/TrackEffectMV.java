package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TrackEffectMV extends com.aliyun.svideosdk.common.struct.effect.EffectBase {
    private int audioStreamId;
    private long duration;
    private long startTime;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.effect.TrackEffectMV effectMv = new com.aliyun.svideosdk.common.struct.effect.TrackEffectMV();

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectMV build() {
            return this.effectMv;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectMV.Builder duration(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.effectMv.duration = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectMV.Builder source(com.aliyun.svideosdk.common.struct.project.Source source) {
            this.effectMv.setSource(source);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectMV.Builder startTime(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.effectMv.startTime = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    public int getAudioStreamId() {
        return this.audioStreamId;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.duration, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public void setAudioStreamId(int i) {
        this.audioStreamId = i;
    }
}
