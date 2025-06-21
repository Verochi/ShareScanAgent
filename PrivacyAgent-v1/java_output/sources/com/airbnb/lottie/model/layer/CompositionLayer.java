package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public class CompositionLayer extends com.airbnb.lottie.model.layer.BaseLayer {
    public final java.util.List<com.airbnb.lottie.model.layer.BaseLayer> A;
    public final android.graphics.RectF B;
    public final android.graphics.RectF C;
    public android.graphics.Paint D;

    @androidx.annotation.Nullable
    public java.lang.Boolean E;

    @androidx.annotation.Nullable
    public java.lang.Boolean F;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> z;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.layer.Layer.MatteType.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.model.layer.Layer.MatteType.ADD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.model.layer.Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.Layer layer, java.util.List<com.airbnb.lottie.model.layer.Layer> list, com.airbnb.lottie.LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i;
        com.airbnb.lottie.model.layer.BaseLayer baseLayer;
        this.A = new java.util.ArrayList();
        this.B = new android.graphics.RectF();
        this.C = new android.graphics.RectF();
        this.D = new android.graphics.Paint();
        com.airbnb.lottie.model.animatable.AnimatableFloatValue q = layer.q();
        if (q != null) {
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> createAnimation = q.createAnimation();
            this.z = createAnimation;
            addAnimation(createAnimation);
            this.z.addUpdateListener(this);
        } else {
            this.z = null;
        }
        androidx.collection.LongSparseArray longSparseArray = new androidx.collection.LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            com.airbnb.lottie.model.layer.Layer layer2 = list.get(size);
            com.airbnb.lottie.model.layer.BaseLayer m = com.airbnb.lottie.model.layer.BaseLayer.m(layer2, lottieDrawable, lottieComposition);
            if (m != null) {
                longSparseArray.put(m.n().getId(), m);
                if (baseLayer2 != null) {
                    baseLayer2.u(m);
                    baseLayer2 = null;
                } else {
                    this.A.add(0, m);
                    int i2 = com.airbnb.lottie.model.layer.CompositionLayer.AnonymousClass1.a[layer2.d().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        baseLayer2 = m;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            com.airbnb.lottie.model.layer.BaseLayer baseLayer3 = (com.airbnb.lottie.model.layer.BaseLayer) longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer3 != null && (baseLayer = (com.airbnb.lottie.model.layer.BaseLayer) longSparseArray.get(baseLayer3.n().f())) != null) {
                baseLayer3.v(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == com.airbnb.lottie.LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> baseKeyframeAnimation = this.z;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.setValueCallback(null);
                    return;
                }
                return;
            }
            com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.z = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        com.airbnb.lottie.L.beginSection("CompositionLayer#draw");
        this.C.set(0.0f, 0.0f, this.o.h(), this.o.g());
        matrix.mapRect(this.C);
        boolean z = this.n.isApplyingOpacityToLayersEnabled() && this.A.size() > 1 && i != 255;
        if (z) {
            this.D.setAlpha(i);
            com.airbnb.lottie.utils.Utils.saveLayerCompat(canvas, this.C, this.D);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (!this.C.isEmpty() ? canvas.clipRect(this.C) : true) {
                this.A.get(size).draw(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.airbnb.lottie.L.endSection("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.B.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.A.get(size).getBounds(this.B, this.m, true);
            rectF.union(this.B);
        }
    }

    public boolean hasMasks() {
        if (this.F == null) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.layer.BaseLayer baseLayer = this.A.get(size);
                if (baseLayer instanceof com.airbnb.lottie.model.layer.ShapeLayer) {
                    if (baseLayer.o()) {
                        this.F = java.lang.Boolean.TRUE;
                        return true;
                    }
                } else if ((baseLayer instanceof com.airbnb.lottie.model.layer.CompositionLayer) && ((com.airbnb.lottie.model.layer.CompositionLayer) baseLayer).hasMasks()) {
                    this.F = java.lang.Boolean.TRUE;
                    return true;
                }
            }
            this.F = java.lang.Boolean.FALSE;
        }
        return this.F.booleanValue();
    }

    public boolean hasMatte() {
        if (this.E == null) {
            if (p()) {
                this.E = java.lang.Boolean.TRUE;
                return true;
            }
            for (int size = this.A.size() - 1; size >= 0; size--) {
                if (this.A.get(size).p()) {
                    this.E = java.lang.Boolean.TRUE;
                    return true;
                }
            }
            this.E = java.lang.Boolean.FALSE;
        }
        return this.E.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            this.A.get(i2).resolveKeyPath(keyPath, i, list, keyPath2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setOutlineMasksAndMattes(boolean z) {
        super.setOutlineMasksAndMattes(z);
        java.util.Iterator<com.airbnb.lottie.model.layer.BaseLayer> it = this.A.iterator();
        while (it.hasNext()) {
            it.next().setOutlineMasksAndMattes(z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void setProgress(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.setProgress(f);
        if (this.z != null) {
            f = ((this.z.getValue().floatValue() * this.o.a().getFrameRate()) - this.o.a().getStartFrame()) / (this.n.getComposition().getDurationFrames() + 0.01f);
        }
        if (this.z == null) {
            f -= this.o.n();
        }
        if (this.o.r() != 0.0f) {
            f /= this.o.r();
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).setProgress(f);
        }
    }
}
