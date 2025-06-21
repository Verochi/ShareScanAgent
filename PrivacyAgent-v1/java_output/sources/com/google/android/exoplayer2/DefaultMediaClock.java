package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class DefaultMediaClock implements com.google.android.exoplayer2.util.MediaClock {
    public final com.google.android.exoplayer2.util.StandaloneMediaClock n;
    public final com.google.android.exoplayer2.DefaultMediaClock.PlaybackParametersListener t;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Renderer u;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.MediaClock v;
    public boolean w = true;
    public boolean x;

    public interface PlaybackParametersListener {
        void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(com.google.android.exoplayer2.DefaultMediaClock.PlaybackParametersListener playbackParametersListener, com.google.android.exoplayer2.util.Clock clock) {
        this.t = playbackParametersListener;
        this.n = new com.google.android.exoplayer2.util.StandaloneMediaClock(clock);
    }

    public void a(com.google.android.exoplayer2.Renderer renderer) {
        if (renderer == this.u) {
            this.v = null;
            this.u = null;
            this.w = true;
        }
    }

    public void b(com.google.android.exoplayer2.Renderer renderer) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.MediaClock mediaClock;
        com.google.android.exoplayer2.util.MediaClock mediaClock2 = renderer.getMediaClock();
        if (mediaClock2 == null || mediaClock2 == (mediaClock = this.v)) {
            return;
        }
        if (mediaClock != null) {
            throw com.google.android.exoplayer2.ExoPlaybackException.createForUnexpected(new java.lang.IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.v = mediaClock2;
        this.u = renderer;
        mediaClock2.setPlaybackParameters(this.n.getPlaybackParameters());
    }

    public void c(long j) {
        this.n.resetPosition(j);
    }

    public final boolean d(boolean z) {
        com.google.android.exoplayer2.Renderer renderer = this.u;
        return renderer == null || renderer.isEnded() || (!this.u.isReady() && (z || this.u.hasReadStreamToEnd()));
    }

    public void e() {
        this.x = true;
        this.n.start();
    }

    public void f() {
        this.x = false;
        this.n.stop();
    }

    public long g(boolean z) {
        h(z);
        return getPositionUs();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        com.google.android.exoplayer2.util.MediaClock mediaClock = this.v;
        return mediaClock != null ? mediaClock.getPlaybackParameters() : this.n.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        return this.w ? this.n.getPositionUs() : ((com.google.android.exoplayer2.util.MediaClock) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.v)).getPositionUs();
    }

    public final void h(boolean z) {
        if (d(z)) {
            this.w = true;
            if (this.x) {
                this.n.start();
                return;
            }
            return;
        }
        com.google.android.exoplayer2.util.MediaClock mediaClock = (com.google.android.exoplayer2.util.MediaClock) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.v);
        long positionUs = mediaClock.getPositionUs();
        if (this.w) {
            if (positionUs < this.n.getPositionUs()) {
                this.n.stop();
                return;
            } else {
                this.w = false;
                if (this.x) {
                    this.n.start();
                }
            }
        }
        this.n.resetPosition(positionUs);
        com.google.android.exoplayer2.PlaybackParameters playbackParameters = mediaClock.getPlaybackParameters();
        if (playbackParameters.equals(this.n.getPlaybackParameters())) {
            return;
        }
        this.n.setPlaybackParameters(playbackParameters);
        this.t.onPlaybackParametersChanged(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        com.google.android.exoplayer2.util.MediaClock mediaClock = this.v;
        if (mediaClock != null) {
            mediaClock.setPlaybackParameters(playbackParameters);
            playbackParameters = this.v.getPlaybackParameters();
        }
        this.n.setPlaybackParameters(playbackParameters);
    }
}
