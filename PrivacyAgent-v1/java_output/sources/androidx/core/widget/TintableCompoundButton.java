package androidx.core.widget;

/* loaded from: classes.dex */
public interface TintableCompoundButton {
    @androidx.annotation.Nullable
    android.content.res.ColorStateList getSupportButtonTintList();

    @androidx.annotation.Nullable
    android.graphics.PorterDuff.Mode getSupportButtonTintMode();

    void setSupportButtonTintList(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList);

    void setSupportButtonTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode);
}
