package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class ez0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjtravel.OneDayTripBean.OneDayResults n;

    public /* synthetic */ ez0(com.moji.mjtravel.OneDayTripBean.OneDayResults oneDayResults) {
        this.n = oneDayResults;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjtravel.local.LocalView4TripSpot.TripSpotAdapter.TripSpotHolder.a(this.n, view);
    }
}
