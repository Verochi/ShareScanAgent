package com.aliyun.svideosdk.mixrecorder.impl;

/* loaded from: classes12.dex */
class b implements com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder, android.view.SurfaceHolder.Callback {
    private static java.lang.String w = "mix";
    private com.aliyun.svideosdk.recorder.impl.g a;
    private com.aliyun.svideosdk.recorder.AliyunIClipManager b;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam e;
    private com.aliyun.svideosdk.common.struct.recorder.MediaInfo f;
    private com.aliyun.svideosdk.common.struct.recorder.MediaInfo g;
    private android.content.Context h;
    private com.aliyun.svideosdk.common.b.d.a i;
    private com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback l;
    private java.lang.String n;
    private android.view.SurfaceView o;
    private android.graphics.Bitmap p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam f97s;
    private java.util.Stack<java.lang.Float> c = new java.util.Stack<>();
    private boolean d = false;
    private com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam j = new com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.Builder().build();
    private com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam k = new com.aliyun.svideosdk.mixrecorder.AliyunMixRecorderDisplayParam.Builder().build();
    private float m = 1.0f;
    private com.aliyun.svideosdk.mixrecorder.MixAudioSourceType t = com.aliyun.svideosdk.mixrecorder.MixAudioSourceType.Original;
    private com.aliyun.svideosdk.mixrecorder.MixAudioAecType u = com.aliyun.svideosdk.mixrecorder.MixAudioAecType.TYPE_NONE;
    private com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback v = new com.aliyun.svideosdk.mixrecorder.impl.b.a();

    public class a implements com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback {
        public a() {
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onClipComplete(boolean z, long j) {
            synchronized (com.aliyun.svideosdk.mixrecorder.impl.b.this) {
                if (z) {
                    com.aliyun.svideosdk.mixrecorder.impl.b.this.c.push(java.lang.Float.valueOf(com.aliyun.svideosdk.mixrecorder.impl.b.this.m));
                } else if (com.aliyun.svideosdk.mixrecorder.impl.b.this.a.b().seek(com.aliyun.svideosdk.mixrecorder.impl.b.this.b.getDuration(java.util.concurrent.TimeUnit.MICROSECONDS)) != 0) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Delete last part failed！");
                }
                if (com.aliyun.svideosdk.mixrecorder.impl.b.this.l != null) {
                    com.aliyun.svideosdk.mixrecorder.impl.b.this.l.onClipComplete(z, j);
                }
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onError(int i) {
            if (com.aliyun.svideosdk.mixrecorder.impl.b.this.l != null) {
                com.aliyun.svideosdk.mixrecorder.impl.b.this.l.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onFinish(java.lang.String str) {
            if (com.aliyun.svideosdk.mixrecorder.impl.b.this.l != null) {
                com.aliyun.svideosdk.mixrecorder.impl.b.this.l.onFinish(str);
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onInitReady() {
            if (com.aliyun.svideosdk.mixrecorder.impl.b.this.l != null) {
                com.aliyun.svideosdk.mixrecorder.impl.b.this.l.onInitReady();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onMaxDuration() {
            if (com.aliyun.svideosdk.mixrecorder.impl.b.this.l != null) {
                com.aliyun.svideosdk.mixrecorder.impl.b.this.l.onMaxDuration();
            }
        }

        @Override // com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback
        public void onProgress(long j) {
            if (com.aliyun.svideosdk.mixrecorder.impl.b.this.l != null) {
                com.aliyun.svideosdk.mixrecorder.impl.b.this.l.onProgress(j);
            }
        }
    }

    public b(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.h = applicationContext;
        com.aliyun.svideosdk.recorder.impl.g gVar = (com.aliyun.svideosdk.recorder.impl.g) com.aliyun.svideosdk.recorder.impl.AliyunRecorderCreator.getRecorderInstance(applicationContext);
        this.a = gVar;
        gVar.a(true);
        com.aliyun.common.log.reporter.AlivcRecorderReporter d = this.a.d();
        if (d != null) {
            d.updateSubModuleName(w);
            d.getReportId();
        }
        this.b = this.a.getClipManager();
        this.i = new com.aliyun.svideosdk.common.b.d.a();
    }

    private void a() {
        if (this.a.a() == null) {
            com.aliyun.svideosdk.common.AliyunRecordAVSource createAVWithFile = com.aliyun.svideosdk.common.AliyunRecordAVSource.createAVWithFile(this.e.getMixVideoFilePath(), this.e.getStreamStartTimeMills(), this.e.getStreamEndTimeMills() - this.e.getStreamStartTimeMills());
            com.aliyun.svideosdk.mixrecorder.MixAudioSourceType mixAudioSourceType = this.t;
            boolean z = mixAudioSourceType == com.aliyun.svideosdk.mixrecorder.MixAudioSourceType.Original || mixAudioSourceType == com.aliyun.svideosdk.mixrecorder.MixAudioSourceType.MIX;
            createAVWithFile.setVideoNeedRender(true);
            createAVWithFile.setAudioNeedRender(true);
            createAVWithFile.setVideoNeedOutput(true);
            createAVWithFile.setAudioNeedOutput(z);
            com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam layoutParam = this.k.getLayoutParam();
            createAVWithFile.setLayoutInfo(new com.aliyun.svideosdk.common.AliyunRecordVideoSource.LayoutInfo(layoutParam.getWidthRatio(), layoutParam.getHeightRatio(), layoutParam.getCenterX(), layoutParam.getCenterY(), 0, this.k.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
            if (this.f97s != null) {
                createAVWithFile.setPureColorBorder((r1.getBorderWidth() * 1.0f) / this.i.b(), this.f97s.getBorderColor(), this.f97s.getCornerRadius() / this.i.b());
            }
            this.a.a(createAVWithFile);
            this.a.b().addSource(createAVWithFile);
        }
    }

    private int b() {
        com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam layoutParam = this.j.getLayoutParam();
        com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam layoutParam2 = this.k.getLayoutParam();
        if (layoutParam == null || layoutParam2 == null || this.e == null || this.g == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AliyunMixTrackLayoutParam can't be null!");
            return -20003002;
        }
        com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam layoutParam3 = this.k.getLayoutParam();
        this.a.a().setLayoutInfo(new com.aliyun.svideosdk.common.AliyunRecordVideoSource.LayoutInfo(layoutParam3.getWidthRatio(), layoutParam3.getHeightRatio(), layoutParam3.getCenterX(), layoutParam3.getCenterY(), 2, this.k.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
        this.a.b().updateSource(this.a.a());
        com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam layoutParam4 = this.j.getLayoutParam();
        this.a.c().setLayoutInfo(new com.aliyun.svideosdk.common.AliyunRecordVideoSource.LayoutInfo(layoutParam4.getWidthRatio(), layoutParam4.getHeightRatio(), layoutParam4.getCenterX(), layoutParam4.getCenterY(), 100, this.j.getDisplayMode().ordinal(), this.f.getVideoWidth(), this.f.getVideoHeight()));
        this.a.b().updateSource(this.a.c());
        this.d = true;
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int addImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        return this.a.addImage(effectImage);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        return this.a.addPaster(effectPaster);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z) {
        return this.a.addPaster(effectPaster, f, f2, f3, f4, f5, z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int applyAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        return this.a.applyAnimationFilter(effectFilter);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        return this.a.applyFilter(effectFilter);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int cancelFinishing() {
        return -4;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int deleteLastPart() {
        if (this.b.getDuration() <= 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "There's no last part!");
            return -4;
        }
        this.b.deleteLastPart();
        int seek = this.a.b().seek(this.b.getDuration(java.util.concurrent.TimeUnit.MICROSECONDS));
        if (seek != 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Delete last part failed！");
            return seek;
        }
        if (this.c.empty()) {
            return 0;
        }
        this.c.pop().floatValue();
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int finishRecording() {
        if (this.b.getDuration() <= 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Can't not finish recording!!!");
            return -4;
        }
        stopPreview();
        java.util.List<java.lang.String> videoPathList = this.b.getVideoPathList();
        java.lang.String[] strArr = new java.lang.String[videoPathList.size()];
        for (int i = 0; i < videoPathList.size(); i++) {
            strArr[i] = videoPathList.get(i);
        }
        int stitchPart = this.a.b().stitchPart(strArr, videoPathList.size(), this.i.a());
        com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback = this.l;
        if (onRecordCallback != null) {
            if (stitchPart == 0) {
                onRecordCallback.onFinish(this.n);
            } else {
                onRecordCallback.onError(stitchPart);
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int getBeautyLevel() {
        return this.a.getBeautyLevel();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int getCameraCount() {
        return this.a.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public com.aliyun.svideosdk.recorder.AliyunIClipManager getClipManager() {
        return this.a.getClipManager();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public float getCurrentExposureCompensationRatio() {
        return this.a.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager getPasterManager() {
        return this.a.getPasterManager();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void needFaceTrackInternal(boolean z) {
        this.a.needFaceTrackInternal(z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void release() {
        android.graphics.Bitmap bitmap = this.p;
        if (bitmap != null) {
            bitmap.recycle();
            this.p = null;
        }
        this.c.clear();
        this.a.release();
        this.o = null;
        this.h = null;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        this.a.removeAnimationFilter(effectFilter);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int removeFilter() {
        return this.a.removeFilter();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        this.a.removeImage(effectImage);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        this.a.removePaster(effectPaster);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBackgroundColor(int i) {
        this.q = i;
        this.a.b().setBackground(this.q, this.p, this.r);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBackgroundImage(android.graphics.Bitmap bitmap, int i) {
        android.graphics.Bitmap bitmap2 = this.p;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.p = null;
        }
        this.p = bitmap;
        this.r = i;
        this.a.b().setBackground(this.q, this.p, this.r);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBackgroundImage(java.lang.String str, int i) {
        android.graphics.Bitmap bitmap = this.p;
        if (bitmap != null) {
            bitmap.recycle();
            this.p = null;
        }
        if (!com.aliyun.common.utils.StringUtils.isEmpty(str) && new java.io.File(str).exists()) {
            this.p = android.graphics.BitmapFactory.decodeFile(str);
        }
        this.r = i;
        this.a.b().setBackground(this.q, this.p, this.r);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBeautyLevel(int i) {
        this.a.setBeautyLevel(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setBeautyStatus(boolean z) {
        this.a.setBeautyStatus(z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setCamera(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType) {
        this.a.setCamera(cameraType);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setCameraCaptureDataMode(int i) {
        this.a.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
        this.a.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setDisplayView(android.view.SurfaceView surfaceView, android.view.SurfaceView surfaceView2) {
        if (surfaceView == null || surfaceView2 == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid DisplayView!");
            return -20003002;
        }
        this.a.setDisplayView(surfaceView);
        this.o = surfaceView2;
        a();
        android.view.SurfaceView surfaceView3 = this.o;
        if (surfaceView3 == null) {
            return 0;
        }
        surfaceView3.getHolder().addCallback(this);
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setEffectView(float f, float f2, float f3, float f4, com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        return this.a.setEffectView(f, f2, f3, f4, effectBase);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setExposureCompensationRatio(float f) {
        return this.a.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFaceDetectRotation(int i) {
        this.a.setFaceDetectRotation(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFaceTrackInternalMaxFaceCount(int i) {
        this.a.setFaceTrackInternalMaxFaceCount(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setFaceTrackInternalModelPath(java.lang.String str) {
        return this.a.setFaceTrackInternalModelPath(str);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setFaces(float[][] fArr) {
        return this.a.setFaces(fArr);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFocus(float f, float f2) {
        this.a.setFocus(f, f2);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setFocusMode(int i) {
        this.a.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setGop(int i) {
        this.i.d(i);
        return this.a.setGop(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setIsAutoClearClipVideos(boolean z) {
        this.a.setIsAutoClearClipVideos(z);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public boolean setLight(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
        return this.a.setLight(flashType);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixAudioAecType(com.aliyun.svideosdk.mixrecorder.MixAudioAecType mixAudioAecType) {
        this.u = mixAudioAecType;
        this.a.setOpenMicAEC(mixAudioAecType == com.aliyun.svideosdk.mixrecorder.MixAudioAecType.TYPE_AEC_SOFT);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixAudioSource(com.aliyun.svideosdk.mixrecorder.MixAudioSourceType mixAudioSourceType) {
        this.t = mixAudioSourceType;
        this.a.a(mixAudioSourceType.ordinal());
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixAudioWeight(int i, int i2) {
        this.a.setMixAudioWeight(i, i2);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setMixMediaInfo(com.aliyun.svideosdk.mixrecorder.AliyunMixMediaInfoParam aliyunMixMediaInfoParam, com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo) {
        if (aliyunMixMediaInfoParam == null || mediaInfo == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid parameters!");
            return -20003002;
        }
        this.e = aliyunMixMediaInfoParam;
        if (aliyunMixMediaInfoParam.getRecordDisplayParam() != null) {
            this.j = aliyunMixMediaInfoParam.getRecordDisplayParam();
        }
        if (aliyunMixMediaInfoParam.getMixDisplayParam() != null) {
            this.k = aliyunMixMediaInfoParam.getMixDisplayParam();
        }
        this.f = mediaInfo;
        this.i.b(mediaInfo.getCrf());
        this.i.c(mediaInfo.getEncoderFps());
        this.i.f(mediaInfo.getVideoWidth());
        this.i.e(mediaInfo.getVideoHeight());
        com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo2 = new com.aliyun.svideosdk.common.struct.recorder.MediaInfo();
        this.g = mediaInfo2;
        mediaInfo2.setCrf(this.f.getCrf());
        this.g.setEncoderFps(this.f.getEncoderFps());
        this.g.setFps(this.f.getFps());
        this.g.setVideoCodec(this.f.getVideoCodec());
        this.g.setVideoWidth(mediaInfo.getVideoWidth());
        this.g.setVideoHeight(mediaInfo.getVideoHeight());
        this.a.setMediaInfo(this.g);
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setMixedBorderParam(com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam aliyunMixBorderParam) {
        this.f97s = aliyunMixBorderParam;
        if (this.a.a() != null) {
            if (aliyunMixBorderParam != null) {
                this.a.a().setPureColorBorder((aliyunMixBorderParam.getBorderWidth() * 1.0f) / this.i.b(), aliyunMixBorderParam.getBorderColor(), aliyunMixBorderParam.getCornerRadius() / this.i.b());
            } else {
                this.a.a().setPureColorBorder(0.0f, 0, 0.0f);
            }
            this.a.b().updateSource(this.a.a());
        }
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnAudioCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack) {
        this.a.setOnAudioCallback(onAudioCallBack);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.a.setOnChoosePictureSizeCallBack(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnFaceDetectInfoListener(com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener onFaceDetectInfoListener) {
        this.a.setOnFaceDetectInfoListener(onFaceDetectInfoListener);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback) {
        this.a.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnRecordCallback(com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback) {
        com.aliyun.svideosdk.recorder.impl.g gVar;
        com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback2;
        this.l = onRecordCallback;
        if (onRecordCallback == null) {
            gVar = this.a;
            onRecordCallback2 = null;
        } else {
            gVar = this.a;
            onRecordCallback2 = this.v;
        }
        gVar.setOnRecordCallback(onRecordCallback2);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setOnTextureIdCallback(com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback onTextureIdCallback) {
        this.a.setOnTextureIdCallback(onTextureIdCallback);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setOutputPath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.n = str;
        this.i.a(str);
        return this.a.setOutputPath(str);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setRate(float f) {
        double d = f;
        if (d >= 0.5d && d <= 2.0d) {
            this.a.setRate(f);
            return 0;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid rate " + f);
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setRecordBorderParam(com.aliyun.svideosdk.mixrecorder.AliyunMixBorderParam aliyunMixBorderParam) {
        if (aliyunMixBorderParam != null) {
            this.a.c().setPureColorBorder((aliyunMixBorderParam.getBorderWidth() * 1.0f) / this.i.b(), aliyunMixBorderParam.getBorderColor(), aliyunMixBorderParam.getCornerRadius() / this.i.b());
        } else {
            this.a.c().setPureColorBorder(0.0f, 0, 0.0f);
        }
        this.a.b().updateSource(this.a.c());
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setRecordRotation(int i) {
        this.a.setRecordRotation(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setRotation(int i) {
        this.a.setRotation(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setVideoBitrate(int i) {
        this.i.a(i);
        return this.a.setVideoBitrate(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        this.a.setVideoQuality(videoQuality);
        this.i.a(videoQuality);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int setZoom(float f) {
        return this.a.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int startPreview() {
        int startPreview;
        java.lang.StringBuilder sb;
        java.lang.String sb2;
        if (this.d || (startPreview = b()) == 0) {
            startPreview = this.a.startPreview();
            if (startPreview != 0) {
                sb = new java.lang.StringBuilder();
            } else {
                startPreview = this.a.b().seek(this.b.getDuration(java.util.concurrent.TimeUnit.MICROSECONDS));
                if (startPreview == 0) {
                    return 0;
                }
                sb = new java.lang.StringBuilder();
            }
            sb.append("Start preview failed!ErrorCode[");
            sb.append(startPreview);
            sb.append("]");
            sb2 = sb.toString();
        } else {
            sb2 = "Prepare failed!";
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", sb2);
        return startPreview;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int startRecording() {
        this.a.setVideoBitrate(10000);
        return this.a.startRecording();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public void stopPreview() {
        this.a.stopPreview();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int stopRecording() {
        return this.a.stopRecording();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.a.a().getStickerManager() != null) {
            this.a.a().getStickerManager().setDisplaySize(this.a.a().getNativeHandle(), i2, i3);
            this.a.b().updateSource(this.a.a());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        this.a.a().setDisplay(surfaceHolder.getSurface());
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        if (this.a.a().getStickerManager() != null) {
            this.a.a().getStickerManager().setDisplaySize(this.a.a().getNativeHandle(), measuredWidth, measuredHeight);
        }
        this.a.b().updateSource(this.a.a());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        this.a.a().setDisplay(null);
        this.a.b().updateSource(this.a.a());
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int switchCamera() {
        return this.a.switchCamera();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight() {
        return this.a.switchLight();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixRecorder
    public int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        return this.a.updateAnimationFilter(effectFilter);
    }
}
