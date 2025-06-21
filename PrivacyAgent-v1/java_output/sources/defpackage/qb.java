package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class qb implements android.widget.AdapterView.OnItemLongClickListener {
    public final /* synthetic */ com.mojiweather.area.AreaManageFragment n;

    public /* synthetic */ qb(com.mojiweather.area.AreaManageFragment areaManageFragment) {
        this.n = areaManageFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        return com.mojiweather.area.AreaManageFragment.m(this.n, adapterView, view, i, j);
    }
}
