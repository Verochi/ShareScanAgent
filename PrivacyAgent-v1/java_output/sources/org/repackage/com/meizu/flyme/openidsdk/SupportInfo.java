package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes26.dex */
class SupportInfo {
    public java.lang.String a;
    public java.lang.Boolean b;

    public void a(boolean z) {
        this.b = java.lang.Boolean.valueOf(z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return android.text.TextUtils.equals(this.a, str);
    }

    public void d(java.lang.String str) {
        this.a = str;
    }

    public boolean e() {
        java.lang.Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
