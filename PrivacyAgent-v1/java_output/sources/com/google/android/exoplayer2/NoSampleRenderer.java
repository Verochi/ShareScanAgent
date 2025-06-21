package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public abstract class NoSampleRenderer implements com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities {
    public com.google.android.exoplayer2.RendererConfiguration n;
    public int t;
    public int u;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.SampleStream v;
    public boolean w;

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.u == 1);
        this.u = 0;
        this.v = null;
        this.w = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(com.google.android.exoplayer2.RendererConfiguration rendererConfiguration, com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.u == 0);
        this.n = rendererConfiguration;
        this.u = 1;
        onEnabled(z);
        replaceStream(formatArr, sampleStream, j2, j3);
        onPositionReset(j, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final com.google.android.exoplayer2.RendererCapabilities getCapabilities() {
        return this;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.RendererConfiguration getConfiguration() {
        return this.n;
    }

    public final int getIndex() {
        return this.t;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public long getReadingPositionUs() {
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.SampleStream getStream() {
        return this.v;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return 6;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws java.io.IOException {
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public void onPositionReset(long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public void onRendererOffsetChanged(long j) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.w);
        this.v = sampleStream;
        onRendererOffsetChanged(j2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.u == 0);
        onReset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.w = false;
        onPositionReset(j, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.w = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setIndex(int i) {
        this.t = i;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public /* synthetic */ void setOperatingRate(float f) {
        defpackage.tb2.a(this, f);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.u == 1);
        this.u = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.u == 2);
        this.u = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        return defpackage.ub2.a(0);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws com.google.android.exoplayer2.ExoPlaybackException {
        return 0;
    }
}
