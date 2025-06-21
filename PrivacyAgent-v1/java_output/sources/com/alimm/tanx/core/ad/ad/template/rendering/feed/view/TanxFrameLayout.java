package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TanxFrameLayout extends android.widget.FrameLayout implements com.alimm.tanx.core.utils.NotConfused {
    float radio;

    public TanxFrameLayout(android.content.Context context) {
        super(context);
        this.radio = 0.56f;
    }

    public TanxFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radio = 0.56f;
    }

    public TanxFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radio = 0.56f;
    }

    public TanxFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.radio = 0.56f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int) (android.view.View.MeasureSpec.getSize(i) * this.radio), 1073741824));
    }

    public void setViewSize(float f) {
        this.radio = f;
    }
}
