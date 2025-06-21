package com.anythink.basead.ui.animplayerview.viewpager;

/* loaded from: classes12.dex */
public class CircleIndicatorView extends android.view.View {
    private boolean a;
    private final android.graphics.Path b;

    public CircleIndicatorView(android.content.Context context) {
        this(context, null);
    }

    public CircleIndicatorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicatorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new android.graphics.Path();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = java.lang.Math.min(width, height);
        this.b.reset();
        this.b.addCircle(width, height, min, android.graphics.Path.Direction.CCW);
        canvas.clipPath(this.b);
        canvas.drawColor(this.a ? -7829368 : -1);
        canvas.restore();
    }

    public void setSelectStatus(boolean z) {
        this.a = z;
        invalidate();
    }
}
