package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ch3 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.weather.dialog.WeatherPageDialogHelper n;
    public final /* synthetic */ com.moji.notify.NotifyPreference t;

    public /* synthetic */ ch3(com.moji.mjweather.weather.dialog.WeatherPageDialogHelper weatherPageDialogHelper, com.moji.notify.NotifyPreference notifyPreference) {
        this.n = weatherPageDialogHelper;
        this.t = notifyPreference;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.dialog.WeatherPageDialogHelper.c(this.n, this.t, view);
    }
}
