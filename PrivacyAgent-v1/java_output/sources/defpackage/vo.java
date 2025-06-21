package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class vo implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.CollectFragment n;

    public /* synthetic */ vo(com.moji.user.homepage.fragment.CollectFragment collectFragment) {
        this.n = collectFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.CollectFragment.j(this.n, (com.moji.user.homepage.mode.DeleteFeedVideoCollectData) obj);
    }
}
