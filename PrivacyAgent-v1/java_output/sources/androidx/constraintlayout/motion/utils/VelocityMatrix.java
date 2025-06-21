package androidx.constraintlayout.motion.utils;

/* loaded from: classes.dex */
public class VelocityMatrix {
    private static java.lang.String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f, float f2, int i, int i2, float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = (f2 - 0.5f) * 2.0f;
        float f6 = f3 + this.mDTranslateX;
        float f7 = f4 + this.mDTranslateY;
        float f8 = f6 + (this.mDScaleX * (f - 0.5f) * 2.0f);
        float f9 = f7 + (this.mDScaleY * f5);
        float radians = (float) java.lang.Math.toRadians(this.mRotate);
        float radians2 = (float) java.lang.Math.toRadians(this.mDRotate);
        double d = radians;
        double d2 = i2 * f5;
        float sin = f8 + (((float) ((((-i) * r7) * java.lang.Math.sin(d)) - (java.lang.Math.cos(d) * d2))) * radians2);
        float cos = f9 + (radians2 * ((float) (((i * r7) * java.lang.Math.cos(d)) - (d2 * java.lang.Math.sin(d)))));
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator, float f) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f);
        }
    }

    public void setRotationVelocity(androidx.constraintlayout.motion.widget.SplineSet splineSet, float f) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f);
            this.mRotate = splineSet.get(f);
        }
    }

    public void setScaleVelocity(androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator, androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator == null && keyCycleOscillator2 == null) {
            return;
        }
        if (keyCycleOscillator == null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 == null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f);
        }
    }

    public void setScaleVelocity(androidx.constraintlayout.motion.widget.SplineSet splineSet, androidx.constraintlayout.motion.widget.SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f);
        }
    }

    public void setTranslationVelocity(androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator, androidx.constraintlayout.motion.widget.KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f);
        }
    }

    public void setTranslationVelocity(androidx.constraintlayout.motion.widget.SplineSet splineSet, androidx.constraintlayout.motion.widget.SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f);
        }
    }
}
