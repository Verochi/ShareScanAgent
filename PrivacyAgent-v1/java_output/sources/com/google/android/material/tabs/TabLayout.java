package com.google.android.material.tabs;

@androidx.viewpager.widget.ViewPager.DecorView
/* loaded from: classes22.dex */
public class TabLayout extends android.widget.HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;

    @androidx.annotation.Dimension(unit = 0)
    static final int DEFAULT_GAP_TEXT_ICON = 8;

    @androidx.annotation.Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT = 48;

    @androidx.annotation.Dimension(unit = 0)
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;

    @androidx.annotation.Dimension(unit = 0)
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int GRAVITY_START = 2;
    public static final int INDICATOR_ANIMATION_MODE_ELASTIC = 1;
    public static final int INDICATOR_ANIMATION_MODE_LINEAR = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final java.lang.String LOG_TAG = "TabLayout";
    public static final int MODE_AUTO = 2;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int TAB_LABEL_VISIBILITY_LABELED = 1;
    public static final int TAB_LABEL_VISIBILITY_UNLABELED = 0;

    @androidx.annotation.Dimension(unit = 0)
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private com.google.android.material.tabs.TabLayout.AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;

    @androidx.annotation.Nullable
    private com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener currentVpSelectedListener;
    boolean inlineLabel;
    int mode;
    private com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener pageChangeListener;

    @androidx.annotation.Nullable
    private androidx.viewpager.widget.PagerAdapter pagerAdapter;
    private android.database.DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private android.animation.ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;

    @androidx.annotation.Nullable
    private com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener selectedListener;
    private final java.util.ArrayList<com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener> selectedListeners;

    @androidx.annotation.Nullable
    private com.google.android.material.tabs.TabLayout.Tab selectedTab;
    private boolean setupViewPagerImplicitly;

    @androidx.annotation.NonNull
    final com.google.android.material.tabs.TabLayout.SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    android.content.res.ColorStateList tabIconTint;
    android.graphics.PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    int tabIndicatorAnimationMode;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    private com.google.android.material.tabs.TabIndicatorInterpolator tabIndicatorInterpolator;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    android.content.res.ColorStateList tabRippleColorStateList;

    @androidx.annotation.NonNull
    android.graphics.drawable.Drawable tabSelectedIndicator;
    private int tabSelectedIndicatorColor;
    int tabTextAppearance;
    android.content.res.ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final androidx.core.util.Pools.Pool<com.google.android.material.tabs.TabLayout.TabView> tabViewPool;
    private final java.util.ArrayList<com.google.android.material.tabs.TabLayout.Tab> tabs;
    boolean unboundedRipple;

    @androidx.annotation.Nullable
    androidx.viewpager.widget.ViewPager viewPager;
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_TabLayout;
    private static final androidx.core.util.Pools.Pool<com.google.android.material.tabs.TabLayout.Tab> tabPool = new androidx.core.util.Pools.SynchronizedPool(16);

    /* renamed from: com.google.android.material.tabs.TabLayout$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            com.google.android.material.tabs.TabLayout.this.scrollTo(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class AdapterChangeListener implements androidx.viewpager.widget.ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;

        public AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager, @androidx.annotation.Nullable androidx.viewpager.widget.PagerAdapter pagerAdapter, @androidx.annotation.Nullable androidx.viewpager.widget.PagerAdapter pagerAdapter2) {
            com.google.android.material.tabs.TabLayout tabLayout = com.google.android.material.tabs.TabLayout.this;
            if (tabLayout.viewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.autoRefresh);
            }
        }

        public void setAutoRefresh(boolean z) {
            this.autoRefresh = z;
        }
    }

    @java.lang.Deprecated
    public interface BaseOnTabSelectedListener<T extends com.google.android.material.tabs.TabLayout.Tab> {
        void onTabReselected(T t);

        void onTabSelected(T t);

        void onTabUnselected(T t);
    }

    public @interface LabelVisibility {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener<com.google.android.material.tabs.TabLayout.Tab> {
    }

    public class PagerAdapterObserver extends android.database.DataSetObserver {
        public PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            com.google.android.material.tabs.TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            com.google.android.material.tabs.TabLayout.this.populateFromPagerAdapter();
        }
    }

    public class SlidingTabIndicator extends android.widget.LinearLayout {
        android.animation.ValueAnimator indicatorAnimator;
        private int layoutDirection;
        int selectedPosition;
        float selectionOffset;

        /* renamed from: com.google.android.material.tabs.TabLayout$SlidingTabIndicator$1, reason: invalid class name */
        public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ android.view.View val$currentView;
            final /* synthetic */ android.view.View val$targetView;

            public AnonymousClass1(android.view.View view, android.view.View view2) {
                this.val$currentView = view;
                this.val$targetView = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
                com.google.android.material.tabs.TabLayout.SlidingTabIndicator.this.tweenIndicatorPosition(this.val$currentView, this.val$targetView, valueAnimator.getAnimatedFraction());
            }
        }

        /* renamed from: com.google.android.material.tabs.TabLayout$SlidingTabIndicator$2, reason: invalid class name */
        public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
            final /* synthetic */ int val$position;

            public AnonymousClass2(int i) {
                this.val$position = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.tabs.TabLayout.SlidingTabIndicator.this.selectedPosition = this.val$position;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                com.google.android.material.tabs.TabLayout.SlidingTabIndicator.this.selectedPosition = this.val$position;
            }
        }

        public SlidingTabIndicator(android.content.Context context) {
            super(context);
            this.selectedPosition = -1;
            this.layoutDirection = -1;
            setWillNotDraw(false);
        }

        private void jumpIndicatorToSelectedPosition() {
            android.view.View childAt = getChildAt(this.selectedPosition);
            com.google.android.material.tabs.TabIndicatorInterpolator tabIndicatorInterpolator = com.google.android.material.tabs.TabLayout.this.tabIndicatorInterpolator;
            com.google.android.material.tabs.TabLayout tabLayout = com.google.android.material.tabs.TabLayout.this;
            tabIndicatorInterpolator.setIndicatorBoundsForTab(tabLayout, childAt, tabLayout.tabSelectedIndicator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tweenIndicatorPosition(android.view.View view, android.view.View view2, float f) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.TabIndicatorInterpolator tabIndicatorInterpolator = com.google.android.material.tabs.TabLayout.this.tabIndicatorInterpolator;
                com.google.android.material.tabs.TabLayout tabLayout = com.google.android.material.tabs.TabLayout.this;
                tabIndicatorInterpolator.setIndicatorBoundsForOffset(tabLayout, view, view2, f, tabLayout.tabSelectedIndicator);
            } else {
                android.graphics.drawable.Drawable drawable = com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.getBounds().bottom);
            }
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(this);
        }

        private void updateOrRecreateIndicatorAnimation(boolean z, int i, int i2) {
            android.view.View childAt = getChildAt(this.selectedPosition);
            android.view.View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                jumpIndicatorToSelectedPosition();
                return;
            }
            com.google.android.material.tabs.TabLayout.SlidingTabIndicator.AnonymousClass1 anonymousClass1 = new com.google.android.material.tabs.TabLayout.SlidingTabIndicator.AnonymousClass1(childAt, childAt2);
            if (!z) {
                this.indicatorAnimator.removeAllUpdateListeners();
                this.indicatorAnimator.addUpdateListener(anonymousClass1);
                return;
            }
            android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
            this.indicatorAnimator = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(anonymousClass1);
            valueAnimator.addListener(new com.google.android.material.tabs.TabLayout.SlidingTabIndicator.AnonymousClass2(i));
            valueAnimator.start();
        }

        public void animateIndicatorToPosition(int i, int i2) {
            android.animation.ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            updateOrRecreateIndicatorAnimation(true, i, i2);
        }

        public boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
            int height;
            int height2 = com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.getBounds().height();
            if (height2 < 0) {
                height2 = com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i = com.google.android.material.tabs.TabLayout.this.tabIndicatorGravity;
            if (i == 0) {
                height = getHeight() - height2;
                height2 = getHeight();
            } else if (i != 1) {
                height = 0;
                if (i != 2) {
                    height2 = i != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - height2) / 2;
                height2 = (getHeight() + height2) / 2;
            }
            if (com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.getBounds().width() > 0) {
                android.graphics.Rect bounds = com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.getBounds();
                com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, height, bounds.right, height2);
                com.google.android.material.tabs.TabLayout tabLayout = com.google.android.material.tabs.TabLayout.this;
                android.graphics.drawable.Drawable drawable = tabLayout.tabSelectedIndicator;
                if (tabLayout.tabSelectedIndicatorColor != 0) {
                    drawable = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable);
                    if (android.os.Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(com.google.android.material.tabs.TabLayout.this.tabSelectedIndicatorColor, android.graphics.PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.DrawableCompat.setTint(drawable, com.google.android.material.tabs.TabLayout.this.tabSelectedIndicatorColor);
                    }
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        public float getIndicatorPosition() {
            return this.selectedPosition + this.selectionOffset;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            android.animation.ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                jumpIndicatorToSelectedPosition();
            } else {
                updateOrRecreateIndicatorAnimation(false, this.selectedPosition, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (android.view.View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            com.google.android.material.tabs.TabLayout tabLayout = com.google.android.material.tabs.TabLayout.this;
            boolean z = true;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    android.view.View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = java.lang.Math.max(i3, childAt.getMeasuredWidth());
                    }
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (((int) com.google.android.material.internal.ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    com.google.android.material.tabs.TabLayout tabLayout2 = com.google.android.material.tabs.TabLayout.this;
                    tabLayout2.tabGravity = 0;
                    tabLayout2.updateTabViews(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (android.os.Build.VERSION.SDK_INT >= 23 || this.layoutDirection == i) {
                return;
            }
            requestLayout();
            this.layoutDirection = i;
        }

        public void setIndicatorPositionFromTabPosition(int i, float f) {
            android.animation.ValueAnimator valueAnimator = this.indicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.indicatorAnimator.cancel();
            }
            this.selectedPosition = i;
            this.selectionOffset = f;
            tweenIndicatorPosition(getChildAt(i), getChildAt(this.selectedPosition + 1), this.selectionOffset);
        }

        public void setSelectedIndicatorHeight(int i) {
            android.graphics.Rect bounds = com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.getBounds();
            com.google.android.material.tabs.TabLayout.this.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;

        @androidx.annotation.Nullable
        private java.lang.CharSequence contentDesc;

        @androidx.annotation.Nullable
        private android.view.View customView;

        @androidx.annotation.Nullable
        private android.graphics.drawable.Drawable icon;

        @androidx.annotation.Nullable
        public com.google.android.material.tabs.TabLayout parent;

        @androidx.annotation.Nullable
        private java.lang.Object tag;

        @androidx.annotation.Nullable
        private java.lang.CharSequence text;

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.TabView view;
        private int position = -1;

        @com.google.android.material.tabs.TabLayout.LabelVisibility
        private int labelVisibilityMode = 1;
        private int id = -1;

        @androidx.annotation.Nullable
        public com.google.android.material.badge.BadgeDrawable getBadge() {
            return this.view.getBadge();
        }

        @androidx.annotation.Nullable
        public java.lang.CharSequence getContentDescription() {
            com.google.android.material.tabs.TabLayout.TabView tabView = this.view;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @androidx.annotation.Nullable
        public android.view.View getCustomView() {
            return this.customView;
        }

        @androidx.annotation.Nullable
        public android.graphics.drawable.Drawable getIcon() {
            return this.icon;
        }

        public int getId() {
            return this.id;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.badge.BadgeDrawable getOrCreateBadge() {
            return this.view.getOrCreateBadge();
        }

        public int getPosition() {
            return this.position;
        }

        @com.google.android.material.tabs.TabLayout.LabelVisibility
        public int getTabLabelVisibility() {
            return this.labelVisibilityMode;
        }

        @androidx.annotation.Nullable
        public java.lang.Object getTag() {
            return this.tag;
        }

        @androidx.annotation.Nullable
        public java.lang.CharSequence getText() {
            return this.text;
        }

        public boolean isSelected() {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.position;
            }
            throw new java.lang.IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void removeBadge() {
            this.view.removeBadge();
        }

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.id = -1;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout == null) {
                throw new java.lang.IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.selectTab(this);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setContentDescription(@androidx.annotation.StringRes int i) {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setContentDescription(tabLayout.getResources().getText(i));
            }
            throw new java.lang.IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setContentDescription(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.contentDesc = charSequence;
            updateView();
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setCustomView(@androidx.annotation.LayoutRes int i) {
            return setCustomView(android.view.LayoutInflater.from(this.view.getContext()).inflate(i, (android.view.ViewGroup) this.view, false));
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setCustomView(@androidx.annotation.Nullable android.view.View view) {
            this.customView = view;
            updateView();
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setIcon(@androidx.annotation.DrawableRes int i) {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setIcon(androidx.appcompat.content.res.AppCompatResources.getDrawable(tabLayout.getContext(), i));
            }
            throw new java.lang.IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            this.icon = drawable;
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setId(int i) {
            this.id = i;
            com.google.android.material.tabs.TabLayout.TabView tabView = this.view;
            if (tabView != null) {
                tabView.setId(i);
            }
            return this;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setTabLabelVisibility(@com.google.android.material.tabs.TabLayout.LabelVisibility int i) {
            this.labelVisibilityMode = i;
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                tabLayout.updateTabViews(true);
            }
            updateView();
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT && this.view.hasBadgeDrawable() && this.view.badgeDrawable.isVisible()) {
                this.view.invalidate();
            }
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setTag(@androidx.annotation.Nullable java.lang.Object obj) {
            this.tag = obj;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setText(@androidx.annotation.StringRes int i) {
            com.google.android.material.tabs.TabLayout tabLayout = this.parent;
            if (tabLayout != null) {
                return setText(tabLayout.getResources().getText(i));
            }
            throw new java.lang.IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @androidx.annotation.NonNull
        public com.google.android.material.tabs.TabLayout.Tab setText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            if (android.text.TextUtils.isEmpty(this.contentDesc) && !android.text.TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            updateView();
            return this;
        }

        public void updateView() {
            com.google.android.material.tabs.TabLayout.TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorAnimationMode {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;

        @androidx.annotation.NonNull
        private final java.lang.ref.WeakReference<com.google.android.material.tabs.TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeListener(com.google.android.material.tabs.TabLayout tabLayout) {
            this.tabLayoutRef = new java.lang.ref.WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            com.google.android.material.tabs.TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i3 = this.scrollState;
                tabLayout.setScrollPosition(i, f, i3 != 2 || this.previousScrollState == 1, (i3 == 2 && this.previousScrollState == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            com.google.android.material.tabs.TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.scrollState;
            tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.previousScrollState == 0));
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public final class TabView extends android.widget.LinearLayout {

        @androidx.annotation.Nullable
        private android.view.View badgeAnchorView;

        @androidx.annotation.Nullable
        private com.google.android.material.badge.BadgeDrawable badgeDrawable;

        @androidx.annotation.Nullable
        private android.graphics.drawable.Drawable baseBackgroundDrawable;

        @androidx.annotation.Nullable
        private android.widget.ImageView customIconView;

        @androidx.annotation.Nullable
        private android.widget.TextView customTextView;

        @androidx.annotation.Nullable
        private android.view.View customView;
        private int defaultMaxLines;
        private android.widget.ImageView iconView;
        private com.google.android.material.tabs.TabLayout.Tab tab;
        private android.widget.TextView textView;

        /* renamed from: com.google.android.material.tabs.TabLayout$TabView$1, reason: invalid class name */
        public class AnonymousClass1 implements android.view.View.OnLayoutChangeListener {
            final /* synthetic */ android.view.View val$view;

            public AnonymousClass1(android.view.View view) {
                this.val$view = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.val$view.getVisibility() == 0) {
                    com.google.android.material.tabs.TabLayout.TabView.this.tryUpdateBadgeDrawableBounds(this.val$view);
                }
            }
        }

        public TabView(@androidx.annotation.NonNull android.content.Context context) {
            super(context);
            this.defaultMaxLines = 2;
            updateBackgroundDrawable(context);
            androidx.core.view.ViewCompat.setPaddingRelative(this, com.google.android.material.tabs.TabLayout.this.tabPaddingStart, com.google.android.material.tabs.TabLayout.this.tabPaddingTop, com.google.android.material.tabs.TabLayout.this.tabPaddingEnd, com.google.android.material.tabs.TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!com.google.android.material.tabs.TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            androidx.core.view.ViewCompat.setPointerIcon(this, androidx.core.view.PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void addOnLayoutChangeListener(@androidx.annotation.Nullable android.view.View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new com.google.android.material.tabs.TabLayout.TabView.AnonymousClass1(view));
        }

        private float approximateLineWidth(@androidx.annotation.NonNull android.text.Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private void clipViewToPaddingForBadge(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        @androidx.annotation.NonNull
        private android.widget.FrameLayout createPreApi18BadgeAnchorRoot() {
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(getContext());
            frameLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void drawBackground(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
            android.graphics.drawable.Drawable drawable = this.baseBackgroundDrawable;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.baseBackgroundDrawable.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @androidx.annotation.Nullable
        public com.google.android.material.badge.BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        @androidx.annotation.Nullable
        private android.widget.FrameLayout getCustomParentForBadge(@androidx.annotation.NonNull android.view.View view) {
            if ((view == this.iconView || view == this.textView) && com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
                return (android.widget.FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @androidx.annotation.NonNull
        public com.google.android.material.badge.BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = com.google.android.material.badge.BadgeDrawable.create(getContext());
            }
            tryUpdateBadgeAnchor();
            com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new java.lang.IllegalStateException("Unable to create badge");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasBadgeDrawable() {
            return this.badgeDrawable != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void inflateAndAddDefaultIconView() {
            android.widget.FrameLayout frameLayout;
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
                frameLayout = createPreApi18BadgeAnchorRoot();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            android.widget.ImageView imageView = (android.widget.ImageView) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_icon, (android.view.ViewGroup) frameLayout, false);
            this.iconView = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void inflateAndAddDefaultTextView() {
            android.widget.FrameLayout frameLayout;
            if (com.google.android.material.badge.BadgeUtils.USE_COMPAT_PARENT) {
                frameLayout = createPreApi18BadgeAnchorRoot();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            android.widget.TextView textView = (android.widget.TextView) android.view.LayoutInflater.from(getContext()).inflate(com.google.android.material.R.layout.design_layout_tab_text, (android.view.ViewGroup) frameLayout, false);
            this.textView = textView;
            frameLayout.addView(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeBadge() {
            if (this.badgeAnchorView != null) {
                tryRemoveBadgeFromAnchor();
            }
            this.badgeDrawable = null;
        }

        private void tryAttachBadgeToAnchor(@androidx.annotation.Nullable android.view.View view) {
            if (hasBadgeDrawable() && view != null) {
                clipViewToPaddingForBadge(false);
                com.google.android.material.badge.BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
                this.badgeAnchorView = view;
            }
        }

        private void tryRemoveBadgeFromAnchor() {
            if (hasBadgeDrawable()) {
                clipViewToPaddingForBadge(true);
                android.view.View view = this.badgeAnchorView;
                if (view != null) {
                    com.google.android.material.badge.BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
                    this.badgeAnchorView = null;
                }
            }
        }

        private void tryUpdateBadgeAnchor() {
            com.google.android.material.tabs.TabLayout.Tab tab;
            com.google.android.material.tabs.TabLayout.Tab tab2;
            if (hasBadgeDrawable()) {
                if (this.customView != null) {
                    tryRemoveBadgeFromAnchor();
                    return;
                }
                if (this.iconView != null && (tab2 = this.tab) != null && tab2.getIcon() != null) {
                    android.view.View view = this.badgeAnchorView;
                    android.widget.ImageView imageView = this.iconView;
                    if (view == imageView) {
                        tryUpdateBadgeDrawableBounds(imageView);
                        return;
                    } else {
                        tryRemoveBadgeFromAnchor();
                        tryAttachBadgeToAnchor(this.iconView);
                        return;
                    }
                }
                if (this.textView == null || (tab = this.tab) == null || tab.getTabLabelVisibility() != 1) {
                    tryRemoveBadgeFromAnchor();
                    return;
                }
                android.view.View view2 = this.badgeAnchorView;
                android.widget.TextView textView = this.textView;
                if (view2 == textView) {
                    tryUpdateBadgeDrawableBounds(textView);
                } else {
                    tryRemoveBadgeFromAnchor();
                    tryAttachBadgeToAnchor(this.textView);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tryUpdateBadgeDrawableBounds(@androidx.annotation.NonNull android.view.View view) {
            if (hasBadgeDrawable() && view == this.badgeAnchorView) {
                com.google.android.material.badge.BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public void updateBackgroundDrawable(android.content.Context context) {
            int i = com.google.android.material.tabs.TabLayout.this.tabBackgroundResId;
            if (i != 0) {
                android.graphics.drawable.Drawable drawable = androidx.appcompat.content.res.AppCompatResources.getDrawable(context, i);
                this.baseBackgroundDrawable = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.baseBackgroundDrawable.setState(getDrawableState());
                }
            } else {
                this.baseBackgroundDrawable = null;
            }
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setColor(0);
            if (com.google.android.material.tabs.TabLayout.this.tabRippleColorStateList != null) {
                android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                android.content.res.ColorStateList convertToRippleDrawableColor = com.google.android.material.ripple.RippleUtils.convertToRippleDrawableColor(com.google.android.material.tabs.TabLayout.this.tabRippleColorStateList);
                boolean z = com.google.android.material.tabs.TabLayout.this.unboundedRipple;
                if (z) {
                    gradientDrawable = null;
                }
                gradientDrawable = new android.graphics.drawable.RippleDrawable(convertToRippleDrawableColor, gradientDrawable, z ? null : gradientDrawable2);
            }
            androidx.core.view.ViewCompat.setBackground(this, gradientDrawable);
            com.google.android.material.tabs.TabLayout.this.invalidate();
        }

        private void updateTextAndIcon(@androidx.annotation.Nullable android.widget.TextView textView, @androidx.annotation.Nullable android.widget.ImageView imageView) {
            com.google.android.material.tabs.TabLayout.Tab tab = this.tab;
            android.graphics.drawable.Drawable mutate = (tab == null || tab.getIcon() == null) ? null : androidx.core.graphics.drawable.DrawableCompat.wrap(this.tab.getIcon()).mutate();
            com.google.android.material.tabs.TabLayout.Tab tab2 = this.tab;
            java.lang.CharSequence text = tab2 != null ? tab2.getText() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !android.text.TextUtils.isEmpty(text);
            if (textView != null) {
                if (z) {
                    textView.setText(text);
                    if (this.tab.labelVisibilityMode == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((java.lang.CharSequence) null);
                }
            }
            if (imageView != null) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int dpToPx = (z && imageView.getVisibility() == 0) ? (int) com.google.android.material.internal.ViewUtils.dpToPx(getContext(), 8) : 0;
                if (com.google.android.material.tabs.TabLayout.this.inlineLabel) {
                    if (dpToPx != androidx.core.view.MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, dpToPx);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (dpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = dpToPx;
                    androidx.core.view.MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            com.google.android.material.tabs.TabLayout.Tab tab3 = this.tab;
            java.lang.CharSequence charSequence = tab3 != null ? tab3.contentDesc : null;
            if (android.os.Build.VERSION.SDK_INT > 23) {
                if (!z) {
                    text = charSequence;
                }
                androidx.appcompat.widget.TooltipCompat.setTooltipText(this, text);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            android.graphics.drawable.Drawable drawable = this.baseBackgroundDrawable;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.baseBackgroundDrawable.setState(drawableState);
            }
            if (z) {
                invalidate();
                com.google.android.material.tabs.TabLayout.this.invalidate();
            }
        }

        public int getContentHeight() {
            android.view.View[] viewArr = {this.textView, this.iconView, this.customView};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                android.view.View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? java.lang.Math.min(i2, view.getTop()) : view.getTop();
                    i = z ? java.lang.Math.max(i, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i - i2;
        }

        public int getContentWidth() {
            android.view.View[] viewArr = {this.textView, this.iconView, this.customView};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                android.view.View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? java.lang.Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? java.lang.Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        @androidx.annotation.Nullable
        public com.google.android.material.tabs.TabLayout.Tab getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            com.google.android.material.badge.BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((java.lang.Object) getContentDescription()) + ", " + ((java.lang.Object) this.badgeDrawable.getContentDescription()));
            }
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrap = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(com.google.android.material.R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            android.text.Layout layout;
            int size = android.view.View.MeasureSpec.getSize(i);
            int mode = android.view.View.MeasureSpec.getMode(i);
            int tabMaxWidth = com.google.android.material.tabs.TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = android.view.View.MeasureSpec.makeMeasureSpec(com.google.android.material.tabs.TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.textView != null) {
                float f = com.google.android.material.tabs.TabLayout.this.tabTextSize;
                int i3 = this.defaultMaxLines;
                android.widget.ImageView imageView = this.iconView;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    android.widget.TextView textView = this.textView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = com.google.android.material.tabs.TabLayout.this.tabTextMultiLineSize;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = androidx.core.widget.TextViewCompat.getMaxLines(this.textView);
                if (f != textSize || (maxLines >= 0 && i3 != maxLines)) {
                    if (com.google.android.material.tabs.TabLayout.this.mode == 1 && f > textSize && lineCount == 1 && ((layout = this.textView.getLayout()) == null || approximateLineWidth(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.textView.setTextSize(0, f);
                        this.textView.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.tab.select();
            return true;
        }

        public void reset() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            android.widget.TextView textView = this.textView;
            if (textView != null) {
                textView.setSelected(z);
            }
            android.widget.ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            android.view.View view = this.customView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(@androidx.annotation.Nullable com.google.android.material.tabs.TabLayout.Tab tab) {
            if (tab != this.tab) {
                this.tab = tab;
                update();
            }
        }

        public final void update() {
            com.google.android.material.tabs.TabLayout.Tab tab = this.tab;
            android.graphics.drawable.Drawable drawable = null;
            android.view.View customView = tab != null ? tab.getCustomView() : null;
            if (customView != null) {
                android.view.ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((android.view.ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.customView = customView;
                android.widget.TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                android.widget.ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                android.widget.TextView textView2 = (android.widget.TextView) customView.findViewById(android.R.id.text1);
                this.customTextView = textView2;
                if (textView2 != null) {
                    this.defaultMaxLines = androidx.core.widget.TextViewCompat.getMaxLines(textView2);
                }
                this.customIconView = (android.widget.ImageView) customView.findViewById(android.R.id.icon);
            } else {
                android.view.View view = this.customView;
                if (view != null) {
                    removeView(view);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    inflateAndAddDefaultIconView();
                }
                if (tab != null && tab.getIcon() != null) {
                    drawable = androidx.core.graphics.drawable.DrawableCompat.wrap(tab.getIcon()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.DrawableCompat.setTintList(drawable, com.google.android.material.tabs.TabLayout.this.tabIconTint);
                    android.graphics.PorterDuff.Mode mode = com.google.android.material.tabs.TabLayout.this.tabIconTintMode;
                    if (mode != null) {
                        androidx.core.graphics.drawable.DrawableCompat.setTintMode(drawable, mode);
                    }
                }
                if (this.textView == null) {
                    inflateAndAddDefaultTextView();
                    this.defaultMaxLines = androidx.core.widget.TextViewCompat.getMaxLines(this.textView);
                }
                androidx.core.widget.TextViewCompat.setTextAppearance(this.textView, com.google.android.material.tabs.TabLayout.this.tabTextAppearance);
                android.content.res.ColorStateList colorStateList = com.google.android.material.tabs.TabLayout.this.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView);
                tryUpdateBadgeAnchor();
                addOnLayoutChangeListener(this.iconView);
                addOnLayoutChangeListener(this.textView);
            } else {
                android.widget.TextView textView3 = this.customTextView;
                if (textView3 != null || this.customIconView != null) {
                    updateTextAndIcon(textView3, this.customIconView);
                }
            }
            if (tab != null && !android.text.TextUtils.isEmpty(tab.contentDesc)) {
                setContentDescription(tab.contentDesc);
            }
            setSelected(tab != null && tab.isSelected());
        }

        public final void updateOrientation() {
            setOrientation(!com.google.android.material.tabs.TabLayout.this.inlineLabel ? 1 : 0);
            android.widget.TextView textView = this.customTextView;
            if (textView == null && this.customIconView == null) {
                updateTextAndIcon(this.textView, this.iconView);
            } else {
                updateTextAndIcon(textView, this.customIconView);
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements com.google.android.material.tabs.TabLayout.OnTabSelectedListener {
        private final androidx.viewpager.widget.ViewPager viewPager;

        public ViewPagerOnTabSelectedListener(androidx.viewpager.widget.ViewPager viewPager) {
            this.viewPager = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onTabSelected(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(com.google.android.material.tabs.TabLayout.Tab tab) {
        }
    }

    public TabLayout(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public TabLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.tabStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r4), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        this.tabs = new java.util.ArrayList<>();
        this.tabSelectedIndicator = new android.graphics.drawable.GradientDrawable();
        this.tabSelectedIndicatorColor = 0;
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new java.util.ArrayList<>();
        this.tabViewPool = new androidx.core.util.Pools.SimplePool(12);
        android.content.Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        com.google.android.material.tabs.TabLayout.SlidingTabIndicator slidingTabIndicator = new com.google.android.material.tabs.TabLayout.SlidingTabIndicator(context2);
        this.slidingTabIndicator = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new android.widget.FrameLayout.LayoutParams(-2, -1));
        int[] iArr = com.google.android.material.R.styleable.TabLayout;
        int i3 = com.google.android.material.R.styleable.TabLayout_tabTextAppearance;
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, iArr, i, i2, i3);
        if (getBackground() instanceof android.graphics.drawable.ColorDrawable) {
            android.graphics.drawable.ColorDrawable colorDrawable = (android.graphics.drawable.ColorDrawable) getBackground();
            com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.initializeElevationOverlay(context2);
            materialShapeDrawable.setElevation(androidx.core.view.ViewCompat.getElevation(this));
            androidx.core.view.ViewCompat.setBackground(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(com.google.android.material.resources.MaterialResources.getDrawable(context2, obtainStyledAttributes, com.google.android.material.R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(obtainStyledAttributes.getColor(com.google.android.material.R.styleable.TabLayout_tabIndicatorColor, 0));
        slidingTabIndicator.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPadding, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.tabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
        this.tabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
        this.tabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
        int resourceId = obtainStyledAttributes.getResourceId(i3, com.google.android.material.R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = resourceId;
        android.content.res.TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.tabTextSize = obtainStyledAttributes2.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.tabTextColors = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes2, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes2.recycle();
            int i4 = com.google.android.material.R.styleable.TabLayout_tabTextColor;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.tabTextColors = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, i4);
            }
            int i5 = com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor;
            if (obtainStyledAttributes.hasValue(i5)) {
                this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), obtainStyledAttributes.getColor(i5, 0));
            }
            this.tabIconTint = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.TabLayout_tabIconTint);
            this.tabIconTintMode = com.google.android.material.internal.ViewUtils.parseTintMode(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.tabRippleColorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context2, obtainStyledAttributes, com.google.android.material.R.styleable.TabLayout_tabRippleColor);
            this.tabIndicatorAnimationDuration = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.requestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMinWidth, -1);
            this.requestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMaxWidth, -1);
            this.tabBackgroundResId = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.TabLayout_tabBackground, 0);
            this.contentInsetStart = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabContentStart, 0);
            this.mode = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabMode, 1);
            this.tabGravity = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.TabLayout_tabGravity, 0);
            this.inlineLabel = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.TabLayout_tabInlineLabel, false);
            this.unboundedRipple = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.TabLayout_tabUnboundedRipple, false);
            obtainStyledAttributes.recycle();
            android.content.res.Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } catch (java.lang.Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void addTabFromItemView(@androidx.annotation.NonNull com.google.android.material.tabs.TabItem tabItem) {
        com.google.android.material.tabs.TabLayout.Tab newTab = newTab();
        java.lang.CharSequence charSequence = tabItem.text;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        android.graphics.drawable.Drawable drawable = tabItem.icon;
        if (drawable != null) {
            newTab.setIcon(drawable);
        }
        int i = tabItem.customLayout;
        if (i != 0) {
            newTab.setCustomView(i);
        }
        if (!android.text.TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.setContentDescription(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void addTabView(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
        com.google.android.material.tabs.TabLayout.TabView tabView = tab.view;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.slidingTabIndicator.addView(tabView, tab.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(android.view.View view) {
        if (!(view instanceof com.google.android.material.tabs.TabItem)) {
            throw new java.lang.IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        addTabFromItemView((com.google.android.material.tabs.TabItem) view);
    }

    private void animateToTab(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() == null || !androidx.core.view.ViewCompat.isLaidOut(this) || this.slidingTabIndicator.childrenNeedLayout()) {
            setScrollPosition(i, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
        if (scrollX != calculateScrollXForTab) {
            ensureScrollAnimator();
            this.scrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
            this.scrollAnimator.start();
        }
        this.slidingTabIndicator.animateIndicatorToPosition(i, this.tabIndicatorAnimationDuration);
    }

    private void applyGravityForModeScrollable(int i) {
        if (i != 0) {
            if (i == 1) {
                this.slidingTabIndicator.setGravity(1);
                return;
            } else if (i != 2) {
                return;
            }
        }
        this.slidingTabIndicator.setGravity(androidx.core.view.GravityCompat.START);
    }

    private void applyModeAndGravity() {
        int i = this.mode;
        androidx.core.view.ViewCompat.setPaddingRelative(this.slidingTabIndicator, (i == 0 || i == 2) ? java.lang.Math.max(0, this.contentInsetStart - this.tabPaddingStart) : 0, 0, 0, 0);
        int i2 = this.mode;
        if (i2 == 0) {
            applyGravityForModeScrollable(this.tabGravity);
        } else if (i2 == 1 || i2 == 2) {
            this.slidingTabIndicator.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i, float f) {
        int i2 = this.mode;
        if (i2 != 0 && i2 != 2) {
            return 0;
        }
        android.view.View childAt = this.slidingTabIndicator.getChildAt(i);
        int i3 = i + 1;
        android.view.View childAt2 = i3 < this.slidingTabIndicator.getChildCount() ? this.slidingTabIndicator.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f);
        return androidx.core.view.ViewCompat.getLayoutDirection(this) == 0 ? left + i4 : left - i4;
    }

    private void configureTab(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab, int i) {
        tab.setPosition(i);
        this.tabs.add(i, tab);
        int size = this.tabs.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            } else {
                this.tabs.get(i).setPosition(i);
            }
        }
    }

    @androidx.annotation.NonNull
    private static android.content.res.ColorStateList createColorStateList(int i, int i2) {
        return new android.content.res.ColorStateList(new int[][]{android.widget.HorizontalScrollView.SELECTED_STATE_SET, android.widget.HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    @androidx.annotation.NonNull
    private android.widget.LinearLayout.LayoutParams createLayoutParamsForTabs() {
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    @androidx.annotation.NonNull
    private com.google.android.material.tabs.TabLayout.TabView createTabView(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
        androidx.core.util.Pools.Pool<com.google.android.material.tabs.TabLayout.TabView> pool = this.tabViewPool;
        com.google.android.material.tabs.TabLayout.TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new com.google.android.material.tabs.TabLayout.TabView(getContext());
        }
        acquire.setTab(tab);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (android.text.TextUtils.isEmpty(tab.contentDesc)) {
            acquire.setContentDescription(tab.text);
        } else {
            acquire.setContentDescription(tab.contentDesc);
        }
        return acquire;
    }

    private void dispatchTabReselected(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabReselected(tab);
        }
    }

    private void dispatchTabSelected(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabSelected(tab);
        }
    }

    private void dispatchTabUnselected(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
        for (int size = this.selectedListeners.size() - 1; size >= 0; size--) {
            this.selectedListeners.get(size).onTabUnselected(tab);
        }
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            android.animation.ValueAnimator valueAnimator = new android.animation.ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new com.google.android.material.tabs.TabLayout.AnonymousClass1());
        }
    }

    @androidx.annotation.Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.tabs.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                com.google.android.material.tabs.TabLayout.Tab tab = this.tabs.get(i);
                if (tab != null && tab.getIcon() != null && !android.text.TextUtils.isEmpty(tab.getText())) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return (!z || this.inlineLabel) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i = this.requestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        int i2 = this.mode;
        if (i2 == 0 || i2 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return java.lang.Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i) {
        com.google.android.material.tabs.TabLayout.TabView tabView = (com.google.android.material.tabs.TabLayout.TabView) this.slidingTabIndicator.getChildAt(i);
        this.slidingTabIndicator.removeViewAt(i);
        if (tabView != null) {
            tabView.reset();
            this.tabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i) {
        int childCount = this.slidingTabIndicator.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i2);
                boolean z = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z = false;
                }
                childAt.setActivated(z);
                i2++;
            }
        }
    }

    private void setupWithViewPager(@androidx.annotation.Nullable androidx.viewpager.widget.ViewPager viewPager, boolean z, boolean z2) {
        androidx.viewpager.widget.ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            com.google.android.material.tabs.TabLayout.AdapterChangeListener adapterChangeListener = this.adapterChangeListener;
            if (adapterChangeListener != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener = this.currentVpSelectedListener;
        if (baseOnTabSelectedListener != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            viewPager.addOnPageChangeListener(this.pageChangeListener);
            com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener(viewPager);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener((com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) viewPagerOnTabSelectedListener);
            androidx.viewpager.widget.PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new com.google.android.material.tabs.TabLayout.AdapterChangeListener();
            }
            this.adapterChangeListener.setAutoRefresh(z);
            viewPager.addOnAdapterChangeListener(this.adapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.viewPager = null;
            setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = z2;
    }

    private void updateAllTabs() {
        int size = this.tabs.size();
        for (int i = 0; i < size; i++) {
            this.tabs.get(i).updateView();
        }
    }

    private void updateTabViewLayoutParams(@androidx.annotation.NonNull android.widget.LinearLayout.LayoutParams layoutParams) {
        if (this.mode == 1 && this.tabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    @java.lang.Deprecated
    public void addOnTabSelectedListener(@androidx.annotation.Nullable com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (this.selectedListeners.contains(baseOnTabSelectedListener)) {
            return;
        }
        this.selectedListeners.add(baseOnTabSelectedListener);
    }

    public void addOnTabSelectedListener(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.OnTabSelectedListener onTabSelectedListener) {
        addOnTabSelectedListener((com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void addTab(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
        addTab(tab, this.tabs.isEmpty());
    }

    public void addTab(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab, int i) {
        addTab(tab, i, this.tabs.isEmpty());
    }

    public void addTab(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab, int i, boolean z) {
        if (tab.parent != this) {
            throw new java.lang.IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        configureTab(tab, i);
        addTabView(tab);
        if (z) {
            tab.select();
        }
    }

    public void addTab(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab, boolean z) {
        addTab(tab, this.tabs.size(), z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(android.view.View view) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(android.view.View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public com.google.android.material.tabs.TabLayout.Tab createTabFromPool() {
        com.google.android.material.tabs.TabLayout.Tab acquire = tabPool.acquire();
        return acquire == null ? new com.google.android.material.tabs.TabLayout.Tab() : acquire;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        com.google.android.material.tabs.TabLayout.Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.tabs.TabLayout.Tab getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.tabs.get(i);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.tabs.TabLayout.Tab newTab() {
        com.google.android.material.tabs.TabLayout.Tab createTabFromPool = createTabFromPool();
        createTabFromPool.parent = this;
        createTabFromPool.view = createTabView(createTabFromPool);
        if (createTabFromPool.id != -1) {
            createTabFromPool.view.setId(createTabFromPool.id);
        }
        return createTabFromPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            android.view.ViewParent parent = getParent();
            if (parent instanceof androidx.viewpager.widget.ViewPager) {
                setupWithViewPager((androidx.viewpager.widget.ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
            android.view.View childAt = this.slidingTabIndicator.getChildAt(i);
            if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                ((com.google.android.material.tabs.TabLayout.TabView) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@androidx.annotation.NonNull android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        if (r0 != 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L29;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int round = java.lang.Math.round(com.google.android.material.internal.ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = android.view.View.MeasureSpec.getMode(i2);
        boolean z = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = android.view.View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && android.view.View.MeasureSpec.getSize(i2) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = android.view.View.MeasureSpec.getSize(i);
        if (android.view.View.MeasureSpec.getMode(i) != 0) {
            int i3 = this.requestedTabMaxWidth;
            if (i3 <= 0) {
                i3 = (int) (size - com.google.android.material.internal.ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() != 1) {
            return;
        }
        android.view.View childAt = getChildAt(0);
        int i4 = this.mode;
        if (i4 != 0) {
            if (i4 != 1) {
            }
            if (z) {
                childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), android.view.ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        androidx.viewpager.widget.PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                addTab(newTab().setText(this.pagerAdapter.getPageTitle(i)), false);
            }
            androidx.viewpager.widget.ViewPager viewPager = this.viewPager;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            selectTab(getTabAt(currentItem));
        }
    }

    public boolean releaseFromTabPool(com.google.android.material.tabs.TabLayout.Tab tab) {
        return tabPool.release(tab);
    }

    public void removeAllTabs() {
        for (int childCount = this.slidingTabIndicator.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        java.util.Iterator<com.google.android.material.tabs.TabLayout.Tab> it = this.tabs.iterator();
        while (it.hasNext()) {
            com.google.android.material.tabs.TabLayout.Tab next = it.next();
            it.remove();
            next.reset();
            releaseFromTabPool(next);
        }
        this.selectedTab = null;
    }

    @java.lang.Deprecated
    public void removeOnTabSelectedListener(@androidx.annotation.Nullable com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.selectedListeners.remove(baseOnTabSelectedListener);
    }

    public void removeOnTabSelectedListener(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.OnTabSelectedListener onTabSelectedListener) {
        removeOnTabSelectedListener((com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void removeTab(@androidx.annotation.NonNull com.google.android.material.tabs.TabLayout.Tab tab) {
        if (tab.parent != this) {
            throw new java.lang.IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        removeTabAt(tab.getPosition());
    }

    public void removeTabAt(int i) {
        com.google.android.material.tabs.TabLayout.Tab tab = this.selectedTab;
        int position = tab != null ? tab.getPosition() : 0;
        removeTabViewAt(i);
        com.google.android.material.tabs.TabLayout.Tab remove = this.tabs.remove(i);
        if (remove != null) {
            remove.reset();
            releaseFromTabPool(remove);
        }
        int size = this.tabs.size();
        for (int i2 = i; i2 < size; i2++) {
            this.tabs.get(i2).setPosition(i2);
        }
        if (position == i) {
            selectTab(this.tabs.isEmpty() ? null : this.tabs.get(java.lang.Math.max(0, i - 1)));
        }
    }

    public void selectTab(@androidx.annotation.Nullable com.google.android.material.tabs.TabLayout.Tab tab) {
        selectTab(tab, true);
    }

    public void selectTab(@androidx.annotation.Nullable com.google.android.material.tabs.TabLayout.Tab tab, boolean z) {
        com.google.android.material.tabs.TabLayout.Tab tab2 = this.selectedTab;
        if (tab2 == tab) {
            if (tab2 != null) {
                dispatchTabReselected(tab);
                animateToTab(tab.getPosition());
                return;
            }
            return;
        }
        int position = tab != null ? tab.getPosition() : -1;
        if (z) {
            if ((tab2 == null || tab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.selectedTab = tab;
        if (tab2 != null) {
            dispatchTabUnselected(tab2);
        }
        if (tab != null) {
            dispatchTabSelected(tab);
        }
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        com.google.android.material.shape.MaterialShapeUtils.setElevation(this, f);
    }

    public void setInlineLabel(boolean z) {
        if (this.inlineLabel != z) {
            this.inlineLabel = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                    ((com.google.android.material.tabs.TabLayout.TabView) childAt).updateOrientation();
                }
            }
            applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(@androidx.annotation.BoolRes int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @java.lang.Deprecated
    public void setOnTabSelectedListener(@androidx.annotation.Nullable com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener) {
        com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        if (baseOnTabSelectedListener2 != null) {
            removeOnTabSelectedListener(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            addOnTabSelectedListener(baseOnTabSelectedListener);
        }
    }

    @java.lang.Deprecated
    public void setOnTabSelectedListener(@androidx.annotation.Nullable com.google.android.material.tabs.TabLayout.OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void setPagerAdapter(@androidx.annotation.Nullable androidx.viewpager.widget.PagerAdapter pagerAdapter, boolean z) {
        android.database.DataSetObserver dataSetObserver;
        androidx.viewpager.widget.PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new com.google.android.material.tabs.TabLayout.PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(android.animation.Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    public void setScrollPosition(int i, float f, boolean z, boolean z2) {
        int round = java.lang.Math.round(i + f);
        if (round < 0 || round >= this.slidingTabIndicator.getChildCount()) {
            return;
        }
        if (z2) {
            this.slidingTabIndicator.setIndicatorPositionFromTabPosition(i, f);
        }
        android.animation.ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.scrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i, f), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void setSelectedTabIndicator(@androidx.annotation.DrawableRes int i) {
        if (i != 0) {
            setSelectedTabIndicator(androidx.appcompat.content.res.AppCompatResources.getDrawable(getContext(), i));
        } else {
            setSelectedTabIndicator((android.graphics.drawable.Drawable) null);
        }
    }

    public void setSelectedTabIndicator(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (this.tabSelectedIndicator != drawable) {
            if (drawable == null) {
                drawable = new android.graphics.drawable.GradientDrawable();
            }
            this.tabSelectedIndicator = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@androidx.annotation.ColorInt int i) {
        this.tabSelectedIndicatorColor = i;
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.tabIndicatorGravity != i) {
            this.tabIndicatorGravity = i;
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        }
    }

    @java.lang.Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(i);
    }

    public void setTabGravity(int i) {
        if (this.tabGravity != i) {
            this.tabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            updateAllTabs();
        }
    }

    public void setTabIconTintResource(@androidx.annotation.ColorRes int i) {
        setTabIconTint(androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.tabIndicatorAnimationMode = i;
        if (i == 0) {
            this.tabIndicatorInterpolator = new com.google.android.material.tabs.TabIndicatorInterpolator();
        } else {
            if (i == 1) {
                this.tabIndicatorInterpolator = new com.google.android.material.tabs.ElasticTabIndicatorInterpolator();
                return;
            }
            throw new java.lang.IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.tabIndicatorFullWidth = z;
        androidx.core.view.ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMode(int i) {
        if (i != this.mode) {
            this.mode = i;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                    ((com.google.android.material.tabs.TabLayout.TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@androidx.annotation.ColorRes int i) {
        setTabRippleColor(androidx.appcompat.content.res.AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }

    public void setTabTextColors(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @java.lang.Deprecated
    public void setTabsFromPagerAdapter(@androidx.annotation.Nullable androidx.viewpager.widget.PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.unboundedRipple != z) {
            this.unboundedRipple = z;
            for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
                android.view.View childAt = this.slidingTabIndicator.getChildAt(i);
                if (childAt instanceof com.google.android.material.tabs.TabLayout.TabView) {
                    ((com.google.android.material.tabs.TabLayout.TabView) childAt).updateBackgroundDrawable(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@androidx.annotation.BoolRes int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(@androidx.annotation.Nullable androidx.viewpager.widget.ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(@androidx.annotation.Nullable androidx.viewpager.widget.ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public void updateTabViews(boolean z) {
        for (int i = 0; i < this.slidingTabIndicator.getChildCount(); i++) {
            android.view.View childAt = this.slidingTabIndicator.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((android.widget.LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }
}
