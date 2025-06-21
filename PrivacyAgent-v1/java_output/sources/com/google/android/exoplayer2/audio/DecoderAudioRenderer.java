package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public abstract class DecoderAudioRenderer<T extends com.google.android.exoplayer2.decoder.Decoder<com.google.android.exoplayer2.decoder.DecoderInputBuffer, ? extends com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ? extends com.google.android.exoplayer2.decoder.DecoderException>> extends com.google.android.exoplayer2.BaseRenderer implements com.google.android.exoplayer2.util.MediaClock {
    public final com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher E;
    public final com.google.android.exoplayer2.audio.AudioSink F;
    public final com.google.android.exoplayer2.decoder.DecoderInputBuffer G;
    public com.google.android.exoplayer2.decoder.DecoderCounters H;
    public com.google.android.exoplayer2.Format I;
    public int J;
    public int K;
    public boolean L;

    @androidx.annotation.Nullable
    public T M;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.decoder.DecoderInputBuffer N;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.decoder.SimpleOutputBuffer O;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession P;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession Q;
    public int R;
    public boolean S;
    public boolean T;
    public long U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;

    public final class AudioSinkListener implements com.google.android.exoplayer2.audio.AudioSink.Listener {
        public AudioSinkListener() {
        }

        public /* synthetic */ AudioSinkListener(com.google.android.exoplayer2.audio.DecoderAudioRenderer decoderAudioRenderer, com.google.android.exoplayer2.audio.DecoderAudioRenderer.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i) {
            com.google.android.exoplayer2.audio.DecoderAudioRenderer.this.E.audioSessionId(i);
            com.google.android.exoplayer2.audio.DecoderAudioRenderer.this.onAudioSessionId(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public /* synthetic */ void onOffloadBufferEmptying() {
            defpackage.pe.a(this);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public /* synthetic */ void onOffloadBufferFull(long j) {
            defpackage.pe.b(this, j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionAdvancing(long j) {
            com.google.android.exoplayer2.audio.DecoderAudioRenderer.this.E.positionAdvancing(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            com.google.android.exoplayer2.audio.DecoderAudioRenderer.this.onPositionDiscontinuity();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onSkipSilenceEnabledChanged(boolean z) {
            com.google.android.exoplayer2.audio.DecoderAudioRenderer.this.E.skipSilenceEnabledChanged(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i, long j, long j2) {
            com.google.android.exoplayer2.audio.DecoderAudioRenderer.this.E.underrun(i, j, j2);
        }
    }

    public DecoderAudioRenderer() {
        this((android.os.Handler) null, (com.google.android.exoplayer2.audio.AudioRendererEventListener) null, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public DecoderAudioRenderer(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, new com.google.android.exoplayer2.audio.DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public DecoderAudioRenderer(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink audioSink) {
        super(1);
        this.E = new com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.F = audioSink;
        audioSink.setListener(new com.google.android.exoplayer2.audio.DecoderAudioRenderer.AudioSinkListener(this, null));
        this.G = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.R = 0;
        this.T = true;
    }

    public DecoderAudioRenderer(@androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, null, audioProcessorArr);
    }

    public final boolean b() throws com.google.android.exoplayer2.ExoPlaybackException, com.google.android.exoplayer2.decoder.DecoderException, com.google.android.exoplayer2.audio.AudioSink.ConfigurationException, com.google.android.exoplayer2.audio.AudioSink.InitializationException, com.google.android.exoplayer2.audio.AudioSink.WriteException {
        if (this.O == null) {
            com.google.android.exoplayer2.decoder.SimpleOutputBuffer simpleOutputBuffer = (com.google.android.exoplayer2.decoder.SimpleOutputBuffer) this.M.dequeueOutputBuffer();
            this.O = simpleOutputBuffer;
            if (simpleOutputBuffer == null) {
                return false;
            }
            int i = simpleOutputBuffer.skippedOutputBufferCount;
            if (i > 0) {
                this.H.skippedOutputBufferCount += i;
                this.F.handleDiscontinuity();
            }
        }
        if (this.O.isEndOfStream()) {
            if (this.R == 2) {
                releaseDecoder();
                d();
                this.T = true;
            } else {
                this.O.release();
                this.O = null;
                try {
                    e();
                } catch (com.google.android.exoplayer2.audio.AudioSink.WriteException e) {
                    throw createRendererException(e, getOutputFormat(this.M));
                }
            }
            return false;
        }
        if (this.T) {
            this.F.configure(getOutputFormat(this.M).buildUpon().setEncoderDelay(this.J).setEncoderPadding(this.K).build(), 0, null);
            this.T = false;
        }
        com.google.android.exoplayer2.audio.AudioSink audioSink = this.F;
        com.google.android.exoplayer2.decoder.SimpleOutputBuffer simpleOutputBuffer2 = this.O;
        if (!audioSink.handleBuffer(simpleOutputBuffer2.data, simpleOutputBuffer2.timeUs, 1)) {
            return false;
        }
        this.H.renderedOutputBufferCount++;
        this.O.release();
        this.O = null;
        return true;
    }

    public final boolean c() throws com.google.android.exoplayer2.decoder.DecoderException, com.google.android.exoplayer2.ExoPlaybackException {
        T t = this.M;
        if (t == null || this.R == 2 || this.X) {
            return false;
        }
        if (this.N == null) {
            com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer = (com.google.android.exoplayer2.decoder.DecoderInputBuffer) t.dequeueInputBuffer();
            this.N = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.R == 1) {
            this.N.setFlags(4);
            this.M.queueInputBuffer(this.N);
            this.N = null;
            this.R = 2;
            return false;
        }
        com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.N, false);
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
        if (this.N.isEndOfStream()) {
            this.X = true;
            this.M.queueInputBuffer(this.N);
            this.N = null;
            return false;
        }
        this.N.flip();
        onQueueInputBuffer(this.N);
        this.M.queueInputBuffer(this.N);
        this.S = true;
        this.H.inputBufferCount++;
        this.N = null;
        return true;
    }

    public boolean canKeepCodec(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        return false;
    }

    public abstract T createDecoder(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto) throws com.google.android.exoplayer2.decoder.DecoderException;

    public final void d() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.drm.ExoMediaCrypto exoMediaCrypto;
        if (this.M != null) {
            return;
        }
        f(this.Q);
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.P;
        if (drmSession != null) {
            exoMediaCrypto = drmSession.getMediaCrypto();
            if (exoMediaCrypto == null && this.P.getError() == null) {
                return;
            }
        } else {
            exoMediaCrypto = null;
        }
        try {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.google.android.exoplayer2.util.TraceUtil.beginSection("createAudioDecoder");
            this.M = createDecoder(this.I, exoMediaCrypto);
            com.google.android.exoplayer2.util.TraceUtil.endSection();
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            this.E.decoderInitialized(this.M.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.H.decoderInitCount++;
        } catch (com.google.android.exoplayer2.decoder.DecoderException e) {
            throw createRendererException(e, this.I);
        }
    }

    public final void e() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        this.Y = true;
        this.F.playToEndOfStream();
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z) {
        this.L = z;
    }

    public final void f(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession) {
        defpackage.r60.b(this.P, drmSession);
        this.P = drmSession;
    }

    public final void flushDecoder() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.R != 0) {
            releaseDecoder();
            d();
            return;
        }
        this.N = null;
        com.google.android.exoplayer2.decoder.SimpleOutputBuffer simpleOutputBuffer = this.O;
        if (simpleOutputBuffer != null) {
            simpleOutputBuffer.release();
            this.O = null;
        }
        this.M.flush();
        this.S = false;
    }

    public final void g(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession) {
        defpackage.r60.b(this.Q, drmSession);
        this.Q = drmSession;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return this;
    }

    public abstract com.google.android.exoplayer2.Format getOutputFormat(T t);

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.F.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            h();
        }
        return this.U;
    }

    public final int getSinkFormatSupport(com.google.android.exoplayer2.Format format) {
        return this.F.getFormatSupport(format);
    }

    public final void h() {
        long currentPositionUs = this.F.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.W) {
                currentPositionUs = java.lang.Math.max(this.U, currentPositionUs);
            }
            this.U = currentPositionUs;
            this.W = false;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i == 2) {
            this.F.setVolume(((java.lang.Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            this.F.setAudioAttributes((com.google.android.exoplayer2.audio.AudioAttributes) obj);
            return;
        }
        if (i == 5) {
            this.F.setAuxEffectInfo((com.google.android.exoplayer2.audio.AuxEffectInfo) obj);
        } else if (i == 101) {
            this.F.setSkipSilenceEnabled(((java.lang.Boolean) obj).booleanValue());
        } else if (i != 102) {
            super.handleMessage(i, obj);
        } else {
            this.F.setAudioSessionId(((java.lang.Integer) obj).intValue());
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.Y && this.F.isEnded();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.F.hasPendingData() || (this.I != null && (isSourceReady() || this.O != null));
    }

    public void onAudioSessionId(int i) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.I = null;
        this.T = true;
        try {
            g(null);
            releaseDecoder();
            this.F.reset();
        } finally {
            this.E.disabled(this.H);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
        this.H = decoderCounters;
        this.E.enabled(decoderCounters);
        int i = getConfiguration().tunnelingAudioSessionId;
        if (i != 0) {
            this.F.enableTunnelingV21(i);
        } else {
            this.F.disableTunneling();
        }
    }

    public final void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder formatHolder) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format);
        g(formatHolder.drmSession);
        com.google.android.exoplayer2.Format format2 = this.I;
        this.I = format;
        if (this.M == null) {
            d();
        } else if (this.Q != this.P || !canKeepCodec(format2, format)) {
            if (this.S) {
                this.R = 1;
            } else {
                releaseDecoder();
                d();
                this.T = true;
            }
        }
        com.google.android.exoplayer2.Format format3 = this.I;
        this.J = format3.encoderDelay;
        this.K = format3.encoderPadding;
        this.E.inputFormatChanged(format3);
    }

    @androidx.annotation.CallSuper
    public void onPositionDiscontinuity() {
        this.W = true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.L) {
            this.F.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.F.flush();
        }
        this.U = j;
        this.V = true;
        this.W = true;
        this.X = false;
        this.Y = false;
        if (this.M != null) {
            flushDecoder();
        }
    }

    public final void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
        if (!this.V || decoderInputBuffer.isDecodeOnly()) {
            return;
        }
        if (java.lang.Math.abs(decoderInputBuffer.timeUs - this.U) > 500000) {
            this.U = decoderInputBuffer.timeUs;
        }
        this.V = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        this.F.play();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        h();
        this.F.pause();
    }

    public final void releaseDecoder() {
        this.N = null;
        this.O = null;
        this.R = 0;
        this.S = false;
        T t = this.M;
        if (t != null) {
            t.release();
            this.M = null;
            this.H.decoderReleaseCount++;
        }
        f(null);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.Y) {
            try {
                this.F.playToEndOfStream();
                return;
            } catch (com.google.android.exoplayer2.audio.AudioSink.WriteException e) {
                throw createRendererException(e, this.I);
            }
        }
        if (this.I == null) {
            com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
            this.G.clear();
            int readSource = readSource(formatHolder, this.G, true);
            if (readSource != -5) {
                if (readSource == -4) {
                    com.google.android.exoplayer2.util.Assertions.checkState(this.G.isEndOfStream());
                    this.X = true;
                    try {
                        e();
                        return;
                    } catch (com.google.android.exoplayer2.audio.AudioSink.WriteException e2) {
                        throw createRendererException(e2, null);
                    }
                }
                return;
            }
            onInputFormatChanged(formatHolder);
        }
        d();
        if (this.M != null) {
            try {
                com.google.android.exoplayer2.util.TraceUtil.beginSection("drainAndFeed");
                while (b()) {
                }
                while (c()) {
                }
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                this.H.ensureUpdated();
            } catch (com.google.android.exoplayer2.audio.AudioSink.ConfigurationException | com.google.android.exoplayer2.audio.AudioSink.InitializationException | com.google.android.exoplayer2.audio.AudioSink.WriteException | com.google.android.exoplayer2.decoder.DecoderException e3) {
                throw createRendererException(e3, this.I);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.F.setPlaybackParameters(playbackParameters);
    }

    public final boolean sinkSupportsFormat(com.google.android.exoplayer2.Format format) {
        return this.F.supportsFormat(format);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(com.google.android.exoplayer2.Format format) {
        if (!com.google.android.exoplayer2.util.MimeTypes.isAudio(format.sampleMimeType)) {
            return defpackage.ub2.a(0);
        }
        int supportsFormatInternal = supportsFormatInternal(format);
        if (supportsFormatInternal <= 2) {
            return defpackage.ub2.a(supportsFormatInternal);
        }
        return defpackage.ub2.b(supportsFormatInternal, 8, com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? 32 : 0);
    }

    public abstract int supportsFormatInternal(com.google.android.exoplayer2.Format format);
}
