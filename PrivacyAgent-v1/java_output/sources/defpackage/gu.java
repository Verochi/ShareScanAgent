package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class gu implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.http.member.entity.MemberCurrentTyphoonResult.CurrentTy.Track n;
    public final /* synthetic */ com.moji.shorttime.ui.function.typhoon.CurrentTyphoonController t;

    public /* synthetic */ gu(com.moji.http.member.entity.MemberCurrentTyphoonResult.CurrentTy.Track track, com.moji.shorttime.ui.function.typhoon.CurrentTyphoonController currentTyphoonController) {
        this.n = track;
        this.t = currentTyphoonController;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.function.typhoon.CurrentTyphoonController.b(this.n, this.t, valueAnimator);
    }
}
