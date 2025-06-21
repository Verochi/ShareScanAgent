package com.anythink.expressad.foundation.webview;

/* loaded from: classes12.dex */
public class ProgressBar extends android.view.View implements com.anythink.expressad.foundation.webview.a {
    private static final float C = 1200.0f;
    private static final long L = 25;
    private static final java.lang.String g = "ProgressBar";
    private static final boolean h = false;
    private static final float t = 0.05f;
    private static final float u = 0.2f;
    private static final float v = 0.4f;
    private static final float w = 1.0f;
    private static final long x = 2000;
    private static final float y = 0.2f;
    private int A;
    private int B;
    private long D;
    private android.graphics.drawable.Drawable E;
    private android.graphics.drawable.Drawable F;
    private android.graphics.drawable.Drawable G;
    private android.graphics.drawable.Drawable H;
    private boolean I;
    private com.anythink.expressad.foundation.webview.a.InterfaceC0215a J;
    private android.os.Handler K;
    private boolean M;
    private boolean N;
    java.lang.Runnable f;
    private android.graphics.Rect i;
    private float j;
    private float k;
    private long l;
    private float m;
    private boolean n;
    private float o;
    private float p;
    private float q;
    private long r;

    /* renamed from: s, reason: collision with root package name */
    private int f248s;
    private int z;

    /* renamed from: com.anythink.expressad.foundation.webview.ProgressBar$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.foundation.webview.ProgressBar.this.invalidate();
        }
    }

    public ProgressBar(android.content.Context context) {
        super(context);
        this.i = new android.graphics.Rect();
        this.k = 0.95f;
        this.D = L;
        this.I = false;
        this.K = new android.os.Handler(android.os.Looper.getMainLooper());
        this.f = new com.anythink.expressad.foundation.webview.ProgressBar.AnonymousClass1();
        this.N = false;
        setWillNotDraw(false);
    }

    public ProgressBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new android.graphics.Rect();
        this.k = 0.95f;
        this.D = L;
        this.I = false;
        this.K = new android.os.Handler(android.os.Looper.getMainLooper());
        this.f = new com.anythink.expressad.foundation.webview.ProgressBar.AnonymousClass1();
        this.N = false;
        setWillNotDraw(false);
    }

    private void a() {
        setWillNotDraw(false);
    }

    private void a(android.graphics.Canvas canvas, float f) {
        android.graphics.drawable.Drawable drawable;
        android.graphics.drawable.Drawable drawable2;
        if (this.n) {
            float f2 = this.o;
            float f3 = this.j;
            int i = (int) ((1.0f - (f2 / (f3 * 0.5f))) * 255.0f);
            if (i < 0) {
                i = 0;
            }
            if (f2 > f3 * 0.5f) {
                setVisible(false);
            }
            android.graphics.drawable.Drawable drawable3 = this.F;
            if (drawable3 != null) {
                drawable3.setAlpha(i);
            }
            android.graphics.drawable.Drawable drawable4 = this.G;
            if (drawable4 != null) {
                drawable4.setAlpha(i);
            }
            android.graphics.drawable.Drawable drawable5 = this.E;
            if (drawable5 != null) {
                drawable5.setAlpha(i);
            }
            canvas.save();
            canvas.translate(this.o, 0.0f);
        }
        if (this.F != null && this.E != null) {
            int width = (int) (this.i.width() - (this.E.getIntrinsicWidth() * t));
            android.graphics.drawable.Drawable drawable6 = this.F;
            drawable6.setBounds(0, 0, width, drawable6.getIntrinsicHeight());
            this.F.draw(canvas);
        }
        if (this.n && (drawable2 = this.G) != null && this.E != null) {
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            android.graphics.drawable.Drawable drawable7 = this.G;
            drawable7.setBounds(0, 0, intrinsicWidth, drawable7.getIntrinsicHeight());
            canvas.save();
            canvas.translate(-intrinsicWidth, 0.0f);
            this.G.draw(canvas);
            canvas.restore();
        }
        if (this.E != null) {
            canvas.save();
            canvas.translate(this.i.width() - getWidth(), 0.0f);
            this.E.draw(canvas);
            canvas.restore();
        }
        if (!this.n && java.lang.Math.abs(this.p - this.k) < 1.0E-5f && (drawable = this.H) != null) {
            int i2 = (int) (this.f248s + (f * 0.2f * this.j));
            this.f248s = i2;
            if (i2 + drawable.getIntrinsicWidth() >= this.i.width()) {
                this.f248s = -this.H.getIntrinsicWidth();
            }
            canvas.save();
            canvas.translate(this.f248s, 0.0f);
            this.H.draw(canvas);
            canvas.restore();
        }
        if (this.n) {
            canvas.restore();
        }
    }

    private float b() {
        if (this.n) {
            if (this.M) {
                return 1.0f;
            }
            return v;
        }
        if (this.r < 2000) {
            if (this.A == 1) {
                if (this.M) {
                    return 1.0f;
                }
                return v;
            }
            if (this.z == 1) {
                if (this.M) {
                    return v;
                }
                return 0.2f;
            }
            if (this.M) {
                return 0.2f;
            }
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r12.M != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x005e, code lost:
    
        r5 = 1.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x004b, code lost:
    
        if (r12.M == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0050, code lost:
    
        if (r12.M != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x005c, code lost:
    
        if (r12.M != false) goto L29;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable;
        android.graphics.drawable.Drawable drawable2;
        if (!this.I) {
            this.I = true;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j = this.N ? 0L : currentTimeMillis - this.l;
        float abs = java.lang.Math.abs(j / 1000.0f);
        this.m = abs;
        this.l = currentTimeMillis;
        long j2 = this.r + j;
        this.r = j2;
        boolean z = this.n;
        float f = v;
        if (!z) {
            if (j2 < 2000) {
                if (this.A != 1) {
                    if (this.z == 1) {
                    }
                    f = 0.2f;
                }
            }
            f = t;
        }
        this.q = f;
        float f2 = this.p + (f * abs);
        this.p = f2;
        if (!z) {
            float f3 = this.k;
            if (f2 > f3) {
                this.p = f3;
            }
        }
        this.i.right = (int) (this.p * this.j);
        this.K.removeCallbacksAndMessages(null);
        this.K.postDelayed(this.f, this.D);
        super.draw(canvas);
        float f4 = this.m;
        if (this.n) {
            float f5 = this.o;
            float f6 = this.j;
            int i = (int) ((1.0f - (f5 / (f6 * 0.5f))) * 255.0f);
            if (i < 0) {
                i = 0;
            }
            if (f5 > f6 * 0.5f) {
                setVisible(false);
            }
            android.graphics.drawable.Drawable drawable3 = this.F;
            if (drawable3 != null) {
                drawable3.setAlpha(i);
            }
            android.graphics.drawable.Drawable drawable4 = this.G;
            if (drawable4 != null) {
                drawable4.setAlpha(i);
            }
            android.graphics.drawable.Drawable drawable5 = this.E;
            if (drawable5 != null) {
                drawable5.setAlpha(i);
            }
            canvas.save();
            canvas.translate(this.o, 0.0f);
        }
        if (this.F != null && this.E != null) {
            int width = (int) (this.i.width() - (this.E.getIntrinsicWidth() * t));
            android.graphics.drawable.Drawable drawable6 = this.F;
            drawable6.setBounds(0, 0, width, drawable6.getIntrinsicHeight());
            this.F.draw(canvas);
        }
        if (this.n && (drawable2 = this.G) != null && this.E != null) {
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            android.graphics.drawable.Drawable drawable7 = this.G;
            drawable7.setBounds(0, 0, intrinsicWidth, drawable7.getIntrinsicHeight());
            canvas.save();
            canvas.translate(-intrinsicWidth, 0.0f);
            this.G.draw(canvas);
            canvas.restore();
        }
        if (this.E != null) {
            canvas.save();
            canvas.translate(this.i.width() - getWidth(), 0.0f);
            this.E.draw(canvas);
            canvas.restore();
        }
        if (!this.n && java.lang.Math.abs(this.p - this.k) < 1.0E-5f && (drawable = this.H) != null) {
            int i2 = (int) (this.f248s + (f4 * 0.2f * this.j));
            this.f248s = i2;
            if (i2 + drawable.getIntrinsicWidth() >= this.i.width()) {
                this.f248s = -this.H.getIntrinsicWidth();
            }
            canvas.save();
            canvas.translate(this.f248s, 0.0f);
            this.H.draw(canvas);
            canvas.restore();
        }
        if (this.n) {
            canvas.restore();
        }
    }

    @Override // android.view.View
    public android.graphics.Bitmap getDrawingCache(boolean z) {
        return null;
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public float getProgress() {
        return this.p;
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void initResource(boolean z) {
        if (z || (this.H == null && this.E == null && this.F == null && this.G == null)) {
            android.graphics.drawable.Drawable drawable = getResources().getDrawable(getResources().getIdentifier("anythink_cm_highlight", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
            this.H = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.H.getIntrinsicHeight());
            }
            android.graphics.drawable.Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("anythink_cm_head", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
            this.E = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.E.getIntrinsicHeight());
            }
            this.F = getResources().getDrawable(getResources().getIdentifier("anythink_cm_tail", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
            this.G = getResources().getDrawable(getResources().getIdentifier("anythink_cm_end_animation", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = getMeasuredWidth();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void onThemeChange() {
        if (this.I) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        android.graphics.drawable.Drawable drawable = this.H;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (drawable.getIntrinsicWidth() * 1.5d), getHeight());
        }
        android.graphics.drawable.Drawable drawable2 = this.E;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setPaused(boolean z) {
        this.N = z;
        if (z) {
            return;
        }
        this.l = java.lang.System.currentTimeMillis();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setProgress(float f, boolean z) {
        if (!z || f < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setProgressBarListener(com.anythink.expressad.foundation.webview.a.InterfaceC0215a interfaceC0215a) {
        this.J = interfaceC0215a;
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setProgressState(int i) {
        if (i == 5) {
            this.z = 1;
            this.A = 0;
            this.B = 0;
            this.r = 0L;
            return;
        }
        if (i == 6) {
            this.A = 1;
            if (this.B == 1) {
                startEndAnimation();
            }
            this.r = 0L;
            return;
        }
        if (i == 7) {
            startEndAnimation();
        } else {
            if (i != 8) {
                return;
            }
            this.B = 1;
            if (this.A == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View, com.anythink.expressad.foundation.webview.a
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setVisible(boolean z) {
        if (!z) {
            setVisibility(4);
            return;
        }
        this.M = true;
        this.l = java.lang.System.currentTimeMillis();
        this.m = 0.0f;
        this.r = 0L;
        this.n = false;
        this.o = 0.0f;
        this.p = 0.0f;
        this.j = getMeasuredWidth();
        this.N = false;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        android.graphics.drawable.Drawable drawable = this.H;
        if (drawable != null) {
            this.f248s = -drawable.getIntrinsicWidth();
        } else {
            this.f248s = 0;
        }
        android.graphics.drawable.Drawable drawable2 = this.F;
        if (drawable2 != null) {
            drawable2.setAlpha(255);
        }
        android.graphics.drawable.Drawable drawable3 = this.G;
        if (drawable3 != null) {
            drawable3.setAlpha(255);
        }
        android.graphics.drawable.Drawable drawable4 = this.E;
        if (drawable4 != null) {
            drawable4.setAlpha(255);
        }
        setVisibility(0);
        invalidate();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void startEndAnimation() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = 0.0f;
    }
}
