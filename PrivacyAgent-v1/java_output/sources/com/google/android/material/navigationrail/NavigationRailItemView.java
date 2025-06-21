package com.google.android.material.navigationrail;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
final class NavigationRailItemView extends com.google.android.material.navigation.NavigationBarItemView {
    public NavigationRailItemView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @androidx.annotation.DimenRes
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_rail_icon_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @androidx.annotation.LayoutRes
    public int getItemLayoutResId() {
        return com.google.android.material.R.layout.mtrl_navigation_rail_item;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (android.view.View.MeasureSpec.getMode(i2) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), android.view.View.resolveSizeAndState(java.lang.Math.max(getMeasuredHeight(), android.view.View.MeasureSpec.getSize(i2)), i2, 0));
        }
    }
}
