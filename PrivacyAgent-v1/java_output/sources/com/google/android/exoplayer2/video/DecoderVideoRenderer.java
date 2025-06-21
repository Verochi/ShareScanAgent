package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public abstract class DecoderVideoRenderer extends com.google.android.exoplayer2.BaseRenderer {
    public final long E;
    public final int F;
    public final com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher G;
    public final com.google.android.exoplayer2.util.TimedValueQueue<com.google.android.exoplayer2.Format> H;
    public final com.google.android.exoplayer2.decoder.DecoderInputBuffer I;
    public com.google.android.exoplayer2.Format J;
    public com.google.android.exoplayer2.Format K;
    public com.google.android.exoplayer2.decoder.Decoder<com.google.android.exoplayer2.video.VideoDecoderInputBuffer, ? extends com.google.android.exoplayer2.video.VideoDecoderOutputBuffer, ? extends com.google.android.exoplayer2.decoder.DecoderException> L;
    public com.google.android.exoplayer2.video.VideoDecoderInputBuffer M;
    public com.google.android.exoplayer2.video.VideoDecoderOutputBuffer N;

    @androidx.annotation.Nullable
    public android.view.Surface O;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer P;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.video.VideoFrameMetadataListener Q;
    public int R;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession S;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public long Z;
    public long a0;
    public boolean b0;
    public boolean c0;
    public boolean d0;
    protected com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters;
    public int e0;
    public int f0;
    public long g0;
    public int h0;
    public int i0;
    public int j0;
    public long k0;
    public long l0;

    public DecoderVideoRenderer(long j, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoRendererEventListener videoRendererEventListener, int i) {
        super(2);
        this.E = j;
        this.F = i;
        this.a0 = -9223372036854775807L;
        b();
        this.H = new com.google.android.exoplayer2.util.TimedValueQueue<>();
        this.I = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.G = new com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.U = 0;
        this.R = -1;
    }

    public static boolean f(long j) {
        return j < -30000;
    }

    public static boolean g(long j) {
        return j < -500000;
    }

    public final void a() {
        this.W = false;
    }

    public final void b() {
        this.e0 = -1;
        this.f0 = -1;
    }

    public final boolean c(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException, com.google.android.exoplayer2.decoder.DecoderException {
        if (this.N == null) {
            com.google.android.exoplayer2.video.VideoDecoderOutputBuffer dequeueOutputBuffer = this.L.dequeueOutputBuffer();
            this.N = dequeueOutputBuffer;
            if (dequeueOutputBuffer == null) {
                return false;
            }
            com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = this.decoderCounters;
            int i = decoderCounters.skippedOutputBufferCount;
            int i2 = dequeueOutputBuffer.skippedOutputBufferCount;
            decoderCounters.skippedOutputBufferCount = i + i2;
            this.j0 -= i2;
        }
        if (!this.N.isEndOfStream()) {
            boolean q = q(j, j2);
            if (q) {
                onProcessedOutputBuffer(this.N.timeUs);
                this.N = null;
            }
            return q;
        }
        if (this.U == 2) {
            releaseDecoder();
            h();
        } else {
            this.N.release();
            this.N = null;
            this.d0 = true;
        }
        return false;
    }

    public boolean canKeepCodec(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        return false;
    }

    public abstract com.google.android.exoplayer2.decoder.Decoder<com.google.android.exoplayer2.video.VideoDecoderInputBuffer, ? extends com.google.android.exoplayer2.video.VideoDecoderOutputBuffer, ? extends com.google.android.exoplayer2.decoder.DecoderException> createDecoder(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.google.android.exoplayer2.decoder.DecoderException;

    public final boolean d() throws com.google.android.exoplayer2.decoder.DecoderException, com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.decoder.Decoder<com.google.android.exoplayer2.video.VideoDecoderInputBuffer, ? extends com.google.android.exoplayer2.video.VideoDecoderOutputBuffer, ? extends com.google.android.exoplayer2.decoder.DecoderException> decoder = this.L;
        if (decoder == null || this.U == 2 || this.c0) {
            return false;
        }
        if (this.M == null) {
            com.google.android.exoplayer2.video.VideoDecoderInputBuffer dequeueInputBuffer = decoder.dequeueInputBuffer();
            this.M = dequeueInputBuffer;
            if (dequeueInputBuffer == null) {
                return false;
            }
        }
        if (this.U == 1) {
            this.M.setFlags(4);
            this.L.queueInputBuffer(this.M);
            this.M = null;
            this.U = 2;
            return false;
        }
        com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.M, false);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (readSource != -4) {
            if (readSource == -3) {
                return false;
            }
            throw new java.lang.IllegalStateException();
        }
        if (this.M.isEndOfStream()) {
            this.c0 = true;
            this.L.queueInputBuffer(this.M);
            this.M = null;
            return false;
        }
        if (this.b0) {
            this.H.add(this.M.timeUs, this.J);
            this.b0 = false;
        }
        this.M.flip();
        com.google.android.exoplayer2.video.VideoDecoderInputBuffer videoDecoderInputBuffer = this.M;
        videoDecoderInputBuffer.format = this.J;
        onQueueInputBuffer(videoDecoderInputBuffer);
        this.L.queueInputBuffer(this.M);
        this.j0++;
        this.V = true;
        this.decoderCounters.inputBufferCount++;
        this.M = null;
        return true;
    }

    public void dropOutputBuffer(com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        updateDroppedBufferCounters(1);
        videoDecoderOutputBuffer.release();
    }

    public final boolean e() {
        return this.R != -1;
    }

    @androidx.annotation.CallSuper
    public void flushDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        this.j0 = 0;
        if (this.U != 0) {
            releaseDecoder();
            h();
            return;
        }
        this.M = null;
        com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.N;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.N = null;
        }
        this.L.flush();
        this.V = false;
    }

    public final void h() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto;
        if (this.L != null) {
            return;
        }
        r(this.T);
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.S;
        if (drmSession != null) {
            exoMediaCrypto = drmSession.getMediaCrypto();
            if (exoMediaCrypto == null && this.S.getError() == null) {
                return;
            }
        } else {
            exoMediaCrypto = null;
        }
        try {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.L = createDecoder(this.J, exoMediaCrypto);
            setDecoderOutputMode(this.R);
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            onDecoderInitialized(this.L.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (com.google.android.exoplayer2.decoder.DecoderException e) {
            throw createRendererException(e, this.J);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i == 1) {
            setOutputSurface((android.view.Surface) obj);
            return;
        }
        if (i == 8) {
            setOutputBufferRenderer((com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer) obj);
        } else if (i == 6) {
            this.Q = (com.google.android.exoplayer2.video.VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    public final void i() {
        if (this.h0 > 0) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            this.G.droppedFrames(this.h0, elapsedRealtime - this.g0);
            this.h0 = 0;
            this.g0 = elapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.d0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        if (this.J != null && ((isSourceReady() || this.N != null) && (this.W || !e()))) {
            this.a0 = -9223372036854775807L;
            return true;
        }
        if (this.a0 == -9223372036854775807L) {
            return false;
        }
        if (android.os.SystemClock.elapsedRealtime() < this.a0) {
            return true;
        }
        this.a0 = -9223372036854775807L;
        return false;
    }

    public final void j() {
        this.Y = true;
        if (this.W) {
            return;
        }
        this.W = true;
        this.G.renderedFirstFrame(this.O);
    }

    public final void k(int i, int i2) {
        if (this.e0 == i && this.f0 == i2) {
            return;
        }
        this.e0 = i;
        this.f0 = i2;
        this.G.videoSizeChanged(i, i2, 0, 1.0f);
    }

    public final void l() {
        if (this.W) {
            this.G.renderedFirstFrame(this.O);
        }
    }

    public final void m() {
        int i = this.e0;
        if (i == -1 && this.f0 == -1) {
            return;
        }
        this.G.videoSizeChanged(i, this.f0, 0, 1.0f);
    }

    public boolean maybeDropBuffersToKeyframe(long j) throws com.google.android.exoplayer2.ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.j0 + skipSource);
        flushDecoder();
        return true;
    }

    public final void n() {
        m();
        a();
        if (getState() == 2) {
            s();
        }
    }

    public final void o() {
        b();
        a();
    }

    @androidx.annotation.CallSuper
    public void onDecoderInitialized(java.lang.String str, long j, long j2) {
        this.G.decoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.J = null;
        b();
        a();
        try {
            t(null);
            releaseDecoder();
        } finally {
            this.G.disabled(this.decoderCounters);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
        this.decoderCounters = decoderCounters;
        this.G.enabled(decoderCounters);
        this.X = z2;
        this.Y = false;
    }

    @androidx.annotation.CallSuper
    public void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder formatHolder) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.b0 = true;
        com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format);
        t(formatHolder.drmSession);
        com.google.android.exoplayer2.Format format2 = this.J;
        this.J = format;
        if (this.L == null) {
            h();
        } else if (this.T != this.S || !canKeepCodec(format2, format)) {
            if (this.V) {
                this.U = 1;
            } else {
                releaseDecoder();
                h();
            }
        }
        this.G.inputFormatChanged(this.J);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.c0 = false;
        this.d0 = false;
        a();
        this.Z = -9223372036854775807L;
        this.i0 = 0;
        if (this.L != null) {
            flushDecoder();
        }
        if (z) {
            s();
        } else {
            this.a0 = -9223372036854775807L;
        }
        this.H.clear();
    }

    @androidx.annotation.CallSuper
    public void onProcessedOutputBuffer(long j) {
        this.j0--;
    }

    public void onQueueInputBuffer(com.google.android.exoplayer2.video.VideoDecoderInputBuffer videoDecoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.h0 = 0;
        this.g0 = android.os.SystemClock.elapsedRealtime();
        this.k0 = android.os.SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        this.a0 = -9223372036854775807L;
        i();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.l0 = j2;
        super.onStreamChanged(formatArr, j, j2);
    }

    public final void p() {
        m();
        l();
    }

    public final boolean q(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException, com.google.android.exoplayer2.decoder.DecoderException {
        if (this.Z == -9223372036854775807L) {
            this.Z = j;
        }
        long j3 = this.N.timeUs - j;
        if (!e()) {
            if (!f(j3)) {
                return false;
            }
            skipOutputBuffer(this.N);
            return true;
        }
        long j4 = this.N.timeUs - this.l0;
        com.google.android.exoplayer2.Format pollFloor = this.H.pollFloor(j4);
        if (pollFloor != null) {
            this.K = pollFloor;
        }
        long elapsedRealtime = (android.os.SystemClock.elapsedRealtime() * 1000) - this.k0;
        boolean z = getState() == 2;
        if ((this.Y ? !this.W : z || this.X) || (z && shouldForceRenderOutputBuffer(j3, elapsedRealtime))) {
            renderOutputBuffer(this.N, j4, this.K);
            return true;
        }
        if (!z || j == this.Z || (shouldDropBuffersToKeyframe(j3, j2) && maybeDropBuffersToKeyframe(j))) {
            return false;
        }
        if (shouldDropOutputBuffer(j3, j2)) {
            dropOutputBuffer(this.N);
            return true;
        }
        if (j3 < 30000) {
            renderOutputBuffer(this.N, j4, this.K);
            return true;
        }
        return false;
    }

    public final void r(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession) {
        defpackage.r60.b(this.S, drmSession);
        this.S = drmSession;
    }

    @androidx.annotation.CallSuper
    public void releaseDecoder() {
        this.M = null;
        this.N = null;
        this.U = 0;
        this.V = false;
        this.j0 = 0;
        com.google.android.exoplayer2.decoder.Decoder<com.google.android.exoplayer2.video.VideoDecoderInputBuffer, ? extends com.google.android.exoplayer2.video.VideoDecoderOutputBuffer, ? extends com.google.android.exoplayer2.decoder.DecoderException> decoder = this.L;
        if (decoder != null) {
            decoder.release();
            this.L = null;
            this.decoderCounters.decoderReleaseCount++;
        }
        r(null);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.d0) {
            return;
        }
        if (this.J == null) {
            com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
            this.I.clear();
            int readSource = readSource(formatHolder, this.I, true);
            if (readSource != -5) {
                if (readSource == -4) {
                    com.google.android.exoplayer2.util.Assertions.checkState(this.I.isEndOfStream());
                    this.c0 = true;
                    this.d0 = true;
                    return;
                }
                return;
            }
            onInputFormatChanged(formatHolder);
        }
        h();
        if (this.L != null) {
            try {
                com.google.android.exoplayer2.util.TraceUtil.beginSection("drainAndFeed");
                while (c(j, j2)) {
                }
                while (d()) {
                }
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (com.google.android.exoplayer2.decoder.DecoderException e) {
                throw createRendererException(e, this.J);
            }
        }
    }

    public void renderOutputBuffer(com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.decoder.DecoderException {
        com.google.android.exoplayer2.video.VideoFrameMetadataListener videoFrameMetadataListener = this.Q;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, java.lang.System.nanoTime(), format, null);
        }
        this.k0 = com.google.android.exoplayer2.C.msToUs(android.os.SystemClock.elapsedRealtime() * 1000);
        int i = videoDecoderOutputBuffer.mode;
        boolean z = i == 1 && this.O != null;
        boolean z2 = i == 0 && this.P != null;
        if (!z2 && !z) {
            dropOutputBuffer(videoDecoderOutputBuffer);
            return;
        }
        k(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
        if (z2) {
            this.P.setOutputBuffer(videoDecoderOutputBuffer);
        } else {
            renderOutputBufferToSurface(videoDecoderOutputBuffer, this.O);
        }
        this.i0 = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        j();
    }

    public abstract void renderOutputBufferToSurface(com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer, android.view.Surface surface) throws com.google.android.exoplayer2.decoder.DecoderException;

    public final void s() {
        this.a0 = this.E > 0 ? android.os.SystemClock.elapsedRealtime() + this.E : -9223372036854775807L;
    }

    public abstract void setDecoderOutputMode(int i);

    public final void setOutputBufferRenderer(@androidx.annotation.Nullable com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        if (this.P == videoDecoderOutputBufferRenderer) {
            if (videoDecoderOutputBufferRenderer != null) {
                p();
                return;
            }
            return;
        }
        this.P = videoDecoderOutputBufferRenderer;
        if (videoDecoderOutputBufferRenderer == null) {
            this.R = -1;
            o();
            return;
        }
        this.O = null;
        this.R = 0;
        if (this.L != null) {
            setDecoderOutputMode(0);
        }
        n();
    }

    public final void setOutputSurface(@androidx.annotation.Nullable android.view.Surface surface) {
        if (this.O == surface) {
            if (surface != null) {
                p();
                return;
            }
            return;
        }
        this.O = surface;
        if (surface == null) {
            this.R = -1;
            o();
            return;
        }
        this.P = null;
        this.R = 1;
        if (this.L != null) {
            setDecoderOutputMode(1);
        }
        n();
    }

    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return g(j);
    }

    public boolean shouldDropOutputBuffer(long j, long j2) {
        return f(j);
    }

    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return f(j) && j2 > 100000;
    }

    public void skipOutputBuffer(com.google.android.exoplayer2.video.VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        videoDecoderOutputBuffer.release();
    }

    public final void t(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession) {
        defpackage.r60.b(this.T, drmSession);
        this.T = drmSession;
    }

    public void updateDroppedBufferCounters(int i) {
        com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.h0 += i;
        int i2 = this.i0 + i;
        this.i0 = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = java.lang.Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i3 = this.F;
        if (i3 <= 0 || this.h0 < i3) {
            return;
        }
        i();
    }
}
