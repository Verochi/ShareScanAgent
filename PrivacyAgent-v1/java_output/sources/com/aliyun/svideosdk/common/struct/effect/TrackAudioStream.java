package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TrackAudioStream extends com.aliyun.svideosdk.common.struct.effect.EffectBase {
    private int audioWeight = 50;
    protected long duration;
    private long startTime;
    protected long streamDuration;
    protected int streamId;
    protected long streamStartTime;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.effect.TrackAudioStream mEffectStream = new com.aliyun.svideosdk.common.struct.effect.TrackAudioStream();

        public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder audioWeight(int i) {
            this.mEffectStream.audioWeight = java.lang.Math.min(100, java.lang.Math.max(i, 0));
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        
            if (r1 != null) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream build() {
            java.lang.Throwable th;
            com.aliyun.svideosdk.transcode.NativeParser nativeParser;
            android.media.MediaMetadataRetriever mediaMetadataRetriever;
            java.lang.Exception e;
            com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream;
            if (this.mEffectStream.streamStartTime >= 0) {
                android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
                try {
                    nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                } catch (java.lang.Exception e2) {
                    mediaMetadataRetriever = null;
                    e = e2;
                    nativeParser = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    nativeParser = null;
                }
                try {
                    nativeParser.init(this.mEffectStream.getSource().getPath());
                    mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(this.mEffectStream.getSource().getPath());
                            java.lang.String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                            if (!android.text.TextUtils.isEmpty(extractMetadata)) {
                                long parseLong = java.lang.Long.parseLong(extractMetadata);
                                java.lang.String value = nativeParser.getValue(18);
                                if (android.text.TextUtils.isEmpty(value)) {
                                    trackAudioStream = this.mEffectStream;
                                } else {
                                    long parseLong2 = java.lang.Long.parseLong(value) / 1000;
                                    trackAudioStream = this.mEffectStream;
                                    trackAudioStream.streamStartTime = (trackAudioStream.streamStartTime * parseLong2) / parseLong;
                                    parseLong = java.lang.Math.min(parseLong2, parseLong);
                                }
                                trackAudioStream.duration = parseLong;
                            }
                            mediaMetadataRetriever.release();
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                        }
                    } catch (java.lang.Throwable th3) {
                        android.media.MediaMetadataRetriever mediaMetadataRetriever3 = mediaMetadataRetriever;
                        th = th3;
                        mediaMetadataRetriever2 = mediaMetadataRetriever3;
                        if (mediaMetadataRetriever2 != null) {
                            mediaMetadataRetriever2.release();
                        }
                        if (nativeParser != null) {
                            nativeParser.release();
                            nativeParser.dispose();
                        }
                        throw th;
                    }
                } catch (java.lang.Exception e4) {
                    mediaMetadataRetriever = null;
                    e = e4;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    if (mediaMetadataRetriever2 != null) {
                    }
                    if (nativeParser != null) {
                    }
                    throw th;
                }
                nativeParser.release();
                nativeParser.dispose();
            }
            com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream2 = this.mEffectStream;
            long j = trackAudioStream2.streamStartTime;
            long j2 = trackAudioStream2.streamDuration + j;
            long j3 = trackAudioStream2.duration;
            if (j2 > j3) {
                trackAudioStream2.streamDuration = j3 - j;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("EffectStream streamDuration exceed the stream duration, the streamDuration adjust to ");
                sb.append(this.mEffectStream.streamDuration);
            }
            return this.mEffectStream;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder source(com.aliyun.svideosdk.common.struct.project.Source source) {
            this.mEffectStream.setSource(source);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder startTime(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mEffectStream.startTime = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder streamDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mEffectStream.streamDuration = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder streamId(int i) {
            this.mEffectStream.streamId = i;
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackAudioStream.Builder streamStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.mEffectStream.streamStartTime = java.lang.Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public boolean checkIsInvalid() {
        com.aliyun.svideosdk.common.struct.project.Source source = getSource();
        if (getSource() == null) {
            return true;
        }
        java.lang.String path = source.getPath();
        if (!com.aliyun.common.utils.StringUtils.isEmpty(path) && new java.io.File(path).exists() && getStreamDuration() >= 0) {
            return super.checkIsInvalid();
        }
        return true;
    }

    public int getAudioWeight() {
        return this.audioWeight;
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

    public int getStreamId() {
        return this.streamId;
    }

    public long getStreamStartTime() {
        return this.streamStartTime;
    }

    public long getStreamStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.streamStartTime, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public void setStreamDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j < 0) {
            j = 0;
        }
        this.streamDuration = timeUnit.toMillis(j);
    }

    public void setStreamId(int i) {
        this.streamId = i;
    }

    public void setStreamStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j < 0) {
            j = 0;
        }
        this.streamStartTime = timeUnit.toMillis(j);
    }
}
