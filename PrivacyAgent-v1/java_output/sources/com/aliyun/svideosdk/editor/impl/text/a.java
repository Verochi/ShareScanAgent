package com.aliyun.svideosdk.editor.impl.text;

/* loaded from: classes12.dex */
public abstract class a extends android.graphics.drawable.Drawable {
    private android.text.StaticLayout a;
    private int c;
    private int f;
    private float g;
    protected int k;
    protected int l;
    protected int m;
    protected int n;

    /* renamed from: s, reason: collision with root package name */
    protected java.lang.CharSequence f96s;
    protected final android.text.TextPaint b = new android.text.TextPaint(1);
    private int d = 0;
    private android.graphics.Bitmap e = null;
    protected float h = 0.0f;
    protected float i = 1.0f;
    protected boolean j = true;
    protected int o = 0;
    protected int p = 0;
    protected int q = 0;
    protected int r = 0;
    public android.text.Layout.Alignment t = android.text.Layout.Alignment.ALIGN_CENTER;
    private int u = 1;
    private boolean v = true;

    private static float a(float f) {
        return java.lang.Math.max(2.0f, (f - 42.0f) / 15.0f);
    }

    private void a() {
        float a = a(this.b.getTextSize());
        this.g = a;
        this.b.setStrokeWidth(a);
        invalidateSelf();
    }

    public void a(float f, float f2) {
        this.h = f;
        this.i = f2;
        b();
    }

    public void a(int i) {
        this.d = i;
        invalidateSelf();
    }

    public void a(int i, int i2) {
        this.k = i;
        this.l = i2;
        b();
    }

    public void a(android.graphics.Bitmap bitmap) {
        this.e = bitmap;
        b();
    }

    public void a(android.graphics.Paint.Join join) {
        this.b.setStrokeJoin(join);
    }

    public void a(android.graphics.Typeface typeface) {
        this.b.setTypeface(typeface);
        b();
    }

    public void a(android.text.Layout.Alignment alignment) {
        if (alignment != null) {
            this.t = alignment;
        }
    }

    public void a(java.lang.CharSequence charSequence) {
        this.f96s = charSequence;
        b();
    }

    public void a(boolean z) {
        this.b.setFakeBoldText(z);
    }

    @android.annotation.SuppressLint({"WrongConstant"})
    public android.text.StaticLayout b(float f) {
        android.text.StaticLayout.Builder obtain;
        android.text.StaticLayout.Builder alignment;
        android.text.StaticLayout.Builder breakStrategy;
        android.text.StaticLayout.Builder lineSpacing;
        android.text.StaticLayout build;
        this.b.setTextSize(f);
        int i = android.os.Build.VERSION.SDK_INT;
        if (i <= 22) {
            return new android.text.StaticLayout(this.f96s, this.b, this.m, this.t, this.i, this.h, this.j);
        }
        java.lang.CharSequence charSequence = this.f96s;
        obtain = android.text.StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.b, this.m);
        alignment = obtain.setAlignment(this.t);
        breakStrategy = alignment.setBreakStrategy(this.u);
        lineSpacing = breakStrategy.setLineSpacing(this.h, this.i);
        lineSpacing.setIncludePad(this.j);
        if (i > 27) {
            obtain.setUseLineSpacingFromFallbacks(this.v);
        }
        build = obtain.build();
        return build;
    }

    public final void b() {
        this.a = null;
        invalidateSelf();
    }

    public void b(int i) {
        this.c = i;
        invalidateSelf();
    }

    public void b(int i, int i2) {
        this.p = i;
        this.q = i2;
    }

    public void b(boolean z) {
        this.j = z;
        b();
    }

    public abstract android.text.StaticLayout c();

    public void c(int i) {
        this.o = i;
    }

    public void c(int i, int i2) {
        this.m = i;
        this.n = i2;
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void d(int i) {
        this.r = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        float f;
        int i;
        if (this.a == null) {
            android.text.StaticLayout c = c();
            this.a = c;
            if (this.r > 0) {
                int lineCount = c.getLineCount();
                int i2 = this.r;
                if (lineCount > i2) {
                    this.f96s = this.f96s.subSequence(0, this.a.getLineStart(i2));
                    this.a = c();
                }
            }
            a();
        }
        canvas.save();
        android.graphics.Rect bounds = getBounds();
        canvas.drawColor(this.d);
        android.graphics.Bitmap bitmap = this.e;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = this.e.getHeight();
            android.graphics.Rect rect = new android.graphics.Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = width;
            rect.bottom = height;
            android.graphics.Rect rect2 = new android.graphics.Rect();
            rect2.left = 0;
            rect2.right = this.k;
            rect2.top = 0;
            rect2.bottom = this.l;
            canvas.drawBitmap(this.e, rect, rect2, (android.graphics.Paint) null);
        }
        canvas.translate(bounds.left, bounds.top);
        canvas.scale(bounds.width() / this.k, bounds.height() / this.l);
        if (this.t == android.text.Layout.Alignment.ALIGN_CENTER) {
            f = (((this.k - this.p) - this.a.getWidth()) / 2) + this.p;
            i = (((this.l - this.q) - this.a.getHeight()) / 2) + this.q;
        } else {
            f = this.p;
            i = this.q;
        }
        canvas.translate(f, i);
        android.text.TextPaint paint = this.a.getPaint();
        int i3 = this.f;
        if (i3 != 0) {
            paint.setColor(i3);
            paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            this.a.draw(canvas);
        }
        int i4 = this.c;
        if (i4 != 0) {
            paint.setColor(i4);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            this.a.draw(canvas);
        }
        canvas.restore();
    }

    public void e(int i) {
        this.f = i;
        invalidateSelf();
    }

    public void f(int i) {
        this.u = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.a = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }
}
