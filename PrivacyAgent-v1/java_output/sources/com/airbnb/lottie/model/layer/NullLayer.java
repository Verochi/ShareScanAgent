package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public class NullLayer extends com.airbnb.lottie.model.layer.BaseLayer {
    public NullLayer(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.Layer layer) {
        super(lottieDrawable, layer);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
