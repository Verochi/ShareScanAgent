package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class c23 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.dailydetails.adpater.TideDelegate n;
    public final /* synthetic */ java.lang.String t;
    public final /* synthetic */ com.moji.weatherprovider.data.Weather u;
    public final /* synthetic */ long v;
    public final /* synthetic */ com.moji.common.area.AreaInfo w;

    public /* synthetic */ c23(com.moji.mjweather.dailydetails.adpater.TideDelegate tideDelegate, java.lang.String str, com.moji.weatherprovider.data.Weather weather, long j, com.moji.common.area.AreaInfo areaInfo) {
        this.n = tideDelegate;
        this.t = str;
        this.u = weather;
        this.v = j;
        this.w = areaInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.dailydetails.adpater.TideDelegate.a(this.n, this.t, this.u, this.v, this.w, view);
    }
}
