package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class GradientStrokeContent extends com.airbnb.lottie.animation.content.BaseStrokeContent {
    public final java.lang.String n;
    public final boolean o;
    public final androidx.collection.LongSparseArray<android.graphics.LinearGradient> p;
    public final androidx.collection.LongSparseArray<android.graphics.RadialGradient> q;
    public final android.graphics.RectF r;

    /* renamed from: s, reason: collision with root package name */
    public final com.airbnb.lottie.model.content.GradientType f76s;
    public final int t;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> u;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> v;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> w;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation x;

    public GradientStrokeContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        this.p = new androidx.collection.LongSparseArray<>();
        this.q = new androidx.collection.LongSparseArray<>();
        this.r = new android.graphics.RectF();
        this.n = gradientStroke.getName();
        this.f76s = gradientStroke.getGradientType();
        this.o = gradientStroke.isHidden();
        this.t = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> createAnimation = gradientStroke.getGradientColor().createAnimation();
        this.u = createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation2 = gradientStroke.getStartPoint().createAnimation();
        this.v = createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation3 = gradientStroke.getEndPoint().createAnimation();
        this.w = createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == com.airbnb.lottie.LottieProperty.GRADIENT_COLOR) {
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.x;
            if (valueCallbackKeyframeAnimation != null) {
                this.layer.removeAnimation(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.x = null;
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.x = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            this.layer.addAnimation(this.x);
        }
    }

    public final int[] c(int[] iArr) {
        com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.x;
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

    public final int d() {
        int round = java.lang.Math.round(this.v.getProgress() * this.t);
        int round2 = java.lang.Math.round(this.w.getProgress() * this.t);
        int round3 = java.lang.Math.round(this.u.getProgress() * this.t);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        if (this.o) {
            return;
        }
        getBounds(this.r, matrix, false);
        android.graphics.Shader e = this.f76s == com.airbnb.lottie.model.content.GradientType.LINEAR ? e() : f();
        e.setLocalMatrix(matrix);
        this.h.setShader(e);
        super.draw(canvas, matrix, i);
    }

    public final android.graphics.LinearGradient e() {
        long d = d();
        android.graphics.LinearGradient linearGradient = this.p.get(d);
        if (linearGradient != null) {
            return linearGradient;
        }
        android.graphics.PointF value = this.v.getValue();
        android.graphics.PointF value2 = this.w.getValue();
        com.airbnb.lottie.model.content.GradientColor value3 = this.u.getValue();
        android.graphics.LinearGradient linearGradient2 = new android.graphics.LinearGradient(value.x, value.y, value2.x, value2.y, c(value3.getColors()), value3.getPositions(), android.graphics.Shader.TileMode.CLAMP);
        this.p.put(d, linearGradient2);
        return linearGradient2;
    }

    public final android.graphics.RadialGradient f() {
        long d = d();
        android.graphics.RadialGradient radialGradient = this.q.get(d);
        if (radialGradient != null) {
            return radialGradient;
        }
        android.graphics.PointF value = this.v.getValue();
        android.graphics.PointF value2 = this.w.getValue();
        com.airbnb.lottie.model.content.GradientColor value3 = this.u.getValue();
        int[] c = c(value3.getColors());
        float[] positions = value3.getPositions();
        android.graphics.RadialGradient radialGradient2 = new android.graphics.RadialGradient(value.x, value.y, (float) java.lang.Math.hypot(value2.x - r7, value2.y - r8), c, positions, android.graphics.Shader.TileMode.CLAMP);
        this.q.put(d, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.n;
    }
}
