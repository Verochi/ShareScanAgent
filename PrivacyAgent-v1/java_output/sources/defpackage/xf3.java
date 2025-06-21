package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xf3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeVideoFeed n;
    public final /* synthetic */ com.moji.mjweather.weather.beta.WeatherExpressAdapter t;
    public final /* synthetic */ int u;

    public /* synthetic */ xf3(com.moji.mjweather.feed.newvideo.model.HomeVideoFeed homeVideoFeed, com.moji.mjweather.weather.beta.WeatherExpressAdapter weatherExpressAdapter, int i) {
        this.n = homeVideoFeed;
        this.t = weatherExpressAdapter;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.beta.WeatherExpressAdapter.ViewHolder.b(this.n, this.t, this.u, view);
    }
}
