package androidx.dynamicanimation.animation;

/* loaded from: classes.dex */
public final class SpringForce implements androidx.dynamicanimation.animation.Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final androidx.dynamicanimation.animation.DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = java.lang.Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new androidx.dynamicanimation.animation.DynamicAnimation.MassState();
    }

    public SpringForce(float f) {
        this.mNaturalFreq = java.lang.Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new androidx.dynamicanimation.animation.DynamicAnimation.MassState();
        this.mFinalPosition = f;
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition == Double.MAX_VALUE) {
            throw new java.lang.IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d = this.mDampingRatio;
        if (d > 1.0d) {
            double d2 = this.mNaturalFreq;
            this.mGammaPlus = ((-d) * d2) + (d2 * java.lang.Math.sqrt((d * d) - 1.0d));
            double d3 = this.mDampingRatio;
            double d4 = this.mNaturalFreq;
            this.mGammaMinus = ((-d3) * d4) - (d4 * java.lang.Math.sqrt((d3 * d3) - 1.0d));
        } else if (d >= 0.0d && d < 1.0d) {
            this.mDampedFreq = this.mNaturalFreq * java.lang.Math.sqrt(1.0d - (d * d));
        }
        this.mInitialized = true;
    }

    @Override // androidx.dynamicanimation.animation.Force
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f, float f2) {
        float finalPosition = f - getFinalPosition();
        double d = this.mNaturalFreq;
        return (float) (((-(d * d)) * finalPosition) - (((d * 2.0d) * this.mDampingRatio) * f2));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d = this.mNaturalFreq;
        return (float) (d * d);
    }

    @Override // androidx.dynamicanimation.animation.Force
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f, float f2) {
        return ((double) java.lang.Math.abs(f2)) < this.mVelocityThreshold && ((double) java.lang.Math.abs(f - getFinalPosition())) < this.mValueThreshold;
    }

    public androidx.dynamicanimation.animation.SpringForce setDampingRatio(@androidx.annotation.FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new java.lang.IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.mDampingRatio = f;
        this.mInitialized = false;
        return this;
    }

    public androidx.dynamicanimation.animation.SpringForce setFinalPosition(float f) {
        this.mFinalPosition = f;
        return this;
    }

    public androidx.dynamicanimation.animation.SpringForce setStiffness(@androidx.annotation.FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.mNaturalFreq = java.lang.Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public void setValueThreshold(double d) {
        double abs = java.lang.Math.abs(d);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public androidx.dynamicanimation.animation.DynamicAnimation.MassState updateValues(double d, double d2, long j) {
        double cos;
        double d3;
        init();
        double d4 = j / 1000.0d;
        double d5 = d - this.mFinalPosition;
        double d6 = this.mDampingRatio;
        if (d6 > 1.0d) {
            double d7 = this.mGammaMinus;
            double d8 = this.mGammaPlus;
            double d9 = d5 - (((d7 * d5) - d2) / (d7 - d8));
            double d10 = ((d5 * d7) - d2) / (d7 - d8);
            d3 = (java.lang.Math.pow(2.718281828459045d, d7 * d4) * d9) + (java.lang.Math.pow(2.718281828459045d, this.mGammaPlus * d4) * d10);
            double d11 = this.mGammaMinus;
            double pow = d9 * d11 * java.lang.Math.pow(2.718281828459045d, d11 * d4);
            double d12 = this.mGammaPlus;
            cos = pow + (d10 * d12 * java.lang.Math.pow(2.718281828459045d, d12 * d4));
        } else if (d6 == 1.0d) {
            double d13 = this.mNaturalFreq;
            double d14 = d2 + (d13 * d5);
            double d15 = d5 + (d14 * d4);
            d3 = java.lang.Math.pow(2.718281828459045d, (-d13) * d4) * d15;
            double pow2 = d15 * java.lang.Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d4);
            double d16 = this.mNaturalFreq;
            cos = (d14 * java.lang.Math.pow(2.718281828459045d, (-d16) * d4)) + (pow2 * (-d16));
        } else {
            double d17 = 1.0d / this.mDampedFreq;
            double d18 = this.mNaturalFreq;
            double d19 = d17 * ((d6 * d18 * d5) + d2);
            double pow3 = java.lang.Math.pow(2.718281828459045d, (-d6) * d18 * d4) * ((java.lang.Math.cos(this.mDampedFreq * d4) * d5) + (java.lang.Math.sin(this.mDampedFreq * d4) * d19));
            double d20 = this.mNaturalFreq;
            double d21 = this.mDampingRatio;
            double d22 = (-d20) * pow3 * d21;
            double pow4 = java.lang.Math.pow(2.718281828459045d, (-d21) * d20 * d4);
            double d23 = this.mDampedFreq;
            double sin = (-d23) * d5 * java.lang.Math.sin(d23 * d4);
            double d24 = this.mDampedFreq;
            cos = d22 + (pow4 * (sin + (d19 * d24 * java.lang.Math.cos(d24 * d4))));
            d3 = pow3;
        }
        androidx.dynamicanimation.animation.DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (d3 + this.mFinalPosition);
        massState.mVelocity = (float) cos;
        return massState;
    }
}
