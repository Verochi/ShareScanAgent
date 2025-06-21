package com.airbnb.lottie.value;

/* loaded from: classes.dex */
abstract class LottieInterpolatedValue<T> extends com.airbnb.lottie.value.LottieValueCallback<T> {
    public final T c;
    public final T d;
    public final android.view.animation.Interpolator e;

    public LottieInterpolatedValue(T t, T t2) {
        this(t, t2, new android.view.animation.LinearInterpolator());
    }

    public LottieInterpolatedValue(T t, T t2, android.view.animation.Interpolator interpolator) {
        this.c = t;
        this.d = t2;
        this.e = interpolator;
    }

    public abstract T a(T t, T t2, float f);

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public T getValue(com.airbnb.lottie.value.LottieFrameInfo<T> lottieFrameInfo) {
        return a(this.c, this.d, this.e.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }
}
