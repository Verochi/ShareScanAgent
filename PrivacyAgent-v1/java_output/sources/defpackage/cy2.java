package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class cy2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.TabWeatherBetaFragment n;
    public final /* synthetic */ com.moji.card.OperationCardViewModel t;
    public final /* synthetic */ androidx.fragment.app.FragmentActivity u;

    public /* synthetic */ cy2(com.moji.mjweather.TabWeatherBetaFragment tabWeatherBetaFragment, com.moji.card.OperationCardViewModel operationCardViewModel, androidx.fragment.app.FragmentActivity fragmentActivity) {
        this.n = tabWeatherBetaFragment;
        this.t = operationCardViewModel;
        this.u = fragmentActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.TabWeatherBetaFragment.g(this.n, this.t, this.u, (java.lang.Boolean) obj);
    }
}
