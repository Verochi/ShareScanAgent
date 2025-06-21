package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class oo0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.HorizontalMoreLayout n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ oo0(com.moji.HorizontalMoreLayout horizontalMoreLayout, android.view.View view) {
        this.n = horizontalMoreLayout;
        this.t = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.HorizontalMoreLayout.a(this.n, this.t, valueAnimator);
    }
}
