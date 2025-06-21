package com.airbnb.lottie.model.animatable;

/* loaded from: classes.dex */
public interface AnimatableValue<K, A> {
    com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<K, A> createAnimation();

    java.util.List<com.airbnb.lottie.value.Keyframe<K>> getKeyframes();

    boolean isStatic();
}
