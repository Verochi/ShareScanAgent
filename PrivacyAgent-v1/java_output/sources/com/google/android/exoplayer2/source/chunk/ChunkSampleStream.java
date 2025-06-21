package com.google.android.exoplayer2.source.chunk;

/* loaded from: classes22.dex */
public class ChunkSampleStream<T extends com.google.android.exoplayer2.source.chunk.ChunkSource> implements com.google.android.exoplayer2.source.SampleStream, com.google.android.exoplayer2.source.SequenceableLoader, com.google.android.exoplayer2.upstream.Loader.Callback<com.google.android.exoplayer2.source.chunk.Chunk>, com.google.android.exoplayer2.upstream.Loader.ReleaseCallback {
    public final com.google.android.exoplayer2.source.chunk.ChunkHolder A;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> B;
    public final java.util.List<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> C;
    public final com.google.android.exoplayer2.source.SampleQueue D;
    public final com.google.android.exoplayer2.source.SampleQueue[] E;
    public final com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput F;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.chunk.Chunk G;
    public com.google.android.exoplayer2.Format H;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<T> I;
    public long J;
    public long K;
    public int L;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.chunk.BaseMediaChunk M;
    public boolean N;
    public final int[] n;
    public final int primaryTrackType;
    public final com.google.android.exoplayer2.Format[] t;
    public final boolean[] u;
    public final T v;
    public final com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T>> w;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher x;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy y;
    public final com.google.android.exoplayer2.upstream.Loader z;

    public final class EmbeddedSampleStream implements com.google.android.exoplayer2.source.SampleStream {
        public final com.google.android.exoplayer2.source.SampleQueue n;
        public final com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T> parent;
        public final int t;
        public boolean u;

        public EmbeddedSampleStream(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T> chunkSampleStream, com.google.android.exoplayer2.source.SampleQueue sampleQueue, int i) {
            this.parent = chunkSampleStream;
            this.n = sampleQueue;
            this.t = i;
        }

        public final void a() {
            if (this.u) {
                return;
            }
            com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.x.downstreamFormatChanged(com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.n[this.t], com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.t[this.t], 0, null, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.K);
            this.u = true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.m() && this.n.isReady(com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.N);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.m()) {
                return -3;
            }
            if (com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.M != null && com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.M.getFirstSampleIndex(this.t + 1) <= this.n.getReadIndex()) {
                return -3;
            }
            a();
            return this.n.read(formatHolder, decoderInputBuffer, z, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.N);
        }

        public void release() {
            com.google.android.exoplayer2.util.Assertions.checkState(com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.u[this.t]);
            com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.u[this.t] = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            if (com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.m()) {
                return 0;
            }
            int skipCount = this.n.getSkipCount(j, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.N);
            if (com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.M != null) {
                skipCount = java.lang.Math.min(skipCount, com.google.android.exoplayer2.source.chunk.ChunkSampleStream.this.M.getFirstSampleIndex(this.t + 1) - this.n.getReadIndex());
            }
            this.n.skip(skipCount);
            if (skipCount > 0) {
                a();
            }
            return skipCount;
        }
    }

    public interface ReleaseCallback<T extends com.google.android.exoplayer2.source.chunk.ChunkSource> {
        void onSampleStreamReleased(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i, @androidx.annotation.Nullable int[] iArr, @androidx.annotation.Nullable com.google.android.exoplayer2.Format[] formatArr, T t, com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T>> callback, com.google.android.exoplayer2.upstream.Allocator allocator, long j, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.primaryTrackType = i;
        int i2 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.n = iArr;
        this.t = formatArr == null ? new com.google.android.exoplayer2.Format[0] : formatArr;
        this.v = t;
        this.w = callback;
        this.x = eventDispatcher2;
        this.y = loadErrorHandlingPolicy;
        this.z = new com.google.android.exoplayer2.upstream.Loader("Loader:ChunkSampleStream");
        this.A = new com.google.android.exoplayer2.source.chunk.ChunkHolder();
        java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> arrayList = new java.util.ArrayList<>();
        this.B = arrayList;
        this.C = java.util.Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.E = new com.google.android.exoplayer2.source.SampleQueue[length];
        this.u = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = new com.google.android.exoplayer2.source.SampleQueue[i3];
        com.google.android.exoplayer2.source.SampleQueue sampleQueue = new com.google.android.exoplayer2.source.SampleQueue(allocator, (android.os.Looper) com.google.android.exoplayer2.util.Assertions.checkNotNull(android.os.Looper.myLooper()), drmSessionManager, eventDispatcher);
        this.D = sampleQueue;
        iArr2[0] = i;
        sampleQueueArr[0] = sampleQueue;
        while (i2 < length) {
            com.google.android.exoplayer2.source.SampleQueue sampleQueue2 = new com.google.android.exoplayer2.source.SampleQueue(allocator, (android.os.Looper) com.google.android.exoplayer2.util.Assertions.checkNotNull(android.os.Looper.myLooper()), defpackage.z60.c(), eventDispatcher);
            this.E[i2] = sampleQueue2;
            int i4 = i2 + 1;
            sampleQueueArr[i4] = sampleQueue2;
            iArr2[i4] = this.n[i2];
            i2 = i4;
        }
        this.F = new com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.J = j;
        this.K = j;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        java.util.List<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> list;
        long j2;
        if (this.N || this.z.isLoading() || this.z.hasFatalError()) {
            return false;
        }
        boolean m = m();
        if (m) {
            list = java.util.Collections.emptyList();
            j2 = this.J;
        } else {
            list = this.C;
            j2 = j().endTimeUs;
        }
        this.v.getNextChunk(j, j2, list, this.A);
        com.google.android.exoplayer2.source.chunk.ChunkHolder chunkHolder = this.A;
        boolean z = chunkHolder.endOfStream;
        com.google.android.exoplayer2.source.chunk.Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z) {
            this.J = -9223372036854775807L;
            this.N = true;
            return true;
        }
        if (chunk == null) {
            return false;
        }
        this.G = chunk;
        if (l(chunk)) {
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = (com.google.android.exoplayer2.source.chunk.BaseMediaChunk) chunk;
            if (m) {
                long j3 = baseMediaChunk.startTimeUs;
                long j4 = this.J;
                if (j3 != j4) {
                    this.D.setStartTimeUs(j4);
                    for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.E) {
                        sampleQueue.setStartTimeUs(this.J);
                    }
                }
                this.J = -9223372036854775807L;
            }
            baseMediaChunk.init(this.F);
            this.B.add(baseMediaChunk);
        } else if (chunk instanceof com.google.android.exoplayer2.source.chunk.InitializationChunk) {
            ((com.google.android.exoplayer2.source.chunk.InitializationChunk) chunk).init(this.F);
        }
        this.x.loadStarted(new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, this.z.startLoading(chunk, this, this.y.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        return true;
    }

    public void discardBuffer(long j, boolean z) {
        if (m()) {
            return;
        }
        int firstIndex = this.D.getFirstIndex();
        this.D.discardTo(j, z, true);
        int firstIndex2 = this.D.getFirstIndex();
        if (firstIndex2 > firstIndex) {
            long firstTimestampUs = this.D.getFirstTimestampUs();
            int i = 0;
            while (true) {
                com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.E;
                if (i >= sampleQueueArr.length) {
                    break;
                }
                sampleQueueArr[i].discardTo(firstTimestampUs, z, this.u[i]);
                i++;
            }
        }
        g(firstIndex2);
    }

    public final void g(int i) {
        int min = java.lang.Math.min(p(i, 0), this.L);
        if (min > 0) {
            com.google.android.exoplayer2.util.Util.removeRange(this.B, 0, min);
            this.L -= min;
        }
    }

    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return this.v.getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.N) {
            return Long.MIN_VALUE;
        }
        if (m()) {
            return this.J;
        }
        long j = this.K;
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk j2 = j();
        if (!j2.isLoadCompleted()) {
            if (this.B.size() > 1) {
                j2 = this.B.get(r2.size() - 2);
            } else {
                j2 = null;
            }
        }
        if (j2 != null) {
            j = java.lang.Math.max(j, j2.endTimeUs);
        }
        return java.lang.Math.max(j, this.D.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return this.v;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (m()) {
            return this.J;
        }
        if (this.N) {
            return Long.MIN_VALUE;
        }
        return j().endTimeUs;
    }

    public final void h(int i) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.z.isLoading());
        int size = this.B.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (!k(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = j().endTimeUs;
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk i2 = i(i);
        if (this.B.isEmpty()) {
            this.J = this.K;
        }
        this.N = false;
        this.x.upstreamDiscarded(this.primaryTrackType, i2.startTimeUs, j);
    }

    public final com.google.android.exoplayer2.source.chunk.BaseMediaChunk i(int i) {
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.B.get(i);
        java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> arrayList = this.B;
        com.google.android.exoplayer2.util.Util.removeRange(arrayList, i, arrayList.size());
        this.L = java.lang.Math.max(this.L, this.B.size());
        int i2 = 0;
        this.D.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.E;
            if (i2 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            com.google.android.exoplayer2.source.SampleQueue sampleQueue = sampleQueueArr[i2];
            i2++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i2));
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.z.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return !m() && this.D.isReady(this.N);
    }

    public final com.google.android.exoplayer2.source.chunk.BaseMediaChunk j() {
        return this.B.get(r0.size() - 1);
    }

    public final boolean k(int i) {
        int readIndex;
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.B.get(i);
        if (this.D.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i2 = 0;
        do {
            com.google.android.exoplayer2.source.SampleQueue[] sampleQueueArr = this.E;
            if (i2 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i2].getReadIndex();
            i2++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i2));
        return true;
    }

    public final boolean l(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        return chunk instanceof com.google.android.exoplayer2.source.chunk.BaseMediaChunk;
    }

    public boolean m() {
        return this.J != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws java.io.IOException {
        this.z.maybeThrowError();
        this.D.maybeThrowError();
        if (this.z.isLoading()) {
            return;
        }
        this.v.maybeThrowError();
    }

    public final void n() {
        int p = p(this.D.getReadIndex(), this.L - 1);
        while (true) {
            int i = this.L;
            if (i > p) {
                return;
            }
            this.L = i + 1;
            o(i);
        }
    }

    public final void o(int i) {
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.B.get(i);
        com.google.android.exoplayer2.Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.H)) {
            this.x.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.H = format;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j, long j2, boolean z) {
        this.G = null;
        this.M = null;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.y.onLoadTaskConcluded(chunk.loadTaskId);
        this.x.loadCanceled(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        if (z) {
            return;
        }
        if (m()) {
            q();
        } else if (l(chunk)) {
            i(this.B.size() - 1);
            if (this.B.isEmpty()) {
                this.J = this.K;
            }
        }
        this.w.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j, long j2) {
        this.G = null;
        this.v.onChunkLoadCompleted(chunk);
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, chunk.bytesLoaded());
        this.y.onLoadTaskConcluded(chunk.loadTaskId);
        this.x.loadCompleted(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
        this.w.onContinueLoadingRequested(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0100  */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, long j, long j2, java.io.IOException iOException, int i) {
        com.google.android.exoplayer2.upstream.Loader.LoadErrorAction loadErrorAction;
        boolean z;
        long bytesLoaded = chunk.bytesLoaded();
        boolean l = l(chunk);
        int size = this.B.size() - 1;
        boolean z2 = (bytesLoaded != 0 && l && k(size)) ? false : true;
        com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo = new com.google.android.exoplayer2.source.LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j, j2, bytesLoaded);
        com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new com.google.android.exoplayer2.source.MediaLoadData(chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, com.google.android.exoplayer2.C.usToMs(chunk.startTimeUs), com.google.android.exoplayer2.C.usToMs(chunk.endTimeUs)), iOException, i);
        if (this.v.onChunkLoadError(chunk, z2, iOException, z2 ? this.y.getBlacklistDurationMsFor(loadErrorInfo) : -9223372036854775807L)) {
            if (z2) {
                loadErrorAction = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY;
                if (l) {
                    com.google.android.exoplayer2.util.Assertions.checkState(i(size) == chunk);
                    if (this.B.isEmpty()) {
                        this.J = this.K;
                    }
                }
                if (loadErrorAction == null) {
                    long retryDelayMsFor = this.y.getRetryDelayMsFor(loadErrorInfo);
                    loadErrorAction = retryDelayMsFor != -9223372036854775807L ? com.google.android.exoplayer2.upstream.Loader.createRetryAction(false, retryDelayMsFor) : com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL;
                }
                z = !loadErrorAction.isRetry();
                this.x.loadError(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, iOException, z);
                if (z) {
                    this.G = null;
                    this.y.onLoadTaskConcluded(chunk.loadTaskId);
                    this.w.onContinueLoadingRequested(this);
                }
                return loadErrorAction;
            }
            com.google.android.exoplayer2.util.Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
        }
        loadErrorAction = null;
        if (loadErrorAction == null) {
        }
        z = !loadErrorAction.isRetry();
        this.x.loadError(loadEventInfo, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, iOException, z);
        if (z) {
        }
        return loadErrorAction;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.D.release();
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.E) {
            sampleQueue.release();
        }
        this.v.release();
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<T> releaseCallback = this.I;
        if (releaseCallback != null) {
            releaseCallback.onSampleStreamReleased(this);
        }
    }

    public final int p(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.B.size()) {
                return this.B.size() - 1;
            }
        } while (this.B.get(i2).getFirstSampleIndex(0) <= i);
        return i2 - 1;
    }

    public final void q() {
        this.D.reset();
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.E) {
            sampleQueue.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (m()) {
            return -3;
        }
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.M;
        if (baseMediaChunk != null && baseMediaChunk.getFirstSampleIndex(0) <= this.D.getReadIndex()) {
            return -3;
        }
        n();
        return this.D.read(formatHolder, decoderInputBuffer, z, this.N);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        if (this.z.hasFatalError() || m()) {
            return;
        }
        if (!this.z.isLoading()) {
            int preferredQueueSize = this.v.getPreferredQueueSize(j, this.C);
            if (preferredQueueSize < this.B.size()) {
                h(preferredQueueSize);
                return;
            }
            return;
        }
        com.google.android.exoplayer2.source.chunk.Chunk chunk = (com.google.android.exoplayer2.source.chunk.Chunk) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.G);
        if (!(l(chunk) && k(this.B.size() - 1)) && this.v.shouldCancelLoad(j, chunk, this.C)) {
            this.z.cancelLoading();
            if (l(chunk)) {
                this.M = (com.google.android.exoplayer2.source.chunk.BaseMediaChunk) chunk;
            }
        }
    }

    public void release() {
        release(null);
    }

    public void release(@androidx.annotation.Nullable com.google.android.exoplayer2.source.chunk.ChunkSampleStream.ReleaseCallback<T> releaseCallback) {
        this.I = releaseCallback;
        this.D.preRelease();
        for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.E) {
            sampleQueue.preRelease();
        }
        this.z.release(this);
    }

    public void seekToUs(long j) {
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk;
        this.K = j;
        if (m()) {
            this.J = j;
            return;
        }
        for (int i = 0; i < this.B.size(); i++) {
            baseMediaChunk = this.B.get(i);
            long j2 = baseMediaChunk.startTimeUs;
            if (j2 == j && baseMediaChunk.clippedStartTimeUs == -9223372036854775807L) {
                break;
            } else {
                if (j2 > j) {
                    break;
                }
            }
        }
        baseMediaChunk = null;
        if (baseMediaChunk != null ? this.D.seekTo(baseMediaChunk.getFirstSampleIndex(0)) : this.D.seekTo(j, j < getNextLoadPositionUs())) {
            this.L = p(this.D.getReadIndex(), 0);
            for (com.google.android.exoplayer2.source.SampleQueue sampleQueue : this.E) {
                sampleQueue.seekTo(j, true);
            }
            return;
        }
        this.J = j;
        this.N = false;
        this.B.clear();
        this.L = 0;
        if (this.z.isLoading()) {
            this.z.cancelLoading();
        } else {
            this.z.clearFatalError();
            q();
        }
    }

    public com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j, int i) {
        for (int i2 = 0; i2 < this.E.length; i2++) {
            if (this.n[i2] == i) {
                com.google.android.exoplayer2.util.Assertions.checkState(!this.u[i2]);
                this.u[i2] = true;
                this.E[i2].seekTo(j, true);
                return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream(this, this.E[i2], i2);
            }
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j) {
        if (m()) {
            return 0;
        }
        int skipCount = this.D.getSkipCount(j, this.N);
        com.google.android.exoplayer2.source.chunk.BaseMediaChunk baseMediaChunk = this.M;
        if (baseMediaChunk != null) {
            skipCount = java.lang.Math.min(skipCount, baseMediaChunk.getFirstSampleIndex(0) - this.D.getReadIndex());
        }
        this.D.skip(skipCount);
        n();
        return skipCount;
    }
}
