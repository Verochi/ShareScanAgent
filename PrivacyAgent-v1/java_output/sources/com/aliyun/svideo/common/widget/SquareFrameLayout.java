package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public class SquareFrameLayout extends android.widget.FrameLayout implements com.aliyun.svideo.common.widget.SizeChangedNotifier {
    private com.aliyun.svideo.common.widget.SizeChangedNotifier.Listener mOnSizeChangedListener;

    public SquareFrameLayout(android.content.Context context) {
        super(context);
    }

    public SquareFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        if (size != 0 || size2 != 0) {
            int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec((size == 0 || size2 == 0) ? java.lang.Math.max(size, size2) : java.lang.Math.min(size, size2), 1073741824);
            super.onMeasure(makeMeasureSpec, makeMeasureSpec);
        } else {
            super.onMeasure(i, i2);
            int min = java.lang.Math.min(getMeasuredWidth(), getMeasuredHeight());
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.aliyun.svideo.common.widget.SizeChangedNotifier.Listener listener = this.mOnSizeChangedListener;
        if (listener != null) {
            listener.onSizeChanged(this, i, i2, i3, i4);
        }
    }

    @Override // com.aliyun.svideo.common.widget.SizeChangedNotifier
    public void setOnSizeChangedListener(com.aliyun.svideo.common.widget.SizeChangedNotifier.Listener listener) {
        this.mOnSizeChangedListener = listener;
    }
}
