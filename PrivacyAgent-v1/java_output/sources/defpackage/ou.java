package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class ou implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.dailydetail.DailyDetailActivity n;

    public /* synthetic */ ou(com.moji.mjweather.dailydetail.DailyDetailActivity dailyDetailActivity) {
        this.n = dailyDetailActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.dailydetail.DailyDetailActivity.b(this.n, (com.moji.mjweather.dailydetails.viewmodel.Hour360ViewYStatus) obj);
    }
}
