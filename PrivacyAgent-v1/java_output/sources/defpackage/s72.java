package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class s72 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.view.RadarTypeListAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.shorttime.ui.view.RadarTypeListAdapter.ViewHolder u;
    public final /* synthetic */ com.moji.shorttime.ui.view.RadarTypeListItemData v;

    public /* synthetic */ s72(com.moji.shorttime.ui.view.RadarTypeListAdapter radarTypeListAdapter, int i, com.moji.shorttime.ui.view.RadarTypeListAdapter.ViewHolder viewHolder, com.moji.shorttime.ui.view.RadarTypeListItemData radarTypeListItemData) {
        this.n = radarTypeListAdapter;
        this.t = i;
        this.u = viewHolder;
        this.v = radarTypeListItemData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.view.RadarTypeListAdapter.a(this.n, this.t, this.u, this.v, view);
    }
}
