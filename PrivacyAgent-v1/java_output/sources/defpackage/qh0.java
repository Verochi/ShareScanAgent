package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class qh0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.weather.view.ForecaseDays40WithDetailView n;
    public final /* synthetic */ java.util.List t;

    public /* synthetic */ qh0(com.moji.mjweather.weather.view.ForecaseDays40WithDetailView forecaseDays40WithDetailView, java.util.List list) {
        this.n = forecaseDays40WithDetailView;
        this.t = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.weather.view.ForecaseDays40WithDetailView.d(this.n, this.t);
    }
}
