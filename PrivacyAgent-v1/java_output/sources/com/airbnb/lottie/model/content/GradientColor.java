package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class GradientColor {
    public final float[] a;
    public final int[] b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    public int[] getColors() {
        return this.b;
    }

    public float[] getPositions() {
        return this.a;
    }

    public int getSize() {
        return this.b.length;
    }

    public void lerp(com.airbnb.lottie.model.content.GradientColor gradientColor, com.airbnb.lottie.model.content.GradientColor gradientColor2, float f) {
        if (gradientColor.b.length == gradientColor2.b.length) {
            for (int i = 0; i < gradientColor.b.length; i++) {
                this.a[i] = com.airbnb.lottie.utils.MiscUtils.lerp(gradientColor.a[i], gradientColor2.a[i], f);
                this.b[i] = com.airbnb.lottie.utils.GammaEvaluator.evaluate(f, gradientColor.b[i], gradientColor2.b[i]);
            }
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.b.length + " vs " + gradientColor2.b.length + ")");
    }
}
