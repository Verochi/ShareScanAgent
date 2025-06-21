package com.vivo.push.util;

/* loaded from: classes19.dex */
final class v implements com.vivo.push.util.d {
    private android.content.ContentResolver a;

    @Override // com.vivo.push.util.d
    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            return android.provider.Settings.System.getString(this.a, str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.b("SettingsCache", "getString error by ".concat(java.lang.String.valueOf(str)));
            return str2;
        }
    }

    @Override // com.vivo.push.util.d
    public final boolean a(android.content.Context context) {
        if (!com.vivo.push.util.j.b()) {
            return false;
        }
        this.a = context.getContentResolver();
        return true;
    }

    @Override // com.vivo.push.util.d
    public final void b(java.lang.String str, java.lang.String str2) {
        try {
            android.provider.Settings.System.putString(this.a, str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.vivo.push.util.p.b("SettingsCache", "putString error by ".concat(java.lang.String.valueOf(str)));
        }
    }
}
