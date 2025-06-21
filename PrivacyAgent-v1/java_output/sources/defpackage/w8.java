package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class w8 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.function.allergy.AllergyTimeLinePlayerBar n;

    public /* synthetic */ w8(com.moji.shorttime.ui.function.allergy.AllergyTimeLinePlayerBar allergyTimeLinePlayerBar) {
        this.n = allergyTimeLinePlayerBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.allergy.AllergyTimeLinePlayerBar.a(this.n, valueAnimator);
    }
}
