package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieValueCallback<T> {
    public final com.airbnb.lottie.value.LottieFrameInfo<T> a;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, ?> b;

    @androidx.annotation.Nullable
    protected T value;

    public LottieValueCallback() {
        this.a = new com.airbnb.lottie.value.LottieFrameInfo<>();
        this.value = null;
    }

    public LottieValueCallback(@androidx.annotation.Nullable T t) {
        this.a = new com.airbnb.lottie.value.LottieFrameInfo<>();
        this.value = t;
    }

    @androidx.annotation.Nullable
    public T getValue(com.airbnb.lottie.value.LottieFrameInfo<T> lottieFrameInfo) {
        return this.value;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public final T getValueInternal(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return getValue(this.a.set(f, f2, t, t2, f3, f4, f5));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public final void setAnimation(@androidx.annotation.Nullable com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.b = baseKeyframeAnimation;
    }

    public final void setValue(@androidx.annotation.Nullable T t) {
        this.value = t;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.b;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.notifyListeners();
        }
    }
}
