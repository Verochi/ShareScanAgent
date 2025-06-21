package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class ba2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.rainbow.presenter.RainbowPresenter n;

    public /* synthetic */ ba2(com.moji.rainbow.presenter.RainbowPresenter rainbowPresenter) {
        this.n = rainbowPresenter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.rainbow.presenter.RainbowPresenter.a(this.n, (com.moji.rainbow.data.RainbowForeData) obj);
    }
}
