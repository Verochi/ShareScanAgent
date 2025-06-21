package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ATRotationView extends android.widget.FrameLayout {
    java.lang.Runnable a;
    private android.graphics.Camera b;
    private android.graphics.Matrix c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private float m;
    private boolean n;
    private boolean o;
    private boolean p;

    /* renamed from: com.anythink.expressad.video.dynview.widget.ATRotationView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.dynview.widget.ATRotationView.a(com.anythink.expressad.video.dynview.widget.ATRotationView.this);
        }
    }

    public ATRotationView(android.content.Context context) {
        super(context);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l = 0.5f;
        this.m = 0.9f;
        this.n = true;
        this.o = false;
        this.p = false;
        this.a = new com.anythink.expressad.video.dynview.widget.ATRotationView.AnonymousClass1();
        a();
    }

    public ATRotationView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l = 0.5f;
        this.m = 0.9f;
        this.n = true;
        this.o = false;
        this.p = false;
        this.a = new com.anythink.expressad.video.dynview.widget.ATRotationView.AnonymousClass1();
        a();
    }

    public ATRotationView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 40;
        this.g = 20;
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.l = 0.5f;
        this.m = 0.9f;
        this.n = true;
        this.o = false;
        this.p = false;
        this.a = new com.anythink.expressad.video.dynview.widget.ATRotationView.AnonymousClass1();
        a();
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            i2 = this.p ? this.i - 2 : this.i + 2;
        } else if (i != 1) {
            if (i != 2) {
                i2 = i != 3 ? 0 : this.i;
            } else if (this.p) {
                i3 = this.i;
                i2 = i3 - 1;
            } else {
                i4 = this.i;
                i2 = i4 + 1;
            }
        } else if (this.p) {
            i4 = this.i;
            i2 = i4 + 1;
        } else {
            i3 = this.i;
            i2 = i3 - 1;
        }
        int childCount = i2 % getChildCount();
        return childCount >= 0 ? childCount : childCount + getChildCount();
    }

    private void a() {
        this.b = new android.graphics.Camera();
        this.c = new android.graphics.Matrix();
        setWillNotDraw(false);
    }

    private void a(int i, int i2, int i3) {
        float f = (-i) / 2.0f;
        if (i3 == 0) {
            this.b.translate(0.0f, f, 0.0f);
            float f2 = -i2;
            this.b.rotateX(f2);
            this.b.translate(0.0f, f, 0.0f);
            this.b.translate(0.0f, f, 0.0f);
            this.b.rotateX(f2);
            this.b.translate(0.0f, f, 0.0f);
            return;
        }
        if (i3 == 1) {
            this.b.translate(0.0f, f, 0.0f);
            this.b.rotateX(i2);
            this.b.translate(0.0f, f, 0.0f);
        } else if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            this.b.rotateX(0.0f);
        } else {
            this.b.translate(0.0f, f, 0.0f);
            this.b.rotateX(-i2);
            this.b.translate(0.0f, f, 0.0f);
        }
    }

    private void a(android.graphics.Canvas canvas) {
        int width = getWidth() / 2;
        int i = ((this.h * this.e) / 2) / this.f;
        b(canvas, i, width, 0);
        b(canvas, i, width, 1);
        if (java.lang.Math.abs(this.h) > this.f / 2) {
            b(canvas, i, width, 3);
            b(canvas, i, width, 2);
        } else {
            b(canvas, i, width, 2);
            b(canvas, i, width, 3);
        }
    }

    private void a(android.graphics.Canvas canvas, int i, int i2, int i3) {
        canvas.save();
        this.b.save();
        this.c.reset();
        float f = i;
        this.b.translate(0.0f, f, 0.0f);
        this.b.rotateX(this.h);
        this.b.translate(0.0f, f, 0.0f);
        if (i == 0) {
            if (this.p) {
                a(this.d, this.f, i3);
            } else {
                a(-this.d, -this.f, i3);
            }
        } else if (i > 0) {
            a(this.d, this.f, i3);
        } else if (i < 0) {
            a(-this.d, -this.f, i3);
        }
        this.b.getMatrix(this.c);
        this.b.restore();
        this.c.preTranslate((-getWidth()) / 2, -i2);
        this.c.postTranslate(getWidth() / 2, i2);
        canvas.concat(this.c);
        android.view.View childAt = getChildAt(a(i3));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.dynview.widget.ATRotationView aTRotationView) {
        if (aTRotationView.getChildCount() != 0) {
            int i = aTRotationView.h - 1;
            aTRotationView.h = i;
            int i2 = aTRotationView.i;
            aTRotationView.j = i2;
            int i3 = aTRotationView.f;
            int i4 = i2 - (i / i3);
            int i5 = i % i3;
            aTRotationView.h = i5;
            aTRotationView.i = i4;
            int a = java.lang.Math.abs(i5) > aTRotationView.f / 2 ? aTRotationView.a(2) : aTRotationView.a(3);
            if (aTRotationView.k != a) {
                aTRotationView.k = a;
            }
            aTRotationView.invalidate();
            if (aTRotationView.n) {
                aTRotationView.postDelayed(aTRotationView.a, 1000 / aTRotationView.g);
            }
        }
    }

    private void b() {
        if (getChildCount() == 0) {
            return;
        }
        int i = this.h - 1;
        this.h = i;
        int i2 = this.i;
        this.j = i2;
        int i3 = this.f;
        int i4 = i2 - (i / i3);
        int i5 = i % i3;
        this.h = i5;
        this.i = i4;
        int a = java.lang.Math.abs(i5) > this.f / 2 ? a(2) : a(3);
        if (this.k != a) {
            this.k = a;
        }
        invalidate();
        if (this.n) {
            postDelayed(this.a, 1000 / this.g);
        }
    }

    private void b(int i) {
        int i2 = this.f;
        int i3 = this.j - (i / i2);
        int i4 = i % i2;
        this.h = i4;
        this.i = i3;
        int a = java.lang.Math.abs(i4) > this.f / 2 ? a(2) : a(3);
        if (this.k != a) {
            this.k = a;
        }
        invalidate();
    }

    private void b(int i, int i2, int i3) {
        if (i3 == 0) {
            float f = (-i) / 2;
            this.b.translate(f, 0.0f, 0.0f);
            float f2 = -i2;
            this.b.rotateY(f2);
            this.b.translate(f, 0.0f, 0.0f);
            this.b.translate(f, 0.0f, 0.0f);
            this.b.rotateY(f2);
            this.b.translate(f, 0.0f, 0.0f);
            return;
        }
        if (i3 == 1) {
            float f3 = i / 2;
            this.b.translate(f3, 0.0f, 0.0f);
            this.b.rotateY(i2);
            this.b.translate(f3, 0.0f, 0.0f);
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return;
            }
            this.b.rotateY(0.0f);
        } else {
            float f4 = (-i) / 2;
            this.b.translate(f4, 0.0f, 0.0f);
            this.b.rotateY(-i2);
            this.b.translate(f4, 0.0f, 0.0f);
        }
    }

    private void b(android.graphics.Canvas canvas) {
        int height = getHeight() / 2;
        int i = ((this.h * this.d) / 2) / this.f;
        a(canvas, i, height, 0);
        a(canvas, i, height, 1);
        if (java.lang.Math.abs(this.h) > this.f / 2) {
            a(canvas, i, height, 3);
            a(canvas, i, height, 2);
        } else {
            a(canvas, i, height, 2);
            a(canvas, i, height, 3);
        }
    }

    private void b(android.graphics.Canvas canvas, int i, int i2, int i3) {
        canvas.save();
        this.b.save();
        this.c.reset();
        float f = i;
        this.b.translate(f, 0.0f, 0.0f);
        this.b.rotateY(this.h);
        this.b.translate(f, 0.0f, 0.0f);
        if (i == 0) {
            if (this.p) {
                b(this.e, this.f, i3);
            } else {
                b(-this.e, -this.f, i3);
            }
        } else if (i > 0) {
            b(this.e, this.f, i3);
        } else if (i < 0) {
            b(-this.e, -this.f, i3);
        }
        this.b.getMatrix(this.c);
        this.b.restore();
        this.c.preTranslate(-i2, (-getHeight()) / 2);
        this.c.postTranslate(i2, getHeight() / 2);
        canvas.concat(this.c);
        android.view.View childAt = getChildAt(a(i3));
        if (childAt != null) {
            drawChild(canvas, childAt, 0L);
        }
        canvas.restore();
    }

    private void c(int i) {
        this.i = i;
        int a = java.lang.Math.abs(this.h) > this.f / 2 ? a(2) : a(3);
        if (this.k != a) {
            this.k = a;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.o) {
            int height = getHeight() / 2;
            int i = ((this.h * this.d) / 2) / this.f;
            a(canvas, i, height, 0);
            a(canvas, i, height, 1);
            if (java.lang.Math.abs(this.h) > this.f / 2) {
                a(canvas, i, height, 3);
                a(canvas, i, height, 2);
                return;
            } else {
                a(canvas, i, height, 2);
                a(canvas, i, height, 3);
                return;
            }
        }
        int width = getWidth() / 2;
        int i2 = ((this.h * this.e) / 2) / this.f;
        b(canvas, i2, width, 0);
        b(canvas, i2, width, 1);
        if (java.lang.Math.abs(this.h) > this.f / 2) {
            b(canvas, i2, width, 3);
            b(canvas, i2, width, 2);
        } else {
            b(canvas, i2, width, 2);
            b(canvas, i2, width, 3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        float f = i5;
        float f2 = this.l;
        int i6 = (int) (((1.0f - f2) * f) / 2.0f);
        int i7 = i4 - i2;
        float f3 = i7;
        float f4 = this.m;
        int i8 = (int) (((1.0f - f4) * f3) / 2.0f);
        this.d = (int) (f3 * f4);
        this.e = (int) (f * f2);
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            android.view.View childAt = getChildAt(i9);
            childAt.layout(i6, i8, i5 - i6, i7 - i8);
            childAt.setClickable(true);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i10 = layoutParams.width;
            int i11 = this.e;
            if (i10 != i11) {
                layoutParams.width = i11;
                layoutParams.height = this.d;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAutoscroll(boolean z) {
        if (z) {
            postDelayed(this.a, 1000 / this.g);
        }
        this.n = z;
    }

    public void setHeightRatio(float f) {
        this.m = f;
    }

    public void setRotateV(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setWidthRatio(float f) {
        this.l = f;
    }
}
