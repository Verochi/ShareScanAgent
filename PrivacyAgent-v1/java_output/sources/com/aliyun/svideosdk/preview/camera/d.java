package com.aliyun.svideosdk.preview.camera;

/* loaded from: classes12.dex */
class d implements com.aliyun.svideosdk.preview.camera.g {
    private com.aliyun.svideosdk.a.e.a a;
    private com.aliyun.svideosdk.preview.camera.f b;
    private int c;
    private int d;
    private int e;
    private int f;
    private android.os.HandlerThread g;
    private android.os.Handler h;
    private int i;

    public class a implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.CountDownLatch a;

        public a(java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.preview.camera.d dVar = com.aliyun.svideosdk.preview.camera.d.this;
            dVar.i = dVar.b.a(com.aliyun.svideosdk.preview.camera.d.this.d, com.aliyun.svideosdk.preview.camera.d.this.e, com.aliyun.svideosdk.preview.camera.d.this.c);
            this.a.countDown();
        }
    }

    public class b implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.CountDownLatch a;

        public b(java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.preview.camera.d dVar = com.aliyun.svideosdk.preview.camera.d.this;
            dVar.c = dVar.b.switchCamera();
            this.a.countDown();
        }
    }

    public class c implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.CountDownLatch a;

        public c(java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.preview.camera.d.this.b.d();
            this.a.countDown();
        }
    }

    /* renamed from: com.aliyun.svideosdk.preview.camera.d$d, reason: collision with other inner class name */
    public static /* synthetic */ class C0108d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.recorder.FlashType.values().length];
            a = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.recorder.FlashType.AUTO.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.recorder.FlashType.ON.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.recorder.FlashType.OFF.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.recorder.FlashType.TORCH.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public d(android.content.Context context, com.aliyun.svideosdk.a.e.a aVar, com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter, com.aliyun.svideosdk.preview.utils.CameraVersion.Version version) {
        this.b = null;
        this.a = aVar;
        this.b = com.aliyun.svideosdk.preview.camera.c.a(context, aVar, alivcRecorderReporter, version);
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("camera-ctrl");
        this.g = handlerThread;
        handlerThread.start();
        this.h = new android.os.Handler(this.g.getLooper());
    }

    private com.aliyun.svideosdk.common.struct.recorder.FlashType d() {
        com.aliyun.svideosdk.common.struct.recorder.FlashType flashType = com.aliyun.svideosdk.common.struct.recorder.FlashType.OFF;
        int i = this.f;
        if (i == 0) {
            return flashType;
        }
        if (i == 1) {
            return com.aliyun.svideosdk.common.struct.recorder.FlashType.AUTO;
        }
        if (i == 2) {
            return com.aliyun.svideosdk.common.struct.recorder.FlashType.ON;
        }
        if (i == 3) {
            return com.aliyun.svideosdk.common.struct.recorder.FlashType.TORCH;
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid flash type:" + flashType.toString());
        return null;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int a() {
        return this.b.a();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int a(int i, int i2) {
        this.d = i;
        this.e = i2;
        return 0;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(int i) {
        this.b.a(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(com.aliyun.svideosdk.a.a aVar) {
        this.b.a(aVar);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(com.aliyun.svideosdk.a.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(com.aliyun.svideosdk.a.c cVar) {
        this.b.a(cVar);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void a(boolean z) {
        this.b.a(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    @Override // com.aliyun.svideosdk.preview.camera.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.aliyun.svideosdk.common.struct.recorder.FlashType flashType) {
        int i = com.aliyun.svideosdk.preview.camera.d.C0108d.a[flashType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i == 3) {
                    this.f = 0;
                } else if (i != 4) {
                    this.f = 4;
                }
                if (this.f == 4) {
                    return this.b.a(flashType.toString());
                }
                com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid flash mode: " + flashType.toString());
                return false;
            }
        }
        this.f = i2;
        if (this.f == 4) {
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void b(int i) {
        this.c = i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public boolean b() {
        return this.b.b();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public android.hardware.Camera.CameraInfo c() {
        return this.b.c();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int getCameraCount() {
        return this.b.getCameraCount();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public float getCurrentExposureCompensationRatio() {
        return this.b.getCurrentExposureCompensationRatio();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public java.util.List<android.hardware.Camera.Size> getSupportedPictureSize() {
        return this.b.getSupportedPictureSize();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public java.util.SortedSet<com.aliyun.common.utils.Size> getSupportedPictureSizes() {
        return this.b.getSupportedPictureSizes();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void release() {
        android.os.Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.h = null;
        }
        android.os.HandlerThread handlerThread = this.g;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.g = null;
        }
        com.aliyun.svideosdk.preview.camera.f fVar = this.b;
        if (fVar != null) {
            fVar.release();
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setCameraCaptureDataMode(int i) {
        this.b.setCameraCaptureDataMode(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setCameraParam(com.aliyun.svideosdk.common.struct.recorder.CameraParam cameraParam) {
        this.b.setCameraParam(cameraParam);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int setExposureCompensationRatio(float f) {
        return this.b.setExposureCompensationRatio(f);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setFocus(float f, float f2) {
        float[] fArr = {f, f2};
        this.a.a(fArr);
        this.b.a(fArr[0], fArr[1]);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setFocus(android.graphics.Point point) {
        this.b.a(point);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setFocusMode(int i) {
        this.b.setFocusMode(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setOnChoosePictureSizeCallBack(com.aliyun.svideosdk.common.callback.recorder.OnChoosePictureSizeCallback onChoosePictureSizeCallback) {
        this.b.a(onChoosePictureSizeCallback);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setOnFrameCallback(com.aliyun.svideosdk.common.callback.recorder.OnFrameCallback onFrameCallback) {
        this.b.setOnFrameCallback(onFrameCallback);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int setPictureSize(int i, int i2) {
        return this.b.setPictureSize(i, i2);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setRotation(int i) {
        this.b.setRotation(i);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setShutterSound(boolean z) {
        this.b.setShutterSound(z);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void setTakePicturePreview(boolean z) {
        this.b.setTakePicturePreview(z);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int setZoom(float f) {
        return this.b.setZoom(f);
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int startPreview() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunCamera call startPreview");
        if (this.h == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunCamera call startPreview hander is null");
            int a2 = this.b.a(this.d, this.e, this.c);
            this.i = a2;
            return a2;
        }
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        this.h.post(new com.aliyun.svideosdk.preview.camera.d.a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        return this.i;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int startPreviewAfterTakePicture() {
        return this.b.startPreviewAfterTakePicture();
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public void stopPreview() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunCamera call stopPreview");
        if (this.h == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunCamera call stopPreview handler is null");
            this.b.d();
            return;
        }
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        this.h.post(new com.aliyun.svideosdk.preview.camera.d.c(countDownLatch));
        try {
            countDownLatch.await(500L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public int switchCamera() {
        if (this.h == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "AliyunCamera call switchCamera hander is null");
            int switchCamera = this.b.switchCamera();
            this.c = switchCamera;
            return switchCamera;
        }
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        this.h.post(new com.aliyun.svideosdk.preview.camera.d.b(countDownLatch));
        try {
            countDownLatch.await();
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        return this.c;
    }

    @Override // com.aliyun.svideosdk.preview.camera.g
    public com.aliyun.svideosdk.common.struct.recorder.FlashType switchLight() {
        int i = this.f;
        this.f = i >= 3 ? 0 : i + 1;
        com.aliyun.svideosdk.common.struct.recorder.FlashType d = d();
        if (a(d)) {
            return d;
        }
        this.f--;
        return d();
    }
}
