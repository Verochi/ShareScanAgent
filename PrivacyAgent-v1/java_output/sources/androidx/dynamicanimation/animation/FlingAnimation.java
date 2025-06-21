package androidx.dynamicanimation.animation;

/* loaded from: classes.dex */
public final class FlingAnimation extends androidx.dynamicanimation.animation.DynamicAnimation<androidx.dynamicanimation.animation.FlingAnimation> {
    private final androidx.dynamicanimation.animation.FlingAnimation.DragForce mFlingForce;

    public static final class DragForce implements androidx.dynamicanimation.animation.Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final androidx.dynamicanimation.animation.DynamicAnimation.MassState mMassState = new androidx.dynamicanimation.animation.DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f, float f2) {
            return f2 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f, float f2) {
            return java.lang.Math.abs(f2) < this.mVelocityThreshold;
        }

        public void setFrictionScalar(float f) {
            this.mFriction = f * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float f) {
            this.mVelocityThreshold = f * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public androidx.dynamicanimation.animation.DynamicAnimation.MassState updateValueAndVelocity(float f, float f2, long j) {
            float f3 = j;
            this.mMassState.mVelocity = (float) (f2 * java.lang.Math.exp((f3 / 1000.0f) * this.mFriction));
            androidx.dynamicanimation.animation.DynamicAnimation.MassState massState = this.mMassState;
            float f4 = this.mFriction;
            massState.mValue = (float) ((f - (f2 / f4)) + ((f2 / f4) * java.lang.Math.exp((f4 * f3) / 1000.0f)));
            androidx.dynamicanimation.animation.DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.mValue, massState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(androidx.dynamicanimation.animation.FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        androidx.dynamicanimation.animation.FlingAnimation.DragForce dragForce = new androidx.dynamicanimation.animation.FlingAnimation.DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    public <K> FlingAnimation(K k, androidx.dynamicanimation.animation.FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        androidx.dynamicanimation.animation.FlingAnimation.DragForce dragForce = new androidx.dynamicanimation.animation.FlingAnimation.DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f, float f2) {
        return this.mFlingForce.getAcceleration(f, f2);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f, float f2) {
        return f >= this.mMaxValue || f <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f, f2);
    }

    public androidx.dynamicanimation.animation.FlingAnimation setFriction(@androidx.annotation.FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public androidx.dynamicanimation.animation.FlingAnimation setMaxValue(float f) {
        super.setMaxValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public androidx.dynamicanimation.animation.FlingAnimation setMinValue(float f) {
        super.setMinValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public androidx.dynamicanimation.animation.FlingAnimation setStartVelocity(float f) {
        super.setStartVelocity(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f) {
        this.mFlingForce.setValueThreshold(f);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j) {
        androidx.dynamicanimation.animation.DynamicAnimation.MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j);
        float f = updateValueAndVelocity.mValue;
        this.mValue = f;
        float f2 = updateValueAndVelocity.mVelocity;
        this.mVelocity = f2;
        float f3 = this.mMinValue;
        if (f < f3) {
            this.mValue = f3;
            return true;
        }
        float f4 = this.mMaxValue;
        if (f <= f4) {
            return isAtEquilibrium(f, f2);
        }
        this.mValue = f4;
        return true;
    }
}
