package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class MaskingMediaPeriod implements com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaPeriod.Callback {
    public final com.google.android.exoplayer2.source.MediaSource.MediaPeriodId id;
    public final com.google.android.exoplayer2.source.MediaSource mediaSource;
    public final com.google.android.exoplayer2.upstream.Allocator n;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod t;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaPeriod.Callback u;
    public long v;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener w;
    public boolean x;
    public long y = -9223372036854775807L;

    public interface PrepareListener {
        void onPrepareComplete(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId);

        void onPrepareError(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, java.io.IOException iOException);
    }

    public MaskingMediaPeriod(com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        this.id = mediaPeriodId;
        this.n = allocator;
        this.mediaSource = mediaSource;
        this.v = j;
    }

    public final long a(long j) {
        long j2 = this.y;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j) {
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.t;
        return mediaPeriod != null && mediaPeriod.continueLoading(j);
    }

    public void createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        long a = a(this.v);
        com.google.android.exoplayer2.source.MediaPeriod createPeriod = this.mediaSource.createPeriod(mediaPeriodId, this.n, a);
        this.t = createPeriod;
        if (this.u != null) {
            createPeriod.prepare(this, a);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, com.google.android.exoplayer2.SeekParameters seekParameters) {
        return ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).getAdjustedSeekPositionUs(j, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).getNextLoadPositionUs();
    }

    public long getPreparePositionOverrideUs() {
        return this.y;
    }

    public long getPreparePositionUs() {
        return this.v;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public /* synthetic */ java.util.List getStreamKeys(java.util.List list) {
        return defpackage.ed1.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public com.google.android.exoplayer2.source.TrackGroupArray getTrackGroups() {
        return ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.t;
        return mediaPeriod != null && mediaPeriod.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws java.io.IOException {
        try {
            com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.t;
            if (mediaPeriod != null) {
                mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (java.io.IOException e) {
            com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener prepareListener = this.w;
            if (prepareListener == null) {
                throw e;
            }
            if (this.x) {
                return;
            }
            this.x = true;
            prepareListener.onPrepareError(this.id, e);
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Util.castNonNull(this.u)).onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback) com.google.android.exoplayer2.util.Util.castNonNull(this.u)).onPrepared(this);
        com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener prepareListener = this.w;
        if (prepareListener != null) {
            prepareListener.onPrepareComplete(this.id);
        }
    }

    public void overridePreparePositionUs(long j) {
        this.y = j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback callback, long j) {
        this.u = callback;
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.t;
        if (mediaPeriod != null) {
            mediaPeriod.prepare(this, a(this.v));
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).reevaluateBuffer(j);
    }

    public void releasePeriod() {
        com.google.android.exoplayer2.source.MediaPeriod mediaPeriod = this.t;
        if (mediaPeriod != null) {
            this.mediaSource.releasePeriod(mediaPeriod);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j) {
        return ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).seekToUs(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, boolean[] zArr, com.google.android.exoplayer2.source.SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.y;
        if (j3 == -9223372036854775807L || j != this.v) {
            j2 = j;
        } else {
            this.y = -9223372036854775807L;
            j2 = j3;
        }
        return ((com.google.android.exoplayer2.source.MediaPeriod) com.google.android.exoplayer2.util.Util.castNonNull(this.t)).selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public void setPrepareListener(com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareListener prepareListener) {
        this.w = prepareListener;
    }
}
