package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class v83 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment n;

    public /* synthetic */ v83(com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment videoDetailFragment) {
        this.n = videoDetailFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.detail.VideoDetailFragment.j(this.n, (com.moji.http.feedvideo.entity.VideoShareDetails) obj);
    }
}
