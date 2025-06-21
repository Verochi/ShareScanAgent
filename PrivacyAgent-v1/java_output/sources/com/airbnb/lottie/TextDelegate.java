package com.airbnb.lottie;

/* loaded from: classes.dex */
public class TextDelegate {
    public final java.util.Map<java.lang.String, java.lang.String> a;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.LottieAnimationView b;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.LottieDrawable c;
    public boolean d;

    @androidx.annotation.VisibleForTesting
    public TextDelegate() {
        this.a = new java.util.HashMap();
        this.d = true;
        this.b = null;
        this.c = null;
    }

    public TextDelegate(com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
        this.a = new java.util.HashMap();
        this.d = true;
        this.b = lottieAnimationView;
        this.c = null;
    }

    public TextDelegate(com.airbnb.lottie.LottieDrawable lottieDrawable) {
        this.a = new java.util.HashMap();
        this.d = true;
        this.c = lottieDrawable;
        this.b = null;
    }

    public final java.lang.String a(java.lang.String str) {
        return str;
    }

    public final void b() {
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = this.b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        com.airbnb.lottie.LottieDrawable lottieDrawable = this.c;
        if (lottieDrawable != null) {
            lottieDrawable.invalidateSelf();
        }
    }

    public final java.lang.String getTextInternal(java.lang.String str) {
        if (this.d && this.a.containsKey(str)) {
            return this.a.get(str);
        }
        java.lang.String a = a(str);
        if (this.d) {
            this.a.put(str, a);
        }
        return a;
    }

    public void invalidateAllText() {
        this.a.clear();
        b();
    }

    public void invalidateText(java.lang.String str) {
        this.a.remove(str);
        b();
    }

    public void setCacheText(boolean z) {
        this.d = z;
    }

    public void setText(java.lang.String str, java.lang.String str2) {
        this.a.put(str, str2);
        b();
    }
}
