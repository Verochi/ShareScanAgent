package com.aliyun.svideosdk.multirecorder.impl;

/* loaded from: classes12.dex */
public class a extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader implements com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder {
    private com.aliyun.common.log.reporter.AlivcRecorderReporter a;
    private com.aliyun.svideosdk.recorder.impl.e b;
    private com.aliyun.svideosdk.multirecorder.impl.c.g c;
    private com.aliyun.svideosdk.recorder.NativeRecorder d;
    private android.graphics.Bitmap e;
    private int f;
    private int g;
    private com.aliyun.svideosdk.multirecorder.OnVideoRecordListener h;
    private com.aliyun.svideosdk.common.struct.recorder.MediaInfo i;
    private boolean j;
    private volatile boolean k;
    private android.os.Handler l;
    private boolean m;
    private com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback n;
    private com.aliyun.svideosdk.multirecorder.impl.b o;
    private java.lang.Runnable p;

    /* renamed from: com.aliyun.svideosdk.multirecorder.impl.a$a, reason: collision with other inner class name */
    public class C0102a implements com.aliyun.svideosdk.multirecorder.impl.c.g.c {
        public C0102a() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.g.c
        public void a() {
            if (com.aliyun.svideosdk.multirecorder.impl.a.this.k) {
                com.aliyun.svideosdk.multirecorder.impl.a.this.k = false;
                com.aliyun.svideosdk.multirecorder.impl.a.this.l.post(com.aliyun.svideosdk.multirecorder.impl.a.this.p);
            }
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.g.c
        public void a(int i) {
            com.aliyun.svideosdk.multirecorder.impl.a.this.b.c(i);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.g.c
        public void onInitReady() {
            com.aliyun.svideosdk.multirecorder.impl.a.this.n.onInitReady();
        }
    }

    public class b implements com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback {
        public b() {
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onClipComplete(boolean z, long j) {
            if (com.aliyun.svideosdk.multirecorder.impl.a.this.h != null) {
                com.aliyun.svideosdk.multirecorder.impl.a.this.h.onClipComplete(z, j);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onError(int i) {
            if (com.aliyun.svideosdk.multirecorder.impl.a.this.h != null) {
                com.aliyun.svideosdk.multirecorder.impl.a.this.h.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onFinish(java.lang.String str) {
            if (com.aliyun.svideosdk.multirecorder.impl.a.this.h != null) {
                com.aliyun.svideosdk.multirecorder.impl.a.this.h.onFinish(str);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onInitReady() {
            if (com.aliyun.svideosdk.multirecorder.impl.a.this.h != null) {
                com.aliyun.svideosdk.multirecorder.impl.a.this.h.onInitReady();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onMaxDuration() {
            if (com.aliyun.svideosdk.multirecorder.impl.a.this.h != null) {
                com.aliyun.svideosdk.multirecorder.impl.a.this.h.onMaxDuration();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onProgress(long j) {
            if (com.aliyun.svideosdk.multirecorder.impl.a.this.h != null) {
                com.aliyun.svideosdk.multirecorder.impl.a.this.h.onProgress(j);
            }
        }
    }

    public class c implements com.aliyun.svideosdk.multirecorder.impl.b {
        public c() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f, float f2) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f, float f2, float f3, float f4, com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(float f, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, java.lang.String str) {
            com.aliyun.svideosdk.multirecorder.impl.a.this.a.sendStartRecordingEvent(f, i, j, j2, j3, j4, j5, j6, i2, com.aliyun.svideosdk.multirecorder.impl.a.this.i.getVideoBitrate(), com.aliyun.svideosdk.multirecorder.impl.a.this.i.getCrf(), com.aliyun.svideosdk.multirecorder.impl.a.this.i.getEncoderFps(), com.aliyun.svideosdk.multirecorder.impl.a.this.i.getGop(), com.aliyun.svideosdk.multirecorder.impl.a.this.i.getVideoCodec(), com.aliyun.svideosdk.multirecorder.impl.a.this.i.getVideoQuality(), com.aliyun.svideosdk.multirecorder.impl.a.this.i.getVideoWidth(), com.aliyun.svideosdk.multirecorder.impl.a.this.i.getVideoHeight(), str);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(int i, long j) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(long j) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(android.view.SurfaceView surfaceView) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage, float f, float f2, float f3, float f4, int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, java.lang.String str, float f6) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType, boolean z) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(java.lang.Object obj) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(java.lang.String str) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(java.lang.String str, int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(java.lang.String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
            com.aliyun.svideosdk.multirecorder.impl.a.this.a.sendStopRecordingEvent(str, j, j2, j3, j4, j5, j6, j7, j8, i, f, i2);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void a(boolean z) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(float f) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(java.lang.String str) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(java.lang.String str, int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(java.lang.String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
            com.aliyun.svideosdk.multirecorder.impl.a.this.a.sendCancelRecordingEvent(str, j, j2, j3, j4, j5, j6, j7, j8, i, f, i2);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void b(boolean z) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void c(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void d(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void e(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void f(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void g(int i) {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.b
        public void h(int i) {
        }
    }

    public class d implements java.lang.Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.multirecorder.impl.a.this.a();
        }
    }

    static {
        try {
            if (com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
                com.aliyun.svideosdk.nativeload.AbstractNativeLoader.loadLocalLibrary(com.aliyun.svideosdk.nativeload.AbstractNativeLoader.SHARED_LIBRARY_FACE_AR_INTERFACE);
            }
        } catch (java.lang.Throwable th) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Load face .so failed!" + th.toString());
        }
        com.aliyun.svideosdk.c.a.OUTPUT_LAYER.a();
    }

    public a(android.content.Context context) {
        this.i = new com.aliyun.svideosdk.common.struct.recorder.MediaInfo();
        this.j = false;
        this.k = false;
        this.m = false;
        this.n = new com.aliyun.svideosdk.multirecorder.impl.a.b();
        this.o = new com.aliyun.svideosdk.multirecorder.impl.a.c();
        this.p = new com.aliyun.svideosdk.multirecorder.impl.a.d();
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Context is null");
        }
        com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter = new com.aliyun.common.log.reporter.AlivcRecorderReporter(context.getApplicationContext());
        this.a = alivcRecorderReporter;
        alivcRecorderReporter.updateSubModuleName("multi_record");
        com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder = new com.aliyun.svideosdk.recorder.NativeRecorder(this.a.getReportId(), true);
        this.d = nativeRecorder;
        nativeRecorder.setVideoSize(1, 1);
        com.aliyun.svideosdk.recorder.impl.e eVar = new com.aliyun.svideosdk.recorder.impl.e(context.getApplicationContext(), this.a, this.d, true);
        this.b = eVar;
        eVar.a(this.n);
        this.l = new android.os.Handler(android.os.Looper.getMainLooper());
        com.aliyun.svideosdk.multirecorder.impl.c.g gVar = new com.aliyun.svideosdk.multirecorder.impl.c.g(context.getApplicationContext(), this.d, this.o, this.a);
        this.c = gVar;
        gVar.a(new com.aliyun.svideosdk.multirecorder.impl.a.C0102a());
    }

    public a(android.content.Context context, com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig aliyunVideoRecorderConfig) {
        this(context);
        a(aliyunVideoRecorderConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "startMediaRecorder");
        return this.b.k();
    }

    private void a(com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo) {
        java.lang.StringBuilder sb;
        int i;
        int videoWidth = mediaInfo.getVideoWidth();
        int videoHeight = mediaInfo.getVideoHeight();
        if (mediaInfo.getVideoCodec() == com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE) {
            if (videoWidth % 16 != 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Correct preview width from ");
                sb2.append(videoWidth);
                sb2.append(" to ");
                int i2 = ((videoWidth / 16) + 1) * 16;
                sb2.append(i2);
                com.aliyun.common.log.debuglog.AlivcSvideoLog.w("AliYunLog", sb2.toString());
                mediaInfo.setVideoWidth(i2);
            }
            if (videoHeight % 16 == 0) {
                return;
            }
            sb = new java.lang.StringBuilder();
            sb.append("Correct preview height from ");
            sb.append(videoHeight);
            sb.append(" to ");
            i = ((videoHeight / 16) + 1) * 16;
        } else {
            if (videoWidth % 2 != 0) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("Correct preview width from ");
                sb3.append(videoWidth);
                sb3.append(" to ");
                int i3 = videoWidth - 1;
                sb3.append(i3);
                com.aliyun.common.log.debuglog.AlivcSvideoLog.w("AliYunLog", sb3.toString());
                mediaInfo.setVideoWidth(i3);
            }
            if (videoHeight % 2 == 0) {
                return;
            }
            sb = new java.lang.StringBuilder();
            sb.append("Correct preview height from ");
            sb.append(videoHeight);
            sb.append(" to ");
            i = videoHeight - 1;
        }
        sb.append(i);
        com.aliyun.common.log.debuglog.AlivcSvideoLog.w("AliYunLog", sb.toString());
        mediaInfo.setVideoHeight(i);
    }

    private void a(com.aliyun.svideosdk.multirecorder.config.AliyunVideoRecorderConfig aliyunVideoRecorderConfig) {
        com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo = new com.aliyun.svideosdk.common.struct.recorder.MediaInfo();
        mediaInfo.setVideoWidth(aliyunVideoRecorderConfig.getVideoWidth());
        mediaInfo.setVideoHeight(aliyunVideoRecorderConfig.getVideoHeight());
        mediaInfo.setFps(aliyunVideoRecorderConfig.getFps());
        mediaInfo.setVideoCodec(aliyunVideoRecorderConfig.getVideoCodecs());
        mediaInfo.setCrf(aliyunVideoRecorderConfig.getCrf());
        mediaInfo.setEncoderFps(aliyunVideoRecorderConfig.getEncoderFps());
        mediaInfo.setVideoQuality(aliyunVideoRecorderConfig.getVideoQuality());
        mediaInfo.setGop(aliyunVideoRecorderConfig.getGop());
        mediaInfo.setVideoBitrate(aliyunVideoRecorderConfig.getVideoBitrate());
        setMediaInfo(mediaInfo);
        setOutputPath(aliyunVideoRecorderConfig.getOutputPath());
    }

    private void b() {
        this.k = false;
        this.l.removeCallbacks(this.p);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int addWaterMark(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        if (effectImage == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        android.graphics.Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null) {
            this.d.getGlobalStickerManager().addBitmapSticker(effectImage.getResId(), bitmap, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        } else {
            if (effectImage.getPath() == null || !new java.io.File(effectImage.getPath()).exists()) {
                return -20003013;
            }
            this.d.getGlobalStickerManager().addSticker(effectImage.getResId(), effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        }
        this.d.updateGlobalStickers();
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized void cancelRecording() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "cancelRecording ");
        b();
        this.b.a();
        this.c.a(true);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int clearBackground() {
        android.graphics.Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
            this.e = null;
        }
        this.f = 0;
        return this.d.clearBackground();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized void destroy() {
        this.a.sendDestroyEvent();
        android.graphics.Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
            this.e = null;
        }
        stopRecording();
        stopPreview();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "Recorder destroy");
        this.j = true;
        this.b.a((com.aliyun.svideosdk.recorder.impl.e.d) null);
        this.b.a((com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback) null);
        this.h = null;
        if (this.m) {
            getClipManager().deleteAllPart();
        }
        this.c.destroy();
        this.b.i();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int finishRecording() {
        int a;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "finishRecording ");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        a = com.aliyun.svideosdk.common.a.a(this.b.b());
        this.a.sendFinishRecordingEvent(java.lang.System.currentTimeMillis() - currentTimeMillis);
        return a;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public android.net.Uri finishRecordingForEdit() {
        if (this.a != null) {
            this.b.c().a(this.a.getRequestId());
        }
        return this.b.c().c();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public com.aliyun.svideosdk.recorder.AliyunIClipManager getClipManager() {
        return this.b.c();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture getVideoCapture() {
        return this.c;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void prepare() {
        this.c.prepare();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void removeMusic() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "Remove background music");
        this.b.a(null, 0L, 0L, true);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int removeWaterMark(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        if (effectImage == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.d.getGlobalStickerManager().removeSticker(effectImage.getResId());
        this.d.updateGlobalStickers();
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundColor(int i) {
        this.f = i;
        return this.d.setBackground(i, this.e, this.g);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundDisplayMode(int i) {
        this.g = i;
        return this.d.setBackground(this.f, this.e, i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundImage(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2 = this.e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.e = null;
        }
        this.e = bitmap;
        return this.d.setBackground(this.f, bitmap, this.g);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setBackgroundImage(java.lang.String str) {
        android.graphics.Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
            this.e = null;
        }
        if (!com.aliyun.common.utils.StringUtils.isEmpty(str) && new java.io.File(str).exists()) {
            this.e = android.graphics.BitmapFactory.decodeFile(str);
        }
        return this.d.setBackground(this.f, this.e, this.g);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setEncoderInfoCallback(com.aliyun.svideosdk.recorder.EncoderInfoCallback encoderInfoCallback) {
        this.b.a(encoderInfoCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setIsAutoClearClipVideos(boolean z) {
        this.m = z;
    }

    public void setMediaInfo(com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo) {
        if (this.j) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Recorder has been destroyed!");
            return;
        }
        if (mediaInfo.getVideoWidth() <= 0 || mediaInfo.getVideoHeight() <= 0) {
            throw new java.lang.IllegalArgumentException("The width or height must > 0");
        }
        this.i = mediaInfo;
        this.c.a(mediaInfo.getFps());
        a(mediaInfo);
        this.b.a(mediaInfo);
        this.c.a(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "set mediainfo " + mediaInfo.toString());
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int setMicDenoiseWeight(int i) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setMicDenoiseWeight: " + i);
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        return this.b.a(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setMixAudioWeight(int i, int i2) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setMixAudioWeight: bgmWeight=" + i + ", micWeight=" + i2);
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 100) {
            i2 = 100;
        }
        this.b.a(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        if (r19 > r13) goto L28;
     */
    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int setMusic(java.lang.String str, long j, long j2) {
        long j3;
        long j4 = j;
        if (android.text.TextUtils.isEmpty(str) || j2 <= 0 || j4 < 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "setMusic error, path = " + str + " , duration  = " + j2 + " , startTime = " + j4);
            return -20001007;
        }
        if (!new java.io.File(str).exists()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "setMusic  error, music filepath = " + str + " is not exit.");
            return -20001003;
        }
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        nativeParser.init(str);
        java.lang.String value = nativeParser.getValue(16);
        if ("unknow".equals(value)) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "setMusic error, music codec not support : " + value);
            return -20001008;
        }
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        try {
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                j3 = mediaPlayer.getDuration();
                if (j3 > 0) {
                    java.lang.String value2 = nativeParser.getValue(18);
                    if (!android.text.TextUtils.isEmpty(value2)) {
                        j4 = ((java.lang.Long.parseLong(value2) / 1000) * j4) / j3;
                    }
                }
                j3 = j2;
                mediaPlayer.release();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                mediaPlayer.release();
                j3 = j2;
            }
            nativeParser.release();
            nativeParser.dispose();
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "Set background music: startTime " + j4 + ", duration " + j3);
            this.b.a(str, j4 * 1000, j3 * 1000, true);
            return 0;
        } catch (java.lang.Throwable th) {
            mediaPlayer.release();
            throw th;
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setMute(boolean z) {
        this.b.a(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOnAudioCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack) {
        this.b.a(onAudioCallBack);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOnRecordListener(com.aliyun.svideosdk.multirecorder.OnVideoRecordListener onVideoRecordListener) {
        this.h = onVideoRecordListener;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOpenMicAEC(boolean z) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setOpenMicAEC: " + z);
        this.b.b(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setOpenMixAudioMode(boolean z) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setOpenMixAudioMode: " + z);
        this.b.c(z);
    }

    public int setOutputPath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.b.a(str);
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "set outputPath " + str);
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public void setRate(float f) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setRate " + f);
        if (f > 2.0d) {
            f = 2.0f;
        }
        if (f < 0.5d) {
            f = 0.5f;
        }
        this.b.a(f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int startPreview() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "VideoRecorder call startPreview");
        this.d.startPreview();
        int startPreview = this.c.startPreview();
        if (startPreview == 0) {
            this.b.h();
            return startPreview;
        }
        com.aliyun.svideosdk.multirecorder.OnVideoRecordListener onVideoRecordListener = this.h;
        if (onVideoRecordListener != null) {
            onVideoRecordListener.onError(startPreview);
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "VideoCapture startPreview failed " + startPreview);
        return startPreview;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int startRecording() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "startRecording");
        if (this.b.g()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Current recording duration is over max duration!");
            com.aliyun.svideosdk.multirecorder.OnVideoRecordListener onVideoRecordListener = this.h;
            if (onVideoRecordListener != null) {
                onVideoRecordListener.onError(-20008008);
            }
            return -20008008;
        }
        int startRecording = this.c.startRecording();
        if (startRecording != 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "VideoCapture startRecording failed " + startRecording);
            return startRecording;
        }
        if (this.c.a()) {
            return a();
        }
        this.k = true;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "RecordWaiting");
        return startRecording;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized void stopPreview() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "VideoRecorder call stopPreview");
        stopRecording();
        this.c.stopPreview();
        this.b.j();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public synchronized int stopRecording() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "VideoRecorder stopRecording");
        b();
        this.c.a(false);
        return this.b.m();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public int updateVideoSize(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Update video size failed: width and height must be greater than 0");
            return -2;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "Update video size: w = " + i + " , h = " + i2);
        this.i.setVideoWidth(i);
        this.i.setVideoHeight(i2);
        a(this.i);
        this.b.a(this.i);
        this.c.a(this.i.getVideoWidth(), this.i.getVideoHeight());
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoRecorder
    public java.lang.String version() {
        return com.aliyun.common.global.Version.VERSION;
    }
}
