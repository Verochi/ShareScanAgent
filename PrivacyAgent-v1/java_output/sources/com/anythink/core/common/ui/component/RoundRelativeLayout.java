package com.anythink.core.common.ui.component;

/* loaded from: classes12.dex */
public class RoundRelativeLayout extends android.widget.RelativeLayout {
    int a;

    public RoundRelativeLayout(android.content.Context context) {
        this(context, null);
    }

    public RoundRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = dip2px(context, 4.0f);
    }

    public RoundRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this(context);
    }

    private void a(android.content.Context context) {
        this.a = dip2px(context, 4.0f);
    }

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.draw(canvas);
        com.anythink.core.common.o.w.a(canvas, getWidth(), getHeight(), this.a);
        canvas.restoreToCount(saveLayer);
    }
}
