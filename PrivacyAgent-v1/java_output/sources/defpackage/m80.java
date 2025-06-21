package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class m80 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.EarthquakeMarkerAnimView n;

    public /* synthetic */ m80(com.moji.shorttime.ui.view.EarthquakeMarkerAnimView earthquakeMarkerAnimView) {
        this.n = earthquakeMarkerAnimView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.EarthquakeMarkerAnimView.a(this.n, valueAnimator);
    }
}
