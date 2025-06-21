package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class NavigationMenuPresenter implements androidx.appcompat.view.menu.MenuPresenter {
    private static final java.lang.String STATE_ADAPTER = "android:menu:adapter";
    private static final java.lang.String STATE_HEADER = "android:menu:header";
    private static final java.lang.String STATE_HIERARCHY = "android:menu:list";
    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter adapter;
    private androidx.appcompat.view.menu.MenuPresenter.Callback callback;
    boolean hasCustomItemIconSize;
    android.widget.LinearLayout headerLayout;
    android.content.res.ColorStateList iconTintList;
    private int id;
    android.graphics.drawable.Drawable itemBackground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    private int itemMaxLines;
    android.view.LayoutInflater layoutInflater;
    androidx.appcompat.view.menu.MenuBuilder menu;
    private com.google.android.material.internal.NavigationMenuView menuView;
    int paddingSeparator;
    private int paddingTopDefault;
    int textAppearance;
    boolean textAppearanceSet;
    android.content.res.ColorStateList textColor;
    boolean isBehindStatusBar = true;
    private int overScrollMode = -1;
    final android.view.View.OnClickListener onClickListener = new com.google.android.material.internal.NavigationMenuPresenter.AnonymousClass1();

    /* renamed from: com.google.android.material.internal.NavigationMenuPresenter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            boolean z = true;
            com.google.android.material.internal.NavigationMenuPresenter.this.setUpdateSuspended(true);
            androidx.appcompat.view.menu.MenuItemImpl itemData = ((com.google.android.material.internal.NavigationMenuItemView) view).getItemData();
            com.google.android.material.internal.NavigationMenuPresenter navigationMenuPresenter = com.google.android.material.internal.NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                com.google.android.material.internal.NavigationMenuPresenter.this.adapter.setCheckedItem(itemData);
            } else {
                z = false;
            }
            com.google.android.material.internal.NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z) {
                com.google.android.material.internal.NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    }

    public static class HeaderViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public HeaderViewHolder(android.view.View view) {
            super(view);
        }
    }

    public class NavigationMenuAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.google.android.material.internal.NavigationMenuPresenter.ViewHolder> {
        private static final java.lang.String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final java.lang.String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private androidx.appcompat.view.menu.MenuItemImpl checkedItem;
        private final java.util.ArrayList<com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem> items = new java.util.ArrayList<>();
        private boolean updateSuspended;

        public NavigationMenuAdapter() {
            prepareMenuItems();
        }

        private void appendTransparentIconIfMissing(int i, int i2) {
            while (i < i2) {
                ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) this.items.get(i)).needsEmptyIcon = true;
                i++;
            }
        }

        private void prepareMenuItems() {
            if (this.updateSuspended) {
                return;
            }
            this.updateSuspended = true;
            this.items.clear();
            this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuHeaderItem());
            int size = com.google.android.material.internal.NavigationMenuPresenter.this.menu.getVisibleItems().size();
            int i = -1;
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = com.google.android.material.internal.NavigationMenuPresenter.this.menu.getVisibleItems().get(i3);
                if (menuItemImpl.isChecked()) {
                    setCheckedItem(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    android.view.SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem(com.google.android.material.internal.NavigationMenuPresenter.this.paddingSeparator, 0));
                        }
                        this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl));
                        int size2 = this.items.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i4 = 0; i4 < size3; i4++) {
                            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl2 = (androidx.appcompat.view.menu.MenuItemImpl) subMenu.getItem(i4);
                            if (menuItemImpl2.isVisible()) {
                                if (!z2 && menuItemImpl2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    setCheckedItem(menuItemImpl);
                                }
                                this.items.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl2));
                            }
                        }
                        if (z2) {
                            appendTransparentIconIfMissing(size2, this.items.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i) {
                        i2 = this.items.size();
                        z = menuItemImpl.getIcon() != null;
                        if (i3 != 0) {
                            i2++;
                            java.util.ArrayList<com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem> arrayList = this.items;
                            int i5 = com.google.android.material.internal.NavigationMenuPresenter.this.paddingSeparator;
                            arrayList.add(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem(i5, i5));
                        }
                    } else if (!z && menuItemImpl.getIcon() != null) {
                        appendTransparentIconIfMissing(i2, this.items.size());
                        z = true;
                    }
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem navigationMenuTextItem = new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl);
                    navigationMenuTextItem.needsEmptyIcon = z;
                    this.items.add(navigationMenuTextItem);
                    i = groupId;
                }
            }
            this.updateSuspended = false;
        }

        @androidx.annotation.NonNull
        public android.os.Bundle createInstanceState() {
            android.os.Bundle bundle = new android.os.Bundle();
            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = this.checkedItem;
            if (menuItemImpl != null) {
                bundle.putInt(STATE_CHECKED_ITEM, menuItemImpl.getItemId());
            }
            android.util.SparseArray<? extends android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
            int size = this.items.size();
            for (int i = 0; i < size; i++) {
                com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.items.get(i);
                if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) {
                    androidx.appcompat.view.menu.MenuItemImpl menuItem = ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem).getMenuItem();
                    android.view.View actionView = menuItem != null ? menuItem.getActionView() : null;
                    if (actionView != null) {
                        com.google.android.material.internal.ParcelableSparseArray parcelableSparseArray = new com.google.android.material.internal.ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItem.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.items.get(i);
            if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) {
                return ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem).getMenuItem().hasSubMenu() ? 1 : 0;
            }
            throw new java.lang.RuntimeException("Unknown item type.");
        }

        public int getRowCount() {
            int i = com.google.android.material.internal.NavigationMenuPresenter.this.headerLayout.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < com.google.android.material.internal.NavigationMenuPresenter.this.adapter.getItemCount(); i2++) {
                if (com.google.android.material.internal.NavigationMenuPresenter.this.adapter.getItemViewType(i2) == 0) {
                    i++;
                }
            }
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@androidx.annotation.NonNull com.google.android.material.internal.NavigationMenuPresenter.ViewHolder viewHolder, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((android.widget.TextView) viewHolder.itemView).setText(((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) this.items.get(i)).getMenuItem().getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem navigationMenuSeparatorItem = (com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuSeparatorItem) this.items.get(i);
                    viewHolder.itemView.setPadding(0, navigationMenuSeparatorItem.getPaddingTop(), 0, navigationMenuSeparatorItem.getPaddingBottom());
                    return;
                }
            }
            com.google.android.material.internal.NavigationMenuItemView navigationMenuItemView = (com.google.android.material.internal.NavigationMenuItemView) viewHolder.itemView;
            navigationMenuItemView.setIconTintList(com.google.android.material.internal.NavigationMenuPresenter.this.iconTintList);
            com.google.android.material.internal.NavigationMenuPresenter navigationMenuPresenter = com.google.android.material.internal.NavigationMenuPresenter.this;
            if (navigationMenuPresenter.textAppearanceSet) {
                navigationMenuItemView.setTextAppearance(navigationMenuPresenter.textAppearance);
            }
            android.content.res.ColorStateList colorStateList = com.google.android.material.internal.NavigationMenuPresenter.this.textColor;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            android.graphics.drawable.Drawable drawable = com.google.android.material.internal.NavigationMenuPresenter.this.itemBackground;
            androidx.core.view.ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem navigationMenuTextItem = (com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) this.items.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
            navigationMenuItemView.setHorizontalPadding(com.google.android.material.internal.NavigationMenuPresenter.this.itemHorizontalPadding);
            navigationMenuItemView.setIconPadding(com.google.android.material.internal.NavigationMenuPresenter.this.itemIconPadding);
            com.google.android.material.internal.NavigationMenuPresenter navigationMenuPresenter2 = com.google.android.material.internal.NavigationMenuPresenter.this;
            if (navigationMenuPresenter2.hasCustomItemIconSize) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
            }
            navigationMenuItemView.setMaxLines(com.google.android.material.internal.NavigationMenuPresenter.this.itemMaxLines);
            navigationMenuItemView.initialize(navigationMenuTextItem.getMenuItem(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @androidx.annotation.Nullable
        public com.google.android.material.internal.NavigationMenuPresenter.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            if (i == 0) {
                com.google.android.material.internal.NavigationMenuPresenter navigationMenuPresenter = com.google.android.material.internal.NavigationMenuPresenter.this;
                return new com.google.android.material.internal.NavigationMenuPresenter.NormalViewHolder(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            }
            if (i == 1) {
                return new com.google.android.material.internal.NavigationMenuPresenter.SubheaderViewHolder(com.google.android.material.internal.NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i == 2) {
                return new com.google.android.material.internal.NavigationMenuPresenter.SeparatorViewHolder(com.google.android.material.internal.NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i != 3) {
                return null;
            }
            return new com.google.android.material.internal.NavigationMenuPresenter.HeaderViewHolder(com.google.android.material.internal.NavigationMenuPresenter.this.headerLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(com.google.android.material.internal.NavigationMenuPresenter.ViewHolder viewHolder) {
            if (viewHolder instanceof com.google.android.material.internal.NavigationMenuPresenter.NormalViewHolder) {
                ((com.google.android.material.internal.NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }

        public void restoreInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
            androidx.appcompat.view.menu.MenuItemImpl menuItem;
            android.view.View actionView;
            com.google.android.material.internal.ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.MenuItemImpl menuItem2;
            int i = bundle.getInt(STATE_CHECKED_ITEM, 0);
            if (i != 0) {
                this.updateSuspended = true;
                int size = this.items.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.items.get(i2);
                    if ((navigationMenuItem instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) && (menuItem2 = ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem).getMenuItem()) != null && menuItem2.getItemId() == i) {
                        setCheckedItem(menuItem2);
                        break;
                    }
                    i2++;
                }
                this.updateSuspended = false;
                prepareMenuItems();
            }
            android.util.SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (sparseParcelableArray != null) {
                int size2 = this.items.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem navigationMenuItem2 = this.items.get(i3);
                    if ((navigationMenuItem2 instanceof com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) && (menuItem = ((com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuTextItem) navigationMenuItem2).getMenuItem()) != null && (actionView = menuItem.getActionView()) != null && (parcelableSparseArray = (com.google.android.material.internal.ParcelableSparseArray) sparseParcelableArray.get(menuItem.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void setCheckedItem(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
            if (this.checkedItem == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl2 = this.checkedItem;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.checkedItem = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void setUpdateSuspended(boolean z) {
            this.updateSuspended = z;
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }
    }

    public static class NavigationMenuHeaderItem implements com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem {
    }

    public interface NavigationMenuItem {
    }

    public static class NavigationMenuSeparatorItem implements com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int i, int i2) {
            this.paddingTop = i;
            this.paddingBottom = i2;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }
    }

    public static class NavigationMenuTextItem implements com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuItem {
        private final androidx.appcompat.view.menu.MenuItemImpl menuItem;
        boolean needsEmptyIcon;

        public NavigationMenuTextItem(androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
            this.menuItem = menuItemImpl;
        }

        public androidx.appcompat.view.menu.MenuItemImpl getMenuItem() {
            return this.menuItem;
        }
    }

    public class NavigationMenuViewAccessibilityDelegate extends androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate {
        public NavigationMenuViewAccessibilityDelegate(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(com.google.android.material.internal.NavigationMenuPresenter.this.adapter.getRowCount(), 0, false));
        }
    }

    public static class NormalViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public NormalViewHolder(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.view.View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(com.google.android.material.R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    public static class SeparatorViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public SeparatorViewHolder(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup) {
            super(layoutInflater.inflate(com.google.android.material.R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    public static class SubheaderViewHolder extends com.google.android.material.internal.NavigationMenuPresenter.ViewHolder {
        public SubheaderViewHolder(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup) {
            super(layoutInflater.inflate(com.google.android.material.R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    public static abstract class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public ViewHolder(android.view.View view) {
            super(view);
        }
    }

    private void updateTopPadding() {
        int i = (this.headerLayout.getChildCount() == 0 && this.isBehindStatusBar) ? this.paddingTopDefault : 0;
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(@androidx.annotation.NonNull android.view.View view) {
        this.headerLayout.addView(view);
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(androidx.appcompat.view.menu.MenuBuilder menuBuilder, androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(@androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.paddingTopDefault != systemWindowInsetTop) {
            this.paddingTopDefault = systemWindowInsetTop;
            updateTopPadding();
        }
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        androidx.core.view.ViewCompat.dispatchApplyWindowInsets(this.headerLayout, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(androidx.appcompat.view.menu.MenuBuilder menuBuilder, androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @androidx.annotation.Nullable
    public androidx.appcompat.view.menu.MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public android.view.View getHeaderView(int i) {
        return this.headerLayout.getChildAt(i);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.id;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemTextColor() {
        return this.textColor;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public androidx.appcompat.view.menu.MenuView getMenuView(android.view.ViewGroup viewGroup) {
        if (this.menuView == null) {
            com.google.android.material.internal.NavigationMenuView navigationMenuView = (com.google.android.material.internal.NavigationMenuView) this.layoutInflater.inflate(com.google.android.material.R.layout.design_navigation_menu, viewGroup, false);
            this.menuView = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuViewAccessibilityDelegate(this.menuView));
            if (this.adapter == null) {
                this.adapter = new com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter();
            }
            int i = this.overScrollMode;
            if (i != -1) {
                this.menuView.setOverScrollMode(i);
            }
            this.headerLayout = (android.widget.LinearLayout) this.layoutInflater.inflate(com.google.android.material.R.layout.design_navigation_item_header, (android.view.ViewGroup) this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    public android.view.View inflateHeaderView(@androidx.annotation.LayoutRes int i) {
        android.view.View inflate = this.layoutInflater.inflate(i, (android.view.ViewGroup) this.headerLayout, false);
        addHeaderView(inflate);
        return inflate;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        this.layoutInflater = android.view.LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.design_navigation_separator_vertical_padding);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(androidx.appcompat.view.menu.MenuBuilder menuBuilder, boolean z) {
        androidx.appcompat.view.menu.MenuPresenter.Callback callback = this.callback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof android.os.Bundle) {
            android.os.Bundle bundle = (android.os.Bundle) parcelable;
            android.util.SparseArray<android.os.Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            android.os.Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                this.adapter.restoreInstanceState(bundle2);
            }
            android.util.SparseArray<android.os.Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @androidx.annotation.NonNull
    public android.os.Parcelable onSaveInstanceState() {
        android.os.Bundle bundle = new android.os.Bundle();
        if (this.menuView != null) {
            android.util.SparseArray<android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            bundle.putBundle(STATE_ADAPTER, navigationMenuAdapter.createInstanceState());
        }
        if (this.headerLayout != null) {
            android.util.SparseArray<android.os.Parcelable> sparseArray2 = new android.util.SparseArray<>();
            this.headerLayout.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(STATE_HEADER, sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(@androidx.annotation.NonNull android.view.View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() == 0) {
            com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z) {
        if (this.isBehindStatusBar != z) {
            this.isBehindStatusBar = z;
            updateTopPadding();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(androidx.appcompat.view.menu.MenuPresenter.Callback callback) {
        this.callback = callback;
    }

    public void setCheckedItem(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
        this.adapter.setCheckedItem(menuItemImpl);
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setItemBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.itemBackground = drawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i) {
        this.itemHorizontalPadding = i;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i) {
        this.itemIconPadding = i;
        updateMenuView(false);
    }

    public void setItemIconSize(@androidx.annotation.Dimension int i) {
        if (this.itemIconSize != i) {
            this.itemIconSize = i;
            this.hasCustomItemIconSize = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i) {
        this.itemMaxLines = i;
        updateMenuView(false);
    }

    public void setItemTextAppearance(@androidx.annotation.StyleRes int i) {
        this.textAppearance = i;
        this.textAppearanceSet = true;
        updateMenuView(false);
    }

    public void setItemTextColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i) {
        this.overScrollMode = i;
        com.google.android.material.internal.NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i);
        }
    }

    public void setUpdateSuspended(boolean z) {
        com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.setUpdateSuspended(z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.update();
        }
    }
}
