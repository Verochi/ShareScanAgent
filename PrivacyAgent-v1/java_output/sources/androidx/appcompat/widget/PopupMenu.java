package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class PopupMenu {
    private final android.view.View mAnchor;
    private final android.content.Context mContext;
    private android.view.View.OnTouchListener mDragListener;
    private final androidx.appcompat.view.menu.MenuBuilder mMenu;
    androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener mMenuItemClickListener;
    androidx.appcompat.widget.PopupMenu.OnDismissListener mOnDismissListener;
    final androidx.appcompat.view.menu.MenuPopupHelper mPopup;

    /* renamed from: androidx.appcompat.widget.PopupMenu$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.appcompat.view.menu.MenuBuilder.Callback {
        public AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder, @androidx.annotation.NonNull android.view.MenuItem menuItem) {
            androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener onMenuItemClickListener = androidx.appcompat.widget.PopupMenu.this.mMenuItemClickListener;
            if (onMenuItemClickListener != null) {
                return onMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(@androidx.annotation.NonNull androidx.appcompat.view.menu.MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$2, reason: invalid class name */
    public class AnonymousClass2 implements android.widget.PopupWindow.OnDismissListener {
        public AnonymousClass2() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            androidx.appcompat.widget.PopupMenu popupMenu = androidx.appcompat.widget.PopupMenu.this;
            androidx.appcompat.widget.PopupMenu.OnDismissListener onDismissListener = popupMenu.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(popupMenu);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.PopupMenu$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.appcompat.widget.ForwardingListener {
        public AnonymousClass3(android.view.View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public androidx.appcompat.view.menu.ShowableListMenu getPopup() {
            return androidx.appcompat.widget.PopupMenu.this.mPopup.getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStarted() {
            androidx.appcompat.widget.PopupMenu.this.show();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStopped() {
            androidx.appcompat.widget.PopupMenu.this.dismiss();
            return true;
        }
    }

    public interface OnDismissListener {
        void onDismiss(androidx.appcompat.widget.PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(android.view.MenuItem menuItem);
    }

    public PopupMenu(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.View view) {
        this(context, view, 0);
    }

    public PopupMenu(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.View view, int i) {
        this(context, view, i, androidx.appcompat.R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.View view, int i, @androidx.annotation.AttrRes int i2, @androidx.annotation.StyleRes int i3) {
        this.mContext = context;
        this.mAnchor = view;
        androidx.appcompat.view.menu.MenuBuilder menuBuilder = new androidx.appcompat.view.menu.MenuBuilder(context);
        this.mMenu = menuBuilder;
        menuBuilder.setCallback(new androidx.appcompat.widget.PopupMenu.AnonymousClass1());
        androidx.appcompat.view.menu.MenuPopupHelper menuPopupHelper = new androidx.appcompat.view.menu.MenuPopupHelper(context, menuBuilder, view, false, i2, i3);
        this.mPopup = menuPopupHelper;
        menuPopupHelper.setGravity(i);
        menuPopupHelper.setOnDismissListener(new androidx.appcompat.widget.PopupMenu.AnonymousClass2());
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    @androidx.annotation.NonNull
    public android.view.View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new androidx.appcompat.widget.PopupMenu.AnonymousClass3(this.mAnchor);
        }
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    @androidx.annotation.NonNull
    public android.view.Menu getMenu() {
        return this.mMenu;
    }

    @androidx.annotation.NonNull
    public android.view.MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.SupportMenuInflater(this.mContext);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.widget.ListView getMenuListView() {
        if (this.mPopup.isShowing()) {
            return this.mPopup.getListView();
        }
        return null;
    }

    public void inflate(@androidx.annotation.MenuRes int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void setGravity(int i) {
        this.mPopup.setGravity(i);
    }

    public void setOnDismissListener(@androidx.annotation.Nullable androidx.appcompat.widget.PopupMenu.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnMenuItemClickListener(@androidx.annotation.Nullable androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }
}
