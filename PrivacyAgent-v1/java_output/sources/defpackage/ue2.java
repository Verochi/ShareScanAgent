package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ue2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.setting.fragment.SettingEarthquakeFragment n;
    public final /* synthetic */ com.moji.dialog.MJDialog t;
    public final /* synthetic */ android.widget.TextView u;
    public final /* synthetic */ android.view.View v;

    public /* synthetic */ ue2(com.moji.mjweather.setting.fragment.SettingEarthquakeFragment settingEarthquakeFragment, com.moji.dialog.MJDialog mJDialog, android.widget.TextView textView, android.view.View view) {
        this.n = settingEarthquakeFragment;
        this.t = mJDialog;
        this.u = textView;
        this.v = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.setting.fragment.SettingEarthquakeFragment.d(this.n, this.t, this.u, this.v, view);
    }
}
