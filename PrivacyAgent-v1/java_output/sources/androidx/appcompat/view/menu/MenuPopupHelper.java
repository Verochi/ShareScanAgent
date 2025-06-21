package androidx.appcompat.view.menu;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuPopupHelper implements androidx.appcompat.view.menu.MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private android.view.View mAnchorView;
    private final android.content.Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final android.widget.PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final androidx.appcompat.view.menu.MenuBuilder mMenu;
    private android.widget.PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private androidx.appcompat.view.menu.MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private androidx.appcompat.view.menu.MenuPresenter.Callback mPresenterCallback;

    /* renamed from: androidx.appcompat.view.menu.MenuPopupHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.PopupWindow.OnDismissListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            androidx.appcompat.view.menu.MenuPopupHelper.this.onDismiss();
        }
    }

    public MenuPopupHelper(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, androidx.appcompat.R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.View view) {
        this(context, menuBuilder, view, false, androidx.appcompat.R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.View view, boolean z, @androidx.annotation.AttrRes int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.View view, boolean z, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        this.mDropDownGravity = androidx.core.view.GravityCompat.START;
        this.mInternalOnDismissListener = new androidx.appcompat.view.menu.MenuPopupHelper.AnonymousClass1();
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
    }

    @androidx.annotation.NonNull
    private androidx.appcompat.view.menu.MenuPopup createPopup() {
        android.view.Display defaultDisplay = ((android.view.WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        defaultDisplay.getRealSize(point);
        androidx.appcompat.view.menu.MenuPopup cascadingMenuPopup = java.lang.Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(androidx.appcompat.R.dimen.abc_cascading_menus_min_smallest_width) ? new androidx.appcompat.view.menu.CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly) : new androidx.appcompat.view.menu.StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        cascadingMenuPopup.addMenu(this.mMenu);
        cascadingMenuPopup.setOnDismissListener(this.mInternalOnDismissListener);
        cascadingMenuPopup.setAnchorView(this.mAnchorView);
        cascadingMenuPopup.setCallback(this.mPresenterCallback);
        cascadingMenuPopup.setForceShowIcon(this.mForceShowIcon);
        cascadingMenuPopup.setGravity(this.mDropDownGravity);
        return cascadingMenuPopup;
    }

    private void showPopup(int i, int i2, boolean z, boolean z2) {
        androidx.appcompat.view.menu.MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((androidx.core.view.GravityCompat.getAbsoluteGravity(this.mDropDownGravity, androidx.core.view.ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                i -= this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(i);
            popup.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new android.graphics.Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        popup.show();
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public android.widget.ListView getListView() {
        return getPopup().getListView();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public androidx.appcompat.view.menu.MenuPopup getPopup() {
        if (this.mPopup == null) {
            this.mPopup = createPopup();
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        androidx.appcompat.view.menu.MenuPopup menuPopup = this.mPopup;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void onDismiss() {
        this.mPopup = null;
        android.widget.PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(@androidx.annotation.NonNull android.view.View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        androidx.appcompat.view.menu.MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setOnDismissListener(@androidx.annotation.Nullable android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(@androidx.annotation.Nullable androidx.appcompat.view.menu.MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
        androidx.appcompat.view.menu.MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new java.lang.IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new java.lang.IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(i, i2, true, true);
        return true;
    }
}
