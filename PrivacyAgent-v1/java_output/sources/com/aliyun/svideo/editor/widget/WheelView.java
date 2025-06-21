package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class WheelView extends android.widget.ScrollView {
    public static final int OFF_SET_DEFAULT = 1;
    private static final int SCROLL_DIRECTION_DOWN = 1;
    private static final int SCROLL_DIRECTION_UP = 0;
    public static final java.lang.String TAG = "WheelView";
    private android.content.Context context;
    int displayItemCount;
    int initialY;
    int itemHeight;
    java.util.List<com.aliyun.svideo.editor.widget.WheelView.DataModel> items;
    int newCheck;
    int offset;
    private com.aliyun.svideo.editor.widget.WheelView.OnWheelViewListener onWheelViewListener;
    android.graphics.Paint paint;
    private int scrollDirection;
    java.lang.Runnable scrollerTask;
    int[] selectedAreaBorder;
    int selectedIndex;
    int viewWidth;
    private android.widget.LinearLayout views;

    /* renamed from: com.aliyun.svideo.editor.widget.WheelView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.widget.WheelView.DataModel {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.widget.WheelView.DataModel
        public java.lang.String getText() {
            return "";
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.WheelView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.svideo.editor.widget.WheelView.DataModel {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideo.editor.widget.WheelView.DataModel
        public java.lang.String getText() {
            return "";
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.WheelView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {

        /* renamed from: com.aliyun.svideo.editor.widget.WheelView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ int val$divided;
            final /* synthetic */ int val$remainder;

            public AnonymousClass1(int i, int i2) {
                this.val$remainder = i;
                this.val$divided = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.widget.WheelView wheelView = com.aliyun.svideo.editor.widget.WheelView.this;
                wheelView.smoothScrollTo(0, (wheelView.initialY - this.val$remainder) + wheelView.itemHeight);
                com.aliyun.svideo.editor.widget.WheelView wheelView2 = com.aliyun.svideo.editor.widget.WheelView.this;
                wheelView2.selectedIndex = this.val$divided + wheelView2.offset + 1;
                wheelView2.onSeletedCallBack();
            }
        }

        /* renamed from: com.aliyun.svideo.editor.widget.WheelView$3$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ int val$divided;
            final /* synthetic */ int val$remainder;

            public AnonymousClass2(int i, int i2) {
                this.val$remainder = i;
                this.val$divided = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideo.editor.widget.WheelView wheelView = com.aliyun.svideo.editor.widget.WheelView.this;
                wheelView.smoothScrollTo(0, wheelView.initialY - this.val$remainder);
                com.aliyun.svideo.editor.widget.WheelView wheelView2 = com.aliyun.svideo.editor.widget.WheelView.this;
                wheelView2.selectedIndex = this.val$divided + wheelView2.offset;
                wheelView2.onSeletedCallBack();
            }
        }

        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int scrollY = com.aliyun.svideo.editor.widget.WheelView.this.getScrollY();
            com.aliyun.svideo.editor.widget.WheelView wheelView = com.aliyun.svideo.editor.widget.WheelView.this;
            int i = wheelView.initialY;
            if (i - scrollY != 0) {
                wheelView.initialY = wheelView.getScrollY();
                com.aliyun.svideo.editor.widget.WheelView wheelView2 = com.aliyun.svideo.editor.widget.WheelView.this;
                wheelView2.postDelayed(wheelView2.scrollerTask, wheelView2.newCheck);
                return;
            }
            int i2 = wheelView.itemHeight;
            int i3 = i % i2;
            int i4 = i / i2;
            if (i3 == 0) {
                wheelView.selectedIndex = i4 + wheelView.offset;
                wheelView.onSeletedCallBack();
            } else if (i3 > i2 / 2) {
                wheelView.post(new com.aliyun.svideo.editor.widget.WheelView.AnonymousClass3.AnonymousClass1(i3, i4));
            } else {
                wheelView.post(new com.aliyun.svideo.editor.widget.WheelView.AnonymousClass3.AnonymousClass2(i3, i4));
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.WheelView$4, reason: invalid class name */
    public class AnonymousClass4 extends android.graphics.drawable.Drawable {
        public AnonymousClass4() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            float f = com.aliyun.svideo.editor.widget.WheelView.this.obtainSelectedAreaBorder()[0];
            com.aliyun.svideo.editor.widget.WheelView wheelView = com.aliyun.svideo.editor.widget.WheelView.this;
            canvas.drawLine(0.0f, f, wheelView.viewWidth, wheelView.obtainSelectedAreaBorder()[0], com.aliyun.svideo.editor.widget.WheelView.this.paint);
            float f2 = com.aliyun.svideo.editor.widget.WheelView.this.obtainSelectedAreaBorder()[1];
            com.aliyun.svideo.editor.widget.WheelView wheelView2 = com.aliyun.svideo.editor.widget.WheelView.this;
            canvas.drawLine(0.0f, f2, wheelView2.viewWidth, wheelView2.obtainSelectedAreaBorder()[1], com.aliyun.svideo.editor.widget.WheelView.this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        @android.annotation.SuppressLint({"WrongConstant"})
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.WheelView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ int val$p;

        public AnonymousClass5(int i) {
            this.val$p = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.widget.WheelView wheelView = com.aliyun.svideo.editor.widget.WheelView.this;
            wheelView.scrollTo(0, this.val$p * wheelView.itemHeight);
        }
    }

    public interface DataModel {
        java.lang.String getText();
    }

    public static class OnWheelViewListener {
        public void onSelected(int i, java.lang.String str) {
        }
    }

    public WheelView(android.content.Context context) {
        super(context);
        this.offset = 1;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.itemHeight = 0;
        this.scrollDirection = -1;
        init(context);
    }

    public WheelView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offset = 1;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.itemHeight = 0;
        this.scrollDirection = -1;
        init(context);
    }

    public WheelView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offset = 1;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.itemHeight = 0;
        this.scrollDirection = -1;
        init(context);
    }

    private android.widget.TextView createView(java.lang.String str, int i, int i2) {
        android.widget.TextView textView = new android.widget.TextView(this.context);
        textView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 18.0f);
        textView.setText(str);
        textView.setGravity(17);
        int dip2px = dip2px(12.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        if (this.itemHeight == 0) {
            this.itemHeight = getViewMeasuredHeight(textView);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("itemHeight: ");
            sb.append(this.itemHeight);
            this.views.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, this.itemHeight * this.displayItemCount));
            setLayoutParams(new android.widget.LinearLayout.LayoutParams(((android.widget.LinearLayout.LayoutParams) getLayoutParams()).width, this.itemHeight * this.displayItemCount));
        }
        return textView;
    }

    private int dip2px(float f) {
        return (int) ((f * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int getViewMeasuredHeight(android.view.View view) {
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }

    private void init(android.content.Context context) {
        this.context = context;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("parent: ");
        sb.append(getParent());
        setVerticalScrollBarEnabled(false);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        this.views = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.views);
        this.scrollerTask = new com.aliyun.svideo.editor.widget.WheelView.AnonymousClass3();
    }

    private void initData() {
        this.displayItemCount = (this.offset * 2) + 1;
        for (int i = 0; i < this.items.size(); i++) {
            this.views.addView(createView(this.items.get(i).getText(), i, this.displayItemCount));
        }
        refreshItemView(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] obtainSelectedAreaBorder() {
        if (this.selectedAreaBorder == null) {
            this.selectedAreaBorder = new int[]{r1 * r2, r1 * (r2 + 1)};
            int i = this.itemHeight;
            int i2 = this.offset;
        }
        return this.selectedAreaBorder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeletedCallBack() {
        com.aliyun.svideo.editor.widget.WheelView.OnWheelViewListener onWheelViewListener = this.onWheelViewListener;
        if (onWheelViewListener != null) {
            int i = this.selectedIndex;
            onWheelViewListener.onSelected(i - this.offset, this.items.get(i).getText());
        }
    }

    private void refreshItemView(int i) {
        int i2 = this.itemHeight;
        int i3 = this.offset;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.views.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            android.widget.TextView textView = (android.widget.TextView) this.views.getChildAt(i7);
            if (textView == null) {
                return;
            }
            if (i4 == i7) {
                textView.setTextColor(android.graphics.Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(android.graphics.Color.parseColor("#bbbbbb"));
            }
        }
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    public int getOffset() {
        return this.offset;
    }

    public com.aliyun.svideo.editor.widget.WheelView.OnWheelViewListener getOnWheelViewListener() {
        return this.onWheelViewListener;
    }

    public int getSeletedIndex() {
        return this.selectedIndex - this.offset;
    }

    public java.lang.String getSeletedItem() {
        return this.items.get(this.selectedIndex).getText();
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        refreshItemView(i2);
        if (i2 > i4) {
            this.scrollDirection = 1;
        } else {
            this.scrollDirection = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("w: ");
        sb.append(i);
        sb.append(", h: ");
        sb.append(i2);
        sb.append(", oldw: ");
        sb.append(i3);
        sb.append(", oldh: ");
        sb.append(i4);
        this.viewWidth = i;
        setBackgroundDrawable(null);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            startScrollerTask();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        if (this.viewWidth == 0) {
            this.viewWidth = ((android.app.Activity) this.context).getWindowManager().getDefaultDisplay().getWidth();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("viewWidth: ");
            sb.append(this.viewWidth);
        }
        if (this.paint == null) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.paint = paint;
            paint.setColor(android.graphics.Color.parseColor("#83cde6"));
            this.paint.setStrokeWidth(dip2px(1.0f));
        }
        super.setBackgroundDrawable(new com.aliyun.svideo.editor.widget.WheelView.AnonymousClass4());
    }

    public void setItems(java.util.List<com.aliyun.svideo.editor.widget.WheelView.DataModel> list) {
        if (this.items == null) {
            this.items = new java.util.ArrayList();
        }
        this.items.clear();
        this.items.addAll(list);
        for (int i = 0; i < this.offset; i++) {
            this.items.add(0, new com.aliyun.svideo.editor.widget.WheelView.AnonymousClass1());
            this.items.add(new com.aliyun.svideo.editor.widget.WheelView.AnonymousClass2());
        }
        initData();
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setOnWheelViewListener(com.aliyun.svideo.editor.widget.WheelView.OnWheelViewListener onWheelViewListener) {
        this.onWheelViewListener = onWheelViewListener;
    }

    public void setSelection(int i) {
        this.selectedIndex = this.offset + i;
        postDelayed(new com.aliyun.svideo.editor.widget.WheelView.AnonymousClass5(i), 300L);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("setSelection: ");
        sb.append(i);
    }

    public void startScrollerTask() {
        this.initialY = getScrollY();
        postDelayed(this.scrollerTask, this.newCheck);
    }
}
