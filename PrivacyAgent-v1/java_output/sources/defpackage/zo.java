package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class zo implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.CollectFragment n;

    public /* synthetic */ zo(com.moji.user.homepage.fragment.CollectFragment collectFragment) {
        this.n = collectFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.CollectFragment.c(this.n, (com.moji.http.fdsapi.entity.FeedCollectListResult) obj);
    }
}
