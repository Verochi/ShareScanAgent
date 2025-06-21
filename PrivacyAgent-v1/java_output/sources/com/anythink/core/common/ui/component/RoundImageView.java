package com.anythink.core.common.ui.component;

/* loaded from: classes12.dex */
public class RoundImageView extends com.anythink.core.common.res.image.RecycleImageView {
    int a;
    boolean b;

    public RoundImageView(android.content.Context context) {
        super(context);
        this.a = com.anythink.core.common.o.i.a(getContext(), 5.0f);
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = com.anythink.core.common.o.i.a(getContext(), 5.0f);
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = com.anythink.core.common.o.i.a(getContext(), 5.0f);
    }

    @Override // com.anythink.core.common.res.image.RecycleImageView, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        try {
            if (this.b) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.dispatchDraw(canvas);
                canvas.translate(getPaddingLeft(), getPaddingTop());
                com.anythink.core.common.o.w.a(canvas, getWidth() - (getPaddingLeft() * 2), getHeight() - (getPaddingTop() * 2), this.a);
                canvas.restoreToCount(saveLayer);
                return;
            }
        } catch (java.lang.Exception unused) {
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.anythink.core.common.res.image.RecycleImageView, android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        try {
            if (this.b) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.onDraw(canvas);
                canvas.translate(getPaddingLeft(), getPaddingTop());
                com.anythink.core.common.o.w.a(canvas, getWidth() - (getPaddingLeft() * 2), getHeight() - (getPaddingTop() * 2), this.a);
                canvas.restoreToCount(saveLayer);
                return;
            }
        } catch (java.lang.Exception unused) {
        }
        super.onDraw(canvas);
    }

    public void setNeedRadiu(boolean z) {
        this.b = z;
    }

    public void setRadiusInDip(int i) {
        this.a = com.anythink.core.common.o.i.a(getContext(), i);
    }
}
