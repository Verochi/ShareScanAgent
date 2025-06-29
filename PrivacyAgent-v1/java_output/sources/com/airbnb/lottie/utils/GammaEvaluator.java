package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class GammaEvaluator {
    public static float a(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) java.lang.Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((java.lang.Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float a = a(((i >> 16) & 255) / 255.0f);
        float a2 = a(((i >> 8) & 255) / 255.0f);
        float a3 = a((i & 255) / 255.0f);
        float a4 = a(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float a5 = a2 + ((a(((i2 >> 8) & 255) / 255.0f) - a2) * f);
        float a6 = a3 + (f * (a((i2 & 255) / 255.0f) - a3));
        return (java.lang.Math.round(b(a + ((a4 - a) * f)) * 255.0f) << 16) | (java.lang.Math.round(f3 * 255.0f) << 24) | (java.lang.Math.round(b(a5) * 255.0f) << 8) | java.lang.Math.round(b(a6) * 255.0f);
    }
}
