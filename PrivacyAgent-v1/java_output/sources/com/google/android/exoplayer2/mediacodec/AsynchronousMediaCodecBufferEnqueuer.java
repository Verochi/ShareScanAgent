package com.google.android.exoplayer2.mediacodec;

@androidx.annotation.RequiresApi(23)
/* loaded from: classes22.dex */
class AsynchronousMediaCodecBufferEnqueuer implements com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer {

    @androidx.annotation.GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams> h = new java.util.ArrayDeque<>();
    public static final java.lang.Object i = new java.lang.Object();
    public final android.media.MediaCodec a;
    public final android.os.HandlerThread b;
    public android.os.Handler c;
    public final java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> d;
    public final com.google.android.exoplayer2.util.ConditionVariable e;
    public final boolean f;
    public boolean g;

    /* renamed from: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.this.f(message);
        }
    }

    public static class MessageParams {
        public int a;
        public int b;
        public int c;
        public final android.media.MediaCodec.CryptoInfo d = new android.media.MediaCodec.CryptoInfo();
        public long e;
        public int f;

        public void a(int i, int i2, int i3, long j, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.e = j;
            this.f = i4;
        }
    }

    public AsynchronousMediaCodecBufferEnqueuer(android.media.MediaCodec mediaCodec, int i2) {
        this(mediaCodec, new android.os.HandlerThread(e(i2)), new com.google.android.exoplayer2.util.ConditionVariable());
    }

    @androidx.annotation.VisibleForTesting
    public AsynchronousMediaCodecBufferEnqueuer(android.media.MediaCodec mediaCodec, android.os.HandlerThread handlerThread, com.google.android.exoplayer2.util.ConditionVariable conditionVariable) {
        this.a = mediaCodec;
        this.b = handlerThread;
        this.e = conditionVariable;
        this.d = new java.util.concurrent.atomic.AtomicReference<>();
        this.f = l();
    }

    public static void b(com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo, android.media.MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.numSubSamples;
        cryptoInfo2.numBytesOfClearData = d(cryptoInfo.numBytesOfClearData, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = d(cryptoInfo.numBytesOfEncryptedData, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(c(cryptoInfo.key, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(c(cryptoInfo.iv, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.mode;
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 24) {
            cryptoInfo2.setPattern(new android.media.MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        }
    }

    @androidx.annotation.Nullable
    public static byte[] c(@androidx.annotation.Nullable byte[] bArr, @androidx.annotation.Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return java.util.Arrays.copyOf(bArr, bArr.length);
        }
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @androidx.annotation.Nullable
    public static int[] d(@androidx.annotation.Nullable int[] iArr, @androidx.annotation.Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return java.util.Arrays.copyOf(iArr, iArr.length);
        }
        java.lang.System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static java.lang.String e(int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ExoPlayer:MediaCodecBufferEnqueuer:");
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        return sb.toString();
    }

    public static com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams j() {
        java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams> arrayDeque = h;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams();
            }
            return arrayDeque.removeFirst();
        }
    }

    public static boolean l() {
        java.lang.String lowerInvariant = com.google.android.exoplayer2.util.Util.toLowerInvariant(com.google.android.exoplayer2.util.Util.MANUFACTURER);
        return lowerInvariant.contains("samsung") || lowerInvariant.contains("motorola");
    }

    public static void m(com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams messageParams) {
        java.util.ArrayDeque<com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams> arrayDeque = h;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    public final void f(android.os.Message message) {
        com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams messageParams;
        int i2 = message.what;
        if (i2 == 0) {
            messageParams = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) message.obj;
            g(messageParams.a, messageParams.b, messageParams.c, messageParams.e, messageParams.f);
        } else if (i2 != 1) {
            if (i2 != 2) {
                n(new java.lang.IllegalStateException(java.lang.String.valueOf(message.what)));
            } else {
                this.e.open();
            }
            messageParams = null;
        } else {
            messageParams = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) message.obj;
            h(messageParams.a, messageParams.b, messageParams.d, messageParams.e, messageParams.f);
        }
        if (messageParams != null) {
            m(messageParams);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void flush() {
        if (this.g) {
            try {
                i();
            } catch (java.lang.InterruptedException e) {
                java.lang.Thread.currentThread().interrupt();
                throw new java.lang.IllegalStateException(e);
            }
        }
    }

    public final void g(int i2, int i3, int i4, long j, int i5) {
        try {
            this.a.queueInputBuffer(i2, i3, i4, j, i5);
        } catch (java.lang.RuntimeException e) {
            n(e);
        }
    }

    public final void h(int i2, int i3, android.media.MediaCodec.CryptoInfo cryptoInfo, long j, int i4) {
        try {
            if (!this.f) {
                this.a.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                return;
            }
            synchronized (i) {
                this.a.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
            }
        } catch (java.lang.RuntimeException e) {
            n(e);
        }
    }

    public final void i() throws java.lang.InterruptedException {
        android.os.Handler handler = (android.os.Handler) com.google.android.exoplayer2.util.Util.castNonNull(this.c);
        handler.removeCallbacksAndMessages(null);
        this.e.close();
        handler.obtainMessage(2).sendToTarget();
        this.e.block();
        k();
    }

    public final void k() {
        java.lang.RuntimeException andSet = this.d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    @androidx.annotation.VisibleForTesting
    public void n(java.lang.RuntimeException runtimeException) {
        this.d.set(runtimeException);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueInputBuffer(int i2, int i3, int i4, long j, int i5) {
        k();
        com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams j2 = j();
        j2.a(i2, i3, i4, j, i5);
        ((android.os.Handler) com.google.android.exoplayer2.util.Util.castNonNull(this.c)).obtainMessage(0, j2).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueSecureInputBuffer(int i2, int i3, com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo, long j, int i4) {
        k();
        com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams j2 = j();
        j2.a(i2, i3, 0, j, i4);
        b(cryptoInfo, j2.d);
        ((android.os.Handler) com.google.android.exoplayer2.util.Util.castNonNull(this.c)).obtainMessage(1, j2).sendToTarget();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void shutdown() {
        if (this.g) {
            flush();
            this.b.quit();
        }
        this.g = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void start() {
        if (this.g) {
            return;
        }
        this.b.start();
        this.c = new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.AnonymousClass1(this.b.getLooper());
        this.g = true;
    }
}
