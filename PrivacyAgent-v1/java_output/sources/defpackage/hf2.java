package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class hf2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.setting.fragment.SettingPermissionControlFragment n;

    public /* synthetic */ hf2(com.moji.mjweather.setting.fragment.SettingPermissionControlFragment settingPermissionControlFragment) {
        this.n = settingPermissionControlFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.setting.fragment.SettingPermissionControlFragment.d(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
