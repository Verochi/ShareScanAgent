package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class WaveAnimImageView extends android.widget.ImageView {
    int a;
    int b;
    private android.graphics.Paint c;
    private com.anythink.basead.ui.WaveAnimImageView.a d;

    public static class a {
        float a;
        float b;
        float c;

        public a(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }
    }

    public WaveAnimImageView(android.content.Context context) {
        super(context);
        a();
    }

    public WaveAnimImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WaveAnimImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setStyle(android.graphics.Paint.Style.STROKE);
        this.c.setColor(android.graphics.Color.parseColor("#FFFFFF"));
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        com.anythink.basead.ui.WaveAnimImageView.a aVar = this.d;
        if (aVar != null) {
            this.c.setAlpha((int) (aVar.c * 255.0f));
            this.c.setStrokeWidth(this.d.b);
            canvas.drawCircle(this.a, this.b, this.d.a, this.c);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a = getWidth() / 2;
        this.b = getHeight() / 2;
    }

    public void setWaveAnimParams(com.anythink.basead.ui.WaveAnimImageView.a aVar) {
        this.d = aVar;
        postInvalidate();
    }
}
