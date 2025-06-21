package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class q implements com.aliyun.svideosdk.editor.AliyunIPipController {
    private com.aliyun.svideosdk.editor.NativeEditor a;
    private com.aliyun.svideosdk.editor.impl.c c;
    private com.aliyun.svideosdk.editor.impl.b d;
    private com.aliyun.svideosdk.common.AliyunPip e;
    private java.lang.ref.WeakReference<com.aliyun.svideosdk.editor.AliyunIPipTrack> f;
    private final com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip g;
    private java.lang.ref.WeakReference<com.aliyun.svideosdk.editor.impl.g> h;
    private com.aliyun.svideosdk.editor.impl.i i;
    private boolean b = false;
    private com.aliyun.svideosdk.editor.impl.AliyunIControllerCallback j = new com.aliyun.svideosdk.editor.impl.q.a();
    private com.aliyun.svideosdk.editor.AliyunIAnimationController k = new com.aliyun.svideosdk.editor.impl.q.b();

    public class a implements com.aliyun.svideosdk.editor.impl.AliyunIControllerCallback {
        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.impl.AliyunIControllerCallback
        public int onApply() {
            com.aliyun.svideosdk.editor.impl.q.this.g();
            if (com.aliyun.svideosdk.editor.impl.q.this.h.get() != null) {
                ((com.aliyun.svideosdk.editor.impl.g) com.aliyun.svideosdk.editor.impl.q.this.h.get()).saveEffectToLocal();
            }
            return com.aliyun.svideosdk.editor.impl.q.this.f();
        }
    }

    public class b implements com.aliyun.svideosdk.editor.AliyunIAnimationController {
        public b() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIAnimationController
        public int addFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
            actionBase.setTargetId(com.aliyun.svideosdk.editor.impl.q.this.e.getStreamId());
            actionBase.setIsStream(true);
            int addFrameAnimation = ((com.aliyun.svideosdk.editor.impl.g) com.aliyun.svideosdk.editor.impl.q.this.h.get()).addFrameAnimation(actionBase);
            if (com.aliyun.svideosdk.editor.impl.q.this.h.get() != null) {
                ((com.aliyun.svideosdk.editor.impl.g) com.aliyun.svideosdk.editor.impl.q.this.h.get()).saveEffectToLocal();
            }
            return addFrameAnimation;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIAnimationController
        public int removeFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
            int removeFrameAnimation = ((com.aliyun.svideosdk.editor.impl.g) com.aliyun.svideosdk.editor.impl.q.this.h.get()).removeFrameAnimation(actionBase);
            if (com.aliyun.svideosdk.editor.impl.q.this.h.get() != null) {
                ((com.aliyun.svideosdk.editor.impl.g) com.aliyun.svideosdk.editor.impl.q.this.h.get()).saveEffectToLocal();
            }
            return removeFrameAnimation;
        }
    }

    public q(com.aliyun.svideosdk.editor.NativeEditor nativeEditor, java.lang.String str, com.aliyun.svideosdk.editor.impl.g gVar) {
        this.a = nativeEditor;
        com.aliyun.svideosdk.common.AliyunPip aliyunPip = new com.aliyun.svideosdk.common.AliyunPip();
        this.e = aliyunPip;
        aliyunPip.setFilePath(str);
        com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip pipVideoTrackClip = new com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip();
        this.g = pipVideoTrackClip;
        this.h = new java.lang.ref.WeakReference<>(gVar);
        this.c = new com.aliyun.svideosdk.editor.impl.c(this.a, this.e, pipVideoTrackClip, gVar);
        this.d = new com.aliyun.svideosdk.editor.impl.b(this.a, this.e, pipVideoTrackClip, gVar);
        this.i = new com.aliyun.svideosdk.editor.impl.i(this.e.getLayoutParams(), this.j);
        e();
    }

    private int a() {
        return this.a.addPicInPic(this.e.getNativeHandle());
    }

    private static java.lang.String a(java.lang.String str) {
        java.lang.String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase(java.util.Locale.US);
        if (lowerCase != null) {
            return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        }
        return null;
    }

    private long b() {
        return this.e.getDuration();
    }

    private void e() {
        int i;
        int i2;
        long j;
        long j2;
        java.lang.String filePath = this.e.getFilePath();
        java.lang.String a2 = a(filePath);
        int i3 = 0;
        if ((a2 != null && a2.startsWith("video")) || filePath.endsWith("gif") || filePath.endsWith("GIF")) {
            this.g.setType(0);
            com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
            nativeParser.init(filePath);
            int i4 = 16;
            try {
                try {
                    i = java.lang.Integer.parseInt(nativeParser.getValue(6));
                    try {
                        i4 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                        i3 = java.lang.Integer.parseInt(nativeParser.getValue(14));
                        j2 = java.lang.Long.parseLong(nativeParser.getValue(3));
                    } catch (java.lang.Exception unused) {
                        j2 = 0;
                        nativeParser.release();
                        nativeParser.dispose();
                        i2 = i4;
                        j = j2;
                        this.e.setWidth((i3 != 90 || i3 == 270) ? i2 : i);
                        com.aliyun.svideosdk.common.AliyunPip aliyunPip = this.e;
                        if (i3 != 90) {
                            i = i2;
                        }
                        aliyunPip.setHeight(i);
                        this.e.setDuration(j);
                    }
                } catch (java.lang.Throwable th) {
                    nativeParser.release();
                    nativeParser.dispose();
                    throw th;
                }
            } catch (java.lang.Exception unused2) {
                i = 9;
            }
            nativeParser.release();
            nativeParser.dispose();
            i2 = i4;
            j = j2;
        } else {
            this.g.setType(1);
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(filePath, options);
            i = options.outWidth;
            i2 = options.outHeight;
            j = 3000000;
        }
        this.e.setWidth((i3 != 90 || i3 == 270) ? i2 : i);
        com.aliyun.svideosdk.common.AliyunPip aliyunPip2 = this.e;
        if (i3 != 90 && i3 != 270) {
            i = i2;
        }
        aliyunPip2.setHeight(i);
        this.e.setDuration(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        return this.a.updatePicInPic(this.e.getNativeHandle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source();
        source.setPath(this.e.getFilePath());
        this.g.setSource(source);
        this.g.setClipId(this.e.getStreamId());
        com.aliyun.svideosdk.common.struct.project.BorderInfo borderInfo = new com.aliyun.svideosdk.common.struct.project.BorderInfo();
        borderInfo.setColor(this.e.getBoarderColor());
        borderInfo.setWidth(this.e.getBoarderWidth());
        borderInfo.setCornerRadius(this.e.getCornerRadius());
        this.g.setBorder(borderInfo);
        this.g.setRotationRadian(this.e.getRotationRadian());
        android.graphics.PointF position = this.e.getPosition();
        this.g.setCenterX(position.x);
        this.g.setCenterY(position.y);
        this.g.setWidth(this.e.getWidth());
        this.g.setHeight(this.e.getHeight());
        this.g.setScale(this.e.getScale());
        this.g.setAlpha(this.e.getAlpha());
        this.g.setMixWeight(this.e.getVolume() * 100);
        this.g.setDenoiseWeight(this.e.getDenoiseWeight());
        this.g.setTimelineIn(com.aliyun.common.media.TimeUnitUtil.microToSecond(this.e.getTimelineStartTime()));
        this.g.setTimelineOut(com.aliyun.common.media.TimeUnitUtil.microToSecond(this.e.getTimelineEndTime()));
        this.g.setIn(com.aliyun.common.media.TimeUnitUtil.microToSecond(this.e.getStartTime()));
        this.g.setOut(com.aliyun.common.media.TimeUnitUtil.microToSecond(this.e.getEndTime()));
        this.g.setDuration(com.aliyun.common.media.TimeUnitUtil.microToSecond(this.e.getDuration()));
        this.g.setHorizontalFlip(this.e.getHorizontalFlip());
    }

    public com.aliyun.svideosdk.editor.AliyunIPipController a(int i) {
        this.e.setLayerIndex(i);
        return this;
    }

    public com.aliyun.svideosdk.editor.impl.q a(long j) {
        this.e.setDuration(j);
        return this;
    }

    public void a(com.aliyun.svideosdk.editor.AliyunIPipTrack aliyunIPipTrack) {
        this.f = new java.lang.ref.WeakReference<>(aliyunIPipTrack);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int apply() {
        int f;
        if (this.b) {
            f = f();
        } else {
            f = a();
            this.b = true;
        }
        g();
        if (this.h.get() != null) {
            this.h.get().saveEffectToLocal();
        }
        return f;
    }

    public com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip c() {
        return this.g;
    }

    public void d() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor = this.a;
        if (nativeEditor != null) {
            nativeEditor.removePipInPic(this.e.getStreamId());
            this.a = null;
        }
        com.aliyun.svideosdk.common.AliyunPip aliyunPip = this.e;
        if (aliyunPip != null) {
            aliyunPip.release();
        }
        com.aliyun.svideosdk.editor.impl.c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIAnimationController getAnimationController() {
        if (this.b) {
            return this.k;
        }
        throw new java.lang.IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIAudioController getAudioController() {
        if (this.b) {
            return this.d;
        }
        throw new java.lang.IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIAugmentationController getAugmentationController() {
        if (this.b) {
            return this.c;
        }
        throw new java.lang.IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getClipDurationInMillis() {
        return com.aliyun.common.media.TimeUnitUtil.microsToMills(this.e.getDuration());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getClipStartTimeInMillis() {
        return com.aliyun.common.media.TimeUnitUtil.microsToMills(this.e.getStartTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int getHeight() {
        return this.e.getHeight();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunILayoutController getLayoutController() {
        if (this.b) {
            return this.i;
        }
        throw new java.lang.IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipController
    public com.aliyun.svideosdk.editor.AliyunIPipTrack getOwnerTrack() {
        return this.f.get();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public java.lang.String getPath() {
        return this.e.getFilePath();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipController
    public android.graphics.RectF getPipRectFInCurrentScreen() {
        float f;
        float f2;
        int e = this.h.get().e();
        int d = this.h.get().d();
        float width = getWidth();
        float f3 = width * 1.0f;
        float f4 = e;
        float f5 = f3 / f4;
        float height = getHeight();
        float f6 = 1.0f * height;
        float f7 = d;
        if (f5 > f6 / f7) {
            f = getLayoutController().getScale();
            f2 = ((f4 * f) * (f6 / width)) / f7;
        } else {
            float scale = getLayoutController().getScale();
            f = ((f7 * scale) * (f3 / height)) / f4;
            f2 = scale;
        }
        android.graphics.PointF position = getLayoutController().getPosition();
        float f8 = position.x;
        float f9 = f / 2.0f;
        float f10 = position.y;
        float f11 = f2 / 2.0f;
        return new android.graphics.RectF(f8 - f9, f10 - f11, f8 + f9, f10 + f11);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int getStreamId() {
        return this.e.getStreamId();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getTimeLineEndTimeInMillis() {
        return com.aliyun.common.media.TimeUnitUtil.microsToMills(this.e.getTimelineEndTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getTimeLineStartTimeInMillis() {
        return com.aliyun.common.media.TimeUnitUtil.microsToMills(this.e.getTimelineStartTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int getWidth() {
        return this.e.getWidth();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIPipController setBorderColor(int i) {
        this.e.setBoarderColor(i);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIPipController setBorderCornerRadius(float f) {
        this.e.setCornerRadius(f / this.h.get().g());
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIPipController setBorderWidth(float f) {
        this.e.setBoarderWidth(f / this.h.get().g());
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIPipController setClipEndTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        long micros = timeUnit.toMicros(j);
        this.e.setEndTime(micros);
        long startTime = micros - this.e.getStartTime();
        if (startTime > 0) {
            this.e.setDuration(startTime);
        }
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIPipController setClipStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        long micros = timeUnit.toMicros(j);
        if (micros < 0) {
            micros = 0;
        } else if (micros > b()) {
            micros = b();
        }
        this.e.setStartTime(micros);
        this.e.setEndTime(micros + b());
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIPipController setHorizontalFlip(boolean z) {
        this.e.setHorizontalFlip(z);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public com.aliyun.svideosdk.editor.AliyunIPipController setTimelineStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        this.e.setTimelineStartTime(timeUnit.toMicros(j));
        return this;
    }
}
