package com.google.android.exoplayer2.source.dash;

/* loaded from: classes22.dex */
public class DefaultDashChunkSource implements com.google.android.exoplayer2.source.dash.DashChunkSource {
    public final com.google.android.exoplayer2.upstream.LoaderErrorThrower a;
    public final int[] b;
    public final int c;
    public final com.google.android.exoplayer2.upstream.DataSource d;
    public final long e;
    public final int f;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler g;
    public com.google.android.exoplayer2.trackselection.TrackSelection h;
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest i;
    public int j;
    public java.io.IOException k;
    public boolean l;
    public long m;
    protected final com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder[] representationHolders;

    public static final class Factory implements com.google.android.exoplayer2.source.dash.DashChunkSource.Factory {
        public final com.google.android.exoplayer2.upstream.DataSource.Factory a;
        public final int b;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
            this(factory, 1);
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory factory, int i) {
            this.a = factory;
            this.b = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashChunkSource.Factory
        public com.google.android.exoplayer2.source.dash.DashChunkSource createDashChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i, int[] iArr, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, int i2, long j, boolean z, java.util.List<com.google.android.exoplayer2.Format> list, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, @androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
            com.google.android.exoplayer2.upstream.DataSource createDataSource = this.a.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource(loaderErrorThrower, dashManifest, i, iArr, trackSelection, i2, createDataSource, j, this.b, z, list, playerTrackEmsgHandler);
        }
    }

    public static final class RepresentationHolder {

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.chunk.ChunkExtractor a;
        public final long b;
        public final long c;
        public final com.google.android.exoplayer2.source.dash.manifest.Representation representation;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.source.dash.DashSegmentIndex segmentIndex;

        public RepresentationHolder(long j, int i, com.google.android.exoplayer2.source.dash.manifest.Representation representation, boolean z, java.util.List<com.google.android.exoplayer2.Format> list, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this(j, representation, d(i, representation, z, list, trackOutput), 0L, representation.getIndex());
        }

        public RepresentationHolder(long j, com.google.android.exoplayer2.source.dash.manifest.Representation representation, @androidx.annotation.Nullable com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor, long j2, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.DashSegmentIndex dashSegmentIndex) {
            this.b = j;
            this.representation = representation;
            this.c = j2;
            this.a = chunkExtractor;
            this.segmentIndex = dashSegmentIndex;
        }

        @androidx.annotation.Nullable
        public static com.google.android.exoplayer2.source.chunk.ChunkExtractor d(int i, com.google.android.exoplayer2.source.dash.manifest.Representation representation, boolean z, java.util.List<com.google.android.exoplayer2.Format> list, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            com.google.android.exoplayer2.extractor.Extractor fragmentedMp4Extractor;
            java.lang.String str = representation.format.containerMimeType;
            if (com.google.android.exoplayer2.util.MimeTypes.isText(str)) {
                if (!"application/x-rawcc".equals(str)) {
                    return null;
                }
                fragmentedMp4Extractor = new com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor(representation.format);
            } else if (com.google.android.exoplayer2.util.MimeTypes.isMatroska(str)) {
                fragmentedMp4Extractor = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor(1);
            } else {
                fragmentedMp4Extractor = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor(z ? 4 : 0, null, null, list, trackOutput);
            }
            return new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor(fragmentedMp4Extractor, i, representation.format);
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder b(long j, com.google.android.exoplayer2.source.dash.manifest.Representation representation) throws com.google.android.exoplayer2.source.BehindLiveWindowException {
            int segmentCount;
            long segmentNum;
            com.google.android.exoplayer2.source.dash.DashSegmentIndex index = this.representation.getIndex();
            com.google.android.exoplayer2.source.dash.DashSegmentIndex index2 = representation.getIndex();
            if (index == null) {
                return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(j, representation, this.a, this.c, index);
            }
            if (index.isExplicit() && (segmentCount = index.getSegmentCount(j)) != 0) {
                long firstSegmentNum = index.getFirstSegmentNum();
                long timeUs = index.getTimeUs(firstSegmentNum);
                long j2 = (segmentCount + firstSegmentNum) - 1;
                long timeUs2 = index.getTimeUs(j2) + index.getDurationUs(j2, j);
                long firstSegmentNum2 = index2.getFirstSegmentNum();
                long timeUs3 = index2.getTimeUs(firstSegmentNum2);
                long j3 = this.c;
                if (timeUs2 == timeUs3) {
                    segmentNum = j3 + ((j2 + 1) - firstSegmentNum2);
                } else {
                    if (timeUs2 < timeUs3) {
                        throw new com.google.android.exoplayer2.source.BehindLiveWindowException();
                    }
                    segmentNum = timeUs3 < timeUs ? j3 - (index2.getSegmentNum(timeUs, j) - firstSegmentNum) : (index.getSegmentNum(timeUs3, j) - firstSegmentNum2) + j3;
                }
                return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(j, representation, this.a, segmentNum, index2);
            }
            return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(j, representation, this.a, this.c, index2);
        }

        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder c(com.google.android.exoplayer2.source.dash.DashSegmentIndex dashSegmentIndex) {
            return new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(this.b, this.representation, this.a, this.c, dashSegmentIndex);
        }

        public long getFirstAvailableSegmentNum(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i, long j) {
            if (getSegmentCount() != -1 || dashManifest.timeShiftBufferDepthMs == -9223372036854775807L) {
                return getFirstSegmentNum();
            }
            return java.lang.Math.max(getFirstSegmentNum(), getSegmentNum(((j - com.google.android.exoplayer2.C.msToUs(dashManifest.availabilityStartTimeMs)) - com.google.android.exoplayer2.C.msToUs(dashManifest.getPeriod(i).startMs)) - com.google.android.exoplayer2.C.msToUs(dashManifest.timeShiftBufferDepthMs)));
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.c;
        }

        public long getLastAvailableSegmentNum(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i, long j) {
            int segmentCount = getSegmentCount();
            return (segmentCount == -1 ? getSegmentNum((j - com.google.android.exoplayer2.C.msToUs(dashManifest.availabilityStartTimeMs)) - com.google.android.exoplayer2.C.msToUs(dashManifest.getPeriod(i).startMs)) : getFirstSegmentNum() + segmentCount) - 1;
        }

        public int getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.b);
        }

        public long getSegmentEndTimeUs(long j) {
            return getSegmentStartTimeUs(j) + this.segmentIndex.getDurationUs(j - this.c, this.b);
        }

        public long getSegmentNum(long j) {
            return this.segmentIndex.getSegmentNum(j, this.b) + this.c;
        }

        public long getSegmentStartTimeUs(long j) {
            return this.segmentIndex.getTimeUs(j - this.c);
        }

        public com.google.android.exoplayer2.source.dash.manifest.RangedUri getSegmentUrl(long j) {
            return this.segmentIndex.getSegmentUrl(j - this.c);
        }
    }

    public static final class RepresentationSegmentIterator extends com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator {
        public final com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder d;

        public RepresentationSegmentIterator(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, long j, long j2) {
            super(j, j2);
            this.d = representationHolder;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.d.getSegmentEndTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.d.getSegmentStartTimeUs(getCurrentIndex());
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public com.google.android.exoplayer2.upstream.DataSpec getDataSpec() {
            checkInBounds();
            return com.google.android.exoplayer2.source.dash.DashUtil.buildDataSpec(this.d.representation, this.d.getSegmentUrl(getCurrentIndex()));
        }
    }

    public DefaultDashChunkSource(com.google.android.exoplayer2.upstream.LoaderErrorThrower loaderErrorThrower, com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i, int[] iArr, com.google.android.exoplayer2.trackselection.TrackSelection trackSelection, int i2, com.google.android.exoplayer2.upstream.DataSource dataSource, long j, int i3, boolean z, java.util.List<com.google.android.exoplayer2.Format> list, @androidx.annotation.Nullable com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler) {
        this.a = loaderErrorThrower;
        this.i = dashManifest;
        this.b = iArr;
        this.h = trackSelection;
        this.c = i2;
        this.d = dataSource;
        this.j = i;
        this.e = j;
        this.f = i3;
        this.g = playerTrackEmsgHandler;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i);
        this.m = -9223372036854775807L;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> a = a();
        this.representationHolders = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder[trackSelection.length()];
        for (int i4 = 0; i4 < this.representationHolders.length; i4++) {
            this.representationHolders[i4] = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder(periodDurationUs, i2, a.get(trackSelection.getIndexInTrackGroup(i4)), z, list, playerTrackEmsgHandler);
        }
    }

    public final java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> a() {
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list = this.i.getPeriod(this.j).adaptationSets;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> arrayList = new java.util.ArrayList<>();
        for (int i : this.b) {
            arrayList.addAll(list.get(i).representations);
        }
        return arrayList;
    }

    public final long b(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, @androidx.annotation.Nullable com.google.android.exoplayer2.source.chunk.MediaChunk mediaChunk, long j, long j2, long j3) {
        return mediaChunk != null ? mediaChunk.getNextChunkIndex() : com.google.android.exoplayer2.util.Util.constrainValue(representationHolder.getSegmentNum(j), j2, j3);
    }

    public final long c(long j) {
        if (this.i.dynamic && this.m != -9223372036854775807L) {
            return this.m - j;
        }
        return -9223372036854775807L;
    }

    public final void d(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, long j) {
        this.m = this.i.dynamic ? representationHolder.getSegmentEndTimeUs(j) : -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        for (com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                return seekParameters.resolveSeekPositionUs(j, segmentStartTimeUs, (segmentStartTimeUs >= j || segmentNum >= ((long) (representationHolder.getSegmentCount() + (-1)))) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void getNextChunk(long j, long j2, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list, com.google.android.exoplayer2.source.chunk.ChunkHolder chunkHolder) {
        int i;
        int i2;
        com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr;
        long j3;
        if (this.k != null) {
            return;
        }
        long j4 = j2 - j;
        long c = c(j);
        long msToUs = com.google.android.exoplayer2.C.msToUs(this.i.availabilityStartTimeMs) + com.google.android.exoplayer2.C.msToUs(this.i.getPeriod(this.j).startMs) + j2;
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.g;
        if (playerTrackEmsgHandler == null || !playerTrackEmsgHandler.maybeRefreshManifestBeforeLoadingNextChunk(msToUs)) {
            long msToUs2 = com.google.android.exoplayer2.C.msToUs(com.google.android.exoplayer2.util.Util.getNowUnixTimeMs(this.e));
            com.google.android.exoplayer2.source.chunk.MediaChunk mediaChunk = list.isEmpty() ? null : list.get(list.size() - 1);
            int length = this.h.length();
            com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] mediaChunkIteratorArr2 = new com.google.android.exoplayer2.source.chunk.MediaChunkIterator[length];
            int i3 = 0;
            while (i3 < length) {
                com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder = this.representationHolders[i3];
                if (representationHolder.segmentIndex == null) {
                    mediaChunkIteratorArr2[i3] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
                    i = i3;
                    i2 = length;
                    mediaChunkIteratorArr = mediaChunkIteratorArr2;
                    j3 = msToUs2;
                } else {
                    long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(this.i, this.j, msToUs2);
                    long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(this.i, this.j, msToUs2);
                    i = i3;
                    i2 = length;
                    mediaChunkIteratorArr = mediaChunkIteratorArr2;
                    j3 = msToUs2;
                    long b = b(representationHolder, mediaChunk, j2, firstAvailableSegmentNum, lastAvailableSegmentNum);
                    if (b < firstAvailableSegmentNum) {
                        mediaChunkIteratorArr[i] = com.google.android.exoplayer2.source.chunk.MediaChunkIterator.EMPTY;
                    } else {
                        mediaChunkIteratorArr[i] = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationSegmentIterator(representationHolder, b, lastAvailableSegmentNum);
                    }
                }
                i3 = i + 1;
                length = i2;
                mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                msToUs2 = j3;
            }
            long j5 = msToUs2;
            this.h.updateSelectedTrack(j, j4, c, list, mediaChunkIteratorArr2);
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder2 = this.representationHolders[this.h.getSelectedIndex()];
            com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor = representationHolder2.a;
            if (chunkExtractor != null) {
                com.google.android.exoplayer2.source.dash.manifest.Representation representation = representationHolder2.representation;
                com.google.android.exoplayer2.source.dash.manifest.RangedUri initializationUri = chunkExtractor.getSampleFormats() == null ? representation.getInitializationUri() : null;
                com.google.android.exoplayer2.source.dash.manifest.RangedUri indexUri = representationHolder2.segmentIndex == null ? representation.getIndexUri() : null;
                if (initializationUri != null || indexUri != null) {
                    chunkHolder.chunk = newInitializationChunk(representationHolder2, this.d, this.h.getSelectedFormat(), this.h.getSelectionReason(), this.h.getSelectionData(), initializationUri, indexUri);
                    return;
                }
            }
            long j6 = representationHolder2.b;
            boolean z = j6 != -9223372036854775807L;
            if (representationHolder2.getSegmentCount() == 0) {
                chunkHolder.endOfStream = z;
                return;
            }
            long firstAvailableSegmentNum2 = representationHolder2.getFirstAvailableSegmentNum(this.i, this.j, j5);
            long lastAvailableSegmentNum2 = representationHolder2.getLastAvailableSegmentNum(this.i, this.j, j5);
            d(representationHolder2, lastAvailableSegmentNum2);
            boolean z2 = z;
            long b2 = b(representationHolder2, mediaChunk, j2, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
            if (b2 < firstAvailableSegmentNum2) {
                this.k = new com.google.android.exoplayer2.source.BehindLiveWindowException();
                return;
            }
            if (b2 > lastAvailableSegmentNum2 || (this.l && b2 >= lastAvailableSegmentNum2)) {
                chunkHolder.endOfStream = z2;
                return;
            }
            if (z2 && representationHolder2.getSegmentStartTimeUs(b2) >= j6) {
                chunkHolder.endOfStream = true;
                return;
            }
            int min = (int) java.lang.Math.min(this.f, (lastAvailableSegmentNum2 - b2) + 1);
            if (j6 != -9223372036854775807L) {
                while (min > 1 && representationHolder2.getSegmentStartTimeUs((min + b2) - 1) >= j6) {
                    min--;
                }
            }
            chunkHolder.chunk = newMediaChunk(representationHolder2, this.d, this.c, this.h.getSelectedFormat(), this.h.getSelectionReason(), this.h.getSelectionData(), b2, min, list.isEmpty() ? j2 : -9223372036854775807L);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public int getPreferredQueueSize(long j, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        return (this.k != null || this.h.length() < 2) ? list.size() : this.h.evaluateQueueSize(j, list);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void maybeThrowError() throws java.io.IOException {
        java.io.IOException iOException = this.k;
        if (iOException != null) {
            throw iOException;
        }
        this.a.maybeThrowError();
    }

    public com.google.android.exoplayer2.source.chunk.Chunk newInitializationChunk(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.Format format, int i, java.lang.Object obj, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri2) {
        com.google.android.exoplayer2.source.dash.manifest.Representation representation = representationHolder.representation;
        if (rangedUri == null || (rangedUri2 = rangedUri.attemptMerge(rangedUri2, representation.baseUrl)) != null) {
            rangedUri = rangedUri2;
        }
        return new com.google.android.exoplayer2.source.chunk.InitializationChunk(dataSource, com.google.android.exoplayer2.source.dash.DashUtil.buildDataSpec(representation, rangedUri), format, i, obj, representationHolder.a);
    }

    public com.google.android.exoplayer2.source.chunk.Chunk newMediaChunk(com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder, com.google.android.exoplayer2.upstream.DataSource dataSource, int i, com.google.android.exoplayer2.Format format, int i2, java.lang.Object obj, long j, int i3, long j2) {
        com.google.android.exoplayer2.source.dash.manifest.Representation representation = representationHolder.representation;
        long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(j);
        com.google.android.exoplayer2.source.dash.manifest.RangedUri segmentUrl = representationHolder.getSegmentUrl(j);
        java.lang.String str = representation.baseUrl;
        if (representationHolder.a == null) {
            return new com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk(dataSource, com.google.android.exoplayer2.source.dash.DashUtil.buildDataSpec(representation, segmentUrl), format, i2, obj, segmentStartTimeUs, representationHolder.getSegmentEndTimeUs(j), j, i, format);
        }
        int i4 = 1;
        int i5 = 1;
        while (i4 < i3) {
            com.google.android.exoplayer2.source.dash.manifest.RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder.getSegmentUrl(i4 + j), str);
            if (attemptMerge == null) {
                break;
            }
            i5++;
            i4++;
            segmentUrl = attemptMerge;
        }
        long segmentEndTimeUs = representationHolder.getSegmentEndTimeUs((i5 + j) - 1);
        long j3 = representationHolder.b;
        return new com.google.android.exoplayer2.source.chunk.ContainerMediaChunk(dataSource, com.google.android.exoplayer2.source.dash.DashUtil.buildDataSpec(representation, segmentUrl), format, i2, obj, segmentStartTimeUs, segmentEndTimeUs, j2, (j3 == -9223372036854775807L || j3 > segmentEndTimeUs) ? -9223372036854775807L : j3, j, i5, -representation.presentationTimeOffsetUs, representationHolder.a);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void onChunkLoadCompleted(com.google.android.exoplayer2.source.chunk.Chunk chunk) {
        com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex;
        if (chunk instanceof com.google.android.exoplayer2.source.chunk.InitializationChunk) {
            int indexOf = this.h.indexOf(((com.google.android.exoplayer2.source.chunk.InitializationChunk) chunk).trackFormat);
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (chunkIndex = representationHolder.a.getChunkIndex()) != null) {
                this.representationHolders[indexOf] = representationHolder.c(new com.google.android.exoplayer2.source.dash.DashWrappingSegmentIndex(chunkIndex, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.g;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.onChunkLoadCompleted(chunk);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean onChunkLoadError(com.google.android.exoplayer2.source.chunk.Chunk chunk, boolean z, java.lang.Exception exc, long j) {
        com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder;
        int segmentCount;
        if (!z) {
            return false;
        }
        com.google.android.exoplayer2.source.dash.PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.g;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.maybeRefreshManifestOnLoadingError(chunk)) {
            return true;
        }
        if (!this.i.dynamic && (chunk instanceof com.google.android.exoplayer2.source.chunk.MediaChunk) && (exc instanceof com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) && ((com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (representationHolder = this.representationHolders[this.h.indexOf(chunk.trackFormat)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((com.google.android.exoplayer2.source.chunk.MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                this.l = true;
                return true;
            }
        }
        if (j == -9223372036854775807L) {
            return false;
        }
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = this.h;
        return trackSelection.blacklist(trackSelection.indexOf(chunk.trackFormat), j);
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public void release() {
        for (com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder representationHolder : this.representationHolders) {
            com.google.android.exoplayer2.source.chunk.ChunkExtractor chunkExtractor = representationHolder.a;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkSource
    public boolean shouldCancelLoad(long j, com.google.android.exoplayer2.source.chunk.Chunk chunk, java.util.List<? extends com.google.android.exoplayer2.source.chunk.MediaChunk> list) {
        if (this.k != null) {
            return false;
        }
        return this.h.shouldCancelChunkLoad(j, chunk, list);
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateManifest(com.google.android.exoplayer2.source.dash.manifest.DashManifest dashManifest, int i) {
        try {
            this.i = dashManifest;
            this.j = i;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i);
            java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Representation> a = a();
            for (int i2 = 0; i2 < this.representationHolders.length; i2++) {
                com.google.android.exoplayer2.source.dash.manifest.Representation representation = a.get(this.h.getIndexInTrackGroup(i2));
                com.google.android.exoplayer2.source.dash.DefaultDashChunkSource.RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i2] = representationHolderArr[i2].b(periodDurationUs, representation);
            }
        } catch (com.google.android.exoplayer2.source.BehindLiveWindowException e) {
            this.k = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.DashChunkSource
    public void updateTrackSelection(com.google.android.exoplayer2.trackselection.TrackSelection trackSelection) {
        this.h = trackSelection;
    }
}
