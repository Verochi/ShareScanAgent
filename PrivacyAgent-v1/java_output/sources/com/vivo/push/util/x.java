package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class x implements com.vivo.push.util.d {
    private static java.lang.String a = "SpCache";
    private static java.lang.String b = "com.vivo.push.cache";
    private android.content.SharedPreferences c;

    @Override // com.vivo.push.util.d
    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String string = this.c.getString(str, str2);
        com.vivo.push.util.p.d(a, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        android.content.SharedPreferences.Editor edit = this.c.edit();
        if (edit != null) {
            edit.clear();
            com.vivo.push.util.b.a(edit);
        }
        com.vivo.push.util.p.d(a, "system cache is cleared");
    }

    @Override // com.vivo.push.util.d
    public final boolean a(android.content.Context context) {
        if (this.c != null) {
            return true;
        }
        this.c = context.getSharedPreferences(b, 0);
        return true;
    }

    @Override // com.vivo.push.util.d
    public final void b(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor edit = this.c.edit();
        if (edit == null) {
            com.vivo.push.util.p.b(a, "putString error by ".concat(java.lang.String.valueOf(str)));
            return;
        }
        edit.putString(str, str2);
        com.vivo.push.util.b.a(edit);
        com.vivo.push.util.p.d(a, "putString by ".concat(java.lang.String.valueOf(str)));
    }
}
