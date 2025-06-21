package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class pr implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjad.common.view.creater.AbsAdStyleViewCreater n;

    public /* synthetic */ pr(com.moji.mjad.common.view.creater.AbsAdStyleViewCreater absAdStyleViewCreater) {
        this.n = absAdStyleViewCreater;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjad.common.view.CommonAdView.d(this.n, valueAnimator);
    }
}
