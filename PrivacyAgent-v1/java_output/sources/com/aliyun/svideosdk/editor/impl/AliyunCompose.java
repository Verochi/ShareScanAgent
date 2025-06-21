package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
class AliyunCompose implements com.aliyun.svideosdk.editor.AliyunICompose {
    private com.aliyun.svideosdk.editor.impl.g a;
    private com.aliyun.svideosdk.editor.AliyunPasterRender b;
    private java.lang.String c;
    private com.aliyun.svideosdk.editor.AliyunIComposeCallBack d;
    private com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient e;
    private com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig f;
    private int g;
    private int h;
    private android.content.Context j;
    private int i = 1;
    private final com.aliyun.svideosdk.editor.OnPasterResumeAndSave k = new com.aliyun.svideosdk.editor.impl.AliyunCompose.a();
    private final com.aliyun.svideosdk.editor.AliyunIComposeCallBack l = new com.aliyun.svideosdk.editor.impl.AliyunCompose.b();

    @com.aliyun.Visible
    public final class VODSVideoUploadCallbackImpl implements com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback {
        com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack mAliyunIUploadCallBack;

        public VODSVideoUploadCallbackImpl(com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack) {
            this.mAliyunIUploadCallBack = aliyunIUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onSTSTokenExpried() {
            com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Status");
            sb.append(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a());
            sb.append("call Upload.");
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onSTSTokenExpired();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadFailed(java.lang.String str, java.lang.String str2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Status");
            sb.append(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a());
            sb.append("call Upload.");
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a() != 4) {
                return;
            }
            com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack = this.mAliyunIUploadCallBack;
            if (aliyunIUploadCallBack != null) {
                aliyunIUploadCallBack.onUploadFailed(str, str2);
            }
            com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a(2);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadProgress(long j, long j2) {
            com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Status");
            sb.append(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a());
            sb.append("call Upload.");
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onUploadProgress(j, j2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadRetry(java.lang.String str, java.lang.String str2) {
            com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Status");
            sb.append(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a());
            sb.append("call Upload.");
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onUploadRetry(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadRetryResume() {
            com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Status");
            sb.append(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a());
            sb.append("call Upload.");
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onUploadRetryResume();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadSucceed(java.lang.String str, java.lang.String str2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Status");
            sb.append(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a());
            sb.append("call Upload.");
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a() != 4) {
                return;
            }
            com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack = this.mAliyunIUploadCallBack;
            if (aliyunIUploadCallBack != null) {
                aliyunIUploadCallBack.onUploadSucceed(str, str2);
            }
            com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a(2);
        }
    }

    public class a implements com.aliyun.svideosdk.editor.OnPasterResumeAndSave {
        com.aliyun.svideosdk.editor.impl.n a = new com.aliyun.svideosdk.editor.impl.n();

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.aliyun.svideosdk.editor.OnPasterResumeAndSave
        public void onPasterResume(java.util.List<com.aliyun.svideosdk.common.struct.project.PasterTrack> list) {
            com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack;
            this.a.a(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.g, com.aliyun.svideosdk.editor.impl.AliyunCompose.this.h);
            for (com.aliyun.svideosdk.common.struct.project.PasterTrack pasterTrack : list) {
                if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.photo) {
                    com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack = (com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack) pasterTrack;
                    com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage = new com.aliyun.svideosdk.common.struct.effect.EffectImage(photoPasterTrack.getSource());
                    effectImage.setXRadio(photoPasterTrack.getX());
                    effectImage.setYRatio(photoPasterTrack.getY());
                    effectImage.setWidthRatio(photoPasterTrack.getWidth());
                    effectImage.setHeightRatio(photoPasterTrack.getHeight());
                    effectImage.setRotation(photoPasterTrack.getRotation());
                    photoPasterTrack.setId(com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a.a(new com.aliyun.svideosdk.common.struct.effect.TrackEffect<>((long) (photoPasterTrack.getTimelineIn() * 1000.0f), (long) (photoPasterTrack.getTimelineOut() * 1000.0f), effectImage)));
                    com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a.a(photoPasterTrack);
                } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.roll_captions) {
                    com.aliyun.svideosdk.common.struct.project.RollCaptionTrack rollCaptionTrack = (com.aliyun.svideosdk.common.struct.project.RollCaptionTrack) pasterTrack;
                    com.aliyun.svideosdk.editor.AliyunRollCaptionComposer createRollCaptionComposer = com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a.createRollCaptionComposer();
                    if (createRollCaptionComposer instanceof com.aliyun.svideosdk.editor.e.a) {
                        ((com.aliyun.svideosdk.editor.e.a) createRollCaptionComposer).a(rollCaptionTrack);
                    }
                } else {
                    if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.gif) {
                        com.aliyun.svideosdk.common.struct.project.GifPasterTrack gifPasterTrack2 = (com.aliyun.svideosdk.common.struct.project.GifPasterTrack) pasterTrack;
                        com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = new com.aliyun.svideosdk.common.struct.effect.EffectPaster(gifPasterTrack2.getSource());
                        this.a.c(effectPaster, gifPasterTrack2);
                        com.aliyun.svideosdk.editor.impl.AliyunCompose.this.b.addEffectPaster(effectPaster);
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
                                    com.aliyun.svideosdk.editor.impl.AliyunCompose.this.b.addCaptionPaster(textBitmapGenerator, (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText);
                                } else {
                                    com.aliyun.svideosdk.editor.impl.AliyunCompose.this.b.addSubtitle(textBitmapGenerator, effectText);
                                }
                            } else if (effectText instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
                                com.aliyun.svideosdk.editor.impl.AliyunCompose.this.b.addCaptionPaster(decodeFile, (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText);
                            } else {
                                com.aliyun.svideosdk.editor.impl.AliyunCompose.this.b.addSubtitle(decodeFile, effectText);
                            }
                            subTitleTrack.setId(effectText.getViewId());
                            gifPasterTrack = subTitleTrack;
                        } else if (pasterTrack.getType() == com.aliyun.svideosdk.common.struct.project.PasterTrack.Type.caption) {
                            com.aliyun.svideosdk.common.struct.project.CaptionTrack captionTrack = (com.aliyun.svideosdk.common.struct.project.CaptionTrack) pasterTrack;
                            com.aliyun.svideosdk.common.AliyunCaption caption = captionTrack.toCaption();
                            com.aliyun.svideosdk.editor.impl.AliyunCompose.this.b.addCaption(caption);
                            captionTrack.setId(caption.getId());
                        }
                    }
                    com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a.a(gifPasterTrack);
                }
            }
        }
    }

    public class b implements com.aliyun.svideosdk.editor.AliyunIComposeCallBack {
        public b() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeCompleted() {
            com.aliyun.svideosdk.editor.impl.AliyunCompose.this.a(2);
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d != null) {
                com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d.onComposeCompleted();
            }
            com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d = null;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeError(int i) {
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d != null) {
                com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d.onComposeError(i);
            }
            com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d = null;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeProgress(int i) {
            if (com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d != null) {
                com.aliyun.svideosdk.editor.impl.AliyunCompose.this.d.onComposeProgress(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i) {
        this.i = i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int cancelCompose() {
        if (a() != 3) {
            return -20011018;
        }
        this.a.cancelCompose();
        a(2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public int cancelUpload() {
        if (a() != 4) {
            return -20011018;
        }
        this.e.cancel();
        a(2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int compose(java.lang.String str, java.lang.String str2, com.aliyun.svideosdk.editor.AliyunIComposeCallBack aliyunIComposeCallBack) {
        java.io.File file;
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject;
        if (a() == 1 || a() != 2) {
            return -20011018;
        }
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject((file = new java.io.File(str)), new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl())) == null) {
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
        this.c = str2;
        this.d = aliyunIComposeCallBack;
        this.a = new com.aliyun.svideosdk.editor.impl.g(android.net.Uri.fromFile(file), null);
        this.g = (int) (readProject.getConfig().getOutputWidth() * readProject.getConfig().getScale());
        this.h = (int) (readProject.getConfig().getOutputHeight() * readProject.getConfig().getScale());
        com.aliyun.svideosdk.editor.AliyunPasterRender pasterRender = this.a.getPasterRender();
        this.b = pasterRender;
        pasterRender.setOnPasterResumeAndSave(this.k);
        this.b.setDisplaySize(this.g, this.h);
        this.a.a(com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE);
        this.a.a(aliyunVideoParam);
        this.a.setOutputPath(this.c);
        if (this.a.init(null, this.j) != 0) {
            return -20011021;
        }
        int compose = this.a.compose(aliyunVideoParam, this.c, this.l);
        if (compose == 0) {
            a(3);
        }
        return compose;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int init(android.content.Context context) {
        this.j = context;
        if (a() != 1) {
            return 0;
        }
        this.f = new com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder().setMaxRetryCount(2).setConnectionTimeout(30000).setSocketTimeout(30000).build();
        if (context == null) {
            return -20011021;
        }
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl vODSVideoUploadClientImpl = new com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl(context.getApplicationContext());
        this.e = vODSVideoUploadClientImpl;
        vODSVideoUploadClientImpl.setAppVersion(com.aliyun.common.global.Version.VERSION);
        this.e.init();
        a(2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int pauseCompose() {
        if (a() == 1) {
            return -20011018;
        }
        return this.a.pause();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public void pauseUpload() {
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient vODSVideoUploadClient = this.e;
        if (vODSVideoUploadClient == null) {
            return;
        }
        vODSVideoUploadClient.pause();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public int refreshSTSToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.e.refreshSTSToken(str, str2, str3, str4);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void release() {
        int i = this.i;
        if (i == 1) {
            return;
        }
        if (i != 2) {
            if (this.i == 3) {
                cancelCompose();
            } else {
                cancelUpload();
            }
        }
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient vODSVideoUploadClient = this.e;
        if (vODSVideoUploadClient != null) {
            vODSVideoUploadClient.release();
        }
        com.aliyun.svideosdk.editor.impl.g gVar = this.a;
        if (gVar != null) {
            gVar.onDestroy();
            this.a = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        a(1);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int resumeCompose() {
        if (a() == 1) {
            return -20011018;
        }
        return this.a.resume();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public void resumeUpload() {
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient vODSVideoUploadClient = this.e;
        if (vODSVideoUploadClient == null) {
            return;
        }
        vODSVideoUploadClient.resume();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public void setUploadRetryAndTimeout(int i, int i2, int i3) {
        this.f = new com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder().setMaxRetryCount(i).setConnectionTimeout(i2).setSocketTimeout(i3).build();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public int uploadWithVideoAndImg(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.alibaba.sdk.android.vod.upload.model.SvideoInfo svideoInfo, boolean z, java.lang.String str6, java.lang.String str7, com.aliyun.svideosdk.editor.AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack) {
        if (a() == 1 || a() != 2) {
            return -20011018;
        }
        if (android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str5)) {
            return -20011020;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Upload requestID: ");
        sb.append((java.lang.String) null);
        this.e.uploadWithVideoAndImg(new com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder().setImagePath(str).setVideoPath(this.c).setSvideoInfo(svideoInfo).setAccessKeyId(str2).setAccessKeySecret(str3).setExpriedTime(str5).setIsTranscode(java.lang.Boolean.valueOf(z)).setSecurityToken(str4).setRequestID(null).setPartSize(1048576L).setTemplateGroupId(str7).setStorageLocation(str6).setVodHttpClientConfig(this.f).build(), new com.aliyun.svideosdk.editor.impl.AliyunCompose.VODSVideoUploadCallbackImpl(aliyunIUploadCallBack));
        a(4);
        return 0;
    }
}
