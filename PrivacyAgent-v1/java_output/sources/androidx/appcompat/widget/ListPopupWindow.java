package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class ListPopupWindow implements androidx.appcompat.view.menu.ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final java.lang.String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static java.lang.reflect.Method sGetMaxAvailableHeightMethod;
    private static java.lang.reflect.Method sSetClipToWindowEnabledMethod;
    private static java.lang.reflect.Method sSetEpicenterBoundsMethod;
    private android.widget.ListAdapter mAdapter;
    private android.content.Context mContext;
    private boolean mDropDownAlwaysVisible;
    private android.view.View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    androidx.appcompat.widget.DropDownListView mDropDownList;
    private android.graphics.drawable.Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private android.graphics.Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final android.os.Handler mHandler;
    private final androidx.appcompat.widget.ListPopupWindow.ListSelectorHider mHideSelector;
    private android.widget.AdapterView.OnItemClickListener mItemClickListener;
    private android.widget.AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private android.database.DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    android.widget.PopupWindow mPopup;
    private int mPromptPosition;
    private android.view.View mPromptView;
    final androidx.appcompat.widget.ListPopupWindow.ResizePopupRunnable mResizePopupRunnable;
    private final androidx.appcompat.widget.ListPopupWindow.PopupScrollListener mScrollListener;
    private java.lang.Runnable mShowDropDownRunnable;
    private final android.graphics.Rect mTempRect;
    private final androidx.appcompat.widget.ListPopupWindow.PopupTouchInterceptor mTouchInterceptor;

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.appcompat.widget.ForwardingListener {
        public AnonymousClass1(android.view.View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public androidx.appcompat.widget.ListPopupWindow getPopup() {
            return androidx.appcompat.widget.ListPopupWindow.this;
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.view.View anchorView = androidx.appcompat.widget.ListPopupWindow.this.getAnchorView();
            if (anchorView == null || anchorView.getWindowToken() == null) {
                return;
            }
            androidx.appcompat.widget.ListPopupWindow.this.show();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$3, reason: invalid class name */
    public class AnonymousClass3 implements android.widget.AdapterView.OnItemSelectedListener {
        public AnonymousClass3() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            androidx.appcompat.widget.DropDownListView dropDownListView;
            if (i == -1 || (dropDownListView = androidx.appcompat.widget.ListPopupWindow.this.mDropDownList) == null) {
                return;
            }
            dropDownListView.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
        }
    }

    public class ListSelectorHider implements java.lang.Runnable {
        public ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.ListPopupWindow.this.clearListSelection();
        }
    }

    public class PopupDataSetObserver extends android.database.DataSetObserver {
        public PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (androidx.appcompat.widget.ListPopupWindow.this.isShowing()) {
                androidx.appcompat.widget.ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            androidx.appcompat.widget.ListPopupWindow.this.dismiss();
        }
    }

    public class PopupScrollListener implements android.widget.AbsListView.OnScrollListener {
        public PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
            if (i != 1 || androidx.appcompat.widget.ListPopupWindow.this.isInputMethodNotNeeded() || androidx.appcompat.widget.ListPopupWindow.this.mPopup.getContentView() == null) {
                return;
            }
            androidx.appcompat.widget.ListPopupWindow listPopupWindow = androidx.appcompat.widget.ListPopupWindow.this;
            listPopupWindow.mHandler.removeCallbacks(listPopupWindow.mResizePopupRunnable);
            androidx.appcompat.widget.ListPopupWindow.this.mResizePopupRunnable.run();
        }
    }

    public class PopupTouchInterceptor implements android.view.View.OnTouchListener {
        public PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            android.widget.PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = androidx.appcompat.widget.ListPopupWindow.this.mPopup) != null && popupWindow.isShowing() && x >= 0 && x < androidx.appcompat.widget.ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < androidx.appcompat.widget.ListPopupWindow.this.mPopup.getHeight()) {
                androidx.appcompat.widget.ListPopupWindow listPopupWindow = androidx.appcompat.widget.ListPopupWindow.this;
                listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            androidx.appcompat.widget.ListPopupWindow listPopupWindow2 = androidx.appcompat.widget.ListPopupWindow.this;
            listPopupWindow2.mHandler.removeCallbacks(listPopupWindow2.mResizePopupRunnable);
            return false;
        }
    }

    public class ResizePopupRunnable implements java.lang.Runnable {
        public ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.DropDownListView dropDownListView = androidx.appcompat.widget.ListPopupWindow.this.mDropDownList;
            if (dropDownListView == null || !androidx.core.view.ViewCompat.isAttachedToWindow(dropDownListView) || androidx.appcompat.widget.ListPopupWindow.this.mDropDownList.getCount() <= androidx.appcompat.widget.ListPopupWindow.this.mDropDownList.getChildCount()) {
                return;
            }
            int childCount = androidx.appcompat.widget.ListPopupWindow.this.mDropDownList.getChildCount();
            androidx.appcompat.widget.ListPopupWindow listPopupWindow = androidx.appcompat.widget.ListPopupWindow.this;
            if (childCount <= listPopupWindow.mListItemExpandMaximum) {
                listPopupWindow.mPopup.setInputMethodMode(2);
                androidx.appcompat.widget.ListPopupWindow.this.show();
            }
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = android.widget.PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", java.lang.Boolean.TYPE);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            try {
                sSetEpicenterBoundsMethod = android.widget.PopupWindow.class.getDeclaredMethod("setEpicenterBounds", android.graphics.Rect.class);
            } catch (java.lang.NoSuchMethodException unused2) {
            }
        }
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            try {
                sGetMaxAvailableHeightMethod = android.widget.PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", android.view.View.class, java.lang.Integer.TYPE, java.lang.Boolean.TYPE);
            } catch (java.lang.NoSuchMethodException unused3) {
            }
        }
    }

    public ListPopupWindow(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null, androidx.appcompat.R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new androidx.appcompat.widget.ListPopupWindow.ResizePopupRunnable();
        this.mTouchInterceptor = new androidx.appcompat.widget.ListPopupWindow.PopupTouchInterceptor();
        this.mScrollListener = new androidx.appcompat.widget.ListPopupWindow.PopupScrollListener();
        this.mHideSelector = new androidx.appcompat.widget.ListPopupWindow.ListSelectorHider();
        this.mTempRect = new android.graphics.Rect();
        this.mContext = context;
        this.mHandler = new android.os.Handler(context.getMainLooper());
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ListPopupWindow, i, i2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        androidx.appcompat.widget.AppCompatPopupWindow appCompatPopupWindow = new androidx.appcompat.widget.AppCompatPopupWindow(context, attributeSet, i, i2);
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    private int buildDropDown() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        if (this.mDropDownList == null) {
            android.content.Context context = this.mContext;
            this.mShowDropDownRunnable = new androidx.appcompat.widget.ListPopupWindow.AnonymousClass2();
            androidx.appcompat.widget.DropDownListView createDropDownListView = createDropDownListView(context, !this.mModal);
            this.mDropDownList = createDropDownListView;
            android.graphics.drawable.Drawable drawable = this.mDropDownListHighlight;
            if (drawable != null) {
                createDropDownListView.setSelector(drawable);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new androidx.appcompat.widget.ListPopupWindow.AnonymousClass3());
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener = this.mItemSelectedListener;
            if (onItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(onItemSelectedListener);
            }
            android.view.View view = this.mDropDownList;
            android.view.View view2 = this.mPromptView;
            if (view2 != null) {
                android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
                linearLayout.setOrientation(1);
                android.view.ViewGroup.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.mPromptPosition;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i4 != 1) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Invalid hint position ");
                    sb.append(this.mPromptPosition);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.mDropDownWidth;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(android.view.View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.mPopup.setContentView(view);
        } else {
            android.view.View view3 = this.mPromptView;
            if (view3 != null) {
                android.widget.LinearLayout.LayoutParams layoutParams3 = (android.widget.LinearLayout.LayoutParams) view3.getLayoutParams();
                i = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        android.graphics.drawable.Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            android.graphics.Rect rect = this.mTempRect;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -i6;
            }
        } else {
            this.mTempRect.setEmpty();
            i2 = 0;
        }
        int maxAvailableHeight = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, this.mPopup.getInputMethodMode() == 2);
        if (this.mDropDownAlwaysVisible || this.mDropDownHeight == -1) {
            return maxAvailableHeight + i2;
        }
        int i7 = this.mDropDownWidth;
        if (i7 == -2) {
            int i8 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            android.graphics.Rect rect2 = this.mTempRect;
            makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            android.graphics.Rect rect3 = this.mTempRect;
            makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int measureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i += i2 + this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom();
        }
        return measureHeightOfChildrenCompat + i;
    }

    private int getMaxAvailableHeight(android.view.View view, int i, boolean z) {
        int maxAvailableHeight;
        if (android.os.Build.VERSION.SDK_INT > 23) {
            maxAvailableHeight = this.mPopup.getMaxAvailableHeight(view, i, z);
            return maxAvailableHeight;
        }
        java.lang.reflect.Method method = sGetMaxAvailableHeightMethod;
        if (method != null) {
            try {
                return ((java.lang.Integer) method.invoke(this.mPopup, view, java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(z))).intValue();
            } catch (java.lang.Exception unused) {
            }
        }
        return this.mPopup.getMaxAvailableHeight(view, i);
    }

    private static boolean isConfirmKey(int i) {
        return i == 66 || i == 23;
    }

    private void removePromptView() {
        android.view.View view = this.mPromptView;
        if (view != null) {
            android.view.ViewParent parent = view.getParent();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    private void setPopupClipToScreenEnabled(boolean z) {
        if (android.os.Build.VERSION.SDK_INT > 28) {
            this.mPopup.setIsClippedToScreen(z);
            return;
        }
        java.lang.reflect.Method method = sSetClipToWindowEnabledMethod;
        if (method != null) {
            try {
                method.invoke(this.mPopup, java.lang.Boolean.valueOf(z));
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public void clearListSelection() {
        androidx.appcompat.widget.DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public android.view.View.OnTouchListener createDragToOpenListener(android.view.View view) {
        return new androidx.appcompat.widget.ListPopupWindow.AnonymousClass1(view);
    }

    @androidx.annotation.NonNull
    public androidx.appcompat.widget.DropDownListView createDropDownListView(android.content.Context context, boolean z) {
        return new androidx.appcompat.widget.DropDownListView(context, z);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    @androidx.annotation.Nullable
    public android.view.View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    @androidx.annotation.StyleRes
    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    @androidx.annotation.Nullable
    public android.graphics.Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) {
            return new android.graphics.Rect(this.mEpicenterBounds);
        }
        return null;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @androidx.annotation.Nullable
    public android.widget.ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    @androidx.annotation.Nullable
    public java.lang.Object getSelectedItem() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItem();
        }
        return null;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedItemPosition();
        }
        return -1;
    }

    @androidx.annotation.Nullable
    public android.view.View getSelectedView() {
        if (isShowing()) {
            return this.mDropDownList.getSelectedView();
        }
        return null;
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet) {
            return this.mDropDownVerticalOffset;
        }
        return 0;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.mModal;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int i, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        int i2;
        int i3;
        if (isShowing() && i != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i))) {
            int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
            boolean z = !this.mPopup.isAboveAnchor();
            android.widget.ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
                i3 = areAllItemsEnabled ? listAdapter.getCount() - 1 : this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
            } else {
                i2 = Integer.MAX_VALUE;
                i3 = Integer.MIN_VALUE;
            }
            if ((z && i == 19 && selectedItemPosition <= i2) || (!z && i == 20 && selectedItemPosition >= i3)) {
                clearListSelection();
                this.mPopup.setInputMethodMode(1);
                show();
                return true;
            }
            this.mDropDownList.setListSelectionHidden(false);
            if (this.mDropDownList.onKeyDown(i, keyEvent)) {
                this.mPopup.setInputMethodMode(2);
                this.mDropDownList.requestFocusFromTouch();
                show();
                if (i == 19 || i == 20 || i == 23 || i == 66) {
                    return true;
                }
            } else if (z && i == 20) {
                if (selectedItemPosition == i3) {
                    return true;
                }
            } else if (!z && i == 19 && selectedItemPosition == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        if (i != 4 || !isShowing()) {
            return false;
        }
        android.view.View view = this.mDropDownAnchorView;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            android.view.KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        }
        if (keyEvent.getAction() != 1) {
            return false;
        }
        android.view.KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
        if (keyDispatcherState2 != null) {
            keyDispatcherState2.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        dismiss();
        return true;
    }

    public boolean onKeyUp(int i, @androidx.annotation.NonNull android.view.KeyEvent keyEvent) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.mDropDownList.onKeyUp(i, keyEvent);
        if (onKeyUp && isConfirmKey(i)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener == null) {
            return true;
        }
        androidx.appcompat.widget.DropDownListView dropDownListView = this.mDropDownList;
        this.mItemClickListener.onItemClick(dropDownListView, dropDownListView.getChildAt(i - dropDownListView.getFirstVisiblePosition()), i, dropDownListView.getAdapter().getItemId(i));
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(@androidx.annotation.Nullable android.widget.ListAdapter listAdapter) {
        android.database.DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new androidx.appcompat.widget.ListPopupWindow.PopupDataSetObserver();
        } else {
            android.widget.ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        androidx.appcompat.widget.DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(@androidx.annotation.Nullable android.view.View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(@androidx.annotation.StyleRes int i) {
        this.mPopup.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        android.graphics.drawable.Drawable background = this.mPopup.getBackground();
        if (background == null) {
            setWidth(i);
            return;
        }
        background.getPadding(this.mTempRect);
        android.graphics.Rect rect = this.mTempRect;
        this.mDropDownWidth = rect.left + rect.right + i;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z) {
        this.mDropDownAlwaysVisible = z;
    }

    public void setDropDownGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setEpicenterBounds(@androidx.annotation.Nullable android.graphics.Rect rect) {
        this.mEpicenterBounds = rect != null ? new android.graphics.Rect(rect) : null;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z) {
        this.mForceIgnoreOutsideTouch = z;
    }

    public void setHeight(int i) {
        if (i < 0 && -2 != i && -1 != i) {
            throw new java.lang.IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.mDropDownHeight = i;
    }

    public void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public void setInputMethodMode(int i) {
        this.mPopup.setInputMethodMode(i);
    }

    public void setListItemExpandMax(int i) {
        this.mListItemExpandMaximum = i;
    }

    public void setListSelector(android.graphics.drawable.Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public void setModal(boolean z) {
        this.mModal = z;
        this.mPopup.setFocusable(z);
    }

    public void setOnDismissListener(@androidx.annotation.Nullable android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@androidx.annotation.Nullable android.widget.AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(@androidx.annotation.Nullable android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = z;
    }

    public void setPromptPosition(int i) {
        this.mPromptPosition = i;
    }

    public void setPromptView(@androidx.annotation.Nullable android.view.View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        androidx.appcompat.widget.DropDownListView dropDownListView = this.mDropDownList;
        if (!isShowing() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i, true);
        }
    }

    public void setSoftInputMode(int i) {
        this.mPopup.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int i) {
        this.mDropDownWidth = i;
    }

    public void setWindowLayoutType(int i) {
        this.mDropDownWindowLayoutType = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        androidx.core.widget.PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        if (this.mPopup.isShowing()) {
            if (androidx.core.view.ViewCompat.isAttachedToWindow(getAnchorView())) {
                int i = this.mDropDownWidth;
                if (i == -1) {
                    i = -1;
                } else if (i == -2) {
                    i = getAnchorView().getWidth();
                }
                int i2 = this.mDropDownHeight;
                if (i2 == -1) {
                    if (!isInputMethodNotNeeded) {
                        buildDropDown = -1;
                    }
                    if (isInputMethodNotNeeded) {
                        this.mPopup.setWidth(this.mDropDownWidth == -1 ? -1 : 0);
                        this.mPopup.setHeight(0);
                    } else {
                        this.mPopup.setWidth(this.mDropDownWidth == -1 ? -1 : 0);
                        this.mPopup.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    buildDropDown = i2;
                }
                this.mPopup.setOutsideTouchable((this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) ? false : true);
                this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, i < 0 ? -1 : i, buildDropDown < 0 ? -1 : buildDropDown);
                return;
            }
            return;
        }
        int i3 = this.mDropDownWidth;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = getAnchorView().getWidth();
        }
        int i4 = this.mDropDownHeight;
        if (i4 == -1) {
            buildDropDown = -1;
        } else if (i4 != -2) {
            buildDropDown = i4;
        }
        this.mPopup.setWidth(i3);
        this.mPopup.setHeight(buildDropDown);
        setPopupClipToScreenEnabled(true);
        this.mPopup.setOutsideTouchable((this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) ? false : true);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet) {
            androidx.core.widget.PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
        }
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            java.lang.reflect.Method method = sSetEpicenterBoundsMethod;
            if (method != null) {
                try {
                    method.invoke(this.mPopup, this.mEpicenterBounds);
                } catch (java.lang.Exception unused) {
                }
            }
        } else {
            this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
        }
        androidx.core.widget.PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (this.mModal) {
            return;
        }
        this.mHandler.post(this.mHideSelector);
    }
}
