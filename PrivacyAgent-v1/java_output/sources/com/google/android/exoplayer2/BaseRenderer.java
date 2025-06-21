package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
public abstract class BaseRenderer implements com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities {
    public long A;
    public boolean C;
    public boolean D;
    public final int n;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.RendererConfiguration u;
    public int v;
    public int w;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.source.SampleStream x;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format[] y;
    public long z;
    public final com.google.android.exoplayer2.FormatHolder t = new com.google.android.exoplayer2.FormatHolder();
    public long B = Long.MIN_VALUE;

    public BaseRenderer(int i) {
        this.n = i;
    }

    public final com.google.android.exoplayer2.ExoPlaybackException createRendererException(java.lang.Exception exc, @androidx.annotation.Nullable com.google.android.exoplayer2.Format format) {
        int i;
        if (format != null && !this.D) {
            this.D = true;
            try {
                i = defpackage.ub2.d(supportsFormat(format));
            } catch (com.google.android.exoplayer2.ExoPlaybackException unused) {
            } finally {
                this.D = false;
            }
            return com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(exc, getName(), getIndex(), format, i);
        }
        i = 4;
        return com.google.android.exoplayer2.ExoPlaybackException.createForRenderer(exc, getName(), getIndex(), format, i);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void disable() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.w == 1);
        this.t.clear();
        this.w = 0;
        this.x = null;
        this.y = null;
        this.C = false;
        onDisabled();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void enable(com.google.android.exoplayer2.RendererConfiguration rendererConfiguration, com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.w == 0);
        this.u = rendererConfiguration;
        this.w = 1;
        this.A = j;
        onEnabled(z, z2);
        replaceStream(formatArr, sampleStream, j2, j3);
        onPositionReset(j, z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final com.google.android.exoplayer2.RendererCapabilities getCapabilities() {
        return this;
    }

    public final com.google.android.exoplayer2.RendererConfiguration getConfiguration() {
        return (com.google.android.exoplayer2.RendererConfiguration) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.u);
    }

    public final com.google.android.exoplayer2.FormatHolder getFormatHolder() {
        this.t.clear();
        return this.t;
    }

    public final int getIndex() {
        return this.v;
    }

    public final long getLastResetPositionUs() {
        return this.A;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final long getReadingPositionUs() {
        return this.B;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final int getState() {
        return this.w;
    }

    @Override // com.google.android.exoplayer2.Renderer
    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.source.SampleStream getStream() {
        return this.x;
    }

    public final com.google.android.exoplayer2.Format[] getStreamFormats() {
        return (com.google.android.exoplayer2.Format[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.y);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public final int getTrackType() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean hasReadStreamToEnd() {
        return this.B == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isCurrentStreamFinal() {
        return this.C;
    }

    public final boolean isSourceReady() {
        return hasReadStreamToEnd() ? this.C : ((com.google.android.exoplayer2.source.SampleStream) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x)).isReady();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void maybeThrowStreamError() throws java.io.IOException {
        ((com.google.android.exoplayer2.source.SampleStream) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x)).maybeThrowError();
    }

    public void onDisabled() {
    }

    public void onEnabled(boolean z, boolean z2) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public void onPositionReset(long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public void onReset() {
    }

    public void onStarted() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public void onStopped() {
    }

    public void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    public final int readSource(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z) {
        int readData = ((com.google.android.exoplayer2.source.SampleStream) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x)).readData(formatHolder, decoderInputBuffer, z);
        if (readData == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.B = Long.MIN_VALUE;
                return this.C ? -4 : -3;
            }
            long j = decoderInputBuffer.timeUs + this.z;
            decoderInputBuffer.timeUs = j;
            this.B = java.lang.Math.max(this.B, j);
        } else if (readData == -5) {
            com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format);
            if (format.subsampleOffsetUs != Long.MAX_VALUE) {
                formatHolder.format = format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.z).build();
            }
        }
        return readData;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void replaceStream(com.google.android.exoplayer2.Format[] formatArr, com.google.android.exoplayer2.source.SampleStream sampleStream, long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.C);
        this.x = sampleStream;
        this.B = j2;
        this.y = formatArr;
        this.z = j2;
        onStreamChanged(formatArr, j, j2);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void reset() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.w == 0);
        this.t.clear();
        onReset();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void resetPosition(long j) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.C = false;
        this.A = j;
        this.B = j;
        onPositionReset(j, false);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setCurrentStreamFinal() {
        this.C = true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void setIndex(int i) {
        this.v = i;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public /* synthetic */ void setOperatingRate(float f) {
        defpackage.tb2.a(this, f);
    }

    public int skipSource(long j) {
        return ((com.google.android.exoplayer2.source.SampleStream) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.x)).skipData(j - this.z);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void start() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkState(this.w == 1);
        this.w = 2;
        onStarted();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final void stop() {
        com.google.android.exoplayer2.util.Assertions.checkState(this.w == 2);
        this.w = 1;
        onStopped();
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsMixedMimeTypeAdaptation() throws com.google.android.exoplayer2.ExoPlaybackException {
        return 0;
    }
}
