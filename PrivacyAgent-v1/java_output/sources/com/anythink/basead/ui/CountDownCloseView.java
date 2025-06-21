package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class CountDownCloseView extends com.anythink.basead.ui.CloseImageView {
    private android.graphics.Paint a;
    private android.graphics.Paint b;
    private float c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private android.graphics.RectF i;
    private float j;
    private long k;

    public CountDownCloseView(android.content.Context context) {
        this(context, null);
    }

    public CountDownCloseView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = android.util.TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.d = android.graphics.Color.parseColor("#FF57575A");
        this.e = -1;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.a.setStyle(android.graphics.Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setColor(this.e);
        this.i = new android.graphics.RectF();
    }

    private void a() {
        float f = this.c * 0.5f;
        float f2 = 0.0f + f;
        this.i.set(f2, f2, this.f - f, this.g - f);
        this.h = ((int) this.i.width()) >> 1;
    }

    private void a(android.content.Context context) {
        this.c = android.util.TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.d = android.graphics.Color.parseColor("#FF57575A");
        this.e = -1;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.a.setStyle(android.graphics.Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setColor(this.e);
        this.i = new android.graphics.RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.j < 360.0f) {
            this.a.setColor(this.d);
            canvas.drawArc(this.i, 0.0f, 360.0f, false, this.a);
            this.a.setColor(this.e);
            canvas.drawArc(this.i, -90.0f, this.j, false, this.a);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = i;
        this.g = i2;
        a();
    }

    public void refresh(long j) {
        long j2 = this.k;
        if (j2 > 0) {
            this.j = ((j * 1.0f) / j2) * 360.0f;
            postInvalidate();
        }
    }

    public void setDuration(long j) {
        this.k = j;
    }

    public void setThickInPx(int i) {
        float f = i;
        this.c = f;
        this.a.setStrokeWidth(f);
        a();
    }

    public void setUnderRingColor(int i) {
        this.d = i;
    }
}
