package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class LoopingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Void> {
    public final com.google.android.exoplayer2.source.MaskingMediaSource B;
    public final int C;
    public final java.util.Map<com.google.android.exoplayer2.source.MediaSource.MediaPeriodId, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> D;
    public final java.util.Map<com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId> E;

    public static final class InfinitelyLoopingTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
        public InfinitelyLoopingTimeline(com.google.android.exoplayer2.Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getNextWindowIndex(int i, int i2, boolean z) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i, i2, z);
            return nextWindowIndex == -1 ? getFirstWindowIndex(z) : nextWindowIndex;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getPreviousWindowIndex(int i, int i2, boolean z) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i, i2, z);
            return previousWindowIndex == -1 ? getLastWindowIndex(z) : previousWindowIndex;
        }
    }

    public static final class LoopingTimeline extends com.google.android.exoplayer2.AbstractConcatenatedTimeline {
        public final com.google.android.exoplayer2.Timeline d;
        public final int e;
        public final int f;
        public final int g;

        public LoopingTimeline(com.google.android.exoplayer2.Timeline timeline, int i) {
            super(false, new com.google.android.exoplayer2.source.ShuffleOrder.UnshuffledShuffleOrder(i));
            this.d = timeline;
            int periodCount = timeline.getPeriodCount();
            this.e = periodCount;
            this.f = timeline.getWindowCount();
            this.g = i;
            if (periodCount > 0) {
                com.google.android.exoplayer2.util.Assertions.checkState(i <= Integer.MAX_VALUE / periodCount, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(java.lang.Object obj) {
            if (obj instanceof java.lang.Integer) {
                return ((java.lang.Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int i) {
            return i / this.e;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int i) {
            return i / this.f;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public java.lang.Object getChildUidByChildIndex(int i) {
            return java.lang.Integer.valueOf(i);
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int i) {
            return i * this.e;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int i) {
            return i * this.f;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.e * this.g;
        }

        @Override // com.google.android.exoplayer2.AbstractConcatenatedTimeline
        public com.google.android.exoplayer2.Timeline getTimelineByChildIndex(int i) {
            return this.d;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.f * this.g;
        }
    }

    public LoopingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    public LoopingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, int i) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i > 0);
        this.B = new com.google.android.exoplayer2.source.MaskingMediaSource(mediaSource, false);
        this.C = i;
        this.D = new java.util.HashMap();
        this.E = new java.util.HashMap();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        if (this.C == Integer.MAX_VALUE) {
            return this.B.createPeriod(mediaPeriodId, allocator, j);
        }
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(com.google.android.exoplayer2.AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.D.put(copyWithPeriodUid, mediaPeriodId);
        com.google.android.exoplayer2.source.MaskingMediaPeriod createPeriod = this.B.createPeriod(copyWithPeriodUid, allocator, j);
        this.E.put(createPeriod, copyWithPeriodUid);
        return createPeriod;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Timeline getInitialTimeline() {
        return this.C != Integer.MAX_VALUE ? new com.google.android.exoplayer2.source.LoopingMediaSource.LoopingTimeline(this.B.getTimeline(), this.C) : new com.google.android.exoplayer2.source.LoopingMediaSource.InfinitelyLoopingTimeline(this.B.getTimeline());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.B.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(java.lang.Void r2, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return this.C != Integer.MAX_VALUE ? this.D.get(mediaPeriodId) : mediaPeriodId;
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.B.getTag();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(java.lang.Void r1, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        refreshSourceInfo(this.C != Integer.MAX_VALUE ? new com.google.android.exoplayer2.source.LoopingMediaSource.LoopingTimeline(timeline, this.C) : new com.google.android.exoplayer2.source.LoopingMediaSource.InfinitelyLoopingTimeline(timeline));
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.B);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        this.B.releasePeriod(mediaPeriod);
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId remove = this.E.remove(mediaPeriod);
        if (remove != null) {
            this.D.remove(remove);
        }
    }
}
