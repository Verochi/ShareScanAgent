package com.google.android.exoplayer2.source.smoothstreaming;

/* loaded from: classes22.dex */
public class DefaultSsChunkSource implements com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource {
    public final com.google.android.exoplayer2.upstream.LoaderErrorThrower a;
    public final int b;
    public final com.google.android.exoplayer2.source.chunk.ChunkExtractor[] c;
    public final com.google.android.exoplayer2.upstream.DataSource d;
    public com.google.android.exoplayer2.trackselection.TrackSelection e;
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest f;
    public int g;

    @androidx.annotation.Nullable
    public java.io.IOException h;

    public static final class Factory implements com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory {
        public final com.google.android.exoplayer2.upstream.DataSource.Factory a;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this.a = factory;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource.Factory
        public com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource createChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, int i, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
            com.google.android.exoplayer2.upstream.DataSource createDataSource = this.a.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource(loaderErrorThrower, ssManifest, i, trackSelection, createDataSource);
        }
    }

    public static final class StreamElementIterator extends com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator {
        public final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement d;
        public final int e;

        public StreamElementIterator(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement, int i, int i2) {
            super(i2, streamElement.chunkCount - 1);
            this.d = streamElement;
            this.e = i;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            return getChunkStartTimeUs() + this.d.getChunkDurationUs((int) getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.d.getStartTimeUs((int) getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public com.google.android.exoplayer2.upstream.DataSpec getDataSpec() {
            checkInBounds();
            return new com.google.android.exoplayer2.upstream.DataSpec(this.d.buildRequestUri(this.e, (int) getCurrentIndex()));
        }
    }

    public DefaultSsChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest, int i, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this.a = loaderErrorThrower;
        this.f = ssManifest;
        this.b = i;
        this.e = trackSelection;
        this.d = dataSource;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = ssManifest.streamElements[i];
        this.c = new com.google.android.exoplayer2.source.chunk.ChunkExtractor[trackSelection.length()];
        int i2 = 0;
        while (i2 < this.c.length) {
            int indexInTrackGroup = trackSelection.getIndexInTrackGroup(i2);
            com.google.android.exoplayer2.Format format = streamElement.formats[indexInTrackGroup];
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxArr = format.drmInitData != null ? ((com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement) com.google.android.exoplayer2.util.Assertions.checkNotNull(ssManifest.protectionElement)).trackEncryptionBoxes : null;
            int i3 = streamElement.type;
            int i4 = i2;
            this.c[i4] = new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor(new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(3, null, new com.google.android.exoplayer2.extractor.mp4.Track(indexInTrackGroup, i3, streamElement.timescale, -9223372036854775807L, ssManifest.durationUs, format, 0, trackEncryptionBoxArr, i3 == 2 ? 4 : 0, null, null)), streamElement.type, format);
            i2 = i4 + 1;
        }
    }

    public static com.google.android.exoplayer2.source.chunk.MediaChunk a(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.upstream.DataSource dataSource, android.net.Uri uri, int i, long j, long j2, long j3, int i2, @androidx.annotation.Nullable java.lang.Object obj, com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor) {
        return new com.google.android.exoplayer2.source.chunk.ContainerMediaChunk(dataSource, new com.google.android.exoplayer2.upstream.DataSpec(uri), format, i2, obj, j, j2, j3, -9223372036854775807L, i, 1, j, chunkExtractor);
    }

    public final long b(long j) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest = this.f;
        if (!ssManifest.isLive) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = ssManifest.streamElements[this.b];
        int i = streamElement.chunkCount - 1;
        return (streamElement.getStartTimeUs(i) + streamElement.getChunkDurationUs(i)) - j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = this.f.streamElements[this.b];
        int chunkIndex = streamElement.getChunkIndex(j);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return seekParameters.resolveSeekPositionUs(j, startTimeUs, (startTimeUs >= j || chunkIndex >= streamElement.chunkCount + (-1)) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public final void getNextChunk(long j, long j2, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.ChunkHolder chunkHolder) {
        int nextChunkIndex;
        long j3 = j2;
        if (this.h != null) {
            return;
        }
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = this.f.streamElements[this.b];
        if (streamElement.chunkCount == 0) {
            chunkHolder.endOfStream = !r4.isLive;
            return;
        }
        if (list.isEmpty()) {
            nextChunkIndex = streamElement.getChunkIndex(j3);
        } else {
            nextChunkIndex = (int) (list.get(list.size() - 1).getNextChunkIndex() - this.g);
            if (nextChunkIndex < 0) {
                this.h = new com.google.android.exoplayer2.source.BehindLiveWindowException();
                return;
            }
        }
        if (nextChunkIndex >= streamElement.chunkCount) {
            chunkHolder.endOfStream = !this.f.isLive;
            return;
        }
        long j4 = j3 - j;
        long b = b(j);
        int length = this.e.length();
        com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr = new com.google.android.exoplayer2.source.chunk.MediaChunkIterator[length];
        for (int i = 0; i < length; i++) {
            mediaChunkIteratorArr[i] = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource.StreamElementIterator(streamElement, this.e.getIndexInTrackGroup(i), nextChunkIndex);
        }
        this.e.updateSelectedTrack(j, j4, b, list, mediaChunkIteratorArr);
        long startTimeUs = streamElement.getStartTimeUs(nextChunkIndex);
        long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(nextChunkIndex);
        if (!list.isEmpty()) {
            j3 = -9223372036854775807L;
        }
        long j5 = j3;
        int i2 = nextChunkIndex + this.g;
        int selectedIndex = this.e.getSelectedIndex();
        chunkHolder.chunk = a(this.e.getSelectedFormat(), this.d, streamElement.buildRequestUri(this.e.getIndexInTrackGroup(selectedIndex), nextChunkIndex), i2, startTimeUs, chunkDurationUs, j5, this.e.getSelectionReason(), this.e.getSelectionData(), this.c[selectedIndex]);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        return (this.h != null || this.e.length() < 2) ? list.size() : this.e.evaluateQueueSize(j, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws java.io.IOException {
        java.io.IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        this.a.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, boolean z, java.lang.Exception exc, long j) {
        if (z && j != -9223372036854775807L) {
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.e;
            if (trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), j)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void release() {
        for (com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor : this.c) {
            chunkExtractor.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean shouldCancelLoad(long j, com.google.android.exoplayer2.source.chunk.Chunk chunk, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        if (this.h != null) {
            return false;
        }
        return this.e.shouldCancelChunkLoad(j, chunk, list);
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateManifest(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest ssManifest) {
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr = this.f.streamElements;
        int i = this.b;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement = streamElementArr[i];
        int i2 = streamElement.chunkCount;
        com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement2 = ssManifest.streamElements[i];
        if (i2 == 0 || streamElement2.chunkCount == 0) {
            this.g += i2;
        } else {
            int i3 = i2 - 1;
            long startTimeUs = streamElement.getStartTimeUs(i3) + streamElement.getChunkDurationUs(i3);
            long startTimeUs2 = streamElement2.getStartTimeUs(0);
            if (startTimeUs <= startTimeUs2) {
                this.g += i2;
            } else {
                this.g += streamElement.getChunkIndex(startTimeUs2);
            }
        }
        this.f = ssManifest;
    }

    @Override // com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource
    public void updateTrackSelection(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        this.e = trackSelection;
    }
}
