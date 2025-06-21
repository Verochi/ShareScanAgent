package com.tencent.connect.avatar;

/* loaded from: classes19.dex */
public class b extends android.view.View {
    private android.graphics.Rect a;
    private android.graphics.Paint b;

    public b(android.content.Context context) {
        super(context);
        b();
    }

    private void b() {
        this.b = new android.graphics.Paint();
    }

    public android.graphics.Rect a() {
        if (this.a == null) {
            this.a = new android.graphics.Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = java.lang.Math.min(java.lang.Math.min((measuredHeight - 60) - 80, measuredWidth), com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH);
            int i = (measuredWidth - min) / 2;
            int i2 = (measuredHeight - min) / 2;
            this.a.set(i, i2, i + min, min + i2);
        }
        return this.a;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        android.graphics.Rect a = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.b.setStyle(android.graphics.Paint.Style.FILL);
        this.b.setColor(android.graphics.Color.argb(100, 0, 0, 0));
        float f = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f, a.top, this.b);
        canvas.drawRect(0.0f, a.bottom, f, measuredHeight, this.b);
        canvas.drawRect(0.0f, a.top, a.left, a.bottom, this.b);
        canvas.drawRect(a.right, a.top, f, a.bottom, this.b);
        canvas.drawColor(android.graphics.Color.argb(100, 0, 0, 0));
        this.b.setStyle(android.graphics.Paint.Style.STROKE);
        this.b.setColor(-1);
        canvas.drawRect(a.left, a.top, a.right - 1, a.bottom, this.b);
    }
}
