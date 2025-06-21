package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
final class SingleSampleMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable> {
    public final com.google.android.exoplayer2.Format B;
    public final boolean C;
    public boolean D;
    public byte[] E;
    public int F;
    public final com.google.android.exoplayer2.upstream.DataSpec n;
    public final com.google.android.exoplayer2.upstream.DataSource.Factory t;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.TransferListener u;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy v;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher w;
    public final com.google.android.exoplayer2.source.TrackGroupArray x;
    public final long z;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SampleStreamImpl> y = new java.util.ArrayList<>();
    public final com.google.android.exoplayer2.upstream.Loader A = new com.google.android.exoplayer2.upstream.Loader("Loader:SingleSampleMediaPeriod");

    public final class SampleStreamImpl implements com.google.android.exoplayer2.source.SampleStream {
        public int n;
        public boolean t;

        public SampleStreamImpl() {
        }

        public /* synthetic */ SampleStreamImpl(com.google.android.exoplayer2.source.SingleSampleMediaPeriod singleSampleMediaPeriod, com.google.android.exoplayer2.source.SingleSampleMediaPeriod.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a() {
            if (this.t) {
                return;
            }
            com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.w.downstreamFormatChanged(com.google.android.exoplayer2.util.MimeTypes.getTrackType(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.B.sampleMimeType), com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.B, 0, null, 0L);
            this.t = true;
        }

        public void b() {
            if (this.n == 2) {
                this.n = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.D;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws java.io.IOException {
            com.google.android.exoplayer2.source.SingleSampleMediaPeriod singleSampleMediaPeriod = com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this;
            if (singleSampleMediaPeriod.C) {
                return;
            }
            singleSampleMediaPeriod.A.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
            a();
            int i = this.n;
            if (i == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if (z || i == 0) {
                formatHolder.format = com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.B;
                this.n = 1;
                return -5;
            }
            com.google.android.exoplayer2.source.SingleSampleMediaPeriod singleSampleMediaPeriod = com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this;
            if (!singleSampleMediaPeriod.D) {
                return -3;
            }
            if (singleSampleMediaPeriod.E != null) {
                decoderInputBuffer.addFlag(1);
                decoderInputBuffer.timeUs = 0L;
                if (decoderInputBuffer.isFlagsOnly()) {
                    return -4;
                }
                decoderInputBuffer.ensureSpaceForWrite(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this.F);
                java.nio.ByteBuffer byteBuffer = decoderInputBuffer.data;
                com.google.android.exoplayer2.source.SingleSampleMediaPeriod singleSampleMediaPeriod2 = com.google.android.exoplayer2.source.SingleSampleMediaPeriod.this;
                byteBuffer.put(singleSampleMediaPeriod2.E, 0, singleSampleMediaPeriod2.F);
            } else {
                decoderInputBuffer.addFlag(4);
            }
            this.n = 2;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            a();
            if (j <= 0 || this.n == 2) {
                return 0;
            }
            this.n = 2;
            return 1;
        }
    }

    public static final class SourceLoadable implements com.google.android.exoplayer2.upstream.Loader.Loadable {
        public final long a = com.google.android.exoplayer2.source.LoadEventInfo.getNewId();
        public final com.google.android.exoplayer2.upstream.DataSpec b;
        public final com.google.android.exoplayer2.upstream.StatsDataSource c;

        @androidx.annotation.Nullable
        public byte[] d;

        public SourceLoadable(com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.upstream.DataSource dataSource) {
            this.b = dataSpec;
            this.c = new com.google.android.exoplayer2.upstream.StatsDataSource(dataSource);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws java.io.IOException {
            this.c.resetBytesRead();
            try {
                this.c.open(this.b);
                int i = 0;
                while (i != -1) {
                    int bytesRead = (int) this.c.getBytesRead();
                    byte[] bArr = this.d;
                    if (bArr == null) {
                        this.d = new byte[1024];
                    } else if (bytesRead == bArr.length) {
                        this.d = java.util.Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = this.c;
                    byte[] bArr2 = this.d;
                    i = statsDataSource.read(bArr2, bytesRead, bArr2.length - bytesRead);
                }
            } finally {
                com.google.android.exoplayer2.util.Util.closeQuietly(this.c);
            }
        }
    }

    public SingleSampleMediaPeriod(com.google.android.exoplayer2.upstream.DataSpec dataSpec, com.google.android.exoplayer2.upstream.DataSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.Format format, long j, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.n = dataSpec;
        this.t = factory;
        this.u = transferListener;
        this.B = format;
        this.z = j;
        this.v = loadErrorHandlingPolicy;
        this.w = eventDispatcher;
        this.C = z;
        this.x = new com.google.android.exoplayer2.source.TrackGroupArray(new com.google.android.exoplayer2.source.TrackGroup(format));
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onLoadCanceled(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable sourceLoadable, long j, long j2, boolean z) {
        com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = sourceLoadable.c;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(sourceLoadable.a, sourceLoadable.b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        this.v.onLoadTaskConcluded(sourceLoadable.a);
        this.w.loadCanceled(loadEventInfo, 1, -1, null, 0, null, 0L, this.z);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onLoadCompleted(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable sourceLoadable, long j, long j2) {
        this.F = (int) sourceLoadable.c.getBytesRead();
        this.E = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(sourceLoadable.d);
        this.D = true;
        com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = sourceLoadable.c;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(sourceLoadable.a, sourceLoadable.b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, this.F);
        this.v.onLoadTaskConcluded(sourceLoadable.a);
        this.w.loadCompleted(loadEventInfo, 1, -1, this.B, 0, null, 0L, this.z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.D || this.A.isLoading() || this.A.hasFatalError()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.DataSource createDataSource = this.t.createDataSource();
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.u;
        if (transferListener != null) {
            createDataSource.addTransferListener(transferListener);
        }
        com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable sourceLoadable = new com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable(this.n, createDataSource);
        this.w.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(sourceLoadable.a, this.n, this.A.startLoading(sourceLoadable, this, this.v.getMinimumLoadableRetryCount(1))), 1, -1, this.B, 0, null, 0L, this.z);
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SourceLoadable sourceLoadable, long j, long j2, java.io.IOException iOException, int i) {
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction createRetryAction;
        com.google.android.exoplayer2.upstream.StatsDataSource statsDataSource = sourceLoadable.c;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(sourceLoadable.a, sourceLoadable.b, statsDataSource.getLastOpenedUri(), statsDataSource.getLastResponseHeaders(), j, j2, statsDataSource.getBytesRead());
        long retryDelayMsFor = this.v.getRetryDelayMsFor(new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(1, -1, this.B, 0, null, 0L, com.google.android.exoplayer2.C.usToMs(this.z)), iOException, i));
        boolean z = retryDelayMsFor == -9223372036854775807L || i >= this.v.getMinimumLoadableRetryCount(1);
        if (this.C && z) {
            this.D = true;
            createRetryAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
        } else {
            createRetryAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
        }
        boolean z2 = !createRetryAction.isRetry();
        this.w.loadError(loadEventInfo, 1, -1, this.B, 0, null, 0L, this.z, iOException, z2);
        if (z2) {
            this.v.onLoadTaskConcluded(sourceLoadable.a);
        }
        return createRetryAction;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
    }

    public void e() {
        this.A.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.D ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return (this.D || this.A.isLoading()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ java.util.List getStreamKeys(java.util.List list) {
        return defpackage.ed1.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.x;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.A.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        for (int i = 0; i < this.y.size(); i++) {
            this.y.get(i).b();
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i];
            if (sampleStream != null && (trackSelectionArr[i] == null || !zArr[i])) {
                this.y.remove(sampleStream);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SampleStreamImpl sampleStreamImpl = new com.google.android.exoplayer2.source.SingleSampleMediaPeriod.SampleStreamImpl(this, null);
                this.y.add(sampleStreamImpl);
                sampleStreamArr[i] = sampleStreamImpl;
                zArr2[i] = true;
            }
        }
        return j;
    }
}
