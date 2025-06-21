package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends android.widget.HorizontalScrollView implements android.widget.AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final java.lang.String TAG = "ScrollingTabContainerView";
    private static final android.view.animation.Interpolator sAlphaInterpolator = new android.view.animation.DecelerateInterpolator();
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private androidx.appcompat.widget.ScrollingTabContainerView.TabClickListener mTabClickListener;
    androidx.appcompat.widget.LinearLayoutCompat mTabLayout;
    java.lang.Runnable mTabSelector;
    private android.widget.Spinner mTabSpinner;
    protected final androidx.appcompat.widget.ScrollingTabContainerView.VisibilityAnimListener mVisAnimListener;
    protected android.view.ViewPropertyAnimator mVisibilityAnim;

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.View val$tabView;

        public AnonymousClass1(android.view.View view) {
            this.val$tabView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.widget.ScrollingTabContainerView.this.smoothScrollTo(this.val$tabView.getLeft() - ((androidx.appcompat.widget.ScrollingTabContainerView.this.getWidth() - this.val$tabView.getWidth()) / 2), 0);
            androidx.appcompat.widget.ScrollingTabContainerView.this.mTabSelector = null;
        }
    }

    public class TabAdapter extends android.widget.BaseAdapter {
        public TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return androidx.appcompat.widget.ScrollingTabContainerView.this.mTabLayout.getChildCount();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            return ((androidx.appcompat.widget.ScrollingTabContainerView.TabView) androidx.appcompat.widget.ScrollingTabContainerView.this.mTabLayout.getChildAt(i)).getTab();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            if (view == null) {
                return androidx.appcompat.widget.ScrollingTabContainerView.this.createTabView((androidx.appcompat.app.ActionBar.Tab) getItem(i), true);
            }
            ((androidx.appcompat.widget.ScrollingTabContainerView.TabView) view).bindTab((androidx.appcompat.app.ActionBar.Tab) getItem(i));
            return view;
        }
    }

    public class TabClickListener implements android.view.View.OnClickListener {
        public TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            ((androidx.appcompat.widget.ScrollingTabContainerView.TabView) view).getTab().select();
            int childCount = androidx.appcompat.widget.ScrollingTabContainerView.this.mTabLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = androidx.appcompat.widget.ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    public class TabView extends android.widget.LinearLayout {
        private static final java.lang.String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private android.view.View mCustomView;
        private android.widget.ImageView mIconView;
        private androidx.appcompat.app.ActionBar.Tab mTab;
        private android.widget.TextView mTextView;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public TabView(android.content.Context context, androidx.appcompat.app.ActionBar.Tab tab, boolean z) {
            super(context, null, r5);
            int i = androidx.appcompat.R.attr.actionBarTabStyle;
            int[] iArr = {android.R.attr.background};
            this.BG_ATTRS = iArr;
            this.mTab = tab;
            androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, null, iArr, i, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public void bindTab(androidx.appcompat.app.ActionBar.Tab tab) {
            this.mTab = tab;
            update();
        }

        public androidx.appcompat.app.ActionBar.Tab getTab() {
            return this.mTab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (androidx.appcompat.widget.ScrollingTabContainerView.this.mMaxTabWidth > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = androidx.appcompat.widget.ScrollingTabContainerView.this.mMaxTabWidth;
                if (measuredWidth > i3) {
                    super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public void update() {
            androidx.appcompat.app.ActionBar.Tab tab = this.mTab;
            android.view.View customView = tab.getCustomView();
            if (customView != null) {
                android.view.ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((android.view.ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.mCustomView = customView;
                android.widget.TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                android.widget.ImageView imageView = this.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                    return;
                }
                return;
            }
            android.view.View view = this.mCustomView;
            if (view != null) {
                removeView(view);
                this.mCustomView = null;
            }
            android.graphics.drawable.Drawable icon = tab.getIcon();
            java.lang.CharSequence text = tab.getText();
            if (icon != null) {
                if (this.mIconView == null) {
                    androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(getContext());
                    android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.mIconView = appCompatImageView;
                }
                this.mIconView.setImageDrawable(icon);
                this.mIconView.setVisibility(0);
            } else {
                android.widget.ImageView imageView2 = this.mIconView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
            }
            boolean z = !android.text.TextUtils.isEmpty(text);
            if (z) {
                if (this.mTextView == null) {
                    androidx.appcompat.widget.AppCompatTextView appCompatTextView = new androidx.appcompat.widget.AppCompatTextView(getContext(), null, androidx.appcompat.R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                    android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.mTextView = appCompatTextView;
                }
                this.mTextView.setText(text);
                this.mTextView.setVisibility(0);
            } else {
                android.widget.TextView textView2 = this.mTextView;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.mTextView.setText((java.lang.CharSequence) null);
                }
            }
            android.widget.ImageView imageView3 = this.mIconView;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.getContentDescription());
            }
            androidx.appcompat.widget.TooltipCompat.setTooltipText(this, z ? null : tab.getContentDescription());
        }
    }

    public class VisibilityAnimListener extends android.animation.AnimatorListenerAdapter {
        private boolean mCanceled = false;
        private int mFinalVisibility;

        public VisibilityAnimListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (this.mCanceled) {
                return;
            }
            androidx.appcompat.widget.ScrollingTabContainerView scrollingTabContainerView = androidx.appcompat.widget.ScrollingTabContainerView.this;
            scrollingTabContainerView.mVisibilityAnim = null;
            scrollingTabContainerView.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            androidx.appcompat.widget.ScrollingTabContainerView.this.setVisibility(0);
            this.mCanceled = false;
        }

        public androidx.appcompat.widget.ScrollingTabContainerView.VisibilityAnimListener withFinalVisibility(android.view.ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.mFinalVisibility = i;
            androidx.appcompat.widget.ScrollingTabContainerView.this.mVisibilityAnim = viewPropertyAnimator;
            return this;
        }
    }

    public ScrollingTabContainerView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.mVisAnimListener = new androidx.appcompat.widget.ScrollingTabContainerView.VisibilityAnimListener();
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.view.ActionBarPolicy actionBarPolicy = androidx.appcompat.view.ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
        androidx.appcompat.widget.LinearLayoutCompat createTabLayout = createTabLayout();
        this.mTabLayout = createTabLayout;
        addView(createTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
    }

    private android.widget.Spinner createSpinner() {
        androidx.appcompat.widget.AppCompatSpinner appCompatSpinner = new androidx.appcompat.widget.AppCompatSpinner(getContext(), null, androidx.appcompat.R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private androidx.appcompat.widget.LinearLayoutCompat createTabLayout() {
        androidx.appcompat.widget.LinearLayoutCompat linearLayoutCompat = new androidx.appcompat.widget.LinearLayoutCompat(getContext(), null, androidx.appcompat.R.attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean isCollapsed() {
        android.widget.Spinner spinner = this.mTabSpinner;
        return spinner != null && spinner.getParent() == this;
    }

    private void performCollapse() {
        if (isCollapsed()) {
            return;
        }
        if (this.mTabSpinner == null) {
            this.mTabSpinner = createSpinner();
        }
        removeView(this.mTabLayout);
        addView(this.mTabSpinner, new android.view.ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter((android.widget.SpinnerAdapter) new androidx.appcompat.widget.ScrollingTabContainerView.TabAdapter());
        }
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mTabSelector = null;
        }
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if (!isCollapsed()) {
            return false;
        }
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public void addTab(androidx.appcompat.app.ActionBar.Tab tab, int i, boolean z) {
        androidx.appcompat.widget.ScrollingTabContainerView.TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, i, new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((androidx.appcompat.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            createTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void addTab(androidx.appcompat.app.ActionBar.Tab tab, boolean z) {
        androidx.appcompat.widget.ScrollingTabContainerView.TabView createTabView = createTabView(tab, false);
        this.mTabLayout.addView(createTabView, new androidx.appcompat.widget.LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((androidx.appcompat.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            createTabView.setSelected(true);
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void animateToTab(int i) {
        android.view.View childAt = this.mTabLayout.getChildAt(i);
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        androidx.appcompat.widget.ScrollingTabContainerView.AnonymousClass1 anonymousClass1 = new androidx.appcompat.widget.ScrollingTabContainerView.AnonymousClass1(childAt);
        this.mTabSelector = anonymousClass1;
        post(anonymousClass1);
    }

    public void animateToVisibility(int i) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i != 0) {
            android.view.ViewPropertyAnimator alpha = animate().alpha(0.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(sAlphaInterpolator);
            alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i));
            alpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        android.view.ViewPropertyAnimator alpha2 = animate().alpha(1.0f);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(sAlphaInterpolator);
        alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i));
        alpha2.start();
    }

    public androidx.appcompat.widget.ScrollingTabContainerView.TabView createTabView(androidx.appcompat.app.ActionBar.Tab tab, boolean z) {
        androidx.appcompat.widget.ScrollingTabContainerView.TabView tabView = new androidx.appcompat.widget.ScrollingTabContainerView.TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, this.mContentHeight));
        } else {
            tabView.setFocusable(true);
            if (this.mTabClickListener == null) {
                this.mTabClickListener = new androidx.appcompat.widget.ScrollingTabContainerView.TabClickListener();
            }
            tabView.setOnClickListener(this.mTabClickListener);
        }
        return tabView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.ActionBarPolicy actionBarPolicy = androidx.appcompat.view.ActionBarPolicy.get(getContext());
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        java.lang.Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
        ((androidx.appcompat.widget.ScrollingTabContainerView.TabView) view).getTab().select();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.mTabLayout.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.mMaxTabWidth = -1;
        } else {
            if (childCount > 2) {
                this.mMaxTabWidth = (int) (android.view.View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.mMaxTabWidth = android.view.View.MeasureSpec.getSize(i) / 2;
            }
            this.mMaxTabWidth = java.lang.Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
        }
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (!z && this.mAllowCollapse) {
            this.mTabLayout.measure(0, makeMeasureSpec);
            if (this.mTabLayout.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(i)) {
                performCollapse();
            } else {
                performExpand();
            }
        } else {
            performExpand();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.mSelectedTabIndex);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(android.widget.AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((androidx.appcompat.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void removeTabAt(int i) {
        this.mTabLayout.removeViewAt(i);
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((androidx.appcompat.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z) {
        this.mAllowCollapse = z;
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.mSelectedTabIndex = i;
        int childCount = this.mTabLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            android.view.View childAt = this.mTabLayout.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                animateToTab(i);
            }
            i2++;
        }
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void updateTab(int i) {
        ((androidx.appcompat.widget.ScrollingTabContainerView.TabView) this.mTabLayout.getChildAt(i)).update();
        android.widget.Spinner spinner = this.mTabSpinner;
        if (spinner != null) {
            ((androidx.appcompat.widget.ScrollingTabContainerView.TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.mAllowCollapse) {
            requestLayout();
        }
    }
}
