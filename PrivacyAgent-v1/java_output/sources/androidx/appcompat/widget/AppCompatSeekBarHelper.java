package androidx.appcompat.widget;

/* loaded from: classes.dex */
class AppCompatSeekBarHelper extends androidx.appcompat.widget.AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private android.graphics.drawable.Drawable mTickMark;
    private android.content.res.ColorStateList mTickMarkTintList;
    private android.graphics.PorterDuff.Mode mTickMarkTintMode;
    private final android.widget.SeekBar mView;

    public AppCompatSeekBarHelper(android.widget.SeekBar seekBar) {
        super(seekBar);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        android.graphics.drawable.Drawable drawable = this.mTickMark;
        if (drawable != null) {
            if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
                android.graphics.drawable.Drawable wrap = androidx.core.graphics.drawable.DrawableCompat.wrap(drawable.mutate());
                this.mTickMark = wrap;
                if (this.mHasTickMarkTint) {
                    androidx.core.graphics.drawable.DrawableCompat.setTintList(wrap, this.mTickMarkTintList);
                }
                if (this.mHasTickMarkTintMode) {
                    androidx.core.graphics.drawable.DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
                }
                if (this.mTickMark.isStateful()) {
                    this.mTickMark.setState(this.mView.getDrawableState());
                }
            }
        }
    }

    public void drawTickMarks(android.graphics.Canvas canvas) {
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.mTickMark.setBounds(-i, -i2, i, i2);
                float width = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void drawableStateChanged() {
        android.graphics.drawable.Drawable drawable = this.mTickMark;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getTickMark() {
        return this.mTickMark;
    }

    @androidx.annotation.Nullable
    public android.content.res.ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    @androidx.annotation.Nullable
    public android.graphics.PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        android.graphics.drawable.Drawable drawable = this.mTickMark;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void loadFromAttributes(android.util.AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, i);
        android.content.Context context = this.mView.getContext();
        int[] iArr = androidx.appcompat.R.styleable.AppCompatSeekBar;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        android.widget.SeekBar seekBar = this.mView;
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        android.graphics.drawable.Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(androidx.appcompat.R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.mView.setThumb(drawableIfKnown);
        }
        setTickMark(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.AppCompatSeekBar_tickMark));
        int i2 = androidx.appcompat.R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.mTickMarkTintMode = androidx.appcompat.widget.DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i2, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        int i3 = androidx.appcompat.R.styleable.AppCompatSeekBar_tickMarkTint;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(i3);
            this.mHasTickMarkTint = true;
        }
        obtainStyledAttributes.recycle();
        applyTickMarkTint();
    }

    public void setTickMark(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this.mView);
            androidx.core.graphics.drawable.DrawableCompat.setLayoutDirection(drawable, androidx.core.view.ViewCompat.getLayoutDirection(this.mView));
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    public void setTickMarkTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    public void setTickMarkTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }
}
