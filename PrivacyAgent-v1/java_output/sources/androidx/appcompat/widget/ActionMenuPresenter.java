package androidx.appcompat.widget;

/* loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.BaseMenuPresenter implements androidx.core.view.ActionProvider.SubUiVisibilityListener {
    private static final java.lang.String TAG = "ActionMenuPresenter";
    private final android.util.SparseBooleanArray mActionButtonGroups;
    androidx.appcompat.widget.ActionMenuPresenter.ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton mOverflowButton;
    androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup mOverflowPopup;
    private android.graphics.drawable.Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private androidx.appcompat.widget.ActionMenuPresenter.ActionMenuPopupCallback mPopupCallback;
    final androidx.appcompat.widget.ActionMenuPresenter.PopupPresenterCallback mPopupPresenterCallback;
    androidx.appcompat.widget.ActionMenuPresenter.OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public class ActionButtonSubmenu extends androidx.appcompat.view.menu.MenuPopupHelper {
        public ActionButtonSubmenu(android.content.Context context, androidx.appcompat.view.menu.SubMenuBuilder subMenuBuilder, android.view.View view) {
            super(context, subMenuBuilder, view, false, androidx.appcompat.R.attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                android.view.View view2 = androidx.appcompat.widget.ActionMenuPresenter.this.mOverflowButton;
                setAnchorView(view2 == null ? (android.view.View) ((androidx.appcompat.view.menu.BaseMenuPresenter) androidx.appcompat.widget.ActionMenuPresenter.this).mMenuView : view2);
            }
            setPresenterCallback(androidx.appcompat.widget.ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            androidx.appcompat.widget.ActionMenuPresenter actionMenuPresenter = androidx.appcompat.widget.ActionMenuPresenter.this;
            actionMenuPresenter.mActionButtonPopup = null;
            actionMenuPresenter.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    public class ActionMenuPopupCallback extends androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback {
        public ActionMenuPopupCallback() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public androidx.appcompat.view.menu.ShowableListMenu getPopup() {
            androidx.appcompat.widget.ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = androidx.appcompat.widget.ActionMenuPresenter.this.mActionButtonPopup;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.getPopup();
            }
            return null;
        }
    }

    public class OpenOverflowRunnable implements java.lang.Runnable {
        private androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup mPopup;

        public OpenOverflowRunnable(androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.BaseMenuPresenter) androidx.appcompat.widget.ActionMenuPresenter.this).mMenu != null) {
                ((androidx.appcompat.view.menu.BaseMenuPresenter) androidx.appcompat.widget.ActionMenuPresenter.this).mMenu.changeMenuMode();
            }
            android.view.View view = (android.view.View) ((androidx.appcompat.view.menu.BaseMenuPresenter) androidx.appcompat.widget.ActionMenuPresenter.this).mMenuView;
            if (view != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
                androidx.appcompat.widget.ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            androidx.appcompat.widget.ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    public class OverflowMenuButton extends androidx.appcompat.widget.AppCompatImageView implements androidx.appcompat.widget.ActionMenuView.ActionMenuChildView {

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.appcompat.widget.ForwardingListener {
            final /* synthetic */ androidx.appcompat.widget.ActionMenuPresenter val$this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(android.view.View view, androidx.appcompat.widget.ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.val$this$0 = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public androidx.appcompat.view.menu.ShowableListMenu getPopup() {
                androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup overflowPopup = androidx.appcompat.widget.ActionMenuPresenter.this.mOverflowPopup;
                if (overflowPopup == null) {
                    return null;
                }
                return overflowPopup.getPopup();
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean onForwardingStarted() {
                androidx.appcompat.widget.ActionMenuPresenter.this.showOverflowMenu();
                return true;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean onForwardingStopped() {
                androidx.appcompat.widget.ActionMenuPresenter actionMenuPresenter = androidx.appcompat.widget.ActionMenuPresenter.this;
                if (actionMenuPresenter.mPostedOpenRunnable != null) {
                    return false;
                }
                actionMenuPresenter.hideOverflowMenu();
                return true;
            }
        }

        public OverflowMenuButton(android.content.Context context) {
            super(context, null, androidx.appcompat.R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            androidx.appcompat.widget.TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.AnonymousClass1(this, androidx.appcompat.widget.ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public boolean performClick() {
            if (super.performClick()) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(this);
                return true;
            }
            playSoundEffect(0);
            androidx.appcompat.widget.ActionMenuPresenter.this.showOverflowMenu();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(this);
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            android.graphics.drawable.Drawable drawable = getDrawable();
            android.graphics.drawable.Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = java.lang.Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.DrawableCompat.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class OverflowPopup extends androidx.appcompat.view.menu.MenuPopupHelper {
        public OverflowPopup(android.content.Context context, androidx.appcompat.view.menu.MenuBuilder menuBuilder, android.view.View view, boolean z) {
            super(context, menuBuilder, view, z, androidx.appcompat.R.attr.actionOverflowMenuStyle);
            setGravity(androidx.core.view.GravityCompat.END);
            setPresenterCallback(androidx.appcompat.widget.ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (((androidx.appcompat.view.menu.BaseMenuPresenter) androidx.appcompat.widget.ActionMenuPresenter.this).mMenu != null) {
                ((androidx.appcompat.view.menu.BaseMenuPresenter) androidx.appcompat.widget.ActionMenuPresenter.this).mMenu.close();
            }
            androidx.appcompat.widget.ActionMenuPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    public class PopupPresenterCallback implements androidx.appcompat.view.menu.MenuPresenter.Callback {
        public PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof androidx.appcompat.view.menu.SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            androidx.appcompat.view.menu.MenuPresenter.Callback callback = androidx.appcompat.widget.ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
            if (menuBuilder == ((androidx.appcompat.view.menu.BaseMenuPresenter) androidx.appcompat.widget.ActionMenuPresenter.this).mMenu) {
                return false;
            }
            androidx.appcompat.widget.ActionMenuPresenter.this.mOpenSubMenuId = ((androidx.appcompat.view.menu.SubMenuBuilder) menuBuilder).getItem().getItemId();
            androidx.appcompat.view.menu.MenuPresenter.Callback callback = androidx.appcompat.widget.ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    @android.annotation.SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<androidx.appcompat.widget.ActionMenuPresenter.SavedState> CREATOR = new androidx.appcompat.widget.ActionMenuPresenter.SavedState.AnonymousClass1();
        public int openSubMenuId;

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.appcompat.widget.ActionMenuPresenter.SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.appcompat.widget.ActionMenuPresenter.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.appcompat.widget.ActionMenuPresenter.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.appcompat.widget.ActionMenuPresenter.SavedState[] newArray(int i) {
                return new androidx.appcompat.widget.ActionMenuPresenter.SavedState[i];
            }
        }

        public SavedState() {
        }

        public SavedState(android.os.Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(android.content.Context context) {
        super(context, androidx.appcompat.R.layout.abc_action_menu_layout, androidx.appcompat.R.layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new android.util.SparseBooleanArray();
        this.mPopupPresenterCallback = new androidx.appcompat.widget.ActionMenuPresenter.PopupPresenterCallback();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private android.view.View findViewForItem(android.view.MenuItem menuItem) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof androidx.appcompat.view.menu.MenuView.ItemView) && ((androidx.appcompat.view.menu.MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(androidx.appcompat.view.menu.MenuItemImpl menuItemImpl, androidx.appcompat.view.menu.MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        androidx.appcompat.view.menu.ActionMenuItemView actionMenuItemView = (androidx.appcompat.view.menu.ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((androidx.appcompat.widget.ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new androidx.appcompat.widget.ActionMenuPresenter.ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(android.view.ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        java.util.ArrayList<androidx.appcompat.view.menu.MenuItemImpl> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        androidx.appcompat.widget.ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
        android.view.View view = null;
        int i5 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = actionMenuPresenter.mMaxItems;
        int i7 = actionMenuPresenter.mActionItemWidthLimit;
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) actionMenuPresenter.mMenuView;
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl = arrayList.get(i10);
            if (menuItemImpl.requiresActionButton()) {
                i8++;
            } else if (menuItemImpl.requestsActionButton()) {
                i9++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (actionMenuPresenter.mReserveOverflow && (z || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        android.util.SparseBooleanArray sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.mStrictWidthLimit) {
            int i12 = actionMenuPresenter.mMinCellSize;
            i3 = i7 / i12;
            i2 = i12 + ((i7 % i12) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            androidx.appcompat.view.menu.MenuItemImpl menuItemImpl2 = arrayList.get(i13);
            if (menuItemImpl2.requiresActionButton()) {
                android.view.View itemView = actionMenuPresenter.getItemView(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.mStrictWidthLimit) {
                    i3 -= androidx.appcompat.widget.ActionMenuView.measureChildForCells(itemView, i2, i3, makeMeasureSpec, i5);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                i4 = i;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i11 > 0 || z2) && i7 > 0 && (!actionMenuPresenter.mStrictWidthLimit || i3 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    android.view.View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                    if (actionMenuPresenter.mStrictWidthLimit) {
                        int measureChildForCells = androidx.appcompat.widget.ActionMenuView.measureChildForCells(itemView2, i2, i3, makeMeasureSpec, 0);
                        i3 -= measureChildForCells;
                        if (measureChildForCells == 0) {
                            z4 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z5 & (!actionMenuPresenter.mStrictWidthLimit ? i7 + i14 <= 0 : i7 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        androidx.appcompat.view.menu.MenuItemImpl menuItemImpl3 = arrayList.get(i15);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i11++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z3) {
                    i11--;
                }
                menuItemImpl2.setIsActionButton(z3);
            } else {
                i4 = i;
                menuItemImpl2.setIsActionButton(false);
                i13++;
                view = null;
                actionMenuPresenter = this;
                i = i4;
                i5 = 0;
            }
            i13++;
            view = null;
            actionMenuPresenter = this;
            i = i4;
            i5 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public android.view.View getItemView(androidx.appcompat.view.menu.MenuItemImpl menuItemImpl, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        androidx.appcompat.widget.ActionMenuView actionMenuView = (androidx.appcompat.widget.ActionMenuView) viewGroup;
        android.view.ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public androidx.appcompat.view.menu.MenuView getMenuView(android.view.ViewGroup viewGroup) {
        androidx.appcompat.view.menu.MenuView menuView = this.mMenuView;
        androidx.appcompat.view.menu.MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((androidx.appcompat.widget.ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public android.graphics.drawable.Drawable getOverflowIcon() {
        androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        java.lang.Object obj;
        androidx.appcompat.widget.ActionMenuPresenter.OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable != null && (obj = this.mMenuView) != null) {
            ((android.view.View) obj).removeCallbacks(openOverflowRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup == null) {
            return false;
        }
        overflowPopup.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        androidx.appcompat.widget.ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        android.content.res.Resources resources = context.getResources();
        androidx.appcompat.view.ActionBarPolicy actionBarPolicy = androidx.appcompat.view.ActionBarPolicy.get(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = actionBarPolicy.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = actionBarPolicy.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = actionBarPolicy.getMaxActionButtons();
        }
        int i = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton overflowMenuButton = new androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                if (this.mPendingOverflowIconSet) {
                    overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup overflowPopup = this.mOverflowPopup;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(androidx.appcompat.view.menu.MenuBuilder menuBuilder, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(menuBuilder, z);
    }

    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = androidx.appcompat.view.ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        int i;
        android.view.MenuItem findItem;
        if ((parcelable instanceof androidx.appcompat.widget.ActionMenuPresenter.SavedState) && (i = ((androidx.appcompat.widget.ActionMenuPresenter.SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((androidx.appcompat.view.menu.SubMenuBuilder) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public android.os.Parcelable onSaveInstanceState() {
        androidx.appcompat.widget.ActionMenuPresenter.SavedState savedState = new androidx.appcompat.widget.ActionMenuPresenter.SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder subMenuBuilder) {
        boolean z = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (androidx.appcompat.view.menu.SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        android.view.View findViewForItem = findViewForItem(subMenuBuilder2.getItem());
        if (findViewForItem == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            android.view.MenuItem item = subMenuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        androidx.appcompat.widget.ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = new androidx.appcompat.widget.ActionMenuPresenter.ActionButtonSubmenu(this.mContext, subMenuBuilder, findViewForItem);
        this.mActionButtonPopup = actionButtonSubmenu;
        actionButtonSubmenu.setForceShowIcon(z);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(androidx.appcompat.widget.ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(android.graphics.drawable.Drawable drawable) {
        androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable;
        }
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i, androidx.appcompat.view.menu.MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        androidx.appcompat.view.menu.MenuBuilder menuBuilder;
        if (!this.mReserveOverflow || isOverflowMenuShowing() || (menuBuilder = this.mMenu) == null || this.mMenuView == null || this.mPostedOpenRunnable != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        androidx.appcompat.widget.ActionMenuPresenter.OpenOverflowRunnable openOverflowRunnable = new androidx.appcompat.widget.ActionMenuPresenter.OpenOverflowRunnable(new androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = openOverflowRunnable;
        ((android.view.View) this.mMenuView).post(openOverflowRunnable);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((android.view.View) this.mMenuView).requestLayout();
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = this.mMenu;
        boolean z2 = false;
        if (menuBuilder != null) {
            java.util.ArrayList<androidx.appcompat.view.menu.MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                androidx.core.view.ActionProvider supportActionProvider = actionItems.get(i).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        androidx.appcompat.view.menu.MenuBuilder menuBuilder2 = this.mMenu;
        java.util.ArrayList<androidx.appcompat.view.menu.MenuItemImpl> nonActionItems = menuBuilder2 != null ? menuBuilder2.getNonActionItems() : null;
        if (this.mReserveOverflow && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton(this.mSystemContext);
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                androidx.appcompat.widget.ActionMenuView actionMenuView = (androidx.appcompat.widget.ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton overflowMenuButton = this.mOverflowButton;
            if (overflowMenuButton != null) {
                java.lang.Object parent = overflowMenuButton.getParent();
                java.lang.Object obj = this.mMenuView;
                if (parent == obj) {
                    ((android.view.ViewGroup) obj).removeView(this.mOverflowButton);
                }
            }
        }
        ((androidx.appcompat.widget.ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
