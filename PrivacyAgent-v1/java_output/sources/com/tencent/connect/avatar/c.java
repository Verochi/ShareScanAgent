package com.tencent.connect.avatar;

/* loaded from: classes19.dex */
public class c extends android.widget.ImageView {
    final java.lang.String a;
    public boolean b;
    private android.graphics.Matrix c;
    private android.graphics.Matrix d;
    private int e;
    private float f;
    private float g;
    private android.graphics.Bitmap h;
    private boolean i;
    private float j;
    private float k;
    private android.graphics.PointF l;
    private android.graphics.PointF m;
    private float n;
    private float o;
    private android.graphics.Rect p;

    /* renamed from: com.tencent.connect.avatar.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.tencent.connect.avatar.c$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04961 implements java.lang.Runnable {
            public RunnableC04961() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.connect.avatar.c.this.clearAnimation();
                com.tencent.connect.avatar.c.this.b();
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.Thread.sleep(300L);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
            com.tencent.connect.avatar.c.this.post(new com.tencent.connect.avatar.c.AnonymousClass1.RunnableC04961());
            com.tencent.connect.avatar.c.this.i = false;
        }
    }

    public c(android.content.Context context) {
        super(context);
        this.c = new android.graphics.Matrix();
        this.d = new android.graphics.Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.a = "TouchView";
        this.l = new android.graphics.PointF();
        this.m = new android.graphics.PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private float a(android.view.MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) java.lang.Math.sqrt((x * x) + (y * y));
    }

    private void a() {
    }

    private void a(android.graphics.PointF pointF) {
        if (this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth() * f3;
        float height = this.h.getHeight() * f3;
        android.graphics.Rect rect = this.p;
        float f4 = rect.left - f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f5 = (f + width) - rect.right;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float width2 = (rect.width() * f4) / (f5 + f4);
        android.graphics.Rect rect2 = this.p;
        float f6 = width2 + rect2.left;
        float f7 = rect2.top - f2;
        float f8 = (f2 + height) - rect2.bottom;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        pointF.set(f6, ((rect2.height() * f7) / ((f8 > 1.0f ? f8 : 1.0f) + f7)) + this.p.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z;
        android.view.animation.Animation animation;
        if (this.h == null) {
            return;
        }
        float width = this.p.width();
        float height = this.p.height();
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = this.f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.o = f5;
            android.graphics.Matrix matrix = this.c;
            android.graphics.PointF pointF = this.m;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.c);
            float f6 = this.o;
            float f7 = 1.0f / f6;
            float f8 = 1.0f / f6;
            android.graphics.PointF pointF2 = this.m;
            animation = new android.view.animation.ScaleAnimation(f7, 1.0f, f8, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f9 = this.g;
            if (f3 < f9) {
                float f10 = f9 / f3;
                this.o = f10;
                android.graphics.Matrix matrix2 = this.c;
                android.graphics.PointF pointF3 = this.m;
                matrix2.postScale(f10, f10, pointF3.x, pointF3.y);
                float f11 = this.o;
                android.graphics.PointF pointF4 = this.m;
                animation = new android.view.animation.ScaleAnimation(1.0f, f11, 1.0f, f11, pointF4.x, pointF4.y);
            } else {
                float width2 = this.h.getWidth() * f3;
                float height2 = this.h.getHeight() * f3;
                android.graphics.Rect rect = this.p;
                int i = rect.left;
                float f12 = i - f;
                int i2 = rect.top;
                float f13 = i2 - f2;
                if (f12 < 0.0f) {
                    f = i;
                    z = true;
                } else {
                    z = false;
                }
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                }
                float f14 = height2 - f13;
                if (width2 - f12 < width) {
                    f = i - (width2 - width);
                    z = true;
                }
                if (f14 < height) {
                    f2 = i2 - (height2 - height);
                    z = true;
                }
                if (z) {
                    float f15 = fArr[2] - f;
                    float f16 = fArr[5] - f2;
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.c.setValues(fArr);
                    setImageMatrix(this.c);
                    animation = new android.view.animation.TranslateAnimation(f15, 0.0f, f16, 0.0f);
                } else {
                    setImageMatrix(this.c);
                    animation = null;
                }
            }
        }
        if (animation != null) {
            this.i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new java.lang.Thread(new com.tencent.connect.avatar.c.AnonymousClass1()).start();
        }
    }

    private void c() {
        if (this.h == null) {
            return;
        }
        float[] fArr = {r1, 0.0f, this.j, 0.0f, r1, r2, 0.0f, 0.0f, 0.0f};
        this.c.getValues(fArr);
        float max = java.lang.Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * max) - this.p.width()) / 2.0f);
        float height = this.p.top - (((this.h.getHeight() * max) - this.p.height()) / 2.0f);
        this.k = height;
        this.c.setValues(fArr);
        float min = java.lang.Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.f = min;
        this.g = max;
        if (min < max) {
            this.f = max;
        }
        setImageMatrix(this.c);
    }

    public void a(android.graphics.Rect rect) {
        this.p = rect;
        if (this.h != null) {
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 != 6) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.i) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.e;
                    if (i == 1) {
                        this.c.set(this.d);
                        this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                        setImageMatrix(this.c);
                    } else if (i == 2) {
                        android.graphics.Matrix matrix = this.c;
                        matrix.set(matrix);
                        float a = a(motionEvent);
                        if (a > 10.0f) {
                            this.c.set(this.d);
                            float f = a / this.n;
                            android.graphics.Matrix matrix2 = this.c;
                            android.graphics.PointF pointF = this.m;
                            matrix2.postScale(f, f, pointF.x, pointF.y);
                        }
                        setImageMatrix(this.c);
                    }
                } else if (action == 5) {
                    float a2 = a(motionEvent);
                    this.n = a2;
                    if (a2 > 10.0f) {
                        this.d.set(this.c);
                        a(this.m);
                        this.e = 2;
                    }
                }
            }
            b();
            this.e = 0;
        } else {
            this.c.set(getImageMatrix());
            this.d.set(this.c);
            this.l.set(motionEvent.getX(), motionEvent.getY());
            this.e = 1;
        }
        this.b = true;
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.h = bitmap;
        if (bitmap != null) {
            this.h = bitmap;
        }
    }
}
