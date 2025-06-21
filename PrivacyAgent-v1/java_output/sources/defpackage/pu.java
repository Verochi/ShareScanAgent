package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class pu implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetail.DailyDetailActivity n;

    public /* synthetic */ pu(com.moji.mjweather.dailydetail.DailyDetailActivity dailyDetailActivity) {
        this.n = dailyDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetail.DailyDetailActivity.d(this.n, (com.moji.mjweather.dailydetails.viewmodel.Hour360ViewXStatus) obj);
    }
}
