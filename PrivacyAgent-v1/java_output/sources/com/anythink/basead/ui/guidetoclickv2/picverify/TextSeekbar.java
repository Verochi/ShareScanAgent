package com.anythink.basead.ui.guidetoclickv2.picverify;

/* loaded from: classes12.dex */
public class TextSeekbar extends android.widget.SeekBar {
    java.lang.String a;
    android.graphics.RectF b;
    float c;
    android.graphics.Paint.FontMetrics d;
    private android.graphics.Paint e;
    private android.graphics.Paint f;

    public TextSeekbar(android.content.Context context) {
        super(context);
    }

    public TextSeekbar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextSeekbar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.e = paint;
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        this.e.setTextSize(com.anythink.core.common.o.i.a(context, 12.0f));
        this.e.setAntiAlias(true);
        this.e.setColor(android.graphics.Color.parseColor("#FFFFFF"));
        this.a = getContext().getString(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_g2c_seek_to_click", com.anythink.expressad.foundation.h.i.g));
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.f = paint2;
        paint2.setColor(android.graphics.Color.parseColor("#80000000"));
        this.c = com.anythink.core.common.o.i.a(getContext(), 12.0f);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (this.b == null) {
            this.b = new android.graphics.RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        android.graphics.RectF rectF = this.b;
        float f = this.c;
        canvas.drawRoundRect(rectF, f, f, this.f);
        if (this.d == null) {
            this.d = this.e.getFontMetrics();
        }
        android.graphics.Paint.FontMetrics fontMetrics = this.d;
        canvas.drawText(this.a, getWidth() / 2, (int) (((getHeight() / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.e);
        super.onDraw(canvas);
    }
}
