package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class e41 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesTimeline n;

    public /* synthetic */ e41(com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesTimeline mJMapleLeavesTimeline) {
        this.n = mJMapleLeavesTimeline;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.mapleleavesline.MJMapleLeavesTimeline.b(this.n, valueAnimator);
    }
}
