package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class AppCompatSpinner extends android.widget.Spinner implements androidx.core.view.TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {android.R.attr.spinnerMode};
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final java.lang.String TAG = "AppCompatSpinner";
    private final androidx.appcompat.widget.AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private androidx.appcompat.widget.ForwardingListener mForwardingListener;
    private androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup mPopup;
    private final android.content.Context mPopupContext;
    private final boolean mPopupSet;
    private android.widget.SpinnerAdapter mTempAdapter;
    final android.graphics.Rect mTempRect;

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.appcompat.widget.ForwardingListener {
        final /* synthetic */ androidx.appcompat.widget.AppCompatSpinner.DropdownPopup val$popup;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.view.View view, androidx.appcompat.widget.AppCompatSpinner.DropdownPopup dropdownPopup) {
            super(view);
            this.val$popup = dropdownPopup;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public androidx.appcompat.view.menu.ShowableListMenu getPopup() {
            return this.val$popup;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        @android.annotation.SuppressLint({"SyntheticAccessor"})
        public boolean onForwardingStarted() {
            if (androidx.appcompat.widget.AppCompatSpinner.this.getInternalPopup().isShowing()) {
                return true;
            }
            androidx.appcompat.widget.AppCompatSpinner.this.showPopup();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!androidx.appcompat.widget.AppCompatSpinner.this.getInternalPopup().isShowing()) {
                androidx.appcompat.widget.AppCompatSpinner.this.showPopup();
            }
            android.view.ViewTreeObserver viewTreeObserver = androidx.appcompat.widget.AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public class DialogPopup implements androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup, android.content.DialogInterface.OnClickListener {
        private android.widget.ListAdapter mListAdapter;

        @androidx.annotation.VisibleForTesting
        androidx.appcompat.app.AlertDialog mPopup;
        private java.lang.CharSequence mPrompt;

        public DialogPopup() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            androidx.appcompat.app.AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.mPopup = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public android.graphics.drawable.Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public java.lang.CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean isShowing() {
            androidx.appcompat.app.AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            androidx.appcompat.widget.AppCompatSpinner.this.setSelection(i);
            if (androidx.appcompat.widget.AppCompatSpinner.this.getOnItemClickListener() != null) {
                androidx.appcompat.widget.AppCompatSpinner.this.performItemClick(null, i, this.mListAdapter.getItemId(i));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(android.widget.ListAdapter listAdapter) {
            this.mListAdapter = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int i) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int i) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(java.lang.CharSequence charSequence) {
            this.mPrompt = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int i) {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int i, int i2) {
            if (this.mListAdapter == null) {
                return;
            }
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(androidx.appcompat.widget.AppCompatSpinner.this.getPopupContext());
            java.lang.CharSequence charSequence = this.mPrompt;
            if (charSequence != null) {
                builder.setTitle(charSequence);
            }
            androidx.appcompat.app.AlertDialog create = builder.setSingleChoiceItems(this.mListAdapter, androidx.appcompat.widget.AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            this.mPopup = create;
            android.widget.ListView listView = create.getListView();
            listView.setTextDirection(i);
            listView.setTextAlignment(i2);
            this.mPopup.show();
        }
    }

    public static class DropDownAdapter implements android.widget.ListAdapter, android.widget.SpinnerAdapter {
        private android.widget.SpinnerAdapter mAdapter;
        private android.widget.ListAdapter mListAdapter;

        public DropDownAdapter(@androidx.annotation.Nullable android.widget.SpinnerAdapter spinnerAdapter, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
            android.content.res.Resources.Theme dropDownViewTheme;
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof android.widget.ListAdapter) {
                this.mListAdapter = (android.widget.ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (android.os.Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)) {
                    android.widget.ThemedSpinnerAdapter themedSpinnerAdapter = (android.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    dropDownViewTheme = themedSpinnerAdapter.getDropDownViewTheme();
                    if (dropDownViewTheme != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof androidx.appcompat.widget.ThemedSpinnerAdapter) {
                    androidx.appcompat.widget.ThemedSpinnerAdapter themedSpinnerAdapter2 = (androidx.appcompat.widget.ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                        themedSpinnerAdapter2.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            android.widget.ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public android.view.View getDropDownView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            android.widget.ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(android.database.DataSetObserver dataSetObserver) {
            android.widget.SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public class DropdownPopup extends androidx.appcompat.widget.ListPopupWindow implements androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup {
        android.widget.ListAdapter mAdapter;
        private java.lang.CharSequence mHintText;
        private int mOriginalHorizontalOffset;
        private final android.graphics.Rect mVisibleRect;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$1, reason: invalid class name */
        public class AnonymousClass1 implements android.widget.AdapterView.OnItemClickListener {
            final /* synthetic */ androidx.appcompat.widget.AppCompatSpinner val$this$0;

            public AnonymousClass1(androidx.appcompat.widget.AppCompatSpinner appCompatSpinner) {
                this.val$this$0 = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
                androidx.appcompat.widget.AppCompatSpinner.this.setSelection(i);
                if (androidx.appcompat.widget.AppCompatSpinner.this.getOnItemClickListener() != null) {
                    androidx.appcompat.widget.AppCompatSpinner.DropdownPopup dropdownPopup = androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.this;
                    androidx.appcompat.widget.AppCompatSpinner.this.performItemClick(view, i, dropdownPopup.mAdapter.getItemId(i));
                }
                androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.this.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$2, reason: invalid class name */
        public class AnonymousClass2 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
            public AnonymousClass2() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                androidx.appcompat.widget.AppCompatSpinner.DropdownPopup dropdownPopup = androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.this;
                if (!dropdownPopup.isVisibleToUser(androidx.appcompat.widget.AppCompatSpinner.this)) {
                    androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.this.dismiss();
                } else {
                    androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.this.computeContentWidth();
                    androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.super.show();
                }
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$3, reason: invalid class name */
        public class AnonymousClass3 implements android.widget.PopupWindow.OnDismissListener {
            final /* synthetic */ android.view.ViewTreeObserver.OnGlobalLayoutListener val$layoutListener;

            public AnonymousClass3(android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.val$layoutListener = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                android.view.ViewTreeObserver viewTreeObserver = androidx.appcompat.widget.AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
                }
            }
        }

        public DropdownPopup(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mVisibleRect = new android.graphics.Rect();
            setAnchorView(androidx.appcompat.widget.AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.AnonymousClass1(androidx.appcompat.widget.AppCompatSpinner.this));
        }

        public void computeContentWidth() {
            int i;
            android.graphics.drawable.Drawable background = getBackground();
            if (background != null) {
                background.getPadding(androidx.appcompat.widget.AppCompatSpinner.this.mTempRect);
                i = androidx.appcompat.widget.ViewUtils.isLayoutRtl(androidx.appcompat.widget.AppCompatSpinner.this) ? androidx.appcompat.widget.AppCompatSpinner.this.mTempRect.right : -androidx.appcompat.widget.AppCompatSpinner.this.mTempRect.left;
            } else {
                android.graphics.Rect rect = androidx.appcompat.widget.AppCompatSpinner.this.mTempRect;
                rect.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = androidx.appcompat.widget.AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = androidx.appcompat.widget.AppCompatSpinner.this.getPaddingRight();
            int width = androidx.appcompat.widget.AppCompatSpinner.this.getWidth();
            androidx.appcompat.widget.AppCompatSpinner appCompatSpinner = androidx.appcompat.widget.AppCompatSpinner.this;
            int i2 = appCompatSpinner.mDropDownWidth;
            if (i2 == -2) {
                int compatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth((android.widget.SpinnerAdapter) this.mAdapter, getBackground());
                int i3 = androidx.appcompat.widget.AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                android.graphics.Rect rect2 = androidx.appcompat.widget.AppCompatSpinner.this.mTempRect;
                int i4 = (i3 - rect2.left) - rect2.right;
                if (compatMeasureContentWidth > i4) {
                    compatMeasureContentWidth = i4;
                }
                setContentWidth(java.lang.Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(i2);
            }
            setHorizontalOffset(androidx.appcompat.widget.ViewUtils.isLayoutRtl(androidx.appcompat.widget.AppCompatSpinner.this) ? i + (((width - paddingRight) - getWidth()) - getHorizontalOriginalOffset()) : i + paddingLeft + getHorizontalOriginalOffset());
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public java.lang.CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return this.mOriginalHorizontalOffset;
        }

        public boolean isVisibleToUser(android.view.View view) {
            return androidx.core.view.ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.mVisibleRect);
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(android.widget.ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int i) {
            this.mOriginalHorizontalOffset = i;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(java.lang.CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int i, int i2) {
            android.view.ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            android.widget.ListView listView = getListView();
            listView.setChoiceMode(1);
            listView.setTextDirection(i);
            listView.setTextAlignment(i2);
            setSelection(androidx.appcompat.widget.AppCompatSpinner.this.getSelectedItemPosition());
            if (isShowing || (viewTreeObserver = androidx.appcompat.widget.AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.AnonymousClass2 anonymousClass2 = new androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.AnonymousClass2();
            viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
            setOnDismissListener(new androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.AnonymousClass3(anonymousClass2));
        }
    }

    public static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.appcompat.widget.AppCompatSpinner.SavedState> CREATOR = new androidx.appcompat.widget.AppCompatSpinner.SavedState.AnonymousClass1();
        boolean mShowDropdown;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.appcompat.widget.AppCompatSpinner.SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.appcompat.widget.AppCompatSpinner.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.appcompat.widget.AppCompatSpinner.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public androidx.appcompat.widget.AppCompatSpinner.SavedState[] newArray(int i) {
                return new androidx.appcompat.widget.AppCompatSpinner.SavedState[i];
            }
        }

        public SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.mShowDropdown = parcel.readByte() != 0;
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
        }
    }

    @androidx.annotation.VisibleForTesting
    public interface SpinnerPopup {
        void dismiss();

        android.graphics.drawable.Drawable getBackground();

        java.lang.CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(android.widget.ListAdapter listAdapter);

        void setBackgroundDrawable(android.graphics.drawable.Drawable drawable);

        void setHorizontalOffset(int i);

        void setHorizontalOriginalOffset(int i);

        void setPromptText(java.lang.CharSequence charSequence);

        void setVerticalOffset(int i);

        void show(int i, int i2);
    }

    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context context) {
        this(context, (android.util.AttributeSet) null);
    }

    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context context, int i) {
        this(context, null, androidx.appcompat.R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r10 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2, android.content.res.Resources.Theme theme) {
        super(context, attributeSet, i);
        android.content.res.TypedArray typedArray;
        this.mTempRect = new android.graphics.Rect();
        androidx.appcompat.widget.ThemeUtils.checkAppCompatTheme(this, getContext());
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.Spinner, i, 0);
        this.mBackgroundTintHelper = new androidx.appcompat.widget.AppCompatBackgroundHelper(this);
        if (theme != null) {
            this.mPopupContext = new androidx.appcompat.view.ContextThemeWrapper(context, theme);
        } else {
            int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.Spinner_popupTheme, 0);
            if (resourceId != 0) {
                this.mPopupContext = new androidx.appcompat.view.ContextThemeWrapper(context, resourceId);
            } else {
                this.mPopupContext = context;
            }
        }
        android.content.res.TypedArray typedArray2 = null;
        if (i2 == -1) {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, ATTRS_ANDROID_SPINNERMODE, i, 0);
                try {
                    if (typedArray.hasValue(0)) {
                        i2 = typedArray.getInt(0, 0);
                    }
                } catch (java.lang.Exception unused) {
                } catch (java.lang.Throwable th) {
                    th = th;
                    typedArray2 = typedArray;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused2) {
                typedArray = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            typedArray.recycle();
        }
        if (i2 == 0) {
            androidx.appcompat.widget.AppCompatSpinner.DialogPopup dialogPopup = new androidx.appcompat.widget.AppCompatSpinner.DialogPopup();
            this.mPopup = dialogPopup;
            dialogPopup.setPromptText(obtainStyledAttributes.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
        } else if (i2 == 1) {
            androidx.appcompat.widget.AppCompatSpinner.DropdownPopup dropdownPopup = new androidx.appcompat.widget.AppCompatSpinner.DropdownPopup(this.mPopupContext, attributeSet, i);
            androidx.appcompat.widget.TintTypedArray obtainStyledAttributes2 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(this.mPopupContext, attributeSet, androidx.appcompat.R.styleable.Spinner, i, 0);
            this.mDropDownWidth = obtainStyledAttributes2.getLayoutDimension(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
            dropdownPopup.setBackgroundDrawable(obtainStyledAttributes2.getDrawable(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
            dropdownPopup.setPromptText(obtainStyledAttributes.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
            obtainStyledAttributes2.recycle();
            this.mPopup = dropdownPopup;
            this.mForwardingListener = new androidx.appcompat.widget.AppCompatSpinner.AnonymousClass1(this, dropdownPopup);
        }
        java.lang.CharSequence[] textArray = obtainStyledAttributes.getTextArray(androidx.appcompat.R.styleable.Spinner_android_entries);
        if (textArray != null) {
            android.widget.ArrayAdapter arrayAdapter = new android.widget.ArrayAdapter(context, android.R.layout.simple_spinner_item, textArray);
            arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((android.widget.SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
        this.mPopupSet = true;
        android.widget.SpinnerAdapter spinnerAdapter = this.mTempAdapter;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
    }

    public int compatMeasureContentWidth(android.widget.SpinnerAdapter spinnerAdapter, android.graphics.drawable.Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = java.lang.Math.max(0, getSelectedItemPosition());
        int min = java.lang.Math.min(spinnerAdapter.getCount(), max + 15);
        android.view.View view = null;
        int i2 = 0;
        for (int max2 = java.lang.Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = java.lang.Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.mTempRect);
        android.graphics.Rect rect = this.mTempRect;
        return i2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getHorizontalOffset() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getVerticalOffset() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.mPopup != null ? this.mDropDownWidth : super.getDropDownWidth();
    }

    @androidx.annotation.VisibleForTesting
    public final androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public android.graphics.drawable.Drawable getPopupBackground() {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getBackground() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public android.content.Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public java.lang.CharSequence getPrompt() {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getHintText() : super.getPrompt();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null || !spinnerPopup.isShowing()) {
            return;
        }
        this.mPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup == null || android.view.View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(java.lang.Math.min(java.lang.Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), android.view.View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        android.view.ViewTreeObserver viewTreeObserver;
        androidx.appcompat.widget.AppCompatSpinner.SavedState savedState = (androidx.appcompat.widget.AppCompatSpinner.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.mShowDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new androidx.appcompat.widget.AppCompatSpinner.AnonymousClass2());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        androidx.appcompat.widget.AppCompatSpinner.SavedState savedState = new androidx.appcompat.widget.AppCompatSpinner.SavedState(super.onSaveInstanceState());
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        savedState.mShowDropdown = spinnerPopup != null && spinnerPopup.isShowing();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        androidx.appcompat.widget.ForwardingListener forwardingListener = this.mForwardingListener;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null) {
            return super.performClick();
        }
        if (spinnerPopup.isShowing()) {
            return true;
        }
        showPopup();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(android.widget.SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            android.content.Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.setAdapter(new androidx.appcompat.widget.AppCompatSpinner.DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@androidx.annotation.DrawableRes int i) {
        super.setBackgroundResource(i);
        androidx.appcompat.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null) {
            super.setDropDownHorizontalOffset(i);
        } else {
            spinnerPopup.setHorizontalOriginalOffset(i);
            this.mPopup.setHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setVerticalOffset(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@androidx.annotation.DrawableRes int i) {
        setPopupBackgroundDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(java.lang.CharSequence charSequence) {
        androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        androidx.appcompat.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        androidx.appcompat.widget.AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    public void showPopup() {
        this.mPopup.show(getTextDirection(), getTextAlignment());
    }
}
