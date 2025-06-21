package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class MaskKeyframeAnimation {
    public final java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path>> a;
    public final java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer>> b;
    public final java.util.List<com.airbnb.lottie.model.content.Mask> c;

    public MaskKeyframeAnimation(java.util.List<com.airbnb.lottie.model.content.Mask> list) {
        this.c = list;
        this.a = new java.util.ArrayList(list.size());
        this.b = new java.util.ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(list.get(i).getMaskPath().createAnimation());
            this.b.add(list.get(i).getOpacity().createAnimation());
        }
    }

    public java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path>> getMaskAnimations() {
        return this.a;
    }

    public java.util.List<com.airbnb.lottie.model.content.Mask> getMasks() {
        return this.c;
    }

    public java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer>> getOpacityAnimations() {
        return this.b;
    }
}
