package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public class l {
    private static volatile com.bytedance.pangle.util.l b;
    public android.content.SharedPreferences a = com.bytedance.pangle.Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private l() {
    }

    public static com.bytedance.pangle.util.l a() {
        if (b == null) {
            synchronized (com.bytedance.pangle.util.l.class) {
                if (b == null) {
                    b = new com.bytedance.pangle.util.l();
                }
            }
        }
        return b;
    }

    public final int a(java.lang.String str) {
        int i = this.a.getInt("PLUGIN_API_VERSION_".concat(java.lang.String.valueOf(str)), 0);
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    public final void a(java.lang.String str, int i, java.lang.String str2) {
        int b2 = b(str, i, str2);
        android.content.SharedPreferences.Editor edit = this.a.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, b2 + 1);
        edit.apply();
    }

    public final void a(java.lang.String str, int i, boolean z) {
        android.content.SharedPreferences.Editor edit = this.a.edit();
        java.lang.String str2 = "INSTALLED_" + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + i;
        if (z) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public final boolean a(java.lang.String str, int i) {
        return this.a.getBoolean(java.lang.String.format(java.util.Locale.getDefault(), "INSTALLED_%s-%d", str, java.lang.Integer.valueOf(i)), false);
    }

    public final int b(java.lang.String str, int i) {
        return this.a.getInt("remove_entry_flag_" + str + "_" + i, 0);
    }

    public final int b(java.lang.String str, int i, java.lang.String str2) {
        return this.a.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, 0);
    }

    public final java.lang.String b(java.lang.String str) {
        java.lang.String string = this.a.getString("HOST_IDENTITY_".concat(java.lang.String.valueOf(str)), "");
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public final void b(java.lang.String str, int i, boolean z) {
        android.content.SharedPreferences.Editor edit = this.a.edit();
        edit.putBoolean("dex_opt_state_" + str + "_" + i, z);
        edit.apply();
    }

    public final void c(java.lang.String str, int i, boolean z) {
        android.content.SharedPreferences.Editor edit = this.a.edit();
        edit.putBoolean("dex_remove_state_" + str + "_" + i, z);
        edit.apply();
    }
}
