package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class if2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjweather.setting.fragment.SettingPermissionFragment n;

    public /* synthetic */ if2(com.moji.mjweather.setting.fragment.SettingPermissionFragment settingPermissionFragment) {
        this.n = settingPermissionFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjweather.setting.fragment.SettingPermissionFragment.d(this.n, (com.moji.opevent.model.OperationEvent) obj);
    }
}
