package com.google.android.exoplayer2.mediacodec;

@androidx.annotation.RequiresApi(23)
/* loaded from: classes22.dex */
final class AsynchronousMediaCodecAdapter extends android.media.MediaCodec.Callback implements com.google.android.exoplayer2.mediacodec.MediaCodecAdapter {
    public final java.lang.Object a;

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final com.google.android.exoplayer2.mediacodec.MediaCodecAsyncCallback b;
    public final android.media.MediaCodec c;
    public final android.os.HandlerThread d;
    public android.os.Handler e;

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public long f;
    public int g;
    public final com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer h;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public java.lang.IllegalStateException i;

    public AsynchronousMediaCodecAdapter(android.media.MediaCodec mediaCodec, int i) {
        this(mediaCodec, false, i, new android.os.HandlerThread(b(i)));
    }

    public AsynchronousMediaCodecAdapter(android.media.MediaCodec mediaCodec, boolean z, int i) {
        this(mediaCodec, z, i, new android.os.HandlerThread(b(i)));
    }

    @androidx.annotation.VisibleForTesting
    public AsynchronousMediaCodecAdapter(android.media.MediaCodec mediaCodec, boolean z, int i, android.os.HandlerThread handlerThread) {
        this.a = new java.lang.Object();
        this.b = new com.google.android.exoplayer2.mediacodec.MediaCodecAsyncCallback();
        this.c = mediaCodec;
        this.d = handlerThread;
        this.h = z ? new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer(mediaCodec, i) : new com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecBufferEnqueuer(mediaCodec);
        this.g = 0;
    }

    public static java.lang.String b(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final boolean c() {
        return this.f > 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void configure(@androidx.annotation.Nullable android.media.MediaFormat mediaFormat, @androidx.annotation.Nullable android.view.Surface surface, @androidx.annotation.Nullable android.media.MediaCrypto mediaCrypto, int i) {
        this.d.start();
        android.os.Handler handler = new android.os.Handler(this.d.getLooper());
        this.e = handler;
        this.c.setCallback(this, handler);
        this.c.configure(mediaFormat, surface, mediaCrypto, i);
        this.g = 1;
    }

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void d() {
        e();
        this.b.f();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        synchronized (this.a) {
            if (c()) {
                return -1;
            }
            d();
            return this.b.b();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(android.media.MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            if (c()) {
                return -1;
            }
            d();
            return this.b.c(bufferInfo);
        }
    }

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void e() {
        java.lang.IllegalStateException illegalStateException = this.i;
        if (illegalStateException == null) {
            return;
        }
        this.i = null;
        throw illegalStateException;
    }

    public final void f() {
        synchronized (this.a) {
            g();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        synchronized (this.a) {
            this.h.flush();
            this.c.flush();
            this.f++;
            ((android.os.Handler) com.google.android.exoplayer2.util.Util.castNonNull(this.e)).post(new com.google.android.exoplayer2.mediacodec.a(this));
        }
    }

    @androidx.annotation.GuardedBy(org.apache.tools.ant.taskdefs.optional.clearcase.ClearCase.COMMAND_LOCK)
    public final void g() {
        if (this.g == 3) {
            return;
        }
        long j = this.f - 1;
        this.f = j;
        if (j > 0) {
            return;
        }
        if (j < 0) {
            this.i = new java.lang.IllegalStateException();
            return;
        }
        this.b.d();
        try {
            this.c.start();
        } catch (java.lang.IllegalStateException e) {
            this.i = e;
        } catch (java.lang.Exception e2) {
            this.i = new java.lang.IllegalStateException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public android.media.MediaCodec getCodec() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public android.media.MediaFormat getOutputFormat() {
        android.media.MediaFormat e;
        synchronized (this.a) {
            e = this.b.e();
        }
        return e;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(android.media.MediaCodec mediaCodec, android.media.MediaCodec.CodecException codecException) {
        synchronized (this.a) {
            this.b.onError(mediaCodec, codecException);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(android.media.MediaCodec mediaCodec, int i) {
        synchronized (this.a) {
            this.b.onInputBufferAvailable(mediaCodec, i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(android.media.MediaCodec mediaCodec, int i, android.media.MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.a) {
            this.b.onOutputBufferAvailable(mediaCodec, i, bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(android.media.MediaCodec mediaCodec, android.media.MediaFormat mediaFormat) {
        synchronized (this.a) {
            this.b.onOutputFormatChanged(mediaCodec, mediaFormat);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.h.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int i, int i2, com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo, long j, int i3) {
        this.h.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void shutdown() {
        synchronized (this.a) {
            if (this.g == 2) {
                this.h.shutdown();
            }
            int i = this.g;
            if (i == 1 || i == 2) {
                this.d.quit();
                this.b.d();
                this.f++;
            }
            this.g = 3;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void start() {
        this.h.start();
        this.c.start();
        this.g = 2;
    }
}
