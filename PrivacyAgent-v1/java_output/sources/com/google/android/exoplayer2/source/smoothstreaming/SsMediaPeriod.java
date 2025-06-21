package com.google.android.exoplayer2.source.smoothstreaming;

/* loaded from: classes22.dex */
final class SsMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader.Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>> {
    public final com.google.android.exoplayer2.source.TrackGroupArray A;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory B;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod.Callback C;
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest D;
    public com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>[] E;
    public com.google.android.exoplayer2.source.SequenceableLoader F;
    public final com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory n;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.upstream.TransferListener t;
    public final com.google.android.exoplayer2.upstream.LoaderErrorThrower u;
    public final com.google.android.exoplayer2.drm.DrmSessionManager v;
    public final com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher w;
    public final com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy x;
    public final com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher y;
    public final com.google.android.exoplayer2.upstream.Allocator z;

    public SsMediaPeriod(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory factory, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager, com.google.android.exoplayer2.drm.DrmSessionEventListener.EventDispatcher eventDispatcher, com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy loadErrorHandlingPolicy, com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher eventDispatcher2, com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.upstream.Allocator allocator) {
        this.D = ssManifest;
        this.n = factory;
        this.t = transferListener;
        this.u = loaderErrorThrower;
        this.v = drmSessionManager;
        this.w = eventDispatcher;
        this.x = loadErrorHandlingPolicy;
        this.y = eventDispatcher2;
        this.z = allocator;
        this.B = compositeSequenceableLoaderFactory;
        this.A = b(ssManifest, drmSessionManager);
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>[] c = c(0);
        this.E = c;
        this.F = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(c);
    }

    public static com.google.android.exoplayer2.source.TrackGroupArray b(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, com.google.android.exoplayer2.drm.DrmSessionManager drmSessionManager) {
        com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[ssManifest.streamElements.length];
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr = ssManifest.streamElements;
            if (i >= streamElementArr.length) {
                return new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
            }
            com.google.android.exoplayer2.Format[] formatArr = streamElementArr[i].formats;
            com.google.android.exoplayer2.Format[] formatArr2 = new com.google.android.exoplayer2.Format[formatArr.length];
            for (int i2 = 0; i2 < formatArr.length; i2++) {
                com.google.android.exoplayer2.Format format = formatArr[i2];
                formatArr2[i2] = format.copyWithExoMediaCryptoType(drmSessionManager.getExoMediaCryptoType(format));
            }
            trackGroupArr[i] = new com.google.android.exoplayer2.source.TrackGroup(formatArr2);
            i++;
        }
    }

    public static com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>[] c(int i) {
        return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream[i];
    }

    public final com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> a(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, long j) {
        int indexOf = this.A.indexOf(trackSelection.getTrackGroup());
        return new com.google.android.exoplayer2.source.chunk.ChunkSampleStream<>(this.D.streamElements[indexOf].type, null, null, this.n.createChunkSource(this.u, this.D, indexOf, trackSelection, this.t), this, this.z, j, this.v, this.w, this.x, this.y);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.F.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream) {
        this.C.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.E) {
            chunkSampleStream.discardBuffer(j, z);
        }
    }

    public void e() {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.E) {
            chunkSampleStream.release();
        }
        this.C = null;
    }

    public void f(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest) {
        this.D = ssManifest;
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.E) {
            chunkSampleStream.getChunkSource().updateManifest(ssManifest);
        }
        this.C.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.E) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j, seekParameters);
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.F.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.F.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public java.util.List<com.google.android.exoplayer2.offline.StreamKey> getStreamKeys(java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = list.get(i);
            int indexOf = this.A.indexOf(trackSelection.getTrackGroup());
            for (int i2 = 0; i2 < trackSelection.length(); i2++) {
                arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(indexOf, trackSelection.getIndexInTrackGroup(i2)));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.A;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.F.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        this.u.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        this.C = callback;
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.F.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        for (com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> chunkSampleStream : this.E) {
            chunkSampleStream.seekToUs(j);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < trackSelectionArr.length; i++) {
            com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i];
            if (sampleStream != null) {
                com.google.android.exoplayer2.source.chunk.ChunkSampleStream chunkSampleStream = (com.google.android.exoplayer2.source.chunk.ChunkSampleStream) sampleStream;
                if (trackSelectionArr[i] == null || !zArr[i]) {
                    chunkSampleStream.release();
                    sampleStreamArr[i] = null;
                } else {
                    ((com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource) chunkSampleStream.getChunkSource()).updateTrackSelection(trackSelectionArr[i]);
                    arrayList.add(chunkSampleStream);
                }
            }
            if (sampleStreamArr[i] == null && (trackSelection = trackSelectionArr[i]) != null) {
                com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource> a = a(trackSelection, j);
                arrayList.add(a);
                sampleStreamArr[i] = a;
                zArr2[i] = true;
            }
        }
        com.google.android.exoplayer2.source.chunk.ChunkSampleStream<com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource>[] c = c(arrayList.size());
        this.E = c;
        arrayList.toArray(c);
        this.F = this.B.createCompositeSequenceableLoader(this.E);
        return j;
    }
}
