package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class ox implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mj40dayforecast.fragment.Days40CalenderWeekFragment n;
    public final /* synthetic */ com.moji.mj40dayforecast.data.ForecastDay t;
    public final /* synthetic */ int u;

    public /* synthetic */ ox(com.moji.mj40dayforecast.fragment.Days40CalenderWeekFragment days40CalenderWeekFragment, com.moji.mj40dayforecast.data.ForecastDay forecastDay, int i) {
        this.n = days40CalenderWeekFragment;
        this.t = forecastDay;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mj40dayforecast.fragment.Days40CalenderWeekFragment.CalenderRecyclerAdapter.CalenderItemHolder.b(this.n, this.t, this.u, view);
    }
}
