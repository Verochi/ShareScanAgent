package com.airbnb.lottie.model;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback);

    void resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2);
}
