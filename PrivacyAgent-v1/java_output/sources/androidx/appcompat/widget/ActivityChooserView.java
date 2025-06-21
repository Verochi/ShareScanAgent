package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActivityChooserView extends android.view.ViewGroup implements androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient {
    private final android.view.View mActivityChooserContent;
    private final android.graphics.drawable.Drawable mActivityChooserContentBackground;
    final androidx.appcompat.widget.ActivityChooserView.ActivityChooserViewAdapter mAdapter;
    private final androidx.appcompat.widget.ActivityChooserView.Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final android.widget.FrameLayout mDefaultActivityButton;
    private final android.widget.ImageView mDefaultActivityButtonImage;
    final android.widget.FrameLayout mExpandActivityOverflowButton;
    private final android.widget.ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private androidx.appcompat.widget.ListPopupWindow mListPopupWindow;
    final android.database.DataSetObserver mModelDataSetObserver;
    android.widget.PopupWindow.OnDismissListener mOnDismissListener;
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    androidx.core.view.ActionProvider mProvider;

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$1, reason: invalid class name */
    public class AnonymousClass1 extends android.database.DataSetObserver {
        public AnonymousClass1() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            androidx.appcompat.widget.ActivityChooserView.this.mAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            androidx.appcompat.widget.ActivityChooserView.this.mAdapter.notifyDataSetInvalidated();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (androidx.appcompat.widget.ActivityChooserView.this.isShowingPopup()) {
                if (!androidx.appcompat.widget.ActivityChooserView.this.isShown()) {
                    androidx.appcompat.widget.ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                androidx.appcompat.widget.ActivityChooserView.this.getListPopupWindow().show();
                androidx.core.view.ActionProvider actionProvider = androidx.appcompat.widget.ActivityChooserView.this.mProvider;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$3, reason: invalid class name */
    public class AnonymousClass3 extends android.view.View.AccessibilityDelegate {
        public AnonymousClass3() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(android.view.View view, android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.appcompat.widget.ForwardingListener {
        public AnonymousClass4(android.view.View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public androidx.appcompat.view.menu.ShowableListMenu getPopup() {
            return androidx.appcompat.widget.ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStarted() {
            androidx.appcompat.widget.ActivityChooserView.this.showPopup();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStopped() {
            androidx.appcompat.widget.ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$5, reason: invalid class name */
    public class AnonymousClass5 extends android.database.DataSetObserver {
        public AnonymousClass5() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            androidx.appcompat.widget.ActivityChooserView.this.updateAppearance();
        }
    }

    public class ActivityChooserViewAdapter extends android.widget.BaseAdapter {
        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        private static final int ITEM_VIEW_TYPE_COUNT = 3;
        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        private androidx.appcompat.widget.ActivityChooserModel mDataModel;
        private boolean mHighlightDefaultActivity;
        private int mMaxActivityCount = 4;
        private boolean mShowDefaultActivity;
        private boolean mShowFooterView;

        public ActivityChooserViewAdapter() {
        }

        public int getActivityCount() {
            return this.mDataModel.getActivityCount();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int activityCount = this.mDataModel.getActivityCount();
            if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                activityCount--;
            }
            int min = java.lang.Math.min(activityCount, this.mMaxActivityCount);
            return this.mShowFooterView ? min + 1 : min;
        }

        public androidx.appcompat.widget.ActivityChooserModel getDataModel() {
            return this.mDataModel;
        }

        public android.content.pm.ResolveInfo getDefaultActivity() {
            return this.mDataModel.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.mDataModel.getHistorySize();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new java.lang.IllegalArgumentException();
            }
            if (!this.mShowDefaultActivity && this.mDataModel.getDefaultActivity() != null) {
                i++;
            }
            return this.mDataModel.getActivity(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.mShowFooterView && i == getCount() - 1) ? 1 : 0;
        }

        public boolean getShowDefaultActivity() {
            return this.mShowDefaultActivity;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new java.lang.IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                android.view.View inflate = android.view.LayoutInflater.from(androidx.appcompat.widget.ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((android.widget.TextView) inflate.findViewById(androidx.appcompat.R.id.title)).setText(androidx.appcompat.widget.ActivityChooserView.this.getContext().getString(androidx.appcompat.R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
            if (view == null || view.getId() != androidx.appcompat.R.id.list_item) {
                view = android.view.LayoutInflater.from(androidx.appcompat.widget.ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            android.content.pm.PackageManager packageManager = androidx.appcompat.widget.ActivityChooserView.this.getContext().getPackageManager();
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(androidx.appcompat.R.id.icon);
            android.content.pm.ResolveInfo resolveInfo = (android.content.pm.ResolveInfo) getItem(i);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((android.widget.TextView) view.findViewById(androidx.appcompat.R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.mShowDefaultActivity && i == 0 && this.mHighlightDefaultActivity) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int i = this.mMaxActivityCount;
            this.mMaxActivityCount = Integer.MAX_VALUE;
            int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            android.view.View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = java.lang.Math.max(i2, view.getMeasuredWidth());
            }
            this.mMaxActivityCount = i;
            return i2;
        }

        public void setDataModel(androidx.appcompat.widget.ActivityChooserModel activityChooserModel) {
            androidx.appcompat.widget.ActivityChooserModel dataModel = androidx.appcompat.widget.ActivityChooserView.this.mAdapter.getDataModel();
            if (dataModel != null && androidx.appcompat.widget.ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(androidx.appcompat.widget.ActivityChooserView.this.mModelDataSetObserver);
            }
            this.mDataModel = activityChooserModel;
            if (activityChooserModel != null && androidx.appcompat.widget.ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(androidx.appcompat.widget.ActivityChooserView.this.mModelDataSetObserver);
            }
            notifyDataSetChanged();
        }

        public void setMaxActivityCount(int i) {
            if (this.mMaxActivityCount != i) {
                this.mMaxActivityCount = i;
                notifyDataSetChanged();
            }
        }

        public void setShowDefaultActivity(boolean z, boolean z2) {
            if (this.mShowDefaultActivity == z && this.mHighlightDefaultActivity == z2) {
                return;
            }
            this.mShowDefaultActivity = z;
            this.mHighlightDefaultActivity = z2;
            notifyDataSetChanged();
        }

        public void setShowFooterView(boolean z) {
            if (this.mShowFooterView != z) {
                this.mShowFooterView = z;
                notifyDataSetChanged();
            }
        }
    }

    public class Callbacks implements android.widget.AdapterView.OnItemClickListener, android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.PopupWindow.OnDismissListener {
        public Callbacks() {
        }

        private void notifyOnDismissListener() {
            android.widget.PopupWindow.OnDismissListener onDismissListener = androidx.appcompat.widget.ActivityChooserView.this.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            androidx.appcompat.widget.ActivityChooserView activityChooserView = androidx.appcompat.widget.ActivityChooserView.this;
            if (view != activityChooserView.mDefaultActivityButton) {
                if (view != activityChooserView.mExpandActivityOverflowButton) {
                    throw new java.lang.IllegalArgumentException();
                }
                activityChooserView.mIsSelectingDefaultActivity = false;
                activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
                return;
            }
            activityChooserView.dismissPopup();
            android.content.Intent chooseActivity = androidx.appcompat.widget.ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(androidx.appcompat.widget.ActivityChooserView.this.mAdapter.getDataModel().getActivityIndex(androidx.appcompat.widget.ActivityChooserView.this.mAdapter.getDefaultActivity()));
            if (chooseActivity != null) {
                chooseActivity.addFlags(524288);
                androidx.appcompat.widget.ActivityChooserView.this.getContext().startActivity(chooseActivity);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            notifyOnDismissListener();
            androidx.core.view.ActionProvider actionProvider = androidx.appcompat.widget.ActivityChooserView.this.mProvider;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            int itemViewType = ((androidx.appcompat.widget.ActivityChooserView.ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new java.lang.IllegalArgumentException();
                }
                androidx.appcompat.widget.ActivityChooserView.this.showPopupUnchecked(Integer.MAX_VALUE);
                return;
            }
            androidx.appcompat.widget.ActivityChooserView.this.dismissPopup();
            androidx.appcompat.widget.ActivityChooserView activityChooserView = androidx.appcompat.widget.ActivityChooserView.this;
            if (activityChooserView.mIsSelectingDefaultActivity) {
                if (i > 0) {
                    activityChooserView.mAdapter.getDataModel().setDefaultActivity(i);
                    return;
                }
                return;
            }
            if (!activityChooserView.mAdapter.getShowDefaultActivity()) {
                i++;
            }
            android.content.Intent chooseActivity = androidx.appcompat.widget.ActivityChooserView.this.mAdapter.getDataModel().chooseActivity(i);
            if (chooseActivity != null) {
                chooseActivity.addFlags(524288);
                androidx.appcompat.widget.ActivityChooserView.this.getContext().startActivity(chooseActivity);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(android.view.View view) {
            androidx.appcompat.widget.ActivityChooserView activityChooserView = androidx.appcompat.widget.ActivityChooserView.this;
            if (view != activityChooserView.mDefaultActivityButton) {
                throw new java.lang.IllegalArgumentException();
            }
            if (activityChooserView.mAdapter.getCount() > 0) {
                androidx.appcompat.widget.ActivityChooserView activityChooserView2 = androidx.appcompat.widget.ActivityChooserView.this;
                activityChooserView2.mIsSelectingDefaultActivity = true;
                activityChooserView2.showPopupUnchecked(activityChooserView2.mInitialActivityCount);
            }
            return true;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends android.widget.LinearLayout {
        private static final int[] TINT_ATTRS = {android.R.attr.background};

        public InnerLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, TINT_ATTRS);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    public ActivityChooserView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ActivityChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mModelDataSetObserver = new androidx.appcompat.widget.ActivityChooserView.AnonymousClass1();
        this.mOnGlobalLayoutListener = new androidx.appcompat.widget.ActivityChooserView.AnonymousClass2();
        this.mInitialActivityCount = 4;
        int[] iArr = androidx.appcompat.R.styleable.ActivityChooserView;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        this.mInitialActivityCount = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActivityChooserView_initialActivityCount, 4);
        android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        android.view.LayoutInflater.from(getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view, (android.view.ViewGroup) this, true);
        androidx.appcompat.widget.ActivityChooserView.Callbacks callbacks = new androidx.appcompat.widget.ActivityChooserView.Callbacks();
        this.mCallbacks = callbacks;
        android.view.View findViewById = findViewById(androidx.appcompat.R.id.activity_chooser_view_content);
        this.mActivityChooserContent = findViewById;
        this.mActivityChooserContentBackground = findViewById.getBackground();
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(androidx.appcompat.R.id.default_activity_button);
        this.mDefaultActivityButton = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        int i2 = androidx.appcompat.R.id.image;
        this.mDefaultActivityButtonImage = (android.widget.ImageView) frameLayout.findViewById(i2);
        android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) findViewById(androidx.appcompat.R.id.expand_activities_button);
        frameLayout2.setOnClickListener(callbacks);
        frameLayout2.setAccessibilityDelegate(new androidx.appcompat.widget.ActivityChooserView.AnonymousClass3());
        frameLayout2.setOnTouchListener(new androidx.appcompat.widget.ActivityChooserView.AnonymousClass4(frameLayout2));
        this.mExpandActivityOverflowButton = frameLayout2;
        android.widget.ImageView imageView = (android.widget.ImageView) frameLayout2.findViewById(i2);
        this.mExpandActivityOverflowButtonImage = imageView;
        imageView.setImageDrawable(drawable);
        androidx.appcompat.widget.ActivityChooserView.ActivityChooserViewAdapter activityChooserViewAdapter = new androidx.appcompat.widget.ActivityChooserView.ActivityChooserViewAdapter();
        this.mAdapter = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new androidx.appcompat.widget.ActivityChooserView.AnonymousClass5());
        android.content.res.Resources resources = context.getResources();
        this.mListPopupMaxWidth = java.lang.Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_config_prefDialogWidth));
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        android.view.ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public androidx.appcompat.widget.ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    public androidx.appcompat.widget.ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            androidx.appcompat.widget.ListPopupWindow listPopupWindow = new androidx.appcompat.widget.ListPopupWindow(getContext());
            this.mListPopupWindow = listPopupWindow;
            listPopupWindow.setAdapter(this.mAdapter);
            this.mListPopupWindow.setAnchorView(this);
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
            this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
        }
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.appcompat.widget.ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.mModelDataSetObserver);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.ActivityChooserModel dataModel = this.mAdapter.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.mModelDataSetObserver);
        }
        android.view.ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mActivityChooserContent.layout(0, 0, i3 - i, i4 - i2);
        if (isShowingPopup()) {
            return;
        }
        dismissPopup();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        android.view.View view = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(androidx.appcompat.widget.ActivityChooserModel activityChooserModel) {
        this.mAdapter.setDataModel(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.mDefaultActionButtonContentDescription = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.mExpandActivityOverflowButtonImage.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(android.graphics.drawable.Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.mInitialActivityCount = i;
    }

    public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(androidx.core.view.ActionProvider actionProvider) {
        this.mProvider = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    public void showPopupUnchecked(int i) {
        if (this.mAdapter.getDataModel() == null) {
            throw new java.lang.IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        ?? r0 = this.mDefaultActivityButton.getVisibility() == 0 ? 1 : 0;
        int activityCount = this.mAdapter.getActivityCount();
        if (i == Integer.MAX_VALUE || activityCount <= i + r0) {
            this.mAdapter.setShowFooterView(false);
            this.mAdapter.setMaxActivityCount(i);
        } else {
            this.mAdapter.setShowFooterView(true);
            this.mAdapter.setMaxActivityCount(i - 1);
        }
        androidx.appcompat.widget.ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.isShowing()) {
            return;
        }
        if (this.mIsSelectingDefaultActivity || r0 == 0) {
            this.mAdapter.setShowDefaultActivity(true, r0);
        } else {
            this.mAdapter.setShowDefaultActivity(false, false);
        }
        listPopupWindow.setContentWidth(java.lang.Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        listPopupWindow.show();
        androidx.core.view.ActionProvider actionProvider = this.mProvider;
        if (actionProvider != null) {
            actionProvider.subUiVisibilityChanged(true);
        }
        listPopupWindow.getListView().setContentDescription(getContext().getString(androidx.appcompat.R.string.abc_activitychooserview_choose_application));
        listPopupWindow.getListView().setSelector(new android.graphics.drawable.ColorDrawable(0));
    }

    public void updateAppearance() {
        if (this.mAdapter.getCount() > 0) {
            this.mExpandActivityOverflowButton.setEnabled(true);
        } else {
            this.mExpandActivityOverflowButton.setEnabled(false);
        }
        int activityCount = this.mAdapter.getActivityCount();
        int historySize = this.mAdapter.getHistorySize();
        if (activityCount == 1 || (activityCount > 1 && historySize > 0)) {
            this.mDefaultActivityButton.setVisibility(0);
            android.content.pm.ResolveInfo defaultActivity = this.mAdapter.getDefaultActivity();
            android.content.pm.PackageManager packageManager = getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(defaultActivity.loadIcon(packageManager));
            if (this.mDefaultActionButtonContentDescription != 0) {
                this.mDefaultActivityButton.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, defaultActivity.loadLabel(packageManager)));
            }
        } else {
            this.mDefaultActivityButton.setVisibility(8);
        }
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        } else {
            this.mActivityChooserContent.setBackgroundDrawable(null);
        }
    }
}
