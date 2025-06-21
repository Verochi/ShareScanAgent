package com.airbnb.lottie.animation.keyframe;

/* loaded from: classes.dex */
public class TransformKeyframeAnimation {
    public final android.graphics.Matrix a = new android.graphics.Matrix();
    public final android.graphics.Matrix b;
    public final android.graphics.Matrix c;
    public final android.graphics.Matrix d;
    public final float[] e;

    @androidx.annotation.NonNull
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> f;

    @androidx.annotation.NonNull
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> g;

    @androidx.annotation.NonNull
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> h;

    @androidx.annotation.NonNull
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> i;

    @androidx.annotation.NonNull
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> j;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation k;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation l;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> m;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> n;

    public TransformKeyframeAnimation(com.airbnb.lottie.model.animatable.AnimatableTransform animatableTransform) {
        this.f = animatableTransform.getAnchorPoint() == null ? null : animatableTransform.getAnchorPoint().createAnimation();
        this.g = animatableTransform.getPosition() == null ? null : animatableTransform.getPosition().createAnimation();
        this.h = animatableTransform.getScale() == null ? null : animatableTransform.getScale().createAnimation();
        this.i = animatableTransform.getRotation() == null ? null : animatableTransform.getRotation().createAnimation();
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.getSkew() == null ? null : (com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) animatableTransform.getSkew().createAnimation();
        this.k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.b = new android.graphics.Matrix();
            this.c = new android.graphics.Matrix();
            this.d = new android.graphics.Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = animatableTransform.getSkewAngle() == null ? null : (com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) animatableTransform.getSkewAngle().createAnimation();
        if (animatableTransform.getOpacity() != null) {
            this.j = animatableTransform.getOpacity().createAnimation();
        }
        if (animatableTransform.getStartOpacity() != null) {
            this.m = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.m = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.n = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.n = null;
        }
    }

    public final void a() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    public void addAnimationsToLayer(com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        baseLayer.addAnimation(this.j);
        baseLayer.addAnimation(this.m);
        baseLayer.addAnimation(this.n);
        baseLayer.addAnimation(this.f);
        baseLayer.addAnimation(this.g);
        baseLayer.addAnimation(this.h);
        baseLayer.addAnimation(this.i);
        baseLayer.addAnimation(this.k);
        baseLayer.addAnimation(this.l);
    }

    public void addListener(com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener animationListener) {
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation = this.k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation2 = this.l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public <T> boolean applyValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation;
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation2;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation2;
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_ANCHOR_POINT) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> baseKeyframeAnimation3 = this.f;
            if (baseKeyframeAnimation3 == null) {
                this.f = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback, new android.graphics.PointF());
                return true;
            }
            baseKeyframeAnimation3.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_POSITION) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> baseKeyframeAnimation4 = this.g;
            if (baseKeyframeAnimation4 == null) {
                this.g = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback, new android.graphics.PointF());
                return true;
            }
            baseKeyframeAnimation4.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_POSITION_X) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> baseKeyframeAnimation5 = this.g;
            if (baseKeyframeAnimation5 instanceof com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation) {
                ((com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation5).setXValueCallback(lottieValueCallback);
                return true;
            }
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_POSITION_Y) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> baseKeyframeAnimation6 = this.g;
            if (baseKeyframeAnimation6 instanceof com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation) {
                ((com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation6).setYValueCallback(lottieValueCallback);
                return true;
            }
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_SCALE) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> baseKeyframeAnimation7 = this.h;
            if (baseKeyframeAnimation7 == null) {
                this.h = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback, new com.airbnb.lottie.value.ScaleXY());
                return true;
            }
            baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_ROTATION) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation8 = this.i;
            if (baseKeyframeAnimation8 == null) {
                this.i = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback, java.lang.Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation8.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_OPACITY) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation9 = this.j;
            if (baseKeyframeAnimation9 == null) {
                this.j = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation9.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_START_OPACITY && (baseKeyframeAnimation2 = this.m) != null) {
            if (baseKeyframeAnimation2 == null) {
                this.m = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_END_OPACITY && (baseKeyframeAnimation = this.n) != null) {
            if (baseKeyframeAnimation == null) {
                this.n = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t == com.airbnb.lottie.LottieProperty.TRANSFORM_SKEW && (floatKeyframeAnimation2 = this.k) != null) {
            if (floatKeyframeAnimation2 == null) {
                this.k = new com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation(java.util.Collections.singletonList(new com.airbnb.lottie.value.Keyframe(java.lang.Float.valueOf(0.0f))));
            }
            this.k.setValueCallback(lottieValueCallback);
            return true;
        }
        if (t != com.airbnb.lottie.LottieProperty.TRANSFORM_SKEW_ANGLE || (floatKeyframeAnimation = this.l) == null) {
            return false;
        }
        if (floatKeyframeAnimation == null) {
            this.l = new com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation(java.util.Collections.singletonList(new com.airbnb.lottie.value.Keyframe(java.lang.Float.valueOf(0.0f))));
        }
        this.l.setValueCallback(lottieValueCallback);
        return true;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> getEndOpacity() {
        return this.n;
    }

    public android.graphics.Matrix getMatrix() {
        this.a.reset();
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> baseKeyframeAnimation = this.g;
        if (baseKeyframeAnimation != null) {
            android.graphics.PointF value = baseKeyframeAnimation.getValue();
            float f = value.x;
            if (f != 0.0f || value.y != 0.0f) {
                this.a.preTranslate(f, value.y);
            }
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation2 = this.i;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2 instanceof com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation ? baseKeyframeAnimation2.getValue().floatValue() : ((com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
            if (floatValue != 0.0f) {
                this.a.preRotate(floatValue);
            }
        }
        if (this.k != null) {
            float cos = this.l == null ? 0.0f : (float) java.lang.Math.cos(java.lang.Math.toRadians((-r0.getFloatValue()) + 90.0f));
            float sin = this.l == null ? 1.0f : (float) java.lang.Math.sin(java.lang.Math.toRadians((-r4.getFloatValue()) + 90.0f));
            float tan = (float) java.lang.Math.tan(java.lang.Math.toRadians(this.k.getFloatValue()));
            a();
            float[] fArr = this.e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            a();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            a();
            float[] fArr3 = this.e;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> baseKeyframeAnimation3 = this.h;
        if (baseKeyframeAnimation3 != null) {
            com.airbnb.lottie.value.ScaleXY value2 = baseKeyframeAnimation3.getValue();
            if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
                this.a.preScale(value2.getScaleX(), value2.getScaleY());
            }
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            android.graphics.PointF value3 = baseKeyframeAnimation4.getValue();
            float f3 = value3.x;
            if (f3 != 0.0f || value3.y != 0.0f) {
                this.a.preTranslate(-f3, -value3.y);
            }
        }
        return this.a;
    }

    public android.graphics.Matrix getMatrixForRepeater(float f) {
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> baseKeyframeAnimation = this.g;
        android.graphics.PointF value = baseKeyframeAnimation == null ? null : baseKeyframeAnimation.getValue();
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> baseKeyframeAnimation2 = this.h;
        com.airbnb.lottie.value.ScaleXY value2 = baseKeyframeAnimation2 == null ? null : baseKeyframeAnimation2.getValue();
        this.a.reset();
        if (value != null) {
            this.a.preTranslate(value.x * f, value.y * f);
        }
        if (value2 != null) {
            double d = f;
            this.a.preScale((float) java.lang.Math.pow(value2.getScaleX(), d), (float) java.lang.Math.pow(value2.getScaleY(), d));
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation3 = this.i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.getValue().floatValue();
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> baseKeyframeAnimation4 = this.f;
            android.graphics.PointF value3 = baseKeyframeAnimation4 != null ? baseKeyframeAnimation4.getValue() : null;
            this.a.preRotate(floatValue * f, value3 == null ? 0.0f : value3.x, value3 != null ? value3.y : 0.0f);
        }
        return this.a;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Integer> getOpacity() {
        return this.j;
    }

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> getStartOpacity() {
        return this.m;
    }

    public void setProgress(float f) {
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation = this.j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation2 = this.m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation3 = this.n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> baseKeyframeAnimation4 = this.f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> baseKeyframeAnimation5 = this.g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.value.ScaleXY, com.airbnb.lottie.value.ScaleXY> baseKeyframeAnimation6 = this.h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation7 = this.i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation = this.k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f);
        }
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation2 = this.l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.setProgress(f);
        }
    }
}
