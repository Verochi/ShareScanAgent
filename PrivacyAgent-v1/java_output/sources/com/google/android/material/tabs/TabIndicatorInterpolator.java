package com.google.android.material.tabs;

/* loaded from: classes22.dex */
class TabIndicatorInterpolator {

    @androidx.annotation.Dimension(unit = 0)
    private static final int MIN_INDICATOR_WIDTH = 24;

    public static android.graphics.RectF calculateIndicatorWidthForTab(com.google.android.material.tabs.TabLayout tabLayout, @androidx.annotation.Nullable android.view.View view) {
        return view == null ? new android.graphics.RectF() : (tabLayout.isTabIndicatorFullWidth() || !(view instanceof com.google.android.material.tabs.TabLayout.TabView)) ? new android.graphics.RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : calculateTabViewContentBounds((com.google.android.material.tabs.TabLayout.TabView) view, 24);
    }

    public static android.graphics.RectF calculateTabViewContentBounds(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.TabView tabView, @androidx.annotation.Dimension(unit = 0) int i) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int dpToPx = (int) com.google.android.material.internal.ViewUtils.dpToPx(tabView.getContext(), i);
        if (contentWidth < dpToPx) {
            contentWidth = dpToPx;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i2 = contentWidth / 2;
        return new android.graphics.RectF(left - i2, top - (contentHeight / 2), i2 + left, top + (left / 2));
    }

    public void setIndicatorBoundsForOffset(com.google.android.material.tabs.TabLayout tabLayout, android.view.View view, android.view.View view2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.RectF calculateIndicatorWidthForTab = calculateIndicatorWidthForTab(tabLayout, view);
        android.graphics.RectF calculateIndicatorWidthForTab2 = calculateIndicatorWidthForTab(tabLayout, view2);
        drawable.setBounds(com.google.android.material.animation.AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, (int) calculateIndicatorWidthForTab2.left, f), drawable.getBounds().top, com.google.android.material.animation.AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, (int) calculateIndicatorWidthForTab2.right, f), drawable.getBounds().bottom);
    }

    public void setIndicatorBoundsForTab(com.google.android.material.tabs.TabLayout tabLayout, android.view.View view, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.RectF calculateIndicatorWidthForTab = calculateIndicatorWidthForTab(tabLayout, view);
        drawable.setBounds((int) calculateIndicatorWidthForTab.left, drawable.getBounds().top, (int) calculateIndicatorWidthForTab.right, drawable.getBounds().bottom);
    }
}
