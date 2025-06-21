package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class LottieValueAnimator extends com.airbnb.lottie.utils.BaseLottieAnimator implements android.view.Choreographer.FrameCallback {

    @androidx.annotation.Nullable
    public com.airbnb.lottie.LottieComposition B;
    public float u = 1.0f;
    public boolean v = false;
    public long w = 0;
    public float x = 0.0f;
    public int y = 0;
    public float z = -2.1474836E9f;
    public float A = 2.1474836E9f;

    @androidx.annotation.VisibleForTesting
    protected boolean running = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @androidx.annotation.MainThread
    public void cancel() {
        a();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.B = null;
        this.z = -2.1474836E9f;
        this.A = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        postFrameCallback();
        if (this.B == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.L.beginSection("LottieValueAnimator#doFrame");
        float f = (this.w != 0 ? j - r1 : 0L) / f();
        float f2 = this.x;
        if (g()) {
            f = -f;
        }
        float f3 = f2 + f;
        this.x = f3;
        boolean z = !com.airbnb.lottie.utils.MiscUtils.contains(f3, getMinFrame(), getMaxFrame());
        this.x = com.airbnb.lottie.utils.MiscUtils.clamp(this.x, getMinFrame(), getMaxFrame());
        this.w = j;
        e();
        if (z) {
            if (getRepeatCount() == -1 || this.y < getRepeatCount()) {
                c();
                this.y++;
                if (getRepeatMode() == 2) {
                    this.v = !this.v;
                    reverseAnimationSpeed();
                } else {
                    this.x = g() ? getMaxFrame() : getMinFrame();
                }
                this.w = j;
            } else {
                this.x = this.u < 0.0f ? getMinFrame() : getMaxFrame();
                removeFrameCallback();
                b(g());
            }
        }
        h();
        com.airbnb.lottie.L.endSection("LottieValueAnimator#doFrame");
    }

    @androidx.annotation.MainThread
    public void endAnimation() {
        removeFrameCallback();
        b(g());
    }

    public final float f() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.B;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / java.lang.Math.abs(this.u);
    }

    public final boolean g() {
        return getSpeed() < 0.0f;
    }

    @Override // android.animation.ValueAnimator
    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.B == null) {
            return 0.0f;
        }
        if (g()) {
            minFrame = getMaxFrame() - this.x;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.x - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator
    public java.lang.Object getAnimatedValue() {
        return java.lang.Float.valueOf(getAnimatedValueAbsolute());
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.B;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.x - lottieComposition.getStartFrame()) / (this.B.getEndFrame() - this.B.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.B;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.x;
    }

    public float getMaxFrame() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.B;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.A;
        return f == 2.1474836E9f ? lottieComposition.getEndFrame() : f;
    }

    public float getMinFrame() {
        com.airbnb.lottie.LottieComposition lottieComposition = this.B;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.z;
        return f == -2.1474836E9f ? lottieComposition.getStartFrame() : f;
    }

    public float getSpeed() {
        return this.u;
    }

    public final void h() {
        if (this.B == null) {
            return;
        }
        float f = this.x;
        if (f < this.z || f > this.A) {
            throw new java.lang.IllegalStateException(java.lang.String.format("Frame must be [%f,%f]. It is %f", java.lang.Float.valueOf(this.z), java.lang.Float.valueOf(this.A), java.lang.Float.valueOf(this.x)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @androidx.annotation.MainThread
    public void pauseAnimation() {
        removeFrameCallback();
    }

    @androidx.annotation.MainThread
    public void playAnimation() {
        this.running = true;
        d(g());
        setFrame((int) (g() ? getMaxFrame() : getMinFrame()));
        this.w = 0L;
        this.y = 0;
        postFrameCallback();
    }

    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            android.view.Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @androidx.annotation.MainThread
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    @androidx.annotation.MainThread
    public void removeFrameCallback(boolean z) {
        android.view.Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    @androidx.annotation.MainThread
    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.w = 0L;
        if (g() && getFrame() == getMinFrame()) {
            this.x = getMaxFrame();
        } else {
            if (g() || getFrame() != getMaxFrame()) {
                return;
            }
            this.x = getMinFrame();
        }
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(com.airbnb.lottie.LottieComposition lottieComposition) {
        boolean z = this.B == null;
        this.B = lottieComposition;
        if (z) {
            setMinAndMaxFrames((int) java.lang.Math.max(this.z, lottieComposition.getStartFrame()), (int) java.lang.Math.min(this.A, lottieComposition.getEndFrame()));
        } else {
            setMinAndMaxFrames((int) lottieComposition.getStartFrame(), (int) lottieComposition.getEndFrame());
        }
        float f = this.x;
        this.x = 0.0f;
        setFrame((int) f);
        e();
    }

    public void setFrame(float f) {
        if (this.x == f) {
            return;
        }
        this.x = com.airbnb.lottie.utils.MiscUtils.clamp(f, getMinFrame(), getMaxFrame());
        this.w = 0L;
        e();
    }

    public void setMaxFrame(float f) {
        setMinAndMaxFrames(this.z, f);
    }

    public void setMinAndMaxFrames(float f, float f2) {
        if (f > f2) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("minFrame (%s) must be <= maxFrame (%s)", java.lang.Float.valueOf(f), java.lang.Float.valueOf(f2)));
        }
        com.airbnb.lottie.LottieComposition lottieComposition = this.B;
        float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
        com.airbnb.lottie.LottieComposition lottieComposition2 = this.B;
        float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
        this.z = com.airbnb.lottie.utils.MiscUtils.clamp(f, startFrame, endFrame);
        this.A = com.airbnb.lottie.utils.MiscUtils.clamp(f2, startFrame, endFrame);
        setFrame((int) com.airbnb.lottie.utils.MiscUtils.clamp(this.x, f, f2));
    }

    public void setMinFrame(int i) {
        setMinAndMaxFrames(i, (int) this.A);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.v) {
            return;
        }
        this.v = false;
        reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.u = f;
    }
}
