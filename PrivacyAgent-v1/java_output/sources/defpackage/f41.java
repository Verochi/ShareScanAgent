package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class f41 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesTimeline n;

    public /* synthetic */ f41(com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesTimeline mJMapleLeavesTimeline) {
        this.n = mJMapleLeavesTimeline;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesTimeline.a(this.n, valueAnimator);
    }
}
