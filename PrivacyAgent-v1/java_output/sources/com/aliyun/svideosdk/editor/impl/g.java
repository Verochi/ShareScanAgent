package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class g implements com.aliyun.svideosdk.editor.AliyunIEditor {
    private com.aliyun.svideosdk.editor.OnAnimationFilterRestoredListener A;
    private android.view.SurfaceView B;
    private android.view.TextureView C;
    private com.aliyun.common.log.struct.AliyunLogInfo D;
    private int F;
    private int G;
    private com.aliyun.svideosdk.editor.NativeEditor a;
    private com.aliyun.svideosdk.editor.AliyunISourcePartManager b;
    private com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl c;
    private com.aliyun.svideosdk.editor.impl.e d;
    private java.lang.String f;
    private long h;
    private com.aliyun.svideosdk.common.struct.project.AliyunEditorProject i;
    private com.aliyun.svideosdk.common.struct.common.AliyunVideoParam j;
    private android.view.Surface l;
    private com.aliyun.svideosdk.editor.AliyunIPlayerController n;
    private boolean p;
    private com.aliyun.svideosdk.common.struct.project.AliyunProjectInfo r;

    /* renamed from: s, reason: collision with root package name */
    private com.aliyun.svideosdk.editor.impl.o f95s;
    private com.aliyun.svideosdk.editor.impl.p t;
    private com.aliyun.svideosdk.editor.e.a u;
    private com.aliyun.svideosdk.editor.impl.r v;
    private com.aliyun.svideosdk.editor.EditorCallBack w;
    private com.aliyun.svideosdk.editor.OnAnimationFilterRestored z;
    private com.aliyun.svideosdk.editor.c e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY;
    private long g = 0;
    private com.aliyun.svideosdk.common.struct.common.VideoDisplayMode k = com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL;
    private boolean m = false;
    private volatile int o = 0;
    private com.aliyun.common.log.reporter.AlivcEditorReporter q = null;
    private com.aliyun.svideosdk.editor.AliyunIComposeCallBack x = null;
    private com.aliyun.svideosdk.editor.a y = null;
    private long E = 0;
    private final android.view.SurfaceHolder.Callback H = new com.aliyun.svideosdk.editor.impl.g.a();
    private com.aliyun.svideosdk.editor.EditorCallBack I = new com.aliyun.svideosdk.editor.impl.g.b();

    public class a implements android.view.SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (!com.aliyun.svideosdk.editor.impl.g.this.m || com.aliyun.svideosdk.editor.impl.g.this.a == null) {
                return;
            }
            if (com.aliyun.svideosdk.editor.impl.g.this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                com.aliyun.svideosdk.editor.impl.g.this.a.setDisplaySize(i2, i3);
                if (com.aliyun.svideosdk.editor.impl.g.this.l == null) {
                    com.aliyun.svideosdk.editor.impl.g.this.l = surfaceHolder.getSurface();
                    com.aliyun.svideosdk.editor.impl.g.this.a.setDisplay(com.aliyun.svideosdk.editor.impl.g.this.l);
                }
            }
            com.aliyun.svideosdk.editor.impl.g.this.F = i2;
            com.aliyun.svideosdk.editor.impl.g.this.G = i3;
            com.aliyun.svideosdk.editor.impl.g.this.u.a(com.aliyun.svideosdk.editor.impl.g.this.F, com.aliyun.svideosdk.editor.impl.g.this.G);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            if (com.aliyun.svideosdk.editor.impl.g.this.a == null) {
                return;
            }
            if (com.aliyun.svideosdk.editor.impl.g.this.m) {
                com.aliyun.svideosdk.editor.impl.g gVar = com.aliyun.svideosdk.editor.impl.g.this;
                gVar.F = gVar.B.getMeasuredWidth();
                com.aliyun.svideosdk.editor.impl.g gVar2 = com.aliyun.svideosdk.editor.impl.g.this;
                gVar2.G = gVar2.B.getMeasuredHeight();
                com.aliyun.svideosdk.editor.impl.g.this.u.a(com.aliyun.svideosdk.editor.impl.g.this.F, com.aliyun.svideosdk.editor.impl.g.this.G);
                if (com.aliyun.svideosdk.editor.impl.g.this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY || com.aliyun.svideosdk.editor.impl.g.this.a.setDisplaySize(com.aliyun.svideosdk.editor.impl.g.this.F, com.aliyun.svideosdk.editor.impl.g.this.G) != 0) {
                    return;
                }
            } else {
                if (com.aliyun.svideosdk.editor.impl.g.this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                    return;
                }
                surfaceHolder.setFixedSize(com.aliyun.svideosdk.editor.impl.g.this.F, com.aliyun.svideosdk.editor.impl.g.this.G);
                if (com.aliyun.svideosdk.editor.impl.g.this.a.setDisplaySize(com.aliyun.svideosdk.editor.impl.g.this.F, com.aliyun.svideosdk.editor.impl.g.this.G) != 0) {
                    return;
                }
            }
            com.aliyun.svideosdk.editor.impl.g.this.l = surfaceHolder.getSurface();
            com.aliyun.svideosdk.editor.impl.g.this.a.setDisplay(com.aliyun.svideosdk.editor.impl.g.this.l);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            if (com.aliyun.svideosdk.editor.impl.g.this.a == null) {
                return;
            }
            com.aliyun.svideosdk.editor.impl.g.this.w();
            com.aliyun.svideosdk.editor.impl.g.this.l = null;
            com.aliyun.svideosdk.editor.impl.g.this.a.setDisplay(com.aliyun.svideosdk.editor.impl.g.this.l);
        }
    }

    public class b extends com.aliyun.svideosdk.editor.EditorCallBack {
        public b() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3) {
            int onCustomRender;
            return (com.aliyun.svideosdk.editor.impl.g.this.w == null || (onCustomRender = com.aliyun.svideosdk.editor.impl.g.this.w.onCustomRender(i, i2, i3)) <= 0) ? i : onCustomRender;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
            if (com.aliyun.svideosdk.editor.impl.g.this.w != null) {
                com.aliyun.svideosdk.editor.impl.g.this.w.onDataReady();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
            com.aliyun.svideosdk.editor.impl.g.this.a(3);
            int i2 = com.aliyun.svideosdk.editor.impl.g.e.c[com.aliyun.svideosdk.editor.impl.g.this.e.ordinal()];
            if (i2 == 1) {
                if (com.aliyun.svideosdk.editor.impl.g.this.w != null) {
                    com.aliyun.svideosdk.editor.impl.g.this.w.onEnd(i);
                }
            } else {
                if (i2 != 2) {
                    return;
                }
                if (com.aliyun.svideosdk.editor.impl.g.this.x != null) {
                    com.aliyun.svideosdk.editor.impl.g.this.x.onComposeCompleted();
                }
                if (com.aliyun.svideosdk.editor.impl.g.this.y != null) {
                    com.aliyun.svideosdk.editor.impl.g.this.y.onComposeCompleted();
                }
                com.aliyun.svideosdk.editor.impl.g.this.x = null;
                com.aliyun.svideosdk.editor.impl.g.this.a(4);
                if (com.aliyun.svideosdk.editor.impl.g.this.f != null) {
                    com.aliyun.svideosdk.editor.impl.g.this.q.sendComposeCompleteEvent(com.aliyun.svideosdk.editor.impl.g.this.f, i, com.aliyun.svideosdk.editor.impl.g.this.E);
                }
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
            com.aliyun.svideosdk.editor.impl.g.this.a(4);
            int i2 = com.aliyun.svideosdk.editor.impl.g.e.c[com.aliyun.svideosdk.editor.impl.g.this.e.ordinal()];
            if (i2 == 1) {
                if (com.aliyun.svideosdk.editor.impl.g.this.w != null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("EditorCallBack::onError, case PROCESS_MODE_PLAY, rv = ");
                    sb.append(i);
                    com.aliyun.svideosdk.editor.impl.g.this.w.onError(i);
                }
                com.aliyun.svideosdk.editor.impl.g.this.q.sendPlayErrorEvent(i);
                return;
            }
            if (i2 != 2) {
                return;
            }
            if (com.aliyun.svideosdk.editor.impl.g.this.x != null) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("EditorCallBack::onError, case PROCESS_MODE_COMPOSE, rv = ");
                sb2.append(i);
                com.aliyun.svideosdk.editor.impl.g.this.x.onComposeError(i);
            }
            com.aliyun.svideosdk.editor.impl.g.this.x = null;
            com.aliyun.svideosdk.editor.impl.g.this.a(4);
            com.aliyun.svideosdk.editor.impl.g.this.q.sendComposeErrorEvent(com.aliyun.svideosdk.editor.impl.g.this.f, i);
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPacketSeek(long j, int i) {
            if (com.aliyun.svideosdk.editor.impl.g.this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE || com.aliyun.svideosdk.editor.impl.g.this.y == null) {
                return;
            }
            com.aliyun.svideosdk.editor.impl.g.this.y.a(j, i);
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
            int i = com.aliyun.svideosdk.editor.impl.g.e.c[com.aliyun.svideosdk.editor.impl.g.this.e.ordinal()];
            if (i == 1) {
                if (com.aliyun.svideosdk.editor.impl.g.this.w != null) {
                    com.aliyun.svideosdk.editor.impl.g.this.w.onPlayProgress(j, j2);
                }
            } else if (i == 2 && com.aliyun.svideosdk.editor.impl.g.this.x != null && com.aliyun.svideosdk.editor.impl.g.this.g > 0) {
                com.aliyun.svideosdk.editor.impl.g.this.x.onComposeProgress((int) ((j * 100) / com.aliyun.svideosdk.editor.impl.g.this.g));
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3) {
            int onTextureRender;
            return (com.aliyun.svideosdk.editor.impl.g.this.w == null || (onTextureRender = com.aliyun.svideosdk.editor.impl.g.this.w.onTextureRender(i, i2, i3)) <= 0) ? i : onTextureRender;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onWritePacket(java.nio.ByteBuffer byteBuffer, int i) {
            if (com.aliyun.svideosdk.editor.impl.g.this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE || com.aliyun.svideosdk.editor.impl.g.this.y == null) {
                return;
            }
            com.aliyun.svideosdk.editor.impl.g.this.y.a(byteBuffer, i);
        }
    }

    public class c implements java.util.Comparator<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> {
        public c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip, com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip2) {
            long a = com.aliyun.svideosdk.editor.impl.g.this.a(videoTrackClip) - com.aliyun.svideosdk.editor.impl.g.this.a(videoTrackClip2);
            if (a == 0) {
                return 0;
            }
            return a > 0 ? 1 : -1;
        }
    }

    public class d implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Bitmap a;

        public d(android.graphics.Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
            android.graphics.Bitmap bitmap = this.a;
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.a.getHeight(), matrix, true);
            java.lang.String str = com.aliyun.svideosdk.editor.impl.g.this.i.getProjectDir().getAbsolutePath() + java.io.File.separator + "cover.jpeg";
            com.aliyun.common.utils.BitmapUtil.writeBitmap(str, createBitmap, android.graphics.Bitmap.CompressFormat.JPEG, 80);
            com.aliyun.svideosdk.editor.impl.g.this.i.setCover(new com.aliyun.svideosdk.common.struct.project.Source(str));
            createBitmap.recycle();
            com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(com.aliyun.svideosdk.editor.impl.g.this.i, com.aliyun.svideosdk.editor.impl.g.this.i.getProjectFile(), com.aliyun.svideosdk.editor.impl.g.this.c);
        }
    }

    public static /* synthetic */ class e {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.editor.c.values().length];
            c = iArr;
            try {
                iArr[com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                c[com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.aliyun.svideosdk.editor.EffectType.values().length];
            b = iArr2;
            try {
                iArr2[com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MV.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                b[com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MIX.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                b[com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_TIME.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                b[com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MV_AUDIO.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.values().length];
            a = iArr3;
            try {
                iArr3[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.BRIGHTNESS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.CONTRAST.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SATURATION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                a[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.SHARPNESS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                a[com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType.VIGNETTE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
        }
    }

    public g(android.net.Uri uri, com.aliyun.svideosdk.editor.EditorCallBack editorCallBack) {
        this.r = null;
        this.w = null;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "create AliyunEditor.");
        this.c = new com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl();
        if (uri == null) {
            throw new java.lang.IllegalArgumentException("Uri cannot be null");
        }
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject readProject = com.aliyun.svideosdk.common.struct.project.ProjectUtil.readProject(new java.io.File(uri.getPath()), this.c);
        this.i = readProject;
        if (readProject == null) {
            throw new java.lang.IllegalArgumentException("Editor init project failed, Verify that the original video filePath is valid,uri:" + uri.toString());
        }
        this.r = new com.aliyun.svideosdk.common.struct.project.AliyunProjectInfo(readProject);
        this.h = c();
        this.w = editorCallBack;
        this.a = new com.aliyun.svideosdk.editor.NativeEditor();
        com.aliyun.common.resource.ResourceParser resourceParser = new com.aliyun.common.resource.ResourceParser(this.c);
        this.t = new com.aliyun.svideosdk.editor.impl.p(this.a, this.q, this.i, resourceParser);
        com.aliyun.svideosdk.editor.e.a aVar = new com.aliyun.svideosdk.editor.e.a(this.a, this.i);
        this.u = aVar;
        this.f95s = new com.aliyun.svideosdk.editor.impl.o(this, this.t, this.q, resourceParser, aVar);
        this.v = new com.aliyun.svideosdk.editor.impl.r(this.a, this.i, this);
    }

    private int a() {
        int addImageElement;
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getType() == 1) {
                addImageElement = this.a.addImageElement(videoTrackClip.getSource().getPath(), (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f), videoTrackClip.getTransition(), videoTrackClip.getWidth(), videoTrackClip.getHeight(), 1.0f, 0.0f);
                if (addImageElement < 0) {
                    return -20003020;
                }
            } else if (videoTrackClip.getType() != 0) {
                continue;
            } else {
                addImageElement = this.a.addVideoElement(videoTrackClip.getSource().getPath(), (long) (videoTrackClip.getIn() * 1000000.0f), (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f), videoTrackClip.getTransition(), videoTrackClip.getWidth(), videoTrackClip.getHeight(), 1.0f, 0.0f);
                if (addImageElement < 0) {
                    return -20003020;
                }
            }
            videoTrackClip.setClipId(addImageElement);
        }
        return 0;
    }

    private int a(int i, float f) {
        if (!this.p) {
            return -4;
        }
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int brightness = this.a.setBrightness(i, f);
        if (brightness != 0) {
            return brightness;
        }
        videoTrackClipById.setBrightness(f);
        return brightness;
    }

    private int a(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter) {
        if (trackEffectFilter == null) {
            return 1073754197;
        }
        if (!this.a.isNativePrepared()) {
            return -20002001;
        }
        int a2 = this.t.a(trackEffectFilter);
        if (a2 != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("set animation filter failed, resources path ");
            sb.append(trackEffectFilter.getBean().getPath());
            sb.append(", startTime ");
            sb.append(trackEffectFilter.getStartTime());
            sb.append(", duration ");
            sb.append(trackEffectFilter.getDuration());
        }
        return a2;
    }

    private int a(java.lang.String str, float f, long j, long j2, int i) {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor = this.a;
        if (nativeEditor == null) {
            return -20011019;
        }
        int lutFilter = nativeEditor.setLutFilter(i, str, f, j * 1000, j2 * 1000);
        if (lutFilter != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("set lut effect filter failed, , startTime ");
            sb.append(j);
            sb.append(", duration ");
            sb.append(j2);
        }
        return lutFilter;
    }

    private int a(java.lang.String str, long j, long j2, int i) {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor = this.a;
        if (nativeEditor == null) {
            return -20011019;
        }
        int switchEff = nativeEditor.switchEff(str, j, j2, i);
        if (switchEff != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("set effect filter failed, resources path ");
            sb.append(str);
            sb.append(", startTime ");
            sb.append(j);
            sb.append(", duration ");
            sb.append(j2);
        }
        return switchEff;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip) {
        return (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f);
    }

    private com.aliyun.svideosdk.common.struct.effect.EffectImage a(com.aliyun.svideosdk.common.struct.project.WaterMark waterMark) {
        com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage = new com.aliyun.svideosdk.common.struct.effect.EffectImage(waterMark.getSource().getPath());
        effectImage.setWidthRatio(waterMark.getWidth());
        effectImage.setHeightRatio(waterMark.getHeight());
        effectImage.setXRadio(waterMark.getX());
        effectImage.setYRatio(waterMark.getY());
        return effectImage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.aliyun.svideosdk.common.struct.effect.BlurBackground, com.aliyun.svideosdk.common.struct.project.VideoEffect] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.aliyun.svideosdk.common.struct.project.VideoEffect] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.aliyun.svideosdk.common.struct.project.RunningDisplayMode, com.aliyun.svideosdk.common.struct.project.VideoEffect, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.StringBuilder] */
    private void a(int i, java.util.List<com.aliyun.svideosdk.common.struct.project.Effect> list) {
        ?? r0;
        int applyBlurBackground;
        java.lang.String str;
        for (com.aliyun.svideosdk.common.struct.project.Effect effect : list) {
            if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.blur_background) {
                r0 = (com.aliyun.svideosdk.common.struct.effect.BlurBackground) effect;
                applyBlurBackground = this.a.applyBlurBackground(i, (long) (r0.getIn() * 1000000.0f), (long) ((r0.getOut() - r0.getIn()) * 1000000.0f), r0.getBlurRadius());
                if (applyBlurBackground < 0) {
                    str = "Resume blur background failed!return ret:" + applyBlurBackground;
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
                } else {
                    r0.setId(applyBlurBackground);
                }
            } else if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.running_display_mode) {
                r0 = (com.aliyun.svideosdk.common.struct.project.RunningDisplayMode) effect;
                applyBlurBackground = this.a.setRunningDisplayMode(i, r0.getDisplayMode(), (long) (r0.getIn() * 1000000.0f), (long) ((r0.getOut() - r0.getIn()) * 1000000.0f));
                if (applyBlurBackground >= 0) {
                    r0.setId(applyBlurBackground);
                } else {
                    str = "Add running display mode failed!" + r0;
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
                }
            } else if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_effect) {
                this.a.audioEffect(i, ((com.aliyun.svideosdk.common.struct.project.AudioEffect) effect).mEffectType.getEffectType(), r0.mEffectParam / 100.0f);
            } else if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade) {
                com.aliyun.svideosdk.common.struct.project.AudioFade audioFade = (com.aliyun.svideosdk.common.struct.project.AudioFade) effect;
                boolean z = audioFade.isFadeIn;
                int i2 = audioFade.shapeType;
                this.a.setAudioFadeInFadeOut(i, z ? i2 == 1 ? 2 : 0 : i2 == 0 ? 1 : 3, (long) (audioFade.duration * 1000.0f), z);
            }
        }
    }

    private void a(com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip, long j) {
        long min = java.lang.Math.min(this.h, j);
        com.aliyun.svideosdk.common.struct.effect.TransitionBase transition = videoTrackClip.getTransition();
        if (transition != null) {
            transition.setOverlapDuration(min, java.util.concurrent.TimeUnit.MILLISECONDS);
            videoTrackClip.setTransition(transition);
        }
    }

    private void a(boolean z) {
        this.a.setMute(z);
        this.i.getConfig().setMute(z);
    }

    private int b() {
        int i;
        int i2;
        android.view.SurfaceView surfaceView = this.B;
        android.view.Surface surface = surfaceView != null ? surfaceView.getHolder().getSurface() : null;
        if (this.C != null) {
            surface = new android.view.Surface(this.C.getSurfaceTexture());
        }
        int i3 = this.F;
        if (i3 == 0 || (i2 = this.G) == 0) {
            i = 0;
        } else {
            i = this.a.setDisplaySize(i3, i2);
            if (i != 0) {
                return i;
            }
        }
        if (surface == null || !surface.isValid() || (i = this.a.setDisplay(surface)) != 0) {
        }
        return i;
    }

    private int b(int i, float f) {
        if (!this.p) {
            return -4;
        }
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int contrast = this.a.setContrast(i, f);
        if (contrast != 0) {
            return contrast;
        }
        videoTrackClipById.setContrast(f);
        return contrast;
    }

    private int c(int i, float f) {
        if (!this.p) {
            return -4;
        }
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int saturation = this.a.setSaturation(i, f);
        if (saturation != 0) {
            return saturation;
        }
        videoTrackClipById.setSaturation(f);
        return saturation;
    }

    private long c() {
        java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> videoTrackClips = this.i.getTimeline().getPrimaryTrack().getVideoTrackClips();
        if (videoTrackClips == null || videoTrackClips.size() == 0) {
            return 0L;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(videoTrackClips);
        java.util.Collections.sort(arrayList, new com.aliyun.svideosdk.editor.impl.g.c());
        return (a((com.aliyun.svideosdk.common.struct.project.VideoTrackClip) arrayList.get(0)) / 2) - 100;
    }

    private int d(int i, float f) {
        if (!this.p) {
            return -4;
        }
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int sharpness = this.a.setSharpness(i, f);
        if (sharpness != 0) {
            return sharpness;
        }
        videoTrackClipById.setSharpness(f);
        return sharpness;
    }

    private int e(int i, float f) {
        if (!this.p) {
            return -4;
        }
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int vignette = this.a.setVignette(i, f);
        if (vignette != 0) {
            return vignette;
        }
        videoTrackClipById.setVignette(f);
        return vignette;
    }

    private boolean i() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor = this.a;
        if (nativeEditor == null) {
            return false;
        }
        return nativeEditor.isNativePrepared();
    }

    private synchronized boolean j() {
        return this.o == 4;
    }

    private int k() {
        java.lang.String str;
        int i;
        com.aliyun.svideosdk.editor.EditorCallBack editorCallBack = this.w;
        if (editorCallBack != null) {
            this.I.mNeedRenderCallback = editorCallBack.mNeedRenderCallback;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "nativeInit");
        this.I.mNeedPacketCallback = this.y != null;
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor = this.a;
        int outputWidth = this.i.getConfig().getOutputWidth();
        int outputHeight = this.i.getConfig().getOutputHeight();
        int i2 = android.os.Build.VERSION.SDK_INT;
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.q;
        int init = nativeEditor.init(outputWidth, outputHeight, i2, alivcEditorReporter == null ? 0L : alivcEditorReporter.getReportId(), this.I);
        if (init != 0) {
            str = "Editor init failed";
        } else {
            init = this.a.setDisplay(null);
            if (init != 0) {
                str = "Set null display failed!";
            } else {
                int outputWidth2 = (int) (this.i.getConfig().getOutputWidth() * this.i.getConfig().getScale());
                if (outputWidth2 % 2 != 0) {
                    outputWidth2--;
                }
                int i3 = outputWidth2;
                int outputHeight2 = (int) (this.i.getConfig().getOutputHeight() * this.i.getConfig().getScale());
                if (outputHeight2 % 2 != 0) {
                    outputHeight2--;
                }
                int i4 = outputHeight2;
                if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
                    init = this.a.setEncodeParam(this.j.getBitrate(), this.j.getFrameRate(), this.j.getGop(), this.j.getVideoQuality().ordinal(), this.j.getCrf(), this.j.getVideoCodec().ordinal(), i3, i4);
                    if (init != 0) {
                        str = "Set compose param failed!";
                    } else {
                        init = this.a.setOutputPath(this.f);
                        if (init != 0) {
                            str = "Set output path failed!";
                        }
                    }
                }
                init = this.a.setMode(this.e);
                if (init != 0) {
                    str = "Set mode failed!";
                } else {
                    init = a();
                    if (init != 0) {
                        str = "Apply source failed!";
                    } else {
                        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                            int i5 = this.F;
                            if (i5 == 0 || (i = this.G) == 0) {
                                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "display size invalid, displayWidth " + this.F + ", displayHeight " + this.G);
                            } else {
                                this.a.setDisplaySize(i5, i);
                            }
                        }
                        init = this.a.prepare();
                        if (init == 0) {
                            setVolume(this.i.getConfig().getVolume());
                            this.a.onStartBatchEdit();
                            t();
                            this.a.onSubmitBatchEdit();
                            p();
                            q();
                            v();
                            s();
                            n();
                            u();
                            r();
                            m();
                            o();
                            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
                                a(videoTrackClip.getClipId(), videoTrackClip.getEffects());
                            }
                            java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it = this.i.getTimeline().getAudioTracks().iterator();
                            while (it.hasNext()) {
                                for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                                    a(audioTrackClip.getClipId(), audioTrackClip.getEffects());
                                }
                            }
                            this.a.setFillBackgroundColor(this.i.getConfig().getBackgroundColor());
                            setAudioSilence(this.i.getConfig().isMute());
                            this.p = true;
                            if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE && !this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().isEmpty()) {
                                b();
                            }
                            int displayMode = setDisplayMode(this.k);
                            if (displayMode != 0) {
                                return displayMode;
                            }
                            this.o = 1;
                            return displayMode;
                        }
                        str = "Editor prepare failed!";
                    }
                }
            }
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
        return init;
    }

    private synchronized int l() {
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
            stop();
        } else {
            int cancelCompose = cancelCompose();
            if (cancelCompose != 0) {
                return cancelCompose;
            }
        }
        this.t.b();
        this.a.release();
        int k = k();
        if (k != 0) {
            return k;
        }
        this.a.setVolume(this.i.getConfig().getVolume());
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject;
        if (this.a == null || this.l == null || this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY || (aliyunEditorProject = this.i) == null || aliyunEditorProject.isCustomCover() || this.a.getPlayTime() <= -1) {
            return;
        }
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor = this.a;
        java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.aliyun.svideosdk.editor.impl.g.d(nativeEditor.getFrameAtTime(nativeEditor.getPlayTime())));
    }

    private int x() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor;
        int clipId;
        int volume;
        if (!i()) {
            return -20011019;
        }
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it = this.i.getTimeline().getAudioTracks().iterator();
        int i = 0;
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (com.aliyun.common.utils.FileUtils.isFileExists(audioTrackClip.getSource().getPath())) {
                    i = this.a.mixAlpha(audioTrackClip.getClipId(), audioTrackClip.getMixWeight());
                    if (i != 0) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("mixAlpha error,ret is ");
                        sb.append(i);
                        sb.append(" id is ");
                        sb.append(audioTrackClip.getClipId());
                    }
                    if (audioTrackClip.getDenoiseWeight() != 0 && (i = this.a.denoise(audioTrackClip.getClipId(), audioTrackClip.getDenoiseWeight() / 100.0f)) != 0) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("denoise error,ret is ");
                        sb2.append(i);
                        sb2.append(" id is ");
                        sb2.append(audioTrackClip.getClipId());
                    }
                }
            }
        }
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getMixWeight() >= 0) {
                nativeEditor = this.a;
                clipId = videoTrackClip.getClipId();
                volume = videoTrackClip.getMixWeight();
            } else {
                nativeEditor = this.a;
                clipId = videoTrackClip.getClipId();
                volume = this.i.getConfig().getVolume();
            }
            int mixAlpha = nativeEditor.mixAlpha(clipId, volume);
            if (mixAlpha != 0) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("mixAlpha error,ret is ");
                sb3.append(mixAlpha);
                sb3.append(" id is ");
                sb3.append(videoTrackClip.getClipId());
            }
            if (videoTrackClip.getDenoiseWeight() != 0 && (mixAlpha = this.a.denoise(videoTrackClip.getClipId(), videoTrackClip.getDenoiseWeight() / 100.0f)) != 0) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("denoise error,ret is ");
                sb4.append(mixAlpha);
                sb4.append(" id is ");
                sb4.append(videoTrackClip.getClipId());
            }
            i = mixAlpha;
        }
        if (this.i.getMVEffect() != null && (i = this.a.mixAlpha(this.i.getMVEffect().getId(), this.i.getMVEffect().getMixWeight())) != 0) {
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append(" mv setAudioWeight error,ret is ");
            sb5.append(i);
            sb5.append(" id is ");
            sb5.append(this.i.getMVEffect().getId());
        }
        return i;
    }

    public int a(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffect) {
        if (!this.p) {
            return -20011019;
        }
        if (!i()) {
            return -20002001;
        }
        if (trackEffect == null) {
            return -2;
        }
        this.q.sendAddImageEvent(trackEffect);
        int b2 = this.t.b(trackEffect);
        trackEffect.setViewId(b2);
        return b2;
    }

    public int a(java.util.Map<java.lang.Integer, com.aliyun.svideosdk.common.struct.effect.TransitionBase> map) {
        int i;
        java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> videoTrackClips = this.i.getTimeline().getPrimaryTrack().getVideoTrackClips();
        for (java.util.Map.Entry<java.lang.Integer, com.aliyun.svideosdk.common.struct.effect.TransitionBase> entry : map.entrySet()) {
            int intValue = entry.getKey().intValue();
            com.aliyun.svideosdk.common.struct.effect.TransitionBase value = entry.getValue();
            if (value == null) {
                value = new com.aliyun.svideosdk.common.struct.effect.TransitionShutter();
                value.setOverlapDuration(0L);
            }
            if (intValue >= 0 && (i = intValue + 1) < videoTrackClips.size()) {
                com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip = videoTrackClips.get(i);
                com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip2 = videoTrackClips.get(i - 1);
                long out = (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f);
                long out2 = (long) ((videoTrackClip2.getOut() - videoTrackClip2.getIn()) * 1000000.0f);
                long overlapDuration = value.getOverlapDuration();
                if (out >= overlapDuration && out2 >= overlapDuration) {
                    a(videoTrackClip, value.getOverlapDuration(java.util.concurrent.TimeUnit.MILLISECONDS));
                    if (value.getOverlapDuration() != 0 || videoTrackClip.getTransition() == null) {
                        videoTrackClip.setTransition(value);
                    } else {
                        videoTrackClip.getEffects().remove(videoTrackClip.getTransition());
                    }
                }
            }
            return -20011022;
        }
        return l();
    }

    public void a(int i) {
        this.o = i;
    }

    public void a(com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam) {
        this.j = aliyunVideoParam;
    }

    public void a(com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack) {
        java.util.ArrayList<com.aliyun.svideosdk.common.struct.effect.ActionBase> arrayList = new java.util.ArrayList(photoPasterTrack.getActions());
        photoPasterTrack.getActions().clear();
        for (com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase : arrayList) {
            actionBase.setTargetId(photoPasterTrack.getId());
            actionBase.setIsStream(false);
            addFrameAnimation(actionBase);
        }
    }

    public void a(com.aliyun.svideosdk.editor.a aVar) {
        this.y = aVar;
    }

    public void a(com.aliyun.svideosdk.editor.c cVar) {
        this.e = cVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null) {
            return -2;
        }
        return addAnimationFilter(effectFilter.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addAnimationFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter) {
        this.q.sendAddAnimationFilterEvent(trackEffectFilter);
        return this.t.a(trackEffectFilter);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (actionBase == null) {
            return -20003002;
        }
        if (this.a == null) {
            return -20011019;
        }
        this.q.sendAddFrameAnimationEvent(actionBase);
        int addFrameAnimation = this.a.addFrameAnimation(actionBase.getTargetId(), actionBase);
        if (addFrameAnimation > 0) {
            actionBase.setId(addFrameAnimation);
        }
        this.i.addAction(actionBase);
        return addFrameAnimation;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addImage(com.aliyun.svideosdk.common.struct.effect.EffectPicture effectPicture) {
        if (effectPicture == null) {
            return -2;
        }
        com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffectImage = effectPicture.toTrackEffectImage();
        int a2 = a(trackEffectImage);
        effectPicture.setViewId(trackEffectImage.getViewId());
        return a2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addRunningDisplayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode, int i, long j, long j2) {
        if (!this.p) {
            return -4;
        }
        if (videoDisplayMode == null) {
            return -20003002;
        }
        this.q.sendAddRunningDisplayModeEvent(videoDisplayMode, i, j, j2);
        int runningDisplayMode = this.a.setRunningDisplayMode(i, videoDisplayMode.getDisplayMode(), j * 1000, j2 * 1000);
        com.aliyun.svideosdk.common.struct.project.RunningDisplayMode runningDisplayMode2 = new com.aliyun.svideosdk.common.struct.project.RunningDisplayMode(i, runningDisplayMode, j, j2, videoDisplayMode.getDisplayMode());
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.getEffects().add(runningDisplayMode2);
        }
        return runningDisplayMode;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addTailWaterMark(com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark trackEffectWaterMark, long j, java.util.concurrent.TimeUnit timeUnit) {
        java.lang.String path = trackEffectWaterMark.getPath();
        if (path == null || !new java.io.File(path).exists()) {
            return -20003013;
        }
        if (!i()) {
            return -20011019;
        }
        long micros = timeUnit.toMicros(j);
        this.q.sendAddTailWaterMarkEvent(path, trackEffectWaterMark.getWidthRatio(), trackEffectWaterMark.getHeightRatio(), trackEffectWaterMark.getXRadio(), trackEffectWaterMark.getYRadio(), micros);
        int tailBmp = this.a.setTailBmp(path, trackEffectWaterMark.getWidthRatio(), trackEffectWaterMark.getHeightRatio(), trackEffectWaterMark.getXRadio(), trackEffectWaterMark.getYRadio(), micros);
        if (tailBmp < 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("addTailWaterMark failed ret is ");
            sb.append(tailBmp);
            return tailBmp;
        }
        com.aliyun.svideosdk.common.struct.project.TailWaterMark tailWaterMark = new com.aliyun.svideosdk.common.struct.project.TailWaterMark();
        tailWaterMark.setSource(new com.aliyun.svideosdk.common.struct.project.Source(path));
        tailWaterMark.setDuration(micros);
        tailWaterMark.setWidth(trackEffectWaterMark.getWidthRatio());
        tailWaterMark.setHeight(trackEffectWaterMark.getHeightRatio());
        tailWaterMark.setX(trackEffectWaterMark.getXRadio());
        tailWaterMark.setY(trackEffectWaterMark.getYRadio());
        tailWaterMark.setId(tailBmp);
        this.i.setTailWaterMark(tailWaterMark);
        return tailBmp;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addTailWaterMark(java.lang.String str, float f, float f2, float f3, float f4, long j) {
        return addTailWaterMark(new com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark.Builder().source(new com.aliyun.svideosdk.common.struct.project.Source(str)).setXRadio(f3).setYRatio(f4).setWidthRatio(f).setHeightRatio(f2).build(), j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyAudioEffect(int i, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, int i2) {
        if (!this.p) {
            return -4;
        }
        if (audioEffectType == null || audioEffectType == com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_DENOISE) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        this.a.pause();
        int audioEffect = this.a.audioEffect(i, audioEffectType.getEffectType(), i2 / 100.0f);
        this.i.addEffect(i, new com.aliyun.svideosdk.common.struct.project.AudioEffect(audioEffectType, i2));
        a(3);
        return audioEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyBlurBackground(int i, long j, long j2, float f) {
        if (!this.p || !i()) {
            return -20011019;
        }
        this.q.sendApplyBlurBackgroundEvent(i, j, j2, f);
        int applyBlurBackground = this.a.applyBlurBackground(i, j * 1000, j2 * 1000, f);
        com.aliyun.svideosdk.common.struct.effect.BlurBackground blurBackground = new com.aliyun.svideosdk.common.struct.effect.BlurBackground(i, applyBlurBackground, j, j2, f);
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.getEffects().add(blurBackground);
        }
        a(3);
        return applyBlurBackground;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyDub(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return applyDub(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyDub(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (!this.p) {
            return -20011019;
        }
        if (trackAudioStream == null || trackAudioStream.getSource() == null || com.aliyun.common.utils.StringUtils.isEmpty(trackAudioStream.getSource().getPath()) || !new java.io.File(trackAudioStream.getSource().getPath()).exists()) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        this.a.pause();
        this.q.sendApplyDubEvent(trackAudioStream);
        int dub = this.a.dub(trackAudioStream.getSource().getPath(), trackAudioStream.getAudioWeight() / 10, trackAudioStream.getStartTime() * 1000, (trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) * 1000, trackAudioStream.getStreamStartTime() * 1000, trackAudioStream.getStreamDuration() * 1000);
        trackAudioStream.setStreamId(dub);
        com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip = new com.aliyun.svideosdk.common.struct.project.AudioTrackClip();
        audioTrackClip.setClipId(dub);
        audioTrackClip.setType(com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Dubs);
        audioTrackClip.setSource(trackAudioStream.getSource());
        audioTrackClip.setIn(trackAudioStream.getStreamStartTime() / 1000.0f);
        audioTrackClip.setOut(audioTrackClip.getIn() + (trackAudioStream.getStreamDuration() / 1000.0f));
        audioTrackClip.setTimelineIn(trackAudioStream.getStartTime() / 1000.0f);
        audioTrackClip.setTimelineOut((trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) / 1000.0f);
        audioTrackClip.setMixWeight(trackAudioStream.getAudioWeight());
        this.i.addAudioTrackClip(audioTrackClip);
        a(3);
        return dub;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean) {
        return android.text.TextUtils.isEmpty(effectBean.getPath()) ? removeFilter() : applyFilter(effectBean.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter) {
        if (!this.p) {
            return -20011019;
        }
        if (trackEffectFilter == null) {
            return -20003014;
        }
        if (trackEffectFilter.getSource() != null && trackEffectFilter.getSource().getPath() != null && !new java.io.File(trackEffectFilter.getSource().getPath()).exists()) {
            return -20003014;
        }
        this.q.sendApplyFilterEvent(trackEffectFilter.getBean());
        int a2 = a(trackEffectFilter.getSource() == null ? null : trackEffectFilter.getSource().getPath(), trackEffectFilter.getStartTime() * 1000, trackEffectFilter.getDuration() * 1000, 1);
        if (a2 == 0 && trackEffectFilter.getSource() != null) {
            if (trackEffectFilter.getSource() != null && com.aliyun.common.utils.StringUtils.isEmpty(trackEffectFilter.getSource().getId())) {
                trackEffectFilter.getSource().setId(java.lang.String.valueOf(trackEffectFilter.getResId()));
            }
            com.aliyun.svideosdk.common.struct.project.Filter filter = new com.aliyun.svideosdk.common.struct.project.Filter(trackEffectFilter.getSource());
            filter.setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter);
            filter.setTimelineIn(trackEffectFilter.getStartTime() / 1000.0f);
            filter.setTimelineOut(filter.getTimelineIn() + (trackEffectFilter.getDuration() / 1000.0f));
            filter.setSource(trackEffectFilter.getSource());
            filter.setId(trackEffectFilter.getResId());
            this.i.setColorEffect(filter);
        }
        return a2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyLutFilter(com.aliyun.svideosdk.common.struct.effect.LUTEffectBean lUTEffectBean) {
        if (!this.p) {
            return -20011019;
        }
        if (lUTEffectBean == null) {
            int a2 = a(null, 0.0f, 0L, 0L, 1);
            this.i.setLutEffect(null);
            return a2;
        }
        if (lUTEffectBean.getSource() != null && lUTEffectBean.getSource().getPath() != null && !new java.io.File(lUTEffectBean.getSource().getPath()).exists()) {
            return -20003014;
        }
        this.q.sendApplyLutFilterEvent(lUTEffectBean);
        int a3 = a(lUTEffectBean.getSource() != null ? lUTEffectBean.getSource().getPath() : null, lUTEffectBean.getIntensity(), 0L, 2147483647L, 1);
        if (a3 == 0) {
            com.aliyun.svideosdk.common.struct.project.Filter filter = new com.aliyun.svideosdk.common.struct.project.Filter(lUTEffectBean.getSource());
            filter.setType(com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.lut_filter);
            filter.setTimelineIn(0.0f);
            filter.setTimelineOut(filter.getTimelineIn() + 2147483.8f);
            filter.setIntensity(lUTEffectBean.getIntensity());
            this.i.setLutEffect(filter);
        }
        return a3;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMV(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return applyMV(effectBean.toTrackMV());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMV(com.aliyun.svideosdk.common.struct.effect.TrackEffectMV trackEffectMV) {
        if (!this.p) {
            return -20011019;
        }
        if (trackEffectMV == null || trackEffectMV.getSource() == null || trackEffectMV.getSource().getPath() == null || !new java.io.File(trackEffectMV.getSource().getPath()).exists()) {
            return -20003022;
        }
        this.a.pause();
        this.q.sendApplyMVEvent(trackEffectMV);
        int applyMv = this.a.applyMv(trackEffectMV.getSource().getPath(), trackEffectMV.getStartTime() * 1000, 1000 * trackEffectMV.getDuration());
        trackEffectMV.setViewId(applyMv);
        trackEffectMV.setAudioStreamId(this.a.getMvAudioId());
        if (trackEffectMV.getSource() != null && com.aliyun.common.utils.StringUtils.isEmpty(trackEffectMV.getSource().getId())) {
            trackEffectMV.getSource().setId(java.lang.String.valueOf(trackEffectMV.getViewId()));
        }
        com.aliyun.svideosdk.common.struct.project.MVFilter mVFilter = new com.aliyun.svideosdk.common.struct.project.MVFilter();
        mVFilter.setId(this.a.getMvAudioId());
        mVFilter.setSource(trackEffectMV.getSource());
        mVFilter.setTimelineIn(trackEffectMV.getStartTime() / 1000.0f);
        mVFilter.setTimelineOut((trackEffectMV.getStartTime() + trackEffectMV.getDuration()) / 1000.0f);
        this.i.setMVEffect(mVFilter);
        a(3);
        return applyMv;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusic(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return applyMusic(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusic(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (!this.p) {
            return -20011019;
        }
        if (trackAudioStream == null || trackAudioStream.checkIsInvalid()) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        this.a.pause();
        this.q.sendApplyMusicEvent(trackAudioStream);
        int mix = this.a.mix(trackAudioStream.getSource().getPath(), trackAudioStream.getAudioWeight() / 10, trackAudioStream.getStartTime() * 1000, (trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) * 1000, trackAudioStream.getStreamStartTime() * 1000, trackAudioStream.getStreamDuration() * 1000);
        trackAudioStream.setStreamId(mix);
        com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip = new com.aliyun.svideosdk.common.struct.project.AudioTrackClip();
        audioTrackClip.setClipId(mix);
        audioTrackClip.setType(com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music);
        audioTrackClip.setSource(trackAudioStream.getSource());
        audioTrackClip.setIn(trackAudioStream.getStreamStartTime() / 1000.0f);
        audioTrackClip.setOut(audioTrackClip.getIn() + (trackAudioStream.getStreamDuration() / 1000.0f));
        audioTrackClip.setTimelineIn(trackAudioStream.getStartTime() / 1000.0f);
        audioTrackClip.setTimelineOut((trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) / 1000.0f);
        audioTrackClip.setMixWeight(trackAudioStream.getAudioWeight());
        this.i.addAudioTrackClip(audioTrackClip);
        a(3);
        return mix;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusicMixWeight(int i, int i2) {
        if (!this.p || !i()) {
            return -20011019;
        }
        if (i2 != 0) {
            i2 = (i2 / 11) + 1;
        }
        int i3 = i2 > 5 ? 10 - ((i2 - 5) * 2) : 10;
        int i4 = i2 < 5 ? 10 - ((5 - i2) * 2) : 10;
        this.q.sendApplyMusicMixWeightEvent(i, i2);
        int mixAlpha = this.a.mixAlpha(i, i4);
        this.i.setMusicWeight(i, i4);
        if (mixAlpha != 0) {
            return mixAlpha;
        }
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            int mixAlpha2 = this.a.mixAlpha(videoTrackClip.getClipId(), i3);
            if (mixAlpha2 != 0) {
                return mixAlpha2;
            }
            videoTrackClip.setMixWeight(i3);
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusicWeight(int i, int i2) {
        if (!this.p) {
            return -20011019;
        }
        if (i2 != 0) {
            i2 = (i2 / 11) + 1;
        }
        this.q.sendApplyMusicWeightEvent(i, i2);
        int mixAlpha = this.a.mixAlpha(i, i2);
        if (mixAlpha != 0) {
            return mixAlpha;
        }
        this.i.setMusicWeight(i, i2);
        return mixAlpha;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applySourceChange() {
        if (this.b == null) {
            return -20003019;
        }
        this.q.sendApplySourceChangeEvent();
        int mediaPartCount = this.b.getMediaPartCount();
        com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip[] mainVideoTrackClipArr = new com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip[mediaPartCount];
        com.aliyun.svideosdk.common.struct.project.VideoTrack primaryTrack = this.i.getTimeline().getPrimaryTrack();
        primaryTrack.getVideoTrackClips().clear();
        for (int i = 0; i < this.b.getMediaPartCount(); i++) {
            com.aliyun.svideosdk.common.struct.common.AliyunClip mediaPart = this.b.getMediaPart(i);
            java.lang.String source = mediaPart.getSource();
            if (!android.text.TextUtils.isEmpty(source) && new java.io.File(source).exists()) {
                com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip mainVideoTrackClip = new com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip();
                mainVideoTrackClip.setSource(new com.aliyun.svideosdk.common.struct.project.Source(mediaPart.getSource()));
                mainVideoTrackClip.setTransition(mediaPart.getTransition());
                mainVideoTrackClip.setDisplayMode(mediaPart.getDisplayMode().ordinal());
                if (mediaPart.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE) {
                    mainVideoTrackClip.setIn(0.0f);
                    mainVideoTrackClip.setOut(((com.aliyun.svideosdk.common.struct.common.AliyunImageClip) mediaPart).getDuration() / 1000.0f);
                    mainVideoTrackClip.setDuration(9.223372E18f);
                    mainVideoTrackClip.setType(1);
                } else if (mediaPart.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE) {
                    mainVideoTrackClip.setIn(r7.getStartTime() / 1000.0f);
                    mainVideoTrackClip.setOut(r7.getEndTime() / 1000.0f);
                    mainVideoTrackClip.setDuration(r7.getDuration() / 1000.0f);
                    mainVideoTrackClip.setRotation(((com.aliyun.svideosdk.common.struct.common.AliyunVideoClip) mediaPart).getRotation());
                    mainVideoTrackClip.setType(0);
                }
                mainVideoTrackClip.setClipId(mediaPart.getId());
                mainVideoTrackClip.setWidth(mediaPart.getClipWidth());
                mainVideoTrackClip.setHeight(mediaPart.getClipHeight());
                if (i < this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().size()) {
                    mainVideoTrackClip.getEffects().addAll(this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().get(i).getEffects());
                }
                mainVideoTrackClipArr[i] = mainVideoTrackClip;
                primaryTrack.getVideoTrackClips().add(mainVideoTrackClip);
            }
        }
        this.i.refreshTimeLine();
        this.h = c();
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getTransition() != null) {
                a(videoTrackClip, videoTrackClip.getTransition().getOverlapDuration(java.util.concurrent.TimeUnit.MILLISECONDS));
            }
        }
        if (mediaPartCount == 0) {
            stop();
            this.a.release();
            return 0;
        }
        if (h()) {
            return 0;
        }
        int l = l();
        if (l != 0) {
            return l;
        }
        int stop = stop();
        if (stop == 0 && this.b != null) {
            this.b.updateAllClips(new com.aliyun.svideosdk.editor.impl.u(this.i.getTimeline().getPrimaryTrack().getVideoTrackClips(), this).getAllClips());
        }
        return stop;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyWaterMark(com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark trackEffectWaterMark) {
        com.aliyun.svideosdk.common.struct.project.WaterMark waterMark = new com.aliyun.svideosdk.common.struct.project.WaterMark();
        waterMark.setX(trackEffectWaterMark.getXRadio());
        waterMark.setY(trackEffectWaterMark.getYRadio());
        waterMark.setWidth(trackEffectWaterMark.getWidthRatio());
        waterMark.setHeight(trackEffectWaterMark.getHeightRatio());
        waterMark.setSource(trackEffectWaterMark.getSource());
        this.q.sendApplyWaterMarkEvent(trackEffectWaterMark.getPath(), trackEffectWaterMark.getXRadio(), trackEffectWaterMark.getYRadio(), trackEffectWaterMark.getWidthRatio(), trackEffectWaterMark.getHeightRatio());
        int effectWaterMark = this.t.setEffectWaterMark(a(waterMark));
        if (effectWaterMark >= 0) {
            waterMark.setId(effectWaterMark);
            this.i.setWaterMark(waterMark);
            return effectWaterMark;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("applyWaterMark failed ret is ");
        sb.append(effectWaterMark);
        return effectWaterMark;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyWaterMark(java.lang.String str, float f, float f2, float f3, float f4) {
        return applyWaterMark(new com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark.Builder().source(new com.aliyun.svideosdk.common.struct.project.Source(str)).setXRadio(f3).setYRatio(f4).setWidthRatio(f).setHeightRatio(f2).build());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int audioEffect(int i, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, int i2) {
        return applyAudioEffect(i, audioEffectType, i2);
    }

    public void b(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        this.q.sendRemoveImageEvent(trackEffect);
        this.t.d(trackEffect);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int cancelCompose() {
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE && this.o == 5) {
            this.q.sendCancelComposeEvent();
            this.a.stop();
            a(4);
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void clearAllAnimationFilter() {
        this.q.sendClearAllAnimationFilterEvent();
        this.t.a();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int compose(com.aliyun.svideosdk.common.struct.common.AliyunVideoParam aliyunVideoParam, java.lang.String str, com.aliyun.svideosdk.editor.AliyunIComposeCallBack aliyunIComposeCallBack) {
        int prepare;
        if (!this.p) {
            return -4;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return -20011020;
        }
        java.io.File parentFile = new java.io.File(str).getParentFile();
        if (parentFile != null) {
            if (parentFile.exists() && !parentFile.isDirectory()) {
                return -10001010;
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Invalid output path:");
                sb.append(str);
                return -10001010;
            }
        }
        if (aliyunVideoParam == null) {
            aliyunVideoParam = new com.aliyun.svideosdk.common.struct.common.AliyunVideoParam();
            aliyunVideoParam.setScaleMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.valueOf(this.i.getConfig().getDisplayMode()));
            aliyunVideoParam.setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality.values()[this.i.getConfig().getVideoQuality()]);
            aliyunVideoParam.setBitrate(this.i.getConfig().getBitrate());
            aliyunVideoParam.setFrameRate(this.i.getConfig().getFps());
            aliyunVideoParam.setGop(this.i.getConfig().getGop());
            aliyunVideoParam.setCrf(this.i.getConfig().getCrf());
            aliyunVideoParam.setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.getInstanceByValue(this.i.getConfig().getVideoCodec()));
            aliyunVideoParam.setScaleRate(this.i.getConfig().getScale());
        }
        int outputWidth = (int) (this.i.getConfig().getOutputWidth() * aliyunVideoParam.getScaleRate());
        if (outputWidth % 2 != 0) {
            outputWidth--;
        }
        int outputHeight = (int) (this.i.getConfig().getOutputHeight() * aliyunVideoParam.getScaleRate());
        if (outputHeight % 2 != 0) {
            outputHeight--;
        }
        int i = outputHeight;
        if (this.o == 5) {
            return -20011018;
        }
        if (this.a.isNativePrepared()) {
            stop();
        }
        this.g = this.a.getDuration();
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
            this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE;
            int encodeParam = this.a.setEncodeParam(aliyunVideoParam.getBitrate(), aliyunVideoParam.getFrameRate(), aliyunVideoParam.getGop(), aliyunVideoParam.getVideoQuality().ordinal(), aliyunVideoParam.getCrf(), aliyunVideoParam.getVideoCodec().ordinal(), outputWidth, i);
            if (encodeParam != 0) {
                return encodeParam;
            }
            int outputPath = this.a.setOutputPath(str);
            if (outputPath != 0) {
                return outputPath;
            }
            int mode = this.a.setMode(this.e);
            if (mode != 0) {
                return mode;
            }
        }
        int displayMode = this.a.setDisplayMode(aliyunVideoParam.getScaleMode().ordinal());
        if (displayMode != 0) {
            return displayMode;
        }
        if (!this.a.isNativePrepared() && (prepare = this.a.prepare()) != 0) {
            return prepare;
        }
        this.q.sendComposeEvent(aliyunVideoParam, str);
        this.a.setDisplaySize(outputWidth, i);
        int start = this.a.start();
        if (start != 0) {
            return start;
        }
        this.j = aliyunVideoParam;
        this.x = aliyunIComposeCallBack;
        this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE;
        a(5);
        this.E = java.lang.System.nanoTime();
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunPasterManager createPasterManager() {
        return this.f95s;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunRollCaptionComposer createRollCaptionComposer() {
        return this.u;
    }

    public int d() {
        return this.G;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int deleteBlurBackground(int i, int i2) {
        if (!this.p || !i()) {
            return -20011019;
        }
        this.q.sendDeleteBlurBackgroundEvent(i, i2);
        int deleteBlurBackground = this.a.deleteBlurBackground(i, i2);
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            for (com.aliyun.svideosdk.common.struct.project.Effect effect : videoTrackClipById.getEffects()) {
                if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.blur_background && (effect instanceof com.aliyun.svideosdk.common.struct.project.RunningDisplayMode) && ((com.aliyun.svideosdk.common.struct.project.RunningDisplayMode) effect).getId() == i2) {
                    videoTrackClipById.getEffects().remove(effect);
                }
            }
        }
        a(3);
        return deleteBlurBackground;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int deleteTimeEffect(int i) {
        this.a.pause();
        this.q.sendDeleteTimeEffectEvent(i);
        int deleteTimeEffect = this.a.deleteTimeEffect(i);
        if (deleteTimeEffect != 0) {
            return deleteTimeEffect;
        }
        this.i.removeTimeFilter(i);
        a(3);
        return deleteTimeEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int denoise(int i, int i2) {
        if (!this.p) {
            return -20011019;
        }
        this.q.sendDenoiseEvent(i, i2 != 0);
        int denoise = this.a.denoise(i, i2 / 100.0f);
        if (denoise != 0) {
            return denoise;
        }
        this.i.setDenoise(i, i2);
        return denoise;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int denoise(int i, boolean z) {
        return denoise(i, z ? 20 : 0);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int draw(long j) {
        return draw(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int draw(long j, java.util.concurrent.TimeUnit timeUnit) {
        int prepare = (!this.p || this.a.isNativePrepared()) ? 0 : this.a.prepare();
        if (prepare != 0) {
            return prepare;
        }
        if (!i() || j()) {
            return -20011019;
        }
        int draw = this.a.draw(timeUnit.toMicros(j));
        a(3);
        return draw;
    }

    public int e() {
        return this.F;
    }

    public com.aliyun.svideosdk.editor.NativeEditor f() {
        return this.a;
    }

    public int g() {
        return this.i.getConfig().getOutputWidth();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.common.log.struct.AliyunLogInfo getAliyunLogInfo() {
        return this.D;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getClipStartTime(int i) {
        if (this.p) {
            return this.a.getClipStartTime(i);
        }
        return -20011019L;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public android.graphics.Bitmap getCurrentFrame() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor = this.a;
        android.graphics.Bitmap frameAtTime = nativeEditor.getFrameAtTime(nativeEditor.getPlayTime());
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(180.0f);
        matrix.postScale(-1.0f, 1.0f);
        return android.graphics.Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getCurrentPlayPosition() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.a) == null) {
            return 0L;
        }
        return nativeEditor.getPlayTime();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getCurrentStreamPosition() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.a) == null) {
            return 0L;
        }
        return nativeEditor.getStreamPlayTime();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getDuration() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.a) == null) {
            return 0L;
        }
        return nativeEditor.getDuration();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.common.struct.project.AliyunEditorProject getEditorProject() {
        return this.i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getFilterLastApplyId() {
        if (!this.p) {
            return -20011019;
        }
        com.aliyun.svideosdk.common.struct.project.Filter colorEffect = this.i.getColorEffect();
        if (colorEffect != null) {
            return colorEffect.getSource().getIntId();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getMVLastApplyId() {
        if (!this.p) {
            return -20011019;
        }
        com.aliyun.svideosdk.common.struct.project.MVFilter mVEffect = this.i.getMVEffect();
        if (mVEffect != null) {
            return mVEffect.getSource().getIntId();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getMusicLastApplyId() {
        if (this.p) {
            return this.i.getAudioId();
        }
        return -20011019;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public android.graphics.Paint getPaintLastApply() {
        java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> transfer;
        if (!this.p || this.i.getCanvasTrack() == null || this.i.getCanvasTrack().getCanvasInfo() == null || (transfer = this.i.getCanvasTrack().getCanvasInfo().convertCoordinate(this.F, this.G, true).transfer()) == null || transfer.size() <= 0) {
            return null;
        }
        return transfer.get(transfer.size() - 1).getPaint();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunPasterManager getPasterManager() {
        return this.f95s;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunPasterRender getPasterRender() {
        return this.t;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunIPipManager getPipManager() {
        return this.v;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunIPlayerController getPlayerController() {
        if (this.n == null) {
            this.n = new com.aliyun.svideosdk.editor.impl.t(this);
        }
        return this.n;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo getProjectInfo() {
        return this.r;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getRotation() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.i;
        if (aliyunEditorProject == null || aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips().size() <= 0) {
            return 0;
        }
        return this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().get(0).getRotation();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunISourcePartManager getSourcePartManager() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.i;
        if (aliyunEditorProject == null) {
            return null;
        }
        if (this.b == null) {
            this.b = new com.aliyun.svideosdk.editor.impl.u(aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips(), this);
        }
        return this.b;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getStreamDuration() {
        com.aliyun.svideosdk.editor.NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.a) == null) {
            return 0L;
        }
        return nativeEditor.getStreamDuration();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.TimeEffectType getTimeEffect() {
        if (!i()) {
            return null;
        }
        int timeEffect = this.a.getTimeEffect();
        if (timeEffect < 0 || timeEffect > com.aliyun.svideosdk.editor.TimeEffectType.values().length) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Editor error!ErrorCode:");
            sb.append(timeEffect);
            return null;
        }
        com.aliyun.svideosdk.editor.TimeEffectType typeByValue = com.aliyun.svideosdk.editor.TimeEffectType.getTypeByValue(timeEffect);
        if (typeByValue == null) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Invalid return value ");
            sb2.append(timeEffect);
        }
        return typeByValue;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getVideoHeight() {
        return this.i.getConfig().getOutputHeight();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getVideoWidth() {
        return this.i.getConfig().getOutputWidth();
    }

    public synchronized boolean h() {
        return this.o == 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int init(android.view.SurfaceView surfaceView, android.content.Context context) {
        int outputWidth = this.i.getConfig().getOutputWidth();
        int outputHeight = this.i.getConfig().getOutputHeight();
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.graphics.Point point = new android.graphics.Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i = point.x;
        return init(surfaceView, context, i, (outputHeight * i) / outputWidth);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int init(android.view.SurfaceView surfaceView, android.content.Context context, int i, int i2) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        if (this.q == null) {
            com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.i;
            this.q = new com.aliyun.common.log.reporter.AlivcEditorReporter(context, aliyunEditorProject == null ? "0" : aliyunEditorProject.getRequestID());
        }
        this.t.a(context.getExternalFilesDir(""));
        this.q.sendInitEvent();
        this.D = new com.aliyun.common.log.struct.AliyunLogInfo(com.aliyun.svideosdk.editor.impl.g.class.getName());
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject2 = this.i;
        if (aliyunEditorProject2 == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Editor init project failed");
            return -20003019;
        }
        int outputWidth = aliyunEditorProject2.getConfig().getOutputWidth();
        int outputHeight = this.i.getConfig().getOutputHeight();
        if (outputWidth <= 0 || outputHeight <= 0) {
            sb = new java.lang.StringBuilder();
            str = "Invalid output size, width[";
        } else {
            this.F = i;
            this.G = i2;
            this.u.a(i, i2);
            if (outputWidth % 2 == 0 && outputHeight % 2 == 0) {
                if (surfaceView != null) {
                    this.B = surfaceView;
                    surfaceView.getHolder().addCallback(this.H);
                }
                this.u.a(context);
                return k();
            }
            sb = new java.lang.StringBuilder();
            str = "Output size must be even number, width[";
        }
        sb.append(str);
        sb.append(outputWidth);
        sb.append("],height[");
        sb.append(outputHeight);
        sb.append("]");
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", sb.toString());
        return -2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int invert() {
        if (!this.p) {
            return -4;
        }
        if (this.a.pause() == 0) {
            a(3);
        }
        this.q.sendInvertEvent();
        int invert = this.a.invert();
        if (invert != 0) {
            return invert;
        }
        this.i.addTimeFilter(new com.aliyun.svideosdk.common.struct.project.TimeFilter(invert, 0L, 0L, com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT.ordinal(), 0.0f, false));
        return invert;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public boolean isAudioSilence() {
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.i;
        if (aliyunEditorProject == null) {
            return false;
        }
        return aliyunEditorProject.getConfig().isMute();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public boolean isPaused() {
        return this.o == 3;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public boolean isPlaying() {
        return this.o == 2;
    }

    public void m() {
        this.t.c();
    }

    public void n() {
        int repeat;
        if (this.i.getTimeline().getEffectTracks() == null || this.i.getTimeline().getEffectTracks().isEmpty()) {
            return;
        }
        java.util.ArrayList<com.aliyun.svideosdk.common.struct.project.EffectTrack> arrayList = new java.util.ArrayList();
        arrayList.addAll(this.i.getTimeline().getEffectTracks());
        this.i.getTimeline().getEffectTracks().clear();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.EffectTrack effectTrack : arrayList) {
            if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.time_effect) {
                com.aliyun.svideosdk.common.struct.project.TimeFilter timeFilter = (com.aliyun.svideosdk.common.struct.project.TimeFilter) effectTrack;
                if (timeFilter.getTimeFilterType() == com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_INVERT.ordinal()) {
                    repeat = this.a.invert();
                } else if (timeFilter.getTimeFilterType() == com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE.ordinal()) {
                    repeat = this.a.setRate(timeFilter.getParam(), timeFilter.getStartTime() * 1000, timeFilter.getDuration() * 1000, timeFilter.isNeedOriginDuration());
                } else {
                    if (timeFilter.getTimeFilterType() == com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT.ordinal()) {
                        repeat = this.a.setRepeat((int) timeFilter.getParam(), timeFilter.getStartTime() * 1000, timeFilter.getDuration() * 1000, timeFilter.isNeedOriginDuration());
                    }
                    this.i.addTimeFilter(timeFilter);
                }
                timeFilter.setId(repeat);
                this.i.addTimeFilter(timeFilter);
            } else if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.filter) {
                com.aliyun.svideosdk.common.struct.project.Filter filter = (com.aliyun.svideosdk.common.struct.project.Filter) effectTrack;
                if (com.aliyun.common.utils.FileUtils.isFileExists(filter.getSource().getPath())) {
                    a(filter.getSource().getPath(), (long) (filter.getTimelineIn() * 1000000.0f), (long) ((filter.getTimelineIn() - filter.getTimelineOut()) * 1000000.0f), 1);
                }
                this.i.setColorEffect(filter);
            } else if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.animation_filter) {
                com.aliyun.svideosdk.common.struct.project.Filter filter2 = (com.aliyun.svideosdk.common.struct.project.Filter) effectTrack;
                com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder builder = new com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter.Builder();
                long duration = filter2.getDuration();
                java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
                com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter build = builder.duration(duration, timeUnit).startTime(filter2.getStartTime(), timeUnit).source(filter2.getSource()).effectConfig(filter2.getEffectConfig()).build();
                a(build);
                arrayList2.add(build);
            } else if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.mv) {
                com.aliyun.svideosdk.common.struct.project.MVFilter mVFilter = (com.aliyun.svideosdk.common.struct.project.MVFilter) effectTrack;
                if (com.aliyun.common.utils.FileUtils.isFileExists(mVFilter.getSource().getPath())) {
                    this.a.applyMv(mVFilter.getSource().getPath(), (long) (mVFilter.getTimelineIn() * 1000000.0f), (long) (mVFilter.getTimelineOut() * 1000000.0f));
                    mVFilter.setId(this.a.getMvAudioId());
                    if (mVFilter.isMute()) {
                        this.a.resetEffect(com.aliyun.svideosdk.editor.EffectType.EFFECT_TYPE_MV_AUDIO.ordinal());
                    }
                }
                this.i.setMVEffect(mVFilter);
            } else if (effectTrack.getType() == com.aliyun.svideosdk.common.struct.project.EffectTrack.Type.lut_filter) {
                com.aliyun.svideosdk.common.struct.project.Filter filter3 = (com.aliyun.svideosdk.common.struct.project.Filter) effectTrack;
                if (com.aliyun.common.utils.FileUtils.isFileExists(filter3.getSource().getPath())) {
                    a(filter3.getSource().getPath(), filter3.getIntensity(), (long) (filter3.getTimelineIn() * 1000.0f), (long) ((filter3.getTimelineOut() - filter3.getTimelineIn()) * 1000.0f), 1);
                }
                this.i.setLutEffect(filter3);
            }
        }
        com.aliyun.svideosdk.editor.OnAnimationFilterRestoredListener onAnimationFilterRestoredListener = this.A;
        if (onAnimationFilterRestoredListener != null) {
            onAnimationFilterRestoredListener.onAnimationFilterRestored(arrayList2);
        }
    }

    public void o() {
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            this.a.setHorizontalFlip(videoTrackClip.getClipId(), videoTrackClip.isHorizontalFlip());
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public com.aliyun.svideosdk.editor.AliyunICanvasController obtainCanvasController(android.content.Context context, int i, int i2) {
        if (context == null || i <= 0 || i2 <= 0) {
            return null;
        }
        com.aliyun.svideosdk.editor.impl.e eVar = this.d;
        if (eVar != null && eVar.b() == i && this.d.a() == i2) {
            return this.d;
        }
        com.aliyun.svideosdk.editor.impl.e eVar2 = new com.aliyun.svideosdk.editor.impl.e(context, this.i, this, i, i2);
        this.d = eVar2;
        return eVar2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void onDestroy() {
        a(0);
        this.p = false;
        if (this.a != null) {
            w();
            this.a.stop();
            this.a.release();
        }
        com.aliyun.svideosdk.editor.impl.e eVar = this.d;
        if (eVar != null) {
            eVar.release();
            this.d = null;
        }
        if (this.a != null) {
            this.a.dispose();
            this.a = null;
        }
        android.view.SurfaceView surfaceView = this.B;
        if (surfaceView != null) {
            surfaceView.getHolder().removeCallback(this.H);
            this.B = null;
        }
        com.aliyun.svideosdk.editor.impl.o oVar = this.f95s;
        if (oVar != null) {
            oVar.setOnPasterRestoreListener(null);
        }
        com.aliyun.common.log.reporter.AlivcEditorReporter alivcEditorReporter = this.q;
        if (alivcEditorReporter != null) {
            alivcEditorReporter.sendOnDestroyEvent();
            this.q.release();
        }
        com.aliyun.svideosdk.editor.impl.r rVar = this.v;
        if (rVar != null) {
            rVar.a();
        }
        this.w = null;
        this.A = null;
        this.x = null;
        this.y = null;
    }

    public void p() {
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.AudioTrack> it = this.i.getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (com.aliyun.svideosdk.common.struct.project.AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (com.aliyun.common.utils.FileUtils.isFileExists(audioTrackClip.getSource().getPath())) {
                    audioTrackClip.setClipId(audioTrackClip.getType() == com.aliyun.svideosdk.common.struct.project.AudioTrackClip.Type.Music ? this.a.mix(audioTrackClip.getSource().getPath(), audioTrackClip.getMixWeight() / 10, (long) (audioTrackClip.getTimelineIn() * 1000000.0f), (long) ((audioTrackClip.getTimelineOut() - audioTrackClip.getTimelineIn()) * 1000000.0f), (long) (audioTrackClip.getIn() * 1000000.0f), (long) ((audioTrackClip.getOut() - audioTrackClip.getIn()) * 1000000.0f)) : this.a.dub(audioTrackClip.getSource().getPath(), audioTrackClip.getMixWeight() / 10, (long) (audioTrackClip.getTimelineIn() * 1000000.0f), (long) ((audioTrackClip.getTimelineOut() - audioTrackClip.getTimelineIn()) * 1000000.0f), (long) (audioTrackClip.getIn() * 1000000.0f), (long) ((audioTrackClip.getOut() - audioTrackClip.getIn()) * 1000000.0f)));
                }
            }
        }
        x();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int pause() {
        if (!this.p) {
            return -4;
        }
        a(3);
        if (!i()) {
            return -20011019;
        }
        this.q.sendPauseEvent();
        return this.a.pause();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int play() {
        if (!this.p) {
            return -4;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "editor play");
        int i = 0;
        if (isPlaying()) {
            return 0;
        }
        this.q.sendPlayEvent();
        b();
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
            com.aliyun.svideosdk.editor.c cVar = com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY;
            this.e = cVar;
            i = this.a.setMode(cVar);
        }
        if (i != 0) {
            return i;
        }
        if (!this.a.isNativePrepared()) {
            i = this.a.prepare();
        }
        if (i != 0) {
            return i;
        }
        int displayMode = setDisplayMode(this.k);
        if (displayMode != 0) {
            return displayMode;
        }
        int start = this.a.start();
        a(2);
        this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY;
        return start;
    }

    public void q() {
        this.t.d();
    }

    public void r() {
        com.aliyun.svideosdk.editor.AliyunIPipTrack aliyunIPipTrack;
        com.aliyun.svideosdk.editor.AliyunIPipController createPipInTrack;
        java.util.ArrayList arrayList = new java.util.ArrayList(this.i.getTimeline().getPipTracks());
        this.i.getTimeline().getVideoTracks().removeAll(arrayList);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i = 0;
            com.aliyun.svideosdk.editor.AliyunIPipTrack aliyunIPipTrack2 = null;
            for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : ((com.aliyun.svideosdk.common.struct.project.VideoTrack) it.next()).getVideoTrackClips()) {
                if (videoTrackClip instanceof com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip) {
                    com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip pipVideoTrackClip = (com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip) videoTrackClip;
                    if (i == 0) {
                        createPipInTrack = this.v.createNewPip(pipVideoTrackClip.getSource().getPath());
                        aliyunIPipTrack = createPipInTrack.getOwnerTrack();
                    } else {
                        aliyunIPipTrack = aliyunIPipTrack2;
                        createPipInTrack = this.v.createPipInTrack(pipVideoTrackClip.getSource().getPath(), aliyunIPipTrack2);
                    }
                    com.aliyun.svideosdk.editor.impl.q qVar = (com.aliyun.svideosdk.editor.impl.q) createPipInTrack;
                    com.aliyun.svideosdk.editor.impl.q a2 = qVar.a((long) (pipVideoTrackClip.getDuration() * 1000000.0f));
                    long in = (long) pipVideoTrackClip.getIn();
                    java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
                    a2.setClipStartTime(in, timeUnit).setClipEndTime((long) pipVideoTrackClip.getOut(), timeUnit).setTimelineStartTime(((long) pipVideoTrackClip.getTimelineIn()) * 1000000, java.util.concurrent.TimeUnit.MICROSECONDS).setBorderColor(pipVideoTrackClip.getBorder().getColor()).setBorderWidth(pipVideoTrackClip.getBorder().getWidth() * this.i.getConfig().getOutputWidth()).setBorderCornerRadius(pipVideoTrackClip.getBorder().getCornerRadius() * this.i.getConfig().getOutputWidth()).setHorizontalFlip(pipVideoTrackClip.getHorizontalFlip()).apply();
                    qVar.getLayoutController().setScale(pipVideoTrackClip.getScale()).setAlpha(pipVideoTrackClip.getAlpha()).setRotation(pipVideoTrackClip.getRotationRadian()).setPosition(pipVideoTrackClip.getCenterX(), pipVideoTrackClip.getCenterY()).apply();
                    qVar.getAugmentationController().setBrightness(pipVideoTrackClip.getBrightness()).setSharpness(pipVideoTrackClip.getSharpness()).setSaturation(pipVideoTrackClip.getSaturation()).setContrast(pipVideoTrackClip.getContrast()).setVignette(pipVideoTrackClip.getVignette()).apply();
                    qVar.getAudioController().setVolume(pipVideoTrackClip.getMixWeight()).denoise(pipVideoTrackClip.getDenoiseWeight()).apply();
                    for (com.aliyun.svideosdk.common.struct.project.Effect effect : pipVideoTrackClip.getEffects()) {
                        if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_effect) {
                            qVar.getAudioController().setAudioEffect(((com.aliyun.svideosdk.common.struct.project.AudioEffect) effect).mEffectType, r7.mEffectParam / 100.0f);
                        } else if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.audio_fade) {
                            com.aliyun.svideosdk.common.struct.project.AudioFade audioFade = (com.aliyun.svideosdk.common.struct.project.AudioFade) effect;
                            com.aliyun.svideosdk.editor.ShapeType shapeType = com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_LINEAR;
                            int i2 = audioFade.shapeType;
                            if (i2 == 1 || i2 == 3) {
                                shapeType = com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_SIN;
                            }
                            if (audioFade.isFadeIn) {
                                qVar.getAudioController().setAudioFadeIn(shapeType, com.aliyun.common.media.TimeUnitUtil.secondsToMicros(audioFade.duration));
                            } else {
                                qVar.getAudioController().setAudioFadeOut(shapeType, com.aliyun.common.media.TimeUnitUtil.secondsToMicros(audioFade.duration));
                            }
                        }
                    }
                    qVar.getAudioController().apply();
                    java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.ActionBase> it2 = pipVideoTrackClip.getActions().iterator();
                    while (it2.hasNext()) {
                        qVar.getAnimationController().addFrameAnimation(it2.next());
                    }
                    i++;
                    aliyunIPipTrack2 = aliyunIPipTrack;
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int rate(float f, long j, long j2, boolean z) {
        if (!this.p) {
            return -4;
        }
        if (this.a.pause() == 0) {
            a(3);
        }
        this.q.sendRateEvent(f, j, j2, z);
        int rate = this.a.setRate(f, j * 1000, j2 * 1000, z);
        if (rate < 0) {
            return rate;
        }
        this.i.addTimeFilter(new com.aliyun.svideosdk.common.struct.project.TimeFilter(rate, j, j2, com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_RATE.ordinal(), f, z));
        return rate;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null) {
            return;
        }
        removeAnimationFilter(effectFilter.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter) {
        if (this.t != null) {
            this.q.sendRemoveAnimationFilterEvent(trackEffectFilter);
            this.t.c(trackEffectFilter);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeAudioEffect(int i, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType) {
        if (!this.p) {
            return -4;
        }
        if (audioEffectType == null) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        this.a.pause();
        int removeAudioEffect = this.a.removeAudioEffect(i, audioEffectType.getEffectType());
        com.aliyun.svideosdk.common.struct.project.AudioEffect audioEffect = new com.aliyun.svideosdk.common.struct.project.AudioEffect();
        audioEffect.mEffectType = audioEffectType;
        this.i.removeEffect(i, audioEffect);
        a(3);
        return removeAudioEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeAudioFadeIn(int i) {
        if (!this.p) {
            return -4;
        }
        if (!i()) {
            return -20011019;
        }
        int audioFadeInFadeOut = this.a.setAudioFadeInFadeOut(i, 0, 0L, true);
        this.i.removeEffect(i, new com.aliyun.svideosdk.common.struct.project.AudioFade(0, 0.0f, true));
        return audioFadeInFadeOut;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeAudioFadeOut(int i) {
        if (!this.p) {
            return -4;
        }
        if (!i()) {
            return -20011019;
        }
        int audioFadeInFadeOut = this.a.setAudioFadeInFadeOut(i, 0, 0L, false);
        this.i.removeEffect(i, new com.aliyun.svideosdk.common.struct.project.AudioFade(0, 0.0f, false));
        return audioFadeInFadeOut;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeDub(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return removeDub(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeDub(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (!this.p) {
            return -20011019;
        }
        if (trackAudioStream == null) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        this.a.pause();
        this.q.sendRemoveDubEvent(trackAudioStream);
        int removeDub = this.a.removeDub(trackAudioStream.getStreamId());
        if (removeDub != 0) {
            return removeDub;
        }
        this.i.removeAudioTrackClip(trackAudioStream.getStreamId());
        a(3);
        return removeDub;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeFilter() {
        if (!this.p) {
            return -20011019;
        }
        this.q.sendRemoveFilterEvent();
        int a2 = a(null, 0L, 0L, 1);
        if (a2 != 0) {
            return a2;
        }
        this.i.clearColorEffect();
        return a2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeFrameAnimation(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        if (!this.p) {
            return -20011019;
        }
        if (actionBase == null) {
            return -2;
        }
        this.i.removeActionById(actionBase.getId());
        this.q.sendRemoveFrameAnimationEvent(actionBase);
        return this.a.removeFrameAnimation(actionBase.getTargetId(), actionBase);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectPicture effectPicture) {
        if (effectPicture == null) {
            return;
        }
        b(effectPicture.toTrackEffectImage());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeMusic(com.aliyun.svideosdk.common.struct.effect.EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return removeMusic(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeMusic(com.aliyun.svideosdk.common.struct.effect.TrackAudioStream trackAudioStream) {
        if (!this.p) {
            return -20011019;
        }
        if (trackAudioStream == null) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        this.a.pause();
        this.q.sendRemoveMusicEvent(trackAudioStream);
        int removeMix = this.a.removeMix(trackAudioStream.getStreamId());
        if (removeMix != 0) {
            return removeMix;
        }
        this.i.removeAudioTrackClip(trackAudioStream.getStreamId());
        a(3);
        return removeMix;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeRunningDisplayMode(int i, int i2) {
        if (!this.p) {
            return -4;
        }
        com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            for (com.aliyun.svideosdk.common.struct.project.Effect effect : videoTrackClipById.getEffects()) {
                if (effect.getType() == com.aliyun.svideosdk.common.struct.project.Effect.Type.running_display_mode && ((com.aliyun.svideosdk.common.struct.project.RunningDisplayMode) effect).getId() == i2) {
                    videoTrackClipById.getEffects().remove(effect);
                }
            }
        }
        this.q.sendRemoveRunningDisplayModeEvent(i, i2);
        return this.a.removeRunningDisplayMode(i2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int repeat(int i, long j, long j2, boolean z) {
        if (!this.p) {
            return -4;
        }
        if (this.a.pause() == 0) {
            a(3);
        }
        float f = i;
        this.q.sendRepeatEvent(f, j, j2, z);
        int repeat = this.a.setRepeat(i, j * 1000, j2 * 1000, z);
        if (repeat != 0) {
            return repeat;
        }
        this.i.addTimeFilter(new com.aliyun.svideosdk.common.struct.project.TimeFilter(repeat, j, j2, com.aliyun.svideosdk.editor.TimeEffectType.TIME_EFFECT_TYPE_REPEAT.ordinal(), f, z));
        return repeat;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int replay() {
        if (!this.p) {
            return -4;
        }
        this.q.sendReplayEvent();
        int seek = this.a.seek(0L);
        if (seek == 0) {
            int resume = this.a.resume();
            a(2);
            return resume;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("replay seek failed ! ret is ");
        sb.append(seek);
        return seek;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int resetEffect(com.aliyun.svideosdk.editor.EffectType effectType) {
        com.aliyun.svideosdk.common.struct.project.MVFilter mVEffect;
        if (effectType == null) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        int i = com.aliyun.svideosdk.editor.impl.g.e.b[effectType.ordinal()];
        if (i == 1) {
            this.i.setMVEffect(null);
        } else if (i == 2) {
            this.i.clearMusic();
        } else if (i == 3) {
            this.i.clearTimeFilters();
        } else if (i == 4 && (mVEffect = this.i.getMVEffect()) != null) {
            mVEffect.setMute(true);
        }
        this.a.pause();
        this.q.sendResetEffectEvent(effectType);
        int resetEffect = this.a.resetEffect(effectType.getEffectType());
        a(3);
        return resetEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int resetVideoAugmentation(int i, com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType) {
        if (!this.p) {
            return -4;
        }
        int i2 = com.aliyun.svideosdk.editor.impl.g.e.a[videoAugmentationType.ordinal()];
        if (i2 == 1) {
            return a(i, 0.5f);
        }
        if (i2 == 2) {
            return b(i, 0.25f);
        }
        if (i2 == 3) {
            return c(i, 0.5f);
        }
        if (i2 == 4) {
            return d(i, 0.0f);
        }
        if (i2 != 5) {
            return -4;
        }
        return e(i, 0.0f);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int resume() {
        if (!this.p) {
            return -4;
        }
        if (!isPaused()) {
            return -20011019;
        }
        this.q.sendResumeEvent();
        int resume = this.a.resume();
        a(2);
        return resume;
    }

    public void s() {
        com.aliyun.svideosdk.common.struct.project.TailWaterMark tailWaterMark = this.i.getTailWaterMark();
        if (tailWaterMark != null) {
            tailWaterMark.setId(this.a.setTailBmp(tailWaterMark.getSource().getPath(), tailWaterMark.getWidth(), tailWaterMark.getHeight(), tailWaterMark.getX(), tailWaterMark.getY(), tailWaterMark.getDuration()));
            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.ActionBase> it = tailWaterMark.getActions().iterator();
            while (it.hasNext()) {
                com.aliyun.svideosdk.common.struct.effect.ActionBase next = it.next();
                next.setTargetId(tailWaterMark.getId());
                next.setId(this.a.addFrameAnimation(next.getTargetId(), next));
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int saveEffectToLocal() {
        if (this.i == null) {
            return -20003019;
        }
        this.q.sendSaveEffectToLocalEvent();
        this.t.e();
        this.i.updateFileSize();
        com.aliyun.svideosdk.common.struct.project.AliyunEditorProject aliyunEditorProject = this.i;
        com.aliyun.svideosdk.common.struct.project.ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), this.c);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int seek(long j) {
        return seek(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int seek(long j, java.util.concurrent.TimeUnit timeUnit) {
        int prepare = (!this.p || this.a.isNativePrepared()) ? 0 : this.a.prepare();
        if (prepare != 0) {
            return prepare;
        }
        if (!i() || j()) {
            return -20011019;
        }
        int seek = this.a.seek(timeUnit.toMicros(j));
        a(3);
        return seek;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setAnimationRestoredListener(com.aliyun.svideosdk.editor.OnAnimationFilterRestored onAnimationFilterRestored) {
        this.z = onAnimationFilterRestored;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setAudioFadeIn(int i, com.aliyun.svideosdk.editor.ShapeType shapeType, long j) {
        if (!this.p) {
            return -4;
        }
        if (shapeType == null) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        int i2 = shapeType == com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_LINEAR ? 0 : 2;
        com.aliyun.svideosdk.common.struct.project.AudioFade audioFade = new com.aliyun.svideosdk.common.struct.project.AudioFade(shapeType.ordinal(), j / 1000.0f, true);
        this.i.removeEffect(i, audioFade);
        this.i.addEffect(i, audioFade);
        return this.a.setAudioFadeInFadeOut(i, i2, j, true);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setAudioFadeOut(int i, com.aliyun.svideosdk.editor.ShapeType shapeType, long j) {
        if (!this.p) {
            return -4;
        }
        if (shapeType == null) {
            return -2;
        }
        if (!i()) {
            return -20011019;
        }
        int i2 = shapeType == com.aliyun.svideosdk.editor.ShapeType.SHAPE_TYPE_LINEAR ? 1 : 3;
        com.aliyun.svideosdk.common.struct.project.AudioFade audioFade = new com.aliyun.svideosdk.common.struct.project.AudioFade(shapeType.ordinal(), j / 1000.0f, false);
        this.i.removeEffect(i, audioFade);
        this.i.addEffect(i, audioFade);
        return this.a.setAudioFadeInFadeOut(i, i2, j, false);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setAudioSilence(boolean z) {
        this.q.sendSilenceEvent(z);
        a(z);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setDisplayMode(com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        if (!this.p) {
            return -4;
        }
        if (videoDisplayMode == null) {
            return -20003002;
        }
        this.k = videoDisplayMode;
        this.q.sendDisplayModeEvent(videoDisplayMode);
        this.i.getConfig().setDisplayMode(videoDisplayMode.getDisplayMode());
        return this.a.setDisplayMode(videoDisplayMode.getDisplayMode());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setDisplayView(android.view.SurfaceView surfaceView) {
        int i;
        java.lang.String str;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setDisplayView");
        if (!this.p) {
            str = "Editor not initialized, setDisplayView SurfaceView failed.";
        } else {
            if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
                this.q.sendSetDisplayViewEvent();
                if (surfaceView == null) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "SurfaceView is null");
                    return -2;
                }
                android.view.Surface surface = surfaceView.getHolder().getSurface();
                if (surface == null || !surface.isValid()) {
                    i = 0;
                } else {
                    this.l = surface;
                    i = this.a.setDisplay(surface);
                }
                this.C = null;
                android.view.SurfaceView surfaceView2 = this.B;
                if (surfaceView2 != null) {
                    surfaceView2.getHolder().removeCallback(this.H);
                }
                this.B = surfaceView;
                surfaceView.getHolder().addCallback(this.H);
                return i;
            }
            str = "compose mode not support set display view";
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
        return -4;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setDisplayView(android.view.TextureView textureView) {
        int i;
        java.lang.String str;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setDisplayView");
        if (!this.p) {
            str = "Editor not initialized, setDisplayView TextureView failed.";
        } else {
            if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
                this.q.sendSetDisplayViewEvent();
                if (textureView == null) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "SurfaceView is null");
                    return -2;
                }
                android.view.Surface surface = new android.view.Surface(textureView.getSurfaceTexture());
                if (surface.isValid()) {
                    this.l = surface;
                    i = this.a.setDisplay(surface);
                    this.C = textureView;
                } else {
                    i = 0;
                }
                android.view.SurfaceView surfaceView = this.B;
                if (surfaceView != null) {
                    surfaceView.getHolder().removeCallback(this.H);
                    this.B = null;
                }
                return i;
            }
            str = "compose mode not support set display view";
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
        return -4;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setFillBackgroundColor(int i) {
        if (!this.p) {
            return -4;
        }
        this.i.getConfig().setBackgroundColor(i);
        this.q.sendSetFillBackgroundColorEvent(i);
        return this.a.setFillBackgroundColor(i);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setHorizontalFlip(int i, boolean z) {
        int horizontalFlip = !this.p ? -20011019 : this.a.setHorizontalFlip(i, z);
        if (horizontalFlip == 0) {
            java.util.Iterator<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> it = this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.aliyun.svideosdk.common.struct.project.VideoTrackClip next = it.next();
                if (next.getClipId() == i) {
                    next.setHorizontalFlip(z);
                    break;
                }
            }
        }
        return horizontalFlip;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setMonitorSurfaceChange(boolean z) {
        if (this.p) {
            return;
        }
        this.m = z;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setOnAnimationRestoredListener(com.aliyun.svideosdk.editor.OnAnimationFilterRestoredListener onAnimationFilterRestoredListener) {
        this.A = onAnimationFilterRestoredListener;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setOutputPath(java.lang.String str) {
        this.f = str;
        if (i()) {
            this.q.sendSetOutputPathEvent(str);
            this.a.setOutputPath(this.f);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setTransition(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        if (!this.p) {
            return -20011019;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(java.lang.Integer.valueOf(i), transitionBase);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setTransition  params : ");
        sb.append(transitionBase == null ? null : transitionBase.toJsonString());
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", sb.toString());
        this.q.sendSetTransitionEvent(i, transitionBase);
        return a(hashMap);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setTransition(java.util.Map<java.lang.Integer, com.aliyun.svideosdk.common.struct.effect.TransitionBase> map) {
        if (!this.p) {
            return -20011019;
        }
        if (map == null) {
            return -2;
        }
        this.q.sendSetTransitionsEvent();
        return a(map);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setVideoAugmentation(int i, com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType, float f) {
        if (!this.p) {
            return -4;
        }
        int i2 = com.aliyun.svideosdk.editor.impl.g.e.a[videoAugmentationType.ordinal()];
        if (i2 == 1) {
            return a(i, f);
        }
        if (i2 == 2) {
            return b(i, f);
        }
        if (i2 == 3) {
            return c(i, f);
        }
        if (i2 == 4) {
            return d(i, f);
        }
        if (i2 != 5) {
            return -4;
        }
        return e(i, f);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setVolume(int i) {
        if (!i()) {
            return -20011019;
        }
        this.q.sendVolumeEvent(i);
        int volume = this.a.setVolume(i);
        this.i.getConfig().setVolume(i);
        return volume;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int stop() {
        if (!this.p) {
            return -4;
        }
        if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
            return 0;
        }
        if (!i() || j()) {
            return -20011019;
        }
        this.q.sendStopEvent();
        a(4);
        return this.a.stop();
    }

    public void t() {
        if (this.i.getTimeline().getVideoTracks() == null || this.i.getTimeline().getVideoTracks().isEmpty()) {
            return;
        }
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            this.a.setBrightness(videoTrackClip.getClipId(), videoTrackClip.getBrightness());
            this.a.setContrast(videoTrackClip.getClipId(), videoTrackClip.getContrast());
            this.a.setSaturation(videoTrackClip.getClipId(), videoTrackClip.getSaturation());
            this.a.setSharpness(videoTrackClip.getClipId(), videoTrackClip.getSharpness());
            this.a.setVignette(videoTrackClip.getClipId(), videoTrackClip.getVignette());
        }
    }

    public void u() {
        for (com.aliyun.svideosdk.common.struct.project.VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip instanceof com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip) {
                for (com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase : ((com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip) videoTrackClip).getActions()) {
                    actionBase.setIsStream(true);
                    actionBase.setTargetId(videoTrackClip.getClipId());
                    this.a.addFrameAnimation(videoTrackClip.getClipId(), actionBase);
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        return updateAnimationFilter(effectFilter.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter trackEffectFilter) {
        this.q.sendUpdateAnimationFilterEvent(trackEffectFilter);
        return this.t.e(trackEffectFilter);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption) {
        return this.a.updateCaption(aliyunCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void updateCover(com.aliyun.svideosdk.common.struct.project.Source source) {
        if (source == null) {
            this.i.setCustomCover(false);
            return;
        }
        if (source.getPath() == null || !new java.io.File(source.getPath()).exists()) {
            return;
        }
        java.io.File file = new java.io.File(source.getPath());
        java.lang.String str = this.i.getProjectDir().getAbsolutePath() + java.io.File.separator + "cover.jpeg";
        java.io.File file2 = new java.io.File(str);
        try {
            if (file.getPath().endsWith(file2.getPath())) {
                this.i.setCover(source);
            } else {
                com.aliyun.common.utils.FileUtils.copyFile(file, file2);
                com.aliyun.svideosdk.common.struct.project.Source source2 = new com.aliyun.svideosdk.common.struct.project.Source(str);
                source2.setURL(source.getURL());
                this.i.setCover(source2);
            }
            this.i.setCustomCover(true);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateTransition(int i, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
        int i2;
        if (!this.p) {
            return -20011019;
        }
        java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> videoTrackClips = this.i.getTimeline().getPrimaryTrack().getVideoTrackClips();
        if (i < 0 || (i2 = i + 1) >= videoTrackClips.size()) {
            return -20011022;
        }
        int clipId = videoTrackClips.get(i2).getClipId();
        this.q.sendSetTransitionEvent(i, transitionBase);
        return this.t.a(clipId, transitionBase);
    }

    public void v() {
        com.aliyun.svideosdk.common.struct.project.WaterMark waterMark = this.i.getWaterMark();
        if (waterMark != null) {
            waterMark.setId(this.t.setEffectWaterMark(a(waterMark)));
            java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.ActionBase> it = waterMark.getActions().iterator();
            while (it.hasNext()) {
                com.aliyun.svideosdk.common.struct.effect.ActionBase next = it.next();
                next.setTargetId(waterMark.getId());
                next.setId(this.a.addFrameAnimation(next.getTargetId(), next));
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public java.lang.String version() {
        return com.aliyun.common.global.Version.VERSION;
    }
}
