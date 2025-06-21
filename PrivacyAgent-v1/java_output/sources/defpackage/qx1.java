package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class qx1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.aqi.widget.particle.ParticleView n;

    public /* synthetic */ qx1(com.moji.aqi.widget.particle.ParticleView particleView) {
        this.n = particleView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.aqi.widget.particle.ParticleView.a(this.n, valueAnimator);
    }
}
