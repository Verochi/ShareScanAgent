package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class j implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.aqi.adapter.AQIForecastDayAdapter n;

    public /* synthetic */ j(com.moji.aqi.adapter.AQIForecastDayAdapter aQIForecastDayAdapter) {
        this.n = aQIForecastDayAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.aqi.adapter.AQIForecastDayAdapter.ItemViewHolder.a(this.n, view);
    }
}
