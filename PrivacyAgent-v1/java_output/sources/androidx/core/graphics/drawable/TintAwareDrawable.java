package androidx.core.graphics.drawable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface TintAwareDrawable {
    void setTint(@androidx.annotation.ColorInt int i);

    void setTintList(android.content.res.ColorStateList colorStateList);

    void setTintMode(android.graphics.PorterDuff.Mode mode);
}
