package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectStream extends com.aliyun.svideosdk.common.struct.effect.EffectBase {
    protected long duration;
    protected long streamDuration;
    protected long streamStartTime;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.effect.EffectStream mEffectStream = new com.aliyun.svideosdk.common.struct.effect.EffectStream();

        public com.aliyun.svideosdk.common.struct.effect.EffectStream build() {
            com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
            nativeParser.init(this.mEffectStream.getSource().getPath());
            nativeParser.getValue(16);
            if (this.mEffectStream.streamStartTime >= 0) {
                android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(this.mEffectStream.getSource().getPath());
                        java.lang.String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (!android.text.TextUtils.isEmpty(extractMetadata)) {
                            long parseLong = java.lang.Long.parseLong(extractMetadata);
                            java.lang.String value = nativeParser.getValue(18);
                            if (android.text.TextUtils.isEmpty(value)) {
                                this.mEffectStream.duration = parseLong;
                            } else {
                                long parseLong2 = java.lang.Long.parseLong(value) / 1000;
                                com.aliyun.svideosdk.common.struct.effect.EffectStream effectStream = this.mEffectStream;
                                effectStream.streamStartTime = (effectStream.streamStartTime * parseLong2) / parseLong;
                                effectStream.duration = java.lang.Math.min(parseLong2, parseLong);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                } finally {
                    mediaMetadataRetriever.release();
                }
            }
            nativeParser.release();
            nativeParser.dispose();
            com.aliyun.svideosdk.common.struct.effect.EffectStream effectStream2 = this.mEffectStream;
            long j = effectStream2.streamStartTime;
            long j2 = effectStream2.streamDuration + j;
            long j3 = effectStream2.duration;
            if (j2 > j3) {
                effectStream2.streamDuration = j3 - j;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("EffectStream streamDuration exceed the stream duration, the streamDuration adjust to ");
                sb.append(this.mEffectStream.streamDuration);
            }
            return this.mEffectStream;
        }

        public com.aliyun.svideosdk.common.struct.effect.EffectStream.Builder source(com.aliyun.svideosdk.common.struct.project.Source source) {
            this.mEffectStream.setSource(source);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.EffectStream.Builder streamDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mEffectStream.streamDuration = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.EffectStream.Builder streamStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mEffectStream.streamStartTime = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.duration, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public long getStreamDuration() {
        return this.streamDuration;
    }

    public long getStreamDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.streamDuration, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public long getStreamEndTime() {
        return this.streamStartTime + this.streamDuration;
    }

    public long getStreamEndTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getStreamEndTime(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public long getStreamStartTime() {
        return this.streamStartTime;
    }

    public long getStreamStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.streamStartTime, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public void setStreamDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.streamDuration = java.lang.Math.max(timeUnit.toMillis(j), 0L);
    }

    public void setStreamStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.streamStartTime = java.lang.Math.max(timeUnit.toMillis(j), 0L);
    }
}
