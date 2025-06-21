package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
final class ProgressiveMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.extractor.ExtractorOutput, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable>, com.google.android.exoplayer2.upstream.Loader.ReleaseCallback, com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener {
    public static final java.util.Map<java.lang.String, java.lang.String> e0 = p();
    public static final com.google.android.exoplayer2.Format f0 = new com.google.android.exoplayer2.Format.Builder().setId("icy").setSampleMimeType(com.google.android.exoplayer2.util.MimeTypes.APPLICATION_ICY).build();

    @androidx.annotation.Nullable
    public final java.lang.String A;
    public final long B;
    public final com.google.android.exoplayer2.source.ProgressiveMediaExtractor D;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod.Callback I;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.icy.IcyHeaders J;
    public boolean M;
    public boolean N;
    public boolean O;
    public com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackState P;
    public com.google.android.exoplayer2.extractor.SeekMap Q;
    public boolean S;
    public boolean U;
    public boolean V;
    public int W;
    public long Y;
    public boolean a0;
    public int b0;
    public boolean c0;
    public boolean d0;
    public final android.net.Uri n;
    public final com.google.android.exoplayer2.upstream.DataSource t;
    public final com.google.android.exoplayer2.drm.DrmSessionManager u;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy v;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher w;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher x;
    public final com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener y;
    public final com.google.android.exoplayer2.upstream.Allocator z;
    public final com.google.android.exoplayer2.upstream.Loader C = new com.google.android.exoplayer2.upstream.Loader("Loader:ProgressiveMediaPeriod");
    public final com.google.android.exoplayer2.util.ConditionVariable E = new com.google.android.exoplayer2.util.ConditionVariable();
    public final java.lang.Runnable F = new com.google.android.exoplayer2.source.a(this);
    public final java.lang.Runnable G = new com.google.android.exoplayer2.source.b(this);
    public final android.os.Handler H = com.google.android.exoplayer2.util.Util.createHandlerForCurrentLooper();
    public com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId[] L = new com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId[0];
    public com.google.android.exoplayer2.source.SampleQueue[] K = new com.google.android.exoplayer2.source.SampleQueue[0];
    public long Z = -9223372036854775807L;
    public long X = -1;
    public long R = -9223372036854775807L;
    public int T = 1;

    public final class ExtractingLoadable implements com.google.android.exoplayer2.upstream.Loader.Loadable, com.google.android.exoplayer2.source.IcyDataSource.Listener {
        public final android.net.Uri b;
        public final com.google.android.exoplayer2.upstream.StatsDataSource c;
        public final com.google.android.exoplayer2.source.ProgressiveMediaExtractor d;
        public final com.google.android.exoplayer2.extractor.ExtractorOutput e;
        public final com.google.android.exoplayer2.util.ConditionVariable f;
        public volatile boolean h;
        public long j;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.extractor.TrackOutput m;
        public boolean n;
        public final com.google.android.exoplayer2.extractor.PositionHolder g = new com.google.android.exoplayer2.extractor.PositionHolder();
        public boolean i = true;
        public long l = -1;
        public final long a = com.google.android.exoplayer2.source.LoadEventInfo.getNewId();
        public com.google.android.exoplayer2.upstream.DataSpec k = g(0);

        public ExtractingLoadable(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.source.ProgressiveMediaExtractor progressiveMediaExtractor, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.util.ConditionVariable conditionVariable) {
            this.b = uri;
            this.c = new com.google.android.exoplayer2.upstream.StatsDataSource(dataSource);
            this.d = progressiveMediaExtractor;
            this.e = extractorOutput;
            this.f = conditionVariable;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.h = true;
        }

        public final com.google.android.exoplayer2.upstream.DataSpec g(long j) {
            return new com.google.android.exoplayer2.upstream.DataSpec.Builder().setUri(this.b).setPosition(j).setKey(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.A).setFlags(6).setHttpRequestHeaders(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.e0).build();
        }

        public final void h(long j, long j2) {
            this.g.position = j;
            this.j = j2;
            this.i = true;
            this.n = false;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws java.io.IOException {
            int i = 0;
            while (i == 0 && !this.h) {
                try {
                    long j = this.g.position;
                    com.google.android.exoplayer2.upstream.DataSpec g = g(j);
                    this.k = g;
                    long open = this.c.open(g);
                    this.l = open;
                    if (open != -1) {
                        this.l = open + j;
                    }
                    com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.J = com.google.android.exoplayer2.metadata.icy.IcyHeaders.parse(this.c.getResponseHeaders());
                    com.google.android.exoplayer2.upstream.DataReader dataReader = this.c;
                    if (com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.J != null && com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.J.metadataInterval != -1) {
                        dataReader = new com.google.android.exoplayer2.source.IcyDataSource(this.c, com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.J.metadataInterval, this);
                        com.google.android.exoplayer2.extractor.TrackOutput s2 = com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.s();
                        this.m = s2;
                        s2.format(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.f0);
                    }
                    long j2 = j;
                    this.d.d(dataReader, this.b, this.c.getResponseHeaders(), j, this.l, this.e);
                    if (com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.J != null) {
                        this.d.c();
                    }
                    if (this.i) {
                        this.d.seek(j2, this.j);
                        this.i = false;
                    }
                    while (true) {
                        long j3 = j2;
                        while (i == 0 && !this.h) {
                            try {
                                this.f.block();
                                i = this.d.a(this.g);
                                j2 = this.d.b();
                                if (j2 > com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.B + j3) {
                                    break;
                                }
                            } catch (java.lang.InterruptedException unused) {
                                throw new java.io.InterruptedIOException();
                            }
                        }
                        this.f.close();
                        com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.H.post(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.G);
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.d.b() != -1) {
                        this.g.position = this.d.b();
                    }
                    com.google.android.exoplayer2.util.Util.closeQuietly(this.c);
                } catch (java.lang.Throwable th) {
                    if (i != 1 && this.d.b() != -1) {
                        this.g.position = this.d.b();
                    }
                    com.google.android.exoplayer2.util.Util.closeQuietly(this.c);
                    throw th;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.IcyDataSource.Listener
        public void onIcyMetadata(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            long max = !this.n ? this.j : java.lang.Math.max(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.r(), this.j);
            int bytesLeft = parsableByteArray.bytesLeft();
            com.google.android.exoplayer2.extractor.TrackOutput trackOutput = (com.google.android.exoplayer2.extractor.TrackOutput) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.m);
            trackOutput.sampleData(parsableByteArray, bytesLeft);
            trackOutput.sampleMetadata(max, 1, bytesLeft, 0, null);
            this.n = true;
        }
    }

    public interface Listener {
        void onSourceInfoRefreshed(long j, boolean z, boolean z2);
    }

    public final class SampleStreamImpl implements com.google.android.exoplayer2.source.SampleStream {
        public final int n;

        public SampleStreamImpl(int i) {
            this.n = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.u(this.n);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws java.io.IOException {
            com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.B(this.n);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
            return com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.G(this.n, formatHolder, decoderInputBuffer, z);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            return com.google.android.exoplayer2.source.ProgressiveMediaPeriod.this.K(this.n, j);
        }
    }

    public static final class TrackId {
        public final int a;
        public final boolean b;

        public TrackId(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId trackId = (com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId) obj;
            return this.a == trackId.a && this.b == trackId.b;
        }

        public int hashCode() {
            return (this.a * 31) + (this.b ? 1 : 0);
        }
    }

    public static final class TrackState {
        public final com.google.android.exoplayer2.source.TrackGroupArray a;
        public final boolean[] b;
        public final boolean[] c;
        public final boolean[] d;

        public TrackState(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.a = trackGroupArray;
            this.b = zArr;
            int i = trackGroupArray.length;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    public ProgressiveMediaPeriod(android.net.Uri uri, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.extractor.ExtractorsFactory extractorsFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher2, com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener listener, com.google.android.exoplayer2.upstream.Allocator allocator, @androidx.annotation.Nullable java.lang.String str, int i) {
        this.n = uri;
        this.t = dataSource;
        this.u = drmSessionManager;
        this.x = eventDispatcher;
        this.v = loadErrorHandlingPolicy;
        this.w = eventDispatcher2;
        this.y = listener;
        this.z = allocator;
        this.A = str;
        this.B = i;
        this.D = new com.google.android.exoplayer2.source.BundledExtractorsAdapter(extractorsFactory);
    }

    public static java.util.Map<java.lang.String, java.lang.String> p() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.google.android.exoplayer2.metadata.icy.IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        return java.util.Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        if (this.d0) {
            return;
        }
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.I)).onContinueLoadingRequested(this);
    }

    public void A() throws java.io.IOException {
        this.C.maybeThrowError(this.v.getMinimumLoadableRetryCount(this.T));
    }

    public void B(int i) throws java.io.IOException {
        this.K[i].maybeThrowError();
        A();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onLoadCanceled(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable, long j, long j2, boolean z) {
        com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = extractingLoadable.c;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(extractingLoadable.a, extractingLoadable.k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        this.v.onLoadTaskConcluded(extractingLoadable.a);
        this.w.loadCanceled(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.j, this.R);
        if (z) {
            return;
        }
        o(extractingLoadable);
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
            sampleQueue.reset();
        }
        if (this.W > 0) {
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.I)).onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onLoadCompleted(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable, long j, long j2) {
        com.google.android.exoplayer2.extractor.SeekMap seekMap;
        if (this.R == -9223372036854775807L && (seekMap = this.Q) != null) {
            boolean isSeekable = seekMap.isSeekable();
            long r = r();
            long j3 = r == Long.MIN_VALUE ? 0L : r + 10000;
            this.R = j3;
            this.y.onSourceInfoRefreshed(j3, isSeekable, this.S);
        }
        com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = extractingLoadable.c;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(extractingLoadable.a, extractingLoadable.k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        this.v.onLoadTaskConcluded(extractingLoadable.a);
        this.w.loadCompleted(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.j, this.R);
        o(extractingLoadable);
        this.c0 = true;
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.I)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable, long j, long j2, java.io.IOException iOException, int i) {
        boolean z;
        com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable2;
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction createRetryAction;
        o(extractingLoadable);
        com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = extractingLoadable.c;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(extractingLoadable.a, extractingLoadable.k, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        long retryDelayMsFor = this.v.getRetryDelayMsFor(new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(1, -1, null, 0, null, com.google.android.exoplayer2.C.usToMs(extractingLoadable.j), com.google.android.exoplayer2.C.usToMs(this.R)), iOException, i));
        if (retryDelayMsFor == -9223372036854775807L) {
            createRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        } else {
            int q = q();
            if (q > this.b0) {
                extractingLoadable2 = extractingLoadable;
                z = true;
            } else {
                z = false;
                extractingLoadable2 = extractingLoadable;
            }
            createRetryAction = n(extractingLoadable2, q) ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(z, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
        }
        boolean z2 = !createRetryAction.isRetry();
        this.w.loadError(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.j, this.R, iOException, z2);
        if (z2) {
            this.v.onLoadTaskConcluded(extractingLoadable.a);
        }
        return createRetryAction;
    }

    public final com.google.android.exoplayer2.extractor.TrackOutput F(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId trackId) {
        int length = this.K.length;
        for (int i = 0; i < length; i++) {
            if (trackId.equals(this.L[i])) {
                return this.K[i];
            }
        }
        com.google.android.exoplayer2.source.SampleQueue sampleQueue = new com.google.android.exoplayer2.source.SampleQueue(this.z, this.H.getLooper(), this.u, this.x);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i2 = length + 1;
        com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId[] trackIdArr = (com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId[]) java.util.Arrays.copyOf(this.L, i2);
        trackIdArr[length] = trackId;
        this.L = (com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId[]) com.google.android.exoplayer2.util.Util.castNonNullTypeArray(trackIdArr);
        com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = (com.google.android.exoplayer2.source.SampleQueue[]) java.util.Arrays.copyOf(this.K, i2);
        sampleQueueArr[length] = sampleQueue;
        this.K = (com.google.android.exoplayer2.source.SampleQueue[]) com.google.android.exoplayer2.util.Util.castNonNullTypeArray(sampleQueueArr);
        return sampleQueue;
    }

    public int G(int i, com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (M()) {
            return -3;
        }
        y(i);
        int read = this.K[i].read(formatHolder, decoderInputBuffer, z, this.c0);
        if (read == -3) {
            z(i);
        }
        return read;
    }

    public void H() {
        if (this.N) {
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
                sampleQueue.preRelease();
            }
        }
        this.C.release(this);
        this.H.removeCallbacksAndMessages(null);
        this.I = null;
        this.d0 = true;
    }

    public final boolean I(boolean[] zArr, long j) {
        int length = this.K.length;
        for (int i = 0; i < length; i++) {
            if (!this.K[i].seekTo(j, false) && (zArr[i] || !this.O)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final void w(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
        this.Q = this.J == null ? seekMap : new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L);
        this.R = seekMap.getDurationUs();
        boolean z = this.X == -1 && seekMap.getDurationUs() == -9223372036854775807L;
        this.S = z;
        this.T = z ? 7 : 1;
        this.y.onSourceInfoRefreshed(this.R, seekMap.isSeekable(), this.S);
        if (this.N) {
            return;
        }
        x();
    }

    public int K(int i, long j) {
        if (M()) {
            return 0;
        }
        y(i);
        com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.K[i];
        int skipCount = sampleQueue.getSkipCount(j, this.c0);
        sampleQueue.skip(skipCount);
        if (skipCount == 0) {
            z(i);
        }
        return skipCount;
    }

    public final void L() {
        com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable = new com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable(this.n, this.t, this.D, this, this.E);
        if (this.N) {
            com.google.android.exoplayer2.util.Assertions.checkState(t());
            long j = this.R;
            if (j != -9223372036854775807L && this.Z > j) {
                this.c0 = true;
                this.Z = -9223372036854775807L;
                return;
            }
            extractingLoadable.h(((com.google.android.exoplayer2.extractor.SeekMap) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.Q)).getSeekPoints(this.Z).first.position, this.Z);
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
                sampleQueue.setStartTimeUs(this.Z);
            }
            this.Z = -9223372036854775807L;
        }
        this.b0 = q();
        this.w.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(extractingLoadable.a, extractingLoadable.k, this.C.startLoading(extractingLoadable, this, this.v.getMinimumLoadableRetryCount(this.T))), 1, -1, null, 0, null, extractingLoadable.j, this.R);
    }

    public final boolean M() {
        return this.V || t();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.c0 || this.C.hasFatalError() || this.a0) {
            return false;
        }
        if (this.N && this.W == 0) {
            return false;
        }
        boolean open = this.E.open();
        if (this.C.isLoading()) {
            return open;
        }
        L();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        m();
        if (t()) {
            return;
        }
        boolean[] zArr = this.P.c;
        int length = this.K.length;
        for (int i = 0; i < length; i++) {
            this.K[i].discardTo(j, z, zArr[i]);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.M = true;
        this.H.post(this.F);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        m();
        if (!this.Q.isSeekable()) {
            return 0L;
        }
        com.google.android.exoplayer2.extractor.SeekMap.SeekPoints seekPoints = this.Q.getSeekPoints(j);
        return seekParameters.resolveSeekPositionUs(j, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long j;
        m();
        boolean[] zArr = this.P.b;
        if (this.c0) {
            return Long.MIN_VALUE;
        }
        if (t()) {
            return this.Z;
        }
        if (this.O) {
            int length = this.K.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.K[i].isLastSampleQueued()) {
                    j = java.lang.Math.min(j, this.K[i].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = r();
        }
        return j == Long.MIN_VALUE ? this.Y : j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (this.W == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ java.util.List getStreamKeys(java.util.List list) {
        return defpackage.ed1.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        m();
        return this.P.a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.C.isLoading() && this.E.isOpen();
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"trackState", "seekMap"})
    public final void m() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.N);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.P);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.Q);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        A();
        if (this.c0 && !this.N) {
            throw new com.google.android.exoplayer2.ParserException("Loading finished before preparation is complete.");
        }
    }

    public final boolean n(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable, int i) {
        com.google.android.exoplayer2.extractor.SeekMap seekMap;
        if (this.X != -1 || ((seekMap = this.Q) != null && seekMap.getDurationUs() != -9223372036854775807L)) {
            this.b0 = i;
            return true;
        }
        if (this.N && !M()) {
            this.a0 = true;
            return false;
        }
        this.V = this.N;
        this.Y = 0L;
        this.b0 = 0;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
            sampleQueue.reset();
        }
        extractingLoadable.h(0L, 0L);
        return true;
    }

    public final void o(com.google.android.exoplayer2.source.ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable) {
        if (this.X == -1) {
            this.X = extractingLoadable.l;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
            sampleQueue.release();
        }
        this.D.release();
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(com.google.android.exoplayer2.Format format) {
        this.H.post(this.F);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        this.I = callback;
        this.E.open();
        L();
    }

    public final int q() {
        int i = 0;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
            i += sampleQueue.getWriteIndex();
        }
        return i;
    }

    public final long r() {
        long j = Long.MIN_VALUE;
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
            j = java.lang.Math.max(j, sampleQueue.getLargestQueuedTimestampUs());
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (!this.V) {
            return -9223372036854775807L;
        }
        if (!this.c0 && q() <= this.b0) {
            return -9223372036854775807L;
        }
        this.V = false;
        return this.Y;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
    }

    public com.google.android.exoplayer2.extractor.TrackOutput s() {
        return F(new com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId(0, true));
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(com.google.android.exoplayer2.extractor.SeekMap seekMap) {
        this.H.post(new com.google.android.exoplayer2.source.c(this, seekMap));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        m();
        boolean[] zArr = this.P.b;
        if (!this.Q.isSeekable()) {
            j = 0;
        }
        this.V = false;
        this.Y = j;
        if (t()) {
            this.Z = j;
            return j;
        }
        if (this.T != 7 && I(zArr, j)) {
            return j;
        }
        this.a0 = false;
        this.Z = j;
        this.c0 = false;
        if (this.C.isLoading()) {
            this.C.cancelLoading();
        } else {
            this.C.clearFatalError();
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
                sampleQueue.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection;
        m();
        com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackState trackState = this.P;
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray = trackState.a;
        boolean[] zArr3 = trackState.c;
        int i = this.W;
        int i2 = 0;
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i3];
            if (sampleStream != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                int i4 = ((com.google.android.exoplayer2.source.ProgressiveMediaPeriod.SampleStreamImpl) sampleStream).n;
                com.google.android.exoplayer2.util.Assertions.checkState(zArr3[i4]);
                this.W--;
                zArr3[i4] = false;
                sampleStreamArr[i3] = null;
            }
        }
        boolean z = !this.U ? j == 0 : i != 0;
        for (int i5 = 0; i5 < trackSelectionArr.length; i5++) {
            if (sampleStreamArr[i5] == null && (trackSelection = trackSelectionArr[i5]) != null) {
                com.google.android.exoplayer2.util.Assertions.checkState(trackSelection.length() == 1);
                com.google.android.exoplayer2.util.Assertions.checkState(trackSelection.getIndexInTrackGroup(0) == 0);
                int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
                com.google.android.exoplayer2.util.Assertions.checkState(!zArr3[indexOf]);
                this.W++;
                zArr3[indexOf] = true;
                sampleStreamArr[i5] = new com.google.android.exoplayer2.source.ProgressiveMediaPeriod.SampleStreamImpl(indexOf);
                zArr2[i5] = true;
                if (!z) {
                    com.google.android.exoplayer2.source.SampleQueue sampleQueue = this.K[indexOf];
                    z = (sampleQueue.seekTo(j, true) || sampleQueue.getReadIndex() == 0) ? false : true;
                }
            }
        }
        if (this.W == 0) {
            this.a0 = false;
            this.V = false;
            if (this.C.isLoading()) {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.K;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].discardToEnd();
                    i2++;
                }
                this.C.cancelLoading();
            } else {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr2 = this.K;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].reset();
                    i2++;
                }
            }
        } else if (z) {
            j = seekToUs(j);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.U = true;
        return j;
    }

    public final boolean t() {
        return this.Z != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public com.google.android.exoplayer2.extractor.TrackOutput track(int i, int i2) {
        return F(new com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackId(i, false));
    }

    public boolean u(int i) {
        return !M() && this.K[i].isReady(this.c0);
    }

    public final void x() {
        if (this.d0 || this.N || !this.M || this.Q == null) {
            return;
        }
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
            if (sampleQueue.getUpstreamFormat() == null) {
                return;
            }
        }
        this.E.close();
        int length = this.K.length;
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.K[i].getUpstreamFormat());
            java.lang.String str = format.sampleMimeType;
            boolean isAudio = com.google.android.exoplayer2.util.MimeTypes.isAudio(str);
            boolean z = isAudio || com.google.android.exoplayer2.util.MimeTypes.isVideo(str);
            zArr[i] = z;
            this.O = z | this.O;
            com.google.android.exoplayer2.metadata.icy.IcyHeaders icyHeaders = this.J;
            if (icyHeaders != null) {
                if (isAudio || this.L[i].b) {
                    com.google.android.exoplayer2.metadata.Metadata metadata = format.metadata;
                    format = format.buildUpon().setMetadata(metadata == null ? new com.google.android.exoplayer2.metadata.Metadata(icyHeaders) : metadata.copyWithAppendedEntries(icyHeaders)).build();
                }
                if (isAudio && format.averageBitrate == -1 && format.peakBitrate == -1 && icyHeaders.bitrate != -1) {
                    format = format.buildUpon().setAverageBitrate(icyHeaders.bitrate).build();
                }
            }
            trackGroupArr[i] = new com.google.android.exoplayer2.source.TrackGroup(format.copyWithExoMediaCryptoType(this.u.getExoMediaCryptoType(format)));
        }
        this.P = new com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackState(new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr), zArr);
        this.N = true;
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.I)).onPrepared(this);
    }

    public final void y(int i) {
        m();
        com.google.android.exoplayer2.source.ProgressiveMediaPeriod.TrackState trackState = this.P;
        boolean[] zArr = trackState.d;
        if (zArr[i]) {
            return;
        }
        com.google.android.exoplayer2.Format format = trackState.a.get(i).getFormat(0);
        this.w.downstreamFormatChanged(com.google.android.exoplayer2.util.MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.Y);
        zArr[i] = true;
    }

    public final void z(int i) {
        m();
        boolean[] zArr = this.P.b;
        if (this.a0 && zArr[i]) {
            if (this.K[i].isReady(false)) {
                return;
            }
            this.Z = 0L;
            this.a0 = false;
            this.V = true;
            this.Y = 0L;
            this.b0 = 0;
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.K) {
                sampleQueue.reset();
            }
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.I)).onContinueLoadingRequested(this);
        }
    }
}
