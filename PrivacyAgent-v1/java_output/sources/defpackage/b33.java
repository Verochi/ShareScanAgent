package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class b33 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.condition.presenter.TopWeatherPresenter n;

    public /* synthetic */ b33(com.moji.condition.presenter.TopWeatherPresenter topWeatherPresenter) {
        this.n = topWeatherPresenter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.condition.presenter.TopWeatherPresenter.b(this.n, (com.moji.condition.model.ConditionNearMomentModel) obj);
    }
}
