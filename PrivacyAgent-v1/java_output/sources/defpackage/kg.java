package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class kg implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.notificationpermissions.BannerView n;

    public /* synthetic */ kg(com.moji.notificationpermissions.BannerView bannerView) {
        this.n = bannerView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.notificationpermissions.BannerView.a(this.n, valueAnimator);
    }
}
