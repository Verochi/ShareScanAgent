package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class AlivcPopupView {
    protected com.aliyun.svideo.base.widget.AlivcPopupView.ContentView contentView;
    private android.content.Context context;
    protected int mArrowCenter;
    protected android.widget.ImageView mArrowDown;
    protected android.view.WindowManager mWindowManager;
    protected android.widget.PopupWindow popupWindow;
    protected android.view.View rootView;
    protected int mWindowHeight = 0;
    protected int mWindowWidth = 0;
    protected int mX = -1;
    protected int mY = -1;
    protected android.graphics.Point mScreenSize = new android.graphics.Point();

    /* renamed from: com.aliyun.svideo.base.widget.AlivcPopupView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnAttachStateChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(android.view.View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(android.view.View view) {
            android.widget.PopupWindow popupWindow = com.aliyun.svideo.base.widget.AlivcPopupView.this.popupWindow;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            com.aliyun.svideo.base.widget.AlivcPopupView.this.popupWindow.dismiss();
        }
    }

    /* renamed from: com.aliyun.svideo.base.widget.AlivcPopupView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.widget.PopupWindow.OnDismissListener {
        public AnonymousClass2() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            com.aliyun.svideo.base.widget.AlivcPopupView.this.popupWindow.dismiss();
        }
    }

    public class ContentView extends android.view.ViewGroup {
        public ContentView(android.content.Context context) {
            super(context);
        }

        public ContentView(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.ViewGroup
        public void addView(android.view.View view) {
            if (getChildCount() > 0) {
                throw new java.lang.RuntimeException("only support one child");
            }
            super.addView(view);
        }

        @Override // android.view.View
        public void onConfigurationChanged(android.content.res.Configuration configuration) {
            android.widget.PopupWindow popupWindow = com.aliyun.svideo.base.widget.AlivcPopupView.this.popupWindow;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            com.aliyun.svideo.base.widget.AlivcPopupView.this.popupWindow.dismiss();
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            if (getChildCount() == 0) {
                return;
            }
            android.view.View childAt = getChildAt(0);
            childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
        }

        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            if (getChildCount() == 0) {
                setMeasuredDimension(0, 0);
            }
            int size = android.view.View.MeasureSpec.getSize(i2);
            int makeWidthMeasureSpec = com.aliyun.svideo.base.widget.AlivcPopupView.this.makeWidthMeasureSpec();
            int makeHeightMeasureSpec = com.aliyun.svideo.base.widget.AlivcPopupView.this.makeHeightMeasureSpec();
            int size2 = android.view.View.MeasureSpec.getSize(makeHeightMeasureSpec);
            int mode = android.view.View.MeasureSpec.getMode(makeHeightMeasureSpec);
            if (size < size2) {
                makeHeightMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(size, mode);
            }
            android.view.View childAt = getChildAt(0);
            childAt.measure(makeWidthMeasureSpec, makeHeightMeasureSpec);
            com.aliyun.svideo.base.widget.AlivcPopupView.this.mWindowWidth = childAt.getMeasuredWidth();
            com.aliyun.svideo.base.widget.AlivcPopupView.this.mWindowHeight = childAt.getMeasuredHeight();
            com.aliyun.svideo.base.widget.AlivcPopupView alivcPopupView = com.aliyun.svideo.base.widget.AlivcPopupView.this;
            setMeasuredDimension(alivcPopupView.mWindowWidth, alivcPopupView.mWindowHeight);
        }
    }

    public AlivcPopupView(android.content.Context context) {
        this.context = context;
        this.popupWindow = new android.widget.PopupWindow(this.context);
        this.mWindowManager = (android.view.WindowManager) this.context.getSystemService("window");
    }

    private void calculatePosition(android.view.View view) {
        if (view == null) {
            throw new java.lang.IllegalStateException("setContentView was not called with a view to display.");
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = iArr[0] + (view.getWidth() / 2);
        this.mArrowCenter = width;
        if (width < this.mScreenSize.x / 2) {
            this.mX = width - (this.mWindowWidth / 2);
        } else {
            this.mX = width - (this.mWindowWidth / 2);
        }
        this.mY = iArr[1] - this.mWindowHeight;
    }

    public static int getHeight(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.view.WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getWidth(android.content.Context context) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.view.WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private void measureWindowSize() {
        this.rootView.measure(makeWidthMeasureSpec(), makeHeightMeasureSpec());
        this.mWindowWidth = this.rootView.getMeasuredWidth();
        this.mWindowHeight = this.rootView.getMeasuredHeight();
    }

    private void showArrow() {
        int measuredWidth = this.mArrowDown.getMeasuredWidth();
        ((android.view.ViewGroup.MarginLayoutParams) this.mArrowDown.getLayoutParams()).leftMargin = (this.mArrowCenter - this.mX) + (measuredWidth / 2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParam(int i, int i2) {
        return new android.widget.FrameLayout.LayoutParams(i, i2);
    }

    @androidx.annotation.LayoutRes
    public int getRootLayout() {
        return com.aliyun.svideo.base.R.layout.alivc_popup_layout;
    }

    public int makeHeightMeasureSpec() {
        return android.view.View.MeasureSpec.makeMeasureSpec(getHeight(this.context), Integer.MIN_VALUE);
    }

    public int makeWidthMeasureSpec() {
        return android.view.View.MeasureSpec.makeMeasureSpec(getWidth(this.context), Integer.MIN_VALUE);
    }

    public android.graphics.Point onShowBegin(android.view.View view) {
        calculatePosition(view);
        showArrow();
        return new android.graphics.Point(this.mX, this.mY);
    }

    public void onShowConfig() {
        if (this.contentView == null) {
            throw new java.lang.IllegalStateException("setContentView was not called with a view to display.");
        }
        this.popupWindow.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        this.popupWindow.setWidth(-2);
        this.popupWindow.setHeight(-2);
        this.popupWindow.setTouchable(true);
        this.popupWindow.setFocusable(true);
        this.popupWindow.setOutsideTouchable(true);
        this.popupWindow.setContentView(this.contentView);
        this.mWindowManager.getDefaultDisplay().getSize(this.mScreenSize);
    }

    public void setContentView(android.view.View view) {
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) android.view.LayoutInflater.from(this.context).inflate(getRootLayout(), (android.view.ViewGroup) null, false);
        this.mArrowDown = (android.widget.ImageView) linearLayout.findViewById(com.aliyun.svideo.base.R.id.arrow_down);
        ((android.widget.FrameLayout) linearLayout.findViewById(com.aliyun.svideo.base.R.id.content_layout)).addView(view);
        if (view == null) {
            throw new java.lang.IllegalStateException("call setContentView view can not be null");
        }
        com.aliyun.svideo.base.widget.AlivcPopupView.ContentView contentView = new com.aliyun.svideo.base.widget.AlivcPopupView.ContentView(this.context);
        this.contentView = contentView;
        contentView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        this.rootView = linearLayout;
        this.contentView.addView(linearLayout);
        this.popupWindow.setContentView(this.contentView);
        this.popupWindow.setOnDismissListener(new com.aliyun.svideo.base.widget.AlivcPopupView.AnonymousClass2());
    }

    public final void show(android.view.View view) {
        show(view, view);
    }

    public final void show(android.view.View view, android.view.View view2) {
        if (androidx.core.view.ViewCompat.isAttachedToWindow(view2)) {
            onShowConfig();
            if (this.mWindowWidth == 0 || this.mWindowHeight == 0) {
                measureWindowSize();
            }
            android.graphics.Point onShowBegin = onShowBegin(view2);
            this.popupWindow.showAtLocation(view, 0, onShowBegin.x, onShowBegin.y);
            view.addOnAttachStateChangeListener(new com.aliyun.svideo.base.widget.AlivcPopupView.AnonymousClass1());
        }
    }
}
