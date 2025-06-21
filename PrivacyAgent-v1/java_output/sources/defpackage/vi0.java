package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class vi0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.FreeUseMemberTipsView n;

    public /* synthetic */ vi0(com.moji.shorttime.ui.view.FreeUseMemberTipsView freeUseMemberTipsView) {
        this.n = freeUseMemberTipsView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.FreeUseMemberTipsView.a(this.n, valueAnimator);
    }
}
