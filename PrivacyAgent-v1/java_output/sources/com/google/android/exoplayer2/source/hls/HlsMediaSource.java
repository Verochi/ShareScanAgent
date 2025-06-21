package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class HlsMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource implements com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int METADATA_TYPE_EMSG = 3;
    public static final int METADATA_TYPE_ID3 = 1;
    public final com.google.android.exoplayer2.MediaItem.PlaybackProperties A;
    public final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory B;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory C;
    public final com.google.android.exoplayer2.drm.DrmSessionManager D;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy E;
    public final boolean F;
    public final int G;
    public final boolean H;
    public final com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker I;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.TransferListener J;
    public final com.google.android.exoplayer2.source.hls.HlsExtractorFactory y;
    public final com.google.android.exoplayer2.MediaItem z;

    public static final class Factory implements com.google.android.exoplayer2.source.MediaSourceFactory {
        public final com.google.android.exoplayer2.source.hls.HlsDataSourceFactory a;
        public final com.google.android.exoplayer2.source.MediaSourceDrmHelper b;
        public com.google.android.exoplayer2.source.hls.HlsExtractorFactory c;
        public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory d;
        public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory e;
        public com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory f;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.drm.DrmSessionManager g;
        public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy h;
        public boolean i;
        public int j;
        public boolean k;
        public java.util.List<com.google.android.exoplayer2.offline.StreamKey> l;

        @androidx.annotation.Nullable
        public java.lang.Object m;

        public Factory(com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory) {
            this.a = (com.google.android.exoplayer2.source.hls.HlsDataSourceFactory) com.google.android.exoplayer2.util.Assertions.checkNotNull(hlsDataSourceFactory);
            this.b = new com.google.android.exoplayer2.source.MediaSourceDrmHelper();
            this.d = new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory();
            this.e = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.FACTORY;
            this.c = com.google.android.exoplayer2.source.hls.HlsExtractorFactory.DEFAULT;
            this.h = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            this.f = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
            this.j = 1;
            this.l = java.util.Collections.emptyList();
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory(factory));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.hls.HlsMediaSource createMediaSource(android.net.Uri uri) {
            return createMediaSource(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setMimeType("application/x-mpegURL").build());
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.hls.HlsMediaSource createMediaSource(android.net.Uri uri, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.hls.HlsMediaSource createMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.hls.HlsMediaSource createMediaSource(com.google.android.exoplayer2.MediaItem mediaItem) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory = this.d;
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> list = mediaItem.playbackProperties.streamKeys.isEmpty() ? this.l : mediaItem.playbackProperties.streamKeys;
            if (!list.isEmpty()) {
                hlsPlaylistParserFactory = new com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list);
            }
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            boolean z = playbackProperties.tag == null && this.m != null;
            boolean z2 = playbackProperties.streamKeys.isEmpty() && !list.isEmpty();
            if (z && z2) {
                mediaItem = mediaItem.buildUpon().setTag(this.m).setStreamKeys(list).build();
            } else if (z) {
                mediaItem = mediaItem.buildUpon().setTag(this.m).build();
            } else if (z2) {
                mediaItem = mediaItem.buildUpon().setStreamKeys(list).build();
            }
            com.google.android.exoplayer2.MediaItem mediaItem2 = mediaItem;
            com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory = this.a;
            com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory = this.c;
            com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.f;
            com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager = this.g;
            if (drmSessionManager == null) {
                drmSessionManager = this.b.create(mediaItem2);
            }
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.h;
            return new com.google.android.exoplayer2.source.hls.HlsMediaSource(mediaItem2, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, this.e.createTracker(this.a, loadErrorHandlingPolicy, hlsPlaylistParserFactory), this.i, this.j, this.k, null);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setAllowChunklessPreparation(boolean z) {
            this.i = z;
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setCompositeSequenceableLoaderFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            if (compositeSequenceableLoaderFactory == null) {
                compositeSequenceableLoaderFactory = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
            }
            this.f = compositeSequenceableLoaderFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
            this.b.setDrmHttpDataSourceFactory(factory);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setDrmSessionManager(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
            this.g = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.MediaSourceFactory setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str) {
            this.b.setDrmUserAgent(str);
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setExtractorFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory) {
            if (hlsExtractorFactory == null) {
                hlsExtractorFactory = com.google.android.exoplayer2.source.hls.HlsExtractorFactory.DEFAULT;
            }
            this.c = hlsExtractorFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            }
            this.h = loadErrorHandlingPolicy;
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setMetadataType(int i) {
            this.j = i;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setMinLoadableRetryCount(int i) {
            this.h = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i);
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setPlaylistParserFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            if (hlsPlaylistParserFactory == null) {
                hlsPlaylistParserFactory = new com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory();
            }
            this.d = hlsPlaylistParserFactory;
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setPlaylistTrackerFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory factory) {
            if (factory == null) {
                factory = com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker.FACTORY;
            }
            this.e = factory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys(@androidx.annotation.Nullable java.util.List list) {
            return setStreamKeys((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setStreamKeys(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            if (list == null) {
                list = java.util.Collections.emptyList();
            }
            this.l = list;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.m = obj;
            return this;
        }

        public com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory setUseSessionKeys(boolean z) {
            this.k = z;
            return this;
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    public HlsMediaSource(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker hlsPlaylistTracker, boolean z, int i, boolean z2) {
        this.A = (com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        this.z = mediaItem;
        this.B = hlsDataSourceFactory;
        this.y = hlsExtractorFactory;
        this.C = compositeSequenceableLoaderFactory;
        this.D = drmSessionManager;
        this.E = loadErrorHandlingPolicy;
        this.I = hlsPlaylistTracker;
        this.F = z;
        this.G = i;
        this.H = z2;
    }

    public /* synthetic */ HlsMediaSource(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.source.hls.HlsDataSourceFactory hlsDataSourceFactory, com.google.android.exoplayer2.source.hls.HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker hlsPlaylistTracker, boolean z, int i, boolean z2, com.google.android.exoplayer2.source.hls.HlsMediaSource.AnonymousClass1 anonymousClass1) {
        this(mediaItem, hlsDataSourceFactory, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, hlsPlaylistTracker, z, i, z2);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        return new com.google.android.exoplayer2.source.hls.HlsMediaPeriod(this.y, this.I, this.B, this.J, this.D, createDrmEventDispatcher(mediaPeriodId), this.E, createEventDispatcher, allocator, this.C, this.F, this.G, this.H);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.z;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.A.tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        this.I.maybeThrowPrimaryPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void onPrimaryPlaylistRefreshed(com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist hlsMediaPlaylist) {
        com.google.android.exoplayer2.source.SinglePeriodTimeline singlePeriodTimeline;
        long j;
        long usToMs = hlsMediaPlaylist.hasProgramDateTime ? com.google.android.exoplayer2.C.usToMs(hlsMediaPlaylist.startTimeUs) : -9223372036854775807L;
        int i = hlsMediaPlaylist.playlistType;
        long j2 = (i == 2 || i == 1) ? usToMs : -9223372036854775807L;
        long j3 = hlsMediaPlaylist.startOffsetUs;
        com.google.android.exoplayer2.source.hls.HlsManifest hlsManifest = new com.google.android.exoplayer2.source.hls.HlsManifest((com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.I.getMasterPlaylist()), hlsMediaPlaylist);
        if (this.I.isLive()) {
            long initialStartTimeUs = hlsMediaPlaylist.startTimeUs - this.I.getInitialStartTimeUs();
            long j4 = hlsMediaPlaylist.hasEndTag ? initialStartTimeUs + hlsMediaPlaylist.durationUs : -9223372036854775807L;
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
            if (j3 != -9223372036854775807L) {
                j = j3;
            } else if (list.isEmpty()) {
                j = 0;
            } else {
                int max = java.lang.Math.max(0, list.size() - 3);
                long j5 = hlsMediaPlaylist.durationUs - (hlsMediaPlaylist.targetDurationUs * 2);
                while (max > 0 && list.get(max).relativeStartTimeUs > j5) {
                    max--;
                }
                j = list.get(max).relativeStartTimeUs;
            }
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j2, usToMs, -9223372036854775807L, j4, hlsMediaPlaylist.durationUs, initialStartTimeUs, j, true, !hlsMediaPlaylist.hasEndTag, true, (java.lang.Object) hlsManifest, this.z);
        } else {
            long j6 = j3 == -9223372036854775807L ? 0L : j3;
            long j7 = hlsMediaPlaylist.durationUs;
            singlePeriodTimeline = new com.google.android.exoplayer2.source.SinglePeriodTimeline(j2, usToMs, -9223372036854775807L, j7, j7, 0L, j6, true, false, false, (java.lang.Object) hlsManifest, this.z);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.J = transferListener;
        this.D.prepare();
        this.I.start(this.A.uri, createEventDispatcher(null), this);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.hls.HlsMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.I.stop();
        this.D.release();
    }
}
