package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class mo0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjkinsfolk.presenter.HomeWriteInfoPresenter.WeatherViewHolder n;
    public final /* synthetic */ com.moji.mjkinsfolk.presenter.HomeWriteInfoPresenter t;

    public /* synthetic */ mo0(com.moji.mjkinsfolk.presenter.HomeWriteInfoPresenter.WeatherViewHolder weatherViewHolder, com.moji.mjkinsfolk.presenter.HomeWriteInfoPresenter homeWriteInfoPresenter) {
        this.n = weatherViewHolder;
        this.t = homeWriteInfoPresenter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjkinsfolk.presenter.HomeWriteInfoPresenter.WeatherViewHolder.a(this.n, this.t, view);
    }
}
