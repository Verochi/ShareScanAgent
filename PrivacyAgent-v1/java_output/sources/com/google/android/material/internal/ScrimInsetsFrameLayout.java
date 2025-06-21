package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ScrimInsetsFrameLayout extends android.widget.FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawTopInsetForeground;

    @androidx.annotation.Nullable
    android.graphics.drawable.Drawable insetForeground;
    android.graphics.Rect insets;
    private android.graphics.Rect tempRect;

    /* renamed from: com.google.android.material.internal.ScrimInsetsFrameLayout$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.core.view.OnApplyWindowInsetsListener {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, @androidx.annotation.NonNull androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
            com.google.android.material.internal.ScrimInsetsFrameLayout scrimInsetsFrameLayout = com.google.android.material.internal.ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.insets == null) {
                scrimInsetsFrameLayout.insets = new android.graphics.Rect();
            }
            com.google.android.material.internal.ScrimInsetsFrameLayout.this.insets.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            com.google.android.material.internal.ScrimInsetsFrameLayout.this.onInsetsChanged(windowInsetsCompat);
            com.google.android.material.internal.ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || com.google.android.material.internal.ScrimInsetsFrameLayout.this.insetForeground == null);
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(com.google.android.material.internal.ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tempRect = new android.graphics.Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.ScrimInsetsFrameLayout, i, com.google.android.material.R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = obtainStyledAttributes.getDrawable(com.google.android.material.R.styleable.ScrimInsetsFrameLayout_insetForeground);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(this, new com.google.android.material.internal.ScrimInsetsFrameLayout.AnonymousClass1());
    }

    @Override // android.view.View
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.insets == null || this.insetForeground == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.drawTopInsetForeground) {
            this.tempRect.set(0, 0, width, this.insets.top);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
        }
        if (this.drawBottomInsetForeground) {
            this.tempRect.set(0, height - this.insets.bottom, width, height);
            this.insetForeground.setBounds(this.tempRect);
            this.insetForeground.draw(canvas);
        }
        android.graphics.Rect rect = this.tempRect;
        android.graphics.Rect rect2 = this.insets;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        android.graphics.Rect rect3 = this.tempRect;
        android.graphics.Rect rect4 = this.insets;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.insetForeground.setBounds(this.tempRect);
        this.insetForeground.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.graphics.drawable.Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.graphics.drawable.Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void onInsetsChanged(androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.drawBottomInsetForeground = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.drawTopInsetForeground = z;
    }

    public void setScrimInsetForeground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.insetForeground = drawable;
    }
}
