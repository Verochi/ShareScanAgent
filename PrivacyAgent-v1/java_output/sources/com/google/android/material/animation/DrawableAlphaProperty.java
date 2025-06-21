package com.google.android.material.animation;

/* loaded from: classes22.dex */
public class DrawableAlphaProperty extends android.util.Property<android.graphics.drawable.Drawable, java.lang.Integer> {
    public static final android.util.Property<android.graphics.drawable.Drawable, java.lang.Integer> DRAWABLE_ALPHA_COMPAT = new com.google.android.material.animation.DrawableAlphaProperty();
    private final java.util.WeakHashMap<android.graphics.drawable.Drawable, java.lang.Integer> alphaCache;

    private DrawableAlphaProperty() {
        super(java.lang.Integer.class, "drawableAlphaCompat");
        this.alphaCache = new java.util.WeakHashMap<>();
    }

    @Override // android.util.Property
    @androidx.annotation.Nullable
    public java.lang.Integer get(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return java.lang.Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public void set(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull java.lang.Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
