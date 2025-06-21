package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public class SimpleExoPlayer extends com.google.android.exoplayer2.BasePlayer implements com.google.android.exoplayer2.ExoPlayer, com.google.android.exoplayer2.Player.AudioComponent, com.google.android.exoplayer2.Player.VideoComponent, com.google.android.exoplayer2.Player.TextComponent, com.google.android.exoplayer2.Player.MetadataComponent, com.google.android.exoplayer2.Player.DeviceComponent {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.decoder.DecoderCounters A;
    public int B;
    public com.google.android.exoplayer2.audio.AudioAttributes C;
    public float D;
    public boolean E;
    public java.util.List<com.google.android.exoplayer2.text.Cue> F;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.VideoFrameMetadataListener G;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.spherical.CameraMotionListener H;
    public boolean I;
    public boolean J;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.PriorityTaskManager K;
    public boolean L;
    public boolean M;
    public com.google.android.exoplayer2.device.DeviceInfo N;
    public final com.google.android.exoplayer2.ExoPlayerImpl a;
    public final com.google.android.exoplayer2.SimpleExoPlayer.ComponentListener b;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoListener> c;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.audio.AudioListener> d;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.text.TextOutput> e;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.MetadataOutput> f;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.device.DeviceListener> g;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoRendererEventListener> h;
    public final java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.audio.AudioRendererEventListener> i;
    public final com.google.android.exoplayer2.analytics.AnalyticsCollector j;
    public final com.google.android.exoplayer2.AudioBecomingNoisyManager k;
    public final com.google.android.exoplayer2.AudioFocusManager l;
    public final com.google.android.exoplayer2.StreamVolumeManager m;
    public final com.google.android.exoplayer2.WakeLockManager n;
    public final com.google.android.exoplayer2.WifiLockManager o;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format p;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format q;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer r;
    protected final com.google.android.exoplayer2.Renderer[] renderers;

    /* renamed from: s, reason: collision with root package name */
    @androidx.annotation.Nullable
    public android.view.Surface f339s;
    public boolean t;
    public int u;

    @androidx.annotation.Nullable
    public android.view.SurfaceHolder v;

    @androidx.annotation.Nullable
    public android.view.TextureView w;
    public int x;
    public int y;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.decoder.DecoderCounters z;

    public static final class Builder {
        public final android.content.Context a;
        public final com.google.android.exoplayer2.RenderersFactory b;
        public com.google.android.exoplayer2.util.Clock c;
        public com.google.android.exoplayer2.trackselection.TrackSelector d;
        public com.google.android.exoplayer2.source.MediaSourceFactory e;
        public com.google.android.exoplayer2.LoadControl f;
        public com.google.android.exoplayer2.upstream.BandwidthMeter g;
        public com.google.android.exoplayer2.analytics.AnalyticsCollector h;
        public android.os.Looper i;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.util.PriorityTaskManager j;
        public com.google.android.exoplayer2.audio.AudioAttributes k;
        public boolean l;
        public int m;
        public boolean n;
        public boolean o;
        public int p;
        public boolean q;
        public com.google.android.exoplayer2.SeekParameters r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f340s;
        public boolean t;
        public boolean u;

        public Builder(android.content.Context context) {
            this(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context), new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory());
        }

        public Builder(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory) {
            this(context, renderersFactory, new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory());
        }

        public Builder(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
            this(context, renderersFactory, new com.google.android.exoplayer2.trackselection.DefaultTrackSelector(context), new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(context, extractorsFactory), new com.google.android.exoplayer2.DefaultLoadControl(), com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.getSingletonInstance(context), new com.google.android.exoplayer2.analytics.AnalyticsCollector(com.google.android.exoplayer2.util.Clock.DEFAULT));
        }

        public Builder(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector) {
            this.a = context;
            this.b = renderersFactory;
            this.d = trackSelector;
            this.e = mediaSourceFactory;
            this.f = loadControl;
            this.g = bandwidthMeter;
            this.h = analyticsCollector;
            this.i = com.google.android.exoplayer2.util.Util.getCurrentOrMainLooper();
            this.k = com.google.android.exoplayer2.audio.AudioAttributes.DEFAULT;
            this.m = 0;
            this.p = 1;
            this.q = true;
            this.r = com.google.android.exoplayer2.SeekParameters.DEFAULT;
            this.c = com.google.android.exoplayer2.util.Clock.DEFAULT;
            this.t = true;
        }

        public Builder(android.content.Context context, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory) {
            this(context, new com.google.android.exoplayer2.DefaultRenderersFactory(context), extractorsFactory);
        }

        public com.google.android.exoplayer2.SimpleExoPlayer build() {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.u = true;
            return new com.google.android.exoplayer2.SimpleExoPlayer(this);
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder experimentalSetThrowWhenStuckBuffering(boolean z) {
            this.t = z;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setAnalyticsCollector(com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.h = analyticsCollector;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.k = audioAttributes;
            this.l = z;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setBandwidthMeter(com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.g = bandwidthMeter;
            return this;
        }

        @androidx.annotation.VisibleForTesting
        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setClock(com.google.android.exoplayer2.util.Clock clock) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.c = clock;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setHandleAudioBecomingNoisy(boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.n = z;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setLoadControl(com.google.android.exoplayer2.LoadControl loadControl) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.f = loadControl;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setLooper(android.os.Looper looper) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.i = looper;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setMediaSourceFactory(com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.e = mediaSourceFactory;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setPauseAtEndOfMediaItems(boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.f340s = z;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setPriorityTaskManager(@androidx.annotation.Nullable com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.j = priorityTaskManager;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setSeekParameters(com.google.android.exoplayer2.SeekParameters seekParameters) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.r = seekParameters;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setSkipSilenceEnabled(boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.o = z;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setTrackSelector(com.google.android.exoplayer2.trackselection.TrackSelector trackSelector) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.d = trackSelector;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setUseLazyPreparation(boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.q = z;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setVideoScalingMode(int i) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.p = i;
            return this;
        }

        public com.google.android.exoplayer2.SimpleExoPlayer.Builder setWakeMode(int i) {
            com.google.android.exoplayer2.util.Assertions.checkState(!this.u);
            this.m = i;
            return this;
        }
    }

    public final class ComponentListener implements com.google.android.exoplayer2.video.VideoRendererEventListener, com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.text.TextOutput, com.google.android.exoplayer2.metadata.MetadataOutput, android.view.SurfaceHolder.Callback, android.view.TextureView.SurfaceTextureListener, com.google.android.exoplayer2.AudioFocusManager.PlayerControl, com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener, com.google.android.exoplayer2.StreamVolumeManager.Listener, com.google.android.exoplayer2.Player.EventListener {
        public ComponentListener() {
        }

        public /* synthetic */ ComponentListener(com.google.android.exoplayer2.SimpleExoPlayer simpleExoPlayer, com.google.android.exoplayer2.SimpleExoPlayer.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void executePlayerCommand(int i) {
            boolean playWhenReady = com.google.android.exoplayer2.SimpleExoPlayer.this.getPlayWhenReady();
            com.google.android.exoplayer2.SimpleExoPlayer.this.Q(playWhenReady, i, com.google.android.exoplayer2.SimpleExoPlayer.H(playWhenReady, i));
        }

        @Override // com.google.android.exoplayer2.AudioBecomingNoisyManager.EventListener
        public void onAudioBecomingNoisy() {
            com.google.android.exoplayer2.SimpleExoPlayer.this.Q(false, -1, 3);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(java.lang.String str, long j, long j2) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioDisabled(decoderCounters);
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.q = null;
            com.google.android.exoplayer2.SimpleExoPlayer.this.A = null;
            com.google.android.exoplayer2.SimpleExoPlayer.this.B = 0;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.A = decoderCounters;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(com.google.android.exoplayer2.Format format) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.q = format;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioPositionAdvancing(long j) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioPositionAdvancing(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i) {
            if (com.google.android.exoplayer2.SimpleExoPlayer.this.B == i) {
                return;
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.B = i;
            com.google.android.exoplayer2.SimpleExoPlayer.this.J();
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioUnderrun(int i, long j, long j2) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.i.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.audio.AudioRendererEventListener) it.next()).onAudioUnderrun(i, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.F = list;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.e.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.text.TextOutput) it.next()).onCues(list);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onDroppedFrames(i, j);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            defpackage.h32.a(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsLoadingChanged(boolean z) {
            if (com.google.android.exoplayer2.SimpleExoPlayer.this.K != null) {
                if (z && !com.google.android.exoplayer2.SimpleExoPlayer.this.L) {
                    com.google.android.exoplayer2.SimpleExoPlayer.this.K.add(0);
                    com.google.android.exoplayer2.SimpleExoPlayer.this.L = true;
                } else {
                    if (z || !com.google.android.exoplayer2.SimpleExoPlayer.this.L) {
                        return;
                    }
                    com.google.android.exoplayer2.SimpleExoPlayer.this.K.remove(0);
                    com.google.android.exoplayer2.SimpleExoPlayer.this.L = false;
                }
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            defpackage.h32.c(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            defpackage.h32.d(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.MediaItem mediaItem, int i) {
            defpackage.h32.e(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.f.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.metadata.MetadataOutput) it.next()).onMetadata(metadata);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.R();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            defpackage.h32.g(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.R();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            defpackage.h32.i(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
            defpackage.h32.j(this, exoPlaybackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            defpackage.h32.k(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            defpackage.h32.l(this, i);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(android.view.Surface surface) {
            if (com.google.android.exoplayer2.SimpleExoPlayer.this.f339s == surface) {
                java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.c.iterator();
                while (it.hasNext()) {
                    ((com.google.android.exoplayer2.video.VideoListener) it.next()).onRenderedFirstFrame();
                }
            }
            java.util.Iterator it2 = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it2.next()).onRenderedFirstFrame(surface);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            defpackage.h32.m(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            defpackage.h32.n(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            defpackage.h32.o(this, z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onSkipSilenceEnabledChanged(boolean z) {
            if (com.google.android.exoplayer2.SimpleExoPlayer.this.E == z) {
                return;
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.E = z;
            com.google.android.exoplayer2.SimpleExoPlayer.this.K();
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamTypeChanged(int i) {
            com.google.android.exoplayer2.device.DeviceInfo G = com.google.android.exoplayer2.SimpleExoPlayer.G(com.google.android.exoplayer2.SimpleExoPlayer.this.m);
            if (G.equals(com.google.android.exoplayer2.SimpleExoPlayer.this.N)) {
                return;
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.N = G;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.g.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.device.DeviceListener) it.next()).onDeviceInfoChanged(G);
            }
        }

        @Override // com.google.android.exoplayer2.StreamVolumeManager.Listener
        public void onStreamVolumeChanged(int i, boolean z) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.g.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.device.DeviceListener) it.next()).onDeviceVolumeChanged(i, z);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.P(new android.view.Surface(surfaceTexture), true);
            com.google.android.exoplayer2.SimpleExoPlayer.this.I(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.P(null, true);
            com.google.android.exoplayer2.SimpleExoPlayer.this.I(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.I(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
            defpackage.h32.p(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i) {
            defpackage.h32.q(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
            defpackage.h32.r(this, trackGroupArray, trackSelectionArray);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(java.lang.String str, long j, long j2) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoDecoderInitialized(str, j, j2);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoDisabled(decoderCounters);
            }
            com.google.android.exoplayer2.SimpleExoPlayer.this.p = null;
            com.google.android.exoplayer2.SimpleExoPlayer.this.z = null;
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.z = decoderCounters;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoEnabled(decoderCounters);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoFrameProcessingOffset(long j, int i) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoFrameProcessingOffset(j, i);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(com.google.android.exoplayer2.Format format) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.p = format;
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it.next()).onVideoInputFormatChanged(format);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            java.util.Iterator it = com.google.android.exoplayer2.SimpleExoPlayer.this.c.iterator();
            while (it.hasNext()) {
                com.google.android.exoplayer2.video.VideoListener videoListener = (com.google.android.exoplayer2.video.VideoListener) it.next();
                if (!com.google.android.exoplayer2.SimpleExoPlayer.this.h.contains(videoListener)) {
                    videoListener.onVideoSizeChanged(i, i2, i3, f);
                }
            }
            java.util.Iterator it2 = com.google.android.exoplayer2.SimpleExoPlayer.this.h.iterator();
            while (it2.hasNext()) {
                ((com.google.android.exoplayer2.video.VideoRendererEventListener) it2.next()).onVideoSizeChanged(i, i2, i3, f);
            }
        }

        @Override // com.google.android.exoplayer2.AudioFocusManager.PlayerControl
        public void setVolumeMultiplier(float f) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.N();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.I(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.P(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.google.android.exoplayer2.SimpleExoPlayer.this.P(null, false);
            com.google.android.exoplayer2.SimpleExoPlayer.this.I(0, 0);
        }
    }

    @java.lang.Deprecated
    public interface VideoListener extends com.google.android.exoplayer2.video.VideoListener {
    }

    @java.lang.Deprecated
    public SimpleExoPlayer(android.content.Context context, com.google.android.exoplayer2.RenderersFactory renderersFactory, com.google.android.exoplayer2.trackselection.TrackSelector trackSelector, com.google.android.exoplayer2.source.MediaSourceFactory mediaSourceFactory, com.google.android.exoplayer2.LoadControl loadControl, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector, boolean z, com.google.android.exoplayer2.util.Clock clock, android.os.Looper looper) {
        this(new com.google.android.exoplayer2.SimpleExoPlayer.Builder(context, renderersFactory).setTrackSelector(trackSelector).setMediaSourceFactory(mediaSourceFactory).setLoadControl(loadControl).setBandwidthMeter(bandwidthMeter).setAnalyticsCollector(analyticsCollector).setUseLazyPreparation(z).setClock(clock).setLooper(looper));
    }

    public SimpleExoPlayer(com.google.android.exoplayer2.SimpleExoPlayer.Builder builder) {
        com.google.android.exoplayer2.analytics.AnalyticsCollector analyticsCollector = builder.h;
        this.j = analyticsCollector;
        this.K = builder.j;
        this.C = builder.k;
        this.u = builder.p;
        this.E = builder.o;
        com.google.android.exoplayer2.SimpleExoPlayer.ComponentListener componentListener = new com.google.android.exoplayer2.SimpleExoPlayer.ComponentListener(this, null);
        this.b = componentListener;
        java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoListener> copyOnWriteArraySet = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.c = copyOnWriteArraySet;
        java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.audio.AudioListener> copyOnWriteArraySet2 = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.d = copyOnWriteArraySet2;
        this.e = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.f = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.g = new java.util.concurrent.CopyOnWriteArraySet<>();
        java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.video.VideoRendererEventListener> copyOnWriteArraySet3 = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.h = copyOnWriteArraySet3;
        java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.audio.AudioRendererEventListener> copyOnWriteArraySet4 = new java.util.concurrent.CopyOnWriteArraySet<>();
        this.i = copyOnWriteArraySet4;
        android.os.Handler handler = new android.os.Handler(builder.i);
        com.google.android.exoplayer2.Renderer[] createRenderers = builder.b.createRenderers(handler, componentListener, componentListener, componentListener, componentListener);
        this.renderers = createRenderers;
        this.D = 1.0f;
        this.B = 0;
        this.F = java.util.Collections.emptyList();
        com.google.android.exoplayer2.ExoPlayerImpl exoPlayerImpl = new com.google.android.exoplayer2.ExoPlayerImpl(createRenderers, builder.d, builder.e, builder.f, builder.g, analyticsCollector, builder.q, builder.r, builder.f340s, builder.c, builder.i);
        this.a = exoPlayerImpl;
        exoPlayerImpl.addListener(componentListener);
        copyOnWriteArraySet3.add(analyticsCollector);
        copyOnWriteArraySet.add(analyticsCollector);
        copyOnWriteArraySet4.add(analyticsCollector);
        copyOnWriteArraySet2.add(analyticsCollector);
        addMetadataOutput(analyticsCollector);
        com.google.android.exoplayer2.AudioBecomingNoisyManager audioBecomingNoisyManager = new com.google.android.exoplayer2.AudioBecomingNoisyManager(builder.a, handler, componentListener);
        this.k = audioBecomingNoisyManager;
        audioBecomingNoisyManager.b(builder.n);
        com.google.android.exoplayer2.AudioFocusManager audioFocusManager = new com.google.android.exoplayer2.AudioFocusManager(builder.a, handler, componentListener);
        this.l = audioFocusManager;
        audioFocusManager.m(builder.l ? this.C : null);
        com.google.android.exoplayer2.StreamVolumeManager streamVolumeManager = new com.google.android.exoplayer2.StreamVolumeManager(builder.a, handler, componentListener);
        this.m = streamVolumeManager;
        streamVolumeManager.m(com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(this.C.usage));
        com.google.android.exoplayer2.WakeLockManager wakeLockManager = new com.google.android.exoplayer2.WakeLockManager(builder.a);
        this.n = wakeLockManager;
        wakeLockManager.a(builder.m != 0);
        com.google.android.exoplayer2.WifiLockManager wifiLockManager = new com.google.android.exoplayer2.WifiLockManager(builder.a);
        this.o = wifiLockManager;
        wifiLockManager.a(builder.m == 2);
        this.N = G(streamVolumeManager);
        if (!builder.t) {
            exoPlayerImpl.n();
        }
        M(1, 3, this.C);
        M(2, 4, java.lang.Integer.valueOf(this.u));
        M(1, 101, java.lang.Boolean.valueOf(this.E));
    }

    public static com.google.android.exoplayer2.device.DeviceInfo G(com.google.android.exoplayer2.StreamVolumeManager streamVolumeManager) {
        return new com.google.android.exoplayer2.device.DeviceInfo(0, streamVolumeManager.e(), streamVolumeManager.d());
    }

    public static int H(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    public final void I(int i, int i2) {
        if (i == this.x && i2 == this.y) {
            return;
        }
        this.x = i;
        this.y = i2;
        java.util.Iterator<com.google.android.exoplayer2.video.VideoListener> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().onSurfaceSizeChanged(i, i2);
        }
    }

    public final void J() {
        java.util.Iterator<com.google.android.exoplayer2.audio.AudioListener> it = this.d.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.audio.AudioListener next = it.next();
            if (!this.i.contains(next)) {
                next.onAudioSessionId(this.B);
            }
        }
        java.util.Iterator<com.google.android.exoplayer2.audio.AudioRendererEventListener> it2 = this.i.iterator();
        while (it2.hasNext()) {
            it2.next().onAudioSessionId(this.B);
        }
    }

    public final void K() {
        java.util.Iterator<com.google.android.exoplayer2.audio.AudioListener> it = this.d.iterator();
        while (it.hasNext()) {
            com.google.android.exoplayer2.audio.AudioListener next = it.next();
            if (!this.i.contains(next)) {
                next.onSkipSilenceEnabledChanged(this.E);
            }
        }
        java.util.Iterator<com.google.android.exoplayer2.audio.AudioRendererEventListener> it2 = this.i.iterator();
        while (it2.hasNext()) {
            it2.next().onSkipSilenceEnabledChanged(this.E);
        }
    }

    public final void L() {
        android.view.TextureView textureView = this.w;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.b) {
                com.google.android.exoplayer2.util.Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.w.setSurfaceTextureListener(null);
            }
            this.w = null;
        }
        android.view.SurfaceHolder surfaceHolder = this.v;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.b);
            this.v = null;
        }
    }

    public final void M(int i, int i2, @androidx.annotation.Nullable java.lang.Object obj) {
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == i) {
                this.a.createMessage(renderer).setType(i2).setPayload(obj).send();
            }
        }
    }

    public final void N() {
        M(1, 2, java.lang.Float.valueOf(this.D * this.l.g()));
    }

    public final void O(@androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        M(2, 8, videoDecoderOutputBufferRenderer);
        this.r = videoDecoderOutputBufferRenderer;
    }

    public final void P(@androidx.annotation.Nullable android.view.Surface surface, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.android.exoplayer2.Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.a.createMessage(renderer).setType(1).setPayload(surface).send());
            }
        }
        android.view.Surface surface2 = this.f339s;
        if (surface2 != null && surface2 != surface) {
            try {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.google.android.exoplayer2.PlayerMessage) it.next()).blockUntilDelivered();
                }
            } catch (java.lang.InterruptedException unused) {
                java.lang.Thread.currentThread().interrupt();
            }
            if (this.t) {
                this.f339s.release();
            }
        }
        this.f339s = surface;
        this.t = z;
    }

    public final void Q(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        this.a.I(z2, i3, i2);
    }

    public final void R() {
        int playbackState = getPlaybackState();
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                this.n.b(getPlayWhenReady());
                this.o.b(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new java.lang.IllegalStateException();
            }
        }
        this.n.b(false);
        this.o.b(false);
    }

    public final void S() {
        if (android.os.Looper.myLooper() != getApplicationLooper()) {
            if (this.I) {
                throw new java.lang.IllegalStateException("Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread");
            }
            com.google.android.exoplayer2.util.Log.w("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.J ? null : new java.lang.IllegalStateException());
            this.J = true;
        }
    }

    public void addAnalyticsListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(analyticsListener);
        this.j.addListener(analyticsListener);
    }

    @java.lang.Deprecated
    public void addAudioDebugListener(com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(audioRendererEventListener);
        this.i.add(audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void addAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(audioListener);
        this.d.add(audioListener);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void addDeviceListener(com.google.android.exoplayer2.device.DeviceListener deviceListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(deviceListener);
        this.g.add(deviceListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(eventListener);
        this.a.addListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void addMediaItem(int i, com.google.android.exoplayer2.MediaItem mediaItem) {
        S();
        this.a.addMediaItem(i, mediaItem);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void addMediaItem(com.google.android.exoplayer2.MediaItem mediaItem) {
        S();
        this.a.addMediaItem(mediaItem);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(int i, java.util.List<com.google.android.exoplayer2.MediaItem> list) {
        S();
        this.a.addMediaItems(i, list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void addMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list) {
        S();
        this.a.addMediaItems(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(int i, com.google.android.exoplayer2.source.MediaSource mediaSource) {
        S();
        this.a.addMediaSource(i, mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        S();
        this.a.addMediaSource(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(int i, java.util.List<com.google.android.exoplayer2.source.MediaSource> list) {
        S();
        this.a.addMediaSources(i, list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void addMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list) {
        S();
        this.a.addMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.Player.MetadataComponent
    public void addMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(metadataOutput);
        this.f.add(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void addTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(textOutput);
        this.e.add(textOutput);
    }

    @java.lang.Deprecated
    public void addVideoDebugListener(com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(videoRendererEventListener);
        this.h.add(videoRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void addVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(videoListener);
        this.c.add(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void clearAuxEffectInfo() {
        setAuxEffectInfo(new com.google.android.exoplayer2.audio.AuxEffectInfo(0, 0.0f));
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener) {
        S();
        if (this.H != cameraMotionListener) {
            return;
        }
        M(5, 7, null);
    }

    @Override // com.google.android.exoplayer2.Player
    public void clearMediaItems() {
        S();
        this.a.clearMediaItems();
    }

    @java.lang.Deprecated
    public void clearMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        removeMetadataOutput(metadataOutput);
    }

    @java.lang.Deprecated
    public void clearTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        removeTextOutput(textOutput);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoDecoderOutputBufferRenderer() {
        S();
        O(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoDecoderOutputBufferRenderer(@androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        S();
        if (videoDecoderOutputBufferRenderer == null || videoDecoderOutputBufferRenderer != this.r) {
            return;
        }
        clearVideoDecoderOutputBufferRenderer();
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener) {
        S();
        if (this.G != videoFrameMetadataListener) {
            return;
        }
        M(2, 6, null);
    }

    @java.lang.Deprecated
    public void clearVideoListener(com.google.android.exoplayer2.SimpleExoPlayer.VideoListener videoListener) {
        removeVideoListener(videoListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface() {
        S();
        L();
        P(null, false);
        I(0, 0);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurface(@androidx.annotation.Nullable android.view.Surface surface) {
        S();
        if (surface == null || surface != this.f339s) {
            return;
        }
        clearVideoSurface();
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceHolder(@androidx.annotation.Nullable android.view.SurfaceHolder surfaceHolder) {
        S();
        if (surfaceHolder == null || surfaceHolder != this.v) {
            return;
        }
        setVideoSurfaceHolder(null);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoSurfaceView(@androidx.annotation.Nullable android.view.SurfaceView surfaceView) {
        clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void clearVideoTextureView(@androidx.annotation.Nullable android.view.TextureView textureView) {
        S();
        if (textureView == null || textureView != this.w) {
            return;
        }
        setVideoTextureView(null);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.PlayerMessage createMessage(com.google.android.exoplayer2.PlayerMessage.Target target) {
        S();
        return this.a.createMessage(target);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void decreaseDeviceVolume() {
        S();
        this.m.c();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        this.a.experimentalSetOffloadSchedulingEnabled(z);
    }

    public com.google.android.exoplayer2.analytics.AnalyticsCollector getAnalyticsCollector() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.Player
    public android.os.Looper getApplicationLooper() {
        return this.a.getApplicationLooper();
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public com.google.android.exoplayer2.audio.AudioAttributes getAudioAttributes() {
        return this.C;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.AudioComponent getAudioComponent() {
        return this;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.decoder.DecoderCounters getAudioDecoderCounters() {
        return this.A;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format getAudioFormat() {
        return this.q;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public int getAudioSessionId() {
        return this.B;
    }

    @java.lang.Deprecated
    public int getAudioStreamType() {
        return com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(this.C.usage);
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        S();
        return this.a.getBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        S();
        return this.a.getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        S();
        return this.a.getContentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        S();
        return this.a.getCurrentAdGroupIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        S();
        return this.a.getCurrentAdIndexInAdGroup();
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCurrentCues() {
        S();
        return this.F;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        S();
        return this.a.getCurrentPeriodIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        S();
        return this.a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.Timeline getCurrentTimeline() {
        S();
        return this.a.getCurrentTimeline();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.source.TrackGroupArray getCurrentTrackGroups() {
        S();
        return this.a.getCurrentTrackGroups();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.trackselection.TrackSelectionArray getCurrentTrackSelections() {
        S();
        return this.a.getCurrentTrackSelections();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        S();
        return this.a.getCurrentWindowIndex();
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.DeviceComponent getDeviceComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public com.google.android.exoplayer2.device.DeviceInfo getDeviceInfo() {
        S();
        return this.N;
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public int getDeviceVolume() {
        S();
        return this.m.g();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        S();
        return this.a.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.MetadataComponent getMetadataComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public boolean getPauseAtEndOfMediaItems() {
        S();
        return this.a.getPauseAtEndOfMediaItems();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        S();
        return this.a.getPlayWhenReady();
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public com.google.android.exoplayer2.ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public android.os.Looper getPlaybackLooper() {
        return this.a.getPlaybackLooper();
    }

    @Override // com.google.android.exoplayer2.Player
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        S();
        return this.a.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        S();
        return this.a.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        S();
        return this.a.getPlaybackSuppressionReason();
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ExoPlaybackException getPlayerError() {
        S();
        return this.a.getPlayerError();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        S();
        return this.a.getRendererCount();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i) {
        S();
        return this.a.getRendererType(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        S();
        return this.a.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public com.google.android.exoplayer2.SeekParameters getSeekParameters() {
        S();
        return this.a.getSeekParameters();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        S();
        return this.a.getShuffleModeEnabled();
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public boolean getSkipSilenceEnabled() {
        return this.E;
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.TextComponent getTextComponent() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        S();
        return this.a.getTotalBufferedDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.TrackSelector getTrackSelector() {
        S();
        return this.a.getTrackSelector();
    }

    @Override // com.google.android.exoplayer2.Player
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player.VideoComponent getVideoComponent() {
        return this;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.decoder.DecoderCounters getVideoDecoderCounters() {
        return this.z;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format getVideoFormat() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public int getVideoScalingMode() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public float getVolume() {
        return this.D;
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void increaseDeviceVolume() {
        S();
        this.m.i();
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public boolean isDeviceMuted() {
        S();
        return this.m.j();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        S();
        return this.a.isLoading();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        S();
        return this.a.isPlayingAd();
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void moveMediaItem(int i, int i2) {
        S();
        this.a.moveMediaItem(i, i2);
    }

    @Override // com.google.android.exoplayer2.Player
    public void moveMediaItems(int i, int i2, int i3) {
        S();
        this.a.moveMediaItems(i, i2, i3);
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        S();
        boolean playWhenReady = getPlayWhenReady();
        int p = this.l.p(playWhenReady, 2);
        Q(playWhenReady, p, H(playWhenReady, p));
        this.a.prepare();
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void prepare(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z, boolean z2) {
        S();
        setMediaSources(java.util.Collections.singletonList(mediaSource), z ? 0 : -1, -9223372036854775807L);
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        S();
        this.k.b(false);
        this.m.k();
        this.n.b(false);
        this.o.b(false);
        this.l.i();
        this.a.release();
        L();
        android.view.Surface surface = this.f339s;
        if (surface != null) {
            if (this.t) {
                surface.release();
            }
            this.f339s = null;
        }
        if (this.L) {
            ((com.google.android.exoplayer2.util.PriorityTaskManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.K)).remove(0);
            this.L = false;
        }
        this.F = java.util.Collections.emptyList();
        this.M = true;
    }

    public void removeAnalyticsListener(com.google.android.exoplayer2.analytics.AnalyticsListener analyticsListener) {
        this.j.removeListener(analyticsListener);
    }

    @java.lang.Deprecated
    public void removeAudioDebugListener(com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this.i.remove(audioRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void removeAudioListener(com.google.android.exoplayer2.audio.AudioListener audioListener) {
        this.d.remove(audioListener);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void removeDeviceListener(com.google.android.exoplayer2.device.DeviceListener deviceListener) {
        this.g.remove(deviceListener);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(com.google.android.exoplayer2.Player.EventListener eventListener) {
        this.a.removeListener(eventListener);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void removeMediaItem(int i) {
        S();
        this.a.removeMediaItem(i);
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeMediaItems(int i, int i2) {
        S();
        this.a.removeMediaItems(i, i2);
    }

    @Override // com.google.android.exoplayer2.Player.MetadataComponent
    public void removeMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        this.f.remove(metadataOutput);
    }

    @Override // com.google.android.exoplayer2.Player.TextComponent
    public void removeTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        this.e.remove(textOutput);
    }

    @java.lang.Deprecated
    public void removeVideoDebugListener(com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
        this.h.remove(videoRendererEventListener);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void removeVideoListener(com.google.android.exoplayer2.video.VideoListener videoListener) {
        this.c.remove(videoListener);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    @java.lang.Deprecated
    public void retry() {
        S();
        prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        S();
        this.j.notifySeekStarted();
        this.a.seekTo(i, j);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
        setAudioAttributes(audioAttributes, false);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioAttributes(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes, boolean z) {
        S();
        if (this.M) {
            return;
        }
        if (!com.google.android.exoplayer2.util.Util.areEqual(this.C, audioAttributes)) {
            this.C = audioAttributes;
            M(1, 3, audioAttributes);
            this.m.m(com.google.android.exoplayer2.util.Util.getStreamTypeForAudioUsage(audioAttributes.usage));
            java.util.Iterator<com.google.android.exoplayer2.audio.AudioListener> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onAudioAttributesChanged(audioAttributes);
            }
        }
        com.google.android.exoplayer2.AudioFocusManager audioFocusManager = this.l;
        if (!z) {
            audioAttributes = null;
        }
        audioFocusManager.m(audioAttributes);
        boolean playWhenReady = getPlayWhenReady();
        int p = this.l.p(playWhenReady, getPlaybackState());
        Q(playWhenReady, p, H(playWhenReady, p));
    }

    @java.lang.Deprecated
    public void setAudioDebugListener(@androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this.i.retainAll(java.util.Collections.singleton(this.j));
        if (audioRendererEventListener != null) {
            addAudioDebugListener(audioRendererEventListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAudioSessionId(int i) {
        S();
        if (this.B == i) {
            return;
        }
        this.B = i;
        M(1, 102, java.lang.Integer.valueOf(i));
        if (i != 0) {
            J();
        }
    }

    @java.lang.Deprecated
    public void setAudioStreamType(int i) {
        int audioUsageForStreamType = com.google.android.exoplayer2.util.Util.getAudioUsageForStreamType(i);
        setAudioAttributes(new com.google.android.exoplayer2.audio.AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(com.google.android.exoplayer2.util.Util.getAudioContentTypeForStreamType(i)).build());
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setAuxEffectInfo(com.google.android.exoplayer2.audio.AuxEffectInfo auxEffectInfo) {
        S();
        M(1, 5, auxEffectInfo);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setCameraMotionListener(com.google.android.exoplayer2.video.spherical.CameraMotionListener cameraMotionListener) {
        S();
        this.H = cameraMotionListener;
        M(5, 7, cameraMotionListener);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void setDeviceMuted(boolean z) {
        S();
        this.m.l(z);
    }

    @Override // com.google.android.exoplayer2.Player.DeviceComponent
    public void setDeviceVolume(int i) {
        S();
        this.m.n(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        S();
        this.a.setForegroundMode(z);
    }

    public void setHandleAudioBecomingNoisy(boolean z) {
        S();
        if (this.M) {
            return;
        }
        this.k.b(z);
    }

    @java.lang.Deprecated
    public void setHandleWakeLock(boolean z) {
        setWakeMode(z ? 1 : 0);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaItem(mediaItem);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, long j) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaItem(mediaItem, j);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, boolean z) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaItem(mediaItem, z);
    }

    @Override // com.google.android.exoplayer2.BasePlayer, com.google.android.exoplayer2.Player
    public void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaItems(list);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list, int i, long j) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaItems(list, i, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setMediaItems(java.util.List<com.google.android.exoplayer2.MediaItem> list, boolean z) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaItems(list, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaSource(mediaSource);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, long j) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaSource(mediaSource, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaSource(mediaSource, z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaSources(list);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, int i, long j) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaSources(list, i, j);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setMediaSources(java.util.List<com.google.android.exoplayer2.source.MediaSource> list, boolean z) {
        S();
        this.j.resetForNewPlaylist();
        this.a.setMediaSources(list, z);
    }

    @java.lang.Deprecated
    public void setMetadataOutput(com.google.android.exoplayer2.metadata.MetadataOutput metadataOutput) {
        this.f.retainAll(java.util.Collections.singleton(this.j));
        if (metadataOutput != null) {
            addMetadataOutput(metadataOutput);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setPauseAtEndOfMediaItems(boolean z) {
        S();
        this.a.setPauseAtEndOfMediaItems(z);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        S();
        int p = this.l.p(z, getPlaybackState());
        Q(z, p, H(z, p));
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(@androidx.annotation.Nullable com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        S();
        this.a.setPlaybackParameters(playbackParameters);
    }

    @androidx.annotation.RequiresApi(23)
    @java.lang.Deprecated
    public void setPlaybackParams(@androidx.annotation.Nullable android.media.PlaybackParams playbackParams) {
        com.google.android.exoplayer2.PlaybackParameters playbackParameters;
        float speed;
        float pitch;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            speed = playbackParams.getSpeed();
            pitch = playbackParams.getPitch();
            playbackParameters = new com.google.android.exoplayer2.PlaybackParameters(speed, pitch);
        } else {
            playbackParameters = null;
        }
        setPlaybackParameters(playbackParameters);
    }

    public void setPriorityTaskManager(@androidx.annotation.Nullable com.google.android.exoplayer2.util.PriorityTaskManager priorityTaskManager) {
        S();
        if (com.google.android.exoplayer2.util.Util.areEqual(this.K, priorityTaskManager)) {
            return;
        }
        if (this.L) {
            ((com.google.android.exoplayer2.util.PriorityTaskManager) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.K)).remove(0);
        }
        if (priorityTaskManager == null || !isLoading()) {
            this.L = false;
        } else {
            priorityTaskManager.add(0);
            this.L = true;
        }
        this.K = priorityTaskManager;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        S();
        this.a.setRepeatMode(i);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(@androidx.annotation.Nullable com.google.android.exoplayer2.SeekParameters seekParameters) {
        S();
        this.a.setSeekParameters(seekParameters);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        S();
        this.a.setShuffleModeEnabled(z);
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void setShuffleOrder(com.google.android.exoplayer2.source.ShuffleOrder shuffleOrder) {
        S();
        this.a.setShuffleOrder(shuffleOrder);
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setSkipSilenceEnabled(boolean z) {
        S();
        if (this.E == z) {
            return;
        }
        this.E = z;
        M(1, 101, java.lang.Boolean.valueOf(z));
        K();
    }

    @java.lang.Deprecated
    public void setTextOutput(com.google.android.exoplayer2.text.TextOutput textOutput) {
        this.e.clear();
        if (textOutput != null) {
            addTextOutput(textOutput);
        }
    }

    public void setThrowsWhenUsingWrongThread(boolean z) {
        this.I = z;
    }

    @java.lang.Deprecated
    public void setVideoDebugListener(@androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener) {
        this.h.retainAll(java.util.Collections.singleton(this.j));
        if (videoRendererEventListener != null) {
            addVideoDebugListener(videoRendererEventListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoDecoderOutputBufferRenderer(@androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        S();
        if (videoDecoderOutputBufferRenderer != null) {
            clearVideoSurface();
        }
        O(videoDecoderOutputBufferRenderer);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoFrameMetadataListener(com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener) {
        S();
        this.G = videoFrameMetadataListener;
        M(2, 6, videoFrameMetadataListener);
    }

    @java.lang.Deprecated
    public void setVideoListener(@androidx.annotation.Nullable com.google.android.exoplayer2.SimpleExoPlayer.VideoListener videoListener) {
        this.c.clear();
        if (videoListener != null) {
            addVideoListener(videoListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoScalingMode(int i) {
        S();
        this.u = i;
        M(2, 4, java.lang.Integer.valueOf(i));
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurface(@androidx.annotation.Nullable android.view.Surface surface) {
        S();
        L();
        if (surface != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        P(surface, false);
        int i = surface != null ? -1 : 0;
        I(i, i);
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceHolder(@androidx.annotation.Nullable android.view.SurfaceHolder surfaceHolder) {
        S();
        L();
        if (surfaceHolder != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.v = surfaceHolder;
        if (surfaceHolder == null) {
            P(null, false);
            I(0, 0);
            return;
        }
        surfaceHolder.addCallback(this.b);
        android.view.Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            P(null, false);
            I(0, 0);
        } else {
            P(surface, false);
            android.graphics.Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            I(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoSurfaceView(@androidx.annotation.Nullable android.view.SurfaceView surfaceView) {
        setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.Player.VideoComponent
    public void setVideoTextureView(@androidx.annotation.Nullable android.view.TextureView textureView) {
        S();
        L();
        if (textureView != null) {
            clearVideoDecoderOutputBufferRenderer();
        }
        this.w = textureView;
        if (textureView == null) {
            P(null, true);
            I(0, 0);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            com.google.android.exoplayer2.util.Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.b);
        android.graphics.SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            P(null, true);
            I(0, 0);
        } else {
            P(new android.view.Surface(surfaceTexture), true);
            I(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.Player.AudioComponent
    public void setVolume(float f) {
        S();
        float constrainValue = com.google.android.exoplayer2.util.Util.constrainValue(f, 0.0f, 1.0f);
        if (this.D == constrainValue) {
            return;
        }
        this.D = constrainValue;
        N();
        java.util.Iterator<com.google.android.exoplayer2.audio.AudioListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(constrainValue);
        }
    }

    public void setWakeMode(int i) {
        S();
        if (i == 0) {
            this.n.a(false);
            this.o.a(false);
        } else if (i == 1) {
            this.n.a(true);
            this.o.a(false);
        } else {
            if (i != 2) {
                return;
            }
            this.n.a(true);
            this.o.a(true);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z) {
        S();
        this.l.p(getPlayWhenReady(), 1);
        this.a.stop(z);
        this.F = java.util.Collections.emptyList();
    }
}
