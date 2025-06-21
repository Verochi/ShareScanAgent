package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes12.dex */
public abstract class AbstractAdglAnimationParam {
    protected float mult;
    protected float normalizedTime;
    protected int interpolationType = 0;
    protected float factor = 1.0f;
    protected boolean hasCheckedParam = false;
    protected boolean needToCaculate = false;
    protected boolean hasFromValue = false;
    protected boolean hasToValue = false;

    public static float bounce(float f) {
        return f * f * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i, float f) {
        this.interpolationType = i;
        this.factor = f;
    }

    public void setNormalizedTime(float f) {
        double pow;
        float bounce;
        float f2;
        this.normalizedTime = f;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                pow = java.lang.Math.pow(f, this.factor * 2.0f);
                f = (float) pow;
                break;
            case 2:
                if (this.factor != 1.0f) {
                    f = (float) (1.0d - java.lang.Math.pow(1.0f - f, r0 * 2.0f));
                    break;
                } else {
                    float f3 = 1.0f - f;
                    f = 1.0f - (f3 * f3);
                    break;
                }
            case 3:
                pow = (java.lang.Math.cos((f + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d;
                f = (float) pow;
                break;
            case 4:
                float f4 = f * 1.1226f;
                if (f4 >= 0.3535f) {
                    if (f4 < 0.7408f) {
                        bounce = bounce(f4 - 0.54719f);
                        f2 = 0.7f;
                    } else if (f4 < 0.9644f) {
                        bounce = bounce(f4 - 0.8526f);
                        f2 = 0.9f;
                    } else {
                        bounce = bounce(f4 - 1.0435f);
                        f2 = 0.95f;
                    }
                    f = bounce + f2;
                    break;
                } else {
                    f = bounce(f4);
                    break;
                }
            case 5:
                float f5 = f - 1.0f;
                f = (f5 * f5 * ((f5 * 3.0f) + 2.0f)) + 1.0f;
                break;
            case 6:
                if (f >= 0.0f) {
                    if (f >= 0.25f) {
                        if (f >= 0.5f) {
                            if (f >= 0.75f) {
                                if (f <= 1.0f) {
                                    f = 4.0f - (f * 4.0f);
                                    break;
                                }
                            } else {
                                f = (f * 4.0f) - 2.0f;
                                break;
                            }
                        } else {
                            f = 2.0f - (f * 4.0f);
                            break;
                        }
                    } else {
                        f *= 4.0f;
                        break;
                    }
                }
            default:
                f = 0.0f;
                break;
        }
        this.mult = f;
    }
}
