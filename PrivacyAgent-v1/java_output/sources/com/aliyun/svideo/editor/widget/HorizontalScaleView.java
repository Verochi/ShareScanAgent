package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class HorizontalScaleView extends android.view.View {
    public static final int LAYOUT_LEFT_TO_RIGHT = 1;
    public static final int LAYOUT_RIGHT_TO_LEFT = 2;
    private int mLayoutMode;
    private android.graphics.Rect mPreviousRect;

    public HorizontalScaleView(android.content.Context context) {
        super(context);
        this.mPreviousRect = new android.graphics.Rect();
        this.mLayoutMode = 1;
    }

    public HorizontalScaleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPreviousRect = new android.graphics.Rect();
        this.mLayoutMode = 1;
    }

    public HorizontalScaleView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPreviousRect = new android.graphics.Rect();
        this.mLayoutMode = 1;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mLayoutMode == 1) {
            super.onLayout(z, i, i2, i3, i4);
        }
        android.graphics.Rect rect = this.mPreviousRect;
        rect.left = i;
        rect.top = i2;
        rect.bottom = i4;
        rect.right = i3;
    }

    public void setWidthLeft(int i) {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
        }
    }

    public void setWidthRight(int i) {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            setLayoutParams(layoutParams);
        }
    }
}
