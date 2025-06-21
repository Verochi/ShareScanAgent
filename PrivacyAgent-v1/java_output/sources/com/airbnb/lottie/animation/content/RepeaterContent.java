package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class RepeaterContent implements com.airbnb.lottie.animation.content.DrawingContent, com.airbnb.lottie.animation.content.PathContent, com.airbnb.lottie.animation.content.GreedyContent, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.animation.content.KeyPathElementContent {
    public final android.graphics.Matrix a = new android.graphics.Matrix();
    public final android.graphics.Path b = new android.graphics.Path();
    public final com.airbnb.lottie.LottieDrawable c;
    public final com.airbnb.lottie.model.layer.BaseLayer d;
    public final java.lang.String e;
    public final boolean f;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> g;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> h;
    public final com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation i;
    public com.airbnb.lottie.animation.content.ContentGroup j;

    public RepeaterContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.Repeater repeater) {
        this.c = lottieDrawable;
        this.d = baseLayer;
        this.e = repeater.getName();
        this.f = repeater.isHidden();
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation = repeater.getCopies().createAnimation();
        this.g = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation2 = repeater.getOffset().createAnimation();
        this.h = createAnimation2;
        baseLayer.addAnimation(createAnimation2);
        createAnimation2.addUpdateListener(this);
        com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation createAnimation3 = repeater.getTransform().createAnimation();
        this.i = createAnimation3;
        createAnimation3.addAnimationsToLayer(baseLayer);
        createAnimation3.addListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        java.util.Collections.reverse(arrayList);
        this.j = new com.airbnb.lottie.animation.content.ContentGroup(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        if (this.i.applyValueCallback(t, lottieValueCallback)) {
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.REPEATER_COPIES) {
            this.g.setValueCallback(lottieValueCallback);
        } else if (t == com.airbnb.lottie.LottieProperty.REPEATER_OFFSET) {
            this.h.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        float floatValue = this.g.getValue().floatValue();
        float floatValue2 = this.h.getValue().floatValue();
        float floatValue3 = this.i.getStartOpacity().getValue().floatValue() / 100.0f;
        float floatValue4 = this.i.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.getMatrixForRepeater(f + floatValue2));
            this.j.draw(canvas, this.a, (int) (i * com.airbnb.lottie.utils.MiscUtils.lerp(floatValue3, floatValue4, f / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.j.getBounds(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.e;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public android.graphics.Path getPath() {
        android.graphics.Path path = this.j.getPath();
        this.b.reset();
        float floatValue = this.g.getValue().floatValue();
        float floatValue2 = this.h.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.getMatrixForRepeater(i + floatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        com.airbnb.lottie.utils.MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
        this.j.setContents(list, list2);
    }
}
