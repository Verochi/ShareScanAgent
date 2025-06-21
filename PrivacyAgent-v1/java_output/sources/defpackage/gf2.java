package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class gf2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjtabme.guide.SettingGuideView n;

    public /* synthetic */ gf2(com.moji.mjtabme.guide.SettingGuideView settingGuideView) {
        this.n = settingGuideView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjtabme.guide.SettingGuideView.a(this.n, valueAnimator);
    }
}
