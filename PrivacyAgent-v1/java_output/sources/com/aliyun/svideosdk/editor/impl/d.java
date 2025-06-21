package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class d implements com.aliyun.svideosdk.editor.AliyunIBaseCompose {
    private static java.lang.ref.WeakReference<android.content.Context> g;
    private com.aliyun.svideosdk.editor.impl.g a;
    private com.aliyun.svideosdk.editor.AliyunPasterRender b;
    private int c;
    private int d;
    private com.aliyun.svideosdk.editor.a e;
    private final com.aliyun.svideosdk.editor.OnPasterResumeAndSave f = new com.aliyun.svideosdk.editor.impl.d.a();

    public class a implements com.aliyun.svideosdk.editor.OnPasterResumeAndSave {
        com.aliyun.svideosdk.editor.impl.n a = new com.aliyun.svideosdk.editor.impl.n();

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.aliyun.svideosdk.editor.OnPasterResumeAndSave
        public void onPasterResume(java.util.List<com.aliyun.svideosdk.common.struct.project.PasterTrack> list) {
            com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack;
            this.a.a(com.aliyun.svideosdk.editor.impl.d.this.c, com.aliyun.svideosdk.editor.impl.d.this.d);
            for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : list) {
                if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo) {
                    com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) pasterTrack;
                    com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage = new com.aliyun.svideosdk.common.struct.effect.EffectImage(photoPasterTrack.getSource());
                    effectImage.setXRadio(photoPasterTrack.getX());
                    effectImage.setYRatio(photoPasterTrack.getY());
                    effectImage.setWidthRatio(photoPasterTrack.getWidth());
                    effectImage.setHeightRatio(photoPasterTrack.getHeight());
                    effectImage.setRotation(photoPasterTrack.getRotation());
                    photoPasterTrack.setId(com.aliyun.svideosdk.editor.impl.d.this.a.a(new com.aliyun.svideosdk.common.struct.effect.TrackEffect<>((long) (photoPasterTrack.getTimelineIn() * 1000.0f), (long) (photoPasterTrack.getTimelineOut() * 1000.0f), effectImage)));
                    com.aliyun.svideosdk.editor.impl.d.this.a.a(photoPasterTrack);
                } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.roll_captions) {
                    com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack = (com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) pasterTrack;
                    com.aliyun.svideosdk.editor.AliyunRollCaptionComposer createRollCaptionComposer = com.aliyun.svideosdk.editor.impl.d.this.a.createRollCaptionComposer();
                    if (createRollCaptionComposer instanceof com.aliyun.svideosdk.editor.e.a) {
                        ((com.aliyun.svideosdk.editor.e.a) createRollCaptionComposer).a(rollCaptionTrack);
                    }
                } else {
                    if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.gif) {
                        com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack2 = (com.aliyun.svideosdk.common.struct.project.GifPasterTrack) pasterTrack;
                        com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = new com.aliyun.svideosdk.common.struct.effect.EffectPaster(gifPasterTrack2.getSource());
                        this.a.c(effectPaster, gifPasterTrack2);
                        com.aliyun.svideosdk.editor.impl.d.this.b.addEffectPaster(effectPaster);
                        pasterTrack.setId(effectPaster.getViewId());
                        gifPasterTrack = gifPasterTrack2;
                    } else {
                        com.aliyun.svideosdk.common.struct.project.PasterTrack.Type type = pasterTrack.getType();
                        com.aliyun.svideosdk.common.struct.project.PasterTrack.Type type2 = com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.subtitle;
                        if (type == type2 || pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.bubble_caption) {
                            com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack = (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) pasterTrack;
                            com.aliyun.svideosdk.common.struct.effect.EffectText effectText = pasterTrack.getType() == type2 ? new com.aliyun.svideosdk.common.struct.effect.EffectText(subTitleTrack.getFont()) : new com.aliyun.svideosdk.common.struct.effect.EffectCaption(subTitleTrack.getSource());
                            this.a.c(effectText, subTitleTrack);
                            this.a.b(effectText, subTitleTrack);
                            java.lang.String str = effectText.textBmpPath;
                            android.graphics.Bitmap decodeFile = (android.text.TextUtils.isEmpty(str) || !new java.io.File(str).exists()) ? null : android.graphics.BitmapFactory.decodeFile(str);
                            effectText.needSaveBmp = false;
                            if (decodeFile == null) {
                                com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator textBitmapGenerator = new com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator();
                                textBitmapGenerator.updateTextBitmap(com.aliyun.svideosdk.editor.impl.text.TextBitmap.fromEffectText(effectText));
                                if (effectText instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
                                    com.aliyun.svideosdk.editor.impl.d.this.b.addCaptionPaster(textBitmapGenerator, (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText);
                                } else {
                                    com.aliyun.svideosdk.editor.impl.d.this.b.addSubtitle(textBitmapGenerator, effectText);
                                }
                            } else if (effectText instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
                                com.aliyun.svideosdk.editor.impl.d.this.b.addCaptionPaster(decodeFile, (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText);
                            } else {
                                com.aliyun.svideosdk.editor.impl.d.this.b.addSubtitle(decodeFile, effectText);
                            }
                            subTitleTrack.setId(effectText.getViewId());
                            gifPasterTrack = subTitleTrack;
                        } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.caption) {
                            com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) pasterTrack;
                            com.aliyun.svideosdk.common.AliyunCaption caption = captionTrack.toCaption();
                            com.aliyun.svideosdk.editor.impl.d.this.b.addCaption(caption);
                            captionTrack.setId(caption.getId());
                        }
                    }
                    com.aliyun.svideosdk.editor.impl.d.this.a.a(gifPasterTrack);
                }
            }
        }
    }

    public void a(com.aliyun.svideosdk.editor.a aVar) {
        this.e = aVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int cancelCompose() {
        com.aliyun.svideosdk.editor.impl.g gVar = this.a;
        if (gVar == null) {
            return -20011023;
        }
        int cancelCompose = gVar.cancelCompose();
        if (cancelCompose != 0) {
            return cancelCompose;
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int compose(java.lang.String str, java.lang.String str2, com.aliyun.svideosdk.editor.AliyunIComposeCallBack aliyunIComposeCallBack) {
        java.io.File file = new java.io.File(str);
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(file, new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl());
        if (readProject == null) {
            return -20011020;
        }
        com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam = new com.aliyun.svideosdk.common.struct.common.AliyunVideoParam();
        aliyunVideoParam.setScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.valueOf(readProject.getConfig().getDisplayMode()));
        aliyunVideoParam.setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality.values()[readProject.getConfig().getVideoQuality()]);
        aliyunVideoParam.setBitrate(readProject.getConfig().getBitrate());
        aliyunVideoParam.setFrameRate(readProject.getConfig().getFps());
        aliyunVideoParam.setGop(readProject.getConfig().getGop());
        aliyunVideoParam.setCrf(readProject.getConfig().getCrf());
        aliyunVideoParam.setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.getInstanceByValue(readProject.getConfig().getVideoCodec()));
        aliyunVideoParam.setScaleRate(readProject.getConfig().getScale());
        this.a = new com.aliyun.svideosdk.editor.impl.g(android.net.Uri.fromFile(file), null);
        this.c = (int) (readProject.getConfig().getOutputWidth() * readProject.getConfig().getScale());
        this.d = (int) (readProject.getConfig().getOutputHeight() * readProject.getConfig().getScale());
        com.aliyun.svideosdk.editor.AliyunPasterRender pasterRender = this.a.getPasterRender();
        this.b = pasterRender;
        pasterRender.setOnPasterResumeAndSave(this.f);
        this.b.setDisplaySize(this.c, this.d);
        this.a.a(com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE);
        this.a.a(aliyunVideoParam);
        this.a.setOutputPath(str2);
        this.a.a(this.e);
        if (this.a.init(null, g.get()) != 0) {
            return -20011021;
        }
        this.a.compose(aliyunVideoParam, str2, aliyunIComposeCallBack);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int init(android.content.Context context) {
        g = new java.lang.ref.WeakReference<>(context);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int pauseCompose() {
        com.aliyun.svideosdk.editor.impl.g gVar = this.a;
        if (gVar == null) {
            return -20011018;
        }
        int pause = gVar.pause();
        if (pause != 0) {
            return pause;
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void release() {
        com.aliyun.svideosdk.editor.impl.g gVar = this.a;
        if (gVar == null) {
            return;
        }
        this.e = null;
        gVar.onDestroy();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int resumeCompose() {
        com.aliyun.svideosdk.editor.impl.g gVar = this.a;
        if (gVar == null) {
            return -20011018;
        }
        int resume = gVar.resume();
        if (resume != 0) {
            return resume;
        }
        return 0;
    }
}
