package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class tm3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.WorksVideoFragment n;

    public /* synthetic */ tm3(com.moji.user.homepage.fragment.WorksVideoFragment worksVideoFragment) {
        this.n = worksVideoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.WorksVideoFragment.e(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoPraiseData) obj);
    }
}
