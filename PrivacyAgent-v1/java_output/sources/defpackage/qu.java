package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class qu implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetail.DailyDetailActivity n;

    public /* synthetic */ qu(com.moji.mjweather.dailydetail.DailyDetailActivity dailyDetailActivity) {
        this.n = dailyDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetail.DailyDetailActivity.e(this.n, (com.moji.mjweather.dailydetails.viewmodel.HeaderColorStatus) obj);
    }
}
