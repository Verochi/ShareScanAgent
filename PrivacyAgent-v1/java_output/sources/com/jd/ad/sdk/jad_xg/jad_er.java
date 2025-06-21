package com.jd.ad.sdk.jad_xg;

/* loaded from: classes23.dex */
public class jad_er extends com.jd.ad.sdk.jad_xg.jad_an implements android.view.Choreographer.FrameCallback {

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_jt jad_jw;
    public float jad_cp = 1.0f;
    public boolean jad_dq = false;
    public long jad_er = 0;
    public float jad_fs = 0.0f;
    public int jad_jt = 0;
    public float jad_hu = -2.1474836E9f;
    public float jad_iv = 2.1474836E9f;

    @androidx.annotation.VisibleForTesting
    public boolean jad_kx = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @androidx.annotation.MainThread
    public void cancel() {
        java.util.Iterator<android.animation.Animator.AnimatorListener> it = this.jad_bo.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
        jad_hu();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        jad_jt();
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null || !this.jad_kx) {
            return;
        }
        float abs = (this.jad_er != 0 ? j - r1 : 0L) / ((1.0E9f / jad_jtVar.jad_mz) / java.lang.Math.abs(this.jad_cp));
        float f = this.jad_fs;
        if (jad_fs()) {
            abs = -abs;
        }
        float f2 = f + abs;
        this.jad_fs = f2;
        float jad_er = jad_er();
        float jad_dq = jad_dq();
        android.graphics.PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        boolean z = !(f2 >= jad_er && f2 <= jad_dq);
        this.jad_fs = java.lang.Math.max(jad_er(), java.lang.Math.min(jad_dq(), this.jad_fs));
        this.jad_er = j;
        jad_an();
        if (z) {
            if (getRepeatCount() == -1 || this.jad_jt < getRepeatCount()) {
                java.util.Iterator<android.animation.Animator.AnimatorListener> it = this.jad_bo.iterator();
                while (it.hasNext()) {
                    it.next().onAnimationRepeat(this);
                }
                this.jad_jt++;
                if (getRepeatMode() == 2) {
                    this.jad_dq = !this.jad_dq;
                    this.jad_cp = -this.jad_cp;
                } else {
                    this.jad_fs = jad_fs() ? jad_dq() : jad_er();
                }
                this.jad_er = j;
            } else {
                this.jad_fs = this.jad_cp < 0.0f ? jad_er() : jad_dq();
                jad_hu();
                jad_an(jad_fs());
            }
        }
        if (this.jad_jw != null) {
            float f3 = this.jad_fs;
            if (f3 < this.jad_hu || f3 > this.jad_iv) {
                throw new java.lang.IllegalStateException(java.lang.String.format("Frame must be [%f,%f]. It is %f", java.lang.Float.valueOf(this.jad_hu), java.lang.Float.valueOf(this.jad_iv), java.lang.Float.valueOf(this.jad_fs)));
            }
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float f;
        float jad_er;
        if (this.jad_jw == null) {
            return 0.0f;
        }
        if (jad_fs()) {
            f = jad_dq();
            jad_er = this.jad_fs;
        } else {
            f = this.jad_fs;
            jad_er = jad_er();
        }
        return (f - jad_er) / (jad_dq() - jad_er());
    }

    @Override // android.animation.ValueAnimator
    public java.lang.Object getAnimatedValue() {
        return java.lang.Float.valueOf(jad_cp());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0L;
        }
        return (long) jad_jtVar.jad_an();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.jad_kx;
    }

    public void jad_an(float f) {
        if (this.jad_fs == f) {
            return;
        }
        float jad_er = jad_er();
        float jad_dq = jad_dq();
        android.graphics.PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        this.jad_fs = java.lang.Math.max(jad_er, java.lang.Math.min(jad_dq, f));
        this.jad_er = 0L;
        jad_an();
    }

    public void jad_an(float f, float f2) {
        if (f > f2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("minFrame (%s) must be <= maxFrame (%s)", java.lang.Float.valueOf(f), java.lang.Float.valueOf(f2)));
        }
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        float f3 = jad_jtVar == null ? -3.4028235E38f : jad_jtVar.jad_kx;
        float f4 = jad_jtVar == null ? Float.MAX_VALUE : jad_jtVar.jad_ly;
        android.graphics.PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        float max = java.lang.Math.max(f3, java.lang.Math.min(f4, f));
        float max2 = java.lang.Math.max(f3, java.lang.Math.min(f4, f2));
        if (max == this.jad_hu && max2 == this.jad_iv) {
            return;
        }
        this.jad_hu = max;
        this.jad_iv = max2;
        jad_an((int) java.lang.Math.max(max, java.lang.Math.min(max2, this.jad_fs)));
    }

    @androidx.annotation.MainThread
    public void jad_bo() {
        jad_hu();
        jad_an(jad_fs());
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float jad_cp() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_fs;
        float f2 = jad_jtVar.jad_kx;
        return (f - f2) / (jad_jtVar.jad_ly - f2);
    }

    public float jad_dq() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_iv;
        return f == 2.1474836E9f ? jad_jtVar.jad_ly : f;
    }

    public float jad_er() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_hu;
        return f == -2.1474836E9f ? jad_jtVar.jad_kx : f;
    }

    public final boolean jad_fs() {
        return this.jad_cp < 0.0f;
    }

    @androidx.annotation.MainThread
    public void jad_hu() {
        android.view.Choreographer.getInstance().removeFrameCallback(this);
        this.jad_kx = false;
    }

    public void jad_jt() {
        if (this.jad_kx) {
            android.view.Choreographer.getInstance().removeFrameCallback(this);
            android.view.Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.jad_dq) {
            return;
        }
        this.jad_dq = false;
        this.jad_cp = -this.jad_cp;
    }
}
