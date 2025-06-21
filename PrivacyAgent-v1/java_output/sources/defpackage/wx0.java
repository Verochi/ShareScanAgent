package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class wx0 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.GetFragmentView n;

    public /* synthetic */ wx0(com.moji.mjweather.feed.newvideo.live.GetFragmentView getFragmentView) {
        this.n = getFragmentView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.feed.newvideo.live.LiveVideoListFragment.b(this.n, valueAnimator);
    }
}
