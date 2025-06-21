package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class ag3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.page.history.WeatherHistoryActivity n;

    public /* synthetic */ ag3(com.moji.page.history.WeatherHistoryActivity weatherHistoryActivity) {
        this.n = weatherHistoryActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.page.history.WeatherHistoryActivity.i(this.n, (com.moji.page.history.HistoryResponse) obj);
    }
}
