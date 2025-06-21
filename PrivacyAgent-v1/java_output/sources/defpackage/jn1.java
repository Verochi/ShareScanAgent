package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class jn1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.dailydetails.adpater.MoonPhaseDelegate n;
    public final /* synthetic */ com.moji.mjweather.dailydetails.adpater.MoonData t;

    public /* synthetic */ jn1(com.moji.mjweather.dailydetails.adpater.MoonPhaseDelegate moonPhaseDelegate, com.moji.mjweather.dailydetails.adpater.MoonData moonData) {
        this.n = moonPhaseDelegate;
        this.t = moonData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.dailydetails.adpater.MoonPhaseDelegate.a(this.n, this.t, view);
    }
}
