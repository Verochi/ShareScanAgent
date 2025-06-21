package com.anythink.core.basead.ui.web;

/* loaded from: classes12.dex */
public class WebProgressBarView extends android.view.View {
    int a;
    int b;
    android.graphics.Paint c;

    public WebProgressBarView(android.content.Context context) {
        super(context);
        a();
    }

    public WebProgressBarView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WebProgressBarView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = -14575885;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.c = paint;
        paint.setColor(this.b);
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.a = 0;
        setBackgroundColor(16777215);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.a) / 100, getHeight(), this.c);
        canvas.restore();
    }

    public void setProgress(int i) {
        this.a = i;
        postInvalidate();
    }
}
