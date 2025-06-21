package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class lx0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment n;

    public /* synthetic */ lx0(com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment liveVideoDetailFragment) {
        this.n = liveVideoDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.live.LiveVideoDetailFragment.b(this.n, (com.moji.http.feedvideo.entity.VideoShareDetails) obj);
    }
}
