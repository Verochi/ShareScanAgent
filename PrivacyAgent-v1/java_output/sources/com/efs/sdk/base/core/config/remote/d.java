package com.efs.sdk.base.core.config.remote;

/* loaded from: classes22.dex */
public final class d implements android.content.SharedPreferences.OnSharedPreferenceChangeListener {
    volatile android.content.SharedPreferences a;

    public static boolean a() {
        com.efs.sdk.base.core.config.GlobalEnvStruct globalEnvStruct = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct();
        java.io.File b = com.efs.sdk.base.core.util.a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (!b.exists()) {
            return false;
        }
        com.efs.sdk.base.core.util.FileUtil.delete(b);
        return true;
    }

    public static void b() {
        java.io.File a = com.efs.sdk.base.core.util.a.a(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid());
        if (a.exists()) {
            a.delete();
        }
    }

    private void d() {
        if (this.a == null) {
            synchronized (com.efs.sdk.base.core.b.c.class) {
                if (this.a == null) {
                    this.a = com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.getSharedPreferences(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.util.secure.EncodeUtil.base64EncodeToStr(("config_" + com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid().toLowerCase()).getBytes()));
                    this.a.registerOnSharedPreferenceChangeListener(this);
                }
            }
        }
    }

    public final boolean a(@androidx.annotation.NonNull com.efs.sdk.base.core.config.remote.RemoteConfig remoteConfig) {
        c();
        if (this.a == null) {
            return false;
        }
        android.content.SharedPreferences.Editor edit = this.a.edit();
        edit.clear();
        edit.putInt("cver", remoteConfig.mConfigVersion);
        edit.putLong("last_refresh_time", java.lang.System.currentTimeMillis());
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : remoteConfig.mSDKConfigMap.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.putString("sign", remoteConfig.a);
        edit.apply();
        return true;
    }

    public final void c() {
        try {
            d();
        } catch (java.lang.Throwable th) {
            com.efs.sdk.base.core.util.Log.e("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        com.efs.sdk.base.core.b.h hVar;
        hVar = com.efs.sdk.base.core.b.h.a.a;
        if (hVar.a()) {
            return;
        }
        com.efs.sdk.base.core.config.remote.b.a().b();
    }
}
