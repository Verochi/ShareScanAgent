package androidx.core.graphics.drawable;

/* loaded from: classes.dex */
final class WrappedDrawableState extends android.graphics.drawable.Drawable.ConstantState {
    int mChangingConfigurations;
    android.graphics.drawable.Drawable.ConstantState mDrawableState;
    android.content.res.ColorStateList mTint;
    android.graphics.PorterDuff.Mode mTintMode;

    public WrappedDrawableState(@androidx.annotation.Nullable androidx.core.graphics.drawable.WrappedDrawableState wrappedDrawableState) {
        this.mTint = null;
        this.mTintMode = androidx.core.graphics.drawable.WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (wrappedDrawableState != null) {
            this.mChangingConfigurations = wrappedDrawableState.mChangingConfigurations;
            this.mDrawableState = wrappedDrawableState.mDrawableState;
            this.mTint = wrappedDrawableState.mTint;
            this.mTintMode = wrappedDrawableState.mTintMode;
        }
    }

    public boolean canConstantState() {
        return this.mDrawableState != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.mChangingConfigurations;
        android.graphics.drawable.Drawable.ConstantState constantState = this.mDrawableState;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @androidx.annotation.NonNull
    public android.graphics.drawable.Drawable newDrawable(@androidx.annotation.Nullable android.content.res.Resources resources) {
        return new androidx.core.graphics.drawable.WrappedDrawableApi21(this, resources);
    }
}
