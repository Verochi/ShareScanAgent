package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class g93 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.feed.databinding.GuideLongPressBinding n;
    public final /* synthetic */ android.view.animation.AlphaAnimation t;

    public /* synthetic */ g93(com.moji.mjweather.feed.databinding.GuideLongPressBinding guideLongPressBinding, android.view.animation.AlphaAnimation alphaAnimation) {
        this.n = guideLongPressBinding;
        this.t = alphaAnimation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment.d(this.n, this.t);
    }
}
