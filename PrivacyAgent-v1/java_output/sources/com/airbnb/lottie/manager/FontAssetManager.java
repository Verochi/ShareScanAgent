package com.airbnb.lottie.manager;

/* loaded from: classes.dex */
public class FontAssetManager {
    public final android.content.res.AssetManager d;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.FontAssetDelegate e;
    public final com.airbnb.lottie.model.MutablePair<java.lang.String> a = new com.airbnb.lottie.model.MutablePair<>();
    public final java.util.Map<com.airbnb.lottie.model.MutablePair<java.lang.String>, android.graphics.Typeface> b = new java.util.HashMap();
    public final java.util.Map<java.lang.String, android.graphics.Typeface> c = new java.util.HashMap();
    public java.lang.String f = ".ttf";

    public FontAssetManager(android.graphics.drawable.Drawable.Callback callback, @androidx.annotation.Nullable com.airbnb.lottie.FontAssetDelegate fontAssetDelegate) {
        this.e = fontAssetDelegate;
        if (callback instanceof android.view.View) {
            this.d = ((android.view.View) callback).getContext().getAssets();
        } else {
            com.airbnb.lottie.utils.Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }

    public final android.graphics.Typeface a(java.lang.String str) {
        java.lang.String fontPath;
        android.graphics.Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.FontAssetDelegate fontAssetDelegate = this.e;
        android.graphics.Typeface fetchFont = fontAssetDelegate != null ? fontAssetDelegate.fetchFont(str) : null;
        com.airbnb.lottie.FontAssetDelegate fontAssetDelegate2 = this.e;
        if (fontAssetDelegate2 != null && fetchFont == null && (fontPath = fontAssetDelegate2.getFontPath(str)) != null) {
            fetchFont = android.graphics.Typeface.createFromAsset(this.d, fontPath);
        }
        if (fetchFont == null) {
            fetchFont = android.graphics.Typeface.createFromAsset(this.d, "fonts/" + str + this.f);
        }
        this.c.put(str, fetchFont);
        return fetchFont;
    }

    public final android.graphics.Typeface b(android.graphics.Typeface typeface, java.lang.String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : android.graphics.Typeface.create(typeface, i);
    }

    public android.graphics.Typeface getTypeface(java.lang.String str, java.lang.String str2) {
        this.a.set(str, str2);
        android.graphics.Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        android.graphics.Typeface b = b(a(str), str2);
        this.b.put(this.a, b);
        return b;
    }

    public void setDefaultFontFileExtension(java.lang.String str) {
        this.f = str;
    }

    public void setDelegate(@androidx.annotation.Nullable com.airbnb.lottie.FontAssetDelegate fontAssetDelegate) {
        this.e = fontAssetDelegate;
    }
}
