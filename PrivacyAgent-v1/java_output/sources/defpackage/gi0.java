package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class gi0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetails.viewmodel.FrameLiveData n;

    public /* synthetic */ gi0(com.moji.mjweather.dailydetails.viewmodel.FrameLiveData frameLiveData) {
        this.n = frameLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetails.viewmodel.FrameLiveData.d(this.n, (com.moji.mj40dayforecast.data.ForecastOptimize) obj);
    }
}
