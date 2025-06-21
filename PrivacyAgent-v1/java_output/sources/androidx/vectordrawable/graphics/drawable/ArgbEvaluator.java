package androidx.vectordrawable.graphics.drawable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ArgbEvaluator implements android.animation.TypeEvaluator {
    private static final androidx.vectordrawable.graphics.drawable.ArgbEvaluator sInstance = new androidx.vectordrawable.graphics.drawable.ArgbEvaluator();

    public static androidx.vectordrawable.graphics.drawable.ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public java.lang.Object evaluate(float f, java.lang.Object obj, java.lang.Object obj2) {
        int intValue = ((java.lang.Integer) obj).intValue();
        float f2 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = ((java.lang.Integer) obj2).intValue();
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
