package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class yo implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.CollectFragment n;

    public /* synthetic */ yo(com.moji.user.homepage.fragment.CollectFragment collectFragment) {
        this.n = collectFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.CollectFragment.a(this.n, (com.moji.http.feedvideo.entity.FeedVideoCollectResult) obj);
    }
}
