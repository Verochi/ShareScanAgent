package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class x70 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.earthquake.ui.list.EarthquakeListActivity n;

    public /* synthetic */ x70(com.moji.earthquake.ui.list.EarthquakeListActivity earthquakeListActivity) {
        this.n = earthquakeListActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.earthquake.ui.list.EarthquakeListActivity.b(this.n, (com.moji.entity.Result) obj);
    }
}
