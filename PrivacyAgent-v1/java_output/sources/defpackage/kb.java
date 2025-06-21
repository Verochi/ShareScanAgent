package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class kb implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.mojiweather.area.AreaManageFragment n;

    public /* synthetic */ kb(com.mojiweather.area.AreaManageFragment areaManageFragment) {
        this.n = areaManageFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.mojiweather.area.AreaManageFragment.o(this.n, (java.lang.Boolean) obj);
    }
}
