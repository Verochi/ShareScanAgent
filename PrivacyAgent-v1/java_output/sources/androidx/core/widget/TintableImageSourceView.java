package androidx.core.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface TintableImageSourceView {
    @androidx.annotation.Nullable
    android.content.res.ColorStateList getSupportImageTintList();

    @androidx.annotation.Nullable
    android.graphics.PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList);

    void setSupportImageTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode);
}
