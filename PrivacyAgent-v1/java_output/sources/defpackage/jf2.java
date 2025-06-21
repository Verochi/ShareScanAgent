package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class jf2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjweather.settingpreference.pref.MJTwoStatePreference n;
    public final /* synthetic */ com.moji.tool.preferences.core.IPreferKey t;

    public /* synthetic */ jf2(com.moji.mjweather.settingpreference.pref.MJTwoStatePreference mJTwoStatePreference, com.moji.tool.preferences.core.IPreferKey iPreferKey) {
        this.n = mJTwoStatePreference;
        this.t = iPreferKey;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjweather.setting.fragment.SettingPermissionSwitchControlFragment.e(this.n, this.t);
    }
}
