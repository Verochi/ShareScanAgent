package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class kv2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjtabme.fragment.TabMeHeaderFragment n;
    public final /* synthetic */ com.moji.mjtabme.viewmodel.TabMeViewModel t;

    public /* synthetic */ kv2(com.moji.mjtabme.fragment.TabMeHeaderFragment tabMeHeaderFragment, com.moji.mjtabme.viewmodel.TabMeViewModel tabMeViewModel) {
        this.n = tabMeHeaderFragment;
        this.t = tabMeViewModel;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjtabme.fragment.TabMeHeaderFragment.b(this.n, this.t, (com.moji.account.data.UserInfo) obj);
    }
}
