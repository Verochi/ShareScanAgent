package com.alipay.sdk.m.m0;

/* loaded from: classes.dex */
public class a {
    public java.lang.String a;
    public android.content.SharedPreferences b;
    public android.content.SharedPreferences.Editor c = null;
    public android.content.Context d;
    public boolean e;

    public a(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        this.b = null;
        this.e = z2;
        this.a = str2;
        this.d = context;
        if (context != null) {
            this.b = context.getSharedPreferences(str2, 0);
        }
    }

    private void b() {
        android.content.SharedPreferences sharedPreferences;
        if (this.c != null || (sharedPreferences = this.b) == null) {
            return;
        }
        this.c = sharedPreferences.edit();
    }

    public java.lang.String a(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences != null) {
            java.lang.String string = sharedPreferences.getString(str, "");
            if (!com.alipay.sdk.m.l0.f.m12a(string)) {
                return string;
            }
        }
        return "";
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (com.alipay.sdk.m.l0.f.m12a(str) || str.equals("t")) {
            return;
        }
        b();
        android.content.SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    public boolean a() {
        boolean z;
        android.content.Context context;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        android.content.SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            if (!this.e && this.b != null) {
                editor.putLong("t", currentTimeMillis);
            }
            if (!this.c.commit()) {
                z = false;
                if (this.b != null && (context = this.d) != null) {
                    this.b = context.getSharedPreferences(this.a, 0);
                }
                return z;
            }
        }
        z = true;
        if (this.b != null) {
            this.b = context.getSharedPreferences(this.a, 0);
        }
        return z;
    }

    public void b(java.lang.String str) {
        if (com.alipay.sdk.m.l0.f.m12a(str) || str.equals("t")) {
            return;
        }
        b();
        android.content.SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.remove(str);
        }
    }
}
