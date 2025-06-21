package androidx.appcompat.widget;

/* loaded from: classes.dex */
class AppCompatBackgroundHelper {
    private androidx.appcompat.widget.TintInfo mBackgroundTint;
    private androidx.appcompat.widget.TintInfo mInternalBackgroundTint;
    private androidx.appcompat.widget.TintInfo mTmpInfo;

    @androidx.annotation.NonNull
    private final android.view.View mView;
    private int mBackgroundResId = -1;
    private final androidx.appcompat.widget.AppCompatDrawableManager mDrawableManager = androidx.appcompat.widget.AppCompatDrawableManager.get();

    public AppCompatBackgroundHelper(@androidx.annotation.NonNull android.view.View view) {
        this.mView = view;
    }

    private boolean applyFrameworkTintUsingColorFilter(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        android.content.res.ColorStateList backgroundTintList = androidx.core.view.ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        android.graphics.PorterDuff.Mode backgroundTintMode = androidx.core.view.ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        androidx.appcompat.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int i = android.os.Build.VERSION.SDK_INT;
        return i > 21 ? this.mInternalBackgroundTint != null : i == 21;
    }

    public void applySupportBackgroundTint() {
        android.graphics.drawable.Drawable background = this.mView.getBackground();
        if (background != null) {
            if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(background)) {
                return;
            }
            androidx.appcompat.widget.TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                androidx.appcompat.widget.AppCompatDrawableManager.tintDrawable(background, tintInfo, this.mView.getDrawableState());
                return;
            }
            androidx.appcompat.widget.TintInfo tintInfo2 = this.mInternalBackgroundTint;
            if (tintInfo2 != null) {
                androidx.appcompat.widget.AppCompatDrawableManager.tintDrawable(background, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    public android.content.res.ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public android.graphics.PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        android.content.Context context = this.mView.getContext();
        int[] iArr = androidx.appcompat.R.styleable.ViewBackgroundHelper;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        android.view.View view = this.mView;
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            int i2 = androidx.appcompat.R.styleable.ViewBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.mBackgroundResId = obtainStyledAttributes.getResourceId(i2, -1);
                android.content.res.ColorStateList tintList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            int i3 = androidx.appcompat.R.styleable.ViewBackgroundHelper_backgroundTint;
            if (obtainStyledAttributes.hasValue(i3)) {
                androidx.core.view.ViewCompat.setBackgroundTintList(this.mView, obtainStyledAttributes.getColorStateList(i3));
            }
            int i4 = androidx.appcompat.R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (obtainStyledAttributes.hasValue(i4)) {
                androidx.core.view.ViewCompat.setBackgroundTintMode(this.mView, androidx.appcompat.widget.DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i4, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onSetBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int i) {
        this.mBackgroundResId = i;
        androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
        setInternalBackgroundTint(appCompatDrawableManager != null ? appCompatDrawableManager.getTintList(this.mView.getContext(), i) : null);
        applySupportBackgroundTint();
    }

    public void setInternalBackgroundTint(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new androidx.appcompat.widget.TintInfo();
            }
            androidx.appcompat.widget.TintInfo tintInfo = this.mInternalBackgroundTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintList(android.content.res.ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
