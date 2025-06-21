package androidx.constraintlayout.motion.utils;

/* loaded from: classes.dex */
public class StopLogic extends androidx.constraintlayout.motion.widget.MotionInterpolator {
    private boolean mBackwards = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private java.lang.String mType;

    private float calcY(float f) {
        float f2 = this.mStage1Duration;
        if (f <= f2) {
            float f3 = this.mStage1Velocity;
            return (f3 * f) + ((((this.mStage2Velocity - f3) * f) * f) / (f2 * 2.0f));
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return this.mStage1EndPosition;
        }
        float f4 = f - f2;
        float f5 = this.mStage2Duration;
        if (f4 < f5) {
            float f6 = this.mStage1EndPosition;
            float f7 = this.mStage2Velocity;
            return f6 + (f7 * f4) + ((((this.mStage3Velocity - f7) * f4) * f4) / (f5 * 2.0f));
        }
        if (i == 2) {
            return this.mStage2EndPosition;
        }
        float f8 = f4 - f5;
        float f9 = this.mStage3Duration;
        if (f8 >= f9) {
            return this.mStage3EndPosition;
        }
        float f10 = this.mStage2EndPosition;
        float f11 = this.mStage3Velocity;
        return (f10 + (f11 * f8)) - (((f11 * f8) * f8) / (f9 * 2.0f));
    }

    private void setup(float f, float f2, float f3, float f4, float f5) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.mStage1Velocity = f;
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < 0.0f) {
            float sqrt = (float) java.lang.Math.sqrt((f2 - ((((-f) / f3) * f) / 2.0f)) * f3);
            if (sqrt < f4) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f8 = (sqrt - f) / f3;
                this.mStage1Duration = f8;
                this.mStage2Duration = sqrt / f3;
                this.mStage1EndPosition = ((f + sqrt) * f8) / 2.0f;
                this.mStage2EndPosition = f2;
                this.mStage3EndPosition = f2;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f4;
            this.mStage3Velocity = f4;
            float f9 = (f4 - f) / f3;
            this.mStage1Duration = f9;
            float f10 = f4 / f3;
            this.mStage3Duration = f10;
            float f11 = ((f + f4) * f9) / 2.0f;
            float f12 = (f10 * f4) / 2.0f;
            this.mStage2Duration = ((f2 - f11) - f12) / f4;
            this.mStage1EndPosition = f11;
            this.mStage2EndPosition = f2 - f12;
            this.mStage3EndPosition = f2;
            return;
        }
        if (f7 >= f2) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f2;
            this.mStage1Duration = (2.0f * f2) / f;
            return;
        }
        float f13 = f2 - f7;
        float f14 = f13 / f;
        if (f14 + f6 < f5) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f13;
            this.mStage2EndPosition = f2;
            this.mStage1Duration = f14;
            this.mStage2Duration = f6;
            return;
        }
        float sqrt2 = (float) java.lang.Math.sqrt((f3 * f2) + ((f * f) / 2.0f));
        float f15 = (sqrt2 - f) / f3;
        this.mStage1Duration = f15;
        float f16 = sqrt2 / f3;
        this.mStage2Duration = f16;
        if (sqrt2 < f4) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = sqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f15;
            this.mStage2Duration = f16;
            this.mStage1EndPosition = ((f + sqrt2) * f15) / 2.0f;
            this.mStage2EndPosition = f2;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f;
        this.mStage2Velocity = f4;
        this.mStage3Velocity = f4;
        float f17 = (f4 - f) / f3;
        this.mStage1Duration = f17;
        float f18 = f4 / f3;
        this.mStage3Duration = f18;
        float f19 = ((f + f4) * f17) / 2.0f;
        float f20 = (f18 * f4) / 2.0f;
        this.mStage2Duration = ((f2 - f19) - f20) / f4;
        this.mStage1EndPosition = f19;
        this.mStage2EndPosition = f2 - f20;
        this.mStage3EndPosition = f2;
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mStartPosition = f;
        boolean z = f > f2;
        this.mBackwards = z;
        if (z) {
            setup(-f3, f - f2, f5, f6, f4);
        } else {
            setup(f3, f2 - f, f5, f6, f4);
        }
    }

    public void debug(java.lang.String str, java.lang.String str2, float f) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str2);
        sb.append(" ===== ");
        sb.append(this.mType);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str2);
        sb2.append(this.mBackwards ? "backwards" : "forward ");
        sb2.append(" time = ");
        sb2.append(f);
        sb2.append("  stages ");
        sb2.append(this.mNumberOfStages);
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append(str2);
        sb3.append(" dur ");
        sb3.append(this.mStage1Duration);
        sb3.append(" vel ");
        sb3.append(this.mStage1Velocity);
        sb3.append(" pos ");
        sb3.append(this.mStage1EndPosition);
        if (this.mNumberOfStages > 1) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(str2);
            sb4.append(" dur ");
            sb4.append(this.mStage2Duration);
            sb4.append(" vel ");
            sb4.append(this.mStage2Velocity);
            sb4.append(" pos ");
            sb4.append(this.mStage2EndPosition);
        }
        if (this.mNumberOfStages > 2) {
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append(str2);
            sb5.append(" dur ");
            sb5.append(this.mStage3Duration);
            sb5.append(" vel ");
            sb5.append(this.mStage3Velocity);
            sb5.append(" pos ");
            sb5.append(this.mStage3EndPosition);
        }
        float f2 = this.mStage1Duration;
        if (f <= f2) {
            java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
            sb6.append(str2);
            sb6.append("stage 0");
            return;
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
            sb7.append(str2);
            sb7.append("end stage 0");
            return;
        }
        float f3 = f - f2;
        float f4 = this.mStage2Duration;
        if (f3 < f4) {
            java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
            sb8.append(str2);
            sb8.append(" stage 1");
        } else if (i == 2) {
            java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
            sb9.append(str2);
            sb9.append("end stage 1");
        } else if (f3 - f4 < this.mStage3Duration) {
            java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
            sb10.append(str2);
            sb10.append(" stage 2");
        } else {
            java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
            sb11.append(str2);
            sb11.append(" end stage 2");
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float calcY = calcY(f);
        this.mLastPosition = f;
        return this.mBackwards ? this.mStartPosition - calcY : this.mStartPosition + calcY;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }

    public float getVelocity(float f) {
        float f2 = this.mStage1Duration;
        if (f <= f2) {
            float f3 = this.mStage1Velocity;
            return f3 + (((this.mStage2Velocity - f3) * f) / f2);
        }
        int i = this.mNumberOfStages;
        if (i == 1) {
            return 0.0f;
        }
        float f4 = f - f2;
        float f5 = this.mStage2Duration;
        if (f4 < f5) {
            float f6 = this.mStage2Velocity;
            return f6 + (((this.mStage3Velocity - f6) * f4) / f5);
        }
        if (i == 2) {
            return this.mStage2EndPosition;
        }
        float f7 = f4 - f5;
        float f8 = this.mStage3Duration;
        if (f7 >= f8) {
            return this.mStage3EndPosition;
        }
        float f9 = this.mStage3Velocity;
        return f9 - ((f7 * f9) / f8);
    }
}
