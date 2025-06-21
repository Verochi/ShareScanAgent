package com.aliyun.svideosdk.multirecorder.impl.c;

/* loaded from: classes12.dex */
public class h extends com.aliyun.svideosdk.multirecorder.impl.c.f implements com.aliyun.svideosdk.multirecorder.AliyunIViewCapture {
    private android.view.View m;

    /* renamed from: s, reason: collision with root package name */
    private com.aliyun.svideosdk.multirecorder.impl.c.i.a.c<android.graphics.Bitmap> f99s;
    private volatile boolean n = false;
    private java.lang.Object p = new java.lang.Object();
    private com.aliyun.common.media.ShareableBitmap q = null;
    private com.aliyun.svideosdk.multirecorder.impl.c.h.f r = com.aliyun.svideosdk.multirecorder.impl.c.h.f.AUTO;
    private android.os.Handler o = new android.os.Handler(android.os.Looper.getMainLooper());

    public class a implements com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<android.graphics.Bitmap> {
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.e.b a;

        public a(com.aliyun.svideosdk.multirecorder.impl.c.h hVar, com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
            this.a = bVar;
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a
        public void a(android.graphics.Bitmap bitmap) {
            this.a.a(bitmap);
        }
    }

    public class b implements com.aliyun.svideosdk.multirecorder.impl.c.e.b<android.graphics.Bitmap> {
        public b() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.b
        public void a(android.graphics.Bitmap bitmap) {
            synchronized (com.aliyun.svideosdk.multirecorder.impl.c.h.this.p) {
                com.aliyun.svideosdk.multirecorder.impl.c.h hVar = com.aliyun.svideosdk.multirecorder.impl.c.h.this;
                hVar.a(hVar.q);
                com.aliyun.svideosdk.multirecorder.impl.c.h.this.q = bitmap == null ? null : new com.aliyun.common.media.ShareableBitmap(bitmap);
                com.aliyun.svideosdk.multirecorder.impl.c.h.this.l();
            }
            com.aliyun.svideosdk.multirecorder.impl.c.h.this.n = false;
        }
    }

    public class c implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.e.b a;

        public c(com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.multirecorder.impl.c.h.this.b((com.aliyun.svideosdk.multirecorder.impl.c.e.b<android.graphics.Bitmap>) this.a);
        }
    }

    public class d implements java.lang.Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.multirecorder.impl.c.h.this.o();
        }
    }

    public static /* synthetic */ class e {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.multirecorder.impl.c.h.f.values().length];
            a = iArr;
            try {
                iArr[com.aliyun.svideosdk.multirecorder.impl.c.h.f.ONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.aliyun.svideosdk.multirecorder.impl.c.h.f.THREE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public enum f {
        AUTO,
        ONE,
        TWO,
        THREE
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.aliyun.common.media.ShareableBitmap shareableBitmap) {
        if (shareableBitmap == null) {
            return;
        }
        shareableBitmap.release();
    }

    private boolean a(android.view.View view, int i) {
        if (view != null && view.getVisibility() == 0) {
            if (view instanceof android.view.SurfaceView) {
                return i != 0;
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (a(viewGroup.getChildAt(i2), i + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.aliyun.svideosdk.multirecorder.impl.c.e.b<android.graphics.Bitmap> bVar) {
        if (this.f99s == null) {
            this.f99s = r();
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "bestViewCapturePolicy " + this.f99s.a());
        }
        this.f99s.a(this.m, new com.aliyun.svideosdk.multirecorder.impl.c.h.a(this, bVar));
    }

    private boolean q() {
        return com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogClose != com.aliyun.svideosdk.AlivcSdkCore.getLogLevel() && com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogDebug.getValue() >= com.aliyun.svideosdk.AlivcSdkCore.getLogLevel().getValue();
    }

    private com.aliyun.svideosdk.multirecorder.impl.c.i.a.c r() {
        android.view.View view = this.m;
        if (view instanceof android.view.TextureView) {
            if (this.r == com.aliyun.svideosdk.multirecorder.impl.c.h.f.TWO && android.os.Build.VERSION.SDK_INT >= 26 && view.isAttachedToWindow()) {
                android.view.View view2 = this.m;
                if ((view2 instanceof android.view.SurfaceView) || (view2.getContext() instanceof android.app.Activity)) {
                    return new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d();
                }
            }
            return new com.aliyun.svideosdk.multirecorder.impl.c.i.a.e();
        }
        if (android.os.Build.VERSION.SDK_INT >= 26 && view.isAttachedToWindow()) {
            android.view.View view3 = this.m;
            if ((view3 instanceof android.view.SurfaceView) || (view3.getContext() instanceof android.app.Activity)) {
                if (this.m instanceof android.view.SurfaceView) {
                    return new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d();
                }
                int i = com.aliyun.svideosdk.multirecorder.impl.c.h.e.a[this.r.ordinal()];
                return i != 1 ? i != 2 ? new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d() : new com.aliyun.svideosdk.multirecorder.impl.c.i.a.b() : new com.aliyun.svideosdk.multirecorder.impl.c.i.a.a();
            }
        }
        return this.r == com.aliyun.svideosdk.multirecorder.impl.c.h.f.THREE ? new com.aliyun.svideosdk.multirecorder.impl.c.i.a.b() : new com.aliyun.svideosdk.multirecorder.impl.c.i.a.a();
    }

    private boolean s() {
        return com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogClose != com.aliyun.svideosdk.AlivcSdkCore.getLogLevel() && com.aliyun.svideosdk.AlivcSdkCore.AlivcLogLevel.AlivcLogError.getValue() >= com.aliyun.svideosdk.AlivcSdkCore.getLogLevel().getValue();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i) {
        if (i > 60) {
            i = 60;
        }
        super.a(i);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public void a(com.aliyun.svideosdk.multirecorder.impl.c.e.b bVar) {
        com.aliyun.common.media.ShareableBitmap shareableBitmap;
        synchronized (this.p) {
            shareableBitmap = this.q;
            if (shareableBitmap != null) {
                shareableBitmap.ref();
            }
        }
        bVar.a(shareableBitmap);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(boolean z) {
        p();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.f, com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        super.destroy();
        this.n = false;
        synchronized (this.p) {
            a(this.q);
            this.q = null;
        }
        this.o.removeCallbacksAndMessages(null);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e
    public com.aliyun.svideosdk.multirecorder.impl.c.e.a e() {
        return com.aliyun.svideosdk.multirecorder.impl.c.e.a.BITMAP;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.f
    public void o() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o.post(new com.aliyun.svideosdk.multirecorder.impl.c.h.c(new com.aliyun.svideosdk.multirecorder.impl.c.h.b()));
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIViewCapture
    public void setCaptureView(android.view.View view) {
        if (view == null) {
            throw new java.lang.RuntimeException("captureView should be not null");
        }
        if (this.m != null) {
            throw new java.lang.RuntimeException("Already set capture view");
        }
        if (s() && a(view, 0)) {
            if (q()) {
                throw new java.lang.RuntimeException("The captureView should not contains SurfaceView");
            }
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "The captureView should not contains SurfaceView");
        }
        this.m = view;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.AliyunIBaseCapture
    public int setProperty(java.lang.String str, java.lang.String str2) {
        com.aliyun.svideosdk.multirecorder.impl.c.h.f fVar;
        if (!"view_capture_policy".equals(str)) {
            return super.setProperty(str, str2);
        }
        str2.hashCode();
        switch (str2) {
            case "1":
                fVar = com.aliyun.svideosdk.multirecorder.impl.c.h.f.ONE;
                break;
            case "2":
                fVar = com.aliyun.svideosdk.multirecorder.impl.c.h.f.TWO;
                break;
            case "3":
                fVar = com.aliyun.svideosdk.multirecorder.impl.c.h.f.THREE;
                break;
            default:
                fVar = com.aliyun.svideosdk.multirecorder.impl.c.h.f.AUTO;
                break;
        }
        this.r = fVar;
        return 0;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startPreview() {
        if (!a()) {
            this.o.postDelayed(new com.aliyun.svideosdk.multirecorder.impl.c.h.d(), 100L);
        }
        return super.startPreview();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.a, com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startRecording() {
        c(true);
        return super.startRecording();
    }
}
