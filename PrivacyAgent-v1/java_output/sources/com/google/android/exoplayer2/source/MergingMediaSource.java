package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class MergingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Integer> {
    public static final com.google.android.exoplayer2.MediaItem J = new com.google.android.exoplayer2.MediaItem.Builder().setMediaId("MergingMediaSource").build();
    public final boolean B;
    public final com.google.android.exoplayer2.source.MediaSource[] C;
    public final com.google.android.exoplayer2.Timeline[] D;
    public final java.util.ArrayList<com.google.android.exoplayer2.source.MediaSource> E;
    public final com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory F;
    public int G;
    public long[][] H;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException I;

    public static final class IllegalMergeException extends java.io.IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @java.lang.annotation.Documented
        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    public MergingMediaSource(boolean z, com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this.B = z;
        this.C = mediaSourceArr;
        this.F = compositeSequenceableLoaderFactory;
        this.E = new java.util.ArrayList<>(java.util.Arrays.asList(mediaSourceArr));
        this.G = -1;
        this.D = new com.google.android.exoplayer2.Timeline[mediaSourceArr.length];
        this.H = new long[0][];
    }

    public MergingMediaSource(boolean z, com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(z, new com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(com.google.android.exoplayer2.source.MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    public final void c() {
        com.google.android.exoplayer2.Timeline.Period period = new com.google.android.exoplayer2.Timeline.Period();
        for (int i = 0; i < this.G; i++) {
            long j = -this.D[0].getPeriod(i, period).getPositionInWindowUs();
            int i2 = 1;
            while (true) {
                com.google.android.exoplayer2.Timeline[] timelineArr = this.D;
                if (i2 < timelineArr.length) {
                    this.H[i][i2] = j - (-timelineArr[i2].getPeriod(i, period).getPositionInWindowUs());
                    i2++;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        int length = this.C.length;
        com.google.android.exoplayer2.source.MediaPeriod[] mediaPeriodArr = new com.google.android.exoplayer2.source.MediaPeriod[length];
        int indexOfPeriod = this.D[0].getIndexOfPeriod(mediaPeriodId.periodUid);
        for (int i = 0; i < length; i++) {
            mediaPeriodArr[i] = this.C[i].createPeriod(mediaPeriodId.copyWithPeriodUid(this.D[i].getUidOfPeriod(indexOfPeriod)), allocator, j - this.H[indexOfPeriod][i]);
        }
        return new com.google.android.exoplayer2.source.MergingMediaPeriod(this.F, this.H[indexOfPeriod], mediaPeriodArr);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        com.google.android.exoplayer2.source.MediaSource[] mediaSourceArr = this.C;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].getMediaItem() : J;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(java.lang.Integer num, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        com.google.android.exoplayer2.source.MediaSource[] mediaSourceArr = this.C;
        if (mediaSourceArr.length > 0) {
            return mediaSourceArr[0].getTag();
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws java.io.IOException {
        com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException illegalMergeException = this.I;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(java.lang.Integer num, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        if (this.I != null) {
            return;
        }
        if (this.G == -1) {
            this.G = timeline.getPeriodCount();
        } else if (timeline.getPeriodCount() != this.G) {
            this.I = new com.google.android.exoplayer2.source.MergingMediaSource.IllegalMergeException(0);
            return;
        }
        if (this.H.length == 0) {
            this.H = (long[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Long.TYPE, this.G, this.D.length);
        }
        this.E.remove(mediaSource);
        this.D[num.intValue()] = timeline;
        if (this.E.isEmpty()) {
            if (this.B) {
                c();
            }
            refreshSourceInfo(this.D[0]);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        for (int i = 0; i < this.C.length; i++) {
            prepareChildSource(java.lang.Integer.valueOf(i), this.C[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        com.google.android.exoplayer2.source.MergingMediaPeriod mergingMediaPeriod = (com.google.android.exoplayer2.source.MergingMediaPeriod) mediaPeriod;
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.source.MediaSource[] mediaSourceArr = this.C;
            if (i >= mediaSourceArr.length) {
                return;
            }
            mediaSourceArr[i].releasePeriod(mergingMediaPeriod.a(i));
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        java.util.Arrays.fill(this.D, (java.lang.Object) null);
        this.G = -1;
        this.I = null;
        this.E.clear();
        java.util.Collections.addAll(this.E, this.C);
    }
}
