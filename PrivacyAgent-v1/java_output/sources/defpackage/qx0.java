package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class qx0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoListFragment n;

    public /* synthetic */ qx0(com.moji.mjweather.feed.newvideo.live.LiveVideoListFragment liveVideoListFragment) {
        this.n = liveVideoListFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.live.LiveVideoListFragment.h(this.n, (java.util.List) obj);
    }
}
