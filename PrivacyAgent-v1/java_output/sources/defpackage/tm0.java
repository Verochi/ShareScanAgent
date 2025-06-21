package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class tm0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity n;

    public /* synthetic */ tm0(com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity historicalTyphoonActivity) {
        this.n = historicalTyphoonActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.typhoon.newversion.HistoricalTyphoonActivity.h(this.n, (com.moji.http.member.entity.ShortMemberDialogResult.Config) obj);
    }
}
