package com.aliyun.svideosdk.recorder.impl;

/* loaded from: classes12.dex */
class b implements com.aliyun.svideosdk.recorder.AliyunIAudioRecorder {
    private static int A = 0;
    private static int v = 1;
    private static int w = 44100;
    private static int x = 2;
    private static int y = 64000;
    private static final int z = android.media.AudioRecord.getMinBufferSize(44100, 16, 2) * 2;
    private android.media.AudioRecord c;
    private android.media.MediaCodec d;
    private java.nio.ByteBuffer[] f;
    private java.nio.ByteBuffer[] g;
    private byte[] i;
    private java.lang.String l;
    private com.aliyun.svideosdk.common.struct.common.AliyunAudioClip n;
    private com.aliyun.svideosdk.common.struct.common.AliyunAudioClip o;
    private volatile long p;
    private java.util.concurrent.CountDownLatch r;

    /* renamed from: s, reason: collision with root package name */
    private java.util.concurrent.CountDownLatch f102s;
    private java.util.concurrent.CountDownLatch t;
    private com.aliyun.svideosdk.common.callback.recorder.OnAudioRecordCallback u;
    final java.nio.ByteBuffer a = java.nio.ByteBuffer.allocateDirect(z);
    private java.lang.String b = null;
    private android.media.MediaCodec.BufferInfo e = new android.media.MediaCodec.BufferInfo();
    private final byte[] h = new byte[7];
    private android.os.HandlerThread j = null;
    private com.aliyun.svideosdk.recorder.impl.b.a k = null;
    private java.util.Vector<com.aliyun.svideosdk.common.struct.common.AliyunAudioClip> m = new java.util.Vector<>();
    private java.io.FileOutputStream q = null;

    public class a extends android.os.Handler {
        private long a;
        private long b;

        public a(android.os.Looper looper) {
            super(looper);
            this.a = 0L;
            this.b = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:92:0x0290  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x02b0  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(android.os.Message message) {
            java.util.concurrent.CountDownLatch countDownLatch;
            com.aliyun.svideosdk.recorder.impl.b bVar;
            com.aliyun.svideosdk.common.struct.common.AliyunAudioClip aliyunAudioClip;
            super.handleMessage(message);
            int i = 100;
            try {
                switch (message.what) {
                    case 1:
                        try {
                            if (com.aliyun.svideosdk.recorder.impl.b.this.c != null) {
                                com.aliyun.svideosdk.recorder.impl.b.this.c.startRecording();
                            }
                            if (com.aliyun.svideosdk.recorder.impl.b.this.d == null) {
                                try {
                                    com.aliyun.svideosdk.recorder.impl.b.this.d = android.media.MediaCodec.createEncoderByType("audio/mp4a-latm");
                                } catch (java.io.IOException e) {
                                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AudioRecord createEncoderByType Exeption" + e.toString());
                                }
                            }
                            if (com.aliyun.svideosdk.recorder.impl.b.this.d != null) {
                                android.media.MediaFormat createAudioFormat = android.media.MediaFormat.createAudioFormat("audio/mp4a-latm", com.aliyun.svideosdk.recorder.impl.b.w, com.aliyun.svideosdk.recorder.impl.b.v);
                                createAudioFormat.setInteger("aac-profile", com.aliyun.svideosdk.recorder.impl.b.x);
                                createAudioFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, com.aliyun.svideosdk.recorder.impl.b.y);
                                com.aliyun.svideosdk.recorder.impl.b.this.d.configure(createAudioFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
                                com.aliyun.svideosdk.recorder.impl.b.this.d.start();
                                com.aliyun.svideosdk.recorder.impl.b bVar2 = com.aliyun.svideosdk.recorder.impl.b.this;
                                bVar2.f = bVar2.d.getInputBuffers();
                                com.aliyun.svideosdk.recorder.impl.b bVar3 = com.aliyun.svideosdk.recorder.impl.b.this;
                                bVar3.g = bVar3.d.getOutputBuffers();
                            }
                            for (int i2 = 0; i2 < 2; i2++) {
                                if (com.aliyun.svideosdk.recorder.impl.b.this.c.read(com.aliyun.svideosdk.recorder.impl.b.this.a, com.aliyun.svideosdk.recorder.impl.b.z) > 0) {
                                    com.aliyun.svideosdk.recorder.impl.b.this.a.clear();
                                } else {
                                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Capture invalid audio data!");
                                }
                            }
                            sendEmptyMessage(3);
                        } catch (java.lang.Exception e2) {
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AudioRecord startRecording failed!" + e2.toString());
                            if (com.aliyun.svideosdk.recorder.impl.b.this.u != null) {
                                com.aliyun.svideosdk.recorder.impl.b.this.u.onError(-20001006);
                            }
                        }
                        countDownLatch = com.aliyun.svideosdk.recorder.impl.b.this.t;
                        countDownLatch.countDown();
                        return;
                    case 2:
                        if (com.aliyun.svideosdk.recorder.impl.b.this.c != null) {
                            com.aliyun.svideosdk.recorder.impl.b.this.c.stop();
                        }
                        int dequeueInputBuffer = com.aliyun.svideosdk.recorder.impl.b.this.d.dequeueInputBuffer(1000L);
                        int i3 = 100;
                        while (dequeueInputBuffer == -1) {
                            i3--;
                            if (i3 <= 0) {
                                if (i3 != 0) {
                                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AudioRecord Exeption");
                                    if (com.aliyun.svideosdk.recorder.impl.b.this.u != null) {
                                        com.aliyun.svideosdk.recorder.impl.b.this.u.onError(-3);
                                    }
                                } else {
                                    com.aliyun.svideosdk.recorder.impl.b.this.d.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                    while (true) {
                                        int i4 = i - 1;
                                        if (i > 0) {
                                            try {
                                                if (!com.aliyun.svideosdk.recorder.impl.b.this.h()) {
                                                    java.lang.Thread.currentThread();
                                                    java.lang.Thread.sleep(10L);
                                                    i = i4;
                                                }
                                            } catch (java.lang.InterruptedException e3) {
                                                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AudioRecord Exeption" + e3.toString());
                                            }
                                        }
                                    }
                                    if (com.aliyun.svideosdk.recorder.impl.b.this.d != null) {
                                        com.aliyun.svideosdk.recorder.impl.b.this.d.flush();
                                        com.aliyun.svideosdk.recorder.impl.b.this.d.stop();
                                        com.aliyun.svideosdk.recorder.impl.b.this.d.reset();
                                        com.aliyun.svideosdk.recorder.impl.b.this.d.release();
                                        com.aliyun.svideosdk.recorder.impl.b.this.d = null;
                                    }
                                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                                    com.aliyun.svideosdk.recorder.impl.b.this.p += currentTimeMillis - this.b;
                                    com.aliyun.svideosdk.recorder.impl.b.this.a(this.a, currentTimeMillis);
                                    removeMessages(3);
                                    removeMessages(4);
                                }
                                countDownLatch = com.aliyun.svideosdk.recorder.impl.b.this.r;
                                countDownLatch.countDown();
                                return;
                            }
                            com.aliyun.svideosdk.recorder.impl.b.this.h();
                            dequeueInputBuffer = com.aliyun.svideosdk.recorder.impl.b.this.d.dequeueInputBuffer(1000L);
                        }
                        if (i3 != 0) {
                        }
                        countDownLatch = com.aliyun.svideosdk.recorder.impl.b.this.r;
                        countDownLatch.countDown();
                        return;
                    case 3:
                        if (com.aliyun.svideosdk.recorder.impl.b.this.n == null) {
                            java.lang.String str = com.aliyun.svideosdk.recorder.impl.b.this.b + java.io.File.separator + java.lang.System.nanoTime();
                            if (com.aliyun.svideosdk.recorder.impl.b.this.o == null) {
                                bVar = com.aliyun.svideosdk.recorder.impl.b.this;
                                aliyunAudioClip = new com.aliyun.svideosdk.common.struct.common.AliyunAudioClip(com.aliyun.svideosdk.recorder.impl.b.b(), 0L, str);
                            } else {
                                bVar = com.aliyun.svideosdk.recorder.impl.b.this;
                                aliyunAudioClip = new com.aliyun.svideosdk.common.struct.common.AliyunAudioClip(com.aliyun.svideosdk.recorder.impl.b.b(), com.aliyun.svideosdk.recorder.impl.b.this.o.getEndTime(), str);
                            }
                            bVar.n = aliyunAudioClip;
                            long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                            this.a = currentTimeMillis2;
                            this.b = currentTimeMillis2;
                            try {
                                if (com.aliyun.svideosdk.recorder.impl.b.this.q == null) {
                                    java.io.File openOrCreateFile = com.aliyun.common.utils.FileUtils.openOrCreateFile(com.aliyun.svideosdk.recorder.impl.b.this.n.getFilePath());
                                    if (openOrCreateFile == null) {
                                        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Create clip file failed!");
                                        if (com.aliyun.svideosdk.recorder.impl.b.this.u != null) {
                                            com.aliyun.svideosdk.recorder.impl.b.this.u.onError(-20005004);
                                            return;
                                        }
                                        return;
                                    }
                                    com.aliyun.svideosdk.recorder.impl.b.this.q = new java.io.FileOutputStream(openOrCreateFile, true);
                                }
                            } catch (java.io.IOException e4) {
                                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Create clip file failed!" + e4.toString());
                                if (com.aliyun.svideosdk.recorder.impl.b.this.u != null) {
                                    com.aliyun.svideosdk.recorder.impl.b.this.u.onError(-20005004);
                                    return;
                                }
                                return;
                            }
                        }
                        int read = com.aliyun.svideosdk.recorder.impl.b.this.c.read(com.aliyun.svideosdk.recorder.impl.b.this.a, com.aliyun.svideosdk.recorder.impl.b.z);
                        long currentTimeMillis3 = java.lang.System.currentTimeMillis();
                        com.aliyun.svideosdk.recorder.impl.b.this.p += currentTimeMillis3 - this.b;
                        this.b = currentTimeMillis3;
                        while (read > 0) {
                            int dequeueInputBuffer2 = com.aliyun.svideosdk.recorder.impl.b.this.d.dequeueInputBuffer(1000L);
                            int i5 = 100;
                            while (dequeueInputBuffer2 == -1 && i5 - 1 > 0) {
                                com.aliyun.svideosdk.recorder.impl.b.this.h();
                                dequeueInputBuffer2 = com.aliyun.svideosdk.recorder.impl.b.this.d.dequeueInputBuffer(1000L);
                            }
                            if (i5 == 0) {
                                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AudioRecord Exeption");
                                if (com.aliyun.svideosdk.recorder.impl.b.this.u != null) {
                                    com.aliyun.svideosdk.recorder.impl.b.this.u.onError(-3);
                                }
                                com.aliyun.svideosdk.recorder.impl.b.this.r.countDown();
                            }
                            java.nio.ByteBuffer byteBuffer = com.aliyun.svideosdk.recorder.impl.b.this.f[dequeueInputBuffer2];
                            byteBuffer.clear();
                            int min = java.lang.Math.min(read, byteBuffer.capacity());
                            read -= min;
                            for (int i6 = 0; i6 < min; i6++) {
                                byteBuffer.put(com.aliyun.svideosdk.recorder.impl.b.this.a.get());
                            }
                            com.aliyun.svideosdk.recorder.impl.b.this.d.queueInputBuffer(dequeueInputBuffer2, 0, min, 0L, 0);
                        }
                        com.aliyun.svideosdk.recorder.impl.b.this.a.rewind();
                        if (com.aliyun.svideosdk.recorder.impl.b.this.h()) {
                            return;
                        }
                        sendEmptyMessage(3);
                        return;
                    case 4:
                        com.aliyun.svideosdk.recorder.impl.b.this.a(this.a, java.lang.System.currentTimeMillis());
                        return;
                    case 5:
                        int g = com.aliyun.svideosdk.recorder.impl.b.this.g();
                        if (g == 0) {
                            if (com.aliyun.svideosdk.recorder.impl.b.this.u != null) {
                                com.aliyun.svideosdk.recorder.impl.b.this.u.onClipConnected(com.aliyun.svideosdk.recorder.impl.b.this.l);
                                return;
                            }
                            return;
                        }
                        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Connect clip files failed, return " + g);
                        if (com.aliyun.svideosdk.recorder.impl.b.this.u != null) {
                            com.aliyun.svideosdk.recorder.impl.b.this.u.onError(g);
                            return;
                        }
                        return;
                    case 6:
                        if (com.aliyun.svideosdk.recorder.impl.b.this.c != null) {
                            com.aliyun.svideosdk.recorder.impl.b.this.c.release();
                            com.aliyun.svideosdk.recorder.impl.b.this.c = null;
                        }
                        if (com.aliyun.svideosdk.recorder.impl.b.this.d != null) {
                            com.aliyun.svideosdk.recorder.impl.b.this.d.release();
                            com.aliyun.svideosdk.recorder.impl.b.this.d = null;
                        }
                        java.util.Iterator it = com.aliyun.svideosdk.recorder.impl.b.this.m.iterator();
                        while (it.hasNext()) {
                            com.aliyun.svideosdk.recorder.impl.b.this.deleteClip((com.aliyun.svideosdk.common.struct.common.AliyunAudioClip) it.next());
                        }
                        removeMessages(3);
                        removeMessages(4);
                        com.aliyun.svideosdk.recorder.impl.b.this.k.getLooper().quitSafely();
                        com.aliyun.svideosdk.recorder.impl.b.this.p = 0L;
                        com.aliyun.svideosdk.recorder.impl.b.this.k = null;
                        com.aliyun.svideosdk.recorder.impl.b.this.j = null;
                        com.aliyun.svideosdk.recorder.impl.b.this.u = null;
                        return;
                    default:
                        return;
                }
            } catch (java.lang.Throwable th) {
                com.aliyun.svideosdk.recorder.impl.b.this.t.countDown();
                throw th;
            }
        }
    }

    private void a(int i, long j) {
        if (i >= this.m.size() || i < 0) {
            return;
        }
        int size = this.m.size();
        while (i < size) {
            com.aliyun.svideosdk.common.struct.common.AliyunAudioClip aliyunAudioClip = this.m.get(i);
            aliyunAudioClip.setStartTime(aliyunAudioClip.getStartTime() - j);
            aliyunAudioClip.setEndTime(aliyunAudioClip.getEndTime() - j);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        com.aliyun.svideosdk.common.struct.common.AliyunAudioClip aliyunAudioClip = this.n;
        if (aliyunAudioClip != null) {
            aliyunAudioClip.setEndTime(aliyunAudioClip.getStartTime() + (j2 - j));
            try {
                this.q.flush();
                this.q.close();
                this.q = null;
                this.m.add(this.n);
                this.o = this.n;
                this.n = null;
            } catch (java.io.IOException e) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close audio data file failed!" + e.toString());
                com.aliyun.svideosdk.common.callback.recorder.OnAudioRecordCallback onAudioRecordCallback = this.u;
                if (onAudioRecordCallback != null) {
                    onAudioRecordCallback.onError(-20005005);
                }
            }
        }
    }

    public static /* synthetic */ int b() {
        int i = A;
        A = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        try {
            if (com.aliyun.common.utils.FileUtils.openOrCreateFile(this.l) == null) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Create output file failed!");
                return -20003002;
            }
            int size = this.m.size();
            java.lang.String[] strArr = new java.lang.String[size];
            for (int i = 0; i < size; i++) {
                com.aliyun.svideosdk.common.struct.common.AliyunAudioClip aliyunAudioClip = this.m.get(i);
                java.io.File file = new java.io.File(aliyunAudioClip.getFilePath());
                if (!file.exists() || !file.isFile()) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid clip file[" + aliyunAudioClip.getFilePath() + "]");
                    return -20003007;
                }
                strArr[i] = aliyunAudioClip.getFilePath();
            }
            com.aliyun.common.utils.FileUtils.mergeFiles(this.l, strArr);
            return 0;
        } catch (java.io.IOException e) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Create output file failed!" + e.toString());
            return -20003002;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        int dequeueOutputBuffer;
        boolean z2;
        android.media.MediaCodec mediaCodec = this.d;
        android.media.MediaCodec.BufferInfo bufferInfo = this.e;
        while (true) {
            dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
            z2 = false;
            if (dequeueOutputBuffer < 0) {
                break;
            }
            android.media.MediaCodec.BufferInfo bufferInfo2 = this.e;
            int i = bufferInfo2.flags;
            if (i == 0) {
                java.nio.ByteBuffer byteBuffer = this.g[dequeueOutputBuffer];
                byteBuffer.position(bufferInfo2.offset);
                int i2 = this.e.size;
                byte[] bArr = new byte[i2];
                this.i = bArr;
                int i3 = x;
                int i4 = v;
                int i5 = i2 + 7;
                byte[] bArr2 = this.h;
                bArr2[0] = -1;
                bArr2[1] = -7;
                bArr2[2] = (byte) (((i3 - 1) << 6) + 16 + (i4 >> 2));
                bArr2[3] = (byte) (((i4 & 3) << 6) + (i5 >> 11));
                bArr2[4] = (byte) ((i5 & 2047) >> 3);
                bArr2[5] = (byte) (((i5 & 7) << 5) + 31);
                bArr2[6] = -4;
                byteBuffer.get(bArr);
                try {
                    this.q.write(this.h, 0, 7);
                    this.q.write(this.i, 0, this.e.size);
                } catch (java.io.IOException unused) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Write audio data to file failed!");
                    com.aliyun.svideosdk.common.callback.recorder.OnAudioRecordCallback onAudioRecordCallback = this.u;
                    if (onAudioRecordCallback != null) {
                        onAudioRecordCallback.onError(-20005005);
                    }
                }
            } else if ((i & 4) != 0) {
                this.d.releaseOutputBuffer(dequeueOutputBuffer, false);
                z2 = true;
                break;
            }
            this.d.releaseOutputBuffer(dequeueOutputBuffer, false);
            mediaCodec = this.d;
            bufferInfo = this.e;
        }
        if (!z2) {
            if (dequeueOutputBuffer == -2) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AudioRecorder INFO_OUTPUT_FORMAT_CHANGED");
                android.media.MediaFormat outputFormat = this.d.getOutputFormat();
                w = outputFormat.getInteger("sample-rate");
                v = outputFormat.getInteger("channel-count");
            } else if (dequeueOutputBuffer == -2) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AudioRecorder INFO_OUTPUT_FORMAT_CHANGED");
                this.g = this.d.getOutputBuffers();
            }
        }
        return z2;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public com.aliyun.svideosdk.common.struct.common.AliyunAudioClip[] allClips() {
        com.aliyun.svideosdk.common.struct.common.AliyunAudioClip[] aliyunAudioClipArr = new com.aliyun.svideosdk.common.struct.common.AliyunAudioClip[this.m.size()];
        this.m.copyInto(aliyunAudioClipArr);
        return aliyunAudioClipArr;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized com.aliyun.svideosdk.common.struct.common.AliyunAudioClip breakTag() {
        if (this.k == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid state!");
            return null;
        }
        this.f102s = new java.util.concurrent.CountDownLatch(1);
        this.k.sendEmptyMessage(4);
        try {
            this.f102s.await();
            return this.o;
        } catch (java.lang.InterruptedException unused) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Break tag failed!");
            return null;
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int connectClip() {
        com.aliyun.svideosdk.recorder.impl.b.a aVar = this.k;
        if (aVar == null) {
            return -4;
        }
        aVar.sendEmptyMessage(5);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int deleteClip(com.aliyun.svideosdk.common.struct.common.AliyunAudioClip aliyunAudioClip) {
        if (aliyunAudioClip == null) {
            return 0;
        }
        if (!this.m.contains(aliyunAudioClip)) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Not find clip with id=" + aliyunAudioClip.getId());
            return -20003008;
        }
        int indexOf = this.m.indexOf(aliyunAudioClip);
        this.m.remove(aliyunAudioClip);
        long endTime = aliyunAudioClip.getEndTime() - aliyunAudioClip.getStartTime();
        this.p -= endTime;
        a(indexOf, endTime);
        java.io.File file = new java.io.File(aliyunAudioClip.getFilePath());
        if (file.exists() && file.isFile()) {
            file.delete();
            if (this.m.isEmpty()) {
                this.o = null;
            } else {
                this.o = this.m.lastElement();
            }
            return 0;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Clip file[" + aliyunAudioClip.getFilePath() + "] not exist!");
        return -20003008;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized long getRecordDuration() {
        return this.p;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    @android.annotation.TargetApi(16)
    public int init(android.content.Context context) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AudioRecorder init.");
        if (this.b == null) {
            this.b = context.getExternalFilesDir(null).getAbsolutePath() + java.io.File.separator + ".aliyun_svideo_files";
        }
        this.c = new android.media.AudioRecord(1, 44100, 16, 2, z);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int release() {
        com.aliyun.svideosdk.recorder.impl.b.a aVar = this.k;
        if (aVar == null) {
            return -4;
        }
        aVar.sendEmptyMessage(6);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public void setOnAudioRecordCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioRecordCallback onAudioRecordCallback) {
        this.u = onAudioRecordCallback;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public int setOutputPath(java.lang.String str) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AudioRecorder setPath." + str);
        if (android.text.TextUtils.isEmpty(str)) {
            return -20003002;
        }
        this.l = str;
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized int startRecord() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AudioRecorder startRecord.");
        if (this.j == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("AudioTagRecorder");
            this.j = handlerThread;
            handlerThread.start();
        }
        if (this.k == null) {
            this.k = new com.aliyun.svideosdk.recorder.impl.b.a(this.j.getLooper());
        }
        this.t = new java.util.concurrent.CountDownLatch(1);
        this.k.sendEmptyMessage(1);
        try {
            this.t.await();
        } catch (java.lang.InterruptedException unused) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Start audio record failed!");
            return -4;
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIAudioRecorder
    public synchronized com.aliyun.svideosdk.common.struct.common.AliyunAudioClip stopRecord() {
        if (this.k == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid state!");
            return null;
        }
        this.r = new java.util.concurrent.CountDownLatch(1);
        this.k.sendEmptyMessage(2);
        try {
            this.r.await();
            return this.o;
        } catch (java.lang.InterruptedException unused) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Stop record failed!");
            return null;
        }
    }
}
