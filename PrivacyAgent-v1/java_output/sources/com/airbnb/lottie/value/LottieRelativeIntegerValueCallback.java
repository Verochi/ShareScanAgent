package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class LottieRelativeIntegerValueCallback extends com.airbnb.lottie.value.LottieValueCallback<java.lang.Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.Integer getOffset(com.airbnb.lottie.value.LottieFrameInfo<java.lang.Integer> lottieFrameInfo) {
        T t = this.value;
        if (t != 0) {
            return (java.lang.Integer) t;
        }
        throw new java.lang.IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public java.lang.Integer getValue(com.airbnb.lottie.value.LottieFrameInfo<java.lang.Integer> lottieFrameInfo) {
        return java.lang.Integer.valueOf(com.airbnb.lottie.utils.MiscUtils.lerp(lottieFrameInfo.getStartValue().intValue(), lottieFrameInfo.getEndValue().intValue(), lottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(lottieFrameInfo).intValue());
    }
}
