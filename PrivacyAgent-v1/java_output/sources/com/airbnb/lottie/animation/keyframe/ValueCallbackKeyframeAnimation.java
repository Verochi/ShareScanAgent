package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<K, A> {
    public final com.airbnb.lottie.value.LottieFrameInfo<A> g;
    public final A h;

    public ValueCallbackKeyframeAnimation(com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    public ValueCallbackKeyframeAnimation(com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback, @androidx.annotation.Nullable A a) {
        super(java.util.Collections.emptyList());
        this.g = new com.airbnb.lottie.value.LottieFrameInfo<>();
        setValueCallback(lottieValueCallback);
        this.h = a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public float a() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue() {
        com.airbnb.lottie.value.LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        A a = this.h;
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, a, a, getProgress(), getProgress(), getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue(com.airbnb.lottie.value.Keyframe<K> keyframe, float f) {
        return getValue();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f) {
        this.progress = f;
    }
}
