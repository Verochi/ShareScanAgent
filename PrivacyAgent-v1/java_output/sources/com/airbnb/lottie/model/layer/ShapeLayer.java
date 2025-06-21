package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public class ShapeLayer extends com.airbnb.lottie.model.layer.BaseLayer {
    public final com.airbnb.lottie.animation.content.ContentGroup z;

    public ShapeLayer(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.Layer layer) {
        super(lottieDrawable, layer);
        com.airbnb.lottie.animation.content.ContentGroup contentGroup = new com.airbnb.lottie.animation.content.ContentGroup(lottieDrawable, this, new com.airbnb.lottie.model.content.ShapeGroup("__container", layer.j(), false));
        this.z = contentGroup;
        contentGroup.setContents(java.util.Collections.emptyList(), java.util.Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(@androidx.annotation.NonNull android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        this.z.draw(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.z.getBounds(rectF, this.m, z);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(com.airbnb.lottie.model.KeyPath keyPath, int i, java.util.List<com.airbnb.lottie.model.KeyPath> list, com.airbnb.lottie.model.KeyPath keyPath2) {
        this.z.resolveKeyPath(keyPath, i, list, keyPath2);
    }
}
