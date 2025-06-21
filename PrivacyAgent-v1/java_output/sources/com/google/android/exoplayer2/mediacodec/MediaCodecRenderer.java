package com.google.android.exoplayer2.mediacodec;

/* loaded from: classes22.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.BaseRenderer {
    protected static final float CODEC_OPERATING_RATE_UNSET = -1.0f;
    protected static final int KEEP_CODEC_RESULT_NO = 0;
    protected static final int KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = 3;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_FLUSH = 1;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = 2;
    public static final int OPERATION_MODE_ASYNCHRONOUS_DEDICATED_THREAD = 2;
    public static final int OPERATION_MODE_ASYNCHRONOUS_DEDICATED_THREAD_ASYNCHRONOUS_QUEUEING = 4;
    public static final int OPERATION_MODE_SYNCHRONOUS = 0;
    public static final byte[] V0 = {0, 0, 1, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, com.google.common.base.Ascii.CAN, -96, 0, 47, -65, com.google.common.base.Ascii.FS, org.apache.tools.tar.TarConstants.LF_LINK, -61, 39, 93, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC};
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public final com.google.android.exoplayer2.mediacodec.MediaCodecSelector E;
    public int E0;
    public final boolean F;
    public int F0;
    public final float G;
    public int G0;
    public final com.google.android.exoplayer2.decoder.DecoderInputBuffer H;
    public boolean H0;
    public final com.google.android.exoplayer2.decoder.DecoderInputBuffer I;
    public boolean I0;
    public final com.google.android.exoplayer2.mediacodec.BatchBuffer J;
    public boolean J0;
    public final com.google.android.exoplayer2.util.TimedValueQueue<com.google.android.exoplayer2.Format> K;
    public long K0;
    public final java.util.ArrayList<java.lang.Long> L;
    public long L0;
    public final android.media.MediaCodec.BufferInfo M;
    public boolean M0;
    public final long[] N;
    public boolean N0;
    public final long[] O;
    public boolean O0;
    public final long[] P;
    public boolean P0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format Q;
    public int Q0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format R;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ExoPlaybackException R0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession S;
    public long S0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.drm.DrmSession T;
    public long T0;

    @androidx.annotation.Nullable
    public android.media.MediaCrypto U;
    public int U0;
    public boolean V;
    public long W;
    public float X;

    @androidx.annotation.Nullable
    public android.media.MediaCodec Y;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.mediacodec.MediaCodecAdapter Z;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format a0;

    @androidx.annotation.Nullable
    public android.media.MediaFormat b0;
    public boolean c0;
    public float d0;
    protected com.google.android.exoplayer2.decoder.DecoderCounters decoderCounters;

    @androidx.annotation.Nullable
    public java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> e0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException f0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.mediacodec.MediaCodecInfo g0;
    public int h0;
    public boolean i0;
    public boolean j0;
    public boolean k0;
    public boolean l0;
    public boolean m0;
    public boolean n0;
    public boolean o0;
    public boolean p0;
    public boolean q0;
    public boolean r0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.mediacodec.C2Mp3TimestampTracker s0;
    public java.nio.ByteBuffer[] t0;
    public java.nio.ByteBuffer[] u0;
    public long v0;
    public int w0;
    public int x0;

    @androidx.annotation.Nullable
    public java.nio.ByteBuffer y0;
    public boolean z0;

    public static class DecoderInitializationException extends java.lang.Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.mediacodec.MediaCodecInfo codecInfo;

        @androidx.annotation.Nullable
        public final java.lang.String diagnosticInfo;

        @androidx.annotation.Nullable
        public final com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException fallbackDecoderInitializationException;
        public final java.lang.String mimeType;
        public final boolean secureDecoderRequired;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DecoderInitializationException(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.lang.Throwable th, boolean z, int i) {
            this(r2.toString(), th, format.sampleMimeType, z, null, buildCustomDiagnosticInfo(i), null);
            java.lang.String valueOf = java.lang.String.valueOf(format);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 36);
            sb.append("Decoder init failed: [");
            sb.append(i);
            sb.append("], ");
            sb.append(valueOf);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DecoderInitializationException(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable java.lang.Throwable th, boolean z, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
            this(r3.toString(), th, format.sampleMimeType, z, mediaCodecInfo, com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? getDiagnosticInfoV21(th) : null, null);
            java.lang.String str = mediaCodecInfo.name;
            java.lang.String valueOf = java.lang.String.valueOf(format);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 23 + valueOf.length());
            sb.append("Decoder init failed: ");
            sb.append(str);
            sb.append(", ");
            sb.append(valueOf);
        }

        private DecoderInitializationException(java.lang.String str, @androidx.annotation.Nullable java.lang.Throwable th, java.lang.String str2, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        private static java.lang.String buildCustomDiagnosticInfo(int i) {
            java.lang.String str = i < 0 ? "neg_" : "";
            int abs = java.lang.Math.abs(i);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 71);
            sb.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            sb.append(str);
            sb.append(abs);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @androidx.annotation.CheckResult
        public com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException copyWithFallbackException(com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException decoderInitializationException) {
            return new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        @androidx.annotation.Nullable
        @androidx.annotation.RequiresApi(21)
        private static java.lang.String getDiagnosticInfoV21(@androidx.annotation.Nullable java.lang.Throwable th) {
            if (th instanceof android.media.MediaCodec.CodecException) {
                return ((android.media.MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    @java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE_PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MediaCodecOperationMode {
    }

    public MediaCodecRenderer(int i, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, boolean z, float f) {
        super(i);
        this.E = (com.google.android.exoplayer2.mediacodec.MediaCodecSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(mediaCodecSelector);
        this.F = z;
        this.G = f;
        this.H = new com.google.android.exoplayer2.decoder.DecoderInputBuffer(0);
        this.I = com.google.android.exoplayer2.decoder.DecoderInputBuffer.newFlagsOnlyInstance();
        this.K = new com.google.android.exoplayer2.util.TimedValueQueue<>();
        this.L = new java.util.ArrayList<>();
        this.M = new android.media.MediaCodec.BufferInfo();
        this.X = 1.0f;
        this.Q0 = 0;
        this.W = -9223372036854775807L;
        this.N = new long[10];
        this.O = new long[10];
        this.P = new long[10];
        this.S0 = -9223372036854775807L;
        this.T0 = -9223372036854775807L;
        this.J = new com.google.android.exoplayer2.mediacodec.BatchBuffer();
        resetCodecStateForRelease();
    }

    @androidx.annotation.RequiresApi(21)
    public static boolean A(java.lang.IllegalStateException illegalStateException) {
        return illegalStateException instanceof android.media.MediaCodec.CodecException;
    }

    @android.annotation.TargetApi(23)
    private void D() throws com.google.android.exoplayer2.ExoPlaybackException {
        int i = this.G0;
        if (i == 1) {
            flushOrReinitializeCodec();
            return;
        }
        if (i == 2) {
            Q();
        } else if (i == 3) {
            I();
        } else {
            this.N0 = true;
            renderToEndOfStream();
        }
    }

    private void N(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession) {
        defpackage.r60.b(this.T, drmSession);
        this.T = drmSession;
    }

    public static boolean c(java.lang.String str, com.google.android.exoplayer2.Format format) {
        return com.google.android.exoplayer2.util.Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean d(java.lang.String str) {
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i <= 19) {
                java.lang.String str2 = com.google.android.exoplayer2.util.Util.DEVICE;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean e(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean f(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        java.lang.String str = mediaCodecInfo.name;
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        return (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(com.google.android.exoplayer2.util.Util.MANUFACTURER) && "AFTS".equals(com.google.android.exoplayer2.util.Util.MODEL) && mediaCodecInfo.secure));
    }

    public static boolean g(java.lang.String str) {
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean h(java.lang.String str, com.google.android.exoplayer2.Format format) {
        return com.google.android.exoplayer2.util.Util.SDK_INT <= 18 && format.channelCount == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean i(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean j(java.lang.String str) {
        return com.google.android.exoplayer2.util.Util.SDK_INT == 29 && "c2.android.aac.decoder".equals(str);
    }

    private boolean p() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.Y == null || this.F0 == 2 || this.M0) {
            return false;
        }
        if (this.w0 < 0) {
            int dequeueInputBufferIndex = this.Z.dequeueInputBufferIndex();
            this.w0 = dequeueInputBufferIndex;
            if (dequeueInputBufferIndex < 0) {
                return false;
            }
            this.H.data = t(dequeueInputBufferIndex);
            this.H.clear();
        }
        if (this.F0 == 1) {
            if (!this.r0) {
                this.I0 = true;
                this.Z.queueInputBuffer(this.w0, 0, 0, 0L, 4);
                K();
            }
            this.F0 = 2;
            return false;
        }
        if (this.p0) {
            this.p0 = false;
            java.nio.ByteBuffer byteBuffer = this.H.data;
            byte[] bArr = V0;
            byteBuffer.put(bArr);
            this.Z.queueInputBuffer(this.w0, 0, bArr.length, 0L, 0);
            K();
            this.H0 = true;
            return true;
        }
        if (this.E0 == 1) {
            for (int i = 0; i < this.a0.initializationData.size(); i++) {
                this.H.data.put(this.a0.initializationData.get(i));
            }
            this.E0 = 2;
        }
        int position = this.H.data.position();
        com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
        int readSource = readSource(formatHolder, this.H, false);
        if (hasReadStreamToEnd()) {
            this.L0 = this.K0;
        }
        if (readSource == -3) {
            return false;
        }
        if (readSource == -5) {
            if (this.E0 == 2) {
                this.H.clear();
                this.E0 = 1;
            }
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (this.H.isEndOfStream()) {
            if (this.E0 == 2) {
                this.H.clear();
                this.E0 = 1;
            }
            this.M0 = true;
            if (!this.H0) {
                D();
                return false;
            }
            try {
                if (!this.r0) {
                    this.I0 = true;
                    this.Z.queueInputBuffer(this.w0, 0, 0, 0L, 4);
                    K();
                }
                return false;
            } catch (android.media.MediaCodec.CryptoException e) {
                throw createRendererException(e, this.Q);
            }
        }
        if (!this.H0 && !this.H.isKeyFrame()) {
            this.H.clear();
            if (this.E0 == 2) {
                this.E0 = 1;
            }
            return true;
        }
        boolean isEncrypted = this.H.isEncrypted();
        if (isEncrypted) {
            this.H.cryptoInfo.increaseClearDataFirstSubSampleBy(position);
        }
        if (this.j0 && !isEncrypted) {
            com.google.android.exoplayer2.util.NalUnitUtil.discardToSps(this.H.data);
            if (this.H.data.position() == 0) {
                return true;
            }
            this.j0 = false;
        }
        com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer = this.H;
        long j = decoderInputBuffer.timeUs;
        com.google.android.exoplayer2.mediacodec.C2Mp3TimestampTracker c2Mp3TimestampTracker = this.s0;
        if (c2Mp3TimestampTracker != null) {
            j = c2Mp3TimestampTracker.c(this.Q, decoderInputBuffer);
        }
        long j2 = j;
        if (this.H.isDecodeOnly()) {
            this.L.add(java.lang.Long.valueOf(j2));
        }
        if (this.O0) {
            this.K.add(j2, this.Q);
            this.O0 = false;
        }
        if (this.s0 != null) {
            this.K0 = java.lang.Math.max(this.K0, this.H.timeUs);
        } else {
            this.K0 = java.lang.Math.max(this.K0, j2);
        }
        this.H.flip();
        if (this.H.hasSupplementalData()) {
            handleInputBufferSupplementalData(this.H);
        }
        onQueueInputBuffer(this.H);
        try {
            if (isEncrypted) {
                this.Z.queueSecureInputBuffer(this.w0, 0, this.H.cryptoInfo, j2, 0);
            } else {
                this.Z.queueInputBuffer(this.w0, 0, this.H.data.limit(), j2, 0);
            }
            K();
            this.H0 = true;
            this.E0 = 0;
            this.decoderCounters.inputBufferCount++;
            return true;
        } catch (android.media.MediaCodec.CryptoException e2) {
            throw createRendererException(e2, this.Q);
        }
    }

    public static boolean supportsFormatDrm(com.google.android.exoplayer2.Format format) {
        java.lang.Class<? extends com.google.android.exoplayer2.drm.ExoMediaCrypto> cls = format.exoMediaCryptoType;
        return cls == null || com.google.android.exoplayer2.drm.FrameworkMediaCrypto.class.equals(cls);
    }

    public static boolean z(java.lang.IllegalStateException illegalStateException) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 21 && A(illegalStateException)) {
            return true;
        }
        java.lang.StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    public final void B(android.media.MediaCrypto mediaCrypto, boolean z) throws com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException {
        if (this.e0 == null) {
            try {
                java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> q = q(z);
                java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> arrayDeque = new java.util.ArrayDeque<>();
                this.e0 = arrayDeque;
                if (this.F) {
                    arrayDeque.addAll(q);
                } else if (!q.isEmpty()) {
                    this.e0.add(q.get(0));
                }
                this.f0 = null;
            } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException e) {
                throw new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(this.Q, e, z, -49998);
            }
        }
        if (this.e0.isEmpty()) {
            throw new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(this.Q, (java.lang.Throwable) null, z, -49999);
        }
        while (this.Y == null) {
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo peekFirst = this.e0.peekFirst();
            if (!shouldInitCodec(peekFirst)) {
                return;
            }
            try {
                x(peekFirst, mediaCrypto);
            } catch (java.lang.Exception e2) {
                java.lang.String valueOf = java.lang.String.valueOf(peekFirst);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 30);
                sb.append("Failed to initialize decoder: ");
                sb.append(valueOf);
                com.google.android.exoplayer2.util.Log.w("MediaCodecRenderer", sb.toString(), e2);
                this.e0.removeFirst();
                com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException decoderInitializationException = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException(this.Q, e2, z, peekFirst);
                if (this.f0 == null) {
                    this.f0 = decoderInitializationException;
                } else {
                    this.f0 = this.f0.copyWithFallbackException(decoderInitializationException);
                }
                if (this.e0.isEmpty()) {
                    throw this.f0;
                }
            }
        }
        this.e0 = null;
    }

    public final boolean C(com.google.android.exoplayer2.drm.DrmSession drmSession, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.drm.FrameworkMediaCrypto s2 = s(drmSession);
        if (s2 == null) {
            return true;
        }
        if (s2.forceAllowInsecureDecoderComponents) {
            return false;
        }
        try {
            android.media.MediaCrypto mediaCrypto = new android.media.MediaCrypto(s2.uuid, s2.sessionId);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(format.sampleMimeType);
            } finally {
                mediaCrypto.release();
            }
        } catch (android.media.MediaCryptoException unused) {
            return true;
        }
    }

    public final void E() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            this.u0 = this.Y.getOutputBuffers();
        }
    }

    public final void F() {
        this.J0 = true;
        android.media.MediaFormat outputFormat = this.Z.getOutputFormat();
        if (this.h0 != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.q0 = true;
            return;
        }
        if (this.o0) {
            outputFormat.setInteger("channel-count", 1);
        }
        this.b0 = outputFormat;
        this.c0 = true;
    }

    public final boolean G(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.mediacodec.BatchBuffer batchBuffer) {
        while (!batchBuffer.l() && !batchBuffer.isEndOfStream()) {
            int readSource = readSource(formatHolder, batchBuffer.j(), false);
            if (readSource == -5) {
                return true;
            }
            if (readSource != -4) {
                if (readSource == -3) {
                    return false;
                }
                throw new java.lang.IllegalStateException();
            }
            batchBuffer.e();
        }
        return false;
    }

    public final boolean H(boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
        this.I.clear();
        int readSource = readSource(formatHolder, this.I, z);
        if (readSource == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (readSource != -4 || !this.I.isEndOfStream()) {
            return false;
        }
        this.M0 = true;
        D();
        return false;
    }

    public final void I() throws com.google.android.exoplayer2.ExoPlaybackException {
        releaseCodec();
        maybeInitCodecOrBypass();
    }

    public final void J() {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            this.t0 = null;
            this.u0 = null;
        }
    }

    public final void K() {
        this.w0 = -1;
        this.H.data = null;
    }

    public final void L() {
        this.x0 = -1;
        this.y0 = null;
    }

    public final void M(@androidx.annotation.Nullable com.google.android.exoplayer2.drm.DrmSession drmSession) {
        defpackage.r60.b(this.S, drmSession);
        this.S = drmSession;
    }

    public final boolean O(long j) {
        return this.W == -9223372036854775807L || android.os.SystemClock.elapsedRealtime() - j < this.W;
    }

    public final void P() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            return;
        }
        float codecOperatingRateV23 = getCodecOperatingRateV23(this.X, this.a0, getStreamFormats());
        float f = this.d0;
        if (f == codecOperatingRateV23) {
            return;
        }
        if (codecOperatingRateV23 == -1.0f) {
            m();
            return;
        }
        if (f != -1.0f || codecOperatingRateV23 > this.G) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putFloat("operating-rate", codecOperatingRateV23);
            this.Y.setParameters(bundle);
            this.d0 = codecOperatingRateV23;
        }
    }

    @androidx.annotation.RequiresApi(23)
    public final void Q() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.drm.FrameworkMediaCrypto s2 = s(this.T);
        if (s2 == null) {
            I();
            return;
        }
        if (com.google.android.exoplayer2.C.PLAYREADY_UUID.equals(s2.uuid)) {
            I();
            return;
        }
        if (flushOrReinitializeCodec()) {
            return;
        }
        try {
            this.U.setMediaDrmSession(s2.sessionId);
            M(this.T);
            this.F0 = 0;
            this.G0 = 0;
        } catch (android.media.MediaCryptoException e) {
            throw createRendererException(e, this.Q);
        }
    }

    public final boolean a(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.mediacodec.BatchBuffer batchBuffer;
        com.google.android.exoplayer2.mediacodec.BatchBuffer batchBuffer2 = this.J;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.N0);
        if (batchBuffer2.k()) {
            batchBuffer = batchBuffer2;
        } else {
            batchBuffer = batchBuffer2;
            if (!processOutputBuffer(j, j2, null, batchBuffer2.data, this.x0, 0, batchBuffer2.g(), batchBuffer2.h(), batchBuffer2.isDecodeOnly(), batchBuffer2.isEndOfStream(), this.R)) {
                return false;
            }
            onProcessedOutputBuffer(batchBuffer.i());
        }
        if (batchBuffer.isEndOfStream()) {
            this.N0 = true;
            return false;
        }
        batchBuffer.b();
        if (this.C0) {
            if (!batchBuffer.k()) {
                return true;
            }
            k();
            this.C0 = false;
            maybeInitCodecOrBypass();
            if (!this.B0) {
                return false;
            }
        }
        com.google.android.exoplayer2.util.Assertions.checkState(!this.M0);
        com.google.android.exoplayer2.FormatHolder formatHolder = getFormatHolder();
        com.google.android.exoplayer2.mediacodec.BatchBuffer batchBuffer3 = batchBuffer;
        boolean G = G(formatHolder, batchBuffer3);
        if (!batchBuffer3.k() && this.O0) {
            com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.Q);
            this.R = format;
            onOutputFormatChanged(format, null);
            this.O0 = false;
        }
        if (G) {
            onInputFormatChanged(formatHolder);
        }
        if (batchBuffer3.isEndOfStream()) {
            this.M0 = true;
        }
        if (batchBuffer3.k()) {
            return false;
        }
        batchBuffer3.flip();
        batchBuffer3.data.order(java.nio.ByteOrder.nativeOrder());
        return true;
    }

    public final int b(java.lang.String str) {
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            java.lang.String str2 = com.google.android.exoplayer2.util.Util.MODEL;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        java.lang.String str3 = com.google.android.exoplayer2.util.Util.DEVICE;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public int canKeepCodec(android.media.MediaCodec mediaCodec, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format format2) {
        return 0;
    }

    public abstract void configureCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, com.google.android.exoplayer2.mediacodec.MediaCodecAdapter mediaCodecAdapter, com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable android.media.MediaCrypto mediaCrypto, float f);

    public com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException createDecoderException(java.lang.Throwable th, @androidx.annotation.Nullable com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return new com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException(th, mediaCodecInfo);
    }

    public void experimentalSetMediaCodecOperationMode(int i) {
        this.Q0 = i;
    }

    public final boolean flushOrReinitializeCodec() throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean flushOrReleaseCodec = flushOrReleaseCodec();
        if (flushOrReleaseCodec) {
            maybeInitCodecOrBypass();
        }
        return flushOrReleaseCodec;
    }

    public boolean flushOrReleaseCodec() {
        if (this.Y == null) {
            return false;
        }
        if (this.G0 == 3 || this.k0 || ((this.l0 && !this.J0) || (this.m0 && this.I0))) {
            releaseCodec();
            return true;
        }
        try {
            this.Z.flush();
            return false;
        } finally {
            resetCodecStateForFlush();
        }
    }

    @androidx.annotation.Nullable
    public final android.media.MediaCodec getCodec() {
        return this.Y;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.mediacodec.MediaCodecInfo getCodecInfo() {
        return this.g0;
    }

    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    public float getCodecOperatingRate() {
        return this.d0;
    }

    public float getCodecOperatingRateV23(float f, com.google.android.exoplayer2.Format format, com.google.android.exoplayer2.Format[] formatArr) {
        return -1.0f;
    }

    @androidx.annotation.Nullable
    public final android.media.MediaFormat getCodecOutputMediaFormat() {
        return this.b0;
    }

    public abstract java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfos(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format, boolean z) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format getInputFormat() {
        return this.Q;
    }

    public final long getLargestQueuedPresentationTimeUs() {
        return this.K0;
    }

    public float getOperatingRate() {
        return this.X;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.Format getOutputFormat() {
        return this.R;
    }

    public final long getOutputStreamOffsetUs() {
        return this.T0;
    }

    public final long getOutputStreamStartPositionUs() {
        return this.S0;
    }

    public void handleInputBufferSupplementalData(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.N0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return this.Q != null && (isSourceReady() || v() || (this.v0 != -9223372036854775807L && android.os.SystemClock.elapsedRealtime() < this.v0));
    }

    public final void k() {
        this.C0 = false;
        this.J.clear();
        this.B0 = false;
    }

    public final void l() {
        if (this.H0) {
            this.F0 = 1;
            this.G0 = 1;
        }
    }

    public boolean legacyKeepAvailableCodecInfosWithoutCodec() {
        return false;
    }

    public final void m() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (!this.H0) {
            I();
        } else {
            this.F0 = 1;
            this.G0 = 3;
        }
    }

    public final void maybeInitCodecOrBypass() throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.Format format;
        if (this.Y != null || this.B0 || (format = this.Q) == null) {
            return;
        }
        if (this.T == null && shouldUseBypass(format)) {
            w(this.Q);
            return;
        }
        M(this.T);
        java.lang.String str = this.Q.sampleMimeType;
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.S;
        if (drmSession != null) {
            if (this.U == null) {
                com.google.android.exoplayer2.drm.FrameworkMediaCrypto s2 = s(drmSession);
                if (s2 != null) {
                    try {
                        android.media.MediaCrypto mediaCrypto = new android.media.MediaCrypto(s2.uuid, s2.sessionId);
                        this.U = mediaCrypto;
                        this.V = !s2.forceAllowInsecureDecoderComponents && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (android.media.MediaCryptoException e) {
                        throw createRendererException(e, this.Q);
                    }
                } else if (this.S.getError() == null) {
                    return;
                }
            }
            if (com.google.android.exoplayer2.drm.FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                int state = this.S.getState();
                if (state == 1) {
                    throw createRendererException(this.S.getError(), this.Q);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            B(this.U, this.V);
        } catch (com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException e2) {
            throw createRendererException(e2, this.Q);
        }
    }

    public final void n() throws com.google.android.exoplayer2.ExoPlaybackException {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 23) {
            m();
        } else if (!this.H0) {
            Q();
        } else {
            this.F0 = 1;
            this.G0 = 2;
        }
    }

    public final boolean o(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean z;
        boolean processOutputBuffer;
        android.media.MediaCodec mediaCodec;
        java.nio.ByteBuffer byteBuffer;
        int i;
        android.media.MediaCodec.BufferInfo bufferInfo;
        int dequeueOutputBufferIndex;
        if (!v()) {
            if (this.n0 && this.I0) {
                try {
                    dequeueOutputBufferIndex = this.Z.dequeueOutputBufferIndex(this.M);
                } catch (java.lang.IllegalStateException unused) {
                    D();
                    if (this.N0) {
                        releaseCodec();
                    }
                    return false;
                }
            } else {
                dequeueOutputBufferIndex = this.Z.dequeueOutputBufferIndex(this.M);
            }
            if (dequeueOutputBufferIndex < 0) {
                if (dequeueOutputBufferIndex == -2) {
                    F();
                    return true;
                }
                if (dequeueOutputBufferIndex == -3) {
                    E();
                    return true;
                }
                if (this.r0 && (this.M0 || this.F0 == 2)) {
                    D();
                }
                return false;
            }
            if (this.q0) {
                this.q0 = false;
                this.Y.releaseOutputBuffer(dequeueOutputBufferIndex, false);
                return true;
            }
            android.media.MediaCodec.BufferInfo bufferInfo2 = this.M;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                D();
                return false;
            }
            this.x0 = dequeueOutputBufferIndex;
            java.nio.ByteBuffer u = u(dequeueOutputBufferIndex);
            this.y0 = u;
            if (u != null) {
                u.position(this.M.offset);
                java.nio.ByteBuffer byteBuffer2 = this.y0;
                android.media.MediaCodec.BufferInfo bufferInfo3 = this.M;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            this.z0 = y(this.M.presentationTimeUs);
            long j3 = this.L0;
            long j4 = this.M.presentationTimeUs;
            this.A0 = j3 == j4;
            updateOutputFormatForTime(j4);
        }
        if (this.n0 && this.I0) {
            try {
                mediaCodec = this.Y;
                byteBuffer = this.y0;
                i = this.x0;
                bufferInfo = this.M;
                z = false;
            } catch (java.lang.IllegalStateException unused2) {
                z = false;
            }
            try {
                processOutputBuffer = processOutputBuffer(j, j2, mediaCodec, byteBuffer, i, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.z0, this.A0, this.R);
            } catch (java.lang.IllegalStateException unused3) {
                D();
                if (this.N0) {
                    releaseCodec();
                }
                return z;
            }
        } else {
            z = false;
            android.media.MediaCodec mediaCodec2 = this.Y;
            java.nio.ByteBuffer byteBuffer3 = this.y0;
            int i2 = this.x0;
            android.media.MediaCodec.BufferInfo bufferInfo4 = this.M;
            processOutputBuffer = processOutputBuffer(j, j2, mediaCodec2, byteBuffer3, i2, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.z0, this.A0, this.R);
        }
        if (processOutputBuffer) {
            onProcessedOutputBuffer(this.M.presentationTimeUs);
            boolean z2 = (this.M.flags & 4) != 0;
            L();
            if (!z2) {
                return true;
            }
            D();
        }
        return z;
    }

    public void onCodecInitialized(java.lang.String str, long j, long j2) {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.Q = null;
        this.S0 = -9223372036854775807L;
        this.T0 = -9223372036854775807L;
        this.U0 = 0;
        if (this.T == null && this.S == null) {
            flushOrReleaseCodec();
        } else {
            onReset();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onEnabled(boolean z, boolean z2) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.decoderCounters = new com.google.android.exoplayer2.decoder.DecoderCounters();
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
    
        if (r1.height == r2.height) goto L56;
     */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onInputFormatChanged(com.google.android.exoplayer2.FormatHolder formatHolder) throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean z = true;
        this.O0 = true;
        com.google.android.exoplayer2.Format format = (com.google.android.exoplayer2.Format) com.google.android.exoplayer2.util.Assertions.checkNotNull(formatHolder.format);
        N(formatHolder.drmSession);
        this.Q = format;
        if (this.B0) {
            this.C0 = true;
            return;
        }
        if (this.Y == null) {
            if (!legacyKeepAvailableCodecInfosWithoutCodec()) {
                this.e0 = null;
            }
            maybeInitCodecOrBypass();
            return;
        }
        com.google.android.exoplayer2.drm.DrmSession drmSession = this.T;
        if ((drmSession == null && this.S != null) || ((drmSession != null && this.S == null) || ((drmSession != this.S && !this.g0.secure && C(drmSession, format)) || (com.google.android.exoplayer2.util.Util.SDK_INT < 23 && this.T != this.S)))) {
            m();
            return;
        }
        int canKeepCodec = canKeepCodec(this.Y, this.g0, this.a0, format);
        if (canKeepCodec == 0) {
            m();
            return;
        }
        if (canKeepCodec == 1) {
            this.a0 = format;
            P();
            if (this.T != this.S) {
                n();
                return;
            } else {
                l();
                return;
            }
        }
        if (canKeepCodec != 2) {
            if (canKeepCodec != 3) {
                throw new java.lang.IllegalStateException();
            }
            this.a0 = format;
            P();
            if (this.T != this.S) {
                n();
                return;
            }
            return;
        }
        if (this.i0) {
            m();
            return;
        }
        this.D0 = true;
        this.E0 = 1;
        int i = this.h0;
        if (i != 2) {
            if (i == 1) {
                int i2 = format.width;
                com.google.android.exoplayer2.Format format2 = this.a0;
                if (i2 == format2.width) {
                }
            }
            z = false;
        }
        this.p0 = z;
        this.a0 = format;
        P();
        if (this.T != this.S) {
            n();
        }
    }

    public void onOutputFormatChanged(com.google.android.exoplayer2.Format format, @androidx.annotation.Nullable android.media.MediaFormat mediaFormat) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.M0 = false;
        this.N0 = false;
        this.P0 = false;
        if (this.B0) {
            this.J.f();
        } else {
            flushOrReinitializeCodec();
        }
        if (this.K.size() > 0) {
            this.O0 = true;
        }
        this.K.clear();
        int i = this.U0;
        if (i != 0) {
            this.T0 = this.O[i - 1];
            this.S0 = this.N[i - 1];
            this.U0 = 0;
        }
    }

    @androidx.annotation.CallSuper
    public void onProcessedOutputBuffer(long j) {
        while (true) {
            int i = this.U0;
            if (i == 0 || j < this.P[0]) {
                return;
            }
            long[] jArr = this.N;
            this.S0 = jArr[0];
            this.T0 = this.O[0];
            int i2 = i - 1;
            this.U0 = i2;
            java.lang.System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.O;
            java.lang.System.arraycopy(jArr2, 1, jArr2, 0, this.U0);
            long[] jArr3 = this.P;
            java.lang.System.arraycopy(jArr3, 1, jArr3, 0, this.U0);
            onProcessedStreamChange();
        }
    }

    public void onProcessedStreamChange() {
    }

    public void onQueueInputBuffer(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer) throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onReset() {
        try {
            k();
            releaseCodec();
        } finally {
            N(null);
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStarted() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStopped() {
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(com.google.android.exoplayer2.Format[] formatArr, long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.T0 == -9223372036854775807L) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.S0 == -9223372036854775807L);
            this.S0 = j;
            this.T0 = j2;
            return;
        }
        int i = this.U0;
        long[] jArr = this.O;
        if (i == jArr.length) {
            long j3 = jArr[i - 1];
            java.lang.StringBuilder sb = new java.lang.StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j3);
            com.google.android.exoplayer2.util.Log.w("MediaCodecRenderer", sb.toString());
        } else {
            this.U0 = i + 1;
        }
        long[] jArr2 = this.N;
        int i2 = this.U0;
        jArr2[i2 - 1] = j;
        this.O[i2 - 1] = j2;
        this.P[i2 - 1] = this.K0;
    }

    public abstract boolean processOutputBuffer(long j, long j2, @androidx.annotation.Nullable android.media.MediaCodec mediaCodec, @androidx.annotation.Nullable java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException;

    public final java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> q(boolean z) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        java.util.List<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> decoderInfos = getDecoderInfos(this.E, this.Q, z);
        if (decoderInfos.isEmpty() && z) {
            decoderInfos = getDecoderInfos(this.E, this.Q, false);
            if (!decoderInfos.isEmpty()) {
                java.lang.String str = this.Q.sampleMimeType;
                java.lang.String valueOf = java.lang.String.valueOf(decoderInfos);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 99 + valueOf.length());
                sb.append("Drm session requires secure decoder for ");
                sb.append(str);
                sb.append(", but no secure decoder available. Trying to proceed with ");
                sb.append(valueOf);
                sb.append(".");
                com.google.android.exoplayer2.util.Log.w("MediaCodecRenderer", sb.toString());
            }
        }
        return decoderInfos;
    }

    public final void r(android.media.MediaCodec mediaCodec) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21) {
            this.t0 = mediaCodec.getInputBuffers();
            this.u0 = mediaCodec.getOutputBuffers();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void releaseCodec() {
        try {
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter mediaCodecAdapter = this.Z;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.shutdown();
            }
            android.media.MediaCodec mediaCodec = this.Y;
            if (mediaCodec != null) {
                this.decoderCounters.decoderReleaseCount++;
                mediaCodec.release();
            }
            this.Y = null;
            this.Z = null;
            try {
                android.media.MediaCrypto mediaCrypto = this.U;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (java.lang.Throwable th) {
            this.Y = null;
            this.Z = null;
            try {
                android.media.MediaCrypto mediaCrypto2 = this.U;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws com.google.android.exoplayer2.ExoPlaybackException {
        if (this.P0) {
            this.P0 = false;
            D();
        }
        com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException = this.R0;
        if (exoPlaybackException != null) {
            this.R0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.N0) {
                renderToEndOfStream();
                return;
            }
            if (this.Q != null || H(true)) {
                maybeInitCodecOrBypass();
                if (this.B0) {
                    com.google.android.exoplayer2.util.TraceUtil.beginSection("bypassRender");
                    while (a(j, j2)) {
                    }
                    com.google.android.exoplayer2.util.TraceUtil.endSection();
                } else if (this.Y != null) {
                    long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                    com.google.android.exoplayer2.util.TraceUtil.beginSection("drainAndFeed");
                    while (o(j, j2) && O(elapsedRealtime)) {
                    }
                    while (p() && O(elapsedRealtime)) {
                    }
                    com.google.android.exoplayer2.util.TraceUtil.endSection();
                } else {
                    this.decoderCounters.skippedInputBufferCount += skipSource(j);
                    H(false);
                }
                this.decoderCounters.ensureUpdated();
            }
        } catch (java.lang.IllegalStateException e) {
            if (!z(e)) {
                throw e;
            }
            throw createRendererException(createDecoderException(e, getCodecInfo()), this.Q);
        }
    }

    public void renderToEndOfStream() throws com.google.android.exoplayer2.ExoPlaybackException {
    }

    @androidx.annotation.CallSuper
    public void resetCodecStateForFlush() {
        K();
        L();
        this.v0 = -9223372036854775807L;
        this.I0 = false;
        this.H0 = false;
        this.p0 = false;
        this.q0 = false;
        this.z0 = false;
        this.A0 = false;
        this.L.clear();
        this.K0 = -9223372036854775807L;
        this.L0 = -9223372036854775807L;
        com.google.android.exoplayer2.mediacodec.C2Mp3TimestampTracker c2Mp3TimestampTracker = this.s0;
        if (c2Mp3TimestampTracker != null) {
            c2Mp3TimestampTracker.b();
        }
        this.F0 = 0;
        this.G0 = 0;
        this.E0 = this.D0 ? 1 : 0;
    }

    @androidx.annotation.CallSuper
    public void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.R0 = null;
        this.s0 = null;
        this.e0 = null;
        this.g0 = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = false;
        this.J0 = false;
        this.d0 = -1.0f;
        this.h0 = 0;
        this.i0 = false;
        this.j0 = false;
        this.k0 = false;
        this.l0 = false;
        this.m0 = false;
        this.n0 = false;
        this.o0 = false;
        this.r0 = false;
        this.D0 = false;
        this.E0 = 0;
        J();
        this.V = false;
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.drm.FrameworkMediaCrypto s(com.google.android.exoplayer2.drm.DrmSession drmSession) throws com.google.android.exoplayer2.ExoPlaybackException {
        com.google.android.exoplayer2.drm.ExoMediaCrypto mediaCrypto = drmSession.getMediaCrypto();
        if (mediaCrypto == null || (mediaCrypto instanceof com.google.android.exoplayer2.drm.FrameworkMediaCrypto)) {
            return (com.google.android.exoplayer2.drm.FrameworkMediaCrypto) mediaCrypto;
        }
        java.lang.String valueOf = java.lang.String.valueOf(mediaCrypto);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 42);
        sb.append("Expecting FrameworkMediaCrypto but found: ");
        sb.append(valueOf);
        throw createRendererException(new java.lang.IllegalArgumentException(sb.toString()), this.Q);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public void setOperatingRate(float f) throws com.google.android.exoplayer2.ExoPlaybackException {
        this.X = f;
        if (this.Y == null || this.G0 == 3 || getState() == 0) {
            return;
        }
        P();
    }

    public final void setPendingOutputEndOfStream() {
        this.P0 = true;
    }

    public final void setPendingPlaybackException(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
        this.R0 = exoPlaybackException;
    }

    public void setRenderTimeLimitMs(long j) {
        this.W = j;
    }

    public boolean shouldInitCodec(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public boolean shouldUseBypass(com.google.android.exoplayer2.Format format) {
        return false;
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public final int supportsFormat(com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.ExoPlaybackException {
        try {
            return supportsFormat(this.E, format);
        } catch (com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format);
        }
    }

    public abstract int supportsFormat(com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, com.google.android.exoplayer2.Format format) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.RendererCapabilities
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public final java.nio.ByteBuffer t(int i) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? this.Y.getInputBuffer(i) : this.t0[i];
    }

    @androidx.annotation.Nullable
    public final java.nio.ByteBuffer u(int i) {
        return com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? this.Y.getOutputBuffer(i) : this.u0[i];
    }

    public final void updateOutputFormatForTime(long j) throws com.google.android.exoplayer2.ExoPlaybackException {
        boolean z;
        com.google.android.exoplayer2.Format pollFloor = this.K.pollFloor(j);
        if (pollFloor == null && this.c0) {
            pollFloor = this.K.pollFirst();
        }
        if (pollFloor != null) {
            this.R = pollFloor;
            z = true;
        } else {
            z = false;
        }
        if (z || (this.c0 && this.R != null)) {
            onOutputFormatChanged(this.R, this.b0);
            this.c0 = false;
        }
    }

    public final boolean v() {
        return this.x0 >= 0;
    }

    public final void w(com.google.android.exoplayer2.Format format) {
        k();
        java.lang.String str = format.sampleMimeType;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.J.n(32);
        } else {
            this.J.n(1);
        }
        this.B0 = true;
    }

    public final void x(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo, android.media.MediaCrypto mediaCrypto) throws java.lang.Exception {
        android.media.MediaCodec mediaCodec;
        com.google.android.exoplayer2.mediacodec.MediaCodecAdapter synchronousMediaCodecAdapter;
        java.lang.String str = mediaCodecInfo.name;
        int i = com.google.android.exoplayer2.util.Util.SDK_INT;
        float codecOperatingRateV23 = i < 23 ? -1.0f : getCodecOperatingRateV23(this.X, this.Q, getStreamFormats());
        float f = codecOperatingRateV23 <= this.G ? -1.0f : codecOperatingRateV23;
        com.google.android.exoplayer2.mediacodec.MediaCodecAdapter mediaCodecAdapter = null;
        try {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            java.lang.String valueOf = java.lang.String.valueOf(str);
            com.google.android.exoplayer2.util.TraceUtil.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new java.lang.String("createCodec:"));
            mediaCodec = android.media.MediaCodec.createByCodecName(str);
            try {
                int i2 = this.Q0;
                synchronousMediaCodecAdapter = (i2 != 2 || i < 23) ? (i2 != 4 || i < 23) ? new com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter(mediaCodec) : new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter(mediaCodec, true, getTrackType()) : new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter(mediaCodec, getTrackType());
            } catch (java.lang.Exception e) {
                e = e;
            }
            try {
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                com.google.android.exoplayer2.util.TraceUtil.beginSection("configureCodec");
                configureCodec(mediaCodecInfo, synchronousMediaCodecAdapter, this.Q, mediaCrypto, f);
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                com.google.android.exoplayer2.util.TraceUtil.beginSection("startCodec");
                synchronousMediaCodecAdapter.start();
                com.google.android.exoplayer2.util.TraceUtil.endSection();
                long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                r(mediaCodec);
                this.Y = mediaCodec;
                this.Z = synchronousMediaCodecAdapter;
                this.g0 = mediaCodecInfo;
                this.d0 = f;
                this.a0 = this.Q;
                this.h0 = b(str);
                this.i0 = i(str);
                this.j0 = c(str, this.a0);
                this.k0 = g(str);
                this.l0 = j(str);
                this.m0 = d(str);
                this.n0 = e(str);
                this.o0 = h(str, this.a0);
                this.r0 = f(mediaCodecInfo) || getCodecNeedsEosPropagation();
                if ("c2.android.mp3.decoder".equals(mediaCodecInfo.name)) {
                    this.s0 = new com.google.android.exoplayer2.mediacodec.C2Mp3TimestampTracker();
                }
                if (getState() == 2) {
                    this.v0 = android.os.SystemClock.elapsedRealtime() + 1000;
                }
                this.decoderCounters.decoderInitCount++;
                onCodecInitialized(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            } catch (java.lang.Exception e2) {
                e = e2;
                mediaCodecAdapter = synchronousMediaCodecAdapter;
                if (mediaCodecAdapter != null) {
                    mediaCodecAdapter.shutdown();
                }
                if (mediaCodec != null) {
                    J();
                    mediaCodec.release();
                }
                throw e;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            mediaCodec = null;
        }
    }

    public final boolean y(long j) {
        int size = this.L.size();
        for (int i = 0; i < size; i++) {
            if (this.L.get(i).longValue() == j) {
                this.L.remove(i);
                return true;
            }
        }
        return false;
    }
}
