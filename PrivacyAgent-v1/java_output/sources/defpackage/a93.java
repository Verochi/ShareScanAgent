package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class a93 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment n;

    public /* synthetic */ a93(com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment videoDetailFragment) {
        this.n = videoDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment.f(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoPraiseData) obj);
    }
}
