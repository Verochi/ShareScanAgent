package defpackage;

/* loaded from: classes29.dex */
public final /* synthetic */ class a21 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.timeline.MJDefaultTimeline n;

    public /* synthetic */ a21(com.moji.shorttime.ui.timeline.MJDefaultTimeline mJDefaultTimeline) {
        this.n = mJDefaultTimeline;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.timeline.MJDefaultTimeline.a(this.n, valueAnimator);
    }
}
