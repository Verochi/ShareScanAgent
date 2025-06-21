package com.aliyun.svideo.common.bottomnavigationbar;

/* loaded from: classes.dex */
public class BottomNavigationBar extends android.widget.LinearLayout implements android.view.View.OnClickListener {
    private static final java.lang.String DEFAULT_SELECTED_COLOR = "#000000";
    private static final java.lang.String DEFAULT_UNSELECTED_COLOR = "#999999";
    private com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationBar.IBnbItemDoubleClickListener bnbItemDoubleClickListener;
    private com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationBar.IBnbItemSelectListener bnbItemSelectListener;
    private java.util.List<com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity> entities;
    private boolean isAnim;
    private int mCurrentPosition;
    private int mItemLayout;
    private int mTextSelectedColor;
    private int mTextUnSelectedColor;
    private float scaleRatio;

    public interface IBnbItemDoubleClickListener {
        void onBnbItemDoubleClick(int i);
    }

    public interface IBnbItemSelectListener {
        void onBnbItemSelect(int i);
    }

    public BottomNavigationBar(android.content.Context context) {
        this(context, null);
    }

    public BottomNavigationBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.entities = new java.util.ArrayList();
        this.mCurrentPosition = -1;
        init(context, attributeSet);
    }

    private void addItems() {
        if (this.entities.isEmpty()) {
            return;
        }
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        for (int i = 0; i < this.entities.size(); i++) {
            com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity bottomNavigationEntity = this.entities.get(i);
            com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView bottomNavigationItemView = new com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView(getContext());
            bottomNavigationItemView.setLayoutId(this.mItemLayout);
            bottomNavigationItemView.setAnim(this.isAnim);
            bottomNavigationItemView.setScaleRatio(this.scaleRatio);
            bottomNavigationItemView.setBottomNavigationEntity(bottomNavigationEntity);
            bottomNavigationItemView.setTextSelectedColor(this.mTextSelectedColor);
            bottomNavigationItemView.setTextUnSelectedColor(this.mTextUnSelectedColor);
            bottomNavigationItemView.setTag(java.lang.Integer.valueOf(i));
            addView(bottomNavigationItemView, layoutParams);
            bottomNavigationItemView.setOnClickListener(this);
            bottomNavigationItemView.setDefaultState();
        }
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.common.R.styleable.BottomNavigationBar);
        this.mTextSelectedColor = obtainStyledAttributes.getColor(com.aliyun.svideo.common.R.styleable.BottomNavigationBar_bnb_selectedColor, android.graphics.Color.parseColor(DEFAULT_SELECTED_COLOR));
        this.mTextUnSelectedColor = obtainStyledAttributes.getColor(com.aliyun.svideo.common.R.styleable.BottomNavigationBar_bnb_unSelectedColor, android.graphics.Color.parseColor("#999999"));
        this.isAnim = obtainStyledAttributes.getBoolean(com.aliyun.svideo.common.R.styleable.BottomNavigationBar_bnb_anim, false);
        this.scaleRatio = obtainStyledAttributes.getFloat(com.aliyun.svideo.common.R.styleable.BottomNavigationBar_bnb_scale_ratio, 1.1f);
        this.mItemLayout = obtainStyledAttributes.getResourceId(com.aliyun.svideo.common.R.styleable.BottomNavigationBar_bnb_layoutId, -1);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationBar.IBnbItemDoubleClickListener iBnbItemDoubleClickListener;
        int intValue = ((java.lang.Integer) view.getTag()).intValue();
        int i = this.mCurrentPosition;
        if (intValue == i && (iBnbItemDoubleClickListener = this.bnbItemDoubleClickListener) != null) {
            iBnbItemDoubleClickListener.onBnbItemDoubleClick(intValue);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            if (intValue != i) {
                setCurrentPosition(intValue);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public void refreshItem(int i) {
        if (i >= 0 && i < getChildCount()) {
            ((com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView) getChildAt(i)).refresh();
        }
    }

    public void setAnim(boolean z) {
        this.isAnim = z;
    }

    public void setBnbItemDoubleClickListener(com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationBar.IBnbItemDoubleClickListener iBnbItemDoubleClickListener) {
        this.bnbItemDoubleClickListener = iBnbItemDoubleClickListener;
    }

    public void setBnbItemSelectListener(com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationBar.IBnbItemSelectListener iBnbItemSelectListener) {
        this.bnbItemSelectListener = iBnbItemSelectListener;
    }

    public void setCurrentPosition(int i) {
        int i2;
        int childCount = getChildCount();
        if (childCount == 0 || i > childCount || i == (i2 = this.mCurrentPosition)) {
            return;
        }
        com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView bottomNavigationItemView = (com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView) getChildAt(i2);
        com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView bottomNavigationItemView2 = (com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView) getChildAt(i);
        if (bottomNavigationItemView != null) {
            bottomNavigationItemView.setSelected(false);
        }
        if (bottomNavigationItemView2 != null) {
            bottomNavigationItemView2.setSelected(true);
        }
        this.mCurrentPosition = i;
        com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationBar.IBnbItemSelectListener iBnbItemSelectListener = this.bnbItemSelectListener;
        if (iBnbItemSelectListener != null) {
            iBnbItemSelectListener.onBnbItemSelect(i);
        }
    }

    public void setEntities(java.util.List<com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity> list) {
        this.entities.clear();
        this.entities.addAll(list);
        addItems();
    }
}
