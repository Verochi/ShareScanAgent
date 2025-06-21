package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class w70 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.EarthquakeDistanceView n;

    public /* synthetic */ w70(com.moji.shorttime.ui.view.EarthquakeDistanceView earthquakeDistanceView) {
        this.n = earthquakeDistanceView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.EarthquakeDistanceView.a(this.n, valueAnimator);
    }
}
