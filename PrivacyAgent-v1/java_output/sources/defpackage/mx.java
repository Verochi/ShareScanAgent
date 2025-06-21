package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class mx implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CalenderMonthFragment n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.mj40dayforecast.data.ForecastDay u;

    public /* synthetic */ mx(com.moji.mj40dayforecast.fragment.Days40CalenderMonthFragment days40CalenderMonthFragment, int i, com.moji.mj40dayforecast.data.ForecastDay forecastDay) {
        this.n = days40CalenderMonthFragment;
        this.t = i;
        this.u = forecastDay;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mj40dayforecast.fragment.Days40CalenderMonthFragment.CalenderRecyclerAdapter.CalenderItemHolder.b(this.n, this.t, this.u, view);
    }
}
