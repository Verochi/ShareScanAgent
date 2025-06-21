package androidx.appcompat.app;

/* loaded from: classes.dex */
class AlertController {
    android.widget.ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final int mButtonIconDimen;
    android.widget.Button mButtonNegative;
    private android.graphics.drawable.Drawable mButtonNegativeIcon;
    android.os.Message mButtonNegativeMessage;
    private java.lang.CharSequence mButtonNegativeText;
    android.widget.Button mButtonNeutral;
    private android.graphics.drawable.Drawable mButtonNeutralIcon;
    android.os.Message mButtonNeutralMessage;
    private java.lang.CharSequence mButtonNeutralText;
    private int mButtonPanelSideLayout;
    android.widget.Button mButtonPositive;
    private android.graphics.drawable.Drawable mButtonPositiveIcon;
    android.os.Message mButtonPositiveMessage;
    private java.lang.CharSequence mButtonPositiveText;
    private final android.content.Context mContext;
    private android.view.View mCustomTitleView;
    final androidx.appcompat.app.AppCompatDialog mDialog;
    android.os.Handler mHandler;
    private android.graphics.drawable.Drawable mIcon;
    private android.widget.ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    android.widget.ListView mListView;
    private java.lang.CharSequence mMessage;
    private android.widget.TextView mMessageView;
    int mMultiChoiceItemLayout;
    androidx.core.widget.NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private java.lang.CharSequence mTitle;
    private android.widget.TextView mTitleView;
    private android.view.View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private int mViewSpacingTop;
    private final android.view.Window mWindow;
    private boolean mViewSpacingSpecified = false;
    private int mIconId = 0;
    int mCheckedItem = -1;
    private int mButtonPanelLayoutHint = 0;
    private final android.view.View.OnClickListener mButtonHandler = new androidx.appcompat.app.AlertController.AnonymousClass1();

    /* renamed from: androidx.appcompat.app.AlertController$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            android.os.Message message;
            android.os.Message message2;
            android.os.Message message3;
            androidx.appcompat.app.AlertController alertController = androidx.appcompat.app.AlertController.this;
            android.os.Message obtain = (view != alertController.mButtonPositive || (message3 = alertController.mButtonPositiveMessage) == null) ? (view != alertController.mButtonNegative || (message2 = alertController.mButtonNegativeMessage) == null) ? (view != alertController.mButtonNeutral || (message = alertController.mButtonNeutralMessage) == null) ? null : android.os.Message.obtain(message) : android.os.Message.obtain(message2) : android.os.Message.obtain(message3);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            androidx.appcompat.app.AlertController alertController2 = androidx.appcompat.app.AlertController.this;
            alertController2.mHandler.obtainMessage(1, alertController2.mDialog).sendToTarget();
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.core.widget.NestedScrollView.OnScrollChangeListener {
        final /* synthetic */ android.view.View val$bottom;
        final /* synthetic */ android.view.View val$top;

        public AnonymousClass2(android.view.View view, android.view.View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(androidx.core.widget.NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            androidx.appcompat.app.AlertController.manageScrollIndicators(nestedScrollView, this.val$top, this.val$bottom);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$bottom;
        final /* synthetic */ android.view.View val$top;

        public AnonymousClass3(android.view.View view, android.view.View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.app.AlertController.manageScrollIndicators(androidx.appcompat.app.AlertController.this.mScrollView, this.val$top, this.val$bottom);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$4, reason: invalid class name */
    public class AnonymousClass4 implements android.widget.AbsListView.OnScrollListener {
        final /* synthetic */ android.view.View val$bottom;
        final /* synthetic */ android.view.View val$top;

        public AnonymousClass4(android.view.View view, android.view.View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
            androidx.appcompat.app.AlertController.manageScrollIndicators(absListView, this.val$top, this.val$bottom);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$bottom;
        final /* synthetic */ android.view.View val$top;

        public AnonymousClass5(android.view.View view, android.view.View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.app.AlertController.manageScrollIndicators(androidx.appcompat.app.AlertController.this.mListView, this.val$top, this.val$bottom);
        }
    }

    public static class AlertParams {
        public android.widget.ListAdapter mAdapter;
        public boolean[] mCheckedItems;
        public final android.content.Context mContext;
        public android.database.Cursor mCursor;
        public android.view.View mCustomTitleView;
        public boolean mForceInverseBackground;
        public android.graphics.drawable.Drawable mIcon;
        public final android.view.LayoutInflater mInflater;
        public java.lang.String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public java.lang.CharSequence[] mItems;
        public java.lang.String mLabelColumn;
        public java.lang.CharSequence mMessage;
        public android.graphics.drawable.Drawable mNegativeButtonIcon;
        public android.content.DialogInterface.OnClickListener mNegativeButtonListener;
        public java.lang.CharSequence mNegativeButtonText;
        public android.graphics.drawable.Drawable mNeutralButtonIcon;
        public android.content.DialogInterface.OnClickListener mNeutralButtonListener;
        public java.lang.CharSequence mNeutralButtonText;
        public android.content.DialogInterface.OnCancelListener mOnCancelListener;
        public android.content.DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public android.content.DialogInterface.OnClickListener mOnClickListener;
        public android.content.DialogInterface.OnDismissListener mOnDismissListener;
        public android.widget.AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public android.content.DialogInterface.OnKeyListener mOnKeyListener;
        public androidx.appcompat.app.AlertController.AlertParams.OnPrepareListViewListener mOnPrepareListViewListener;
        public android.graphics.drawable.Drawable mPositiveButtonIcon;
        public android.content.DialogInterface.OnClickListener mPositiveButtonListener;
        public java.lang.CharSequence mPositiveButtonText;
        public java.lang.CharSequence mTitle;
        public android.view.View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public int mViewSpacingTop;
        public int mIconId = 0;
        public int mIconAttrId = 0;
        public boolean mViewSpacingSpecified = false;
        public int mCheckedItem = -1;
        public boolean mRecycleOnMeasure = true;
        public boolean mCancelable = true;

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$1, reason: invalid class name */
        public class AnonymousClass1 extends android.widget.ArrayAdapter<java.lang.CharSequence> {
            final /* synthetic */ androidx.appcompat.app.AlertController.RecycleListView val$listView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(android.content.Context context, int i, int i2, java.lang.CharSequence[] charSequenceArr, androidx.appcompat.app.AlertController.RecycleListView recycleListView) {
                super(context, i, i2, charSequenceArr);
                this.val$listView = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
                android.view.View view2 = super.getView(i, view, viewGroup);
                boolean[] zArr = androidx.appcompat.app.AlertController.AlertParams.this.mCheckedItems;
                if (zArr != null && zArr[i]) {
                    this.val$listView.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$2, reason: invalid class name */
        public class AnonymousClass2 extends android.widget.CursorAdapter {
            private final int mIsCheckedIndex;
            private final int mLabelIndex;
            final /* synthetic */ androidx.appcompat.app.AlertController val$dialog;
            final /* synthetic */ androidx.appcompat.app.AlertController.RecycleListView val$listView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(android.content.Context context, android.database.Cursor cursor, boolean z, androidx.appcompat.app.AlertController.RecycleListView recycleListView, androidx.appcompat.app.AlertController alertController) {
                super(context, cursor, z);
                this.val$listView = recycleListView;
                this.val$dialog = alertController;
                android.database.Cursor cursor2 = getCursor();
                this.mLabelIndex = cursor2.getColumnIndexOrThrow(androidx.appcompat.app.AlertController.AlertParams.this.mLabelColumn);
                this.mIsCheckedIndex = cursor2.getColumnIndexOrThrow(androidx.appcompat.app.AlertController.AlertParams.this.mIsCheckedColumn);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor) {
                ((android.widget.CheckedTextView) view.findViewById(android.R.id.text1)).setText(cursor.getString(this.mLabelIndex));
                this.val$listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.mIsCheckedIndex) == 1);
            }

            @Override // android.widget.CursorAdapter
            public android.view.View newView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
                return androidx.appcompat.app.AlertController.AlertParams.this.mInflater.inflate(this.val$dialog.mMultiChoiceItemLayout, viewGroup, false);
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$3, reason: invalid class name */
        public class AnonymousClass3 implements android.widget.AdapterView.OnItemClickListener {
            final /* synthetic */ androidx.appcompat.app.AlertController val$dialog;

            public AnonymousClass3(androidx.appcompat.app.AlertController alertController) {
                this.val$dialog = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
                androidx.appcompat.app.AlertController.AlertParams.this.mOnClickListener.onClick(this.val$dialog.mDialog, i);
                if (androidx.appcompat.app.AlertController.AlertParams.this.mIsSingleChoice) {
                    return;
                }
                this.val$dialog.mDialog.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$AlertParams$4, reason: invalid class name */
        public class AnonymousClass4 implements android.widget.AdapterView.OnItemClickListener {
            final /* synthetic */ androidx.appcompat.app.AlertController val$dialog;
            final /* synthetic */ androidx.appcompat.app.AlertController.RecycleListView val$listView;

            public AnonymousClass4(androidx.appcompat.app.AlertController.RecycleListView recycleListView, androidx.appcompat.app.AlertController alertController) {
                this.val$listView = recycleListView;
                this.val$dialog = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
                boolean[] zArr = androidx.appcompat.app.AlertController.AlertParams.this.mCheckedItems;
                if (zArr != null) {
                    zArr[i] = this.val$listView.isItemChecked(i);
                }
                androidx.appcompat.app.AlertController.AlertParams.this.mOnCheckboxClickListener.onClick(this.val$dialog.mDialog, i, this.val$listView.isItemChecked(i));
            }
        }

        public interface OnPrepareListViewListener {
            void onPrepareListView(android.widget.ListView listView);
        }

        public AlertParams(android.content.Context context) {
            this.mContext = context;
            this.mInflater = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void createListView(androidx.appcompat.app.AlertController alertController) {
            android.widget.ListAdapter listAdapter;
            androidx.appcompat.app.AlertController.RecycleListView recycleListView = (androidx.appcompat.app.AlertController.RecycleListView) this.mInflater.inflate(alertController.mListLayout, (android.view.ViewGroup) null);
            if (this.mIsMultiChoice) {
                listAdapter = this.mCursor == null ? new androidx.appcompat.app.AlertController.AlertParams.AnonymousClass1(this.mContext, alertController.mMultiChoiceItemLayout, android.R.id.text1, this.mItems, recycleListView) : new androidx.appcompat.app.AlertController.AlertParams.AnonymousClass2(this.mContext, this.mCursor, false, recycleListView, alertController);
            } else {
                int i = this.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
                if (this.mCursor != null) {
                    listAdapter = new android.widget.SimpleCursorAdapter(this.mContext, i, this.mCursor, new java.lang.String[]{this.mLabelColumn}, new int[]{android.R.id.text1});
                } else {
                    listAdapter = this.mAdapter;
                    if (listAdapter == null) {
                        listAdapter = new androidx.appcompat.app.AlertController.CheckedItemAdapter(this.mContext, i, android.R.id.text1, this.mItems);
                    }
                }
            }
            androidx.appcompat.app.AlertController.AlertParams.OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView);
            }
            alertController.mAdapter = listAdapter;
            alertController.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new androidx.appcompat.app.AlertController.AlertParams.AnonymousClass3(alertController));
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new androidx.appcompat.app.AlertController.AlertParams.AnonymousClass4(recycleListView, alertController));
            }
            android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                recycleListView.setChoiceMode(2);
            }
            alertController.mListView = recycleListView;
        }

        public void apply(androidx.appcompat.app.AlertController alertController) {
            android.view.View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                java.lang.CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                android.graphics.drawable.Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i = this.mIconId;
                if (i != 0) {
                    alertController.setIcon(i);
                }
                int i2 = this.mIconAttrId;
                if (i2 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i2));
                }
            }
            java.lang.CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            java.lang.CharSequence charSequence3 = this.mPositiveButtonText;
            if (charSequence3 != null || this.mPositiveButtonIcon != null) {
                alertController.setButton(-1, charSequence3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
            }
            java.lang.CharSequence charSequence4 = this.mNegativeButtonText;
            if (charSequence4 != null || this.mNegativeButtonIcon != null) {
                alertController.setButton(-2, charSequence4, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }
            java.lang.CharSequence charSequence5 = this.mNeutralButtonText;
            if (charSequence5 != null || this.mNeutralButtonIcon != null) {
                alertController.setButton(-3, charSequence5, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                createListView(alertController);
            }
            android.view.View view2 = this.mView;
            if (view2 != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                } else {
                    alertController.setView(view2);
                    return;
                }
            }
            int i3 = this.mViewLayoutResId;
            if (i3 != 0) {
                alertController.setView(i3);
            }
        }
    }

    public static final class ButtonHandler extends android.os.Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private java.lang.ref.WeakReference<android.content.DialogInterface> mDialog;

        public ButtonHandler(android.content.DialogInterface dialogInterface) {
            this.mDialog = new java.lang.ref.WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((android.content.DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
            } else {
                if (i != 1) {
                    return;
                }
                ((android.content.DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class CheckedItemAdapter extends android.widget.ArrayAdapter<java.lang.CharSequence> {
        public CheckedItemAdapter(android.content.Context context, int i, int i2, java.lang.CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends android.widget.ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(android.content.Context context) {
            this(context, null);
        }

        public RecycleListView(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
        }
    }

    public AlertController(android.content.Context context, androidx.appcompat.app.AppCompatDialog appCompatDialog, android.view.Window window) {
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new androidx.appcompat.app.AlertController.ButtonHandler(appCompatDialog);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, androidx.appcompat.R.styleable.AlertDialog, androidx.appcompat.R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    public static boolean canTextInput(android.view.View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            return false;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (canTextInput(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void centerButton(android.widget.Button button) {
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static void manageScrollIndicators(android.view.View view, android.view.View view2, android.view.View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    @androidx.annotation.Nullable
    private android.view.ViewGroup resolvePanel(@androidx.annotation.Nullable android.view.View view, @androidx.annotation.Nullable android.view.View view2) {
        if (view == null) {
            if (view2 instanceof android.view.ViewStub) {
                view2 = ((android.view.ViewStub) view2).inflate();
            }
            return (android.view.ViewGroup) view2;
        }
        if (view2 != null) {
            android.view.ViewParent parent = view2.getParent();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof android.view.ViewStub) {
            view = ((android.view.ViewStub) view).inflate();
        }
        return (android.view.ViewGroup) view;
    }

    private int selectContentView() {
        int i = this.mButtonPanelSideLayout;
        return (i != 0 && this.mButtonPanelLayoutHint == 1) ? i : this.mAlertDialogLayout;
    }

    private void setScrollIndicators(android.view.ViewGroup viewGroup, android.view.View view, int i, int i2) {
        android.view.View findViewById = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorUp);
        android.view.View findViewById2 = this.mWindow.findViewById(androidx.appcompat.R.id.scrollIndicatorDown);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            androidx.core.view.ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById == null && findViewById2 == null) {
            return;
        }
        if (this.mMessage != null) {
            this.mScrollView.setOnScrollChangeListener(new androidx.appcompat.app.AlertController.AnonymousClass2(findViewById, findViewById2));
            this.mScrollView.post(new androidx.appcompat.app.AlertController.AnonymousClass3(findViewById, findViewById2));
            return;
        }
        android.widget.ListView listView = this.mListView;
        if (listView != null) {
            listView.setOnScrollListener(new androidx.appcompat.app.AlertController.AnonymousClass4(findViewById, findViewById2));
            this.mListView.post(new androidx.appcompat.app.AlertController.AnonymousClass5(findViewById, findViewById2));
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void setupButtons(android.view.ViewGroup viewGroup) {
        int i;
        android.widget.Button button = (android.widget.Button) viewGroup.findViewById(android.R.id.button1);
        this.mButtonPositive = button;
        button.setOnClickListener(this.mButtonHandler);
        if (android.text.TextUtils.isEmpty(this.mButtonPositiveText) && this.mButtonPositiveIcon == null) {
            this.mButtonPositive.setVisibility(8);
            i = 0;
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            android.graphics.drawable.Drawable drawable = this.mButtonPositiveIcon;
            if (drawable != null) {
                int i2 = this.mButtonIconDimen;
                drawable.setBounds(0, 0, i2, i2);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonPositive.setVisibility(0);
            i = 1;
        }
        android.widget.Button button2 = (android.widget.Button) viewGroup.findViewById(android.R.id.button2);
        this.mButtonNegative = button2;
        button2.setOnClickListener(this.mButtonHandler);
        if (android.text.TextUtils.isEmpty(this.mButtonNegativeText) && this.mButtonNegativeIcon == null) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            android.graphics.drawable.Drawable drawable2 = this.mButtonNegativeIcon;
            if (drawable2 != null) {
                int i3 = this.mButtonIconDimen;
                drawable2.setBounds(0, 0, i3, i3);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
            }
            this.mButtonNegative.setVisibility(0);
            i |= 2;
        }
        android.widget.Button button3 = (android.widget.Button) viewGroup.findViewById(android.R.id.button3);
        this.mButtonNeutral = button3;
        button3.setOnClickListener(this.mButtonHandler);
        if (android.text.TextUtils.isEmpty(this.mButtonNeutralText) && this.mButtonNeutralIcon == null) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            android.graphics.drawable.Drawable drawable3 = this.mButtonNeutralIcon;
            if (drawable3 != null) {
                int i4 = this.mButtonIconDimen;
                drawable3.setBounds(0, 0, i4, i4);
                this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
            }
            this.mButtonNeutral.setVisibility(0);
            i |= 4;
        }
        if (shouldCenterSingleButton(this.mContext)) {
            if (i == 1) {
                centerButton(this.mButtonPositive);
            } else if (i == 2) {
                centerButton(this.mButtonNegative);
            } else if (i == 4) {
                centerButton(this.mButtonNeutral);
            }
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void setupContent(android.view.ViewGroup viewGroup) {
        androidx.core.widget.NestedScrollView nestedScrollView = (androidx.core.widget.NestedScrollView) this.mWindow.findViewById(androidx.appcompat.R.id.scrollView);
        this.mScrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        android.widget.TextView textView = (android.widget.TextView) viewGroup.findViewById(android.R.id.message);
        this.mMessageView = textView;
        if (textView == null) {
            return;
        }
        java.lang.CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView == null) {
            viewGroup.setVisibility(8);
            return;
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.mScrollView.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.mScrollView);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.mListView, indexOfChild, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    private void setupCustomContent(android.view.ViewGroup viewGroup) {
        android.view.View view = this.mView;
        if (view == null) {
            view = this.mViewLayoutResId != 0 ? android.view.LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !canTextInput(view)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.mWindow.findViewById(androidx.appcompat.R.id.custom);
        frameLayout.addView(view, new android.view.ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified) {
            frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
        }
        if (this.mListView != null) {
            ((android.widget.LinearLayout.LayoutParams) ((androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void setupTitle(android.view.ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new android.view.ViewGroup.LayoutParams(-1, -2));
            this.mWindow.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
            return;
        }
        this.mIconView = (android.widget.ImageView) this.mWindow.findViewById(android.R.id.icon);
        if (!(!android.text.TextUtils.isEmpty(this.mTitle)) || !this.mShowTitle) {
            this.mWindow.findViewById(androidx.appcompat.R.id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        android.widget.TextView textView = (android.widget.TextView) this.mWindow.findViewById(androidx.appcompat.R.id.alertTitle);
        this.mTitleView = textView;
        textView.setText(this.mTitle);
        int i = this.mIconId;
        if (i != 0) {
            this.mIconView.setImageResource(i);
            return;
        }
        android.graphics.drawable.Drawable drawable = this.mIcon;
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
        } else {
            this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
            this.mIconView.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        android.view.View findViewById;
        android.widget.ListAdapter listAdapter;
        android.view.View findViewById2;
        android.view.View findViewById3 = this.mWindow.findViewById(androidx.appcompat.R.id.parentPanel);
        int i = androidx.appcompat.R.id.topPanel;
        android.view.View findViewById4 = findViewById3.findViewById(i);
        int i2 = androidx.appcompat.R.id.contentPanel;
        android.view.View findViewById5 = findViewById3.findViewById(i2);
        int i3 = androidx.appcompat.R.id.buttonPanel;
        android.view.View findViewById6 = findViewById3.findViewById(i3);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) findViewById3.findViewById(androidx.appcompat.R.id.customPanel);
        setupCustomContent(viewGroup);
        android.view.View findViewById7 = viewGroup.findViewById(i);
        android.view.View findViewById8 = viewGroup.findViewById(i2);
        android.view.View findViewById9 = viewGroup.findViewById(i3);
        android.view.ViewGroup resolvePanel = resolvePanel(findViewById7, findViewById4);
        android.view.ViewGroup resolvePanel2 = resolvePanel(findViewById8, findViewById5);
        android.view.ViewGroup resolvePanel3 = resolvePanel(findViewById9, findViewById6);
        setupContent(resolvePanel2);
        setupButtons(resolvePanel3);
        setupTitle(resolvePanel);
        boolean z = viewGroup.getVisibility() != 8;
        boolean z2 = (resolvePanel == null || resolvePanel.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (resolvePanel3 == null || resolvePanel3.getVisibility() == 8) ? false : true;
        if (!z3 && resolvePanel2 != null && (findViewById2 = resolvePanel2.findViewById(androidx.appcompat.R.id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            androidx.core.widget.NestedScrollView nestedScrollView = this.mScrollView;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            android.view.View findViewById10 = (this.mMessage == null && this.mListView == null) ? null : resolvePanel.findViewById(androidx.appcompat.R.id.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (resolvePanel2 != null && (findViewById = resolvePanel2.findViewById(androidx.appcompat.R.id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        android.widget.ListView listView = this.mListView;
        if (listView instanceof androidx.appcompat.app.AlertController.RecycleListView) {
            ((androidx.appcompat.app.AlertController.RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            android.view.View view = this.mListView;
            if (view == null) {
                view = this.mScrollView;
            }
            if (view != null) {
                setScrollIndicators(resolvePanel2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        android.widget.ListView listView2 = this.mListView;
        if (listView2 == null || (listAdapter = this.mAdapter) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i4 = this.mCheckedItem;
        if (i4 > -1) {
            listView2.setItemChecked(i4, true);
            listView2.setSelection(i4);
        }
    }

    private static boolean shouldCenterSingleButton(android.content.Context context) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public android.widget.Button getButton(int i) {
        if (i == -3) {
            return this.mButtonNeutral;
        }
        if (i == -2) {
            return this.mButtonNegative;
        }
        if (i != -1) {
            return null;
        }
        return this.mButtonPositive;
    }

    public int getIconAttributeResId(int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public android.widget.ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        this.mDialog.setContentView(selectContentView());
        setupView();
    }

    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        androidx.core.widget.NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        androidx.core.widget.NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void setButton(int i, java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener, android.os.Message message, android.graphics.drawable.Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message;
            this.mButtonNeutralIcon = drawable;
        } else if (i == -2) {
            this.mButtonNegativeText = charSequence;
            this.mButtonNegativeMessage = message;
            this.mButtonNegativeIcon = drawable;
        } else {
            if (i != -1) {
                throw new java.lang.IllegalArgumentException("Button does not exist");
            }
            this.mButtonPositiveText = charSequence;
            this.mButtonPositiveMessage = message;
            this.mButtonPositiveIcon = drawable;
        }
    }

    public void setButtonPanelLayoutHint(int i) {
        this.mButtonPanelLayoutHint = i;
    }

    public void setCustomTitle(android.view.View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int i) {
        this.mIcon = null;
        this.mIconId = i;
        android.widget.ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
            }
        }
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        android.widget.ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.mIconView.setImageDrawable(drawable);
            }
        }
    }

    public void setMessage(java.lang.CharSequence charSequence) {
        this.mMessage = charSequence;
        android.widget.TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        this.mTitle = charSequence;
        android.widget.TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int i) {
        this.mView = null;
        this.mViewLayoutResId = i;
        this.mViewSpacingSpecified = false;
    }

    public void setView(android.view.View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(android.view.View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i;
        this.mViewSpacingTop = i2;
        this.mViewSpacingRight = i3;
        this.mViewSpacingBottom = i4;
    }
}
