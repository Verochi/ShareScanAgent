package com.alipay.sdk.m.i0;

/* loaded from: classes.dex */
public class c {
    public java.lang.String a;
    public java.lang.Boolean b;

    public void a(boolean z) {
        this.b = java.lang.Boolean.valueOf(z);
    }

    public boolean a() {
        return this.b != null;
    }

    public boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return android.text.TextUtils.equals(this.a, str);
    }

    public void b(java.lang.String str) {
        this.a = str;
    }

    public boolean b() {
        java.lang.Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
