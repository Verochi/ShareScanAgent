package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public class ImageLayer extends com.airbnb.lottie.model.layer.BaseLayer {
    public final android.graphics.Rect A;
    public final android.graphics.Rect B;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> C;
    public final android.graphics.Paint z;

    public ImageLayer(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.Layer layer) {
        super(lottieDrawable, layer);
        this.z = new com.airbnb.lottie.animation.LPaint(3);
        this.A = new android.graphics.Rect();
        this.B = new android.graphics.Rect();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == com.airbnb.lottie.LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.C = null;
            } else {
                this.C = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(@androidx.annotation.NonNull android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        android.graphics.Bitmap y = y();
        if (y == null || y.isRecycled()) {
            return;
        }
        float dpScale = com.airbnb.lottie.utils.Utils.dpScale();
        this.z.setAlpha(i);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.C;
        if (baseKeyframeAnimation != null) {
            this.z.setColorFilter(baseKeyframeAnimation.getValue());
        }
        canvas.save();
        canvas.concat(matrix);
        this.A.set(0, 0, y.getWidth(), y.getHeight());
        this.B.set(0, 0, (int) (y.getWidth() * dpScale), (int) (y.getHeight() * dpScale));
        canvas.drawBitmap(y, this.A, this.B, this.z);
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        if (y() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * com.airbnb.lottie.utils.Utils.dpScale(), r3.getHeight() * com.airbnb.lottie.utils.Utils.dpScale());
            this.m.mapRect(rectF);
        }
    }

    @androidx.annotation.Nullable
    public final android.graphics.Bitmap y() {
        return this.n.getImageAsset(this.o.i());
    }
}
