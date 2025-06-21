package com.google.android.material.animation;

/* loaded from: classes22.dex */
public class ArgbEvaluatorCompat implements android.animation.TypeEvaluator<java.lang.Integer> {
    private static final com.google.android.material.animation.ArgbEvaluatorCompat instance = new com.google.android.material.animation.ArgbEvaluatorCompat();

    @androidx.annotation.NonNull
    public static com.google.android.material.animation.ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    @Override // android.animation.TypeEvaluator
    @androidx.annotation.NonNull
    public java.lang.Integer evaluate(float f, java.lang.Integer num, java.lang.Integer num2) {
        int intValue = num.intValue();
        float f2 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) java.lang.Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) java.lang.Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) java.lang.Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) java.lang.Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f3 = f2 + (((((intValue2 >> 24) & 255) / 255.0f) - f2) * f);
        float pow5 = pow2 + ((((float) java.lang.Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f);
        float pow6 = pow3 + (f * (((float) java.lang.Math.pow((intValue2 & 255) / 255.0f, 2.2d)) - pow3));
        return java.lang.Integer.valueOf((java.lang.Math.round(((float) java.lang.Math.pow(pow + ((pow4 - pow) * f), 0.45454545454545453d)) * 255.0f) << 16) | (java.lang.Math.round(f3 * 255.0f) << 24) | (java.lang.Math.round(((float) java.lang.Math.pow(pow5, 0.45454545454545453d)) * 255.0f) << 8) | java.lang.Math.round(((float) java.lang.Math.pow(pow6, 0.45454545454545453d)) * 255.0f));
    }
}
