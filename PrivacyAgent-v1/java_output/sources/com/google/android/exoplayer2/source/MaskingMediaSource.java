package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class MaskingMediaSource extends com.google.android.exoplayer2.source.CompositeMediaSource<java.lang.Void> {
    public final com.google.android.exoplayer2.source.MediaSource B;
    public final boolean C;
    public final com.google.android.exoplayer2.Timeline.Window D;
    public final com.google.android.exoplayer2.Timeline.Period E;
    public com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline F;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MaskingMediaPeriod G;
    public boolean H;
    public boolean I;
    public boolean J;

    public static final class MaskingTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
        public static final java.lang.Object c = new java.lang.Object();

        @androidx.annotation.Nullable
        public final java.lang.Object a;

        @androidx.annotation.Nullable
        public final java.lang.Object b;

        public MaskingTimeline(com.google.android.exoplayer2.Timeline timeline, @androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
            super(timeline);
            this.a = obj;
            this.b = obj2;
        }

        public static com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline c(com.google.android.exoplayer2.MediaItem mediaItem) {
            return new com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline(new com.google.android.exoplayer2.source.MaskingMediaSource.PlaceholderTimeline(mediaItem), com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID, c);
        }

        public static com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline d(com.google.android.exoplayer2.Timeline timeline, @androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
            return new com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline(timeline, obj, obj2);
        }

        public com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline b(com.google.android.exoplayer2.Timeline timeline) {
            return new com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline(timeline, this.a, this.b);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
            java.lang.Object obj2;
            com.google.android.exoplayer2.Timeline timeline = this.timeline;
            if (c.equals(obj) && (obj2 = this.b) != null) {
                obj = obj2;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
            this.timeline.getPeriod(i, period, z);
            if (com.google.android.exoplayer2.util.Util.areEqual(period.uid, this.b) && z) {
                period.uid = c;
            }
            return period;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i) {
            java.lang.Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
            return com.google.android.exoplayer2.util.Util.areEqual(uidOfPeriod, this.b) ? c : uidOfPeriod;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
            this.timeline.getWindow(i, window, j);
            if (com.google.android.exoplayer2.util.Util.areEqual(window.uid, this.a)) {
                window.uid = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }
    }

    @androidx.annotation.VisibleForTesting
    public static final class PlaceholderTimeline extends com.google.android.exoplayer2.Timeline {
        public final com.google.android.exoplayer2.MediaItem a;

        public PlaceholderTimeline(com.google.android.exoplayer2.MediaItem mediaItem) {
            this.a = mediaItem;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(java.lang.Object obj) {
            return obj == com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.c ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
            return period.set(z ? 0 : null, z ? com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.c : null, 0, -9223372036854775807L, 0L);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public java.lang.Object getUidOfPeriod(int i) {
            return com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.c;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public com.google.android.exoplayer2.Timeline.Window getWindow(int i, com.google.android.exoplayer2.Timeline.Window window, long j) {
            window.set(com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID, this.a, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, false, 0L, -9223372036854775807L, 0, 0, 0L);
            window.isPlaceholder = true;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }
    }

    public MaskingMediaSource(com.google.android.exoplayer2.source.MediaSource mediaSource, boolean z) {
        this.B = mediaSource;
        this.C = z && mediaSource.isSingleWindow();
        this.D = new com.google.android.exoplayer2.Timeline.Window();
        this.E = new com.google.android.exoplayer2.Timeline.Period();
        com.google.android.exoplayer2.Timeline initialTimeline = mediaSource.getInitialTimeline();
        if (initialTimeline == null) {
            this.F = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.c(mediaSource.getMediaItem());
        } else {
            this.F = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.d(initialTimeline, null, null);
            this.J = true;
        }
    }

    public final java.lang.Object c(java.lang.Object obj) {
        return (this.F.b == null || !this.F.b.equals(obj)) ? obj : com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.c;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.source.MaskingMediaPeriod createPeriod(com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.upstream.Allocator allocator, long j) {
        com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod = new com.google.android.exoplayer2.source.MaskingMediaPeriod(this.B, mediaPeriodId, allocator, j);
        if (this.I) {
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(d(mediaPeriodId.periodUid)));
        } else {
            this.G = maskingMediaPeriod;
            if (!this.H) {
                this.H = true;
                prepareChildSource(null, this.B);
            }
        }
        return maskingMediaPeriod;
    }

    public final java.lang.Object d(java.lang.Object obj) {
        return (this.F.b == null || !obj.equals(com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.c)) ? obj : this.F.b;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    public final void e(long j) {
        com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod = this.G;
        int indexOfPeriod = this.F.getIndexOfPeriod(maskingMediaPeriod.id.periodUid);
        if (indexOfPeriod == -1) {
            return;
        }
        long j2 = this.F.getPeriod(indexOfPeriod, this.E).durationUs;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = java.lang.Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.overridePreparePositionUs(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public com.google.android.exoplayer2.MediaItem getMediaItem() {
        return this.B.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(java.lang.Void r1, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.copyWithPeriodUid(c(mediaPeriodId.periodUid));
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    @androidx.annotation.Nullable
    @java.lang.Deprecated
    public java.lang.Object getTag() {
        return this.B.getTag();
    }

    public com.google.android.exoplayer2.Timeline getTimeline() {
        return this.F;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x009a  */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(java.lang.Void r12, com.google.android.exoplayer2.source.MediaSource mediaSource, com.google.android.exoplayer2.Timeline timeline) {
        long j;
        com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod;
        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId copyWithPeriodUid;
        if (this.I) {
            this.F = this.F.b(timeline);
            com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod2 = this.G;
            if (maskingMediaPeriod2 != null) {
                e(maskingMediaPeriod2.getPreparePositionOverrideUs());
            }
        } else if (timeline.isEmpty()) {
            this.F = this.J ? this.F.b(timeline) : com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.d(timeline, com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID, com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.c);
        } else {
            timeline.getWindow(0, this.D);
            long defaultPositionUs = this.D.getDefaultPositionUs();
            com.google.android.exoplayer2.source.MaskingMediaPeriod maskingMediaPeriod3 = this.G;
            if (maskingMediaPeriod3 != null) {
                long preparePositionUs = maskingMediaPeriod3.getPreparePositionUs();
                if (preparePositionUs != 0) {
                    j = preparePositionUs;
                    com.google.android.exoplayer2.Timeline.Window window = this.D;
                    java.lang.Object obj = window.uid;
                    android.util.Pair<java.lang.Object, java.lang.Long> periodPosition = timeline.getPeriodPosition(window, this.E, 0, j);
                    java.lang.Object obj2 = periodPosition.first;
                    long longValue = ((java.lang.Long) periodPosition.second).longValue();
                    this.F = !this.J ? this.F.b(timeline) : com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.d(timeline, obj, obj2);
                    maskingMediaPeriod = this.G;
                    if (maskingMediaPeriod != null) {
                        e(longValue);
                        com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.id;
                        copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(d(mediaPeriodId.periodUid));
                        this.J = true;
                        this.I = true;
                        refreshSourceInfo(this.F);
                        if (copyWithPeriodUid == null) {
                            ((com.google.android.exoplayer2.source.MaskingMediaPeriod) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.G)).createPeriod(copyWithPeriodUid);
                            return;
                        }
                        return;
                    }
                }
            }
            j = defaultPositionUs;
            com.google.android.exoplayer2.Timeline.Window window2 = this.D;
            java.lang.Object obj3 = window2.uid;
            android.util.Pair<java.lang.Object, java.lang.Long> periodPosition2 = timeline.getPeriodPosition(window2, this.E, 0, j);
            java.lang.Object obj22 = periodPosition2.first;
            long longValue2 = ((java.lang.Long) periodPosition2.second).longValue();
            this.F = !this.J ? this.F.b(timeline) : com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.d(timeline, obj3, obj22);
            maskingMediaPeriod = this.G;
            if (maskingMediaPeriod != null) {
            }
        }
        copyWithPeriodUid = null;
        this.J = true;
        this.I = true;
        refreshSourceInfo(this.F);
        if (copyWithPeriodUid == null) {
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(@androidx.annotation.Nullable com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        if (this.C) {
            return;
        }
        this.H = true;
        prepareChildSource(null, this.B);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(com.google.android.exoplayer2.source.MediaPeriod mediaPeriod) {
        ((com.google.android.exoplayer2.source.MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.G) {
            this.G = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.I = false;
        this.H = false;
        super.releaseSourceInternal();
    }
}
