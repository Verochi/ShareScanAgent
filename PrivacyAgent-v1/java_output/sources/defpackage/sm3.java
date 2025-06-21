package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class sm3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.WorksVideoFragment n;

    public /* synthetic */ sm3(com.moji.user.homepage.fragment.WorksVideoFragment worksVideoFragment) {
        this.n = worksVideoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.WorksVideoFragment.a(this.n, (com.moji.http.feedvideo.entity.FeedVideoCollectResult) obj);
    }
}
