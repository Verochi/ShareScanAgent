package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class ch0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.FocusAnimViewOfGuide n;

    public /* synthetic */ ch0(com.moji.shorttime.ui.view.FocusAnimViewOfGuide focusAnimViewOfGuide) {
        this.n = focusAnimViewOfGuide;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.shorttime.ui.view.FocusAnimViewOfGuide.a(this.n, valueAnimator);
    }
}
