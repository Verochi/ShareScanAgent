package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class FillContent implements com.airbnb.lottie.animation.content.DrawingContent, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.animation.content.KeyPathElementContent {
    public final android.graphics.Path a;
    public final android.graphics.Paint b;
    public final com.airbnb.lottie.model.layer.BaseLayer c;
    public final java.lang.String d;
    public final boolean e;
    public final java.util.List<com.airbnb.lottie.animation.content.PathContent> f;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> g;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> h;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> i;
    public final com.airbnb.lottie.LottieDrawable j;

    public FillContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.ShapeFill shapeFill) {
        android.graphics.Path path = new android.graphics.Path();
        this.a = path;
        this.b = new com.airbnb.lottie.animation.LPaint(1);
        this.f = new java.util.ArrayList();
        this.c = baseLayer;
        this.d = shapeFill.getName();
        this.e = shapeFill.isHidden();
        this.j = lottieDrawable;
        if (shapeFill.getColor() == null || shapeFill.getOpacity() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(shapeFill.getFillType());
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> createAnimation = shapeFill.getColor().createAnimation();
        this.g = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> createAnimation2 = shapeFill.getOpacity().createAnimation();
        this.h = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        if (t == com.airbnb.lottie.LottieProperty.COLOR) {
            this.g.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.OPACITY) {
            this.h.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.COLOR_FILTER) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.i;
            if (baseKeyframeAnimation != null) {
                this.c.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.i = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.c.addAnimation(this.i);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        com.airbnb.lottie.L.beginSection("FillContent#draw");
        this.b.setColor(((com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation) this.g).getIntValue());
        this.b.setAlpha(com.airbnb.lottie.utils.MiscUtils.clamp((int) ((((i / 255.0f) * this.h.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.i;
        if (baseKeyframeAnimation != null) {
            this.b.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        com.airbnb.lottie.L.endSection("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.a.addPath(this.f.get(i).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        com.airbnb.lottie.utils.MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            com.airbnb.lottie.animation.content.Content content = list2.get(i);
            if (content instanceof com.airbnb.lottie.animation.content.PathContent) {
                this.f.add((com.airbnb.lottie.animation.content.PathContent) content);
            }
        }
    }
}
