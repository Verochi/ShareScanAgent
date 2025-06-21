package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class ShapeKeyframeAnimation extends com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> {
    public final com.airbnb.lottie.model.content.ShapeData g;
    public final android.graphics.Path h;

    public ShapeKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.content.ShapeData>> list) {
        super(list);
        this.g = new com.airbnb.lottie.model.content.ShapeData();
        this.h = new android.graphics.Path();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public android.graphics.Path getValue(com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.content.ShapeData> keyframe, float f) {
        this.g.interpolateBetween(keyframe.startValue, keyframe.endValue, f);
        com.airbnb.lottie.utils.MiscUtils.getPathFromData(this.g, this.h);
        return this.h;
    }
}
