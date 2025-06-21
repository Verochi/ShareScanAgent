package defpackage;

/* loaded from: classes18.dex */
public final /* synthetic */ class ku implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.viewpagerindicator.CustomPagerIndicator n;

    public /* synthetic */ ku(com.moji.viewpagerindicator.CustomPagerIndicator customPagerIndicator) {
        this.n = customPagerIndicator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.viewpagerindicator.CustomPagerIndicator.a(this.n, valueAnimator);
    }
}
