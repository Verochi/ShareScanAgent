package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ib1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.player.MapSeekBar n;

    public /* synthetic */ ib1(com.moji.shorttime.ui.player.MapSeekBar mapSeekBar) {
        this.n = mapSeekBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.player.MapSeekBar.a(this.n, valueAnimator);
    }
}
