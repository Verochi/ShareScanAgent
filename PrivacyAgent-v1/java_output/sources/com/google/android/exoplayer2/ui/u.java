package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final /* synthetic */ class u implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager n;
    public final /* synthetic */ android.view.ViewGroup t;

    public /* synthetic */ u(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, android.view.ViewGroup viewGroup) {
        this.n = styledPlayerControlViewLayoutManager;
        this.t = viewGroup;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        this.n.I(this.t, valueAnimator);
    }
}
