package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class gx implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CalenderFragment n;

    public /* synthetic */ gx(com.moji.mj40dayforecast.fragment.Days40CalenderFragment days40CalenderFragment) {
        this.n = days40CalenderFragment;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mj40dayforecast.fragment.Days40CalenderFragment.f(this.n, valueAnimator);
    }
}
