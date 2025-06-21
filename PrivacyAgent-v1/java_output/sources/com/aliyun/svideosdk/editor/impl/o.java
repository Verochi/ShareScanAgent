package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
class o implements com.aliyun.svideosdk.editor.AliyunPasterManager {
    private com.aliyun.svideosdk.editor.impl.n a;
    private com.aliyun.common.resource.ResourceParser b;
    private com.aliyun.svideosdk.editor.impl.p c;
    private com.aliyun.common.log.reporter.AlivcEditorReporter d;
    private com.aliyun.svideosdk.editor.OnPasterRestored e;
    private com.aliyun.svideosdk.editor.impl.g f;
    private com.aliyun.svideosdk.editor.e.a g;
    private java.util.Map<com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack> h = new java.util.HashMap();
    private java.util.List<com.aliyun.svideosdk.editor.AliyunIPasterController> i;
    private final com.aliyun.svideosdk.editor.OnPasterResumeAndSave j;

    public class a implements com.aliyun.svideosdk.editor.OnPasterResumeAndSave {
        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.OnPasterResumeAndSave
        public void onPasterResume(java.util.List<com.aliyun.svideosdk.common.struct.project.PasterTrack> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : list) {
                if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo) {
                    com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) pasterTrack;
                    com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage = new com.aliyun.svideosdk.common.struct.effect.EffectImage(photoPasterTrack.getSource());
                    effectImage.setXRadio(photoPasterTrack.getX());
                    effectImage.setYRatio(photoPasterTrack.getY());
                    effectImage.setWidthRatio(photoPasterTrack.getWidth());
                    effectImage.setHeightRatio(photoPasterTrack.getHeight());
                    effectImage.setRotation(photoPasterTrack.getRotation());
                    photoPasterTrack.setId(com.aliyun.svideosdk.editor.impl.o.this.c.b(new com.aliyun.svideosdk.common.struct.effect.TrackEffect<>((long) (photoPasterTrack.getTimelineIn() * 1000.0f), (long) ((photoPasterTrack.getTimelineOut() - photoPasterTrack.getTimelineIn()) * 1000.0f), effectImage)));
                    com.aliyun.svideosdk.editor.impl.o.this.f.a(photoPasterTrack);
                } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.roll_captions) {
                    com.aliyun.svideosdk.editor.impl.o.this.g.a((com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) pasterTrack);
                } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.gif) {
                    com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack = (com.aliyun.svideosdk.common.struct.project.GifPasterTrack) pasterTrack;
                    com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = new com.aliyun.svideosdk.common.struct.effect.EffectPaster(gifPasterTrack.getSource());
                    com.aliyun.svideosdk.editor.impl.o.this.a.c(effectPaster, gifPasterTrack);
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.d("COMPOSE", "restore after : " + effectPaster.toString());
                    arrayList.add(new com.aliyun.svideosdk.editor.impl.l(effectPaster, com.aliyun.svideosdk.editor.impl.o.this.c, com.aliyun.svideosdk.editor.impl.o.this, true));
                    if (!com.aliyun.svideosdk.editor.impl.o.this.a.a()) {
                        com.aliyun.svideosdk.editor.impl.o.this.h.put(effectPaster, gifPasterTrack);
                    }
                    com.aliyun.svideosdk.editor.impl.o.this.c.addEffectPaster(effectPaster);
                    pasterTrack.setId(effectPaster.getViewId());
                    if (!gifPasterTrack.getActions().isEmpty()) {
                        effectPaster.action = gifPasterTrack.getActions().get(gifPasterTrack.getActions().size() - 1);
                    }
                    com.aliyun.svideosdk.editor.impl.o.this.f.a(gifPasterTrack);
                } else {
                    com.aliyun.svideosdk.common.struct.project.PasterTrack.Type type = pasterTrack.getType();
                    com.aliyun.svideosdk.common.struct.project.PasterTrack.Type type2 = com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.subtitle;
                    android.graphics.Bitmap bitmap = null;
                    if (type == type2 || pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption) {
                        com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack = (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) pasterTrack;
                        com.aliyun.svideosdk.common.struct.effect.EffectText effectText = pasterTrack.getType() == type2 ? new com.aliyun.svideosdk.common.struct.effect.EffectText(subTitleTrack.getFont()) : new com.aliyun.svideosdk.common.struct.effect.EffectCaption(subTitleTrack.getSource());
                        com.aliyun.svideosdk.editor.impl.o.this.a.c(effectText, subTitleTrack);
                        com.aliyun.svideosdk.editor.impl.o.this.a.b(effectText, subTitleTrack);
                        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("COMPOSE", "restore after rotation : " + effectText.rotation + " width : " + effectText.width + " height : " + effectText.height + "x : " + effectText.x + " y : " + effectText.y + " mirror : " + effectText.mirror + " name : " + effectText.name);
                        boolean z = effectText instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption;
                        arrayList.add(z ? new com.aliyun.svideosdk.editor.impl.k((com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText, com.aliyun.svideosdk.editor.impl.o.this.c, com.aliyun.svideosdk.editor.impl.o.this, true) : new com.aliyun.svideosdk.editor.impl.m(effectText, com.aliyun.svideosdk.editor.impl.o.this.c, com.aliyun.svideosdk.editor.impl.o.this, true));
                        java.lang.String str = effectText.textBmpPath;
                        if (!android.text.TextUtils.isEmpty(str) && new java.io.File(str).exists()) {
                            bitmap = android.graphics.BitmapFactory.decodeFile(str);
                        }
                        effectText.needSaveBmp = false;
                        if (bitmap == null) {
                            com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator textBitmapGenerator = new com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator();
                            textBitmapGenerator.updateTextBitmap(com.aliyun.svideosdk.editor.impl.text.TextBitmap.fromEffectText(effectText));
                            if (z) {
                                com.aliyun.svideosdk.editor.impl.o.this.c.addCaptionPaster(textBitmapGenerator, (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText);
                            } else {
                                com.aliyun.svideosdk.editor.impl.o.this.c.addSubtitle(textBitmapGenerator, effectText);
                            }
                        } else if (z) {
                            com.aliyun.svideosdk.editor.impl.o.this.c.addCaptionPaster(bitmap, (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText);
                        } else {
                            com.aliyun.svideosdk.editor.impl.o.this.c.addSubtitle(bitmap, effectText);
                        }
                        subTitleTrack.setId(effectText.getViewId());
                        if (!subTitleTrack.getActions().isEmpty()) {
                            effectText.action = subTitleTrack.getActions().get(subTitleTrack.getActions().size() - 1);
                        }
                        com.aliyun.svideosdk.editor.impl.o.this.f.a(subTitleTrack);
                        if (!com.aliyun.svideosdk.editor.impl.o.this.a.a()) {
                            com.aliyun.svideosdk.editor.impl.o.this.h.put(effectText, subTitleTrack);
                        }
                    } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.caption) {
                        com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) pasterTrack;
                        captionTrack.setCaption(null);
                        com.aliyun.svideosdk.common.AliyunCaption caption = captionTrack.toCaption();
                        com.aliyun.svideosdk.editor.impl.o.this.c.addCaption(caption);
                        captionTrack.setId(caption.getId());
                        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = new com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption(caption, com.aliyun.svideosdk.editor.impl.o.this.c);
                        com.aliyun.svideosdk.editor.impl.o.this.i.add(aliyunPasterControllerCompoundCaption);
                        arrayList.add(aliyunPasterControllerCompoundCaption);
                    }
                }
            }
            if (com.aliyun.svideosdk.editor.impl.o.this.e != null) {
                com.aliyun.svideosdk.editor.impl.o.this.e.onPasterRestored(arrayList);
            }
        }
    }

    public o(com.aliyun.svideosdk.editor.impl.g gVar, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter, com.aliyun.common.resource.ResourceParser resourceParser, com.aliyun.svideosdk.editor.e.a aVar) {
        com.aliyun.svideosdk.editor.impl.o.a aVar2 = new com.aliyun.svideosdk.editor.impl.o.a();
        this.j = aVar2;
        this.f = gVar;
        this.b = resourceParser;
        this.c = pVar;
        this.g = aVar;
        this.d = alivcEditorReporter;
        this.a = new com.aliyun.svideosdk.editor.impl.n();
        this.c.setOnPasterResumeAndSave(aVar2);
        this.i = new java.util.ArrayList();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2, long j, long j2) {
        return addCaptionWithStartTime(str, source, source2, j, j2, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.common.struct.project.Source source2, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        com.aliyun.svideosdk.common.AliyunCaption aliyunCaption = new com.aliyun.svideosdk.common.AliyunCaption();
        aliyunCaption.setText(str);
        float sp2px = com.aliyun.common.utils.DensityUtil.sp2px(25.0f);
        com.aliyun.common.utils.Size displaySize = this.c.getDisplaySize();
        aliyunCaption.setFontStyle(new com.aliyun.svideosdk.common.AliyunFontStyle(source2, sp2px / java.lang.Math.min(displaySize.getWidth(), displaySize.getHeight()), com.aliyun.svideosdk.common.AliyunTypeface.NORMAL));
        aliyunCaption.setBubbleSource(source);
        aliyunCaption.setStartTime(timeUnit.toMicros(j));
        aliyunCaption.setDuration(timeUnit.toMicros(j2));
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = new com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption(aliyunCaption, this.c);
        this.i.add(aliyunPasterControllerCompoundCaption);
        return aliyunPasterControllerCompoundCaption;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @java.lang.Deprecated
    public com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption addCaptionWithStartTime(java.lang.String str, java.lang.String str2, java.lang.String str3, long j, long j2) {
        return addCaptionWithStartTime(str, new com.aliyun.svideosdk.common.struct.project.Source(str2), new com.aliyun.svideosdk.common.struct.project.Source(str3), j, j2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.impl.AliyunPasterControllerImage addImage(com.aliyun.svideosdk.common.struct.project.Source source) {
        com.aliyun.svideosdk.editor.impl.AliyunPasterControllerImage aliyunPasterControllerImage = new com.aliyun.svideosdk.editor.impl.AliyunPasterControllerImage(new com.aliyun.svideosdk.common.struct.effect.TrackEffect(0L, 0L, new com.aliyun.svideosdk.common.struct.effect.EffectImage(source)), this.c, this.f);
        this.i.add(aliyunPasterControllerImage);
        return aliyunPasterControllerImage;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.AliyunPasterController addPaster(com.aliyun.svideosdk.common.struct.project.Source source) {
        return addPasterWithStartTime(source, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @java.lang.Deprecated
    public com.aliyun.svideosdk.editor.AliyunPasterController addPaster(java.lang.String str) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.d;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddPasterEvent(str);
        }
        return addPasterWithStartTime(str, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.AliyunPasterController addPasterWithStartTime(com.aliyun.svideosdk.common.struct.project.Source source, long j, long j2) {
        return addPasterWithStartTime(source, j, j2, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.AliyunPasterController addPasterWithStartTime(com.aliyun.svideosdk.common.struct.project.Source source, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        com.aliyun.svideosdk.common.struct.project.DynamicImage dynamicImage;
        com.aliyun.svideosdk.editor.AliyunPasterController lVar;
        if (source == null || com.aliyun.common.utils.StringUtils.isEmpty(source.getPath()) || (dynamicImage = (com.aliyun.svideosdk.common.struct.project.DynamicImage) this.b.readResource(source.getPath(), com.aliyun.svideosdk.common.struct.project.DynamicImage.class)) == null) {
            return null;
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.d;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddPasterWithStartTimeEvent(source.getPath(), j, j2);
        }
        com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = new com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack();
        bubbleCaptionTrack.setSource(source);
        dynamicImage.fillPaster(bubbleCaptionTrack);
        long micros = timeUnit.toMicros(j);
        long micros2 = timeUnit.toMicros(j2);
        if (micros != 0) {
            bubbleCaptionTrack.setTimelineIn(micros / 1000000.0f);
        }
        if (micros2 != 0) {
            bubbleCaptionTrack.setTimelineOut(bubbleCaptionTrack.getTimelineIn() + (micros2 / 1000000.0f));
        }
        if (dynamicImage.type == 0) {
            com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = new com.aliyun.svideosdk.common.struct.effect.EffectCaption(source);
            this.a.b((com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectCaption, (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) bubbleCaptionTrack);
            this.a.a((com.aliyun.svideosdk.common.struct.effect.EffectText) effectCaption, (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) bubbleCaptionTrack);
            lVar = new com.aliyun.svideosdk.editor.impl.k(effectCaption, this.c, this);
        } else {
            com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = new com.aliyun.svideosdk.common.struct.effect.EffectPaster(source);
            this.a.b(effectPaster, bubbleCaptionTrack);
            lVar = new com.aliyun.svideosdk.editor.impl.l(effectPaster, this.c, this);
        }
        this.i.add(lVar);
        return lVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @java.lang.Deprecated
    public com.aliyun.svideosdk.editor.AliyunPasterController addPasterWithStartTime(java.lang.String str, long j, long j2) {
        return addPasterWithStartTime(new com.aliyun.svideosdk.common.struct.project.Source(str), j, j2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.AliyunPasterController addSubtitle(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.d;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddSubtitleEvent(str, source != null ? source.getPath() : null);
        }
        return addSubtitleWithStartTime(str, source, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @java.lang.Deprecated
    public com.aliyun.svideosdk.editor.AliyunPasterController addSubtitle(java.lang.String str, java.lang.String str2) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.d;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddSubtitleEvent(str, str2);
        }
        return addSubtitleWithStartTime(str, str2, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.AliyunPasterController addSubtitleWithStartTime(java.lang.String str, com.aliyun.svideosdk.common.struct.project.Source source, long j, long j2) {
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.d;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendAddSubtitleWithStartTimeEvent(str, source != null ? source.getPath() : null, j, j2);
        }
        com.aliyun.svideosdk.common.struct.effect.EffectText effectText = new com.aliyun.svideosdk.common.struct.effect.EffectText(source);
        com.aliyun.svideosdk.common.struct.project.DynamicImage textOnlyConfig = com.aliyun.svideosdk.common.struct.project.DynamicImage.getTextOnlyConfig();
        com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack = new com.aliyun.svideosdk.common.struct.project.SubTitleTrack();
        subTitleTrack.setFont(source);
        textOnlyConfig.fillPaster(subTitleTrack);
        if (j != 0) {
            subTitleTrack.setTimelineIn(j / 1000000.0f);
        }
        if (j2 != 0) {
            subTitleTrack.setTimelineOut(subTitleTrack.getTimelineIn() + (j2 / 1000000.0f));
        }
        this.a.b((com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectText, (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) subTitleTrack);
        this.a.a(effectText, subTitleTrack);
        effectText.text = str;
        if (source != null) {
            effectText.font = source.getPath();
            effectText.fontSource = source;
        }
        com.aliyun.svideosdk.editor.impl.m mVar = new com.aliyun.svideosdk.editor.impl.m(effectText, this.c, this);
        this.i.add(mVar);
        return mVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @java.lang.Deprecated
    public com.aliyun.svideosdk.editor.AliyunPasterController addSubtitleWithStartTime(java.lang.String str, java.lang.String str2, long j, long j2) {
        return addSubtitleWithStartTime(str, new com.aliyun.svideosdk.common.struct.project.Source(str2), j, j2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.AliyunIPasterController findControllerAtPoint(android.graphics.PointF pointF, long j) {
        return findControllerAtPoint(pointF, j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public com.aliyun.svideosdk.editor.AliyunIPasterController findControllerAtPoint(android.graphics.PointF pointF, long j, java.util.concurrent.TimeUnit timeUnit) {
        for (int size = this.i.size() - 1; size >= 0; size--) {
            com.aliyun.svideosdk.editor.AliyunIPasterController aliyunIPasterController = this.i.get(size);
            long startTime = aliyunIPasterController.getStartTime();
            long duration = aliyunIPasterController.getDuration();
            long micros = timeUnit.toMicros(j);
            if (startTime <= micros && micros <= startTime + duration) {
                android.graphics.PointF position = aliyunIPasterController.getPosition();
                android.graphics.RectF size2 = aliyunIPasterController.getSize();
                float scale = aliyunIPasterController instanceof com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption ? ((com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption) aliyunIPasterController).getScale() : 1.0f;
                float width = (size2.width() * scale) / 2.0f;
                float height = (size2.height() * scale) / 2.0f;
                float f = position.x;
                float f2 = position.y;
                android.graphics.RectF rectF = new android.graphics.RectF(f - width, f2 - height, f + width, f2 + height);
                android.graphics.Matrix matrix = new android.graphics.Matrix();
                matrix.setTranslate(pointF.x, pointF.y);
                matrix.postRotate(-((float) java.lang.Math.toDegrees(aliyunIPasterController.getRotate())), position.x, position.y);
                float[] fArr = {0.0f, 0.0f};
                matrix.mapPoints(fArr);
                if (rectF.contains(fArr[0], fArr[1])) {
                    return aliyunIPasterController;
                }
            }
        }
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public java.util.List<com.aliyun.svideosdk.editor.AliyunIPasterController> findControllersByType(int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int size = this.i.size() - 1; size >= 0; size--) {
            com.aliyun.svideosdk.editor.AliyunIPasterController aliyunIPasterController = this.i.get(size);
            if (aliyunIPasterController.getType() == i) {
                arrayList.add(aliyunIPasterController);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public void remove(com.aliyun.svideosdk.editor.AliyunIPasterController aliyunIPasterController) {
        if (aliyunIPasterController instanceof com.aliyun.svideosdk.editor.impl.h) {
            ((com.aliyun.svideosdk.editor.impl.h) aliyunIPasterController).remove();
        }
        this.i.remove(aliyunIPasterController);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public void setDisplaySize(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw new java.lang.IllegalStateException("width or height can not be zero");
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.d;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendSetDisplaySizeEvent(i, i2);
        }
        this.a.a(i, i2);
        this.c.setDisplaySize(i, i2);
        for (java.util.Map.Entry<com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack> entry : this.h.entrySet()) {
            this.a.c(entry.getKey(), entry.getValue());
            if ((entry.getKey() instanceof com.aliyun.svideosdk.common.struct.effect.EffectText) && (entry.getValue() instanceof com.aliyun.svideosdk.common.struct.project.SubTitleTrack)) {
                this.a.b((com.aliyun.svideosdk.common.struct.effect.EffectText) entry.getKey(), (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) entry.getValue());
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public void setOnPasterRestoreListener(com.aliyun.svideosdk.editor.OnPasterRestored onPasterRestored) {
        this.e = onPasterRestored;
    }
}
