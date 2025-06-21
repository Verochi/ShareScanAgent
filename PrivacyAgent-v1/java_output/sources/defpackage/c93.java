package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class c93 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment n;

    public /* synthetic */ c93(com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment videoDetailFragment) {
        this.n = videoDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment.h(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoCollectData) obj);
    }
}
