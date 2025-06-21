package com.huawei.secure.android.common.util;

/* loaded from: classes22.dex */
public class a {
    public java.lang.String a;
    public java.lang.Character b;
    public java.lang.Character c;
    public int d = 0;
    public int e = 0;

    public a(java.lang.String str) {
        this.a = str;
    }

    public static boolean b(java.lang.Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    public static boolean c(java.lang.Character ch) {
        char charValue;
        return ch != null && (charValue = ch.charValue()) >= '0' && charValue <= '7';
    }

    public void a(java.lang.Character ch) {
        this.b = ch;
    }

    public boolean a() {
        if (this.b != null) {
            return true;
        }
        java.lang.String str = this.a;
        return (str == null || str.length() == 0 || this.d >= this.a.length()) ? false : true;
    }

    public boolean a(char c) {
        java.lang.Character ch = this.b;
        if (ch != null && ch.charValue() == c) {
            return true;
        }
        java.lang.String str = this.a;
        return str != null && str.length() != 0 && this.d < this.a.length() && this.a.charAt(this.d) == c;
    }

    public int b() {
        return this.d;
    }

    public void c() {
        this.c = this.b;
        this.e = this.d;
    }

    public java.lang.Character d() {
        java.lang.Character ch = this.b;
        if (ch != null) {
            this.b = null;
            return ch;
        }
        java.lang.String str = this.a;
        if (str == null || str.length() == 0 || this.d >= this.a.length()) {
            return null;
        }
        java.lang.String str2 = this.a;
        int i = this.d;
        this.d = i + 1;
        return java.lang.Character.valueOf(str2.charAt(i));
    }

    public java.lang.Character e() {
        java.lang.Character d = d();
        if (d != null && b(d)) {
            return d;
        }
        return null;
    }

    public java.lang.Character f() {
        java.lang.Character d = d();
        if (d != null && c(d)) {
            return d;
        }
        return null;
    }

    public java.lang.Character g() {
        java.lang.Character ch = this.b;
        if (ch != null) {
            return ch;
        }
        java.lang.String str = this.a;
        if (str == null || str.length() == 0 || this.d >= this.a.length()) {
            return null;
        }
        return java.lang.Character.valueOf(this.a.charAt(this.d));
    }

    public java.lang.String h() {
        java.lang.String substring = this.a.substring(this.d);
        if (this.b == null) {
            return substring;
        }
        return this.b + substring;
    }

    public void i() {
        this.b = this.c;
        this.d = this.e;
    }
}
