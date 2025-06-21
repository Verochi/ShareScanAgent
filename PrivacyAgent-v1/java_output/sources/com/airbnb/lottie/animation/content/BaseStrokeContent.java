package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public abstract class BaseStrokeContent implements com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.animation.content.KeyPathElementContent, com.airbnb.lottie.animation.content.DrawingContent {
    public final com.airbnb.lottie.LottieDrawable e;
    public final float[] g;
    public final android.graphics.Paint h;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> i;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Integer> j;
    public final java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float>> k;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> l;
    protected final com.airbnb.lottie.model.layer.BaseLayer layer;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> m;
    public final android.graphics.PathMeasure a = new android.graphics.PathMeasure();
    public final android.graphics.Path b = new android.graphics.Path();
    public final android.graphics.Path c = new android.graphics.Path();
    public final android.graphics.RectF d = new android.graphics.RectF();
    public final java.util.List<com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup> f = new java.util.ArrayList();

    public static final class PathGroup {
        public final java.util.List<com.airbnb.lottie.animation.content.PathContent> a;

        @androidx.annotation.Nullable
        public final com.airbnb.lottie.animation.content.TrimPathContent b;

        public PathGroup(@androidx.annotation.Nullable com.airbnb.lottie.animation.content.TrimPathContent trimPathContent) {
            this.a = new java.util.ArrayList();
            this.b = trimPathContent;
        }

        public /* synthetic */ PathGroup(com.airbnb.lottie.animation.content.TrimPathContent trimPathContent, com.airbnb.lottie.animation.content.BaseStrokeContent.AnonymousClass1 anonymousClass1) {
            this(trimPathContent);
        }
    }

    public BaseStrokeContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, android.graphics.Paint.Cap cap, android.graphics.Paint.Join join, float f, com.airbnb.lottie.model.animatable.AnimatableIntegerValue animatableIntegerValue, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue, java.util.List<com.airbnb.lottie.model.animatable.AnimatableFloatValue> list, com.airbnb.lottie.model.animatable.AnimatableFloatValue animatableFloatValue2) {
        com.airbnb.lottie.animation.LPaint lPaint = new com.airbnb.lottie.animation.LPaint(1);
        this.h = lPaint;
        this.e = lottieDrawable;
        this.layer = baseLayer;
        lPaint.setStyle(android.graphics.Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f);
        this.j = animatableIntegerValue.createAnimation();
        this.i = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.l = null;
        } else {
            this.l = animatableFloatValue2.createAnimation();
        }
        this.k = new java.util.ArrayList(list.size());
        this.g = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.k.add(list.get(i).createAnimation());
        }
        baseLayer.addAnimation(this.j);
        baseLayer.addAnimation(this.i);
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            baseLayer.addAnimation(this.k.get(i2));
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation = this.l;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.j.addUpdateListener(this);
        this.i.addUpdateListener(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.k.get(i3).addUpdateListener(this);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation2 = this.l;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
    }

    public final void a(android.graphics.Matrix matrix) {
        com.airbnb.lottie.L.beginSection("StrokeContent#applyDashPattern");
        if (this.k.isEmpty()) {
            com.airbnb.lottie.L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = com.airbnb.lottie.utils.Utils.getScale(matrix);
        for (int i = 0; i < this.k.size(); i++) {
            this.g[i] = this.k.get(i).getValue().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.g;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.g;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.g;
            fArr3[i] = fArr3[i] * scale;
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation = this.l;
        this.h.setPathEffect(new android.graphics.DashPathEffect(this.g, baseKeyframeAnimation == null ? 0.0f : scale * baseKeyframeAnimation.getValue().floatValue()));
        com.airbnb.lottie.L.endSection("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @androidx.annotation.CallSuper
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        if (t == com.airbnb.lottie.LottieProperty.OPACITY) {
            this.j.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.STROKE_WIDTH) {
            this.i.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.COLOR_FILTER) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.m;
            if (baseKeyframeAnimation != null) {
                this.layer.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.m = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.m = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.m);
        }
    }

    public final void b(android.graphics.Canvas canvas, com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup pathGroup, android.graphics.Matrix matrix) {
        com.airbnb.lottie.L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.b == null) {
            com.airbnb.lottie.L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int size = pathGroup.a.size() - 1; size >= 0; size--) {
            this.b.addPath(((com.airbnb.lottie.animation.content.PathContent) pathGroup.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float floatValue = (pathGroup.b.getOffset().getValue().floatValue() * length) / 360.0f;
        float floatValue2 = ((pathGroup.b.getStart().getValue().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((pathGroup.b.getEnd().getValue().floatValue() * length) / 100.0f) + floatValue;
        float f = 0.0f;
        for (int size2 = pathGroup.a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((com.airbnb.lottie.animation.content.PathContent) pathGroup.a.get(size2)).getPath());
            this.c.transform(matrix);
            this.a.setPath(this.c, false);
            float length2 = this.a.getLength();
            if (floatValue3 > length) {
                float f2 = floatValue3 - length;
                if (f2 < f + length2 && f < f2) {
                    com.airbnb.lottie.utils.Utils.applyTrimPathIfNeeded(this.c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, java.lang.Math.min(f2 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.h);
                    f += length2;
                }
            }
            float f3 = f + length2;
            if (f3 >= floatValue2 && f <= floatValue3) {
                if (f3 > floatValue3 || floatValue2 >= f) {
                    com.airbnb.lottie.utils.Utils.applyTrimPathIfNeeded(this.c, floatValue2 < f ? 0.0f : (floatValue2 - f) / length2, floatValue3 <= f3 ? (floatValue3 - f) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.c, this.h);
                } else {
                    canvas.drawPath(this.c, this.h);
                }
            }
            f += length2;
        }
        com.airbnb.lottie.L.endSection("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        com.airbnb.lottie.L.beginSection("StrokeContent#draw");
        if (com.airbnb.lottie.utils.Utils.hasZeroScaleAxis(matrix)) {
            com.airbnb.lottie.L.endSection("StrokeContent#draw");
            return;
        }
        this.h.setAlpha(com.airbnb.lottie.utils.MiscUtils.clamp((int) ((((i / 255.0f) * ((com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation) this.j).getIntValue()) / 100.0f) * 255.0f), 0, 255));
        this.h.setStrokeWidth(((com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) this.i).getFloatValue() * com.airbnb.lottie.utils.Utils.getScale(matrix));
        if (this.h.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.L.endSection("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.m;
        if (baseKeyframeAnimation != null) {
            this.h.setColorFilter(baseKeyframeAnimation.getValue());
        }
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup pathGroup = this.f.get(i2);
            if (pathGroup.b != null) {
                b(canvas, pathGroup, matrix);
            } else {
                com.airbnb.lottie.L.beginSection("StrokeContent#buildPath");
                this.b.reset();
                for (int size = pathGroup.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((com.airbnb.lottie.animation.content.PathContent) pathGroup.a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.L.endSection("StrokeContent#buildPath");
                com.airbnb.lottie.L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.h);
                com.airbnb.lottie.L.endSection("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.L.endSection("StrokeContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        com.airbnb.lottie.L.beginSection("StrokeContent#getBounds");
        this.b.reset();
        for (int i = 0; i < this.f.size(); i++) {
            com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup pathGroup = this.f.get(i);
            for (int i2 = 0; i2 < pathGroup.a.size(); i2++) {
                this.b.addPath(((com.airbnb.lottie.animation.content.PathContent) pathGroup.a.get(i2)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float floatValue = ((com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) this.i).getFloatValue();
        android.graphics.RectF rectF2 = this.d;
        float f = floatValue / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.L.endSection("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        com.airbnb.lottie.utils.MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
        com.airbnb.lottie.animation.content.TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.animation.content.Content content = list.get(size);
            if (content instanceof com.airbnb.lottie.animation.content.TrimPathContent) {
                com.airbnb.lottie.animation.content.TrimPathContent trimPathContent2 = (com.airbnb.lottie.animation.content.TrimPathContent) content;
                if (trimPathContent2.getType() == com.airbnb.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.a(this);
        }
        com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            com.airbnb.lottie.animation.content.Content content2 = list2.get(size2);
            if (content2 instanceof com.airbnb.lottie.animation.content.TrimPathContent) {
                com.airbnb.lottie.animation.content.TrimPathContent trimPathContent3 = (com.airbnb.lottie.animation.content.TrimPathContent) content2;
                if (trimPathContent3.getType() == com.airbnb.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.f.add(pathGroup);
                    }
                    pathGroup = new com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup(trimPathContent3, null);
                    trimPathContent3.a(this);
                }
            }
            if (content2 instanceof com.airbnb.lottie.animation.content.PathContent) {
                if (pathGroup == null) {
                    pathGroup = new com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup(trimPathContent, null);
                }
                pathGroup.a.add((com.airbnb.lottie.animation.content.PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.f.add(pathGroup);
        }
    }
}
