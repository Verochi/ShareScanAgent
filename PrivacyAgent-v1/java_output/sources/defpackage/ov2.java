package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class ov2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjtabme.fragment.TabMeTitleFragment n;

    public /* synthetic */ ov2(com.moji.mjtabme.fragment.TabMeTitleFragment tabMeTitleFragment) {
        this.n = tabMeTitleFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjtabme.fragment.TabMeTitleFragment.a(this.n, (com.moji.account.data.UserInfo) obj);
    }
}
