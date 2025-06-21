package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class r80 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.earlywarning.EarthquakeReportFragment n;

    public /* synthetic */ r80(com.moji.earlywarning.EarthquakeReportFragment earthquakeReportFragment) {
        this.n = earthquakeReportFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.earlywarning.EarthquakeReportFragment.a(this.n, (com.moji.card.event.OpCardChangeEvent) obj);
    }
}
