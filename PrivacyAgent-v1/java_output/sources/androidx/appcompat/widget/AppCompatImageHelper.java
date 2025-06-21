package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AppCompatImageHelper {
    private androidx.appcompat.widget.TintInfo mImageTint;
    private androidx.appcompat.widget.TintInfo mInternalImageTint;
    private androidx.appcompat.widget.TintInfo mTmpInfo;

    @androidx.annotation.NonNull
    private final android.widget.ImageView mView;

    public AppCompatImageHelper(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        android.content.res.ColorStateList imageTintList = androidx.core.widget.ImageViewCompat.getImageTintList(this.mView);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        android.graphics.PorterDuff.Mode imageTintMode = androidx.core.widget.ImageViewCompat.getImageTintMode(this.mView);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        androidx.appcompat.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int i = android.os.Build.VERSION.SDK_INT;
        return i > 21 ? this.mInternalImageTint != null : i == 21;
    }

    public void applySupportImageTint() {
        android.graphics.drawable.Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            androidx.appcompat.widget.DrawableUtils.fixDrawable(drawable);
        }
        if (drawable != null) {
            if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(drawable)) {
                return;
            }
            androidx.appcompat.widget.TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                androidx.appcompat.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
                return;
            }
            androidx.appcompat.widget.TintInfo tintInfo2 = this.mInternalImageTint;
            if (tintInfo2 != null) {
                androidx.appcompat.widget.AppCompatDrawableManager.tintDrawable(drawable, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    public android.content.res.ColorStateList getSupportImageTintList() {
        androidx.appcompat.widget.TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public android.graphics.PorterDuff.Mode getSupportImageTintMode() {
        androidx.appcompat.widget.TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return !(this.mView.getBackground() instanceof android.graphics.drawable.RippleDrawable);
    }

    public void loadFromAttributes(android.util.AttributeSet attributeSet, int i) {
        int resourceId;
        android.content.Context context = this.mView.getContext();
        int[] iArr = androidx.appcompat.R.styleable.AppCompatImageView;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        android.widget.ImageView imageView = this.mView;
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            android.graphics.drawable.Drawable drawable = this.mView.getDrawable();
            if (drawable == null && (resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.content.res.AppCompatResources.getDrawable(this.mView.getContext(), resourceId)) != null) {
                this.mView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                androidx.appcompat.widget.DrawableUtils.fixDrawable(drawable);
            }
            int i2 = androidx.appcompat.R.styleable.AppCompatImageView_tint;
            if (obtainStyledAttributes.hasValue(i2)) {
                androidx.core.widget.ImageViewCompat.setImageTintList(this.mView, obtainStyledAttributes.getColorStateList(i2));
            }
            int i3 = androidx.appcompat.R.styleable.AppCompatImageView_tintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
                androidx.core.widget.ImageViewCompat.setImageTintMode(this.mView, androidx.appcompat.widget.DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            android.graphics.drawable.Drawable drawable = androidx.appcompat.content.res.AppCompatResources.getDrawable(this.mView.getContext(), i);
            if (drawable != null) {
                androidx.appcompat.widget.DrawableUtils.fixDrawable(drawable);
            }
            this.mView.setImageDrawable(drawable);
        } else {
            this.mView.setImageDrawable(null);
        }
        applySupportImageTint();
    }

    public void setInternalImageTint(android.content.res.ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new androidx.appcompat.widget.TintInfo();
            }
            androidx.appcompat.widget.TintInfo tintInfo = this.mInternalImageTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalImageTint = null;
        }
        applySupportImageTint();
    }

    public void setSupportImageTintList(android.content.res.ColorStateList colorStateList) {
        if (this.mImageTint == null) {
            this.mImageTint = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportImageTint();
    }

    public void setSupportImageTintMode(android.graphics.PorterDuff.Mode mode) {
        if (this.mImageTint == null) {
            this.mImageTint = new androidx.appcompat.widget.TintInfo();
        }
        androidx.appcompat.widget.TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportImageTint();
    }
}
