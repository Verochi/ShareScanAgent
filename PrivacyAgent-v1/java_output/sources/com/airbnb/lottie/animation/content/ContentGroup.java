package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class ContentGroup implements com.airbnb.lottie.animation.content.DrawingContent, com.airbnb.lottie.animation.content.PathContent, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.model.KeyPathElement {
    public android.graphics.Paint a;
    public android.graphics.RectF b;
    public final android.graphics.Matrix c;
    public final android.graphics.Path d;
    public final android.graphics.RectF e;
    public final java.lang.String f;
    public final boolean g;
    public final java.util.List<com.airbnb.lottie.animation.content.Content> h;
    public final com.airbnb.lottie.LottieDrawable i;

    @androidx.annotation.Nullable
    public java.util.List<com.airbnb.lottie.animation.content.PathContent> j;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation k;

    public ContentGroup(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), a(lottieDrawable, baseLayer, shapeGroup.getItems()), b(shapeGroup.getItems()));
    }

    public ContentGroup(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, java.lang.String str, boolean z, java.util.List<com.airbnb.lottie.animation.content.Content> list, @androidx.annotation.Nullable com.airbnb.lottie.model.animatable.AnimatableTransform animatableTransform) {
        this.a = new com.airbnb.lottie.animation.LPaint();
        this.b = new android.graphics.RectF();
        this.c = new android.graphics.Matrix();
        this.d = new android.graphics.Path();
        this.e = new android.graphics.RectF();
        this.f = str;
        this.i = lottieDrawable;
        this.g = z;
        this.h = list;
        if (animatableTransform != null) {
            com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation createAnimation = animatableTransform.createAnimation();
            this.k = createAnimation;
            createAnimation.addAnimationsToLayer(baseLayer);
            this.k.addListener(this);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.animation.content.Content content = list.get(size);
            if (content instanceof com.airbnb.lottie.animation.content.GreedyContent) {
                arrayList.add((com.airbnb.lottie.animation.content.GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((com.airbnb.lottie.animation.content.GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }

    public static java.util.List<com.airbnb.lottie.animation.content.Content> a(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, java.util.List<com.airbnb.lottie.model.content.ContentModel> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            com.airbnb.lottie.animation.content.Content content = list.get(i).toContent(lottieDrawable, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    @androidx.annotation.Nullable
    public static com.airbnb.lottie.model.animatable.AnimatableTransform b(java.util.List<com.airbnb.lottie.model.content.ContentModel> list) {
        for (int i = 0; i < list.size(); i++) {
            com.airbnb.lottie.model.content.ContentModel contentModel = list.get(i);
            if (contentModel instanceof com.airbnb.lottie.model.animatable.AnimatableTransform) {
                return (com.airbnb.lottie.model.animatable.AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t, lottieValueCallback);
        }
    }

    public java.util.List<com.airbnb.lottie.animation.content.PathContent> c() {
        if (this.j == null) {
            this.j = new java.util.ArrayList();
            for (int i = 0; i < this.h.size(); i++) {
                com.airbnb.lottie.animation.content.Content content = this.h.get(i);
                if (content instanceof com.airbnb.lottie.animation.content.PathContent) {
                    this.j.add((com.airbnb.lottie.animation.content.PathContent) content);
                }
            }
        }
        return this.j;
    }

    public android.graphics.Matrix d() {
        com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.c.reset();
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            this.c.preConcat(transformKeyframeAnimation.getMatrix());
            i = (int) (((((this.k.getOpacity() == null ? 100 : this.k.getOpacity().getValue().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.i.isApplyingOpacityToLayersEnabled() && e() && i != 255;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            getBounds(this.b, this.c, true);
            this.a.setAlpha(i);
            com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.b, this.a);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.animation.content.Content content = this.h.get(size);
            if (content instanceof com.airbnb.lottie.animation.content.DrawingContent) {
                ((com.airbnb.lottie.animation.content.DrawingContent) content).draw(canvas, this.c, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    public final boolean e() {
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            if ((this.h.get(i2) instanceof com.airbnb.lottie.animation.content.DrawingContent) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.c.set(matrix);
        com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            this.c.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.animation.content.Content content = this.h.get(size);
            if (content instanceof com.airbnb.lottie.animation.content.DrawingContent) {
                ((com.airbnb.lottie.animation.content.DrawingContent) content).getBounds(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.f;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public android.graphics.Path getPath() {
        this.c.reset();
        com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation transformKeyframeAnimation = this.k;
        if (transformKeyframeAnimation != null) {
            this.c.set(transformKeyframeAnimation.getMatrix());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.animation.content.Content content = this.h.get(size);
            if (content instanceof com.airbnb.lottie.animation.content.PathContent) {
                this.d.addPath(((com.airbnb.lottie.animation.content.PathContent) content).getPath(), this.c);
            }
        }
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        if (keyPath.matches(getName(), i) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i)) {
                int incrementDepthBy = i + keyPath.incrementDepthBy(getName(), i);
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    com.airbnb.lottie.animation.content.Content content = this.h.get(i2);
                    if (content instanceof com.airbnb.lottie.model.KeyPathElement) {
                        ((com.airbnb.lottie.model.KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size() + this.h.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            com.airbnb.lottie.animation.content.Content content = this.h.get(size);
            content.setContents(arrayList, this.h.subList(0, size));
            arrayList.add(content);
        }
    }
}
