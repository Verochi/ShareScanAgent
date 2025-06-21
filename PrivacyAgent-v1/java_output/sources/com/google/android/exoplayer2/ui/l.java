package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final /* synthetic */ class l implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager n;

    public /* synthetic */ l(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.n = styledPlayerControlViewLayoutManager;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        this.n.K(valueAnimator);
    }
}
