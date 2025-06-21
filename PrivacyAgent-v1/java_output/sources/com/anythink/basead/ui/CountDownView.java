package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class CountDownView extends android.view.View {
    private android.graphics.Paint a;
    private android.graphics.Paint b;
    private android.graphics.Paint c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private android.graphics.RectF l;
    private float m;
    private java.lang.String n;
    private android.graphics.Rect o;
    private long p;
    private float q;
    private android.graphics.Paint.FontMetrics r;

    public CountDownView(android.content.Context context) {
        this(context, null);
    }

    public CountDownView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = android.util.TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.e = android.util.TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f = android.graphics.Color.parseColor("#66000000");
        this.g = android.graphics.Color.parseColor("#CC000000");
        this.h = -1;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.a.setStyle(android.graphics.Paint.Style.STROKE);
        this.a.setStrokeWidth(this.d);
        android.graphics.Paint paint2 = new android.graphics.Paint(this.a);
        this.b = paint2;
        paint2.setColor(this.f);
        this.b.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint3 = new android.graphics.Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setTextSize(this.e);
        this.c.setColor(this.h);
        this.l = new android.graphics.RectF();
        this.o = new android.graphics.Rect();
    }

    private void a() {
        float f = this.d * 0.5f;
        float f2 = 0.0f + f;
        this.l.set(f2, f2, this.i - f, this.j - f);
        this.k = ((int) this.l.width()) >> 1;
    }

    private void a(android.content.Context context) {
        this.d = android.util.TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.e = android.util.TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f = android.graphics.Color.parseColor("#66000000");
        this.g = android.graphics.Color.parseColor("#CC000000");
        this.h = -1;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.a.setStyle(android.graphics.Paint.Style.STROKE);
        this.a.setStrokeWidth(this.d);
        android.graphics.Paint paint2 = new android.graphics.Paint(this.a);
        this.b = paint2;
        paint2.setColor(this.f);
        this.b.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint3 = new android.graphics.Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setTextSize(this.e);
        this.c.setColor(this.h);
        this.l = new android.graphics.RectF();
        this.o = new android.graphics.Rect();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.l.centerX(), this.l.centerY(), this.k, this.b);
        this.a.setColor(this.g);
        canvas.drawArc(this.l, 0.0f, 360.0f, false, this.a);
        this.a.setColor(this.h);
        canvas.drawArc(this.l, -90.0f, this.m, false, this.a);
        if (android.text.TextUtils.isEmpty(this.n)) {
            return;
        }
        android.graphics.Paint paint = this.c;
        java.lang.String str = this.n;
        paint.getTextBounds(str, 0, str.length(), this.o);
        this.q = this.c.measureText(this.n);
        this.r = this.c.getFontMetrics();
        java.lang.String str2 = this.n;
        float centerX = this.l.centerX() - (this.q / 2.0f);
        float centerY = this.l.centerY();
        android.graphics.Paint.FontMetrics fontMetrics = this.r;
        float f = fontMetrics.bottom;
        canvas.drawText(str2, centerX, centerY + (((f - fontMetrics.top) / 2.0f) - f), this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = i;
        this.j = i2;
        a();
    }

    public void refresh(long j) {
        long j2 = this.p;
        if (j2 > 0) {
            this.m = ((j * 1.0f) / j2) * 360.0f;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append((int) java.lang.Math.ceil((this.p - j) / 1000.0d));
            this.n = sb.toString();
            postInvalidate();
        }
    }

    public void setBgColor(int i) {
        this.f = i;
        this.b.setColor(i);
    }

    public void setDuration(long j) {
        this.p = j;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(j / 1000);
        this.n = sb.toString();
    }

    public void setThickInPx(int i) {
        float f = i;
        this.d = f;
        this.a.setStrokeWidth(f);
        a();
    }

    public void setUnderRingColor(int i) {
        this.g = i;
    }
}
