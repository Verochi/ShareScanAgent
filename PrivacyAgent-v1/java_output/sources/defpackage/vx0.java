package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class vx0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.databinding.GuideSpeedPlayBinding n;
    public final /* synthetic */ android.view.animation.AlphaAnimation t;

    public /* synthetic */ vx0(com.moji.mjweather.feed.databinding.GuideSpeedPlayBinding guideSpeedPlayBinding, android.view.animation.AlphaAnimation alphaAnimation) {
        this.n = guideSpeedPlayBinding;
        this.t = alphaAnimation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.newvideo.live.LiveVideoListFragment.d(this.n, this.t);
    }
}
