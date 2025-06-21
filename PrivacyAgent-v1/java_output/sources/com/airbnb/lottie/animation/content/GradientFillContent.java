package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class GradientFillContent implements com.airbnb.lottie.animation.content.DrawingContent, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.animation.content.KeyPathElementContent {

    @androidx.annotation.NonNull
    public final java.lang.String a;
    public final boolean b;
    public final com.airbnb.lottie.model.layer.BaseLayer c;
    public final androidx.collection.LongSparseArray<android.graphics.LinearGradient> d = new androidx.collection.LongSparseArray<>();
    public final androidx.collection.LongSparseArray<android.graphics.RadialGradient> e = new androidx.collection.LongSparseArray<>();
    public final android.graphics.Path f;
    public final android.graphics.Paint g;
    public final android.graphics.RectF h;
    public final java.util.List<com.airbnb.lottie.animation.content.PathContent> i;
    public final com.airbnb.lottie.model.content.GradientType j;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> k;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> l;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> m;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> n;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> o;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation p;
    public final com.airbnb.lottie.LottieDrawable q;
    public final int r;

    public GradientFillContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.GradientFill gradientFill) {
        android.graphics.Path path = new android.graphics.Path();
        this.f = path;
        this.g = new com.airbnb.lottie.animation.LPaint(1);
        this.h = new android.graphics.RectF();
        this.i = new java.util.ArrayList();
        this.c = baseLayer;
        this.a = gradientFill.getName();
        this.b = gradientFill.isHidden();
        this.q = lottieDrawable;
        this.j = gradientFill.getGradientType();
        path.setFillType(gradientFill.getFillType());
        this.r = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> createAnimation = gradientFill.getGradientColor().createAnimation();
        this.k = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> createAnimation2 = gradientFill.getOpacity().createAnimation();
        this.l = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation3 = gradientFill.getStartPoint().createAnimation();
        this.m = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation4 = gradientFill.getEndPoint().createAnimation();
        this.n = createAnimation4;
        createAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation4);
    }

    public final int[] a(int[] iArr) {
        com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.p;
        if (valueCallbackKeyframeAnimation != null) {
            java.lang.Integer[] numArr = (java.lang.Integer[]) valueCallbackKeyframeAnimation.getValue();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        if (t == com.airbnb.lottie.LottieProperty.OPACITY) {
            this.l.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.COLOR_FILTER) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.o;
            if (baseKeyframeAnimation != null) {
                this.c.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.o = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.o = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.c.addAnimation(this.o);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.GRADIENT_COLOR) {
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.p;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.c.removeAnimation(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.p = null;
                return;
            }
            this.d.clear();
            this.e.clear();
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.p = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            this.c.addAnimation(this.p);
        }
    }

    public final int b() {
        int round = java.lang.Math.round(this.m.getProgress() * this.r);
        int round2 = java.lang.Math.round(this.n.getProgress() * this.r);
        int round3 = java.lang.Math.round(this.k.getProgress() * this.r);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    public final android.graphics.LinearGradient c() {
        long b = b();
        android.graphics.LinearGradient linearGradient = this.d.get(b);
        if (linearGradient != null) {
            return linearGradient;
        }
        android.graphics.PointF value = this.m.getValue();
        android.graphics.PointF value2 = this.n.getValue();
        com.airbnb.lottie.model.content.GradientColor value3 = this.k.getValue();
        android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(value.x, value.y, value2.x, value2.y, a(value3.getColors()), value3.getPositions(), android.graphics.Shader.TileMode.CLAMP);
        this.d.put(b, linearGradient2);
        return linearGradient2;
    }

    public final android.graphics.RadialGradient d() {
        long b = b();
        android.graphics.RadialGradient radialGradient = this.e.get(b);
        if (radialGradient != null) {
            return radialGradient;
        }
        android.graphics.PointF value = this.m.getValue();
        android.graphics.PointF value2 = this.n.getValue();
        com.airbnb.lottie.model.content.GradientColor value3 = this.k.getValue();
        int[] a = a(value3.getColors());
        float[] positions = value3.getPositions();
        float f = value.x;
        float f2 = value.y;
        float hypot = (float) java.lang.Math.hypot(value2.x - f, value2.y - f2);
        android.graphics.RadialGradient radialGradient2 = new android.graphics.RadialGradient(f, f2, hypot <= 0.0f ? 0.001f : hypot, a, positions, android.graphics.Shader.TileMode.CLAMP);
        this.e.put(b, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        if (this.b) {
            return;
        }
        com.airbnb.lottie.L.beginSection("GradientFillContent#draw");
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).getPath(), matrix);
        }
        this.f.computeBounds(this.h, false);
        android.graphics.Shader c = this.j == com.airbnb.lottie.model.content.GradientType.LINEAR ? c() : d();
        c.setLocalMatrix(matrix);
        this.g.setShader(c);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.o;
        if (baseKeyframeAnimation != null) {
            this.g.setColorFilter(baseKeyframeAnimation.getValue());
        }
        this.g.setAlpha(com.airbnb.lottie.utils.MiscUtils.clamp((int) ((((i / 255.0f) * this.l.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        com.airbnb.lottie.L.endSection("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.q.invalidateSelf();
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
                this.i.add((com.airbnb.lottie.animation.content.PathContent) content);
            }
        }
    }
}
