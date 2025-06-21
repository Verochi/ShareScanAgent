package com.airbnb.lottie.model;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class LottieCompositionCache {
    public static final com.airbnb.lottie.model.LottieCompositionCache b = new com.airbnb.lottie.model.LottieCompositionCache();
    public final androidx.collection.LruCache<java.lang.String, com.airbnb.lottie.LottieComposition> a = new androidx.collection.LruCache<>(20);

    @androidx.annotation.VisibleForTesting
    public LottieCompositionCache() {
    }

    public static com.airbnb.lottie.model.LottieCompositionCache getInstance() {
        return b;
    }

    public void clear() {
        this.a.evictAll();
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.LottieComposition get(@androidx.annotation.Nullable java.lang.String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void put(@androidx.annotation.Nullable java.lang.String str, com.airbnb.lottie.LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.a.put(str, lottieComposition);
    }

    public void resize(int i) {
        this.a.resize(i);
    }
}
