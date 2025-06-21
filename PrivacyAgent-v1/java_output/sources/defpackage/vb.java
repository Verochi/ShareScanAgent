package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class vb implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.mojiweather.area.AreaManageFragment n;

    public /* synthetic */ vb(com.mojiweather.area.AreaManageFragment areaManageFragment) {
        this.n = areaManageFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.mojiweather.area.AreaManageFragment.p(this.n, (java.util.List) obj);
    }
}
