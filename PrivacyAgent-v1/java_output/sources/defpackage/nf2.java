package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nf2 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.mjweather.setting.fragment.SettingWeatherAlertFragment a;
    public final /* synthetic */ com.moji.mjweather.settingpreference.pref.MJPreferenceWithValue b;

    public /* synthetic */ nf2(com.moji.mjweather.setting.fragment.SettingWeatherAlertFragment settingWeatherAlertFragment, com.moji.mjweather.settingpreference.pref.MJPreferenceWithValue mJPreferenceWithValue) {
        this.a = settingWeatherAlertFragment;
        this.b = mJPreferenceWithValue;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.setting.fragment.SettingWeatherAlertFragment.d(this.a, this.b, mJDialog, eTypeAction);
    }
}
