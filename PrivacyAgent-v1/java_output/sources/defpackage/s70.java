package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class s70 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.EarthQuakeInfoView n;

    public /* synthetic */ s70(com.moji.shorttime.ui.view.EarthQuakeInfoView earthQuakeInfoView) {
        this.n = earthQuakeInfoView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.EarthQuakeInfoView.c(this.n, valueAnimator);
    }
}
