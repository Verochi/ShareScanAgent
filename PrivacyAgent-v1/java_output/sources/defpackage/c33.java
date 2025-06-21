package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class c33 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.condition.presenter.TopWeatherPresenter n;

    public /* synthetic */ c33(com.moji.condition.presenter.TopWeatherPresenter topWeatherPresenter) {
        this.n = topWeatherPresenter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.condition.presenter.TopWeatherPresenter.a(this.n, (com.moji.condition.viewmodel.ScrollState) obj);
    }
}
