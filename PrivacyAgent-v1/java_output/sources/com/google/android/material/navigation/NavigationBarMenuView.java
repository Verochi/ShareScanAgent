package com.google.android.material.navigation;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public abstract class NavigationBarMenuView extends android.view.ViewGroup implements androidx.appcompat.view.menu.MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    private static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;

    @androidx.annotation.NonNull
    private android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> badgeDrawables;

    @androidx.annotation.Nullable
    private com.google.android.material.navigation.NavigationBarItemView[] buttons;
    private android.graphics.drawable.Drawable itemBackground;
    private int itemBackgroundRes;

    @androidx.annotation.Dimension
    private int itemIconSize;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList itemIconTint;
    private final androidx.core.util.Pools.Pool<com.google.android.material.navigation.NavigationBarItemView> itemPool;

    @androidx.annotation.StyleRes
    private int itemTextAppearanceActive;

    @androidx.annotation.StyleRes
    private int itemTextAppearanceInactive;

    @androidx.annotation.Nullable
    private final android.content.res.ColorStateList itemTextColorDefault;
    private android.content.res.ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private androidx.appcompat.view.menu.MenuBuilder menu;

    @androidx.annotation.NonNull
    private final android.view.View.OnClickListener onClickListener;

    @androidx.annotation.NonNull
    private final android.util.SparseArray<android.view.View.OnTouchListener> onTouchListeners;
    private com.google.android.material.navigation.NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @androidx.annotation.NonNull
    private final androidx.transition.TransitionSet set;

    /* renamed from: com.google.android.material.navigation.NavigationBarMenuView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            androidx.appcompat.view.menu.MenuItemImpl itemData = ((com.google.android.material.navigation.NavigationBarItemView) view).getItemData();
            if (com.google.android.material.navigation.NavigationBarMenuView.this.menu.performItemAction(itemData, com.google.android.material.navigation.NavigationBarMenuView.this.presenter, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.itemPool = new androidx.core.util.Pools.SynchronizedPool(5);
        this.onTouchListeners = new android.util.SparseArray<>(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new android.util.SparseArray<>(5);
        this.itemTextColorDefault = createDefaultColorStateList(android.R.attr.textColorSecondary);
        androidx.transition.AutoTransition autoTransition = new androidx.transition.AutoTransition();
        this.set = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(ACTIVE_ANIMATION_DURATION_MS);
        autoTransition.setInterpolator((android.animation.TimeInterpolator) new androidx.interpolator.view.animation.FastOutSlowInInterpolator());
        autoTransition.addTransition(new com.google.android.material.internal.TextScale());
        this.onClickListener = new com.google.android.material.navigation.NavigationBarMenuView.AnonymousClass1();
        androidx.core.view.ViewCompat.setImportantForAccessibility(this, 1);
    }

    private com.google.android.material.navigation.NavigationBarItemView getNewItem() {
        com.google.android.material.navigation.NavigationBarItemView acquire = this.itemPool.acquire();
        return acquire == null ? createNavigationBarItemView(getContext()) : acquire;
    }

    private boolean isValidId(int i) {
        return i != -1;
    }

    private void removeUnusedBadges() {
        java.util.HashSet hashSet = new java.util.HashSet();
        for (int i = 0; i < this.menu.size(); i++) {
            hashSet.add(java.lang.Integer.valueOf(this.menu.getItem(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.badgeDrawables.size(); i2++) {
            int keyAt = this.badgeDrawables.keyAt(i2);
            if (!hashSet.contains(java.lang.Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(@androidx.annotation.NonNull com.google.android.material.navigation.NavigationBarItemView navigationBarItemView) {
        com.google.android.material.badge.BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (isValidId(id) && (badgeDrawable = this.badgeDrawables.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    private void validateMenuItemId(int i) {
        if (isValidId(i)) {
            return;
        }
        throw new java.lang.IllegalArgumentException(i + " is not a valid view id");
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void buildMenuView() {
        removeAllViews();
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.itemPool.release(navigationBarItemView);
                    navigationBarItemView.removeBadge();
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        removeUnusedBadges();
        this.buttons = new com.google.android.material.navigation.NavigationBarItemView[this.menu.size()];
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i = 0; i < this.menu.size(); i++) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(i).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            com.google.android.material.navigation.NavigationBarItemView newItem = getNewItem();
            this.buttons[i] = newItem;
            newItem.setIconTintList(this.itemIconTint);
            newItem.setIconSize(this.itemIconSize);
            newItem.setTextColor(this.itemTextColorDefault);
            newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
            newItem.setTextColor(this.itemTextColorFromUser);
            android.graphics.drawable.Drawable drawable = this.itemBackground;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.itemBackgroundRes);
            }
            newItem.setShifting(isShifting);
            newItem.setLabelVisibilityMode(this.labelVisibilityMode);
            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = (androidx.appcompat.view.menu.MenuItemImpl) this.menu.getItem(i);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.onTouchListeners.get(itemId));
            newItem.setOnClickListener(this.onClickListener);
            int i2 = this.selectedItemId;
            if (i2 != 0 && itemId == i2) {
                this.selectedItemPosition = i;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = java.lang.Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = min;
        this.menu.getItem(min).setChecked(true);
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList createDefaultColorStateList(int i) {
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
        return new android.content.res.ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, android.view.ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    @androidx.annotation.NonNull
    public abstract com.google.android.material.navigation.NavigationBarItemView createNavigationBarItemView(@androidx.annotation.NonNull android.content.Context context);

    @androidx.annotation.Nullable
    public com.google.android.material.navigation.NavigationBarItemView findItemView(int i) {
        validateMenuItemId(i);
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr == null) {
            return null;
        }
        for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
            if (navigationBarItemView.getId() == i) {
                return navigationBarItemView;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.badge.BadgeDrawable getBadge(int i) {
        return this.badgeDrawables.get(i);
    }

    public android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getItemBackground() {
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.itemBackground : navigationBarItemViewArr[0].getBackground();
    }

    @java.lang.Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @androidx.annotation.Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @androidx.annotation.StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @androidx.annotation.StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    @androidx.annotation.Nullable
    public androidx.appcompat.view.menu.MenuBuilder getMenu() {
        return this.menu;
    }

    public com.google.android.material.badge.BadgeDrawable getOrCreateBadge(int i) {
        validateMenuItemId(i);
        com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawables.get(i);
        if (badgeDrawable == null) {
            badgeDrawable = com.google.android.material.badge.BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i, badgeDrawable);
        }
        com.google.android.material.navigation.NavigationBarItemView findItemView = findItemView(i);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    public boolean isShifting(int i, int i2) {
        if (i == -1) {
            if (i2 > 3) {
                return true;
            }
        } else if (i == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    public void removeBadge(int i) {
        validateMenuItemId(i);
        com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawables.get(i);
        com.google.android.material.navigation.NavigationBarItemView findItemView = findItemView(i);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        if (badgeDrawable != null) {
            this.badgeDrawables.remove(i);
        }
    }

    public void setBadgeDrawables(android.util.SparseArray<com.google.android.material.badge.BadgeDrawable> sparseArray) {
        this.badgeDrawables = sparseArray;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(sparseArray.get(navigationBarItemView.getId()));
            }
        }
    }

    public void setIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.itemBackground = drawable;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.itemBackgroundRes = i;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i);
            }
        }
    }

    public void setItemIconSize(@androidx.annotation.Dimension int i) {
        this.itemIconSize = i;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i);
            }
        }
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i, @androidx.annotation.Nullable android.view.View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.onTouchListeners.remove(i);
        } else {
            this.onTouchListeners.put(i, onTouchListener);
        }
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(@androidx.annotation.StyleRes int i) {
        this.itemTextAppearanceActive = i;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i);
                android.content.res.ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@androidx.annotation.StyleRes int i) {
        this.itemTextAppearanceInactive = i;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i);
                android.content.res.ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        com.google.android.material.navigation.NavigationBarItemView[] navigationBarItemViewArr = this.buttons;
        if (navigationBarItemViewArr != null) {
            for (com.google.android.material.navigation.NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.labelVisibilityMode = i;
    }

    public void setPresenter(@androidx.annotation.NonNull com.google.android.material.navigation.NavigationBarPresenter navigationBarPresenter) {
        this.presenter = navigationBarPresenter;
    }

    public void tryRestoreSelectedItemId(int i) {
        int size = this.menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            android.view.MenuItem item = this.menu.getItem(i2);
            if (i == item.getItemId()) {
                this.selectedItemId = i;
                this.selectedItemPosition = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    public void updateMenuView() {
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = this.menu;
        if (menuBuilder == null || this.buttons == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.buttons.length) {
            buildMenuView();
            return;
        }
        int i = this.selectedItemId;
        for (int i2 = 0; i2 < size; i2++) {
            android.view.MenuItem item = this.menu.getItem(i2);
            if (item.isChecked()) {
                this.selectedItemId = item.getItemId();
                this.selectedItemPosition = i2;
            }
        }
        if (i != this.selectedItemId) {
            androidx.transition.TransitionManager.beginDelayedTransition(this, this.set);
        }
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[i3].setLabelVisibilityMode(this.labelVisibilityMode);
            this.buttons[i3].setShifting(isShifting);
            this.buttons[i3].initialize((androidx.appcompat.view.menu.MenuItemImpl) this.menu.getItem(i3), 0);
            this.presenter.setUpdateSuspended(false);
        }
    }
}
