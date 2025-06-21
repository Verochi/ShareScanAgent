package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class iz2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.TabWeatherV9Fragment n;
    public final /* synthetic */ com.moji.card.OperationCardViewModel t;
    public final /* synthetic */ androidx.fragment.app.FragmentActivity u;

    public /* synthetic */ iz2(com.moji.mjweather.TabWeatherV9Fragment tabWeatherV9Fragment, com.moji.card.OperationCardViewModel operationCardViewModel, androidx.fragment.app.FragmentActivity fragmentActivity) {
        this.n = tabWeatherV9Fragment;
        this.t = operationCardViewModel;
        this.u = fragmentActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.TabWeatherV9Fragment.z(this.n, this.t, this.u, (java.lang.Boolean) obj);
    }
}
