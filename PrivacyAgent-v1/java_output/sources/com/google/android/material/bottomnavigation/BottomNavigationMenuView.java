package com.google.android.material.bottomnavigation;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class BottomNavigationMenuView extends com.google.android.material.navigation.NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int[] tempChildWidths;

    public BottomNavigationMenuView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        android.content.res.Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_height);
        this.tempChildWidths = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @androidx.annotation.NonNull
    public com.google.android.material.navigation.NavigationBarItemView createNavigationBarItemView(@androidx.annotation.NonNull android.content.Context context) {
        return new com.google.android.material.bottomnavigation.BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            android.view.View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (androidx.core.view.ViewCompat.getLayoutDirection(this) == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.MenuBuilder menu = getMenu();
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
        if (isShifting(getLabelVisibilityMode(), size2) && isItemHorizontalTranslationEnabled()) {
            android.view.View childAt = getChildAt(getSelectedItemPosition());
            int i3 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i3 = java.lang.Math.max(i3, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = java.lang.Math.min(size - (this.inactiveItemMinWidth * i4), java.lang.Math.min(i3, this.activeItemMaxWidth));
            int i5 = size - min;
            int min2 = java.lang.Math.min(i5 / (i4 == 0 ? 1 : i4), this.inactiveItemMaxWidth);
            int i6 = i5 - (i4 * min2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    this.tempChildWidths[i7] = i7 == getSelectedItemPosition() ? min : min2;
                    if (i6 > 0) {
                        int[] iArr = this.tempChildWidths;
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.tempChildWidths[i7] = 0;
                }
                i7++;
            }
        } else {
            int min3 = java.lang.Math.min(size / (size2 != 0 ? size2 : 1), this.activeItemMaxWidth);
            int i8 = size - (size2 * min3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    int[] iArr2 = this.tempChildWidths;
                    iArr2[i9] = min3;
                    if (i8 > 0) {
                        iArr2[i9] = min3 + 1;
                        i8--;
                    }
                } else {
                    this.tempChildWidths[i9] = 0;
                }
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            android.view.View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i11], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i10 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(android.view.View.resolveSizeAndState(i10, android.view.View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), android.view.View.resolveSizeAndState(this.itemHeight, makeMeasureSpec, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.itemHorizontalTranslationEnabled = z;
    }
}
