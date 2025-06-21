package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class fx implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CalenderFragment n;

    public /* synthetic */ fx(com.moji.mj40dayforecast.fragment.Days40CalenderFragment days40CalenderFragment) {
        this.n = days40CalenderFragment;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mj40dayforecast.fragment.Days40CalenderFragment.d(this.n, valueAnimator);
    }
}
