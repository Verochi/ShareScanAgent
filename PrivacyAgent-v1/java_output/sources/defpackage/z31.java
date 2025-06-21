package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class z31 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesLinePlayBar n;

    public /* synthetic */ z31(com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesLinePlayBar mJMapleLeavesLinePlayBar) {
        this.n = mJMapleLeavesLinePlayBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesLinePlayBar.b(this.n, valueAnimator);
    }
}
