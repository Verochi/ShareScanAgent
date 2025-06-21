package com.anythink.basead.ui.component;

/* loaded from: classes12.dex */
public class RoundFrameLayout extends android.widget.FrameLayout {
    int a;

    public RoundFrameLayout(android.content.Context context) {
        super(context);
        this.a = dip2px(getContext(), 10.0f);
    }

    public RoundFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = dip2px(getContext(), 10.0f);
    }

    public RoundFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = dip2px(getContext(), 10.0f);
    }

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        com.anythink.core.common.o.w.a(canvas, getWidth(), getHeight(), this.a);
        canvas.restoreToCount(saveLayer);
    }
}
