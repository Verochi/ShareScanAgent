package com.aliyun.svideo.common.bottomnavigationbar;

/* loaded from: classes.dex */
class BottomNavigationItemView extends android.widget.LinearLayout {
    private static final float SCALE_MAX = 1.1f;
    private boolean isAnim;
    private com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity mBottomNavigationEntity;
    private android.widget.TextView mItemBadge;
    private android.widget.ImageView mItemIcon;
    private android.widget.TextView mItemText;
    private int mLayoutId;
    private int mTextSelectedColor;
    private int mTextUnSelectedColor;
    private float scaleRatio;
    private android.animation.ValueAnimator valueAnimator;

    /* renamed from: com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView.this.setScaleX(floatValue);
            com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView.this.setScaleY(floatValue);
        }
    }

    public BottomNavigationItemView(android.content.Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        setGravity(17);
    }

    @android.annotation.SuppressLint({"SetTextI18n"})
    private void rendingItemBadge() {
        com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity bottomNavigationEntity;
        if (this.mItemBadge == null || (bottomNavigationEntity = this.mBottomNavigationEntity) == null) {
            return;
        }
        int badgeNum = bottomNavigationEntity.getBadgeNum();
        if (badgeNum <= 0) {
            this.mItemBadge.setVisibility(4);
            return;
        }
        if (badgeNum < 99) {
            this.mItemBadge.setText(java.lang.String.valueOf(badgeNum));
        } else {
            this.mItemBadge.setText("99+");
        }
        this.mItemBadge.setVisibility(0);
    }

    private void rendingItemIcon(boolean z) {
        com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity bottomNavigationEntity;
        android.widget.ImageView imageView = this.mItemIcon;
        if (imageView == null || (bottomNavigationEntity = this.mBottomNavigationEntity) == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(bottomNavigationEntity.getSelectedIcon());
        } else {
            imageView.setImageResource(bottomNavigationEntity.getUnSelectIcon());
        }
    }

    private void rendingItemText(boolean z) {
        com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity bottomNavigationEntity;
        if (this.mItemText == null || (bottomNavigationEntity = this.mBottomNavigationEntity) == null) {
            return;
        }
        java.lang.String text = bottomNavigationEntity.getText();
        if (android.text.TextUtils.isEmpty(text)) {
            this.mItemText.setVisibility(8);
            return;
        }
        this.mItemText.setText(text);
        this.mItemText.setVisibility(0);
        if (z) {
            this.mItemText.setTextColor(this.mTextSelectedColor);
        } else {
            this.mItemText.setTextColor(this.mTextUnSelectedColor);
        }
    }

    private void scale(float f, float f2) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(f, f2);
        this.valueAnimator = ofFloat;
        ofFloat.setDuration(200L);
        this.valueAnimator.addUpdateListener(new com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationItemView.AnonymousClass1());
        this.valueAnimator.start();
    }

    public float getScaleRatio() {
        return this.scaleRatio;
    }

    public boolean isAnim() {
        return this.isAnim;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        android.animation.ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.onDetachedFromWindow();
    }

    public void refresh() {
        rendingItemBadge();
    }

    public void setAnim(boolean z) {
        this.isAnim = z;
    }

    public void setBottomNavigationEntity(com.aliyun.svideo.common.bottomnavigationbar.BottomNavigationEntity bottomNavigationEntity) {
        this.mBottomNavigationEntity = bottomNavigationEntity;
        setDefaultState();
    }

    public void setDefaultState() {
        rendingItemText(false);
        rendingItemIcon(false);
        rendingItemBadge();
    }

    public void setLayoutId(int i) {
        this.mLayoutId = i;
        android.view.LayoutInflater.from(getContext()).inflate(this.mLayoutId, (android.view.ViewGroup) this, true);
        this.mItemIcon = (android.widget.ImageView) findViewById(com.aliyun.svideo.common.R.id.bnb_item_icon);
        this.mItemText = (android.widget.TextView) findViewById(com.aliyun.svideo.common.R.id.bnb_item_text);
        this.mItemBadge = (android.widget.TextView) findViewById(com.aliyun.svideo.common.R.id.bnb_item_badge);
    }

    public void setScaleRatio(float f) {
        this.scaleRatio = java.lang.Math.abs(f);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        rendingItemText(z);
        rendingItemIcon(z);
        if (this.isAnim) {
            float f = SCALE_MAX;
            if (z) {
                float f2 = this.scaleRatio;
                if (f2 > SCALE_MAX) {
                    f = f2;
                }
                scale(1.0f, f);
                return;
            }
            float f3 = this.scaleRatio;
            if (f3 > SCALE_MAX) {
                f = f3;
            }
            scale(f, 1.0f);
        }
    }

    public void setTextSelectedColor(int i) {
        this.mTextSelectedColor = i;
    }

    public void setTextUnSelectedColor(int i) {
        this.mTextUnSelectedColor = i;
    }
}
