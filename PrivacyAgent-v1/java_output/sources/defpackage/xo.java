package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class xo implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.CollectFragment n;

    public /* synthetic */ xo(com.moji.user.homepage.fragment.CollectFragment collectFragment) {
        this.n = collectFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.CollectFragment.d(this.n, (com.moji.user.homepage.mode.DeleteCollectData) obj);
    }
}
