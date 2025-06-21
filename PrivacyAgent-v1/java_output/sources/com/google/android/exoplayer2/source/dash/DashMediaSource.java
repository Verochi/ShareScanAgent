package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
public final class DashMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource {

    @java.lang.Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS = 30000;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;

    @java.lang.Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_PREFER_MANIFEST_MS = -1;
    public static final java.lang.String DUMMY_MEDIA_ID = "com.google.android.exoplayer2.source.dash.DashMediaSource";
    public final com.google.android.exoplayer2.source.dash.DashChunkSource.Factory A;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory B;
    public final com.google.android.exoplayer2.drm.DrmSessionManager C;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy D;
    public final long E;
    public final boolean F;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher G;
    public final com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> H;
    public final com.google.android.exoplayer2.source.dash.DashMediaSource.ManifestCallback I;
    public final java.lang.Object J;
    public final android.util.SparseArray<com.google.android.exoplayer2.source.dash.DashMediaPeriod> K;
    public final java.lang.Runnable L;
    public final java.lang.Runnable M;
    public final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback N;
    public final com.google.android.exoplayer2.upstream.LoaderErrorThrower O;
    public final com.google.android.exoplayer2.MediaItem P;
    public final com.google.android.exoplayer2.MediaItem.PlaybackProperties Q;
    public com.google.android.exoplayer2.upstream.DataSource R;
    public com.google.android.exoplayer2.upstream.Loader S;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.TransferListener T;
    public java.io.IOException U;
    public android.os.Handler V;
    public android.net.Uri W;
    public android.net.Uri X;
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest Y;
    public boolean Z;
    public long a0;
    public long b0;
    public long c0;
    public int d0;
    public long e0;
    public int f0;
    public final boolean y;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory z;

    /* renamed from: com.google.android.exoplayer2.source.dash.DashMediaSource$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.util.SntpClient.InitializationCallback {
        public AnonymousClass1() {
        }

        @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
        public void onInitializationFailed(java.io.IOException iOException) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.q(iOException);
        }

        @Override // com.google.android.exoplayer2.util.SntpClient.InitializationCallback
        public void onInitialized() {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.r(com.google.android.exoplayer2.util.SntpClient.getElapsedRealtimeOffsetMs());
        }
    }

    public static final class DashTimeline extends com.google.android.exoplayer2.Timeline {
        public final long a;
        public final long b;
        public final long c;
        public final int d;
        public final long e;
        public final long f;
        public final long g;
        public final com.google.android.exoplayer2.source.dash.manifest.DashManifest h;
        public final com.google.android.exoplayer2.MediaItem i;

        public DashTimeline(long j, long j2, long j3, int i, long j4, long j5, long j6, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.MediaItem mediaItem) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = i;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.h = dashManifest;
            this.i = mediaItem;
        }

        public static boolean b(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest) {
            return dashManifest.dynamic && dashManifest.minUpdatePeriodMs != -9223372036854775807L && dashManifest.durationMs == -9223372036854775807L;
        }

        public final long a(long j) {
            com.google.android.exoplayer2.source.dash.DashSegmentIndex index;
            long j2 = this.g;
            if (!b(this.h)) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.f) {
                    return -9223372036854775807L;
                }
            }
            long j3 = this.e + j2;
            long periodDurationUs = this.h.getPeriodDurationUs(0);
            int i = 0;
            while (i < this.h.getPeriodCount() - 1 && j3 >= periodDurationUs) {
                j3 -= periodDurationUs;
                i++;
                periodDurationUs = this.h.getPeriodDurationUs(i);
            }
            com.google.android.exoplayer2.source.dash.manifest.Period period = this.h.getPeriod(i);
            int adaptationSetIndex = period.getAdaptationSetIndex(2);
            return (adaptationSetIndex == -1 || (index = period.adaptationSets.get(adaptationSetIndex).representations.get(0).getIndex()) == null || index.getSegmentCount(periodDurationUs) == 0) ? j2 : (j2 + index.getTimeUs(index.getSegmentNum(j3, periodDurationUs))) - j3;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
            int intValue;
            if ((obj instanceof java.lang.Integer) && (intValue = ((java.lang.Integer) obj).intValue() - this.d) >= 0 && intValue < getPeriodCount()) {
                return intValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
            com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, getPeriodCount());
            return period.set(z ? this.h.getPeriod(i).id : null, z ? java.lang.Integer.valueOf(this.d + i) : null, 0, this.h.getPeriodDurationUs(i), com.google.android.exoplayer2.C.msToUs(this.h.getPeriod(i).startMs - this.h.getPeriod(0).startMs) - this.e);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.h.getPeriodCount();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i) {
            com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, getPeriodCount());
            return java.lang.Integer.valueOf(this.d + i);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
            com.google.android.exoplayer2.util.Assertions.checkIndex(i, 0, 1);
            long a = a(j);
            java.lang.Object obj = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID;
            com.google.android.exoplayer2.MediaItem mediaItem = this.i;
            com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest = this.h;
            return window.set(obj, mediaItem, dashManifest, this.a, this.b, this.c, true, b(dashManifest), this.h.dynamic, a, this.f, 0, getPeriodCount() - 1, this.e);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    public final class DefaultPlayerEmsgCallback implements com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback {
        public DefaultPlayerEmsgCallback() {
        }

        public /* synthetic */ DefaultPlayerEmsgCallback(com.google.android.exoplayer2.source.dash.DashMediaSource dashMediaSource, com.google.android.exoplayer2.source.dash.DashMediaSource.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestPublishTimeExpired(long j) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.j(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerEmsgCallback
        public void onDashManifestRefreshRequested() {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.k();
        }
    }

    public static final class Factory implements com.google.android.exoplayer2.source.MediaSourceFactory {
        public final com.google.android.exoplayer2.source.dash.DashChunkSource.Factory a;
        public final com.google.android.exoplayer2.source.MediaSourceDrmHelper b;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.upstream.DataSource.Factory c;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.drm.DrmSessionManager d;
        public com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory e;
        public com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy f;
        public long g;
        public boolean h;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> i;
        public java.util.List<com.google.android.exoplayer2.offline.StreamKey> j;

        @androidx.annotation.Nullable
        public java.lang.Object k;

        public Factory(com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory2) {
            this.a = (com.google.android.exoplayer2.source.dash.DashChunkSource.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
            this.c = factory2;
            this.b = new com.google.android.exoplayer2.source.MediaSourceDrmHelper();
            this.f = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            this.g = 30000L;
            this.e = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
            this.j = java.util.Collections.emptyList();
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.Factory(factory), factory);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(android.net.Uri uri) {
            return createMediaSource(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setMimeType("application/dash+xml").setTag(this.k).build());
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(android.net.Uri uri, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource = createMediaSource(uri);
            if (handler != null && mediaSourceEventListener != null) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(com.google.android.exoplayer2.MediaItem mediaItem) {
            com.google.android.exoplayer2.MediaItem mediaItem2 = mediaItem;
            com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem2.playbackProperties);
            com.google.android.exoplayer2.upstream.ParsingLoadable.Parser parser = this.i;
            if (parser == null) {
                parser = new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser();
            }
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> list = mediaItem2.playbackProperties.streamKeys.isEmpty() ? this.j : mediaItem2.playbackProperties.streamKeys;
            com.google.android.exoplayer2.upstream.ParsingLoadable.Parser filteringManifestParser = !list.isEmpty() ? new com.google.android.exoplayer2.offline.FilteringManifestParser(parser, list) : parser;
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem2.playbackProperties;
            boolean z = playbackProperties.tag == null && this.k != null;
            boolean z2 = playbackProperties.streamKeys.isEmpty() && !list.isEmpty();
            if (z && z2) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.k).setStreamKeys(list).build();
            } else if (z) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.k).build();
            } else if (z2) {
                mediaItem2 = mediaItem.buildUpon().setStreamKeys(list).build();
            }
            com.google.android.exoplayer2.MediaItem mediaItem3 = mediaItem2;
            com.google.android.exoplayer2.upstream.DataSource.Factory factory = this.c;
            com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2 = this.a;
            com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.e;
            com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager = this.d;
            if (drmSessionManager == null) {
                drmSessionManager = this.b.create(mediaItem3);
            }
            return new com.google.android.exoplayer2.source.dash.DashMediaSource(mediaItem3, null, factory, filteringManifestParser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, this.f, this.g, this.h, null);
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest) {
            return createMediaSource(dashManifest, new com.google.android.exoplayer2.MediaItem.Builder().setUri(android.net.Uri.EMPTY).setMediaId(com.google.android.exoplayer2.source.dash.DashMediaSource.DUMMY_MEDIA_ID).setMimeType("application/dash+xml").setStreamKeys(this.j).setTag(this.k).build());
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
            com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource = createMediaSource(dashManifest);
            if (handler != null && mediaSourceEventListener != null) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource createMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.MediaItem mediaItem) {
            com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest2 = dashManifest;
            com.google.android.exoplayer2.util.Assertions.checkArgument(!dashManifest2.dynamic);
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> list = (playbackProperties == null || playbackProperties.streamKeys.isEmpty()) ? this.j : mediaItem.playbackProperties.streamKeys;
            if (!list.isEmpty()) {
                dashManifest2 = dashManifest2.copy(list);
            }
            com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest3 = dashManifest2;
            com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties2 = mediaItem.playbackProperties;
            boolean z = playbackProperties2 != null;
            com.google.android.exoplayer2.MediaItem build = mediaItem.buildUpon().setMimeType("application/dash+xml").setUri(z ? mediaItem.playbackProperties.uri : android.net.Uri.EMPTY).setTag(z && playbackProperties2.tag != null ? mediaItem.playbackProperties.tag : this.k).setStreamKeys(list).build();
            com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory = this.a;
            com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.e;
            com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager = this.d;
            if (drmSessionManager == null) {
                drmSessionManager = this.b.create(build);
            }
            return new com.google.android.exoplayer2.source.dash.DashMediaSource(build, dashManifest3, null, null, factory, compositeSequenceableLoaderFactory, drmSessionManager, this.f, this.g, this.h, null);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{0};
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setCompositeSequenceableLoaderFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            if (compositeSequenceableLoaderFactory == null) {
                compositeSequenceableLoaderFactory = new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory();
            }
            this.e = compositeSequenceableLoaderFactory;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setDrmHttpDataSourceFactory(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.HttpDataSource.Factory factory) {
            this.b.setDrmHttpDataSourceFactory(factory);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setDrmSessionManager(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
            this.d = drmSessionManager;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setDrmUserAgent(@androidx.annotation.Nullable java.lang.String str) {
            this.b.setDrmUserAgent(str);
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setLivePresentationDelayMs(long j) {
            return j == -1 ? setLivePresentationDelayMs(30000L, false) : setLivePresentationDelayMs(j, true);
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setLivePresentationDelayMs(long j, boolean z) {
            this.g = j;
            this.h = z;
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setLoadErrorHandlingPolicy(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy();
            }
            this.f = loadErrorHandlingPolicy;
            return this;
        }

        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setManifestParser(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> parser) {
            this.i = parser;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setMinLoadableRetryCount(int i) {
            return setLoadErrorHandlingPolicy((com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy) new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i));
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys(@androidx.annotation.Nullable java.util.List list) {
            return setStreamKeys((java.util.List<com.google.android.exoplayer2.offline.StreamKey>) list);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceFactory
        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setStreamKeys(@androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
            if (list == null) {
                list = java.util.Collections.emptyList();
            }
            this.j = list;
            return this;
        }

        @java.lang.Deprecated
        public com.google.android.exoplayer2.source.dash.DashMediaSource.Factory setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.k = obj;
            return this;
        }
    }

    public static final class Iso8601Parser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<java.lang.Long> {
        public static final java.util.regex.Pattern n = java.util.regex.Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Long parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
            java.lang.String readLine = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, com.google.common.base.Charsets.UTF_8)).readLine();
            try {
                java.util.regex.Matcher matcher = n.matcher(readLine);
                if (!matcher.matches()) {
                    java.lang.String valueOf = java.lang.String.valueOf(readLine);
                    throw new com.google.android.exoplayer2.ParserException(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new java.lang.String("Couldn't parse timestamp: "));
                }
                java.lang.String group = matcher.group(1);
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(org.apache.tools.ant.util.DateUtils.ISO8601_DATETIME_PATTERN, java.util.Locale.US);
                simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long parseLong = java.lang.Long.parseLong(matcher.group(5));
                    java.lang.String group2 = matcher.group(7);
                    time -= j * ((((parseLong * 60) + (android.text.TextUtils.isEmpty(group2) ? 0L : java.lang.Long.parseLong(group2))) * 60) * 1000);
                }
                return java.lang.Long.valueOf(time);
            } catch (java.text.ParseException e) {
                throw new com.google.android.exoplayer2.ParserException(e);
            }
        }
    }

    public final class ManifestCallback implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest>> {
        public ManifestCallback() {
        }

        public /* synthetic */ ManifestCallback(com.google.android.exoplayer2.source.dash.DashMediaSource dashMediaSource, com.google.android.exoplayer2.source.dash.DashMediaSource.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j, long j2, boolean z) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.l(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j, long j2) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.m(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j, long j2, java.io.IOException iOException, int i) {
            return com.google.android.exoplayer2.source.dash.DashMediaSource.this.n(parsingLoadable, j, j2, iOException, i);
        }
    }

    public final class ManifestLoadErrorThrower implements com.google.android.exoplayer2.upstream.LoaderErrorThrower {
        public ManifestLoadErrorThrower() {
        }

        public final void a() throws java.io.IOException {
            if (com.google.android.exoplayer2.source.dash.DashMediaSource.this.U != null) {
                throw com.google.android.exoplayer2.source.dash.DashMediaSource.this.U;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() throws java.io.IOException {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.S.maybeThrowError();
            a();
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i) throws java.io.IOException {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.S.maybeThrowError(i);
            a();
        }
    }

    public static final class PeriodSeekInfo {
        public final boolean a;
        public final long b;
        public final long c;

        public PeriodSeekInfo(boolean z, long j, long j2) {
            this.a = z;
            this.b = j;
            this.c = j2;
        }

        public static com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo a(com.google.android.exoplayer2.source.dash.manifest.Period period, long j) {
            boolean z;
            boolean z2;
            long j2;
            int size = period.adaptationSets.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = period.adaptationSets.get(i2).type;
                if (i3 == 1 || i3 == 2) {
                    z = true;
                    break;
                }
            }
            z = false;
            long j3 = Long.MAX_VALUE;
            int i4 = 0;
            boolean z3 = false;
            long j4 = 0;
            boolean z4 = false;
            while (i4 < size) {
                com.google.android.exoplayer2.source.dash.manifest.AdaptationSet adaptationSet = period.adaptationSets.get(i4);
                if (!z || adaptationSet.type != 3) {
                    com.google.android.exoplayer2.source.dash.DashSegmentIndex index = adaptationSet.representations.get(i).getIndex();
                    if (index == null) {
                        return new com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo(true, 0L, j);
                    }
                    z3 |= index.isExplicit();
                    int segmentCount = index.getSegmentCount(j);
                    if (segmentCount == 0) {
                        z2 = z;
                        j2 = 0;
                        j4 = 0;
                        z4 = true;
                    } else if (!z4) {
                        z2 = z;
                        long firstSegmentNum = index.getFirstSegmentNum();
                        long j5 = j3;
                        j4 = java.lang.Math.max(j4, index.getTimeUs(firstSegmentNum));
                        if (segmentCount != -1) {
                            long j6 = (firstSegmentNum + segmentCount) - 1;
                            j2 = java.lang.Math.min(j5, index.getTimeUs(j6) + index.getDurationUs(j6, j));
                        } else {
                            j2 = j5;
                        }
                    }
                    i4++;
                    j3 = j2;
                    z = z2;
                    i = 0;
                }
                z2 = z;
                j2 = j3;
                i4++;
                j3 = j2;
                z = z2;
                i = 0;
            }
            return new com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo(z3, j4, j3);
        }
    }

    public final class UtcTimestampCallback implements com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long>> {
        public UtcTimestampCallback() {
        }

        public /* synthetic */ UtcTimestampCallback(com.google.android.exoplayer2.source.dash.DashMediaSource dashMediaSource, com.google.android.exoplayer2.source.dash.DashMediaSource.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadCanceled(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j, long j2, boolean z) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.l(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j, long j2) {
            com.google.android.exoplayer2.source.dash.DashMediaSource.this.o(parsingLoadable, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j, long j2, java.io.IOException iOException, int i) {
            return com.google.android.exoplayer2.source.dash.DashMediaSource.this.p(parsingLoadable, j, j2, iOException);
        }
    }

    public static final class XsDateTimeParser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<java.lang.Long> {
        public XsDateTimeParser() {
        }

        public /* synthetic */ XsDateTimeParser(com.google.android.exoplayer2.source.dash.DashMediaSource.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Long parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
            return java.lang.Long.valueOf(com.google.android.exoplayer2.util.Util.parseXsDateTime(new java.io.BufferedReader(new java.io.InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    @java.lang.Deprecated
    public DashMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, int i, long j, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser(), factory2, i, j, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public DashMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, factory2, 3, -1L, handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public DashMediaSource(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> parser, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, int i, long j, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(new com.google.android.exoplayer2.MediaItem.Builder().setUri(uri).setMimeType("application/dash+xml").build(), null, factory, parser, factory2, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), defpackage.z60.c(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i), j == -1 ? 30000L : j, j != -1);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    public DashMediaSource(com.google.android.exoplayer2.MediaItem mediaItem, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.DataSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<? extends com.google.android.exoplayer2.source.dash.manifest.DashManifest> parser, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j, boolean z) {
        this.P = mediaItem;
        com.google.android.exoplayer2.MediaItem.PlaybackProperties playbackProperties = (com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaItem.playbackProperties);
        this.Q = playbackProperties;
        android.net.Uri uri = playbackProperties.uri;
        this.W = uri;
        this.X = uri;
        this.Y = dashManifest;
        this.z = factory;
        this.H = parser;
        this.A = factory2;
        this.C = drmSessionManager;
        this.D = loadErrorHandlingPolicy;
        this.E = j;
        this.F = z;
        this.B = compositeSequenceableLoaderFactory;
        boolean z2 = dashManifest != null;
        this.y = z2;
        this.G = createEventDispatcher(null);
        this.J = new java.lang.Object();
        this.K = new android.util.SparseArray<>();
        this.N = new com.google.android.exoplayer2.source.dash.DashMediaSource.DefaultPlayerEmsgCallback(this, null);
        this.e0 = -9223372036854775807L;
        this.c0 = -9223372036854775807L;
        if (!z2) {
            this.I = new com.google.android.exoplayer2.source.dash.DashMediaSource.ManifestCallback(this, null);
            this.O = new com.google.android.exoplayer2.source.dash.DashMediaSource.ManifestLoadErrorThrower();
            this.L = new defpackage.wv(this);
            this.M = new defpackage.xv(this);
            return;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(true ^ dashManifest.dynamic);
        this.I = null;
        this.L = null;
        this.M = null;
        this.O = new com.google.android.exoplayer2.upstream.LoaderErrorThrower.Dummy();
    }

    public /* synthetic */ DashMediaSource(com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.upstream.DataSource.Factory factory, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser parser, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory2, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j, boolean z, com.google.android.exoplayer2.source.dash.DashMediaSource.AnonymousClass1 anonymousClass1) {
        this(mediaItem, dashManifest, factory, parser, factory2, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, j, z);
    }

    @java.lang.Deprecated
    public DashMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, int i, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(new com.google.android.exoplayer2.MediaItem.Builder().setMediaId(DUMMY_MEDIA_ID).setMimeType("application/dash+xml").setUri(android.net.Uri.EMPTY).build(), dashManifest, null, null, factory, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), defpackage.z60.c(), new com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy(i), 30000L, false);
        if (handler == null || mediaSourceEventListener == null) {
            return;
        }
        addEventListener(handler, mediaSourceEventListener);
    }

    @java.lang.Deprecated
    public DashMediaSource(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, com.google.android.exoplayer2.source.dash.DashChunkSource.Factory factory, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.source.MediaSourceEventListener mediaSourceEventListener) {
        this(dashManifest, factory, 3, handler, mediaSourceEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        s(false);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        int intValue = ((java.lang.Integer) mediaPeriodId.periodUid).intValue() - this.f0;
        com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId, this.Y.getPeriod(intValue).startMs);
        com.google.android.exoplayer2.source.dash.DashMediaPeriod dashMediaPeriod = new com.google.android.exoplayer2.source.dash.DashMediaPeriod(this.f0 + intValue, this.Y, intValue, this.A, this.T, this.C, createDrmEventDispatcher(mediaPeriodId), this.D, createEventDispatcher, this.c0, this.O, allocator, this.B, this.N);
        this.K.put(dashMediaPeriod.n, dashMediaPeriod);
        return dashMediaPeriod;
    }

    public final long g() {
        return java.lang.Math.min((this.d0 - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.P;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.Q.tag;
    }

    public final void i() {
        com.google.android.exoplayer2.util.SntpClient.initialize(this.S, new com.google.android.exoplayer2.source.dash.DashMediaSource.AnonymousClass1());
    }

    public void j(long j) {
        long j2 = this.e0;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.e0 = j;
        }
    }

    public void k() {
        this.V.removeCallbacks(this.M);
        y();
    }

    public void l(com.google.android.exoplayer2.upstream.ParsingLoadable<?> parsingLoadable, long j, long j2) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.D.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.G.loadCanceled(loadEventInfo, parsingLoadable.type);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j, long j2) {
        boolean z;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.D.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.G.loadCompleted(loadEventInfo, parsingLoadable.type);
        com.google.android.exoplayer2.source.dash.manifest.DashManifest result = parsingLoadable.getResult();
        com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest = this.Y;
        int periodCount = dashManifest == null ? 0 : dashManifest.getPeriodCount();
        long j3 = result.getPeriod(0).startMs;
        int i = 0;
        while (i < periodCount && this.Y.getPeriod(i).startMs < j3) {
            i++;
        }
        if (result.dynamic) {
            if (periodCount - i > result.getPeriodCount()) {
                com.google.android.exoplayer2.util.Log.w("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j4 = this.e0;
                if (j4 != -9223372036854775807L) {
                    long j5 = result.publishTimeMs;
                    if (1000 * j5 <= j4) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder(73);
                        sb.append("Loaded stale dynamic manifest: ");
                        sb.append(j5);
                        sb.append(", ");
                        sb.append(j4);
                        com.google.android.exoplayer2.util.Log.w("DashMediaSource", sb.toString());
                    }
                }
                z = false;
                if (!z) {
                    int i2 = this.d0;
                    this.d0 = i2 + 1;
                    if (i2 < this.D.getMinimumLoadableRetryCount(parsingLoadable.type)) {
                        w(g());
                        return;
                    } else {
                        this.U = new com.google.android.exoplayer2.source.dash.DashManifestStaleException();
                        return;
                    }
                }
                this.d0 = 0;
            }
            z = true;
            if (!z) {
            }
        }
        this.Y = result;
        this.Z = result.dynamic & this.Z;
        this.a0 = j - j2;
        this.b0 = j;
        synchronized (this.J) {
            if (parsingLoadable.dataSpec.uri == this.W) {
                android.net.Uri uri = this.Y.location;
                if (uri == null) {
                    uri = parsingLoadable.getUri();
                }
                this.W = uri;
            }
        }
        if (periodCount != 0) {
            this.f0 += i;
            s(true);
            return;
        }
        com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest2 = this.Y;
        if (!dashManifest2.dynamic) {
            s(true);
            return;
        }
        com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement = dashManifest2.utcTiming;
        if (utcTimingElement != null) {
            t(utcTimingElement);
        } else {
            i();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        this.O.maybeThrowError();
    }

    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction n(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> parsingLoadable, long j, long j2, java.io.IOException iOException, int i) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        long retryDelayMsFor = this.D.getRetryDelayMsFor(new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(parsingLoadable.type), iOException, i));
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction createRetryAction = retryDelayMsFor == -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL : com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor);
        boolean z = !createRetryAction.isRetry();
        this.G.loadError(loadEventInfo, parsingLoadable.type, iOException, z);
        if (z) {
            this.D.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        }
        return createRetryAction;
    }

    public void o(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j, long j2) {
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
        this.D.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        this.G.loadCompleted(loadEventInfo, parsingLoadable.type);
        r(parsingLoadable.getResult().longValue() - j);
    }

    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction p(com.google.android.exoplayer2.upstream.ParsingLoadable<java.lang.Long> parsingLoadable, long j, long j2, java.io.IOException iOException) {
        this.G.loadError(new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded()), parsingLoadable.type, iOException, true);
        this.D.onLoadTaskConcluded(parsingLoadable.loadTaskId);
        q(iOException);
        return com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.T = transferListener;
        this.C.prepare();
        if (this.y) {
            s(false);
            return;
        }
        this.R = this.z.createDataSource();
        this.S = new com.google.android.exoplayer2.upstream.Loader("Loader:DashMediaSource");
        this.V = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper();
        y();
    }

    public final void q(java.io.IOException iOException) {
        com.google.android.exoplayer2.util.Log.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        s(true);
    }

    public final void r(long j) {
        this.c0 = j;
        s(true);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.dash.DashMediaPeriod dashMediaPeriod = (com.google.android.exoplayer2.source.dash.DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.q();
        this.K.remove(dashMediaPeriod.n);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.Z = false;
        this.R = null;
        com.google.android.exoplayer2.upstream.Loader loader = this.S;
        if (loader != null) {
            loader.release();
            this.S = null;
        }
        this.a0 = 0L;
        this.b0 = 0L;
        this.Y = this.y ? this.Y : null;
        this.W = this.X;
        this.U = null;
        android.os.Handler handler = this.V;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.V = null;
        }
        this.c0 = -9223372036854775807L;
        this.d0 = 0;
        this.e0 = -9223372036854775807L;
        this.f0 = 0;
        this.K.clear();
        this.C.release();
    }

    public void replaceManifestUri(android.net.Uri uri) {
        synchronized (this.J) {
            this.W = uri;
            this.X = uri;
        }
    }

    public final void s(boolean z) {
        long j;
        boolean z2;
        long j2;
        for (int i = 0; i < this.K.size(); i++) {
            int keyAt = this.K.keyAt(i);
            if (keyAt >= this.f0) {
                this.K.valueAt(i).u(this.Y, keyAt - this.f0);
            }
        }
        int periodCount = this.Y.getPeriodCount() - 1;
        com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo a = com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo.a(this.Y.getPeriod(0), this.Y.getPeriodDurationUs(0));
        com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo a2 = com.google.android.exoplayer2.source.dash.DashMediaSource.PeriodSeekInfo.a(this.Y.getPeriod(periodCount), this.Y.getPeriodDurationUs(periodCount));
        long j3 = a.b;
        long j4 = a2.c;
        if (!this.Y.dynamic || a2.a) {
            j = j3;
            z2 = false;
        } else {
            j4 = java.lang.Math.min((com.google.android.exoplayer2.C.msToUs(com.google.android.exoplayer2.util.Util.getNowUnixTimeMs(this.c0)) - com.google.android.exoplayer2.C.msToUs(this.Y.availabilityStartTimeMs)) - com.google.android.exoplayer2.C.msToUs(this.Y.getPeriod(periodCount).startMs), j4);
            long j5 = this.Y.timeShiftBufferDepthMs;
            if (j5 != -9223372036854775807L) {
                long msToUs = j4 - com.google.android.exoplayer2.C.msToUs(j5);
                while (msToUs < 0 && periodCount > 0) {
                    periodCount--;
                    msToUs += this.Y.getPeriodDurationUs(periodCount);
                }
                j3 = periodCount == 0 ? java.lang.Math.max(j3, msToUs) : this.Y.getPeriodDurationUs(0);
            }
            j = j3;
            z2 = true;
        }
        long j6 = j4 - j;
        for (int i2 = 0; i2 < this.Y.getPeriodCount() - 1; i2++) {
            j6 += this.Y.getPeriodDurationUs(i2);
        }
        com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest = this.Y;
        if (dashManifest.dynamic) {
            long j7 = this.E;
            if (!this.F) {
                long j8 = dashManifest.suggestedPresentationDelayMs;
                if (j8 != -9223372036854775807L) {
                    j7 = j8;
                }
            }
            long msToUs2 = j6 - com.google.android.exoplayer2.C.msToUs(j7);
            if (msToUs2 < 5000000) {
                msToUs2 = java.lang.Math.min(5000000L, j6 / 2);
            }
            j2 = msToUs2;
        } else {
            j2 = 0;
        }
        com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest2 = this.Y;
        long j9 = dashManifest2.availabilityStartTimeMs;
        long usToMs = j9 != -9223372036854775807L ? j9 + dashManifest2.getPeriod(0).startMs + com.google.android.exoplayer2.C.usToMs(j) : -9223372036854775807L;
        com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest3 = this.Y;
        refreshSourceInfo(new com.google.android.exoplayer2.source.dash.DashMediaSource.DashTimeline(dashManifest3.availabilityStartTimeMs, usToMs, this.c0, this.f0, j, j6, j2, dashManifest3, this.P));
        if (this.y) {
            return;
        }
        this.V.removeCallbacks(this.M);
        if (z2) {
            this.V.postDelayed(this.M, 5000L);
        }
        if (this.Z) {
            y();
            return;
        }
        if (z) {
            com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest4 = this.Y;
            if (dashManifest4.dynamic) {
                long j10 = dashManifest4.minUpdatePeriodMs;
                if (j10 != -9223372036854775807L) {
                    w(java.lang.Math.max(0L, (this.a0 + (j10 != 0 ? j10 : 5000L)) - android.os.SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    public final void t(com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement) {
        java.lang.String str = utcTimingElement.schemeIdUri;
        if (com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") || com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            u(utcTimingElement);
            return;
        }
        if (com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") || com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            v(utcTimingElement, new com.google.android.exoplayer2.source.dash.DashMediaSource.Iso8601Parser());
            return;
        }
        if (com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") || com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            v(utcTimingElement, new com.google.android.exoplayer2.source.dash.DashMediaSource.XsDateTimeParser(null));
        } else if (com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2014") || com.google.android.exoplayer2.util.Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2012")) {
            i();
        } else {
            q(new java.io.IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void u(com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement) {
        try {
            r(com.google.android.exoplayer2.util.Util.parseXsDateTime(utcTimingElement.value) - this.b0);
        } catch (com.google.android.exoplayer2.ParserException e) {
            q(e);
        }
    }

    public final void v(com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<java.lang.Long> parser) {
        x(new com.google.android.exoplayer2.upstream.ParsingLoadable(this.R, android.net.Uri.parse(utcTimingElement.value), 5, parser), new com.google.android.exoplayer2.source.dash.DashMediaSource.UtcTimestampCallback(this, null), 1);
    }

    public final void w(long j) {
        this.V.postDelayed(this.L, j);
    }

    public final <T> void x(com.google.android.exoplayer2.upstream.ParsingLoadable<T> parsingLoadable, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.upstream.ParsingLoadable<T>> callback, int i) {
        this.G.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.S.startLoading(parsingLoadable, callback, i)), parsingLoadable.type);
    }

    public final void y() {
        android.net.Uri uri;
        this.V.removeCallbacks(this.L);
        if (this.S.hasFatalError()) {
            return;
        }
        if (this.S.isLoading()) {
            this.Z = true;
            return;
        }
        synchronized (this.J) {
            uri = this.W;
        }
        this.Z = false;
        x(new com.google.android.exoplayer2.upstream.ParsingLoadable(this.R, uri, 4, this.H), this.I, this.D.getMinimumLoadableRetryCount(4));
    }
}
