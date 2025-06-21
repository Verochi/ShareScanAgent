package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class f extends android.view.View implements com.aliyun.svideosdk.nativerender.BitmapGenerator {
    private static final java.lang.String t = "com.aliyun.svideosdk.editor.impl.f";
    private android.graphics.Bitmap a;
    private android.graphics.Canvas b;
    private com.aliyun.svideosdk.editor.AliyunIPaint c;
    private android.graphics.Paint d;
    private int e;
    private int f;
    private com.aliyun.svideosdk.common.struct.project.CanvasAction g;
    private int h;
    private java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> i;
    private java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> j;
    private java.lang.String k;
    private com.aliyun.svideosdk.common.struct.CanvasInfo l;
    private android.os.HandlerThread m;
    private android.os.Handler n;
    private android.os.Handler o;
    private boolean p;
    private java.lang.Object q;
    private java.lang.Runnable r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.Runnable f94s;

    public class a implements java.lang.Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideosdk.editor.impl.f.this.invalidate();
            com.aliyun.svideosdk.editor.impl.f.this.p = false;
        }
    }

    public class b implements java.lang.Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String unused = com.aliyun.svideosdk.editor.impl.f.t;
            com.aliyun.svideosdk.editor.impl.f.this.a.eraseColor(0);
            if (com.aliyun.svideosdk.editor.impl.f.this.i != null && com.aliyun.svideosdk.editor.impl.f.this.i.size() > 0) {
                com.aliyun.svideosdk.editor.impl.f.this.i.remove((com.aliyun.svideosdk.common.struct.project.CanvasAction) com.aliyun.svideosdk.editor.impl.f.this.i.get(com.aliyun.svideosdk.editor.impl.f.this.i.size() - 1));
                com.aliyun.svideosdk.editor.impl.f.this.l.remove();
                synchronized (com.aliyun.svideosdk.editor.impl.f.this.q) {
                    for (com.aliyun.svideosdk.common.struct.project.CanvasAction canvasAction : com.aliyun.svideosdk.editor.impl.f.this.i) {
                        com.aliyun.svideosdk.editor.impl.f.this.b.drawPath(canvasAction.path, canvasAction.paint);
                    }
                }
            }
            com.aliyun.svideosdk.editor.impl.f.this.o.post(com.aliyun.svideosdk.editor.impl.f.this.r);
            java.lang.String unused2 = com.aliyun.svideosdk.editor.impl.f.t;
        }
    }

    public f(android.content.Context context, int i, int i2) {
        super(context);
        this.c = new com.aliyun.svideosdk.editor.impl.j();
        this.d = new android.graphics.Paint();
        this.g = null;
        this.h = 0;
        this.i = new java.util.concurrent.CopyOnWriteArrayList();
        this.j = new java.util.concurrent.CopyOnWriteArrayList();
        this.l = new com.aliyun.svideosdk.common.struct.CanvasInfo();
        this.o = new android.os.Handler(android.os.Looper.getMainLooper());
        this.p = false;
        this.q = new java.lang.Object();
        this.r = new com.aliyun.svideosdk.editor.impl.f.a();
        this.f94s = new com.aliyun.svideosdk.editor.impl.f.b();
        this.k = com.aliyun.common.utils.StorageUtils.getCacheDirectory(context) + java.io.File.separator + "paint.png";
        this.e = i;
        this.f = i2;
        setLayerType(1, null);
        e();
    }

    private void a(float f, float f2) {
        if (this.h != 0) {
            return;
        }
        this.d = this.c.getPaint();
        h();
        this.g = new com.aliyun.svideosdk.common.struct.project.CanvasAction(f, f2, this.d);
    }

    private void a(java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> list, java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> list2) {
        list2.clear();
        java.util.Iterator<com.aliyun.svideosdk.common.struct.project.CanvasAction> it = list.iterator();
        while (it.hasNext()) {
            list2.add(it.next());
        }
    }

    private void e() {
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(this.e, this.f, android.graphics.Bitmap.Config.ARGB_8888);
        this.a = createBitmap;
        createBitmap.eraseColor(0);
        android.graphics.Canvas canvas = new android.graphics.Canvas(this.a);
        this.b = canvas;
        canvas.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
        this.b.drawColor(0);
    }

    public void a(com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo) {
        if (canvasInfo == null) {
            return;
        }
        this.l.resore(canvasInfo);
        a(canvasInfo.transfer());
    }

    public void a(java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        a(list, this.i);
        a(this.i, this.j);
        this.a.eraseColor(0);
        java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> list2 = this.i;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (com.aliyun.svideosdk.common.struct.project.CanvasAction canvasAction : this.i) {
            this.b.drawPath(canvasAction.path, canvasAction.paint);
        }
        invalidate();
    }

    public void b() {
        this.a.eraseColor(0);
        java.util.List<com.aliyun.svideosdk.common.struct.project.CanvasAction> list = this.j;
        if (list != null && list.size() > 0) {
            for (com.aliyun.svideosdk.common.struct.project.CanvasAction canvasAction : this.j) {
                this.b.drawPath(canvasAction.path, canvasAction.paint);
            }
        }
        a(this.j, this.i);
    }

    public void c() {
        this.a.eraseColor(0);
        this.b.setBitmap(this.a);
        this.i.clear();
        this.l.clean();
        invalidate();
    }

    public void d() {
        a(this.i, this.j);
    }

    public void f() {
        android.graphics.Bitmap bitmap = this.a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.recycle();
        }
        this.a = null;
        this.b = null;
    }

    public void g() {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(new java.io.File(this.k));
            this.a.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public android.graphics.Bitmap generateBitmap(int i, int i2) {
        return null;
    }

    public int getCanvasHeight() {
        return this.f;
    }

    public com.aliyun.svideosdk.common.struct.CanvasInfo getCanvasInfo() {
        return this.l;
    }

    public int getCanvasWidth() {
        return this.e;
    }

    public java.lang.String getPath() {
        return this.k;
    }

    public void h() {
        android.graphics.BlurMaskFilter blurMaskFilter = new android.graphics.BlurMaskFilter(1.0f, android.graphics.BlurMaskFilter.Blur.SOLID);
        android.graphics.Paint paint = this.d;
        if (paint != null) {
            paint.setMaskFilter(blurMaskFilter);
        }
    }

    public void i() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.n.post(this.f94s);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("undo");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new android.os.Handler(this.m.getLooper());
        this.p = false;
        a(this.j);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.removeCallbacks(this.f94s);
        this.o.removeCallbacks(this.r);
        this.m.quit();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        synchronized (this.q) {
            canvas.drawBitmap(this.a, 0.0f, 0.0f, (android.graphics.Paint) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r5 != 6) goto L31;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked() | motionEvent.getAction();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    com.aliyun.svideosdk.common.struct.project.CanvasAction canvasAction = this.g;
                    if (canvasAction != null) {
                        canvasAction.move(x, y, this.b);
                    }
                    com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo = this.l;
                    if (canvasInfo != null) {
                        canvasInfo.lineMove(x, y);
                    }
                    invalidate();
                    return true;
                }
                if (actionMasked != 5) {
                }
            }
            com.aliyun.svideosdk.common.struct.project.CanvasAction canvasAction2 = this.g;
            if (canvasAction2 != null) {
                this.i.add(canvasAction2);
                this.g = null;
            }
            com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo2 = this.l;
            if (canvasInfo2 != null) {
                canvasInfo2.lineEnd(x, y, this.d);
            }
            invalidate();
            return true;
        }
        a(x, y);
        com.aliyun.svideosdk.common.struct.project.CanvasAction canvasAction3 = this.g;
        if (canvasAction3 != null) {
            canvasAction3.point(x, y, this.b);
        }
        com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo3 = this.l;
        if (canvasInfo3 != null) {
            canvasInfo3.lineStart(x, y);
        }
        invalidate();
        return true;
    }

    public void setAliyunPaint(com.aliyun.svideosdk.editor.AliyunIPaint aliyunIPaint) {
        this.c = aliyunIPaint;
    }

    public void setPath(java.lang.String str) {
        this.k = str;
    }
}
