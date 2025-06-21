package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class c60 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.FloatRef n;
    public final /* synthetic */ com.moji.mjad.splash.view.DrawerImageView t;

    public /* synthetic */ c60(kotlin.jvm.internal.Ref.FloatRef floatRef, com.moji.mjad.splash.view.DrawerImageView drawerImageView) {
        this.n = floatRef;
        this.t = drawerImageView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjad.splash.view.DrawerImageView.b(this.n, this.t, valueAnimator);
    }
}
