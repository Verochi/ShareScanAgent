package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class sb implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.mojiweather.area.AreaManageFragment n;

    public /* synthetic */ sb(com.mojiweather.area.AreaManageFragment areaManageFragment) {
        this.n = areaManageFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.mojiweather.area.AreaManageFragment.e(this.n, (java.lang.Boolean) obj);
    }
}
