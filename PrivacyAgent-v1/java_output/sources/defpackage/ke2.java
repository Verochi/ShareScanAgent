package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ke2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.setting.fragment.SettingCommonFragment n;

    public /* synthetic */ ke2(com.moji.mjweather.setting.fragment.SettingCommonFragment settingCommonFragment) {
        this.n = settingCommonFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.setting.fragment.SettingCommonFragment.d(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
