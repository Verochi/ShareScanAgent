package com.aliyun.svideosdk.recorder.impl.h;

/* loaded from: classes12.dex */
public class a {
    private int a = 50;
    private boolean b = false;
    private com.aliyun.svideosdk.recorder.impl.h.a.InterfaceC0110a c;
    private com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack d;
    private int e;
    private android.media.AudioRecord f;
    private byte[] g;
    private byte[] h;
    private com.aliyun.svideosdk.recorder.NativeRecorder i;
    private android.os.Handler j;
    private android.os.HandlerThread k;
    private com.aliyun.svideosdk.recorder.impl.h.a.b l;
    private com.aliyun.svideosdk.common.AliyunRecordAudioSource m;
    private volatile boolean n;

    /* renamed from: com.aliyun.svideosdk.recorder.impl.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0110a {
        void a(long j);
    }

    public class b extends java.lang.Thread {
        private long a;

        /* renamed from: com.aliyun.svideosdk.recorder.impl.h.a$b$a, reason: collision with other inner class name */
        public class RunnableC0111a implements java.lang.Runnable {
            final /* synthetic */ int a;

            public RunnableC0111a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideosdk.recorder.impl.h.a.this.d != null) {
                    if (com.aliyun.svideosdk.recorder.impl.h.a.this.b) {
                        com.aliyun.svideosdk.recorder.impl.h.a.this.d.onAudioDataBack(com.aliyun.svideosdk.recorder.impl.h.a.this.h, this.a);
                    } else {
                        com.aliyun.svideosdk.recorder.impl.h.a.this.d.onAudioDataBackInPreview(com.aliyun.svideosdk.recorder.impl.h.a.this.h, this.a);
                    }
                }
            }
        }

        public b(java.lang.String str) {
            super(str);
        }

        public void a() {
            this.a = java.lang.System.nanoTime();
            if (com.aliyun.svideosdk.recorder.impl.h.a.this.c != null) {
                com.aliyun.svideosdk.recorder.impl.h.a.this.c.a(this.a);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            while (!com.aliyun.svideosdk.recorder.impl.h.a.this.n) {
                try {
                    i = com.aliyun.svideosdk.recorder.impl.h.a.this.f.read(com.aliyun.svideosdk.recorder.impl.h.a.this.g, 0, com.aliyun.svideosdk.recorder.impl.h.a.this.e);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                if (i <= 0) {
                    i = com.aliyun.svideosdk.recorder.impl.h.a.this.e;
                    try {
                        java.lang.Thread.sleep(com.aliyun.svideosdk.recorder.impl.h.a.this.a);
                    } catch (java.lang.InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                long nanoTime = (java.lang.System.nanoTime() - this.a) / 1000;
                synchronized (this) {
                    if (com.aliyun.svideosdk.recorder.impl.h.a.this.i != null && com.aliyun.svideosdk.recorder.impl.h.a.this.m != null && com.aliyun.svideosdk.recorder.impl.h.a.this.b) {
                        com.aliyun.svideosdk.recorder.impl.h.a.this.i.addAudioBuffer(com.aliyun.svideosdk.recorder.impl.h.a.this.m, com.aliyun.svideosdk.recorder.impl.h.a.this.g, i);
                    }
                    if (com.aliyun.svideosdk.recorder.impl.h.a.this.j != null && com.aliyun.svideosdk.recorder.impl.h.a.this.d != null) {
                        java.lang.System.arraycopy(com.aliyun.svideosdk.recorder.impl.h.a.this.g, 0, com.aliyun.svideosdk.recorder.impl.h.a.this.h, 0, com.aliyun.svideosdk.recorder.impl.h.a.this.e);
                        com.aliyun.svideosdk.recorder.impl.h.a.this.j.post(new com.aliyun.svideosdk.recorder.impl.h.a.b.RunnableC0111a(i));
                    }
                }
            }
            this.a = 0L;
            com.aliyun.svideosdk.recorder.impl.h.a.this.n = false;
        }
    }

    private void d() {
        com.aliyun.svideosdk.recorder.impl.h.a.b bVar = this.l;
        if (bVar != null) {
            bVar.a();
        }
    }

    public com.aliyun.svideosdk.common.AliyunRecordAudioSource a() {
        if (this.m == null) {
            this.m = com.aliyun.svideosdk.common.AliyunRecordAudioSource.createAudioWithInfo(1, 44100);
        }
        return this.m;
    }

    public void a(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack) {
        this.d = onAudioCallBack;
    }

    public void a(com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder) {
        synchronized (this) {
            this.i = nativeRecorder;
        }
    }

    public void a(com.aliyun.svideosdk.recorder.impl.h.a.InterfaceC0110a interfaceC0110a) {
        this.c = interfaceC0110a;
        d();
        synchronized (this) {
            this.b = true;
        }
        this.n = false;
    }

    public boolean b() {
        try {
            int minBufferSize = android.media.AudioRecord.getMinBufferSize(44100, 16, 2) * 2;
            this.e = minBufferSize;
            if (minBufferSize < 0) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AudioRecorder", "audio buffer size error");
            } else {
                this.g = new byte[minBufferSize];
                this.h = new byte[minBufferSize];
                this.a = (minBufferSize * 1000) / 88200;
            }
            if (this.d != null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("audio data thread");
                this.k = handlerThread;
                handlerThread.start();
                this.j = new android.os.Handler(this.k.getLooper());
            }
            android.media.AudioRecord audioRecord = new android.media.AudioRecord(1, 44100, 16, 2, this.e);
            this.f = audioRecord;
            audioRecord.startRecording();
            this.n = false;
            com.aliyun.svideosdk.recorder.impl.h.a.b bVar = new com.aliyun.svideosdk.recorder.impl.h.a.b("AliyunAudioRecorder");
            this.l = bVar;
            bVar.start();
            return true;
        } catch (java.lang.Exception unused) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Open audio record failed!");
            return false;
        }
    }

    public void c() {
        try {
            this.n = true;
            android.media.AudioRecord audioRecord = this.f;
            if (audioRecord != null) {
                audioRecord.stop();
                this.f.release();
            }
            this.f = null;
        } catch (java.lang.Exception e) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Stop AudioRecord failed! " + e.toString());
        }
        android.os.HandlerThread handlerThread = this.k;
        if (handlerThread != null) {
            handlerThread.quit();
            this.k = null;
        }
    }

    public void e() {
        synchronized (this) {
            if (this.b) {
                this.b = false;
            }
        }
    }
}
