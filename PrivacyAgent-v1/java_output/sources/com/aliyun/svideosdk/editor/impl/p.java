package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
class p implements com.aliyun.svideosdk.editor.AliyunPasterRender {
    private com.aliyun.svideosdk.editor.b a;
    private com.aliyun.common.resource.ResourceParser b;
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject c;
    private com.aliyun.common.utils.Size i;
    private int j;
    private int k;
    private com.aliyun.svideosdk.editor.OnPasterResumeAndSave l;
    private com.aliyun.common.log.reporter.AlivcEditorReporter m;
    private java.io.File n = android.os.Environment.getExternalStorageDirectory();
    private com.aliyun.svideosdk.editor.impl.n d = new com.aliyun.svideosdk.editor.impl.n();

    @java.lang.Deprecated
    private com.aliyun.svideosdk.editor.impl.v<com.aliyun.svideosdk.editor.impl.p.a> f = new com.aliyun.svideosdk.editor.impl.v<>(new android.util.SparseArray());

    @java.lang.Deprecated
    private com.aliyun.svideosdk.editor.impl.v<android.graphics.Bitmap> g = new com.aliyun.svideosdk.editor.impl.v<>(new android.util.SparseArray());
    private com.aliyun.svideosdk.editor.impl.v<com.aliyun.svideosdk.common.struct.effect.EffectFilter> e = new com.aliyun.svideosdk.editor.impl.v<>(new android.util.SparseArray());

    @java.lang.Deprecated
    private com.aliyun.svideosdk.editor.impl.v<com.aliyun.svideosdk.nativerender.BitmapGenerator> h = new com.aliyun.svideosdk.editor.impl.v<>(new android.util.SparseArray());

    public class a {
        int a = -1;
        int b = -1;

        public a(com.aliyun.svideosdk.editor.impl.p pVar) {
        }
    }

    public class b {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;

        public b(com.aliyun.svideosdk.editor.impl.p pVar) {
        }
    }

    public p(com.aliyun.svideosdk.editor.b bVar, com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter, com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject, com.aliyun.common.resource.ResourceParser resourceParser) {
        this.a = bVar;
        this.b = resourceParser;
        this.m = alivcEditorReporter;
        this.c = aliyunEditorProject;
    }

    private int a(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        android.graphics.Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            return this.a.addImgView(effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation(), 0L, 2147483647L, false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_WATERMARK.a());
        }
        android.graphics.Bitmap a2 = a(effectImage.getPath());
        if (a2 == null) {
            return -20003013;
        }
        return this.a.addImgView(a2, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation(), 0L, 2147483647L, false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_WATERMARK.a());
    }

    private android.graphics.Bitmap a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && new java.io.File(str).exists()) {
            return android.graphics.BitmapFactory.decodeFile(str);
        }
        return null;
    }

    private com.aliyun.svideosdk.editor.impl.p.b a(com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        com.aliyun.svideosdk.editor.impl.p.b bVar = new com.aliyun.svideosdk.editor.impl.p.b(this);
        if (this.i.getWidth() <= 0 || this.i.getHeight() <= 0) {
            bVar.a = effectCaption.getXRatio();
            bVar.b = effectCaption.getYRatio();
            bVar.c = effectCaption.getWidthRatio();
            bVar.d = effectCaption.getHeightRatio();
        } else {
            int i = effectCaption.textWidth;
            int i2 = effectCaption.textHeight;
            int i3 = effectCaption.textCenterY;
            int i4 = effectCaption.textCenterX;
            if (effectCaption.mirror) {
                int i5 = i / 2;
                i4 = ((effectCaption.width - i4) - i5) + i5;
            }
            float f = i4 + ((int) (effectCaption.x - (effectCaption.width / 2)));
            float f2 = i3 + ((int) (effectCaption.y - (effectCaption.height / 2)));
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setRotate((float) java.lang.Math.toDegrees(effectCaption.rotation), effectCaption.x, effectCaption.y);
            float[] fArr = new float[2];
            matrix.mapPoints(fArr, 0, new float[]{f, f2}, 0, 1);
            float f3 = fArr[0];
            float width = f3 / this.i.getWidth();
            float height = fArr[1] / this.i.getHeight();
            bVar.a = width;
            bVar.b = height;
            bVar.c = i / this.i.getWidth();
            bVar.d = i2 / this.i.getHeight();
            effectCaption.setXRatio(width);
            effectCaption.setYRatio(height);
            effectCaption.setWidthRatio(bVar.c);
            effectCaption.setHeightRatio(bVar.d);
        }
        float f4 = effectCaption.rotation;
        boolean z = effectCaption.mirror;
        float f5 = effectCaption.textRotation;
        if (z) {
            f5 = -f5;
        }
        bVar.e = -(f4 + f5);
        return bVar;
    }

    private void a(int i) {
        android.graphics.Bitmap b2 = this.g.b(i);
        if (b2 != null) {
            b2.recycle();
            this.g.a(i);
        }
    }

    private void a(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        if (effectText.needSaveBmp) {
            if (!android.text.TextUtils.isEmpty(effectText.mBackgroundBmpPath)) {
                java.io.File file = new java.io.File(effectText.mBackgroundBmpPath);
                if (file.exists()) {
                    file.delete();
                }
            }
            java.lang.String generateTextFinger = effectText.generateTextFinger();
            if (effectText.mBackgroundBmp != null) {
                java.io.File file2 = new java.io.File(this.n, generateTextFinger + "_background");
                try {
                    if (!com.aliyun.common.utils.BitmapUtil.generateFileFromBitmap(effectText.mBackgroundBmp, file2.getAbsolutePath(), "image/png")) {
                        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Text background image backup failed!");
                    }
                    effectText.mBackgroundBmpPath = file2.getAbsolutePath();
                } catch (java.io.IOException e) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Text background image backup failed!" + e.getMessage());
                }
            }
            if (bitmap == null) {
                return;
            }
            java.io.File file3 = new java.io.File(this.n, generateTextFinger);
            java.lang.String str = effectText.textBmpPath;
            if (android.text.TextUtils.equals(file3.getPath(), str)) {
                return;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                java.io.File file4 = new java.io.File(str);
                if (file4.exists()) {
                    file4.delete();
                }
            }
            if (file3.exists()) {
                file3.delete();
            }
            try {
                bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, new java.io.FileOutputStream(file3));
                effectText.textBmpPath = file3.getPath();
            } catch (java.io.IOException unused) {
            }
        }
    }

    private com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack b(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack gifPasterTrack = effectPaster.getPasterType() == 0 ? new com.aliyun.svideosdk.common.struct.project.GifPasterTrack() : effectPaster.getPasterType() == 1 ? new com.aliyun.svideosdk.common.struct.project.SubTitleTrack() : effectPaster.getPasterType() == 2 ? new com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack() : null;
        if (gifPasterTrack != null) {
            this.d.a(effectPaster, gifPasterTrack);
        }
        return gifPasterTrack;
    }

    private void b(com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        long j = effectCaption.end;
        long j2 = effectCaption.start;
        long j3 = j - j2;
        long j4 = effectCaption.duration;
        if (j3 >= j4 - 100000) {
            long j5 = effectCaption.preBegin;
            long j6 = (((j3 - j5) - (j4 - effectCaption.preEnd)) + j5) - j5;
            long j7 = j5 + j2;
            effectCaption.textBegin = j7;
            j = j7 + j6;
        } else {
            effectCaption.textBegin = j2;
        }
        effectCaption.textEnd = j;
    }

    public int a(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        if (transitionBase == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "TransitionCustom  object is null");
            return -20001005;
        }
        java.lang.String jsonString = transitionBase.toJsonString();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "updateTransition  params : " + jsonString);
        int updateTransition = this.a.updateTransition(i, jsonString);
        this.c.updateTransition(i, transitionBase);
        return updateTransition;
    }

    public int a(com.aliyun.svideosdk.common.struct.effect.EffectPaint effectPaint) {
        return this.a.addImgView(effectPaint.getPath(), 0.5f, 0.5f, 1.0f, 1.0f, 0.0f, 0L, 2147483647L, false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_GRAFFITI.a());
    }

    public int a(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectFilter> trackEffect) {
        if (trackEffect == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "animation filter object is null");
            return -20001005;
        }
        if (trackEffect.getSource() == null || com.aliyun.common.utils.StringUtils.isEmpty(trackEffect.getSource().getPath())) {
            return -20001005;
        }
        int c = this.e.c();
        long startTime = trackEffect.getStartTime();
        if (startTime < 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.w("AliYunLog", "Invalid animation filter startTime " + startTime + ",auto change to 0");
            trackEffect.setStartTime(0L, java.util.concurrent.TimeUnit.MICROSECONDS);
        }
        long duration = trackEffect.getDuration();
        if (duration < 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid animation filter duration" + duration);
            return -20003002;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddAnimationFilterEvent(trackEffect);
        }
        com.aliyun.svideosdk.common.struct.effect.EffectFilter bean = trackEffect.getBean();
        int i = 0;
        while (true) {
            if (i >= c) {
                break;
            }
            if (bean.equals(this.e.f(i))) {
                ((com.aliyun.svideosdk.editor.NativeEditor) this.a).deleteAnimationFilter(this.e.d(i));
                this.e.e(i);
                break;
            }
            i++;
        }
        java.lang.String jsonString = bean.toJsonString();
        int addAnimationEff = this.a.addAnimationEff(bean.getPath(), trackEffect.getStartTime() * 1000, 1000 * trackEffect.getDuration(), jsonString);
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "addAnimationFilter  params : " + jsonString);
        trackEffect.setViewId(addAnimationEff);
        this.e.a(addAnimationEff, bean);
        com.aliyun.svideosdk.common.struct.project.Filter filter = new com.aliyun.svideosdk.common.struct.project.Filter(bean.getSource());
        filter.setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter);
        filter.setTimelineIn(trackEffect.getStartTime() / 1000.0f);
        filter.setTimelineOut(filter.getTimelineIn() + (trackEffect.getDuration() / 1000.0f));
        filter.setId(bean.getViewId());
        filter.setEffectConfig(bean.getEffectConfig());
        this.c.addAnimationFilter(filter);
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "after add, mAnimationFilters.size " + this.e.c());
        return addAnimationEff;
    }

    public com.aliyun.svideosdk.editor.impl.p.b a(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        float xRatio;
        float yRatio;
        float widthRatio;
        float heightRatio;
        com.aliyun.svideosdk.editor.impl.p.b bVar = new com.aliyun.svideosdk.editor.impl.p.b(this);
        int i = effectPaster.width;
        int i2 = effectPaster.height;
        float f = effectPaster.y;
        float f2 = effectPaster.x;
        if (this.i.getWidth() <= 0 || this.i.getHeight() <= 0) {
            xRatio = effectPaster.getXRatio();
            yRatio = effectPaster.getYRatio();
            widthRatio = effectPaster.getWidthRatio();
            heightRatio = effectPaster.getHeightRatio();
        } else {
            xRatio = f2 / this.i.getWidth();
            yRatio = f / this.i.getHeight();
            widthRatio = i / this.i.getWidth();
            heightRatio = i2 / this.i.getHeight();
            effectPaster.setXRatio(xRatio);
            effectPaster.setYRatio(yRatio);
            effectPaster.setWidthRatio(widthRatio);
            effectPaster.setHeightRatio(heightRatio);
        }
        bVar.a = xRatio;
        bVar.b = yRatio;
        bVar.c = widthRatio;
        bVar.d = heightRatio;
        bVar.e = -effectPaster.rotation;
        return bVar;
    }

    public void a() {
        if (this.e.c() > 0) {
            int c = this.e.c();
            for (int i = 0; i < c; i++) {
                ((com.aliyun.svideosdk.editor.NativeEditor) this.a).deleteAnimationFilter(this.e.d(i));
            }
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendClearAllAnimationFilterEvent();
        }
        this.e.a();
        this.c.clearAnimationFilters();
    }

    public void a(java.io.File file) {
        this.n = file;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption) {
        if (aliyunCaption.isNativeRelease()) {
            return -4;
        }
        int addCaption = this.a.addCaption(aliyunCaption);
        if (addCaption != 0) {
            aliyunCaption.releaseNativeHandle();
        } else {
            this.c.addPasterTrack(com.aliyun.svideosdk.common.struct.project.CaptionTrack.fromCaption(aliyunCaption));
        }
        return addCaption;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addCaptionPaster(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddCaptionBmpEvent(effectCaption);
        }
        a(bitmap, effectCaption);
        com.aliyun.svideosdk.editor.impl.p.b a2 = a((com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectCaption);
        int addGifView = this.a.addGifView(effectCaption.getSource().getPath(), a2.a, a2.b, a2.c, a2.d, a2.e, effectCaption.mirror, effectCaption.start, effectCaption.end - effectCaption.start, true);
        if (addGifView <= 0 || addGifView > 268435456) {
            return addGifView;
        }
        effectCaption.gifViewId = addGifView;
        com.aliyun.svideosdk.editor.impl.p.a aVar = new com.aliyun.svideosdk.editor.impl.p.a(this);
        aVar.b = addGifView;
        b(effectCaption);
        long j = effectCaption.textBegin;
        long j2 = effectCaption.textEnd - j;
        com.aliyun.svideosdk.editor.impl.p.b a3 = a(effectCaption);
        int addImgView = this.a.addImgView(bitmap, a3.a, a3.b, a3.c, a3.d, a3.e, j, j2, true, effectCaption.textBegin - effectCaption.start, com.aliyun.svideosdk.editor.d.VIEW_TYPE_TEXT.a());
        if (addImgView <= 0) {
            return addImgView;
        }
        aVar.a = addImgView;
        effectCaption.setViewId(addImgView);
        this.c.addPasterTrack(b((com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectCaption));
        this.f.a(addImgView, aVar);
        this.g.a(addImgView, bitmap);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addCaptionPaster(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddCaptionGeneratorEvent(effectCaption);
        }
        com.aliyun.svideosdk.editor.impl.p.b a2 = a((com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectCaption);
        long j = effectCaption.end - effectCaption.start;
        com.aliyun.svideosdk.editor.impl.p.a aVar = new com.aliyun.svideosdk.editor.impl.p.a(this);
        b(effectCaption);
        long j2 = effectCaption.textBegin;
        long j3 = effectCaption.textEnd - j2;
        com.aliyun.svideosdk.editor.impl.p.b a3 = a(effectCaption);
        int addGifTextView = this.a.addGifTextView(effectCaption.getSource().getPath(), a2.a, a2.b, a2.c, a2.d, a2.e, effectCaption.mirror, effectCaption.start, j, true, bitmapGenerator, a3.a, a3.b, a3.c, a3.d, a3.e, this.i.getWidth(), this.i.getHeight(), j2, j3, true, effectCaption.textBegin - effectCaption.start);
        if (addGifTextView <= 0) {
            return addGifTextView;
        }
        aVar.a = addGifTextView;
        effectCaption.setViewId(addGifTextView);
        this.c.addPasterTrack(b((com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectCaption));
        this.f.a(addGifTextView, aVar);
        this.h.a(addGifTextView, bitmapGenerator);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addEffectPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        if (effectPaster == null || effectPaster.getPath() == null || !new java.io.File(effectPaster.getPath()).exists()) {
            return -20003011;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddPasterEvent(effectPaster);
        }
        long j = effectPaster.end - effectPaster.start;
        com.aliyun.svideosdk.editor.impl.p.b a2 = a(effectPaster);
        int addGifView = this.a.addGifView(effectPaster.getPath(), a2.a, a2.b, a2.c, a2.d, a2.e, effectPaster.mirror, effectPaster.start, j, false);
        if (addGifView <= 0 || addGifView > 268435456) {
            return addGifView;
        }
        effectPaster.setViewId(addGifView);
        this.c.addPasterTrack(b(effectPaster));
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addSubtitle(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddSubtitleBmpEvent(effectText);
        }
        a(bitmap, effectText);
        long j = effectText.end - effectText.start;
        com.aliyun.svideosdk.editor.impl.p.b a2 = a(effectText);
        int addImgView = this.a.addImgView(bitmap, a2.a, a2.b, a2.c, a2.d, a2.e, effectText.start, j, true, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_TEXT.a());
        if (addImgView <= 0 || addImgView > 268435456) {
            return addImgView;
        }
        effectText.setViewId(addImgView);
        this.c.addPasterTrack(b(effectText));
        this.g.a(addImgView, bitmap);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addSubtitle(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddSubtitleGeneratorEvent(effectText);
        }
        a((android.graphics.Bitmap) null, effectText);
        long j = effectText.end - effectText.start;
        com.aliyun.svideosdk.editor.impl.p.b a2 = a(effectText);
        int addImgView = this.a.addImgView(bitmapGenerator, a2.a, a2.b, a2.c, a2.d, a2.e, this.i.getWidth(), this.i.getHeight(), effectText.start, j, true, 0L);
        if (addImgView <= 0 || addImgView > 268435456) {
            return addImgView;
        }
        effectText.setViewId(addImgView);
        this.c.addPasterTrack(b(effectText));
        this.h.a(addImgView, bitmapGenerator);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public synchronized int applyPaintCanvas(com.aliyun.svideosdk.common.struct.effect.EffectPaint effectPaint) {
        if (effectPaint != null) {
            if (effectPaint.getPath() != null) {
                java.io.File file = new java.io.File(effectPaint.getPath());
                if (!file.exists()) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Paint canvas image file not exist, path:" + file.getAbsolutePath());
                    return -20003013;
                }
                int i = this.k;
                if (i != 0) {
                    this.a.deleteView(i, com.aliyun.svideosdk.editor.d.VIEW_TYPE_GRAFFITI.a());
                }
                int a2 = a(effectPaint);
                if (a2 < 0) {
                    return a2;
                }
                effectPaint.setViewId(a2);
                com.aliyun.svideosdk.common.struct.project.PaintTrack paintTrack = new com.aliyun.svideosdk.common.struct.project.PaintTrack();
                paintTrack.setSource(new com.aliyun.svideosdk.common.struct.project.Source(effectPaint.getPath()));
                com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo = effectPaint.getCanvasInfo();
                if (canvasInfo != null) {
                    paintTrack.setCanvasInfo(canvasInfo.convertCoordinate(getDisplaySize().getWidth(), getDisplaySize().getHeight(), false));
                }
                paintTrack.setTimelineIn(0.0f);
                paintTrack.setTimelineOut(2.1474836E9f);
                paintTrack.setId(a2);
                this.c.setCanvasTrack(paintTrack);
                this.k = a2;
                return 0;
            }
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid effect paint object");
        return -20001005;
    }

    public int b(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffect) {
        if (this.c.getPasterTrackByID(trackEffect.getViewId()) != null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Duplicated add image");
            return 1073754181;
        }
        com.aliyun.svideosdk.common.struct.effect.EffectImage bean = trackEffect.getBean();
        android.graphics.Bitmap bitmap = bean.getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = a(bean.getPath());
        }
        android.graphics.Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            return -20003013;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddImageEvent(trackEffect);
        }
        int addImgView = this.a.addImgView(bitmap2, bean.getXRadio(), bean.getYRadio(), bean.getWidthRatio(), bean.getHeightRatio(), bean.getRotation(), trackEffect.getStartTime() * 1000, 1000 * trackEffect.getDuration(), false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
        if (addImgView <= 0) {
            return addImgView;
        }
        bean.setViewId(addImgView);
        com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = new com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack();
        photoPasterTrack.setId(addImgView);
        photoPasterTrack.setX(bean.getXRadio());
        photoPasterTrack.setY(bean.getYRadio());
        photoPasterTrack.setWidth(bean.getWidthRatio());
        photoPasterTrack.setHeight(bean.getHeightRatio());
        photoPasterTrack.setRotation(bean.getRotation());
        photoPasterTrack.setMirror(false);
        photoPasterTrack.setTimelineIn(trackEffect.getStartTime() / 1000.0f);
        photoPasterTrack.setTimelineOut(trackEffect.getEndTime() / 1000.0f);
        photoPasterTrack.setSource(bean.getSource());
        this.c.addPasterTrack(photoPasterTrack);
        return addImgView;
    }

    public void b() {
        this.e.a();
        this.f.a();
        this.g.a();
        this.h.a();
    }

    public void c() {
        if (this.c.getCanvasTrack() == null || !new java.io.File(this.c.getCanvasTrack().getSource().getPath()).exists()) {
            return;
        }
        com.aliyun.svideosdk.common.struct.effect.EffectPaint effectPaint = new com.aliyun.svideosdk.common.struct.effect.EffectPaint();
        effectPaint.setPath(this.c.getCanvasTrack().getSource().getPath());
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo = this.c.getCanvasTrack().getCanvasInfo();
        if (canvasInfo != null) {
            effectPaint.setCanvasInfo(canvasInfo.convertCoordinate(this.i.getWidth(), this.i.getHeight(), true));
        }
        applyPaintCanvas(effectPaint);
    }

    public void c(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectFilter> trackEffect) {
        int a2 = this.e.a((com.aliyun.svideosdk.editor.impl.v<com.aliyun.svideosdk.common.struct.effect.EffectFilter>) trackEffect.getBean());
        if (a2 < 0) {
            return;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendRemoveAnimationFilterEvent(trackEffect);
        }
        int d = this.e.d(a2);
        ((com.aliyun.svideosdk.editor.NativeEditor) this.a).deleteAnimationFilter(d);
        this.e.e(a2);
        this.c.removeAnimationFilter(d);
    }

    public void d() {
        if (this.l != null) {
            boolean z = this.c.getVersion() == 0;
            for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : this.c.getTimeline().getPasterTracks()) {
                try {
                    if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.gif) {
                        com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack = (com.aliyun.svideosdk.common.struct.project.GifPasterTrack) pasterTrack;
                        com.aliyun.svideosdk.common.struct.project.DynamicImage dynamicImage = (com.aliyun.svideosdk.common.struct.project.DynamicImage) this.b.readResource(gifPasterTrack.getSource().getPath(), com.aliyun.svideosdk.common.struct.project.DynamicImage.class);
                        gifPasterTrack.setFrameArray(dynamicImage.frameArry);
                        gifPasterTrack.setTimeArray(dynamicImage.timeArry);
                        gifPasterTrack.setName(dynamicImage.n);
                        if (z) {
                            gifPasterTrack.setX(gifPasterTrack.getX() / com.aliyun.svideosdk.editor.impl.n.d);
                            gifPasterTrack.setY(gifPasterTrack.getY() / com.aliyun.svideosdk.editor.impl.n.d);
                            gifPasterTrack.setWidth(gifPasterTrack.getWidth() / this.i.getWidth());
                            gifPasterTrack.setHeight(gifPasterTrack.getHeight() / this.i.getHeight());
                        }
                    } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.subtitle || pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption) {
                        com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack = (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) pasterTrack;
                        if (subTitleTrack.getTextSize() == 0.0f) {
                            java.lang.String text = subTitleTrack.getText();
                            android.graphics.Rect rect = new android.graphics.Rect();
                            android.graphics.Paint paint = new android.graphics.Paint();
                            paint.setAntiAlias(true);
                            paint.setStrokeWidth(1.0f);
                            paint.setTextAlign(android.graphics.Paint.Align.CENTER);
                            paint.setTextSize(48.0f);
                            paint.getTextBounds(text, 0, text.length(), rect);
                            subTitleTrack.setTextWidth((rect.width() * 1.0f) / this.i.getWidth());
                            subTitleTrack.setTextHeight((rect.height() * 1.0f) / this.i.getWidth());
                            subTitleTrack.setTextSize(48.0f / this.i.getWidth());
                            subTitleTrack.setTextAlignment(android.text.Layout.Alignment.ALIGN_CENTER.ordinal());
                        }
                        if (z) {
                            subTitleTrack.setX(subTitleTrack.getX() / com.aliyun.svideosdk.editor.impl.n.d);
                            subTitleTrack.setY(subTitleTrack.getY() / com.aliyun.svideosdk.editor.impl.n.d);
                            subTitleTrack.setWidth(subTitleTrack.getWidth() / this.i.getWidth());
                            subTitleTrack.setHeight(subTitleTrack.getHeight() / this.i.getHeight());
                            subTitleTrack.setTextWidth(subTitleTrack.getTextWidth() / this.i.getWidth());
                            subTitleTrack.setTextHeight(subTitleTrack.getTextHeight() / this.i.getHeight());
                        }
                        if (subTitleTrack.getSource() != null) {
                            com.aliyun.svideosdk.common.struct.project.DynamicImage dynamicImage2 = (com.aliyun.svideosdk.common.struct.project.DynamicImage) this.b.readResource(subTitleTrack.getSource().getPath(), com.aliyun.svideosdk.common.struct.project.DynamicImage.class);
                            subTitleTrack.setFrameArray(dynamicImage2.frameArry);
                            subTitleTrack.setTimeArray(dynamicImage2.timeArry);
                            subTitleTrack.setName(dynamicImage2.n);
                            subTitleTrack.setTextRotation((float) java.lang.Math.toRadians(dynamicImage2.tAngle));
                            subTitleTrack.setPreBegin((long) (dynamicImage2.tBegin * 1000000.0f));
                            subTitleTrack.setPreEnd((long) (dynamicImage2.tEnd * 1000000.0f));
                            if (z && pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption) {
                                ((com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) subTitleTrack).setTextCenterX(((com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) subTitleTrack).getTextCenterX() / this.i.getWidth());
                                ((com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) subTitleTrack).setTextCenterY(((com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) subTitleTrack).getTextCenterY() / this.i.getHeight());
                            }
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            if (z) {
                this.c.setVersion(1);
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(this.c.getTimeline().getPasterTracks());
            this.c.getTimeline().getPasterTracks().clear();
            this.l.onPasterResume(arrayList);
        }
    }

    public void d(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffect) {
        if (this.c.getPasterTrackByID(trackEffect.getViewId()) != null) {
            this.a.deleteView(trackEffect.getViewId(), com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
            this.c.removePasterTrack(trackEffect.getViewId());
        }
    }

    public int e(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectFilter> trackEffect) {
        if (trackEffect == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "animation filter object is null");
            return -20001005;
        }
        com.aliyun.svideosdk.common.struct.effect.EffectFilter bean = trackEffect.getBean();
        java.lang.String jsonString = bean.toJsonString();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "updateAnimationFilter  params : " + jsonString);
        int updateAnimationEff = this.a.updateAnimationEff(bean.getViewId(), trackEffect.getStartTime() * 1000, 1000 * trackEffect.getDuration(), jsonString);
        this.c.updateAnimationFilter(bean);
        return updateAnimationEff;
    }

    public void e() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.c;
        if (aliyunEditorProject == null) {
            return;
        }
        for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : aliyunEditorProject.getTimeline().getPasterTracks()) {
            if (pasterTrack instanceof com.aliyun.svideosdk.common.struct.project.CaptionTrack) {
                ((com.aliyun.svideosdk.common.struct.project.CaptionTrack) pasterTrack).updateInfo();
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public java.util.List<com.aliyun.svideosdk.common.AliyunCaption> findCaptions(long j) {
        return this.a.findCaptions(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public com.aliyun.common.utils.Size getDisplaySize() {
        return this.i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int hidePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrackByID = this.c.getPasterTrackByID(effectPaster.getViewId());
        if (pasterTrackByID == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", "Not find effect paster:" + effectPaster);
            return -20003002;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendHidePasterEvent(effectPaster);
        }
        int id = pasterTrackByID.getId();
        int c = this.f.c(id);
        if (c < 0) {
            return this.a.deleteView(id, com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
        }
        com.aliyun.svideosdk.editor.impl.p.a f = this.f.f(c);
        com.aliyun.svideosdk.editor.b bVar = this.a;
        int i = f.b;
        com.aliyun.svideosdk.editor.d dVar = com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER;
        int deleteView = bVar.deleteView(i, dVar.a());
        if (deleteView != 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", "delete paster[" + effectPaster + "] failed!return " + deleteView);
        }
        int i2 = f.a;
        if (i2 >= 0 && (deleteView = this.a.deleteView(i2, dVar.a())) != 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", "delete paster[" + effectPaster + "] bmp failed!return " + deleteView);
        }
        return deleteView;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public synchronized void removeCanvas() {
        int i = this.k;
        if (i != 0) {
            this.a.deleteView(i, com.aliyun.svideosdk.editor.d.VIEW_TYPE_GRAFFITI.a());
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int removeCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption) {
        if (this.c.getPasterTrackByID(aliyunCaption.getId()) == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", "Not find caption ");
            return -20003002;
        }
        this.c.removePasterTrack(aliyunCaption.getId());
        return this.a.removeCaption(aliyunCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        int deleteView;
        java.lang.StringBuilder sb;
        com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrackByID = this.c.getPasterTrackByID(effectPaster.getViewId());
        if (pasterTrackByID == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", "Not find paster " + effectPaster);
            return -20003002;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendRemovePasterEvent(effectPaster);
        }
        int id = pasterTrackByID.getId();
        com.aliyun.svideosdk.editor.impl.p.a b2 = this.f.b(id);
        if (b2 == null) {
            deleteView = this.a.deleteView(id, com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
            if (deleteView != 0) {
                sb = new java.lang.StringBuilder();
                sb.append("delete paster[");
                sb.append(effectPaster);
                sb.append("] failed!return ");
                sb.append(deleteView);
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", sb.toString());
            }
            this.c.removePasterTrack(id);
            a(pasterTrackByID.getId());
            return deleteView;
        }
        this.f.a(id);
        com.aliyun.svideosdk.editor.b bVar = this.a;
        int i = b2.b;
        com.aliyun.svideosdk.editor.d dVar = com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER;
        deleteView = bVar.deleteView(i, dVar.a());
        if (deleteView != 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", "delete paster[" + effectPaster + "] failed!return " + deleteView);
        }
        int i2 = b2.a;
        if (i2 >= 0 && (deleteView = this.a.deleteView(i2, dVar.a())) != 0) {
            sb = new java.lang.StringBuilder();
            sb.append("delete paster[");
            sb.append(effectPaster);
            sb.append("] failed!return ");
            sb.append(deleteView);
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliyunPasterRenderImpl", sb.toString());
        }
        this.c.removePasterTrack(id);
        a(pasterTrackByID.getId());
        return deleteView;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public void setDisplaySize(int i, int i2) {
        this.d.a(i, i2);
        this.i = new com.aliyun.common.utils.Size(i, i2);
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendSetDisplaySizeEvent(i, i2);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int setEffectWaterMark(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        if (effectImage == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Watermark object is null");
            return -20001005;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.m;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendApplyWaterMarkEvent(effectImage.getPath(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getXRadio(), effectImage.getYRadio());
        }
        int i = this.j;
        if (i != 0) {
            this.a.deleteView(i, com.aliyun.svideosdk.editor.d.VIEW_TYPE_WATERMARK.a());
        }
        int a2 = a(effectImage);
        effectImage.setViewId(a2);
        this.j = a2;
        return a2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public void setOnPasterResumeAndSave(com.aliyun.svideosdk.editor.OnPasterResumeAndSave onPasterResumeAndSave) {
        this.l = onPasterResumeAndSave;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showCaptionPaster(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        a(bitmap, effectCaption);
        removePaster(effectCaption);
        return addCaptionPaster(bitmap, effectCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showCaptionPaster(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        removePaster(effectCaption);
        return addCaptionPaster(bitmapGenerator, effectCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        removePaster(effectPaster);
        return addEffectPaster(effectPaster);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showTextPaster(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        a(bitmap, effectText);
        if (bitmap == null) {
            return showPaster(effectText);
        }
        removePaster(effectText);
        return addSubtitle(bitmap, effectText);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showTextPaster(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        if (bitmapGenerator == null) {
            return showPaster(effectText);
        }
        removePaster(effectText);
        return addSubtitle(bitmapGenerator, effectText);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int updateCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption) {
        return this.a.updateCaption(aliyunCaption);
    }
}
