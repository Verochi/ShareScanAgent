package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieRelativeFloatValueCallback extends com.airbnb.lottie.value.LottieValueCallback<java.lang.Float> {
    public LottieRelativeFloatValueCallback() {
    }

    public LottieRelativeFloatValueCallback(@androidx.annotation.NonNull java.lang.Float f) {
        super(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.Float getOffset(com.airbnb.lottie.value.LottieFrameInfo<java.lang.Float> lottieFrameInfo) {
        T t = this.value;
        if (t != 0) {
            return (java.lang.Float) t;
        }
        throw new java.lang.IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public java.lang.Float getValue(com.airbnb.lottie.value.LottieFrameInfo<java.lang.Float> lottieFrameInfo) {
        return java.lang.Float.valueOf(com.airbnb.lottie.utils.MiscUtils.lerp(lottieFrameInfo.getStartValue().floatValue(), lottieFrameInfo.getEndValue().floatValue(), lottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(lottieFrameInfo).floatValue());
    }
}
