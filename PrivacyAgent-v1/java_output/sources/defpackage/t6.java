package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class t6 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.AdaptiveRadarTypeListParentView n;

    public /* synthetic */ t6(com.moji.shorttime.ui.view.AdaptiveRadarTypeListParentView adaptiveRadarTypeListParentView) {
        this.n = adaptiveRadarTypeListParentView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.AdaptiveRadarTypeListParentView.a(this.n, valueAnimator);
    }
}
