package com.airbnb.lottie.model.layer;

/* loaded from: classes.dex */
public class SolidLayer extends com.airbnb.lottie.model.layer.BaseLayer {
    public final android.graphics.Paint A;
    public final float[] B;
    public final android.graphics.Path C;
    public final com.airbnb.lottie.model.layer.Layer D;

    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> E;
    public final android.graphics.RectF z;

    public SolidLayer(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.Layer layer) {
        super(lottieDrawable, layer);
        this.z = new android.graphics.RectF();
        com.airbnb.lottie.animation.LPaint lPaint = new com.airbnb.lottie.animation.LPaint();
        this.A = lPaint;
        this.B = new float[8];
        this.C = new android.graphics.Path();
        this.D = layer;
        lPaint.setAlpha(0);
        lPaint.setStyle(android.graphics.Paint.Style.FILL);
        lPaint.setColor(layer.k());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @androidx.annotation.Nullable com.airbnb.lottie.value.LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == com.airbnb.lottie.LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.E = null;
            } else {
                this.E = new com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        int alpha = android.graphics.Color.alpha(this.D.k());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * (this.v.getOpacity() == null ? 100 : this.v.getOpacity().getValue().intValue())) / 100.0f) * 255.0f);
        this.A.setAlpha(intValue);
        com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.ColorFilter, android.graphics.ColorFilter> baseKeyframeAnimation = this.E;
        if (baseKeyframeAnimation != null) {
            this.A.setColorFilter(baseKeyframeAnimation.getValue());
        }
        if (intValue > 0) {
            float[] fArr = this.B;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.D.m();
            float[] fArr2 = this.B;
            fArr2[3] = 0.0f;
            fArr2[4] = this.D.m();
            this.B[5] = this.D.l();
            float[] fArr3 = this.B;
            fArr3[6] = 0.0f;
            fArr3[7] = this.D.l();
            matrix.mapPoints(this.B);
            this.C.reset();
            android.graphics.Path path = this.C;
            float[] fArr4 = this.B;
            path.moveTo(fArr4[0], fArr4[1]);
            android.graphics.Path path2 = this.C;
            float[] fArr5 = this.B;
            path2.lineTo(fArr5[2], fArr5[3]);
            android.graphics.Path path3 = this.C;
            float[] fArr6 = this.B;
            path3.lineTo(fArr6[4], fArr6[5]);
            android.graphics.Path path4 = this.C;
            float[] fArr7 = this.B;
            path4.lineTo(fArr7[6], fArr7[7]);
            android.graphics.Path path5 = this.C;
            float[] fArr8 = this.B;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.C.close();
            canvas.drawPath(this.C, this.A);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.z.set(0.0f, 0.0f, this.D.m(), this.D.l());
        this.m.mapRect(this.z);
        rectF.set(this.z);
    }
}
