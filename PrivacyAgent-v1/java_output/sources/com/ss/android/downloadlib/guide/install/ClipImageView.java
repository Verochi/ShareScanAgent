package com.ss.android.downloadlib.guide.install;

/* loaded from: classes19.dex */
public class ClipImageView extends android.widget.ImageView {
    private android.graphics.RectF t;
    private android.graphics.Paint v;
    private boolean vw;
    private android.graphics.Path wg;
    private float[] yl;

    public ClipImageView(android.content.Context context) {
        super(context);
        this.vw = true;
        vw(context);
    }

    public ClipImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vw = true;
        vw(context);
    }

    public ClipImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vw = true;
        vw(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (this.vw) {
            this.wg.reset();
            this.t.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.yl;
            if (fArr != null) {
                this.wg.addRoundRect(this.t, fArr, android.graphics.Path.Direction.CW);
            }
            canvas.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.wg);
            android.graphics.Paint paint = this.v;
            if (paint != null) {
                canvas.drawPath(this.wg, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.v = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        this.v.setColor(i);
    }

    public void setClip(boolean z) {
        this.vw = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.yl = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public void vw(android.content.Context context) {
        this.wg = new android.graphics.Path();
        this.t = new android.graphics.RectF();
    }
}
