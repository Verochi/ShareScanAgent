package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class ap implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.CollectFragment n;

    public /* synthetic */ ap(com.moji.user.homepage.fragment.CollectFragment collectFragment) {
        this.n = collectFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.CollectFragment.k(this.n, (com.moji.http.snsforum.entity.CollectionListResult2) obj);
    }
}
