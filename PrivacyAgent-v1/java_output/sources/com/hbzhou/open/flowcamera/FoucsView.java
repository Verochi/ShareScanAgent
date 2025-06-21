package com.hbzhou.open.flowcamera;

/* loaded from: classes22.dex */
public class FoucsView extends android.view.View {
    public int n;
    public int t;
    public int u;
    public int v;
    public android.graphics.Paint w;

    public FoucsView(android.content.Context context) {
        this(context, null);
    }

    public FoucsView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FoucsView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = com.hbzhou.open.flowcamera.util.ScreenUtils.getScreenWidth(context) / 3;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.w = paint;
        paint.setAntiAlias(true);
        this.w.setDither(true);
        this.w.setColor(-300503530);
        this.w.setStrokeWidth(4.0f);
        this.w.setStyle(android.graphics.Paint.Style.STROKE);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int i = this.t;
        int i2 = this.v;
        int i3 = this.u;
        canvas.drawRect(i - i2, i3 - i2, i + i2, i3 + i2, this.w);
        canvas.drawLine(2.0f, getHeight() / 2, this.n / 10, getHeight() / 2, this.w);
        canvas.drawLine(getWidth() - 2, getHeight() / 2, getWidth() - (this.n / 10), getHeight() / 2, this.w);
        canvas.drawLine(getWidth() / 2, 2.0f, getWidth() / 2, this.n / 10, this.w);
        canvas.drawLine(getWidth() / 2, getHeight() - 2, getWidth() / 2, getHeight() - (this.n / 10), this.w);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.n;
        this.t = (int) (i3 / 2.0d);
        this.u = (int) (i3 / 2.0d);
        this.v = ((int) (i3 / 2.0d)) - 2;
        setMeasuredDimension(i3, i3);
    }
}
