package com.google.android.material.internal;

/* loaded from: classes22.dex */
public class BaselineLayout extends android.view.ViewGroup {
    private int baseline;

    public BaselineLayout(android.content.Context context) {
        super(context, null, 0);
        this.baseline = -1;
    }

    public BaselineLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.baseline = -1;
    }

    public BaselineLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baseline = -1;
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.baseline;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i3 - i) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline = (this.baseline == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.baseline + paddingTop) - childAt.getBaseline();
                childAt.layout(i6, baseline, measuredWidth + i6, measuredHeight + baseline);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < childCount; i8++) {
            android.view.View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i6 = java.lang.Math.max(i6, baseline);
                    i7 = java.lang.Math.max(i7, childAt.getMeasuredHeight() - baseline);
                }
                i4 = java.lang.Math.max(i4, childAt.getMeasuredWidth());
                i3 = java.lang.Math.max(i3, childAt.getMeasuredHeight());
                i5 = android.view.View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        if (i6 != -1) {
            i3 = java.lang.Math.max(i3, java.lang.Math.max(i7, getPaddingBottom()) + i6);
            this.baseline = i6;
        }
        setMeasuredDimension(android.view.View.resolveSizeAndState(java.lang.Math.max(i4, getSuggestedMinimumWidth()), i, i5), android.view.View.resolveSizeAndState(java.lang.Math.max(i3, getSuggestedMinimumHeight()), i2, i5 << 16));
    }
}
