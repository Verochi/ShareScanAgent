package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class to implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.CollectFragment n;

    public /* synthetic */ to(com.moji.user.homepage.fragment.CollectFragment collectFragment) {
        this.n = collectFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.CollectFragment.g(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoPraiseData) obj);
    }
}
