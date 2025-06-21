package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class no0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.feed.view.HorizontalMoreLayout n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ no0(com.moji.mjweather.feed.view.HorizontalMoreLayout horizontalMoreLayout, android.view.View view) {
        this.n = horizontalMoreLayout;
        this.t = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.feed.view.HorizontalMoreLayout.b(this.n, this.t, valueAnimator);
    }
}
