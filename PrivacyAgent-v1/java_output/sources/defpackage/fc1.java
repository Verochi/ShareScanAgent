package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class fc1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.tabme.viewmodel.MeUiViewModel.MeUiLiveData n;

    public /* synthetic */ fc1(com.moji.mjweather.tabme.viewmodel.MeUiViewModel.MeUiLiveData meUiLiveData) {
        this.n = meUiLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.tabme.viewmodel.MeUiViewModel.MeUiLiveData.f(this.n, (com.moji.mjweather.tabme.model.MeTabModel) obj);
    }
}
