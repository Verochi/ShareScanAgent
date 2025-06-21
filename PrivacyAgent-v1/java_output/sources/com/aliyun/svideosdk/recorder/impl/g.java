package com.aliyun.svideosdk.recorder.impl;

/* loaded from: classes12.dex */
public class g extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader implements com.aliyun.svideosdk.recorder.AliyunIRecorder, android.view.SurfaceHolder.Callback, com.aliyun.svideosdk.recorder.impl.d {
    private volatile android.view.SurfaceView A;
    private byte[] D;
    private com.aliyun.common.log.reporter.AlivcRecorderReporter F;
    private android.view.ViewTreeObserver.OnDrawListener G;
    private com.aliyun.svideosdk.recorder.impl.f H;
    private com.aliyun.svideosdk.common.AliyunRecordVideoSource K;
    private com.aliyun.svideosdk.common.AliyunRecordAVSource L;
    private final com.aliyun.svideosdk.preview.utils.CameraVersion.Version a;
    private final com.aliyun.svideosdk.preview.camera.g b;
    private com.aliyun.svideosdk.a.e.a c;
    private com.aliyun.svideosdk.recorder.NativeRecorder d;
    private com.aliyun.svideosdk.recorder.impl.e e;
    private com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback h;
    private boolean i;
    private int k;
    private com.aliyun.svideosdk.facearengine.FaceAREngine m;
    private com.aliyun.common.log.struct.AliyunLogInfo n;
    private android.view.WindowManager o;
    private int p;
    private com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener q;
    private com.aliyun.svideosdk.common.struct.recorder.MediaInfo r;
    private int t;
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.effect.EffectBase> f = new java.util.concurrent.CopyOnWriteArrayList<>();
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.effect.EffectBase> g = new java.util.concurrent.CopyOnWriteArrayList<>();
    private boolean j = false;
    private int l = -1;

    /* renamed from: s, reason: collision with root package name */
    private int f104s = 3;
    private boolean u = false;
    private int v = 50;
    private final java.lang.Object w = new java.lang.Object();
    private final java.lang.Object x = new java.lang.Object();
    private boolean y = false;
    private java.util.List<android.view.SurfaceView> z = new java.util.ArrayList();
    private float B = 1.0f;
    private java.lang.String C = null;
    private java.lang.String E = null;
    private boolean I = false;
    private boolean J = false;
    private com.aliyun.svideosdk.a.a M = new com.aliyun.svideosdk.recorder.impl.g.a();

    public class a implements com.aliyun.svideosdk.a.a {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00e9 A[Catch: all -> 0x0244, TryCatch #0 {, blocks: (B:26:0x0094, B:28:0x009c, B:30:0x009e, B:32:0x00a4, B:35:0x00e1, B:37:0x00e9, B:38:0x00f2, B:40:0x0100, B:41:0x010f, B:43:0x0138, B:45:0x015f, B:47:0x016b, B:49:0x0171, B:51:0x0212, B:55:0x021a, B:57:0x0227, B:59:0x022f, B:60:0x0242, B:62:0x00c0, B:64:0x00c8, B:66:0x00d0, B:67:0x00df, B:68:0x00d3), top: B:25:0x0094 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0100 A[Catch: all -> 0x0244, TryCatch #0 {, blocks: (B:26:0x0094, B:28:0x009c, B:30:0x009e, B:32:0x00a4, B:35:0x00e1, B:37:0x00e9, B:38:0x00f2, B:40:0x0100, B:41:0x010f, B:43:0x0138, B:45:0x015f, B:47:0x016b, B:49:0x0171, B:51:0x0212, B:55:0x021a, B:57:0x0227, B:59:0x022f, B:60:0x0242, B:62:0x00c0, B:64:0x00c8, B:66:0x00d0, B:67:0x00df, B:68:0x00d3), top: B:25:0x0094 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x015f A[Catch: all -> 0x0244, TryCatch #0 {, blocks: (B:26:0x0094, B:28:0x009c, B:30:0x009e, B:32:0x00a4, B:35:0x00e1, B:37:0x00e9, B:38:0x00f2, B:40:0x0100, B:41:0x010f, B:43:0x0138, B:45:0x015f, B:47:0x016b, B:49:0x0171, B:51:0x0212, B:55:0x021a, B:57:0x0227, B:59:0x022f, B:60:0x0242, B:62:0x00c0, B:64:0x00c8, B:66:0x00d0, B:67:0x00df, B:68:0x00d3), top: B:25:0x0094 }] */
        @Override // com.aliyun.svideosdk.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onFrameBack(byte[] bArr, int i, int i2, android.hardware.Camera.CameraInfo cameraInfo) {
            int i3;
            int i4;
            int faceCount;
            int i5;
            if (!com.aliyun.svideosdk.recorder.impl.g.this.i || !com.aliyun.svideosdk.recorder.impl.g.this.j || com.aliyun.svideosdk.recorder.impl.g.this.u || com.aliyun.svideosdk.recorder.impl.g.this.y) {
                return;
            }
            char c = 0;
            if (com.aliyun.svideosdk.recorder.impl.g.this.f.size() == 0) {
                com.aliyun.svideosdk.recorder.impl.g.this.p = 0;
                return;
            }
            char c2 = 1;
            if (com.aliyun.svideosdk.recorder.impl.g.this.m == null && com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
                com.aliyun.svideosdk.recorder.impl.g.this.m = new com.aliyun.svideosdk.facearengine.FaceAREngine();
                int init = com.aliyun.svideosdk.recorder.impl.g.this.m.init(com.aliyun.svideosdk.recorder.impl.g.this.D, i, i2, 0);
                com.aliyun.svideosdk.recorder.impl.g.this.D = null;
                if (init != 0) {
                    com.aliyun.svideosdk.recorder.impl.g.this.m.release();
                    com.aliyun.svideosdk.recorder.impl.g.this.m = null;
                    com.aliyun.svideosdk.recorder.impl.g.this.y = true;
                    return;
                }
                com.aliyun.svideosdk.recorder.impl.g.this.m.switchFaceDetect(true);
            }
            synchronized (com.aliyun.svideosdk.recorder.impl.g.this.w) {
                if (com.aliyun.svideosdk.recorder.impl.g.this.m == null) {
                    return;
                }
                if (1 == cameraInfo.facing) {
                    int abs = java.lang.Math.abs(270 - cameraInfo.orientation);
                    i4 = ((cameraInfo.orientation + (com.aliyun.svideosdk.recorder.impl.g.this.k - 270)) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                    if ((abs == 90 || abs == 270) && (com.aliyun.svideosdk.recorder.impl.g.this.k == 90 || com.aliyun.svideosdk.recorder.impl.g.this.k == 270)) {
                        i3 = i4 + 180;
                    }
                    if (com.aliyun.svideosdk.recorder.impl.g.this.l != i4) {
                        com.aliyun.svideosdk.recorder.impl.g.this.m.setRenderRotationAndSize(i4, i, i2);
                    }
                    if (com.aliyun.svideosdk.recorder.impl.g.this.t != com.aliyun.svideosdk.recorder.impl.g.this.f104s) {
                        com.aliyun.svideosdk.recorder.impl.g.this.m.setMaxFaceCount(com.aliyun.svideosdk.recorder.impl.g.this.f104s);
                    }
                    com.aliyun.svideosdk.recorder.impl.g.this.l = i4;
                    com.aliyun.svideosdk.recorder.impl.g gVar = com.aliyun.svideosdk.recorder.impl.g.this;
                    gVar.t = gVar.f104s;
                    com.aliyun.svideosdk.recorder.impl.g.this.m.renderVideoData(bArr, i, i2);
                    com.aliyun.svideosdk.facearengine.FaceAROrganLocation faceOrganLocation = com.aliyun.svideosdk.recorder.impl.g.this.m.getFaceOrganLocation();
                    faceCount = faceOrganLocation.getFaceCount();
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "face detect result " + faceCount);
                    int i6 = 6;
                    float[][] fArr = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, faceCount, 6);
                    i5 = 0;
                    while (i5 < faceCount) {
                        com.aliyun.svideosdk.facearengine.FaceARFaceResult faceARFaceResult = faceOrganLocation.mFacePonits.get(i5);
                        java.util.ArrayList<com.aliyun.svideosdk.facearengine.FaceARPoint2D> arrayList = faceARFaceResult.mFace2D;
                        if (arrayList != null && arrayList.size() != 0) {
                            float f = i;
                            fArr[i5][c] = ((faceARFaceResult.mFace2D.get(i6).x + faceARFaceResult.mFace2D.get(7).x) / 2.0f) / f;
                            float f2 = i2;
                            fArr[i5][c2] = ((faceARFaceResult.mFace2D.get(8).y + faceARFaceResult.mFace2D.get(9).y) / 2.0f) / f2;
                            fArr[i5][2] = ((faceARFaceResult.mFace2D.get(14).x + faceARFaceResult.mFace2D.get(15).x) / 2.0f) / f;
                            fArr[i5][3] = ((faceARFaceResult.mFace2D.get(16).y + faceARFaceResult.mFace2D.get(17).y) / 2.0f) / f2;
                            fArr[i5][4] = faceARFaceResult.mFace2D.get(37).x / f;
                            fArr[i5][5] = faceARFaceResult.mFace2D.get(37).y / f2;
                        }
                        i5++;
                        c = 0;
                        c2 = 1;
                        i6 = 6;
                    }
                    com.aliyun.svideosdk.recorder.impl.g.this.setFaces(fArr);
                    if (com.aliyun.svideosdk.recorder.impl.g.this.p != faceCount && com.aliyun.svideosdk.recorder.impl.g.this.q != null) {
                        com.aliyun.svideosdk.recorder.impl.g.this.p = faceCount;
                        com.aliyun.svideosdk.recorder.impl.g.this.q.onFaceInfoChange(new com.aliyun.svideosdk.common.struct.recorder.FaceDetectInfo(faceCount));
                    }
                }
                i3 = cameraInfo.orientation + (com.aliyun.svideosdk.recorder.impl.g.this.k - 90) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                i4 = i3 % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                if (com.aliyun.svideosdk.recorder.impl.g.this.l != i4) {
                }
                if (com.aliyun.svideosdk.recorder.impl.g.this.t != com.aliyun.svideosdk.recorder.impl.g.this.f104s) {
                }
                com.aliyun.svideosdk.recorder.impl.g.this.l = i4;
                com.aliyun.svideosdk.recorder.impl.g gVar2 = com.aliyun.svideosdk.recorder.impl.g.this;
                gVar2.t = gVar2.f104s;
                com.aliyun.svideosdk.recorder.impl.g.this.m.renderVideoData(bArr, i, i2);
                com.aliyun.svideosdk.facearengine.FaceAROrganLocation faceOrganLocation2 = com.aliyun.svideosdk.recorder.impl.g.this.m.getFaceOrganLocation();
                faceCount = faceOrganLocation2.getFaceCount();
                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "face detect result " + faceCount);
                int i62 = 6;
                float[][] fArr2 = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, faceCount, 6);
                i5 = 0;
                while (i5 < faceCount) {
                }
                com.aliyun.svideosdk.recorder.impl.g.this.setFaces(fArr2);
                if (com.aliyun.svideosdk.recorder.impl.g.this.p != faceCount) {
                    com.aliyun.svideosdk.recorder.impl.g.this.p = faceCount;
                    com.aliyun.svideosdk.recorder.impl.g.this.q.onFaceInfoChange(new com.aliyun.svideosdk.common.struct.recorder.FaceDetectInfo(faceCount));
                }
            }
        }
    }

    public class b implements com.aliyun.svideosdk.a.c {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback b;

        public class a implements java.lang.Runnable {
            final /* synthetic */ byte[] a;

            public a(byte[] bArr) {
                this.a = bArr;
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[Catch: all -> 0x00ae, TryCatch #1 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0012, B:12:0x002e, B:15:0x0046, B:17:0x0056, B:19:0x0078, B:21:0x007e, B:22:0x00ac, B:26:0x0084, B:28:0x008e, B:30:0x009f, B:33:0x005d, B:36:0x003e), top: B:3:0x0005, inners: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0084 A[Catch: all -> 0x00ae, TryCatch #1 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000f, B:10:0x0012, B:12:0x002e, B:15:0x0046, B:17:0x0056, B:19:0x0078, B:21:0x007e, B:22:0x00ac, B:26:0x0084, B:28:0x008e, B:30:0x009f, B:33:0x005d, B:36:0x003e), top: B:3:0x0005, inners: #0 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                android.graphics.Bitmap bitmap;
                android.graphics.Bitmap bitmap2;
                com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback;
                byte[] bArr;
                synchronized (com.aliyun.svideosdk.recorder.impl.g.this) {
                    if (!com.aliyun.svideosdk.recorder.impl.g.b.this.a || (bArr = this.a) == null || bArr.length <= 0) {
                        bitmap = null;
                    } else {
                        bitmap = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        android.hardware.Camera.CameraInfo c = com.aliyun.svideosdk.recorder.impl.g.this.b.c();
                        android.graphics.Matrix matrix = new android.graphics.Matrix();
                        int i = c.facing;
                        if (i == 1) {
                            matrix.postRotate(c.orientation);
                            matrix.postScale(-1.0f, 1.0f);
                        } else if (i == 0) {
                            matrix.postRotate(c.orientation);
                        }
                        try {
                            bitmap2 = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            if (bitmap2 != bitmap) {
                                bitmap.recycle();
                            }
                        } catch (java.lang.OutOfMemoryError e) {
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Create bitmap failed!" + e.getMessage());
                        }
                        com.aliyun.svideosdk.recorder.impl.g.b bVar = com.aliyun.svideosdk.recorder.impl.g.b.this;
                        onPictureCallback = bVar.b;
                        if (onPictureCallback == null) {
                            onPictureCallback.onPicture(bitmap2, this.a);
                        } else if (com.aliyun.svideosdk.recorder.impl.g.this.h instanceof com.aliyun.svideosdk.recorder.RecordCallback) {
                            ((com.aliyun.svideosdk.recorder.RecordCallback) com.aliyun.svideosdk.recorder.impl.g.this.h).onPictureDataBack(this.a);
                            if (bitmap2 != null) {
                                ((com.aliyun.svideosdk.recorder.RecordCallback) com.aliyun.svideosdk.recorder.impl.g.this.h).onPictureBack(bitmap2);
                            }
                        }
                    }
                    bitmap2 = bitmap;
                    com.aliyun.svideosdk.recorder.impl.g.b bVar2 = com.aliyun.svideosdk.recorder.impl.g.b.this;
                    onPictureCallback = bVar2.b;
                    if (onPictureCallback == null) {
                    }
                }
            }
        }

        public b(boolean z, com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback) {
            this.a = z;
            this.b = onPictureCallback;
        }

        @Override // com.aliyun.svideosdk.a.c
        public void a(byte[] bArr) {
            java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.aliyun.svideosdk.recorder.impl.g.b.a(bArr));
        }

        @Override // com.aliyun.svideosdk.a.c
        public void onShutter() {
        }
    }

    public class c implements com.aliyun.svideosdk.a.b {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback b;

        public c(boolean z, com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback) {
            this.a = z;
            this.b = onPictureCallback;
        }

        @Override // com.aliyun.svideosdk.a.b
        public void a(int i, int i2, android.hardware.Camera.CameraInfo cameraInfo, java.nio.ByteBuffer byteBuffer) {
            android.graphics.Bitmap bitmap;
            if (!this.a || i == 0 || i2 == 0) {
                bitmap = null;
            } else {
                android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
                byteBuffer.rewind();
                createBitmap.copyPixelsFromBuffer(byteBuffer);
                com.aliyun.svideosdk.recorder.impl.g gVar = com.aliyun.svideosdk.recorder.impl.g.this;
                bitmap = gVar.a(createBitmap, gVar.a(cameraInfo));
            }
            com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback = this.b;
            if (onPictureCallback != null) {
                onPictureCallback.onPicture(bitmap, byteBuffer.array());
            } else if (com.aliyun.svideosdk.recorder.impl.g.this.h instanceof com.aliyun.svideosdk.recorder.RecordCallback) {
                ((com.aliyun.svideosdk.recorder.RecordCallback) com.aliyun.svideosdk.recorder.impl.g.this.h).onPictureDataBack(byteBuffer.array());
                if (bitmap != null) {
                    ((com.aliyun.svideosdk.recorder.RecordCallback) com.aliyun.svideosdk.recorder.impl.g.this.h).onPictureBack(bitmap);
                }
            }
        }
    }

    public class d implements android.view.ViewTreeObserver.OnDrawListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        public class a implements java.lang.Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                android.view.SurfaceView surfaceView = com.aliyun.svideosdk.recorder.impl.g.this.A;
                if (surfaceView != null) {
                    surfaceView.getViewTreeObserver().removeOnDrawListener(com.aliyun.svideosdk.recorder.impl.g.this.G);
                }
            }
        }

        public class b implements java.lang.Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                android.view.SurfaceView surfaceView = com.aliyun.svideosdk.recorder.impl.g.this.A;
                if (surfaceView != null) {
                    android.view.SurfaceHolder holder = surfaceView.getHolder();
                    com.aliyun.svideosdk.recorder.impl.g.d dVar = com.aliyun.svideosdk.recorder.impl.g.d.this;
                    holder.setFixedSize(dVar.a, dVar.b);
                }
            }
        }

        public d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (com.aliyun.svideosdk.recorder.impl.g.this.G != null) {
                com.aliyun.svideosdk.recorder.impl.g.this.A.post(new com.aliyun.svideosdk.recorder.impl.g.d.a());
                com.aliyun.svideosdk.recorder.impl.g.this.A.postDelayed(new com.aliyun.svideosdk.recorder.impl.g.d.b(), 100L);
            }
        }
    }

    public static /* synthetic */ class e {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType.values().length];
            a = iArr;
            try {
                iArr[com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType.STICKER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType.FACE_STICKER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType.WATERMARK.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
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
    }

    public g(android.content.Context context, com.aliyun.svideosdk.preview.utils.CameraVersion.Version version) {
        this.F = new com.aliyun.common.log.reporter.AlivcRecorderReporter(context.getApplicationContext());
        com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder = new com.aliyun.svideosdk.recorder.NativeRecorder(this.F.getReportId());
        this.d = nativeRecorder;
        this.c = new com.aliyun.svideosdk.a.e.a(this.F, nativeRecorder);
        com.aliyun.svideosdk.common.AliyunRecordVideoSource createVideoWithInfo = com.aliyun.svideosdk.common.AliyunRecordVideoSource.createVideoWithInfo(1, 1);
        createVideoWithInfo.setVideoNeedRender(true);
        createVideoWithInfo.setVideoNeedOutput(true);
        a(createVideoWithInfo);
        this.d.addSource(createVideoWithInfo);
        this.c.a(createVideoWithInfo);
        this.a = version;
        this.b = com.aliyun.svideosdk.preview.camera.e.a(context, this.c, this.F, version);
        this.o = (android.view.WindowManager) context.getApplicationContext().getSystemService("window");
        this.n = new com.aliyun.common.log.struct.AliyunLogInfo(com.aliyun.svideosdk.recorder.impl.g.class.getName());
        this.e = new com.aliyun.svideosdk.recorder.impl.e(context.getApplicationContext(), this.F, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001f, code lost:
    
        if (r7 != 180) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r7 != 270) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(android.hardware.Camera.CameraInfo cameraInfo) {
        int i = cameraInfo.facing;
        int i2 = 270;
        if (i == 1) {
            int i3 = cameraInfo.orientation;
            if (i3 != 0) {
                if (i3 != 90) {
                    if (i3 != 180) {
                    }
                    i2 = 90;
                }
                i2 = 0;
            }
        } else {
            if (i == 0) {
                int i4 = cameraInfo.orientation;
                if (i4 != 0) {
                    if (i4 != 90) {
                    }
                    i2 = 180;
                }
            }
            i2 = 0;
        }
        return i2 + this.b.a();
    }

    private int a(com.aliyun.svideosdk.common.struct.effect.EffectSticker effectSticker, boolean z) {
        if (effectSticker == null || effectSticker.getPath() == null || !new java.io.File(effectSticker.getPath()).exists()) {
            return -20001003;
        }
        int a2 = com.aliyun.svideosdk.common.a.a(this.c.a(effectSticker.getPath(), effectSticker.getResId(), effectSticker.getXRadio(), effectSticker.getYRadio(), effectSticker.getWidthRatio(), effectSticker.getHeightRatio(), effectSticker.getRotation(), effectSticker.isFlipH(), 0L, z ? 1 : 0));
        if (a2 == 0 && z) {
            this.f.add(effectSticker);
            this.b.a(false);
        }
        this.F.sendAddPasterEvent(effectSticker, this.i, this.C, this.k);
        return a2;
    }

    private int a(com.aliyun.svideosdk.common.struct.effect.EffectStream effectStream) {
        return (effectStream == null || effectStream.getSource() == null || android.text.TextUtils.isEmpty(effectStream.getSource().getPath())) ? this.e.a(null, 0L, 0L, true) : this.e.a(effectStream.getSource().getPath(), effectStream.getStreamStartTime() * 1000, 1000 * effectStream.getStreamDuration(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(i);
        matrix.postScale(-1.0f, 1.0f);
        try {
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (java.lang.OutOfMemoryError e2) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Create bitmap failed!" + e2.getMessage());
            return bitmap;
        }
    }

    private void a(com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo, float f) {
        if (java.lang.Float.compare((mediaInfo.getVideoWidth() * 1.0f) / mediaInfo.getVideoHeight(), f) == 0) {
            return;
        }
        int round = java.lang.Math.round(mediaInfo.getVideoWidth() / f);
        if (round % 2 != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("The preview height must be even, so auto correct preview height from ");
            sb.append(round);
            sb.append(" to ");
            round--;
            sb.append(round);
            com.aliyun.common.log.debuglog.AlivcSvideoLog.w("AliYunLog", sb.toString());
        }
        mediaInfo.setVideoHeight(round);
    }

    private void b(com.aliyun.svideosdk.common.struct.effect.EffectSticker effectSticker, boolean z) {
        if (effectSticker == null) {
            return;
        }
        if (z) {
            synchronized (this.x) {
                java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.EffectBase> it = this.g.iterator();
                while (it.hasNext()) {
                    this.c.a(it.next().getResId());
                }
                this.g.clear();
                this.f.remove(effectSticker);
                if (this.f.size() == 0) {
                    this.b.a(true);
                }
                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "size = " + this.f.size());
            }
        }
        this.F.sendRemovePasterEvent(effectSticker.getResId());
        this.c.a(effectSticker.getResId());
    }

    public com.aliyun.svideosdk.common.AliyunRecordVideoSource a() {
        return this.L;
    }

    public void a(int i) {
        this.e.b(i);
    }

    public void a(com.aliyun.svideosdk.common.AliyunRecordAVSource aliyunRecordAVSource) {
        this.L = aliyunRecordAVSource;
        this.e.a(aliyunRecordAVSource);
    }

    public void a(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource) {
        this.K = aliyunRecordVideoSource;
    }

    @Override // com.aliyun.svideosdk.recorder.impl.d
    public void a(com.aliyun.svideosdk.recorder.impl.a aVar) {
        int i = com.aliyun.svideosdk.recorder.impl.g.e.a[aVar.getType().ordinal()];
        if (i == 1) {
            a(((com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController) aVar).getModel(), false);
        } else if (i == 2) {
            a(((com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController) aVar).getModel(), true);
        } else {
            if (i != 3) {
                return;
            }
            addImage(((com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController) aVar).getModel());
        }
    }

    public void a(boolean z) {
        this.J = z;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int addImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        int a2;
        if (effectImage == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        android.graphics.Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null) {
            a2 = this.c.a(effectImage.getResId(), bitmap, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation());
        } else {
            if (effectImage.getPath() == null || !new java.io.File(effectImage.getPath()).exists()) {
                return -20003013;
            }
            a2 = this.c.a(effectImage.getResId(), effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation());
        }
        this.F.sendAddImageEvent(effectImage, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation());
        return com.aliyun.svideosdk.common.a.a(a2);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        if (effectPaster != null) {
            return a(effectPaster.toEffectSticker(), effectPaster.isTrack);
        }
        return -20001003;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z) {
        if (effectPaster == null || effectPaster.getPath() == null || !new java.io.File(effectPaster.getPath()).exists()) {
            return -20001003;
        }
        return a(effectPaster.toEffectSticker(), effectPaster.isTrack);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int applyAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null || !(effectFilter.getSource() == null || effectFilter.getSource().getPath() == null || new java.io.File(effectFilter.getSource().getPath()).exists())) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "EffectFilter resource not exist!");
            return -20003002;
        }
        java.lang.String jsonString = effectFilter.toJsonString();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "applyAnimationFilter params : " + jsonString);
        java.lang.String path = effectFilter.getSource() == null ? null : effectFilter.getSource().getPath();
        int a2 = com.aliyun.svideosdk.common.a.a(this.c.b(path, jsonString));
        effectFilter.setViewId(a2);
        this.F.sendApplyAnimationFilterEvent(path, effectFilter.getViewId());
        return java.lang.Math.min(a2, 0);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int applyBackgroundMusic(com.aliyun.svideosdk.common.struct.effect.EffectStream effectStream) {
        java.lang.String path = effectStream.getSource().getPath();
        long streamStartTime = effectStream.getStreamStartTime();
        long streamDuration = effectStream.getStreamDuration();
        this.F.sendSetMusicEvent(path, effectStream.getStreamStartTime(), effectStream.getStreamDuration());
        if (path != null) {
            if (!new java.io.File(path).exists()) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "setMusic  error, music filepath = " + path + " is not exit.");
                return -20001003;
            }
            if (0 == streamDuration || streamStartTime < 0) {
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "setMusic error, music duration  = " + streamDuration + ",  startTime = " + streamStartTime);
                return -20001007;
            }
            if (effectStream.getDuration() == 0) {
                return -20001008;
            }
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "apply music startTime " + streamStartTime + ", duration " + streamDuration);
        return a(effectStream);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null || !(effectFilter.getSource() == null || effectFilter.getSource().getPath() == null || new java.io.File(effectFilter.getSource().getPath()).exists())) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "applyFilter, ALIVC_SVIDEO_ERROR_PARAM_FILTER_FILE_PATH_INVALID = -20003014");
            return -20003014;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "applyFilter ");
        java.lang.String path = effectFilter.getSource() == null ? null : effectFilter.getSource().getPath();
        this.F.sendApplyFilterEvent(path);
        return com.aliyun.svideosdk.common.a.a(this.c.a(path));
    }

    public com.aliyun.svideosdk.recorder.NativeRecorder b() {
        return this.d;
    }

    @Override // com.aliyun.svideosdk.recorder.impl.d
    public void b(com.aliyun.svideosdk.recorder.impl.a aVar) {
        int i = com.aliyun.svideosdk.recorder.impl.g.e.a[aVar.getType().ordinal()];
        if (i == 1) {
            b(((com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController) aVar).getModel(), false);
        } else if (i == 2) {
            b(((com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController) aVar).getModel(), true);
        } else {
            if (i != 3) {
                return;
            }
            removeImage(((com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController) aVar).getModel());
        }
    }

    public com.aliyun.svideosdk.common.AliyunRecordVideoSource c() {
        return this.K;
    }

    @Override // com.aliyun.svideosdk.recorder.impl.d
    public void c(com.aliyun.svideosdk.recorder.impl.a aVar) {
        com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController aliyunRecordPasterController;
        com.aliyun.svideosdk.common.struct.effect.EffectSticker model;
        int i = com.aliyun.svideosdk.recorder.impl.g.e.a[aVar.getType().ordinal()];
        boolean z = true;
        if (i == 1) {
            aliyunRecordPasterController = (com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController) aVar;
            model = aliyunRecordPasterController.getModel();
            z = false;
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController aliyunRecordWaterMarkController = (com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController) aVar;
                removeImage(aliyunRecordWaterMarkController.getModel());
                addImage(aliyunRecordWaterMarkController.getModel());
                return;
            }
            aliyunRecordPasterController = (com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController) aVar;
            model = aliyunRecordPasterController.getModel();
        }
        b(model, z);
        a(aliyunRecordPasterController.getModel(), z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void cancelRecording() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "cancelRecording ");
        this.e.a();
        this.c.l();
        com.aliyun.svideosdk.a.d.a i = this.c.i();
        this.c.f();
        com.aliyun.svideosdk.a.d.a g = this.c.g();
        com.aliyun.svideosdk.a.d.a k = this.c.k();
        com.aliyun.svideosdk.a.d.a e2 = this.c.e();
        this.F.sendCancelRecordingEvent(this.E, i.d(), i.h(), g.d(), g.h(), k.d(), k.h(), e2.d(), e2.h(), i.i(), i.g(), i.e());
    }

    public com.aliyun.common.log.reporter.AlivcRecorderReporter d() {
        return this.F;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void destroy() {
        release();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int finishRecording() {
        int a2;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "finishRecording ");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        a2 = com.aliyun.svideosdk.common.a.a(this.e.b());
        this.F.sendFinishRecordingEvent(java.lang.System.currentTimeMillis() - currentTimeMillis);
        return a2;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public android.net.Uri finishRecordingForEdit() {
        if (this.F != null) {
            this.e.c().a(this.F.getRequestId());
        }
        return this.e.c().c();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public com.aliyun.common.log.struct.AliyunLogInfo getAliyunLogInfo() {
        return this.n;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int getBeautyLevel() {
        return this.v;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int getCameraCount() {
        return this.b.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public com.aliyun.svideosdk.recorder.AliyunIClipManager getClipManager() {
        return this.e.c();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public float getCurrentExposureCompensationRatio() {
        return this.b.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager getPasterManager() {
        if (this.H == null) {
            this.H = new com.aliyun.svideosdk.recorder.impl.f(this);
        }
        return this.H;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public java.util.List<android.hardware.Camera.Size> getSupportedPictureSize() {
        return this.b.getSupportedPictureSize();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes() {
        return this.b.getSupportedPictureSizes();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void needFaceTrackInternal(boolean z) {
        this.i = z;
        this.F.sendNeedFaceTrackInternalEvent(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void release() {
        this.F.sendDestroyEvent();
        this.c.o();
        stopRecording();
        stopPreview();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "Recorder destroy");
        this.u = true;
        this.b.setOnFrameCallback(null);
        this.b.a((com.aliyun.svideosdk.a.a) null);
        this.e.a((com.aliyun.svideosdk.recorder.impl.e.d) null);
        this.e.a((com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback) null);
        this.h = null;
        if (this.I) {
            getClipManager().deleteAllPart();
        }
        this.c.n();
        this.d.removeSource(this.K);
        this.K.release();
        this.e.i();
        this.b.release();
        synchronized (this.w) {
            com.aliyun.svideosdk.facearengine.FaceAREngine faceAREngine = this.m;
            if (faceAREngine != null) {
                faceAREngine.release();
                this.m = null;
            }
        }
        java.util.Iterator<android.view.SurfaceView> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().getHolder().removeCallback(this);
        }
        this.D = null;
        this.z.clear();
        this.A = null;
        this.c.a((com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback) null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter != null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "removeAnimationFilter ");
            this.F.sendRemoveAnimationFilterEvent(effectFilter.getResId());
            this.c.p();
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int removeBackgroundMusic() {
        this.F.sendRemoveMusicEvent();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "remove music startTime ");
        return a((com.aliyun.svideosdk.common.struct.effect.EffectStream) null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int removeFilter() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "removeFilter ");
        this.F.sendRemoveFilterEvent();
        return com.aliyun.svideosdk.common.a.a(this.c.a((java.lang.String) null));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        if (effectImage != null) {
            this.F.sendRemoveImageEvent(effectImage.getResId());
            this.c.a(effectImage.getResId());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        b(effectPaster.toEffectSticker(), effectPaster.isTrack);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int resizePreviewSize(int i, int i2) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "resizePreviewSize " + i + " " + i2);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        int b2 = this.c.b();
        if (android.os.Build.VERSION.SDK_INT < 29) {
            this.G = new com.aliyun.svideosdk.recorder.impl.g.d(i, i2);
            this.A.getViewTreeObserver().addOnDrawListener(this.G);
        } else {
            this.A.getHolder().setFixedSize(i, i2);
        }
        this.F.sendResizePreviewSizeEvent(java.lang.System.currentTimeMillis() - currentTimeMillis);
        return b2;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setBeautyLevel(int i) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setBeautyLevel " + i);
        this.F.sendSetBeautyLevelEvent(i);
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.v = i;
        this.c.b(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setBeautyStatus(boolean z) {
        com.aliyun.svideosdk.a.e.a aVar;
        int i;
        this.F.sendSetBeautyStatusEvent(z);
        if (z) {
            aVar = this.c;
            i = this.v;
            if (i == 0) {
                i = 50;
            }
        } else {
            aVar = this.c;
            i = 0;
        }
        aVar.b(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setCamera(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType) {
        if (cameraType == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Camera Type!");
        } else {
            this.F.sendSetCameraTypeEvent(cameraType);
            this.b.b(cameraType.getType());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setCameraCaptureDataMode(int i) {
        this.b.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setCameraParam ");
        this.F.sendSetCameraParamEvent(cameraParam);
        this.b.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setDisplayView(android.view.SurfaceView surfaceView) {
        if (surfaceView == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid DisplayView!");
            return;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setDisplayView ");
        this.F.sendSetDisplayView(surfaceView);
        this.A = surfaceView;
        this.z.add(surfaceView);
        android.view.Surface surface = surfaceView.getHolder().getSurface();
        if (surface != null && surface.isValid()) {
            this.c.a(surface);
            this.B = (surfaceView.getMeasuredWidth() * 1.0f) / surfaceView.getMeasuredHeight();
            com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback = this.h;
            if (onRecordCallback != null) {
                onRecordCallback.onInitReady();
            }
        }
        surfaceView.getHolder().addCallback(this);
        android.view.WindowManager windowManager = (android.view.WindowManager) surfaceView.getContext().getSystemService("window");
        if (windowManager != null) {
            this.b.setRotation(windowManager.getDefaultDisplay().getRotation());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setEffectView(float f, float f2, float f3, float f4, com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        if (effectBase == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Effect Item!");
            return -20003002;
        }
        this.F.sendSetEffectViewEvent(f, f2, f3, f4, effectBase);
        this.c.d().getStickerManager().updateStickerPosition(effectBase.getResId(), f, f2, f3, f4);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int setExposureCompensationRatio(float f) {
        this.F.sendSetExposureCompensationEvent(f);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return this.b.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setFaceDetectRotation(int i) {
        this.F.sendSetFaceDetectRotationEvent(i);
        this.k = i;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setFaceTrackInternalMaxFaceCount(int i) {
        this.F.sendSetFaceTrackInternalMaxFaceCountEvent(i);
        this.f104s = i;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setFaceTrackInternalModelPath(java.lang.String str) {
        this.F.sendSetFaceTrackInternalModelPathEvent(str);
        this.C = str;
        java.io.File file = new java.io.File(str + "/face_all_data_130.dat");
        com.aliyun.common.stream.ByteArrayOutputStream byteArrayOutputStream = new com.aliyun.common.stream.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        if (!file.exists()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "model file is not exists");
            return -20003002;
        }
        java.io.DataInputStream dataInputStream = null;
        try {
            try {
                java.io.DataInputStream dataInputStream2 = new java.io.DataInputStream(new java.io.FileInputStream(file));
                while (true) {
                    try {
                        int read = dataInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (java.io.FileNotFoundException e2) {
                        e = e2;
                        dataInputStream = dataInputStream2;
                        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "FaceTrack model path[" + str + "] not exist!" + e.getMessage());
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException e3) {
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e3.getMessage());
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (java.io.IOException e4) {
                                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e4.getMessage());
                            }
                        }
                        return -20003002;
                    } catch (java.io.IOException e5) {
                        e = e5;
                        dataInputStream = dataInputStream2;
                        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "FaceTrack model file[" + str + "] error!" + e.getMessage());
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException e6) {
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e6.getMessage());
                        }
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (java.io.IOException e7) {
                                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e7.getMessage());
                            }
                        }
                        return -20003002;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        dataInputStream = dataInputStream2;
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.io.IOException e8) {
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e8.getMessage());
                        }
                        if (dataInputStream == null) {
                            throw th;
                        }
                        try {
                            dataInputStream.close();
                            throw th;
                        } catch (java.io.IOException e9) {
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e9.getMessage());
                            throw th;
                        }
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.D = byteArray;
                int bytesToInt = com.aliyun.common.utils.ByteUtil.bytesToInt(byteArray, 0, false);
                byte[] bArr2 = this.D;
                if (bArr2 != null && bytesToInt == bArr2.length) {
                    this.j = true;
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException e10) {
                        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e10.getMessage());
                    }
                    try {
                        dataInputStream2.close();
                    } catch (java.io.IOException e11) {
                        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e11.getMessage());
                    }
                    return 0;
                }
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Face model file is damaged!expectLength " + bytesToInt + ", file size " + this.D.length);
                this.D = null;
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException e12) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e12.getMessage());
                }
                try {
                    dataInputStream2.close();
                } catch (java.io.IOException e13) {
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Close file stream failed!" + e13.getMessage());
                }
                return -20003002;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.FileNotFoundException e14) {
            e = e14;
        } catch (java.io.IOException e15) {
            e = e15;
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setFaces(float[][] fArr) {
        float[][] fArr2 = fArr;
        if (!com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Has no privilege to use setFaces interface");
            return -20001001;
        }
        synchronized (this.x) {
            if (fArr2 != null) {
                try {
                    if (this.g != null && this.f.size() != 0) {
                        com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase = this.f.get(0);
                        int size = this.g.size();
                        if (fArr2.length == 0) {
                            fArr2 = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, 1, 6);
                        }
                        if (this.g.size() >= fArr2.length) {
                            for (int length = fArr2.length; length < size; length++) {
                                java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.effect.EffectBase> copyOnWriteArrayList = this.g;
                                this.c.a(copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1).getResId());
                            }
                            for (int i = 0; i < fArr2.length; i++) {
                                this.c.a(this.g.get(i).getResId(), fArr2[i]);
                            }
                        } else {
                            int length2 = fArr2.length - this.g.size();
                            for (int i2 = 0; i2 < length2; i2++) {
                                if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectSticker) {
                                    if (this.g.isEmpty()) {
                                        this.g.add(effectBase);
                                    } else {
                                        com.aliyun.svideosdk.common.struct.effect.EffectSticker effectSticker = new com.aliyun.svideosdk.common.struct.effect.EffectSticker(effectBase.getSource());
                                        if (this.c.a(effectSticker.getSource().getPath(), effectSticker.getResId(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0L, 1) == 0) {
                                            this.g.add(effectSticker);
                                        }
                                    }
                                }
                            }
                            for (int i3 = 0; i3 < fArr2.length; i3++) {
                                this.c.a(this.g.get(i3).getResId(), fArr2[i3]);
                            }
                        }
                        return 0;
                    }
                } finally {
                }
            }
            return -3;
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setFocus(float f, float f2) {
        com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter = this.F;
        if (alivcRecorderReporter != null) {
            alivcRecorderReporter.sendSetFocusEvent(f, f2);
        }
        if (com.aliyun.svideosdk.preview.utils.CameraVersion.Version.CAMERA1 == this.a) {
            this.b.setFocus(f, f2);
        } else {
            this.b.setFocus(new android.graphics.Point(((int) f) * this.A.getWidth(), ((int) f2) * this.A.getHeight()));
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setFocus(android.graphics.Point point) {
        float f;
        float f2;
        if (point == null) {
            return;
        }
        int width = this.A.getWidth();
        int height = this.A.getHeight();
        if (width <= 0 || height <= 0) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            f = (point.x * 1.0f) / width;
            f2 = (point.y * 1.0f) / height;
        }
        com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter = this.F;
        if (alivcRecorderReporter != null) {
            alivcRecorderReporter.sendSetFocusEvent(f, f2);
        }
        if (com.aliyun.svideosdk.preview.utils.CameraVersion.Version.CAMERA1 == this.a) {
            this.b.setFocus(f, f2);
        } else {
            this.b.setFocus(point);
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void setFocusMode(int i) {
        this.F.sendSetFocusModeEvent(i);
        this.b.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setGop(int i) {
        this.F.sendSetGopEvent(i);
        if (i >= 0 && i <= 9000) {
            this.r.setGop(i);
            this.e.a(this.r);
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "set gop " + i);
            return 0;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid gop value " + i + ", gop value has must be between 0 and 9000");
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setIsAutoClearClipVideos(boolean z) {
        this.I = z;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized boolean setLight(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
        if (flashType == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Light!");
            return false;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setLight ");
        boolean a2 = this.b.a(flashType);
        this.F.sendSetLightEvent(flashType, a2);
        return a2;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setMediaInfo(com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo) {
        if (this.u) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Recorder has been destroyed!");
            return;
        }
        this.F.sendMediaInfoEvent(mediaInfo);
        this.r = mediaInfo;
        this.b.a(mediaInfo.getFps());
        if (mediaInfo.getVideoWidth() == 0 || mediaInfo.getVideoHeight() == 0) {
            throw new java.lang.IllegalArgumentException("The width or height must > 0");
        }
        int videoWidth = this.r.getVideoWidth();
        int videoHeight = this.r.getVideoHeight();
        if (videoWidth % 2 != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("The preview width must be even, so auto correct preview width from ");
            sb.append(videoWidth);
            sb.append(" to ");
            int i = videoWidth - 1;
            sb.append(i);
            com.aliyun.common.log.debuglog.AlivcSvideoLog.w("AliYunLog", sb.toString());
            this.r.setVideoWidth(i);
        }
        if (videoHeight % 2 != 0) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("The preview height must be even, so auto correct preview height from ");
            sb2.append(videoHeight);
            sb2.append(" to ");
            int i2 = videoHeight - 1;
            sb2.append(i2);
            com.aliyun.common.log.debuglog.AlivcSvideoLog.w("AliYunLog", sb2.toString());
            this.r.setVideoHeight(i2);
        }
        this.b.a(mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight());
        this.e.a(mediaInfo);
        if (!this.J) {
            this.c.d().setLayoutInfo(new com.aliyun.svideosdk.common.AliyunRecordVideoSource.LayoutInfo(1.0f, 1.0f, 0.5f, 0.5f, 0, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE.ordinal(), mediaInfo.getVideoWidth(), mediaInfo.getVideoHeight()));
            this.d.updateSource(this.c.d());
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "set mediainfo " + mediaInfo.toString());
    }

    public void setMixAudioWeight(int i, int i2) {
        this.e.a(i, i2);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setMusic(java.lang.String str, long j, long j2) {
        if (str == null || str.isEmpty()) {
            removeBackgroundMusic();
            return;
        }
        com.aliyun.svideosdk.common.struct.effect.EffectStream.Builder source = new com.aliyun.svideosdk.common.struct.effect.EffectStream.Builder().source(new com.aliyun.svideosdk.common.struct.project.Source(str));
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        applyBackgroundMusic(source.streamStartTime(j, timeUnit).streamDuration(j2, timeUnit).build());
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setMute(boolean z) {
        this.F.sendSetMuteEvent(z);
        this.e.a(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnAudioCallback(com.aliyun.svideosdk.common.callback.recorder.OnAudioCallBack onAudioCallBack) {
        this.e.a(onAudioCallBack);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.b.setOnChoosePictureSizeCallBack(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnEncoderInfoCallback(com.aliyun.svideosdk.common.callback.recorder.OnEncoderInfoCallback onEncoderInfoCallback) {
        this.e.a(onEncoderInfoCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnFaceDetectInfoListener(com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener onFaceDetectInfoListener) {
        this.q = onFaceDetectInfoListener;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback) {
        this.F.sendSetOnFrameCallbackEvent(onFrameCallback);
        this.b.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnRecordCallback(com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback) {
        this.F.sendSetRecordCallbackEvent(onRecordCallback);
        this.h = onRecordCallback;
        this.e.a(onRecordCallback);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setOnTextureIdCallback(com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback onTextureIdCallback) {
        this.c.a(onTextureIdCallback);
    }

    public void setOpenMicAEC(boolean z) {
        this.e.b(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setOutputPath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        this.F.sendSetOutputPathEvent(str);
        this.e.a(str);
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "set outputPath " + str);
        return 0;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setPictureSize(android.hardware.Camera.Size size) {
        if (size == null) {
            return -2;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setPictureSize " + size.width + " " + size.height);
        return this.b.setPictureSize(size.width, size.height);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setPictureSize(com.aliyun.common.utils.Size size) {
        if (size == null) {
            return -2;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setPictureSize " + size.getWidth() + " " + size.getHeight());
        return this.b.setPictureSize(size.getWidth(), size.getHeight());
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setRate(float f) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setRate " + f);
        this.F.sendSetRateEvent(f);
        if (f > 2.0d) {
            f = 2.0f;
        }
        if (f < 0.5d) {
            f = 0.5f;
        }
        this.e.a(f);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setRecordRotation(int i) {
        this.F.sendSetRecordRotationEvent(i);
        this.e.c(i);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setRotation(int i) {
        int i2;
        java.lang.StringBuilder sb;
        java.lang.String str;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setRotation " + i);
        this.k = i;
        if (i == 90 || i == 270) {
            i = (i + 90) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            if (this.b.c().facing == 0) {
                i2 = i + 180;
                i = i2 % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            }
        } else if (i == 0 || i == 180) {
            i2 = i + 270;
            i = i2 % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
        }
        if (this.b.c().facing == 1) {
            int abs = java.lang.Math.abs(270 - this.b.c().orientation);
            if (abs == 180 || ((abs == 90 || abs == 270) && (i == 0 || i == 360 || i == 180))) {
                i = (i + 180) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            }
            this.e.c(((abs + i) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) + this.o.getDefaultDisplay().getRotation());
            sb = new java.lang.StringBuilder();
            str = "front rotation is ";
        } else {
            this.e.c(this.o.getDefaultDisplay().getRotation() + i);
            sb = new java.lang.StringBuilder();
            str = "back rotation is ";
        }
        sb.append(str);
        sb.append(i);
        sb.append("camera orientation is ");
        sb.append(this.b.c().orientation);
        sb.append("wm rotation is ");
        sb.append(this.o.getDefaultDisplay().getRotation());
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliyunRecorder", sb.toString());
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setShutterSound(boolean z) {
        this.b.setShutterSound(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setTakePicturePreview(boolean z) {
        this.b.setTakePicturePreview(z);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setVideoBitrate(int i) {
        this.F.sendSetVideoBitrateEvent(i);
        if (i >= 200 && i <= 20000) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setVideoBitrate, bitrate = " + i);
            this.r.setVideoBitrate(i);
            this.e.a(this.r);
            return 0;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid video bitrate value " + i + ", video bitrate has must be between 200 and 20000");
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int setVideoFlipH(boolean z) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setVideoFlipH " + z);
        this.c.d().setMirrorInfo(z ? 1 : 0);
        this.d.updateSource(this.c.d());
        return -1;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void setVideoQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality videoQuality) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setVideoQuality " + videoQuality);
        if (videoQuality != null) {
            this.F.sendSetVideoQualityEvent(videoQuality);
            this.r.setVideoQuality(videoQuality);
            this.e.a(this.r);
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int setZoom(float f) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setZoom " + f);
        this.F.sendSetZoomEvent(f);
        return this.b.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int startPreview() {
        com.aliyun.svideosdk.a.e.a aVar;
        int videoWidth;
        int videoHeight;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunRecorder call startPreview");
        if (this.A == null || this.A.getMeasuredWidth() <= 0 || this.A.getMeasuredHeight() <= 0) {
            aVar = this.c;
            videoWidth = this.r.getVideoWidth();
            videoHeight = this.r.getVideoHeight();
        } else {
            aVar = this.c;
            videoWidth = this.A.getMeasuredWidth();
            videoHeight = this.A.getMeasuredHeight();
        }
        int a2 = aVar.a(videoWidth, videoHeight);
        if (a2 != 0) {
            com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback = this.h;
            if (onRecordCallback != null) {
                onRecordCallback.onError(a2);
            }
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "startPreview, changeFboSize failed, res = " + a2);
            return a2;
        }
        this.e.a(this.r);
        int startPreview = this.b.startPreview();
        if (startPreview >= 0) {
            this.b.a(this.M);
            this.e.h();
            return startPreview;
        }
        com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback2 = this.h;
        if (onRecordCallback2 != null) {
            onRecordCallback2.onError(startPreview);
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "startPreview, mAliyunCameraProxy.startPreview failed, res = " + startPreview);
        return startPreview;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int startPreviewAfterTakePicture() {
        return this.b.startPreviewAfterTakePicture();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int startRecording() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "startRecording");
        com.aliyun.svideosdk.recorder.impl.e eVar = this.e;
        if (eVar == null) {
            return -4;
        }
        if (eVar.g()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Current recording duration is over max duration!");
            com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback = this.h;
            if (onRecordCallback != null) {
                onRecordCallback.onError(-20008008);
            }
            return -20008008;
        }
        if (!this.b.b()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Not start preview,so can not record video!");
            return -4;
        }
        int k = this.e.k();
        this.c.l();
        com.aliyun.svideosdk.a.d.a i = this.c.i();
        this.c.f();
        com.aliyun.svideosdk.a.d.a g = this.c.g();
        com.aliyun.svideosdk.a.d.a k2 = this.c.k();
        this.E = com.aliyun.common.log.util.UUIDGenerator.generateUUID();
        this.F.sendStartRecordingEvent(i.g(), i.e(), i.d(), i.h(), g.d(), g.h(), k2.d(), k2.h(), i.i(), this.r.getVideoBitrate(), this.r.getCrf(), this.r.getEncoderFps(), this.r.getGop(), this.r.getVideoCodec(), this.r.getVideoQuality(), this.r.getVideoWidth(), this.r.getVideoHeight(), this.E);
        this.c.m();
        return k;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized void stopPreview() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunRecorder call stopPreview");
        stopRecording();
        this.b.a((com.aliyun.svideosdk.a.a) null);
        this.b.stopPreview();
        this.e.j();
        this.l = -1;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int stopRecording() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "stopRecording");
        if (this.e == null) {
            return -4;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunRecorder stopRecording");
        int m = this.e.m();
        if (m == 0) {
            this.c.l();
            com.aliyun.svideosdk.a.d.a i = this.c.i();
            this.c.f();
            com.aliyun.svideosdk.a.d.a g = this.c.g();
            com.aliyun.svideosdk.a.d.a k = this.c.k();
            com.aliyun.svideosdk.a.d.a e2 = this.c.e();
            this.F.sendStopRecordingEvent(this.E, i.d(), i.h(), g.d(), g.h(), k.d(), k.h(), e2.d(), e2.h(), i.i(), i.g(), i.e());
        }
        return m;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.aliyun.svideosdk.common.struct.recorder.MediaInfo mediaInfo;
        com.aliyun.svideosdk.a.e.a aVar = this.c;
        if (aVar != null) {
            aVar.a(surfaceHolder.getSurface());
        }
        int measuredWidth = this.A.getMeasuredWidth();
        int measuredHeight = this.A.getMeasuredHeight();
        this.B = (measuredWidth * 1.0f) / measuredHeight;
        this.c.a(measuredWidth, measuredHeight);
        if (!this.J && (mediaInfo = this.r) != null) {
            a(mediaInfo, this.B);
            this.e.a(this.r);
            com.aliyun.svideosdk.common.AliyunRecordVideoSource.LayoutInfo layoutInfo = this.c.d().getLayoutInfo();
            layoutInfo.outputWidth = this.r.getVideoWidth();
            layoutInfo.outputHeight = this.r.getVideoHeight();
            this.c.d().setLayoutInfo(layoutInfo);
            this.d.updateSource(this.c.d());
        }
        com.aliyun.svideosdk.common.callback.recorder.OnRecordCallback onRecordCallback = this.h;
        if (onRecordCallback != null) {
            onRecordCallback.onInitReady();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        com.aliyun.svideosdk.a.e.a aVar = this.c;
        if (aVar != null) {
            aVar.b(surfaceHolder.getSurface());
        }
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized int switchCamera() {
        int switchCamera;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "switchCamera ");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        switchCamera = this.b.switchCamera();
        this.F.sendSwitchCameraEvent(switchCamera, java.lang.System.currentTimeMillis() - currentTimeMillis);
        return switchCamera;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public synchronized com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight() {
        com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight;
        switchLight = this.b.switchLight();
        this.F.sendSwitchLightEvent(switchLight);
        return switchLight;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takePhoto(boolean z) {
        takeSnapshot(z, null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takePicture(boolean z) {
        takePicture(z, null);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takePicture(boolean z, com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback) {
        this.F.sendTakePictureEvent();
        this.b.a(new com.aliyun.svideosdk.recorder.impl.g.b(z, onPictureCallback));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public void takeSnapshot(boolean z, com.aliyun.svideosdk.common.callback.recorder.OnPictureCallback onPictureCallback) {
        this.F.sendTakePhotoEvent();
        this.b.a(new com.aliyun.svideosdk.recorder.impl.g.c(z, onPictureCallback));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null || !(effectFilter.getSource() == null || effectFilter.getSource().getPath() == null || new java.io.File(effectFilter.getSource().getPath()).exists())) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "EffectFilter resource not exist!");
            return -20003002;
        }
        java.lang.String jsonString = effectFilter.toJsonString();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "updateAnimationFilter params : " + jsonString);
        int a2 = com.aliyun.svideosdk.common.a.a(this.c.b(effectFilter.getPath(), jsonString));
        this.F.sendUpdateAnimationFilterEvent(effectFilter.getSource() == null ? null : effectFilter.getSource().getPath(), effectFilter.getResId());
        return a2;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecorder
    public java.lang.String version() {
        return com.aliyun.common.global.Version.VERSION;
    }
}
