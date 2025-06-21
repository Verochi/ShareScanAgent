package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class me2 implements android.widget.CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ com.moji.mjweather.setting.activity.SettingDarkModeActivity n;

    public /* synthetic */ me2(com.moji.mjweather.setting.activity.SettingDarkModeActivity settingDarkModeActivity) {
        this.n = settingDarkModeActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        com.moji.mjweather.setting.activity.SettingDarkModeActivity.b(this.n, compoundButton, z);
    }
}
