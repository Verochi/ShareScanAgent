package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public class ClipRelativeLayout extends android.widget.RelativeLayout {
    public android.graphics.Region mAreaRegion;
    public android.graphics.Path mClipPath;
    public android.graphics.RectF mLayer;
    public android.graphics.Paint mPaint;
    public float[] radii;

    public ClipRelativeLayout(android.content.Context context) {
        this(context, null);
        a();
    }

    public ClipRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a();
    }

    public ClipRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radii = new float[8];
        a();
    }

    public final void a() {
        this.mLayer = new android.graphics.RectF();
        this.mClipPath = new android.graphics.Path();
        this.mAreaRegion = new android.graphics.Region();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        canvas.saveLayer(this.mLayer, null, 31);
        super.dispatchDraw(canvas);
        onClipDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void invalidate() {
        refreshRegion();
        super.invalidate();
    }

    public void onClipDraw(android.graphics.Canvas canvas) {
        this.mPaint.setColor(-1);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        if (android.os.Build.VERSION.SDK_INT <= 27) {
            this.mPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.mClipPath, this.mPaint);
            return;
        }
        this.mPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        android.graphics.Path path = new android.graphics.Path();
        android.graphics.RectF rectF = this.mLayer;
        path.addRect(rectF.left, rectF.top, ((int) rectF.width()) + this.mLayer.left, ((int) r2.height()) + this.mLayer.top, android.graphics.Path.Direction.CW);
        path.op(this.mClipPath, android.graphics.Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.mPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mLayer.set(0.0f, 0.0f, i, i2);
        refreshRegion();
    }

    public void refreshRegion() {
        android.graphics.RectF rectF = new android.graphics.RectF();
        android.graphics.RectF rectF2 = this.mLayer;
        rectF.left = rectF2.left;
        rectF.top = rectF2.top;
        rectF.right = rectF2.right;
        rectF.bottom = rectF2.bottom;
        this.mClipPath.reset();
        this.mClipPath.addRoundRect(rectF, this.radii, android.graphics.Path.Direction.CW);
        this.mAreaRegion.setPath(this.mClipPath, new android.graphics.Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }

    public void setRadius(int i) {
        int i2 = 0;
        while (true) {
            float[] fArr = this.radii;
            if (i2 >= fArr.length) {
                invalidate();
                return;
            } else {
                fArr[i2] = i;
                i2++;
            }
        }
    }

    public void setRectF(android.graphics.RectF rectF) {
        this.mLayer = rectF;
        invalidate();
    }
}
