package com.hbzhou.open.flowcamera;

/* loaded from: classes22.dex */
public class ReturnButton extends android.view.View {
    public int n;
    public int t;
    public int u;
    public float v;
    public android.graphics.Paint w;
    public android.graphics.Path x;

    public ReturnButton(android.content.Context context) {
        super(context);
    }

    public ReturnButton(android.content.Context context, int i) {
        this(context);
        this.n = i;
        int i2 = i / 2;
        this.t = i2;
        this.u = i2;
        this.v = i / 15.0f;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.w = paint;
        paint.setAntiAlias(true);
        this.w.setColor(-1);
        this.w.setStyle(android.graphics.Paint.Style.STROKE);
        this.w.setStrokeWidth(this.v);
        this.x = new android.graphics.Path();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        android.graphics.Path path = this.x;
        float f = this.v;
        path.moveTo(f, f / 2.0f);
        this.x.lineTo(this.t, this.u - (this.v / 2.0f));
        android.graphics.Path path2 = this.x;
        float f2 = this.n;
        float f3 = this.v;
        path2.lineTo(f2 - f3, f3 / 2.0f);
        canvas.drawPath(this.x, this.w);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.n;
        setMeasuredDimension(i3, i3 / 2);
    }
}
