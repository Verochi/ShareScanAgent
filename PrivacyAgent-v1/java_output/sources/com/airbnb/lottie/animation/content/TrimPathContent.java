package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class TrimPathContent implements com.airbnb.lottie.animation.content.Content, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener {
    public final java.lang.String a;
    public final boolean b;
    public final java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener> c = new java.util.ArrayList();
    public final com.airbnb.lottie.model.content.ShapeTrimPath.Type d;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> e;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> f;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> g;

    public TrimPathContent(com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.ShapeTrimPath shapeTrimPath) {
        this.a = shapeTrimPath.getName();
        this.b = shapeTrimPath.isHidden();
        this.d = shapeTrimPath.getType();
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation = shapeTrimPath.getStart().createAnimation();
        this.e = createAnimation;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation2 = shapeTrimPath.getEnd().createAnimation();
        this.f = createAnimation2;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation3 = shapeTrimPath.getOffset().createAnimation();
        this.g = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    public void a(com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener animationListener) {
        this.c.add(animationListener);
    }

    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> getEnd() {
        return this.f;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.a;
    }

    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> getOffset() {
        return this.g;
    }

    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> getStart() {
        return this.e;
    }

    public com.airbnb.lottie.model.content.ShapeTrimPath.Type getType() {
        return this.d;
    }

    public boolean isHidden() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).onValueChanged();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
    }
}
