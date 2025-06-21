package com.amap.api.maps.offlinemap;

/* loaded from: classes12.dex */
public class DownloadProgressView extends android.view.View {
    private java.lang.String a;
    private int b;
    private int c;
    private float d;
    private float e;
    private android.text.TextPaint f;
    private android.text.TextPaint g;
    private float h;
    private float i;

    public DownloadProgressView(android.content.Context context) {
        super(context);
        this.b = androidx.core.internal.view.SupportMenu.CATEGORY_MASK;
        this.c = androidx.core.internal.view.SupportMenu.CATEGORY_MASK;
        this.d = 0.0f;
        this.e = 0.6f;
        a(null, 0);
    }

    public DownloadProgressView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = androidx.core.internal.view.SupportMenu.CATEGORY_MASK;
        this.c = androidx.core.internal.view.SupportMenu.CATEGORY_MASK;
        this.d = 0.0f;
        this.e = 0.6f;
        a(attributeSet, 0);
    }

    public DownloadProgressView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = androidx.core.internal.view.SupportMenu.CATEGORY_MASK;
        this.c = androidx.core.internal.view.SupportMenu.CATEGORY_MASK;
        this.d = 0.0f;
        this.e = 0.6f;
        a(attributeSet, i);
    }

    private void a() {
        this.f.setTextSize(this.d);
        this.f.setColor(this.b);
        this.g.setColor(this.c);
        this.h = this.f.measureText(this.a);
        this.i = this.f.getFontMetrics().bottom;
    }

    private void a(android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.amap.api.map3d.R.styleable.a, i, 0);
        this.a = obtainStyledAttributes.getString(0);
        this.b = obtainStyledAttributes.getColor(3, this.b);
        this.d = obtainStyledAttributes.getDimension(1, this.d);
        this.c = obtainStyledAttributes.getColor(2, this.c);
        obtainStyledAttributes.recycle();
        android.text.TextPaint textPaint = new android.text.TextPaint();
        this.f = textPaint;
        textPaint.setFlags(1);
        this.f.setTextAlign(android.graphics.Paint.Align.RIGHT);
        android.text.TextPaint textPaint2 = new android.text.TextPaint();
        this.g = textPaint2;
        textPaint2.setStyle(android.graphics.Paint.Style.FILL);
        a();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        java.lang.String str = java.lang.String.valueOf((int) (this.e * 100.0f)) + "%";
        canvas.drawRect(new android.graphics.Rect(0, (int) (height * 0.8f), (int) (width * this.e), height), this.g);
        canvas.drawText(str, (int) (this.e * r3), (int) (r1 - 3.0d), this.f);
    }

    public void setProgress(int i) {
        if (i > 100 || i < 0) {
            return;
        }
        this.e = i / 100.0f;
        invalidate();
    }
}
