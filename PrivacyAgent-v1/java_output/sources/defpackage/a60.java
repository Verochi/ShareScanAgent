package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class a60 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjad.splash.view.DrawerImageView n;

    public /* synthetic */ a60(com.moji.mjad.splash.view.DrawerImageView drawerImageView) {
        this.n = drawerImageView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjad.splash.view.DrawerImageView.a(this.n, valueAnimator);
    }
}
