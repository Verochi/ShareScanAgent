package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class kw0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.ListRootFragment n;

    public /* synthetic */ kw0(com.moji.mjweather.feed.newvideo.detail.ListRootFragment listRootFragment) {
        this.n = listRootFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.detail.ListRootFragment.d(this.n, (com.moji.http.feedvideo.entity.HomeFeedDetailList) obj);
    }
}
