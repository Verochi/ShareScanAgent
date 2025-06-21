package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class z70 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.earthquake.ui.list.EarthquakeListAdapter.OnItemClickListener n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.entity.earthquake.EarthquakeModel u;

    public /* synthetic */ z70(com.moji.earthquake.ui.list.EarthquakeListAdapter.OnItemClickListener onItemClickListener, int i, com.moji.entity.earthquake.EarthquakeModel earthquakeModel) {
        this.n = onItemClickListener;
        this.t = i;
        this.u = earthquakeModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.earthquake.ui.list.EarthquakeListAdapter.ViewHolder.a(this.n, this.t, this.u, view);
    }
}
