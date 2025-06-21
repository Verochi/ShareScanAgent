package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class DownloadHelper {

    @java.lang.Deprecated
    public static final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS;
    public static final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;

    @java.lang.Deprecated
    public static final com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT;
    public final com.google.android.exoplayer2.MediaItem.PlaybackProperties a;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.MediaSource b;
    public final com.google.android.exoplayer2.trackselection.DefaultTrackSelector c;
    public final com.google.android.exoplayer2.RendererCapabilities[] d;
    public final android.util.SparseIntArray e;
    public final android.os.Handler f;
    public final com.google.android.exoplayer2.Timeline.Window g;
    public boolean h;
    public com.google.android.exoplayer2.offline.DownloadHelper.Callback i;
    public com.google.android.exoplayer2.offline.DownloadHelper.MediaPreparer j;
    public com.google.android.exoplayer2.source.TrackGroupArray[] k;
    public com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo[] l;
    public java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection>[][] m;
    public java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection>[][] n;

    /* renamed from: com.google.android.exoplayer2.offline.DownloadHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.video.VideoRendererEventListener {
        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onDroppedFrames(int i, long j) {
            defpackage.za3.a(this, i, j);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onRenderedFirstFrame(android.view.Surface surface) {
            defpackage.za3.b(this, surface);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoDecoderInitialized(java.lang.String str, long j, long j2) {
            defpackage.za3.c(this, str, j, j2);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            defpackage.za3.d(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            defpackage.za3.e(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoFrameProcessingOffset(long j, int i) {
            defpackage.za3.f(this, j, i);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoInputFormatChanged(com.google.android.exoplayer2.Format format) {
            defpackage.za3.g(this, format);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public /* synthetic */ void onVideoSizeChanged(int i, int i2, int i3, float f) {
            defpackage.za3.h(this, i, i2, i3, f);
        }
    }

    /* renamed from: com.google.android.exoplayer2.offline.DownloadHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.exoplayer2.audio.AudioRendererEventListener {
        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioDecoderInitialized(java.lang.String str, long j, long j2) {
            defpackage.ge.a(this, str, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioDisabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            defpackage.ge.b(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioEnabled(com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters) {
            defpackage.ge.c(this, decoderCounters);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioInputFormatChanged(com.google.android.exoplayer2.Format format) {
            defpackage.ge.d(this, format);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioPositionAdvancing(long j) {
            defpackage.ge.e(this, j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioSessionId(int i) {
            defpackage.ge.f(this, i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onAudioUnderrun(int i, long j, long j2) {
            defpackage.ge.g(this, i, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
            defpackage.ge.h(this, z);
        }
    }

    public interface Callback {
        void onPrepareError(com.google.android.exoplayer2.offline.DownloadHelper downloadHelper, java.io.IOException iOException);

        void onPrepared(com.google.android.exoplayer2.offline.DownloadHelper downloadHelper);
    }

    public static final class DownloadTrackSelection extends com.google.android.exoplayer2.trackselection.BaseTrackSelection {

        public static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
            public Factory() {
            }

            public /* synthetic */ Factory(com.google.android.exoplayer2.offline.DownloadHelper.AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
            public com.google.android.exoplayer2.trackselection.TrackSelection[] createTrackSelections(com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] definitionArr, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
                com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr = new com.google.android.exoplayer2.trackselection.TrackSelection[definitionArr.length];
                for (int i = 0; i < definitionArr.length; i++) {
                    com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition = definitionArr[i];
                    trackSelectionArr[i] = definition == null ? null : new com.google.android.exoplayer2.offline.DownloadHelper.DownloadTrackSelection(definition.group, definition.tracks);
                }
                return trackSelectionArr;
            }
        }

        public DownloadTrackSelection(com.google.android.exoplayer2.source.TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        @androidx.annotation.Nullable
        public java.lang.Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j, long j2, long j3, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr) {
        }
    }

    public static final class FakeBandwidthMeter implements com.google.android.exoplayer2.upstream.BandwidthMeter {
        public FakeBandwidthMeter() {
        }

        public /* synthetic */ FakeBandwidthMeter(com.google.android.exoplayer2.offline.DownloadHelper.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void addEventListener(android.os.Handler handler, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener) {
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public long getBitrateEstimate() {
            return 0L;
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.TransferListener getTransferListener() {
            return null;
        }

        @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void removeEventListener(com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener eventListener) {
        }
    }

    public static class LiveContentUnsupportedException extends java.io.IOException {
    }

    public static final class MediaPreparer implements com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller, com.google.android.exoplayer2.source.MediaPeriod.Callback, android.os.Handler.Callback {
        public com.google.android.exoplayer2.source.MediaPeriod[] A;
        public boolean B;
        public final com.google.android.exoplayer2.source.MediaSource n;
        public final com.google.android.exoplayer2.offline.DownloadHelper t;
        public final com.google.android.exoplayer2.upstream.Allocator u = new com.google.android.exoplayer2.upstream.DefaultAllocator(true, 65536);
        public final java.util.ArrayList<com.google.android.exoplayer2.source.MediaPeriod> v = new java.util.ArrayList<>();
        public final android.os.Handler w = com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper(new com.google.android.exoplayer2.offline.a(this));
        public final android.os.HandlerThread x;
        public final android.os.Handler y;
        public com.google.android.exoplayer2.Timeline z;

        public MediaPreparer(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.offline.DownloadHelper downloadHelper) {
            this.n = mediaSource;
            this.t = downloadHelper;
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("ExoPlayer:DownloadHelper");
            this.x = handlerThread;
            handlerThread.start();
            android.os.Handler createHandler = com.google.android.exoplayer2.util.Util.createHandler(handlerThread.getLooper(), this);
            this.y = createHandler;
            createHandler.sendEmptyMessage(0);
        }

        public final boolean b(android.os.Message message) {
            if (this.B) {
                return false;
            }
            int i = message.what;
            if (i == 0) {
                this.t.s();
                return true;
            }
            if (i != 1) {
                return false;
            }
            d();
            this.t.r((java.io.IOException) com.google.android.exoplayer2.util.Util.castNonNull(message.obj));
            return true;
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
            if (this.v.contains(mediaPeriod)) {
                this.y.obtainMessage(2, mediaPeriod).sendToTarget();
            }
        }

        public void d() {
            if (this.B) {
                return;
            }
            this.B = true;
            this.y.sendEmptyMessage(3);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 0) {
                this.n.prepareSource(this, null);
                this.y.sendEmptyMessage(1);
                return true;
            }
            int i2 = 0;
            if (i == 1) {
                try {
                    if (this.A == null) {
                        this.n.maybeThrowSourceInfoRefreshError();
                    } else {
                        while (i2 < this.v.size()) {
                            this.v.get(i2).maybeThrowPrepareError();
                            i2++;
                        }
                    }
                    this.y.sendEmptyMessageDelayed(1, 100L);
                } catch (java.io.IOException e) {
                    this.w.obtainMessage(1, e).sendToTarget();
                }
                return true;
            }
            if (i == 2) {
                com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = (com.google.android.exoplayer2.source.MediaPeriod) message.obj;
                if (this.v.contains(mediaPeriod)) {
                    mediaPeriod.continueLoading(0L);
                }
                return true;
            }
            if (i != 3) {
                return false;
            }
            com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.A;
            if (mediaPeriodArr != null) {
                int length = mediaPeriodArr.length;
                while (i2 < length) {
                    this.n.releasePeriod(mediaPeriodArr[i2]);
                    i2++;
                }
            }
            this.n.releaseSource(this);
            this.y.removeCallbacksAndMessages(null);
            this.x.quit();
            return true;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
            this.v.remove(mediaPeriod);
            if (this.v.isEmpty()) {
                this.y.removeMessages(1);
                this.w.sendEmptyMessage(0);
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
        public void onSourceInfoRefreshed(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
            com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr;
            if (this.z != null) {
                return;
            }
            if (timeline.getWindow(0, new com.google.android.exoplayer2.Timeline.Window()).isLive) {
                this.w.obtainMessage(1, new com.google.android.exoplayer2.offline.DownloadHelper.LiveContentUnsupportedException()).sendToTarget();
                return;
            }
            this.z = timeline;
            this.A = new com.google.android.exoplayer2.source.MediaPeriod[timeline.getPeriodCount()];
            int i = 0;
            while (true) {
                mediaPeriodArr = this.A;
                if (i >= mediaPeriodArr.length) {
                    break;
                }
                com.google.android.exoplayer2.source.MediaPeriod createPeriod = this.n.createPeriod(new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(timeline.getUidOfPeriod(i)), this.u, 0L);
                this.A[i] = createPeriod;
                this.v.add(createPeriod);
                i++;
            }
            for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : mediaPeriodArr) {
                mediaPeriod.prepare(this, 0L);
            }
        }
    }

    static {
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters build = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.DEFAULT_WITHOUT_CONTEXT.buildUpon().setForceHighestSupportedBitrate(true).build();
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT = build;
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT = build;
        DEFAULT_TRACK_SELECTOR_PARAMETERS = build;
    }

    public DownloadHelper(com.google.android.exoplayer2.MediaItem mediaItem, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr) {
        this.a = (com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        this.b = mediaSource;
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector defaultTrackSelector = new com.google.android.exoplayer2.trackselection.DefaultTrackSelector(parameters, new com.google.android.exoplayer2.offline.DownloadHelper.DownloadTrackSelection.Factory(null));
        this.c = defaultTrackSelector;
        this.d = rendererCapabilitiesArr;
        this.e = new android.util.SparseIntArray();
        defaultTrackSelector.init(new defpackage.z40(), new com.google.android.exoplayer2.offline.DownloadHelper.FakeBandwidthMeter(null));
        this.f = com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper();
        this.g = new com.google.android.exoplayer2.Timeline.Window();
    }

    public static com.google.android.exoplayer2.source.MediaSource createMediaSource(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        return createMediaSource(downloadRequest, factory, null);
    }

    public static com.google.android.exoplayer2.source.MediaSource createMediaSource(com.google.android.exoplayer2.offline.DownloadRequest downloadRequest, com.google.android.exoplayer2.upstream.DataSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
        return j(downloadRequest.toMediaItem(), factory, drmSessionManager);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forDash(android.content.Context context, android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.RenderersFactory renderersFactory) {
        return forDash(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forDash(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.RenderersFactory renderersFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        return forMediaItem(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setMimeType("application/dash+xml").build(), parameters, renderersFactory, factory, drmSessionManager);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forHls(android.content.Context context, android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.RenderersFactory renderersFactory) {
        return forHls(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forHls(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.RenderersFactory renderersFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        return forMediaItem(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setMimeType("application/x-mpegURL").build(), parameters, renderersFactory, factory, drmSessionManager);
    }

    public static com.google.android.exoplayer2.offline.DownloadHelper forMediaItem(android.content.Context context, com.google.android.exoplayer2.MediaItem mediaItem) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(k((com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties)));
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), null, null, null);
    }

    public static com.google.android.exoplayer2.offline.DownloadHelper forMediaItem(android.content.Context context, com.google.android.exoplayer2.MediaItem mediaItem, @androidx.annotation.Nullable com.google.android.exoplayer2.RenderersFactory renderersFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        return forMediaItem(mediaItem, getDefaultTrackSelectorParameters(context), renderersFactory, factory, null);
    }

    public static com.google.android.exoplayer2.offline.DownloadHelper forMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, @androidx.annotation.Nullable com.google.android.exoplayer2.RenderersFactory renderersFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        return forMediaItem(mediaItem, parameters, renderersFactory, factory, null);
    }

    public static com.google.android.exoplayer2.offline.DownloadHelper forMediaItem(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, @androidx.annotation.Nullable com.google.android.exoplayer2.RenderersFactory renderersFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
        boolean k = k((com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties));
        com.google.android.exoplayer2.util.Assertions.checkArgument(k || factory != null);
        return new com.google.android.exoplayer2.offline.DownloadHelper(mediaItem, k ? null : j(mediaItem, (com.google.android.exoplayer2.upstream.DataSource.Factory) com.google.android.exoplayer2.util.Util.castNonNull(factory), drmSessionManager), parameters, renderersFactory != null ? getRendererCapabilities(renderersFactory) : new com.google.android.exoplayer2.RendererCapabilities[0]);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forProgressive(android.content.Context context, android.net.Uri uri) {
        return forMediaItem(context, new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).build());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forProgressive(android.content.Context context, android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str) {
        return forMediaItem(context, new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setCustomCacheKey(str).build());
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forSmoothStreaming(android.content.Context context, android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, null, getDefaultTrackSelectorParameters(context));
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forSmoothStreaming(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri, factory, renderersFactory, null, DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.offline.DownloadHelper forSmoothStreaming(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.RenderersFactory renderersFactory, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        return forMediaItem(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setMimeType("application/vnd.ms-sstr+xml").build(), parameters, renderersFactory, factory, drmSessionManager);
    }

    public static com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters getDefaultTrackSelectorParameters(android.content.Context context) {
        return com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.getDefaults(context).buildUpon().setForceHighestSupportedBitrate(true).build();
    }

    public static com.google.android.exoplayer2.RendererCapabilities[] getRendererCapabilities(com.google.android.exoplayer2.RenderersFactory renderersFactory) {
        com.google.android.exoplayer2.Renderer[] createRenderers = renderersFactory.createRenderers(com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper(), new com.google.android.exoplayer2.offline.DownloadHelper.AnonymousClass1(), new com.google.android.exoplayer2.offline.DownloadHelper.AnonymousClass2(), new defpackage.a50(), new defpackage.b50());
        com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr = new com.google.android.exoplayer2.RendererCapabilities[createRenderers.length];
        for (int i = 0; i < createRenderers.length; i++) {
            rendererCapabilitiesArr[i] = createRenderers[i].getCapabilities();
        }
        return rendererCapabilitiesArr;
    }

    public static com.google.android.exoplayer2.source.MediaSource j(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.upstream.DataSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
        return new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(factory, com.google.android.exoplayer2.extractor.ExtractorsFactory.EMPTY).setDrmSessionManager(drmSessionManager).createMediaSource(mediaItem);
    }

    public static boolean k(com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties) {
        return com.google.android.exoplayer2.util.Util.inferContentTypeForUriAndMimeType(playbackProperties.uri, playbackProperties.mimeType) == 3;
    }

    public static /* synthetic */ void l(java.util.List list) {
    }

    public static /* synthetic */ void m(com.google.android.exoplayer2.metadata.Metadata metadata) {
    }

    public static /* synthetic */ void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(java.io.IOException iOException) {
        ((com.google.android.exoplayer2.offline.DownloadHelper.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i)).onPrepareError(this, iOException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        ((com.google.android.exoplayer2.offline.DownloadHelper.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i)).onPrepared(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(com.google.android.exoplayer2.offline.DownloadHelper.Callback callback) {
        callback.onPrepared(this);
    }

    public void addAudioLanguagesToSelection(java.lang.String... strArr) {
        i();
        for (int i = 0; i < this.l.length; i++) {
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.l[i];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                if (mappedTrackInfo.getRendererType(i2) != 1) {
                    buildUpon.setRendererDisabled(i2, true);
                }
            }
            for (java.lang.String str : strArr) {
                buildUpon.setPreferredAudioLanguage(str);
                addTrackSelection(i, buildUpon.build());
            }
        }
    }

    public void addTextLanguagesToSelection(boolean z, java.lang.String... strArr) {
        i();
        for (int i = 0; i < this.l.length; i++) {
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.l[i];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                if (mappedTrackInfo.getRendererType(i2) != 3) {
                    buildUpon.setRendererDisabled(i2, true);
                }
            }
            buildUpon.setSelectUndeterminedTextLanguage(z);
            for (java.lang.String str : strArr) {
                buildUpon.setPreferredTextLanguage(str);
                addTrackSelection(i, buildUpon.build());
            }
        }
    }

    public void addTrackSelection(int i, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        i();
        this.c.setParameters(parameters);
        t(i);
    }

    public void addTrackSelectionForSingleRenderer(int i, int i2, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, java.util.List<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> list) {
        i();
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon = parameters.buildUpon();
        int i3 = 0;
        while (i3 < this.l[i].getRendererCount()) {
            buildUpon.setRendererDisabled(i3, i3 != i2);
            i3++;
        }
        if (list.isEmpty()) {
            addTrackSelection(i, buildUpon.build());
            return;
        }
        com.google.android.exoplayer2.source.TrackGroupArray trackGroups = this.l[i].getTrackGroups(i2);
        for (int i4 = 0; i4 < list.size(); i4++) {
            buildUpon.setSelectionOverride(i2, trackGroups, list.get(i4));
            addTrackSelection(i, buildUpon.build());
        }
    }

    public void clearTrackSelections(int i) {
        i();
        for (int i2 = 0; i2 < this.d.length; i2++) {
            this.m[i][i2].clear();
        }
    }

    public com.google.android.exoplayer2.offline.DownloadRequest getDownloadRequest(java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        com.google.android.exoplayer2.offline.DownloadRequest.Builder mimeType = new com.google.android.exoplayer2.offline.DownloadRequest.Builder(str, this.a.uri).setMimeType(this.a.mimeType);
        com.google.android.exoplayer2.MediaItem.DrmConfiguration drmConfiguration = this.a.drmConfiguration;
        com.google.android.exoplayer2.offline.DownloadRequest.Builder data = mimeType.setKeySetId(drmConfiguration != null ? drmConfiguration.getKeySetId() : null).setCustomCacheKey(this.a.customCacheKey).setData(bArr);
        if (this.b == null) {
            return data.build();
        }
        i();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int length = this.m.length;
        for (int i = 0; i < length; i++) {
            arrayList2.clear();
            int length2 = this.m[i].length;
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList2.addAll(this.m[i][i2]);
            }
            arrayList.addAll(this.j.A[i].getStreamKeys(arrayList2));
        }
        return data.setStreamKeys(arrayList).build();
    }

    public com.google.android.exoplayer2.offline.DownloadRequest getDownloadRequest(@androidx.annotation.Nullable byte[] bArr) {
        return getDownloadRequest(this.a.uri.toString(), bArr);
    }

    @androidx.annotation.Nullable
    public java.lang.Object getManifest() {
        if (this.b == null) {
            return null;
        }
        i();
        if (this.j.z.getWindowCount() > 0) {
            return this.j.z.getWindow(0, this.g).manifest;
        }
        return null;
    }

    public com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo getMappedTrackInfo(int i) {
        i();
        return this.l[i];
    }

    public int getPeriodCount() {
        if (this.b == null) {
            return 0;
        }
        i();
        return this.k.length;
    }

    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups(int i) {
        i();
        return this.k[i];
    }

    public java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection> getTrackSelections(int i, int i2) {
        i();
        return this.n[i][i2];
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    public final void i() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.h);
    }

    public void prepare(com.google.android.exoplayer2.offline.DownloadHelper.Callback callback) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.i == null);
        this.i = callback;
        com.google.android.exoplayer2.source.MediaSource mediaSource = this.b;
        if (mediaSource != null) {
            this.j = new com.google.android.exoplayer2.offline.DownloadHelper.MediaPreparer(mediaSource, this);
        } else {
            this.f.post(new defpackage.c50(this, callback));
        }
    }

    public final void r(java.io.IOException iOException) {
        ((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f)).post(new defpackage.d50(this, iOException));
    }

    public void release() {
        com.google.android.exoplayer2.offline.DownloadHelper.MediaPreparer mediaPreparer = this.j;
        if (mediaPreparer != null) {
            mediaPreparer.d();
        }
    }

    public void replaceTrackSelections(int i, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters) {
        clearTrackSelections(i);
        addTrackSelection(i, parameters);
    }

    public final void s() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.j);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.j.A);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.j.z);
        int length = this.j.A.length;
        int length2 = this.d.length;
        this.m = (java.util.List[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.util.List.class, length, length2);
        this.n = (java.util.List[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.util.List.class, length, length2);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                this.m[i][i2] = new java.util.ArrayList();
                this.n[i][i2] = java.util.Collections.unmodifiableList(this.m[i][i2]);
            }
        }
        this.k = new com.google.android.exoplayer2.source.TrackGroupArray[length];
        this.l = new com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.k[i3] = this.j.A[i3].getTrackGroups();
            this.c.onSelectionActivated(t(i3).info);
            this.l[i3] = (com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.c.getCurrentMappedTrackInfo());
        }
        u();
        ((android.os.Handler) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.f)).post(new defpackage.e50(this));
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    public final com.google.android.exoplayer2.trackselection.TrackSelectorResult t(int i) {
        boolean z;
        try {
            com.google.android.exoplayer2.trackselection.TrackSelectorResult selectTracks = this.c.selectTracks(this.d, this.k[i], new com.google.android.exoplayer2.source.MediaSource.MediaPeriodId(this.j.z.getUidOfPeriod(i)), this.j.z);
            for (int i2 = 0; i2 < selectTracks.length; i2++) {
                com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = selectTracks.selections.get(i2);
                if (trackSelection != null) {
                    java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection> list = this.m[i][i2];
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list.size()) {
                            z = false;
                            break;
                        }
                        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection2 = list.get(i3);
                        if (trackSelection2.getTrackGroup() == trackSelection.getTrackGroup()) {
                            this.e.clear();
                            for (int i4 = 0; i4 < trackSelection2.length(); i4++) {
                                this.e.put(trackSelection2.getIndexInTrackGroup(i4), 0);
                            }
                            for (int i5 = 0; i5 < trackSelection.length(); i5++) {
                                this.e.put(trackSelection.getIndexInTrackGroup(i5), 0);
                            }
                            int[] iArr = new int[this.e.size()];
                            for (int i6 = 0; i6 < this.e.size(); i6++) {
                                iArr[i6] = this.e.keyAt(i6);
                            }
                            list.set(i3, new com.google.android.exoplayer2.offline.DownloadHelper.DownloadTrackSelection(trackSelection2.getTrackGroup(), iArr));
                            z = true;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        list.add(trackSelection);
                    }
                }
            }
            return selectTracks;
        } catch (com.google.android.exoplayer2.ExoPlaybackException e) {
            throw new java.lang.UnsupportedOperationException(e);
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    public final void u() {
        this.h = true;
    }
}
