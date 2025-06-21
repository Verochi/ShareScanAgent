package com.google.android.exoplayer2.source.ads;

@androidx.annotation.VisibleForTesting(otherwise = 3)
/* loaded from: classes22.dex */
public final class SinglePeriodAdTimeline extends com.google.android.exoplayer2.source.ForwardingTimeline {
    public final com.google.android.exoplayer2.source.ads.AdPlaybackState a;

    public SinglePeriodAdTimeline(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.source.ads.AdPlaybackState adPlaybackState) {
        super(timeline);
        com.google.android.exoplayer2.util.Assertions.checkState(timeline.getPeriodCount() == 1);
        com.google.android.exoplayer2.util.Assertions.checkState(timeline.getWindowCount() == 1);
        this.a = adPlaybackState;
    }

    @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
    public com.google.android.exoplayer2.Timeline.Period getPeriod(int i, com.google.android.exoplayer2.Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        long j = period.durationUs;
        if (j == -9223372036854775807L) {
            j = this.a.contentDurationUs;
        }
        period.set(period.id, period.uid, period.windowIndex, j, period.getPositionInWindowUs(), this.a);
        return period;
    }
}
