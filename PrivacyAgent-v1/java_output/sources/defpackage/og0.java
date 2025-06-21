package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class og0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.huania.sdk.entity.EarthquakeEntity n;
    public final /* synthetic */ com.moji.earthquake.manager.FloatingWindowManager t;

    public /* synthetic */ og0(com.huania.sdk.entity.EarthquakeEntity earthquakeEntity, com.moji.earthquake.manager.FloatingWindowManager floatingWindowManager) {
        this.n = earthquakeEntity;
        this.t = floatingWindowManager;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.earthquake.manager.FloatingWindowManager.b(this.n, this.t, view);
    }
}
