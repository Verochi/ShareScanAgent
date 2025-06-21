package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public interface ExoPlayer extends com.google.android.exoplayer2.Player {

    public static final class Builder {
        public final com.google.android.exoplayer2.Renderer[] a;
        public com.google.android.exoplayer2.util.Clock b;
        public com.google.android.exoplayer2.trackselection.TrackSelector c;
        public com.google.android.exoplayer2.source.MediaSourceFactory d;
        public com.google.android.exoplayer2.LoadControl e;
        public com.google.android.exoplayer2.upstream.BandwidthMeter f;
        public android.os.Looper g;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.analytics.AnalyticsCollector h;
        public boolean i;
        public com.google.android.exoplayer2.SeekParameters j;
        public boolean k;
        public boolean l;
        public long m;
        public boolean n;

        public Builder(android.content.Context context, com.google.android.exoplayer2.Renderer... rendererArr) {
            this(rendererArr, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector(context), new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(context), new com.google.android.exoplayer2.DefaultLoadControl(), com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.getSingletonInstance(context));
        }

        public Builder(com.google.android.exoplayer2.Renderer[] rendererArr, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(rendererArr.length > 0);
            this.a = rendererArr;
            this.c = trackSelector;
            this.d = mediaSourceFactory;
            this.e = loadControl;
            this.f = bandwidthMeter;
            this.g = com.google.android.exoplayer2.util.Util.getCurrentOrMainLooper();
            this.i = true;
            this.j = com.google.android.exoplayer2.SeekParameters.DEFAULT;
            this.b = com.google.android.exoplayer2.util.Clock.DEFAULT;
            this.n = true;
        }

        public com.google.android.exoplayer2.ExoPlayer build() {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.l = true;
            com.google.android.exoplayer2.ExoPlayerImpl exoPlayerImpl = new com.google.android.exoplayer2.ExoPlayerImpl(this.a, this.c, this.d, this.e, this.f, this.h, this.i, this.j, this.k, this.b, this.g);
            long j = this.m;
            if (j > 0) {
                exoPlayerImpl.o(j);
            }
            if (!this.n) {
                exoPlayerImpl.n();
            }
            return exoPlayerImpl;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder experimentalSetReleaseTimeoutMs(long j) {
            this.m = j;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder experimentalSetThrowWhenStuckBuffering(boolean z) {
            this.n = z;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setAnalyticsCollector(com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.h = analyticsCollector;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setBandwidthMeter(com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.f = bandwidthMeter;
            return this;
        }

        @androidx.annotation.VisibleForTesting
        public com.google.android.exoplayer2.ExoPlayer.Builder setClock(com.google.android.exoplayer2.util.Clock clock) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.b = clock;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setLoadControl(com.google.android.exoplayer2.LoadControl loadControl) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.e = loadControl;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setLooper(android.os.Looper looper) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.g = looper;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setMediaSourceFactory(com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.d = mediaSourceFactory;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setPauseAtEndOfMediaItems(boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.k = z;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.j = seekParameters;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setTrackSelector(com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.c = trackSelector;
            return this;
        }

        public com.google.android.exoplayer2.ExoPlayer.Builder setUseLazyPreparation(boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.l);
            this.i = z;
            return this;
        }
    }

    void addMediaSource(int i, com.google.android.exoplayer2.source.MediaSource mediaSource);

    void addMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource);

    void addMediaSources(int i, java.util.List<com.google.android.exoplayer2.source.MediaSource> list);

    void addMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list);

    com.google.android.exoplayer2.PlayerMessage createMessage(com.google.android.exoplayer2.PlayerMessage.Target target);

    void experimentalSetOffloadSchedulingEnabled(boolean z);

    boolean getPauseAtEndOfMediaItems();

    android.os.Looper getPlaybackLooper();

    com.google.android.exoplayer2.SeekParameters getSeekParameters();

    @java.lang.Deprecated
    void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource);

    @java.lang.Deprecated
    void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z, boolean z2);

    @java.lang.Deprecated
    void retry();

    void setForegroundMode(boolean z);

    void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource);

    void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j);

    void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z);

    void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list);

    void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, int i, long j);

    void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, boolean z);

    void setPauseAtEndOfMediaItems(boolean z);

    void setSeekParameters(@androidx.annotation.Nullable com.google.android.exoplayer2.SeekParameters seekParameters);

    void setShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder);
}
