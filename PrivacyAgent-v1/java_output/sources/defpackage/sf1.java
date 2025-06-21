package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class sf1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager n;

    public /* synthetic */ sf1(com.moji.shorttime.ui.member_control.MemberDialogManager memberDialogManager) {
        this.n = memberDialogManager;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.member_control.MemberDialogManager.d(this.n, valueAnimator);
    }
}
