package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class r70 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.shorttime.ui.view.EarthQuakeInfoView n;
    public final /* synthetic */ com.moji.entity.earthquake.EarthquakeModel.LocationInfluence t;

    public /* synthetic */ r70(com.moji.shorttime.ui.view.EarthQuakeInfoView earthQuakeInfoView, com.moji.entity.earthquake.EarthquakeModel.LocationInfluence locationInfluence) {
        this.n = earthQuakeInfoView;
        this.t = locationInfluence;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.shorttime.ui.view.EarthQuakeInfoView.b(this.n, this.t);
    }
}
