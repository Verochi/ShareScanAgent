package com.aliyun.svideosdk.recorder.impl;

/* loaded from: classes12.dex */
public class e {
    private float A;
    private float B;
    private com.aliyun.svideosdk.common.AliyunRecordAudioSource C;
    private com.aliyun.svideosdk.common.AliyunRecordAudioSource D;
    private com.aliyun.svideosdk.common.AliyunRecordAVSource E;
    private int F;
    private java.lang.String a;
    private com.aliyun.svideosdk.recorder.NativeRecorder.CallBack b;
    private boolean c;
    private com.aliyun.svideosdk.recorder.impl.h.a d;
    private com.aliyun.svideosdk.recorder.impl.c e;
    private com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback f;
    private com.aliyun.svideosdk.common.callback.recorder.OnEncoderInfoCallback g;
    private com.aliyun.svideosdk.common.struct.recorder.MediaInfo h;
    private int i;
    private int j;
    private java.lang.String k;
    private com.aliyun.svideosdk.recorder.impl.e.d l;
    private java.lang.Boolean m;
    private long n;
    private volatile int o;
    private float p;
    private long q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f103s;
    private android.os.Handler t;
    private boolean u;
    private com.aliyun.common.log.reporter.AlivcRecorderReporter v;
    private com.aliyun.svideosdk.recorder.NativeRecorder w;
    private boolean x;
    private boolean y;
    private boolean z;

    public class a implements com.aliyun.svideosdk.recorder.NativeRecorder.CallBack {

        /* renamed from: com.aliyun.svideosdk.recorder.impl.e$a$a, reason: collision with other inner class name */
        public class RunnableC0109a implements java.lang.Runnable {
            public RunnableC0109a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.recorder.impl.e.this.m();
            }
        }

        public a() {
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onDuration(long j) {
            com.aliyun.svideosdk.recorder.impl.e.this.q = j / 1000;
            long duration = com.aliyun.svideosdk.recorder.impl.e.this.e.getDuration() + com.aliyun.svideosdk.recorder.impl.e.this.q;
            if (com.aliyun.svideosdk.recorder.impl.e.this.f != null) {
                com.aliyun.svideosdk.recorder.impl.e.this.f.onProgress(com.aliyun.svideosdk.recorder.impl.e.this.q);
            }
            if (duration < com.aliyun.svideosdk.recorder.impl.e.this.e.getMaxDuration() || !com.aliyun.svideosdk.recorder.impl.e.this.u) {
                return;
            }
            if (com.aliyun.svideosdk.recorder.impl.e.this.f != null) {
                com.aliyun.svideosdk.recorder.impl.e.this.f.onMaxDuration();
            }
            com.aliyun.svideosdk.recorder.impl.e.this.t.post(new com.aliyun.svideosdk.recorder.impl.e.a.RunnableC0109a());
            com.aliyun.svideosdk.recorder.impl.e.this.u = false;
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onEncoderInfoBack(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliyunMediaRecorder", "recorder onEncoderInfoBack type = " + j + ", width = " + j2 + ", height = " + j3 + ", duration = " + j4 + ", fps = " + j5 + ", bitrateDiff = " + j6 + ", keyframeDelay = " + j7 + ", avgUseTime = " + j8 + ", maxCacheFrame = " + j9);
            com.aliyun.svideosdk.common.struct.encoder.EncoderInfo encoderInfo = new com.aliyun.svideosdk.common.struct.encoder.EncoderInfo();
            encoderInfo.encoderType = j;
            encoderInfo.width = j2;
            encoderInfo.height = j3;
            encoderInfo.duration = j4;
            encoderInfo.fps = j5;
            encoderInfo.bitrateDiff = j6;
            encoderInfo.avgUseTime = j8;
            encoderInfo.maxCacheFrame = j9;
            if (com.aliyun.svideosdk.recorder.impl.e.this.g != null) {
                com.aliyun.svideosdk.recorder.impl.e.this.g.onEncoderInfoBack(encoderInfo);
            }
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onError(int i) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliyunMediaRecorder", " recorder onError " + i);
            if (com.aliyun.svideosdk.recorder.impl.e.this.f != null) {
                com.aliyun.svideosdk.recorder.impl.e.this.f.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.CallBack
        public void onExit(int i, long j, long j2) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliyunMediaRecorder", "recorder onComplete, mTempPath = " + com.aliyun.svideosdk.recorder.impl.e.this.k + ", mCurrentClipDuration = " + com.aliyun.svideosdk.recorder.impl.e.this.q);
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliyunMediaRecorder", "recorder onComplete, aDuration " + j + ", vDuration " + j2);
            com.aliyun.svideosdk.recorder.impl.e.this.d.e();
            boolean z = (j2 == 0 || j == 0) ? false : true;
            if (j2 > j) {
                j = j2;
            }
            com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip = new com.aliyun.svideosdk.common.struct.project.VideoTrackClip();
            videoTrackClip.setSource(new com.aliyun.svideosdk.common.struct.project.Source(com.aliyun.svideosdk.recorder.impl.e.this.k));
            videoTrackClip.setIn(0.0f);
            float f = j / 1000000.0f;
            videoTrackClip.setOut(f);
            videoTrackClip.setDuration(f);
            videoTrackClip.setRotation(com.aliyun.svideosdk.recorder.impl.e.this.f103s);
            videoTrackClip.setType(0);
            com.aliyun.svideosdk.recorder.impl.e eVar = com.aliyun.svideosdk.recorder.impl.e.this;
            if (z) {
                eVar.e.a(videoTrackClip);
                com.aliyun.svideosdk.common.struct.project.Config b = com.aliyun.svideosdk.recorder.impl.e.this.e.b();
                b.setOutputWidth(com.aliyun.svideosdk.recorder.impl.e.this.h.getVideoWidth());
                b.setOutputHeight(com.aliyun.svideosdk.recorder.impl.e.this.h.getVideoHeight());
                b.setGop(com.aliyun.svideosdk.recorder.impl.e.this.h.getGop());
                b.setBitrate(com.aliyun.svideosdk.recorder.impl.e.this.h.getVideoBitrate());
                b.setVideoQuality(com.aliyun.svideosdk.recorder.impl.e.this.h.getVideoQuality().ordinal());
                b.setFps(com.aliyun.svideosdk.recorder.impl.e.this.h.getFps());
                if (com.aliyun.svideosdk.recorder.impl.e.this.f103s == 90 || com.aliyun.svideosdk.recorder.impl.e.this.f103s == 270) {
                    b.setOutputWidth(com.aliyun.svideosdk.recorder.impl.e.this.h.getVideoHeight());
                    b.setOutputHeight(com.aliyun.svideosdk.recorder.impl.e.this.h.getVideoWidth());
                }
            } else {
                com.aliyun.common.utils.FileUtils.deleteFile(eVar.k);
            }
            com.aliyun.svideosdk.recorder.impl.e.this.v.sendFinishPartUsetimeEvent(java.lang.System.currentTimeMillis() - com.aliyun.svideosdk.recorder.impl.e.this.n);
            if (com.aliyun.svideosdk.recorder.impl.e.this.f != null) {
                com.aliyun.svideosdk.recorder.impl.e.this.f.onClipComplete(z, j / 1000);
            }
        }
    }

    public class b implements com.aliyun.svideosdk.recorder.impl.h.a.InterfaceC0110a {
        public b() {
        }

        @Override // com.aliyun.svideosdk.recorder.impl.h.a.InterfaceC0110a
        public void a(long j) {
            if (com.aliyun.svideosdk.recorder.impl.e.this.l != null) {
                com.aliyun.svideosdk.recorder.impl.e.this.l.a(j);
            }
        }
    }

    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.values().length];
            b = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_SOFT_OPENH264.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.aliyun.svideosdk.common.struct.common.VideoQuality.values().length];
            a = iArr2;
            try {
                iArr2[com.aliyun.svideosdk.common.struct.common.VideoQuality.SSD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.VideoQuality.HD.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.VideoQuality.SD.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.VideoQuality.LD.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.VideoQuality.PD.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.VideoQuality.EPD.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    public interface d {
        void a(long j);
    }

    public e(android.content.Context context, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter, com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder) {
        this(context, alivcRecorderReporter, nativeRecorder, false);
    }

    public e(android.content.Context context, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter, com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder, boolean z) {
        this.c = false;
        this.d = new com.aliyun.svideosdk.recorder.impl.h.a();
        this.h = new com.aliyun.svideosdk.common.struct.recorder.MediaInfo();
        this.m = java.lang.Boolean.FALSE;
        this.n = 0L;
        this.o = 0;
        this.p = 1.0f;
        this.r = 0;
        this.f103s = 0;
        this.t = new android.os.Handler(android.os.Looper.getMainLooper());
        this.u = true;
        this.y = false;
        this.z = false;
        this.A = 1.0f;
        this.B = 1.0f;
        this.C = null;
        this.D = null;
        this.F = -1;
        this.w = nativeRecorder;
        this.x = z;
        e();
        this.e = new com.aliyun.svideosdk.recorder.impl.c(context);
        this.v = alivcRecorderReporter;
        this.b = new com.aliyun.svideosdk.recorder.impl.e.a();
        f();
    }

    private com.aliyun.svideosdk.c.c d() {
        com.aliyun.svideosdk.c.c cVar = com.aliyun.svideosdk.c.c.High;
        int i = com.aliyun.svideosdk.recorder.impl.e.c.a[this.h.getVideoQuality().ordinal()];
        return i != 1 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? cVar : com.aliyun.svideosdk.c.c.ExtraPoor : com.aliyun.svideosdk.c.c.Poor : com.aliyun.svideosdk.c.c.Low : com.aliyun.svideosdk.c.c.Meidan : com.aliyun.svideosdk.c.c.Super;
    }

    private void e() {
        com.aliyun.svideosdk.common.AliyunRecordAudioSource a2 = this.d.a();
        this.D = a2;
        a2.setAudioNeedRender(false);
        this.D.setAudioNeedOutput(true);
        this.w.addSource(this.D);
    }

    private void f() {
        this.w.setCallback(this.b);
        this.d.a(this.w);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int l() {
        com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder;
        int a2;
        com.aliyun.svideosdk.c.e eVar;
        int start;
        if (this.m.booleanValue() || !this.c) {
            this.D.setAudioNeedRender(false);
            this.D.setAudioNeedOutput(false);
            com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource = this.E;
            if (aliyunRecordAVSource != null) {
                aliyunRecordAVSource.setVolume(1.0f);
            }
            com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource = this.C;
            if (aliyunRecordAudioSource != null) {
                aliyunRecordAudioSource.setVolume(1.0f);
            }
        } else {
            this.D.setVolume(1.0f);
            int i = this.F;
            boolean z = i == 1 || i == 3 || this.z;
            if (!z && i == -1 && this.C == null && this.E == null) {
                z = true;
            }
            com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource2 = this.E;
            if (aliyunRecordAVSource2 != null || this.C != null) {
                if (this.y) {
                    if (aliyunRecordAVSource2 != null) {
                        this.D.setAECFarSource(aliyunRecordAVSource2);
                        this.E.setAudioNeedOutput(true);
                        this.E.setVolume(this.A);
                    }
                    com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource2 = this.C;
                    if (aliyunRecordAudioSource2 != null) {
                        this.D.setAECFarSource(aliyunRecordAudioSource2);
                        this.C.setAudioNeedOutput(true);
                        this.C.setVolume(this.A);
                    }
                    this.D.setVolume(this.B);
                } else {
                    this.D.setAECFarSource(null);
                    com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource3 = this.E;
                    if (aliyunRecordAVSource3 != null) {
                        aliyunRecordAVSource3.setAudioNeedOutput(false);
                        this.E.setVolume(1.0f);
                        z = true;
                    }
                    com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource3 = this.C;
                    if (aliyunRecordAudioSource3 != null) {
                        aliyunRecordAudioSource3.setAudioNeedOutput(false);
                        this.C.setVolume(1.0f);
                        z = true;
                    }
                }
            }
            this.D.setAudioNeedOutput(z);
        }
        if (this.F == 2) {
            this.D.setAudioNeedOutput(false);
            com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource4 = this.E;
            if (aliyunRecordAVSource4 != null) {
                aliyunRecordAVSource4.setAudioNeedOutput(false);
            }
            com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource4 = this.C;
            if (aliyunRecordAudioSource4 != null) {
                aliyunRecordAudioSource4.setAudioNeedOutput(false);
            }
        }
        this.w.updateSource(this.D);
        com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource5 = this.E;
        if (aliyunRecordAVSource5 != null) {
            this.w.updateSource(aliyunRecordAVSource5);
        }
        com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource5 = this.C;
        if (aliyunRecordAudioSource5 != null) {
            this.w.updateSource(aliyunRecordAudioSource5);
        }
        int i2 = com.aliyun.svideosdk.recorder.impl.e.c.b[this.h.getVideoCodec().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                nativeRecorder = this.w;
                a2 = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
                eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_OPENH264;
            }
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), this.h.getEncoderFps());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.h.getCrf());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), this.h.getGop());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), this.h.getVideoBitrate());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), d().a());
            this.w.setParam(com.aliyun.svideosdk.c.d.VideoRotateKey.a(), this.r);
            this.f103s = this.r;
            this.w.setVideoTempo(this.p);
            this.w.setVideoSize(this.h.getVideoWidth(), this.h.getVideoHeight());
            java.lang.String str = this.a.replace(".mp4", "") + "_" + java.lang.System.currentTimeMillis() + ".mp4";
            this.k = str;
            start = !this.x ? this.w.start(this.k, (this.e.getMaxDuration() - this.e.getDuration()) * 1000) : this.w.start(str);
            if (start != 0) {
                d(1001);
                this.u = true;
                return 0;
            }
            com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback = this.f;
            if (onRecordCallback != null) {
                onRecordCallback.onError(start);
            }
            return start;
        }
        nativeRecorder = this.w;
        a2 = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
        eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_HARDWARE;
        nativeRecorder.setParam(a2, eVar.a());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), this.h.getEncoderFps());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.h.getCrf());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), this.h.getGop());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), this.h.getVideoBitrate());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), d().a());
        this.w.setParam(com.aliyun.svideosdk.c.d.VideoRotateKey.a(), this.r);
        this.f103s = this.r;
        this.w.setVideoTempo(this.p);
        this.w.setVideoSize(this.h.getVideoWidth(), this.h.getVideoHeight());
        java.lang.String str2 = this.a.replace(".mp4", "") + "_" + java.lang.System.currentTimeMillis() + ".mp4";
        this.k = str2;
        if (!this.x) {
        }
        if (start != 0) {
        }
    }

    public int a(int i) {
        this.D.setDenoiseWeight(i / 100.0f);
        return 0;
    }

    public int a(java.lang.String str, long j, long j2, boolean z) {
        if (this.o == 1001) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid state!");
            return -4;
        }
        com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource = this.C;
        if (aliyunRecordAudioSource != null) {
            this.w.removeSource(aliyunRecordAudioSource);
            this.C.release();
            this.C = null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        com.aliyun.svideosdk.common.AliyunRecordAudioSource createAudioWithFile = com.aliyun.svideosdk.common.AliyunRecordAudioSource.createAudioWithFile(str, j, j2);
        this.C = createAudioWithFile;
        createAudioWithFile.setAudioNeedRender(true);
        this.C.setAudioNeedOutput(true);
        return this.w.addSource(this.C);
    }

    public int a(java.lang.String[] strArr, java.lang.String str) {
        if (strArr == null || strArr.length == 0) {
            return 1073754177;
        }
        int stitchPart = this.w.stitchPart(strArr, strArr.length, str);
        com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback = this.f;
        if (onRecordCallback == null) {
            return stitchPart;
        }
        if (stitchPart == 0) {
            onRecordCallback.onFinish(str);
        } else {
            onRecordCallback.onError(stitchPart);
        }
        return stitchPart;
    }

    public void a() {
        if (this.o == 1003 || this.o == 1001) {
            this.w.cancel();
            this.d.e();
            d(1002);
        }
    }

    public void a(float f) {
        this.p = f;
    }

    public void a(int i, int i2) {
        this.A = i / 100.0f;
        this.B = i2 / 100.0f;
    }

    public void a(com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource) {
        this.E = aliyunRecordAVSource;
    }

    public void a(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack) {
        this.d.a(onAudioCallBack);
    }

    public void a(com.aliyun.svideosdk.common.callback.recorder.OnEncoderInfoCallback onEncoderInfoCallback) {
        this.g = onEncoderInfoCallback;
    }

    public void a(com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback) {
        this.f = onRecordCallback;
    }

    public void a(com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo) {
        if (mediaInfo != null) {
            this.h = mediaInfo;
        }
        if (mediaInfo.getVideoWidth() <= 0 || mediaInfo.getVideoHeight() <= 0) {
            return;
        }
        if (this.i == mediaInfo.getVideoWidth() && this.j == mediaInfo.getVideoHeight()) {
            return;
        }
        this.i = mediaInfo.getVideoWidth();
        this.j = mediaInfo.getVideoHeight();
        this.w.setVideoSize(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
    }

    public void a(com.aliyun.svideosdk.recorder.impl.e.d dVar) {
        this.l = dVar;
    }

    public void a(java.lang.String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.m = java.lang.Boolean.valueOf(z);
    }

    public int b() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunMediaRecord finish ");
        java.lang.String[] strArr = new java.lang.String[this.e.a().size()];
        for (int i = 0; i < this.e.a().size(); i++) {
            strArr[i] = this.e.a().get(i).getSource().getPath();
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunMediaRecord finish part " + i + " file " + strArr[i]);
        }
        int a2 = a(strArr, this.a);
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunMediaRecord stitchVideo finish " + a2);
        return a2;
    }

    public void b(int i) {
        this.F = i;
    }

    public void b(boolean z) {
        this.y = z;
    }

    public com.aliyun.svideosdk.recorder.impl.c c() {
        return this.e;
    }

    public void c(int i) {
        this.r = i;
    }

    public void c(boolean z) {
        this.z = z;
    }

    public synchronized void d(int i) {
        this.o = i;
    }

    public boolean g() {
        return this.e.getDuration() >= this.e.getMaxDuration();
    }

    public void h() {
        com.aliyun.svideosdk.recorder.impl.h.a aVar = this.d;
        if (aVar != null) {
            this.c = aVar.b();
        }
    }

    public void i() {
        this.b = null;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunMediaRecorder release");
        com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource = this.E;
        if (aliyunRecordAVSource != null) {
            this.w.removeSource(aliyunRecordAVSource);
            this.E.release();
            this.E = null;
        }
        com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource = this.C;
        if (aliyunRecordAudioSource != null) {
            this.w.removeSource(aliyunRecordAudioSource);
            this.C.release();
            this.C = null;
        }
        com.aliyun.svideosdk.common.AliyunRecordAudioSource aliyunRecordAudioSource2 = this.D;
        if (aliyunRecordAudioSource2 != null) {
            this.w.removeSource(aliyunRecordAudioSource2);
            this.D.release();
            this.D = null;
        }
        com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter = this.v;
        if (alivcRecorderReporter != null) {
            alivcRecorderReporter.release();
        }
        this.w.release();
        this.g = null;
    }

    public void j() {
        com.aliyun.svideosdk.recorder.impl.h.a aVar = this.d;
        if (aVar != null) {
            aVar.c();
            this.c = false;
        }
    }

    public int k() {
        if (this.o != 0 && 1002 != this.o) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AliyunMediaRecorder, the last recording is not complete, STATE_PENDING = " + this.o);
            this.f.onError(-20008005);
            return -20008005;
        }
        d(1003);
        int l = l();
        if (l != 0) {
            d(1002);
            return l;
        }
        if (this.c) {
            this.d.a(new com.aliyun.svideosdk.recorder.impl.e.b());
            return 0;
        }
        com.aliyun.svideosdk.recorder.impl.e.d dVar = this.l;
        if (dVar == null) {
            return 0;
        }
        dVar.a(java.lang.System.nanoTime());
        return 0;
    }

    public int m() {
        if (this.o != 1003 && this.o != 1001) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AliyunMediaRecord stop invalid state!");
            return -4;
        }
        this.n = java.lang.System.currentTimeMillis();
        this.w.stop();
        d(1002);
        return 0;
    }
}
