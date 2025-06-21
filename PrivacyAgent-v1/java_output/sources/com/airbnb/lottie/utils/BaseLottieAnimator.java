package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public abstract class BaseLottieAnimator extends android.animation.ValueAnimator {
    public final java.util.Set<android.animation.ValueAnimator.AnimatorUpdateListener> n = new java.util.concurrent.CopyOnWriteArraySet();
    public final java.util.Set<android.animation.Animator.AnimatorListener> t = new java.util.concurrent.CopyOnWriteArraySet();

    public void a() {
        java.util.Iterator<android.animation.Animator.AnimatorListener> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    @Override // android.animation.Animator
    public void addListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.t.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.n.add(animatorUpdateListener);
    }

    public void b(boolean z) {
        for (android.animation.Animator.AnimatorListener animatorListener : this.t) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    public void c() {
        java.util.Iterator<android.animation.Animator.AnimatorListener> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    public void d(boolean z) {
        for (android.animation.Animator.AnimatorListener animatorListener : this.t) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    public void e() {
        java.util.Iterator<android.animation.ValueAnimator.AnimatorUpdateListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.t.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.n.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.t.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.n.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public android.animation.ValueAnimator setDuration(long j) {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(android.animation.TimeInterpolator timeInterpolator) {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }
}
