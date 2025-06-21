package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dr extends android.view.View {
    public static final int a = android.graphics.Color.argb(255, 235, 235, 235);
    public static final int b = android.graphics.Color.argb(255, 21, 21, 21);
    private android.graphics.Paint c;

    public dr(android.content.Context context) {
        super(context);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setColor(a);
    }

    public final void a() {
        setVisibility(8);
    }

    public final void a(int i) {
        android.graphics.Paint paint = this.c;
        if (paint != null) {
            paint.setColor(i);
            try {
                postInvalidate();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(android.graphics.Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.c);
    }
}
