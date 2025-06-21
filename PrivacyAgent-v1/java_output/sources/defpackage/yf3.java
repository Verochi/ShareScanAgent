package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class yf3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.WeatherExpressAdapter n;
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeVideoFeed t;

    public /* synthetic */ yf3(com.moji.mjweather.weather.beta.WeatherExpressAdapter weatherExpressAdapter, com.moji.mjweather.feed.newvideo.model.HomeVideoFeed homeVideoFeed) {
        this.n = weatherExpressAdapter;
        this.t = homeVideoFeed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.beta.WeatherExpressAdapter.ViewHolder.e(this.n, this.t, view);
    }
}
