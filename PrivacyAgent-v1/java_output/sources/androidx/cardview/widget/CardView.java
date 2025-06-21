package androidx.cardview.widget;

/* loaded from: classes.dex */
public class CardView extends android.widget.FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {android.R.attr.colorBackground};
    private static final androidx.cardview.widget.CardViewImpl IMPL;
    private final androidx.cardview.widget.CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final android.graphics.Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final android.graphics.Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    /* renamed from: androidx.cardview.widget.CardView$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.cardview.widget.CardViewDelegate {
        private android.graphics.drawable.Drawable mCardBackground;

        public AnonymousClass1() {
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public android.graphics.drawable.Drawable getCardBackground() {
            return this.mCardBackground;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public android.view.View getCardView() {
            return androidx.cardview.widget.CardView.this;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public boolean getPreventCornerOverlap() {
            return androidx.cardview.widget.CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public boolean getUseCompatPadding() {
            return androidx.cardview.widget.CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setCardBackground(android.graphics.drawable.Drawable drawable) {
            this.mCardBackground = drawable;
            androidx.cardview.widget.CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setMinWidthHeightInternal(int i, int i2) {
            androidx.cardview.widget.CardView cardView = androidx.cardview.widget.CardView.this;
            if (i > cardView.mUserSetMinWidth) {
                androidx.cardview.widget.CardView.super.setMinimumWidth(i);
            }
            androidx.cardview.widget.CardView cardView2 = androidx.cardview.widget.CardView.this;
            if (i2 > cardView2.mUserSetMinHeight) {
                androidx.cardview.widget.CardView.super.setMinimumHeight(i2);
            }
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            androidx.cardview.widget.CardView.this.mShadowBounds.set(i, i2, i3, i4);
            androidx.cardview.widget.CardView cardView = androidx.cardview.widget.CardView.this;
            android.graphics.Rect rect = cardView.mContentPadding;
            androidx.cardview.widget.CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    static {
        androidx.cardview.widget.CardViewApi21Impl cardViewApi21Impl = new androidx.cardview.widget.CardViewApi21Impl();
        IMPL = cardViewApi21Impl;
        cardViewApi21Impl.initStatic();
    }

    public CardView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public CardView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    public CardView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.content.res.ColorStateList valueOf;
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new android.graphics.Rect();
        androidx.cardview.widget.CardView.AnonymousClass1 anonymousClass1 = new androidx.cardview.widget.CardView.AnonymousClass1();
        this.mCardViewDelegate = anonymousClass1;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i, androidx.cardview.R.style.CardView);
        int i2 = androidx.cardview.R.styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i2)) {
            valueOf = obtainStyledAttributes.getColorStateList(i2);
        } else {
            android.content.res.TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            android.graphics.Color.colorToHSV(color, fArr);
            valueOf = android.content.res.ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(androidx.cardview.R.color.cardview_light_background) : getResources().getColor(androidx.cardview.R.color.cardview_dark_background));
        }
        android.content.res.ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(anonymousClass1, context, colorStateList, dimension, dimension2, f);
    }

    @androidx.annotation.NonNull
    public android.content.res.ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    @androidx.annotation.Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @androidx.annotation.Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @androidx.annotation.Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @androidx.annotation.Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (IMPL instanceof androidx.cardview.widget.CardViewApi21Impl) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = android.view.View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.max((int) java.lang.Math.ceil(r0.getMinWidth(this.mCardViewDelegate)), android.view.View.MeasureSpec.getSize(i)), mode);
        }
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.max((int) java.lang.Math.ceil(r0.getMinHeight(this.mCardViewDelegate)), android.view.View.MeasureSpec.getSize(i2)), mode2);
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(@androidx.annotation.ColorInt int i) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, android.content.res.ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public void setCardElevation(float f) {
        IMPL.setElevation(this.mCardViewDelegate, f);
    }

    public void setContentPadding(@androidx.annotation.Px int i, @androidx.annotation.Px int i2, @androidx.annotation.Px int i3, @androidx.annotation.Px int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f) {
        IMPL.setRadius(this.mCardViewDelegate, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }
}
