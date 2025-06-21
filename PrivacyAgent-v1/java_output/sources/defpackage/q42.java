package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class q42 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.PraiseVideoFragment n;

    public /* synthetic */ q42(com.moji.user.homepage.fragment.PraiseVideoFragment praiseVideoFragment) {
        this.n = praiseVideoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.PraiseVideoFragment.b(this.n, (com.moji.mjweather.feed.newvideo.model.HomeFeedVideoPraiseData) obj);
    }
}
