package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TanxImageView extends android.widget.ImageView implements com.alimm.tanx.core.utils.NotConfused {
    float radio;

    public TanxImageView(android.content.Context context) {
        super(context);
        this.radio = 0.0f;
    }

    public TanxImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radio = 0.0f;
    }

    public TanxImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.radio = 0.0f;
    }

    public TanxImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.radio = 0.0f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int i3 = (int) (size * this.radio);
        com.alimm.tanx.core.utils.LogUtils.d("TanxImageView", "width - >" + size + "  height -> " + i3);
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public void setViewSize(float f) {
        this.radio = f;
    }
}
