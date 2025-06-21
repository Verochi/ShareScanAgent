package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class StandaloneMediaClock implements com.google.android.exoplayer2.util.MediaClock {
    public final com.google.android.exoplayer2.util.Clock n;
    public boolean t;
    public long u;
    public long v;
    public com.google.android.exoplayer2.PlaybackParameters w = com.google.android.exoplayer2.PlaybackParameters.DEFAULT;

    public StandaloneMediaClock(com.google.android.exoplayer2.util.Clock clock) {
        this.n = clock;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        long j = this.u;
        if (!this.t) {
            return j;
        }
        long elapsedRealtime = this.n.elapsedRealtime() - this.v;
        com.google.android.exoplayer2.PlaybackParameters playbackParameters = this.w;
        return j + (playbackParameters.speed == 1.0f ? com.google.android.exoplayer2.C.msToUs(elapsedRealtime) : playbackParameters.getMediaTimeUsForPlayoutTimeMs(elapsedRealtime));
    }

    public void resetPosition(long j) {
        this.u = j;
        if (this.t) {
            this.v = this.n.elapsedRealtime();
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        if (this.t) {
            resetPosition(getPositionUs());
        }
        this.w = playbackParameters;
    }

    public void start() {
        if (this.t) {
            return;
        }
        this.v = this.n.elapsedRealtime();
        this.t = true;
    }

    public void stop() {
        if (this.t) {
            resetPosition(getPositionUs());
            this.t = false;
        }
    }
}
