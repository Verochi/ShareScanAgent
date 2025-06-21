package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class po0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ android.widget.TextView n;

    public /* synthetic */ po0(android.widget.TextView textView) {
        this.n = textView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.feed.view.HorizontalMoreLayout.a(this.n, valueAnimator);
    }
}
