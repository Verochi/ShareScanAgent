package com.aliyun.svideosdk.preview.camera;

@android.annotation.TargetApi(21)
/* loaded from: classes12.dex */
public class b implements com.aliyun.svideosdk.preview.camera.f, android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private static final java.lang.String Z = "b";
    private static final android.util.SparseIntArray a0;
    private static final com.aliyun.common.utils.AspectRatio b0;
    private android.hardware.camera2.CameraDevice A;
    private android.hardware.camera2.CameraCaptureSession B;
    private android.hardware.camera2.CaptureRequest.Builder C;
    private android.hardware.camera2.CaptureRequest.Builder D;
    private android.media.ImageReader E;
    private android.media.ImageReader F;
    private android.view.Surface H;
    private com.aliyun.svideosdk.preview.utils.c I;
    private com.aliyun.svideosdk.preview.utils.b J;
    private android.media.MediaActionSound K;
    private android.graphics.Rect N;
    private int O;
    private android.hardware.camera2.CameraManager a;
    private int c;
    private com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback d;
    private com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback e;
    private boolean f;
    private boolean g;
    private com.aliyun.svideosdk.a.a h;
    private com.aliyun.svideosdk.a.c i;
    private com.aliyun.svideosdk.a.e.a j;
    private com.aliyun.common.log.reporter.AlivcRecorderReporter k;
    private android.os.HandlerThread l;
    private android.os.Handler m;
    private int n;
    private android.hardware.camera2.CameraCharacteristics r;
    private int v;
    private int w;
    private java.lang.String b = com.aliyun.svideosdk.common.struct.recorder.FlashType.OFF.toString();
    private android.hardware.Camera.CameraInfo o = new android.hardware.Camera.CameraInfo();
    private int p = 0;
    private java.lang.String q = "0";

    /* renamed from: s, reason: collision with root package name */
    private final java.util.List<com.aliyun.common.utils.Size> f101s = new java.util.ArrayList();
    private final com.aliyun.common.utils.SizeMap t = new com.aliyun.common.utils.SizeMap();
    private final com.aliyun.common.utils.SizeMap u = new com.aliyun.common.utils.SizeMap();
    private com.aliyun.common.utils.Size x = null;
    private com.aliyun.common.utils.Size y = null;
    private com.aliyun.common.utils.AspectRatio z = b0;
    volatile android.media.Image G = null;
    private float L = 0.0f;
    private android.graphics.Rect M = new android.graphics.Rect();
    private int P = 0;
    android.util.Range<java.lang.Integer> Q = null;
    private volatile long R = 0;
    private int S = 7;
    private final android.hardware.camera2.CameraDevice.StateCallback T = new com.aliyun.svideosdk.preview.camera.b.a();
    private final android.hardware.camera2.CameraCaptureSession.StateCallback U = new com.aliyun.svideosdk.preview.camera.b.C0107b();
    android.hardware.camera2.CameraCaptureSession.CaptureCallback V = new com.aliyun.svideosdk.preview.camera.b.c();
    private final android.hardware.camera2.CameraCaptureSession.CaptureCallback W = new com.aliyun.svideosdk.preview.camera.b.d();
    private final android.media.ImageReader.OnImageAvailableListener X = new com.aliyun.svideosdk.preview.camera.b.e();
    private final android.media.ImageReader.OnImageAvailableListener Y = new com.aliyun.svideosdk.preview.camera.b.f();

    public class a extends android.hardware.camera2.CameraDevice.StateCallback {
        public a() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(android.hardware.camera2.CameraDevice cameraDevice) {
            java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(android.hardware.camera2.CameraDevice cameraDevice) {
            com.aliyun.svideosdk.preview.camera.b.this.A = null;
            java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(android.hardware.camera2.CameraDevice cameraDevice, int i) {
            java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("StateCallback.onError., onError: ");
            sb.append(cameraDevice.getId());
            sb.append(" (");
            sb.append(i);
            sb.append(")");
            com.aliyun.svideosdk.preview.camera.b.this.A = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(android.hardware.camera2.CameraDevice cameraDevice) {
            com.aliyun.svideosdk.preview.camera.b.this.A = cameraDevice;
            java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
            com.aliyun.svideosdk.preview.camera.b.this.o();
        }
    }

    /* renamed from: com.aliyun.svideosdk.preview.camera.b$b, reason: collision with other inner class name */
    public class C0107b extends android.hardware.camera2.CameraCaptureSession.StateCallback {
        public C0107b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
            if (com.aliyun.svideosdk.preview.camera.b.this.B == null || !com.aliyun.svideosdk.preview.camera.b.this.B.equals(cameraCaptureSession)) {
                return;
            }
            com.aliyun.svideosdk.preview.camera.b.this.B = null;
            java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
            java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
            if (com.aliyun.svideosdk.preview.camera.b.this.A == null) {
                return;
            }
            java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
            com.aliyun.svideosdk.preview.camera.b.this.B = cameraCaptureSession;
            com.aliyun.svideosdk.preview.camera.b.this.q();
            com.aliyun.svideosdk.preview.camera.b.this.I.a(com.aliyun.svideosdk.preview.camera.b.this.j(), com.aliyun.svideosdk.preview.camera.b.this.b);
            com.aliyun.svideosdk.preview.camera.b.this.n();
        }
    }

    public class c extends android.hardware.camera2.CameraCaptureSession.CaptureCallback {
        public c() {
        }

        private void a(android.hardware.camera2.CaptureResult captureResult) {
            int i = com.aliyun.svideosdk.preview.camera.b.this.S;
            if (i == 2) {
                java.lang.Integer num = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    return;
                }
                if (num.intValue() != 4 && num.intValue() != 5) {
                    return;
                }
                java.lang.Integer num2 = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE);
                if (num2 != null && num2.intValue() != 2) {
                    com.aliyun.svideosdk.preview.camera.b.this.S = 3;
                    com.aliyun.svideosdk.preview.camera.b.this.l();
                    return;
                }
            } else {
                if (i == 4) {
                    java.lang.Integer num3 = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE);
                    if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4 || num3.intValue() == 2) {
                        com.aliyun.svideosdk.preview.camera.b.this.S = 5;
                        return;
                    }
                    return;
                }
                if (i != 5) {
                    return;
                }
                java.lang.Integer num4 = (java.lang.Integer) captureResult.get(android.hardware.camera2.CaptureResult.CONTROL_AE_STATE);
                if (num4 != null && num4.intValue() == 5) {
                    return;
                }
            }
            com.aliyun.svideosdk.preview.camera.b.this.S = 6;
            com.aliyun.svideosdk.preview.camera.b.this.f();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
            a(totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CaptureResult captureResult) {
            a(captureResult);
        }
    }

    public class d extends android.hardware.camera2.CameraCaptureSession.CaptureCallback {
        public d() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
            if (com.aliyun.svideosdk.preview.camera.b.this.g) {
                com.aliyun.svideosdk.preview.camera.b.this.p();
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(android.hardware.camera2.CameraCaptureSession cameraCaptureSession, android.hardware.camera2.CaptureRequest captureRequest, long j, long j2) {
            if (com.aliyun.svideosdk.preview.camera.b.this.f) {
                com.aliyun.svideosdk.preview.camera.b.this.K.play(0);
            }
        }
    }

    public class e implements android.media.ImageReader.OnImageAvailableListener {
        public e() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(android.media.ImageReader imageReader) {
            android.media.Image acquireNextImage = imageReader.acquireNextImage();
            try {
                android.media.Image.Plane[] planes = acquireNextImage.getPlanes();
                if (planes.length > 0) {
                    java.lang.String unused = com.aliyun.svideosdk.preview.camera.b.Z;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("onImageAvailable, image width = ");
                    sb.append(acquireNextImage.getWidth());
                    sb.append(", height = ");
                    sb.append(acquireNextImage.getHeight());
                    java.nio.ByteBuffer buffer = planes[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    if (com.aliyun.svideosdk.preview.camera.b.this.i != null) {
                        com.aliyun.svideosdk.preview.camera.b.this.i.a(bArr);
                    }
                }
                acquireNextImage.close();
            } catch (java.lang.Throwable th) {
                try {
                    throw th;
                } catch (java.lang.Throwable th2) {
                    if (acquireNextImage != null) {
                        try {
                            acquireNextImage.close();
                        } catch (java.lang.Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    public class f implements android.media.ImageReader.OnImageAvailableListener {
        public f() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(android.media.ImageReader imageReader) {
            try {
                try {
                    com.aliyun.svideosdk.preview.camera.b.this.G = imageReader.acquireNextImage();
                } catch (java.lang.Exception unused) {
                    java.lang.String unused2 = com.aliyun.svideosdk.preview.camera.b.Z;
                    if (com.aliyun.svideosdk.preview.camera.b.this.G == null) {
                        return;
                    }
                }
                if (com.aliyun.svideosdk.preview.camera.b.this.G.getTimestamp() < com.aliyun.svideosdk.preview.camera.b.this.R) {
                    java.lang.String unused3 = com.aliyun.svideosdk.preview.camera.b.Z;
                    if (com.aliyun.svideosdk.preview.camera.b.this.G != null) {
                        com.aliyun.svideosdk.preview.camera.b.this.G.close();
                        com.aliyun.svideosdk.preview.camera.b.this.G = null;
                        return;
                    }
                    return;
                }
                android.media.Image.Plane[] planes = com.aliyun.svideosdk.preview.camera.b.this.G.getPlanes();
                if (planes.length > 0) {
                    java.nio.ByteBuffer buffer = planes[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    if (com.aliyun.svideosdk.preview.camera.b.this.d != null) {
                        com.aliyun.svideosdk.preview.camera.b.this.d.onFrameBack(bArr, com.aliyun.svideosdk.preview.camera.b.this.G.getWidth(), com.aliyun.svideosdk.preview.camera.b.this.G.getHeight(), com.aliyun.svideosdk.preview.camera.b.this.o);
                    }
                    if (com.aliyun.svideosdk.preview.camera.b.this.h != null) {
                        com.aliyun.svideosdk.preview.camera.b.this.h.onFrameBack(bArr, com.aliyun.svideosdk.preview.camera.b.this.G.getWidth(), com.aliyun.svideosdk.preview.camera.b.this.G.getHeight(), com.aliyun.svideosdk.preview.camera.b.this.o);
                    }
                    if (com.aliyun.svideosdk.preview.camera.b.this.j != null) {
                        com.aliyun.svideosdk.preview.camera.b.this.j.a(com.aliyun.svideosdk.preview.camera.b.this.z.toFloat(), com.aliyun.svideosdk.preview.camera.b.this.x.getWidth(), com.aliyun.svideosdk.preview.camera.b.this.x.getHeight());
                    }
                }
                if (com.aliyun.svideosdk.preview.camera.b.this.G == null) {
                    return;
                }
                com.aliyun.svideosdk.preview.camera.b.this.G.close();
                com.aliyun.svideosdk.preview.camera.b.this.G = null;
            } catch (java.lang.Throwable th) {
                if (com.aliyun.svideosdk.preview.camera.b.this.G != null) {
                    com.aliyun.svideosdk.preview.camera.b.this.G.close();
                    com.aliyun.svideosdk.preview.camera.b.this.G = null;
                }
                throw th;
            }
        }
    }

    public class g implements java.lang.Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (7 != com.aliyun.svideosdk.preview.camera.b.this.S) {
                com.aliyun.svideosdk.preview.camera.b.this.p();
            }
        }
    }

    public class h implements com.aliyun.svideosdk.a.e.a.d {
        final /* synthetic */ com.aliyun.svideosdk.a.b a;

        public h(com.aliyun.svideosdk.a.b bVar) {
            this.a = bVar;
        }

        @Override // com.aliyun.svideosdk.a.e.a.d
        public void a(int i, int i2, java.nio.ByteBuffer byteBuffer) {
            com.aliyun.svideosdk.a.b bVar = this.a;
            if (bVar != null) {
                bVar.a(i, i2, com.aliyun.svideosdk.preview.camera.b.this.c(), byteBuffer);
            }
        }
    }

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        a0 = sparseIntArray;
        sparseIntArray.put(0, 1);
        sparseIntArray.put(1, 0);
        b0 = com.aliyun.common.utils.AspectRatio.of(16, 9);
    }

    public b(android.content.Context context, com.aliyun.svideosdk.a.e.a aVar, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter) {
        this.j = aVar;
        this.k = alivcRecorderReporter;
        this.a = (android.hardware.camera2.CameraManager) context.getApplicationContext().getSystemService(com.sensorsdata.sf.ui.view.UIProperty.action_type_camera);
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("camera-background");
        this.l = handlerThread;
        handlerThread.start();
        this.m = new android.os.Handler(this.l.getLooper());
        this.I = new com.aliyun.svideosdk.preview.utils.c();
        this.J = new com.aliyun.svideosdk.preview.utils.b();
        this.K = new android.media.MediaActionSound();
    }

    private android.hardware.camera2.CaptureRequest.Builder a(boolean z, java.util.List<android.view.Surface> list) {
        if (z) {
            return a(2, list);
        }
        if (this.D == null) {
            this.D = a(2, list);
        }
        return this.D;
    }

    private com.aliyun.common.utils.Size a(int i, int i2) {
        com.aliyun.common.utils.Size size = new com.aliyun.common.utils.Size(i2, i);
        com.aliyun.common.utils.Size size2 = null;
        if (!this.f101s.contains(size)) {
            size = null;
        }
        if (this.d != null) {
            new java.util.ArrayList(this.f101s);
        }
        if (size == null) {
            java.util.ArrayList<com.aliyun.common.utils.Size> arrayList = new java.util.ArrayList();
            for (com.aliyun.common.utils.Size size3 : this.f101s) {
                if (size2 == null) {
                    size2 = size3;
                }
                if (size2.getWidth() < size3.getWidth() && size2.getHeight() < size3.getHeight()) {
                    size2 = size3;
                }
                if (size3.getWidth() >= i2 && size3.getHeight() >= i && java.lang.Math.min(size3.getWidth() / i2, size3.getHeight() / i) >= 1.0f) {
                    arrayList.add(size3);
                }
            }
            float f2 = Float.MAX_VALUE;
            for (com.aliyun.common.utils.Size size4 : arrayList) {
                float width = size4.getWidth() * size4.getHeight();
                if (width < f2) {
                    size = size4;
                    f2 = width;
                }
            }
            if (size == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("use maxSize: ");
                sb.append(size2.getWidth());
                sb.append(" x ");
                sb.append(size2.getHeight());
                size = size2;
            }
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("mAspectRatio = ");
        sb2.append(this.z.toString());
        sb2.append(", bestPreviewSize, width = ");
        sb2.append(size.getWidth());
        sb2.append(", height = ");
        sb2.append(size.getHeight());
        this.z = com.aliyun.common.utils.AspectRatio.of(size.getWidth(), size.getHeight());
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(this.E.getSurface());
            android.hardware.camera2.CaptureRequest.Builder a2 = a(false, (java.util.List<android.view.Surface>) arrayList);
            android.hardware.camera2.CaptureRequest.Key key = android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE;
            a2.set(key, this.C.get(key));
            a2.set(android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION, this.M);
            a2.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, java.lang.Integer.valueOf(this.P));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("captureStillPicture, mExposureCompensation = ");
            sb.append(this.P);
            this.I.a(a2, this.b);
            int intValue = ((java.lang.Integer) this.r.get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            android.hardware.camera2.CaptureRequest.Key key2 = android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION;
            int i = this.n;
            int i2 = 1;
            if (this.p != 1) {
                i2 = -1;
            }
            a2.set(key2, java.lang.Integer.valueOf(((intValue + (i * i2)) + com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE));
            this.B.stopRepeating();
            this.B.abortCaptures();
            this.B.capture(a2.build(), this.W, this.m);
        } catch (android.hardware.camera2.CameraAccessException unused) {
        }
    }

    private boolean g() {
        try {
            int i = a0.get(this.p);
            java.lang.String[] cameraIdList = this.a.getCameraIdList();
            if (cameraIdList.length == 0) {
                throw new java.lang.RuntimeException("No camera available.");
            }
            for (java.lang.String str : cameraIdList) {
                android.hardware.camera2.CameraCharacteristics cameraCharacteristics = this.a.getCameraCharacteristics(str);
                if (((java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)) != null) {
                    java.lang.Integer num = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING);
                    if (num == null) {
                        throw new java.lang.NullPointerException("Unexpected state: LENS_FACING null");
                    }
                    if (num.intValue() == i) {
                        this.q = str;
                        this.r = cameraCharacteristics;
                        return true;
                    }
                }
            }
            java.lang.String str2 = cameraIdList[0];
            this.q = str2;
            android.hardware.camera2.CameraCharacteristics cameraCharacteristics2 = this.a.getCameraCharacteristics(str2);
            this.r = cameraCharacteristics2;
            java.lang.Integer num2 = (java.lang.Integer) cameraCharacteristics2.get(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            if (num2 != null && num2.intValue() != 2) {
                java.lang.Integer num3 = (java.lang.Integer) this.r.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING);
                if (num3 == null) {
                    throw new java.lang.NullPointerException("Unexpected state: LENS_FACING null");
                }
                int size = a0.size();
                for (int i2 = 0; i2 < size; i2++) {
                    android.util.SparseIntArray sparseIntArray = a0;
                    if (sparseIntArray.valueAt(i2) == num3.intValue()) {
                        this.p = sparseIntArray.keyAt(i2);
                        return true;
                    }
                }
                this.p = 0;
                return true;
            }
            return false;
        } catch (android.hardware.camera2.CameraAccessException e2) {
            throw new java.lang.RuntimeException("Failed to get a list of camera devices", e2);
        }
    }

    private com.aliyun.common.utils.Size h() {
        com.aliyun.common.utils.Size size = this.x;
        java.util.SortedSet<com.aliyun.common.utils.Size> unmodifiableSortedSet = java.util.Collections.unmodifiableSortedSet(this.u.sizes(this.z));
        if (!unmodifiableSortedSet.contains(size)) {
            size = null;
        }
        com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback = this.e;
        com.aliyun.common.utils.Size onChoosePictureSize = onChoosePictureSizeCallback != null ? onChoosePictureSizeCallback.onChoosePictureSize(unmodifiableSortedSet) : null;
        if (onChoosePictureSize != null && unmodifiableSortedSet.contains(onChoosePictureSize)) {
            size = onChoosePictureSize;
        }
        if (size == null) {
            size = unmodifiableSortedSet.last();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("bestPictureSize, width = ");
        sb.append(size.getWidth());
        sb.append(", height = ");
        sb.append(size.getHeight());
        return size;
    }

    private void i() {
        android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) this.r.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new java.lang.IllegalStateException("Failed to get configuration map: " + this.p);
        }
        this.t.clear();
        for (android.util.Size size : streamConfigurationMap.getOutputSizes(android.graphics.SurfaceTexture.class)) {
            this.t.add(new com.aliyun.common.utils.Size(size.getWidth(), size.getHeight()));
        }
        this.u.clear();
        for (android.util.Size size2 : streamConfigurationMap.getOutputSizes(256)) {
            this.u.add(new com.aliyun.common.utils.Size(size2.getWidth(), size2.getHeight()));
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.common.utils.AspectRatio aspectRatio : this.t.ratios()) {
            if (!this.u.ratios().contains(aspectRatio)) {
                arrayList.add(aspectRatio);
            }
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.t.remove((com.aliyun.common.utils.AspectRatio) it.next());
        }
        this.f101s.clear();
        java.util.Iterator<com.aliyun.common.utils.AspectRatio> it2 = this.t.ratios().iterator();
        while (it2.hasNext()) {
            java.util.Iterator<com.aliyun.common.utils.Size> it3 = this.t.sizes(it2.next()).iterator();
            while (it3.hasNext()) {
                this.f101s.add(it3.next());
            }
        }
        this.L = ((java.lang.Float) this.r.get(android.hardware.camera2.CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        this.N = (android.graphics.Rect) this.r.get(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        this.O = ((java.lang.Integer) this.r.get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        this.Q = (android.util.Range) this.r.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("collectCameraInfo, mMaxZoom = ");
        sb.append(this.L);
        sb.append(", mSensorInfoSize = ");
        sb.append(this.N.width());
        sb.append(" x ");
        sb.append(this.N.width());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.hardware.camera2.CaptureRequest.Builder j() {
        if (this.C == null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(this.H);
            arrayList.add(this.F.getSurface());
            android.hardware.camera2.CaptureRequest.Builder a2 = a(1, arrayList);
            this.C = a2;
            a2.set(android.hardware.camera2.CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
            this.S = 0;
        }
        return this.C;
    }

    private void k() {
        android.media.ImageReader imageReader = this.E;
        if (imageReader != null) {
            imageReader.close();
            this.E = null;
        }
        android.media.ImageReader newInstance = android.media.ImageReader.newInstance(this.y.getWidth(), this.y.getHeight(), 256, 2);
        this.E = newInstance;
        newInstance.setOnImageAvailableListener(this.X, this.m);
        android.media.ImageReader imageReader2 = this.F;
        if (imageReader2 != null) {
            imageReader2.close();
            this.F = null;
        }
        android.media.ImageReader newInstance2 = android.media.ImageReader.newInstance(this.x.getWidth(), this.x.getHeight(), 35, 2);
        this.F = newInstance2;
        newInstance2.setOnImageAvailableListener(this.Y, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        b(this.I.a(j()), this.V, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.A == null) {
            return;
        }
        this.J.a(this.x.getHeight(), this.x.getWidth(), this.O, this.N, this.p);
        android.graphics.SurfaceTexture j = this.j.j();
        j.setDefaultBufferSize(this.x.getWidth(), this.x.getHeight());
        j.setOnFrameAvailableListener(this);
        this.H = new android.view.Surface(j);
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("startCaptureSession, surfaceTexture size: ");
            sb.append(this.x.getWidth());
            sb.append(" x ");
            sb.append(this.x.getHeight());
            j();
            this.A.createCaptureSession(java.util.Arrays.asList(this.H, this.E.getSurface(), this.F.getSurface()), this.U, null);
        } catch (android.hardware.camera2.CameraAccessException unused) {
            throw new java.lang.RuntimeException("Failed to start camera session");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            q();
            this.I.a(j(), this.b);
            this.C.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
            this.C.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 0);
            this.B.setRepeatingRequest(this.C.build(), this.V, this.m);
            this.S = 1;
        } catch (android.hardware.camera2.CameraAccessException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        android.hardware.camera2.CameraCharacteristics cameraCharacteristics = this.r;
        if (cameraCharacteristics == null || this.C == null) {
            return;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null || iArr.length == 0 || (iArr.length == 1 && iArr[0] == 0)) {
            this.C.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 0);
        } else {
            this.C.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 3);
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int a() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    @android.annotation.SuppressLint({"MissingPermission"})
    public int a(int i, int i2, int i3) {
        this.v = i;
        this.w = i2;
        this.p = i3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("cameraId = ");
        sb.append(i3);
        if (g()) {
            i();
            this.I.a(this.r);
            this.x = a(i, i2);
            this.y = h();
            k();
            try {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("camera id : ");
                sb2.append(this.q);
                android.hardware.Camera.getCameraInfo(this.p, this.o);
                this.a.openCamera(this.q, this.T, this.m);
            } catch (android.hardware.camera2.CameraAccessException e2) {
                throw new java.lang.RuntimeException("Failed to open camera: " + this.p, e2);
            }
        }
        return this.p;
    }

    public android.hardware.camera2.CaptureRequest.Builder a(int i, java.util.List<android.view.Surface> list) {
        try {
            android.hardware.camera2.CaptureRequest.Builder createCaptureRequest = this.A.createCaptureRequest(i);
            java.util.Iterator<android.view.Surface> it = list.iterator();
            while (it.hasNext()) {
                createCaptureRequest.addTarget(it.next());
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("createBuilder, cameraDevice.createCaptureRequest CaptureRequest.Builder, and addTarget, captureType = ");
            sb.append(i);
            return createCaptureRequest;
        } catch (android.hardware.camera2.CameraAccessException | java.lang.IllegalStateException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(float f2, float f3) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(int i) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(android.graphics.Point point) {
        android.hardware.camera2.params.MeteringRectangle a2 = this.J.a(point.x, point.y, true);
        android.hardware.camera2.params.MeteringRectangle a3 = this.J.a(point.x, point.y, false);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("manualFocus, focusRect = {");
        sb.append(a2.getRect().left);
        sb.append(", ");
        sb.append(a2.getRect().top);
        sb.append(", ");
        sb.append(a2.getRect().bottom);
        sb.append(", ");
        sb.append(a2.getRect().right);
        sb.append(com.alipay.sdk.m.u.i.d);
        a(a2, a3);
    }

    public void a(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CameraCaptureSession.CaptureCallback captureCallback, android.os.Handler handler) {
        try {
            this.B.capture(captureRequest, captureCallback, handler);
        } catch (android.hardware.camera2.CameraAccessException | java.lang.IllegalStateException e2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("send capture request error:");
            sb.append(e2.getMessage());
        }
    }

    public void a(android.hardware.camera2.params.MeteringRectangle meteringRectangle, android.hardware.camera2.params.MeteringRectangle meteringRectangle2) {
        android.hardware.camera2.CaptureRequest.Builder j = j();
        b(this.I.a(j, meteringRectangle, meteringRectangle2), this.V, this.m);
        j.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 1);
        a(j.build(), (android.hardware.camera2.CameraCaptureSession.CaptureCallback) null, this.m);
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.a aVar) {
        this.h = aVar;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.b bVar) {
        this.j.a(new com.aliyun.svideosdk.preview.camera.b.h(bVar));
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.a.c cVar) {
        this.i = cVar;
        if (com.aliyun.svideosdk.common.struct.recorder.FlashType.OFF.toString() != this.b) {
            m();
        } else {
            f();
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.e = onChoosePictureSizeCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void a(boolean z) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean a(java.lang.String str) {
        this.b = str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("flash : ");
        sb.append(this.b);
        b(this.I.b(j(), this.b), this.V, this.m);
        return true;
    }

    public void b(android.hardware.camera2.CaptureRequest captureRequest, android.hardware.camera2.CameraCaptureSession.CaptureCallback captureCallback, android.os.Handler handler) {
        try {
            android.hardware.camera2.CameraCaptureSession cameraCaptureSession = this.B;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.setRepeatingRequest(captureRequest, captureCallback, handler);
            }
        } catch (android.hardware.camera2.CameraAccessException | java.lang.IllegalStateException e2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("send repeating request error:");
            sb.append(e2.getMessage());
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public boolean b() {
        return true;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public android.hardware.Camera.CameraInfo c() {
        android.hardware.Camera.getCameraInfo(this.p, this.o);
        return this.o;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void d() {
        this.S = 7;
        if (this.B != null) {
            this.B.close();
            this.B = null;
        }
        android.hardware.camera2.CameraDevice cameraDevice = this.A;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.A = null;
        }
        android.media.ImageReader imageReader = this.E;
        if (imageReader != null) {
            imageReader.close();
            this.E = null;
        }
        android.media.ImageReader imageReader2 = this.F;
        if (imageReader2 != null) {
            imageReader2.close();
            this.F = null;
        }
        if (this.C != null) {
            this.C = null;
        }
        if (this.D != null) {
            this.D = null;
        }
        android.view.Surface surface = this.H;
        if (surface != null) {
            surface.release();
            this.H = null;
        }
        if (this.Q != null) {
            this.Q = null;
        }
        if (this.N != null) {
            this.N = null;
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int getCameraCount() {
        return android.hardware.Camera.getNumberOfCameras();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public float getCurrentExposureCompensationRatio() {
        if (7 == this.S || this.Q == null) {
            return 0.5f;
        }
        return (((java.lang.Integer) j().get(android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION)).intValue() - this.Q.getLower().intValue()) / (this.Q.getUpper().intValue() - this.Q.getLower().intValue());
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public java.util.List<android.hardware.Camera.Size> getSupportedPictureSize() {
        return null;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes() {
        return this.u.sizes(this.z);
    }

    public void l() {
        this.C.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        this.S = 4;
        a(this.C.build(), this.V, this.m);
        this.C.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
    }

    public void m() {
        this.S = 2;
        android.hardware.camera2.CaptureRequest.Builder j = j();
        j.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER, 1);
        a(j.build(), this.V, this.m);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        this.R = surfaceTexture.getTimestamp();
        this.j.r();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int release() {
        android.media.MediaActionSound mediaActionSound = this.K;
        if (mediaActionSound != null) {
            mediaActionSound.release();
        }
        android.os.HandlerThread handlerThread = this.l;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.l = null;
        }
        if (this.m == null) {
            return 0;
        }
        this.m = null;
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraCaptureDataMode(int i) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setExposureCompensationRatio(float f2) {
        if (7 == this.S || this.Q == null) {
            return -20005007;
        }
        this.P = this.I.a(j(), this.Q, f2);
        b(this.C.build(), this.V, this.m);
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setFocusMode(int i) {
        this.c = i;
        q();
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback) {
        this.d = onFrameCallback;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setPictureSize(int i, int i2) {
        com.aliyun.common.utils.Size size = new com.aliyun.common.utils.Size(i, i2);
        com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter = this.k;
        if (alivcRecorderReporter != null) {
            alivcRecorderReporter.sendSetPictureSizeEvent(size, this.u.sizes(this.z));
        }
        if (!this.u.sizes(this.z).contains(size)) {
            return -20003002;
        }
        this.y = size;
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setRotation(int i) {
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setShutterSound(boolean z) {
        this.f = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public void setTakePicturePreview(boolean z) {
        this.g = z;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int setZoom(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (7 == this.S || this.N == null) {
            return -20005007;
        }
        b(this.I.a(j(), ((this.L - 1.0f) * f2) + 1.0f, this.N, this.M), this.V, this.m);
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int startPreviewAfterTakePicture() {
        this.m.post(new com.aliyun.svideosdk.preview.camera.b.g());
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.f
    public int switchCamera() {
        this.p = this.p == 0 ? 1 : 0;
        if (this.A != null) {
            d();
        }
        return a(this.v, this.w, this.p);
    }
}
