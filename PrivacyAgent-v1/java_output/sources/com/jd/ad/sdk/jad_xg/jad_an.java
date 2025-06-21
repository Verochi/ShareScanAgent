package com.jd.ad.sdk.jad_xg;

/* loaded from: classes23.dex */
public abstract class jad_an extends android.animation.ValueAnimator {
    public final java.util.Set<android.animation.ValueAnimator.AnimatorUpdateListener> jad_an = new java.util.concurrent.CopyOnWriteArraySet();
    public final java.util.Set<android.animation.Animator.AnimatorListener> jad_bo = new java.util.concurrent.CopyOnWriteArraySet();

    @Override // android.animation.Animator
    public void addListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.jad_bo.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.jad_an.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new java.lang.UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void jad_an() {
        java.util.Iterator<android.animation.ValueAnimator.AnimatorUpdateListener> it = this.jad_an.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    public void jad_an(boolean z) {
        for (android.animation.Animator.AnimatorListener animatorListener : this.jad_bo) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.jad_bo.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.jad_an.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(android.animation.Animator.AnimatorListener animatorListener) {
        this.jad_bo.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.jad_an.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public /* bridge */ /* synthetic */ android.animation.Animator setDuration(long j) {
        setDuration(j);
        throw null;
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
