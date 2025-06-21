package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class uz1 implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.mjpersonalmodule.PersonalWeatherCardPresenter n;

    public /* synthetic */ uz1(com.moji.mjpersonalmodule.PersonalWeatherCardPresenter personalWeatherCardPresenter) {
        this.n = personalWeatherCardPresenter;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.mjpersonalmodule.PersonalWeatherCardPresenter.d(this.n, dialogInterface);
    }
}
