package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends android.widget.HorizontalScrollView {
    private static final int[] ATTRS = {android.R.attr.textSize, android.R.attr.textColor};
    private static final int TAB_DIVIDER_LINT = 1;
    private int currentPosition;
    private float currentPositionOffset;
    private android.widget.LinearLayout.LayoutParams defaultTabLayoutParams;
    public androidx.viewpager.widget.ViewPager.OnPageChangeListener delegatePageListener;
    private int dividerColor;
    private int dividerPadding;
    private android.graphics.Paint dividerPaint;
    private int dividerWidth;
    private android.widget.LinearLayout.LayoutParams expandedTabLayoutParams;
    private int indicatorColor;
    private int indicatorHeight;
    private int lastScrollX;
    private java.util.Locale locale;
    private android.content.Context mContext;
    private final com.aliyun.svideo.base.widget.PagerSlidingTabStrip.PageListener pageListener;
    private androidx.viewpager.widget.ViewPager pager;
    private android.graphics.Paint rectPaint;
    private int scrollOffset;
    private boolean shouldExpand;
    private int tabBackgroundResId;
    private com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabClickListener tabClickListener;
    private int tabCount;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;
    private android.graphics.Typeface tabTypeface;
    private int tabTypefaceStyle;
    private int tabViewId;
    private android.widget.LinearLayout tabsContainer;
    private boolean textAllCaps;
    private int underlineColor;
    private int underlineHeight;

    /* renamed from: com.aliyun.svideo.base.widget.PagerSlidingTabStrip$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ int val$position;

        public AnonymousClass1(int i) {
            this.val$position = i;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.pager.setCurrentItem(this.val$position);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface IconTabProvider {
        int getPageIconResId(int i);
    }

    public class PageListener implements androidx.viewpager.widget.ViewPager.OnPageChangeListener {
        private PageListener() {
        }

        public /* synthetic */ PageListener(com.aliyun.svideo.base.widget.PagerSlidingTabStrip pagerSlidingTabStrip, defpackage.kx1 kx1Var) {
            this();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                com.aliyun.svideo.base.widget.PagerSlidingTabStrip pagerSlidingTabStrip = com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(pagerSlidingTabStrip.pager.getCurrentItem(), 0);
            }
            androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener = com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.currentPosition = i;
            com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.currentPositionOffset = f;
            com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.scrollToChild(i, (int) (r0.tabsContainer.getChildAt(i).getWidth() * f));
            com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.invalidate();
            androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener = com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener = com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
            com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.updateTabStyles(i);
        }
    }

    public static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState> CREATOR = new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState.AnonymousClass1();
        int currentPosition;

        /* renamed from: com.aliyun.svideo.base.widget.PagerSlidingTabStrip$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState[] newArray(int i) {
                return new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState[i];
            }
        }

        private SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        public /* synthetic */ SavedState(android.os.Parcel parcel, defpackage.lx1 lx1Var) {
            this(parcel);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }

    public interface TabClickListener {
        void onTabClickListener(int i);

        void onTabDoubleClickListener(int i);
    }

    public class TabView {
        private final android.view.View _Root;
        private final android.widget.TextView title;

        /* renamed from: com.aliyun.svideo.base.widget.PagerSlidingTabStrip$TabView$1, reason: invalid class name */
        public class AnonymousClass1 extends android.view.GestureDetector.SimpleOnGestureListener {
            final /* synthetic */ int val$id;
            final /* synthetic */ com.aliyun.svideo.base.widget.PagerSlidingTabStrip val$this$0;

            public AnonymousClass1(com.aliyun.svideo.base.widget.PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
                this.val$this$0 = pagerSlidingTabStrip;
                this.val$id = i;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
                if (com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.tabClickListener != null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("id");
                    sb.append(this.val$id);
                    com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.tabClickListener.onTabClickListener(this.val$id);
                }
                return super.onSingleTapUp(motionEvent);
            }
        }

        /* renamed from: com.aliyun.svideo.base.widget.PagerSlidingTabStrip$TabView$2, reason: invalid class name */
        public class AnonymousClass2 implements android.view.View.OnTouchListener {
            final /* synthetic */ androidx.core.view.GestureDetectorCompat val$gesture;
            final /* synthetic */ com.aliyun.svideo.base.widget.PagerSlidingTabStrip val$this$0;

            public AnonymousClass2(com.aliyun.svideo.base.widget.PagerSlidingTabStrip pagerSlidingTabStrip, androidx.core.view.GestureDetectorCompat gestureDetectorCompat) {
                this.val$this$0 = pagerSlidingTabStrip;
                this.val$gesture = gestureDetectorCompat;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                this.val$gesture.onTouchEvent(motionEvent);
                return false;
            }
        }

        public TabView(android.view.ViewGroup viewGroup, int i) {
            android.view.View inflate = android.view.View.inflate(viewGroup.getContext(), com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this.tabViewId, null);
            this._Root = inflate;
            inflate.setTag(this);
            this.title = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.base.R.id.aliyun_tv_title);
            inflate.setOnTouchListener(new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView.AnonymousClass2(com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this, new androidx.core.view.GestureDetectorCompat(inflate.getContext(), new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView.AnonymousClass1(com.aliyun.svideo.base.widget.PagerSlidingTabStrip.this, i))));
        }

        public android.view.View getView() {
            return this._Root;
        }
    }

    public PagerSlidingTabStrip(android.content.Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pageListener = new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.PageListener(this, null);
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0f;
        this.shouldExpand = false;
        this.textAllCaps = true;
        this.scrollOffset = 52;
        this.indicatorHeight = 4;
        this.underlineHeight = 1;
        this.dividerPadding = 16;
        this.tabPadding = 2;
        this.dividerWidth = 0;
        this.tabTextSize = 36;
        this.tabTypeface = null;
        this.tabTypefaceStyle = 0;
        this.lastScrollX = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        this.mContext = context;
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.scrollOffset = (int) android.util.TypedValue.applyDimension(1, this.scrollOffset, displayMetrics);
        this.indicatorHeight = (int) android.util.TypedValue.applyDimension(1, this.indicatorHeight, displayMetrics);
        this.underlineHeight = (int) android.util.TypedValue.applyDimension(1, this.underlineHeight, displayMetrics);
        this.dividerPadding = (int) android.util.TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) android.util.TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) android.util.TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.tabTextSize = (int) android.util.TypedValue.applyDimension(2, this.tabTextSize, displayMetrics);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        android.content.res.TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip);
        this.indicatorColor = obtainStyledAttributes2.getColor(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsIndicatorColor, this.indicatorColor);
        this.underlineColor = obtainStyledAttributes2.getColor(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsUnderlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsDividerColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsIndicatorHeight, this.indicatorHeight);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsUnderlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsDividerPadding, this.dividerPadding);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsTabPaddingLeftRight, this.tabPadding);
        this.tabBackgroundResId = obtainStyledAttributes2.getResourceId(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsTabBackground, this.tabBackgroundResId);
        this.shouldExpand = obtainStyledAttributes2.getBoolean(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsShouldExpand, this.shouldExpand);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsScrollOffset, this.scrollOffset);
        this.textAllCaps = obtainStyledAttributes2.getBoolean(com.aliyun.svideo.base.R.styleable.QuViewPagerSlidingTabStrip_pstsTextAllCaps, this.textAllCaps);
        obtainStyledAttributes2.recycle();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.dividerPaint = paint2;
        paint2.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth(this.dividerWidth);
        this.defaultTabLayoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        this.expandedTabLayoutParams = new android.widget.LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    private void addIconTab(int i, int i2) {
        android.widget.ImageButton imageButton = new android.widget.ImageButton(getContext());
        imageButton.setImageResource(i2);
        addTab(i, imageButton);
    }

    private void addTab(int i, android.view.View view) {
        view.setFocusable(true);
        view.setOnClickListener(new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.AnonymousClass1(i));
        int i2 = this.tabPadding;
        view.setPadding(i2, 0, i2, 0);
        this.tabsContainer.addView(view, i, this.shouldExpand ? this.expandedTabLayoutParams : this.defaultTabLayoutParams);
    }

    private void addTabWithIcon(int i, java.lang.CharSequence charSequence, int i2) {
        com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView tabView = new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView(this.tabsContainer, i);
        tabView.title.setText(charSequence);
        tabView.title.setGravity(17);
        if (i2 != 0) {
            tabView.title.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
            tabView.title.setCompoundDrawablePadding(com.aliyun.common.utils.DensityUtil.dip2px(this.mContext, 5.0f));
        }
        addTab(i, tabView.getView());
    }

    private void addTextTab(int i, java.lang.String str) {
        com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView tabView = new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView(this.tabsContainer, i);
        tabView.title.setText(str);
        tabView.title.setGravity(17);
        addTab(i, tabView.getView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.tabCount == 0) {
            return;
        }
        int left = this.tabsContainer.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.scrollOffset;
        }
        if (left != this.lastScrollX) {
            this.lastScrollX = left;
            scrollTo(left, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles(int i) {
        for (int i2 = 0; i2 < this.tabCount; i2++) {
            android.view.View childAt = this.tabsContainer.getChildAt(i2);
            childAt.setBackgroundResource(this.tabBackgroundResId);
            if (childAt instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) childAt;
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.tabTypeface, this.tabTypefaceStyle);
                textView.setTextColor(this.tabTextColor);
                if (this.textAllCaps) {
                    textView.setAllCaps(true);
                }
            } else {
                java.lang.Object tag = childAt.getTag();
                if (tag != null && (tag instanceof com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView)) {
                    com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView tabView = (com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabView) tag;
                    if (i2 == i) {
                        tabView.title.setSelected(true);
                    } else {
                        tabView.title.setSelected(false);
                    }
                    if (this.textAllCaps) {
                        tabView.title.setAllCaps(true);
                    }
                }
            }
        }
    }

    public int getDividerColor() {
        return this.dividerColor;
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public int getTabBackground() {
        return this.tabBackgroundResId;
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public int getTextColor() {
        return this.tabTextColor;
    }

    public int getTextSize() {
        return this.tabTextSize;
    }

    public int getUnderlineColor() {
        return this.underlineColor;
    }

    public int getUnderlineHeight() {
        return this.underlineHeight;
    }

    public boolean isTextAllCaps() {
        return this.textAllCaps;
    }

    public void notifyDataSetChanged() {
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();
        for (int i = 0; i < this.tabCount; i++) {
            java.lang.CharSequence pageTitle = this.pager.getAdapter().getPageTitle(i);
            if (this.pager.getAdapter() instanceof com.aliyun.svideo.base.widget.PagerSlidingTabStrip.IconTabProvider) {
                addTabWithIcon(i, pageTitle, ((com.aliyun.svideo.base.widget.PagerSlidingTabStrip.IconTabProvider) this.pager.getAdapter()).getPageIconResId(i));
            } else {
                addTextTab(i, pageTitle.toString());
            }
        }
        updateTabStyles(this.currentPosition);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.tabCount <= 1) {
            return;
        }
        int height = getHeight();
        android.view.View childAt = this.tabsContainer.getChildAt(this.currentPosition);
        int width = childAt.getWidth() / 3;
        float left = childAt.getLeft() + width;
        float right = childAt.getRight() - width;
        if (this.currentPositionOffset > 0.0f && (i = this.currentPosition) < this.tabCount - 1) {
            android.view.View childAt2 = this.tabsContainer.getChildAt(i + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f = this.currentPositionOffset;
            float f2 = width;
            left = (left2 * f) + ((1.0f - f) * left) + f2;
            right = ((right2 * f) + ((1.0f - f) * right)) - f2;
        }
        this.rectPaint.setColor(this.underlineColor);
        this.rectPaint.setColor(this.indicatorColor);
        canvas.drawRoundRect(new android.graphics.RectF(left + 0.0f, height - this.indicatorHeight, right - 0.0f, height), 5.0f, 5.0f, this.rectPaint);
        this.dividerPaint.setColor(this.dividerColor);
        for (int i2 = 0; i2 < this.tabCount - 1; i2++) {
            android.view.View childAt3 = this.tabsContainer.getChildAt(i2);
            canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.dividerPaint);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState savedState = (com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState savedState = new com.aliyun.svideo.base.widget.PagerSlidingTabStrip.SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    public void setAllCaps(boolean z) {
        this.textAllCaps = z;
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.dividerColor = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.indicatorColor = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.indicatorColor = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setOnPageChangeListener(androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener) {
        this.delegatePageListener = onPageChangeListener;
    }

    public void setScrollOffset(int i) {
        this.scrollOffset = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.shouldExpand = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.tabBackgroundResId = i;
    }

    public void setTabClickListener(com.aliyun.svideo.base.widget.PagerSlidingTabStrip.TabClickListener tabClickListener) {
        this.tabClickListener = tabClickListener;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles(this.currentPosition);
    }

    public void setTabViewId(int i) {
        this.tabViewId = i;
    }

    public void setTextColor(int i) {
        this.tabTextColor = i;
        updateTabStyles(this.currentPosition);
    }

    public void setTextColorResource(int i) {
        this.tabTextColor = getResources().getColor(i);
        updateTabStyles(this.currentPosition);
    }

    public void setTextSize(int i) {
        this.tabTextSize = i;
        updateTabStyles(this.currentPosition);
    }

    public void setTypeface(android.graphics.Typeface typeface, int i) {
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = i;
        updateTabStyles(this.currentPosition);
    }

    public void setUnderlineColor(int i) {
        this.underlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.underlineColor = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.underlineHeight = i;
        invalidate();
    }

    public void setViewPager(androidx.viewpager.widget.ViewPager viewPager) {
        this.pager = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new java.lang.IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.pageListener);
        notifyDataSetChanged();
    }
}
