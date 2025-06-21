package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class tf3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.WeatherExpressAdapter n;
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeVideoFeed t;
    public final /* synthetic */ int u;

    public /* synthetic */ tf3(com.moji.mjweather.weather.beta.WeatherExpressAdapter weatherExpressAdapter, com.moji.mjweather.feed.newvideo.model.HomeVideoFeed homeVideoFeed, int i) {
        this.n = weatherExpressAdapter;
        this.t = homeVideoFeed;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.beta.WeatherExpressAdapter.ViewHolder.c(this.n, this.t, this.u, view);
    }
}
