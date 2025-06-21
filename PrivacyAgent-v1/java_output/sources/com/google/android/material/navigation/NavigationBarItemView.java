package com.google.android.material.navigation;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public abstract class NavigationBarItemView extends android.widget.FrameLayout implements androidx.appcompat.view.menu.MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    private static final int INVALID_ITEM_POSITION = -1;

    @androidx.annotation.Nullable
    private com.google.android.material.badge.BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private android.widget.ImageView icon;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList iconTint;
    private boolean isShifting;

    @androidx.annotation.Nullable
    private androidx.appcompat.view.menu.MenuItemImpl itemData;
    private int itemPosition;
    private final android.view.ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final android.widget.TextView largeLabel;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final android.widget.TextView smallLabel;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable wrappedIconDrawable;

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnLayoutChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (com.google.android.material.navigation.NavigationBarItemView.this.icon.getVisibility() == 0) {
                com.google.android.material.navigation.NavigationBarItemView navigationBarItemView = com.google.android.material.navigation.NavigationBarItemView.this;
                navigationBarItemView.tryUpdateBadgeBounds(navigationBarItemView.icon);
            }
        }
    }

    public NavigationBarItemView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.itemPosition = -1;
        android.view.LayoutInflater.from(context).inflate(getItemLayoutResId(), (android.view.ViewGroup) this, true);
        this.icon = (android.widget.ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.labelGroup = viewGroup;
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.smallLabel = textView;
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.largeLabel = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.defaultMargin = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        viewGroup.setTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding, java.lang.Integer.valueOf(viewGroup.getPaddingBottom()));
        androidx.core.view.ViewCompat.setImportantForAccessibility(textView, 2);
        androidx.core.view.ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        calculateTextScaleFactors(textView.getTextSize(), textView2.getTextSize());
        android.widget.ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new com.google.android.material.navigation.NavigationBarItemView.AnonymousClass1());
        }
    }

    private void calculateTextScaleFactors(float f, float f2) {
        this.shiftAmount = f - f2;
        this.scaleUpFactor = (f2 * 1.0f) / f;
        this.scaleDownFactor = (f * 1.0f) / f2;
    }

    @androidx.annotation.Nullable
    private android.widget.FrameLayout getCustomParentForBadge(android.view.View view) {
        android.widget.ImageView imageView = this.icon;
        if (view == imageView && com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
            return (android.widget.FrameLayout) imageView.getParent();
        }
        return null;
    }

    private int getItemVisiblePosition() {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < indexOfChild; i2++) {
            android.view.View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof com.google.android.material.navigation.NavigationBarItemView) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconHeight() {
        com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return java.lang.Math.max(minimumHeight, ((android.widget.FrameLayout.LayoutParams) this.icon.getLayoutParams()).topMargin) + this.icon.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.icon.getLayoutParams();
        return java.lang.Math.max(minimumWidth, layoutParams.leftMargin) + this.icon.getMeasuredWidth() + java.lang.Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    private static void setViewLayoutParams(@androidx.annotation.NonNull android.view.View view, int i, int i2) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(@androidx.annotation.NonNull android.view.View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private void tryAttachBadgeToAnchor(@androidx.annotation.Nullable android.view.View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(@androidx.annotation.Nullable android.view.View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateBadgeBounds(android.view.View view) {
        if (hasBadge()) {
            com.google.android.material.badge.BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private static void updateViewPaddingBottom(@androidx.annotation.NonNull android.view.View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    @androidx.annotation.Nullable
    public com.google.android.material.badge.BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @androidx.annotation.DrawableRes
    public int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @androidx.annotation.Nullable
    public androidx.appcompat.view.menu.MenuItemImpl getItemData() {
        return this.itemData;
    }

    @androidx.annotation.DimenRes
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @androidx.annotation.LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.labelGroup.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return java.lang.Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.labelGroup.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuItemImpl menuItemImpl, int i) {
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!android.text.TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        java.lang.CharSequence tooltipText = !android.text.TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle();
        if (android.os.Build.VERSION.SDK_INT > 23) {
            androidx.appcompat.widget.TooltipCompat.setTooltipText(this, tooltipText);
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    @androidx.annotation.NonNull
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.itemData.isChecked()) {
            android.view.View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            java.lang.CharSequence title = this.itemData.getTitle();
            if (!android.text.TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((java.lang.Object) title) + ", " + ((java.lang.Object) this.badgeDrawable.getContentDescription()));
        }
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrap = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setBadge(@androidx.annotation.NonNull com.google.android.material.badge.BadgeDrawable badgeDrawable) {
        this.badgeDrawable = badgeDrawable;
        android.widget.ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        this.largeLabel.setPivotX(r0.getWidth() / 2);
        this.largeLabel.setPivotY(r0.getBaseline());
        this.smallLabel.setPivotX(r0.getWidth() / 2);
        this.smallLabel.setPivotY(r0.getBaseline());
        int i = this.labelVisibilityMode;
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    android.view.ViewGroup viewGroup = this.labelGroup;
                    updateViewPaddingBottom(viewGroup, ((java.lang.Integer) viewGroup.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
                    this.largeLabel.setVisibility(0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(4);
                }
                this.smallLabel.setVisibility(4);
            } else if (i == 1) {
                android.view.ViewGroup viewGroup2 = this.labelGroup;
                updateViewPaddingBottom(viewGroup2, ((java.lang.Integer) viewGroup2.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
                if (z) {
                    setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                    setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                    android.widget.TextView textView = this.smallLabel;
                    float f = this.scaleUpFactor;
                    setViewScaleValues(textView, f, f, 4);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    android.widget.TextView textView2 = this.largeLabel;
                    float f2 = this.scaleDownFactor;
                    setViewScaleValues(textView2, f2, f2, 4);
                    setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
                }
            } else if (i == 2) {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                this.largeLabel.setVisibility(8);
                this.smallLabel.setVisibility(8);
            }
        } else if (this.isShifting) {
            if (z) {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                android.view.ViewGroup viewGroup3 = this.labelGroup;
                updateViewPaddingBottom(viewGroup3, ((java.lang.Integer) viewGroup3.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
                this.largeLabel.setVisibility(0);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(4);
            }
            this.smallLabel.setVisibility(4);
        } else {
            android.view.ViewGroup viewGroup4 = this.labelGroup;
            updateViewPaddingBottom(viewGroup4, ((java.lang.Integer) viewGroup4.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z) {
                setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                android.widget.TextView textView3 = this.smallLabel;
                float f3 = this.scaleUpFactor;
                setViewScaleValues(textView3, f3, f3, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                android.widget.TextView textView4 = this.largeLabel;
                float f4 = this.scaleDownFactor;
                setViewScaleValues(textView4, f4, f4, 4);
                setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.icon.setEnabled(z);
        if (z) {
            androidx.core.view.ViewCompat.setPointerIcon(this, androidx.core.view.PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            androidx.core.view.ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            android.content.res.ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData == null || (drawable = this.wrappedIconDrawable) == null) {
            return;
        }
        androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, colorStateList);
        this.wrappedIconDrawable.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : androidx.core.content.ContextCompat.getDrawable(getContext(), i));
    }

    public void setItemBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        androidx.core.view.ViewCompat.setBackground(this, drawable);
    }

    public void setItemPosition(int i) {
        this.itemPosition = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.labelVisibilityMode != i) {
            this.labelVisibilityMode = i;
            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.isShifting != z) {
            this.isShifting = z;
            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = this.itemData;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearanceActive(@androidx.annotation.StyleRes int i) {
        androidx.core.widget.TextViewCompat.setTextAppearance(this.largeLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(@androidx.annotation.StyleRes int i) {
        androidx.core.widget.TextViewCompat.setTextAppearance(this.smallLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = this.itemData;
        if (menuItemImpl == null || android.text.TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        androidx.appcompat.view.menu.MenuItemImpl menuItemImpl2 = this.itemData;
        if (menuItemImpl2 != null && !android.text.TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        if (android.os.Build.VERSION.SDK_INT > 23) {
            androidx.appcompat.widget.TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}
