package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class kx0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment n;

    public /* synthetic */ kx0(com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment liveVideoDetailFragment) {
        this.n = liveVideoDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment.e(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoCollectData) obj);
    }
}
