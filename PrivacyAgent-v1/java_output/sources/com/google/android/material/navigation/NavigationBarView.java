package com.google.android.material.navigation;

/* loaded from: classes22.dex */
public abstract class NavigationBarView extends android.widget.FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList itemRippleColor;

    @androidx.annotation.NonNull
    private final com.google.android.material.navigation.NavigationBarMenu menu;
    private android.view.MenuInflater menuInflater;

    @androidx.annotation.NonNull
    private final com.google.android.material.navigation.NavigationBarMenuView menuView;

    @androidx.annotation.NonNull
    private final com.google.android.material.navigation.NavigationBarPresenter presenter;
    private com.google.android.material.navigation.NavigationBarView.OnItemReselectedListener reselectedListener;
    private com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener selectedListener;

    /* renamed from: com.google.android.material.navigation.NavigationBarView$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.appcompat.view.menu.MenuBuilder.Callback {
        public AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.MenuItem menuItem) {
            if (com.google.android.material.navigation.NavigationBarView.this.reselectedListener == null || menuItem.getItemId() != com.google.android.material.navigation.NavigationBarView.this.getSelectedItemId()) {
                return (com.google.android.material.navigation.NavigationBarView.this.selectedListener == null || com.google.android.material.navigation.NavigationBarView.this.selectedListener.onNavigationItemSelected(menuItem)) ? false : true;
            }
            com.google.android.material.navigation.NavigationBarView.this.reselectedListener.onNavigationItemReselected(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        @androidx.annotation.NonNull
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat, @androidx.annotation.NonNull com.google.android.material.internal.ViewUtils.RelativePadding relativePadding) {
            relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
            boolean z = androidx.core.view.ViewCompat.getLayoutDirection(view) == 1;
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            relativePadding.start += z ? systemWindowInsetRight : systemWindowInsetLeft;
            int i = relativePadding.end;
            if (!z) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            relativePadding.end = i + systemWindowInsetLeft;
            relativePadding.applyToView(view);
            return windowInsetsCompat;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void onNavigationItemReselected(@androidx.annotation.NonNull android.view.MenuItem menuItem);
    }

    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem);
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.navigation.NavigationBarView.SavedState> CREATOR = new com.google.android.material.navigation.NavigationBarView.SavedState.AnonymousClass1();

        @androidx.annotation.Nullable
        android.os.Bundle menuPresenterState;

        /* renamed from: com.google.android.material.navigation.NavigationBarView$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.navigation.NavigationBarView.SavedState> {
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.Nullable
            public com.google.android.material.navigation.NavigationBarView.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.navigation.NavigationBarView.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @androidx.annotation.NonNull
            public com.google.android.material.navigation.NavigationBarView.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.navigation.NavigationBarView.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.navigation.NavigationBarView.SavedState[] newArray(int i) {
                return new com.google.android.material.navigation.NavigationBarView.SavedState[i];
            }
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuPresenterState);
        }
    }

    public NavigationBarView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        com.google.android.material.navigation.NavigationBarPresenter navigationBarPresenter = new com.google.android.material.navigation.NavigationBarPresenter();
        this.presenter = navigationBarPresenter;
        android.content.Context context2 = getContext();
        int[] iArr = com.google.android.material.R.styleable.NavigationBarView;
        int i3 = com.google.android.material.R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int i4 = com.google.android.material.R.styleable.NavigationBarView_itemTextAppearanceActive;
        androidx.appcompat.widget.TintTypedArray obtainTintedStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, iArr, i, i2, i3, i4);
        com.google.android.material.navigation.NavigationBarMenu navigationBarMenu = new com.google.android.material.navigation.NavigationBarMenu(context2, getClass(), getMaxItemCount());
        this.menu = navigationBarMenu;
        com.google.android.material.navigation.NavigationBarMenuView createNavigationBarMenuView = createNavigationBarMenuView(context2);
        this.menuView = createNavigationBarMenuView;
        navigationBarPresenter.setMenuView(createNavigationBarMenuView);
        navigationBarPresenter.setId(1);
        createNavigationBarMenuView.setPresenter(navigationBarPresenter);
        navigationBarMenu.addMenuPresenter(navigationBarPresenter);
        navigationBarPresenter.initForMenu(getContext(), navigationBarMenu);
        int i5 = com.google.android.material.R.styleable.NavigationBarView_itemIconTint;
        if (obtainTintedStyledAttributes.hasValue(i5)) {
            createNavigationBarMenuView.setIconTintList(obtainTintedStyledAttributes.getColorStateList(i5));
        } else {
            createNavigationBarMenuView.setIconTintList(createNavigationBarMenuView.createDefaultColorStateList(android.R.attr.textColorSecondary));
        }
        setItemIconSize(obtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (obtainTintedStyledAttributes.hasValue(i3)) {
            setItemTextAppearanceInactive(obtainTintedStyledAttributes.getResourceId(i3, 0));
        }
        if (obtainTintedStyledAttributes.hasValue(i4)) {
            setItemTextAppearanceActive(obtainTintedStyledAttributes.getResourceId(i4, 0));
        }
        int i6 = com.google.android.material.R.styleable.NavigationBarView_itemTextColor;
        if (obtainTintedStyledAttributes.hasValue(i6)) {
            setItemTextColor(obtainTintedStyledAttributes.getColorStateList(i6));
        }
        if (getBackground() == null || (getBackground() instanceof android.graphics.drawable.ColorDrawable)) {
            androidx.core.view.ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(context2));
        }
        if (obtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationBarView_elevation)) {
            setElevation(obtainTintedStyledAttributes.getDimensionPixelSize(r12, 0));
        }
        androidx.core.graphics.drawable.DrawableCompat.setTintList(getBackground().mutate(), com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, com.google.android.material.R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(obtainTintedStyledAttributes.getInteger(com.google.android.material.R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = obtainTintedStyledAttributes.getResourceId(com.google.android.material.R.styleable.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            createNavigationBarMenuView.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainTintedStyledAttributes, com.google.android.material.R.styleable.NavigationBarView_itemRippleColor));
        }
        int i7 = com.google.android.material.R.styleable.NavigationBarView_menu;
        if (obtainTintedStyledAttributes.hasValue(i7)) {
            inflateMenu(obtainTintedStyledAttributes.getResourceId(i7, 0));
        }
        obtainTintedStyledAttributes.recycle();
        addView(createNavigationBarMenuView);
        navigationBarMenu.setCallback(new com.google.android.material.navigation.NavigationBarView.AnonymousClass1());
        applyWindowInsets();
    }

    private void applyWindowInsets() {
        com.google.android.material.internal.ViewUtils.doOnApplyWindowInsets(this, new com.google.android.material.navigation.NavigationBarView.AnonymousClass2());
    }

    @androidx.annotation.NonNull
    private com.google.android.material.shape.MaterialShapeDrawable createMaterialShapeDrawableBackground(android.content.Context context) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
        android.graphics.drawable.Drawable background = getBackground();
        if (background instanceof android.graphics.drawable.ColorDrawable) {
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(((android.graphics.drawable.ColorDrawable) background).getColor()));
        }
        materialShapeDrawable.initializeElevationOverlay(context);
        return materialShapeDrawable;
    }

    private android.view.MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new androidx.appcompat.view.SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public abstract com.google.android.material.navigation.NavigationBarMenuView createNavigationBarMenuView(@androidx.annotation.NonNull android.content.Context context);

    @androidx.annotation.Nullable
    public com.google.android.material.badge.BadgeDrawable getBadge(int i) {
        return this.menuView.getBadge(i);
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @androidx.annotation.DrawableRes
    @java.lang.Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    @androidx.annotation.Dimension
    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    @androidx.annotation.StyleRes
    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    @androidx.annotation.StyleRes
    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @androidx.annotation.NonNull
    public android.view.Menu getMenu() {
        return this.menu;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public androidx.appcompat.view.menu.MenuView getMenuView() {
        return this.menuView;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.badge.BadgeDrawable getOrCreateBadge(int i) {
        return this.menuView.getOrCreateBadge(i);
    }

    @androidx.annotation.NonNull
    public com.google.android.material.navigation.NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    @androidx.annotation.IdRes
    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int i) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@androidx.annotation.Nullable android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.navigation.NavigationBarView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.navigation.NavigationBarView.SavedState savedState = (com.google.android.material.navigation.NavigationBarView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuPresenterState);
    }

    @Override // android.view.View
    @androidx.annotation.NonNull
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.navigation.NavigationBarView.SavedState savedState = new com.google.android.material.navigation.NavigationBarView.SavedState(super.onSaveInstanceState());
        android.os.Bundle bundle = new android.os.Bundle();
        savedState.menuPresenterState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void removeBadge(int i) {
        this.menuView.removeBadge(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f);
    }

    public void setItemBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.menuView.setItemBackground(drawable);
        this.itemRippleColor = null;
    }

    public void setItemBackgroundResource(@androidx.annotation.DrawableRes int i) {
        this.menuView.setItemBackgroundRes(i);
        this.itemRippleColor = null;
    }

    public void setItemIconSize(@androidx.annotation.Dimension int i) {
        this.menuView.setItemIconSize(i);
    }

    public void setItemIconSizeRes(@androidx.annotation.DimenRes int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i, @androidx.annotation.Nullable android.view.View.OnTouchListener onTouchListener) {
        this.menuView.setItemOnTouchListener(i, onTouchListener);
    }

    public void setItemRippleColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.itemRippleColor == colorStateList) {
            if (colorStateList != null || this.menuView.getItemBackground() == null) {
                return;
            }
            this.menuView.setItemBackground(null);
            return;
        }
        this.itemRippleColor = colorStateList;
        if (colorStateList == null) {
            this.menuView.setItemBackground(null);
        } else {
            this.menuView.setItemBackground(new android.graphics.drawable.RippleDrawable(com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(@androidx.annotation.StyleRes int i) {
        this.menuView.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(@androidx.annotation.StyleRes int i) {
        this.menuView.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.menuView.getLabelVisibilityMode() != i) {
            this.menuView.setLabelVisibilityMode(i);
            this.presenter.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(@androidx.annotation.Nullable com.google.android.material.navigation.NavigationBarView.OnItemReselectedListener onItemReselectedListener) {
        this.reselectedListener = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(@androidx.annotation.Nullable com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener onItemSelectedListener) {
        this.selectedListener = onItemSelectedListener;
    }

    public void setSelectedItemId(@androidx.annotation.IdRes int i) {
        android.view.MenuItem findItem = this.menu.findItem(i);
        if (findItem == null || this.menu.performItemAction(findItem, this.presenter, 0)) {
            return;
        }
        findItem.setChecked(true);
    }
}
