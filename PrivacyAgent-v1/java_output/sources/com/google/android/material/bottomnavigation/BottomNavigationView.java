package com.google.android.material.bottomnavigation;

/* loaded from: classes22.dex */
public class BottomNavigationView extends com.google.android.material.navigation.NavigationBarView {
    static final int MAX_ITEM_COUNT = 5;

    @java.lang.Deprecated
    public interface OnNavigationItemReselectedListener extends com.google.android.material.navigation.NavigationBarView.OnItemReselectedListener {
    }

    @java.lang.Deprecated
    public interface OnNavigationItemSelectedListener extends com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public BottomNavigationView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, com.google.android.material.R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        android.content.Context context2 = getContext();
        androidx.appcompat.widget.TintTypedArray obtainTintedStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.BottomNavigationView, i, i2, new int[0]);
        setItemHorizontalTranslationEnabled(obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        obtainTintedStyledAttributes.recycle();
        if (shouldDrawCompatibilityTopDivider()) {
            addCompatibilityTopDivider(context2);
        }
    }

    private void addCompatibilityTopDivider(@androidx.annotation.NonNull android.content.Context context) {
        android.view.View view = new android.view.View(context);
        view.setBackgroundColor(androidx.core.content.ContextCompat.getColor(context, com.google.android.material.R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private boolean shouldDrawCompatibilityTopDivider() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public com.google.android.material.navigation.NavigationBarMenuView createNavigationBarMenuView(@androidx.annotation.NonNull android.content.Context context) {
        return new com.google.android.material.bottomnavigation.BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return ((com.google.android.material.bottomnavigation.BottomNavigationMenuView) getMenuView()).isItemHorizontalTranslationEnabled();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        com.google.android.material.bottomnavigation.BottomNavigationMenuView bottomNavigationMenuView = (com.google.android.material.bottomnavigation.BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.isItemHorizontalTranslationEnabled() != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            getPresenter().updateMenuView(false);
        }
    }

    @java.lang.Deprecated
    public void setOnNavigationItemReselectedListener(@androidx.annotation.Nullable com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        setOnItemReselectedListener(onNavigationItemReselectedListener);
    }

    @java.lang.Deprecated
    public void setOnNavigationItemSelectedListener(@androidx.annotation.Nullable com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        setOnItemSelectedListener(onNavigationItemSelectedListener);
    }
}
