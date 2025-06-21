package com.aliyun.svideosdk.a.e;

/* loaded from: classes12.dex */
public class a {
    private volatile android.graphics.SurfaceTexture a;
    private int c;
    private com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback e;
    private com.aliyun.svideosdk.a.e.a.d f;
    private float m;
    private int n;
    private int o;
    private com.aliyun.svideosdk.recorder.NativeRecorder p;
    private com.aliyun.svideosdk.a.e.a.c q;
    private com.aliyun.svideosdk.common.AliyunRecordVideoSource r;
    private float[] b = new float[16];
    private short d = 1;
    private int g = 0;
    private com.aliyun.svideosdk.a.d.a h = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a i = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a j = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a k = new com.aliyun.svideosdk.a.d.c();
    private com.aliyun.svideosdk.a.d.a l = new com.aliyun.svideosdk.a.d.b();

    /* renamed from: com.aliyun.svideosdk.a.e.a$a, reason: collision with other inner class name */
    public class C0083a implements com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback {
        public C0083a() {
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback
        public int onDestroyTexture() {
            if (com.aliyun.svideosdk.a.e.a.this.e == null) {
                return 0;
            }
            com.aliyun.svideosdk.a.e.a.this.e.onTextureDestroyed();
            return 0;
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback
        public int onPostTexture(int i, int i2, int i3) {
            int i4;
            if (com.aliyun.svideosdk.a.e.a.this.e != null) {
                com.aliyun.svideosdk.a.e.a.this.k.c();
                i4 = com.aliyun.svideosdk.a.e.a.this.e.onScaledIdBack(i, i2, i3, null);
                com.aliyun.svideosdk.a.e.a.this.k.b();
            } else {
                i4 = i;
            }
            return i4 == 0 ? i : i4;
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.TextureCallback
        public int onPreTexture(int i, int i2, int i3) {
            int i4;
            com.aliyun.svideosdk.a.e.a.this.s();
            if (com.aliyun.svideosdk.a.e.a.this.e != null) {
                com.aliyun.svideosdk.a.e.a.this.k.c();
                i4 = com.aliyun.svideosdk.a.e.a.this.e.onTextureIdBack(i, i2, i3, com.aliyun.svideosdk.a.e.a.this.b);
                com.aliyun.svideosdk.a.e.a.this.k.b();
            } else {
                i4 = i;
            }
            return i4 == 0 ? i : i4;
        }
    }

    public class b implements com.aliyun.svideosdk.recorder.NativeRecorder.ScreenshotCallback {
        public b() {
        }

        @Override // com.aliyun.svideosdk.recorder.NativeRecorder.ScreenshotCallback
        public void onScreenshot(int i, int i2, byte[] bArr, int i3) {
            if (com.aliyun.svideosdk.a.e.a.this.f != null) {
                com.aliyun.svideosdk.a.e.a.this.f.a(i, i2, java.nio.ByteBuffer.wrap(bArr));
            }
        }
    }

    public interface c {
        void b(int i);
    }

    public interface d {
        void a(int i, int i2, java.nio.ByteBuffer byteBuffer);
    }

    public a(com.aliyun.common.log.reporter.AlivcRecorderReporter alivcRecorderReporter, com.aliyun.svideosdk.recorder.NativeRecorder nativeRecorder) {
        this.p = nativeRecorder;
    }

    private int a() {
        this.c = this.p.createTexture();
        this.a = new android.graphics.SurfaceTexture(this.c);
        return 0;
    }

    public int a(int i, int i2) {
        synchronized (this) {
            if (i > 0 && i2 > 0) {
                this.r.getStickerManager().setDisplaySize(this.r.getNativeHandle(), i, i2);
                this.p.updateSource(this.r);
                return 0;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Invalid fbo width[");
            sb.append(i);
            sb.append("] or height[");
            sb.append(i2);
            sb.append("]");
            return -20003002;
        }
    }

    public int a(int i, int i2, int i3) {
        synchronized (this) {
            if (i > 0 && i2 > 0) {
                this.r.setCaptureSurface(this.a, i, i2, i3);
                this.p.updateSource(this.r);
                return 0;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Invalid capture width[");
            sb.append(i);
            sb.append("] or height[");
            sb.append(i2);
            sb.append("]");
            return -20003002;
        }
    }

    public int a(int i, android.graphics.Bitmap bitmap, float f, float f2, float f3, float f4, float f5) {
        this.r.getStickerManager().addBitmapSticker(i, bitmap, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth(), f, f2, f3, f4, f5);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(int i, java.lang.String str, float f, float f2, float f3, float f4, float f5) {
        this.r.getStickerManager().addSticker(i, str, f, f2, f3, f4, f5);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(android.view.Surface surface) {
        this.r.setDisplay(surface);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(com.aliyun.svideosdk.common.AliyunRecordVideoSource aliyunRecordVideoSource) {
        if (this.d != 1) {
            return -4;
        }
        synchronized (this) {
            this.r = aliyunRecordVideoSource;
            this.p.setTextureCallback(aliyunRecordVideoSource, new com.aliyun.svideosdk.a.e.a.C0083a());
            this.p.setScreenshotCallback(new com.aliyun.svideosdk.a.e.a.b());
        }
        a();
        this.d = (short) 2;
        this.p.startPreview();
        return 0;
    }

    public int a(java.lang.String str) {
        this.r.setFilterInfo(str);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(java.lang.String str, int i, float f, float f2, float f3, float f4, float f5, boolean z, long j, int i2) {
        this.r.getStickerManager().addGifSticker(i, str, f, f2, f3, f4, f5, z, 0L, j, i2 == 1);
        this.p.updateSource(this.r);
        return 0;
    }

    public int a(java.lang.String str, java.lang.String str2) {
        if (com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE != str) {
            return -20003002;
        }
        java.lang.Boolean.parseBoolean(str2);
        return 0;
    }

    public void a(float f, int i, int i2) {
        a(true, f, i, i2);
    }

    public void a(int i) {
        this.r.getStickerManager().removeSticker(i);
        this.p.updateSource(this.r);
    }

    public void a(int i, float[] fArr) {
        this.r.getStickerManager().setFacePoint(i, fArr, fArr.length);
        this.p.updateSource(this.r);
    }

    public void a(com.aliyun.svideosdk.a.e.a.c cVar) {
        this.q = cVar;
    }

    public void a(com.aliyun.svideosdk.a.e.a.d dVar) {
        synchronized (this) {
            this.f = dVar;
            this.p.takePhoto(this.r);
        }
    }

    public void a(com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback onTextureIdCallback) {
        this.e = onTextureIdCallback;
    }

    public void a(boolean z, float f, int i, int i2) {
        if (i > 0) {
            if ((f > 0.0f) && (i2 > 0)) {
                this.m = f;
                this.n = i;
                this.o = i2;
                this.h.c();
                int i3 = this.c;
                synchronized (this) {
                    java.lang.System.currentTimeMillis();
                    this.i.c();
                    com.aliyun.svideosdk.a.e.a.c cVar = this.q;
                    if (cVar == null) {
                        this.p.addVideoBuffer(this.r, i3);
                    } else {
                        cVar.b(i3);
                    }
                    this.i.b();
                }
                this.h.b();
            }
        }
    }

    public void a(float[] fArr) {
        this.r.getStickerManager().mapScreenToOriginalPreview(fArr);
    }

    public int b() {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        a(false, this.m, this.n, this.o);
        countDownLatch.countDown();
        return 0;
    }

    public int b(int i) {
        this.g = i;
        this.r.setBeautyLevel(i);
        return 0;
    }

    public int b(android.view.Surface surface) {
        this.r.setDisplay(null);
        this.p.updateSource(this.r);
        return 0;
    }

    public int b(java.lang.String str, java.lang.String str2) {
        this.r.setAnimationFilterInfo(str, str2);
        this.p.updateSource(this.r);
        return 0;
    }

    public int c() {
        return this.g;
    }

    public com.aliyun.svideosdk.common.AliyunRecordVideoSource d() {
        return this.r;
    }

    public com.aliyun.svideosdk.a.d.a e() {
        return this.l;
    }

    public com.aliyun.svideosdk.a.d.a f() {
        return this.i;
    }

    public com.aliyun.svideosdk.a.d.a g() {
        return this.j;
    }

    public com.aliyun.svideosdk.common.callback.recorder.OnTextureIdCallback h() {
        return this.e;
    }

    public com.aliyun.svideosdk.a.d.a i() {
        return this.h;
    }

    public android.graphics.SurfaceTexture j() {
        return this.a;
    }

    public com.aliyun.svideosdk.a.d.a k() {
        return this.k;
    }

    public void l() {
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
    }

    public void m() {
        this.h.f();
        this.i.f();
        this.j.f();
        this.k.f();
    }

    public int n() {
        if (this.d == 2) {
            this.r.setDisplay(null);
            this.a.release();
        }
        this.d = (short) 1;
        this.a = null;
        return 0;
    }

    public void o() {
    }

    public int p() {
        this.r.setAnimationFilterInfo(null, null);
        this.p.updateSource(this.r);
        return 0;
    }

    public void q() {
        this.r.setFilterInfo(null);
    }

    public void r() {
        try {
            this.a.updateTexImage();
            this.a.getTransformMatrix(this.b);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void s() {
        try {
            this.a.getTransformMatrix(this.b);
        } catch (java.lang.Throwable unused) {
        }
    }
}
