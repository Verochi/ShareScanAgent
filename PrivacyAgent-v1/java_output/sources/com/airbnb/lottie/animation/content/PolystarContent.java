package com.airbnb.lottie.animation.content;

/* loaded from: classes.dex */
public class PolystarContent implements com.airbnb.lottie.animation.content.PathContent, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.animation.content.KeyPathElementContent {
    public final java.lang.String b;
    public final com.airbnb.lottie.LottieDrawable c;
    public final com.airbnb.lottie.model.content.PolystarShape.Type d;
    public final boolean e;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> f;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, android.graphics.PointF> g;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> h;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> i;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> j;

    @androidx.annotation.Nullable
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> k;
    public final com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> l;
    public boolean n;
    public final android.graphics.Path a = new android.graphics.Path();
    public com.airbnb.lottie.animation.content.CompoundTrimPathContent m = new com.airbnb.lottie.animation.content.CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.content.PolystarShape.Type.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.model.content.PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.model.content.PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer, com.airbnb.lottie.model.content.PolystarShape polystarShape) {
        this.c = lottieDrawable;
        this.b = polystarShape.getName();
        com.airbnb.lottie.model.content.PolystarShape.Type type = polystarShape.getType();
        this.d = type;
        this.e = polystarShape.isHidden();
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation = polystarShape.getPoints().createAnimation();
        this.f = createAnimation;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> createAnimation2 = polystarShape.getPosition().createAnimation();
        this.g = createAnimation2;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation3 = polystarShape.getRotation().createAnimation();
        this.h = createAnimation3;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.j = createAnimation4;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.l = createAnimation5;
        com.airbnb.lottie.model.content.PolystarShape.Type type2 = com.airbnb.lottie.model.content.PolystarShape.Type.STAR;
        if (type == type2) {
            this.i = polystarShape.getInnerRadius().createAnimation();
            this.k = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.i = null;
            this.k = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type == type2) {
            baseLayer.addAnimation(this.i);
            baseLayer.addAnimation(this.k);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type == type2) {
            this.i.addUpdateListener(this);
            this.k.addUpdateListener(this);
        }
    }

    public final void a() {
        int i;
        double d;
        double d2;
        double d3;
        int floor = (int) java.lang.Math.floor(this.f.getValue().floatValue());
        double radians = java.lang.Math.toRadians((this.h == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = floor;
        float floatValue = this.l.getValue().floatValue() / 100.0f;
        float floatValue2 = this.j.getValue().floatValue();
        double d5 = floatValue2;
        float cos = (float) (java.lang.Math.cos(radians) * d5);
        float sin = (float) (java.lang.Math.sin(radians) * d5);
        this.a.moveTo(cos, sin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double ceil = java.lang.Math.ceil(d4);
        int i2 = 0;
        while (i2 < ceil) {
            float cos2 = (float) (java.lang.Math.cos(d7) * d5);
            double d8 = ceil;
            float sin2 = (float) (d5 * java.lang.Math.sin(d7));
            if (floatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double atan2 = (float) (java.lang.Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) java.lang.Math.cos(atan2);
                float sin3 = (float) java.lang.Math.sin(atan2);
                d3 = d6;
                double atan22 = (float) (java.lang.Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f = floatValue2 * floatValue * 0.25f;
                this.a.cubicTo(cos - (cos3 * f), sin - (sin3 * f), cos2 + (((float) java.lang.Math.cos(atan22)) * f), sin2 + (f * ((float) java.lang.Math.sin(atan22))), cos2, sin2);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.a.lineTo(cos2, sin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            sin = sin2;
            cos = cos2;
            ceil = d8;
            d5 = d2;
            d6 = d3;
        }
        android.graphics.PointF value = this.g.getValue();
        this.a.offset(value.x, value.y);
        this.a.close();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation2;
        if (t == com.airbnb.lottie.LottieProperty.POLYSTAR_POINTS) {
            this.f.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.POLYSTAR_ROTATION) {
            this.h.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.POSITION) {
            this.g.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.i) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.j.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == com.airbnb.lottie.LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.k) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t == com.airbnb.lottie.LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.l.setValueCallback(lottieValueCallback);
        }
    }

    public final void b() {
        int i;
        float f;
        float f2;
        double d;
        float f3;
        float f4;
        float f5;
        float f6;
        double d2;
        float f7;
        float f8;
        float f9;
        double d3;
        float floatValue = this.f.getValue().floatValue();
        double radians = java.lang.Math.toRadians((this.h == null ? 0.0d : r2.getValue().floatValue()) - 90.0d);
        double d4 = floatValue;
        float f10 = (float) (6.283185307179586d / d4);
        float f11 = f10 / 2.0f;
        float f12 = floatValue - ((int) floatValue);
        int i2 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f12) * f11;
        }
        float floatValue2 = this.j.getValue().floatValue();
        float floatValue3 = this.i.getValue().floatValue();
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation = this.k;
        float floatValue4 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, java.lang.Float> baseKeyframeAnimation2 = this.l;
        float floatValue5 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f4 = ((floatValue2 - floatValue3) * f12) + floatValue3;
            i = i2;
            double d5 = f4;
            float cos = (float) (d5 * java.lang.Math.cos(radians));
            f3 = (float) (d5 * java.lang.Math.sin(radians));
            this.a.moveTo(cos, f3);
            d = radians + ((f10 * f12) / 2.0f);
            f = cos;
            f2 = f11;
        } else {
            i = i2;
            double d6 = floatValue2;
            float cos2 = (float) (java.lang.Math.cos(radians) * d6);
            float sin = (float) (d6 * java.lang.Math.sin(radians));
            this.a.moveTo(cos2, sin);
            f = cos2;
            f2 = f11;
            d = radians + f2;
            f3 = sin;
            f4 = 0.0f;
        }
        double ceil = java.lang.Math.ceil(d4) * 2.0d;
        int i3 = 0;
        float f13 = f2;
        float f14 = f;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 >= ceil) {
                android.graphics.PointF value = this.g.getValue();
                this.a.offset(value.x, value.y);
                this.a.close();
                return;
            }
            float f15 = z ? floatValue2 : floatValue3;
            if (f4 == 0.0f || d7 != ceil - 2.0d) {
                f5 = f10;
                f6 = f13;
            } else {
                f5 = f10;
                f6 = (f10 * f12) / 2.0f;
            }
            if (f4 == 0.0f || d7 != ceil - 1.0d) {
                d2 = d7;
                f7 = f4;
                f4 = f15;
            } else {
                d2 = d7;
                f7 = f4;
            }
            double d8 = f4;
            double d9 = ceil;
            float cos3 = (float) (d8 * java.lang.Math.cos(d));
            float sin2 = (float) (d8 * java.lang.Math.sin(d));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.a.lineTo(cos3, sin2);
                d3 = d;
                f8 = floatValue4;
                f9 = floatValue5;
            } else {
                f8 = floatValue4;
                double atan2 = (float) (java.lang.Math.atan2(f3, f14) - 1.5707963267948966d);
                float cos4 = (float) java.lang.Math.cos(atan2);
                float sin3 = (float) java.lang.Math.sin(atan2);
                f9 = floatValue5;
                d3 = d;
                double atan22 = (float) (java.lang.Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) java.lang.Math.cos(atan22);
                float sin4 = (float) java.lang.Math.sin(atan22);
                float f16 = z ? f8 : f9;
                float f17 = z ? f9 : f8;
                float f18 = (z ? floatValue3 : floatValue2) * f16 * 0.47829f;
                float f19 = cos4 * f18;
                float f20 = f18 * sin3;
                float f21 = (z ? floatValue2 : floatValue3) * f17 * 0.47829f;
                float f22 = cos5 * f21;
                float f23 = f21 * sin4;
                if (i != 0) {
                    if (i3 == 0) {
                        f19 *= f12;
                        f20 *= f12;
                    } else if (d2 == d9 - 1.0d) {
                        f22 *= f12;
                        f23 *= f12;
                    }
                }
                this.a.cubicTo(f14 - f19, f3 - f20, cos3 + f22, sin2 + f23, cos3, sin2);
            }
            d = d3 + f6;
            z = !z;
            i3++;
            f14 = cos3;
            f3 = sin2;
            floatValue5 = f9;
            floatValue4 = f8;
            f4 = f7;
            f10 = f5;
            ceil = d9;
        }
    }

    public final void c() {
        this.n = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public android.graphics.Path getPath() {
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        int i = com.airbnb.lottie.animation.content.PolystarContent.AnonymousClass1.a[this.d.ordinal()];
        if (i == 1) {
            b();
        } else if (i == 2) {
            a();
        }
        this.a.close();
        this.m.apply(this.a);
        this.n = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        c();
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
                    this.m.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
