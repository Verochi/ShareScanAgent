package androidx.core.view;

/* loaded from: classes.dex */
public interface TintableBackgroundView {
    @androidx.annotation.Nullable
    android.content.res.ColorStateList getSupportBackgroundTintList();

    @androidx.annotation.Nullable
    android.graphics.PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList);

    void setSupportBackgroundTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode);
}
