package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ForegroundLinearLayout extends androidx.appcompat.widget.LinearLayoutCompat {

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable foreground;
    boolean foregroundBoundsChanged;
    private int foregroundGravity;
    protected boolean mForegroundInPadding;
    private final android.graphics.Rect overlayBounds;
    private final android.graphics.Rect selfBounds;

    public ForegroundLinearLayout(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selfBounds = new android.graphics.Rect();
        this.overlayBounds = new android.graphics.Rect();
        this.foregroundGravity = 119;
        this.mForegroundInPadding = true;
        this.foregroundBoundsChanged = false;
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.ForegroundLinearLayout, i, 0, new int[0]);
        this.foregroundGravity = obtainStyledAttributes.getInt(com.google.android.material.R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.foregroundGravity);
        android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(com.google.android.material.R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.mForegroundInPadding = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        super.draw(canvas);
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable != null) {
            if (this.foregroundBoundsChanged) {
                this.foregroundBoundsChanged = false;
                android.graphics.Rect rect = this.selfBounds;
                android.graphics.Rect rect2 = this.overlayBounds;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.mForegroundInPadding) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                android.view.Gravity.apply(this.foregroundGravity, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @androidx.annotation.RequiresApi(21)
    @android.annotation.TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.foreground.setState(getDrawableState());
    }

    @Override // android.view.View
    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getForeground() {
        return this.foreground;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    @androidx.annotation.RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        android.graphics.drawable.Drawable drawable = this.foreground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.foregroundBoundsChanged = z | this.foregroundBoundsChanged;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.foregroundBoundsChanged = true;
    }

    @Override // android.view.View
    public void setForeground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.foreground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.foreground);
            }
            this.foreground = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.foregroundGravity == 119) {
                    drawable.getPadding(new android.graphics.Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.foregroundGravity != i) {
            if ((8388615 & i) == 0) {
                i |= androidx.core.view.GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.foregroundGravity = i;
            if (i == 119 && this.foreground != null) {
                this.foreground.getPadding(new android.graphics.Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.foreground;
    }
}
