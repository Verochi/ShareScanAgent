package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class mh2 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.ShortTimeSwitchButton n;

    public /* synthetic */ mh2(com.moji.shorttime.ui.view.ShortTimeSwitchButton shortTimeSwitchButton) {
        this.n = shortTimeSwitchButton;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.ShortTimeSwitchButton.a(this.n, valueAnimator);
    }
}
