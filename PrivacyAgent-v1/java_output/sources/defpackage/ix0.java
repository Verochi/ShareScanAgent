package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ix0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment n;

    public /* synthetic */ ix0(com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment liveVideoDetailFragment) {
        this.n = liveVideoDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment.d(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoPraiseData) obj);
    }
}
