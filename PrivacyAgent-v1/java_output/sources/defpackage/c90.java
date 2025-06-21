package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class c90 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ int t;
    public final /* synthetic */ boolean u;

    public /* synthetic */ c90(android.view.View view, int i, boolean z) {
        this.n = view;
        this.t = i;
        this.u = z;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.EarthquakeWarningStatusView.c(this.n, this.t, this.u, valueAnimator);
    }
}
