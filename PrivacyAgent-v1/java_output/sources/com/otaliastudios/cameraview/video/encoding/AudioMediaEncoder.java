package com.otaliastudios.cameraview.video.encoding;

@androidx.annotation.RequiresApi(api = 18)
/* loaded from: classes19.dex */
public class AudioMediaEncoder extends com.otaliastudios.cameraview.video.encoding.MediaEncoder {
    public static final com.otaliastudios.cameraview.CameraLogger D = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.class.getSimpleName());
    public long A;
    public long B;
    public java.util.Map<java.lang.Long, java.lang.Long> C;
    public boolean p;
    public com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.AudioEncodingThread q;
    public com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.AudioRecordingThread r;

    /* renamed from: s, reason: collision with root package name */
    public com.otaliastudios.cameraview.video.encoding.ByteBufferPool f420s;
    public final com.otaliastudios.cameraview.video.encoding.AudioTimestamp t;
    public com.otaliastudios.cameraview.video.encoding.AudioConfig u;
    public com.otaliastudios.cameraview.video.encoding.InputBufferPool v;
    public final java.util.concurrent.LinkedBlockingQueue<com.otaliastudios.cameraview.video.encoding.InputBuffer> w;
    public com.otaliastudios.cameraview.video.encoding.AudioNoise x;
    public int y;
    public int z;

    public class AudioEncodingThread extends java.lang.Thread {
        public AudioEncodingThread() {
        }

        public /* synthetic */ AudioEncodingThread(com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder audioMediaEncoder, com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.InputBuffer inputBuffer) {
            long nanoTime = java.lang.System.nanoTime() / 1000000;
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.v("encoding thread - performing pending operation for timestamp:", java.lang.Long.valueOf(inputBuffer.timestamp), "- encoding.");
            inputBuffer.data.put(inputBuffer.source);
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.f420s.recycle(inputBuffer.source);
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.w.remove(inputBuffer);
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.encodeInputBuffer(inputBuffer);
            boolean z = inputBuffer.isEndOfStream;
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.v.recycle(inputBuffer);
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.v("encoding thread - performing pending operation for timestamp:", java.lang.Long.valueOf(inputBuffer.timestamp), "- draining.");
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.drainOutput(z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0000, code lost:
        
            continue;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                if (com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.w.isEmpty()) {
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.t(3);
                } else {
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.v("encoding thread - performing", java.lang.Integer.valueOf(com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.w.size()), "pending operations.");
                    while (true) {
                        com.otaliastudios.cameraview.video.encoding.InputBuffer inputBuffer = (com.otaliastudios.cameraview.video.encoding.InputBuffer) com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.w.peek();
                        if (inputBuffer != null) {
                            if (inputBuffer.isEndOfStream) {
                                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.acquireInputBuffer(inputBuffer);
                                a(inputBuffer);
                                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.v.clear();
                                return;
                            } else if (com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.tryAcquireInputBuffer(inputBuffer)) {
                                a(inputBuffer);
                            } else {
                                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.t(3);
                            }
                        }
                    }
                }
            }
        }
    }

    public class AudioRecordingThread extends java.lang.Thread {
        public android.media.AudioRecord n;
        public java.nio.ByteBuffer t;
        public int u;
        public long v;
        public long w;

        public AudioRecordingThread() {
            this.w = Long.MIN_VALUE;
            setPriority(10);
            int i = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.samplingFrequency;
            int a = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.a();
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.getClass();
            int minBufferSize = android.media.AudioRecord.getMinBufferSize(i, a, 2);
            int f = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.f() * com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.b();
            while (f < minBufferSize) {
                f += com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.f();
            }
            int i2 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.samplingFrequency;
            int a2 = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.a();
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.getClass();
            this.n = new android.media.AudioRecord(5, i2, a2, 2, f);
        }

        public /* synthetic */ AudioRecordingThread(com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder audioMediaEncoder, com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, long j, boolean z) {
            int remaining = byteBuffer.remaining();
            com.otaliastudios.cameraview.video.encoding.InputBuffer inputBuffer = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.v.get();
            inputBuffer.source = byteBuffer;
            inputBuffer.timestamp = j;
            inputBuffer.length = remaining;
            inputBuffer.isEndOfStream = z;
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.w.add(inputBuffer);
        }

        public final void b(int i, boolean z) {
            long e = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.t.e(i);
            this.v = e;
            if (this.w == Long.MIN_VALUE) {
                this.w = e;
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.notifyFirstFrameMillis(java.lang.System.currentTimeMillis() - com.otaliastudios.cameraview.video.encoding.AudioTimestamp.a(i, com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.d()));
            }
            if (!com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.hasReachedMaxLength()) {
                if ((this.v - this.w > com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.getMaxLengthUs()) && !z) {
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.w("read thread - this frame reached the maxLength! deltaUs:", java.lang.Long.valueOf(this.v - this.w));
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.notifyMaxLengthReached();
                }
            }
            c();
        }

        public final void c() {
            int c = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.t.c(com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.f());
            if (c <= 0) {
                return;
            }
            long d = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.t.d(this.v);
            long b = com.otaliastudios.cameraview.video.encoding.AudioTimestamp.b(com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.f(), com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.d());
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.w("read thread - GAPS: trying to add", java.lang.Integer.valueOf(c), "noise buffers. PERFORMANCE_MAX_GAPS:", 8);
            for (int i = 0; i < java.lang.Math.min(c, 8); i++) {
                java.nio.ByteBuffer byteBuffer = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.f420s.get();
                if (byteBuffer == null) {
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.e("read thread - GAPS: aborting because we have no free buffer.");
                    return;
                }
                byteBuffer.clear();
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.x.a(byteBuffer);
                byteBuffer.rewind();
                a(byteBuffer, d, false);
                d += b;
            }
        }

        public final boolean d(boolean z) {
            java.nio.ByteBuffer byteBuffer = com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.f420s.get();
            this.t = byteBuffer;
            if (byteBuffer == null) {
                if (z) {
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.v("read thread - eos: true - No buffer, retrying.");
                } else {
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.w("read thread - eos: false - Skipping audio frame,", "encoding is too slow.");
                    com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.t(6);
                }
                return false;
            }
            byteBuffer.clear();
            this.u = this.n.read(this.t, com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.u.f());
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.v("read thread - eos:", java.lang.Boolean.valueOf(z), "- Read new audio frame. Bytes:", java.lang.Integer.valueOf(this.u));
            int i = this.u;
            if (i > 0) {
                b(i, z);
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.v("read thread - eos:", java.lang.Boolean.valueOf(z), "- mLastTimeUs:", java.lang.Long.valueOf(this.v));
                this.t.limit(this.u);
                a(this.t, this.v, z);
            } else if (i == -3) {
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.e("read thread - eos:", java.lang.Boolean.valueOf(z), "- Got AudioRecord.ERROR_INVALID_OPERATION");
            } else if (i == -2) {
                com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.e("read thread - eos:", java.lang.Boolean.valueOf(z), "- Got AudioRecord.ERROR_BAD_VALUE");
            }
            return true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z;
            this.n.startRecording();
            while (true) {
                z = false;
                if (com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.p) {
                    break;
                } else if (!com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.this.hasReachedMaxLength()) {
                    d(false);
                }
            }
            com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.D.w("Stop was requested. We're out of the loop. Will post an endOfStream.");
            while (!z) {
                z = d(true);
            }
            this.n.stop();
            this.n.release();
            this.n = null;
        }
    }

    public AudioMediaEncoder(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.AudioConfig audioConfig) {
        super("AudioEncoder");
        this.p = false;
        this.v = new com.otaliastudios.cameraview.video.encoding.InputBufferPool();
        this.w = new java.util.concurrent.LinkedBlockingQueue<>();
        this.y = 0;
        this.z = 0;
        this.A = 0L;
        this.B = 0L;
        this.C = new java.util.HashMap();
        com.otaliastudios.cameraview.video.encoding.AudioConfig e = audioConfig.e();
        this.u = e;
        this.t = new com.otaliastudios.cameraview.video.encoding.AudioTimestamp(e.d());
        this.q = new com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.AudioEncodingThread(this, null);
        this.r = new com.otaliastudios.cameraview.video.encoding.AudioMediaEncoder.AudioRecordingThread(this, null);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public int getEncodedBitRate() {
        return this.u.bitRate;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onPrepare(@androidx.annotation.NonNull com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine.Controller controller, long j) {
        com.otaliastudios.cameraview.video.encoding.AudioConfig audioConfig = this.u;
        android.media.MediaFormat createAudioFormat = android.media.MediaFormat.createAudioFormat(audioConfig.mimeType, audioConfig.samplingFrequency, audioConfig.channels);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", this.u.a());
        createAudioFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, this.u.bitRate);
        try {
            com.otaliastudios.cameraview.video.encoding.AudioConfig audioConfig2 = this.u;
            java.lang.String str = audioConfig2.encoder;
            if (str != null) {
                this.mMediaCodec = android.media.MediaCodec.createByCodecName(str);
            } else {
                this.mMediaCodec = android.media.MediaCodec.createEncoderByType(audioConfig2.mimeType);
            }
            this.mMediaCodec.configure(createAudioFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
            this.mMediaCodec.start();
            this.f420s = new com.otaliastudios.cameraview.video.encoding.ByteBufferPool(this.u.f(), this.u.c());
            this.x = new com.otaliastudios.cameraview.video.encoding.AudioNoise(this.u);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onStart() {
        this.p = false;
        this.r.start();
        this.q.start();
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    @com.otaliastudios.cameraview.video.encoding.EncoderThread
    public void onStop() {
        this.p = true;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public void onStopped() {
        super.onStopped();
        this.p = false;
        this.q = null;
        this.r = null;
        com.otaliastudios.cameraview.video.encoding.ByteBufferPool byteBufferPool = this.f420s;
        if (byteBufferPool != null) {
            byteBufferPool.clear();
            this.f420s = null;
        }
    }

    public final void t(int i) {
        try {
            java.lang.Thread.sleep(com.otaliastudios.cameraview.video.encoding.AudioTimestamp.a(this.u.f() * i, this.u.d()));
        } catch (java.lang.InterruptedException unused) {
        }
    }
}
