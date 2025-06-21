package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public abstract class TrackSelector {

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener a;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.upstream.BandwidthMeter b;

    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    public final com.google.android.exoplayer2.upstream.BandwidthMeter getBandwidthMeter() {
        return (com.google.android.exoplayer2.upstream.BandwidthMeter) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b);
    }

    public final void init(com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener invalidationListener, com.google.android.exoplayer2.upstream.BandwidthMeter bandwidthMeter) {
        this.a = invalidationListener;
        this.b = bandwidthMeter;
    }

    public final void invalidate() {
        com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener invalidationListener = this.a;
        if (invalidationListener != null) {
            invalidationListener.onTrackSelectionsInvalidated();
        }
    }

    public abstract void onSelectionActivated(@androidx.annotation.Nullable java.lang.Object obj);

    public abstract com.google.android.exoplayer2.trackselection.TrackSelectorResult selectTracks(com.google.android.exoplayer2.RendererCapabilities[] rendererCapabilitiesArr, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.Timeline timeline) throws com.google.android.exoplayer2.ExoPlaybackException;
}
