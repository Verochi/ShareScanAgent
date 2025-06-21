package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
final class MergingMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaPeriod.Callback {
    public final com.google.android.exoplayer2.source.MediaPeriod[] n;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory u;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod.Callback w;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.TrackGroupArray x;
    public com.google.android.exoplayer2.source.SequenceableLoader z;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.MediaPeriod> v = new java.util.ArrayList<>();
    public final java.util.IdentityHashMap<com.google.android.exoplayer2.source.SampleStream, java.lang.Integer> t = new java.util.IdentityHashMap<>();
    public com.google.android.exoplayer2.source.MediaPeriod[] y = new com.google.android.exoplayer2.source.MediaPeriod[0];

    public static final class TimeOffsetMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaPeriod.Callback {
        public final com.google.android.exoplayer2.source.MediaPeriod n;
        public final long t;
        public com.google.android.exoplayer2.source.MediaPeriod.Callback u;

        public TimeOffsetMediaPeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod, long j) {
            this.n = mediaPeriod;
            this.t = j;
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.u)).onContinueLoadingRequested(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            return this.n.continueLoading(j - this.t);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j, boolean z) {
            this.n.discardBuffer(j - this.t, z);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
            return this.n.getAdjustedSeekPositionUs(j - this.t, seekParameters) + this.t;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.n.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.t + bufferedPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.n.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.t + nextLoadPositionUs;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public java.util.List<com.google.android.exoplayer2.offline.StreamKey> getStreamKeys(java.util.List<com.google.android.exoplayer2.trackselection.TrackSelection> list) {
            return this.n.getStreamKeys(list);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
            return this.n.getTrackGroups();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean isLoading() {
            return this.n.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void maybeThrowPrepareError() throws java.io.IOException {
            this.n.maybeThrowPrepareError();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.u)).onPrepared(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
            this.u = callback;
            this.n.prepare(this, j - this.t);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long readDiscontinuity() {
            long readDiscontinuity = this.n.readDiscontinuity();
            if (readDiscontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.t + readDiscontinuity;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void reevaluateBuffer(long j) {
            this.n.reevaluateBuffer(j - this.t);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long seekToUs(long j) {
            return this.n.seekToUs(j - this.t) + this.t;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr2 = new com.google.android.exoplayer2.source.SampleStream[sampleStreamArr.length];
            int i = 0;
            while (true) {
                com.google.android.exoplayer2.source.SampleStream sampleStream = null;
                if (i >= sampleStreamArr.length) {
                    break;
                }
                com.google.android.exoplayer2.source.MergingMediaPeriod.TimeOffsetSampleStream timeOffsetSampleStream = (com.google.android.exoplayer2.source.MergingMediaPeriod.TimeOffsetSampleStream) sampleStreamArr[i];
                if (timeOffsetSampleStream != null) {
                    sampleStream = timeOffsetSampleStream.a();
                }
                sampleStreamArr2[i] = sampleStream;
                i++;
            }
            long selectTracks = this.n.selectTracks(trackSelectionArr, zArr, sampleStreamArr2, zArr2, j - this.t);
            for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
                com.google.android.exoplayer2.source.SampleStream sampleStream2 = sampleStreamArr2[i2];
                if (sampleStream2 == null) {
                    sampleStreamArr[i2] = null;
                } else {
                    com.google.android.exoplayer2.source.SampleStream sampleStream3 = sampleStreamArr[i2];
                    if (sampleStream3 == null || ((com.google.android.exoplayer2.source.MergingMediaPeriod.TimeOffsetSampleStream) sampleStream3).a() != sampleStream2) {
                        sampleStreamArr[i2] = new com.google.android.exoplayer2.source.MergingMediaPeriod.TimeOffsetSampleStream(sampleStream2, this.t);
                    }
                }
            }
            return selectTracks + this.t;
        }
    }

    public static final class TimeOffsetSampleStream implements com.google.android.exoplayer2.source.SampleStream {
        public final com.google.android.exoplayer2.source.SampleStream n;
        public final long t;

        public TimeOffsetSampleStream(com.google.android.exoplayer2.source.SampleStream sampleStream, long j) {
            this.n = sampleStream;
            this.t = j;
        }

        public com.google.android.exoplayer2.source.SampleStream a() {
            return this.n;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return this.n.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws java.io.IOException {
            this.n.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
            int readData = this.n.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -4) {
                decoderInputBuffer.timeUs = java.lang.Math.max(0L, decoderInputBuffer.timeUs + this.t);
            }
            return readData;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            return this.n.skipData(j - this.t);
        }
    }

    public MergingMediaPeriod(com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, com.google.android.exoplayer2.source.MediaPeriod... mediaPeriodArr) {
        this.u = compositeSequenceableLoaderFactory;
        this.n = mediaPeriodArr;
        this.z = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new com.google.android.exoplayer2.source.SequenceableLoader[0]);
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.n[i] = new com.google.android.exoplayer2.source.MergingMediaPeriod.TimeOffsetMediaPeriod(mediaPeriodArr[i], j);
            }
        }
    }

    public com.google.android.exoplayer2.source.MediaPeriod a(int i) {
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.n[i];
        return mediaPeriod instanceof com.google.android.exoplayer2.source.MergingMediaPeriod.TimeOffsetMediaPeriod ? ((com.google.android.exoplayer2.source.MergingMediaPeriod.TimeOffsetMediaPeriod) mediaPeriod).n : mediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.w)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        if (this.v.isEmpty()) {
            return this.z.continueLoading(j);
        }
        int size = this.v.size();
        for (int i = 0; i < size; i++) {
            this.v.get(i).continueLoading(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.y) {
            mediaPeriod.discardBuffer(j, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.y;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.n[0]).getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.z.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.z.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ java.util.List getStreamKeys(java.util.List list) {
        return defpackage.ed1.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return (com.google.android.exoplayer2.source.TrackGroupArray) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.z.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.n) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.v.remove(mediaPeriod);
        if (this.v.isEmpty()) {
            int i = 0;
            for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod2 : this.n) {
                i += mediaPeriod2.getTrackGroups().length;
            }
            com.google.android.exoplayer2.source.TrackGroup[] trackGroupArr = new com.google.android.exoplayer2.source.TrackGroup[i];
            int i2 = 0;
            for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod3 : this.n) {
                com.google.android.exoplayer2.source.TrackGroupArray trackGroups = mediaPeriod3.getTrackGroups();
                int i3 = trackGroups.length;
                int i4 = 0;
                while (i4 < i3) {
                    trackGroupArr[i2] = trackGroups.get(i4);
                    i4++;
                    i2++;
                }
            }
            this.x = new com.google.android.exoplayer2.source.TrackGroupArray(trackGroupArr);
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.w)).onPrepared(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        this.w = callback;
        java.util.Collections.addAll(this.v, this.n);
        for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.n) {
            mediaPeriod.prepare(this, j);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        long j = -9223372036854775807L;
        for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod : this.y) {
            long readDiscontinuity = mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != -9223372036854775807L) {
                if (j == -9223372036854775807L) {
                    for (com.google.android.exoplayer2.source.MediaPeriod mediaPeriod2 : this.y) {
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        }
                        if (mediaPeriod2.seekToUs(readDiscontinuity) != readDiscontinuity) {
                            throw new java.lang.IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = readDiscontinuity;
                } else if (readDiscontinuity != j) {
                    throw new java.lang.IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j != -9223372036854775807L && mediaPeriod.seekToUs(j) != j) {
                throw new java.lang.IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.z.reevaluateBuffer(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        long seekToUs = this.y[0].seekToUs(j);
        int i = 1;
        while (true) {
            com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.y;
            if (i >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i].seekToUs(seekToUs) != seekToUs) {
                throw new java.lang.IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        for (int i = 0; i < trackSelectionArr.length; i++) {
            com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i];
            java.lang.Integer num = sampleStream == null ? null : this.t.get(sampleStream);
            iArr[i] = num == null ? -1 : num.intValue();
            iArr2[i] = -1;
            com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = trackSelectionArr[i];
            if (trackSelection != null) {
                com.google.android.exoplayer2.source.TrackGroup trackGroup = trackSelection.getTrackGroup();
                int i2 = 0;
                while (true) {
                    com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = this.n;
                    if (i2 >= mediaPeriodArr.length) {
                        break;
                    }
                    if (mediaPeriodArr[i2].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.t.clear();
        int length = trackSelectionArr.length;
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr2 = new com.google.android.exoplayer2.source.SampleStream[length];
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr3 = new com.google.android.exoplayer2.source.SampleStream[trackSelectionArr.length];
        com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr2 = new com.google.android.exoplayer2.trackselection.TrackSelection[trackSelectionArr.length];
        java.util.ArrayList arrayList = new java.util.ArrayList(this.n.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.n.length) {
            for (int i4 = 0; i4 < trackSelectionArr.length; i4++) {
                sampleStreamArr3[i4] = iArr[i4] == i3 ? sampleStreamArr[i4] : null;
                trackSelectionArr2[i4] = iArr2[i4] == i3 ? trackSelectionArr[i4] : null;
            }
            int i5 = i3;
            java.util.ArrayList arrayList2 = arrayList;
            com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
            long selectTracks = this.n[i3].selectTracks(trackSelectionArr2, zArr, sampleStreamArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = selectTracks;
            } else if (selectTracks != j2) {
                throw new java.lang.IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < trackSelectionArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    com.google.android.exoplayer2.source.SampleStream sampleStream2 = (com.google.android.exoplayer2.source.SampleStream) com.google.android.exoplayer2.util.Assertions.checkNotNull(sampleStreamArr3[i6]);
                    sampleStreamArr2[i6] = sampleStreamArr3[i6];
                    this.t.put(sampleStream2, java.lang.Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    com.google.android.exoplayer2.util.Assertions.checkState(sampleStreamArr3[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.n[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            trackSelectionArr2 = trackSelectionArr3;
        }
        java.lang.System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, length);
        com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr2 = (com.google.android.exoplayer2.source.MediaPeriod[]) arrayList.toArray(new com.google.android.exoplayer2.source.MediaPeriod[0]);
        this.y = mediaPeriodArr2;
        this.z = this.u.createCompositeSequenceableLoader(mediaPeriodArr2);
        return j2;
    }
}
