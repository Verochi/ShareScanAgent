package com.aliyun.svideosdk.preview.camera;

/* loaded from: classes12.dex */
public class a implements com.aliyun.svideosdk.preview.camera.f, android.hardware.Camera.PreviewCallback, android.graphics.SurfaceTexture.OnFrameAvailableListener {
    public static final java.lang.String Q = "a";
    private com.aliyun.svideosdk.a.e.a H;
    private com.aliyun.common.log.reporter.AlivcRecorderReporter K;
    private float c;
    private int d;
    private int e;
    private java.lang.String f;
    private java.lang.Integer g;
    private java.lang.Float h;
    private android.hardware.Camera.Parameters i;
    private boolean j;
    private int m;
    private com.aliyun.svideosdk.common.struct.recorder.CameraParam o;
    private com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback p;
    private com.aliyun.svideosdk.a.a q;

    /* renamed from: s, reason: collision with root package name */
    private int f100s;
    private int t;
    private int v;
    private int a = 0;
    private int b = 0;
    private android.hardware.Camera.CameraInfo k = new android.hardware.Camera.CameraInfo();
    private android.hardware.Camera l = null;
    private android.hardware.Camera.Size n = null;
    private com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback r = null;
    private com.aliyun.common.utils.AspectRatio u = null;
    private int w = 0;
    private boolean x = true;
    private boolean y = true;
    private boolean z = false;
    private android.graphics.Matrix A = new android.graphics.Matrix();
    private volatile int B = 3;
    private java.lang.Object C = new java.lang.Object();
    private int D = 3;
    private java.util.List<byte[]> E = new java.util.ArrayList();
    private volatile boolean F = true;
    private int G = 0;
    private float I = 0.0f;
    private final com.aliyun.common.utils.SizeMap J = new com.aliyun.common.utils.SizeMap();
    private boolean L = false;
    private java.lang.Object M = new java.lang.Object();
    private long N = 0;
    private android.os.Handler O = new android.os.Handler(android.os.Looper.myLooper());
    private java.lang.Runnable P = new com.aliyun.svideosdk.preview.camera.a.RunnableC0106a();

    /* renamed from: com.aliyun.svideosdk.preview.camera.a$a, reason: collision with other inner class name */
    public class RunnableC0106a implements java.lang.Runnable {
        public RunnableC0106a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.aliyun.svideosdk.preview.camera.a.this.C) {
                if (com.aliyun.svideosdk.preview.camera.a.this.j) {
                    java.lang.String str = com.aliyun.svideosdk.preview.camera.a.Q;
                    com.aliyun.svideosdk.preview.camera.a.this.j = false;
                    com.aliyun.svideosdk.preview.camera.a.this.b("force cancel focus");
                } else {
                    java.lang.String str2 = com.aliyun.svideosdk.preview.camera.a.Q;
                }
            }
        }
    }

    public class b implements android.hardware.Camera.ShutterCallback {
        final /* synthetic */ com.aliyun.svideosdk.a.c a;

        public b(com.aliyun.svideosdk.preview.camera.a aVar, com.aliyun.svideosdk.a.c cVar) {
            this.a = cVar;
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            com.aliyun.svideosdk.a.c cVar = this.a;
            if (cVar != null) {
                cVar.onShutter();
            }
        }
    }

    public class c implements android.hardware.Camera.PictureCallback {
        final /* synthetic */ long a;
        final /* synthetic */ com.aliyun.svideosdk.a.c b;

        public c(long j, com.aliyun.svideosdk.a.c cVar) {
            this.a = j;
            this.b = cVar;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, android.hardware.Camera camera) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "takePicture callback: costTime=" + (java.lang.System.currentTimeMillis() - this.a));
            com.aliyun.svideosdk.preview.camera.a.this.z = false;
            synchronized (com.aliyun.svideosdk.preview.camera.a.this.C) {
                if (com.aliyun.svideosdk.preview.camera.a.this.B != 3) {
                    com.aliyun.svideosdk.a.c cVar = this.b;
                    if (cVar != null) {
                        cVar.a(bArr);
                    }
                    if (com.aliyun.svideosdk.preview.camera.a.this.y) {
                        try {
                            camera.startPreview();
                        } catch (java.lang.Exception e) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("Start Preview failed after takePicture ");
                            sb.append(e.getMessage());
                        }
                    }
                }
            }
        }
    }

    public class d implements com.aliyun.svideosdk.a.e.a.d {
        final /* synthetic */ com.aliyun.svideosdk.a.b a;

        public d(com.aliyun.svideosdk.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.aliyun.svideosdk.a.e.a.d
        public void a(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            com.aliyun.svideosdk.a.b bVar = this.a;
            if (bVar != null) {
                bVar.a(i, i2, com.aliyun.svideosdk.preview.camera.a.this.c(), byteBuffer);
            }
        }
    }

    public class e implements android.hardware.Camera.AutoFocusCallback {
        public e() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, android.hardware.Camera camera) {
            synchronized (com.aliyun.svideosdk.preview.camera.a.this.C) {
                if (com.aliyun.svideosdk.preview.camera.a.this.O != null) {
                    com.aliyun.svideosdk.preview.camera.a.this.O.removeCallbacks(com.aliyun.svideosdk.preview.camera.a.this.P, null);
                }
                com.aliyun.svideosdk.preview.camera.a.this.j = false;
                java.lang.String str = com.aliyun.svideosdk.preview.camera.a.Q;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onAutoFocus, current mCamera status ");
                sb.append(com.aliyun.svideosdk.preview.camera.a.this.B);
                sb.append(", succ = ");
                sb.append(z);
                if (com.aliyun.svideosdk.preview.camera.a.this.B == 3) {
                    return;
                }
                try {
                    camera.cancelAutoFocus();
                } catch (java.lang.RuntimeException e) {
                    java.lang.String str2 = com.aliyun.svideosdk.preview.camera.a.Q;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("onAutoFocus exception ");
                    sb2.append(e.toString());
                }
                android.hardware.Camera.Parameters h = com.aliyun.svideosdk.preview.camera.a.this.h();
                if (h == null) {
                    return;
                }
                if (h.isAutoExposureLockSupported()) {
                    h.setAutoExposureLock(false);
                }
                if (h.isAutoWhiteBalanceLockSupported()) {
                    h.setAutoWhiteBalanceLock(false);
                }
                try {
                    com.aliyun.svideosdk.preview.camera.a.this.l.setParameters(h);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public a(com.aliyun.svideosdk.a.e.a aVar, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter) {
        this.H = aVar;
        this.K = alivcRecorderReporter;
    }

    private java.util.List<android.hardware.Camera.Size> a(java.util.SortedSet<com.aliyun.common.utils.Size> sortedSet, java.util.List<android.hardware.Camera.Size> list) {
        if (sortedSet == null || list == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.common.utils.Size size : sortedSet) {
            java.util.Iterator<android.hardware.Camera.Size> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    android.hardware.Camera.Size next = it.next();
                    if (size.getWidth() == next.width && size.getHeight() == next.height) {
                        arrayList.add(next);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(android.hardware.Camera.Parameters parameters, int i) {
        int i2;
        int[] iArr = {com.hbzhou.open.flowcamera.JCameraView.MEDIA_QUALITY_POOR, com.hbzhou.open.flowcamera.JCameraView.MEDIA_QUALITY_POOR};
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        int i3 = i * 1000;
        java.util.Iterator<int[]> it = parameters.getSupportedPreviewFpsRange().iterator();
        java.lang.String str = "Supported Preview Framerate: ";
        while (it.hasNext()) {
            int[] next = it.next();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(next[0] / 1000);
            sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(next[1] / 1000);
            sb.append("fps");
            sb.append(it.hasNext() ? ", " : "");
            str = sb.toString();
            int abs = java.lang.Math.abs(next[0] - i3);
            int abs2 = java.lang.Math.abs(next[1] - i3);
            if (abs2 <= iArr[1] && abs <= iArr[0]) {
                iArr[0] = abs;
                iArr[1] = abs2;
                int i4 = next[0];
                iArr2[0] = i4;
                int i5 = next[1];
                iArr2[1] = i5;
                if (i4 != i5) {
                    iArr3[0] = i4;
                    iArr3[1] = i5;
                }
            }
        }
        int i6 = iArr3[0];
        if (i6 != 0 && (i2 = iArr3[1]) != 0) {
            parameters.setPreviewFpsRange(i6, i2);
        }
        parameters.setPreviewFrameRate(30);
        parameters.getPreviewFpsRange(iArr2);
        this.m = (iArr2[0] + iArr2[1]) / 2000;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0055, code lost:
    
        if (r0 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(android.hardware.Camera.Parameters parameters, int i, int i2) {
        int i3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Preview size: expected size is ");
        sb.append(i2);
        sb.append(" ");
        sb.append(i);
        android.hardware.Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
        if (preferredPreviewSizeForVideo != null) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Camera preferred preview size for video is ");
            sb2.append(preferredPreviewSizeForVideo.width);
            sb2.append("x");
            sb2.append(preferredPreviewSizeForVideo.height);
        }
        java.util.List<android.hardware.Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        android.hardware.Camera.Size size = null;
        android.hardware.Camera.Size onChoosePreviewSize = this.p != null ? this.p.onChoosePreviewSize(new java.util.ArrayList(supportedPreviewSizes), preferredPreviewSizeForVideo) : null;
        boolean z = true;
        if (onChoosePreviewSize != null) {
            if (supportedPreviewSizes.contains(onChoosePreviewSize)) {
                preferredPreviewSizeForVideo = onChoosePreviewSize;
            }
            z = false;
        }
        if (!z) {
            java.util.ArrayList<android.hardware.Camera.Size> arrayList = new java.util.ArrayList();
            for (android.hardware.Camera.Size size2 : supportedPreviewSizes) {
                if (size == null || (size.width < size2.width && size.height < size2.height)) {
                    size = size2;
                }
                int i4 = size2.width;
                if (i4 >= i2 && (i3 = size2.height) >= i && java.lang.Math.min(i4 / i2, i3 / i) >= 1.0f) {
                    arrayList.add(size2);
                }
            }
            float f = Float.MAX_VALUE;
            for (android.hardware.Camera.Size size3 : arrayList) {
                float f2 = size3.width * size3.height;
                if (f2 < f) {
                    preferredPreviewSizeForVideo = size3;
                    f = f2;
                }
            }
            if (preferredPreviewSizeForVideo == null) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("use maxSize: ");
                sb3.append(size.width);
                sb3.append(" x ");
                sb3.append(size.height);
                preferredPreviewSizeForVideo = size;
            }
        }
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        sb4.append("choosePreviewSize, setPreviewSize, width = ");
        sb4.append(preferredPreviewSizeForVideo.width);
        sb4.append(", height = ");
        sb4.append(preferredPreviewSizeForVideo.height);
        parameters.setPreviewSize(preferredPreviewSizeForVideo.width, preferredPreviewSizeForVideo.height);
        int i5 = preferredPreviewSizeForVideo.width;
        this.d = i5;
        int i6 = preferredPreviewSizeForVideo.height;
        this.e = i6;
        this.u = com.aliyun.common.utils.AspectRatio.of(i5, i6);
        this.n = preferredPreviewSizeForVideo;
        this.I = preferredPreviewSizeForVideo.width / preferredPreviewSizeForVideo.height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        android.hardware.Camera camera = this.l;
        if (camera != null) {
            try {
                camera.cancelAutoFocus();
            } catch (java.lang.RuntimeException e2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(" cancelAutoFocus exception ");
                sb.append(e2.toString());
            }
        }
    }

    private void e() {
        java.util.List<android.hardware.Camera.Size> supportedPictureSizes = this.i.getSupportedPictureSizes();
        this.J.clear();
        for (android.hardware.Camera.Size size : supportedPictureSizes) {
            this.J.add(new com.aliyun.common.utils.Size(size.width, size.height));
        }
        java.util.SortedSet<com.aliyun.common.utils.Size> sizes = this.J.sizes(this.u);
        android.hardware.Camera.Size previewSize = this.i.getPreviewSize();
        if (sizes == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("choosePictureSize, previewSize ");
            sb.append(previewSize.width);
            sb.append("x");
            sb.append(previewSize.height);
            sb.append(" is not in pictureSize");
            return;
        }
        java.util.List<android.hardware.Camera.Size> a = a(sizes, supportedPictureSizes);
        com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback = this.r;
        android.hardware.Camera.Size size2 = null;
        android.hardware.Camera.Size onChoosePictureSize = onChoosePictureSizeCallback != null ? onChoosePictureSizeCallback.onChoosePictureSize(a) : null;
        if (onChoosePictureSize != null) {
            java.util.Iterator<com.aliyun.common.utils.Size> it = sizes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.aliyun.common.utils.Size next = it.next();
                if (next.getWidth() == onChoosePictureSize.width && next.getHeight() == onChoosePictureSize.height) {
                    size2 = onChoosePictureSize;
                    break;
                }
            }
        }
        if (size2 == null) {
            java.util.Iterator<com.aliyun.common.utils.Size> it2 = sizes.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                com.aliyun.common.utils.Size next2 = it2.next();
                if (next2.getWidth() == previewSize.width && next2.getHeight() == previewSize.height) {
                    size2 = previewSize;
                    break;
                }
            }
        }
        if (size2 == null) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("choosePictureSize, previewSize ");
            sb2.append(previewSize.width);
            sb2.append("x");
            sb2.append(previewSize.height);
            sb2.append(" is not in pictureSize");
            return;
        }
        this.i.setPictureSize(size2.width, size2.height);
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append("setPictureSize, width =  ");
        sb3.append(size2.width);
        sb3.append(", height = ");
        sb3.append(size2.height);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009b A[Catch: Exception -> 0x016f, all -> 0x018c, TryCatch #0 {Exception -> 0x016f, blocks: (B:9:0x000c, B:14:0x0016, B:16:0x0054, B:17:0x0057, B:19:0x005b, B:20:0x0062, B:22:0x0066, B:23:0x006d, B:30:0x0095, B:32:0x009b, B:33:0x00be, B:34:0x00e2, B:35:0x011b, B:37:0x011f, B:39:0x012e, B:50:0x00c2), top: B:8:0x000c, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f A[Catch: Exception -> 0x016f, all -> 0x018c, LOOP:0: B:35:0x011b->B:37:0x011f, LOOP_END, TryCatch #0 {Exception -> 0x016f, blocks: (B:9:0x000c, B:14:0x0016, B:16:0x0054, B:17:0x0057, B:19:0x005b, B:20:0x0062, B:22:0x0066, B:23:0x006d, B:30:0x0095, B:32:0x009b, B:33:0x00be, B:34:0x00e2, B:35:0x011b, B:37:0x011f, B:39:0x012e, B:50:0x00c2), top: B:8:0x000c, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c2 A[Catch: Exception -> 0x016f, all -> 0x018c, TryCatch #0 {Exception -> 0x016f, blocks: (B:9:0x000c, B:14:0x0016, B:16:0x0054, B:17:0x0057, B:19:0x005b, B:20:0x0062, B:22:0x0066, B:23:0x006d, B:30:0x0095, B:32:0x009b, B:33:0x00be, B:34:0x00e2, B:35:0x011b, B:37:0x011f, B:39:0x012e, B:50:0x00c2), top: B:8:0x000c, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int f() {
        int i;
        android.hardware.Camera.CameraInfo cameraInfo;
        java.lang.StringBuilder sb;
        int i2;
        int i3;
        synchronized (this.C) {
            if (this.B == 1) {
                try {
                    android.hardware.Camera.Parameters h = h();
                    this.i = h;
                    if (h == null) {
                        return -20005002;
                    }
                    a(h, this.f100s, this.t);
                    e();
                    android.graphics.Matrix matrix = new android.graphics.Matrix();
                    matrix.postScale(this.d / 2000.0f, this.e / 2000.0f);
                    matrix.postTranslate(this.d / 2, this.e / 2);
                    matrix.invert(this.A);
                    a(this.i, this.m);
                    int maxZoom = this.i.getMaxZoom();
                    java.lang.String str = this.f;
                    if (str != null) {
                        a(str);
                    }
                    java.lang.Integer num = this.g;
                    if (num != null) {
                        setFocusMode(num.intValue());
                    }
                    java.lang.Float f = this.h;
                    if (f != null) {
                        setExposureCompensationRatio(f.floatValue());
                    }
                    this.i.setZoom((int) (maxZoom * this.c));
                    android.hardware.Camera.getCameraInfo(this.v, this.k);
                    int i4 = this.a;
                    try {
                        if (i4 != 0) {
                            if (i4 == 1) {
                                i = 90;
                            } else if (i4 == 2) {
                                i = 180;
                            } else if (i4 == 3) {
                                i = 270;
                            }
                            cameraInfo = this.k;
                            if (cameraInfo.facing != 1) {
                                int i5 = cameraInfo.orientation;
                                this.w = ((270 - i5) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                                int i6 = (i5 + i) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                                this.b = i6;
                                this.b = (360 - i6) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                                sb = new java.lang.StringBuilder();
                                sb.append("facing front info.orientation is ");
                                i2 = this.k.orientation;
                            } else {
                                int i7 = cameraInfo.orientation;
                                this.w = ((i7 + 270) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                                this.b = ((i7 - i) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
                                sb = new java.lang.StringBuilder();
                                sb.append("facing back info.orientation is ");
                                i2 = this.k.orientation;
                            }
                            sb.append(i2);
                            this.l.setDisplayOrientation(this.b);
                            com.aliyun.svideosdk.a.e.a aVar = this.H;
                            android.hardware.Camera.Size size = this.n;
                            aVar.a(size.width, size.height, this.b);
                            setCameraParam(this.o);
                            android.graphics.SurfaceTexture j = this.H.j();
                            j.setOnFrameAvailableListener(this);
                            this.l.setPreviewTexture(j);
                            this.l.setPreviewCallbackWithBuffer(null);
                            android.hardware.Camera.Size size2 = this.n;
                            int i8 = ((size2.width * size2.height) * 3) / 2;
                            for (i3 = 0; i3 < this.D; i3++) {
                                byte[] bArr = new byte[i8];
                                this.E.add(bArr);
                                this.l.addCallbackBuffer(bArr);
                            }
                            this.l.setPreviewCallbackWithBuffer(this);
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("doStartPreview, setPreviewCallbackWithBuffer, mCameraBufferNum = ");
                            sb2.append(this.D);
                            this.l.setParameters(this.i);
                            this.l.startPreview();
                            this.B = 2;
                        }
                        this.l.startPreview();
                        this.B = 2;
                    } catch (java.lang.RuntimeException e2) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("Start Preview failed ");
                        sb3.append(e2.getMessage());
                        com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback = this.p;
                        if (onFrameCallback != null) {
                            onFrameCallback.openFailed();
                        }
                        return -20005001;
                    }
                    i = 0;
                    cameraInfo = this.k;
                    if (cameraInfo.facing != 1) {
                    }
                    sb.append(i2);
                    this.l.setDisplayOrientation(this.b);
                    com.aliyun.svideosdk.a.e.a aVar2 = this.H;
                    android.hardware.Camera.Size size3 = this.n;
                    aVar2.a(size3.width, size3.height, this.b);
                    setCameraParam(this.o);
                    android.graphics.SurfaceTexture j2 = this.H.j();
                    j2.setOnFrameAvailableListener(this);
                    this.l.setPreviewTexture(j2);
                    this.l.setPreviewCallbackWithBuffer(null);
                    android.hardware.Camera.Size size22 = this.n;
                    int i82 = ((size22.width * size22.height) * 3) / 2;
                    while (i3 < this.D) {
                    }
                    this.l.setPreviewCallbackWithBuffer(this);
                    java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
                    sb22.append("doStartPreview, setPreviewCallbackWithBuffer, mCameraBufferNum = ");
                    sb22.append(this.D);
                    this.l.setParameters(this.i);
                } catch (java.lang.Exception e3) {
                    com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback2 = this.p;
                    if (onFrameCallback2 != null) {
                        onFrameCallback2.openFailed();
                    }
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    sb4.append("Open Camera failed ");
                    sb4.append(e3.getMessage());
                    return -20005002;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.hardware.Camera.Parameters h() {
        synchronized (this.C) {
            android.hardware.Camera.Parameters parameters = null;
            if (this.l == null) {
                return null;
            }
            if (this.B == 3) {
                return null;
            }
            try {
                parameters = this.l.getParameters();
            } catch (java.lang.RuntimeException e2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Camera getParameters Exception ,msg : ");
                sb.append(e2.getMessage());
            }
            return parameters;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int a() {
        return this.w;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int a(int i, int i2, int i3) {
        synchronized (this.C) {
            if (this.B != 3) {
                return -4;
            }
            this.f100s = i;
            this.t = i2;
            this.v = i3;
            try {
                this.l = android.hardware.Camera.open(i3);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Open camera success!, Camera is ");
                sb.append(this.l);
                this.B = 1;
                int f = f();
                if (this.K != null) {
                    this.H.m();
                    com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter = this.K;
                    com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback h = this.H.h();
                    int i4 = this.d;
                    int i5 = this.e;
                    alivcRecorderReporter.sendStartPreviewEvent(h, i4, i5, i4, i5, 0, this.H.c(), 1);
                }
                if (f == 0) {
                    this.j = false;
                    return 0;
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("do start preview failed, return error ");
                sb2.append(f);
                return f;
            } catch (java.lang.RuntimeException e2) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("Camera open exception ");
                sb3.append(e2.toString());
                return 1073754176;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(float f, float f2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("manualFocus camera = ");
        sb.append(this.l);
        sb.append(", focusing = ");
        sb.append(this.j);
        synchronized (this.C) {
            if (this.l != null && !this.j) {
                if (this.B == 3) {
                    return;
                }
                b("manualFocus");
                float[] fArr = {f * this.d, f2 * this.e};
                this.A.mapPoints(fArr);
                float f3 = fArr[0];
                int i = (int) (f3 - 100.0f);
                int i2 = (int) (f3 + 100.0f);
                float f4 = fArr[1];
                int i3 = (int) (f4 - 100.0f);
                int i4 = (int) (f4 + 100.0f);
                if (i < -1000) {
                    i2 = -800;
                    i = -1000;
                } else if (i2 > 1000) {
                    i2 = 1000;
                    i = 800;
                }
                if (i3 < -1000) {
                    i4 = -800;
                    i3 = -1000;
                } else if (i4 > 1000) {
                    i4 = 1000;
                    i3 = 800;
                }
                android.graphics.Rect rect = new android.graphics.Rect(i, i3, i2, i4);
                android.graphics.Rect rect2 = new android.graphics.Rect(i, i3, i2, i4);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("focus area : left");
                sb2.append(rect.left);
                sb2.append(" top ");
                sb2.append(rect.top);
                sb2.append(" right ");
                sb2.append(rect.right);
                sb2.append(" bottom ");
                sb2.append(rect.bottom);
                android.hardware.Camera.Parameters h = h();
                if (h != null && h.getFocusMode() != null && ((h.getFocusMode().contains("auto") || h.getFocusMode().contains("continuous-video") || h.getFocusMode().contains("continuous-picture") || h.getFocusMode().contains("fixed")) && (h.getMaxNumFocusAreas() >= 1 || h.getMaxNumMeteringAreas() >= 1))) {
                    if (h.getMaxNumFocusAreas() > 0) {
                        h.setFocusAreas((rect.width() <= 0 || rect.height() <= 0) ? null : java.util.Arrays.asList(new android.hardware.Camera.Area(rect, 1000)));
                    }
                    if (h.getMaxNumMeteringAreas() > 0) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        arrayList.add(new android.hardware.Camera.Area(rect2, 1000));
                        h.setMeteringAreas(arrayList);
                    }
                    if (h.isAutoExposureLockSupported()) {
                        h.setAutoExposureLock(true);
                    }
                    if (h.isAutoWhiteBalanceLockSupported()) {
                        h.setAutoWhiteBalanceLock(true);
                    }
                    try {
                        this.l.setParameters(h);
                        this.j = true;
                        this.l.autoFocus(new com.aliyun.svideosdk.preview.camera.a.e());
                        android.os.Handler handler = this.O;
                        if (handler != null) {
                            handler.removeCallbacks(this.P, null);
                            this.O.postDelayed(this.P, 1500L);
                        }
                    } catch (java.lang.Exception e2) {
                        this.j = false;
                        b("try exception");
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("Auto focus failed! ");
                        sb3.append(e2.toString());
                    }
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(int i) {
        this.m = i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(android.graphics.Point point) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.a aVar) {
        this.q = aVar;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.b bVar) {
        this.H.a(new com.aliyun.svideosdk.preview.camera.a.d(bVar));
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.c cVar) {
        synchronized (this.C) {
            if (this.B == 2 && this.l != null) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                long j = currentTimeMillis - this.N;
                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "takePhoto: isTakingPicture=" + this.z + ", interval=" + j);
                if (!this.z || j >= 2000) {
                    this.N = currentTimeMillis;
                    this.z = true;
                    try {
                        this.l.setParameters(this.i);
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                    this.l.takePicture(this.x ? new com.aliyun.svideosdk.preview.camera.a.b(this, cVar) : null, null, new com.aliyun.svideosdk.preview.camera.a.c(java.lang.System.currentTimeMillis(), cVar));
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.r = onChoosePictureSizeCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized void a(boolean z) {
        if (this.G == 0) {
            this.F = z;
            this.H.a(this.I, this.d, this.e);
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean a(java.lang.String str) {
        synchronized (this.C) {
            boolean z = true;
            if (this.l == null) {
                this.f = str;
                return true;
            }
            android.hardware.Camera.Parameters parameters = this.i;
            if (parameters == null) {
                return false;
            }
            java.util.List<java.lang.String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes == null) {
                return false;
            }
            if (supportedFlashModes.contains(str)) {
                this.i.setFlashMode(str);
                try {
                    this.l.setParameters(this.i);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
                return z;
            }
            z = false;
            return z;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean b() {
        return this.B == 2;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public android.hardware.Camera.CameraInfo c() {
        return this.k;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void d() {
        synchronized (this.C) {
            try {
                android.os.Handler handler = this.O;
                if (handler != null) {
                    handler.removeCallbacks(this.P, null);
                }
                android.hardware.Camera camera = this.l;
                if (camera != null) {
                    camera.cancelAutoFocus();
                }
            } catch (java.lang.Exception unused) {
            }
            try {
                android.hardware.Camera camera2 = this.l;
                if (camera2 != null) {
                    camera2.setPreviewCallbackWithBuffer(null);
                    this.l.setZoomChangeListener(null);
                    g();
                    this.l.lock();
                    this.l.release();
                    if (this.K != null) {
                        this.H.l();
                        com.aliyun.svideosdk.a.d.a i = this.H.i();
                        this.H.f();
                        com.aliyun.svideosdk.a.d.a g = this.H.g();
                        com.aliyun.svideosdk.a.d.a k = this.H.k();
                        this.K.sendStopPreviewEvent(i.g(), i.e(), i.d(), i.h(), g.d(), g.h(), k.d(), k.h(), i.i());
                    }
                }
                this.l = null;
            } catch (java.lang.Exception unused2) {
                this.l = null;
            } catch (java.lang.Throwable th) {
                this.l = null;
                this.B = 3;
                this.i = null;
                throw th;
            }
            this.B = 3;
            this.i = null;
            this.E.clear();
        }
    }

    public void g() {
        synchronized (this.C) {
            android.os.Handler handler = this.O;
            if (handler != null) {
                handler.removeCallbacks(this.P, null);
            }
            if (this.B == 2) {
                android.hardware.Camera camera = this.l;
                if (camera != null) {
                    camera.stopPreview();
                }
                this.B = 1;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int getCameraCount() {
        return android.hardware.Camera.getNumberOfCameras();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public float getCurrentExposureCompensationRatio() {
        synchronized (this.C) {
            if (this.i == null) {
                return 0.0f;
            }
            return (r1.getExposureCompensation() - this.i.getMinExposureCompensation()) / (this.i.getMaxExposureCompensation() - this.i.getMinExposureCompensation());
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public java.util.List<android.hardware.Camera.Size> getSupportedPictureSize() {
        synchronized (this.C) {
            if (this.B != 3) {
                android.hardware.Camera.Parameters h = h();
                if (this.l != null && h != null) {
                    return h.getSupportedPictureSizes();
                }
            }
            return null;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes() {
        synchronized (this.C) {
            if (this.B == 3 || !this.J.ratios().contains(this.u)) {
                return null;
            }
            return this.J.sizes(this.u);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        if (this.F) {
            this.H.a(true, this.I, this.d, this.e);
            return;
        }
        synchronized (this.M) {
            this.L = true;
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, android.hardware.Camera camera) {
        com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback = this.p;
        if (onFrameCallback != null) {
            onFrameCallback.onFrameBack(bArr, this.d, this.e, this.k);
        }
        com.aliyun.svideosdk.a.a aVar = this.q;
        if (aVar != null) {
            aVar.onFrameBack(bArr, this.d, this.e, this.k);
        }
        if (camera != null) {
            camera.addCallbackBuffer(bArr);
        }
        if (this.F || this.B != 2) {
            return;
        }
        synchronized (this.M) {
            if (this.L) {
                this.L = false;
                this.H.a(this.I, this.d, this.e);
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int release() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraCaptureDataMode(int i) {
        this.G = i;
        if (1 == i) {
            this.F = false;
        } else if (2 == i) {
            this.F = true;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
        if (cameraParam == null) {
            return;
        }
        synchronized (this.C) {
            if (this.l == null) {
                this.o = cameraParam;
            } else {
                if (this.i == null) {
                    this.i = h();
                }
                if (this.i != null) {
                    setExposureCompensationRatio(cameraParam.getExposureCompensationRatio());
                    this.i.setZoom((int) (this.i.getMaxZoom() * cameraParam.getZoomRatio()));
                    int focusMode = cameraParam.getFocusMode();
                    java.lang.String str = "";
                    if (focusMode == 1) {
                        str = "auto";
                    } else if (focusMode == 0) {
                        str = "continuous-video";
                    }
                    if (this.i.getSupportedFocusModes().contains(str)) {
                        this.i.setFocusMode(str);
                    }
                    java.lang.String flashType = cameraParam.getFlashType();
                    java.util.List<java.lang.String> supportedFlashModes = this.i.getSupportedFlashModes();
                    if (supportedFlashModes != null && supportedFlashModes.contains(flashType)) {
                        this.i.setFlashMode(flashType);
                    }
                    try {
                        this.l.setParameters(this.i);
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int setExposureCompensationRatio(float f) {
        synchronized (this.C) {
            try {
                if (this.l == null) {
                    this.h = java.lang.Float.valueOf(f);
                    return -20005007;
                }
                int maxExposureCompensation = this.i.getMaxExposureCompensation();
                int minExposureCompensation = this.i.getMinExposureCompensation();
                if (maxExposureCompensation == 0 && minExposureCompensation == 0) {
                    return -20003002;
                }
                this.i.setExposureCompensation((int) (minExposureCompensation + ((maxExposureCompensation - minExposureCompensation) * f)));
                this.l.setParameters(this.i);
                return 0;
            } catch (java.lang.Exception unused) {
                return -20005006;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setFocusMode(int i) {
        synchronized (this.C) {
            if (this.l == null) {
                this.g = java.lang.Integer.valueOf(i);
                return;
            }
            if (this.B == 3) {
                return;
            }
            java.lang.String str = "";
            if (i == 1) {
                str = "auto";
            } else if (i == 0) {
                str = "continuous-video";
            }
            java.util.List<java.lang.String> supportedFocusModes = this.i.getSupportedFocusModes();
            if (!str.isEmpty() && supportedFocusModes.contains(str)) {
                this.i.setFocusMode(str);
                try {
                    this.l.setParameters(this.i);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("focus mode is invalid ");
            sb.append(i);
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback) {
        this.p = onFrameCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setPictureSize(int i, int i2) {
        boolean z;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setPictureSize: width = ");
        sb.append(i);
        sb.append(", height = ");
        sb.append(i2);
        java.util.List<android.hardware.Camera.Size> supportedPictureSize = getSupportedPictureSize();
        if (supportedPictureSize == null) {
            return -1;
        }
        com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter = this.K;
        if (alivcRecorderReporter != null) {
            alivcRecorderReporter.sendSetPictureSizeEvent(i, i2, supportedPictureSize);
        }
        java.util.Iterator<android.hardware.Camera.Size> it = supportedPictureSize.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            android.hardware.Camera.Size next = it.next();
            if (next.width == i && next.height == i2) {
                z = false;
                break;
            }
        }
        if (z) {
            return -20003015;
        }
        synchronized (this.C) {
            android.hardware.Camera.Parameters parameters = this.i;
            if (parameters != null) {
                parameters.setPictureSize(i, i2);
            }
            try {
                this.l.setParameters(this.i);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setRotation(int i) {
        this.a = i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setShutterSound(boolean z) {
        this.x = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setTakePicturePreview(boolean z) {
        this.y = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int setZoom(float f) {
        synchronized (this.C) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.c = f;
            if (this.l == null) {
                return -20005007;
            }
            try {
                this.i.setZoom((int) (this.i.getMaxZoom() * f));
                this.l.setParameters(this.i);
                return 0;
            } catch (java.lang.Exception unused) {
                return -20005006;
            }
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int startPreviewAfterTakePicture() {
        int i;
        synchronized (this.C) {
            if (this.B != 3) {
                try {
                    android.hardware.Camera camera = this.l;
                    if (camera != null) {
                        camera.startPreview();
                    } else {
                        i = -20003002;
                    }
                } catch (java.lang.RuntimeException e2) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Start Preview failed ");
                    sb.append(e2.getMessage());
                    com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback = this.p;
                    if (onFrameCallback != null) {
                        onFrameCallback.openFailed();
                    }
                    return -20005001;
                }
            }
            i = 0;
        }
        return i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public synchronized int switchCamera() {
        if (this.v == 0) {
            this.v = 1;
        } else {
            this.v = 0;
        }
        d();
        if (a(this.f100s, this.t, this.v) != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("switchCamera failed, mCameraId = ");
            sb.append(this.v);
        }
        return this.v;
    }
}
