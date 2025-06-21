package defpackage;

/* loaded from: classes5.dex */
public final /* synthetic */ class iv2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjtabme.fragment.TabMeHeaderFragment n;

    public /* synthetic */ iv2(com.moji.mjtabme.fragment.TabMeHeaderFragment tabMeHeaderFragment) {
        this.n = tabMeHeaderFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjtabme.fragment.TabMeHeaderFragment.a(this.n, (com.moji.mjtabme.data.TabMeScrollData) obj);
    }
}
