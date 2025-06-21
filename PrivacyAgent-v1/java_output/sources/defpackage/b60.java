package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class b60 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjad.splash.view.DrawerImageView n;

    public /* synthetic */ b60(com.moji.mjad.splash.view.DrawerImageView drawerImageView) {
        this.n = drawerImageView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjad.splash.view.DrawerImageView.c(this.n, valueAnimator);
    }
}
