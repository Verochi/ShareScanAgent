package com.google.android.exoplayer2.audio;

/* loaded from: classes22.dex */
public class MediaCodecAudioRenderer extends com.google.android.exoplayer2.mediacodec.MediaCodecRenderer implements com.google.android.exoplayer2.util.MediaClock {
    public final android.content.Context W0;
    public final com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher X0;
    public final com.google.android.exoplayer2.audio.AudioSink Y0;
    public int Z0;
    public boolean a1;
    public boolean b1;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format c1;
    public long d1;
    public boolean e1;
    public boolean f1;
    public boolean g1;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Renderer.WakeupListener h1;

    public final class AudioSinkListener implements com.google.android.exoplayer2.audio.AudioSink.Listener {
        public AudioSinkListener() {
        }

        public /* synthetic */ AudioSinkListener(com.google.android.exoplayer2.audio.MediaCodecAudioRenderer mediaCodecAudioRenderer, com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onAudioSessionId(int i) {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.X0.audioSessionId(i);
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.onAudioSessionId(i);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onOffloadBufferEmptying() {
            if (com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.h1 != null) {
                com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.h1.onWakeup();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onOffloadBufferFull(long j) {
            if (com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.h1 != null) {
                com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.h1.onSleep(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionAdvancing(long j) {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.X0.positionAdvancing(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onPositionDiscontinuity() {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.onPositionDiscontinuity();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onSkipSilenceEnabledChanged(boolean z) {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.X0.skipSilenceEnabledChanged(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.Listener
        public void onUnderrun(int i, long j, long j2) {
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.this.X0.underrun(i, j, j2);
        }
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, null, null);
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, (com.google.android.exoplayer2.audio.AudioCapabilities) null, new com.google.android.exoplayer2.audio.AudioProcessor[0]);
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioCapabilities audioCapabilities, com.google.android.exoplayer2.audio.AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, new com.google.android.exoplayer2.audio.DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink audioSink) {
        this(context, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    public MediaCodecAudioRenderer(android.content.Context context, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, boolean z, @androidx.annotation.Nullable android.os.Handler handler, @androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, com.google.android.exoplayer2.audio.AudioSink audioSink) {
        super(1, mediaCodecSelector, z, 44100.0f);
        this.W0 = context.getApplicationContext();
        this.Y0 = audioSink;
        this.X0 = new com.google.android.exoplayer2.audio.AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink.setListener(new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer.AudioSinkListener(this, null));
    }

    public static boolean T(java.lang.String str) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER)) {
            java.lang.String str2 = com.google.android.exoplayer2.util.Util.DEVICE;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean U(java.lang.String str) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER)) {
            java.lang.String str2 = com.google.android.exoplayer2.util.Util.DEVICE;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean V() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT == 23) {
            java.lang.String str = com.google.android.exoplayer2.util.Util.MODEL;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final int W(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format) {
        int i;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.name) || (i = com.google.android.exoplayer2.util.Util.SDK_INT) >= 24 || (i == 23 && com.google.android.exoplayer2.util.Util.isTv(this.W0))) {
            return format.maxInputSize;
        }
        return -1;
    }

    public final void X() {
        long currentPositionUs = this.Y0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.f1) {
                currentPositionUs = java.lang.Math.max(this.d1, currentPositionUs);
            }
            this.d1 = currentPositionUs;
            this.f1 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int canKeepCodec(android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        if (W(mediaCodecInfo, format2) > this.Z0) {
            return 0;
        }
        if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, true)) {
            return 3;
        }
        return canKeepCodecWithFlush(format, format2) ? 1 : 0;
    }

    public boolean canKeepCodecWithFlush(com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        return com.google.android.exoplayer2.util.Util.areEqual(format.sampleMimeType, format2.sampleMimeType) && format.channelCount == format2.channelCount && format.sampleRate == format2.sampleRate && format.pcmEncoding == format2.pcmEncoding && format.initializationDataEquals(format2) && !"audio/opus".equals(format.sampleMimeType);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.mediacodec.MediaCodecAdapter mediaCodecAdapter, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable android.media.MediaCrypto mediaCrypto, float f) {
        this.Z0 = getCodecMaxInputSize(mediaCodecInfo, format, getStreamFormats());
        this.a1 = T(mediaCodecInfo.name);
        this.b1 = U(mediaCodecInfo.name);
        boolean z = false;
        mediaCodecAdapter.configure(getMediaFormat(format, mediaCodecInfo.codecMimeType, this.Z0, f), null, mediaCrypto, 0);
        if ("audio/raw".equals(mediaCodecInfo.mimeType) && !"audio/raw".equals(format.sampleMimeType)) {
            z = true;
        }
        if (!z) {
            format = null;
        }
        this.c1 = format;
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean z) {
        this.g1 = z;
    }

    public int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        int W = W(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return W;
        }
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            if (mediaCodecInfo.isSeamlessAdaptationSupported(format, format2, false)) {
                W = java.lang.Math.max(W, W(mediaCodecInfo, format2));
            }
        }
        return W;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float getCodecOperatingRateV23(float f, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        int i = -1;
        for (com.google.android.exoplayer2.Format format2 : formatArr) {
            int i2 = format2.sampleRate;
            if (i2 != -1) {
                i = java.lang.Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f * i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format, boolean z) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.MediaCodecInfo decryptOnlyDecoderInfo;
        java.lang.String str = format.sampleMimeType;
        if (str == null) {
            return java.util.Collections.emptyList();
        }
        if (this.Y0.supportsFormat(format) && (decryptOnlyDecoderInfo = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecryptOnlyDecoderInfo()) != null) {
            return java.util.Collections.singletonList(decryptOnlyDecoderInfo);
        }
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfosSortedByFormatSupport = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z, false), format);
        if ("audio/eac3-joc".equals(str)) {
            java.util.ArrayList arrayList = new java.util.ArrayList(decoderInfosSortedByFormatSupport);
            arrayList.addAll(mediaCodecSelector.getDecoderInfos("audio/eac3", z, false));
            decoderInfosSortedByFormatSupport = arrayList;
        }
        return java.util.Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.MediaClock getMediaClock() {
        return this;
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public android.media.MediaFormat getMediaFormat(com.google.android.exoplayer2.Format format, java.lang.String str, int i, float f) {
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.channelCount);
        mediaFormat.setInteger("sample-rate", format.sampleRate);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        com.google.android.exoplayer2.mediacodec.MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", i);
        int i2 = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i2 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && !V()) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (i2 <= 28 && com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(format.sampleMimeType)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24 && this.Y0.getFormatSupport(com.google.android.exoplayer2.util.Util.getPcmFormat(4, format.channelCount, format.sampleRate)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public java.lang.String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters() {
        return this.Y0.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public long getPositionUs() {
        if (getState() == 2) {
            X();
        }
        return this.d1;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (i == 2) {
            this.Y0.setVolume(((java.lang.Float) obj).floatValue());
        }
        if (i == 3) {
            this.Y0.setAudioAttributes((com.google.android.exoplayer2.audio.AudioAttributes) obj);
            return;
        }
        if (i == 5) {
            this.Y0.setAuxEffectInfo((com.google.android.exoplayer2.audio.AuxEffectInfo) obj);
            return;
        }
        switch (i) {
            case 101:
                this.Y0.setSkipSilenceEnabled(((java.lang.Boolean) obj).booleanValue());
                break;
            case 102:
                this.Y0.setAudioSessionId(((java.lang.Integer) obj).intValue());
                break;
            case 103:
                this.h1 = (com.google.android.exoplayer2.Renderer.WakeupListener) obj;
                break;
            default:
                super.handleMessage(i, obj);
                break;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return super.isEnded() && this.Y0.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.Y0.hasPendingData() || super.isReady();
    }

    public void onAudioSessionId(int i) {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onCodecInitialized(java.lang.String str, long j, long j2) {
        this.X0.decoderInitialized(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        try {
            this.Y0.flush();
            try {
                super.onDisabled();
            } finally {
            }
        } catch (java.lang.Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onEnabled(z, z2);
        this.X0.enabled(this.decoderCounters);
        int i = getConfiguration().tunnelingAudioSessionId;
        if (i != 0) {
            this.Y0.enableTunnelingV21(i);
        } else {
            this.Y0.disableTunneling();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder formatHolder) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onInputFormatChanged(formatHolder);
        this.X0.inputFormatChanged(formatHolder.format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable android.media.MediaFormat mediaFormat) throws com.google.android.exoplayer2.ExoPlaybackException {
        int i;
        com.google.android.exoplayer2.Format format2 = this.c1;
        int[] iArr = null;
        if (format2 == null) {
            if (getCodec() == null) {
                format2 = format;
            } else {
                format2 = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/raw").setPcmEncoding("audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : (com.google.android.exoplayer2.util.Util.SDK_INT < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? com.google.android.exoplayer2.util.Util.getPcmEncoding(mediaFormat.getInteger("v-bits-per-sample")) : "audio/raw".equals(format.sampleMimeType) ? format.pcmEncoding : 2 : mediaFormat.getInteger("pcm-encoding")).setEncoderDelay(format.encoderDelay).setEncoderPadding(format.encoderPadding).setChannelCount(mediaFormat.getInteger("channel-count")).setSampleRate(mediaFormat.getInteger("sample-rate")).build();
                if (this.a1 && format2.channelCount == 6 && (i = format.channelCount) < 6) {
                    iArr = new int[i];
                    for (int i2 = 0; i2 < format.channelCount; i2++) {
                        iArr[i2] = i2;
                    }
                }
            }
        }
        try {
            this.Y0.configure(format2, 0, iArr);
        } catch (com.google.android.exoplayer2.audio.AudioSink.ConfigurationException e) {
            throw createRendererException(e, format);
        }
    }

    @androidx.annotation.CallSuper
    public void onPositionDiscontinuity() {
        this.f1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        super.onPositionReset(j, z);
        if (this.g1) {
            this.Y0.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.Y0.flush();
        }
        this.d1 = j;
        this.e1 = true;
        this.f1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.Y0.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) {
        if (!this.e1 || decoderInputBuffer.isDecodeOnly()) {
            return;
        }
        if (java.lang.Math.abs(decoderInputBuffer.timeUs - this.d1) > 500000) {
            this.d1 = decoderInputBuffer.timeUs;
        }
        this.e1 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            super.onReset();
        } finally {
            this.Y0.reset();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
        super.onStarted();
        this.Y0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
        X();
        this.Y0.pause();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, @androidx.annotation.Nullable android.media.MediaCodec mediaCodec, @androidx.annotation.Nullable java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(byteBuffer);
        if (mediaCodec != null && this.b1 && j3 == 0 && (i2 & 4) != 0 && getLargestQueuedPresentationTimeUs() != -9223372036854775807L) {
            j3 = getLargestQueuedPresentationTimeUs();
        }
        if (this.c1 != null && (i2 & 2) != 0) {
            ((android.media.MediaCodec) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaCodec)).releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            if (mediaCodec != null) {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            this.decoderCounters.skippedOutputBufferCount += i3;
            this.Y0.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.Y0.handleBuffer(byteBuffer, j3, i3)) {
                return false;
            }
            if (mediaCodec != null) {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            this.decoderCounters.renderedOutputBufferCount += i3;
            return true;
        } catch (com.google.android.exoplayer2.audio.AudioSink.InitializationException | com.google.android.exoplayer2.audio.AudioSink.WriteException e) {
            throw createRendererException(e, format);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void renderToEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
        try {
            this.Y0.playToEndOfStream();
        } catch (com.google.android.exoplayer2.audio.AudioSink.WriteException e) {
            com.google.android.exoplayer2.Format outputFormat = getOutputFormat();
            if (outputFormat == null) {
                outputFormat = getInputFormat();
            }
            throw createRendererException(e, outputFormat);
        }
    }

    @Override // com.google.android.exoplayer2.util.MediaClock
    public void setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
        this.Y0.setPlaybackParameters(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean shouldUseBypass(com.google.android.exoplayer2.Format format) {
        return this.Y0.supportsFormat(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        if (!com.google.android.exoplayer2.util.MimeTypes.isAudio(format.sampleMimeType)) {
            return defpackage.ub2.a(0);
        }
        int i = com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? 32 : 0;
        boolean z = format.exoMediaCryptoType != null;
        boolean supportsFormatDrm = com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.supportsFormatDrm(format);
        int i2 = 8;
        if (supportsFormatDrm && this.Y0.supportsFormat(format) && (!z || com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecryptOnlyDecoderInfo() != null)) {
            return defpackage.ub2.b(4, 8, i);
        }
        if ((!"audio/raw".equals(format.sampleMimeType) || this.Y0.supportsFormat(format)) && this.Y0.supportsFormat(com.google.android.exoplayer2.util.Util.getPcmFormat(2, format.channelCount, format.sampleRate))) {
            java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, false);
            if (decoderInfos.isEmpty()) {
                return defpackage.ub2.a(1);
            }
            if (!supportsFormatDrm) {
                return defpackage.ub2.a(2);
            }
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
            boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
            if (isFormatSupported && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
                i2 = 16;
            }
            return defpackage.ub2.b(isFormatSupported ? 4 : 3, i2, i);
        }
        return defpackage.ub2.a(1);
    }
}
