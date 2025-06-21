package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class RectangleContent implements com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.animation.content.KeyPathElementContent, com.airbnb.lottie.animation.content.PathContent {
    public final java.lang.String c;
    public final boolean d;
    public final com.airbnb.lottie.LottieDrawable e;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> f;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> g;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> h;
    public boolean j;
    public final android.graphics.Path a = new android.graphics.Path();
    public final android.graphics.RectF b = new android.graphics.RectF();
    public com.airbnb.lottie.animation.content.CompoundTrimPathContent i = new com.airbnb.lottie.animation.content.CompoundTrimPathContent();

    public RectangleContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.RectangleShape rectangleShape) {
        this.c = rectangleShape.getName();
        this.d = rectangleShape.isHidden();
        this.e = lottieDrawable;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation = rectangleShape.getPosition().createAnimation();
        this.f = createAnimation;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation2 = rectangleShape.getSize().createAnimation();
        this.g = createAnimation2;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation3 = rectangleShape.getCornerRadius().createAnimation();
        this.h = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    public final void a() {
        this.j = false;
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        if (t == com.airbnb.lottie.LottieProperty.RECTANGLE_SIZE) {
            this.g.setValueCallback(lottieValueCallback);
        } else if (t == com.airbnb.lottie.LottieProperty.POSITION) {
            this.f.setValueCallback(lottieValueCallback);
        } else if (t == com.airbnb.lottie.LottieProperty.CORNER_RADIUS) {
            this.h.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public android.graphics.Path getPath() {
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        android.graphics.PointF value = this.g.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation = this.h;
        float floatValue = baseKeyframeAnimation == null ? 0.0f : ((com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) baseKeyframeAnimation).getFloatValue();
        float min = java.lang.Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        android.graphics.PointF value2 = this.f.getValue();
        this.a.moveTo(value2.x + f, (value2.y - f2) + floatValue);
        this.a.lineTo(value2.x + f, (value2.y + f2) - floatValue);
        if (floatValue > 0.0f) {
            android.graphics.RectF rectF = this.b;
            float f3 = value2.x;
            float f4 = floatValue * 2.0f;
            float f5 = value2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((value2.x - f) + floatValue, value2.y + f2);
        if (floatValue > 0.0f) {
            android.graphics.RectF rectF2 = this.b;
            float f6 = value2.x;
            float f7 = value2.y;
            float f8 = floatValue * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(value2.x - f, (value2.y - f2) + floatValue);
        if (floatValue > 0.0f) {
            android.graphics.RectF rectF3 = this.b;
            float f9 = value2.x;
            float f10 = value2.y;
            float f11 = floatValue * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((value2.x + f) - floatValue, value2.y - f2);
        if (floatValue > 0.0f) {
            android.graphics.RectF rectF4 = this.b;
            float f12 = value2.x;
            float f13 = floatValue * 2.0f;
            float f14 = value2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.apply(this.a);
        this.j = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        com.airbnb.lottie.utils.MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            com.airbnb.lottie.animation.content.Content content = list.get(i);
            if (content instanceof com.airbnb.lottie.animation.content.TrimPathContent) {
                com.airbnb.lottie.animation.content.TrimPathContent trimPathContent = (com.airbnb.lottie.animation.content.TrimPathContent) content;
                if (trimPathContent.getType() == com.airbnb.lottie.model.content.ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.i.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
