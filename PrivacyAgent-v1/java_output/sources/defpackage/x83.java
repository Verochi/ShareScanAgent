package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class x83 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.databinding.GuideSpeedPlayBinding n;
    public final /* synthetic */ android.view.animation.AlphaAnimation t;

    public /* synthetic */ x83(com.moji.mjweather.feed.databinding.GuideSpeedPlayBinding guideSpeedPlayBinding, android.view.animation.AlphaAnimation alphaAnimation) {
        this.n = guideSpeedPlayBinding;
        this.t = alphaAnimation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment.b(this.n, this.t);
    }
}
