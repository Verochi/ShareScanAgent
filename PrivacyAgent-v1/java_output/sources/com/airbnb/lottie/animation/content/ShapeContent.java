package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class ShapeContent implements com.airbnb.lottie.animation.content.PathContent, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener {
    public final java.lang.String b;
    public final boolean c;
    public final com.airbnb.lottie.LottieDrawable d;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.Path> e;
    public boolean f;
    public final android.graphics.Path a = new android.graphics.Path();
    public com.airbnb.lottie.animation.content.CompoundTrimPathContent g = new com.airbnb.lottie.animation.content.CompoundTrimPathContent();

    public ShapeContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.ShapePath shapePath) {
        this.b = shapePath.getName();
        this.c = shapePath.isHidden();
        this.d = lottieDrawable;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> createAnimation = shapePath.getShapePath().createAnimation();
        this.e = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    public final void a() {
        this.f = false;
        this.d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public android.graphics.Path getPath() {
        if (this.f) {
            return this.a;
        }
        this.a.reset();
        if (this.c) {
            this.f = true;
            return this.a;
        }
        this.a.set(this.e.getValue());
        this.a.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        this.g.apply(this.a);
        this.f = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            com.airbnb.lottie.animation.content.Content content = list.get(i);
            if (content instanceof com.airbnb.lottie.animation.content.TrimPathContent) {
                com.airbnb.lottie.animation.content.TrimPathContent trimPathContent = (com.airbnb.lottie.animation.content.TrimPathContent) content;
                if (trimPathContent.getType() == com.airbnb.lottie.model.content.ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
