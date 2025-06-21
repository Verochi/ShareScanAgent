package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class SilenceMediaSource extends com.google.android.exoplayer2.source.BaseMediaSource {
    public static final com.google.android.exoplayer2.Format A;
    public static final com.google.android.exoplayer2.MediaItem B;
    public static final byte[] C;
    public static final java.lang.String MEDIA_ID = "SilenceMediaSource";
    public final long y;
    public final com.google.android.exoplayer2.MediaItem z;

    public static final class Factory {
        public long a;

        @androidx.annotation.Nullable
        public java.lang.Object b;

        public com.google.android.exoplayer2.source.SilenceMediaSource createMediaSource() {
            com.google.android.exoplayer2.util.Assertions.checkState(this.a > 0);
            return new com.google.android.exoplayer2.source.SilenceMediaSource(this.a, com.google.android.exoplayer2.source.SilenceMediaSource.B.buildUpon().setTag(this.b).build(), null);
        }

        public com.google.android.exoplayer2.source.SilenceMediaSource.Factory setDurationUs(long j) {
            this.a = j;
            return this;
        }

        public com.google.android.exoplayer2.source.SilenceMediaSource.Factory setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.b = obj;
            return this;
        }
    }

    public static final class SilenceMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod {
        public static final com.google.android.exoplayer2.source.TrackGroupArray u = new com.google.android.exoplayer2.source.TrackGroupArray(new com.google.android.exoplayer2.source.TrackGroup(com.google.android.exoplayer2.source.SilenceMediaSource.A));
        public final long n;
        public final java.util.ArrayList<com.google.android.exoplayer2.source.SampleStream> t = new java.util.ArrayList<>();

        public SilenceMediaPeriod(long j) {
            this.n = j;
        }

        public final long a(long j) {
            return com.google.android.exoplayer2.util.Util.constrainValue(j, 0L, this.n);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean continueLoading(long j) {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void discardBuffer(long j, boolean z) {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
            return a(j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getBufferedPositionUs() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long getNextLoadPositionUs() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public /* synthetic */ java.util.List getStreamKeys(java.util.List list) {
            return defpackage.ed1.a(this, list);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
            return u;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean isLoading() {
            return false;
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
            long a = a(j);
            for (int i = 0; i < this.t.size(); i++) {
                ((com.google.android.exoplayer2.source.SilenceMediaSource.SilenceSampleStream) this.t.get(i)).a(a);
            }
            return a;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            long a = a(j);
            for (int i = 0; i < trackSelectionArr.length; i++) {
                com.google.android.exoplayer2.source.SampleStream sampleStream = sampleStreamArr[i];
                if (sampleStream != null && (trackSelectionArr[i] == null || !zArr[i])) {
                    this.t.remove(sampleStream);
                    sampleStreamArr[i] = null;
                }
                if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                    com.google.android.exoplayer2.source.SilenceMediaSource.SilenceSampleStream silenceSampleStream = new com.google.android.exoplayer2.source.SilenceMediaSource.SilenceSampleStream(this.n);
                    silenceSampleStream.a(a);
                    this.t.add(silenceSampleStream);
                    sampleStreamArr[i] = silenceSampleStream;
                    zArr2[i] = true;
                }
            }
            return a;
        }
    }

    public static final class SilenceSampleStream implements com.google.android.exoplayer2.source.SampleStream {
        public final long n;
        public boolean t;
        public long u;

        public SilenceSampleStream(long j) {
            this.n = com.google.android.exoplayer2.source.SilenceMediaSource.f(j);
            a(0L);
        }

        public void a(long j) {
            this.u = com.google.android.exoplayer2.util.Util.constrainValue(com.google.android.exoplayer2.source.SilenceMediaSource.f(j), 0L, this.n);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (!this.t || z) {
                formatHolder.format = com.google.android.exoplayer2.source.SilenceMediaSource.A;
                this.t = true;
                return -5;
            }
            long j = this.n - this.u;
            if (j == 0) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            int min = (int) java.lang.Math.min(com.google.android.exoplayer2.source.SilenceMediaSource.C.length, j);
            decoderInputBuffer.ensureSpaceForWrite(min);
            decoderInputBuffer.data.put(com.google.android.exoplayer2.source.SilenceMediaSource.C, 0, min);
            decoderInputBuffer.timeUs = com.google.android.exoplayer2.source.SilenceMediaSource.g(this.u);
            decoderInputBuffer.addFlag(1);
            this.u += min;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j) {
            long j2 = this.u;
            a(j);
            return (int) ((this.u - j2) / com.google.android.exoplayer2.source.SilenceMediaSource.C.length);
        }
    }

    static {
        com.google.android.exoplayer2.Format build = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/raw").setChannelCount(2).setSampleRate(44100).setPcmEncoding(2).build();
        A = build;
        B = new com.google.android.exoplayer2.MediaItem.Builder().setMediaId(MEDIA_ID).setUri(android.net.Uri.EMPTY).setMimeType(build.sampleMimeType).build();
        C = new byte[com.google.android.exoplayer2.util.Util.getPcmFrameSize(2, 2) * 1024];
    }

    public SilenceMediaSource(long j) {
        this(j, B);
    }

    public SilenceMediaSource(long j, com.google.android.exoplayer2.MediaItem mediaItem) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j >= 0);
        this.y = j;
        this.z = mediaItem;
    }

    public /* synthetic */ SilenceMediaSource(long j, com.google.android.exoplayer2.MediaItem mediaItem, com.google.android.exoplayer2.source.SilenceMediaSource.AnonymousClass1 anonymousClass1) {
        this(j, mediaItem);
    }

    public static long f(long j) {
        return com.google.android.exoplayer2.util.Util.getPcmFrameSize(2, 2) * ((j * 44100) / 1000000);
    }

    public static long g(long j) {
        return ((j / com.google.android.exoplayer2.util.Util.getPcmFrameSize(2, 2)) * 1000000) / 44100;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        return new com.google.android.exoplayer2.source.SilenceMediaSource.SilenceMediaPeriod(this.y);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.z;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return ((com.google.android.exoplayer2.MediaItem.PlaybackProperties) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.z.playbackProperties)).tag;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        refreshSourceInfo(new com.google.android.exoplayer2.source.SinglePeriodTimeline(this.y, true, false, false, (java.lang.Object) null, this.z));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }
}
