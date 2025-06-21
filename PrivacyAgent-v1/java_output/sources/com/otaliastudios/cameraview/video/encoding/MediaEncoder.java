package com.otaliastudios.cameraview.video.encoding;

@androidx.annotation.RequiresApi(api = 18)
/* loaded from: classes19.dex */
public abstract class MediaEncoder {
    public static final com.otaliastudios.cameraview.CameraLogger o = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.encoding.MediaEncoder.class.getSimpleName());
    public final java.lang.String b;
    public com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller c;
    public int d;
    public com.otaliastudios.cameraview.video.encoding.OutputBufferPool e;
    public android.media.MediaCodec.BufferInfo f;
    public com.otaliastudios.cameraview.video.encoding.MediaCodecBuffers g;
    public long i;
    public boolean j;
    protected android.media.MediaCodec mMediaCodec;
    protected com.otaliastudios.cameraview.internal.WorkerHandler mWorker;
    public int a = 0;
    public final java.util.Map<java.lang.String, java.util.concurrent.atomic.AtomicInteger> h = new java.util.HashMap();
    public long k = 0;
    public long l = Long.MIN_VALUE;
    public long m = 0;
    public long n = Long.MIN_VALUE;

    /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller n;
        public final /* synthetic */ long t;

        public AnonymousClass1(com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller controller, long j) {
            this.n = controller;
            this.t = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.o.i(com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.b, "Prepare was called. Executing.");
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.h(1);
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.onPrepare(this.n, this.t);
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.h(2);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoder$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.a < 2 || com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.a >= 3) {
                com.otaliastudios.cameraview.video.encoding.MediaEncoder.o.e(com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.b, "Wrong state while starting. Aborting.", java.lang.Integer.valueOf(com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.a));
                return;
            }
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.h(3);
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.o.w(com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.b, "Start was called. Executing.");
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.onStart();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoder$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ java.util.concurrent.atomic.AtomicInteger n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.Object u;

        public AnonymousClass3(java.util.concurrent.atomic.AtomicInteger atomicInteger, java.lang.String str, java.lang.Object obj) {
            this.n = atomicInteger;
            this.t = str;
            this.u = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.o.v(com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.b, "Notify was called. Executing. pendingEvents:", java.lang.Integer.valueOf(this.n.intValue()));
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.onEvent(this.t, this.u);
            this.n.decrementAndGet();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.video.encoding.MediaEncoder$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.o.w(com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.b, "Stop was called. Executing.");
            com.otaliastudios.cameraview.video.encoding.MediaEncoder.this.onStop();
        }
    }

    public MediaEncoder(@androidx.annotation.NonNull java.lang.String str) {
        this.b = str;
    }

    public void acquireInputBuffer(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.InputBuffer inputBuffer) {
        while (!tryAcquireInputBuffer(inputBuffer)) {
        }
    }

    @android.annotation.SuppressLint({"LogNotTimber"})
    public final void drainOutput(boolean z) {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = o;
        cameraLogger.i(this.b, "DRAINING - EOS:", java.lang.Boolean.valueOf(z));
        android.media.MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            cameraLogger.e("drain() was called before prepare() or after releasing.");
            return;
        }
        if (this.g == null) {
            this.g = new com.otaliastudios.cameraview.video.encoding.MediaCodecBuffers(mediaCodec);
        }
        while (true) {
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.f, 0L);
            com.otaliastudios.cameraview.CameraLogger cameraLogger2 = o;
            cameraLogger2.i(this.b, "DRAINING - Got status:", java.lang.Integer.valueOf(dequeueOutputBuffer));
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                this.g.c();
            } else if (dequeueOutputBuffer == -2) {
                if (this.c.isStarted()) {
                    throw new java.lang.RuntimeException("MediaFormat changed twice.");
                }
                this.d = this.c.notifyStarted(this.mMediaCodec.getOutputFormat());
                h(4);
                this.e = new com.otaliastudios.cameraview.video.encoding.OutputBufferPool(this.d);
            } else if (dequeueOutputBuffer < 0) {
                cameraLogger2.e("Unexpected result from dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                java.nio.ByteBuffer b = this.g.b(dequeueOutputBuffer);
                if (!((this.f.flags & 2) != 0) && this.c.isStarted()) {
                    android.media.MediaCodec.BufferInfo bufferInfo = this.f;
                    if (bufferInfo.size != 0) {
                        b.position(bufferInfo.offset);
                        android.media.MediaCodec.BufferInfo bufferInfo2 = this.f;
                        b.limit(bufferInfo2.offset + bufferInfo2.size);
                        if (this.l == Long.MIN_VALUE) {
                            long j = this.f.presentationTimeUs;
                            this.l = j;
                            cameraLogger2.w(this.b, "DRAINING - Got the first presentation time:", java.lang.Long.valueOf(j));
                        }
                        android.media.MediaCodec.BufferInfo bufferInfo3 = this.f;
                        long j2 = bufferInfo3.presentationTimeUs;
                        this.m = j2;
                        long j3 = ((this.k * 1000) + j2) - this.l;
                        bufferInfo3.presentationTimeUs = j3;
                        cameraLogger2.v(this.b, "DRAINING - About to write(). Adjusted presentation:", java.lang.Long.valueOf(j3));
                        com.otaliastudios.cameraview.video.encoding.OutputBuffer outputBuffer = this.e.get();
                        outputBuffer.info = this.f;
                        outputBuffer.trackIndex = this.d;
                        outputBuffer.data = b;
                        onWriteOutput(this.e, outputBuffer);
                    }
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                if (!z && !this.j) {
                    long j4 = this.l;
                    if (j4 != Long.MIN_VALUE) {
                        long j5 = this.m;
                        if (j5 - j4 > this.i) {
                            cameraLogger2.w(this.b, "DRAINING - Reached maxLength! mLastTimeUs:", java.lang.Long.valueOf(j5), "mStartTimeUs:", java.lang.Long.valueOf(this.l), "mDeltaUs:", java.lang.Long.valueOf(this.m - this.l), "mMaxLengthUs:", java.lang.Long.valueOf(this.i));
                            f();
                            return;
                        }
                    }
                }
                if ((this.f.flags & 4) != 0) {
                    cameraLogger2.w(this.b, "DRAINING - Got EOS. Releasing the codec.");
                    onStopped();
                    return;
                }
            }
        }
    }

    public final void e(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object obj) {
        if (!this.h.containsKey(str)) {
            this.h.put(str, new java.util.concurrent.atomic.AtomicInteger(0));
        }
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.h.get(str);
        atomicInteger.incrementAndGet();
        o.v(this.b, "Notify was called. Posting. pendingEvents:", java.lang.Integer.valueOf(atomicInteger.intValue()));
        this.mWorker.post(new com.otaliastudios.cameraview.video.encoding.MediaEncoder.AnonymousClass3(atomicInteger, str, obj));
    }

    public void encodeInputBuffer(com.otaliastudios.cameraview.video.encoding.InputBuffer inputBuffer) {
        o.v(this.b, "ENCODING - Buffer:", java.lang.Integer.valueOf(inputBuffer.index), "Bytes:", java.lang.Integer.valueOf(inputBuffer.length), "Presentation:", java.lang.Long.valueOf(inputBuffer.timestamp));
        if (inputBuffer.isEndOfStream) {
            this.mMediaCodec.queueInputBuffer(inputBuffer.index, 0, 0, inputBuffer.timestamp, 4);
        } else {
            this.mMediaCodec.queueInputBuffer(inputBuffer.index, 0, inputBuffer.length, inputBuffer.timestamp, 0);
        }
    }

    public final void f() {
        if (this.j) {
            o.w(this.b, "onMaxLengthReached: Called twice.");
            return;
        }
        this.j = true;
        int i = this.a;
        if (i >= 5) {
            o.w(this.b, "onMaxLengthReached: Reached in wrong state. Aborting.", java.lang.Integer.valueOf(i));
            return;
        }
        o.w(this.b, "onMaxLengthReached: Requesting a stop.");
        h(5);
        this.c.requestStop(this.d);
    }

    public final void g(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller controller, long j) {
        int i = this.a;
        if (i >= 1) {
            o.e(this.b, "Wrong state while preparing. Aborting.", java.lang.Integer.valueOf(i));
            return;
        }
        this.c = controller;
        this.f = new android.media.MediaCodec.BufferInfo();
        this.i = j;
        com.otaliastudios.cameraview.internal.WorkerHandler workerHandler = com.otaliastudios.cameraview.internal.WorkerHandler.get(this.b);
        this.mWorker = workerHandler;
        workerHandler.getThread().setPriority(10);
        o.i(this.b, "Prepare was called. Posting.");
        this.mWorker.post(new com.otaliastudios.cameraview.video.encoding.MediaEncoder.AnonymousClass1(controller, j));
    }

    public abstract int getEncodedBitRate();

    public long getMaxLengthUs() {
        return this.i;
    }

    public final int getPendingEvents(@androidx.annotation.NonNull java.lang.String str) {
        return this.h.get(str).intValue();
    }

    public final void h(int i) {
        java.lang.String str;
        if (this.n == Long.MIN_VALUE) {
            this.n = java.lang.System.currentTimeMillis();
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis() - this.n;
        this.n = java.lang.System.currentTimeMillis();
        switch (i) {
            case 0:
                str = "NONE";
                break;
            case 1:
                str = "PREPARING";
                break;
            case 2:
                str = "PREPARED";
                break;
            case 3:
                str = "STARTING";
                break;
            case 4:
                str = "STARTED";
                break;
            case 5:
                str = "LIMIT_REACHED";
                break;
            case 6:
                str = "STOPPING";
                break;
            case 7:
                str = "STOPPED";
                break;
            default:
                str = null;
                break;
        }
        o.w(this.b, "setState:", str, "millisSinceLastState:", java.lang.Long.valueOf(currentTimeMillis));
        this.a = i;
    }

    public boolean hasReachedMaxLength() {
        return this.j;
    }

    public final void i() {
        o.w(this.b, "Start was called. Posting.");
        this.mWorker.post(new com.otaliastudios.cameraview.video.encoding.MediaEncoder.AnonymousClass2());
    }

    public final void j() {
        int i = this.a;
        if (i >= 6) {
            o.e(this.b, "Wrong state while stopping. Aborting.", java.lang.Integer.valueOf(i));
            return;
        }
        h(6);
        o.w(this.b, "Stop was called. Posting.");
        this.mWorker.post(new com.otaliastudios.cameraview.video.encoding.MediaEncoder.AnonymousClass4());
    }

    public final void notifyFirstFrameMillis(long j) {
        this.k = j;
    }

    public void notifyMaxLengthReached() {
        f();
    }

    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onEvent(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object obj) {
    }

    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public abstract void onPrepare(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller controller, long j);

    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public abstract void onStart();

    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public abstract void onStop();

    @androidx.annotation.CallSuper
    public void onStopped() {
        o.w(this.b, "is being released. Notifying controller and releasing codecs.");
        this.c.notifyStopped(this.d);
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
        this.mMediaCodec = null;
        this.e.clear();
        this.e = null;
        this.g = null;
        h(7);
        this.mWorker.destroy();
    }

    @androidx.annotation.CallSuper
    public void onWriteOutput(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.OutputBufferPool outputBufferPool, @androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.OutputBuffer outputBuffer) {
        this.c.write(outputBufferPool, outputBuffer);
    }

    public boolean tryAcquireInputBuffer(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.InputBuffer inputBuffer) {
        if (this.g == null) {
            this.g = new com.otaliastudios.cameraview.video.encoding.MediaCodecBuffers(this.mMediaCodec);
        }
        int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(0L);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        inputBuffer.index = dequeueInputBuffer;
        inputBuffer.data = this.g.a(dequeueInputBuffer);
        return true;
    }
}
