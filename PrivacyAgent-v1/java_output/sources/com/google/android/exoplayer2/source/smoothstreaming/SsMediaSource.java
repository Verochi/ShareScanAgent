package com.google.android.exoplayer2.source.smoothstreaming;

/* loaded from: classes22.dex */
public final class SsMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest>> {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    public final com.google.android.exoplayer2.MediaItem.PlaybackProperties A;
    public final com.google.android.exoplayer2.MediaItem B;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory C;
    public final com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory D;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory E;
    public final com.google.android.exoplayer2.drm.DrmSessionManager F;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy G;
    public final long H;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher I;
    public final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> J;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod> K;
    public com.google.android.exoplayer2.upstream.DataSource L;
    public com.google.android.exoplayer2.upstream.Loader M;
    public com.google.android.exoplayer2.upstream.LoaderErrorThrower N;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.TransferListener O;
    public long P;
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest Q;
    public android.os.Handler R;
    public final boolean y;
    public final android.net.Uri z;

    public static final class Factory implements com.google.android.exoplayer2.source.MediaSourceFactory {
        public final com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory a;
        public final com.google.android.exoplayer2.source.MediaSourceDrmHelper b;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.upstream.DataSource.Factory c;
        public com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory d;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.drm.DrmSessionManager e;
        public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy f;
        public long g;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> h;
        public java.util.List<com.google.android.exoplayer2.offline.StreamKey> i;

        @androidx.annotation.Nullable
        public java.lang.Object j;

        public Factory(com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory2) {
            this.a = (com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
            this.c = factory2;
            this.b = new com.google.android.exoplayer2.source.MediaSourceDrmHelper();
            this.f = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            this.g = 30000L;
            this.d = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
            this.i = java.util.Collections.emptyList();
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource.Factory(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(android.net.Uri uri) {
            return createMediaSource(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).build());
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(android.net.Uri uri, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(com.google.android.exoplayer2.MediaItem mediaItem) {
            com.google.android.exoplayer2.MediaItem mediaItem2 = mediaItem;
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem2.playbackProperties);
            com.google.android.exoplayer2.upstream.ParsingLoadable.Parser parser = this.h;
            if (parser == null) {
                parser = new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser();
            }
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> list = !mediaItem2.playbackProperties.streamKeys.isEmpty() ? mediaItem2.playbackProperties.streamKeys : this.i;
            com.google.android.exoplayer2.upstream.ParsingLoadable.Parser filteringManifestParser = !list.isEmpty() ? new com.google.android.exoplayer2.offline.FilteringManifestParser(parser, list) : parser;
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem2.playbackProperties;
            boolean z = playbackProperties.tag == null && this.j != null;
            boolean z2 = playbackProperties.streamKeys.isEmpty() && !list.isEmpty();
            if (z && z2) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.j).setStreamKeys(list).build();
            } else if (z) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.j).build();
            } else if (z2) {
                mediaItem2 = mediaItem.buildUpon().setStreamKeys(list).build();
            }
            com.google.android.exoplayer2.MediaItem mediaItem3 = mediaItem2;
            com.google.android.exoplayer2.upstream.DataSource.Factory factory = this.c;
            com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2 = this.a;
            com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.d;
            com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager = this.e;
            if (drmSessionManager == null) {
                drmSessionManager = this.b.create(mediaItem3);
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource(mediaItem3, null, factory, filteringManifestParser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, this.f, this.g, null);
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest) {
            return createMediaSource(ssManifest, com.google.android.exoplayer2.MediaItem.fromUri(android.net.Uri.EMPTY));
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource = createMediaSource(ssManifest);
            if (handler != null && mediaSourceEventListener != null) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource createMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.MediaItem mediaItem) {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest2 = ssManifest;
            com.google.android.exoplayer2.util.Assertions.checkArgument(!ssManifest2.isLive);
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> list = (playbackProperties == null || playbackProperties.streamKeys.isEmpty()) ? this.i : mediaItem.playbackProperties.streamKeys;
            if (!list.isEmpty()) {
                ssManifest2 = ssManifest2.copy(list);
            }
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest3 = ssManifest2;
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties2 = mediaItem.playbackProperties;
            boolean z = playbackProperties2 != null;
            com.google.android.exoplayer2.MediaItem build = mediaItem.buildUpon().setMimeType("application/vnd.ms-sstr+xml").setUri(z ? mediaItem.playbackProperties.uri : android.net.Uri.EMPTY).setTag(z && playbackProperties2.tag != null ? mediaItem.playbackProperties.tag : this.j).setStreamKeys(list).build();
            com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory = this.a;
            com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.d;
            com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager = this.e;
            if (drmSessionManager == null) {
                drmSessionManager = this.b.create(build);
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource(build, ssManifest3, null, null, factory, compositeSequenceableLoaderFactory, drmSessionManager, this.f, this.g, null);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{1};
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setCompositeSequenceableLoaderFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            if (compositeSequenceableLoaderFactory == null) {
                compositeSequenceableLoaderFactory = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
            }
            this.d = compositeSequenceableLoaderFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
            this.b.setDrmHttpDataSourceFactory(factory);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setDrmSessionManager(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
            this.e = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str) {
            this.b.setDrmUserAgent(str);
            return this;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setLivePresentationDelayMs(long j) {
            this.g = j;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            }
            this.f = loadErrorHandlingPolicy;
            return this;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setManifestParser(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parser) {
            this.h = parser;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setMinLoadableRetryCount(int i) {
            return setLoadErrorHandlingPolicy((com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy) new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys(@androidx.annotation.Nullable java.util.List list) {
            return setStreamKeys((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setStreamKeys(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            if (list == null) {
                list = java.util.Collections.emptyList();
            }
            this.i = list;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.Factory setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.j = obj;
            return this;
        }
    }

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    @java.lang.Deprecated
    public SsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, int i, long j, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser(), factory2, i, j, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public SsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, 30000L, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public SsMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parser, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, int i, long j, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setMimeType("application/vnd.ms-sstr+xml").build(), null, factory, parser, factory2, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), defpackage.z60.c(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i), j);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    public SsMediaSource(com.google.android.exoplayer2.MediaItem mediaItem, @androidx.annotation.Nullable com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parser, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        com.google.android.exoplayer2.util.Assertions.checkState(ssManifest == null || !ssManifest.isLive);
        this.B = mediaItem;
        com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = (com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        this.A = playbackProperties;
        this.Q = ssManifest;
        this.z = playbackProperties.uri.equals(android.net.Uri.EMPTY) ? null : com.google.android.exoplayer2.util.Util.fixSmoothStreamingIsmManifestUri(playbackProperties.uri);
        this.C = factory;
        this.J = parser;
        this.D = factory2;
        this.E = compositeSequenceableLoaderFactory;
        this.F = drmSessionManager;
        this.G = loadErrorHandlingPolicy;
        this.H = j;
        this.I = createEventDispatcher(null);
        this.y = ssManifest != null;
        this.K = new java.util.ArrayList<>();
    }

    public /* synthetic */ SsMediaSource(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser parser, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory2, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j, com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource.AnonymousClass1 anonymousClass1) {
        this(mediaItem, ssManifest, factory, parser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, j);
    }

    @java.lang.Deprecated
    public SsMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, int i, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(new com.google.android.exoplayer2.MediaItem.Builder().setUri(android.net.Uri.EMPTY).setMimeType("application/vnd.ms-sstr+xml").build(), ssManifest, null, null, factory, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), defpackage.z60.c(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i), 30000L);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public SsMediaSource(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(ssManifest, factory, 3, handler, mediaSourceEventListener);
    }

    public final void b() {
        com.google.android.exoplayer2.source.SinglePeriodTimeline singlePeriodTimeline;
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).f(this.Q);
        }
        long j = Long.MIN_VALUE;
        long j2 = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement : this.Q.streamElements) {
            if (streamElement.chunkCount > 0) {
                j2 = java.lang.Math.min(j2, streamElement.getStartTimeUs(0));
                j = java.lang.Math.max(j, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
            }
        }
        if (j2 == Long.MAX_VALUE) {
            long j3 = this.Q.isLive ? -9223372036854775807L : 0L;
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest = this.Q;
            boolean z = ssManifest.isLive;
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j3, 0L, 0L, 0L, true, z, z, (java.lang.Object) ssManifest, this.B);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest2 = this.Q;
            if (ssManifest2.isLive) {
                long j4 = ssManifest2.dvrWindowLengthUs;
                if (j4 != -9223372036854775807L && j4 > 0) {
                    j2 = java.lang.Math.max(j2, j - j4);
                }
                long j5 = j2;
                long j6 = j - j5;
                long msToUs = j6 - com.google.android.exoplayer2.C.msToUs(this.H);
                if (msToUs < 5000000) {
                    msToUs = java.lang.Math.min(5000000L, j6 / 2);
                }
                singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(-9223372036854775807L, j6, j5, msToUs, true, true, true, (java.lang.Object) this.Q, this.B);
            } else {
                long j7 = ssManifest2.durationUs;
                long j8 = j7 != -9223372036854775807L ? j7 : j - j2;
                singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j2 + j8, j8, j2, 0L, true, false, false, (java.lang.Object) this.Q, this.B);
            }
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    public final void c() {
        if (this.Q.isLive) {
            this.R.postDelayed(new defpackage.uq2(this), java.lang.Math.max(0L, (this.P + 5000) - android.os.SystemClock.elapsedRealtime()));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod ssMediaPeriod = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod(this.Q, this.D, this.O, this.E, this.F, createDrmEventDispatcher(mediaPeriodId), this.G, createEventDispatcher, this.N, allocator);
        this.K.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    public final void d() {
        if (this.M.hasFatalError()) {
            return;
        }
        com.google.android.exoplayer2.upstream.ParsingLoadable parsingLoadable = new com.google.android.exoplayer2.upstream.ParsingLoadable(this.L, this.z, 4, this.J);
        this.I.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.M.startLoading(parsingLoadable, this, this.G.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.B;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.A.tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        this.N.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parsingLoadable, long j, long j2, boolean z) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.G.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.I.loadCanceled(loadEventInfo, parsingLoadable.type);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parsingLoadable, long j, long j2) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.G.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.I.loadCompleted(loadEventInfo, parsingLoadable.type);
        this.Q = parsingLoadable.getResult();
        this.P = j - j2;
        b();
        c();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> parsingLoadable, long j, long j2, java.io.IOException iOException, int i) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        long retryDelayMsFor = this.G.getRetryDelayMsFor(new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(parsingLoadable.type), iOException, i));
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction createRetryAction = retryDelayMsFor == -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL : com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor);
        boolean z = !createRetryAction.isRetry();
        this.I.loadError(loadEventInfo, parsingLoadable.type, iOException, z);
        if (z) {
            this.G.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        }
        return createRetryAction;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.O = transferListener;
        this.F.prepare();
        if (this.y) {
            this.N = new com.google.android.exoplayer2.upstream.LoaderErrorThrower.Dummy();
            b();
            return;
        }
        this.L = this.C.createDataSource();
        com.google.android.exoplayer2.upstream.Loader loader = new com.google.android.exoplayer2.upstream.Loader("Loader:Manifest");
        this.M = loader;
        this.N = loader;
        this.R = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper();
        d();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod) mediaPeriod).e();
        this.K.remove(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.Q = this.y ? this.Q : null;
        this.L = null;
        this.P = 0L;
        com.google.android.exoplayer2.upstream.Loader loader = this.M;
        if (loader != null) {
            loader.release();
            this.M = null;
        }
        android.os.Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.R = null;
        }
        this.F.release();
    }
}
