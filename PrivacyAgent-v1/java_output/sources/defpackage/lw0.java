package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class lw0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.ListRootFragment n;

    public /* synthetic */ lw0(com.moji.mjweather.feed.newvideo.detail.ListRootFragment listRootFragment) {
        this.n = listRootFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.feed.newvideo.detail.ListRootFragment.a(this.n, (com.moji.mjweather.feed.newvideo.detail.model.HomeVideoRecommendData) obj);
    }
}
