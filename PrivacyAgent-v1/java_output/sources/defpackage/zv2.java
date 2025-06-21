package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class zv2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.tabmember.TabMemberFragment n;

    public /* synthetic */ zv2(com.moji.mjweather.tabmember.TabMemberFragment tabMemberFragment) {
        this.n = tabMemberFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.tabmember.TabMemberFragment.g(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
