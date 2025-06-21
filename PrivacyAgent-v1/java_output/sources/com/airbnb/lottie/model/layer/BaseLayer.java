package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public abstract class BaseLayer implements com.airbnb.lottie.animation.content.DrawingContent, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener, com.airbnb.lottie.model.KeyPathElement {
    public final android.graphics.Path a = new android.graphics.Path();
    public final android.graphics.Matrix b = new android.graphics.Matrix();
    public final android.graphics.Paint c = new com.airbnb.lottie.animation.LPaint(1);
    public final android.graphics.Paint d = new com.airbnb.lottie.animation.LPaint(1, android.graphics.PorterDuff.Mode.DST_IN);
    public final android.graphics.Paint e = new com.airbnb.lottie.animation.LPaint(1, android.graphics.PorterDuff.Mode.DST_OUT);
    public final android.graphics.Paint f;
    public final android.graphics.Paint g;
    public final android.graphics.RectF h;
    public final android.graphics.RectF i;
    public final android.graphics.RectF j;
    public final android.graphics.RectF k;
    public final java.lang.String l;
    public final android.graphics.Matrix m;
    public final com.airbnb.lottie.LottieDrawable n;
    public final com.airbnb.lottie.model.layer.Layer o;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation p;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation q;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.layer.BaseLayer r;

    /* renamed from: s, reason: collision with root package name */
    @androidx.annotation.Nullable
    public com.airbnb.lottie.model.layer.BaseLayer f77s;
    public java.util.List<com.airbnb.lottie.model.layer.BaseLayer> t;
    public final java.util.List<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, ?>> u;
    public final com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation v;
    public boolean w;
    public boolean x;

    @androidx.annotation.Nullable
    public android.graphics.Paint y;

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$1, reason: invalid class name */
    public class AnonymousClass1 implements com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener {
        public AnonymousClass1() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
        public void onValueChanged() {
            com.airbnb.lottie.model.layer.BaseLayer baseLayer = com.airbnb.lottie.model.layer.BaseLayer.this;
            baseLayer.w(baseLayer.q.getFloatValue() == 1.0f);
        }
    }

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.content.Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                b[com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                b[com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.airbnb.lottie.model.layer.Layer.LayerType.values().length];
            a = iArr2;
            try {
                iArr2[com.airbnb.lottie.model.layer.Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.LayerType.NULL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
        }
    }

    public BaseLayer(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.Layer layer) {
        com.airbnb.lottie.animation.LPaint lPaint = new com.airbnb.lottie.animation.LPaint(1);
        this.f = lPaint;
        this.g = new com.airbnb.lottie.animation.LPaint(android.graphics.PorterDuff.Mode.CLEAR);
        this.h = new android.graphics.RectF();
        this.i = new android.graphics.RectF();
        this.j = new android.graphics.RectF();
        this.k = new android.graphics.RectF();
        this.m = new android.graphics.Matrix();
        this.u = new java.util.ArrayList();
        this.w = true;
        this.n = lottieDrawable;
        this.o = layer;
        this.l = layer.e() + "#draw";
        if (layer.d() == com.airbnb.lottie.model.layer.Layer.MatteType.INVERT) {
            lPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        } else {
            lPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        }
        com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation createAnimation = layer.s().createAnimation();
        this.v = createAnimation;
        createAnimation.addListener(this);
        if (layer.c() != null && !layer.c().isEmpty()) {
            com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation maskKeyframeAnimation = new com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation(layer.c());
            this.p = maskKeyframeAnimation;
            java.util.Iterator<com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path>> it = maskKeyframeAnimation.getMaskAnimations().iterator();
            while (it.hasNext()) {
                it.next().addUpdateListener(this);
            }
            for (com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation : this.p.getOpacityAnimations()) {
                addAnimation(baseKeyframeAnimation);
                baseKeyframeAnimation.addUpdateListener(this);
            }
        }
        x();
    }

    @androidx.annotation.Nullable
    public static com.airbnb.lottie.model.layer.BaseLayer m(com.airbnb.lottie.model.layer.Layer layer, com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.LottieComposition lottieComposition) {
        switch (com.airbnb.lottie.model.layer.BaseLayer.AnonymousClass2.a[layer.getLayerType().ordinal()]) {
            case 1:
                return new com.airbnb.lottie.model.layer.ShapeLayer(lottieDrawable, layer);
            case 2:
                return new com.airbnb.lottie.model.layer.CompositionLayer(lottieDrawable, layer, lottieComposition.getPrecomps(layer.i()), lottieComposition);
            case 3:
                return new com.airbnb.lottie.model.layer.SolidLayer(lottieDrawable, layer);
            case 4:
                return new com.airbnb.lottie.model.layer.ImageLayer(lottieDrawable, layer);
            case 5:
                return new com.airbnb.lottie.model.layer.NullLayer(lottieDrawable, layer);
            case 6:
                return new com.airbnb.lottie.model.layer.TextLayer(lottieDrawable, layer);
            default:
                com.airbnb.lottie.utils.Logger.warning("Unknown layer type " + layer.getLayerType());
                return null;
        }
    }

    public void addAnimation(@androidx.annotation.Nullable com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.u.add(baseKeyframeAnimation);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    @androidx.annotation.CallSuper
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        this.v.applyValueCallback(t, lottieValueCallback);
    }

    public final void c(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.model.content.Mask mask, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> baseKeyframeAnimation, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2) {
        this.a.set(baseKeyframeAnimation.getValue());
        this.a.transform(matrix);
        this.c.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
    }

    public final void d(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.model.content.Mask mask, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> baseKeyframeAnimation, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2) {
        com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.h, this.d);
        this.a.set(baseKeyframeAnimation.getValue());
        this.a.transform(matrix);
        this.c.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.a, this.c);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        android.graphics.Paint paint;
        com.airbnb.lottie.L.beginSection(this.l);
        if (!this.w || this.o.isHidden()) {
            com.airbnb.lottie.L.endSection(this.l);
            return;
        }
        k();
        com.airbnb.lottie.L.beginSection("Layer#parentMatrix");
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.b.preConcat(this.t.get(size).v.getMatrix());
        }
        com.airbnb.lottie.L.endSection("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * (this.v.getOpacity() == null ? 100 : this.v.getOpacity().getValue().intValue())) / 100.0f) * 255.0f);
        if (!p() && !o()) {
            this.b.preConcat(this.v.getMatrix());
            com.airbnb.lottie.L.beginSection("Layer#drawLayer");
            drawLayer(canvas, this.b, intValue);
            com.airbnb.lottie.L.endSection("Layer#drawLayer");
            t(com.airbnb.lottie.L.endSection(this.l));
            return;
        }
        com.airbnb.lottie.L.beginSection("Layer#computeBounds");
        getBounds(this.h, this.b, false);
        r(this.h, matrix);
        this.b.preConcat(this.v.getMatrix());
        q(this.h, this.b);
        if (!this.h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.airbnb.lottie.L.endSection("Layer#computeBounds");
        if (this.h.width() >= 1.0f && this.h.height() >= 1.0f) {
            com.airbnb.lottie.L.beginSection("Layer#saveLayer");
            this.c.setAlpha(255);
            com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.h, this.c);
            com.airbnb.lottie.L.endSection("Layer#saveLayer");
            l(canvas);
            com.airbnb.lottie.L.beginSection("Layer#drawLayer");
            drawLayer(canvas, this.b, intValue);
            com.airbnb.lottie.L.endSection("Layer#drawLayer");
            if (o()) {
                h(canvas, this.b);
            }
            if (p()) {
                com.airbnb.lottie.L.beginSection("Layer#drawMatte");
                com.airbnb.lottie.L.beginSection("Layer#saveLayer");
                com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.h, this.f, 19);
                com.airbnb.lottie.L.endSection("Layer#saveLayer");
                l(canvas);
                this.r.draw(canvas, matrix, intValue);
                com.airbnb.lottie.L.beginSection("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.L.endSection("Layer#restoreLayer");
                com.airbnb.lottie.L.endSection("Layer#drawMatte");
            }
            com.airbnb.lottie.L.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.L.endSection("Layer#restoreLayer");
        }
        if (this.x && (paint = this.y) != null) {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            this.y.setColor(-251901);
            this.y.setStrokeWidth(4.0f);
            canvas.drawRect(this.h, this.y);
            this.y.setStyle(android.graphics.Paint.Style.FILL);
            this.y.setColor(1357638635);
            canvas.drawRect(this.h, this.y);
        }
        t(com.airbnb.lottie.L.endSection(this.l));
    }

    public abstract void drawLayer(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i);

    public final void e(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.model.content.Mask mask, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> baseKeyframeAnimation, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2) {
        com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.h, this.c);
        canvas.drawRect(this.h, this.c);
        this.a.set(baseKeyframeAnimation.getValue());
        this.a.transform(matrix);
        this.c.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    public final void f(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.model.content.Mask mask, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> baseKeyframeAnimation, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2) {
        com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.h, this.d);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        this.a.set(baseKeyframeAnimation.getValue());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    public final void g(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.model.content.Mask mask, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> baseKeyframeAnimation, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2) {
        com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.h, this.e);
        canvas.drawRect(this.h, this.c);
        this.e.setAlpha((int) (baseKeyframeAnimation2.getValue().intValue() * 2.55f));
        this.a.set(baseKeyframeAnimation.getValue());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    @androidx.annotation.CallSuper
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        k();
        this.m.set(matrix);
        if (z) {
            java.util.List<com.airbnb.lottie.model.layer.BaseLayer> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.getMatrix());
                }
            } else {
                com.airbnb.lottie.model.layer.BaseLayer baseLayer = this.f77s;
                if (baseLayer != null) {
                    this.m.preConcat(baseLayer.v.getMatrix());
                }
            }
        }
        this.m.preConcat(this.v.getMatrix());
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.o.e();
    }

    public final void h(android.graphics.Canvas canvas, android.graphics.Matrix matrix) {
        com.airbnb.lottie.L.beginSection("Layer#saveLayer");
        com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.h, this.d, 19);
        if (android.os.Build.VERSION.SDK_INT < 28) {
            l(canvas);
        }
        com.airbnb.lottie.L.endSection("Layer#saveLayer");
        for (int i = 0; i < this.p.getMasks().size(); i++) {
            com.airbnb.lottie.model.content.Mask mask = this.p.getMasks().get(i);
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> baseKeyframeAnimation = this.p.getMaskAnimations().get(i);
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2 = this.p.getOpacityAnimations().get(i);
            int i2 = com.airbnb.lottie.model.layer.BaseLayer.AnonymousClass2.b[mask.getMaskMode().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.c.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                        this.c.setAlpha(255);
                        canvas.drawRect(this.h, this.c);
                    }
                    if (mask.isInverted()) {
                        g(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        i(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (mask.isInverted()) {
                            e(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            c(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask.isInverted()) {
                    f(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    d(canvas, matrix, mask, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (j()) {
                this.c.setAlpha(255);
                canvas.drawRect(this.h, this.c);
            }
        }
        com.airbnb.lottie.L.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.L.endSection("Layer#restoreLayer");
    }

    public final void i(android.graphics.Canvas canvas, android.graphics.Matrix matrix, com.airbnb.lottie.model.content.Mask mask, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.ShapeData, android.graphics.Path> baseKeyframeAnimation, com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> baseKeyframeAnimation2) {
        this.a.set(baseKeyframeAnimation.getValue());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.e);
    }

    public final boolean j() {
        if (this.p.getMaskAnimations().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.p.getMasks().size(); i++) {
            if (this.p.getMasks().get(i).getMaskMode() != com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void k() {
        if (this.t != null) {
            return;
        }
        if (this.f77s == null) {
            this.t = java.util.Collections.emptyList();
            return;
        }
        this.t = new java.util.ArrayList();
        for (com.airbnb.lottie.model.layer.BaseLayer baseLayer = this.f77s; baseLayer != null; baseLayer = baseLayer.f77s) {
            this.t.add(baseLayer);
        }
    }

    public final void l(android.graphics.Canvas canvas) {
        com.airbnb.lottie.L.beginSection("Layer#clearLayer");
        android.graphics.RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        com.airbnb.lottie.L.endSection("Layer#clearLayer");
    }

    public com.airbnb.lottie.model.layer.Layer n() {
        return this.o;
    }

    public boolean o() {
        com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation maskKeyframeAnimation = this.p;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.getMaskAnimations().isEmpty()) ? false : true;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        s();
    }

    public boolean p() {
        return this.r != null;
    }

    public final void q(android.graphics.RectF rectF, android.graphics.Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (o()) {
            int size = this.p.getMasks().size();
            for (int i = 0; i < size; i++) {
                com.airbnb.lottie.model.content.Mask mask = this.p.getMasks().get(i);
                this.a.set(this.p.getMaskAnimations().get(i).getValue());
                this.a.transform(matrix);
                int i2 = com.airbnb.lottie.model.layer.BaseLayer.AnonymousClass2.b[mask.getMaskMode().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                if ((i2 == 3 || i2 == 4) && mask.isInverted()) {
                    return;
                }
                this.a.computeBounds(this.k, false);
                if (i == 0) {
                    this.i.set(this.k);
                } else {
                    android.graphics.RectF rectF2 = this.i;
                    rectF2.set(java.lang.Math.min(rectF2.left, this.k.left), java.lang.Math.min(this.i.top, this.k.top), java.lang.Math.max(this.i.right, this.k.right), java.lang.Math.max(this.i.bottom, this.k.bottom));
                }
            }
            if (rectF.intersect(this.i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void r(android.graphics.RectF rectF, android.graphics.Matrix matrix) {
        if (p() && this.o.d() != com.airbnb.lottie.model.layer.Layer.MatteType.INVERT) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.getBounds(this.j, matrix, true);
            if (rectF.intersect(this.j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void removeAnimation(com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.u.remove(baseKeyframeAnimation);
    }

    public void resolveChildKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        com.airbnb.lottie.model.layer.BaseLayer baseLayer = this.r;
        if (baseLayer != null) {
            com.airbnb.lottie.model.KeyPath addKey = keyPath2.addKey(baseLayer.getName());
            if (keyPath.fullyResolvesTo(this.r.getName(), i)) {
                list.add(addKey.resolve(this.r));
            }
            if (keyPath.propagateToChildren(getName(), i)) {
                this.r.resolveChildKeyPath(keyPath, keyPath.incrementDepthBy(this.r.getName(), i) + i, list, addKey);
            }
        }
        if (keyPath.matches(getName(), i)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i)) {
                resolveChildKeyPath(keyPath, i + keyPath.incrementDepthBy(getName(), i), list, keyPath2);
            }
        }
    }

    public final void s() {
        this.n.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
    }

    public void setOutlineMasksAndMattes(boolean z) {
        if (z && this.y == null) {
            this.y = new com.airbnb.lottie.animation.LPaint();
        }
        this.x = z;
    }

    public void setProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.v.setProgress(f);
        if (this.p != null) {
            for (int i = 0; i < this.p.getMaskAnimations().size(); i++) {
                this.p.getMaskAnimations().get(i).setProgress(f);
            }
        }
        if (this.o.r() != 0.0f) {
            f /= this.o.r();
        }
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation = this.q;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f / this.o.r());
        }
        com.airbnb.lottie.model.layer.BaseLayer baseLayer = this.r;
        if (baseLayer != null) {
            this.r.setProgress(baseLayer.o.r() * f);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).setProgress(f);
        }
    }

    public final void t(float f) {
        this.n.getComposition().getPerformanceTracker().recordRenderTime(this.o.e(), f);
    }

    public void u(@androidx.annotation.Nullable com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        this.r = baseLayer;
    }

    public void v(@androidx.annotation.Nullable com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        this.f77s = baseLayer;
    }

    public final void w(boolean z) {
        if (z != this.w) {
            this.w = z;
            s();
        }
    }

    public final void x() {
        if (this.o.b().isEmpty()) {
            w(true);
            return;
        }
        com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation floatKeyframeAnimation = new com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation(this.o.b());
        this.q = floatKeyframeAnimation;
        floatKeyframeAnimation.setIsDiscrete();
        this.q.addUpdateListener(new com.airbnb.lottie.model.layer.BaseLayer.AnonymousClass1());
        w(this.q.getValue().floatValue() == 1.0f);
        addAnimation(this.q);
    }
}
