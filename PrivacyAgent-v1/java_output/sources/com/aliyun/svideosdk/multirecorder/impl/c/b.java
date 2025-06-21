package com.aliyun.svideosdk.multirecorder.impl.c;

/* loaded from: classes12.dex */
public class b extends com.aliyun.svideosdk.multirecorder.impl.c.a implements com.aliyun.svideosdk.multirecorder.AliyunICameraCapture, android.view.SurfaceHolder.Callback, com.aliyun.svideosdk.a.e.a.c {
    private com.aliyun.svideosdk.facearengine.FaceAREngine B;
    private byte[] D;
    private boolean E;
    private android.view.WindowManager G;
    private volatile android.view.SurfaceView I;
    private com.aliyun.svideosdk.preview.camera.g J;
    private com.aliyun.svideosdk.a.e.a K;
    private android.view.ViewTreeObserver.OnDrawListener L;
    private com.aliyun.svideosdk.multirecorder.impl.c.b.e N;
    private int O;
    private final com.aliyun.svideosdk.preview.utils.CameraVersion.Version m;
    private int q;

    /* renamed from: s, reason: collision with root package name */
    private int f98s;
    private com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener y;
    private int z;
    private java.lang.String l = null;
    private boolean n = false;
    private int o = 0;
    private boolean p = true;
    private int r = 3;
    private boolean t = false;
    private final java.lang.Object u = new java.lang.Object();
    private final java.lang.Object v = new java.lang.Object();
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.effect.EffectBase> w = new java.util.concurrent.CopyOnWriteArrayList<>();
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.effect.EffectBase> x = new java.util.concurrent.CopyOnWriteArrayList<>();
    private int A = -1;
    private java.lang.String C = null;
    private boolean F = false;
    private java.util.List<android.view.SurfaceView> H = new java.util.ArrayList();
    private java.lang.Object M = new java.lang.Object();
    private com.aliyun.svideosdk.a.a P = new com.aliyun.svideosdk.multirecorder.impl.c.b.a();

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
            if (!com.aliyun.svideosdk.multirecorder.impl.c.b.this.E || !com.aliyun.svideosdk.multirecorder.impl.c.b.this.F || com.aliyun.svideosdk.multirecorder.impl.c.b.this.n || com.aliyun.svideosdk.multirecorder.impl.c.b.this.t) {
                return;
            }
            char c = 0;
            if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.w.size() == 0) {
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.q = 0;
                return;
            }
            char c2 = 1;
            if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.B == null && com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.B = new com.aliyun.svideosdk.facearengine.FaceAREngine();
                int init = com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.init(com.aliyun.svideosdk.multirecorder.impl.c.b.this.D, i, i2, 0);
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.D = null;
                if (init != 0) {
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.release();
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.B = null;
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.t = true;
                    return;
                }
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.switchFaceDetect(true);
            }
            synchronized (com.aliyun.svideosdk.multirecorder.impl.c.b.this.u) {
                if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.B == null) {
                    return;
                }
                if (1 == cameraInfo.facing) {
                    int abs = java.lang.Math.abs(270 - cameraInfo.orientation);
                    i4 = ((cameraInfo.orientation + (com.aliyun.svideosdk.multirecorder.impl.c.b.this.z - 270)) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                    if ((abs == 90 || abs == 270) && (com.aliyun.svideosdk.multirecorder.impl.c.b.this.z == 90 || com.aliyun.svideosdk.multirecorder.impl.c.b.this.z == 270)) {
                        i3 = i4 + 180;
                    }
                    if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.A != i4) {
                        com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.setRenderRotationAndSize(i4, i, i2);
                    }
                    if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.f98s != com.aliyun.svideosdk.multirecorder.impl.c.b.this.r) {
                        com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.setMaxFaceCount(com.aliyun.svideosdk.multirecorder.impl.c.b.this.r);
                    }
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.A = i4;
                    com.aliyun.svideosdk.multirecorder.impl.c.b bVar = com.aliyun.svideosdk.multirecorder.impl.c.b.this;
                    bVar.f98s = bVar.r;
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.renderVideoData(bArr, i, i2);
                    com.aliyun.svideosdk.facearengine.FaceAROrganLocation faceOrganLocation = com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.getFaceOrganLocation();
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
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.setFaces(fArr);
                    if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.q != faceCount && com.aliyun.svideosdk.multirecorder.impl.c.b.this.y != null) {
                        com.aliyun.svideosdk.multirecorder.impl.c.b.this.q = faceCount;
                        com.aliyun.svideosdk.multirecorder.impl.c.b.this.y.onFaceInfoChange(new com.aliyun.svideosdk.common.struct.recorder.FaceDetectInfo(faceCount));
                    }
                }
                i3 = cameraInfo.orientation + (com.aliyun.svideosdk.multirecorder.impl.c.b.this.z - 90) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                i4 = i3 % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.A != i4) {
                }
                if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.f98s != com.aliyun.svideosdk.multirecorder.impl.c.b.this.r) {
                }
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.A = i4;
                com.aliyun.svideosdk.multirecorder.impl.c.b bVar2 = com.aliyun.svideosdk.multirecorder.impl.c.b.this;
                bVar2.f98s = bVar2.r;
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.renderVideoData(bArr, i, i2);
                com.aliyun.svideosdk.facearengine.FaceAROrganLocation faceOrganLocation2 = com.aliyun.svideosdk.multirecorder.impl.c.b.this.B.getFaceOrganLocation();
                faceCount = faceOrganLocation2.getFaceCount();
                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "face detect result " + faceCount);
                int i62 = 6;
                float[][] fArr2 = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, faceCount, 6);
                i5 = 0;
                while (i5 < faceCount) {
                }
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.setFaces(fArr2);
                if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.q != faceCount) {
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.q = faceCount;
                    com.aliyun.svideosdk.multirecorder.impl.c.b.this.y.onFaceInfoChange(new com.aliyun.svideosdk.common.struct.recorder.FaceDetectInfo(faceCount));
                }
            }
        }
    }

    /* renamed from: com.aliyun.svideosdk.multirecorder.impl.c.b$b, reason: collision with other inner class name */
    public class C0103b implements com.aliyun.svideosdk.a.c {
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.OnPictureCallback a;
        final /* synthetic */ boolean b;

        /* renamed from: com.aliyun.svideosdk.multirecorder.impl.c.b$b$a */
        public class a implements java.lang.Runnable {
            final /* synthetic */ byte[] a;

            public a(byte[] bArr) {
                this.a = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                synchronized (com.aliyun.svideosdk.multirecorder.impl.c.b.this) {
                    com.aliyun.svideosdk.multirecorder.impl.c.b.C0103b.this.a.onPicture(this.a);
                    if (com.aliyun.svideosdk.multirecorder.impl.c.b.C0103b.this.b && (bArr = this.a) != null && bArr.length > 0) {
                        android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        android.hardware.Camera.CameraInfo c = com.aliyun.svideosdk.multirecorder.impl.c.b.this.J.c();
                        android.graphics.Matrix matrix = new android.graphics.Matrix();
                        int i = c.facing;
                        if (i == 1) {
                            matrix.postRotate(c.orientation);
                            matrix.postScale(-1.0f, 1.0f);
                        } else if (i == 0) {
                            matrix.postRotate(c.orientation);
                        }
                        try {
                            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                            if (createBitmap != decodeByteArray) {
                                decodeByteArray.recycle();
                            }
                            decodeByteArray = createBitmap;
                        } catch (java.lang.OutOfMemoryError e) {
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Create bitmap failed!" + e.getMessage());
                        }
                        com.aliyun.svideosdk.multirecorder.impl.c.b.C0103b.this.a.onPicture(decodeByteArray);
                    }
                }
            }
        }

        public C0103b(com.aliyun.svideosdk.multirecorder.OnPictureCallback onPictureCallback, boolean z) {
            this.a = onPictureCallback;
            this.b = z;
        }

        @Override // com.aliyun.svideosdk.a.c
        public void a(byte[] bArr) {
            java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.aliyun.svideosdk.multirecorder.impl.c.b.C0103b.a(bArr));
        }

        @Override // com.aliyun.svideosdk.a.c
        public void onShutter() {
        }
    }

    public class c implements com.aliyun.svideosdk.a.b {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.OnPictureCallback b;

        public class a implements java.lang.Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ java.nio.ByteBuffer c;
            final /* synthetic */ android.hardware.Camera.CameraInfo d;

            public a(int i, int i2, java.nio.ByteBuffer byteBuffer, android.hardware.Camera.CameraInfo cameraInfo) {
                this.a = i;
                this.b = i2;
                this.c = byteBuffer;
                this.d = cameraInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.graphics.Bitmap bitmap;
                int i;
                int i2;
                if (!com.aliyun.svideosdk.multirecorder.impl.c.b.c.this.a || (i = this.a) == 0 || (i2 = this.b) == 0) {
                    bitmap = null;
                } else {
                    android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
                    this.c.rewind();
                    createBitmap.copyPixelsFromBuffer(this.c);
                    com.aliyun.svideosdk.multirecorder.impl.c.b bVar = com.aliyun.svideosdk.multirecorder.impl.c.b.this;
                    bitmap = bVar.a(createBitmap, bVar.a(this.d));
                }
                com.aliyun.svideosdk.multirecorder.OnPictureCallback onPictureCallback = com.aliyun.svideosdk.multirecorder.impl.c.b.c.this.b;
                if (onPictureCallback != null) {
                    onPictureCallback.onPicture(this.c.array());
                    if (bitmap != null) {
                        com.aliyun.svideosdk.multirecorder.impl.c.b.c.this.b.onPicture(bitmap);
                    }
                }
            }
        }

        public c(boolean z, com.aliyun.svideosdk.multirecorder.OnPictureCallback onPictureCallback) {
            this.a = z;
            this.b = onPictureCallback;
        }

        @Override // com.aliyun.svideosdk.a.b
        public void a(int i, int i2, android.hardware.Camera.CameraInfo cameraInfo, java.nio.ByteBuffer byteBuffer) {
            java.util.concurrent.Executors.newSingleThreadExecutor().submit(new com.aliyun.svideosdk.multirecorder.impl.c.b.c.a(i, i2, byteBuffer, cameraInfo));
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
                android.view.SurfaceView surfaceView = com.aliyun.svideosdk.multirecorder.impl.c.b.this.I;
                if (surfaceView != null) {
                    surfaceView.getViewTreeObserver().removeOnDrawListener(com.aliyun.svideosdk.multirecorder.impl.c.b.this.L);
                }
            }
        }

        /* renamed from: com.aliyun.svideosdk.multirecorder.impl.c.b$d$b, reason: collision with other inner class name */
        public class RunnableC0104b implements java.lang.Runnable {
            public RunnableC0104b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                android.view.SurfaceView surfaceView = com.aliyun.svideosdk.multirecorder.impl.c.b.this.I;
                if (surfaceView != null) {
                    android.view.SurfaceHolder holder = surfaceView.getHolder();
                    com.aliyun.svideosdk.multirecorder.impl.c.b.d dVar = com.aliyun.svideosdk.multirecorder.impl.c.b.d.this;
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
            if (com.aliyun.svideosdk.multirecorder.impl.c.b.this.L != null) {
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.I.post(new com.aliyun.svideosdk.multirecorder.impl.c.b.d.a());
                com.aliyun.svideosdk.multirecorder.impl.c.b.this.I.postDelayed(new com.aliyun.svideosdk.multirecorder.impl.c.b.d.RunnableC0104b(), 100L);
            }
        }
    }

    public interface e {
        void a(int i);

        void a(int i, float f, float f2, float f3, float f4);

        void onInitReady();
    }

    public b(android.content.Context context, com.aliyun.svideosdk.preview.utils.CameraVersion.Version version, com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter) {
        com.aliyun.svideosdk.a.e.a aVar = new com.aliyun.svideosdk.a.e.a(alivcRecorderReporter, nativeRecorder);
        this.K = aVar;
        aVar.a(this);
        this.m = version;
        this.J = com.aliyun.svideosdk.preview.camera.e.a(context, this.K, alivcRecorderReporter, version);
        this.G = (android.view.WindowManager) context.getApplicationContext().getSystemService("window");
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
        return i2 + this.J.a();
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

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i) {
        super.a(i);
        this.J.a(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.e
    public void a(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource, com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam, com.aliyun.svideosdk.multirecorder.impl.b bVar) {
        super.a(aliyunRecordVideoSource, aliyunLayoutParam, bVar);
        this.K.a(aliyunRecordVideoSource);
    }

    public void a(com.aliyun.svideosdk.multirecorder.impl.c.b.e eVar) {
        this.N = eVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
        bVar.a(java.lang.Integer.valueOf(this.O));
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(boolean z) {
        if (this.l == null) {
            return;
        }
        this.K.l();
        com.aliyun.svideosdk.a.d.a i = this.K.i();
        com.aliyun.svideosdk.a.d.a g = this.K.g();
        com.aliyun.svideosdk.a.d.a k = this.K.k();
        com.aliyun.svideosdk.a.d.a e2 = this.K.e();
        if (i.i() == 0 && g.i() == 0 && k.i() == 0 && e2.i() == 0) {
            return;
        }
        com.aliyun.svideosdk.multirecorder.impl.b bVar = this.i;
        if (z) {
            bVar.b(this.l, i.d(), i.h(), g.d(), g.h(), k.d(), k.h(), e2.d(), e2.h(), i.i(), i.g(), i.e());
        } else {
            bVar.a(this.l, i.d(), i.h(), g.d(), g.h(), k.d(), k.h(), e2.d(), e2.h(), i.i(), i.g(), i.e());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int addImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        int a2;
        if (effectImage == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Parameter!");
            return -20003002;
        }
        android.graphics.Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null) {
            a2 = this.K.a(effectImage.getResId(), bitmap, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        } else {
            if (effectImage.getPath() == null || !new java.io.File(effectImage.getPath()).exists()) {
                return -20003013;
            }
            a2 = this.K.a(effectImage.getResId(), effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0.0f);
        }
        this.i.a(effectImage, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), 0);
        return com.aliyun.svideosdk.common.a.a(a2);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster2;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        boolean z;
        com.aliyun.svideosdk.multirecorder.impl.c.b bVar;
        if (effectPaster != null) {
            f = effectPaster.x;
            f2 = effectPaster.y;
            f3 = effectPaster.width;
            f4 = effectPaster.height;
            f5 = effectPaster.rotation;
            z = effectPaster.mirror;
            bVar = this;
            effectPaster2 = effectPaster;
        } else {
            effectPaster2 = null;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
            f5 = 0.0f;
            z = false;
            bVar = this;
        }
        return bVar.addPaster(effectPaster2, f, f2, f3, f4, f5, z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int addPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, float f, float f2, float f3, float f4, float f5, boolean z) {
        if (effectPaster == null || effectPaster.getPath() == null || !new java.io.File(effectPaster.getPath()).exists()) {
            return -20001003;
        }
        int a2 = com.aliyun.svideosdk.common.a.a(this.K.a(effectPaster.getPath(), effectPaster.getResId(), f, f2, f3, f4, f5, z, effectPaster.duration, effectPaster.isTrack ? 1 : 0));
        if (a2 == 0 && effectPaster.isTrack) {
            this.w.add(effectPaster);
            this.J.a(false);
        }
        com.aliyun.svideosdk.multirecorder.impl.b bVar = this.i;
        boolean z2 = this.E;
        java.lang.String str = this.C;
        if (str == null) {
            str = "";
        }
        bVar.a(effectPaster, f, f2, f3, f4, f5, z, z2, str, f5);
        return a2;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int applyAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        java.lang.String str;
        if (effectFilter == null) {
            str = "Invalid EffectFilter!";
        } else {
            if (new java.io.File(effectFilter.getPath()).exists()) {
                java.lang.String jsonString = effectFilter.toJsonString();
                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "applyAnimationFilter params : " + jsonString);
                int a2 = com.aliyun.svideosdk.common.a.a(this.K.b(effectFilter.getPath(), jsonString));
                effectFilter.setViewId(a2);
                this.i.b(effectFilter.getPath(), effectFilter.getViewId());
                if (a2 > 0) {
                    return 0;
                }
                return a2;
            }
            str = "EffectFilter resource not exist!";
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
        return -20003002;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int applyFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null || android.text.TextUtils.isEmpty(effectFilter.getPath()) || !new java.io.File(effectFilter.getPath()).exists()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "applyFilter error, invalid params");
            return -20003014;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "applyFilter ");
        this.i.b(effectFilter.getPath());
        return com.aliyun.svideosdk.common.a.a(this.K.a(effectFilter.getPath()));
    }

    @Override // com.aliyun.svideosdk.a.e.a.c
    public void b(int i) {
        this.O = i;
        m();
        l();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        this.K.o();
        this.n = true;
        this.J.setOnFrameCallback(null);
        this.J.a((com.aliyun.svideosdk.a.a) null);
        this.J.release();
        synchronized (this.u) {
            com.aliyun.svideosdk.facearengine.FaceAREngine faceAREngine = this.B;
            if (faceAREngine != null) {
                faceAREngine.release();
                this.B = null;
            }
        }
        this.K.n();
        java.util.Iterator<android.view.SurfaceView> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().getHolder().removeCallback(this);
        }
        this.D = null;
        this.H.clear();
        this.I = null;
        this.K.a((com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback) null);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public com.aliyun.svideosdk.multirecorder.impl.c.e.a e() {
        return com.aliyun.svideosdk.multirecorder.impl.c.e.a.TEXTURE_OES_ID;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.e
    public boolean f() {
        return true;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int getBeautyLevel() {
        return this.o;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int getCameraCount() {
        return this.J.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public float getCurrentExposureCompensationRatio() {
        return this.J.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public java.util.List<android.hardware.Camera.Size> getSupportedPictureSize() {
        return this.J.getSupportedPictureSize();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes() {
        return this.J.getSupportedPictureSizes();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.e
    public boolean h() {
        return true;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void needFaceTrackInternal(boolean z) {
        this.E = z;
        this.i.b(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removeAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter != null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "removeAnimationFilter ");
            this.i.d(effectFilter.getResId());
            this.K.p();
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removeFilter() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "removeFilter ");
        this.K.q();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removeImage(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        if (effectImage != null) {
            this.i.e(effectImage.getResId());
            this.K.a(effectImage.getResId());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        if (effectPaster.isTrack) {
            synchronized (this.v) {
                java.util.Iterator<com.aliyun.svideosdk.common.struct.effect.EffectBase> it = this.x.iterator();
                while (it.hasNext()) {
                    this.K.a(it.next().getResId());
                }
                this.x.clear();
                this.w.remove(effectPaster);
                if (this.w.size() == 0) {
                    this.J.a(true);
                }
                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "size = " + this.w.size());
            }
        }
        this.i.g(effectPaster.getResId());
        this.K.a(effectPaster.getResId());
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int resizePreviewSize(int i, int i2) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "resizePreviewSize " + i + " " + i2);
        if (this.I == null) {
            return -4;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        int a2 = this.K.a(i, i2);
        if (a2 != 0) {
            return a2;
        }
        int b = this.K.b();
        if (android.os.Build.VERSION.SDK_INT < 29) {
            this.L = new com.aliyun.svideosdk.multirecorder.impl.c.b.d(i, i2);
            this.I.getViewTreeObserver().addOnDrawListener(this.L);
        } else {
            this.I.getHolder().setFixedSize(i, i2);
        }
        this.i.a(java.lang.System.currentTimeMillis() - currentTimeMillis);
        return b;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setAutoPreviewAfterTakePhoto(boolean z) {
        this.J.setTakePicturePreview(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setBeautyLevel(int i) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setBeautyLevel " + i);
        this.i.a(i);
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.o = i;
        if (this.p) {
            this.K.b(i);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setBeautyStatus(boolean z) {
        com.aliyun.svideosdk.a.e.a aVar;
        int i;
        this.i.a(z);
        this.p = z;
        if (z) {
            aVar = this.K;
            i = this.o;
            if (i == 0) {
                i = 50;
            }
        } else {
            aVar = this.K;
            i = 0;
        }
        aVar.b(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setCamera(com.aliyun.svideosdk.common.struct.recorder.CameraType cameraType) {
        if (cameraType == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Camera Type!");
        } else {
            this.i.a(cameraType);
            this.J.b(cameraType.getType());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setCameraCaptureDataMode(int i) {
        this.J.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setCameraParam ");
        this.i.a(cameraParam);
        this.J.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setDisplayView(android.view.SurfaceView surfaceView) {
        if (surfaceView == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid DisplayView!");
            return;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setDisplayView ");
        this.i.a(surfaceView);
        this.I = surfaceView;
        this.H.add(surfaceView);
        android.view.Surface surface = surfaceView.getHolder().getSurface();
        if (surface != null && surface.isValid()) {
            this.K.a(surface);
            com.aliyun.svideosdk.multirecorder.impl.c.b.e eVar = this.N;
            if (eVar != null) {
                eVar.onInitReady();
            }
        }
        surfaceView.getHolder().addCallback(this);
        android.view.WindowManager windowManager = (android.view.WindowManager) surfaceView.getContext().getSystemService("window");
        if (windowManager != null) {
            this.J.setRotation(windowManager.getDefaultDisplay().getRotation());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setEffectView(float f, float f2, float f3, float f4, com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        if (effectBase == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Effect Item!");
            return -20003002;
        }
        this.i.a(f, f2, f3, f4, effectBase);
        com.aliyun.svideosdk.multirecorder.impl.c.b.e eVar = this.N;
        if (eVar == null) {
            return 0;
        }
        eVar.a(effectBase.getResId(), f, f2, f3, f4);
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized int setExposureCompensationRatio(float f) {
        this.i.a(f);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return this.J.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setFaceDetectRotation(int i) {
        this.i.b(i);
        this.z = i;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setFaceTrackInternalMaxFaceCount(int i) {
        this.i.c(i);
        this.r = i;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setFaceTrackInternalModelPath(java.lang.String str) {
        int i;
        this.i.a(str);
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
                        i = 0;
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
                    this.F = true;
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
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Face model file is damaged!expectLength ");
                sb.append(bytesToInt);
                sb.append(", file size ");
                byte[] bArr3 = this.D;
                if (bArr3 != null) {
                    i = bArr3.length;
                }
                sb.append(i);
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", sb.toString());
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

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setFaces(float[][] fArr) {
        int i;
        float[][] fArr2 = fArr;
        if (!com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LIB_ALI_FACE_AR_ENGINE_SUPPORTED.booleanValue()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Has no privilege to use setFaces interface");
            return -20001001;
        }
        synchronized (this.v) {
            if (fArr2 != null) {
                try {
                    if (this.x != null && this.w.size() != 0) {
                        com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase = this.w.get(0);
                        int size = this.x.size();
                        if (fArr2.length == 0) {
                            fArr2 = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Float.TYPE, 1, 6);
                        }
                        if (this.x.size() >= fArr2.length) {
                            for (int length = fArr2.length; length < size; length++) {
                                java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.common.struct.effect.EffectBase> copyOnWriteArrayList = this.x;
                                this.K.a(copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1).getResId());
                            }
                            for (int i2 = 0; i2 < fArr2.length; i2++) {
                                this.K.a(this.x.get(i2).getResId(), fArr2[i2]);
                            }
                        } else {
                            int length2 = fArr2.length - this.x.size();
                            int i3 = 0;
                            while (i3 < length2) {
                                if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectPaster) {
                                    if (this.x.isEmpty()) {
                                        this.x.add(effectBase);
                                    } else {
                                        com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = new com.aliyun.svideosdk.common.struct.effect.EffectPaster(effectBase.getPath());
                                        i = length2;
                                        if (this.K.a(effectPaster.getPath(), effectPaster.getResId(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, effectPaster.duration, 1) == 0) {
                                            this.x.add(effectPaster);
                                        }
                                        i3++;
                                        length2 = i;
                                    }
                                }
                                i = length2;
                                i3++;
                                length2 = i;
                            }
                            for (int i4 = 0; i4 < fArr2.length; i4++) {
                                this.K.a(this.x.get(i4).getResId(), fArr2[i4]);
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

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setFocus(float f, float f2) {
        if (this.I == null) {
            return;
        }
        this.i.a(f, f2);
        if (com.aliyun.svideosdk.preview.utils.CameraVersion.Version.CAMERA1 == this.m) {
            this.J.setFocus(f, f2);
        } else {
            this.J.setFocus(new android.graphics.Point(((int) f) * this.I.getWidth(), ((int) f2) * this.I.getHeight()));
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setFocus(android.graphics.Point point) {
        float f;
        float f2;
        if (point != null) {
            if (this.I != null) {
                int width = this.I.getWidth();
                int height = this.I.getHeight();
                if (width <= 0 || height <= 0) {
                    f = 0.0f;
                    f2 = 0.0f;
                } else {
                    f = (point.x * 1.0f) / width;
                    f2 = (point.y * 1.0f) / height;
                }
                this.i.a(f, f2);
                if (com.aliyun.svideosdk.preview.utils.CameraVersion.Version.CAMERA1 == this.m) {
                    this.J.setFocus(f, f2);
                } else {
                    this.J.setFocus(point);
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized void setFocusMode(int i) {
        this.i.f(i);
        this.J.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized boolean setLight(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
        if (flashType == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid Light!");
            return false;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setLight ");
        boolean a2 = this.J.a(flashType);
        this.i.a(flashType, a2);
        return a2;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.J.setOnChoosePictureSizeCallBack(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnFaceDetectInfoListener(com.aliyun.svideosdk.recorder.OnFaceDetectInfoListener onFaceDetectInfoListener) {
        this.y = onFaceDetectInfoListener;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback) {
        this.i.a(onFrameCallback);
        this.J.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOnTextureIdCallback(com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback onTextureIdCallback) {
        this.K.a(onTextureIdCallback);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setOutputFlip(boolean z) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setOutputFlip " + z);
        b(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int setPictureSize(int i, int i2) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setPictureSize " + i + " " + i2);
        return this.J.setPictureSize(i, i2);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public int setProperty(java.lang.String str, java.lang.String str2) {
        if (com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE.equals(str)) {
            return this.K.a(str, str2);
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setRecordRotation(int i) {
        this.i.h(i);
        com.aliyun.svideosdk.multirecorder.impl.c.b.e eVar = this.N;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setRotation(int i) {
        int i2;
        java.lang.StringBuilder sb;
        java.lang.String str;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setRotation " + i);
        this.z = i;
        if (i == 90 || i == 270) {
            i = (i + 90) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            if (this.J.c().facing == 0) {
                i2 = i + 180;
                i = i2 % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            }
        } else if (i == 0 || i == 180) {
            i2 = i + 270;
            i = i2 % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
        }
        if (this.J.c().facing == 1) {
            int abs = java.lang.Math.abs(270 - this.J.c().orientation);
            if (abs == 180 || ((abs == 90 || abs == 270) && (i == 0 || i == 360 || i == 180))) {
                i = (i + 180) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
            }
            com.aliyun.svideosdk.multirecorder.impl.c.b.e eVar = this.N;
            if (eVar != null) {
                eVar.a(((abs + i) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) + this.G.getDefaultDisplay().getRotation());
            }
            sb = new java.lang.StringBuilder();
            str = "front rotation is ";
        } else {
            com.aliyun.svideosdk.multirecorder.impl.c.b.e eVar2 = this.N;
            if (eVar2 != null) {
                eVar2.a(this.G.getDefaultDisplay().getRotation() + i);
            }
            sb = new java.lang.StringBuilder();
            str = "back rotation is ";
        }
        sb.append(str);
        sb.append(i);
        sb.append("camera orientation is ");
        sb.append(this.J.c().orientation);
        sb.append("wm rotation is ");
        sb.append(this.G.getDefaultDisplay().getRotation());
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliyunRecorder", sb.toString());
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void setShutterSound(boolean z) {
        this.J.setShutterSound(z);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized int setZoom(float f) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "setZoom " + f);
        this.i.b(f);
        return this.J.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void snapshot(boolean z, com.aliyun.svideosdk.multirecorder.OnPictureCallback onPictureCallback) {
        if (onPictureCallback == null) {
            return;
        }
        synchronized (this.M) {
            this.J.a(new com.aliyun.svideosdk.multirecorder.impl.c.b.c(z, onPictureCallback));
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startPreview() {
        int[] j = (this.I == null || this.I.getMeasuredWidth() <= 0 || this.I.getMeasuredHeight() <= 0) ? j() : new int[]{this.I.getMeasuredWidth(), this.I.getMeasuredHeight()};
        this.J.a(j[0], j[1]);
        int a2 = this.K.a(j[0], j[1]);
        if (a2 != 0) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "changeFboSize failed, res = " + a2);
            return a2;
        }
        int startPreview = this.J.startPreview();
        if (startPreview >= 0) {
            this.J.a(this.P);
            return startPreview;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "startPreview failed, res = " + startPreview);
        return startPreview;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int startPreviewAfterTakePicture() {
        return this.J.startPreviewAfterTakePicture();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startRecording() {
        if (!this.J.b()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Not start preview,so can not record video!");
            return -4;
        }
        this.K.l();
        com.aliyun.svideosdk.a.d.a i = this.K.i();
        com.aliyun.svideosdk.a.d.a g = this.K.g();
        com.aliyun.svideosdk.a.d.a k = this.K.k();
        if (i.i() == 0 && g.i() == 0 && k.i() == 0) {
            return 0;
        }
        this.l = com.aliyun.common.log.util.UUIDGenerator.generateUUID();
        this.i.a(i.g(), i.e(), i.d(), i.h(), g.d(), g.h(), k.d(), k.h(), i.i(), this.l);
        this.K.m();
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void stopPreview() {
        this.J.a((com.aliyun.svideosdk.a.a) null);
        this.J.stopPreview();
        this.A = -1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        com.aliyun.svideosdk.a.e.a aVar = this.K;
        if (aVar != null) {
            aVar.a(surfaceHolder.getSurface());
        }
        this.K.a(this.I.getMeasuredWidth(), this.I.getMeasuredHeight());
        com.aliyun.svideosdk.multirecorder.impl.c.b.e eVar = this.N;
        if (eVar != null) {
            eVar.onInitReady();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        com.aliyun.svideosdk.a.e.a aVar = this.K;
        if (aVar != null) {
            aVar.b(surfaceHolder.getSurface());
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized int switchCamera() {
        int switchCamera;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "switchCamera ");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        switchCamera = this.J.switchCamera();
        this.i.a(switchCamera, java.lang.System.currentTimeMillis() - currentTimeMillis);
        return switchCamera;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public synchronized com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight() {
        com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight;
        switchLight = this.J.switchLight();
        this.i.a(switchLight);
        return switchLight;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public void takePhoto(boolean z, com.aliyun.svideosdk.multirecorder.OnPictureCallback onPictureCallback) {
        if (onPictureCallback == null) {
            return;
        }
        this.J.a(new com.aliyun.svideosdk.multirecorder.impl.c.b.C0103b(onPictureCallback, z));
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunICameraCapture
    public int updateAnimationFilter(com.aliyun.svideosdk.common.struct.effect.EffectFilter effectFilter) {
        if (effectFilter == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid EffectFilter!");
            return -20003002;
        }
        if (!new java.io.File(effectFilter.getPath()).exists()) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "EffectFilter resource not exist!");
            return -20003002;
        }
        java.lang.String jsonString = effectFilter.toJsonString();
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "updateAnimationFilter params : " + jsonString);
        int a2 = com.aliyun.svideosdk.common.a.a(this.K.b(effectFilter.getPath(), jsonString));
        this.i.a(effectFilter.getPath(), effectFilter.getResId());
        return a2;
    }
}
