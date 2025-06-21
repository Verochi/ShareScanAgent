package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class RoundCornerRelativeLayout extends android.widget.RelativeLayout {
    private android.graphics.Path a;
    private android.graphics.Paint b;
    private android.graphics.RectF c;
    private float d;

    public RoundCornerRelativeLayout(android.content.Context context) {
        super(context);
        this.d = 0.0f;
        a();
    }

    public RoundCornerRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        a();
    }

    public RoundCornerRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.0f;
        a();
    }

    @androidx.annotation.RequiresApi(api = 21)
    public RoundCornerRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = 0.0f;
        a();
    }

    private void a() {
        this.d = com.anythink.core.common.o.i.a(getContext(), 12.0f);
        this.a = new android.graphics.Path();
        this.b = new android.graphics.Paint(1);
        this.c = new android.graphics.RectF();
        this.b.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
    }

    private android.graphics.Path b() {
        this.a.reset();
        android.graphics.Path path = this.a;
        android.graphics.RectF rectF = this.c;
        float f = this.d;
        path.addRoundRect(rectF, f, f, android.graphics.Path.Direction.CW);
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        canvas.save();
        this.a.reset();
        android.graphics.Path path = this.a;
        android.graphics.RectF rectF = this.c;
        float f = this.d;
        path.addRoundRect(rectF, f, f, android.graphics.Path.Direction.CW);
        canvas.clipPath(this.a);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c.set(0.0f, 0.0f, i, i2);
    }
}
