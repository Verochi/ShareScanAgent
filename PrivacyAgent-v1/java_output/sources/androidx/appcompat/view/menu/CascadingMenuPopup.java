package androidx.appcompat.view.menu;

/* loaded from: classes.dex */
final class CascadingMenuPopup extends androidx.appcompat.view.menu.MenuPopup implements android.view.View.OnKeyListener, android.widget.PopupWindow.OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = androidx.appcompat.R.layout.abc_cascading_menu_item_layout;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private android.view.View mAnchorView;
    private final android.content.Context mContext;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private final int mMenuMaxWidth;
    private android.widget.PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private androidx.appcompat.view.menu.MenuPresenter.Callback mPresenterCallback;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    android.view.View mShownAnchorView;
    final android.os.Handler mSubMenuHoverHandler;
    android.view.ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;
    private final java.util.List<androidx.appcompat.view.menu.MenuBuilder> mPendingMenus = new java.util.ArrayList();
    final java.util.List<androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo> mShowingMenus = new java.util.ArrayList();
    final android.view.ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass1();
    private final android.view.View.OnAttachStateChangeListener mAttachStateChangeListener = new androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass2();
    private final androidx.appcompat.widget.MenuItemHoverListener mMenuItemHoverListener = new androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass3();
    private int mRawDropDownGravity = 0;
    private int mDropDownGravity = 0;
    private boolean mForceShowIcon = false;
    private int mLastPosition = getInitialMenuPosition();

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!androidx.appcompat.view.menu.CascadingMenuPopup.this.isShowing() || androidx.appcompat.view.menu.CascadingMenuPopup.this.mShowingMenus.size() <= 0 || androidx.appcompat.view.menu.CascadingMenuPopup.this.mShowingMenus.get(0).window.isModal()) {
                return;
            }
            android.view.View view = androidx.appcompat.view.menu.CascadingMenuPopup.this.mShownAnchorView;
            if (view == null || !view.isShown()) {
                androidx.appcompat.view.menu.CascadingMenuPopup.this.dismiss();
                return;
            }
            java.util.Iterator<androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo> it = androidx.appcompat.view.menu.CascadingMenuPopup.this.mShowingMenus.iterator();
            while (it.hasNext()) {
                it.next().window.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnAttachStateChangeListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            android.view.ViewTreeObserver viewTreeObserver = androidx.appcompat.view.menu.CascadingMenuPopup.this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    androidx.appcompat.view.menu.CascadingMenuPopup.this.mTreeObserver = view.getViewTreeObserver();
                }
                androidx.appcompat.view.menu.CascadingMenuPopup cascadingMenuPopup = androidx.appcompat.view.menu.CascadingMenuPopup.this;
                cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$3, reason: invalid class name */
    public class AnonymousClass3 implements androidx.appcompat.widget.MenuItemHoverListener {

        /* renamed from: androidx.appcompat.view.menu.CascadingMenuPopup$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.view.MenuItem val$item;
            final /* synthetic */ androidx.appcompat.view.menu.MenuBuilder val$menu;
            final /* synthetic */ androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo val$nextInfo;

            public AnonymousClass1(androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo, android.view.MenuItem menuItem, androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
                this.val$nextInfo = cascadingMenuInfo;
                this.val$item = menuItem;
                this.val$menu = menuBuilder;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo = this.val$nextInfo;
                if (cascadingMenuInfo != null) {
                    androidx.appcompat.view.menu.CascadingMenuPopup.this.mShouldCloseImmediately = true;
                    cascadingMenuInfo.menu.close(false);
                    androidx.appcompat.view.menu.CascadingMenuPopup.this.mShouldCloseImmediately = false;
                }
                if (this.val$item.isEnabled() && this.val$item.hasSubMenu()) {
                    this.val$menu.performItemAction(this.val$item, 4);
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.MenuItem menuItem) {
            androidx.appcompat.view.menu.CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
            int size = androidx.appcompat.view.menu.CascadingMenuPopup.this.mShowingMenus.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == androidx.appcompat.view.menu.CascadingMenuPopup.this.mShowingMenus.get(i).menu) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            androidx.appcompat.view.menu.CascadingMenuPopup.this.mSubMenuHoverHandler.postAtTime(new androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass3.AnonymousClass1(i2 < androidx.appcompat.view.menu.CascadingMenuPopup.this.mShowingMenus.size() ? androidx.appcompat.view.menu.CascadingMenuPopup.this.mShowingMenus.get(i2) : null, menuItem, menuBuilder), menuBuilder, android.os.SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.MenuItem menuItem) {
            androidx.appcompat.view.menu.CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
        }
    }

    public static class CascadingMenuInfo {
        public final androidx.appcompat.view.menu.MenuBuilder menu;
        public final int position;
        public final androidx.appcompat.widget.MenuPopupWindow window;

        public CascadingMenuInfo(@androidx.annotation.NonNull androidx.appcompat.widget.MenuPopupWindow menuPopupWindow, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }

        public android.widget.ListView getListView() {
            return this.window.getListView();
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, boolean z) {
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        this.mOverflowOnly = z;
        android.content.res.Resources resources = context.getResources();
        this.mMenuMaxWidth = java.lang.Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new android.os.Handler();
    }

    private androidx.appcompat.widget.MenuPopupWindow createPopupWindow() {
        androidx.appcompat.widget.MenuPopupWindow menuPopupWindow = new androidx.appcompat.widget.MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuPopupWindow.setHoverListener(this.mMenuItemHoverListener);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setAnchorView(this.mAnchorView);
        menuPopupWindow.setDropDownGravity(this.mDropDownGravity);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private int findIndexOfAddedMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        int size = this.mShowingMenus.size();
        for (int i = 0; i < size; i++) {
            if (menuBuilder == this.mShowingMenus.get(i).menu) {
                return i;
            }
        }
        return -1;
    }

    private android.view.MenuItem findMenuItemForSubmenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder2) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            android.view.MenuItem item = menuBuilder.getItem(i);
            if (item.hasSubMenu() && menuBuilder2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    private android.view.View findParentViewForSubmenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        androidx.appcompat.view.menu.MenuAdapter menuAdapter;
        int i;
        int firstVisiblePosition;
        android.view.MenuItem findMenuItemForSubmenu = findMenuItemForSubmenu(cascadingMenuInfo.menu, menuBuilder);
        if (findMenuItemForSubmenu == null) {
            return null;
        }
        android.widget.ListView listView = cascadingMenuInfo.getListView();
        android.widget.ListAdapter adapter = listView.getAdapter();
        int i2 = 0;
        if (adapter instanceof android.widget.HeaderViewListAdapter) {
            android.widget.HeaderViewListAdapter headerViewListAdapter = (android.widget.HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            menuAdapter = (androidx.appcompat.view.menu.MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            menuAdapter = (androidx.appcompat.view.menu.MenuAdapter) adapter;
            i = 0;
        }
        int count = menuAdapter.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (findMenuItemForSubmenu == menuAdapter.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - listView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listView.getChildCount()) {
            return listView.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int getInitialMenuPosition() {
        return androidx.core.view.ViewCompat.getLayoutDirection(this.mAnchorView) == 1 ? 0 : 1;
    }

    private int getNextMenuPosition(int i) {
        java.util.List<androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo> list = this.mShowingMenus;
        android.widget.ListView listView = list.get(list.size() - 1).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
        return this.mLastPosition == 1 ? (iArr[0] + listView.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private void showMenu(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo;
        android.view.View view;
        int i;
        int i2;
        int i3;
        android.view.LayoutInflater from = android.view.LayoutInflater.from(this.mContext);
        androidx.appcompat.view.menu.MenuAdapter menuAdapter = new androidx.appcompat.view.menu.MenuAdapter(menuBuilder, from, this.mOverflowOnly, ITEM_LAYOUT);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter.setForceShowIcon(true);
        } else if (isShowing()) {
            menuAdapter.setForceShowIcon(androidx.appcompat.view.menu.MenuPopup.shouldPreserveIconSpacing(menuBuilder));
        }
        int measureIndividualMenuWidth = androidx.appcompat.view.menu.MenuPopup.measureIndividualMenuWidth(menuAdapter, null, this.mContext, this.mMenuMaxWidth);
        androidx.appcompat.widget.MenuPopupWindow createPopupWindow = createPopupWindow();
        createPopupWindow.setAdapter(menuAdapter);
        createPopupWindow.setContentWidth(measureIndividualMenuWidth);
        createPopupWindow.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() > 0) {
            java.util.List<androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo> list = this.mShowingMenus;
            cascadingMenuInfo = list.get(list.size() - 1);
            view = findParentViewForSubmenu(cascadingMenuInfo, menuBuilder);
        } else {
            cascadingMenuInfo = null;
            view = null;
        }
        if (view != null) {
            createPopupWindow.setTouchModal(false);
            createPopupWindow.setEnterTransition(null);
            int nextMenuPosition = getNextMenuPosition(measureIndividualMenuWidth);
            boolean z = nextMenuPosition == 1;
            this.mLastPosition = nextMenuPosition;
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                createPopupWindow.setAnchorView(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.mAnchorView.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.mDropDownGravity & 7) == 5) {
                    iArr[0] = iArr[0] + this.mAnchorView.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.mDropDownGravity & 5) == 5) {
                if (!z) {
                    measureIndividualMenuWidth = view.getWidth();
                    i3 = i - measureIndividualMenuWidth;
                }
                i3 = i + measureIndividualMenuWidth;
            } else {
                if (z) {
                    measureIndividualMenuWidth = view.getWidth();
                    i3 = i + measureIndividualMenuWidth;
                }
                i3 = i - measureIndividualMenuWidth;
            }
            createPopupWindow.setHorizontalOffset(i3);
            createPopupWindow.setOverlapAnchor(true);
            createPopupWindow.setVerticalOffset(i2);
        } else {
            if (this.mHasXOffset) {
                createPopupWindow.setHorizontalOffset(this.mXOffset);
            }
            if (this.mHasYOffset) {
                createPopupWindow.setVerticalOffset(this.mYOffset);
            }
            createPopupWindow.setEpicenterBounds(getEpicenterBounds());
        }
        this.mShowingMenus.add(new androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo(createPopupWindow, menuBuilder, this.mLastPosition));
        createPopupWindow.show();
        android.widget.ListView listView = createPopupWindow.getListView();
        listView.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.getHeaderTitle() != null) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) from.inflate(androidx.appcompat.R.layout.abc_popup_menu_header_item_layout, (android.view.ViewGroup) listView, false);
            android.widget.TextView textView = (android.widget.TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuBuilder.getHeaderTitle());
            listView.addHeaderView(frameLayout, null, false);
            createPopupWindow.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.mShowingMenus.size();
        if (size > 0) {
            androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo[] cascadingMenuInfoArr = (androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo[]) this.mShowingMenus.toArray(new androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public android.widget.ListView getListView() {
        if (this.mShowingMenus.isEmpty()) {
            return null;
        }
        return this.mShowingMenus.get(r0.size() - 1).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mShowingMenus.size() > 0 && this.mShowingMenus.get(0).window.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(androidx.appcompat.view.menu.MenuBuilder menuBuilder, boolean z) {
        int findIndexOfAddedMenu = findIndexOfAddedMenu(menuBuilder);
        if (findIndexOfAddedMenu < 0) {
            return;
        }
        int i = findIndexOfAddedMenu + 1;
        if (i < this.mShowingMenus.size()) {
            this.mShowingMenus.get(i).menu.close(false);
        }
        androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo remove = this.mShowingMenus.remove(findIndexOfAddedMenu);
        remove.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately) {
            remove.window.setExitTransition(null);
            remove.window.setAnimationStyle(0);
        }
        remove.window.dismiss();
        int size = this.mShowingMenus.size();
        if (size > 0) {
            this.mLastPosition = this.mShowingMenus.get(size - 1).position;
        } else {
            this.mLastPosition = getInitialMenuPosition();
        }
        if (size != 0) {
            if (z) {
                this.mShowingMenus.get(0).menu.close(false);
                return;
            }
            return;
        }
        dismiss();
        androidx.appcompat.view.menu.MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, true);
        }
        android.view.ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            }
            this.mTreeObserver = null;
        }
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo;
        int size = this.mShowingMenus.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.mShowingMenus.get(i);
            if (!cascadingMenuInfo.window.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(android.view.View view, int i, android.view.KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public android.os.Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder subMenuBuilder) {
        for (androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.getListView().requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        androidx.appcompat.view.menu.MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(@androidx.annotation.NonNull android.view.View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = androidx.core.view.GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, androidx.core.view.ViewCompat.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(androidx.appcompat.view.menu.MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int i) {
        if (this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = androidx.core.view.GravityCompat.getAbsoluteGravity(i, androidx.core.view.ViewCompat.getLayoutDirection(this.mAnchorView));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int i) {
        this.mHasXOffset = true;
        this.mXOffset = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int i) {
        this.mHasYOffset = true;
        this.mYOffset = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing()) {
            return;
        }
        java.util.Iterator<androidx.appcompat.view.menu.MenuBuilder> it = this.mPendingMenus.iterator();
        while (it.hasNext()) {
            showMenu(it.next());
        }
        this.mPendingMenus.clear();
        android.view.View view = this.mAnchorView;
        this.mShownAnchorView = view;
        if (view != null) {
            boolean z = this.mTreeObserver == null;
            android.view.ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.mTreeObserver = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            }
            this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        java.util.Iterator<androidx.appcompat.view.menu.CascadingMenuPopup.CascadingMenuInfo> it = this.mShowingMenus.iterator();
        while (it.hasNext()) {
            androidx.appcompat.view.menu.MenuPopup.toMenuAdapter(it.next().getListView().getAdapter()).notifyDataSetChanged();
        }
    }
}
