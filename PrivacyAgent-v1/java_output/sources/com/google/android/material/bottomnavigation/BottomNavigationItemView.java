package com.google.android.material.bottomnavigation;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class BottomNavigationItemView extends com.google.android.material.navigation.NavigationBarItemView {
    public BottomNavigationItemView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @androidx.annotation.DimenRes
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.design_bottom_navigation_margin;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @androidx.annotation.LayoutRes
    public int getItemLayoutResId() {
        return com.google.android.material.R.layout.design_bottom_navigation_item;
    }
}
