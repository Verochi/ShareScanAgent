package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes12.dex */
public class AdglAnimation2V extends com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i) {
        reset();
        this.duration = i;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(java.lang.Object obj) {
        if (this.isOver) {
            return;
        }
        long uptimeMillis = android.os.SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f = uptimeMillis / this.duration;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        } else if (f < 0.0f) {
            this.isOver = true;
            return;
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.setNormalizedTime(f);
            this.curValue1 = this.v2Param.getCurXValue();
            this.curValue2 = this.v2Param.getCurYValue();
        }
    }

    public double getCurValue(int i) {
        return i == 0 ? this.curValue1 : this.curValue2;
    }

    public double getEndValue(int i) {
        if (i == 0) {
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getToXValue();
            }
            return 0.0d;
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getToYValue();
        }
        return 0.0d;
    }

    public double getStartValue(int i) {
        if (i == 0) {
            com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            if (abstractAdglAnimationParam2V != null) {
                return abstractAdglAnimationParam2V.getFromXValue();
            }
            return 0.0d;
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        if (abstractAdglAnimationParam2V2 != null) {
            return abstractAdglAnimationParam2V2.getFromYValue();
        }
        return 0.0d;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
    }
}
