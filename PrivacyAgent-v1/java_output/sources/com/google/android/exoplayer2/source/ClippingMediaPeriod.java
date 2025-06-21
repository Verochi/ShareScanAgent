package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class ClippingMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaPeriod.Callback {
    public final com.google.android.exoplayer2.source.MediaPeriod mediaPeriod;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod.Callback n;
    public com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[] t = new com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[0];
    public long u;
    public long v;
    public long w;

    public final class ClippingSampleStream implements com.google.android.exoplayer2.source.SampleStream {
        public final com.google.android.exoplayer2.source.SampleStream n;
        public boolean t;

        public ClippingSampleStream(com.google.android.exoplayer2.source.SampleStream sampleStream) {
            this.n = sampleStream;
        }

        public void a() {
            this.t = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !com.google.android.exoplayer2.source.ClippingMediaPeriod.this.b() && this.n.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws java.io.IOException {
            this.n.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (com.google.android.exoplayer2.source.ClippingMediaPeriod.this.b()) {
                return -3;
            }
            if (this.t) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.n.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -5) {
                com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format);
                int i = format.encoderDelay;
                if (i != 0 || format.encoderPadding != 0) {
                    com.google.android.exoplayer2.source.ClippingMediaPeriod clippingMediaPeriod = com.google.android.exoplayer2.source.ClippingMediaPeriod.this;
                    if (clippingMediaPeriod.v != 0) {
                        i = 0;
                    }
                    formatHolder.format = format.buildUpon().setEncoderDelay(i).setEncoderPadding(clippingMediaPeriod.w == Long.MIN_VALUE ? format.encoderPadding : 0).build();
                }
                return -5;
            }
            com.google.android.exoplayer2.source.ClippingMediaPeriod clippingMediaPeriod2 = com.google.android.exoplayer2.source.ClippingMediaPeriod.this;
            long j = clippingMediaPeriod2.w;
            if (j == Long.MIN_VALUE || ((readData != -4 || decoderInputBuffer.timeUs < j) && !(readData == -3 && clippingMediaPeriod2.getBufferedPositionUs() == Long.MIN_VALUE && !decoderInputBuffer.waitingForKeys))) {
                return readData;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.t = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            if (com.google.android.exoplayer2.source.ClippingMediaPeriod.this.b()) {
                return -3;
            }
            return this.n.skipData(j);
        }
    }

    public ClippingMediaPeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod, boolean z, long j, long j2) {
        this.mediaPeriod = mediaPeriod;
        this.u = z ? j : -9223372036854775807L;
        this.v = j;
        this.w = j2;
    }

    public static boolean c(long j, com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr) {
        if (j != 0) {
            for (com.google.android.exoplayer2.trackselection.TrackSelection trackSelection : trackSelectionArr) {
                if (trackSelection != null) {
                    com.google.android.exoplayer2.Format selectedFormat = trackSelection.getSelectedFormat();
                    if (!com.google.android.exoplayer2.util.MimeTypes.allSamplesAreSyncSamples(selectedFormat.sampleMimeType, selectedFormat.codecs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final com.google.android.exoplayer2.SeekParameters a(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        long constrainValue = com.google.android.exoplayer2.util.Util.constrainValue(seekParameters.toleranceBeforeUs, 0L, j - this.v);
        long j2 = seekParameters.toleranceAfterUs;
        long j3 = this.w;
        long constrainValue2 = com.google.android.exoplayer2.util.Util.constrainValue(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (constrainValue == seekParameters.toleranceBeforeUs && constrainValue2 == seekParameters.toleranceAfterUs) ? seekParameters : new com.google.android.exoplayer2.SeekParameters(constrainValue, constrainValue2);
    }

    public boolean b() {
        return this.u != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        return this.mediaPeriod.continueLoading(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        long j2 = this.v;
        if (j == j2) {
            return j2;
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, a(j, seekParameters));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.w;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.w;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ java.util.List getStreamKeys(java.util.List list) {
        return defpackage.ed1.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.n)).onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        this.n = callback;
        this.mediaPeriod.prepare(this, j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (b()) {
            long j = this.u;
            this.u = -9223372036854775807L;
            long readDiscontinuity = readDiscontinuity();
            return readDiscontinuity != -9223372036854775807L ? readDiscontinuity : j;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(readDiscontinuity2 >= this.v);
        long j2 = this.w;
        if (j2 != Long.MIN_VALUE && readDiscontinuity2 > j2) {
            z = false;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(z);
        return readDiscontinuity2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0 > r7) goto L17;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long seekToUs(long j) {
        this.u = -9223372036854775807L;
        boolean z = false;
        for (com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream clippingSampleStream : this.t) {
            if (clippingSampleStream != null) {
                clippingSampleStream.a();
            }
        }
        long seekToUs = this.mediaPeriod.seekToUs(j);
        if (seekToUs != j) {
            if (seekToUs >= this.v) {
                long j2 = this.w;
                if (j2 != Long.MIN_VALUE) {
                }
            }
            com.google.android.exoplayer2.util.Assertions.checkState(z);
            return seekToUs;
        }
        z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(z);
        return seekToUs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (r2 > r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        this.t = new com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[sampleStreamArr.length];
        com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr2 = new com.google.android.exoplayer2.source.SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[] clippingSampleStreamArr = this.t;
            com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream clippingSampleStream = (com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream) sampleStreamArr[i];
            clippingSampleStreamArr[i] = clippingSampleStream;
            if (clippingSampleStream != null) {
                sampleStream = clippingSampleStream.n;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr2, zArr2, j);
        if (b()) {
            long j3 = this.v;
            if (j == j3 && c(j3, trackSelectionArr)) {
                j2 = selectTracks;
                this.u = j2;
                if (selectTracks != j) {
                    if (selectTracks >= this.v) {
                        long j4 = this.w;
                        if (j4 != Long.MIN_VALUE) {
                        }
                    }
                    z = false;
                    com.google.android.exoplayer2.util.Assertions.checkState(z);
                    for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
                        com.google.android.exoplayer2.source.SampleStream sampleStream2 = sampleStreamArr2[i2];
                        if (sampleStream2 == null) {
                            this.t[i2] = null;
                        } else {
                            com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[] clippingSampleStreamArr2 = this.t;
                            com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream clippingSampleStream2 = clippingSampleStreamArr2[i2];
                            if (clippingSampleStream2 == null || clippingSampleStream2.n != sampleStream2) {
                                clippingSampleStreamArr2[i2] = new com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream(sampleStream2);
                            }
                        }
                        sampleStreamArr[i2] = this.t[i2];
                    }
                    return selectTracks;
                }
                z = true;
                com.google.android.exoplayer2.util.Assertions.checkState(z);
                while (i2 < sampleStreamArr.length) {
                }
                return selectTracks;
            }
        }
        j2 = -9223372036854775807L;
        this.u = j2;
        if (selectTracks != j) {
        }
        z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(z);
        while (i2 < sampleStreamArr.length) {
        }
        return selectTracks;
    }

    public void updateClipping(long j, long j2) {
        this.v = j;
        this.w = j2;
    }
}
