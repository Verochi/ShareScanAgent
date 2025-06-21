package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class j62 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.puddle.PuddleMainResponse.OtherForecast n;

    public /* synthetic */ j62(com.moji.http.puddle.PuddleMainResponse.OtherForecast otherForecast) {
        this.n = otherForecast;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.puddle.presenter.PuddleOtherViewControl.OtherForecastAdapter.ItemHolder.a(this.n, view);
    }
}
