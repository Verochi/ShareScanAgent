package com.google.android.material.navigation;

/* loaded from: classes22.dex */
public class NavigationView extends com.google.android.material.internal.ScrimInsetsFrameLayout {
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener listener;
    private final int maxWidth;

    @androidx.annotation.NonNull
    private final com.google.android.material.internal.NavigationMenu menu;
    private android.view.MenuInflater menuInflater;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final com.google.android.material.internal.NavigationMenuPresenter presenter;
    private final int[] tmpLocation;
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_NavigationView;

    /* renamed from: com.google.android.material.navigation.NavigationView$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.appcompat.view.menu.MenuBuilder.Callback {
        public AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.MenuBuilder menuBuilder, android.view.MenuItem menuItem) {
            com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = com.google.android.material.navigation.NavigationView.this.listener;
            return onNavigationItemSelectedListener != null && onNavigationItemSelectedListener.onNavigationItemSelected(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            com.google.android.material.navigation.NavigationView navigationView = com.google.android.material.navigation.NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.tmpLocation);
            boolean z = com.google.android.material.navigation.NavigationView.this.tmpLocation[1] == 0;
            com.google.android.material.navigation.NavigationView.this.presenter.setBehindStatusBar(z);
            com.google.android.material.navigation.NavigationView.this.setDrawTopInsetForeground(z);
            android.app.Activity activity = com.google.android.material.internal.ContextUtils.getActivity(com.google.android.material.navigation.NavigationView.this.getContext());
            if (activity != null) {
                com.google.android.material.navigation.NavigationView.this.setDrawBottomInsetForeground((activity.findViewById(android.R.id.content).getHeight() == com.google.android.material.navigation.NavigationView.this.getHeight()) && (android.graphics.Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
            }
        }
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@androidx.annotation.NonNull android.view.MenuItem menuItem);
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.navigation.NavigationView.SavedState> CREATOR = new com.google.android.material.navigation.NavigationView.SavedState.AnonymousClass1();

        @androidx.annotation.Nullable
        public android.os.Bundle menuState;

        /* renamed from: com.google.android.material.navigation.NavigationView$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.navigation.NavigationView.SavedState> {
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.Nullable
            public com.google.android.material.navigation.NavigationView.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.navigation.NavigationView.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @androidx.annotation.NonNull
            public com.google.android.material.navigation.NavigationView.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.navigation.NavigationView.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.navigation.NavigationView.SavedState[] newArray(int i) {
                return new com.google.android.material.navigation.NavigationView.SavedState[i];
            }
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel, @androidx.annotation.Nullable java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }

    public NavigationView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public NavigationView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r6), attributeSet, i);
        int i2;
        boolean z;
        int i3 = DEF_STYLE_RES;
        com.google.android.material.internal.NavigationMenuPresenter navigationMenuPresenter = new com.google.android.material.internal.NavigationMenuPresenter();
        this.presenter = navigationMenuPresenter;
        this.tmpLocation = new int[2];
        android.content.Context context2 = getContext();
        com.google.android.material.internal.NavigationMenu navigationMenu = new com.google.android.material.internal.NavigationMenu(context2);
        this.menu = navigationMenu;
        androidx.appcompat.widget.TintTypedArray obtainTintedStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.NavigationView, i, i3, new int[0]);
        int i4 = com.google.android.material.R.styleable.NavigationView_android_background;
        if (obtainTintedStyledAttributes.hasValue(i4)) {
            androidx.core.view.ViewCompat.setBackground(this, obtainTintedStyledAttributes.getDrawable(i4));
        }
        if (getBackground() == null || (getBackground() instanceof android.graphics.drawable.ColorDrawable)) {
            com.google.android.material.shape.ShapeAppearanceModel build = com.google.android.material.shape.ShapeAppearanceModel.builder(context2, attributeSet, i, i3).build();
            android.graphics.drawable.Drawable background = getBackground();
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(build);
            if (background instanceof android.graphics.drawable.ColorDrawable) {
                materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(((android.graphics.drawable.ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            androidx.core.view.ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (obtainTintedStyledAttributes.hasValue(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(obtainTintedStyledAttributes.getDimensionPixelSize(r12, 0));
        }
        setFitsSystemWindows(obtainTintedStyledAttributes.getBoolean(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = obtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        int i5 = com.google.android.material.R.styleable.NavigationView_itemIconTint;
        android.content.res.ColorStateList colorStateList = obtainTintedStyledAttributes.hasValue(i5) ? obtainTintedStyledAttributes.getColorStateList(i5) : createDefaultColorStateList(android.R.attr.textColorSecondary);
        int i6 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance;
        if (obtainTintedStyledAttributes.hasValue(i6)) {
            i2 = obtainTintedStyledAttributes.getResourceId(i6, 0);
            z = true;
        } else {
            i2 = 0;
            z = false;
        }
        int i7 = com.google.android.material.R.styleable.NavigationView_itemIconSize;
        if (obtainTintedStyledAttributes.hasValue(i7)) {
            setItemIconSize(obtainTintedStyledAttributes.getDimensionPixelSize(i7, 0));
        }
        int i8 = com.google.android.material.R.styleable.NavigationView_itemTextColor;
        android.content.res.ColorStateList colorStateList2 = obtainTintedStyledAttributes.hasValue(i8) ? obtainTintedStyledAttributes.getColorStateList(i8) : null;
        if (!z && colorStateList2 == null) {
            colorStateList2 = createDefaultColorStateList(android.R.attr.textColorPrimary);
        }
        android.graphics.drawable.Drawable drawable = obtainTintedStyledAttributes.getDrawable(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (drawable == null && hasShapeAppearance(obtainTintedStyledAttributes)) {
            drawable = createDefaultItemBackground(obtainTintedStyledAttributes);
        }
        int i9 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding;
        if (obtainTintedStyledAttributes.hasValue(i9)) {
            navigationMenuPresenter.setItemHorizontalPadding(obtainTintedStyledAttributes.getDimensionPixelSize(i9, 0));
        }
        int dimensionPixelSize = obtainTintedStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(obtainTintedStyledAttributes.getInt(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        navigationMenu.setCallback(new com.google.android.material.navigation.NavigationView.AnonymousClass1());
        navigationMenuPresenter.setId(1);
        navigationMenuPresenter.initForMenu(context2, navigationMenu);
        navigationMenuPresenter.setItemIconTintList(colorStateList);
        navigationMenuPresenter.setOverScrollMode(getOverScrollMode());
        if (z) {
            navigationMenuPresenter.setItemTextAppearance(i2);
        }
        navigationMenuPresenter.setItemTextColor(colorStateList2);
        navigationMenuPresenter.setItemBackground(drawable);
        navigationMenuPresenter.setItemIconPadding(dimensionPixelSize);
        navigationMenu.addMenuPresenter(navigationMenuPresenter);
        addView((android.view.View) navigationMenuPresenter.getMenuView(this));
        int i10 = com.google.android.material.R.styleable.NavigationView_menu;
        if (obtainTintedStyledAttributes.hasValue(i10)) {
            inflateMenu(obtainTintedStyledAttributes.getResourceId(i10, 0));
        }
        int i11 = com.google.android.material.R.styleable.NavigationView_headerLayout;
        if (obtainTintedStyledAttributes.hasValue(i11)) {
            inflateHeaderView(obtainTintedStyledAttributes.getResourceId(i11, 0));
        }
        obtainTintedStyledAttributes.recycle();
        setupInsetScrimsListener();
    }

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList createDefaultColorStateList(int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        android.content.res.ColorStateList colorStateList = androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new android.content.res.ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, android.widget.FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    @androidx.annotation.NonNull
    private final android.graphics.drawable.Drawable createDefaultItemBackground(@androidx.annotation.NonNull androidx.appcompat.widget.TintTypedArray tintTypedArray) {
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(com.google.android.material.shape.ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(com.google.android.material.resources.MaterialResources.getColorStateList(getContext(), tintTypedArray, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new android.graphics.drawable.InsetDrawable((android.graphics.drawable.Drawable) materialShapeDrawable, tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private android.view.MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new androidx.appcompat.view.SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(@androidx.annotation.NonNull androidx.appcompat.widget.TintTypedArray tintTypedArray) {
        return tintTypedArray.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new com.google.android.material.navigation.NavigationView.AnonymousClass2();
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@androidx.annotation.NonNull android.view.View view) {
        this.presenter.addHeaderView(view);
    }

    @androidx.annotation.Nullable
    public android.view.MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public android.view.View getHeaderView(int i) {
        return this.presenter.getHeaderView(i);
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    @androidx.annotation.Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    @androidx.annotation.Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @androidx.annotation.NonNull
    public android.view.Menu getMenu() {
        return this.menu;
    }

    public android.view.View inflateHeaderView(@androidx.annotation.LayoutRes int i) {
        return this.presenter.inflateHeaderView(i);
    }

    public void inflateMenu(int i) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.min(android.view.View.MeasureSpec.getSize(i), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.navigation.NavigationView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.navigation.NavigationView.SavedState savedState = (com.google.android.material.navigation.NavigationView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.navigation.NavigationView.SavedState savedState = new com.google.android.material.navigation.NavigationView.SavedState(super.onSaveInstanceState());
        android.os.Bundle bundle = new android.os.Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void removeHeaderView(@androidx.annotation.NonNull android.view.View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setCheckedItem(@androidx.annotation.IdRes int i) {
        android.view.MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            this.presenter.setCheckedItem((androidx.appcompat.view.menu.MenuItemImpl) findItem);
        }
    }

    public void setCheckedItem(@androidx.annotation.NonNull android.view.MenuItem menuItem) {
        android.view.MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem == null) {
            throw new java.lang.IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        }
        this.presenter.setCheckedItem((androidx.appcompat.view.menu.MenuItemImpl) findItem);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f);
    }

    public void setItemBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@androidx.annotation.DrawableRes int i) {
        setItemBackground(androidx.core.content.ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemHorizontalPadding(@androidx.annotation.Dimension int i) {
        this.presenter.setItemHorizontalPadding(i);
    }

    public void setItemHorizontalPaddingResource(@androidx.annotation.DimenRes int i) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(@androidx.annotation.Dimension int i) {
        this.presenter.setItemIconPadding(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(@androidx.annotation.Dimension int i) {
        this.presenter.setItemIconSize(i);
    }

    public void setItemIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i) {
        this.presenter.setItemMaxLines(i);
    }

    public void setItemTextAppearance(@androidx.annotation.StyleRes int i) {
        this.presenter.setItemTextAppearance(i);
    }

    public void setItemTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setNavigationItemSelectedListener(@androidx.annotation.Nullable com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        com.google.android.material.internal.NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i);
        }
    }
}
