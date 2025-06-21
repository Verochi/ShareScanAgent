package com.google.android.material.navigationrail;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class NavigationRailMenuView extends com.google.android.material.navigation.NavigationBarMenuView {
    private final android.widget.FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    private int makeSharedHeightSpec(int i, int i2, int i3) {
        return android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(android.view.View.MeasureSpec.getSize(i), i2 / java.lang.Math.max(1, i3)), 0);
    }

    private int measureChildHeight(android.view.View view, int i, int i2) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i, i2);
        return view.getMeasuredHeight();
    }

    private int measureSharedChildHeights(int i, int i2, int i3, android.view.View view) {
        makeSharedHeightSpec(i, i2, i3);
        int makeSharedHeightSpec = view == null ? makeSharedHeightSpec(i, i2, i3) : android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = getChildAt(i5);
            if (childAt != view) {
                i4 += measureChildHeight(childAt, i, makeSharedHeightSpec);
            }
        }
        return i4;
    }

    private int measureShiftingChildHeights(int i, int i2, int i3) {
        int i4;
        android.view.View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i4 = measureChildHeight(childAt, i, makeSharedHeightSpec(i, i2, i3));
            i2 -= i4;
            i3--;
        } else {
            i4 = 0;
        }
        return i4 + measureSharedChildHeights(i, i2, i3, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @androidx.annotation.NonNull
    public com.google.android.material.navigation.NavigationBarItemView createNavigationBarItemView(@androidx.annotation.NonNull android.content.Context context) {
        return new com.google.android.material.navigationrail.NavigationRailItemView(context);
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    public boolean isTopGravity() {
        return (this.layoutParams.gravity & 112) == 48;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            android.view.View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                childAt.layout(0, i6, i5, measuredHeight);
                i6 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i2);
        int size2 = getMenu().getVisibleItems().size();
        setMeasuredDimension(android.view.View.resolveSizeAndState(android.view.View.MeasureSpec.getSize(i), i, 0), android.view.View.resolveSizeAndState((size2 <= 1 || !isShifting(getLabelVisibilityMode(), size2)) ? measureSharedChildHeights(i, size, size2, null) : measureShiftingChildHeights(i, size, size2), i2, 0));
    }

    public void setMenuGravity(int i) {
        android.widget.FrameLayout.LayoutParams layoutParams = this.layoutParams;
        if (layoutParams.gravity != i) {
            layoutParams.gravity = i;
            setLayoutParams(layoutParams);
        }
    }
}
